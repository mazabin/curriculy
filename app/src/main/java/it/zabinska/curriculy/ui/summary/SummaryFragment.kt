package it.zabinska.curriculy.ui.summary

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.fragment.app.Fragment
import it.zabinska.curriculy.R

class SummaryFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_summary, container, false)

        val photoView = root.findViewById<ImageView>(R.id.photo)
        val bmp = BitmapFactory.decodeResource(resources, R.drawable.face)
        val rbmp = RoundedBitmapDrawableFactory.create(resources, bmp)
        rbmp.isCircular = true
        photoView.setImageDrawable(rbmp)

        val callButton = root.findViewById<ImageButton>(R.id.callButton)
        val phoneNumberTextView = root.findViewById<TextView>(R.id.callNumber)
        val emailButton = root.findViewById<ImageButton>(R.id.emailButton)
        val emailAddressTextView = root.findViewById<TextView>(R.id.emailAddress)

        val callListener = View.OnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" + getString(R.string.phone_number))
            startActivity(intent)
        }

        callButton.setOnClickListener(callListener)
        phoneNumberTextView.setOnClickListener(callListener)

        val emailListener = View.OnClickListener{
            val intent = Intent(Intent.ACTION_SEND).apply {
                data = Uri.parse("mailto:")
                type = "text/plain"
                val recipients = Array(1) { getString(R.string.email_address) }
                putExtra(Intent.EXTRA_EMAIL, recipients)
                putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject))
                putExtra(Intent.EXTRA_TEXT, getString(R.string.email_content))
            }
            startActivity(Intent.createChooser(intent, getString(R.string.send_email_message)))
        }

        emailButton.setOnClickListener(emailListener)
        emailAddressTextView.setOnClickListener(emailListener)

        return root
    }
}