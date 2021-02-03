package framework.driver

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

typealias thread<T> = ThreadLocalDelegate<T>

class ThreadLocalDelegate<T>(private val threadLocal: ThreadLocal<T>) : ReadWriteProperty<Any, T> {
    companion object {
        fun <T> lateinit() = ThreadLocalDelegate<T>(ThreadLocal())
    }

    constructor (initial: T) : this(ThreadLocal.withInitial { initial })

    constructor (initial: () -> T) : this(ThreadLocal.withInitial(initial))

    override fun getValue(thisRef: Any, property: KProperty<*>): T = threadLocal.get()

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) = threadLocal.set(value)
}