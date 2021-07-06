package app.basiccalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), BottomFragment.BottomListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onButtonClick(button: String){
        val displayTextView = supportFragmentManager.findFragmentById(R.id.topFragment) as TopFragment

        displayTextView.setDisplay(button)
    }
}