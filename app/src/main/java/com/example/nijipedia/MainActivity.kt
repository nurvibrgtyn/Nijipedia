package com.example.nijipedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvNiji: RecyclerView
    private val list = ArrayList<Niji>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvNiji = findViewById(R.id.rv_niji)
        rvNiji.setHasFixedSize(true)

        list.addAll(getListNiji())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btn_about -> {
                val moveIntent = Intent(this@MainActivity, About::class.java)
                startActivity(moveIntent)
            }
            R.id.action_list -> {
                rvNiji.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvNiji.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListNiji(): ArrayList<Niji> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataBirthday = resources.getStringArray(R.array.data_birthday)
        val dataHeight = resources.getStringArray(R.array.data_height)
        val dataDebut = resources.getStringArray(R.array.data_debut)
        val dataSong = resources.getStringArray(R.array.song)
        val dataAlbum = resources.obtainTypedArray(R.array.data_album)

        val listNiji = ArrayList<Niji>()
        for (i in dataName.indices) {
            val niji = Niji(dataName[i],  dataPhoto.getResourceId(i, -1), dataDescription[i], dataBirthday[i], dataHeight[i], dataDebut[i], dataSong[i], dataAlbum.getResourceId(i, -1))
            listNiji.add(niji)
        }
        return listNiji
    }

    private fun showRecyclerList() {
        rvNiji.layoutManager = LinearLayoutManager(this)
        val listNijiAdapter = ListNijiAdapter(list)
        rvNiji.adapter = listNijiAdapter

        listNijiAdapter.setOnItemClickCallback(object : ListNijiAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Niji) {
                showSelectedNiji(data)
            }
        })
    }

    private fun showSelectedNiji(niji: Niji) {
        Toast.makeText(this, "Kamu memilih " + niji.name, Toast.LENGTH_SHORT).show()
    }
}