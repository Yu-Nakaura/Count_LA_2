package app.nakaura.chloe.countla2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

// Doggy: Adapter という名前だと何のアダプターなのか分からないので、
//  TutorialAdapter や TutorialViewPagerAdapter のような命名にすると分かりやすくなるよ！

// Doggy: コードを読み返した時に「fm ってなんだっけ？」となりそうなので、
//  あまり省略した単語は使わない方が良さそう！
//  Android で慣習的に省略する単語もあるけど、その判定は他の人のコードを読んだり、
//  公式ドキュメントを参照してみると良さそう！
//  公式ドキュメント：https://developer.android.com/guide/fragments?hl=ja
class Adapter(fm: FragmentActivity):FragmentStateAdapter(fm){
    override fun createFragment(position: Int): Fragment  =
        when(position){
            0 -> FirstFragment()
            1 -> SecondFragment()
            2 -> ThirdFragment()
            else -> FirstFragment()
        }

    override fun getItemCount(): Int {
        return 3
    }
    // Doggy: 単に値を返すようなメソッドは、以下のような書き方もできるよ！
    //  override fun getItemCount(): Int = 3
}
