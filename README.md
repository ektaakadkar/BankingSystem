# BankingSystem

The following code implements producer consumer algorithm to provide the customers in bank the correct counter to take place their transaction. Multi-threading is used for the above purpose. Each counter is allocated one thread. The customer line is implemented using a queue where customers are added at a random time irrespective of any other processes. The customers added in the queue are called by the counters one by one. The transaction time at each counter is a random number to make it a natural scenario. 
