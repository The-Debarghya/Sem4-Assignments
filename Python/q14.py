#!/usr/bin/env python3
with open('data.txt', 'r') as f:
    text = f.read()

text = text.lower()
words = text.split()
words = [word.strip('.,!;') for word in words]
words = [word.replace("'s", '') for word in words]

unique = []
for word in words:
    if word not in unique:
        unique.append(word)

unique.sort()
unique_and_pallindrome = [i for i in unique if i[::-1] == i]
print(f"Total number of words: {len(words)}")
print(f"Number of unique words: {len(unique)}")
print(f"Number of unique and pallindromes:{len(unique_and_pallindrome)}")
print(unique_and_pallindrome)
