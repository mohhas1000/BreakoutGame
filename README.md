# BreakoutGame
I denna laboration ska man skapa ett program som efterliknar spelet Breakout. Spelet går ut på att man ska i princip styra ett slagträ för att slå iväg en boll, som i sin tur ska träffa ett antal brickor. Spelet ska bestå utav en spelplan (GameBoard), där den övre delen av spelplanen ska brickorna utplaceras. Brickorna ska även bestå utav flera olika färger. Runt spelplanen ska det finnas tre väggar för att bollen ska kunna studsa på dem. Vid spelplanens botten ska det inte finnas någon vägg, eftersom när bollen åker ner så ska ett av liven förbrukas. Ett slagträ ska finnas längst ner på spelplanen som bollen kan studsa på, därtill ska slagträet styras med hjälp av tangentbord. Vissa brickor ska försvinna vid första träff, medan andra ska byta färg innan dem försvinner. Brickorna som förvinner vid första träff ska ge en poäng, samtidigt som brickorna med unika egenskaper ska ge extra poäng. Det är spelarens jobb att försöka träffa bollen med slagträet. Ifall spelaren missar bollen och den hamnar nedanför slagträet, så kommer spelaren få en boll mindre (Ett liv förbrukas). När spelaren har förbrukad tre bollar, det vill säga tre liv, då har spelaren förlorat samt att spelarens resultat ska visas tydligt på skärmen. Å andra sidan om alla brickor försvinner då har spelaren vunnit och spelarens resultat ska också visas på skärmen.

# Kravspecifikation
• Spelplanen ska ha tre kanter där bollen kan studsa mot dem.
• Spelplanen ska ha ett slagträ som styrs utav tangentbord och förflyttas endast i sidled.
• Spelplanen ska ha brickor som försvinner när bollen studsar på dem.
• Brickor i spelplanen ska ha olika färger.
• Det ska finnas brickor som tar flera olika träffar innan de försvinner, samt ska det även
visas tydligt genom att byta färg på brickor.
• Brickor ska ge poäng när spelaren träffar bollen, vissa brickor ska ge mer poäng än
andra.
• Bollen ska kunna studsa på slagträ och brickor.
• Spelarens nuvarande poäng ska synas i spelet.
• Om bollen hamnar nedanför slagträet, så ska en ny boll tilldelas till spelaren. När
spelaren har förlorat alla bollar så ska spelet vara över.
• Spelaren har tre bollar (liv) på sig för att få så många poäng som möjligt.
• Spelet ska startas genom att trycka på space-knappen.
• Spelet ska vara spelbart.

# Klasser, egenskaper och förmågor
Genom att analysera kravspecifikationen så kunde jag komma fram till att dessa klasser behövdes:
➢ En mainklass för att att skapa fönstret (Frame).
➢ En klass för mainpanel (Spelplanen).
➢ En klass för fönstret.
➢ En klass för bollen.
➢ En klass för Brickor.
➢ En klass för slagträet. 
