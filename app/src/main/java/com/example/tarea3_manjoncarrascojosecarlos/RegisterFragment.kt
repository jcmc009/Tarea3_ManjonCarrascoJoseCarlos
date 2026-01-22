package com.example.tarea3_manjoncarrascojosecarlos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tarea3_manjoncarrascojosecarlos.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterFragment : Fragment() {

    // Configuración de ViewBinding
    private var _binding: FragmentRegisterBinding? = null
    // Esta propiedad solo es válida entre onCreateView y onDestroyView
    private val binding get() = _binding!!

    // Variable para Firebase Auth
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inicializamos el binding con el layout correcto (fragment_register)
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializamos Firebase Auth
        auth = FirebaseAuth.getInstance()

        // --- BOTÓN: REGISTRARSE  ---
        binding.btnDoRegister.setOnClickListener {
            // Obtenemos los textos de los campos

            val name = binding.registerName.text.toString()
            val email = binding.registerMail.text.toString()
            val password = binding.registerPassword.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                // Función para crear usuario en Firebase
                registerUser(email, password)
            } else {
                Toast.makeText(context, "Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        // --- BOTÓN: VOLVER AL LOGIN (btn_back_to_login) ---
        binding.btnBackToLogin.setOnClickListener {
            // Usamos la acción definida en nav_graph para volver
            try {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            } catch (e: Exception) {
                // Si falla la acción específica, intentamos volver atrás simplemente
                findNavController().popBackStack()
            }
        }
    }

    private fun registerUser(email: String, pass: String) {
        // Crear usuario en Firebase
        auth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Registro exitoso
                    Toast.makeText(context, "Cuenta creada con éxito", Toast.LENGTH_SHORT).show()

                    // Volvemos al Login para que el usuario entre
                  //  findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                } else {
                    // Error en el registro (ej. correo ya existe, contraseña corta)
                    val errorMsg = task.exception?.message ?: "Error al registrar"
                    Toast.makeText(context, errorMsg, Toast.LENGTH_LONG).show()
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}