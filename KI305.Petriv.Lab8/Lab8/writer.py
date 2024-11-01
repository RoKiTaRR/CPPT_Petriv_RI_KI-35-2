import os
import struct

class Writer:
    def __init__(self, result=0.0):
        self.result = result

    def set_result(self, result):
        """Метод для встановлення значення результату."""
        self.result = result

    def get_result(self):
        """Метод для отримання значення результату."""
        return self.result

    def wr_txt(self, f_name):
        """Запис результату у текстовий файл."""
        with open(f_name, 'w') as f:
            f.write(f"{self.result:.6f}\n")

    def rd_txt(self, f_name):
        """Зчитування результату з текстового файлу."""
        if os.path.exists(f_name):
            with open(f_name, 'r') as f:
                self.result = float(f.readline().strip())
            return self.result
        raise FileNotFoundError(f"Файл {f_name} не знайдено")

    def wr_bin(self, f_name):
        """Запис результату у двійковий файл."""
        with open(f_name, 'wb') as f:
            f.write(struct.pack('d', self.result))

    def rd_bin(self, f_name):
        """Зчитування результату з двійкового файлу."""
        if os.path.exists(f_name):
            with open(f_name, 'rb') as f:
                self.result = struct.unpack('d', f.read(8))[0]
            return self.result
        raise FileNotFoundError(f"Файл {f_name} не знайдено")
