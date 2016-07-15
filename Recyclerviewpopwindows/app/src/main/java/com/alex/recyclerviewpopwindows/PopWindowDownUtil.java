package com.alex.recyclerviewpopwindows;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

/**
 * Created by alex on 2016/7/2.
 */
public class PopWindowDownUtil {
    private View view;
    private View parentView;
    private Activity activity;
    private PopupWindow window;

    public PopWindowDownUtil(View view, View parentView, Activity activity) {
        this.view = view;
        this.parentView = parentView;
        this.activity = activity;

    }
    public void showPopupWindow() {
        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()

        int w = activity.getWindow().getDecorView().getWidth();
        window = new PopupWindow(view,
                w-400,
                100);
//        window = new PopupWindow(view,
//                WindowManager.LayoutParams.WRAP_CONTENT,
//                WindowManager.LayoutParams.WRAP_CONTENT);
        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);
//        int[] location = new int[2];
//        view.getLocationOnScreen(location);
   //     window.showAtLocation(view, Gravity.NO_GRAVITY, 0, 0);


        // 实例化一个ColorDrawable颜色为半透明

        ColorDrawable dw = new ColorDrawable(00000000);
        window.setBackgroundDrawable(dw);


        // 设置popWindow的显示和消失动画
       window.setAnimationStyle(R.style.PopupWindowAnimation);
        // 在底部显示
  //        window.showAtLocation(parentView,
//                Gravity.RIGHT, 0, 0);
        //在某控件下方显示
        window.showAsDropDown(parentView,-700,-90);
        //window.showAtLocation(parentView,Gravity.NO_GRAVITY, 0, 0);
        //（以某个View为参考）,表示弹出窗口以parent组件为参考，位于左侧，偏移-90。
        window.setOnDismissListener(new PopwindowDismissListener());
    }

    public void dismiss() {
        if(window.isShowing()){
            window.dismiss();
        }

    }


    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        activity.getWindow().setAttributes(lp);
    }

    /**
     * 添加新笔记时弹出的popWin关闭的事件,主要是为了将背景透明度改回来
     *
     * @author cg
     */
    public class PopwindowDismissListener implements PopupWindow.OnDismissListener {

        @Override
        public void onDismiss() {
            backgroundAlpha(1f);
        }

    }


}
