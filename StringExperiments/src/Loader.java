
public class Loader
{
    public static void main(String[] args)
    {
        String text = "Вася заработал 50000 рублей, Петя - 7563 рубля, а Маша - 30453 рублей";
        int firstIndexWord = text.indexOf("л");
        int secondIndexWord = text.indexOf("руб");
        System.out.println(firstIndexWord);
        System.out.println(secondIndexWord);

        String fragmentMoney = text.substring((firstIndexWord+1),secondIndexWord);
        System.out.println(fragmentMoney);

        int thirdIndexWord = text.indexOf("а -");
        int fourtyIndexWord = text.lastIndexOf("руб");

        String fragmentMonetTwo = text.substring(thirdIndexWord+3,fourtyIndexWord);
        System.out.println(fragmentMonetTwo);
        int sum1 = Integer.parseInt(fragmentMoney.trim());
        int sum2 = Integer.parseInt(fragmentMonetTwo.trim());
        int sum3 = sum1 + sum2;
        System.out.println(sum3);


//        System.out.println("Возращает длину строки " + text.length());
//        System.out.println("возращает значение на какой позиции встречается руб, он возращает номер симола р первого встретившегося. " + text.indexOf("руб"));
//        System.out.println("он возращает последний вхождение руб, в периданной строки " + text.lastIndexOf("руб"));
//        System.out.println(text);

//        int lastIndex = text.lastIndexOf("руб");
//        String fragment = text.substring(lastIndex,67);
//        System.out.println(fragment);
    }
}