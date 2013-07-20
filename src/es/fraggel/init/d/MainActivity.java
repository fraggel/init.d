package es.fraggel.init.d;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
        ArrayList<String> listaInitd=new ArrayList<String>();
        TextView lstv=(TextView) findViewById(R.id.textView3);
        File f=new File("/system/etc/init.d/");
        if(f.exists()){
            File[] files = f.listFiles();
            for (int x=0;x<files.length;x++){
                if(!files[x].isDirectory()){
                    listaInitd.add(files[x].getName());
                    lstv.setText(lstv.getText()+"\n"+files[x].getName());
                }
            }
        }
		return true;
	}

}
