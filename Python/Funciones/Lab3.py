from Lab2 import is_year_leap, days_in_month


def day_of_year(year, month, day):
    dias = 0
    meses = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    meses_bisiesto = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    if is_year_leap(year):
        for i in range(month-1):
            dias += meses_bisiesto[i]
        dias += day
        return dias
    elif is_year_leap(year) == False:
        for i in range(month-1):
            dias += meses[i]
        dias += day
        return dias



print(day_of_year(2000, 12, 31))
print(day_of_year(2001, 12, 31))
print(day_of_year(2001, 5, 21))


