package com.example.tarea3_manjoncarrascojosecarlos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class StartActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Este layout ya NO necesita DrawerLayout

        auth = Firebase.auth

        // Configuración básica del Navigation (Solo para ir de Login a Register)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // NOTA: Hemos quitado Toolbar, DrawerLayout y AppBarConfiguration.
        // Aquí no hacen falta.
    }
}