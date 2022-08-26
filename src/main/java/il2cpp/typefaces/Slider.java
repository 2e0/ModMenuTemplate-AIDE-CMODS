package il2cpp.typefaces;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import il2cpp.Utils;

// 1 line
public class Slider extends LinearLayout {
	Context context;
	public TextView title, value;
	public SeekBar slider;
	
	public static interface Callback {
		public void onChange(int value);
	}
	public Callback callback;
	
	public void setValue(int v) {
		slider.setProgress(v);
		value.setText(String.valueOf(v));
		if (callback != null) callback.onChange(v);
	}
	
	public Slider(Context context, String text, int max, int current) {
		super(context);
		this.context = context;
		
		int mainColor = Color.parseColor("#696969");
		
		LinearLayout leftlayout = new LinearLayout(context);
		{
			title = new TextView(context);
			{ // Slider text
				title.setText(text + ": ");
				title.setTextSize(10f);
				title.setTypeface(Utils.font(context));
				title.setTextColor(Color.WHITE);
				title.setGravity(Gravity.CENTER_VERTICAL);
				
				leftlayout.addView(title, -2, -1);
			}
			
			value = new TextView(context);
			{ // Slider value text
				value.setText(String.valueOf(current));
				value.setTextSize(10f);
				value.setTypeface(Utils.font(context));
				value.setTextColor(Color.WHITE);
				value.setGravity(Gravity.CENTER_VERTICAL);
				
				leftlayout.addView(value, -2, -1);
			}
			
			leftlayout.setOrientation(LinearLayout.HORIZONTAL);
			leftlayout.setGravity(Gravity.CENTER_VERTICAL);
			
			addView(leftlayout, new LayoutParams(-1, -1, 1));
		}
		
		LinearLayout rightlayout = new LinearLayout(context);
		{
			
			slider = new SeekBar(context);
			{ // SeekBar design
				slider.setMax(max);
				slider.setProgress(current);
				GradientDrawable thumb = new GradientDrawable();
				thumb.setColor(mainColor);
				thumb.setSize(30, 30);
				thumb.setCornerRadius(5);
				slider.setPadding(10,0,10,0);
				
				thumb.setStroke(1, Color.WHITE);
				thumb.setTintMode(PorterDuff.Mode.MULTIPLY);

				slider.setThumb(thumb);

				slider.getProgressDrawable().setColorFilter(mainColor, PorterDuff.Mode.MULTIPLY);
				
				slider.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
					@Override
					public void onProgressChanged(SeekBar sl, int v, boolean b) {
						setValue(v);
					}

					@Override
					public void onStopTrackingTouch(SeekBar sl) {}
					@Override
					public void onStartTrackingTouch(SeekBar sl) {}
				});
				
				rightlayout.addView(slider, -1, -1);
			}
			
			addView(rightlayout, new LayoutParams(-1, -1, 1));
		}
		
		setPadding(10,0,10,0);
		setOrientation(LinearLayout.HORIZONTAL);
		setLayoutParams(new LayoutParams(-1, Utils.dp(context, 20)));
	}
}
