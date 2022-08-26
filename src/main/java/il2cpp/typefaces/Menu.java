package il2cpp.typefaces;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.*;
import android.view.inputmethod.InputMethodManager;
import il2cpp.*;
import android.text.*;
import android.view.Window.*; 
import android.text.method.*;
import android.graphics.Typeface;
import android.util.*;
import android.net.Uri;
import android.view.*;
import android.widget.*;
import android.view.animation.AlphaAnimation; 
import android.view.animation.Animation;
import java.io.*;
import java.util.Objects;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;
import android.view.View.OnClickListener;
import il2cpp.typefaces.*;

public class Menu
{
	protected int WIDTH,HEIGHT;
    
	public Typeface google(Context yes) {return Typeface.createFromAsset(yes.getAssets(), "Font.ttf");}
	
	protected Context context;
	protected FrameLayout _parentBox;
	protected LinearLayout __page;
	protected ScrollView __scroll;
	
	public ArrayList<ComponentBlock> blocks = new ArrayList<>();
	public ArrayList<PageButton> _pagebuttons = new ArrayList<>();
	public ArrayList<LinearLayout> __pages = new ArrayList<>();
	protected ArrayList<LinearLayout> pageList = new ArrayList<>();
	
	public ImageView _icon;
	public TextView __pagetitle;
	public ImageView __pagesrc;
	boolean _isShow = false;
	
	LinearLayout menulayout,linear7,_isopen,linear8,_pages,_scroll;
TextView stend2hacks;
ImageView _close;
 
	protected WindowManager wmManager;
	protected WindowManager.LayoutParams wmParams;
	protected int isCrosshairHide;
	
	protected void init(Context context) {
		
		this.context = context;
		isCrosshairHide = 1;
		_parentBox = new FrameLayout(context);

		_parentBox.setOnTouchListener(handleMotionTouch);
		wmManager = ((Activity)context).getWindowManager();
		int aditionalFlags=0;
		if (Build.VERSION.SDK_INT >= 11)
			aditionalFlags = WindowManager.LayoutParams.FLAG_SPLIT_TOUCH;
		if (Build.VERSION.SDK_INT >=  3)
			aditionalFlags = aditionalFlags | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
		wmParams = new WindowManager.LayoutParams(
			WindowManager.LayoutParams.WRAP_CONTENT,
			WindowManager.LayoutParams.WRAP_CONTENT,
			0,//initialX
			0,//initialy
			WindowManager.LayoutParams.TYPE_APPLICATION,
			WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
			WindowManager.LayoutParams.FLAG_LAYOUT_IN_OVERSCAN |
			WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
			aditionalFlags,
			PixelFormat.TRANSPARENT
		);
		wmParams.gravity = Gravity.CENTER;
	}
	
