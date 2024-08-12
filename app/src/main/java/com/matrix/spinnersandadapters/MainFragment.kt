package com.matrix.spinnersandadapters

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.matrix.spinnersandadapters.databinding.CustomAlertdialogboxBinding
import com.matrix.spinnersandadapters.databinding.FragmentMainBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    var binding:FragmentMainBinding?=null
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

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentMainBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        binding?.btnSpinner?.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_spinnerFragment)
        }
        binding?.btnlistview?.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_listViewFragment)
        }
        binding?.btnbaseAdapter?.setOnClickListener {
            findNavController().navigate(R.id.baseAdapterFragment)
        }
        binding?.btndialog?.setOnClickListener{
            val dialogview=layoutInflater.inflate(R.layout.custom_alertdialogbox,null)
            val dialog=AlertDialog.Builder(requireContext())
                .setView(dialogview)
                .setTitle("Add Detail")
                .setMessage("Do you want to add thid detail")
                .setPositiveButton("Yes"){
                    DialogInterface,which->
                    var editText=dialogview.findViewById<EditText>(R.id.etalertdialog)
                    var enteredtxt=editText.text.toString()
                    Toast.makeText(requireContext(),"You Entered $enteredtxt",Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No"){
                    DialogInterface,which->
                    Toast.makeText(requireContext(),"no",Toast.LENGTH_SHORT).show()

                }
                .setNeutralButton("Canceled"){
                        DialogInterface,which->
                    Toast.makeText(requireContext(),"Canceled",Toast.LENGTH_SHORT).show()
                }
            var alertDialog:AlertDialog=dialog.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
        binding?.btnStudentList?.setOnClickListener{
            findNavController().navigate(R.layout.fragment_student_list)
        }

        return binding?.root
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}