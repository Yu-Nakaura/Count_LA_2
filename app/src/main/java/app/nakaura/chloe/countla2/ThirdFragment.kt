package app.nakaura.chloe.countla2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ThirdFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    // Doggy: onViewCreated で View の操作をしているのナイス！！
    //  Fragment のライフサイクルは Activity よりも複雑で、
    //  ・onCreateView: レイアウトファイルを Fragment 内で使用できるようにする
    //  ・onViewCreated: View の操作をする（Activity の onCreate で行うような処理を書く）
    //  といった使い分けをします！
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Doggy: findViewById は使わずに View Binding を使おう！
        //  View Binding についてのドキュメントを読んでみよう！
        //  https://developer.android.com/topic/libraries/view-binding?hl=ja#findviewbyid

        // Doggy: finish という変数名は Button であることが伝わらないので、
        //  finidhButton のような名前がより良さそう！
        val finish = view.findViewById<Button>(R.id.finish_button)
        finish.setOnClickListener{
            // Doggy: ログを表示しているのナイス！！
            Log.d("log", "finish button was pressed!")
            // Doggy: 以下のような書き方もあるよ！
            //  requireActivity().finish()
            //  activity? と requireActivity の違いを調べてみよう！
            activity?.finish()
        }

    }
}