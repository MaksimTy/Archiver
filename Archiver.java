package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.IOException;

public class Archiver {

    public static void main(String[] args) throws IOException {

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