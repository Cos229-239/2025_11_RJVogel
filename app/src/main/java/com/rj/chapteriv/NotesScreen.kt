package com.rj.chapteriv

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun NotesScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        CurrentBook()
        Spacer(modifier = Modifier.height(24.dp))
        NoteSections(navController)
    }
}

@Composable
fun CurrentBook() {
    Row{
        Text(
            "NOTES",
            fontSize = 57.sp,
            color = Color(0xFF0AAAFE6)
        )

        Spacer(modifier = Modifier.width(130.dp))

        IconButton(onClick = { /* TODO: open menu */ }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                modifier = Modifier.size(90.dp),
                tint = Color.White,
            )
        }
    }

    Spacer(modifier = Modifier.height(22.dp))

    Button(onClick = { /* TODO: choose book from library */ },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF0AAAFE6)),
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)){
        Text(
            "Select book from Library",
            fontSize = 20.sp)
    }

    Spacer(modifier = Modifier.height(22.dp))

    Row{
        Image(painter = painterResource(id = android.R.drawable.ic_menu_gallery),
            contentDescription = "Book Cover",
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.width(30.dp))

        Column{
            Text("BOOK TITLE",
                fontSize = 30.sp,
                color = Color(0xFF0AAAFE6)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("Author Name",
                fontSize = 20.sp,
                color = Color(0xFF0AAAFE6)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row{
                CircularProgressIndicator(
                    progress = 0.66f,
                    modifier = Modifier
                        .size(63.dp),
                    strokeWidth = 5.dp,
                    color = Color(0xFF00A8E8)
                )

                Spacer(modifier = Modifier.width(24.dp))

                Column{
                    Box(
                        modifier = Modifier
                            .size(width = 125.dp, height = 20.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color(0xFF00A8E8)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "XXX Pages Left",
                            fontSize = 12.sp,
                            color = Color(0xFF0346C6B)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Box(
                        modifier = Modifier
                            .size(width = 125.dp, height = 20.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color(0xFF00A8E8)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "XXX Hours Left",
                            fontSize = 12.sp,
                            color = Color(0xFF0346C6B)
                        )
                    }
                }
            }
        }
    }

    Spacer(modifier = Modifier.height(24.dp))

    Row{
        Box(
            modifier = Modifier
                .size(width = 80.dp, height = 30.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF0AAAFE6),
                    shape = RoundedCornerShape(6.dp)
                ),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Total Pages",
                fontSize = 12.sp,
                color = Color(0xFF0AAAFE6)
            )
        }

        Spacer(modifier = Modifier.width(24.dp))

        Box(
            modifier = Modifier
                .size(width = 150.dp, height = 30.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF0AAAFE6),
                    shape = RoundedCornerShape(6.dp)
                ),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Published: MM/DD/YYYY",
                fontSize = 12.sp,
                color = Color(0xFF0AAAFE6)
            )
        }

        Spacer(modifier = Modifier.width(24.dp))

        Box(
            modifier = Modifier
                .size(width = 80.dp, height = 30.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF0AAAFE6),
                    shape = RoundedCornerShape(6.dp)
                ),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Genre",
                fontSize = 12.sp,
                color = Color(0xFF0AAAFE6)
            )
        }
    }
}

@Composable
fun NoteSections(navController: NavHostController) {
    Spacer(modifier = Modifier.height(40.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Color(0xFF0AAAFE6))
            .clickable { navController.navigate("characterNotes") },
        contentAlignment = Alignment.TopStart,
    ) {
        Text(
            text = "Characters   >",
            fontSize = 28.sp,
            color = Color.White
        )
    }

    Spacer(modifier = Modifier.height(20.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Color(0xFF0AAAFE6))
            .clickable { navController.navigate("quoteNotes") },
        contentAlignment = Alignment.TopStart,
    ) {
        Text(
            text = "Quotes   >",
            fontSize = 28.sp,
            color = Color.White
        )
    }

    Spacer(modifier = Modifier.height(20.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Color(0xFF0AAAFE6))
            .clickable { navController.navigate("thoughtNotes") },
        contentAlignment = Alignment.TopStart,
    ) {
        Text(
            text = "Thoughts   >",
            fontSize = 28.sp,
            color = Color.White
        )
    }
}

@Composable
fun CharacterNotesScreen(navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Character Notes", fontSize = 24.sp, color = Color(0xFF0AAAFE6))
        Spacer(modifier = Modifier.height(16.dp))

        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Write your character notes here") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                cursorColor = Color.White,
                focusedIndicatorColor = Color(0xFF00A8E8),
                unfocusedIndicatorColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Save & Return")
        }
    }
}

@Composable
fun QuoteNotesScreen(navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Quotes", fontSize = 24.sp, color = Color(0xFF0AAAFE6))
        Spacer(modifier = Modifier.height(16.dp))

        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Write your notes") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                cursorColor = Color.White,
                focusedIndicatorColor = Color(0xFF00A8E8),
                unfocusedIndicatorColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Save & Return")
        }
    }
}

@Composable
fun ThoughtNotesScreen(navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Thoughts", fontSize = 24.sp, color = Color(0xFF0AAAFE6))
        Spacer(modifier = Modifier.height(16.dp))

        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Write your thoughts out here") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                cursorColor = Color.White,
                focusedIndicatorColor = Color(0xFF00A8E8),
                unfocusedIndicatorColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Save & Return")
        }
    }
}

@Preview(showBackground = true, name = "Notes Screen Preview")
@Composable
fun Prev() {
    val navController = rememberNavController()
    NotesScreen(navController)


}