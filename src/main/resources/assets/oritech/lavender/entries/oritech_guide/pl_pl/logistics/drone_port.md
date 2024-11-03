```json
{
  "title": "Drone Port",
  "icon": "oritech:drone_port_block",
  "category": "oritech:logistics"
}
```

<block;oritech:drone_port_block>

Port dronów pozwala transportować przedmioty na dużą odległość za pomocą latających dronów. Wymaga zbudowania i zasilenia portu dronów w miejscu startu i lądowania.

;;;;;

Po zbudowaniu musisz przypisać port docelowy, używając przedmiotu do wyznaczania celu. Powiąż go z docelowym portem dronów, klikając prawym przyciskiem myszy z wciśniętym klawiszem shift. Następnie w porcie, z którego chcesz wysłać przedmioty, otwórz interfejs użytkownika i umieść wyznacznik w specjalnym slocie na przedmioty.

Port docelowy musi znajdować się w odległości co najmniej 50 bloków. Obszar, w którym się znajduje, również musi być załadowany w chunkach.

;;;;;

Port dronów może wysyłać przedmioty tylko do jednego konkretnego portu docelowego, ale port może odbierać przedmioty z wielu portów. Każdy dron zajmuje jednak kilka sekund na lądowanie, więc jeśli przedmioty przychodzą zbyt często, jeden port odbiorczy może być przeciążony, gdy jest celem dla wielu portów.

Czas dostawy przedmiotów jest stały, niezależnie od odległości, jaką musi pokonać dron. Koszt energii jednak wzrasta z odległością.

;;;;;

Kwadratowa wartość odległości jest używana w obliczeniach zużycia energii.