# Backtracking 
Algorithmic technique for solving problems recursively by trying to build a solution one piece at a time. We remove solutions that fail to satisfy the constraints of the problem at any point of time.
+ This works well for constraint satisfaction problems
  + N queens, map coloring problem, sudoku, etc
This approach works very well for certain problems that cannot be solved by Dynamic Programming or Greedy Algorithms (these tend to be much faster)
  
### Simplified Description
Have 3 boxes, only one has a gold coin in it. We want to find which one has a gold coin. We go to box 1, it doesn't have it so we close it and go on to the next one. We repeat this until we have found it. Each box is a subproblem that we solve one by one until we reach the solution. (or best possible solution)