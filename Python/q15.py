#!/usr/bin/env python3
class BankAccount(object):

    def __init__(self, name: str, accno: int, pin: int, balance: float):
        self.name = name
        self.accno = accno
        self.pin = pin
        self.balance = balance

    def __str__(self):
        return(f"Name:{self.name}, Acc. No.:{self.accno}, Balance:Rs.{self.balance}")

    def get_balance(self) -> float:
        return self.balance

    def change_pin(self, new):
        self.pin = new

    def withdraw(self, amount, accno):
        if self.accno == accno and (self.balance - amount) != 0:
            self.balance = self.balance - amount
            print(
                f"Successfully withdrawn Rs.{amount}, present balance:Rs.{self.balance}")
        else:
            print("Not much balance/Acc. No. doesn't match!")

    def deposit(self, amount, accno):
        if self.accno == accno:
            self.balance = self.balance + amount
            print(
                f"Successfully deposited Rs.{amount}, present balance:Rs.{self.balance}")
        else:
            print("Account Number doesn't match!")


class SavangsAccount(BankAccount):

    interest = 5

    def __init__(self, name, accno, pin, balance):
        super().__init__(name, accno, pin, balance)

    def add_interest(self, months):
        inr = self.balance*self.interest*months/100
        self.balance = self.balance + inr
        print(f"Present balance:Rs.{self.balance}")


class FeeSavingsAccount(SavangsAccount):

    def __init__(self, name, accno, pin, balance, fee):
        super().__init__(name, accno, pin, balance)
        self.fee = fee

    def withdraw(self, amount, accno):
        if self.accno == accno and (self.balance - amount) != 0:
            self.balance = self.balance - amount - self.fee
            print(
                f"Successfully withdrawn Rs.{amount}, present balance:Rs.{self.balance}")
        else:
            print("Not much balance/Acc. No. doesn't match!")
