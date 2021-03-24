# Linked List Assignment

For this assignment you will be responsible for creating a doubly linked list and implementing all of the required functions associated with the list interface as well as test cases that show the correctness of your implementation. Recall that a `doubly linked list` is a list where each node has a pointer to both its predecessor and its successor. This allows us to more efficiently implement methods such as `removeBack` and `insertAt`, this comes at the cost of needing to track more metadata during insertion and removal operations. 

Your goal for the assignment will be to implement all public interface functions for the class and ensure all of the already existing test cases, and any that you add, execute successfully. The public interface and implementation can be found inside of `GenericList.java`, see the file for function names and descriptions of the behavior that each method is expected to provide. `GenericList.java` includes a test `main` that can be used to do your initial testing with. You can invoke that main function through the Intellij IDE or from the command line via by running the following command from a command prompt:

```
./javac-ds GenericList.java
./java-ds GenericList
```

## Expectations & Rules

* You are expected to correctly implement all required methods inside of `GenericList.java`. Your implementations should also handle potential edge cases that could arrise without crashing
* You cannot change the prototype of any existing `public` method in the class
* You cannot add any new `public` methods to the class
* You can add new `private` methods and instance variables which act as helper functions
* Your method implementations should return in the correct manner, such that if it is a `void` method,  nothing should be returned, if it is a `boolean` method then a Boolean should always be returned, etc
* If a sample output file is provided, then your output format must match the provided output _exactly_, including spaces, casing, etc. 
* You should include some number of test cases in other `.java` files that show the correctness of your program in both normal and edge case scenarios. Think about strange situations your code could end up in and show that your implementation is able to handle it correctly. For instance, what happens if the `getFront` method is called on a list that is empty, or what happens if you remove all nodes from the list and then start adding new nodes back into it? The required number of test cases will be dictated by the rubric below.
* The main file you will be editing is `GenericList.java`. No other existing files should be modified unless they are test cases that you have added

## Creating Test Cases

All test files should be located inside of the `tests` folder. If you create a new test with the Intellij 'new class' wizard it may automatically place the following line at the top of the file

`package tests;`

Delete or comment out that line, if you do not you will get multiple errors when trying to use either the algs4 library functions or the classes you needed to implement for this assignment.

To create a new test case, create a new file called `Test<some test name>.java`. Note that the file name __must__ start with the word `Test`. Once you have created the test you can create an instance of your data structure and perform the necessary operations to show the success of the test. See the included Test files for examples, in general each test should follow these guidelines

* The test file name must have the prefix `Test`
* If the test fails, a message should be printed saying that the test failed
* If the test fails, `System.exit(1);` should be called, you can ignore Intellij warning squiggles after that line has been written
* If the test succeeds then a message should be printed out indicating that it was successful

Examine the included tests and use them as a template for your tests.

To build and run all tests you can use the included shell script called `run_tests.sh` This will find all test files in the `tests` folder, build them, and run them. This can be invoked from a terminal that is open to the assignment directory with:

```
./run_tests.sh
```

## Rubric

Your code will be graded based on the following rubric

| Category          |                                                              |                                                              |                                                              |                                                              |
| ----------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Readability       | 6 Points                                                     | 4 Points                                                     | 2 Points                                                     | 0 Points                                                     |
|                   | Code is clean, understandable, well-organized                | Minor issues such as inconsistent indentation, variable naming, general organization | At least one major issue that makes it difficult to read     | Several major issues that make it difficult to read.         |
| Unit Tests        | 6 Points                                                     | 4 Points                                                     | 2 Points                                                     | 0 Points                                                     |
|                   | At least 6 additional  unit tests are provided(beyond the ones that are provided) | At least 4 additional unit tests are provided(beyond the ones that are provided) | At least 2 additional unit tests are provided(beyond the ones that are provided) | No unit tests were provided                                  |
| Elegance          |                                                              | 4 Points                                                     | 2 Points                                                     | 0 Points                                                     |
|                   |                                                              | Code duplication is minimized by implementing the appropriate number of functions and loop statements. | Poor design choices were used in at least one place, for example duplicate code that could have been extracted into a function or put inside of a loop was not | Code contained multiple instances of poor design, such as not modularizing duplicate code or lack of data structure use to maintain and organize data |
| Correctness       | 30 Points                                                    | 25 Points                                                    | 15 Points                                                    | 0 Points                                                     |
|                   | All specifications are met and the program always functions as expected regardless of the input provided to it | Program meets most requirements but behaves abnormally when certain edge cases are provided | The program produces incorrect output with most input sets   | Program does not compile or does not function correctly even when provided with the sample input |
| Specifications    |                                                              | 4 Points                                                     | 2 Points                                                     | 0 Points                                                     |
|                   |                                                              | Program meets all specifications provided in the assignment description file | Minor specifications have been violated (incorrectly named files, program input) | Many specifications were not met                             |
| Memory Management |                                                              | 5 Points                                                     | 3 Points                                                     | 0 Points                                                     |
|                   |                                                              | Program allocates the correct amount of data without extraneous allocations | Program has a small number of extraneous allocations that are not required | Program has many extraneous allocations                      |