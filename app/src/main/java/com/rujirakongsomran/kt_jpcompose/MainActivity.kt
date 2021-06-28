package com.rujirakongsomran.kt_jpcompose

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rujirakongsomran.kt_jpcompose.ui.theme.KT_JPComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyApp {
//                Greeting(name = "Android")
                MyScreenContent()
//                PlusNumber()
            }
//            KT_JPComposeTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
////                    Greeting("Android")
////                    NewsStory()
//
//                }
//            }
        }
    }

    // Displaying Text
    @Composable
    fun SimpleText() {
        Text("Hello World")
    }

    @Composable
    fun StringResourceText(){
        Text(stringResource(R.string.app_name))
    }

    @Composable
    fun Counter() {
        val count = remember {
            mutableStateOf(0)
        }
        Button(onClick = { count.value++ }) {
            Text("I've been clicked ${count.value} times")
        }
    }

    @Composable
    fun Counter2(count: Int, updateCount: (Int) -> Unit) {
        Button(onClick = { updateCount(count + 1) }) {
            Text("I've been clicked $count times")
        }
    }

    @Composable
    fun Plus2Number(num1: Int, num2: Int) {
        var result: Int = num1 + num2
        Text("$num1 + $num2 = $result")

    }


    @Composable
    fun MyScreenContent(names: List<String> = listOf("Android", "there")) {
        val counterState = remember {
            mutableStateOf(0)
        }
        Column {
            for (name in names) {
                Greeting(name = name)
                Divider(color = Black)
            }
            Divider(color = Transparent, thickness = 32.dp)
//            Counter
            Counter2(
                count = counterState.value,
                updateCount = { newCount ->
                    counterState.value = newCount
                }
            )
        }
    }

    @Composable
    fun PlusNumber(numbers: List<Int> = listOf(5, 10)) {
        Column {
            for (number in numbers) {
                Plus(name = number.toString())
                Divider(color = Black)
            }
            Divider(color = Transparent, thickness = 32.dp)
            Plus2Number(numbers.elementAt(0), numbers.elementAt(1))
        }
    }

    @Composable
    fun MyApp(content: @Composable () -> Unit) {
        KT_JPComposeTheme {
            Surface(color = White) {
                content()
            }
        }
    }

    @Composable
    fun NewsStory() {
        MaterialTheme {
            val typography = MaterialTheme.typography
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.header),
                    contentDescription = null,
                    modifier = Modifier
                        .height(180.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    "A day wandering through the sandhills " +
                            "in Shark Fin Cove, and a few of the " +
                            "sights I saw",
                    style = typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    "Davenport, California",
                    style = typography.body2
                )
                Text(
                    "December 2018",
                    style = typography.body2
                )
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Surface(color = Yellow) {
            Text(
                text = "Hello $name!",
                modifier = Modifier.padding(24.dp)
            )
        }
    }

    @Composable
    fun Plus(name: String) {
        Surface(color = Yellow) {
            Text(
                text = name,
                modifier = Modifier.padding(24.dp)
            )
        }
    }


    @Preview
    @Composable
    fun DefaultPreview() {
        MyApp {
//            Greeting("Android")
//            MyScreenContent()
//            SimpleText()
            StringResourceText()
        }
    }
}

