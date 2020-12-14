package com.sandystudios.todocb

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mehdi.sakout.aboutpage.AboutPage
import mehdi.sakout.aboutpage.Element

class AboutActivity : AppCompatActivity() {

    private val id = "sanidhyakr18"
    private val emailId = "$id@gmail.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val versionElement: Element =
            Element().setTitle("Version 1.0").setIconDrawable(R.drawable.ic_tools)
                .setIconTint(R.color.colorPrimary)

        val linkedInIntent = Intent(Intent.ACTION_VIEW)
        linkedInIntent.apply {
            addCategory(Intent.CATEGORY_BROWSABLE);
            data = Uri.parse((String.format("https://linkedin.com/in/$id")))
        }

        val instaIntent = Intent(Intent.ACTION_VIEW)
        instaIntent.apply {
            addCategory(Intent.CATEGORY_BROWSABLE);
            data = Uri.parse((String.format("http://instagram.com/$id")))
        }

        val emailIntent = Intent(Intent.ACTION_SENDTO)
        emailIntent.apply {
            addCategory(Intent.CATEGORY_BROWSABLE);
            data = Uri.parse("mailto:$emailId")
            putExtra(Intent.EXTRA_SUBJECT, "Implicit Intents")
        }

        val linkedIn: Element = Element().setTitle("LinkedIn")
            .setIconDrawable(R.drawable.ic_linkedin_circle).setIntent(linkedInIntent)

        val instagram: Element = Element().setTitle("Instagram")
            .setIconDrawable(R.drawable.ic_instagram).setIntent(instaIntent)

        val email: Element = Element().setTitle("Email")
            .setIconDrawable(R.drawable.ic_email).setIntent(emailIntent).setIconTint(R.color.yellow)

        val aboutPage = AboutPage(this)
            .setImage(R.drawable.ic_icon)
            .setDescription("This is a simple To-Do app with a clean & appealing UI with features like search and swipe action.")
            .addGroup("Connect with me")
            .addGitHub(id, "Github")
            .addItem(linkedIn)
            .addItem(instagram)
            .addItem(email)
            .addGroup("About App")
            .addItem(versionElement)
            .create()
        setContentView(aboutPage)
    }
}