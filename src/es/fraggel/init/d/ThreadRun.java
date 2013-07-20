package es.fraggel.init.d;

import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;

/**
 * Created by Fra on 19/07/13.
 */
public class ThreadRun implements Runnable {
    String param="";
    public ThreadRun(String parametro) {
        param=parametro;
    }

    public void run() {
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec("su -c './system/etc/init.d/"+param+"'");
        }catch(Exception e){
        }
    }
}