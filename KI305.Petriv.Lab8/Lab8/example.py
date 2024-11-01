import math

class Example:
    def __init__(self, x=0):
        self.x = x

    def set_x(self, x):
        """Метод для встановлення значення x."""
        self.x = x

    def calculate(self):
        """Обчислює y = sin(3x - 5) / ctg(2x) з перевіркою на ділення на нуль."""
        if math.sin(2 * self.x) == 0:
            raise ArithmeticError("Помилка: ділення на нуль")
        return math.sin(3 * self.x - 5) / math.tan(2 * self.x)
