package com.example.chattingapplication.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.chattingapplication.R

@Composable
fun ProfilePage(navController: NavController , modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()

            .verticalScroll(scrollState) // Add vertical scroll
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomStart
        ) {
            Image(painter = painterResource(id = R.drawable.sampel_profile), // Replace with your actual image
                contentDescription = "Profile Image", // Add a meaningful description
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(bottomEnd = 32.dp, bottomStart = 32.dp))
            )

            Text(
                text = "Anna, 19",
                modifier = Modifier.padding(bottom = 32.dp, start = 16.dp),
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(32.dp))

        TagRow()

        Spacer(modifier = Modifier.height(32.dp))

        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )

        // Languages Section
        Text(
            text = "Languages I Know",
            fontSize = 28.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp) // Consistent padding
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp) // Consistent padding
        ) {
            TagCard(text = "Hindi")
            TagCard(text = "English")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Divider(
                color = Color.Gray,
        thickness = 1.dp,
        modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Other Interests Section (Consider using a LazyRow here for better performance)
        Row(modifier = Modifier.padding(8.dp)) {
            TagCard(text = "Drinking")
            TagCard(text = "Eating")
            TagCard(text = "Sleeping")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth())

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentAlignment = Alignment.CenterStart
        ){
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF292E38)
            )){
                Text(
                    text = "About Me",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}



@Composable
fun TagCard(text: String) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp) // Reduced padding for better spacing
            .width(100.dp)
            .height(30.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF292E38)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box( // Using Box for simpler centering
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun TagRow() {
    Row {
        TagCard(text = "#Music")
        TagCard(text = "#Movies")
        TagCard(text = "#Gaming")
        // Add more TagCards as needed
    }
}



@Preview(showBackground = true , showSystemUi = true)
@Composable
fun profilePagePreview(){
    ProfilePage(rememberNavController())
}