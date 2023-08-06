package com.example.completable.completable

import java.util.concurrent.CompletableFuture
import kotlin.system.measureTimeMillis


private fun fibonacci(
    num: Int
): Int{
    if (num == 1) {
        return 0;
    }
    if (num == 2) {
        return 1;
    }
    return fibonacci(num - 1) + fibonacci(num - 2);
}

fun main() {
    measureTimeMillis {
        val future1 = CompletableFuture.supplyAsync { fibonacci(35) }
        val future2 = CompletableFuture.supplyAsync { fibonacci(35) }
        val future3 = CompletableFuture.supplyAsync { fibonacci(35) }
        val future4 = CompletableFuture.supplyAsync { fibonacci(35) }
        val future5 = CompletableFuture.supplyAsync { fibonacci(35) }
        val future6 = CompletableFuture.supplyAsync { fibonacci(35) }
        val future7 = CompletableFuture.supplyAsync { fibonacci(35) }
        val future8 = CompletableFuture.supplyAsync { fibonacci(35) }
        val future9 = CompletableFuture.supplyAsync { fibonacci(35) }
        val future10 = CompletableFuture.supplyAsync { fibonacci(35) }

        val result = future1.get() + future2.get() + future3.get() + future4.get() + future5.get()
        + future6.get() + future7.get() + future8.get() + future9.get() + future10.get()

        println("Result: $result")
    }.also { println("Async Time: $it") }

    measureTimeMillis {
        val result = fibonacci(35) + fibonacci(35) + fibonacci(35) + fibonacci(35) + fibonacci(35)
        + fibonacci(35) + fibonacci(35) + fibonacci(35) + fibonacci(35) + fibonacci(35)

        measureTimeMillis {
            fibonacci(35)
        }.let {
            println("Fibonacci Time: $it")
        }

        println("Result: $result")
    }.also { println("Sync Time: $it") }
}
