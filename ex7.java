Notification Manager:
MainActivity.java
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle; import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
Button b;
EditText e;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate( savedInstanceState ); setContentView(
R.layout.activity_main ); b=(Button)findViewById(
R.id.b ); e=(EditText)findViewById( R.id.e );
b.setOnClickListener( new View.OnClickListener() {
@Override
public void onClick(View v) {
Intent intent=new Intent( MainActivity.this,Main2Activity.class );
PendingIntent pendingIntent = PendingIntent.getActivity( MainActivity.this, 0,
intent, 0 );
Notification notification = new Notification.Builder( MainActivity.this )
.setContentTitle( "New Message")
.setContentText( e.getText().toString())
.setSmallIcon( R.mipmap.ic_launcher)
.setContentIntent( pendingIntent ).build();
NotificationManager manager = (NotificationManager) getSystemService(
NOTIFICATION_SERVICE );
notification.flags |= Notification.FLAG_AUTO_CANCEL;
manager.notify( 0, notification );
}});
}}

MainActivity2.java

package e.student.notificationmanager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class Main2Activity extends AppCompatActivity {
@Override
protected void onCreate(Bundle savedInstanceState)
{ super.onCreate( savedInstanceState );
setContentView( R.layout.activity_main2 );
} }