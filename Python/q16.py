#!/usr/bin/env python3
class ModifiedString(str):

    def __init__(self, a):
        str.__init__(a)

    def __len__(self):
        string = self.lower()
        words = string.split(" ")
        ct = 0
        for i in range(0, len(words)):
            count = 1
            for j in range(i+1, len(words)):
                if(words[i] == (words[j])):
                    count = count + 1
                    words[j] = "0"
            if(count > 1 and words[i] != "0"):
                ct = ct+1
        return ct

    def most_common(self) -> str:
        words = self.lower().split(" ")
        return max(set(words), key=words.count)


string = "big black bug bit a big black dog on his big black nose"
mod_str = ModifiedString(string)
print(len(mod_str))
print(mod_str.most_common())
