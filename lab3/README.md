## Prep

### F2
map.entrySet(); of type Set<Map.Entry<K, V>>;

### F3
list.sort((e1, e2) -> e2.getValue() - e1.getValue());

### F4
addActionListener(new ActionListener() {});
.getText() (found in superclass JTextComponent)
panel.add() found in java.awt.Container;
setSelectedIndex(int index) selects a single cell.

## Discussion

### D10
a. Callback functions on events, i.e., addActionListener to handle 
button click. Swing calls us, we don't call them.

b. callbacks from event listeners are functional interfaces,
why lambda expressions makes sense to use.

c. Think there's an Observable<JList> that triggers a callback on changes,
resulting in Swing automatically updating the UI. Probably a subscribe()
like in Angular.
