package br.com.digitalhouse.roomdatabaseapp.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import br.com.digitalhouse.roomdatabaseapp.ContatosActivity;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED) ||
                intent.getAction().equals(Intent.ACTION_LOCKED_BOOT_COMPLETED)) {
            Intent startIntent = new Intent(context, ContatosActivity.class);
            startIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(startIntent);
        }
    }
}
