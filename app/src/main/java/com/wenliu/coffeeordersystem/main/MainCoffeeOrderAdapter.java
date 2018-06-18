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

import com.wenliu.coffeeordersystem.Constants;
import com.wenliu.coffeeordersystem.R;
import com.wenliu.coffeeordersystem.object.CoffeeOrder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainCoffeeOrderAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private MainContract.Presenter mPresenter;
    private ArrayList<CoffeeOrder> mCoffeeOrders;

    public MainCoffeeOrderAdapter(Context context, MainContract.Presenter presenter, ArrayList<CoffeeOrder> coffeeOrders) {
        mContext = context;
        mPresenter = presenter;
        mCoffeeOrders = coffeeOrders;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coffee_order_linear, parent, false);
        return new CoffeeOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {




    }

    @Override
    public int getItemCount() {
        return 7;
    }


    public class CoffeeOrderViewHolder extends RecyclerView.ViewHolder {
        //region "BindView"
        @BindView(R.id.iv_main_book_cover)
        ImageView mIvMainBookCover;
        @BindView(R.id.tv_main_title)
        TextView mTvMainTitle;
        @BindView(R.id.radioBtn_iced)
        RadioButton mRadioBtnIced;
        @BindView(R.id.radioBtn_hot)
        RadioButton mRadioBtnHot;
        @BindView(R.id.radioBtn_unread)
        RadioButton mRadioBtnUnread;
        @BindView(R.id.radioBtn_reading)
        RadioButton mRadioBtnReading;
        //endregion

        public CoffeeOrderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public ImageView getIvMainBookCover() {
            return mIvMainBookCover;
        }

        public TextView getTvMainTitle() {
            return mTvMainTitle;
        }

        public RadioButton getRadioBtnIced() {
            return mRadioBtnIced;
        }

        public RadioButton getRadioBtnHot() {
            return mRadioBtnHot;
        }

        public RadioButton getRadioBtnUnread() {
            return mRadioBtnUnread;
        }

        public RadioButton getRadioBtnReading() {
            return mRadioBtnReading;
        }
    }


    public void updateData(ArrayList<CoffeeOrder> coffeeOrders) {
        Log.d(Constants.TAG_MAIN_COFFEE_ORDER_ADAPTER, "updateData, data count= " + coffeeOrders.size());
        mCoffeeOrders = new ArrayList<>(coffeeOrders);
        notifyDataSetChanged();
    }

}
