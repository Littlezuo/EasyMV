package com.jaydenxiao.common.basemvvm;

//import com.jaydenxiao.common.baseevent.rxbus.RxBus;

import android.widget.ImageView;

/**
 * Created by Littlezuo on 2017/5/17.
 * 传该类作为泛型需手动注册rxbus(@BindBus)
 *
 */

public class SlideViewModel extends ViewModel {
//    public static boolean isErr = false;
   public ImageView iv_right;
    public ImageView iv_left;
    public String slide_title;
}
