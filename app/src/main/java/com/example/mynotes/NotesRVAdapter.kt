package com.example.mynotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class NotesRVAdapter(private val context: Context, private val listener:INotesRVAdapter): RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {

    val allNotes = ArrayList<note>()

    inner class NoteViewHolder(itemView: View) : ViewHolder(itemView){
           val textView = itemView.findViewById<TextView>(R.id.text)
           val deleteBtn = itemView.findViewById<ImageView>(R.id.deletebutton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
          val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note, parent , false))
        viewHolder.deleteBtn.setOnClickListener{
             listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
       return allNotes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.textView.text = currentNote.text
    }
fun updateList(newList: List<note>){
    allNotes.clear()
    allNotes.addAll(newList)

    notifyDataSetChanged()
}

}
//If we want to define functions afterwards not yet then for that we make interfaces
//and then we override the methods of interfaces whenever and whherever we want them to use
//but for that we have to make another class implement this interface (like in this main activity had implemeted this interface at starting(extended)
interface INotesRVAdapter {
    fun onItemClicked(note: note)
}