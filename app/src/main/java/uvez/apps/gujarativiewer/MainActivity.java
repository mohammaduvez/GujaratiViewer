package uvez.apps.gujarativiewer;

import android.content.ClipboardManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String clipboardstring;
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview=(TextView)findViewById(R.id.gujarati_text);
        textview.setTypeface(Typeface.createFromAsset(getAssets(),getString(R.string.typeface_name)));
        textview.setText(getClipboardString());
    }
    protected String getClipboardString(){
        clipboardstring = ((ClipboardManager)getSystemService(CLIPBOARD_SERVICE)).getPrimaryClip().getItemAt(0).getText().toString();
        return clipboardstring;
    }
    @Override
    protected void onResume(){
        super.onResume();
        textview.setText(getClipboardString());
    }
}