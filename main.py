import kivy
from kivy.app import App
# from kivy.core.window import Window
from kivy.uix.boxlayout import BoxLayout

kivy.require('2.3.0')


class Root(BoxLayout):

    def __init__(self):
        super(Root,self).__init__()

    def cal_symbol(self,symbol):
        self.calculator_field.text += symbol

    def clear(self):
        self.calculator_field.text = ""

    def get_results(self):
        self.calculator_field.text  = str(eval(self.calculator_field.text))


class Calculator(App):
    
    def build(self):
        return Root()


calculator = Calculator()
calculator.run()