package com.wenliu.coffeeordersystem.api;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.wenliu.coffeeordersystem.Constants;
import com.wenliu.coffeeordersystem.Utils;
import com.wenliu.coffeeordersystem.object.CoffeeItem;
import com.wenliu.coffeeordersystem.object.CoffeeOrder;

import java.util.ArrayList;

public class FirebaseApiHelper {

    private static final FirebaseApiHelper instance = new FirebaseApiHelper();
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mGetRef = mDatabase.getReference();

    public static FirebaseApiHelper getInstance() {
        return instance;
    }

    public void getCoffeeItem(final GetCoffeeItemCallback callback) {
        Log.d(Constants.TAG_FIREBASE_API_HELPER, "getCoffeeItem: ");

        Query coffeeItemQuery = mGetRef.child(Constants.FIREBASE_NODE_ITEMS);
        coffeeItemQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                ArrayList<CoffeeItem> coffeeItems = new ArrayList<>();
                if (dataSnapshot.exists()) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        CoffeeItem coffeeItem = snapshot.getValue(CoffeeItem.class);
                        coffeeItems.add(coffeeItem);
                    }

                    Log.d(Constants.TAG_FIREBASE_API_HELPER, "dataSnapshot.exists()");
                    callback.onCompleted(coffeeItems);

                } else {
                    callback.onError("error");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void uploadOrderData(final CoffeeOrder coffeeOrder) {
        Log.d(Constants.TAG_FIREBASE_API_HELPER, "uploadOrderData: ");

        String orderNumber = createOrderNumber(Utils.getCreatedTime(coffeeOrder.getTime()) + "001", new CreateOrderNumberCallback() {
            @Override
            public void onCompleted(String orderNumber) {
                mGetRef.child(Constants.FIREBASE_NODE_ORDERS).child(orderNumber).setValue(coffeeOrder);
            }

            @Override
            public void onError(String error) {

            }
        });
    }



    private String createOrderNumber(final String time, final CreateOrderNumberCallback callback) {
        Log.d(Constants.TAG_FIREBASE_API_HELPER, "getLatestOrderNumber: ");

        Query coffeeOrderQuery = mGetRef.child(Constants.FIREBASE_NODE_ORDERS).orderByKey().limitToLast(1);
        
        coffeeOrderQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        String latestOrderNumber = snapshot.getKey();
                        String orderNumberString;

                        if (Integer.valueOf(latestOrderNumber) >= Integer.valueOf(time)) {
                            int orderNumber = Integer.valueOf(latestOrderNumber) + 1;
                            orderNumberString =  String.valueOf(orderNumber);
                        } else {
                            orderNumberString = String.valueOf(time);
                        }
                        callback.onCompleted(orderNumberString);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return time;
    }
}
