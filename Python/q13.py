#!/usr/bin/env python3
def generate_terms(a, r):
    term = a
    yield a
    while True:
        term = term*r
        if term > 100000:
            print(f"Term reached greater than 100000({term})")
            break
        yield term


a = int(input("Enter the first term:"))
r = int(input("Enter the ratio:"))
li = list(generate_terms(a, r))
print(li)
