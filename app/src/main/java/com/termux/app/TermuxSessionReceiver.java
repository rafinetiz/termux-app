package com.termux.app;

import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;

import com.termux.app.TermuxActivity;
import com.termux.app.terminal.TermuxTerminalSessionClient;

class TerminalSessionReceiver extends BroadcastReceiver {
    TermuxActivity termuxActivity;
    TermuxTerminalSessionClient mTermuxSessionClient;

    @Override
    public void onReceive(Context context, Intent intent) {
        final String session_name = intent.getStringExtra("sess_name");
        final boolean fail_safe   = intent.getBooleanExtra("fail_safe", false);

        termuxActivity = ((TermuxActivity) context.getApplicationContext()).getCurrentActivity();
        mTermuxSessionClient = new TermuxTerminalSessionClient(termuxActivity);

        mTermuxSessionClient.addNewSession(fail_safe, session_name);
    }
}