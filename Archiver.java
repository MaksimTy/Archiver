package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Archiver {

    public static void main(String[] args) throws Exception {
//todo test!!! убрать перед сдачей
/*        Path path = Paths.get("C:\\JavaRushTasks\\3.JavaMultithreading\\src\\com\\javarush\\task\\task31\\task3110\\res\\archiv.zip");
        ZipFileManager zipFileManager = new ZipFileManager(path);
        List<Path> list = new ArrayList<>();
                list.add(Paths.get("file.TXT"));
                list.add(Paths.get("fil_.TXT"));

        System.out.println(list.size());
        zipFileManager.removeFiles(list);*/


        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }

        } while (operation != Operation.EXIT);
    }

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Выберите операцию:");
        for (Operation op : Operation.values()
        ) {
            StringBuilder strBul = new StringBuilder();
            strBul.append(op.ordinal()).append(" - ").append(op.getDescription());
            ConsoleHelper.writeMessage(strBul.toString());
        }
        int choice = ConsoleHelper.readInt();
        return Operation.values()[choice];
    }
}