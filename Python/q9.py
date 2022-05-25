#!/usr/bin/env python3
actual_list = [("Aaron", "CSE", 67), ("Steven", "ETCE", 45),
               ("Green", "IEE", 89), ("Daren", "IT", 79)]
max_list = list(map(max, zip(*actual_list)))
print(max_list)
min_list = list(map(min, zip(*actual_list)))
print(min_list)
