import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoadCamera
{
    public static void main(String[] args) throws IOException
    {
        //Параметры программы
        int maxOncomingSpeed = 60; // km/h
        int speedFineGrade = 20; // km/h
        int finePerGrade = 1000; // RUB
        int criminalSpeed = 180; // km/h


        //=============================================================

        System.out.println("Введите скорость автомобиля:");

        //Скорость автомобиля
        int oncomingSpeed = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());
        if(oncomingSpeed >= criminalSpeed)
        {
             System.out.println("Вызов полиции...");
        }
        else if(oncomingSpeed > maxOncomingSpeed)
        {
            int overSpeed = oncomingSpeed - maxOncomingSpeed;
            int gradesCount = overSpeed / speedFineGrade;
            int fine = finePerGrade * (1 + gradesCount);
            System.out.println("Сумма штрафа: " + fine);
        }
        else
        {
            System.out.println("Скорость не превышена");
        }
    }
}       // Правильно ли я понял, когда переменная вводится в условие( с учетом того что можно обойтись без нее), то она называется магической.
        // А если переменную вводить в формулу, то сколько душе угодно?
