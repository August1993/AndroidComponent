package com.example.commonlib.event

class RxBusMessage {
    var code = 0
        private set
    var `object`: Any? = null
        private set

    constructor(code: Int, `object`: Any?) {
        this.code = code
        this.`object` = `object`
    }

    constructor() {}
}