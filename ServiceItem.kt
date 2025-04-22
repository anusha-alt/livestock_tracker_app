package com.example.at_lab_project

data class ServiceItem(
    @JvmField val name: String,
    @JvmField val iconRes: Int
){
    fun getName(): String = name
    fun getIconRes(): Int = iconRes
}