	public int dpi(float dp) {
		float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dp * scale + 0.5f);
	}
	
	public void showMenu() {
		_close.setRotation(90);
		_isShow = false;
		_parentBox.removeAllViews();
		_parentBox.addView(menulayout, 1150, 810);
	}

	public void hideMenu() {
		_close.setRotation(-90);
		_isShow = true;
		_parentBox.removeAllViews();
		_parentBox.addView(menulayout, 1150, dpi(40));
	}
	
	public void newPage(final String nm, final String src) {
		LinearLayout _page = new LinearLayout(context);
		PageButton _butt = new PageButton(context, nm, src);
		final int pageid = __pages.size();
		__page.setOrientation(LinearLayout.VERTICAL);
		_page.setOrientation(LinearLayout.VERTICAL);
		__page.addView(_page, -1, -1);
		_page.setVisibility(View.GONE);
		__pages.add(_page);
		_butt.callback = new PageButton.Callback() {
			public void onClick() {
				__pagetitle.setText(nm);
				Utils.SetAssets(context, __pagesrc, src);
				showPage(pageid);
			}
		};
		
		_pagebuttons.add(_butt);
		_pages.addView(_butt);
	}
	
	public void showPage(final int id) {
		for (PageButton pg: _pagebuttons) {
			pg.hide();
		}
		for (LinearLayout layout: __pages) {
			layout.setVisibility(View.GONE);
		}
		__pages.get(id).setVisibility(View.VISIBLE);
		_pagebuttons.get(id).show();
		Utils.anim(__pages.get(id), 400);
	}
	
	public int newBlock(int pageid, String[] names) {
        final int blockid = blocks.size();

        LinearLayout blockline = new LinearLayout(context);
        blockline.setOrientation(LinearLayout.HORIZONTAL);

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            ComponentBlock block = new ComponentBlock(context, name);
            blocks.add(block);

            if (names.length > 1) {
                if ((i != 0)) {
                    LinearLayout expand = new LinearLayout(context);
                    blockline.addView(expand, dpi(5), -1);
                }
            }
            blockline.addView(block, new LinearLayout.LayoutParams(-1, -1, 1));

        }
        __pages.get(pageid).addView(blockline, -1, -1);
        return blockid;
 }
	public Menu(Context context)
	{
		init(context);
		
		_icon = new ImageView(context);
		Utils.SetAssets(context, _icon, "icon.png");
		
		menulayout = new LinearLayout(context);
				{
					menulayout.setOrientation(1);
					menulayout.setPadding(5, 5, 5, 5);
					menulayout.setGravity(51);
					
					GradientDrawable design = new GradientDrawable();
					design.setColor(0);
					design.setCornerRadii(new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f });
					design.setStroke(0, -16777216);
					menulayout.setBackgroundDrawable(design);
					
					LayoutParams lp = new LayoutParams(1150, 810, 0);
					lp.leftMargin   = 0;
					lp.topMargin    = 0;
					lp.rightMargin  = 0;
					lp.bottomMargin = 0;
					menulayout.setLayoutParams(lp);
				}

		linear7 = new LinearLayout(context);
				{
					linear7.setOrientation(0);
					linear7.setPadding(5, 5, 5, 5);
					linear7.setGravity(51);
					
					GradientDrawable design = new GradientDrawable();
					design.setColor(-16743189);
					design.setCornerRadii(new float[] { 20.0f, 20.0f, 20.0f, 20.0f, 20.0f, 20.0f, 20.0f, 20.0f });
					design.setStroke(0, -16777216);
					linear7.setBackgroundDrawable(design);
					
					LayoutParams lp = new LayoutParams(-1, 81, 0);
					lp.leftMargin   = 0;
					lp.topMargin    = 0;
					lp.rightMargin  = 0;
					lp.bottomMargin = 0;
					linear7.setLayoutParams(lp);
				}
menulayout.addView(linear7);

		stend2hacks = new TextView(context);
				{
					stend2hacks.setText("STEND2HACKS.COM");
					stend2hacks.setPadding(5, 5, 5, 5);
					stend2hacks.setGravity(17);
					
					GradientDrawable design = new GradientDrawable();
					design.setColor(0);
					design.setCornerRadii(new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f });
					design.setStroke(1, 0);
					stend2hacks.setBackgroundDrawable(design);
					
					LayoutParams lp = new LayoutParams(-2, -2, 0);
					lp.leftMargin   = 0;
					lp.topMargin    = 0;
					lp.rightMargin  = 0;
					lp.bottomMargin = 0;
					stend2hacks.setLayoutParams(lp);
					stend2hacks.setTextColor(-1);
					stend2hacks.setTextSize(19.0f);
					stend2hacks.setTypeface(Utils.font(context));
				}
linear7.addView(stend2hacks);

		_isopen = new LinearLayout(context);
				{
					_isopen.setOrientation(1);
					_isopen.setPadding(5, 5, 5, 5);
					_isopen.setGravity(51);
					
					GradientDrawable design = new GradientDrawable();
					design.setColor(0);
					design.setCornerRadii(new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f });
					design.setStroke(0, -16777216);
					_isopen.setBackgroundDrawable(design);
					
					LayoutParams lp = new LayoutParams(-2, -2, 0);
					lp.leftMargin   = 500;
					lp.topMargin    = 0;
					lp.rightMargin  = 0;
					lp.bottomMargin = 0;
					_isopen.setLayoutParams(lp);
				}
linear7.addView(_isopen);

		_close = new ImageView(context);
				{
					_close.setPadding(5, 5, 5, 5);
					
					GradientDrawable design = new GradientDrawable();
					design.setColor(0);
					design.setCornerRadii(new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f });
					design.setStroke(0, -16776961);
					_close.setBackgroundDrawable(design);
					
					LayoutParams lp = new LayoutParams(81, -2, 0);
					lp.leftMargin   = 0;
					lp.topMargin    = 0;
					lp.rightMargin  = 0;
					lp.bottomMargin = 0;
					_close.setLayoutParams(lp);
					
					Utils.SetAssets(context, _close, "close.png");
				}
