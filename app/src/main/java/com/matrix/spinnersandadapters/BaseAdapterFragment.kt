package com.matrix.spinnersandadapters

import BaseAdapterClass
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import com.matrix.spinnersandadapters.databinding.FragmentBaseAdapterBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BaseAdapterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BaseAdapterFragment : Fragment() {
    var binding:FragmentBaseAdapterBinding?=null
//    var listBaseAdapter: BaseAdapterClass?=null
    var list2= arrayListOf("Apple","Burger","Pizza","Garlic Bread")
    var listBaseAdapter: BaseAdapterClass = BaseAdapterClass(list2)

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
       binding= FragmentBaseAdapterBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.listView?.adapter=listBaseAdapter
        binding?.btnadditem?.setOnClickListener {
            if (binding?.etadditem?.text.toString().isEmpty()){
                binding?.etadditem?.error="Enter an Item"
            }
            else{
                var item=binding?.etadditem?.text.toString()
                list2.add(item)
                listBaseAdapter.notifyDataSetChanged()
            }
        }
        
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BaseAdapterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BaseAdapterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}