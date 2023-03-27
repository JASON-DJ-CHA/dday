
package com.jason.example.ddayapplication

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnEnd = findViewById<Button>(R.id.btnEnd)

        var startDate = ""
        var endDate = ""

        val calendar_start = Calendar.getInstance()
        val calendar_end = Calendar.getInstance()

        btnStart.setOnClickListener{
            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    startDate = year.toString() + (month+1).toString() + dayOfMonth.toString()

                    calendar_start.set(year, month+1, dayOfMonth)
                        //"${year} + ${month+1} + ${dayOfMonth}"
                    Log.d("date",startDate)
                    Log.d("date2",calendar_start.timeInMillis.toString())


                }

            }, year, month, day)
            dlg.show()
        }

        btnEnd.setOnClickListener {
            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    endDate = year.toString() + (month+1).toString() + dayOfMonth.toString()
                    Log.d("date",endDate)

                    calendar_end.set(year, month+1, dayOfMonth)
                    Log.d("date2",calendar_end.timeInMillis.toString())

                    val finalDate = TimeUnit.MILLISECONDS.toDays( calendar_end.timeInMillis - calendar_start.timeInMillis).toString()
                    Log.d("date", finalDate)

                    findViewById<TextView>(R.id.tvDday).setText(finalDate)
                }

            }, year, month, day)
            dlg.show()
        }
    }
}