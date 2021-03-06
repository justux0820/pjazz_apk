package com.maistasinamus.pjazz;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    private static final String INSERT_URL = "http://etravi.lt/php/pica.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button sendRegistration=findViewById(R.id.submit_registration);
        sendRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText username=findViewById(R.id.username);
                final EditText password=findViewById(R.id.password);
                final EditText email=findViewById(R.id.email);

                User user = new User(username.getText().toString(), password.getText().toString(),email.getText().toString());
                if(!user.getUsername().isEmpty() &&!user.getPassword().isEmpty() && Validation.IsvalidEmail_Credentials(user.getEmail()) )
                {
                    //Toast.makeText(NewEntryActivity.this,
                    //"Gauti duomenys : \n"+newentry.getPavadinimas()+"\n"+newentry.getSaltiniai()+"\n"+newentry.getTrukme()+"\n"+newentry.getLygis()+"\n"+newentry.getKaina(),
                    // Toast.LENGTH_SHORT).show();
                    insertToDB(user);
                }
                else {
                    username.setError("");
                    password.setError("");
                    email.setError("");
                    Toast.makeText(RegisterActivity.this,
                            "Užpildykite privalomus laukus!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void insertToDB(User user) {
        class SendEntry extends AsyncTask<String, Void, String> {

            ProgressDialog loading;
            DB db = new DB();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(RegisterActivity.this,
                        getResources().getString(R.string.entryDatabaseInfoUser),
                        null, true, true);
            }

            @Override
            protected String doInBackground(String... strings) {
                // Pirmas string yra raktas, antras - reikšmė.
                HashMap<String, String> userData = new HashMap<String, String>();
                userData.put("vardas", strings[0]);
                userData.put("elpastas", strings[1]);
                userData.put("slaptazodis", strings[2]);

                userData.put("veiksmas","registruoti" );

                String result = db.sendPostRequest(INSERT_URL, userData);

                return result;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(RegisterActivity.this, s, Toast.LENGTH_SHORT).show();
                Intent goToSearchActivity = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(goToSearchActivity);
            }
        }

        SendEntry sendentry = new SendEntry();
        sendentry.execute(
                user.getUsername(),
                user.getEmail(),
                user.getPassword()
        );
    }
}