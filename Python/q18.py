#!/usr/bin/env python3
import random
items = int(input("Enter no. of integers in main list:"))
li = [i*random.randint(1, items) for i in range(items)]
N = int(input("Enetr the value of N:"))
li.sort()
print(f"Main list: {li}")
print(f"Largest {N} numbers:", end="")
print(li[-N:])
print(f"Smallest {N} numbers:", end="")
print(li[:N])
