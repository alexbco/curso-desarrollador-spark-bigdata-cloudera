from Lab1 import is_year_leap

def days_in_month(year, month):
    meses_normal = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    meses_bisiesto = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

    if is_year_leap(year):
        return meses_bisiesto[month-1]
    elif is_year_leap(year) == False:
        return meses_normal[month-1]


test_years = [1900, 2000, 2016, 1987]
test_months = [2, 2, 1, 11]
test_results = [28, 29, 31, 30]

def solucion():
    for i in range(len(test_years)):
        yr = test_years[i]
        mo = test_months[i]
        print(yr, mo, "->", end="")
        result = days_in_month(yr, mo)
        if result == test_results[i]:
            print("OK")
        else:
            print("Fallido")
