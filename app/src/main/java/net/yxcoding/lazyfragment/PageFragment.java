package net.yxcoding.lazyfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * User: yxfang
 * Date: 2016-07-13
 * Time: 10:06
 * ------------- Description -------------
 * 子页面Fragment实例
 * ---------------------------------------
 */
public class PageFragment extends LazyFragment
{
    private View rootView;
    private TextView tvName;

    private String name;

    /**
     * 实例化一个子类页面
     *
     * @param name
     * @return
     */
    public static PageFragment newInstance(String name)
    {
        PageFragment fragment = new PageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        if (rootView != null)
        {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent)
            {
                parent.removeView(rootView);
            }
        }
        else
        {
            rootView = inflater.inflate(R.layout.fragment_page, container, false);
            tvName = (TextView) rootView.findViewById(R.id.tv_name);
        }
        Log.d("PageFragment", "onCreateView");
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        Bundle bundle = getArguments();
        name = bundle.getString("name");
        tvName.setText(name);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected void loadData()
    {
        Log.d("PageFragment", name + " 加载数据");
    }
}
