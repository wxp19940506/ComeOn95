package uiutils;

import android.content.Context;

/**
 * Created by Administrator on 2016/10/29 0029.
 */

public  class GetAddress {
    public static String PATH = "http://121.42.24.226";
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
