package com.wenliu.coffeeordersystem.orderlist;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wenliu.coffeeordersystem.CoffeeOrderSystem;
import com.wenliu.coffeeordersystem.R;
import com.wenliu.coffeeordersystem.object.CoffeeOrder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderListFragment extends Fragment implements OrderListContract.View {

    @BindView(R.id.rv_coffee_order_list)
    RecyclerView mRvCoffeeOrderList;
    Unbinder unbinder;

    private OrderListContract.Presenter mPresenter;
    private OrderListAdapter mOrderListAdapter;
    private ArrayList<CoffeeOrder> mCoffeeOrders = new ArrayList<>();


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
        unbinder = ButterKnife.bind(this, layout);
        setRecyclerView();
        return layout;
    }

    private void setRecyclerView() {
        mOrderListAdapter = new OrderListAdapter(getContext(), mPresenter, mCoffeeOrders);
        mRvCoffeeOrderList.setLayoutManager(new LinearLayoutManager(CoffeeOrderSystem.getAppContext()));
        mRvCoffeeOrderList.setAdapter(mOrderListAdapter);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setPresenter(OrderListContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showCoffeeOrders(ArrayList<CoffeeOrder> coffeeOrders) {
        mOrderListAdapter.updateData(coffeeOrders);
    }
}
