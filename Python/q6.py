#!/usr/bin/env python3
class AgeError(Exception):

    def __init__(self, age, msg):
        self.age = age
        self.msg = msg

    def __str__(self):
        return self.msg


class MailError(Exception):

    def __init__(self, mail, msg):
        self.mail = mail
        self.msg = msg

    def __str__(self):
        return self.msg


def parse_list(li: list) -> dict:
    d = {}
    for i in li:
        if type(i) != tuple:
            raise TypeError
        else:
            try:
                if i[2] <= 16:
                    raise AgeError(
                        i[2], f"Age must be above 16, your age:{i[2]}")
                if "@" and "mail" not in i[1]:
                    raise MailError(
                        i[1], f"Not a proper mail ID, mail given: {i[1]}")
                if i[0] in d.keys():
                    raise KeyError
            except AgeError as err:
                print(err.msg)
                continue
            except MailError as err:
                print(err.msg)
                continue
            except KeyError:
                print(f"Duplicate names not allowed ({i[0]})")
                continue
            else:
                d1 = {i[0]: i[1]}
                d.update(d1)
    return d


names = [("Daren", "daren@mail", 26), ("Derek", "derek@mail", 22),
         ("John", "jon@mail", 15), ("Thomas", "tommy@mail", 18),
         ("Carl", "carlcj@mail", 20), ("Diaz", "rick@mail", -15),
         ("Daren", "daren1@mail", 18), ("Lance", "lance", 23)]
try:
    d = parse_list(names)
except TypeError:
    print("Each element must be a tuple")
except Exception:
    pass
print(f"Final dict:{d}")
