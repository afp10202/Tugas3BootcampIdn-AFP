package com.bootcamp.tugas3_bootcampidn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.tugas3_bootcampidn.adapter.NewsAdapter
import com.bootcamp.tugas3_bootcampidn.api.ApiConfig
import com.bootcamp.tugas3_bootcampidn.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var rvNews: RecyclerView
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<News>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ApiConfig.getService().getNews().enqueue(object : Callback<ResponseNews>{
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                if (response.isSuccessful){
                    val responseNews = response.body()
                    val dataNews = responseNews?.articles
                    val newsAdapter = NewsAdapter()
                    newsAdapter.setData(dataNews as List<ArticlesItem>)

                    binding.rvNews.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        adapter = newsAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                Log.d("gagal", "onFailure : " + t.localizedMessage)
            }
        })
        }

    }