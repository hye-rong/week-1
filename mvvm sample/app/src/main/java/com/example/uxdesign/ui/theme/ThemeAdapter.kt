package com.example.uxdesign.ui.theme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uxdesign.databinding.ThemeRowBinding

class ThemeAdapter(val items:ArrayList<String>):RecyclerView.Adapter<ThemeAdapter.MyViewHolder>() {
    interface OnItemClickListener{
        fun OnItemClick(holder: RecyclerView.ViewHolder, view: View, data: String, position:Int)
    }

    var itemClickListener: OnItemClickListener?=null

    inner class MyViewHolder(val binding: ThemeRowBinding): RecyclerView.ViewHolder(binding.root){
        init{
            binding.root.setOnClickListener {
                itemClickListener?.OnItemClick(this, it, items[adapterPosition], adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //뷰바인딩 사용하려면 ViewHolder에 넘겨줄 view를 Binding을 보내줘야함
        val view = ThemeRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            //imageView
            textView.setText("")
        }

    }

    override fun getItemCount(): Int {
        //아이템의 전체 개수
        return items.size
    }
}