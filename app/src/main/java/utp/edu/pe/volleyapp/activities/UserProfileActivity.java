package utp.edu.pe.volleyapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import utp.edu.pe.volleyapp.R;


public class UserProfileActivity extends AppCompatActivity {

    TextView textView;
    Button incomesButton;
    Button expensesButton;
    ImageView logoutImageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        textView = (TextView) findViewById(R.id.textViewUsername);
        Intent intent = getIntent();
        textView.setText(intent.getStringExtra(LoginActivity.KEY_USERNAME));

        incomesButton = (Button) findViewById(R.id.incomesButton);
        incomesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), IncomeActivity.class);
                Intent intent = getIntent();
                i.putExtra("username", intent.getStringExtra(LoginActivity.KEY_USERNAME));
                startActivity(i);
            }
        });

        expensesButton = (Button) findViewById(R.id.expensesButton);
        expensesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ExpenseActivity.class);
                Intent intent = getIntent();
                i.putExtra("username", intent.getStringExtra(LoginActivity.KEY_USERNAME));
                startActivity(i);
            }
        });

        logoutImageview = (ImageView) findViewById(R.id.logoutimageView);
        logoutImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });

    }
}
