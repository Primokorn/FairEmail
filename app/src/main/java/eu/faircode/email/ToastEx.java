package eu.faircode.email;

import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ToastEx extends Toast {
    public ToastEx(Context context) {
        super(context);
    }

    public static Toast makeText(Context context, int resId, int duration) throws Resources.NotFoundException {
        return makeText(context, context.getText(resId), duration);
    }

    public static Toast makeText(Context context, CharSequence text, int duration) {
        ToastEx toast = new ToastEx(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.toast, null);
        TextView tv = view.findViewById(android.R.id.message);
        tv.setText(text);
        toast.setView(view);
        toast.setDuration(duration);
        // <dimen name="design_bottom_navigation_height">56dp</dimen>
        int dp = Helper.dp2pixels(context, 2 * 56);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, dp);
        return toast;
    }
}
