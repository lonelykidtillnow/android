GPS :

MainActivity.java

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
Button b1;
EditText e1,e2;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
b1=(Button)findViewById( R.id.b1 );
e1=(EditText)findViewById( R.id.e1 );
e2=(EditText)findViewById( R.id.e2 );
b1.setOnClickListener( new View.OnClickListener()
{ @Override
public void onClick(View v) {
Intent i=new Intent( getApplicationContext(),MainActivity2.class );
i.putExtra( "e1",e1.getText().toString() ); i.putExtra(
"e2",e2.getText().toString() );
startActivity( i );
}
} );
}
}

MainActivity2.java

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.os.Bundle;
public class MainActivity2 extends AppCompatActivity {
String lat,long1;
WebView w1;
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main2);
Bundle b=getIntent().getExtras();
lat=b.getString( "e1" );
long1=b.getString( "e2" );
w1=(WebView)findViewById( R.id.w1 );
w1.setWebViewClient( new WebViewClient() );
w1.getSettings().setJavaScriptEnabled( true );
String url = "https://www.google.com/maps/search/?api=1&query=" + lat + "," + long1;
w1.loadUrl(url);
}
}