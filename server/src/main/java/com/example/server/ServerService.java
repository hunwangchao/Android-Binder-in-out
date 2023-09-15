package com.example.server;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

import IInterface.Feedback;
import IInterface.IPerformTask;
import IInterface.VerificationData;


public class ServerService extends Service {

    private Binder mBinder;

    @Override
    public IBinder onBind(Intent intent) {
        mBinder = new IPerformTask.Stub() {
            @Override
            public void performVerify(VerificationData data, Feedback feedback) throws RemoteException {
                if(data.age > 30 || data.degree.equals("bachelor")) {
                    feedback.isPass = false;
                } else {
                    feedback.isPass = true;
                    data.name = "chawan";
                    feedback.cookie = "Congratulation , welcome to join us !";
                }
            }
        };
        return  mBinder;
    }
}