package com.example.ets_ppb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ets_ppb.ui.theme.ETS_PPBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ETS_PPBTheme {
                    ScheduleApp(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }

@Composable
fun ScheduleApp(modifier: Modifier = Modifier) {
    var shouldLogIn by rememberSaveable { mutableStateOf(true) }

    Surface(modifier) {
        if (shouldLogIn) {
            LoginScreen(onContinueClicked = { shouldLogIn = false })
        } else{
            JadwalScreen(onContinueClicked = {})
        }
    }

}


@Preview(showBackground = true)
@Composable
fun ETSPreview() {
    ETS_PPBTheme {
        ScheduleApp(modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun LoginScreen(onContinueClicked: () -> Unit,
                modifier: Modifier = Modifier) {
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }
    Image(
        painter = painterResource(id = R.drawable.jadwal_kuliah_page),
        contentDescription = "login image",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))

            Text("myITS", fontSize = 50.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text(
                text = "mahasiswa",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(60.dp))

            SelectionContainer(
                modifier = Modifier
                    .width(275.dp)
            ) {
                Text(
                    text = "MyITS ID",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text(text = "example@student.its.ac.id") },
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp
                ),
                modifier = Modifier
                    .background(color = Color.White)
            )

            Spacer(modifier = Modifier.height(20.dp))

            SelectionContainer(Modifier.width(275.dp)) {
                Text(
                    text = "Password",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text(text = "********") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .background(color = Color.White)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                modifier = Modifier
                    .height(50.dp)
                    .width(125.dp),
                onClick = onContinueClicked,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0, 208, 158))
            ) {
                Text("Log In", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            }
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Forget Password?", color = Color.White)
            }
        }
    }
}

@Composable
fun JadwalScreen(onContinueClicked: () -> Unit) {
    val scrollState = rememberScrollState()
    Image(
        painter = painterResource(id = R.drawable.schedule_page),
        contentDescription = "login image",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )


    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Row {
            SelectionContainer(
                Modifier
                    .width(300.dp)
                    .height(95.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxWidth()
                        .padding(vertical = 30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Jadwal Kuliah Mahasiswa",
                        fontSize = 23.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            Row {
                Column(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Hari Ini",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 5.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .border(1.dp, Color(196, 196, 196))
                    .background(color = Color(229, 229, 229))
            ) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "15.30", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = "to", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = "17.20", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.width(5.dp))
                Divider(
                    modifier = Modifier
                        .width(1.dp)
                        .height(100.dp),
                    color = Color(45, 186, 177)
                )

                Spacer(modifier = Modifier.width(5.dp))
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = "Kewirausahaan Berbasis Teknologi",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "Mata Kuliah Wajib",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Text(text = "Sains Tower 1", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                    Text(text = "Ruang 602", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                }
            }
            Divider(
                color = Color(196, 196, 196), thickness = 1.dp, modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp)
            )
            Row {
                Column(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Jadwal Kuliah Saya",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 1.dp)
                    )
                }
            }
            Divider(
                color = Color(196, 196, 196), thickness = 1.dp, modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp)
            )
            Row() {
                Column(
                ) {
                    Text(
                        text = "Selasa",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 5.dp)
                            .padding(horizontal = 20.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .border(1.dp, Color(196, 196, 196))
                    .background(color = Color(229, 229, 229))
            ) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "15.30", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = "to", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = "17.20", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.width(5.dp))
                Divider(
                    modifier = Modifier
                        .width(1.dp)
                        .height(100.dp),
                    color = Color(45, 186, 177)
                )

                Spacer(modifier = Modifier.width(5.dp))
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = "Kewirausahaan Berbasis Teknologi",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "Mata Kuliah Wajib",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Text(text = "Sains Tower 1", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                    Text(text = "Ruang 602", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                }
            }


            Row {
                Column(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Rabu",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 5.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .border(1.dp, Color(196, 196, 196))
                    .background(color = Color(229, 229, 229))
            ) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "13.30", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = "to", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = "15.20", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.width(5.dp))
                Divider(
                    modifier = Modifier
                        .width(1.dp)
                        .height(100.dp),
                    color = Color(45, 186, 177)
                )

                Spacer(modifier = Modifier.width(5.dp))
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = "Pemrograman Perangkat Bergerak",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "Mata Kuliah Wajib",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = "Gedung Informatika",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(text = "Ruang 302", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Spacer(modifier = Modifier.width(5.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .border(1.dp, Color(196, 196, 196))
                    .background(color = Color(229, 229, 229))
            ) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "15.30", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = "to", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = "17.20", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.width(5.dp))
                Divider(
                    modifier = Modifier
                        .width(1.dp)
                        .height(100.dp),
                    color = Color(45, 186, 177)
                )

                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(text = "Data Mining", fontSize = 14.sp, fontWeight = FontWeight.Bold,)
                    Text(
                        text = "Mata Kuliah Pilihan",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = "Gedung Informatika",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(text = "Ruang 102", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                }
            }
            Row {
                Column(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Kamis",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 5.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .border(1.dp, Color(196, 196, 196))
                    .background(color = Color(229, 229, 229))
            ) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "07.30", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = "to", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = "09.50", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.width(5.dp))
                Divider(
                    modifier = Modifier
                        .width(1.dp)
                        .height(100.dp),
                    color = Color(45, 186, 177)
                )

                Spacer(modifier = Modifier.width(5.dp))
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(text = "Text Mining", fontSize = 14.sp, fontWeight = FontWeight.Bold,)
                    Text(
                        text = "Mata Kuliah Pilihan",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = "Gedung Informatika",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(text = "Ruang 302", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }

}









