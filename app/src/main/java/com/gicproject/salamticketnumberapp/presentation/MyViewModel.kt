package com.gicproject.salamticketnumberapp.presentation

import android.annotation.SuppressLint
import android.os.Handler
import android.util.Log
import android_serialport_api.SerialPort
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gicproject.emojisurveyapp.common.Resource
import com.gicproject.emojisurveyapp.domain.repository.DataStoreRepository
import com.gicproject.salamticketnumberapp.common.Constants
import com.gicproject.salamticketnumberapp.common.Constants.Companion.NO_COUNTER_SELECTED
import com.gicproject.salamticketnumberapp.common.Constants.Companion.lEDG
import com.gicproject.salamticketnumberapp.common.Constants.Companion.lEDOFF
import com.gicproject.salamticketnumberapp.common.Constants.Companion.lEDON
import com.gicproject.salamticketnumberapp.common.Constants.Companion.lEDR
import com.gicproject.salamticketnumberapp.domain.model.TicketNumber
import com.gicproject.salamticketnumberapp.domain.use_case.MyUseCases
import com.gicproject.salamticketnumberapp.led.LampsUtil
import com.gicproject.salamticketnumberapp.led.UartSend
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class MyViewModel @Inject constructor(
    private val surveyUseCases: MyUseCases,
    private val repository: DataStoreRepository
) : ViewModel() {

    private val _selectedCounterName = MutableStateFlow(NO_COUNTER_SELECTED)
    val selectedCounterName: StateFlow<String>
        get() = _selectedCounterName.asStateFlow()

    private val _selectedCounterId = MutableStateFlow("")
    val selectedCounterId: StateFlow<String>
        get() = _selectedCounterId.asStateFlow()

    private val _selectedBlinkCount = MutableStateFlow(4)
    val selectedBlinkCount: StateFlow<Int>
        get() = _selectedBlinkCount.asStateFlow()


    private val _ticketNumber = mutableStateOf(TicketNumber(0, "Intializing"))
    val ticketNumber: State<TicketNumber> = _ticketNumber

    private val _stateSetting = mutableStateOf(SettingScreenState())
    val stateSetting: State<SettingScreenState> = _stateSetting

    private val _isRefreshingSetting = MutableStateFlow(false)
    val isRefreshingSetting: StateFlow<Boolean>
        get() = _isRefreshingSetting.asStateFlow()

    private val _stateTicket = mutableStateOf(TicketScreenState())
    val stateTicket: State<TicketScreenState> = _stateTicket

    private val _isDarkTheme = mutableStateOf(false)
    val isDarkTheme: State<Boolean> = _isDarkTheme


    init {
        var lampUtil :LampsUtil  = LampsUtil()
        Log.d("TAG", "init called: ")
        initPreference()
        onEvent(MyEvent.GetTicket)
        onEvent(MyEvent.GetBlinkCount)


    }

    private fun initPreference() {
        viewModelScope.launch {
            initCounterNamePreference()
            initBlinkCountPreference()
        }
    }
var job: Job? = null
    private fun blinkEffect() {
        job?.cancel()
        job =  viewModelScope.launch {
            val tempTicket = ticketNumber.value.number

            val blinkCounter = _selectedBlinkCount.value
            Log.d("TAG", "blinkEffect: ${_selectedBlinkCount.value}")
            var i = 0
            while (i < blinkCounter) {
                i += 1;
                delay(500L)
               // offLamps()
                _stateTicket.value = _stateTicket.value.copy(ticketNumber = TicketNumber(ticketNumber.value.status, ""))
                Log.d("TAG", "blinkEffect: value of ticket number1 ${tempTicket}")
                delay(500L)
              //  greenLamps()
                _stateTicket.value =
                    _stateTicket.value.copy(ticketNumber = TicketNumber(ticketNumber.value.status, tempTicket))
                Log.d("TAG", "blinkEffect: value of ticket number ${tempTicket}")

            }


        }
    }

    private suspend fun initCounterNamePreference() {
        val locationName = repository.getString(Constants.KEY_COUNTER_NAME)
        val locationId = repository.getString(Constants.KEY_COUNTER_ID)

        if (locationId != null) {
            _selectedCounterId.value = locationId
        }
        if (locationName != null) {
            _selectedCounterName.value = locationName
        }
    }

    private suspend fun initBlinkCountPreference() {

        val blinkCount = repository.getInt(Constants.KEY_BLINK_COUNT)
        if (blinkCount != null) {
            _selectedBlinkCount.value = blinkCount
        }
    }

    fun ledRedOn() {
        writeValue(lEDR, lEDON)
    }

    fun ledRedOff() {
        writeValue(lEDR, lEDOFF)
    }

    fun ledYellowOn() {
        writeValue(lEDG, lEDON)
    }

    fun ledYellowOff() {
        writeValue(lEDG, lEDOFF)
    }

    fun ledGreenOn() {
        writeValue(lEDG, lEDON)
        writeValue(lEDG, lEDON)
    }

    fun ledGreenOff() {
        writeValue(lEDG, lEDOFF)
        writeValue(lEDG, lEDOFF)
    }

    fun saveCounter(counterName: String?, counterId: Int?) {
        viewModelScope.launch {
            if (counterId != null) {
                repository.putString(Constants.KEY_COUNTER_NAME, counterName.toString())
                repository.putString(Constants.KEY_COUNTER_ID, counterId.toString())
                initCounterNamePreference()
            }
        }
    }

    fun saveBlinkCount(count: Int) {
        viewModelScope.launch {
            try{
                repository.putInt(Constants.KEY_BLINK_COUNT, count)
                initBlinkCountPreference()
            }catch (e: java.lang.Exception){
                e.printStackTrace()
            }

        }
    }

    fun onEvent(event: MyEvent) {
        when (event) {
            is MyEvent.GetLocation -> {
                surveyUseCases.getLocations().onEach { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data?.let {
                                _stateSetting.value = SettingScreenState(locations = it)
                            }
                        }
                        is Resource.Error -> {
                            _stateSetting.value = SettingScreenState(
                                error = result.message ?: "An unexpected error occurred"
                            )
                        }
                        is Resource.Loading -> {
                            _stateSetting.value = SettingScreenState(isLoading = true)
                        }
                    }
                }.launchIn(viewModelScope)
            }
            is MyEvent.GetTicket -> {
                Log.d("TAG", "onEvent: called getticket")
                if(_selectedCounterId.value.isNotEmpty()){
                    surveyUseCases.getCounterStatus(_selectedCounterId.value).onEach { result ->
                        when (result) {
                            is Resource.Success -> {
                                result.data?.let {
                                    _stateTicket.value =  _stateTicket.value.copy(ticketNumber = it, error = "")
                                    if(it.status == 1){
                                        blueLamps()
                                    }else{
                                        greenLamps()
                                        if(
                                            _ticketNumber.value.number != it.number){
                                            _ticketNumber.value = it
                                            blinkEffect()

                                        }else{
                                            _ticketNumber.value = it
                                        }
                                    }

                                }
                                delay(1000)
                                onEvent(MyEvent.GetTicket)
                            }
                            is Resource.Error -> {
                                _stateTicket.value =  _stateTicket.value.copy(
                                    error = result.message ?: "An unexpected error occurred"
                                )
                                delay(500)
                                onEvent(MyEvent.GetTicket)
                            }
                            is Resource.Loading -> {
                            }
                        }
                    }.launchIn(viewModelScope)
                }else{
                    viewModelScope.launch {
                        delay(1000)
                        onEvent(MyEvent.GetTicket)
                    }

                }
            }
            is MyEvent.GetBlinkCount -> {
                    surveyUseCases.getBlinkCount().onEach { result ->
                        when (result) {
                            is Resource.Success -> {
                                result.data?.let {
                                    it.blinkingCount?.let { it1 -> saveBlinkCount(it1) }
                                }
                                delay(5000)
                                onEvent(MyEvent.GetBlinkCount)
                            }
                            is Resource.Error -> {
                                _stateTicket.value =  _stateTicket.value.copy(
                                    error = result.message ?: "An unexpected error occurred"
                                )
                                delay(5000)
                                onEvent(MyEvent.GetBlinkCount)
                            }
                            else -> {}
                        }
                    }.launchIn(viewModelScope)

            }
            else -> {

            }
        }
    }

    fun changeTheme() {
        _isDarkTheme.value = !_isDarkTheme.value
    }


    private fun writeValue(gpo: String, value: String) {
        val file = File(gpo)
        val os: FileOutputStream?
        try {
            os = FileOutputStream(file, true)
            os.write(value.toByteArray())
            os.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    //light
    @Throws(IOException::class)
    fun blueLamps() {

        val runnableLoop: Runnable = object : Runnable {
            @SuppressLint("SuspiciousIndentation")
            override fun run() {
                try {
                    val ttyS1 = SerialPort(File("/dev/ttyS1"), 115200, 0)
                    UartSend.UartAllB(ttyS1, "ttyS1").run()

                } catch (e: SecurityException) {
                    e.printStackTrace()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        runnableLoop.run()
    }

    @Throws(IOException::class)
    fun greenLamps() {
        val runnableLoop: Runnable = object : Runnable {
            //LOOP thread
            @SuppressLint("SuspiciousIndentation")
            override fun run() {
                try {
                    val ttyS1 = SerialPort(File("/dev/ttyS1"), 115200, 0)
                    UartSend.UartAllG(ttyS1, "ttyS1").run()

                } catch (e: SecurityException) {
                    e.printStackTrace()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        runnableLoop.run()
    }

    @Throws(IOException::class)
    fun redLamps() {
        val runnableLoop: Runnable = object : Runnable {
            //LOOP thread
            @SuppressLint("SuspiciousIndentation")
            override fun run() {
                try {
                    var  ttyS1 = SerialPort(File("/dev/ttyS1"), 115200, 0)
                    UartSend.UartAllR(ttyS1, "ttyS1").run()

                } catch (e: SecurityException) {
                    e.printStackTrace()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        runnableLoop.run()
    }

    @Throws(IOException::class)
    fun yellowLamps() {
        val handlerLoop = Handler()
        val runnableLoop: Runnable = object : Runnable {
            @SuppressLint("SuspiciousIndentation")
            override fun run() {
                try {
                    Log.d("TAG", "run: called run")
                    var  ttyS1 = SerialPort(File("/dev/ttyS1"), 115200, 0)
                    UartSend.UartAllG(ttyS1, "ttyS1").run()

                } catch (e: SecurityException) {
                    e.printStackTrace()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        runnableLoop.run()



    }

    fun offLamps() {
        viewModelScope.launch {
            try {
                var ttyS1 = SerialPort(File("/dev/ttyS1"), 115200, 0)
                UartSend.UartAllOff(ttyS1, "ttyS1").run()
            } catch (e: SecurityException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }


    }

}

