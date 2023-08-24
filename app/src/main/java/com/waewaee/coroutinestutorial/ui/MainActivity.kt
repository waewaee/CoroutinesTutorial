package com.waewaee.coroutinestutorial.ui

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.waewaee.coroutinestutorial.R
import com.waewaee.coroutinestutorial.databinding.ActivityMainBinding
import com.waewaee.coroutinestutorial.ui.base.BaseActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

data class Person(
    val name: String = "",
    val age: Int = -1
)

class MainActivity : BaseActivity<ActivityMainBinding>(inflate = ActivityMainBinding::inflate) {

    override fun initUi() {

        val tutorialDocument = Firebase.firestore.collection("coroutines")
            .document("tutorial")

        val peter = Person("Peter", 25)

        GlobalScope.launch(Dispatchers.IO) {
            delay(3000L)
            tutorialDocument.set(peter).await()
            val person = tutorialDocument.get().await().toObject(Person::class.java)
            withContext(Dispatchers.Main) {
                binding.tvData.text = person.toString()
            }
        }

    }

    override fun observe() {

    }

}