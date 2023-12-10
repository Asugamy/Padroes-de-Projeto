# Classe base para todos os componentes
class MenuComponent:

    def get_name(self):
        raise NotImplementedError

    def get_description(self):
        raise NotImplementedError

    def is_vegetarian(self):
        raise NotImplementedError

    def get_price(self):
        raise NotImplementedError

# Classe para representar um item de menu
class MenuItem(MenuComponent):

    def __init__(self, name, description, is_vegetarian, price):
        self.name = name
        self.description = description
        self.is_vegetarian = is_vegetarian
        self.price = price

    def get_name(self):
        return self.name

    def get_description(self):
        return self.description

    def is_vegetarian(self):
        return self.is_vegetarian

    def get_price(self):
        return self.price

# Classe para representar um menu
class Menu(MenuComponent):

    def __init__(self, name, description):
        self.name = name
        self.description = description
        self.children = []

    def get_name(self):
        return self.name

    def get_description(self):
        return self.description

    def is_vegetarian(self):
        for child in self.children:
            if not child.is_vegetarian():
                return False
        return True

    def get_price(self):
        total_price = 0
        for child in self.children:
            total_price += child.get_price()
        return total_price

    def add(self, component):
        self.children.append(component)

    def remove(self, component):
        self.children.remove(component)

# Exemplo de uso

# Cria um item de menu vegetariano
vegetarian_item = MenuItem("Vegetariano", "Um item vegetariano", True, 10)

# Cria um item de menu não vegetariano
non_vegetarian_item = MenuItem("Não vegetariano", "Um item não vegetariano", False, 20)

# Cria um menu
menu = Menu("Meu menu", "Meu menu favorito")

# Adiciona os itens de menu ao menu
menu.add(vegetarian_item)
menu.add(non_vegetarian_item)

# Imprime o preço total do menu
print(menu.get_price())
