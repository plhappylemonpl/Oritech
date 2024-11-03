```json
{
  "title": "Addons",
  "icon": "oritech:machine_extender",
  "category": "oritech:processing",
  "associated_items": [
    "oritech:machine_extender",
    "oritech:capacitor_addon_extender",
    "oritech:machine_speed_addon",
    "oritech:machine_efficiency_addon",
    "oritech:machine_capacitor_addon",
    "oritech:machine_fluid_addon",
    "oritech:machine_yield_addon",
    "oritech:crop_filter_addon",
    "oritech:quarry_addon",
    "oritech:machine_acceptor_addon",
    "oritech:machine_inventory_proxy_addon"
  ],
  "ordinal": 2
}
```

Aby ulepszyć maszyny w oritech, używane są dodatki. Są to bloki, które muszą być podłączone do samej maszyny lub do podłączonego przedłużacza maszyny. Dodatki mogą robić wiele rzeczy, takich jak zwiększenie prędkości, efektywności energetycznej, zapewnienie dostępu do konkretnych slotów inwentarza i wiele więcej.

;;;;;

Maszyny mogą akceptować dodatki tylko w określonych pozycjach. Aby je zobaczyć, sprawdź stronę interfejsu użytkownika "dodatki" lub poszukaj tych znaczników na maszynie:  
![znacznik_maszyny](oritech:textures/book/addon_marker.png,fit)

;;;;;

Dodatki będą aktywowane, gdy maszyna zostanie kliknięta prawym przyciskiem myszy. Aby to wskazać, różowe części dodatku zmieniają kolor na niebieski, gdy są używane. Aby zwiększyć dostępną liczbę slotów na dodatki, możesz użyć przedłużaczy maszyny. Są to specjalne dodatki, które nie wpływają bezpośrednio na maszynę, ale pozwalają na umieszczanie dodatków na nich, które następnie liczą się do maszyny, z którą są połączone.

Maksymalna liczba warstw przedłużaczy maszyny, którą możesz 

;;;;;

użyć, zależy od jakości maszyny. Jeśli masz maszynę o jakości rdzenia 1, nie możesz używać żadnego przedłużacza. Każdy dodatkowy przedłużacz, który przechodzi **przez** inny przedłużacz, wymaga zwiększenia jakości rdzenia o 1.

Jakość rdzenia nigdy nie liczy bezpośrednio liczby aktywnych przedłużaczy maszyny. Zamiast tego liczy, przez ile przedłużaczy dodatek musi przejść, aby być połączonym z maszyną. Jeśli ta liczba jest większa niż jakość rdzenia, dodatek 

;;;;;

nie zostanie podłączony. Zobacz ten obrazek jako małą demonstrację:  
![dodatki_maszyn](oritech:textures/book/extenders.png,fit)

;;;;;

Jak wspomniano wcześniej, liczy się tylko liczba przedłużaczy pomiędzy maszyną a dodatkiem. Oznacza to, że możesz rozgałęziać przedłużacze, a wszystko będzie działać:  
![rozgałęzienie_dodatków](oritech:textures/book/addon_branching.png,fit)