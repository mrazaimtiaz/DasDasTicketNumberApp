package com.gicproject.salamticketnumberapp.presentation

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gicproject.salamticketnumberapp.Screen
import com.gicproject.salamticketnumberapp.common.Constants
import com.gicproject.salamticketnumberapp.R

@Composable
fun QuestionScreen(
    navController: NavController,
    viewModel: MyViewModel,
) {
    val state = viewModel.stateTicket.value
    var isNavigateSetting = true

    val counterId by viewModel.selectedCounterId.collectAsState()

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    MaterialTheme.colors.surface,
                )
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ){
                Row() {
                    Image(
                        painter = painterResource(R.drawable.part2salam),
                        contentScale = ContentScale.FillBounds,
                        contentDescription = null,
                        modifier = Modifier
                            .pointerInput(Unit) {
                                detectDragGestures { change, _ ->
                                    if (change.position.y > 400) {
                                        if (isNavigateSetting) {
                                            isNavigateSetting = false
                                            navController.navigate(Screen.SettingScreen.route)
                                        }
                                    }
                                    change.consume()
                                }
                            }
                            .fillMaxSize()
                            .weight(1.0f)
                    )
                    Image(
                        painter = painterResource(R.drawable.part1),
                        contentScale = ContentScale.FillBounds,
                        contentDescription = null,
                        modifier = Modifier
                            .pointerInput(Unit) {
                                detectDragGestures { change, _ ->
                                    if (change.position.y > 400) {
                                        if (isNavigateSetting) {
                                            isNavigateSetting = false
                                            navController.navigate(Screen.SettingScreen.route)
                                        }
                                    }
                                    change.consume()
                                }
                            }
                            .fillMaxSize()
                            .weight(2.0f)
                    )
                }

            }
            Modifier.padding(innerPadding)
            Column(
                modifier = Modifier.fillMaxSize()
            ) {

                Row(modifier = Modifier.fillMaxSize(),) {

                    Column(modifier = Modifier
                        .weight(1.0f)
                        .fillMaxSize().padding(bottom = 120.dp),
                        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            counterId,
                            color = Color.White,
                            fontSize = 488.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }

                    Column(modifier = Modifier
                        .weight(2.0f)
                        .fillMaxSize().padding(bottom = 80.dp),
                        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                       if(state.ticketNumber.status == 2){
                           Text(
                               state.ticketNumber.number.toString(),
                               color = Color(0xff003a6c),
                               fontSize = 358.sp,
                               fontWeight = FontWeight.Bold,
                           )
                       }else if(state.ticketNumber.status == 1){
                           Image(
                               painterResource( R.drawable.daslogo),
                               contentDescription = "ghp logo",
                               contentScale = ContentScale.Fit,
                               modifier = Modifier.size(688.dp, 688.dp).padding(top =70.dp)
                           )
                       }

                    }
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp)
                ) {
                    if (state.isLoadingSubmit) {
                        LinearProgressIndicator()
                    }
                }
            }
            if (state.error.isNotBlank()) {
                if (state.error == Constants.NO_COUNTER_SELECTED) {
                    if (counterId.isEmpty()) {
                        ErrorMsg(errorMsg = state.error)
                    }
                } else {
                    ErrorMsg(errorMsg = state.error)
                }
            }

            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            if (state.success.isNotBlank()) {
                LaunchedEffect(key1 = true) {

                }
            }
        }
    }
}

@Composable
fun TopIcon(settingClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LogoImage(image = R.drawable.hyundailogo, Modifier.pointerInput(Unit) {
            detectDragGestures { change, _ ->
                if (change.position.y > 400) {
                    settingClick()
                }
                change.consume()
            }
        })
        LogoImage(image = R.drawable.textlogo)
    }
}

@Composable
fun EmojiItem(onClick: () -> Unit, textEn: String, textAr: String, image: String?, color: Color) {
    var bitmap: ImageBitmap? = null
    if (image != null) {
        try {
            bitmap = image.toBitmap().asImageBitmap()
        } catch (e: java.lang.Exception) {
            bitmap = null
        }
    }
    Column(
        modifier = Modifier
            .padding(end = 40.dp)
            .clickable {
                onClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            textEn,
            fontSize = 35.sp,
            color = color,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.2.sp
        )
        bitmap?.let {
            Image(
                bitmap = it,
                contentDescription = "logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(200.dp, 200.dp)

            )
        }
        Text(
            textAr,
            fontSize = 35.sp,
            color = color,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.2.sp
        )
    }
}

@Composable
fun LogoImage(image: Int, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painterResource(image),
            contentDescription = "ghp logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(80.dp, 80.dp)
        )
    }

}

@Composable
fun ErrorMsg(errorMsg: String) {
    Text(
        text = errorMsg,
        color = MaterialTheme.colors.error,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    )
}


@Composable
fun ThemeSwitcher(onThemeSwitch: () -> Unit) {
    val isDark = remember { mutableStateOf(false) }
    @DrawableRes val light = R.drawable.ic_light
    @DrawableRes val dark = R.drawable.ic_dark
    IconButton(onClick = {
        onThemeSwitch()
        isDark.value = !isDark.value
    }) {
        Icon(
            painter = if (isDark.value) painterResource(light) else painterResource(dark),
            contentDescription = "theme switcher",
            tint = Color.White
        )
    }
}

fun String.toBitmap(): Bitmap {
    Base64.decode(this, Base64.DEFAULT).apply {
        return BitmapFactory.decodeByteArray(this, 0, size)
    }
}

val String.color
    get() = Color(android.graphics.Color.parseColor(this))
