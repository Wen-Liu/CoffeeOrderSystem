package com.wenliu.coffeeordersystem.main;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wenliu.coffeeordersystem.CoffeeOrderSystem;
import com.wenliu.coffeeordersystem.Constants;
import com.wenliu.coffeeordersystem.R;
import com.wenliu.coffeeordersystem.object.CoffeeItem;
import com.wenliu.coffeeordersystem.object.CoffeeType;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements MainContract.View {

    @BindView(R.id.rv_main_coffee_item)
    RecyclerView mRvMainCoffeeItem;
    @BindView(R.id.rv_main_coffee_order)
    RecyclerView mRvMainCoffeeOrder;
    Unbinder unbinder;
    @BindView(R.id.tv_main_confirm)
    TextView mTvMainConfirm;

    private MainContract.Presenter mPresenter;
    private MainCoffeeItemAdapter mMainCoffeeItemAdapter;
    private MainCoffeeOrderAdapter mMainCoffeeOrderAdapter;
    private ArrayList<CoffeeItem> mCoffeeItems = new ArrayList<>();
    private ArrayList<CoffeeType> mCoffeeTypes = new ArrayList<>();
    private com.wenliu.coffeeordersystem.object.CoffeeOrder mCoffeeOrder;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(Constants.TAG_MAIN_FRAGMENT, "onCreateView: ");
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, layout);
        setRecyclerView();

        return layout;
    }

    private void setRecyclerView() {
        mMainCoffeeItemAdapter = new MainCoffeeItemAdapter(getContext(), mPresenter, mCoffeeItems);

//        int spanCount = 3;
//        int spacing = Math.round(4 * getResources().getDisplayMetrics().density); // 50p
//        boolean includeEdge = false;
//        mRvMainCoffeeItem.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        mRvMainCoffeeItem.setLayoutManager(new GridLayoutManager(CoffeeOrderSystem.getAppContext(), 4));
        mRvMainCoffeeItem.setAdapter(mMainCoffeeItemAdapter);

        mMainCoffeeOrderAdapter = new MainCoffeeOrderAdapter(getContext(), mPresenter, mCoffeeTypes);
        mRvMainCoffeeOrder.setLayoutManager(new LinearLayoutManager(CoffeeOrderSystem.getAppContext()));
        mRvMainCoffeeOrder.setAdapter(mMainCoffeeOrderAdapter);
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
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showCoffeeItems(ArrayList<CoffeeItem> coffeeItems) {
        Log.d(Constants.TAG_MAIN_FRAGMENT, "showCoffeeItems: ");
        mMainCoffeeItemAdapter.updateData(coffeeItems);
    }

    @Override
    public void showCoffeeOrders(CoffeeItem coffeeItem) {
        Log.d(Constants.TAG_MAIN_FRAGMENT, "showCoffeeOrders: ");
        mCoffeeTypes.add(new CoffeeType(coffeeItem));
        mMainCoffeeOrderAdapter.updateData(mCoffeeTypes);
    }

    @OnClick(R.id.tv_main_confirm)
    public void onViewClicked() {
        mCoffeeOrder = mMainCoffeeOrderAdapter.getOrderData();
        mPresenter.uploadOrderData(mCoffeeOrder);

    }
}
