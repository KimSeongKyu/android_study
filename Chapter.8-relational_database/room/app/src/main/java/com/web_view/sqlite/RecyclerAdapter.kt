package com.web_view.sqlite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycler.view.*

class RecyclerAdapter : RecyclerView.Adapter<Holder>() {
    var listData = mutableListOf<RoomMemo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val RoomMemo = listData.get(position)
        holder.setRoomMemo(RoomMemo)
    }

}

class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun setRoomMemo(RoomMemo: RoomMemo){
        itemView.textNo.text = "${RoomMemo.no}"
        itemView.textContent.text = RoomMemo.content
    }
}