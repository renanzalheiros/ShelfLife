package bonbini.com.br.shelflife.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import bonbini.com.br.shelflife.R
import bonbini.com.br.shelflife.SkuListActivity
import kotlinx.android.synthetic.main.adapter_pdvlist_row.view.*

class PdvListAdapter(private var pdvList: MutableList<String>) : RecyclerView.Adapter<PdvListAdapter.ViewHolder>(), Filterable {

	private var tempRows = pdvList

	override fun getFilter(): Filter {
		return object : Filter() {
			override fun performFiltering(constraint: CharSequence?): FilterResults {
				val filterResults = FilterResults()
				val filteredArrayList = ArrayList<String>()
				constraint.toString().toLowerCase()
				pdvList.filterTo(filteredArrayList) { it.toLowerCase().contains(constraint.toString().toLowerCase()) }

				filterResults.count = filteredArrayList.size
				filterResults.values = filteredArrayList

				return filterResults
			}

			override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
				tempRows = results!!.values as MutableList<String>
				notifyDataSetChanged()
			}

		}
	}

	override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
		return ViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.adapter_pdvlist_row, parent, false))
	}

	override fun getItemCount(): Int {
		return tempRows.size
	}

	override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
		holder!!.bindItems(tempRows[position], position)
	}

	class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

		fun bindItems(item: String, position: Int) {
			itemView.pdv_name.text = item
			if (position < 2 && position < 8) {
				itemView.pdv_status.setImageDrawable(itemView.context.resources.getDrawable(R.drawable.status_green_circle))
			} else if (position >= 10) {
				itemView.pdv_status.setImageDrawable(itemView.context.resources.getDrawable(R.drawable.status_yellow_circle))
			} else {
				itemView.pdv_status.setImageDrawable(itemView.context.resources.getDrawable(R.drawable.status_red_circle))
			}
			itemView.setOnClickListener({ _ ->
				val intent = Intent(itemView.context, SkuListActivity::class.java)
				intent.putExtra("pdv_name", item)
				itemView.context.startActivity(intent)
			})
		}
	}
}