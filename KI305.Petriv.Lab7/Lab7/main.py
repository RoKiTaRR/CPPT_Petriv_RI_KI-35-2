# main.py
import matrix

if __name__ == '__main__':
    # Ввід розміру матриці
    size = int(input("Введіть розмір матриці: "))

    # Ввід символу-заповнювача
    filler = input("Введіть символ-заповнювач: ")

    # Перевірка на валідність символу-заповнювача
    if len(filler) != 1:
        print("Введіть коректний символ заповнювач")
    else:
        arr = matrix.create_length_of_each_sub_arr(size)
        matrix.print_matrix(arr, filler, size)