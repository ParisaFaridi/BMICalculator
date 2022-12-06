package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculateBmi.setOnClickListener {
            val intent = Intent(this,BMIActivity::class.java)
            startActivity(intent)
        }
        binding.btnAboutUs.setOnClickListener {
            AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_baseline_bookmark_24)
                .setTitle("درباره ما")
                .setMessage("این سومین پروژه از سایت آموزشی ماست")
                .show()
        }
        binding.btnExit.setOnClickListener {
            showExitDialog("می خوای بری؟")
        }
    }

    override fun onBackPressed() {
        showExitDialog("مطمئنی می خوای بری؟")
    }
    private fun showExitDialog(msg :String){
        AlertDialog.Builder(this).setMessage(msg).setCancelable(false)
            .setPositiveButton("آره") { _, _ ->
            finish()
            }.setNegativeButton("نه") { dialog, _ ->
                dialog.cancel()
            }
            .show()
    }
}