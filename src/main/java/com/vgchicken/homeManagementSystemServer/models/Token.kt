package com.vgchicken.homeManagementSystemServer.models

import org.apache.commons.codec.binary.Hex
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Token {
    constructor() {
        createRandomToken()
    }

    constructor(tokenString: String) {
        decodeToken(tokenString)
    }

    private val sdf = SimpleDateFormat("00MMHHssyyyyddmm")

    private val key = "VGCHICKENISTHEBESTSTUDIO".toByteArray()

    private val iv = "GBTECHCO".toByteArray()

    private val vg3des = VG3DESEncryption(key = key, keyIv = iv)

    var realToken: String? = null

    var date: Date? = null

    fun encodeToken (): String {
        if (realToken == null) return ""
        val dateString = sdf.format(date)
        val data = dateString.substring(0, 10) + realToken + dateString.substring(10)
        val encodeByteArray = vg3des.cbc(Hex.decodeHex(data.toCharArray()))
        return Hex.encodeHex(encodeByteArray).formatTOString()
    }

    fun new () {
        createRandomToken()
    }

    private fun decodeToken(tokenString: String) {
        if (tokenString.length != 80) return
        try {
            val byteArray = Hex.decodeHex(tokenString.toCharArray())
            val data = Hex.encodeHex(vg3des.cbc(byteArray, VG3DESEncryption.EncryptionMode.DECODE)).formatTOString()
            val dateString = data.substring(0, 10) + data.substring(74)

            date = sdf.parse(dateString)
            realToken = data.substring(10, 74)
        } catch (e: ParseException) {
            println("Token日期格式錯誤")
            e.printStackTrace()
        } catch (e: Exception) {
            println("Token格式錯誤")
            e.printStackTrace()
        }
    }

    private fun createRandomToken() {
        val bytes = getRandomBytes()
        val randomHex = Hex.encodeHex(bytes).formatTOString()
        date = Date()
        realToken = randomHex
    }

    private fun getRandomBytes(): ByteArray {
        val bytes = ByteArray(32)
        Random().nextBytes(bytes)
        return bytes
    }

    private fun CharArray.formatTOString(): String {
        return this.joinToString("").toUpperCase()
    }

}