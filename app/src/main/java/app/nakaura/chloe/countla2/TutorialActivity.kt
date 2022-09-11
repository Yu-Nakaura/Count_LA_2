package app.nakaura.chloe.countla2

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

//reviewed by toppo 🧸: Tutorialが綺麗に作られていて良い！チュートリアルを一回しか表示しないトライもGood！あと一歩><
class TutorialActivity : AppCompatActivity() {
    private lateinit var sharedPref: SharedPreferences
    val memory: String = "チュートリアル済"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //🧸: 不要なコードは削除しよう！
        /*val firstFragment = FirstFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer, firstFragment)
        fragmentTransaction.commit()*/

        sharedPref = getSharedPreferences("DataStore", Context.MODE_PRIVATE)
        val output: String? = sharedPref.getString("DataStore", "")

        //🧸: Fragmentの画面遷移をAdapterで管理できていていいね！
        if(output !== memory){
            /// adapterのインスタンス生成
            val adapter = Adapter(this)
            //🧸: 惜しい！findViewByIdではなくviewBindingを活用してみよう
            /// adapterをセット
            val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
            viewPager2.adapter = adapter
        }else{
            finish()
        }


    //🧸: 空白行が目立つので、開ける空白は2行ほどにしよう！プログラムが長くなってきた時にも読みやすいコードにすることができます

    }

    override fun onStop() {
        super.onStop()
        sharedPref = getSharedPreferences("DataStore", Context.MODE_PRIVATE)

        //🧸: SharedPreferencesのKeyが違ったのかな？25行目と揃えてみよう
        // 文字列を"Input"に書き込む
        val editor = sharedPref.edit()
        editor.putString("Input", memory)

        //editor.commit();
        editor.apply()
    }
}

