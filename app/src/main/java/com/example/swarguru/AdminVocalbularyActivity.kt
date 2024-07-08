package com.example.swarguru

import android.app.Activity
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.DocumentsContract
import android.provider.MediaStore
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.swarguru.DataClass.AddQuestionResponseData
import com.example.swarguru.DataClass.AddVocablaryResponse
import com.example.swarguru.databinding.ActivityAdminVocalbularyBinding
import com.squareup.picasso.Picasso
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class AdminVocalbularyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminVocalbularyBinding
    private var imagePath: String? = null
    private var audioPath: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityAdminVocalbularyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAdapter()
        setListeners()
    }

    private fun setListeners() {
        binding.cardView.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        binding.audioTV.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.type = "audio/*"
            startActivityForResult(intent, PICK_AUDIO_REQUEST)
        }

        binding.submitBTN.setOnClickListener {
            val level = binding.selectLevelTV.text.toString()
            val hindiText = binding.hindiET.text.toString()
            val englishText = binding.englishET.text.toString()
            val image = imagePath
            val audio = audioPath
            if (image != null) {
                if (audio != null) {
                    if (level.isEmpty() || hindiText.isEmpty() || englishText.isEmpty() || image.isEmpty() || audio.isEmpty()) {
                        Toast.makeText(this, "Please enter all data", Toast.LENGTH_SHORT).show()
                        Log.e(TAG, "Image or audio path is null")
                    } else {
                        uploadData(level, hindiText, englishText, image, audio)
                    }
                }
            }
        }
    }

    private fun setAdapter() {
        val levels = resources.getStringArray(R.array.level_array)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, levels
        )
        binding.selectLevelTV.setAdapter(adapter)
    }

    private fun createPartFromString(descriptionString: String): RequestBody {
        return RequestBody.create("text/plain".toMediaTypeOrNull(), descriptionString)
    }

    private fun prepareFilePart(partName: String, fileUri: String): MultipartBody.Part {
        val file = File(fileUri)
        val requestFile = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), file)
        return MultipartBody.Part.createFormData(partName, file.name, requestFile)
    }

    private fun getPathFromUri(uri: Uri): String? {
        var path: String? = null
        if (uri.scheme == "content") {
            try {
                val inputStream = contentResolver.openInputStream(uri)
                inputStream?.let {
                    val fileExtension = when (contentResolver.getType(uri)) {
                        "image/jpeg", "image/png" -> ".jpg"
                        "audio/mpeg" -> ".mp3"
                        "audio/wav" -> ".wav"
                        else -> ""
                    }
                    val file = createTempFile("tempFile", fileExtension, cacheDir)
                    file.outputStream().use { outputStream ->
                        inputStream.copyTo(outputStream)
                    }
                    path = file.absolutePath
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else if (uri.scheme == "file") {
            path = uri.path
        }
        return path
    }

    private fun clearFields() {
        binding.selectLevelTV.setText("")
        binding.hindiET.setText("")
        binding.englishET.setText("")
        binding.audioTV.text = ""
        imagePath = null
        audioPath = null
    }


    private fun uploadData(
        level: String,
        hindiText: String,
        englishText: String,
        imagePath: String,
        audioPath: String
    ) {
        val levelPart = createPartFromString(level)
        val hindiTextPart = createPartFromString(hindiText)
        val englishTextPart = createPartFromString(englishText)
        val imagePart = prepareFilePart("image", imagePath)
        val audioPart = prepareFilePart("audio", audioPath)

        val call = RetrofitClient.api.upload(
            levelPart,
            imagePart,
            hindiTextPart,
            englishTextPart,
            audioPart
        )
        call.enqueue(object : Callback<AddVocablaryResponse> {
            override fun onResponse(
                call: Call<AddVocablaryResponse>,
                response: Response<AddVocablaryResponse>
            ) {
                if (response.isSuccessful) {
                    val response = response.body()
                    println(response)
                    if (response != null) {
                        Toast.makeText(
                            this@AdminVocalbularyActivity,
                            response.message,
                            Toast.LENGTH_SHORT
                        ).show()
                        clearFields()
                    }
                } else {
                    Log.e("Error", "Response not successful: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<AddVocablaryResponse>, t: Throwable) {
                Log.e(TAG, "failed to fetch", t)
            }
        })
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri: Uri? = data.data
            selectedImageUri?.let {
                imagePath = getPathFromUri(it)
                if (imagePath != null) {
                    Picasso.get().load(File(imagePath!!)).into(binding.imageIV)
                    Log.d(TAG, "Image path: $imagePath")
                } else {
                    Toast.makeText(this, "Failed to get image path", Toast.LENGTH_SHORT).show()
                }
            }
        } else if (requestCode == PICK_AUDIO_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val selectedAudioUri: Uri? = data.data
            selectedAudioUri?.let {
                audioPath = getPathFromUri(it)
                if (audioPath != null) {
                    binding.audioTV.text = audioPath
                    Log.d(TAG, "Audio path: $audioPath")
                } else {
                    Toast.makeText(this, "Failed to get audio path", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    companion object {
        private const val PICK_IMAGE_REQUEST = 1
        private const val PICK_AUDIO_REQUEST = 2
    }
}