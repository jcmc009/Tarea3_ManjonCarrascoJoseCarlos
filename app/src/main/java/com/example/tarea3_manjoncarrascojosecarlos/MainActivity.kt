package com.example.tarea3_manjoncarrascojosecarlos

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    // HE BORRADO EL VIEWMODEL DE AQUÍ.
    // La MainActivity solo gestiona la navegación, no los datos de la lista.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()

        auth = Firebase.auth

        // --- Referencias ---
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        setSupportActionBar(toolbar)

        // --- Navegación ---
        // Asegúrate de que en tu XML el ID sea nav_host_fragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // --- Configuración de las 3 Rayas ---
        // R.id.mainViewFragment debe coincidir con el ID en tu nav_graph.xml
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.mainViewFragment),
            drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)

        // --- Visibilidad de la barra ---
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.loginFragment, R.id.registerFragment -> {
                    toolbar.visibility = View.GONE
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                }

                else -> {
                    toolbar.visibility = View.VISIBLE
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                }
            }
        }

    } // <--- AQUÍ CIERRA EL ONCREATE. ¡IMPORTANTE!

    // --- Permite abrir el menú al pulsar el botón ---
    // Esta función va FUERA del onCreate, al mismo nivel
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}