# COP4520-22-Assignment-3

## Problem 1: The Birthday Presents Party (50 points)
For the servants to have more presents "Thank you" notes, it is possible that two servants went to add the same present, one failed because the other added it first, but then both "successfully" removed the present from the chain and wrote the "Thank you" note. <br>
A way to fix that would be for the servant to check if it actually removed the gift or simply didn't find it. If it did not find the gift, then don't write the "Thank you" note. <br>
In previous testing, a single threaded version of the linked list took around 3 seconds to add 500,000 unique entries in order. The multi-threaded version only took tens of milliseconds to finish the same job (4 threads). <br>
To run the file, go to "Problem 1" directory and, in the terminal, type and run "javac Experimenting.java" and then "java Experimenting"

## Problem 2: Atmospheric Temperature Reading Module (50 points)
For effiency, each thread runs concurrently (of course) and has a designated section in the shared memory. The 1st thread gets the first 60 slots, the 2nd thread gets the next 60, and so on. We then copy the array to another array (as to not altar the previous data), sort it, remove duplicates, and then write out the 5 highest and 5 lowest temperatures. <br>
To run the file, go to "Problem 2" directory and, in the terminal, type and run "javac Problem2.java" and then "java Problem2"