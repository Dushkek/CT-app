package by.tms.ct.infoActivities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import by.tms.ct.R
import kotlinx.android.synthetic.main.info_layout.*

class InfoActivity :AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_layout)

        ctInCities.setOnClickListener(this)
        numberOfTasks.setOnClickListener(this)
    }


    override fun onClick(v: View?) {

        when(v?.id){
            ctInCities.id-> startActivity(Intent(this, CtInCitiesActivity::class.java))
            numberOfTasks.id-> startActivity(Intent(this, NumberOfTaskActivity::class.java))
        }
    }
}