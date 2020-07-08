package com.rafaelmfer.nasaexperience.ui.activity

import android.app.AlertDialog
import android.content.Intent
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.view.GravityCompat
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.navigation.NavigationView
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.baseviews.ActBind
import com.rafaelmfer.nasaexperience.databinding.ActivityHomeBinding
import com.rafaelmfer.nasaexperience.debugging.ExceptionHandler
import com.rafaelmfer.nasaexperience.extensions.CircleTransform
import com.rafaelmfer.nasaexperience.extensions.addMarginTopStatusBarHeight
import com.rafaelmfer.nasaexperience.extensions.setFullScreen
import com.rafaelmfer.nasaexperience.extensions.toast
import com.rafaelmfer.nasaexperience.viewmodel.ViewModelLoginRegisterFirebase
import com.squareup.picasso.Picasso

class ActivityHome : ActBind<ActivityHomeBinding>(), NavigationView.OnNavigationItemSelectedListener {

    private val viewModelLoginFirebase: ViewModelLoginRegisterFirebase by viewModels()

    private val loginIntentGoogle by lazy {
        GoogleSignIn.getClient(
            this, GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
        )
    }

    override val bindClass: Class<ActivityHomeBinding> by lazy { ActivityHomeBinding::class.java }

    override fun ActivityHomeBinding.onBoundView() {
        exceptionHandler = ExceptionHandler::class.java
        setFullScreen()
        binding.contentHome.apply {
            menuNavdrawer.run {
                addMarginTopStatusBarHeight()
                setOnClickListener { drawerLayout.openDrawer(GravityCompat.START) }
            }
            btMarsWeather.setOnClickListener(clickToStartNewActivity(ActivityMarsWeather::class.java))
            btAsteroids.setOnClickListener(clickToStartNewActivity(ActivityAsteroidsNearFromEarth::class.java))
            btAstronomicImage.setOnClickListener(clickToStartNewActivity(ActivityAstronomicImageOfTheDay::class.java))
        }
        navigationView.setNavigationItemSelectedListener(this@ActivityHome)
        val hView = navigationView.getHeaderView(0)
        val profileName = hView.findViewById<View>(R.id.profile_name) as TextView
        val profileEmail = hView.findViewById<View>(R.id.profile_email) as TextView
        val profileImage = hView.findViewById<View>(R.id.profile_image) as ImageView
        val currentUser = viewModelLoginFirebase.firebaseUser
        profileName.text = currentUser?.displayName
        profileEmail.text = currentUser?.email
        Picasso.get().load(currentUser?.photoUrl)
            .resize(100, 100)
            .transform(CircleTransform())
            .centerCrop()
            .into(profileImage)
    }

    private fun clickToStartNewActivity(activity: Class<*>) =
        View.OnClickListener { startActivity(Intent(it.context, activity)) }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_favorites -> {
                openFavoritesScreen()
            }
            R.id.nav_log_out -> {
                logoffFire()
            }
            R.id.nav_about -> {
                openAboutScreen()
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return false
    }

    private fun openFavoritesScreen() {
        //TODO ABRIR BOTTOM SHEET FUTURAMENTE AQUI
        //TODO POR ENQUANTO ABRE ESSA ACTIVITY MESMO ( ͡° ʖ̯ ͡°)
        startActivity(Intent(this@ActivityHome, ActivityFavorites::class.java))
    }

    private fun openAboutScreen() {
        startActivity(Intent(this@ActivityHome, ActivityAbout::class.java))
    }

    private fun logoffFire() {
        viewModelLoginFirebase.logoffFirebase()
        loginIntentGoogle.revokeAccess()
        onBackPressed()
    }

    override fun onBackPressed() {

        val builder = AlertDialog.Builder(this)
        builder.setMessage("Deseja sair da nave?")
        builder.setCancelable(true)
        builder.setNegativeButton("Cancelar") { dialogInterface, cancel ->

            dialogInterface.cancel()
        }
        builder.setPositiveButton("Sair") { dialogInterface, exit ->
            toast(getString(R.string.dialog_exite_message))
            finishAffinity()
        }

        val alertDialog = builder.create()
        alertDialog.show()
    }
}