package roc.cjm.slidedelete.utils;

import android.content.Context;

/**
 * Created by Administrator on 2017/9/2.
 */

public class Util {

    public static int dp2px(Context context,float dpValue) {
        return (int) (dpValue * context.getResources().getDisplayMetrics().density + 0.5f);
    }
}
