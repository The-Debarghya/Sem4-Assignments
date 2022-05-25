#!/usr/bin/env python3
import re
ph = input("Enter phone number(without spaces/dashes):")
validity = re.compile("^([0-9]{2})?[1-9][0-9]{9}$").match(ph)
if validity:
    print("Valid number")
else:
    print("Invalid number")
