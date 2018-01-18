package bonbini.com.br.shelflife

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.LinearLayout
import bonbini.com.br.shelflife.adapter.SkuListAdapter
import kotlinx.android.synthetic.main.content_sku_list.*

class SkuListActivity : AppCompatActivity() {

	private val skuList = mutableListOf<String>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.content_sku_list)

		val pdvName = intent.getStringExtra("pdv_name")
		tv_sku_em_pdv.text = "Lotes em " + pdvName

		skuList.add("Achocolatado Nescau 200g")
		skuList.add("Achocolatado Toddyinho 200g")
		skuList.add("Achocolatado ChocoMilk 200g")
		skuList.add("Nescau Cereal 180g")
		skuList.add("Nesquik morando 180g")

		listViewSku.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
		listViewSku.adapter = SkuListAdapter(skuList)

		Log.i("teste", pdvName.toString())
	}
}