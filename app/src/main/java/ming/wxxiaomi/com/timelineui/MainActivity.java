package ming.wxxiaomi.com.timelineui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button first;
    private Button second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        first = (Button) findViewById(R.id.first);
        first.setOnClickListener(this);
        second = (Button) findViewById(R.id.second);
        second.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent inetnt = null;
        switch (view.getId()){
            case R.id.first:
                inetnt = new Intent(this,LatestActivity2.class);

                break;
            case R.id.second:
                inetnt = new Intent(this,RefreshActivity.class);
                break;
        }
        startActivity(inetnt);
    }
}
