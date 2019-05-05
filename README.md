# FribaTulosApp

Sovellukseen merkitään frisbeegolf tulokset kierroksittain ja henkilöittäin. Kaikille on yhteiset radat joita voi käyttää. Kaikki pystyvät myös merkitsemään tulokset toistensa puolesta.



## Dokumentaatio
[vaatimusmaarittely.md](https://github.com/Kahvipuu/ot-harjoitustyo/blob/master/Dokumentointi/vaatimusmaarittely.md)

[arkkitehtuuri.md](https://github.com/Kahvipuu/ot-harjoitustyo/blob/master/Dokumentointi/arkkitehtuuri.md)

[Käyttöohje.md](https://github.com/Kahvipuu/ot-harjoitustyo/blob/master/Dokumentointi/Kayttoohje.md)

[Testausdokumentti] (https://github.com/Kahvipuu/ot-harjoitustyo/blob/master/Dokumentointi/Testausdokumentti.md)

## Releaset
[Release, viimeisin. Vain Jar] (https://github.com/Kahvipuu/ot-harjoitustyo/releases/download/1b/FribaTulosApp-1.0-SNAPSHOT.jar)
[Kaikki] (https://github.com/Kahvipuu/ot-harjoitustyo/releases)

## Työaikakirjanpito
[tyoaikakirjanpito.md] (https://github.com/Kahvipuu/ot-harjoitustyo/blob/master/Dokumentointi/tyoaikakirjanpito.md)

## Komentorivitoiminnot

### Testaus
Testit suoritetaan komennolla:
mvn test

Testikattavuusraportti luodaan komennolla:
mvn jacoco:report

Kattavuusraportti löytyy sijainnista: 
../target/site/jacoco/index.html

### Suoritettavan jarin generointi
jar saadaan luotua komennolla:
mvn package

löytyy sijainnista
../target/FribaTulosApp-1.0-SNAPSHOT.jar

### JavaDoc
JavaDoc luodaan komennolla:
mvn javadoc:javadoc

tiedosto löytyy sijainnista:
../target/site/apidocs/index.html

### Checkstyle
Tarkistukset suoritetaan checkstyle.xml määrittelemällä tavalla komennolla:
mvn jxr:jxr checkstyle:checkstyle

Raportti löytyy sijainnista:
../target/site/checkstyle.html
