package ro.pub.cs.systems.eim.practicaltest01var06


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class SomeEventBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val message = intent.getStringExtra("message")

        Log.d("EIM", "Am primit: $message")

        // val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT) // in Activity
        // toast.show()
    }

    // adb shell "am broadcast -a ro.pub.cs.systems.eim.practicaltest01var06.MESSAGE -p ro.pub.cs.systems.eim.practicaltest01var06 --es message 'Bine ai venit la EIM'"
}
