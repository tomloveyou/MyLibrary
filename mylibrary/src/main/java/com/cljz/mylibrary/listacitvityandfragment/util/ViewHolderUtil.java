package com.cljz.mylibrary.listacitvityandfragment.util;

import android.util.SparseArray;
import android.view.View;

/**
 * Created by lrc on 2016/7/22.
 */
public class ViewHolderUtil {

    public static <T extends View> T getViewHolder(View view, int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        if (viewHolder == null) {
            viewHolder = new SparseArray<View>();
            view.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }
}
