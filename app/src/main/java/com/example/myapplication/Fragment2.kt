package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.listData.AdapterClass
import com.example.myapplication.listData.DataClass

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment2 : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    private lateinit var imageList: Array<Int>
    private lateinit var titleList: Array<String>
    private lateinit var myAdapter: AdapterClass

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_2, container, false)

        imageList = arrayOf(
            R.drawable.basquetebol,
            R.drawable.pinguepongue,
            R.drawable.beisebol,
            R.drawable.boxe,
            R.drawable.futebol,
            R.drawable.tenis,
            R.drawable.tocha,
            R.drawable.volei
        )

        titleList = arrayOf(
            "Basquetebol",
            "Pingue Pongue",
            "Beisebol",
            "Boxe",
            "Futebol",
            "Tenis",
            "Tocha",
            "Volei"
        )

        recyclerView = view.findViewById(R.id.recyclerView1)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf()
        getData()

        myAdapter = AdapterClass(dataList)
        recyclerView.adapter = myAdapter

        return view
    }

    private fun getData() {
        for (i in imageList.indices) {
            val dataClass = DataClass(titleList[i], imageList[i])
            println(dataClass)

            dataList.add(dataClass)

        }
        dataList.addAll(dataList)
        recyclerView.adapter = AdapterClass(dataList)
    }
}