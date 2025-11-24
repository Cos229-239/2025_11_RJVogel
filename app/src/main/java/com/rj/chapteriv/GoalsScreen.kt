package com.rj.chapteriv

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

data class Goal(
    val title: String,
    var isCompleted: Boolean = false,
)
@Composable
fun GoalsScreen(navController: NavHostController){
    var activeGoals by remember { mutableStateOf(listOf(
        Goal("READ FOR 30 MINUTES"),
        Goal("UPDATE BOOK NOTES")
    )) }
    var completedGoals by remember { mutableStateOf(listOf<Goal>()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Streak()
        Spacer(modifier = Modifier.height(24.dp))
        Goals(
            activeGoals = activeGoals,
            completedGoals = completedGoals,
            onAddGoal = { newGoal ->
                activeGoals = activeGoals + newGoal
            },
            onCompleteGoal = { goal ->
                activeGoals = activeGoals - goal
                completedGoals = completedGoals + goal.copy(isCompleted = true)
            }
        )
    }
}

@Composable
fun Streak() {
    Row{
        Text(
            "GOALS",
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

    Spacer(modifier = Modifier.height(24.dp))

    Text(
        "Reading Streak:",
        fontSize = 30.sp,
        color = Color(0xFF0AAAFE6)
    )

    Spacer(modifier = Modifier.height(16.dp))

    Row{
        Box(
            modifier = Modifier
                .size(width = 35.dp, height = 35.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF0AAAFE6),
                    shape = RoundedCornerShape(18.dp)
                ),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "S",
                fontSize = 18.sp,
                color = Color(0xFF0AAAFE6)
            )
        }

        Spacer(modifier = Modifier.width(18.dp))

        Box(
            modifier = Modifier
                .size(width = 35.dp, height = 35.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF0AAAFE6),
                    shape = RoundedCornerShape(18.dp)
                ),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "M",
                fontSize = 18.sp,
                color = Color(0xFF0AAAFE6)
            )
        }

        Spacer(modifier = Modifier.width(18.dp))

        Box(
            modifier = Modifier
                .size(width = 35.dp, height = 35.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF0AAAFE6),
                    shape = RoundedCornerShape(18.dp)
                ),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "T",
                fontSize = 18.sp,
                color = Color(0xFF0AAAFE6)
            )
        }

        Spacer(modifier = Modifier.width(18.dp))

        Box(
            modifier = Modifier
                .size(width = 35.dp, height = 35.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF0AAAFE6),
                    shape = RoundedCornerShape(18.dp)
                ),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "W",
                fontSize = 18.sp,
                color = Color(0xFF0AAAFE6)
            )
        }

        Spacer(modifier = Modifier.width(18.dp))

        Box(
            modifier = Modifier
                .size(width = 35.dp, height = 35.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF0AAAFE6),
                    shape = RoundedCornerShape(18.dp)
                ),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "T",
                fontSize = 18.sp,
                color = Color(0xFF0AAAFE6)
            )
        }

        Spacer(modifier = Modifier.width(18.dp))

        Box(
            modifier = Modifier
                .size(width = 35.dp, height = 35.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF0AAAFE6),
                    shape = RoundedCornerShape(18.dp)
                ),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "F",
                fontSize = 18.sp,
                color = Color(0xFF0AAAFE6)
            )
        }

        Spacer(modifier = Modifier.width(18.dp))

        Box(
            modifier = Modifier
                .size(width = 35.dp, height = 35.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF0AAAFE6),
                    shape = RoundedCornerShape(18.dp)
                ),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "S",
                fontSize = 18.sp,
                color = Color(0xFF0AAAFE6)
            )
        }
    }
}

@Composable
fun Goals(
    activeGoals: List<Goal>,
    completedGoals: List<Goal>,
    onAddGoal: (Goal) -> Unit,
    onCompleteGoal: (Goal) -> Unit
) {
    Spacer(modifier = Modifier.height(24.dp))

    Row {
        Spacer(modifier = Modifier.width(24.dp))
        Text("${activeGoals.size} GOALS LEFT!", fontSize = 28.sp, color = Color(0xFF0AAAFE6))
        Spacer(modifier = Modifier.width(80.dp))

        IconButton(
            onClick = { onAddGoal(Goal("NEW GOAL")) }, // 👈 Add a placeholder goal
            modifier = Modifier.offset(y = (-10).dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add", modifier = Modifier.size(32.dp), tint = Color.White)
        }
    }

    Spacer(modifier = Modifier.height(24.dp))

    // Active goals
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        activeGoals.forEach { goal ->
            Box(
                modifier = Modifier
                    .size(width = 150.dp, height = 150.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color(0xFF0AAAFE6))
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                    Text(goal.title, fontSize = 18.sp, textAlign = TextAlign.Center, color = Color.Black)
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = { onCompleteGoal(goal) },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0484D8), contentColor = Color.White),
                        modifier = Modifier.height(36.dp)
                    ) {
                        Text("Complete")
                    }
                }
            }
            Spacer(modifier = Modifier.width(28.dp))
        }
    }

    Spacer(modifier = Modifier.height(32.dp))

    Text("Completed Goals:", fontSize = 28.sp, color = Color(0xFF0AAAFE6))
    Spacer(modifier = Modifier.height(24.dp))

    // Completed goals
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        completedGoals.forEach { goal ->
            Box(
                modifier = Modifier
                    .size(width = 150.dp, height = 150.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color.Gray),
                contentAlignment = Alignment.Center
            ) {
                Text(goal.title, fontSize = 18.sp, textAlign = TextAlign.Center, color = Color.White)
            }
            Spacer(modifier = Modifier.width(28.dp))
        }
    }
}


@Preview(showBackground = true, name = "Goals Screen Preview")
@Composable
fun PreviewGoals() {
    val navController = rememberNavController()
    GoalsScreen(navController)
}