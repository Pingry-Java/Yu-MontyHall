Monty Hall Problem
==========

Overview (Main program)
--------
This project is meant to replicate the Monty Hall Problem. Behind three doors, there are 
two goats and one car. First, the user is asked to choose a door. The program then reveals
a door with a goat behind it. Then, the user is asked if he/she would like to switch doors. 
The program then reveals what is behind the user's door. Hint: User should probably switch. 


Overview (Simulation program)
--------
This project uses the previous code from the Monty Hall problem and simulates however many
times the user wishes. Then, the program reports back on the success rate of either staying
or switching doors. 


Here is an example of how the code should run in CommandPrompt/Terminal:

CODE 1
--------
<pre>
Choose a door between 1-3:
2
There is a goat behind door number 1
Would you like to switch your door? (Yes or No):
yes
Your new door number is 3
CONGRATS! behind door # 3 is a car
  ______
 ll_ll_\`.__
(   _    _ _\
=`-(_)--(_)-'

</pre>

CODE 2
--------
<pre>
C:\javaProjects\MontyHall>java MontyHall 10000
Going to run 10000 Simulations.
You won: 67.28803367408298% of all the games who you swapepd.
You won: 33.76571542606266% of all the games who you stayed.
</pre>

Usage
-----
Compile the program with:
`javac MontyHall.java`
 and

Run the compiled bytecode with:
`java MontyHall`

and for simulation code, run it with:
`java MontyHall (number of times you want to run it)`

Author
-----
Lindsey Yu 
AP COMPSCI CLASS