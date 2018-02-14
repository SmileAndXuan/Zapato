package com.zapato.zapato

import android.content.SharedPreferences
import android.graphics.Color
import android.content.Context;
import android.content.SharedPreferences.Editor



/**
 * Created by james on 2/12/18.
 */
class Prefs (context: Context) {
    val PREFS_FILENAME = "com.teamtreehouse.colorsarefun.prefs"
    val BACKGROUND_COLOR = "background_color"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0);

    var bgColor: Int
        get() = prefs.getInt(BACKGROUND_COLOR, Color.BLACK)
        set(value) = prefs.edit().putInt(BACKGROUND_COLOR, value).apply()
}
