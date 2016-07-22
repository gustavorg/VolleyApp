package utp.edu.pe.volleyapp;

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

public class IncomeActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String REGISTER_URL = "http://192.241.166.108/WebService/registerincome.php";

    public static final String KEY_ELECTRICITY = "electricity";
    public static final String KEY_GAS = "gas";
    public static final String KEY_WATER = "water";
    public static final String KEY_INTERNET = "internet";
    public static final String KEY_USERNAME = "username";

    EditText ElectricityEditText;
    EditText GasEditText;
    EditText WaterEditText;
    EditText InternetEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ElectricityEditText = (EditText) findViewById(R.id.ElectricityEditText);
        GasEditText = (EditText) findViewById(R.id.GasEditText);
        WaterEditText = (EditText) findViewById(R.id.WaterEditText);
        InternetEditText = (EditText) findViewById(R.id.InternetEditText);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }
    private void registerIncome(){
        final String electricity = ElectricityEditText.getText().toString().trim();
        final String  gas = GasEditText.getText().toString().trim();
        final String water = WaterEditText.getText().toString().trim();
        Intent intent = getIntent();
        final String username = intent.getStringExtra("username").trim();
        final String  internet = InternetEditText.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(IncomeActivity.this,response,Toast.LENGTH_LONG).show();
                        ElectricityEditText.setText("");
                        GasEditText.setText("");
                        WaterEditText.setText("");
                        InternetEditText.setText("");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(IncomeActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_ELECTRICITY,electricity);
                params.put(KEY_GAS,gas);
                params.put(KEY_WATER, water);
                params.put(KEY_INTERNET, internet);
                params.put(KEY_USERNAME, username);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {
        registerIncome();
    }
}
