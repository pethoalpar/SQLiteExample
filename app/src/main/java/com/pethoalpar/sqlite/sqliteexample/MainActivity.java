package com.pethoalpar.sqlite.sqliteexample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pethoalpar.sqlite.sqliteexample.database.SQLBusinessDelegate;
import com.pethoalpar.sqlite.sqliteexample.database.exception.DatabaseBusinessException;
import com.pethoalpar.sqlite.sqliteexample.database.exception.NoResultException;
import com.pethoalpar.sqlite.sqliteexample.entities.Person;

public class MainActivity extends AppCompatActivity {

    private Button saveButton;
    private EditText nameEditText;
    private EditText ageEditText;
    private TextView resultTextView;
    private long id = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = (Button) this.findViewById(R.id.button);
        nameEditText = (EditText) this.findViewById(R.id.editTextName);
        ageEditText = (EditText) this.findViewById(R.id.editTextAge);
        resultTextView = (TextView) this.findViewById(R.id.textViewResult);
        this.setListeners();
    }

    private  void setListeners(){
        final Context context = this;
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person();
                if(id != -1){
                    SQLBusinessDelegate<Person> dbDelegate = new SQLBusinessDelegate<Person>(context,Person.class,"example", null,1);
                    try {
                        person = dbDelegate.findById((int) id);
                    }catch ( NoResultException e){
                        Log.w("Person not found!",e);
                    }
                }
                person.setName(nameEditText.getText().toString());
                person.setAge(Integer.parseInt(ageEditText.getText().toString()));
                SQLBusinessDelegate<Person> dbDelegate = new SQLBusinessDelegate<Person>(context,Person.class,"example", null,1);
                try {
                    if(id != -1){
                        dbDelegate.update(person);
                    }else{
                        id = dbDelegate.save(person);
                    }
                }catch (NoResultException nre){
                    Toast.makeText(context,"Save exception", Toast.LENGTH_SHORT).show();
                    Log.w("Can't save!",nre);
                }
                try{
                    Person savedPerson = dbDelegate.findById((int) id);
                    resultTextView.setText("Name: "+savedPerson.getName()+" Age:"+savedPerson.getAge());
                }catch (NoResultException nre){
                    Log.w("Can't find!",nre);
                }

            }
        });
    }

}
