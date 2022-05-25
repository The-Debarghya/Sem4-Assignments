#!/usr/bin/env python3
def gen_primes(n):
    D = {}
    q = 2
    while n != 0:
        if q not in D:
            yield q
            D[q * q] = [q]
            n = n-1
        else:
            for p in D[q]:
                D.setdefault(p + q, []).append(p)
            del D[q]

        q += 1


n = int(input("No. of primes to generate:"))
print(list(gen_primes(n)))
