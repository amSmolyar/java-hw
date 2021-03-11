package files.setup;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static final String GAMEPATH = "D:/netology/Games";

    public static void main(String[] args) {
        StringBuilder temp = new StringBuilder();

        temp.append(makeDirectory(GAMEPATH, "src") + "\n");
        temp.append(makeDirectory(GAMEPATH, "res") + "\n");
        temp.append(makeDirectory(GAMEPATH, "savegames") + "\n");
        temp.append(makeDirectory(GAMEPATH, "temp") + "\n");

        temp.append(makeDirectory(GAMEPATH + "/src", "main") + "\n");
        temp.append(makeDirectory(GAMEPATH + "/src", "test") + "\n");

        temp.append(makeDirectory(GAMEPATH + "/res", "drawables") + "\n");
        temp.append(makeDirectory(GAMEPATH + "/res", "vectors") + "\n");
        temp.append(makeDirectory(GAMEPATH + "/res", "icons") + "\n");

        temp.append(createFile(GAMEPATH + "/src/main", "Main.java") + "\n");
        temp.append(createFile(GAMEPATH + "/src/main", "Utils.java") + "\n");

        temp.append(createFile(GAMEPATH + "/temp", "temp.txt") + "\n");
        writeDataToFile(GAMEPATH + "/temp/temp.txt", temp.toString() + "\n");
    }

    public static String makeDirectory(String path, String nameDir) {
        File srcDir = new File(path, nameDir);
        if (srcDir.mkdir()) {
            System.out.println("В каталоге " + path + " создана директория '" + nameDir + "'.");
            return ("В каталоге " + path + " создана директория '" + nameDir + "'.");
        } else {
            System.out.println("Ошибка в создании директории '" + nameDir + "' в каталоге " + path);
            return ("Ошибка в создании директории '" + nameDir + "' в каталоге " + path);
        }
    }

    public static String createFile(String path, String nameFile) {
        File newFile = new File(path + "//" + nameFile);
        String message = " ";
        try {
            if (newFile.createNewFile()) {
                System.out.println("В каталоге " + path + " создан файл '" + nameFile + "'.");
                message = ("В каталоге " + path + " создан файл '" + nameFile + "'.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            message = ("Ошибка в создании файла '" + nameFile + "' в каталоге " + path);
        }
        return message;
    }

    public static void writeDataToFile(String file, String data) {
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(data);
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
