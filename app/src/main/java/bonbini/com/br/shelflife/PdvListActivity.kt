package bonbini.com.br.shelflife

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import bonbini.com.br.shelflife.adapter.PdvListAdapter
import kotlinx.android.synthetic.main.activity_pdv_list.*
import kotlinx.android.synthetic.main.content_pdv_list.*

class PdvListActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

	private val pdvs = mutableListOf<String>()
	private lateinit var adapter: PdvListAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_pdv_list)
		toolbar.title = getString(R.string.app_name)
		setSupportActionBar(toolbar)


		val toggle = ActionBarDrawerToggle(
				this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
		drawer_layout.addDrawerListener(toggle)
		toggle.syncState()

		nav_view.setNavigationItemSelectedListener(this)

		pdvs.add("Supermercado Angeloni Capoeiras")
		pdvs.add("Hippo Supermercados Centro")
		pdvs.add("Supermercado Baia Sul")
		pdvs.add("Supermercado Angeloni Beira-Mar")
		pdvs.add("Fort Atacadista")
		pdvs.add("Makro Atacadista")
		pdvs.add("Supermercado Big Iguatemi")
		pdvs.add("Supermercado Hippo Coqueiros")
		pdvs.add("Supermercado Angeloni Rio Branco")
		pdvs.add("Supermercado Bistek")
		pdvs.add("Giassi Supermercado")
		pdvs.add("Mercado Martins")
		pdvs.add("Supermercado Ok")

		listViewPdv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
		adapter = PdvListAdapter(pdvs)
		listViewPdv.adapter = adapter
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
		val searchItem = menu.findItem(R.id.action_search)
		val searchView = searchItem.actionView as SearchView

		searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
			override fun onQueryTextSubmit(query: String?): Boolean {
				val filter = adapter.filter
				filter.filter(query)
				return false
			}

			override fun onQueryTextChange(newText: String?): Boolean {
				val filter = adapter.filter
				filter.filter(newText)
				return false
			}

		})
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
