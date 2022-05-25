#!/usr/bin/env python3
stock_prices1 = {}
stock_prices1.update({"A": 2000})
stock_prices1.update({"B": 3000})
stock_prices1.update({"C": 6900})
stock_prices1.update({"D": 800})
stock_prices1.update({"E": 5000})
stock_prices1.update({"F": 2703})
max = max(stock_prices1, key=stock_prices1.get)
print(f"Maximum valued stock is = {max}:Rs.{stock_prices1[max]}")
min = min(stock_prices1, key=stock_prices1.get)
print(f"Minimum valued stock is = {min}:Rs.{stock_prices1[min]}")
sorted_prices = dict(sorted(stock_prices1.items(), key=lambda item: item[1]))
print(f"Sorted 1st Dictionary:{sorted_prices}")
stock_prices2 = {}
stock_prices2.update({"A": 2500})
stock_prices2.update({"B": 3800})
stock_prices2.update({"C": 6900})
stock_prices2.update({"G": 400})
stock_prices2.update({"H": 4000})
stock_prices2.update({"I": 4703})
stock_prices2.update({"Z": 800})
items1 = stock_prices1.keys()
items2 = stock_prices2.keys()
print("The values present only in 1st dictionary:{", end="")
for i in items1:
    if i not in items2:
        print(f"'{i}':{stock_prices1[i]}, ", end="")
print("}")
print("The following items have different prices:")
for i in items1:
    if i in items2 and stock_prices1[i] != stock_prices2[i]:
        print(f"'{i}':{stock_prices1[i]}, {stock_prices2[i]}")
sorted_prices = dict(sorted(stock_prices2.items(), key=lambda item: item[1]))
print(f"Sorted 2nd Dictionary:{sorted_prices}")
grouped_stocks = dict([(i, stock_prices1[i])
                      for i in items1 if stock_prices1[i] % 500 == 0])
print(f"Stocks that are multiples of 500:{grouped_stocks}")
for i in items2:
    if i in items1:
        del stock_prices1[i]
print(f"Updated 1st dictionary: {stock_prices1}")
find_items = [i for i in items1 if stock_prices1[i] == 800]
find_items = find_items+[j for j in items2 if stock_prices2[j] == 800]
print(f"Stocks with 800 price:{find_items}")
