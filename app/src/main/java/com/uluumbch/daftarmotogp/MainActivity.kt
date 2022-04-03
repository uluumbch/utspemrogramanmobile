package com.uluumbch.daftarmotogp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uluumbch.daftarmotogp.adapter.MyAdapter
import com.uluumbch.daftarmotogp.data.Data
import com.uluumbch.daftarmotogp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerView
        recyclerView.adapter = MyAdapter()

        recyclerView.setHasFixedSize(true)
    }

    //    fungsi chooseLayout() untuk memilih layout pada recycler view
//    ke jenis layout yang dipilih pada tombol
    private fun chooseLayout() {
        if (isLinearLayoutManager) {
            recyclerView.layoutManager = LinearLayoutManager(this)
        } else {
            recyclerView.layoutManager = GridLayoutManager(this, 2)
        }
        recyclerView.adapter = MyAdapter()
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return


//    menetapkan resource drawable untuk ikon pada menu sesuai dengan LayoutManager yang sedang digunakan

        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this, R.drawable.ic_list_layout)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_layout, menu)

        val layoutButton = menu?.findItem(R.id.action_switch_layout)

//        panggil fungsi setIcon() untuk mengganti ikon sesuai dengan layout manager
        setIcon(layoutButton)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {

//                tetapkan variabel isLinearLayoutManager ke nilai balik(awalnya true menjadi false dan begitu juga sebaliknya)
                isLinearLayoutManager = !isLinearLayoutManager

//                tetapkan layout dan ikon
                chooseLayout()
                setIcon(item)

                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}