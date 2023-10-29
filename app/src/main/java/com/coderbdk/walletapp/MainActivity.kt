package com.coderbdk.walletapp

import android.graphics.BlurMaskFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

@Composable
fun MainUi() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff55648e))
    ) {
        Card(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxSize(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xff35405e)
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(245.dp)
                        .padding(start = 25.dp, end = 25.dp)
                        .shadow(
                            elevation = 10.dp,
                            shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)
                        )
                        .background(
                            Color(0xff2e364d),
                            RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)
                        )
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(start = 10.dp, bottom = 15.dp, end = 10.dp)
                        .shadow(
                            elevation = 10.dp
                        )
                        .background(
                            Color(0xff7c578d),
                            RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
                        )
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(225.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color(0xff9F7EE7),
                                    Color(0xffd565b9),

                                    )
                            ),
                            RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
                        )
                        .drawBehind {

                        }


                ) {
                    DrawPathBG()
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(15.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(bottom = 15.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = "menu",
                                    tint = Color.White
                                )
                            }
                            Text(
                                text = "WALLET",
                                style = TextStyle(
                                    fontSize = 22.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            )
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Filled.Notifications,
                                    contentDescription = "category",
                                    tint = Color.White
                                )
                            }
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = "$",
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            )
                            Text(
                                text = "9238.31",
                                style = TextStyle(
                                    fontSize = 35.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = "+ $ 45.5555 (22.012)",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            )
                            IconButton(
                                modifier = Modifier.size(25.dp),
                                onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Filled.KeyboardArrowUp,
                                    contentDescription = "top arrow",
                                    tint = Color.Green
                                )
                            }
                        }

                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 20.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Box(
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp)
                            .background(
                                Color.White,
                                RoundedCornerShape(50.dp)
                            )
                            .padding(10.dp)

                    ) {

                        Canvas(modifier = Modifier.fillMaxSize(),
                            onDraw = {
                                drawArc(
                                    Color(0xff9291ec),
                                    120f,
                                    120f,
                                    false,
                                    style = Stroke(
                                        10f,
                                        cap = StrokeCap.Round
                                    )
                                )
                            })
                        Canvas(modifier = Modifier.fillMaxSize(),
                            onDraw = {
                                drawArc(
                                    Color(0xffd791b5),
                                    120f * 2,
                                    120f,
                                    false,
                                    style = Stroke(
                                        10f,
                                        cap = StrokeCap.Round
                                    )
                                )
                            })
                        Canvas(modifier = Modifier.fillMaxSize(),
                            onDraw = {
                                drawArc(
                                    Color(0xff8bb4e8),
                                    120f * 3,
                                    120f,
                                    false,
                                    style = Stroke(
                                        10f,
                                        cap = StrokeCap.Round
                                    )
                                )
                            })
                    }
                }

            }

        }
    }
}

