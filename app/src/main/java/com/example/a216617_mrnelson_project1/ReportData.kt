package com.example.a216617_mrnelson_project1

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

// -------------------- DATA class saya --------------------

data class ReportMessage(val type: String,val agency: String,val title: String, val issue: String, val location: String)

// -------------------- VIEWMODEL kite --------------------

class ReportViewModel : ViewModel() {
    private val _messages = mutableStateListOf<ReportMessage>()
    val messages: List<ReportMessage> = _messages

    // 1. Count by Type (For the 4 categories)
    fun getCountByType(type: String): Int {
        return _messages.count { it.type == type }
    }

    // 2. Count by Agency
    fun getAgencyStats(): Map<String, Int> {
        return _messages.groupBy { it.agency }.mapValues { it.value.size }
    }


    fun addMessage(type: String, agency: String,title: String, issue: String, location: String) {
        _messages.add(ReportMessage(type,agency,title, issue, location))
    }
}