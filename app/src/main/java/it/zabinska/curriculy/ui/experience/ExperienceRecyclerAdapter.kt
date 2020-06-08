package it.zabinska.curriculy.ui.experience

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import it.zabinska.curriculy.R
import it.zabinska.curriculy.backend.Experience
import it.zabinska.curriculy.ui.experience.ExperienceRecyclerAdapter.ExperienceHolder

class ExperienceRecyclerAdapter(private val experiences: ArrayList<Experience>) : RecyclerView.Adapter<ExperienceHolder>(){

    lateinit var companyYearsResource : String

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem_experience, parent, false) as View

        companyYearsResource = parent.context.getString(R.string.company_years)

        return ExperienceHolder(item)
    }

    override fun getItemCount() = experiences.size

    override fun onBindViewHolder(holder: ExperienceHolder, position: Int) {
        val item = holder.itemView

        val positionAtCompany = item.findViewById<TextView>(R.id.position)
        val companyName = item.findViewById<TextView>(R.id.company_name)
        val companyLogo = item.findViewById<ImageView>(R.id.company_logo)
        val companyYears = item.findViewById<TextView>(R.id.company_years)
        val responsibilities = item.findViewById<TextView>(R.id.responsibilities_content)

        val exp = experiences[position]

        positionAtCompany.text = exp.positionAtCompany
        companyName.text = exp.companyName
        companyYears.text = companyYearsResource.format(exp.startYear, exp.endYear)
        Picasso.get().load(exp.companyLogoPath).into(companyLogo)
        var responsibilitiesFormattedString = ""
        for(s in exp.responsibilities)
            responsibilitiesFormattedString = "$responsibilitiesFormattedString\u2022 $s\n"
        responsibilities.text = responsibilitiesFormattedString
    }

    class ExperienceHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}