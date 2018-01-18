package bonbini.com.br.shelflife.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bonbini.com.br.shelflife.LoteListActivity
import bonbini.com.br.shelflife.R
import kotlinx.android.synthetic.main.adapter_pdvlist_row.view.*

class SkuListAdapter(private val skuList: MutableList<String>) : RecyclerView.Adapter<SkuListAdapter.ViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
		return ViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.adapter_pdvlist_row, parent, false))
	}

	override fun getItemCount(): Int {
		return skuList.size
	}

	override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
		holder!!.bindItems(skuList[position], position)
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
				val intent = Intent(itemView.context, LoteListActivity::class.java)
				intent.putExtra("sku", item)
				itemView.context.startActivity(intent)
			})
		}
	}
}