package com.gicproject.salamticketnumberapp.presentation

import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import com.gicproject.emojisurveyapp.domain.model.Location
import com.gicproject.salamticketnumberapp.R
import com.gicproject.salamticketnumberapp.ui.theme.TicketNumberAppTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun SettingScreen(
    navController: NavController,
    viewModel: MyViewModel,
) {

    val context = LocalContext.current
    val state = viewModel.stateSetting.value
    val isRefreshing by viewModel.isRefreshingSetting.collectAsState()

    val counterName by viewModel.selectedCounterName.collectAsState()
    val counterId by viewModel.selectedCounterId.collectAsState()

    val blinkCount by viewModel.selectedBlinkCount.collectAsState()

    var isCounterExpanded by remember { mutableStateOf(false) }

    var selectedIndex by remember { mutableStateOf(-1) }


    LaunchedEffect(true) {
        viewModel.onEvent(MyEvent.GetLocation)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = { Text("Settings") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            Icons.Filled.KeyboardArrowLeft,
                            "back arrow",
                            tint = Color.White,
                            modifier = Modifier
                                .size(100.dp, 100.dp)
                        )
                    }

                },
                actions = {
                    ThemeSwitcher(onThemeSwitch = {
                        viewModel.changeTheme()
                    })
                }
            )
        },
    ) { innerPadding ->
        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing),
            onRefresh = {
                Log.d("TAG", "SettingScreen: swipe refresh")
                viewModel.onEvent(MyEvent.GetLocation)
            },
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        MaterialTheme.colors.surface,
                    )
            ) {
                Modifier.padding(innerPadding)
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(top = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (state.isLoading) {
                        CircularProgressIndicator()
                    }
                    ComposeMenu(
                        menuItems = state.locations,
                        menuExpandedState = isCounterExpanded,
                        selectedIndex = selectedIndex,
                        onDismissMenuView = {
                            isCounterExpanded = false
                        },
                        updateExpandedValue = {
                            isCounterExpanded = true
                        },
                        onMenuItemClick = { index, item ->
                            selectedIndex = index
                            isCounterExpanded = false
                            viewModel.saveCounter(item.Name,item.ID)
                        }
                    )
                    Text(
                        "Selected Counter: $counterName",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 30.dp)
                    )
                    Text(
                        "Selected Counter Id: $counterId",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 30.dp)
                    )
                        Row() {
                            Button( onClick = {
                                if((blinkCount -1 ) >= 0){
                                    viewModel.saveBlinkCount(blinkCount - 1)
                                }
                               }){
                                Text("-")
                            }
                            Text(text = "blink count: ${blinkCount.toString()}",)
                            Button(onClick = { viewModel.saveBlinkCount(blinkCount + 1) }){
                                Text("+")
                            }
                        }
                    IntentToSetting(context)
                }
                if (state.error.isNotBlank()) {
                    ErrorMsg(errorMsg = state.error)
                }
            }
        }
    }
}

@Composable
fun IntentToSetting(context: Context) {
    Button(
        modifier = Modifier.padding(top = 30.dp),
        onClick = {
            startActivity(context, Intent(Settings.ACTION_SETTINGS), null)

        }) {
        Icon(
            Icons.Filled.Settings,
            "setting",
            tint = Color.White,
            modifier = Modifier
                .size(30.dp, 30.dp)
        )

        Text(text = "Open Settings", Modifier.padding(start = 10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TicketNumberAppTheme {
    }
}

@Composable
fun ComposeMenu(
    menuItems: List<Location>,
    menuExpandedState: Boolean,
    selectedIndex: Int,
    updateExpandedValue: () -> Unit,
    onDismissMenuView: () -> Unit,
    onMenuItemClick: (Int, Location) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .border(0.5.dp, MaterialTheme.colors.onSurface.copy(alpha = 0.5f))
            .clickable(
                onClick = {
                    updateExpandedValue()
                },
            ),
    ) {
        ConstraintLayout(
            modifier = Modifier
                .size(width = 300.dp, height = 60.dp)
                .padding(16.dp)
        ) {
            val (label, iconView) = createRefs()
            Text(
                text = if (selectedIndex != -1) menuItems[selectedIndex].Name.toString() else "Select Location",
                color = Color.Black,
                modifier = Modifier
                    .constrainAs(label) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(iconView.start)
                        width = Dimension.fillToConstraints
                    }
            )

            val displayIcon: Painter = painterResource(
                id = R.drawable.ic_drop_down
            )

            Icon(
                painter = displayIcon,
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp, 20.dp)
                    .constrainAs(iconView) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                tint = MaterialTheme.colors.onSurface
            )
            DropdownMenu(
                expanded = menuExpandedState,
                onDismissRequest = { onDismissMenuView() },
                modifier = Modifier
                    .background(MaterialTheme.colors.background)
            ) {
                menuItems.forEachIndexed { index, item ->
                    DropdownMenuItem(
                        onClick = {
                            onMenuItemClick(index, item)
                        }) {
                        Text(text = item.Name.toString() + " " +item.ID.toString())
                    }
                }
            }
        }
    }
}
