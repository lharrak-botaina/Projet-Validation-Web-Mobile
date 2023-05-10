package com.example.misenpage.data

import android.icu.text.CaseMap.Title

data class TaskEntry (
    var id:Int,
    var title: String,
    var priority : Int,
    var timestamp:Long
        )