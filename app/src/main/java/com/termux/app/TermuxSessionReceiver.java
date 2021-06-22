package com.termux.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.termux.app.terminal.TermuxTerminalSessionClient;

class TermuxSessionReceiver extends BroadcastReceiver {
    TermuxTerminalSessionClient mTerminalSessionClient;

    @Override
    public void onReceive(Context context, Intent intent) {
        final String  session_name = intent.getStringExtra("sess_name");
        final boolean fail_safe    = intent.getBooleanExtra("fail_safe", false);
        
        mTerminalSessionClient.addNewSession(fail_safe, session_name);
    }
}