package bonbini.com.br.shelflife

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	private val pdvs = mutableListOf<String>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		pdvs.add("PDV 1")
		pdvs.add("PDV 2")
		pdvs.add("PDV 3")
		pdvs.add("PDV 4")
		pdvs.add("PDV 5")

		pdv_list.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pdvs)
		pdv_list.setOnItemClickListener { parent, view, position, id ->
			val intent = Intent(this, LoteShelfLife::class.java)
			intent.putExtra("pdv", position)
			startActivity(intent)
		}
	}
}
