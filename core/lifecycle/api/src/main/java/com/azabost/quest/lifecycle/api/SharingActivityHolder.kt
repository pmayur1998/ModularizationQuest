package com.azabost.quest.lifecycle.api

import android.app.Activity

//Need to check if we should move this to api module
interface SharingActivityHolder {
    fun getSharingActivity(): Activity?
}