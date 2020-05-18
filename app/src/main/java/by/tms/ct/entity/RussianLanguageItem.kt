package by.tms.ct.entity


import com.google.gson.annotations.SerializedName

data class RussianLanguageItem(
    @SerializedName("answer_1")
    val answer1: String,
    @SerializedName("answer_2")
    val answer2: String,
    @SerializedName("answer_3")
    val answer3: String,
    @SerializedName("answer_4")
    val answer4: String,
    @SerializedName("answer_5")
    val answer5: String,
    @SerializedName("created")
    val created: Long,
    @SerializedName("Right_answer")
    val rightAnswer: String,
    @SerializedName("Task")
    val task: String,
    @SerializedName("Task_Number")
    val taskNumber: String
)