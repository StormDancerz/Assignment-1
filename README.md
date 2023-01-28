# Assignment-1
Problem 1 (100 points) 
Your non-technical manager assigns you the task to find all primes between 1 and 
10^8.  The assumption is that your company is going to use a parallel machine that 
supports eight concurrent threads. Thus, in your design you should plan to spawn 8 
threads that will perform the necessary computation. Your boss does not have a strong 
technical background but she is a reasonable person. Therefore, she expects to see that 
the work is distributed such that the computational execution time is approximately 
equivalent among the threads. Finally, you need to provide a brief summary of your 
approach and an informal statement reasoning about the correctness and efficiency of 
your design. Provide a summary of the experimental evaluation of your approach. 
Remember, that your company cannot afford a supercomputer and rents a machine by 
the minute, so the longer your program takes, the more it costs. Feel free to use any 
programming language of your choice that supports multi-threading as long as you 
provide a ReadMe file with instructions for your manager explaining how to compile and 
run your program from the command prompt.   

Documentation:
This program uses multithreading to increase the speed of calculating the prime numbers up to 10^8 in Java. To find the prime numbers I implemented a boolean isPrime function that for each number checks the numbers up to its square root to see if any of them are prime. To implement multithreading I made the class MultiThread that implements runnable. I set each thread to check 100000000/8, or 12500000, numbers each. Each thread would check the numbers within its specified range and add all the prime numbers to an ArrayList of prime numbers. In the main function, I stored the 8 threads in an ArrayList of threads, which each thread having a specified range of numbers to check between. After all the threads had been started, I joined the threads. 

While I was able to count the number of primes that each thread found individually, I struggled to find out how to add up this number between all the threads. The same goes for finding the sum. I was also unsure how to specifically find the last 10 primes. I had tried a few methods such as trying to find the last 10 numbers in the arrayList but struggled calling the arrayList of primes in the main function, and when I called it in the MultiThread class I couldn't figure out how to specifically take the last 10 digits from the last thread. 

Runtime: The runtime of the program typically took about 19 seconds

Instructions:
Open terminal on your computer and navigate to the directory that Assignment1.java is saved in. Type javac ass1.java and then java ass1 in the terminal to run the program 

