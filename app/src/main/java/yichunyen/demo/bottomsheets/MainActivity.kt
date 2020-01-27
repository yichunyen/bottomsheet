package yichunyen.demo.bottomsheets

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var sheetBehavior: BottomSheetBehavior<View>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBottomBehavior()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_default -> {
                displayDefaultBottomSheet()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initBottomBehavior() {
        // CoordinatorLayout layout
        sheetBehavior = BottomSheetBehavior.from(llBottomSheet)
        sheetBehavior!!.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(p0: View, p1: Float) {

            }

            override fun onStateChanged(p0: View, p1: Int) {
            }

        })
    }

    private fun displayDefaultBottomSheet() {
        if (sheetBehavior!!.state != BottomSheetBehavior.STATE_EXPANDED) {
            llBottomSheet.visibility = View.VISIBLE
            sheetBehavior!!.state = BottomSheetBehavior.STATE_EXPANDED
        } else {
            llBottomSheet.visibility = View.GONE
            sheetBehavior!!.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }
}
