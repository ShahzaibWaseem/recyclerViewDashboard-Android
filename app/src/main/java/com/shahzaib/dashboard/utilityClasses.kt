package com.shahzaib.dashboard

import android.graphics.Bitmap

class Recent(image: Bitmap, text: String, tag: String) {
    lateinit var image: Bitmap
    lateinit var text: String
    lateinit var tag: String
}

class Schedule(image: Bitmap, time: String, tag: String) {
    lateinit var image: Bitmap
    lateinit var time: String
    lateinit var tag: String
}

class Historical(image: Bitmap) {
    lateinit var image: Bitmap
}