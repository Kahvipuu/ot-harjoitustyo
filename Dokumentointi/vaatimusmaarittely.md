# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen avulla voi pitää kirjaa käyttäjän ja muun seurueen tuloksista frisbeegolf kierroksella. Sovellus muistaa siihen tallennetut radat ja niiden par -tulokset ja näyttää kierroksella pelaajien kumulatiivisen tuloksen sekä keskinäisen järjestyksen.

## Käyttäjät
Alkuun luon roolin vain peruskäyttäjälle, mutta siten että yksi käyttäjä voi kirjata tulokset kerralla usealle käyttäjälle. Usein yksi pitää kirjaa kaikkien tuloksesta joten käyttäjien luomisen tulee olla helppoa.

## Käyttöliittymäluonnos
Piirrustuksen liitän jos sellaiselle koen tarvetta jatkossa. Perinteinen tapa toteuttaa vastaava sovellus on helppokäyttöisillä '+' ja '-' -napeilla.


## Perusversion tarjoama toiminnallisuus

### Ennen kirjautumista

- Käyttäjä voi luoda oman tunnuksen
  - Uniikki ja varmaan se kolme merkkiä tähän riittää

- Kirjautuminen
  - Jos tunnusta ei ole niin kysytään luodaanko uusi /(tai sitten vain ilmoitetaan puutteesta)  
  
### Kirjautumisen jälkeen

- Käyttäjä voi luoda pelaajia jotka halutaan kierrokselle mukaan

- Käyttäjä voi aloittaa uuden pelikierroksen
  - joko uudella tai vanhalla radalla
  - ja halutuilla pelaajilla

- Kun kierros on pelattu se tallennetaan tietokantaan
  - Vanhoja tuloksia voi selata sekä katsoa kierrosten keskiarvoja sekä muita oleellisia tietoja

- Uloskirjautuminen  


## Kehitysideoita
Jos ei ole liian vaikeaa niin teen toiminnallisuuden jolla uusi käyttäjä voi ottaa itselleen haltuun jo luodun pelaajan tiedot.
Sään salliessa saatan yrittää muistella miten tehdään yksinkertainen graafi, josta pelaaja voi katsella kehitystään.
Muissa vastaavissa sovelluksissa on esimeriksi kartta tallennettuna ja niillä reitit ja pituudet.
