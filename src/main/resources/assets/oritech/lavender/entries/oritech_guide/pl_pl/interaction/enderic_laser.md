```json
{
  "title": "Enderic Laser",
  "icon": "oritech:laser_arm_block",
  "category": "oritech:interaction",
  "associated_items": [
    "oritech:laser_arm_block",
    "oritech:fluxite",
    "minecraft:amethyst_cluster",
    "minecraft:amethyst_shard"
  ],
  "ordinal": 6
}
```

![enderowy laser](oritech:textures/book/enderic_laser.png,fit)

Ekstraktor bedrocku może wydobywać rudy z poniżej bedrocku w miejscach, gdzie znajdują się [węzły zasobów rud](^oritech:resources/resource_nodes). Ta maszyna [multi-blokowa](^oritech:processing/multiblocks) może działać tylko wtedy, gdy jest umieszczona na węzłach zasobów i musi być zasilana za pomocą [enderowych laserów](^oritech:interaction/enderic_laser).

;;;;;

**Kontrola**

Aby ustawić kierunek docelowy lasera, wybierz cel za pomocą przedmiotu [wskaźnika celu](^oritech:tools/target_designator). Następnie przytrzymaj klawisz shift i kliknij prawym przyciskiem myszy na **dolny** blok lasera, aby przypisać cel. Laser będzie kontynuował strzelanie w kierunku celu, dopóki będzie coś do trafienia.

*Zauważ, że ustawiasz tylko kierunek celu. Oznacza to, że laser zniszczy również bloki przed i za celem*. Sygnał redstone dezaktywuje laser.

Maksymalny zasięg wynosi 64.

;;;;;

**Zbieranie Fluxitu**

Ogromne ilości energii z enderowego lasera powodują, że dorosłe klastery ametystów zamieniają się w fluxit, gdy zostaną zniszczone.
<block;minecraft:amethyst_cluster>

Przyspieszają również wzrost ametystów, gdy są skierowane na same wyrastające ametysty.

;;;;;

**Przesył energii**

Gdy enderowy laser celuje w blok, który może przechowywać energię (np. jakakolwiek maszyna), napełni on magazyn energii tej maszyny. 
Laser ignoruje wszystkie ograniczenia wejściowe i wyjściowe i może napełniać magazyny energii maszyn, które mogą nie akceptować energii bezpośrednio z kabli.

;;;;;

**Dodatek Łowcy Maszyn**

Gdy enderowy laser ma dodatek łowcy maszyn, będzie celował w moby zamiast bloków. Ulepszenia dodatków wciąż działają podczas polowania na moby: dodatek wydajności sprawi, że moby będą wypadać więcej łupów, a więcej dodatków łowcy wydłuży zasięg skanowania celu, dodatki szybkości zwiększą zadawane obrażenia (i zmniejszą efektywność energetyczną), a filtr upraw uniknie zabijania młodych zwierząt.

;;;;;

Jeśli nosisz [zbroję exo](^oritech:tools/exo_armor), to enderowy laser naładował ją za Ciebie.

**Celowanie Łowcy**

Użyj [wskaźnika celu](^oritech:tools/target_designator) na enderowym laserze, aby zmienić tryby celowania. Domyślnie atakuje tylko potwory, ale możesz również ustawić go, aby atakował zwierzęta lub nawet wędrownych handlarzy. Uważaj, gdzie go używasz i jak ustawiasz celowanie, ponieważ możesz zabić rzeczy, których nie chcesz zabić.

;;;;;

**Więcej szczegółów**

Promień lasera będzie celował w dowolny blok, ale przechodzi przez szkło (i nie-wyrastające ametysty). Dodatki kamieniołomu zwiększą szerokość wykopanego obszaru.

Laser ma tylko 1 slot na dodatek dostępny na dole. Dodatki będą wpływać tylko na prędkość i wydajność łamania bloków, przesył energii może korzystać tylko z ulepszeń prędkości.

Blok docelowy zatrzyma laser przed dalszym działaniem, nie będąc zniszczonym.