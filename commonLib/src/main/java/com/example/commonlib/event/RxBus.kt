package com.example.commonlib.event

import com.example.commonlib.event.RxBus
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject

class RxBus {
    private val _bus = PublishSubject.create<Any>()

    /**
     * 发送事件(post event)
     *
     * @param event : event object(事件的内容)
     */
    fun post(event: Any) {
        _bus.onNext(event)
    }

    /**
     * 提供了一个新的事件,根据code进行分发
     *
     * @param code 事件code
     * @param o
     */
    fun post(code: Int, o: Any?) {
        _bus.onNext(RxBusMessage(code, o))
    }

    /**
     * 返回Event的管理者,进行对事件的接受
     *
     * @return
     */
    fun toObservable(): Observable<*> {
        return _bus
    }

    /**
     * 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
     *
     * @param eventType 事件类型
     * @param <T>
     * @return
    </T> */
    fun <T> toObservable(eventType: Class<T>?): Observable<T> {
        return _bus.ofType(eventType)
    }

    /**
     * 根据传递的code和 eventType 类型返回特定类型(eventType)的 被观察者
     * 对于注册了code为0，class为voidMessage的观察者，那么就接收不到code为0之外的voidMessage。
     *
     * @param code      事件code
     * @param eventType 事件类型
     * @param <T>
     * @return
    </T> */
    fun <T> toObservable(code: Int, eventType: Class<T>): Observable<T> {
        return _bus.ofType(RxBusMessage::class.java)
            .filter { msg: RxBusMessage -> msg.code == code && eventType.isInstance(msg.`object`) }
            .map { obj: RxBusMessage -> obj.`object` }
            .cast(eventType)
    }

    /**
     * 判断是否有订阅者
     */
    fun hasObservers(): Boolean {
        return _bus.hasObservers()
    }

    companion object {
        @Volatile
        private var sInstance: RxBus? = null
        val instance: RxBus?
            get() {
                if (sInstance == null) {
                    synchronized(RxBus::class.java) {
                        if (sInstance == null) {
                            sInstance = RxBus()
                        }
                    }
                }
                return sInstance
            }
    }
}