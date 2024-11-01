# matrix.py

def create_length_of_each_sub_arr(size):
    """Генерує зубчастий масив для заданого розміру."""
    arr = []
    for i in range(size):
        arr.append([' '] * (size - i))
    return arr

def print_matrix(arr, filler, size, file_name="Lab1.txt"):
    """Виводить зубчастий масив в консоль та записує у файл."""
    print("Результат матриці:")
    with open(file_name, "w") as writer:
        for i in range(size):
            # Додаємо відступи перед символами
            row_str = " " * (i * 2)
            writer.write(row_str)
            print(row_str, end="")
            for j in range(size - i):
                arr[i][j] = filler
                row_str = arr[i][j] + " "
                print(row_str, end="")
                writer.write(row_str)
            print()
            writer.write("\n")