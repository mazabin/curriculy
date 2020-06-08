package it.zabinska.curriculy.ui.skills

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import it.zabinska.curriculy.R

class SkillRecyclerAdapter (private val skills: ArrayList<SkillsFragment.Skill>) : RecyclerView.Adapter<SkillRecyclerAdapter.SkillHolder>() {

    lateinit var companyYearsResource: String

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem_skill, parent, false) as View

        companyYearsResource = parent.context.getString(R.string.company_years)

        return SkillHolder(item)
    }

    override fun getItemCount() = skills.size

    override fun onBindViewHolder(holder: SkillHolder, position: Int) {
        val item = holder.itemView

        val image = item.findViewById<ImageView>(R.id.image)
        val title = item.findViewById<TextView>(R.id.title)
        val content = item.findViewById<TextView>(R.id.content)

        val skill = skills[position]

        if(skill.image != null)
            image.setImageDrawable(skill.image)
        title.text = skill.title
        content.text = skill.content
    }

    class SkillHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}
}