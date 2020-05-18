package by.tms.ct.activities

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.forEach
import androidx.core.view.get
import by.tms.ct.R
import by.tms.ct.fragments.FragmentTaskForAanswers
import by.tms.ct.fragments.FragmentTaskForBanswers
import by.tms.ct.retrofit.CTAPIFactory
import kotlinx.android.synthetic.main.fragment_taskfora_layout.*
import kotlinx.android.synthetic.main.fragment_taskforb_layout.*
import kotlinx.android.synthetic.main.test_layout.*
import kotlinx.coroutines.*

class TestLayout : AppCompatActivity(), AdapterView.OnItemClickListener{

    private val fragmentForA = FragmentTaskForAanswers()
    private val fragmentForB = FragmentTaskForBanswers()
    private val numOfTask = ArrayList<String>()
    private val tasks = ArrayList<String>()
    private val firstans = ArrayList<String>()
    private val sec = ArrayList<String>()
    private val third = ArrayList<String>()
    private val fourth = ArrayList<String>()
    private val fifth = ArrayList<String>()
    val bAnswersList= arrayOf("B1","B2","B3","B4","B5","B6","B7","B8","B9","B10","A10")
    val rightAnswers = ArrayList<String>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_layout)


        CoroutineScope(Dispatchers.IO).launch {
            val response = CTAPIFactory.getRetrofit().getRussianLangeageTest(100,"created").await()
            if (response.isSuccessful) {
                val ct = response.body()

                ct?.forEach {
                    numOfTask.add(it.taskNumber)
                    tasks.add(it.task)
                    firstans.add(it.answer1)
                    sec.add(it.answer2)
                    third.add(it.answer3)
                    fourth.add(it.answer4)
                    fifth.add(it.answer5)
                    rightAnswers.add(it.rightAnswer)
                }

                withContext(Dispatchers.Main){
                    val adapter = ArrayAdapter<String>(this@TestLayout,
                        R.layout.task_navigation_item,numOfTask)
                    gridViewWidget.adapter = adapter
                    gridViewWidget.onItemClickListener = this@TestLayout

                }
            }
        }





    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

//        var result: List<String> = rightAnswers[position].split(",").map { it.trim() }


        if(gridViewWidget[position].isInTouchMode){
            gridViewWidget.forEach {
                it.setBackgroundResource(R.drawable.navigation_item_background)
            }
            gridViewWidget[position].setBackgroundColor(ContextCompat.getColor(this,
                R.color.selectedGreenColour
            ))
        }



        when(numOfTask[position]){
            in bAnswersList-> {

                taskForBTextView?.text = tasks[position]
                supportFragmentManager.beginTransaction()
                    .replace(R.id.landscapeFragment, fragmentForB)
                    .commit()
            }
            else-> {

                taskForATextView?.text = tasks[position]
                firstAnswerTextView?.text = firstans[position]
                secondAnswerTextView?.text = sec[position]
                thirdAnswerTextView?.text = third[position]
                fourthAnswerTextView?.text = fourth[position]
                fifthAnswerTextView?.text = fifth[position]
                supportFragmentManager.beginTransaction()
                    .replace(R.id.landscapeFragment, fragmentForA)
                    .commit()
            }

        }


    }



}

