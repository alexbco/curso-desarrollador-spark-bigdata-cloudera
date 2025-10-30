# Testing properties: class variables.
# class Super:
#     supVar = 1


# class Sub(Super):
#     subVar = 2


# obj = Sub()

# print(obj.subVar)
# print(obj.supVar)


# class Level1:
#     variable_1 = 100
#     def __init__(self):
#         self.var_1 = 101

#     def fun_1(self):
#         return 102


# class Level2(Level1):
#     variable_2 = 200
#     def __init__(self):
#         super().__init__()
#         self.var_2 = 201
    
#     def fun_2(self):
#         return 202


# class Level3(Level2):
#     variable_3 = 300
#     def __init__(self):
#         super().__init__()
#         self.var_3 = 301

#     def fun_3(self):
#         return 302


# obj = Level3()


# print(obj.variable_1, obj.var_1, obj.fun_1())
# print(obj.variable_2, obj.var_2, obj.fun_2())
# print(obj.variable_3, obj.var_3, obj.fun_3())



class Level1:
    var = 100
    def fun(self):
        return 101


class Level2(Level1):
    var = 200
    def fun(self):
        return 201


class Level3(Level2):
    pass


obj = Level3()

print(obj.var, obj.fun())
    