package nitt.paritosh.simplycity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;



public class Invites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_invite);

    }

    public void back(View view)
    {

        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}