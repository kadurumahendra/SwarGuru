package com.example.swarguru

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.swarguru.DataClass.AddQuestionData
import com.example.swarguru.DataClass.AddQuestionResponseData
import com.example.swarguru.databinding.ActivityAdminQuizBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdminQuizActivity : AppCompatActivity() {

    private lateinit var binding:ActivityAdminQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAdminQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAdapter()
        setListeners()
    }

    private fun setAdapter() {
        val levels = resources.getStringArray(R.array.level_array)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, levels
        )
        binding.selectLevelTV.setAdapter(adapter)
    }

    private fun setListeners() {
        binding.submitBTN.setOnClickListener {
            val level = binding.selectLevelTV.text.toString()
            val question = binding.questionEditText.text.toString()
            val option1 = binding.option1.text.toString()
            val option2 = binding.option2.text.toString()
            val option3 = binding.option3.text.toString()
            val correctAnswer = binding.correctET.text.toString()

            if (level.isEmpty() || question.isEmpty() || option1.isEmpty() || option2.isEmpty() || option3.isEmpty() || correctAnswer.isEmpty()) {
                Toast.makeText(this, "Please enter all data", Toast.LENGTH_SHORT).show()
            } else {
                val questionData = AddQuestionData(level, question, option1, option2, option3, correctAnswer)
                uploadQuestion(questionData)
            }
        }
    }

    private fun clearFields() {
        binding.selectLevelTV.setText("")
        binding.questionEditText.setText("")
        binding.option1.setText("")
        binding.option2.setText("")
        binding.option3.setText("")
        binding.correctET.setText("")
    }

    private fun uploadQuestion(data: AddQuestionData) {
        val call = RetrofitClient.api.sendData(data)

        call.enqueue(object : Callback<AddQuestionResponseData> {
            override fun onResponse(
                call: Call<AddQuestionResponseData>,
                response: Response<AddQuestionResponseData>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        Toast.makeText(
                            this@AdminQuizActivity,
                            responseBody.message,
                            Toast.LENGTH_SHORT
                        ).show()
                        clearFields()
                    }
                } else {
                    Log.e("Error", "Response not successful: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<AddQuestionResponseData>, t: Throwable) {
                Log.e(TAG, "failed to fetch", t )
            }

        })
    }
}