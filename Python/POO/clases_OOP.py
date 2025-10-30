# class Vehicle:
#     pass


# class LandVehicle(Vehicle):
#     pass


# class TrackedVehicle(LandVehicle):
#     pass


# for cls1 in [Vehicle, LandVehicle, TrackedVehicle]:
#     for cls2 in [Vehicle, LandVehicle, TrackedVehicle]:
#         print(issubclass(cls1, cls2), end="\t")
#     print()


# class Vehicle:
#     pass


# class LandVehicle(Vehicle):
#     pass


# class TrackedVehicle(LandVehicle):
#     pass


# my_vehicle = Vehicle()
# my_land_vehicle = LandVehicle()
# my_tracked_vehicle = TrackedVehicle()

# for obj in [my_vehicle, my_land_vehicle, my_tracked_vehicle]:
#     for cls in [Vehicle, LandVehicle, TrackedVehicle]:
#         print(isinstance(obj, cls), end="\t")
#     print()
    


class Super:
    def __init__(self, name):
        self.name = name

    def __str__(self):
        return "(SuperClase)y name is " + self.name + "."


class Sub1(Super):
    def __init__(self, name):
        Super.__init__(self, name)

    def __str__(self):
        return "(Subclase1)My name is " + self.name + "."


class Sub2(Super):
    def __init__(self, name):
        Super.__init__(self, name)

    def __str__(self):
        return "(Subclase2)My name is " + self.name + "."

# obj = Sub2("Andy")

# print(obj)

lista = [Sub2("Andy"), Sub1("Andy"), Super("Andy")]

for objeto in lista:
    print(objeto.__str__())