_isopen.addView(_close);

		linear8 = new LinearLayout(context);
				{
					linear8.setOrientation(0);
					linear8.setPadding(5, 5, 5, 5);
					linear8.setGravity(51);
					
					GradientDrawable design = new GradientDrawable();
					design.setColor(-13882576);
					design.setCornerRadii(new float[] { 20.0f, 20.0f, 20.0f, 20.0f, 20.0f, 20.0f, 20.0f, 20.0f });
					design.setStroke(0, -16777216);
					linear8.setBackgroundDrawable(design);
					
					LayoutParams lp = new LayoutParams(-1, -1, 0);
					lp.leftMargin   = 0;
					lp.topMargin    = 50;
					lp.rightMargin  = 0;
					lp.bottomMargin = 0;
					linear8.setLayoutParams(lp);
				}
menulayout.addView(linear8);

		_pages = new LinearLayout(context);
				{
					_pages.setOrientation(1);
					_pages.setPadding(5, 5, 5, 5);
					_pages.setGravity(51);
					
					GradientDrawable design = new GradientDrawable();
					design.setColor(0);
					design.setCornerRadii(new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f });
					design.setStroke(0, -16777216);
					_pages.setBackgroundDrawable(design);
					
					LayoutParams lp = new LayoutParams(250, -1, 0);
					lp.leftMargin   = 25;
					lp.topMargin    = 25;
					lp.rightMargin  = 25;
					lp.bottomMargin = 25;
					_pages.setLayoutParams(lp);
				}
linear8.addView(_pages);

		_scroll = new LinearLayout(context);
				{
					_scroll.setOrientation(1);
					_scroll.setPadding(5, 5, 5, 5);
					_scroll.setGravity(51);
					
					GradientDrawable design = new GradientDrawable();
					design.setColor(0);
					design.setCornerRadii(new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f });
					design.setStroke(0, -16777216);
					_scroll.setBackgroundDrawable(design);
					
					LayoutParams lp = new LayoutParams(-1, -1, 0);
					lp.leftMargin   = 0;
					lp.topMargin    = 25;
					lp.rightMargin  = 0;
					lp.bottomMargin = 25;
					_scroll.setLayoutParams(lp);
				}
linear8.addView(_scroll);
LinearLayout _underpages = new LinearLayout(context);

TextView _pagetitle = new TextView(context);

ImageView _pagesrc = new ImageView(context);
		
		__pagetitle = _pagetitle;
		__pagesrc = _pagesrc;
		
		OnClickListener clck = (new OnClickListener() {
			public void onClick(View v){
				if (_isShow) {
					showMenu();
				} else {
					hideMenu();
				}
			}
		});
		final Crosshair crosshair = new Crosshair(context);
		crosshair.setWidth(crosshair.dpi(30));
		crosshair.setHeight(crosshair.dpi(30));
		crosshair.isVisible(true);
        
		_close.setOnClickListener(clck);
		
		__scroll = new ScrollView(context);
		__scroll.setFillViewport(true);
		
		__page = new LinearLayout(context);
		__page.setOrientation(LinearLayout.VERTICAL);
		
		__scroll.addView(__page, -1, -1);
		_scroll.addView(__scroll, -1, -1);
		
		hideMenu();
		wmManager.addView(_parentBox, wmParams);
	}
	
	View.OnTouchListener handleMotionTouch = new View.OnTouchListener()
	{
		private float initX;          
		private float initY;
		private float touchX;
		private float touchY;

		double clock=0;
		
		@Override
		public boolean onTouch(View vw, MotionEvent ev)
		{

			switch (ev.getAction())
			{
				case MotionEvent.ACTION_DOWN:

					initX = wmParams.x;
					initY = wmParams.y;
					touchX = ev.getRawX();
					touchY = ev.getRawY();
					clock = System.currentTimeMillis();
					break;

				case MotionEvent.ACTION_MOVE:
					wmParams.x = (int)initX + (int)(ev.getRawX() - touchX);

					wmParams.y = (int)initY + (int)(ev.getRawY() - touchY);


					wmManager.updateViewLayout(vw, wmParams);
					break;

				case MotionEvent.ACTION_UP:
					if (!_isShow && (System.currentTimeMillis() < (clock + 200)))
					{
						showMenu();
					}
					break;
			}
			return true;
		}
	};
}
