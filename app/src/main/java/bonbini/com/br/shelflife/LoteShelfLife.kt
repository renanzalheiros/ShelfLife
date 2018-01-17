package bonbini.com.br.shelflife

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class LoteShelfLife : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val pdvId = intent.getIntExtra("pdv", 0)
		Log.i("teste", pdvId.toString())
	}
}