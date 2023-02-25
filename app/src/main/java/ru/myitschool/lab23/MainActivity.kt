package ru.myitschool.lab23

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.myitschool.lab23.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dateString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.content.calendarView.setOnDateChangeListener { calendarView, i, i2, i3 ->
            // собираем строку из i, i2, i3
            // "$i.$i2.$i3" => "11.12.2022"
            dateString = "$i.$i2.$i3"
        }

        binding.content.save.setOnClickListener {
            val dialog = MyDialog()
            val bundle = Bundle()
            bundle.putString("dateString", dateString)
            bundle.putString("edit1", binding.content.editTextTextPersonName.text.toString())
            dialog.arguments = bundle
            dialog.show(supportFragmentManager,null)


        }
    }
}