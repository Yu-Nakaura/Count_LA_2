package app.nakaura.chloe.countla2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

//reviewed by toppo 🧸: Adapterという命名だと、どんな役割のAdapterかわかりにくいので、FragmentAdapterなど工夫してみよう！
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
}
