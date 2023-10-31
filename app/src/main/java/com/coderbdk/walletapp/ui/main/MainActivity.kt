package com.coderbdk.walletapp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coderbdk.walletapp.R
import com.coderbdk.walletapp.ui.theme.WalletAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WalletAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainUi()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainUi() {
    Box(
        contentAlignment = Alignment.BottomEnd
    ) {
        TopBar().MainTopBarUi(
            mainUI = {
                MainUIComponent()

            }
        )
       BottomBar()
    }

}

@Composable
fun BottomBar() {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(75.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xF0394462),
                        Color(0xEE394462),
                    )
                ),
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp, bottomStart = 15.dp, bottomEnd = 15.dp)
            )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Icon(
                painter = painterResource(id = R.drawable.baseline_wallet_24),
                contentDescription = "top arrow",
                tint =  Color(0xffd565b9),
            )
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "add",
                tint =  Color(0xffd565b9),

                )
            Text(
                text = "ADD WALLET",
                color = Color(0xffd565b9),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 15.sp
            )
        }
    }
}


@Composable
fun MainUIComponent() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .padding(10.dp),
    ) {
        PagerIndicator(false)
        Text(
            text = "My Wallet",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White
        )

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                Modifier.padding(bottom = 25.dp)
            ) {
                Text(
                    text = "$4.0034",
                    color = Color(0xffa0a6b6)
                )
                Text(
                    text = "(+4.00%)",
                    color = Color(0xffa0a6b6)
                )
                IconButton(
                    modifier = Modifier.size(20.dp),
                    onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_upward_24),
                        contentDescription = "top arrow",
                        tint = Color(0xFF54E75C)
                    )
                }
            }
            Row {
                Text(
                    text = "ADD COIN",
                    color = Color(0xff418dbe),
                    fontWeight = FontWeight.ExtraBold
                )
                Icon(
                    painter = painterResource(id = R.drawable.baseline_add_circle_24),
                    contentDescription = "add",
                    tint = Color(0xff418dbe),
                    )
            }

        }

        // item
        repeat(5){
            HomeItem()
            HomeItem()
        }

    }

}

@Composable
fun HomeItem() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(bottom = 25.dp)
            .fillMaxWidth()
            .shadow(
                10.dp,
                shape = RoundedCornerShape(50.dp)
            )
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xff4A5575),
                        Color(0xff323B5A),
                    )
                ),
                shape = RoundedCornerShape(50.dp)
            )
            .padding(15.dp)
    ) {
        Row(
            Modifier
                .size(45.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xff9F7EE7),
                            Color(0xffd565b9),

                            )
                    ),
                    shape = RoundedCornerShape(22.dp)
                )
        ) {
            IconButton(
                modifier = Modifier.size(45.dp),
                onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_euro_24),
                    contentDescription = "top arrow",
                    tint = Color(0xFFFFFFFF)
                )
            }
        }
        Column(
            Modifier
                .weight(1f)
                .padding(start = 10.dp),
        ) {
            Text(
                text = "EURO",
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
            Text(
                text = "$ 64.45",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xffa0a6b6),
            )
        }
        Column(
            Modifier
                .weight(1f)
                .padding(start = 10.dp),
        ) {
            Text(
                text = "2344.55",
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
            Text(
                text = "0.345 coin",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xffa0a6b6),
            )
        }
    }
}

@Composable
private fun PagerIndicator(isHome: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(15.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
        ) {

            drawCircle(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xff9F7EE7),
                        Color(0xffd565b9),

                        )
                ),
                10f,
                style = if(!isHome){
                   Stroke(
                        width = 1f
                    )
                }else Fill
            )
            drawCircle(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xff9F7EE7),
                        Color(0xffd565b9),

                        )
                ),
                10f,
                style = if(isHome)Stroke(
                    width = 1f
                )else Fill,
                center = Offset(size.width/2 + 35,0f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    WalletAppTheme {
        MainUi()
    }
}