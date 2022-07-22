package com.example.guessanimalkt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.guessanimalkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var isDog = false
    var isCat = false
    var isGiraffe = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            dogBtn.setOnClickListener {
                isDog = true
                isCat = false
                isGiraffe = false

                binding.animalImage.setImageResource(R.drawable.dog)
            }
            catBtn.setOnClickListener {
                isDog = false
                isCat = true
                isGiraffe = false

                binding.animalImage.setImageResource(R.drawable.cat)
            }
            giraffeBtn.setOnClickListener {
                isDog = false
                isCat = false
                isGiraffe = true

                binding.animalImage.setImageResource(R.drawable.giraffe)
            }

            thisDogBtn.setOnClickListener {
                if (isDog == true) {
                    Toast.makeText(applicationContext, "Вы угадали", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "Вы не угадали", Toast.LENGTH_SHORT).show()
                }
            }
            thisCatBtn.setOnClickListener {
                if (isCat == true) {
                    Toast.makeText(applicationContext, "Вы угадали", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "Вы не угадали", Toast.LENGTH_SHORT).show()
                }
            }
            thisGiraffeBtn.setOnClickListener {
                if (isGiraffe == true){
                    Toast.makeText(applicationContext, "Вы угадали", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(applicationContext, "Вы не угадали", Toast.LENGTH_SHORT).show()
                }
            }

            resultBin.setOnClickListener {
                val intent: Intent = Intent(this@MainActivity, ResultActivity::class.java)
                if(isDog == true) {
                    intent.putExtra("result", "Dog")
                }
                else if(isCat == true) {
                    intent.putExtra("result", "Cat")
                }
                else if(isGiraffe == true) {
                    intent.putExtra("result", "Giraffe")
                }
                else {
                    intent.putExtra("result", "Animal not selected")
                }
                startActivity(intent)
            }
        }
    }
}