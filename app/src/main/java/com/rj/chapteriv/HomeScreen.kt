package com.rj.chapteriv

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        containerColor = Color(0xFF0484D81)
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { HomeScreen(navController) }
            composable("library") { LibraryScreen(navController) }
            composable("notes") { NotesScreen(navController) }
            composable("goals") { GoalsScreen(navController) }

            composable("characterNotes") { CharacterNotesScreen(navController) }
            composable("quoteNotes") { QuoteNotesScreen(navController) }
            composable("thoughtNotes") { ThoughtNotesScreen(navController) }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        CurrentReadSection(navController)
        Spacer(modifier = Modifier.height(24.dp))
        SimilarReadsSection()
    }
}

@Composable
fun CurrentReadSection(navController: NavHostController) {
    Row{
        Text(
            "HOME",
            fontSize = 57.sp,
            color = Color(0xFF0AAAFE6)
        )

        Spacer(modifier = Modifier.width(150.dp))

        IconButton(onClick = { /* TODO: open menu */ }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                modifier = Modifier.size(90.dp),
                tint = Color.White,
            )
        }
    }


    Spacer(modifier = Modifier.height(32.dp))

    Text("Current Read:",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF071BFE5)
        )
    Text("Book Title and author", style = MaterialTheme.typography.headlineSmall, color = Color(0xFF071BFE5))

    Spacer(modifier = Modifier.height(32.dp))

    Row {
        CircularProgressIndicator(
            progress = 0.75f,
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

        Box(
            modifier = Modifier
                .size(width = 150.dp,
                    height = 48.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Color(0xFF00A8E8)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "XXX Pages Left",
                fontSize = 12.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.width(27.dp))

        Button(onClick = { navController.navigate("notes") },
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
fun BottomNavigationBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomAppBar(containerColor = Color(0xFFEEEEEE)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(onClick = { navController.navigate("home") }) {
                Icon(
                    Icons.Filled.Bookmark,
                    contentDescription = "Home",
                    modifier = Modifier.size(40.dp),
                    tint = if (currentRoute == "home") Color(0xFF0484D8) else Color.Black
                )
            }

            IconButton(onClick = { navController.navigate("library") }) {
                Icon(
                    Icons.Filled.Book,
                    contentDescription = "Library",
                    modifier = Modifier.size(40.dp),
                    tint = if (currentRoute == "library") Color(0xFF0484D8) else Color.Black
                )
            }

            IconButton(onClick = { navController.navigate("notes") }) {
                Icon(
                    Icons.Filled.AttachFile,
                    contentDescription = "Notes",
                    modifier = Modifier.size(40.dp),
                    tint = if (currentRoute == "notes") Color(0xFF0484D8) else Color.Black
                )
            }

            IconButton(onClick = { navController.navigate("goals") }) {
                Icon(
                    Icons.Filled.Star,
                    contentDescription = "Goals",
                    modifier = Modifier.size(40.dp),
                    tint = if (currentRoute == "goals") Color(0xFF0484D8) else Color.Black
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Main Screen Preview")
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
