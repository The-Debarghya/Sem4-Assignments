#!/usr/bin/env python3
import itertools

numbers = list(range(1, 21))
odd_selector = [x % 2 for x in range(1, 21)]
even_selector = [x ^ 1 for x in odd_selector]

odds = itertools.compress(numbers, odd_selector)
evens = itertools.compress(numbers, even_selector)

print("1st 10 Odd numbers:")
for i in odds:
    print(i, end=" ")
print()
print("1st 10 Even numbers:")
for i in evens:
    print(i, end=" ")
print()
