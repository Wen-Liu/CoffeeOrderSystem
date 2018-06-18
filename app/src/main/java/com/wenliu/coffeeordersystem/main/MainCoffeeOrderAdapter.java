package com.wenliu.coffeeordersystem.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wenliu.coffeeordersystem.Constants;
import com.wenliu.coffeeordersystem.R;
import com.wenliu.coffeeordersystem.object.CoffeeOrder;
import com.wenliu.coffeeordersystem.object.CoffeeType;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainCoffeeOrderAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private MainContract.Presenter mPresenter;
    private ArrayList<CoffeeType> mCoffeeTypes;

    public MainCoffeeOrderAdapter(Context context, MainContract.Presenter presenter, ArrayList<CoffeeType> coffeeTypes) {
        mContext = context;
        mPresenter = presenter;
        mCoffeeTypes = new ArrayList<>(coffeeTypes);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coffee_order_linear, parent, false);
        return new CoffeeOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Glide.with(mContext)
                .load(mCoffeeTypes.get(position).getImage())
                .into(((CoffeeOrderViewHolder) holder).getIvAdapterOrderCoffeeImage());

        ((CoffeeOrderViewHolder) holder).getTvMainTitle().setText(mCoffeeTypes.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return mCoffeeTypes.size();
    }

    @OnClick({R.id.radioBtn_sugar, R.id.radioBtn_no_sugar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.radioBtn_sugar:
                break;
            case R.id.radioBtn_no_sugar:
                break;
        }
    }


    public class CoffeeOrderViewHolder extends RecyclerView.ViewHolder {
        //region "BindView"
        @BindView(R.id.iv_adapter_order_coffee_image)
        ImageView mIvAdapterOrderCoffeeImage;
        @BindView(R.id.tv_main_title)
        TextView mTvMainTitle;
        @BindView(R.id.radioBtn_iced)
        RadioButton mRadioBtnIced;
        @BindView(R.id.radioBtn_hot)
        RadioButton mRadioBtnHot;
        @BindView(R.id.radioBtn_sugar)
        RadioButton mRadioBtnSugar;
        @BindView(R.id.radioBtn_no_sugar)
        RadioButton mRadioBtnNoSugar;

        //endregion

        public CoffeeOrderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @OnClick({R.id.radioBtn_iced, R.id.radioBtn_hot, R.id.radioBtn_sugar, R.id.radioBtn_no_sugar})
        public void onViewClicked(View view) {
            switch (view.getId()) {
                case R.id.radioBtn_iced:
                    mCoffeeTypes.get(getAdapterPosition()).setIced(true);
                    break;

                case R.id.radioBtn_hot:
                    mCoffeeTypes.get(getAdapterPosition()).setIced(false);
                    break;

                case R.id.radioBtn_sugar:
                    mCoffeeTypes.get(getAdapterPosition()).setSugar(true);
                    break;

                case R.id.radioBtn_no_sugar:
                    mCoffeeTypes.get(getAdapterPosition()).setSugar(false);
                    break;
            }
        }


        public ImageView getIvAdapterOrderCoffeeImage() {
            return mIvAdapterOrderCoffeeImage;
        }

        public TextView getTvMainTitle() {
            return mTvMainTitle;
        }

    }


    public CoffeeOrder getOrderData() {
        CoffeeOrder coffeeOrder = new CoffeeOrder();
        coffeeOrder.setContent(mCoffeeTypes);
        return coffeeOrder;
    }

    public void updateData(ArrayList<CoffeeType> coffeeTypes) {
        Log.d(Constants.TAG_MAIN_COFFEE_ORDER_ADAPTER, "updateData, data count= " + coffeeTypes.size());
        mCoffeeTypes = new ArrayList<>(coffeeTypes);
        Collections.reverse(mCoffeeTypes);
        notifyDataSetChanged();
    }

}
