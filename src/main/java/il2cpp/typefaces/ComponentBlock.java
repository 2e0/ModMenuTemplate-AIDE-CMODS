package il2cpp.typefaces;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import il2cpp.Utils;

public class ComponentBlock extends LinearLayout {
	Context context;
	
	public LinearLayout header, line, main;
	public TextView title;
	public ScrollView scrl;
	
	public float corner = 10;
	public ComponentBlock(Context ctx, String name) {
		super(ctx);
		context = ctx;
		
		setOrientation(LinearLayout.VERTICAL);
		
		header = new LinearLayout(context);
		{ // Header Layout
			GradientDrawable head = new GradientDrawable();
			head.setCornerRadii(new float[] {corner, corner, corner, corner, 0, 0, 0, 0});
			head.setColor(Color.parseColor("#2C2B30" ));
			header.setBackgroundDrawable(head);
			
			title = new TextView(context);
			{ // Header title
				title.setText(name);
				title.setTextSize(11.5f);
				title.setTypeface(Utils.font(context));
				title.setTextColor(Color.WHITE);
				title.setGravity(Gravity.CENTER_VERTICAL);
				title.setPadding(20,0,0,0);
			}
			
			header.addView(title, new LayoutParams(-1, -1, 1));
		}
		
		line = new LinearLayout(context);
		{ // Line layout
			line.setBackgroundColor(Color.parseColor("#2C2B30" ));
		}
		
		main = new LinearLayout(context);
		main.setOrientation(LinearLayout.VERTICAL);
		{ // Main content view
			GradientDrawable menu = new GradientDrawable();
			menu.setCornerRadii(new float[] {0,0,0,0, corner, corner, corner, corner});
			menu.setColor(Color.parseColor("#2C2B30" ));
			main.setBackgroundDrawable(menu);
			
			main.setPadding(10, 10, 10, 10);
			
			main.setMinimumHeight(Utils.dp(context, 20));
		}
		
		addView(header, -1, Utils.dp(context, 20));
		addView(line, -1, 2);
		
		scrl = new ScrollView(context);
		scrl.addView(main, -1, -1);
		scrl.setFillViewport(true);
		
		addView(scrl, new LinearLayout.LayoutParams(-1, -1));
	}
}
