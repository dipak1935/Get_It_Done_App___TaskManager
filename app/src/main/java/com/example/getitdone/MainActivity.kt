package com.example.getitdone

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.getitdone.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.pager.adapter=PagerAdapter(this)

        TabLayoutMediator(binding.tabLayout,binding.pager){ tab,position->

//            when(position){
//                0->{
//                    tab.text="Tasks"
//
//                }
//            }
            
            // OR 
            
            tab.text="Tasks"


        }.attach()
    }

    private inner class PagerAdapter(activity:FragmentActivity):FragmentStateAdapter(activity){
        override fun getItemCount(): Int=1


        override fun createFragment(position: Int): Fragment {

            return TasksFragment()
        }

    }
}