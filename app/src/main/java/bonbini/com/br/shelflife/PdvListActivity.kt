package bonbini.com.br.shelflife

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_pdv_list.*
import kotlinx.android.synthetic.main.app_bar_pdv_list.*
import kotlinx.android.synthetic.main.content_pdv_list.*

class PdvListActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

	private val pdvs = mutableListOf<String>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_pdv_list)
		setSupportActionBar(toolbar)

//		fab.setOnClickListener { view ->
//			Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//					.setAction("Action", null).show()
//		}

		val toggle = ActionBarDrawerToggle(
				this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
		drawer_layout.addDrawerListener(toggle)
		toggle.syncState()

		nav_view.setNavigationItemSelectedListener(this)

		pdvs.add("PDV 1")
		pdvs.add("PDV 2")
		pdvs.add("PDV 3")
		pdvs.add("PDV 4")
		pdvs.add("PDV 5")

		pdv_list.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pdvs)
		pdv_list.setOnItemClickListener { _, _, position, _ ->
			val intent = Intent(this, LoteShelfLife::class.java)
			intent.putExtra("pdv", position)
			startActivity(intent)
		}
	}

	override fun onBackPressed() {
		if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
			drawer_layout.closeDrawer(GravityCompat.START)
		} else {
			super.onBackPressed()
		}
	}

	override fun onCreateOptionsMenu(menu: Menu): Boolean {
		// Inflate the menu; this adds items to the action bar if it is present.
		menuInflater.inflate(R.menu.pdv_list, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		when (item.itemId) {
			R.id.action_settings -> return true
			else -> return super.onOptionsItemSelected(item)
		}
	}

	override fun onNavigationItemSelected(item: MenuItem): Boolean {
		// Handle navigation view item clicks here.
		when (item.itemId) {
			R.id.nav_camera -> {
				// Handle the camera action
			}
			R.id.nav_gallery -> {

			}
			R.id.nav_slideshow -> {

			}
			R.id.nav_manage -> {

			}
			R.id.nav_share -> {

			}
			R.id.nav_send -> {

			}
		}

		drawer_layout.closeDrawer(GravityCompat.START)
		return true
	}
}
