package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .padding(bottom = 12.dp)
                    .clip(CircleShape),
                painter = painterResource(R.drawable.eu),
                contentDescription = null
            )
            Text(text = stringResource(R.string.name), fontSize = 32.sp)
            Text(text = stringResource(R.string.work_with))
        }

        Column {
            Row(Modifier.padding(bottom = 12.dp)) {
                Icon(Icons.Rounded.Call, contentDescription = null)
                Spacer(Modifier.width(20.dp))
                Text(stringResource(R.string.phone))
            }
            Row(Modifier.padding(bottom = 12.dp)) {
                Icon(Icons.Rounded.Share, contentDescription = null)
                Spacer(Modifier.width(20.dp))
                Text(stringResource(R.string.hashtag))
            }
            Row {
                Icon(Icons.Rounded.Email, contentDescription = null)
                Spacer(Modifier.width(20.dp))
                Text(stringResource(R.string.email))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}