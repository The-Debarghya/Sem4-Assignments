#!/usr/bin/env python3
coupon_codes = {
    "Monday": 4465,
    "Tuesday": 7676,
    "Wednesday": 1067,
    "Thursday": 7655,
    "Friday": 7678,
    "Saturday": 4333,
    "Sunday": 6578
}
i = input("Day for the coupon code:")
if i not in coupon_codes.keys():
    print("Sorry no such day exists!")
else:
    print(f"Coupon code for {i}: {coupon_codes[i]}")
