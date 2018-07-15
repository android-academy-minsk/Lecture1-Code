package by.androidacademy.firstapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Random mRandom = new Random();

    private TextView mRussiaGoals;
    private TextView mSpainGoals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRussiaGoals = findViewById(R.id.tv_russia_goals);
        mSpainGoals = findViewById(R.id.tv_spain_goals);

        findViewById(R.id.iv_russia).setOnClickListener(view -> {
            FlagActivity.show(this, R.drawable.flag_russia);
        });
        findViewById(R.id.iv_spain).setOnClickListener(view -> {
            FlagActivity.show(this, R.drawable.flag_spain);
        });
        findViewById(R.id.btn_predict).setOnClickListener(view -> {
            predictScores();
        });
    }

    private void predictScores() {
        final int russiaScore = getRandomScore(0, 5);
        final int spainScore = getRandomScore(0, 5);

        mRussiaGoals.setText(String.valueOf(russiaScore));
        mSpainGoals.setText(String.valueOf(spainScore));
    }

    private int getRandomScore(int start,
                               int end) {
        if (start > end) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        }
        long range = (long) end - (long) start + 1;
        long fraction = (long) (range * mRandom.nextDouble());
        return (int) (fraction + start);
    }
}
