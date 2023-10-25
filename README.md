# Maze Lab
test

# Purpose

In this lab you will use the power of a stack and a queue to explore and find your way through a maze. The purpose of this lab is to:



* Have you implement a stack and a queue
* Build a simple linked list of nodes
* Use your stack and queue to solve a maze
* Explore the differences between the two solution strategies
* Apply software team development best practices


# Requirements



* Complete the [CSCI 151 - Stacks and Queues Simply A-Maze-ing! lab](https://www.cs.oberlin.edu/~rhoyle/16s-cs151/lab03/index.html) from Oberlin.
* Changes from the lab as written for Oberlin:
    * The code is in the repository you are looking at right now. You can skip all the steps under “starting point code”
    * You will use Visual Studio Code and not Eclipse.
    * Consider questions 2, 4, and 5 in Part 5 and answer them if you want, but it is not required.
* You will work with a partner on this summative lab and demonstrate your understanding of using GitHub as a team as well as the Agile process.
    * Set up and keep up-to-date the Trello board that was created by Dr. Miller
    * Hold a [Sprint Planning Meeting](https://docs.google.com/document/d/1bkBpcO9URCqPlFYVbQEVhB36BuU77CYmBulchadE6aQ/edit?usp=sharing) and turn in the document after your Trello board is set up (this is summative evidence)
    * Commit to GitHub frequently, at least daily, with a meaningful commit message
    * You and your partner must create and use branches for your development as specified in the daily milestones
    * You and your partner must issue pull requests to incorporate changes in your branch into `main`
* This lab is recorded as two labs in the gradebook. One score is based on satisfying the requirements for the Maze lab. The other score is based on your sprint planning meeting.


# Daily Milestones (will be checked daily by instructor)



1. (**Teammate A & B**) create `square` branch from `main`; implement `Square` class skeleton in `square` branch; implement `Square` class unit test; run tests (verify fails); implement `Square` class; run tests (verify passes); pull into `main` (**pair programming**)
2. (**Teammate A & B**) create `mazeSkeleton` branch from `main`; implement `Maze` class skeleton in `mazeSkeleton` branch; pull into `main` (**pair programming**) \
At the same time:
    * (**Teammate B**) create `mazeTest` branch from `main`; implement `Maze` unit test in `mazeTest` branch[^1]; run test (verify fails); pull into `main`


    * (**Teammate A**) create `maze` branch from `main`; implement `Maze` class in `maze` branch

    (**Teammate A & B**) merge `main` into `maze` branch; run tests (probably fails); debug `Maze` class; run tests (verify passes); pull into `main` (**pair programming**)

3. At the same time:
    * (**Teammate A**) create `stack` branch from `main`; implement `MyStack` and `MyStackTest` in `stack` branch; run tests (verify passes); pull into `main`
    * (**Teammate B**) create `queue` branch from `main`; implement `MyQueue` and `MyQueueTest`[^2] in `queue` branch; run tests (verify passes); pull into `main`


4. (**Teammate A & B**) create `solver` branch from `main`; implement `MazeSolver` in `solver` branch (**pair programming**)
5. At the same time:
    * (**Teammate A**) create `stackSolver` branch from `solver` (not `main`); implement `MazeSolverStack` in `stackSolver` branch
    * (**Teammate B**) create `queueSolver` branch from `solver` (not `main`); implement `MazeSolverQueue` in `queueSolver` branch
6. (**Teammate A & B**) tie up loose ends; pull both branches into `solver`; run tests (verify passes); uncomment all of the lines in MazeApp.java (refer to comment at the top of the file); test MazeApp by hand (verify functionality); pull into `main`

Your GitHub branching history should look similar to the following:



![image alt text](image_0.png)



# Extensions



* Try the bonus mazes.
* Add more awesome.


# Submission



* Submit a link to your GitHub repository with this assignment.

<!-- Footnotes themselves at the bottom. -->
## Notes

[^1]:

     There is a maze-invalid file that contains an improperly formatted maze and should be used in the test to ensure exceptions do not go unhandled.

[^2]:

     To avoid future headaches, ensure that the test thoroughly tests the Queue class. Specifically, make sure to test that the last element in the queue is successfully dequeued.


