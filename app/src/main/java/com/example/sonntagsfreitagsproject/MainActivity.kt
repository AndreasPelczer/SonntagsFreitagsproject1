package com.example.sonntagsfreitagsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.sonntagsfreitagsproject.network.ApiClient
import com.example.sonntagsfreitagsproject.network.CharacterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = ApiClient.apiService.fetchCharacters("1")

        client.enqueue(object : retrofit2.Callback<CharacterResponse> {

            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ){
                if (response.isSuccessful){
                    Log.d("characters",""+response.body())


                    val result = response.body()?.result
                    result?.let {
                        val adapter = MainAdapter(result)
                        val recyclerView=findViewById<RecyclerView>(R.id.charactersRv)
                        recyclerView?.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
                        recyclerView?.adapter=adapter
                    }
                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                Log.e("failure",""+t.message)
            }

        })
    }
}