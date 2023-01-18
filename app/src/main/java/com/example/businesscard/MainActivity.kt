package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.AndroidGreen
import com.example.businesscard.ui.theme.BlackBack
import com.example.businesscard.ui.theme.BusinessCardTheme
import com.example.businesscard.ui.theme.DividerColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BlackBack
                ) {
                    Card()
                }
            }
        }
    }
}

@Composable
fun MainInfo(title: String, name: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        modifier = Modifier
            .fillMaxHeight(.5f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(painter = image, contentDescription = null, modifier.height(128.dp))
        Text(text = name, fontSize = 36.sp, color = Color.White)
        Text(text = title, fontSize = 24.sp, color = AndroidGreen)
    }
}

@Composable
fun ContactInfo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = BlackBack)
            .padding(bottom = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ContactRow(
            icon = painterResource(id = R.drawable.ic_local_phone),
            contact = "+55 (61) 99999-9999"
        )
        ContactRow(
            icon = painterResource(id = R.drawable.ic_share),
            contact = "@rafaelludens"
        )
        ContactRow(
            icon = painterResource(id = R.drawable.ic_email),
            contact = "k.rafaelalves@gmail.com"
        )
    }

}

@Composable
fun Card() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        MainInfo(title = "Android Developer", name = "Rafael Kenedy")
        ContactInfo()
    }
}

@Composable
fun ContactRow(
    modifier: Modifier = Modifier,
    icon: Painter,
    contact: String
) {
    Divider(thickness = 2.dp, color = DividerColor)
    Row(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 64.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(painter = icon, contentDescription = null, tint = AndroidGreen)
        Text(text = contact, color = Color.White)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        Card()
    }
}