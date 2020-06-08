package it.zabinska.curriculy.backend

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FirebaseHelper {
    val database = Firebase.database
    val myRef = database.getReferenceFromUrl("https://curricluly.firebaseio.com/experiences")
    companion object {
        var exp = ArrayList<Experience>()
        private const val TAG = "KotlinActivity"
    }

    fun readData(){
        myRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val values = ArrayList<DataSnapshot>()
                for(c in dataSnapshot.children) values.add(c)
                exp = createExperiences(values)
            }
        })
    }

    fun createExperiences(value : ArrayList<DataSnapshot>): ArrayList<Experience> {
        val exp = ArrayList<Experience>()
        for(v in value) {
            val e = v.getValue(Experience::class.java)
            if(e!=null){
                if(e.endYear == 0L || e.startYear == 0L) {
                    e.startYear = v.child("start_year").value.toString().toLong()
                    e.endYear = v.child("end_year").value.toString().toLong()
                }
                exp.add(e)
            }
        }
        return exp
    }
}