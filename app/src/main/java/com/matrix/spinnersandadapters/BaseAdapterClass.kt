import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.matrix.spinnersandadapters.R

class BaseAdapterClass(private var list: ArrayList<String>) : BaseAdapter() {

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder", "SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView ?: LayoutInflater.from(parent?.context).inflate(R.layout.item_base_adapter, parent, false)

        val tvName: TextView = view.findViewById(R.id.tvName)

        val postion="$position"

        tvName.text = postion +list[position]


        return view
    }
}
