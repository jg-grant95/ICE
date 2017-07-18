package com.example.jerringiselle.ice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateContactActivity extends AppCompatActivity {
    Spinner spinner;
    EditText first, last, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        spinner = (Spinner) findViewById(R.id.chooseRelationship);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.relationship,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        first = (EditText) findViewById(R.id.firstName);
        last  = (EditText) findViewById(R.id.lastName);
        phone = (EditText) findViewById(R.id.phoneNumber);
    }

    public void addContactClick(View view){
        Contact contact = new Contact();
        contact.setFirstName(first.getText().toString());
        contact.setLastName(last.getText().toString());
       // contact.setPhoneNumber(phone.getText());
        contact.setRelationship(typeRelationship(spinner.getSelectedItem().toString()));

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("contact");
        myRef.push().setValue(contact);

    }


    private Relationship typeRelationship(String str) {
        switch (str.toLowerCase()) {
            case "father":
                return Relationship.father;
            case "mother":
                return Relationship.mother;
            case "guardian":
                return Relationship.guardian;
            case "so":
                return Relationship.SO;
            case "husband":
                return Relationship.husband;
            case "wife":
                return Relationship.wife;
            case "sister":
                return Relationship.sister;
            case "brother":
                return Relationship.brother;
            case "friend":
                return Relationship.friend;
            case "other":
                return Relationship.Other;
            default:
                return Relationship.Other;
        }
    }




}
