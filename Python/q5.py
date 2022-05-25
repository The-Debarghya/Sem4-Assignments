#!/usr/bin/env python3

def fib(n):
    a, b = 0, 1
    for _ in range(n):
        yield a
        a, b = b, a + b


fibonacci_num = list(fib(7))
print(fibonacci_num)
