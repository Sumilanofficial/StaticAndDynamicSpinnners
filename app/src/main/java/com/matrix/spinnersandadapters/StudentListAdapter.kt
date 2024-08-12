package com.matrix.spinnersandadapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class StudentListAdapter(
    private val studentList: ArrayList<Student>
) : BaseAdapter() {

    override fun getCount(): Int {
        return studentList.size
    }

    override fun getItem(position: Int): Any {
        return studentList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_studentlist_adapter, parent, false)

        val studentNameTextView: TextView = view.findViewById(R.id.txtstudentList)
        val studentPositionTextView: TextView = view.findViewById(R.id.txtstudentPostion)

        val student = studentList[position]
        val serialNo = (position + 1).toString()

        studentNameTextView.text = student.name
        studentPositionTextView.text = serialNo

        return view
    }
}
