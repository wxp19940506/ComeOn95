package uiutils;

/**
 * Created by Administrator on 2016/10/18 0018.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;

public class MoveViewUtils {
    /**
     * 设置控件可在屏幕上随意拖动
     *
     * @param view
     * 要移动的控件
     * @param sp
     * sharedPreference
     * @param screenHeight
     * 屏幕的高度
     * @param screenWidth
     * //屏幕的宽度
     */
    protected static int screenWidth;
    protected static int screenHeight;
    protected static SharedPreferences sp;

    public static void setMoveView(Context context, final View view) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        screenWidth = wm.getDefaultDisplay().getWidth();
        screenHeight = wm.getDefaultDisplay().getHeight();
        sp = context.getSharedPreferences("config",  Context.MODE_PRIVATE);
        int lastx = sp.getInt("lastx", 0);
        int lasty = sp.getInt("lasty", 0);
        LayoutParams params = (LayoutParams) view
                .getLayoutParams();
        params.leftMargin = lastx;
        params.topMargin = lasty;
        view.setLayoutParams(params);

        view.setOnTouchListener(new OnTouchListener() {
            int startX;
            int startY;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:// 手指第一次触摸到屏幕
                        this.startX = (int) event.getRawX();
                        this.startY = (int) event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:// 手指移动
                        int newX = (int) event.getRawX();
                        int newY = (int) event.getRawY();

                        int dx = newX - this.startX;
                        int dy = newY - this.startY;

                        // 计算出来控件原来的位置
                        int l = view.getLeft();
                        int r = view.getRight();
                        int t = view.getTop();
                        int b = view.getBottom();

                        int newt = t + dy;
                        int newb = b + dy;
                        int newl = l + dx;
                        int newr = r + dx;

                        if ((newl < 0) || (newt < 0) || (newr > screenWidth)
                                || (newb > screenHeight)) {
                            break;
                        }

                        // 更新控件在屏幕的位置.
                        view.layout(newl, newt, newr, newb);
                        this.startX = (int) event.getRawX();
                        this.startY = (int) event.getRawY();

                        break;
                    case MotionEvent.ACTION_UP: // 手指离开屏幕的一瞬间
                        int lastx = view.getLeft();
                        int lasty = view.getTop();
                        Editor editor = sp.edit();
                        editor.putInt("lastx", lastx);
                        editor.putInt("lasty", lasty);
                        editor.commit();
                        break;
                }
                return true;
            }
        });
    }
}
