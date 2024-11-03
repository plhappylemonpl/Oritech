```json
{
  "title": "Energy",
  "icon": "oritech:energy_pipe",
  "category": "oritech:logistics",
  "associated_items": [
    "oritech:energy_pipe",
    "oritech:small_storage_block",
    "oritech:large_storage_block"
  ]
}
```

Oritech wykorzystuje {gold}**RF**{} do zasilania wszystkich swoich maszyn. Działa na podstawie API Reborn Energy, co sprawia, że jest kompatybilny ze wszystkimi modami korzystającymi z systemu energii Tech Reborn, który obecnie obejmuje prawie wszystkie mody korzystające z energii fabric.

Dostępny jest tylko jeden poziom kabli, zdolny do przesyłania do {gold}10k RF/t{}.

;;;;;

Generatory zawsze produkują energię, a wszystkie inne maszyny przyjmują energię z każdej strony (nie wypuszczając jej ponownie). Same kable mogą przechowywać do {gold}10k RF{} w każdym połączeniu maszyny, jeśli nie mogą wypuścić energii.

;;;;;

Aby buforować i przechowywać energię, można używać bloków magazynowych energii. Występują w dwóch rozmiarach i mogą być znacznie rozszerzane za pomocą dodatków. Bloki magazynowe energii przyjmują energię ze wszystkich stron za pośrednictwem {green}zielonego portu{}, a mogą wypuszczać energię tylko przez jeden {red}czerwony port{}. Sygnał redstone wyłącza wszystkie wyjścia energii.

<block;oritech:small_storage_block>

;;;;;

Energii można również przesyłać bezprzewodowo za pomocą lasera enderycznego. Po więcej informacji zobacz [laser enderyczny](^oritech:interaction/enderic_laser).

![laser enderyczny](oritech:textures/book/enderic_laser.png,fit)