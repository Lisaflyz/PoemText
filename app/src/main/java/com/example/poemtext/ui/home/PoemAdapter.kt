package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.PageData
import com.example.poemtext.R

class PoemAdapter(poems: List<PageData>) : RecyclerView.Adapter<PoemAdapter.ViewHolder>(),
    View.OnClickListener {
    private val mPoems: List<PageData> = poems

    private var mOnRecyclerViewItemClickListener: OnRecyclerViewItemClickListener? = null

    interface OnRecyclerViewItemClickListener {
        fun onItemClick(view: View?, pageData: PageData?)
    }

    fun setOnRecyclerViewItemClickListener(onRecyclerViewItemClickListener: OnRecyclerViewItemClickListener?) {
        mOnRecyclerViewItemClickListener = onRecyclerViewItemClickListener
    }

    override fun onClick(v: View) {
        if (mOnRecyclerViewItemClickListener != null) {
            //通过v.getTag()接受数据
            mOnRecyclerViewItemClickListener!!.onItemClick(v, v.tag as PageData)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.poem, parent, false)
        val holder = ViewHolder(view)
        view.setOnClickListener(this)
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val onePoem: PageData = mPoems[position]
        holder.itemView.tag = onePoem
        holder.poemImg.setImageResource(onePoem.imageId)
    }

    override fun getItemCount(): Int {
        return mPoems.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var poemImg: ImageView = view.findViewById<ImageView>(R.id.poem_img)
    }
}