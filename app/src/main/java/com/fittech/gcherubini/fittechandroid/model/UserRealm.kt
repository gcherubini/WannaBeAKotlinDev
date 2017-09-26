package com.fittech.gcherubini.fittechandroid.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

open class UserRealm: RealmObject() {
    @PrimaryKey
    open var name: String = ""
}