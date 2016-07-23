package utp.edu.pe.volleyapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import utp.edu.pe.volleyapp.R;

public class ExpenseActivity extends AppCompatActivity  implements View.OnClickListener {

    private static final String REGISTER_URL = "http://192.241.166.108/WebService/registerexpense.php";

    public static final String KEY_SALARYJ = "salaryj";
    public static final String KEY_SALARYP = "salaryp";
    public static final String KEY_USERNAME = "username";

    EditText salaryJEditText;
    EditText salaryPEditText;

    private String salaryj;
    private String salaryp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        salaryJEditText = (EditText) findViewById(R.id.salaryJEditText);
        salaryPEditText = (EditText) findViewById(R.id.salaryPEditText);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

    }
    private void registerExpense(){
        salaryj = salaryJEditText.getText().toString().trim();
        salaryp = salaryPEditText.getText().toString().trim();
        Intent intent = getIntent();
        final String username = intent.getStringExtra("username").trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(ExpenseActivity.this,response,Toast.LENGTH_LONG).show();
                        salaryJEditText.setText("");
                        salaryPEditText.setText("");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ExpenseActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_SALARYJ,salaryj);
                params.put(KEY_SALARYP,salaryp);
                params.put(KEY_USERNAME, username);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {
        registerExpense();
    }
}
