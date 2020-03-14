package com.bihim.firestoretest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    EditText editTextTitle, editTextImageLink, editTextWriterName, editTextNewsSource, editTextDay, editTextMonth, editTextYear, editTextDescription;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("born", 1815);

// Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("Baal", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("Baal", "Error adding document", e);
                    }
                });

        // Create a new user with a first, middle, and last name
       // Map<String, Object> user = new HashMap<>();
        user.put("first", "Alan");
        user.put("middle", "Mathison");
        user.put("last", "Turing");
        user.put("born", 1912);

// Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("Baal", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("Baal", "Error adding document", e);
                    }
                });

        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("Haua", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w("Haua", "Error getting documents.", task.getException());
                        }
                    }
                });*/

        editTextTitle       = findViewById(R.id.news_main_title);
        editTextImageLink   = findViewById(R.id.news_main_image_link);
        editTextWriterName  = findViewById(R.id.news_main_writer_name);
        editTextNewsSource  = findViewById(R.id.news_main_source);
        editTextDay         = findViewById(R.id.news_main_day);
        editTextMonth       = findViewById(R.id.news_main_month);
        editTextYear        = findViewById(R.id.news_main_year);
        editTextDescription = findViewById(R.id.news_main_description);
        buttonSubmit        = findViewById(R.id.news_main_submit);
        newsSubmit();

        Button button = findViewById(R.id.button_news);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, NewsActivity.class));

                /*FirebaseFirestore.getInstance().collection("news")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d("News", document.getId() + " => " + document.getData());
                                    }
                                } else {
                                    Log.d("News", "Error getting documents: ", task.getException());
                                }
                            }
                        });*/
            }
        });
    }

    private void newsSubmit()
    {

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                final String title = editTextTitle.getText().toString();
                final String link = editTextImageLink.getText().toString();
                final String name = editTextWriterName.getText().toString();
                final String source = editTextNewsSource.getText().toString();
                final String date = editTextDay.getText().toString()+"-"+editTextMonth.getText().toString()+"-"+editTextYear.getText().toString();
                final String description = editTextDescription.getText().toString();

                Map <String, String> data = new HashMap<>();
                data.put("Title", title);
                data.put("Link", link);
                data.put("Name", name);
                data.put("Source", source);
                data.put("Date", date);
                data.put("Description", description);

                String query = "/news/";

                FirebaseFirestore.getInstance().collection("news")
                        .add(data)
                        .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task)
                    {
                        Toasty.success(MainActivity.this, "News Added", Toasty.LENGTH_SHORT,true).show();
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
            }
        });
    }
}
