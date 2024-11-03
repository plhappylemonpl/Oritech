```json
{
  "title": "Redstone",
  "icon": "oritech:energy_pipe",
  "category": "oritech:interaction",
  "associated_items": [
    "oritech:machine_redstone_addon",
    "minecraft:redstone"
  ]
}
```

Niektóre maszyny Oritech mogą bezpośrednio interagować z sygnałem redstone, takie jak przenośny zbiornik i przenośna energia. Zawartość przenośnego zbiornika można zmierzyć za pomocą komparatora, a wyjście przenośnego magazynu energii można wyłączyć za pomocą sygnału redstone. W przypadku wszystkich innych bloków wymagany jest "Kontroler Dodatku Redstone".

;;;;;

Kontroler dodatku redstone można podłączyć w taki sam sposób jak każdy inny dodatek i można go skonfigurować za pomocą interfejsu użytkownika. Po skonfigurowaniu, dane mogą być odczytywane za pomocą komparatora. Sygnał komparatora będzie wyjściem z dodatku, a nie z samej maszyny. Maszynę można również wyłączyć sygnałem redstone do dodatku.