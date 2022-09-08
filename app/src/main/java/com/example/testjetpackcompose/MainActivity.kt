package com.example.testjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testjetpackcompose.ui.theme.TestJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painterTRX = painterResource(id = R.drawable.trx)
            val painterMammoth = painterResource(id = R.drawable.mammoth)
            val painterF150 = painterResource(id = R.drawable.f150)
            var description = "RAM TRX"

            Column() {
                Text(
                    text = "THE MONSTERS",
                    style = TextStyle(color = Color.Black, fontSize = 40.sp),
                    textAlign = TextAlign.Center
                )
                Column(
                    modifier = Modifier
                        .verticalScroll(ScrollState(0), true)
                ) {
                    imageCard(
                        painter = painterTRX,
                        contentDescription = description,
                        title = "RAM TRX 2022"
                    )
                    imageCard(
                        painter = painterMammoth,
                        contentDescription = description,
                        title = "MAMMOTH"
                    )
                    imageCard(
                        painter = painterF150,
                        contentDescription = description,
                        title = "FORD F150"
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun imageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 10.dp
    ) {
        Box(
            modifier = Modifier
                .height(250.dp)
        ){
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxHeight()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 600f
                        )
                    )
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            , contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = title,
                    style = TextStyle(color = Color.White, fontSize = 26.sp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestJetpackComposeTheme {
        Greeting("Android")
    }
}