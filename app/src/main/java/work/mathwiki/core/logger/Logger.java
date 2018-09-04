package work.mathwiki.core.logger;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.util.Log;
import android.widget.Toast;

/**
 *  日志辅助类
 * ==============================
 * 默认只启用Error 日志
 *
 * Created by s2751 on 2018/8/25 0025.
 */

public class Logger {
    private static final String APP_NAME = "Hyper-Math";
    private static final String LeftEqs = "========  ";
    private static final String RightEqs = "  ========";

    private String mModuleName;
    private static boolean DEBUG = false;
    private Logger(String moduleName){
        moduleName = moduleName;
    }

    @NonNull
    public static Logger build(String moduleName){
        return new Logger(moduleName);
    }
    public static void setDebug(boolean debug){
        DEBUG = debug;
    }

    // region Static Log
    public static void sd(String msg){
        if(DEBUG)
            Log.d(APP_NAME ,msg);
    }
    public static void sw(String msg){
        if(DEBUG)
            Log.w(APP_NAME ,msg);
    }
    public static void se(String msg){
            Log.e(APP_NAME ,msg);
    }
    public static void si(String msg){
        if(DEBUG)
            Log.i(APP_NAME ,msg);
    }

    public void d(String msg){
        if(DEBUG)
            Log.d(APP_NAME +" #"+mModuleName,msg);
    }
    // endregion


    // region Simple log
    public void e(String msg){
        Log.e(APP_NAME +" #"+mModuleName,msg);
    }

    public void i(String msg){
        if(DEBUG)
        Log.i(APP_NAME +" #"+mModuleName,msg);
    }

    public void w(String msg){
        if(DEBUG)
        Log.w(APP_NAME +" #"+mModuleName,msg);
    }
    // endregion

    // region 阶段性日志记录 Stage log
    public void dd(String msg){
        d(LeftEqs + msg +RightEqs);
    }

    public void ee(String msg){
        e(LeftEqs + msg +RightEqs);
    }

    public void ww(String msg){
        w(LeftEqs + msg +RightEqs);
    }

    public void ii(String msg){
        i(LeftEqs + msg +RightEqs);
    }
    // endregion

    public void ii_toast(Context context, String msg){
        if(DEBUG){
            ii(msg);
            Spanned spanned;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                spanned = Html.fromHtml(String.format("<div name=\"green\">%s</div>", msg),Html.FROM_HTML_MODE_COMPACT);
            }else{
                spanned = Html.fromHtml(String.format("<div name=\"green\">%s</div>", msg));
            }
            Toast.makeText(context, spanned, Toast.LENGTH_SHORT).show();
        }
    }
}