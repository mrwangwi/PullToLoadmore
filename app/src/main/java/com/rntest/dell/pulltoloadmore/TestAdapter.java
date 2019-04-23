package com.rntest.dell.pulltoloadmore;

import android.support.annotation.Nullable;

import com.mrwangwei.pullloadmore.BaseQuickAdapter;
import com.mrwangwei.pullloadmore.BaseViewHolder;

import java.util.List;

/**
 *
 */
public class TestAdapter extends BaseQuickAdapter<TestBean, BaseViewHolder> {

    public TestAdapter(int layoutResId, @Nullable List<TestBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TestBean item) {
        helper.setText(R.id.tv_left, helper.getPosition() + "");
    }
}
