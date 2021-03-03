package javaBasics.HashCarBaseSecondVar;

import java.util.*;

// Типы автомобиля нужно вводить следующим образом:
// легковой (или car)
// грузовой (или truck)
// спецтранспорт (или special transport)
// Тип транспортного средства, введенный другим способом, будет отнесен к категории "другие транспортные средства"

public class HashCarBaseSecondVar {

    public static final String[] TYPEARRAY = new String[]{"car", "truck", "special transport", "another type"};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String scanData = "";
        Set<Transport> transportSet = new HashSet<>();
        Transport newTransport;

        System.out.println("Привет!");
        while (true) {
            System.out.println("Введите информацию об автомобиле (в формате: номер, марка, цвет, тип автомобиля):");
            scanData = scan.nextLine().trim();

            if (scanData.equals("")) {
                writeTransportSet(transportSet);
                break;
            }

            try {
                newTransport = detectTransport(scanData);
            } catch (DataInFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Исключение обработано");
                continue;
            }
            addTransport(transportSet, newTransport);
        }

        scan.close();
    }

    public static Transport detectTransport(String str) throws DataInFormatException {
        Transport currentTransport;

        String[] arrayIn = str.split("([,;:./(\\s+)])");
        if (arrayIn.length != 4)
            throw new DataInFormatException("Неправильный формат входных данных");
        else {
            String number = arrayIn[0].trim();
            String brand = arrayIn[1].trim();
            String colour = arrayIn[2].trim();
            String type = arrayIn[3].trim();
            switch (type) {
                case ("легковой"):
                case ("car"):
                    currentTransport = new Car(number, brand, colour);
                    break;
                case ("грузовой"):
                case ("truck"):
                    currentTransport = new Truck(number, brand, colour);
                    break;
                case ("спецтранспорт"):
                case ("special transport"):
                    currentTransport = new SpecialTransport(number, brand, colour);
                    break;
                default:
                    currentTransport = new Transport(number, brand, colour, type);
                    break;
            }
        }
        return currentTransport;
    }

    public static boolean addTransport(Set transportSet, Transport newTransport) {
        if (transportSet.add(newTransport))
            return true;
        else {
            System.out.println("Транспортное средство с данным номером уже есть в базе");
            return false;
        }
    }

    public static void writeTransportSet(Set transportSet) {
        int cnt;
        String transportType;
        int typeIndex;
        for (int cntType = 0; cntType < TYPEARRAY.length; cntType++) {
            cnt = 0;
            Iterator<Transport> it = transportSet.iterator();
            while (it.hasNext()) {
                Transport transport = it.next();
                transportType = transport.getType();
                typeIndex = Arrays.asList(TYPEARRAY).indexOf(transportType);
                if ((transportType.equals(TYPEARRAY[cntType])) || ((TYPEARRAY[cntType].equals("another type")) && (typeIndex < 0))) {
                    if (cnt == 0) {
                        convertType(TYPEARRAY[cntType]);
                        cnt++;
                    }
                    System.out.println(transport.toString());
                }
            }
        }
    }

    public static void convertType(String type) {
        if (type.equals("car"))
            System.out.println("\nЛегковые автомобили:");
        else if (type.equals("truck"))
            System.out.println("\nГрузовые автомобили:");
        else if (type.equals("special transport"))
            System.out.println("\nСпецтранспорт:");
        else
            System.out.println("\nДругие типы транспортных средств:");
    }

}
