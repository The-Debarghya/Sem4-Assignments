#!/usr/bin/env python3
with open('numbers.txt', 'r') as f:
    text = f.read().split("\n")[:-1]
enumerated_list = list(enumerate(text, 1))
dictionary = dict(enumerated_list)
for i in dictionary.keys():
    print(f"{hex(hash(dictionary[i]))}: '{dictionary[i]}'")
lengths = []
for i in text:
    lengths.append(len(i))
max = max(lengths)
padded = []
for i in text:
    j = i.rjust(max, '0')
    padded.append(j)
print(padded)
