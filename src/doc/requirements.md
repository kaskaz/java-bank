# System Requirements Specification

## System Features

The Bank can have any number of customers and each customer can have multiple checking and savings accounts.
Account balance cannot be negative, transactions should fail if not enough money is available.
The Savings Account has a minimum balance should be 100, no debits or transfers can be made from this account if inactive.
The Customer can deposit or withdraw from the checking account or transfer money between checking and savings account
The Customer balance equals the sum of the balances of all the customer accounts.
The Bank balance equals the sum of the balances of all customers.

## Functional Requirements
1. Bank should be able to contain any number of Customers
1. Customers should be able to have multiple checking accounts
1. Customers should be able to have multiple savings accounts
1. Checking account balance can not be negative
1. Savings account balance can not be lower than 100
1. Savings account requires transfer of at least minimum balance to become active
1. Customer should be able to deposit money in any of its checking accounts.
1. Customer should be able to withdraw money from any of its checking accounts, provided it has sufficient funds
1. Customer should be able to transfer money between any of its accounts
1. Customer should be able to check balance of any account
1. Customer should be able to check combined balance of all accounts
1. Bank should be able to check the combined balance of all customers

## Identifying Objects & Responsibilities
Bank, Customer, Checking, Savings, Account, Money, Accounts Manager

## Bank
Represents the Banking service, contains costumers

### Responsibilities
* add a new customer
* get balance

### Collaborators
* Customer

## Customer
Represents bank customers, contains accounts

### Responsibilities
* add a new account
* get balance

### Collaborators
* Account

## Account
Represents a Bank Account, contains money

### Responsibilities
* credit
* debit
* get balance

## Accounts Manager
Represents bank accounts manager, contains all bank accounts

### Responsibilities
* add a new account
* deposit money account
* withdraw money from account
* transfer between accounts

### Collaborators
* Account

## High Level Design

* Inheritance is an obvious choice for modeling different account types, but was not used deliberatly
* Customer contains Accounts seemed like a better choice than Accounts belong to Customer
* Account objects are stored in Map container for quick and convenient access
* Customer objects are stored in Set container to prevent duplicates

 
