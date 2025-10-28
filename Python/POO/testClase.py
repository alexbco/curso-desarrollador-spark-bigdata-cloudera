class Stack:
    def __init__(self):
        self.__stack_list = [] 
    def push(self, val):
        self.__stack_list.append(val)


    def pop(self):
        val = self.__stack_list[-1]
        del self.__stack_list[-1]
        return val

stack1 = Stack()
stack2 = Stack()

print(stack2.__stack_list)  # Output: []
print(stack1.__stack_list)  # Output: []






