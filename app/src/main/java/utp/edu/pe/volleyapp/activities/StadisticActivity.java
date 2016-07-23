package utp.edu.pe.volleyapp.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import utp.edu.pe.volleyapp.R;


public class StadisticActivity extends AppCompatActivity {
    private static final String REGISTER_URL = "http://192.241.166.108/WebService/stadistic.php";

    public static final String KEY_INCOME = "income";
    public static final String KEY_EXPENSE = "expense";
    public static final String KEY_USERNAME = "username";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stadistic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BarChart chart = (BarChart) findViewById(R.id.chart);
        Intent intent = getIntent();
        final String username = intent.getStringExtra("username").trim();

      //  BarData data = new BarData(getXAxisValues());
       // chart.setData(data);
       // chart.setDescription("");
       // chart.invalidate();
    }

    private void Staditic(){
        Intent intent = getIntent();
        final String username = intent.getStringExtra("username").trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME, username);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

   /* @Override
    public void onClick(View v) {
        Staditic();
    }
    private ArrayList<BarDataSet> getDataSet(String username) {
        ArrayList<BarDataSet> dataSets = null;
        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(, 0); // Jan
        valueSet1.add(v1e1);

        ArrayList<BarEntry> valueSet2 = new ArrayList<>();
        BarEntry v2e1 = new BarEntry(service.getExpenseforMonth(0,getextras(extras)), 0); // Jan
        valueSet2.add(v2e1);

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Income");
        barDataSet1.setColor(Color.rgb(0, 155, 0));
        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Expense");
        barDataSet2.setColor(Color.rgb(155,0,0));

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);
        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("Income");
        xAxis.add("Expense");
        return xAxis;
    }
*/

}
