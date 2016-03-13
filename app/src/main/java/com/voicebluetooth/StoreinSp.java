package com.voicebluetooth;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Sreejith Kilmadi on 3/13/2016.
 */
public class StoreinSp {


    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "voice_bt";

    // Constructor
    public StoreinSp(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void storeinSp(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public String getStoredDate(String key) {
        String value = null;
        value = pref.getString(key, null);
        return value;
    }

    public void deleteStoredData(){
        editor.clear();
        editor.commit();

    }

    public void deleteKeyValue(String key){
        editor.remove(key);
        // editor.apply();
        editor.commit();
    }



}
