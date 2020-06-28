package com.rafaelmfer.nasaexperience.ui.activity

import android.content.Intent
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.facebook.CallbackManager
import com.facebook.login.LoginManager
import com.google.android.material.navigation.NavigationView
import com.rafaelmfer.nasaexperience.R
import com.rafaelmfer.nasaexperience.baseviews.ActBind
import com.rafaelmfer.nasaexperience.databinding.ActivityHomeBinding
import com.rafaelmfer.nasaexperience.debugging.ExceptionHandler
import com.rafaelmfer.nasaexperience.extensions.addMarginTopStatusBarHeight
import com.rafaelmfer.nasaexperience.extensions.setFullScreen
import com.rafaelmfer.nasaexperience.extensions.toast

class ActivityHome : ActBind<ActivityHomeBinding>(), NavigationView.OnNavigationItemSelectedListener {

    private var callbackManager = CallbackManager.Factory.create()

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
    }

    private fun clickToStartNewActivity(activity: Class<*>) =
        View.OnClickListener { startActivity(Intent(it.context, activity)) }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_favorites -> {
                openFavoritesScreen()
            }
            R.id.nav_log_out -> {
                facebookLogout()
            }
            R.id.nav_rate_avaliation -> {
                Toast.makeText(this, "Me faz um Le'ato!", Toast.LENGTH_LONG).show()
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

    private fun facebookLogout() {
        LoginManager.getInstance().logOut()
        this@ActivityHome.toast("Saiu Pq fii da mãe?!")
        onBackPressed()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }
}