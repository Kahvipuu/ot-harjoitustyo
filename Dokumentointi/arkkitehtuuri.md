# Rakenne
Ohjelman rakenne on sama kuin referenssisovelluksessa, ui on käyttöliittymä, domain sovelluslogiikka ja daot on tietojen tallentamiseen.
<img src="https://github.com/Kahvipuu/ot-harjoitustyo/blob/master/Dokumentointi/kaavio.PNG">

# Käyttöliittymä
Eri näkymät pelaajien luomiselle, radan luomiselle ja itse kierrokselle. Toistaiseksi arkistossa ei ole toiminnallisuutta.

Näkymät ovat päällekäin ja napeilla vaihdetaan näkyvää sivua. Kayttöliittymä on luokassa FribaTulosApp.ui.AppUi. Käyttöliittymässä ei käsitellä kuin käyttäjälle näkyviä komponentteja, muut on AppService metodien takana.

Kun käyttäjä tekee muutoksia, niin näkymää päivitetään muutosten mukana.

# Sovelluslogiikka
Sovellus toimii luokilla pelaaja ja rata, jotka annetaan kierros -luokalle. 	


# Tietojen pysyväistallennus
FilePlayerDao tallentaa pelaajien tiedot
FilecourseDao tallentaa radat
FileRoundOfPlayDao tallentaa pelaajien kirjaamat tulokset

# Päätoiminnallisuudet
Pelaajan luomisnäkymässä annetaan pelaajalle nimi ja painetaan nappulaa.
Alla kuvattu ohjelman toiminta. Ensin siirrytään oikeaan näkymään. Kirjoitetaan pelaajan nimi kenttään. Ohjelma kutsuu pelaajan luonti metodia antaen kenttään kirjoitetun nimen sille arvoksi. Pejaaja daolta tarkastetaan onko samannimistä pelaajaa jo olemassa ja jos ei ole niin luodaan uusi. Uusi pelaaja annetaan dao:lle tallennettavaksi. Sovelluslogiikka palauttaa boolean arvona onnistuiko pelaajan luominen.
<img src="https://github.com/Kahvipuu/ot-harjoitustyo/blob/master/Dokumentointi/sekvenssikaavio.PNG">

# Ohjelmaan jääneet heikkoudet
## Graafisen käyttöliittymän metodi start on pitkä, tätä on yritetty kommentoinnilla hieman jakaa. Kuitenkin metodia olisi syytä pilkkoa.

## DAO-luokat
Toteutuksessa on jonkin verran toisteista koodia, ja varmasti myös logiikassa olisi parannettavaaa. Testaus jäänyt vaillinaiseksi joten se olisi kuitenkin ensi sijalla.

