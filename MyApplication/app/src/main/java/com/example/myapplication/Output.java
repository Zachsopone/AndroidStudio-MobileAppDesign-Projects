package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class Output {
    SharedPreferences sharedData;
    public  SharedPreferences.Editor editor;
    public Context context;
    int modifier=0;

    private static final String print="Login";
    private static final String login="isLogin";
    public static final String fname="Firstname";
    public static final String lname="Lastname";

    public Output(Context context){
        this.context=context;
        sharedData = context.getSharedPreferences(print,modifier);
        editor = sharedData.edit();
    }
    public void declareOutput(String firstName, String lastName){
        editor.putBoolean(login,true);
        editor.putString(fname,firstName);
        editor.putString(lname, lastName);
        editor.apply();
    }
    public boolean loginState(){
        return sharedData.getBoolean(login, false);
    }
    public void loadLogin(){
        if(!this.loginState()){
            Intent intent=new Intent(context,Activity4.class);
            context.startActivity(intent);
            ((Activity5)context).finish();
        }
    }
    public HashMap<String, String> getData() {
        HashMap<String, String> map = new HashMap<>();
        map.put(fname, sharedData.getString(fname,null));
        map.put(lname, sharedData.getString(lname, null));
        return map;
    }
    public void logout(){
        editor.clear();
        editor.commit();
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
        ((Activity5)context).finish();
    }
}
