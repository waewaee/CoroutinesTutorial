package com.waewaee.coroutinestutorial

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.waewaee.coroutinestutorial.ui.theme.CoroutinesTutorialTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoroutinesTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

        GlobalScope.launch {
            Log.d(TAG, "Before any task")
            val networkCallAnswer = doNetworkCall()
            Log.d(TAG, networkCallAnswer)
            val networkCallAnswer2 = doNetworkCall2()
            Log.d(TAG, networkCallAnswer2)
        }
    }
        suspend fun doNetworkCall(): String {
            delay(3000L)
            return "This is the answer"
        }

        suspend fun doNetworkCall2(): String {
            delay(3000L)
            return "This is the answer2"
        }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoroutinesTutorialTheme {
        Greeting("Android")
    }
}