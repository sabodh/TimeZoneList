package com.sample.mapping.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.mapping.data.entity.TimeZoneMember
import com.sample.mapping.data.entity.getCurrentTimeAndFormat
import com.sample.mapping.data.repository.TimeZoneRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val timeZoneRepository: TimeZoneRepository
) : ViewModel() {

    private val _timeZoneList: MutableStateFlow<List<TimeZoneMember>> =
        MutableStateFlow(emptyList())
    val timeZoneList: StateFlow<List<TimeZoneMember>> = _timeZoneList

    private val _showLoaded: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val showLoaded: StateFlow<Boolean> = _showLoaded

    init {
        viewModelScope.launch {
            _showLoaded.value = true
            val timezoneMember = timeZoneRepository.getTimezoneList()
            val updatedTimezoneMember = timezoneMember.map { timeZoneMember ->
                timeZoneMember.copy(currentTime = getCurrentTimeAndFormat(timeZoneMember.timezone))
            }
            _timeZoneList.value = updatedTimezoneMember
            _showLoaded.value = false
        }
    }


}
