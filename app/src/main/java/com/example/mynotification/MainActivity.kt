package com.example.mynotification

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.mynotification.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.content, TestFragment()).commit()
        createNotification()
      //  binding.submitButton.setOnClickListener{scheduleNotification()}
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotification() {
        val name = "Notif Channel"
        val desc = "A description of the Channel"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelID, name, importance)
        channel.description = desc

        // Set notification sound

        channel.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION), null)
        channel.enableVibration(true)
        channel.enableLights(true)
        channel.lightColor = Color.RED
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)

    }

  //  @RequiresApi(Build.VERSION_CODES.M)
 //   private fun scheduleNotification() {
//        val intent = Intent(this, Notification::class.java)
//        val title = binding.titleET.text.toString()
//        val message = binding.messageET.text.toString()
//        intent.putExtra(titleExtra, title)
//        intent.putExtra(messageExtra, message)
//        intent.putExtra("activity", MainActivity::class.java)
//
//        val pendingIntent = PendingIntent.getBroadcast(
//            applicationContext,
//            notificationID,
//            intent,
//            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
//        )
//        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
//        val time = getTime()
//        applicationContext.checkCallingOrSelfPermission("SCHEDULE_EXACT_ALARM")
//        alarmManager.setExactAndAllowWhileIdle(
//            AlarmManager.RTC_WAKEUP,
//            time,
//            pendingIntent
//        )
//        showAlert(time, title, message)
//    }
//
//    private fun showAlert(time: Long, title: String, message: String) {
//
//        val date = Date(time)
//        val dateFormat = android.text.format.DateFormat.getLongDateFormat(applicationContext)
//        val timeFormat = android.text.format.DateFormat.getTimeFormat(applicationContext)
//
//        AlertDialog.Builder(this)
//            .setTitle("Notification Scheuled")
//            .setMessage(
//                "Title: " + title +
//                        "\nMessage: " + message +
//                        "\nAt: " + dateFormat.format(date) + " " + timeFormat.format(date)
//            )
//            .setPositiveButton("Okay"){_,_ ->}
//            .show()
//    }
//
//    @RequiresApi(Build.VERSION_CODES.M)
//    private fun getTime(): Long {
//        val minute = binding.timePicker.minute
//        val hour = binding.timePicker.hour
//        val day = binding.datePicker.dayOfMonth
//        val month = binding.datePicker.month
//        val year = binding.datePicker.year
//
//        val calendar = Calendar.getInstance()
//        calendar.set(year, month,day,hour,minute)
//        return calendar.timeInMillis
//
//    }
}