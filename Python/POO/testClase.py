from typing import Self


class Stack:
    def __init__(self):
        self.__stack_list = [] 

    def push(self, val):
        self.__stack_list.append(val)


    def pop(self):
        val = self.__stack_list[-1]
        del self.__stack_list[-1]
        return val

# stack2 = Stack()
# #print(stack2._Stack__stack_list)  Para acceder a un atributo privado desde fuera de la clase. Mala practica

# stack_object = Stack()
# stack_object2 = Stack()

# stack_object.push(1)
# stack_object.push(2)
# stack_object.push(3)

# stack_object2.push("uno")
# stack_object2.push("dos")    
# stack_object2.push("tres")


# #stack_object.klk = "hola"  Mala practica, pero se puede hacer
# print(vars(stack_object))


class AddingStack(Stack):
    def __init__(self):
        Stack.__init__(self)
        self.__sum = 0

    def push(self, val):
        self.__stack_list.append(val)
        self.__sum += val


    def pop(self):
        val = self.__stack_list[-1]
        del self.__stack_list[-1]
        self.__sum -= val
        return val
    

pila2 = AddingStack()

print(vars(pila2))