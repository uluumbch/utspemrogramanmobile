package com.uluumbch.daftarmotogp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.uluumbch.daftarmotogp.model.MotoGP
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val nama = findViewById<TextView>(R.id.hasil_nama)
        val bike = findViewById<TextView>(R.id.hasil_bike)
        val dob = findViewById<TextView>(R.id.hasil_DOB)
        val hw = findViewById<TextView>(R.id.hasil_hw)
        val info = findViewById<TextView>(R.id.hasil_info)
        val gambar = findViewById<ImageView>(R.id.hasil_gambar)

        val intent = this.intent
        var data = intent.getSerializableExtra("data") as? MotoGP
        nama.text = data?.stringName
        bike.text = getString(R.string.bike,data?.bike)
        hw.text = getString(R.string.hw,data?.height,"128cm")
        dob.text = getString(R.string.dob, data?.DOB)
        info.text = data?.info
        gambar.setImageResource(data?.imageResourceId!!)
    }
}