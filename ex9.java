Send Mail:

MainActivity.java

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
Button b;
EditText e1,e2,e3;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
b = (Button) findViewById( R.id.b );
e1 = (EditText) findViewById( R.id.e1 );
e2 = (EditText) findViewById( R.id.e2 );
e3 = (EditText) findViewById( R.id.e3 );
b.setOnClickListener( new View.OnClickListener() {
@Override
public void onClick(View v) {
String to = e1.getText().toString();
String subject = e2.getText().toString();
String message = e3.getText().toString();
Intent i = new Intent( Intent.ACTION_SEND );
i.putExtra( Intent.EXTRA_EMAIL, new String[]{to}
); i.putExtra( Intent.EXTRA_SUBJECT, subject );
i.putExtra( Intent.EXTRA_TEXT, message );
i.setType( "message/rfc822" );
startActivity( Intent.createChooser( i, "Choose EMail App" ) );
}
} );}}

Values---string.xml

<resources>
<string name="app_name">EX9</string>
<color name="colorPrimary">#3F51B5</color>
<color name="colorPrimaryDark">#303F9F</color>
<color name="colorAccent">#FF4081</color>
</resources>

AndroidManifest.xml

<activity
android:name=".MainActivity"
android:exported="true">
<intent-filter>
<action android:name="android.intent.action.MAIN" />
<category android:name="android.intent.category.LAUNCHER" />
</intent-filter>
<intent-filter>
<action android:name="android.intent.action.SEND" />
<category android:name="android.intent.category.DEFAULT" />
<data android:mimeType="message/rfc822" />
</intent-filter>
</activity>