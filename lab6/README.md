## Prep

### F1
a) 10 20 30 47
b) 3
c) 4

### F2
if (empty) 0
height = 1 + max{calcHeight(leftNode), calcHeight(rightNode)}
Math.max()

### F3
int mid = first + ((last - first) / 2);

## Discussion

### D8
1.if we want to use private attributes for recursive, e.g. private root attr.

2. having parameters the user can't access / don't have

3. If we can have it private, why have it public? implementation detail.
Best practice (?) as restrivtive as possible, private, protected, public.

b) Do we hacve length of linked list?, complexity O(n), arraylist O(1).
traversing is slow, but technically possible.

If we dont have size: traverse till null, size++, then traverse again
size/2 times. Ineffective 
