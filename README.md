# Help Desk Call Center Simulator

A Java simulation of a tech support call center. Customers call in at a set rate,
get matched with available technicians, and the program prints live reports on
waiting customers, free techs, and active sessions.

## Features
- Custom generic queue (linked list + HashSet) that blocks duplicate customers with O(1) lookups
- Priority queue that ends support sessions in order of finish time
- Call lengths modeled with a normal (Gaussian) distribution
- Loads 1,000 customers and 50 technicians from CSV files
- Configurable staffing, call rate, average call length, and simulation length

## How it works
Each loop of the simulation is one minute. Every minute it:
1. Ends any support sessions that have finished and returns those techs to the available queue
2. Adds a new incoming call when the call interval is reached
3. Pairs waiting customers with available techs and starts new sessions
4. Prints a status report at the chosen update interval

## How to run
Run `Main.java` from the project folder (so it can find `customers.txt` and
`techs.txt`), then enter the simulation settings when prompted.

## Built with
Java

*Final project for CSC 143 (Object-Oriented Programming in Java), North Seattle College.*
