package pe.gob.ipd.antidopaje

import android.os.Build
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.transition.TransitionManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_one.*

class OneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
        addAnimationOperations()

        tiet_search.setOnEditorActionListener { textView, _, _ ->

            Toast.makeText(this, textView.text, Toast.LENGTH_SHORT).show()
            true

        }

    }

    private fun addAnimationOperations() {
        var set = false
        val constraint1 = ConstraintSet()
        constraint1.clone(root)
        val constraint2 = ConstraintSet()
        constraint2.clone(this, R.layout.activity_two)

        cv_item_search.setOnClickListener {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

                ly_menu.visibility = View.GONE
                ly_resultados.visibility = View.VISIBLE
                ic_close.visibility = View.VISIBLE
                tiet_search.isEnabled = true

                TransitionManager.beginDelayedTransition(root)
                constraint2.applyTo(root)
                set = !set

            }

        }

        ic_close.setOnClickListener {



            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

                ly_resultados.visibility = View.GONE
                ly_menu.visibility = View.VISIBLE
                ic_close.visibility = View.GONE
                tiet_search.editableText.clear()
                tiet_search.isEnabled = false

                TransitionManager.beginDelayedTransition(root)
                constraint1.applyTo(root)
                set = !set

            }
        }

    }

}
