package com.web_view.viewpagerfragment

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentList = listOf(FragmentA(), FragmentB(), FragmentC(), FragmentD())
        val pageTitleList = listOf("프래그먼트A", "프래그먼트B", "프래그먼트C", "프래그먼트D")

        val adapter = FragmentAdapter(this)
        adapter.fragmentList = fragmentList
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
            tab.text = pageTitleList.get(position)
        }.attach()
    }
}