package app.basiccalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.basiccalculator.databinding.FragmentTopBinding
import kotlinx.android.synthetic.main.fragment_top.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TopFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TopFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding : FragmentTopBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top, container, false)
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        binding = FragmentTopBinding.bind(view)
    }

    fun setDisplay(str : String) {
        var ops = arrayOf<String>("+", "-", "x", "÷", "%", "√", "%", ".")
        var line = binding.editTextCalc.text.toString()

        if(str in ops){
            if(line.isEmpty()){ //  If line is empty, allow operator
                line = "$line$str"
            }
            else if(line[line.length - 1] == '√' && str == "√"){    //  If previous character is root, and current operator is root, allow current operator
                line = "$line$str"
            }
            else if(line[line.length - 1] == '-' && str == "-"){    //  If previous character is minus, and current operator is minus, allow current operator
                line = "$line$str"
            }
            else if(line[line.length - 1].toString() !in ops) {     //  If previous character is operator, do not allow any other operator
                line = "$line$str"
            }
        }
        else if(str == "c"){    //  If current operator is clear, clear line
            line = ""
        }
        else if(str == "ce"){   //  If current operator is clear previous, clear previous character
            if(line.isNotEmpty()){
                line = line.substring(0, line.length - 1)
            }
        }
        else if(str == "="){    //  If current operator is equals, calculate result

        }
        else{   //  Otherwise add character
            line = "$line$str"
        }

        binding.editTextCalc.setText(line)

        binding.editTextCalc.setSelection(editTextCalc.text.length)

        // Log.i("setDisplayFunction: ", "$line")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TopFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                TopFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}