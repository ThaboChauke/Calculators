import kivy
from kivy.app import App
from kivy.clock import Clock
from kivy.uix.boxlayout import BoxLayout

kivy.require('2.3.0')


class Root(BoxLayout):

    def __init__(self):
        super(Root,self).__init__()

    def cal_symbol(self,symbol):
        placeholder = self.calculator_field.text
        
        if placeholder == "0":
            self.calculator_field.text = ""
            self.calculator_field.text += symbol
        else:
            self.calculator_field.text += symbol

    def clear(self):
        self.calculator_field.text = "0"

    def get_results(self):
        try:
            self.calculator_field.text  = str(eval(self.calculator_field.text))
        except ZeroDivisionError:
            self.calculator_field.text = "Undefined"
            Clock.schedule_once(lambda dt: self.clear(), 3)
        except SyntaxError:
            self.calculator_field.text = "Syntax Error"
            Clock.schedule_once(lambda dt: self.clear(), 3)
        except NameError:
            self.calculator_field.text = "0"

    def erase(self):
        current_input = self.calculator_field.text
        updated_input = current_input[:-1]
        self.calculator_field.text = updated_input

    def brackets(self):
        current_input = self.calculator_field.text

        if "(" in current_input:                   
            updated_input = f"{current_input})"
            self.calculator_field.text = updated_input
        else:
            updated_input = f"({current_input}"
            self.calculator_field.text = updated_input

    def positive_negative(self):
        current_input = self.calculator_field.text

        if "-" in current_input:
            self.calculator_field.text = current_input.replace("-","")
        else:
            self.calculator_field.text = f"-{current_input}"


class Calculator(App):
    
    def build(self):
        return Root()


if __name__ == "__main__":
    calculator = Calculator()
    calculator.run()
