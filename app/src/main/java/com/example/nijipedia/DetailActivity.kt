package com.example.nijipedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val actionBar = supportActionBar
        actionBar!!.title = "Liver's Details"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val tvName: TextView = findViewById(R.id.tv_niji_name)
        val tvPhoto: ImageView = findViewById(R.id.img_niji_photo)
        val tvBirthday: TextView = findViewById(R.id.tv_niji_birthday)
        val tvHeight: TextView = findViewById(R.id.tv_niji_height)
        val tvDebut: TextView = findViewById(R.id.tv_niji_debut)
        val tvSong: TextView = findViewById(R.id.tv_niji_song)
        val tvDesc: TextView = findViewById(R.id.tv_niji_description)
        val tvAlbum: ImageView = findViewById(R.id.img_niji_album)

        val nijiName = intent.getStringExtra("mName")
        val nijiPhoto = intent.getIntExtra("mPhoto", 1)
        val nijiBirthday = intent.getStringExtra("mBirthday")
        val nijiHeight = intent.getStringExtra("mHeight")
        val nijiDebut = intent.getStringExtra("mDebut")
        val nijiSong = intent.getStringExtra("mSong")
        val nijiDesc = intent.getStringExtra("mDesc")
        val nijiAlbum = intent.getIntExtra("mAlbum", 1)

        tvName.text = nijiName
        tvPhoto.setImageResource(nijiPhoto)
        tvBirthday.text = nijiBirthday
        tvHeight.text = nijiHeight
        tvDebut.text = nijiDebut
        tvSong.text = nijiSong
        tvDesc.text = nijiDesc
        tvAlbum.setImageResource(nijiAlbum)

        val action_share : FloatingActionButton = findViewById(R.id.action_share)

        action_share.setOnClickListener{
            val intent= Intent()
            intent.action=Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Check out these cool Nijisanji Livers!")
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Share To: "))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return false
    }
}