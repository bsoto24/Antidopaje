package pe.gob.ipd.antidopaje

import android.app.SearchManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.Menu
import android.view.inputmethod.EditorInfo
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        toolbar.title = ""
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.search, menu)

        val searchManager: SearchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.menuSearch)?.actionView as SearchView
        val searchableInfo = searchManager.getSearchableInfo(componentName)

        searchView.queryHint = "Nombre del medicamento o componente activo"
        searchView.setSearchableInfo(searchableInfo)

        searchView.imeOptions = EditorInfo.IME_FLAG_NO_EXTRACT_UI
        searchView.setSearchableInfo(searchableInfo)
        searchView.setIconifiedByDefault(false)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(p0: String?): Boolean {

                Log.e("RESULTADO", p0)
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {

                Log.e("BUSCANDO", p0)
                return false
            }

        })

        return super.onCreateOptionsMenu(menu)

    }
}
