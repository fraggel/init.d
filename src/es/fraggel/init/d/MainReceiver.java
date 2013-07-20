package es.fraggel.init.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;

/**
 * Created by u028952 on 18/07/13.
 */
public class MainReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            File f=new File("/system/etc/init.d");
            if(f.exists()){
                Runtime rt = Runtime.getRuntime();
                Process p = rt.exec("su");
                BufferedOutputStream bos = new BufferedOutputStream(p.getOutputStream());
                bos.write("su -c 'mount -o rw,remount /dev/block/mmcblk0p3 /system'\n".getBytes());
                bos.write("chmod 777 /system/etc/init.d\n".getBytes());
                bos.write("chmod 777 /system/etc/init.d/*\n".getBytes());
                bos.flush();
                bos.close();
                File[] files = f.listFiles();
                for (int x=0;x<files.length;x++){
                    if(!files[x].isDirectory()){
                        ThreadRun thr=new ThreadRun(files[x].getName());
                        thr.run();
                    }
                }

            }
        }catch(Exception e){
            Toast.makeText(context, context.getResources().getString(R.string.error), Toast.LENGTH_SHORT).show();
        }

    }
}
