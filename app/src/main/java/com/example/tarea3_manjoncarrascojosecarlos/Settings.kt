package com.example.tarea3_manjoncarrascojosecarlos

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.tarea3_manjoncarrascojosecarlos.databinding.FragmentSettingsBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.Locale

class Settings : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    // Nombre del archivo de preferencias
    private val PREFS_NAME = "app_settings"
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Inicializar SharedPreferences
        sharedPreferences = requireActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        // 2. Cargar estado actual de las preferencias
        val isDarkMode = sharedPreferences.getBoolean("dark_mode", false)
        val isEnglish = sharedPreferences.getBoolean("language_english", false)

        binding.switchDarkMode.isChecked = isDarkMode
        binding.switchLanguage.isChecked = isEnglish

        // --- LÓGICA MODO OSCURO ---
        binding.switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            // Guardar preferencia
            sharedPreferences.edit().putBoolean("dark_mode", isChecked).apply()

            // Aplicar cambio
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        // --- LÓGICA CAMBIO DE IDIOMA ---
        binding.switchLanguage.setOnCheckedChangeListener { _, isChecked ->
            // Guardar preferencia
            sharedPreferences.edit().putBoolean("language_english", isChecked).apply()

            // Cambiar idioma
            setLocale(if (isChecked) "en" else "es")

            // Reiniciar Activity para aplicar cambios de idioma
            requireActivity().recreate()
        }

        // --- LÓGICA CERRAR SESIÓN ---
        binding.btnLogout.setOnClickListener {
            // 1. Cerrar sesión en Firebase
            FirebaseAuth.getInstance().signOut()

            // 2. Borrar preferencias de sesión si las tuvieras (opcional)
            // sharedPreferences.edit().clear().apply()

            // 3. Volver a la pantalla de Login (MainActivity) y borrar historial
            val intent = Intent(requireContext(), MainActivity::class.java)
            // Estas flags borran la pila para que no puedas volver atrás
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    // Función auxiliar para cambiar el idioma
    private fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        requireContext().resources.updateConfiguration(
            config,
            requireContext().resources.displayMetrics
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}