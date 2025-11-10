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

@Composable
fun HomeScreen() {
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
            CurrentReadSection()
            Spacer(modifier = Modifier.height(24.dp))
            SimilarReadsSection()
        }
    }
}

@Composable
fun CurrentReadSection() {
    Text(
        "HOME",
        fontSize = 57.sp,
            color = Color(0xFF0AAAFE6)
        )

    Spacer(modifier = Modifier.height(32.dp))

    Text("Current Read:",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF071BFE5)
        )
    Text("Book Title and author", style = MaterialTheme.typography.headlineSmall, color = Color(0xFF071BFE5))

    Spacer(modifier = Modifier.height(32.dp))

    Row {
        CircularProgressIndicator(
            progress = 1.0f,
            modifier = Modifier
                .size(157.dp)
                .padding(start = 32.dp),
            strokeWidth = 10.dp,
            color = Color(0xFF00A8E8)
        )

        Image(
            painter = painterResource(id = android.R.drawable.ic_menu_gallery),
            contentDescription = "Book Cover",
            modifier = Modifier
                .size(125.dp)
                .padding(start = 62.dp)
                .offset(y = (-20).dp)
        )
    }

    Spacer(modifier = Modifier.height(32.dp))

    Row {
        Spacer(modifier = Modifier.width(17.dp))

        Button(onClick = { /* TODO */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00A8E8)),
            modifier = Modifier
                .width(150.dp)
                .height(48.dp)) {
            Text("XXX pages left")
        }

        Spacer(modifier = Modifier.width(27.dp))

        Button(onClick = { /* TODO */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00A8E8)),
            modifier = Modifier
                .width(150.dp)
                .height(48.dp)) {
            Text("View Notes")
        }
    }
}
@Composable
fun SimilarReadsSection() {
    Spacer(modifier = Modifier.height(32.dp))

    Text("Similar Reads:",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF071BFE5))

    Spacer(modifier = Modifier.height(57.dp))

    LazyRow {
        items(4) {
            BookCard()
        }
    }
}


@Composable
fun BookCard() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = android.R.drawable.ic_menu_gallery),
            contentDescription = "book title",
            modifier = Modifier.size(90.dp)
        )
        Text("book title", style = MaterialTheme.typography.bodySmall, color = Color.White)
    }
}



@Composable
fun BottomNavigationBar() {
    Text("Bottom Navigation Placeholder", color = Color.White)
}

@Preview(showBackground = true, name = "Home Screen Preview")
@Composable
fun PreviewScreen() {
    HomeScreen()
}