package utp.edu.pe.volleyapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class UserProfileActivity extends AppCompatActivity {

    TextView textView;
    Button IncomesButton;
    Button ExpensesButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        textView = (TextView) findViewById(R.id.textViewUsername);
        Intent intent = getIntent();
        textView.setText(intent.getStringExtra(LoginActivity.KEY_USERNAME));

        IncomesButton = (Button) findViewById(R.id.IncomesButton);
        IncomesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), IncomeActivity.class);
                Intent intent = getIntent();
                i.putExtra("username", intent.getStringExtra(LoginActivity.KEY_USERNAME) );
                startActivity(i);
            }
        });

        ExpensesButton = (Button) findViewById(R.id.ExpensesButton);
        ExpensesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ExpenseActivity.class);
                Intent intent = getIntent();
                i.putExtra("username", intent.getStringExtra(LoginActivity.KEY_USERNAME) );
                startActivity(i);
            }
        });
    }
}
