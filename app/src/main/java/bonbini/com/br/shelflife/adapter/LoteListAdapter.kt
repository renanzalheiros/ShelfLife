package bonbini.com.br.shelflife.adapter

import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import bonbini.com.br.shelflife.R
import bonbini.com.br.shelflife.formataParaBrasileiro
import bonbini.com.br.shelflife.model.Lote
import kotlinx.android.synthetic.main.adapter_lote_row.view.*
import java.math.BigDecimal
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class LoteListAdapter(private val loteList: MutableList<Lote>) : RecyclerView.Adapter<LoteListAdapter.ViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
		return ViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.adapter_lote_row, parent, false))
	}

	override fun getItemCount(): Int {
		return loteList.size
	}

	override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
		holder!!.bindItems(loteList[position])
	}

	class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {


		fun bindItems(item: Lote) {
			val hoje = Calendar.getInstance()
			val vencido = Calendar.getInstance()
			val longeDeVencer = Calendar.getInstance()
			vencido.set(2017, 12, 31)
			longeDeVencer.set(2018, 1, 30)

			itemView.lote.text = item.lote
			itemView.vencimento.text = item.vencimento.formataParaBrasileiro()
			when {
				hoje.before(item.vencimento) -> itemView.vencimento.setTextColor(itemView.context.resources.getColor(R.color.green))
				hoje.after(item.vencimento) -> itemView.vencimento.setTextColor(itemView.context.resources.getColor(R.color.colorPrimaryDark))
				else -> itemView.vencimento.setTextColor(itemView.context.resources.getColor(R.color.yellow))
			}
			itemView.setOnClickListener({ _ ->
				AlertDialog.Builder(itemView.context)
						.setTitle("Dar baixa?")
						.setView(R.layout.dialog_alert)
						.setPositiveButton("Confirmar", { _, _ ->
						})
						.setNegativeButton("Cancelar", { _, _ ->
						})
						.show()
			})
		}
	}
}