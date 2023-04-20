# Constraint-Satisfaction
Experimental Analysis of Algorithms - Constraint Satisfaction

## Map Coloring Problem (involves variables that have discrete, finite domains)

Constraint satisfaction problems (CSPs) represent a state with a set of variable/value
pairs and represent the conditions for a solution by a set of constraints on the variables.

X is a set of variables, {X1,...,Xn}. <br>
D is a set of domains, {D1,...,Dn}, one for each variable. <br>
C is a set of constraints that specify allowable combinations of values. <br>


We can visualize the map coloring CSP as a constraint graph, where: <br>
nodes = variables of the problem <br>
colors = represents the domain for each variable (node) <br> 
edge between two nodes = connects two variables that participate in a constraint <br>

Types of constraints: <br>
- unary constraint involves a single variable (e.g.: WA != red)
- binary constraint relates two variables (e.g.: WA != SA)
- global constraint relates a constraint involving an arbitrary number of variables (e.g.: AllDiff(F, T, U, W, R, O) - all of the
variables involved in the constraint must have different values)
- preferences indicating which solutions are preferred (e.g.: red is better than green)


Backtracking Search
- depth-first search + variable ordering + fail when constraint is not satisfied 
- chooses values for one variable at a time and backtracks when a variable has no legal values left to assign

Backtracking Search Optimizations:
- can be improved using inference techniques that use the constraints to infer which variable/value pairs
are consistent and which are not (arc-, path-, or k-consistency)
- can be improved using heuristics

Heuristics
- The minimum-remaining-values and degree heuristics are domain-independent methods for deciding which variable to choose next in a backtracking search
- The least-constraining-value heuristic helps in deciding which value to try first for a given variable. Backtracking occurs when no legal assignment can be found for a variable
- Conflict-directed backjumping backtracks directly to the source of the problem
- Local search using the min-conflicts heuristic


#### References: Stuart J. Russell and Peter Norvig. Artificial Intelligence: A Modern Approach, chapter 6 (Constraint Satisfaction Problems)
