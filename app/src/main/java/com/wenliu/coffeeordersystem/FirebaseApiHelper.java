package com.wenliu.coffeeordersystem;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONObject;

public class FirebaseApiHelper {

    private static final FirebaseApiHelper instance = new FirebaseApiHelper();
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mGetRef = mDatabase.getReference();

    public static FirebaseApiHelper getInstance() {
        return instance;
    }



    public void uploadUser() {
        Log.d(Constants.TAG_FIREBASE_API_HELPER, "uploadUser");

        mGetRef.push();

    }


}
