# Knapsack Problem Solver
Добро пожаловать в программу Knapsack Problem Solver!
Это консольное приложение позволяет находить оптимальное решение программирования задачи о рюкзаке в следующих постановках: задача о булевом рюкзаке, задача о целочисленном рюкзаке, нелинейная задача о рюкзаке

## Demo
https://github.com/user-attachments/assets/f983138b-f8eb-4fad-a110-b2d37589a161


## Установка
Загрузите файл Knapsack_problem.jar. Внимание: рядом с .jar файлом будет создаватся файл Input.txt для ввода графа, поэтому имеет смысл поместить .jar в отдельную папку.

## Использование
1. Откройте консоль (для Windows - cmd, для MacOS - Terminal)
2. Внутри консоли откройте папку с проектом (cd <путь-до-папки>)
3. Введите в консоли команду
```bash
java -jar Knapsack_problem.jar
```
4. Навигация по приложению реализована в формате выбора пунктов меню. Находясь в главном меню, вы можете решить задачу (введите 1 и нажмите Enter), октрыть файл для ввода в режиме чтения (2), выйти из программы (0).
5. Выбрав пункт решения задачи (1), выберите постановку желаемой задачи (булева, целочисленная или нелинейная).
6. Выберите необходимый способ ввода задачи. Она может быть введена вручную (1) или сгенерирована (2). **Обратите внимание:**  Данные вводятся в следующем порядкке: вес рюкзака, n весов предметов, n стоимостей предметов. В булевой и целочисленной постановке стоимости представляют последовательность чисел длины n, в нелинейной стоимости вводятся n последовательностей чисел, каждая длиной m, где m - количество входящих в рюкзак предметов уникального типа. Значения разделяются единственным пробелом или единственным переносом строки.


## Возможные проблемы и их решения
1. Если введен новый граф, а в блокноте отображается старый - попробуйте перезапустить блокнот, либо воспользуйтесь редакторами с функцией auto-refresh
