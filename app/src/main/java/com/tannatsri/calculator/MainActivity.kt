package com.tannatsri.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.tannatsri.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnAc.setOnClickListener{
            binding.inputText.text = ""
            binding.outputText.text = ""
        }
        binding.btnZero.setOnClickListener{
            binding.inputText.append("0")
        }
        binding.btnOne.setOnClickListener{
            binding.inputText.append("1")
        }
        binding.btnTwo.setOnClickListener{
            binding.inputText.append("2")
        }
        binding.btnThree.setOnClickListener{
            binding.inputText.append("3")
        }
        binding.btnFour.setOnClickListener{
            binding.inputText.append("4")
        }
        binding.btnFive.setOnClickListener{
            binding.inputText.append("5")
        }
        binding.btnSix.setOnClickListener{
            binding.inputText.append("6")
        }
        binding.btnSeven.setOnClickListener{
            binding.inputText.append("7")
        }
        binding.btnEight.setOnClickListener{
            binding.inputText.append("8")
        }
        binding.btnNine.setOnClickListener{
            binding.inputText.append("9")
        }
        binding.btnAdd.setOnClickListener{
            binding.inputText.append("+")
        }
        binding.btnMinus.setOnClickListener{
            binding.inputText.append("-")
        }
        binding.btnMultiply.setOnClickListener{
            binding.inputText.append("*")
        }
        binding.btnDivide.setOnClickListener{
            binding.inputText.append("/")
        }
        binding.btnDot.setOnClickListener{
            binding.inputText.append(".")
        }
        binding.btnOpenBracket.setOnClickListener{
            binding.inputText.append("(")
        }
        binding.btnClosedBracket.setOnClickListener{
            binding.inputText.append(")")
        }


        binding.btnEqual.setOnClickListener{
            try {

                    val expression = ExpressionBuilder(binding.inputText.text.toString()).build()
                    val evaluate = expression.evaluate()
                    val longResult = evaluate.toLong()
                    if (evaluate == longResult.toDouble()) {
                        binding.outputText.text = longResult.toString()
                    } else {
                        binding.outputText.text = evaluate.toString()
                    }
                    binding.inputText.text = ""
            }
            catch (e: Exception) {
                binding.inputText.text = "Invalid Input"
                Handler().postDelayed({
                    binding.inputText.text = ""
                }, 2000)

            }


        }
    }
}