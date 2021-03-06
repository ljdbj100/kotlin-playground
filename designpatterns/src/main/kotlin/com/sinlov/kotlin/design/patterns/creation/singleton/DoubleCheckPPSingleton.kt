package com.sinlov.kotlin.design.patterns.creation.singleton

/**
 * for Object
 * @see <a href="https://en.wikipedia.org/wiki/Singleton_pattern">Wikipedia Singleton_pattern</a>
 */
class DoubleCheckPPSingleton private constructor(private val property: Int) {

    companion object {
        @Volatile
        private var instance: DoubleCheckPPSingleton? = null

        fun getInstance(property: Int) =
            instance ?: synchronized(this) {
                instance ?: DoubleCheckPPSingleton(property).also {
                    instance = it
                }
            }
    }

    fun getProperty(): Int {
        return property
    }
}