package com.example.home_activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.cert.PolicyNode;

public class SearchData extends AppCompatActivity {

    Button search;
    EditText myInput;



    EditText fullName,fatherName,motherName,nidNumber,address;
    Button addFire;
    TextView displayView;
    private ValueEventListener eventListener;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference requestRf =  db.getReference("User");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_data);
        getSupportActionBar().hide();

        search();

    }

    private void search() {

        search = (Button)findViewById(R.id.search_button_id);
        myInput = (EditText)findViewById(R.id.input);
        displayView =(TextView)findViewById(R.id.display_id);

        String inputData = myInput.getText().toString().trim();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


             onStart();


                }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        eventListener = requestRf.orderByChild("nid_Number").equalTo("").addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String data = "";
                for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()){
                    AddData addData = itemSnapshot.getValue(AddData.class);
                    String oName = addData.getFull_Name();
                    String nidNo = addData.getNID_Number();

                    data = data+"Full Name: "+oName+"\nNID: "+nidNo+"\n\n";
                }
                displayView.setText(data);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {




            }
        });






        }
}
