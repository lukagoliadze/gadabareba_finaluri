package com.example.lukafinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.backBtn
import kotlinx.android.synthetic.main.registration.*


class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private val db: DatabaseReference = FirebaseDatabase.getInstance().reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        auth = FirebaseAuth.getInstance()
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val name = dataSnapshot.child("Users").child("username").value.toString()
                val mail = dataSnapshot.child("Users").child("email").value.toString()

                inputName.setText(name)
                inputemail.setText(mail)

            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w( "loadPost:onCancelled", databaseError.toException())
                // ...
            }


        })

        backBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


        changePasswordBtn.setOnClickListener {
            val intent = Intent(this, ChangePassword::class.java)
            startActivity(intent)
            finish()
        }


//        saveBtn.setOnClickListener {
//            val n: String = inputName.text.toString()
//            val p: String = inputPhone.text.toString()
//            val a: String = inputAddress.text.toString()
//
//            if (TextUtils.isEmpty(n)) {
//                Toast.makeText(this, "Empty Data!", Toast.LENGTH_LONG).show()
//
//            } else {
//                contactInfo(n, p, a)
//            }
//
//
//        }

//        clearBtn.setOnClickListener {
//            val n: String = ""
//            val p: String = ""
//            val a: String = ""
//
//            contactInfo(n, p, a)
//
//            inputName.setText("")
//            inputPhone.setText("")
//            inputAddress.setText("")
//
//        }

   }


//    private fun contactInfo(name: String, phone: String?, address: String) {
//        val userInfo = UserInfo(name, phone, address)
//        db.child(auth.currentUser?.uid!!).setValue(userInfo)
//    }

//    private fun addUserInfoChangeListener() {
//        db.child(auth.currentUser?.uid!!)
//            .addValueEventListener(object : ValueEventListener {
//
//                override fun onCancelled(p0: DatabaseError) {
//
//                }
//
//                override fun onDataChange(p0: DataSnapshot) {
//                    val userInfo: UserInfo = p0.getValue(UserInfo::class.java) ?: return
//
//                    showName.text = userInfo.name
//                    showPhone.text = userInfo.mobile ?: ""
//                    showAddress.text = userInfo.address
//
//
//                    inputName.setText("")
//                    inputPhone.setText("")
//                    inputAddress.setText("")
//
//                }
//            })
//
//
//
//        backBtn.setOnClickListener {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//
//
//        changePasswordBtn.setOnClickListener {
//            val intent = Intent(this, ChangePassword::class.java)
//            startActivity(intent)
//            finish()
//        }
//
//
//    }


}