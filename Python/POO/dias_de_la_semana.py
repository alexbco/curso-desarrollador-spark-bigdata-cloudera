class WeekDayError(Exception):
    pass
	

class Weeker:
    dias_semana = {1:"Lunes", 2:"Martes", 3:"Miercoles",4:"Jueves",5:"Viernes",6:"Sabado",7:"Domingo"}

    def __init__(self, dia):
        self.dia = dia

    def __str__(self):
        return f"El dia de la semana es {self.dia}"

    def add_days(self, n):        
        while (n - 7) >= 7:
            n -= 7

        self.dias_semana[self.dia] += n


    def subtract_days(self, n):
        #
        # Escribir código aquí.
        #
        pass
    
    def __dia_numerico(self):
        dia_numerico = self.dias_semana[self.dia]
        return dia_numerico

try:
    weekday = Weeker('Lunes')
    print(weekday)
    weekday.add_days(15)
    print(weekday)
    weekday.subtract_days(23)
    print(weekday)
    weekday = Weeker('Lun')
except WeekDayError:
    print("Lo siento, no puedo atender tu solicitud.")
    