package com.example.poemtext.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.myapplication.PoemAdapter
import com.example.myapplication.PoemAdapter.OnRecyclerViewItemClickListener
import com.example.myapplication.model.PageData
import com.example.myapplication.utils.Utils
import com.example.poemtext.DetailActivity
import com.example.poemtext.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), OnRecyclerViewItemClickListener {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var poemWithImages: List<PageData> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        initPoems()

        val recyclerView: RecyclerView = binding.recyclerView
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.setLayoutManager(layoutManager)
        val adapter: PoemAdapter = PoemAdapter(poemWithImages)
        recyclerView.setAdapter(adapter)
        adapter.setOnRecyclerViewItemClickListener(this)
        return root
    }

    private fun initPoems() {
        val poemMap: HashMap<String, PageData> = Utils.map
        poemWithImages = java.util.ArrayList(poemMap.values)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onItemClick(view: View?, pageData: PageData?) {
        //创建一个intent，指明跳转目标类
        val intent: Intent = Intent(activity, DetailActivity::class.java)
        //拿到数据传给intent
        if (pageData != null) {
            intent.putExtra("image", pageData.imageId)
        }
        if (pageData != null) {
            intent.putExtra("poem", pageData.text)
        }
        //启动Activity
        startActivity(intent)
    }
}