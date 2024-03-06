package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme
import com.google.android.gms.wallet.button.ButtonConstants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
               DiceRollerApp()
            }
        }
    }
}

@Composable
fun DiceWithButtonAndIMage(modifier: Modifier = Modifier){
    var result by remember { mutableStateOf(0) }
    val imageResource = when (result){
        1-> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Box(modifier = modifier,){
        Image(painter = painterResource(id = R.drawable.white_background), contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Column(modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Image(
                painter = painterResource(id = imageResource), contentDescription = result.toString()
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Ｙｏｕ Ｒｏｌｌｅｄ:  $result",
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.SemiBold
            )
            Button(onClick = { result = (1..6).random()},
                colors = ButtonDefaults.buttonColors(Color.LightGray),
            ) {
                Text(stringResource(id = R.string.roll),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun DiceRollerApp(modifier: Modifier = Modifier){
    DiceWithButtonAndIMage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))

}