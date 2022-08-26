package il2cpp.typefaces;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import il2cpp.Utils;
import il2cpp.typefaces.Menu;

public class CheckBox extends LinearLayout {
	Context context;
	
	public LinearLayout checkbox;
	public TextView title;
	public LinearLayout expand;
	
	public boolean isChecked = false;
	public Callback callback;
	public int colorMain = 0;
	
	public static interface Callback {
		public void onChanged(boolean checked);
	}
	
	public void setChecked(boolean isch) {
		isChecked = isch;
		if (callback != null) callback.onChanged(isChecked);
		
		if (isChecked) {
			setColor(colorMain);
			Utils.anim(checkbox, 200);
		} else {
			setColor(Color.TRANSPARENT);
			Utils.disanim(checkbox, 150);
			new Handler().postDelayed(new Runnable() {
				public void run() {
					Utils.anim(checkbox, 200);
				}
			}, 150);
		}
	}
	
	public void setCallback(Callback call) {
		callback = call;
	}
	
	public void setText(String t) {
		title.setText(t);
	}
	
	public void setColor(int c) {
		GradientDrawable grad = new GradientDrawable();
		grad.setColor(c);
		grad.setCornerRadius(5f);
		grad.setStroke(2, colorMain);
		
		checkbox.setBackgroundDrawable(grad);
	}
	
	public CheckBox(Context ctx) {
		super(ctx);
		context = ctx;
		
		colorMain = Color.parseColor("#696969");
		
		setOrientation(LinearLayout.HORIZONTAL);
		
		checkbox = new LinearLayout(context);
		{ // CheckBox create
			setColor(colorMain);
		}
		
		expand = new LinearLayout(context);
		{ // Expand line
			expand.setPadding(7, 7, 7, 7);
			expand.setGravity(Gravity.CENTER);
			
			expand.addView(checkbox, -1, -1);
		}
		
		title = new TextView(context);
		{ // Checkbox text
			title.setTextSize(11.5f);
			title.setTypeface(Utils.font(context));
			title.setTextColor(Color.WHITE);
			title.setGravity(Gravity.CENTER_VERTICAL);
			title.setPadding(10,0,0,0);
		}
		
		OnClickListener clck;
		{ // Click lsitener
			clck = new OnClickListener() {
				public void onClick(View v) {
					setChecked(!isChecked);
				}
			};
			checkbox.setOnClickListener(clck);
			title.setOnClickListener(clck);
			setOnClickListener(clck);
		}
		
		addView(expand, Utils.dp(context, 20), Utils.dp(context, 20));
		addView(title, -1, -1);
		setLayoutParams(new LinearLayout.LayoutParams(-1, Utils.dp(context, 20)));
		
		setChecked(false);
	}
}
