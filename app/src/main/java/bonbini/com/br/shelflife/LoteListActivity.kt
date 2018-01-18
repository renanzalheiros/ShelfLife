package bonbini.com.br.shelflife

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import bonbini.com.br.shelflife.adapter.LoteListAdapter
import bonbini.com.br.shelflife.model.Lote
import kotlinx.android.synthetic.main.content_lote_list.*
import kotlinx.android.synthetic.main.content_sku_list.*
import java.util.*

class LoteListActivity : AppCompatActivity() {

	private val lote = mutableListOf<Lote>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.content_lote_list)

		val sku = intent.getStringExtra("sku")
		tv_validades.text = "Lotes de " + sku

		val hoje = Calendar.getInstance()
		val vencido = Calendar.getInstance()
		val longeDeVencer = Calendar.getInstance()
		vencido.set(2017, 12, 31)
		longeDeVencer.set(2018, 1, 30)

		lote.add(Lote("13aabd854", hoje))
		lote.add(Lote("13aebd854", vencido))
		lote.add(Lote("13acbd854", longeDeVencer))

		listViewLotes.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
		listViewLotes.adapter = LoteListAdapter(lote)

		Log.i("teste", sku.toString())
	}
}