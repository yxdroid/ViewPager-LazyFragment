package net.yxcoding.lazyfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * User: yxfang
 * Date: 2016-07-13
 * Time: 10:02
 * ------------- Description -------------
 * 定义懒加载Fragment 基类，用来实现懒加载算法
 * ---------------------------------------
 */
public abstract class LazyFragment extends BaseFragment
{
    // 当前Fragment 是否可见
    protected boolean isVisible = false;
    // 是否加载过数据
    protected boolean isLoadData = false;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser)
    {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisible = isVisibleToUser;
        preLoadData(false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        this.isViewInit = true;
        // 防止一开始加载的时候未 调用 preLoadData 方法， 因为setUserVisibleHint 比 onActivityCreated 触发 前
        if (getUserVisibleHint())
        {
            preLoadData(false);
        }
    }

    /**
     * 子类加载数据
     */
    protected abstract void loadData();

    /**
     * 当UI初始化成功，UI可见并且没有加载过数据的时候 加载数据
     *
     * @param forceLoad 强制加载数据
     */
    public void preLoadData(boolean forceLoad)
    {
        if (isViewInit && isVisible && (!isLoadData || forceLoad))
        {
            loadData();
            isLoadData = true;
        }
    }
}
