package com.rj.chapteriv

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu

@Composable
fun LibraryScreen(){
    Scaffold(
        bottomBar = { BottomNavigationBar() },
        containerColor = Color(0xFF0484D81)
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            FilterLine()
            Spacer(modifier = Modifier.height(24.dp))
            BookRows()
        }
    }
}

@Composable
fun BookRows() {
    Text(
        "not yet implemented",
        fontSize = 16.sp,
        color = Color(0xFF0AAAFE6)
    )
}

@Composable
fun FilterLine() {
    Row{
        Text(
            "LIBRARY",
            fontSize = 57.sp,
            color = Color(0xFF0AAAFE6)
        )

        Spacer(modifier = Modifier.width(75.dp))

        IconButton(onClick = { /* TODO: open menu */ }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                modifier = Modifier.size(90.dp),
                tint = Color.White,
            )
        }
    }

    Spacer(modifier = Modifier.height(24.dp))

    Row{

        Button(onClick = { /* TODO */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00A8E8)),
            modifier = Modifier
                .width(83.dp)
                .height(43.dp)) {
            Text(
                "Recent",
                fontSize = 11.sp,
                maxLines = 1
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Button(onClick = { /* TODO */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00A8E8)),
            modifier = Modifier
                .width(66.dp)
                .height(45.dp)) {
            Text(
                "A-Z",
                fontSize = 11.sp
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Button(onClick = { /* TODO */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00A8E8)),
            modifier = Modifier
                .width(73.dp)
                .height(45.dp)) {
            Text(
                "Read",
                fontSize = 11.sp
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Button(onClick = { /* TODO */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00A8E8)),
            modifier = Modifier
                .width(84.dp)
                .height(45.dp)) {
            Text(
                "Unread",
                fontSize = 11.sp
            )
        }
    }

}

@Preview(showBackground = true, name = "Library Screen Preview")
@Composable
fun Preview() {
    LibraryScreen()
}