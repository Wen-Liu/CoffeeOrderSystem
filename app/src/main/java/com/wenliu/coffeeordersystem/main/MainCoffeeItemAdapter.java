package com.wenliu.coffeeordersystem.main;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.bumptech.glide.Glide;
import com.wenliu.coffeeordersystem.CoffeeOrderSystem;
import com.wenliu.coffeeordersystem.Constants;
import com.wenliu.coffeeordersystem.R;
import com.wenliu.coffeeordersystem.object.CoffeeItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainCoffeeItemAdapter extends RecyclerView.Adapter {

    private MainContract.Presenter mPresenter;
    private ArrayList<CoffeeItem> mCoffeeItems;
    private Context mContext;

    public MainCoffeeItemAdapter(Context context, MainContract.Presenter presenter, ArrayList<CoffeeItem> coffeeItems) {
        Log.d(Constants.TAG_MAIN_COFFEE_ITEM_ADAPTER, "MainCoffeeItemAdapter: ");
        mContext = context;
        mPresenter = presenter;
        mCoffeeItems = coffeeItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coffee_item_grid, parent, false);
        return new CoffeeItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Glide.with(mContext)
                .load(mCoffeeItems.get(position).getImage())
                .into(((CoffeeItemViewHolder) holder).getIbtnAdapterCoffeeItem());
//        mImageManager.loadImageUrl(mBookCustomInfos.get(position).getImage(), ((MainViewHolder) holder).getImVMainBookCover());
    }

    @Override
    public int getItemCount() {
        return mCoffeeItems.size();
    }

    public class CoffeeItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ibtn_adapter_coffee_item)
        ImageButton mIbtnAdapterCoffeeItem;

        public CoffeeItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @OnClick({R.id.ibtn_adapter_coffee_item})
        public void onViewClicked(View view) {
            switch (view.getId()) {
                case R.id.ibtn_adapter_coffee_item:
                    Log.d(Constants.TAG_MAIN_COFFEE_ITEM_ADAPTER, "TAG_MAIN_COFFEE_ITEM_ADAPTER Clicked position: " + getAdapterPosition());

                    break;
            }
        }

        public ImageButton getIbtnAdapterCoffeeItem() {
            return mIbtnAdapterCoffeeItem;
        }
    }


    public void updateData(ArrayList<CoffeeItem> coffeeItems) {
        Log.d(Constants.TAG_MAIN_COFFEE_ITEM_ADAPTER, "updateData, data count= " + coffeeItems.size());
        mCoffeeItems = new ArrayList<>(coffeeItems);
        notifyDataSetChanged();
    }

}
