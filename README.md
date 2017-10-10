# MyNews

### Bevezető
A MyNews egy olyan közösségi oldal, ahol a regisztrált felhasználók bejegyzéseket tehetnek közzé szöveges formátumban. A bejegyzések mind publikusak, de csak a regisztrált felhasználók tudnak hozzászólni és/vagy kedvelni vagy nem kedvelni egy bejegyzést.

### Funkciók
- **Regisztráció:** a regisztráció egy külön erre a célra készített oldalon történik. Meg kell adni egy egyedi email címet, a felhasználó valós nevét és egy jelszót.
- **Bejelentkezés:** email cím és jelszó megadásával történik.
- **Kijelentkezés:** a felhasználót a rendszer ezentúl vendégként kezeli. 
- **Adatlap szerkesztése:** a felhasználó módosíthatja az adatait, megoszthat magáról több információt és jelszót változtathat.
- **Adatlap megtekintése:** a felhasználók megtekinthetik egymás adatait.
- **Bejegyzések megtekintése:** a legfrissebb bejegyzés kerül mindig legfelülre. A regisztrált felhasználók a bejegyző nevére kattintva láthatják az adatlapját.
- **Bejegyzés írása:** a felhasználók szöveges bejegyzéseket tehetnek közzé.
- **Kommentelés:** a felhasználók egymás bejegyzéseihez hozzászólásokat fűzhetnek.
- **Like/Dislike:** a felhasználók tudják a bejegyzéseket kedvelni vagy nem kedvelni. Ezt egy számláló folyamatosan nyomon követi.
- **Privát üzenet:** a felhasználók egymás között tudnak üzenetet küldeni amit csak ők és a címzett lát.
- **Bejegyzés jelentése:** a felhasználók minden bejegyzést tudnak jelenteni, amikor is az adminisztrátornak jelzik, hogy a bejegyzés vagy egy komment a bejegyzésen nem megfelelő tartalmú.

### Felhasználók
- **Admin:** külön felületen törölhet bejegyzéseket, kommenteket és törölhet felhasználókat. A felhasználóktól érkező jelentéseket megkapja. Minden olyat tud amit egy "User".
- **User:** regisztrált felhasználó megtekintheti mások adatlapjait, egymás között privát üzenetet küldhet, bejegyzést írhat, kommentelhet, kedvelhet, jelenthet.
- **Guest:** megtekintheti a bejegyzéseket és a kommenteket, de nem írhat, kedvelhet vagy jelenthet.

### Adatbázis modell
![messages](https://user-images.githubusercontent.com/32630836/31410359-b1322b28-ae0e-11e7-9af8-be0149e6bfea.png)
![posts](https://user-images.githubusercontent.com/32630836/31410360-b14bf72e-ae0e-11e7-9345-8638a3b5a693.png)
![report](https://user-images.githubusercontent.com/32630836/31410361-b166531c-ae0e-11e7-8b07-c8a1582cc491.png)
![users](https://user-images.githubusercontent.com/32630836/31410363-b184b172-ae0e-11e7-8750-143b824c9ce4.png)
![comments](https://user-images.githubusercontent.com/32630836/31410364-b19de656-ae0e-11e7-940a-e324ff29c400.png)
