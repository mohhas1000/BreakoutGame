# BreakoutGame
I detta projekt har ett program utvecklats som efterliknar spelet Breakout. Spelet går ut på att man ska i princip styra ett slagträ för att slå iväg en boll, som i sin tur ska träffa ett antal brickor. Spelet består av en spelplan (GameBoard), där den övre delen av spelplanen har brickorna utplacerats. Brickorna består utav flera olika färger. Runt spelplanen finnas det tre väggar för att bollen ska kunna studsa på dem. Vid spelplanens botten finns det inte någon vägg, eftersom när bollen åker ner så ska ett av liven förbrukas. Ett slagträ finns längst ner på spelplanen som bollen kan studsa på, där slagträet styrs med hjälp av tangentbordet. Vissa brickor försvinner vid första träff, medan andra byter färg innan dem försvinner. Brickorna som förvinner vid första träff ska ge en poäng, medan brickorna med unika egenskaper ska ge extra poäng. Det är spelarens jobb att försöka träffa bollen med slagträet. Ifall spelaren missar bollen och den hamnar nedanför slagträet, så kommer spelaren få en boll mindre (Ett liv förbrukas). När spelaren har förbrukad tre bollar, det vill säga tre liv, då har spelaren förlorat och med det visas spelarens resultat tydligt på skärmen. Å andra sidan om alla brickor försvinner då har spelaren vunnit och därav visas spelarens resultat på skärmen.

# Kravspecifikation
- Spelplanen ska ha tre kanter där bollen kan studsa mot dem.\
- Spelplanen ska ha ett slagträ som styrs utav tangentbord och förflyttas endast i sidled.\
- Spelplanen ska ha brickor som försvinner när bollen studsar på dem.\
- Brickor i spelplanen ska ha olika färger.\
- Det ska finnas brickor som tar flera olika träffar innan de försvinner, samt ska det även
visas tydligt genom att byta färg på brickor.\
- Brickor ska ge poäng när spelaren träffar bollen, vissa brickor ska ge mer poäng än
andra.\
- Bollen ska kunna studsa på slagträ och brickor.\
- Spelarens nuvarande poäng ska synas i spelet.\
- Om bollen hamnar nedanför slagträet, så ska en ny boll tilldelas till spelaren. När
spelaren har förlorat alla bollar så ska spelet vara över.\
- Spelaren har tre bollar (liv) på sig för att få så många poäng som möjligt.\
- Spelet ska startas genom att trycka på space-knappen.\
- Spelet ska vara spelbart.

# Klasser, egenskaper och förmågor
Genom att analysera kravspecifikationen så kunde jag komma fram till att dessa klasser behövdes:
- En mainklass för att att skapa fönstret (Frame).\
- En klass för mainpanel (Spelplanen).\
- En klass för fönstret.\
- En klass för bollen.\
- En klass för Brickor.\
- En klass för slagträet. 

## Mainklass
Mainklass är en klass som endast har förmågan att skapa ett nytt Frame-fönster och det är
där programmet exekveras först.

## Mainpanel
Mainpanel är en klass som beskriver spelplanen och har båda egenskaper och förmågor.
Egenskaperna hos Mainpanel är bland annat att spelarens nuvarande poäng ska finnas på
skärmen samt hur många liv spelaren har. Därtill har Mainpanel en egenskap som bestämmer
hur snabbt bollen och slagträet ska förflyttas. För att allt ska synas på skärmen så har
Mainpanel en PaintComponent-funktion som är en förmåga hos klassen. Klassen har även
förmågan att kunna kontrollera kollisionen mellan brickor, slagträet och bollen, dessutom har
Mainpanel förmågan att kunna ta bort brickor, slagträet, bollen och kunna styra slagträet med
tangentbordet. Klassen har också förmågan att minska spelarens liv med ett när bollen hamnar
nedanför slagträet.

## Fönstret
Syftet med klassen till fönstret är att framställa fönstret egenskaper och visa spelplanen med
hjälp förmågan ”Boll_window”. Exempelvis är det i fönstret som spelaren kan se spelplanen.

## Bollen
Bollklassen har som uppgift att beskriv egenskaperna och förmågorna hos bollen. Bollens egenskaper är att den
har en storlek, färg, hastighet i x-led, hastighet i y-led och en viss position i x-led samt y-led.
Förmågorna hos bollen är att den ska kunna förflyttas (ge en hastighet), försvinna, styras med
tangentbordet som är några exempel.

## Brickor
Klassen Brick, precis som klassen Boll, skapades för brickorna. Brickorna har egenskaper som till exempel
storlek, position och färg. Medan förmågorna hos klassen brick är att kunna ta bort, ge dessa
egenskaper, samt byta färg på brickorna.

## Slagträet
Klassen för slagträet beskriver egenskaperna och förmågorna hos slagträet. Slagträets egenskaper är
att den har en storlek, en hastighet samt en position i x-led och y-led. Slagträet har förmågan
att kunna försvinna, röra på sig, visas på skärmen och ge en hastighet för slagträet
