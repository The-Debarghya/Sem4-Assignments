#!/usr/bin/env python3
import glob
import os.path
root_dir = input("Enter the directory name to search for:")
if os.path.isfile(root_dir):
    print("The given name is a file")
elif os.path.isdir(root_dir):
    for filename in glob.iglob(root_dir + '**/**', recursive=True):
        print(filename)
else:
    print("The given name doesn't exist in working directory")
