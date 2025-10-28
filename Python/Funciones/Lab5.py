def liters_100km_to_miles_gallon(liters):
    return 235.215 / liters

def miles_gallon_to_liters_100km(miles):
    return 235.215 / miles

print(liters_100km_to_miles_gallon(3.9))  # 60.3 mpg
print(liters_100km_to_miles_gallon(7.5))  # 31.4 mpg
print(liters_100km_to_miles_gallon(10.))  # 23.5 mpg

print(miles_gallon_to_liters_100km(60.3)) # 3.9 L/100km
print(miles_gallon_to_liters_100km(31.4)) # 7.5 L/100km
print(miles_gallon_to_liters_100km(23.5)) # 10.0 L/100km
