package com.lauwba.pabj

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.lauwba.pabj.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //kasih klik untuk masing-masing tombol
        binding.letsPlay.setOnClickListener {
            //do something in here
            val letsPlay = Intent(this@MainActivity, LetsPlayActivity::class.java)
            startActivity(letsPlay)
        }

        binding.tentang.setOnClickListener {
            //do something in here

            //ini dipakai untuk membuat sebuah object dari intent yang mana
            // akan digunakan untuk berpindah dari halaman MainActivity ke Tentang Aplikasi
            val intentTentang = Intent(this@MainActivity, TentangActivity::class.java)

            //mulai/proses menampilkan halaman tentang aplikasi
            startActivity(intentTentang)
        }

        binding.keluar.setOnClickListener {
            //memanggil fungsi alert
            alertExit()
        }
    }

    private fun alertExit() {
        //mendeklarasikan alert dialog
        val builder = AlertDialog.Builder(this)
        //title alert
        builder.setTitle("Alert")
        //pesan alert
        builder.setMessage("Apakah anda ingin keluar ?")

        //tombol yes
        builder.setPositiveButton("yes") { dialog, which ->
            //menyelesaikan halaman activity
            finish()
            //untuk keluar aplikasi
            System.exit(0)
        }

        //tombol no
        builder.setNegativeButton("no") { dialog, which ->
            Toast.makeText(applicationContext,
                "Anda tidak jadi keluar !", Toast.LENGTH_SHORT).show()
        }

        builder.show()
    }
}