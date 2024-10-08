package com.matrix.spinnersandadapters

import android.os.Bundle
import android.text.Selection
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import com.matrix.spinnersandadapters.databinding.FragmentSpinnerBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SpinnerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpinnerFragment : Fragment() {
    lateinit var arrayAdapter:ArrayAdapter<String>
    var binding:FragmentSpinnerBinding?=null
    var cities= arrayListOf("jalandhar","ludhiana")
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
       binding= FragmentSpinnerBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arrayAdapter=ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,cities)
        binding?.dynamicSpinner?.adapter=arrayAdapter
        binding?.btnSubmit?.setOnClickListener {
            if(binding?.btnSubmit?.text.toString().isEmpty()){
                binding?.etcity?.error="Enter the city"
            }
            else{
                cities.add(binding?.etcity?.text.toString())
            }
            Toast.makeText(requireContext()," City Added successfully",Toast.LENGTH_SHORT).show()
        }


        binding?.staticSpinner?.onItemSelectedListener= object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selecteditem=binding?.staticSpinner?.selectedItem as String
                Toast.makeText(requireContext(),"$selecteditem",Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }


}