from writer import Writer
from example import Example

if __name__ == "__main__":
    try:
        # Створення об'єкта Example та введення значення x
        x = float(input("Введіть значення x: "))
        eq = Example(x)

        # Обчислення функції та створення об'єкта Writer для збереження результатів
        result = eq.calculate()
        wr = Writer(result)

        # Запис та читання з двійкового файлу
        wr.wr_bin("Res.bin")
        print("Результат з двійкового файлу:", wr.rd_bin("Res.bin"))

        # Запис та читання з текстового файлу
        wr.wr_txt("Res.txt")
        print("Результат з текстового файлу:", wr.rd_txt("Res.txt"))

    except ArithmeticError as ex:
        print("Помилка:", ex)
    except ValueError:
        print("Помилка: введено невірний тип числа")
    except FileNotFoundError as ex:
        print("Помилка:", ex)
