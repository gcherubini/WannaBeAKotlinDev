package com.gcherubini.wannabeakotlindev.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class UserRealm: RealmObject() {
    @PrimaryKey
    open var name: String = ""
    open var age: Int = 0
}