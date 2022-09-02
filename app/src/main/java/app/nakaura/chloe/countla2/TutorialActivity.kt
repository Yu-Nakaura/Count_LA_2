package app.nakaura.chloe.countla2

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class TutorialActivity : AppCompatActivity() {
    private lateinit var sharedPref: SharedPreferences
    val memory: String = "チュートリアル済"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val firstFragment = FirstFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer, firstFragment)
        fragmentTransaction.commit()*/

        sharedPref = getSharedPreferences("DataStore", Context.MODE_PRIVATE)
        val output: String? = sharedPref.getString("DataStore", "")

        if(output !== memory){
            /// adapterのインスタンス生成
            val adapter = Adapter(this)
            /// adapterをセット
            val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
            viewPager2.adapter = adapter
        }else{
            finish()
        }



    }

    override fun onStop() {
        super.onStop()
        sharedPref = getSharedPreferences("DataStore", Context.MODE_PRIVATE)

        // 文字列を"Input"に書き込む
        val editor = sharedPref.edit()
        editor.putString("Input", memory)

        //editor.commit();
        editor.apply()
    }
}

