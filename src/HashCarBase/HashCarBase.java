package HashCarBase;

import java.util.*;

public class HashCarBase {
    public static final int MAXID = 3;
    
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

        String[] arrayIn = str.split("[,;:./]");
        String number = arrayIn[0].trim();
        String brand = arrayIn[0].trim();
        String colour = arrayIn[0].trim();
        String type = arrayIn[0].trim();
        if (arrayIn.length != 4)
            throw new DataInFormatException("Неправильный формат входных данных");
        else {
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
        if (!transportSet.contains(newTransport)) {
            transportSet.add(newTransport);
            return true;
        } else {
            System.out.println("Транспортное средство с данным номером уже есть в базе");
            return false;
        }
    }

    public static void writeTransportSet(Set transportSet) {
        List<Transport> list = new ArrayList<>(transportSet);
        Collections.sort(list);
        int cnt = 0;
        int cntId = MAXID;
        for (int ii = 0; ii < list.size(); ii++) {
            int id = list.get(ii).getId();
            String type = list.get(ii).getType();
            while (id != cntId) {
                cntId--;
                cnt = 0;
            }

            if (cnt == 0) {
                cnt++;
                convertType(type);
            }
            System.out.println(list.get(ii).toString());
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
