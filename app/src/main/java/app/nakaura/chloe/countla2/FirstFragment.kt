package app.nakaura.chloe.countla2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// Doggy: Fragment には使用しないコードしないコードが含まれているので、
//  不要な場合は消してしまおう！
class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    // Doggy: 使用していないコードは消してしまおう！
    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toSecondText = view.findViewById<TextView>(R.id.TextView1)
        toSecondText.setOnClickListener{
            Log.d("log", "FirstText was pressed!")
            val secondFragment = SecondFragment()
            val fragmentTransaction = fragmentManager?.beginTransaction()
            fragmentTransaction?.addToBackStack(null)
            fragmentTransaction?.replace(R.id.fragmentContainer, secondFragment)
            fragmentTransaction?.commit()
        }
    }*/
}