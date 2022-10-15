package com.example.smarttasktrackerbyamansharma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import com.example.smarttasktrackerbyamansharma.ui.theme.SmartTaskTrackerTheme
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartTaskTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    val deadlines:ArrayList<MutableMap<String, Any>> = arrayListOf(
        mutableMapOf(
            "id" to "1",
            "date" to "2021-10-20 23:55",
            "title" to "Complete Bio Assignment",
            "description" to "Biology Gene Assigment. Assigned Gene: CAT. To be submitted by 20 Oct."
        ),
        mutableMapOf(
            "id" to "2",
            "date" to "2021-10-31 15:00",
            "title" to "Submit Intern Application",
            "description" to "Submit Intern Application to Smart Solutions Inc."
        )
    )

    val todos:ArrayList<MutableMap<String, String>> = arrayListOf(
        mutableMapOf(
            "id" to "1",
            "title" to "Study for Physics Exams",
            "description" to "Exam on 21 Oct."
        ),
        mutableMapOf(
            "id" to "2",
            "title" to "Complete Portfolio Website",
            "description" to "Add Qualifications to Profile Website and add dark theme. Test responsiveness on mobile devices."
        )
    )

    val scrollState = rememberScrollState()


    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(state = scrollState)
    ) {

        Text(
            text = "Smart Task Tracker",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .border(width = 2.dp, Color.Black)
                .background(Color.Yellow.copy(alpha = 0.9f))
                .padding(16.dp)
        )

        Text(
            text = "Deadlines",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(width = 2.dp, Color.Black)
                .padding(16.dp)
        )

        if (deadlines.size == 0) {

            Text(
                text = "You have no deadines",
                style = TextStyle(
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

        }
        else {
            for (i in 0..(deadlines.size-1)){
                Text(
                    text = "${i+1}. ${deadlines[i]["title"]}\n\nDeadline: ${deadlines[i]["date"]}\n\n${deadlines[i]["description"]}",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .padding(16.dp)
                )

            }
        }

        Text(
            text = "Todos",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(width = 2.dp, Color.Black)
                .padding(16.dp)
        )

        if (todos.size == 0) {

            Text(
                text = "You have no deadines",
                style = TextStyle(
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
        else {
            for (i in 0..(todos.size-1)){
                Text(
                    text = "${i+1}. ${todos[i]["title"]}\n\n${todos[i]["description"]}",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .padding(16.dp)
                )

            }
        }



    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SmartTaskTrackerTheme {
        HomeScreen()
    }
}