@Composable
fun DrawPathBG() {
    Canvas(modifier = Modifier
        .fillMaxSize(),
        onDraw = {

            val w = size.width + 0f
            val h = size.height + 0f


            // val midW = w / 2f
            val midH = h / 2f
            val points = listOf(
                //start
                Offset(10f, h - 10f),
                Offset(0f, h - 75f),
                // point
                Offset(w * 0.05f, h - 100),
                Offset(w * 0.1f, h - 75),
                Offset(w * 0.15f, h - 85),

                Offset(w * 0.2f, h - 125),
                Offset(w * 0.25f, h - 175),
                Offset(w * 0.3f, h - 230),

                Offset(w * 0.35f, h - 275),
                Offset(w * 0.4f, h - 265),
                Offset(w * 0.45f, h - 255),

                Offset(w * 0.5f, h - midH + 50),

                Offset(w * 0.55f, h - 235),

                Offset(w * 0.6f, h - 230),
                Offset(w * 0.65f, h - 240),
                Offset(w * 0.7f, h - 255),
                Offset(w * 0.75f, h - 280),
                Offset(w * 0.8f, h - 285),
                Offset(w * 0.85f, h - 290),
                Offset(w * 0.9f, h - 295),
                Offset(w * 0.95f, h - 295),
                // end point
                Offset(w, midH),
                Offset(w, h - 25f),
                Offset(w - 15, h - 15f)

            )


            /*
            drawPoints(
                points = points,
                color = Color.Red,
                strokeWidth = 10f,
                pointMode = PointMode.Points
            )*/


            val path = Path()
            //start
            path.moveTo(points[0].x, points[0].y)
            points.forEach {
                path.lineTo(it.x, it.y)
            }
            // end
            drawPath(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xffC172CD),
                        Color(0xffC172CD),
                        Color(0xffAF75D9),
                        Color(0xffAF75D9),
                    )
                ),
                path = path,
            )
            drawPath(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xffC172CD),
                        Color(0xffC172CD),
                        Color(0xffAF75D9),
                        Color(0xffAF75D9),

                        )
                ),
                path = path,
                style = Stroke(
                    pathEffect = PathEffect.cornerPathEffect(50f),
                    width = 10f
                ),
            )

            // new path
            val points2 = listOf(
                //start
                Offset(10f, h - 10f),
                Offset(0f, h - 25f),
                // point
                Offset(w * 0.05f, h - 75),
                Offset(w * 0.1f, h - 55),
                Offset(w * 0.15f, h - 45),

                Offset(w * 0.2f, h - 65),
                Offset(w * 0.25f, h - 85),
                Offset(w * 0.3f, h - 145),

                Offset(w * 0.35f, h - 195),
                Offset(w * 0.4f, h - 215),
                Offset(w * 0.45f, h - 210),

                Offset(w * 0.5f, h - midH + 125),

                Offset(w * 0.55f, h - 175),

                Offset(w * 0.6f, h - 185),
                Offset(w * 0.65f, h - 195),
                Offset(w * 0.7f, h - 215),

                Offset(w * 0.75f, h - 225),
                Offset(w * 0.8f, h - 235),
                Offset(w * 0.85f, h - 235),

                Offset(w * 0.9f, h - 230),
                Offset(w * 0.95f, h - 235),
                // end point
                Offset(w, midH + 75),
                Offset(w, h - 25f),
                Offset(w - 15, h - 15f)

            )
            /*drawPoints(
                points = points2,
                color = Color.Red,
                strokeWidth = 10f,
                pointMode = PointMode.Points
            )*/
            val path2 = Path()
            //start
            path2.moveTo(points[0].x, points[0].y)
            points2.forEach {
                path2.lineTo(it.x, it.y)
            }
            // end
            drawPath(
                brush = Brush.verticalGradient(
                    colors = listOf(

                        Color(0xffBF69CA),
                        Color(0xffC36AC6),
                        Color(0xFFA16CC7),
                        Color(0xffCB67C1),
                    ),

                    ),
                path = path2,
            )
            drawPath(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xffBF69CA),
                        Color(0xffC36AC6),
                        Color(0xFFA16CC7),
                        Color(0xffCB67C1),
                    )
                ),
                path = path2,
                style = Stroke(
                    pathEffect = PathEffect.cornerPathEffect(50f),
                    width = 10f
                ),
            )

            // draw
            this.drawIntoCanvas {

                val paint = Paint()

                val nativePaint = paint.asFrameworkPaint()
                nativePaint.shader = LinearGradientShader(
                    Offset(110f, 0f),
                    Offset(w, h),
                    colors = listOf(
                        Color(0x88D082DA),
                        Color(0x9ED0CDD3),
                        Color(0x8DE696E9),
                        Color(0x8AE9E5E9),
                    )
                )
                // nativePaint.color = android.graphics.Color.parseColor("#ffffff")
                nativePaint.maskFilter =
                    (BlurMaskFilter(20f, BlurMaskFilter.Blur.NORMAL))
                it.drawRoundRect(
                    0f,
                    h,
                    w,
                    h - 35f,
                    0f,
                    0f,
                    paint
                )

            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    WalletAppTheme {
        MainUi()
    }
}