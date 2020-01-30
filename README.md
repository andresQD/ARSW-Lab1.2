# ARSW-Lab1.2
## Part I
1.  Al ejecutar el programa con un solo hilo se obtuvo el siguiente resultado:
![img1](https://user-images.githubusercontent.com/48091585/73319638-00941680-420b-11ea-9a51-3938d5009d26.PNG)
![img2](https://user-images.githubusercontent.com/48091585/73319655-07bb2480-420b-11ea-8df2-e29930eb13d6.png)
2.  Se realizó la implementacion de los 3 threads y a cada uno se le asigno un rango diferente, pero cubriendo el rango principal de 1 - 30000000
![img3](https://user-images.githubusercontent.com/48091585/73319658-0a1d7e80-420b-11ea-9d12-81c7b3f860cb.png)

Al ejecutarlo se obtuvo el siguiente resultado:
![img4](https://user-images.githubusercontent.com/48091585/73319660-0be74200-420b-11ea-8f38-038842f3c66c.png)
![img5](https://user-images.githubusercontent.com/48091585/73319662-0e499c00-420b-11ea-9d96-23df6128f337.png)
3.  What you have been asked for is: you must modify the application so that when 5 seconds have elapsed since the execution started, all the threads are stopped and the number of primes ​​found so far is displayed. Then, you must wait for the user to press ENTER to resume their execution.

## Part III
1.  
1.1 The action of starting the race and showing the results is carried out from line 38 of MainCanodromo

1.2 The join() method of the Thread class can be used to synchronize the thread that starts the race, with the completion of the greyhound threads.

![im1](https://user-images.githubusercontent.com/48091585/73411837-c727dd80-42d4-11ea-8fd0-1b20e634f6a7.png)

Con el ciclo “for” donde a cada galgo se le hace join(), permite no avanzar a la siguiente parte del código hasta que todos los galgos acaben su ejecución, haciendo asi no muestre quien es el ganador hasta que se acabe la carrera.


3.  Use a synchronization mechanism to ensure that these critical regions only access one thread at a time. Verify the results.

![im2](https://github.com/andresQD/ARSW-Lab1.2/blob/master/img/media/im4.PNG)

Se determino que las regiones criticas a las cuales solo puede acceder un subproceso a la vez son las que pertenecen a la clase RegistroLegada, mas especificamente a el metodo get y set del atributo UltimaPosicionAlcanzada.




4.  Implement the pause and continue functionalities. With these, when "Stop" is clicked, all the threads of the greyhounds should fall asleep, and when "Continue" is clicked they should wake up and continue with the race. Design a solution that allows you to do this using the synchronization mechanisms with the Locks primitives provided by the language (wait and notifyAll).

![im2](https://user-images.githubusercontent.com/48091585/73411832-c131fc80-42d4-11ea-965c-6a056d30ec26.png)

![im3](https://user-images.githubusercontent.com/48091585/73411842-cabb6480-42d4-11ea-9c5e-a289d0a32b30.png)

Se añadió una bandera que le permite saber a cada Galgo si debe continuar o si debe para, y un método que dependiendo el botón que se oprima cambie su banderapara saber si esta en ejecución o no.
