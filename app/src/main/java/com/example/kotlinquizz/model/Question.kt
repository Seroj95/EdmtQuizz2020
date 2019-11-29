package com.example.kotlinquizz.model

class Question (
    var id:Int,
    var questionText:String,
    var questionImage:String,
    var answerA:String?,
    var answerB:String?,
    var answerC:String?,
    var answerD:String?,
    var corectAnswer:String?,
    var isImageQustion:Boolean?,
    var categoryId:Int


)
