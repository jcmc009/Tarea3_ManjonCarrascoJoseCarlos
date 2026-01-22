package com.example.tarea3_manjoncarrascojosecarlos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tarea3_manjoncarrascojosecarlos.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {

    // Configuración de ViewBinding
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    // Firebase
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializa Firebase Auth
        auth = FirebaseAuth.getInstance()

        //  Lógica del botón LOGIN
        binding.login.setOnClickListener {
            val email = binding.username.text.toString()
            val password = binding.password.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Mostrar cargando
                binding.loading.visibility = View.VISIBLE
                binding.login.isEnabled = false // Evitar doble click

                // Intentar Login con Firebase
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        // Ocultar cargando
                        binding.loading.visibility = View.GONE
                        binding.login.isEnabled = true

                        if (task.isSuccessful) {
                            Toast.makeText(context, "Login Correcto", Toast.LENGTH_SHORT).show()
                            // Navegar a la pantalla principal (BlankFragment)
                            try {
                                findNavController().navigate(R.id.action_loginFragment_to_mainViewFragment)
                            } catch (e: Exception) {
                                Toast.makeText(
                                    context,
                                    getString(R.string.error_nav_no_encuentro_blankfragment),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                context,
                                "Error: ${task.exception?.message}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            } else {
                Toast.makeText(context,
                    getString(R.string.escribe_email_y_contrase_a), Toast.LENGTH_SHORT).show()
            }
        }

        // Lógica del botón REGISTER
        binding.register.setOnClickListener {
           
            try {
                // Navegar a la pantalla de registro
                findNavController().navigate(R.id.registerFragment)

            } catch (e: Exception) {
                Toast.makeText(context, getString(R.string.error_de_navegaci_n), Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}