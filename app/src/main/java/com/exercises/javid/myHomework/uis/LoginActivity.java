package com.exercises.javid.myHomework.uis;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.exercises.javid.myHomework.R;
import com.exercises.javid.myHomework.net.JSONDownloader;

public class LoginActivity extends AppCompatActivity {

    private final String url = "http://hbahonar.ir/getres.php?id=";
    private String password, userId;
    private EditText use, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userId = "";

        use = findViewById(R.id.edit_login_use);

        findViewById(R.id.btn_login_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (use.length() > 0) {
                    userId = use.getText().toString();
                    new DownloadTask().execute(url, userId);
                } else {
                    Toast.makeText(
                            getApplicationContext(),
                            getResources().getString(R.string.login_error),
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });


    }


    private class DownloadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            try {
                return new JSONDownloader().download(strings[0] + strings[1]);
            } catch (Exception e) {
                Log.e("My Cod:",
                        "Class: DownloadTask Method: doInBackground " + e.toString()
                );
            }
            return null;
        }

        @Override
        protected void onPostExecute(String data) {
            try {
                if (!data.equals("") && !data.equals(null)) {
                    Toast.makeText(
                            getApplicationContext(), "Data is: " + data, Toast.LENGTH_LONG
                    ).show();
                } else {
                    Toast.makeText(
                            getApplicationContext(),
                            getResources().getString(R.string.login_data_load_error),
                            Toast.LENGTH_SHORT
                    ).show();
                }
            } catch (Exception e) {
                Log.e("My Cod:",
                        "Class: DownloadTask Method: onPostExecute " + e.toString()
                );
            }
        }
    }
}

