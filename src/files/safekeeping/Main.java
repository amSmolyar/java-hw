package files.safekeeping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static final String GAMEPATH = "D:/netology/Games";

    public static void main(String[] args) {
        GameProgress game1 = new GameProgress(99, 5, 2, 100.2);
        GameProgress game2 = new GameProgress(85, 3, 4, 157.8);
        GameProgress game3 = new GameProgress(64, 4, 5, 170.5);

        List<String> savePathList = new ArrayList<>();
        savePathList.add(GAMEPATH + "/savegames/save1.dat");
        savePathList.add(GAMEPATH + "/savegames/save2.dat");
        savePathList.add(GAMEPATH + "/savegames/save3.dat");

        saveGame(savePathList.get(0), game1);
        saveGame(savePathList.get(1), game2);
        saveGame(savePathList.get(2), game3);

        zipFiles(GAMEPATH + "/savegames/saves.zip", savePathList);
        deleteFiles(savePathList);

        System.out.println("Все прошло успешно!");
    }

    public static void saveGame(String fullPath, GameProgress game) {
        try (FileOutputStream fileOutput = new FileOutputStream(fullPath);
             ObjectOutputStream outObject = new ObjectOutputStream(fileOutput)) {
            outObject.writeObject(game);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void zipFiles(String fullPath, List<String> fileList) {
        try (ZipOutputStream zipOutput = new ZipOutputStream(new FileOutputStream(fullPath))) {
            int cntFles = 0;
            for (String path : fileList) {
                cntFles++;
                try (FileInputStream fileInput = new FileInputStream(path)) {
                    ZipEntry entry = new ZipEntry("packed_save" + cntFles + ".dat");
                    zipOutput.putNextEntry(entry);
                    byte[] buffer = new byte[fileInput.available()];
                    fileInput.read(buffer);
                    zipOutput.write(buffer);
                    zipOutput.closeEntry();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteFiles(List<String> pathList) {
        for (String path : pathList) {
            File fileToDelete = new File(path);
            fileToDelete.delete();
        }

    }
}
