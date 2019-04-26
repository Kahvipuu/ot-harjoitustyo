#Rakenne
Ohjelman rakenne on sama kuin referenssisovelluksessa, ui on käyttöliittymä, domain sovelluslogiikka ja daot on tietojen tallentamiseen.
<img src="https://github.com/Kahvipuu/ot-harjoitustyo/blob/master/Dokumentointi/kaavio.PNG">

#Käyttöliittymä
Eri näkymät pelaajien luomiselle, radan luomiselle ja itse kierrokselle.

#Sovelluslogiikka
Sovellus toimii luokilla pelaaja ja rata, jotka annetaan kierros -luokalle. 	

#Tietojen pysyväistallennus
FilePlayerDao tallentaa pelaajien tiedot
FilexxDao tallentaa tulokset --tulossa

#Päätoiminnallisuudet
Pelaajan luomisnäkymässä annetaan pelaajalle nimi ja painetaan nappulaa.
Alla kuvattu ohjelman toiminta. Ensin siirrytään oikeaan näkymään. Kirjoitetaan pelaajan nimi kenttään. Ohjelma kutsuu pelaajan luonti metodia antaen kenttään kirjoitetun nimen sille arvoksi. Pejaaja daolta tarkastetaan onko samannimistä pelaajaa jo olemassa ja jos ei ole niin luodaan uusi. Uusi pelaaja annetaan dao:lle tallennettavaksi. Sovelluslogiikka palauttaa boolean arvona onnistuiko pelaajan luominen.
<img src="https://github.com/Kahvipuu/ot-harjoitustyo/blob/master/Dokumentointi/sekvenssikaavio.PNG">