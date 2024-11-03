```json
{
  "title": "Fluids",
  "icon": "oritech:fluid_pipe",
  "category": "oritech:logistics",
  "associated_items": [
    "oritech:fluid_pipe",
    "oritech:small_tank_block"
  ]
}
```

Rury płynowe działają podobnie do rur z przedmiotami, ale mają także małe wewnętrzne magazyny na każdym połączeniu. Gdy są skonfigurowane do wydobywania, rury płynowe będą pobierać płyny ze wszystkich sąsiednich bloków. W przeciwieństwie do rur z przedmiotami, rury płynowe mogą również przyjmować płyny z bloków, które są następnie transportowane do następnego dostępnego magazynu płynów.

;;;;;

Aby przechowywać płyny, można użyć zbiornika na płyny. Mały zbiornik na płyny może pomieścić do *256* wiader płynu. Po zniszczeniu, mały zbiornik zachowuje całą swoją zawartość w danych NBT przedmiotu. Stan napełnienia zbiornika można zmierzyć za pomocą wyjścia porównywacza. Stosowane zbiorniki automatycznie pozwolą płynom spływać w dół.

<block;oritech:small_tank_block>