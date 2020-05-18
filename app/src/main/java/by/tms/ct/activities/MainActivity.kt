package by.tms.ct.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import by.tms.ct.R
import by.tms.ct.infoActivities.InfoActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton.setOnClickListener(this)
        infoButton.setOnClickListener(this)

        val adRequest  = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        MobileAds.initialize(this)

    }




    override fun onClick(v: View?) {

        when(v?.id){
            startButton.id-> startActivity(Intent(this, SubjectsActivity::class.java))
            infoButton.id-> startActivity(Intent(this, InfoActivity::class.java))
        }
    }

}
