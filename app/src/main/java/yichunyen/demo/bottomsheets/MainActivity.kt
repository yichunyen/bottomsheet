package yichunyen.demo.bottomsheets

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
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
            R.id.menu_dialog -> {
                displayDialogBottomSheet()
                true
            }
            R.id.menu_fragment -> {
                showBottomSheetFragment()
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

    private fun displayDialogBottomSheet() {
        // Cannot the setup the peek height of dialog bottom sheet.
        val dialogView = layoutInflater.inflate(R.layout.layout_bottom_sheet, null)
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(dialogView)
        dialog.show()
    }

    private fun showBottomSheetFragment() {
        val bottomSheetFragment = BottomSheetFragment.newInstance()
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
    }

}
