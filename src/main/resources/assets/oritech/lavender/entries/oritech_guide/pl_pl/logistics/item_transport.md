```json
{
  "title": "Item Transportation",
  "icon": "oritech:item_filter_block",
  "category": "oritech:logistics",
  "associated_items": [
    "oritech:item_pipe",
    "oritech:item_filter_block"
  ]
}
```

Oritech zawiera rury transportowe dla przedmiotów oraz bloki filtrów przedmiotów, aby zaspokoić Twoje potrzeby w zakresie logistyki przedmiotów. Rury przedmiotowe łączą się ze sobą i ze wszystkimi sąsiednimi inwentarzami.

;;;;;

W przeciwieństwie do innych rur, rury przedmiotowe nie mają własnego inwentarza. Oznacza to, że inne bloki (takie jak lejek) nie mogą samodzielnie wstawiać przedmiotów do sieci rur. Zamiast tego rura przedmiotowa może być ustawiona na wydobywanie z pobliskiego inwentarza. Aby to zrobić, wystarczy kliknąć prawym przyciskiem myszy na blok rury (który jest połączony z czymś). Jeśli masz wiele inwentarzy podłączonych do tego samego bloku rury, zauważysz, że wszystkie połączenia zmieniają się w tryb wydobywania. To jest

;;;;;

aktualne ograniczenie rur oritech. Jeśli ustawisz blok rury na wydobywanie, spróbuje on wydobyć przedmioty ze wszystkich bloków, które są połączone z tym blokiem rury. Aby rzeczywiście transportować jakiekolwiek przedmioty, sieć rur musi składać się z co najmniej 2 bloków.

Wydobyte przedmioty będą umieszczane w **najbliższym** dostępnym inwentarzu dalej w sieci.

;;;;;

Maksymalny zasięg transferu wynosi 64 bloki. Każda sieć dłuższa niż to musi być podzielona.

Rury zawsze będą wydobywać z pierwszego niepustego slotu w inwentarzu. Jeśli przedmiot nie może być umieszczony w inwentarzu sieci rur, zablokuje to rurę przed wydobywaniem z tego inwentarza.

;;;;;

**Filtry przedmiotów**  
<block;oritech:item_filter_block>  
Aby filtrować, które przedmioty trafiają gdzie, możesz użyć filtrów przedmiotów. To bloki, które możesz umieścić obok docelowego inwentarza. Mają 5 stron wejściowych i zawsze wypuszczają przedmioty w stronę, w którą są skierowane. Akceptują tylko przedmioty, które pasują do filtra ustawionego za pomocą interfejsu użytkownika, i automatycznie przesyłają je do docelowego inwentarza.

;;;;;

Jednak nie będą automatycznie wydobywać przedmiotów z sąsiednich inwentarzy.