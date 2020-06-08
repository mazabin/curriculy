package it.zabinska.curriculy.ui.skills

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import it.zabinska.curriculy.R

class SkillsFragment : Fragment() {
    private lateinit var linearLayoutManager : RecyclerView.LayoutManager
    private lateinit var myAdapter : RecyclerView.Adapter<SkillRecyclerAdapter.SkillHolder>
    private lateinit var recyclerView : RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_skills, container, false)

        val skills = ArrayList<Skill>()

        val skillsImages = resources.obtainTypedArray(R.array.skills_images)
        val skillsNames = resources.getStringArray(R.array.skills_names)
        val skillsDescriptions = resources.getStringArray(R.array.skills_descriptions)

        for(i in 0 until skillsImages.length()){
            skills.add(Skill(skillsImages.getDrawable(i),
                skillsNames[i], skillsDescriptions[i]))
        }

        linearLayoutManager = LinearLayoutManager(this.context)
        myAdapter = SkillRecyclerAdapter(skills)
        recyclerView = root.findViewById<RecyclerView>(R.id.recycler_view)
            .apply {
                setHasFixedSize(true)
                layoutManager = linearLayoutManager
                adapter = myAdapter
            }

        skillsImages.recycle()
        return root
    }

    class Skill(val image: Drawable?, val title: String, val content: String)
}