package app.nakaura.chloe.countla2

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class TutorialActivity : AppCompatActivity() {
    private lateinit var sharedPref: SharedPreferences

    // Doggy: チュートリアル済みかを判定する値を String で定義してしまうと、
    //  例えば今回の場合は、チュートリアルを既に表示したことがあったとしても、
    //  「チュートリアル済」以外の文字列が SharedPreferences で保存されていたら
    //  チュートリアル画面が保存されてしまうね！
    //  このように、「〇〇したかしていないか」を判定する値としては、Boolean（true/false）が適しているので、
    //  Boolean を使用してコードを書き換えてみよう！
    val memory: String = "チュートリアル済"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Doggy: 使用していないコードは消してOK！
        /*val firstFragment = FirstFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer, firstFragment)
        fragmentTransaction.commit()*/

        sharedPref = getSharedPreferences("DataStore", Context.MODE_PRIVATE)

        // Doggy: String? とすると null が入る可能性があるので、以下のように書くと良さそう！
        //  val output: String = sharedPref.getString("DataStore","") ?: ""
        //  "?:" は、?: の直前の値が null だった場合に、代わりに ?: の後ろに書かれた値を使用するという意味だよ！
        //  デフォルトの値を ?: の後ろに置いたりすることが多いよ！

        // Doggy: getString の第1引数には値のキーを渡すよ！
        //  コードを読んだ限りでは "DataStore" というキーで値を保存していないため、
        //  現状だと必ずデフォルトの値が呼ばれてしまい、
        //  output != memory が常に true になってしまうはずなので、
        //  コードを見直してみよう！
        //  また、SharedPreferences がどういう仕組みで値を保存しているかを調べてみよう！
        val output: String? = sharedPref.getString("Input", "")

        // Doggy: Kotlin では、"!==" と "!=" の意味が異なるので注意しよう！
        //  今回の場合は "!==" と "!=" でどちらが適しているか、コードを動かして確認してみよう！
        if(output !== memory){
            // Doggy: true の時のみ ViewPager の設定をするナイス！
            /// adapterのインスタンス生成
            val adapter = Adapter(this)
            /// adapterをセット
            val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
            viewPager2.adapter = adapter
        }else{
            // Doggy: 他の Activity が起動していない状態で finish を呼ぶと、
            //  アプリが閉じてユーザーにとってはアプリがクラッシュしたように見えてしまうね！
            //  なので、他の Activity に遷移するか、
            //  「チュートリアルは表示済です」のような文言を表示できると良さそう！
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

