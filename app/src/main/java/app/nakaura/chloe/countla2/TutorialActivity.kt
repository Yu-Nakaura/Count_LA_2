package app.nakaura.chloe.countla2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class TutorialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer, firstFragment)
        fragmentTransaction.commit()

        /// adapterのインスタンス生成
        val adapter = Adapter(this)
        /// adapterをセット
        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        viewPager2.adapter = adapter
    }
}

