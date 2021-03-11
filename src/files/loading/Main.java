package files.loading;

import files.safekeeping.GameProgress;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {
    public static final String GAMEPATH = "D:/netology/Games";

    public static void main(String[] args) {
        openZip(GAMEPATH + "/savegames/saves.zip", GAMEPATH + "/savegames");

        File dir = new File(GAMEPATH + "/savegames");
        showGameProgress(dir);
    }

    public static void openZip(String zipPath, String unpackedPath) {
        try (ZipInputStream zipInput = new ZipInputStream(new FileInputStream(zipPath))) {
            ZipEntry entry;
            String name;
            while ((entry = zipInput.getNextEntry()) != null) {
                name = entry.getName();
                FileOutputStream fileOutput = new FileOutputStream(unpackedPath + "/" + name);
                for (int ii = zipInput.read(); ii != -1; ii = zipInput.read()) {
                    fileOutput.write(ii);
                }
                fileOutput.flush();
                zipInput.closeEntry();
                fileOutput.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static GameProgress openProgress(String gamePath) {
        GameProgress gameProgress = null;
        try (FileInputStream fileInput = new FileInputStream(gamePath);
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
            gameProgress = (GameProgress) objectInput.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return gameProgress;
    }

    public static void showGameProgress(File dir) {
        if (dir.isDirectory()) {
            File[] fileList = dir.listFiles(((dir1, name) -> name.endsWith(".dat")));

            if (fileList.length > 0) {
                for (File fileOrDir : fileList) {
                    System.out.println("GameProgress " + fileOrDir.getName());
                    System.out.println(openProgress(fileOrDir.getPath()).toString());
                }
            } else
                System.out.println("Каталог пуст");
        }
    }

}
