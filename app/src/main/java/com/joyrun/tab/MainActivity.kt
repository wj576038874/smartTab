package com.joyrun.tab

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , BlankFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {

    }

    private val datas = mutableListOf<Fragment>()
    private val titles = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        tab_layout.setTabNormalTextSize(18f)

//        tab_layout.setCustomTabView { container, position, adapter ->
//            val itemView = LayoutInflater.from(this).inflate(R.layout.smart_tab_default_layout_item , container , false)
//            val textView :TextView= itemView.findViewById(R.id.tv_smart_tab)
//            textView.text = adapter.getPageTitle(position)
//            return@setCustomTabView itemView
//        }

        tab_layout.setCustomTabView(R.layout.smart_tab_default_layout_item ,R.id.tv_smart_tab)

        datas.add(BlankFragment.newInstance("#e81b8b",""))
        datas.add(BlankFragment.newInstance("#21ff00",""))
        datas.add(BlankFragment.newInstance("#0054ff",""))

        titles.add("推荐")
        titles.add("关注")
        titles.add("话题")


        view_pager.adapter = ViewPagerFragmentAdapter(supportFragmentManager,datas,titles)
        view_pager.offscreenPageLimit = 3
        tab_layout.setViewPager(view_pager)

    }
}
