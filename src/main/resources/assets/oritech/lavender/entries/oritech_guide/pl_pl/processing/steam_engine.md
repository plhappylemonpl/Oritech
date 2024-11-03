```json
{
  "title": "Steam Power",
  "icon": "oritech:steam_boiler_addon",
  "category": "oritech:processing",
  "associated_items": [
    "oritech:steam_engine_block",
    "oritech:steam_boiler_addon"
  ]
}
```

<block;oritech:steam_boiler_addon>

Wszystkie generatory (z wyjątkiem podstawowego generatora) mogą być ulepszane, aby produkować parę. Aby to zrobić, dodaj dodatek do kotła parowego. Po dodaniu maszyna przestanie bezpośrednio produkować RF.

;;;;;

Zamiast tego będzie produkować parę w stosunku 2:1. Aby wyprodukować parę, zużywana będzie woda. Płyny wody i pary mogą być pompowane do i z dodatku, ale nie z samej maszyny.

Aby wykorzystać parę, można użyć silnika parowego, aby produkować RF. Silnik ten przyjmuje parę jako wejście i wypuszcza wodę. Jednak podczas procesu około 20% wody zostanie utracone, dlatego potrzebna jest stała dostawa wody do generatorów.

;;;;;

Wiele silników parowych można ze sobą łączyć. Będą one dzielić magazyn energii, zbiornik wody i pary z pierwszego silnika w kolejce. Będą działać współpracując. 

Prędkość silnika parowego zmienia się w zależności od zgromadzonej pary. Więcej pary spowoduje większe ciśnienie, co sprawi, że silnik będzie działał szybciej. Prędkość jest skalowana liniowo na podstawie procentowego napełnienia zbiornika pary, z maksymalnym mnożnikiem wynoszącym 10, gdy zbiornik jest pełny.

;;;;;

Jednak wydajność silnika zmienia się w zależności od prędkości. Wyższa wydajność skutkuje większą ilością RF na jednostkę pary produkowanej. Wydajność maszyny jest najwyższa przy prędkości około 700%. Cokolwiek poniżej lub powyżej tej wartości spowoduje mniej idealny uzysk. Energia będzie wydobywana z czerwonych slotów maszyny. Porty płynów są oznaczone na niebiesko.