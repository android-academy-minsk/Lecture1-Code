package by.androidacademy.firstapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FlagActivity extends AppCompatActivity {

    private static final String FLAG_RES_ID_EXTRA = "flagResId";
    private static final String TAG = FlagActivity.class.getSimpleName();

    public static void show(Context context, int flagResId) {
        final Intent intent = new Intent(context, FlagActivity.class);
        intent.putExtra(FlagActivity.FLAG_RES_ID_EXTRA, flagResId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag);

        final int flagResId = getIntent().getIntExtra(FLAG_RES_ID_EXTRA, 0);
        if (flagResId != 0) {
            final ImageView flagImage = findViewById(R.id.iv_flag);
            flagImage.setImageResource(flagResId);
        } else {
            Log.e(TAG, "Flag resource id is undefined!");
        }
    }

}
