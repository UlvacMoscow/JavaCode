import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {

        Scanner name = new Scanner(System.in);
        System.out.println("Введите свои Ф.И.О. через пробел");
        String person = name.nextLine();
        System.out.println(person);
        int spaceOne = person.indexOf(" ");
        int spaceTwo = person.lastIndexOf(" ");
        String surnamePerson = person.substring(0,spaceOne);
        String namePerson = person.substring(spaceOne,spaceTwo);
        String secondName = person.substring(spaceTwo);
        System.out.println("Фамилия " + surnamePerson.trim());
        System.out.println("Имя " + namePerson.trim());
        System.out.println("Отчество " + secondName.trim());
//        System.out.println(spaceOne);
//        System.out.println(spaceTwo);
        }
    }




