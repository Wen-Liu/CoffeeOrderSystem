package com.wenliu.coffeeordersystem.orderlist;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wenliu.coffeeordersystem.Constants;
import com.wenliu.coffeeordersystem.R;
import com.wenliu.coffeeordersystem.object.CoffeeType;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderListFragment extends Fragment implements OrderListContract.View {

    private OrderListContract.Presenter mPresenter;



    public OrderListFragment() {
        // Required empty public constructor
    }

    public static OrderListFragment newInstance() {
        return new OrderListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View layout = inflater.inflate(R.layout.fragment_order_list, container, false);
        setRecyclerView();
        return layout;
    }

    private void setRecyclerView() {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.start();
    }

    @Override
    public void setPresenter(OrderListContract.Presenter presenter) {
        mPresenter = presenter;
    }



}
