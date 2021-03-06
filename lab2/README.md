## Prep

### F1

Scheduler.java -> machineWithLeastToDo (line 19),
called from makeSchedule() line 34, in main 21
The error stems from the constructor, where attribute
in class what not used (this.machines)
It is a lava.lang.NullPointerException

java.lang.ArrayIndexOutOfBoundsException
Scheduler.java, line 51
method: printSchedule()
reason: <= in for loop

### F2

4. Well, you can see that they are sorted in ascending order.
Error probably with lambda expression, will investigate.
Yup, j2.getTime() - j1. instead of other way around solved it.

5. RE machineWithLeastToDo();
Looks like the totalTime variable, get from getScheduledTime()
is not incrementing properly. When two jobs assigned to machine 2,
we still only see the total time of the most recently assigned job.
Yeah, read instructions again. Changed void assignJob() to
this.scheduledTime += j.getTime();

### F3

Using a priority queue allows us to access min at O(1) time complexity.
If we use a priority deque, double ended queue, we can also access
the maximum element in O(1), however not necessary in this case
(thus far).

### F4

a) 20 rows
Yes, we can be sure

b)
only 10 times bc HashSet does not allow dublicates.
"A set is a collection that contains no duplicate elements, and 
whose elements are in no particular order."
Therefore, no. Order cannot be ensured.
Can use LinkedHashSet instead

c)
Map<String, Integer> m = new HashMap<String, Integer>();
7 will be printed

d) boolean containsKey(Object key);

## Discussions

### D12
688 608 684 -> median 684ms

### D13
644 735 723 -> median 723ms
Higher!
Treemap ensures order, hashmap doesnt
Program still working

### D14

Map is the interface both TreeMap and HashMap implements
I cannot instantiate a Map as an object (it's not a class)
HashMap implements Map, meaning it has it's own or inherits the
implementation of all methods in map. HashMap is, howver, an object
and can therefore be instantiated and used.

HashMap does not guarantee order (which treemap does), and is therefore
faster in general. 
HashMap is a hashtable based implementation, whilst treemap is a binary
searh tree (self balanced). HashTable O(1) on search, insert, delete
whilst binary search tree is O(log(n))

A map is used for key-value store. Perfect for this lab since we are counting
occurances, thus key=word, value=number of occurances.
A set is useful for the implementation we used, to check for occurance. If
instead a vector would be used, we would have to loop over every element
and check for equality, instead we use .contains() with O(1) if hashset
and O(logn) if treeset.

.sort() takes a class that implements the interface Comparator. However,
to avoid creating a new class we use a lambda expression, which creates
an object in the background (that implements Comparator).
Out parameters, e1 e2, have their type inferred, and the compiler understands
we are calling the compare method since no other method exists on the interface.
Using lambda expression to create an object only works if only one abstract
method exists, called a functional interface, which Comparable is an example of.
