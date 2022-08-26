package il2cpp.typefaces;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import il2cpp.Utils;
import android.widget.ImageView;

public class PageButton extends LinearLayout {
	Context context;
	
	public static interface Callback {
		public void onClick();
	}
	public Callback callback;
	View __isopen;
	
	
TextView _pagetitle;
ImageView _pagescrl;
	public void show() {
		__isopen.setVisibility(View.VISIBLE);
	}
	
	public void hide() {
		__isopen.setVisibility(View.GONE);
	}
	
	public void anim() {
		Utils.anim(this, 400);
	}
	
	public PageButton(Context context, String __text, String __src) {
		super(context);
		this.context = context;
		
		
		
				{
					this.setOrientation(0);
					this.setPadding(5, 5, 5, 5);
					this.setGravity(19);
					
					GradientDrawable design = new GradientDrawable();
					design.setColor(-14277334);
					design.setCornerRadii(new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f });
					design.setStroke(1, -14277334);
					this.setBackgroundDrawable(design);
					
					LayoutParams lp = new LayoutParams(220, 110, 0);
					lp.leftMargin   = 30;
					lp.topMargin    = 20;
					lp.rightMargin  = 0;
					lp.bottomMargin = 0;
					this.setLayoutParams(lp);
				}


		_pagescrl = new ImageView(context);
				{
					_pagescrl.setPadding(5, 5, 5, 5);
					
					GradientDrawable design = new GradientDrawable();
					design.setColor(0);
					design.setCornerRadii(new float[] { 20.0f, 20.0f, 20.0f, 20.0f, 20.0f, 20.0f, 20.0f, 20.0f });
					design.setStroke(1, -886445);
					_pagescrl.setBackgroundDrawable(design);
					
					LayoutParams lp = new LayoutParams(82, 82, 0);
					lp.leftMargin   = 10;
					lp.topMargin    = 0;
					lp.rightMargin  = 0;
					lp.bottomMargin = 0;
					_pagescrl.setLayoutParams(lp);
					
					Utils.SetAssets(context, _pagescrl, "icon.png");
				}
this.addView(_pagescrl);

		_pagetitle = new TextView(context);
				{
					_pagetitle.setText("TextView");
					_pagetitle.setPadding(5, 5, 5, 5);
					_pagetitle.setGravity(17);
					
					GradientDrawable design = new GradientDrawable();
					design.setColor(0);
					design.setCornerRadii(new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f });
					design.setStroke(1, 0);
					_pagetitle.setBackgroundDrawable(design);
					
					LayoutParams lp = new LayoutParams(-2, -2, 0);
					lp.leftMargin   = 10;
					lp.topMargin    = 0;
					lp.rightMargin  = 0;
					lp.bottomMargin = 0;
					_pagetitle.setLayoutParams(lp);
					_pagetitle.setTextColor(-1);
					_pagetitle.setTextSize(10.0f);
					_pagetitle.setTypeface(Utils.font(context));
				}
this.addView(_pagetitle);
LinearLayout _isopen = new LinearLayout(context);

ImageView _pagesrc = new ImageView(context);

		
		__isopen = _isopen;
		
		this.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				anim();
				if (callback != null) callback.onClick();
			}
		});
		_pagetitle.setText(__text);
		Utils.SetAssets(context, _pagesrc, __src);
	}
}
