Layout& Event:

import android.graphics.Color;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.View;
public class MainActivity extends AppCompatActivity {
Button b1,b2,b3;
ListView l;
Spinner s;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
b1=(Button)findViewById( R.id.b1 );
b2=(Button)findViewById( R.id.b2 );
b3=(Button)findViewById( R.id.b3 );
l=(ListView)findViewById( R.id.l );
s=(Spinner)findViewById( R.id.s );
b1.setOnClickListener( new View.OnClickListener()
{ @Override
public void onClick(View v) {
b1.setTextColor( Color.RED );
}
} );
b2.setOnClickListener( new View.OnClickListener()
{ @Override
public void onClick(View v) {
b2.setTextColor( Color.GREEN );
}
} );
b3.setOnClickListener( new View.OnClickListener()
{ @Override
public void onClick(View v) {
b3.setTextColor( Color.BLUE );
}
} );
String a[]=new String[] {"Red", "Green","Blue"};
final ArrayAdapter<String> aa=new
ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,a );
l.setAdapter( aa );
s.setAdapter( aa );
l.setOnItemClickListener( new AdapterView.OnItemClickListener()
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
String s=(String)l.getItemAtPosition( position );
Toast.makeText(getApplicationContext(),"List View "+s,
Toast.LENGTH_SHORT).show();
}
} );
s.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener()
public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
{
String s1=(String)parent.getItemAtPosition( position );
Toast.makeText(getApplicationContext(),"Spinner "+s1,
Toast.LENGTH_SHORT).show();
}
public void onNothingSelected(AdapterView<?> parent) {
}} );}}