package com.matrix.spinnersandadapters

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.core.view.get
import com.matrix.spinnersandadapters.databinding.FragmentListViewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class   ListViewFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var binding: FragmentListViewBinding? = null
    var listItems = arrayListOf("Apple", "Banana", "Mangoes", "Burger", "Pizza")
    private lateinit var listAdapter: ArrayAdapter<String>
    private var param1: String? = null
    private var param2: String? = null
    private val TAG = "ListViewFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListViewBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, listItems)
        binding?.listview?.adapter = listAdapter
        binding?.btnaddElement?.setOnClickListener {
            if (binding?.etaddElement?.text.toString().isEmpty()) {
                binding?.etaddElement?.error = "Enter element"
            } else {
                listItems.add(binding?.etaddElement?.text.toString())
                listAdapter.notifyDataSetChanged()
            }
            Toast.makeText(requireContext(), "Element Added successfully", Toast.LENGTH_SHORT).show()
        }
        binding?.listview?.setOnItemClickListener { parent, view, position, id ->
            val selection = listItems[position]
            Log.e(TAG, " list item ${binding?.listview?.selectedItem}")
            Toast.makeText(requireContext(), "Selected $selection", Toast.LENGTH_SHORT).show()

        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListViewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListViewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}