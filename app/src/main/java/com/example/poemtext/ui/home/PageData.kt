package com.example.myapplication.model

class PageData {
    var text: String? = null
    var imageId: Int = 0

    constructor()
    constructor(imageId: Int, text: String?) {
        this.text = text
        this.imageId = imageId
    }
}