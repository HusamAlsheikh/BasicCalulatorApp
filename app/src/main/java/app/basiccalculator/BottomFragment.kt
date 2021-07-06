package app.basiccalculator

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.basiccalculator.databinding.FragmentBottomBinding

class BottomFragment : Fragment(), View.OnClickListener {
    private lateinit var binding : FragmentBottomBinding

    var activityCallback : BottomListener? = null

    interface BottomListener {
        fun onButtonClick(button: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try{
            activityCallback = context as BottomListener
        }
        catch(e : ClassCastException) {
            throw ClassCastException(context.toString() +
                    " must implement BottomPetListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom, container, false)
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        binding = FragmentBottomBinding.bind(view)
    }

    override fun onActivityCreated(savedInstanceState : Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.button0.setOnClickListener(this)
        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
        binding.button5.setOnClickListener(this)
        binding.button6.setOnClickListener(this)
        binding.button7.setOnClickListener(this)
        binding.button8.setOnClickListener(this)
        binding.button9.setOnClickListener(this)
        binding.buttonDecimal.setOnClickListener(this)
        binding.buttonPlus.setOnClickListener(this)
        binding.buttonMinus.setOnClickListener(this)
        binding.buttonMultiply.setOnClickListener(this)
        binding.buttonDivide.setOnClickListener(this)
        binding.buttonModulus.setOnClickListener(this)
        binding.buttonRoot.setOnClickListener(this)
        binding.buttonClear.setOnClickListener(this)
        binding.buttonEqual.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        var whichButton = ""

        when(view?.id) {
            R.id.buttonDecimal -> {
                whichButton = "."
            }
            R.id.button1 -> {
                whichButton = "1"
            }
            R.id.button2 -> {
                whichButton = "2"
            }
            R.id.button3 -> {
                whichButton = "3"
            }
            R.id.button4 -> {
                whichButton = "4"
            }
            R.id.button5 -> {
                whichButton = "5"
            }
            R.id.button6 -> {
                whichButton = "6"
            }
            R.id.button7 -> {
                whichButton = "7"
            }
            R.id.button8 -> {
                whichButton = "8"
            }
            R.id.button9 -> {
                whichButton = "9"
            }
            R.id.button0 -> {
                whichButton = "0"
            }
            R.id.buttonPlus -> {
                whichButton = "+"
            }
            R.id.buttonMinus -> {
                whichButton = "-"
            }
            R.id.buttonMultiply -> {
                whichButton = "x"
            }
            R.id.buttonDivide -> {
                whichButton = "÷"
            }
            R.id.buttonModulus -> {
                whichButton = "%"
            }
            R.id.buttonRoot -> {
                whichButton = "√"
            }
            R.id.buttonClear -> {
                whichButton = "c"
            }
            R.id.buttonClearRecent -> {
                whichButton = "ce"
            }
            R.id.buttonEqual -> {
                whichButton = "="
            }
        }

        // Log.i("BottomPetFragment", whichButton)

        activityCallback?.onButtonClick(whichButton)
    }
}