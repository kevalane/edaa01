## Prep

### f2
a) Player is a superclass to the subclasses HumanPlayer and ComputerPlayer.
b) These:
Player p = new HumanPlayer("aragor");
works bc superclass as type, is allowed. Think shape and square

HumanPlayer p = new HumanPlayer("eowyn");
allowed, standard

Other two:
1st: No, bc player is abstract. Cant be initialized
4th: No, type mismatch.

## Discussion

### D5
1. We avoid dupclitative code, using super() for constructor, and only
storing userid in the superclass.

2. We can ensure the method takePins is implemented on both
subclasses, by making it abstract as well.
In short, an abstract method is placed in a superclass,
lacks implementation, but forces all children to implement it.
(if not implemented, error on compilation)
- allows for different implementations, on different subclasses,
in this case: different strategies.

