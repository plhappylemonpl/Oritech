```json
{
  "title": "Particle Accelerator",
  "icon": "oritech:accelerator_ring",
  "category": "oritech:interaction",
  "associated_items": [
    "oritech:accelerator_ring",
    "oritech:accelerator_motor",
    "oritech:accelerator_controller",
    "oritech:accelerator_sensor",
    "oritech:black_hole_block"
  ],
  "ordinal": 6
}
```

<block;oritech:accelerator_ring>

Akcelerator cząstek może być używany do, jak się domyślasz, przyspieszania cząstek. Cząstka zaczyna od bloku akceleratora cząstek. Możesz w nim umieścić dowolny przedmiot, który będzie używany jako cząstka. Prosty pierścień prowadzący

;;;;;

musi być umieszczony tuż za kontrolerem, skierowany na bok. Wizualizacje powinny się pokrywać.

Po włożeniu cząstka podróżuje wzdłuż trasy określonej przez pierścienie prowadzące. Można je kliknąć prawym przyciskiem myszy, aby dodać skręt o 45 stopni z jednej strony. Kolejny pierścień prowadzący musi znajdować się na drodze cząstki zgodnie z definicją pierścieni prowadzących. W zależności od prędkości dozwolona odległość między blokami prowadzącymi rośnie.

;;;;;

Maksymalna odległość obliczana jest według następującego wzoru:

> clamp(sqrt(speed), 2, 10)

To oznacza, że przy wyższej prędkości odległość między blokami prowadzącymi może być większa.

;;;;;

**Przełączniki Redstone**

Kiedy sygnał redstone jest podawany do nieprostego bloku prowadzącego, zamienia się w blok przełącznika. Kiedy jest zasilany, prowadzi cząstki prosto, a kiedy jest wyłączony, kieruje je z powrotem w oryginalnym zakrzywionym kierunku. Jednak cząstka może także wchodzić z "innego" kierunku. Jest to zobrazowane mniejszą czerwoną szklaną rurką. Cząstka podąży ścieżką białej rurki i może wchodzić zarówno z czerwonej, jak i białej rurki.

;;;;;

Przy wyższych prędkościach cząstka nie będzie mogła wykonywać zbyt ciasnych zakrętów. Jeśli ostatni pełny zakręt o 90 stopni jest zbyt blisko, cząstka wyjdzie z prowadzonej trasy i zamiast tego wystrzeli w świat. Jeśli odległość między blokami prowadzącymi jest zbyt duża lub nie znaleziono kolejnego prowadzącego, również wystrzeli w świat. Minimalna odległość między zakrętami obliczana jest w ten sposób:

> sqrt(speed) / 3

;;;;;

**Interakcje**

Jednostki trafione przez cząstkę będą obrażane na podstawie aktualnej prędkości cząstki. Po wyjściu z prowadzonej ścieżki również zrani jednostki na swojej drodze i zniszczy bloki, aż nie zostanie więcej pędu. Kiedy dwie cząstki się zderzą (z różnych kontrolerów), mogą stworzyć nowe przedmioty.

Kiedy cząstka przechodzi przez silnik akceleratora, przyspiesza o 1 m/s. Wymaga to, aby silnik

;;;;;

był zasilany. Wymagania dotyczące mocy rosną wraz z prędkością.

Zarówno silniki cząstek, jak i czujniki mogą być używane jako proste prowadnice.

;;;;;

**Czujniki Prędkości**

Prędkość cząstek można mierzyć za pomocą czujnika cząstek. Następnie można użyć komparatora, aby uzyskać sygnał redstone w oparciu o prędkość cząstek. Następująca tabela pokazuje wymaganą prędkość dla każdego poziomu redstone:

1. 0
2. 10
3. 50
4. 75
5. 100

;;;;;

6. 150
7. 250
8. 500
9. 750
10. 1000
11. 2500
12. 5000
13. 7500
14. 10000
15. 15000

;;;;;

**Projekt Akceleratora**

Akceleratory cząstek można budować na różne sposoby, w zależności od ich celów. Możesz zbudować prostą linię silników, aby po prostu wystrzelić cząstki w coś. Jednak jeśli chcesz osiągnąć wyższe prędkości, okrągły układ jest zazwyczaj znacznie bardziej efektywny. Próbując dotrzeć do określonych elementów, mogą być potrzebne bardzo duże pierścienie. Ponieważ powolne cząstki wymagają bliskiego ułożenia pierścieni prowadzących, często sensowne jest najpierw rozpoczęcie

;;;;;

cząstki w małym pierścieniu, a następnie użycie redstone, aby przenieść ją do większego pierścienia.

W niektórych przypadkach może być potrzebnych wiele etapów pierścieni.

;;;;;

**Inkurzje Wymiarowe**

Kiedy pewne elementy zderzają się zbyt dużą energią, przerywają czasoprzestrzeń, tworząc małą inkurzję wymiarową. Ponieważ wymagana ilość energii, aby to osiągnąć, jest ogromna, niewiele wiadomo o tych inkurzjach i co je wywołuje. Badacze zauważyli, że zderzając ładunki ognia z energią kolizji przekraczającą 5000J, wydaje się przybliżać Nether. Perły Endera i więcej niż 10000J wydają się

;;;;;

robić to samo dla wymiaru Endu.

Są plotki o naukowcach próbujących bombardować jedną z tych inkurzji z prędkościami przekraczającymi najwyższe zmierzone wartości. Jednak nikt nie przeżył, aby opowiedzieć tę historię.