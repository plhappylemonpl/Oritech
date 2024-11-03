```json
{
  "title": "Machine Frames",
  "icon": "oritech:machine_frame_block",
  "category": "oritech:interaction",
  "associated_items": [
    "oritech:machine_frame_block",
    "oritech:destroyer_block",
    "oritech:placer_block",
    "oritech:fertilizer_block"
  ],
  "ordinal": 0
}
```

*[blok umieszczający](^oritech:interaction/block_placer), [blok niszczący](^oritech:interaction/block_destroyer) oraz [nawoz](^oritech:interaction/fertilizer)* działają na dźwigu, który jest zbudowany z ram maszynowych. Rama maszyny wyznacza obszar, w którym maszyny działają. Musi mieć prostokątny kształt i być pusty w środku.

Maszyny zawsze celują w bloki **poniżej** ramy.

Dowolna liczba maszyn może działać na tej samej ramie maszyny. Aby to zrobić, wystarczy umieścić wiele maszyn

;;;;;

na ramie. Maszyny zawsze przeglądają wszystkie bloki w obszarze ramy.

Wszystkie maszyny, które działają na ramach maszynowych, mogą korzystać z większości dodatków.

Dodatek prędkości zwiększa zarówno prędkość ruchu, jak i prędkość działania.

<block;oritech:machine_speed_addon>