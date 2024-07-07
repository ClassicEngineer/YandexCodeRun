package easy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.HashSet
import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.streams.toList


/*
	В новой программе OpenCalculator появилась новая возможность – можно настроить, какие кнопки отображаются, а какие – нет.
	Если кнопка не отображается на экране, то ввести соответствующую цифру с клавиатуры или копированием из другой программы нельзя.
	 Петя настроил калькулятор так, что он отображает только кнопки с цифрами x, y, z. Напишите программу, определяющую, сможет ли Петя ввести число N, а если нет,
	  то какое минимальное количество кнопок надо дополнительно отобразить на экране для его ввода.
Формат ввода

Сначала вводятся три различных числа из диапазона от 0 до 9: x, y и z (числа разделяются пробелами).
Далее вводится целое неотрицательное число N, которое Петя хочет ввести в калькулятор. Число N не превышает 10000.
Формат вывода

Выведите, какое минимальное количество кнопок должно быть добавлено для того,
чтобы можно было ввести число N (если число может быть введено с помощью уже имеющихся кнопок, выведите 0)
*/
fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val len = 3
    val nums = ArrayList<Int>(len)
    val parts = reader.readLine().split(" ")
    for (element in parts) {
        nums.add(element.toInt())
    }
    val numbers = HashSet.newHashSet<Int>(10)
    val line = reader.readLine()
    for (c in line) {
        numbers.add(c.digitToInt())
    }
    var result = 0

    for (number in numbers) {
        if (!nums.contains(number)) {
            result++
        }
    }
    writer.write(result.toString())

    reader.close()
    writer.close()
}