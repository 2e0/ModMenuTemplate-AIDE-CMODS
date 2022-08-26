package il2cpp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.text.Html;
import android.view.Gravity;
import android.widget.LinearLayout;
import il2cpp.typefaces.Crosshair;
import android.widget.TextView;
import android.widget.Toast;
import il2cpp.typefaces.Menu;
import il2cpp.typefaces.CheckBox;
import il2cpp.typefaces.Slider;
import il2cpp.Main;
import il2cpp.typefaces.Flick;
import il2cpp.typefaces.Codes;
import il2cpp.typefaces.Fps;
import android.view.animation.Animation;
import android.widget.*;
import java.io.*;
import android.view.animation.ScaleAnimation;

public class Main {
	protected static Context context;
	
	public static native void Changes(int feature, int value);
    public static native String[] getFeatures();
	
	public static void start(final Context context) {
		Main.context = context;
		if (Build.VERSION.SDK_INT >= 23) {
			if (context.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
				|| context.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
				((Activity) context).requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
				init(context);
			}
			else {
				init(context);
			}
		}
		else {
			init(context);
		}
	}

	public static void init(final Context context) {
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
				@Override
				public void run() {
					System.loadLibrary("gvraudio");
					
					try {
						new Main().MenuMain(context);
					} catch(Exception e) {
						Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
					}
				}
			}, 3000);
	}
	
    
	public final void MenuMain(final Context context) {
	
	final Crosshair crosshair = new Crosshair(context);
  crosshair.setWidth(crosshair.dpi(30));
  crosshair.setHeight(crosshair.dpi(30));
  crosshair.isVisible(true);
  
        final Flick redlik = new Flick(context);
		redlik.setWidth(redlik.dpi(100));
		redlik.setHeight(redlik.dpi(30));
		redlik.isVisible(true);

		final Codes soft = new Codes(context);
		soft.setWidth(soft.dpi(100));
		soft.setHeight(soft.dpi(30));
		soft.isVisible(true);

		final Fps fps = new Fps(context);
		fps.setWidth(soft.dpi(100));
		fps.setHeight(soft.dpi(30));
		fps.isVisible(true);
		
		Main.context = context;
		Menu menu = new Menu(context);
		
		String[] ft = getFeatures();
		for (String token: ft) {
			final String[] split = token.split("_");
			
			if (split[0].equals("page")) {
				menu.newPage(split[1], split[2]);
			}
			 if (split[0].equals("BLOCK")) {
                menu.newBlock(Integer.parseInt(split[1]), split[2].split(","));
             }
			if (split[0].equals("slider")) {
				Slider slider = new Slider(context, split[3], Integer.parseInt(split[4]), Integer.parseInt(split[5]));
				slider.callback = new Slider.Callback() {
					public void onChange(int value) {
						Changes(Integer.parseInt(split[1]), value);
					}
				};
				menu.blocks.get(Integer.parseInt(split[2])).main.addView(slider);
			}
switch (split[0]) {
				case "switch":
					CheckBox button = new CheckBox(context);
					button.setText(split[3]);
					button.setCallback(new CheckBox.Callback() {
						public void onChanged(boolean check) {
							Changes(Integer.parseInt(split[1]), check ? 1 : 0);
						}
					});
					menu.blocks.get(Integer.parseInt(split[2])).main.addView(button);
					break;
			}
		}
	}
	
}


