Persistent Data Storage:

Mainactivity.java

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {
SQLiteDatabase db;
String f1,l1,m1;
EditText e1,e2,e3;
Button add,close,show;
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
db=openOrCreateDatabase("Mydb",MODE_PRIVATE,null);
db.execSQL("CREATE TABLE IF NOT EXISTS student(fname VARCHAR, lname VARCHAR, email VARCHAR);");
add=(Button)findViewById(R.id.b1);
close=(Button)findViewById(R.id.b2);
show=(Button)findViewById(R.id.b3);
add.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
e1=(EditText)findViewById(R.id.e1);
e2=(EditText)findViewById(R.id.e2);
e3=(EditText)findViewById(R.id.e3);
f1=e1.getText().toString();
l1=e2.getText().toString();
m1=e3.getText().toString();
db.execSQL("INSERT INTO student VALUES ('"+f1+"','"+l1+"','"+m1+"');");
Toast.makeText(getApplicationContext(),
"Row Inserted",Toast.LENGTH_LONG).show();
}
});
close.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
System.exit(0); }
});
show.setOnClickListener(new View.OnClickListener()
{ @Override
public void onClick(View view) {
Intent i=new Intent(getApplicationContext(),MainActivity2.class);
startActivity(i);
}
});}}


Mainactivity2.java

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
public class MainActivity2 extends AppCompatActivity {
EditText fn,ln,em;
Button prev,next,back;
SQLiteDatabase db;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main2);
fn=(EditText)findViewById(R.id.e4);
ln=(EditText)findViewById(R.id.e5);
em=(EditText)findViewById(R.id.e6);
prev=(Button)findViewById(R.id.b4);
next=(Button)findViewById(R.id.b5);
back=(Button)findViewById(R.id.b6);
db=openOrCreateDatabase("Mydb",MODE_PRIVATE,null);
final Cursor c=db.rawQuery("select * from student",null);
c.moveToFirst();
back.setOnClickListener(new View.OnClickListener()
{ @Override
public void onClick(View view) {
Intent i1=new Intent(getApplicationContext(),MainActivity.class);
startActivity(i1);
}
});
prev.setOnClickListener(new View.OnClickListener()
{ @Override
public void onClick(View view) {
try {
c.moveToPrevious();
fn.setText(c.getString(c.getColumnIndexOrThrow("fname")));
ln.setText(c.getString(c.getColumnIndexOrThrow("lname")));
em.setText(c.getString(c.getColumnIndexOrThrow("email")));
}
catch (Exception e){
Toast.makeText(getApplicationContext(),
"First Record",Toast.LENGTH_SHORT).show();
e.printStackTrace();
}
} });
next.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
try{
c.moveToNext();
fn.setText(c.getString(c.getColumnIndexOrThrow("fname")));
ln.setText(c.getString(c.getColumnIndexOrThrow("lname")));
em.setText(c.getString(c.getColumnIndexOrThrow("email")));
}
catch (Exception e){
Toast.makeText(getApplicationContext(),
"Last Record",Toast.LENGTH_SHORT).show();
}} });}}