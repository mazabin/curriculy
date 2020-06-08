package it.zabinska.curriculy.ui.experience

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import it.zabinska.curriculy.R
import it.zabinska.curriculy.backend.FirebaseHelper


class ExperienceFragment : Fragment() {
    private lateinit var linearLayoutManager : RecyclerView.LayoutManager
    private lateinit var myAdapter : RecyclerView.Adapter<ExperienceRecyclerAdapter.ExperienceHolder>
    private lateinit var recyclerView : RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_experience, container, false)

        val experiences = FirebaseHelper.exp

        linearLayoutManager = LinearLayoutManager(this.context)
        experiences.reverse()
        myAdapter = ExperienceRecyclerAdapter(experiences)
        recyclerView = root.findViewById<RecyclerView>(R.id.recycler_view)
            .apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = myAdapter
        }

        return root
    }
}