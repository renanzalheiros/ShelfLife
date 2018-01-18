package bonbini.com.br.shelflife.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bonbini.com.br.shelflife.R
import bonbini.com.br.shelflife.SkuListActivity
import kotlinx.android.synthetic.main.adapter_pdvlist_row.view.*

class PdvListAdapter(private val pdvList: MutableList<String>) : RecyclerView.Adapter<PdvListAdapter.ViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
		return ViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.adapter_pdvlist_row, parent, false))
	}

	override fun getItemCount(): Int {
		return pdvList.size
	}

	override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
		holder!!.bindItems(pdvList[position], position)
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