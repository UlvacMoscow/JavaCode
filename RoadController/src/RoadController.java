import core.*;
import core.Camera;

public class RoadController
{
    /**
     * макс вес легкового траснопрта 3500кг
     * макс высота легкового транспорта 2000 мм
     * макс высота для проезда 4000мм
     */
    //Double passengerCarMaxWeight
    public static double passengerCarMaxWeight = 3500.0; // kg
    //Integer passengerCarMaxHeight
    public static int passengerCarMaxHeight = 2000; // mm
    //Integer controllerMaxHeight
    public static int controllerMaxHeight = 3500; // mm
    /**
     * легковой транспорт 100
     грузовой транспорт 250
     транспортное средство 200
      */
    //Integer passengerCarPrice
    public static int passengerCarPrice = 100; // RUB
    //Integer cargoCarPrice
    public static int cargoCarPrice = 250; // RUB
    //Integer vehicleAdditionalPrice
    public static int vehicleAdditionalPrice = 200; // RUB
    /**
     * макс скорость 30
     * макс допустимая погрешность 20
     * штрав 500
     * кримандбная скорость 160
     */
    //Integer maxOncomingSpeed
    public static int maxOncomingSpeed = 60; // km/h
    //Integer speedFineGrade
    public static int speedFineGrade = 20; // km/h
    //Integer finePerGrade
    public static int finePerGrade = 1000; // RUB
    //Integer criminalSpeed
    public static int criminalSpeed = 160; // km/h


    public static void main(String[] args)
    {
        /**
         * Создаем десять автомобилей
         */
        //Integer i
        for(int i = 0; i < 10; i++)
        {
            //Car car
            Car car = Camera.getNextCar();
            System.out.println(car);       //Распечатываются номер авто, высоту и массу.
            System.out.println("Скорость: " + Camera.getCarSpeed(car) + " км/ч");//Распечатываем скорость в км/ч

            /**
             * Проверка на наличие номера в списке номеров нарушителей
             */
            //Boolean policeCalled
            Boolean policeCalled = false;
            /**
             * Получаем криминальные номера из полиции, и сравниваем их с номерами наших авто.
             * В случае совпадение криминального номера с номером нашего авто, вызываем полицию.
             */
            for(String criminalNumber : Police.getCriminalNumbers())
            {
                //String carNumber
                String carNumber = car.getNumber();
                if(carNumber.equals(criminalNumber))
                {
                    Police.call("автомобиль нарушителя с номером " + carNumber);
                    blockWay("не двигайтесь с места! За вами уже выехали!");
                    break; // останавливает цикл, и код продолжается дальше.
                }
            }
            // Если в полицию звонили, то начать проверять следующий авто.
            if(Police.wasCalled())
            {
                continue;
            }
            /**
             * Пропускаем автомобили спецтранспорта, и переходим к следующему авто.
             */
            if(car.isSpecial())
            {
                openWay();
                continue;
            }

            /**
             * Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
             */
            //Integer carHeight
            int carHeight = car.getHeight();

            //Integer price
            int price = 0;
            /**
             * Проверяем высоту нашего авто, может ли он проехать под нашим шлагбаумом. Если нет, то переходим к следующему авто.
             */
            if(carHeight > controllerMaxHeight)
            {
                blockWay("высота вашего ТС превышает высоту пропускного пункта!");
                continue;
            }
            /**
             * Проверяем выше ли наш авто пассажирского транспорта
             * Если ниже, то мы его даже не взвешиваем и выставляем сразу цену как за пассажирский транспорт.
             */
            else if(carHeight > passengerCarMaxHeight)
            {
                //Double weight
                double weight = WeightMeter.getWeight(car);
                //Грузовой автомобиль
                /**
                 * Смотрим теперь по массе, больше он пассажирского, если да то это ГРУЗОВОЙ транспорт.
                 * И выставляем ему цену грузового транспорта.
                 * Если масса авто меньше, то определяем что Пассажирский транспорт и выставляем соответствующую стоимость проезда.
                 */
                if(weight > passengerCarMaxWeight)
                {
                    /**
                     * Проверяем есть ли у этого Грузового транспорта, прицеп. Если есть, то добавляем стоимость за прицеп.
                     */
                    price = cargoCarPrice;
                    if(car.hasVehicle()) {
                        price = price + vehicleAdditionalPrice;
                    }
                }
                //Легковой автомобиль
                else
                {
                    price = passengerCarPrice;// тоже цена как у грузового поскольку выше пассажирского, хоть и вес у нас попадает в категорию пассажирского транспорта
                }
            }

            else
            {
                price = passengerCarPrice;
            }

            /**
             * Проверка скорости подъезда и выставление штрафа
             */
            //Integer carSpeed
            int carSpeed = Camera.getCarSpeed(car);
            /**
             * Сравниваем скорость автомобиля с криминальной, если она выше то вызываем полицию.
             * Если ниже, то сравниваем ее с допустимой скоростью.
             * Если скорость выше то выписываем штраф. И добавляем его к общей стоимости проезда.
             * Если ниже то стоимость проезда остается прежней.
             */
            if(carSpeed > criminalSpeed) // если скорость выше кримальной то
            {
                Police.call("cкорость автомобиля - " + carSpeed + " км/ч, номер - " + car.getNumber()); //вызов полиции и сообщение на экран, скорость и номер авто
                blockWay("вы значительно превысили скорость. Ожидайте полицию!"); // обращение к методу и сообщение на экран
                continue;//начать цикл заново с увеличением i+1/
            }
            else if(carSpeed > maxOncomingSpeed) //если скорость выше допустимой разрешенной скорости
            {
                //Integer overSpeed
                int overSpeed = carSpeed - maxOncomingSpeed;
                //Integer totalFine
                int totalFine = finePerGrade * (1 + overSpeed / speedFineGrade);
                System.out.println("Вы превысили скорость! Штраф: " + totalFine + " руб.");// сообщение на экран и цена превышения
                price = price + totalFine; //к стоимсоти проезда через шлагбаум добавляем цену за превышение скорости
            }

            /**
             * Отображение суммы к оплате
             */
            System.out.println("Общая сумма к оплате: " + price + " руб.");//сообщение на экран с общей ценой
        }

    }

    /**
     * Открытие шлагбаума
     */
    public static void openWay()//создание публичного метода
    {
        System.out.println("Шлагбаум открывается... Счастливого пути!");// метод, и сообщение на эеран
    }

    public static void blockWay(String reason)//создание публичного метода
    {
        System.out.println("Проезд невозможен: " + reason);// метод, и сообщение на эеран
    }
}