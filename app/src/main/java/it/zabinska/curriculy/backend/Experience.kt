package it.zabinska.curriculy.backend

import com.google.firebase.database.PropertyName

class Experience() {
    @PropertyName("position_name")
    lateinit var positionAtCompany : String
    @PropertyName("company_name")
    lateinit var companyName : String
    @PropertyName("company_logo")
    lateinit var companyLogoPath : String
    @PropertyName("start_year")
    var startYear : Long = 0
    @PropertyName("end_year")
    var endYear : Long = 0
        get() = field
        set(value) {
            field = value
        }
    lateinit var responsibilities : List<String>
}
