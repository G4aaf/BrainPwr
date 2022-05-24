package fr.isen.rouveure.brainpwr.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import fr.isen.rouveure.brainpwr.HomeActivity
import fr.isen.rouveure.brainpwr.R
import fr.isen.rouveure.brainpwr.databinding.ActivityLoginBinding

import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding


    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        firebaseAuth = FirebaseAuth.getInstance()
        val uid = firebaseAuth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance("https://brainpwr-2043a-default-rtdb.europe-west1.firebasedatabase.app").getReference("Users")
        val database = Firebase.database
        val myRef = database.getReference("User")


        //change of view between login and registration
        binding.singUp.setOnClickListener {
            binding.singUp.background =
                ResourcesCompat.getDrawable(resources, R.drawable.switch_trcks, null)
            binding.singUp.setTextColor(
                ResourcesCompat.getColor(
                    resources,
                    R.color.textColor,
                    null
                )
            )
            binding.logIn.background = null
            binding.singUpLayout.visibility = View.VISIBLE
            binding.logInLayout.visibility = View.GONE
            binding.logIn.setTextColor(ResourcesCompat.getColor(resources, R.color.blueColor, null))
        }

        //connexion LogIn
        binding.logIn.setOnClickListener {
            binding.singUp.background = null
            binding.singUp.setTextColor(
                ResourcesCompat.getColor(
                    resources,
                    R.color.blueColor,
                    null
                )
            )
            binding.logIn.background =
                ResourcesCompat.getDrawable(resources, R.drawable.switch_trcks, null)
            binding.singUpLayout.visibility = View.GONE
            binding.logInLayout.visibility = View.VISIBLE
            binding.logIn.setTextColor(ResourcesCompat.getColor(resources, R.color.textColor, null))

            //Firebase connexion
            binding.singIn.setOnClickListener {
            val email = binding.eMail.text.toString()
            val pass = binding.passwords.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()){

                    firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful){
                            val intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)
                        }else {
                            Toast.makeText(this, it.exception.toString() , Toast.LENGTH_SHORT).show()
                        }
                }
            }else {
                Toast.makeText(this, "Certain champs sont vide !!", Toast.LENGTH_SHORT).show()
            }

            //val intent = Intent(this, HomeActivity::class.java)
            //startActivity(intent)
        }
        }

        // Firebase registration
        binding.singIn.setOnClickListener {
            val email = binding.eMails.text.toString()
            val pass = binding.passwordET.text.toString()
            val confirmPass = binding.confirmPassword.text.toString()
            val firstName = binding.firstName.text.toString()
            val lastName = binding.lastName.text.toString()
            val address = binding.postalAdresse.text.toString()


            if (email.isNotEmpty() && isEmailValid(email) && pass.isNotEmpty() && pass?.count() ?: 0 >= 6 && confirmPass.isNotEmpty() && firstName.isNotEmpty() && lastName.isNotEmpty() && address.isNotEmpty()){
                if (pass == confirmPass){


                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful){

                            val user = User(firstName,lastName,address,email)
                            if (uid != null) {
                                databaseReference.child(uid).setValue(user).addOnCompleteListener {
                                    if (it.isSuccessful) {
                            myRef.setValue("user")
                                    }else {
                                        Toast.makeText(this, "failed to upload profile" , Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }

                            val intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)
                        }else {
                            Toast.makeText(this, it.exception.toString() , Toast.LENGTH_SHORT).show()
                        }
                    }

                }else {
                    Toast.makeText(this, "Les mots de passe ne coincide pas", Toast.LENGTH_SHORT).show()
                }
            }else {
                Toast.makeText(this, "Aucun compte ne corresponds aux informations", Toast.LENGTH_SHORT).show()
            }

            //val intent = Intent(this, HomeActivity::class.java)
            //startActivity(intent)
        }

    }

    fun isEmailValid(email: String): Boolean {
            return Pattern.compile(
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
            ).matcher(email).matches()
        }
}
