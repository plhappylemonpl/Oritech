```json
{
  "title": "Block Destroyer",
  "icon": "oritech:destroyer_block",
  "category": "oritech:interaction",
  "associated_items": [
    "oritech:destroyer_block"
  ],
  "ordinal": 3
}
```

<block;oritech:destroyer_block[machine_assembled=true]>

Blok destruktor jest używany, jak się domyślasz, do niszczenia bloków. Jest to [multi-blok](^oritech:processing/multiblocks), który działa na [ramie maszyny](^oritech:interaction:machine_frames) i celuje w warstwę bloków bezpośrednio poniżej ramy.

;;;;;

Czas i energia potrzebne do zniszczenia bloku zależą od twardości bloków. Blok destruktor próbuje zniszczyć wszystkie bloki poniżej. Aby umożliwić użycie w rolnictwie, można zainstalować dodatek filtra upraw. Spowoduje to, że blok destruktor pominie wszystkie niedokończone uprawy.

<block;oritech:crop_filter_addon>

;;;;;

Dodając dodatki do kamieniołomu, blok destruktor może być również używany jako kamieniołom. Każdy dodatek kamieniołomu mnoży zasięg przez 8.

To oznacza, że jeden dodatek daje zasięg 8, 2 dodatki dają zasięg 64, a 3 dodatki dają zasięg 512.

<block;oritech:quarry_addon>