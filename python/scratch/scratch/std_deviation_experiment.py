import math


def mean(numbers: list) -> float:
    data_sum = 0
    for number in numbers:
        data_sum += number

    return float(data_sum) / float(len(numbers))


def variance(numbers: list) -> float:
    data_mean = mean(numbers)
    deviation_squares = [(x - data_mean) ** 2 for x in data]
    variance_sum = 0
    for element in deviation_squares:
        variance_sum += element

    return float(variance_sum) / float(len(numbers) - 1)


def standard_deviation(numbers: list) -> float:
    return math.sqrt(variance(numbers))


def kris_deviation(numbers: list) -> float:
    data_mean = mean(numbers)
    deviation_absolutes = [math.fabs(x - data_mean) for x in data]
    deviation_sum = 0
    for element in deviation_absolutes:
        deviation_sum += element

    print(data_mean)
    print(deviation_absolutes)
    print(deviation_sum)
    return float(deviation_sum) / float(len(numbers))


data = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

print(standard_deviation(data))
print(kris_deviation(data))
