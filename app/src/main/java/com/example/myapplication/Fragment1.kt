package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.listData.ListAdapter
import com.example.myapplication.listData.ListData
import com.example.myapplication.databinding.Fragment1Binding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: Fragment1Binding
    private lateinit var listAdapter: ListAdapter
    private lateinit var listData: ListData
    private var dataArrayList = ArrayList<ListData?>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = Fragment1Binding.inflate(inflater, container, false)

        val imageList = intArrayOf(
            R.drawable.brasil,
            R.drawable.alemanha,
            R.drawable.estadosunidos,
            R.drawable.franca,
            R.drawable.inglaterra,
            R.drawable.italia,
            R.drawable.reinounido,
            R.drawable.russia
        )

        val nameList = arrayOf("Brasil", "Alemanha", "Estados Unidos", "França", "Inglaterra", "Italia", "Reino Unido", "Russia")

        for (i in imageList.indices) {
            listData = ListData(
                nameList[i], imageList[i]
            )
            dataArrayList.add(listData)
        }

        listAdapter = ListAdapter(requireContext(), dataArrayList)
        binding.listView1.adapter = listAdapter
        binding.listView1.isClickable = true

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}