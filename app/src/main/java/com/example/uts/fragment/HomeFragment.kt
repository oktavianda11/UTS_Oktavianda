package com.example.uts.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"




class HomeFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: SuperheroAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var superheroArrayList : ArrayList<Superhero>

    lateinit var image : Array<Int>
    lateinit var name : Array<String>
    lateinit var description: Array<String>
    lateinit var rate : Array<String>
    lateinit var news : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }

            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_hero)
        recyclerView.layoutManager  = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = SuperheroAdapter(superheroArrayList)
        recyclerView.adapter = adapter

        superheroArrayList = arrayListOf<Superhero>()
        getUserdata()

    }

    private fun getUserdata() {
        for (i in image.indices) {

            val superhero = Superhero(image[i], name[i], description[i], rate[i])
            superheroArrayList.add(superhero)
        }

        var adapter = SuperheroAdapter(superheroArrayList)
        recyclerView.adapter = adapter
        adapter.setOnItemClikListener(object : SuperheroAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                // Toast.makeText(requireActivity(), "You Clicked on Item no. $position", Toast.LENGTH_SHORT).show()

                val intent = Intent(requireActivity(),DetailSuperheroActivity::class.java)
                intent.putExtra("image", superheroArrayList[position].imgSuperhero)
                intent.putExtra("name", superheroArrayList[position].nameSuperhero)
                intent.putExtra("news",news[position])
                startActivity(intent)


            }

        })
    }

    private fun dataInitialize(){
        superheroArrayList = arrayListOf<Superhero>()

        image = arrayOf(
            R.drawable.chrollo,
            R.drawable.deku,
            R.drawable.denji,
            R.drawable.guts,
            R.drawable.johanliebert,
            R.drawable.ladynagant,
            R.drawable.lawliett,
            R.drawable.luffy,
            R.drawable.mereoleona,
            R.drawable.musashi,
        )

        name = arrayOf(
            "Chrollo",
            "Deku",
            "Denji",
            "Guts",
            "Johan Liebert",
            "Lady Nagant",
            "Lawliett",
            "Luffy",
            "Mereoleona Vermillion",
            "Musashi Miyamoto",
        )

        description = arrayOf(
            "HunterxHunter",
            "Boku No Hero Academia",
            "Chainsaw Man",
            "Berserk",
            "Monster",
            "Boku No Hero Academia",
            "Death Note",
            "One Piece",
            "Black Clover",
            "Vagabond",
        )

        rate = arrayOf(
            "10/10",
            "10/10",
            "10/10",
            "10/10",
            "10/10",
            "9/10",
            "10/10",
            "10/10",
            "10/10",
            "10/10",
            "10/10",
            "10/10",
            "10/10",
        )

        news = arrayOf(
            "Tokoh ini dari Anime HunterxHunter",
            "Tokoh ini dari Anime Boku No Hero Academia",
            "Tokoh ini dari Anime Chainsaw Man",
            "Tokoh ini dari Anime Berserk",
            "Tokoh ini dari Anime Monster",
            "Tokoh ini dari Anime Boku No Hero Academia",
            "Tokoh ini dari Anime Death Note",
            "Tokoh ini dari Anime One Piece",
            "Tokoh ini dari Anime Black Clover",
            "Tokoh ini dari Anime Vagabond",

        )

    }
}