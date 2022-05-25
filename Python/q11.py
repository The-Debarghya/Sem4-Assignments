#!/usr/bin/env python3
def pythagoreanTriplets(limits):
    c, m = 0, 2
    while c < limits:
        for n in range(1, m):
            a = m * m - n * n
            b = 2 * m * n
            c = m * m + n * n
            if c > limits:
                break
            li = [a, b, c]
            yield li
        m = m + 1


limit = 100
l1 = list(pythagoreanTriplets(limit))
filters = [x for x in range(1, 10)]
filtered_list = list(filter(lambda x: any(b in filters for b in x), l1))
print(filtered_list)
