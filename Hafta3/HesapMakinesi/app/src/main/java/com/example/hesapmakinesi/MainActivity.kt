package com.example.hesapmakinesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.hesapmakinesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val sb = StringBuilder()
    private var leftOperand = 0
    private var rightOperand = 0
    private var sumResult = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainActivityObject = this
    }

    fun buttonNumClick(num: String) {
        sb.append(num)
        binding.textViewResult.text = sb.toString()
    }

    fun buttonResetClick() {
        sb.clear()
        leftOperand = 0
        rightOperand = 0
        binding.textViewOperation.text = ""
        binding.textViewResult.text = "0"
    }

    fun buttonAddClick() {
        leftOperand = Integer.parseInt(binding.textViewResult.text.toString())
        binding.textViewOperation.text = "$leftOperand + "
        sb.clear()
    }

    fun buttonResultClick() {
        rightOperand = Integer.parseInt(binding.textViewResult.text.toString())
        sumResult = leftOperand + rightOperand
        binding.textViewResult.text = sumResult.toString()
        binding.textViewOperation.text = "$leftOperand + $rightOperand ="
    }
}