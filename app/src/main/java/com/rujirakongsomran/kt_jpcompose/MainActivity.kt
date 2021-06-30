package com.rujirakongsomran.kt_jpcompose

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rujirakongsomran.kt_jpcompose.ui.theme.KT_JPComposeTheme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyApp {
//                Greeting(name = "Android")
//                MyScreenContent()
//                PlusNumber()
                PasswordTextField()
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
    fun StringResourceText() {
        Text(stringResource(R.string.app_name))
    }

    @Composable
    fun BlueText() {
        Text("Hello World", color = Blue)
    }

    @Composable
    fun BigText() {
        Text("Hello World", fontSize = 30.sp)
    }

    @Composable
    fun ItalicText() {
        Text("Hello World", fontStyle = FontStyle.Italic)
    }

    @Composable
    fun BoldText() {
        Text("Hello World", fontWeight = FontWeight.Bold)
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

    @Composable
    fun DifferentFonts() {
        val firaSansFamily = FontFamily(
            Font(R.font.firasans_light, FontWeight.Light),
            Font(R.font.firasans_regular, FontWeight.Normal),
            Font(R.font.firasans_italic, FontWeight.Normal, FontStyle.Italic),
            Font(R.font.firasans_medium, FontWeight.Medium),
            Font(R.font.firasans_bold, FontWeight.Bold)
        )
        Column {
//            Text("Hello World", fontFamily = FontFamily.Serif)
//            Text("Hello World", fontFamily = FontFamily.SansSerif)
            Text("Android Spread", fontFamily = firaSansFamily, fontWeight = FontWeight.Light)
            Text("Android Spread", fontFamily = firaSansFamily, fontWeight = FontWeight.Normal)
            Text(
                "Android Spread",
                fontFamily = firaSansFamily,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic
            )
            Text("Android Spread", fontFamily = firaSansFamily, fontWeight = FontWeight.Medium)
            Text("Android Spread", fontFamily = firaSansFamily, fontWeight = FontWeight.Bold)
        }
    }

    //    @Preview(showBackground = true)
    @Composable
    fun MultipleStylesInText() {
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Blue)) {
                    append("H")
                }
                append("ello ")

                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Red)) {
                    append("W")
                }
                append("orld")
            }
        )
    }

    //    @Preview(showBackground = true)
    @Composable
    fun ParagraphStyle() {
        Text(
            buildAnnotatedString {
                withStyle(style = androidx.compose.ui.text.ParagraphStyle(lineHeight = 30.sp)) {
                    withStyle(style = SpanStyle(color = Blue)) {
                        append("Hello\n")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = Red
                        )
                    ) {
                        append("World\n")
                    }
                    append("Compose")
                }
            }
        )
    }

    //    @Preview(showBackground = true)
    @Composable
    fun LongText() {
        Text("Biw ".repeat(50), maxLines = 2, overflow = TextOverflow.Ellipsis)
    }

    //    @Preview(showBackground = true)
    @Composable
    fun SelectableText() {
        SelectionContainer {
            Text("This text is selectable")
        }
    }


    @Composable
    fun PartiallySelectableText() {
        SelectionContainer() {
            Column {
                Text("This text is selectable")
                Text("This one too")
                Text("This one as well")
                DisableSelection {
                    Text("But not this one")
                    Text("Neither this one")
                }
                Text("But again, you can select this one")
                Text("And this one too")
            }
        }
    }


    //    @Preview
    @Composable
    fun DefaultPreview() {
        MyApp {
//            Greeting("Android")
//            MyScreenContent()
//            SimpleText()
//            StringResourceText
//            BlueText()
//            BigText
//            ItalicText()
            BoldText()
        }
    }

    @Composable
    fun SimpleClickableText() {
        ClickableText(
            text = AnnotatedString("Click Me"),
            onClick = { offset ->
                Log.d("ClickableText", "$offset -th character is clicked.")

            }
        )
    }


    @Composable
    fun CenterText() {
        Text(
            "Hello World", textAlign = TextAlign.Center,
            modifier = Modifier.width(150.dp)
        )
    }

    @Composable
    fun SimpleFilledTextFieldSample() {
        var text by remember { mutableStateOf("Hello") }

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Label") }
        )
    }

    @Composable
    fun SimpleOutlinedTextFieldSample() {
        var text by remember {
            mutableStateOf("")
        }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Label") }
        )
    }

    //    @Preview(showBackground = true)
    @Composable
    fun StyledTextField() {
        var value by remember {
            mutableStateOf("Hello\nWorld\nInvisible")
        }
        TextField(
            value = value,
            onValueChange = { value = it },
            label = { Text("Enter text") },
            maxLines = 2,
            textStyle = TextStyle(color = Blue, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(20.dp)
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PasswordTextField() {
        var password by rememberSaveable {
            mutableStateOf("")
        }

        TextField(
            value = password,
            onValueChange = {password = it},
            label = {
                Text("Enter password")
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
    }
}

