package com.example.recyclerdelete

import android.app.LauncherActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {

    private val items: MutableList<ListItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = MyAdapter(items)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Add sample items
        for (i in 1..10) {
            items.add(ListItem(i, "Item $i"))
        }

        val deleteSelectedButton: Button = findViewById(R.id.delete_button)
        deleteSelectedButton.setOnClickListener {
            val iterator = items.iterator()
            while (iterator.hasNext()) {
                val item = iterator.next()
                if (item.isChecked) {
                    iterator.remove()
                }
            }
            adapter.notifyDataSetChanged()
        }
    }
}

