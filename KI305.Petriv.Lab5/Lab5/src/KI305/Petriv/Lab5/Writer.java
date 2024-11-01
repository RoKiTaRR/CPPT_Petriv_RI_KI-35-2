package KI305.Petriv.Lab5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Клас Writer - відповідає за запис та читання результатів у текстовий і двійковий файли.
 */
public class Writer {
    private double result;

    // Конструктор за замовчуванням
    public Writer() { }

    // Конструктор з параметром результату
    public Writer(double result) {
        this.result = result;
    }

    // Метод для встановлення значення результату
    public void setResult(double result) {
        this.result = result;
    }

    // Метод для отримання значення результату
    public double getResult() {
        return this.result;
    }

    // Метод для запису результату у текстовий файл
    public void wrTxt(String fName) throws IOException {
        try (PrintWriter f = new PrintWriter(fName)) {
            f.printf("%f ", result);
        }
    }

    // Метод для зчитування результату з текстового файлу
    public double rdTxt(String fName) throws IOException {
        File f = new File(fName);
        if (f.exists()) {
            try (Scanner s = new Scanner(f)) {
                result = s.nextDouble();
            }
        } else {
            throw new IOException("Файл " + fName + " не знайдено");
        }
        return result;
    }

    // Метод для запису результату у двійковий файл
    public void wrBin(String fName) throws IOException {
        try (DataOutputStream f = new DataOutputStream(new FileOutputStream(fName))) {
            f.writeDouble(result);
        }
    }

    // Метод для зчитування результату з двійкового файлу
    public double rdBin(String fName) throws IOException {
        try (DataInputStream f = new DataInputStream(new FileInputStream(fName))) {
            result = f.readDouble();
        }
        return result;
    }
}
