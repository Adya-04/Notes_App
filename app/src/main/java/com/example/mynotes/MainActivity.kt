package com.example.mynotes

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), INotesRVAdapter {

    lateinit var viewModel: NoteViewModel
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = NotesRVAdapter(this,this)
        binding.recyclerView.adapter = adapter

        //rev>
            viewModel= ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
            viewModel.allNotes.observe(this, Observer {list ->
                //checking whether list is nullable or not
                list?.let{
                    adapter.updateList(it)
                }

            })


        }

    override fun onItemClicked(note: note) {
        viewModel.deleteNote(note)
        Toast.makeText(this,"${note.text} Deleted", Toast.LENGTH_LONG).show()


    }

    fun submitData(view: View) {
        val noteText = binding.input.text.toString()
        if(noteText.isNotEmpty()){
            viewModel.insertNote(note(noteText))
            Toast.makeText(this,"$noteText Inserted", Toast.LENGTH_LONG).show()
            binding.input.text.clear()
        }

    }
}
