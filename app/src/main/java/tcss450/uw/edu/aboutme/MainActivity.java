package tcss450.uw.edu.aboutme;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showText(View view) {
        Intent intent = new Intent(this, TextActivity.class);
        startActivity(intent);
    }

    public void showImage(View view) {
        Intent intent = new Intent(this, ImageActivity.class);
        startActivity(intent);
    }

    public void showWeb(View view) {
        Uri webpage = Uri.parse("http://developer.android.com/index.html");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

    public void showToast(View view) {
        Context context = getApplicationContext();
        CharSequence text = "I'm just gonna put this right here...";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void showDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.dialog_title).setMessage(R.string.dialog_message);
        builder.setCancelable(true);
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.i(LOG_TAG, "I almost do something.");
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }

}
