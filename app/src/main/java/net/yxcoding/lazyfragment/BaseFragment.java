package net.yxcoding.lazyfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * User: yxfang
 * Date: 2016-07-13
 * Time: 10:02
 * ------------- Description -------------
 * 基类Fragment，定义全局的Fragment父类
 * ---------------------------------------
 */
public class BaseFragment extends Fragment
{
    // 标识view 是否初始化完成
    protected boolean isViewInit = false;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }
}
