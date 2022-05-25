#!/usr/bin/env python3
numbers = [x for x in range(1, 51)]
multiples = list(filter(lambda x: (x % 5 == 0), numbers))
print(multiples)
