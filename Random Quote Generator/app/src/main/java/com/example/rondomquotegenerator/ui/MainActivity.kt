package com.example.rondomquotegenerator.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.rondomquotegenerator.R
import com.example.rondomquotegenerator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var model: QuoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        model=ViewModelProvider(this)[QuoteViewModel::class.java]
        getQuote()
        observer()
        onClick()


    }



    fun onClick(){
        binding.newQuote.setOnClickListener{
            getQuote()
            observer()
        }

        binding.imageShared.setOnClickListener{
            val quoteText = binding.points.text.toString()
            val title=binding.title.text.toString()
            if (quoteText.isNotEmpty()) {
                shareQuote(quoteText,title)
            }
        }
    }

    fun observer(){
        model.mutableLiveData.observe(this){
            binding.apply {
                title.text=it.get(0).a
                points.text=it[0].q
            }
        }
    }

    fun getQuote(){
        model.getQuote()
    }
    private fun shareQuote(quote: String, title: String) {
        val shareContent = "$title\n\n$quote"
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareContent)
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Share quote via"))
    }

}