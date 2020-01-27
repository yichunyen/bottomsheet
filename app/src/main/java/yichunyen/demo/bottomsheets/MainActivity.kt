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
    private fun getSheetBehavior(): BottomSheetBehavior<View> = sheetBehavior!!

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
        getSheetBehavior().peekHeight = 0
    }

    private fun displayDefaultBottomSheet() {
        if (getSheetBehavior().state != BottomSheetBehavior.STATE_EXPANDED) {
            getSheetBehavior().state = BottomSheetBehavior.STATE_EXPANDED
        } else {
            getSheetBehavior().state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }

}
