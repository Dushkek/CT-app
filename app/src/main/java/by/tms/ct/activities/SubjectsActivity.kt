package by.tms.ct.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import by.tms.ct.R
import kotlinx.android.synthetic.main.subject_layout.*

class SubjectsActivity:AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v?.id){
            subjectRusLang.id->startActivity(Intent(this, TestLayout::class.java))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.subject_layout)

        subjectRusLang.setOnClickListener(this)


    }



}