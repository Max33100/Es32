# Esercizion Numero 32

Un artista da strada esegue delle caricature e dei ritratti a carboncino. Chi vuole un ritratto si siede in una delle quattro sedie messe a disposizione e attende il suo turno per spostarsi nella zona di lavoro dove farsi fare il ritratto. Le persone intorno arrivano continuamente e guardano incuriosite, attendendo che una delle quattro sedie si liberi per potersi mettere in attesa del ritratto. Tuttavia, le persone che aspettano per troppo tempo una sedia libera (stabilire un tempo predefinito all’inizio del programma) rinunciano a farsi fare il ritratto. Simulare questa situazione utilizzando i semafori come meccanismo di sincronizzazione tra i processi. In particolare, tenere presente che:

- all’inizio non c’è nessun cliente
- i clienti arrivano in numero e a istanti di tempo casuali
- l’artista non impiega sempre lo stesso tempo per eseguire un ritratto


## Sincronizzazione
All'interno del programma vengono utilizzati __Due semafori__. Il primo semaforo a *conteggio* rappresenta le __Sedie__ ed ha il compito di monitorare le sedie occupate e libere, invece il secondo semaforo *mutex* rappresenta il __Pittore__ ed ha il compito di capire se il pittore stia già lavorando alla sua opera oppure no. 

## Starvation e stalli
Non viene utilizzata nessun tipo di __Attesa Circolare__ limitando ed in generale, eliminando la possibilità di un *Deadlock* dove tutti i processi si fermano, rendendo così impossibile lo stallo. Mentre la *Starvation* è risolta dalla __coda rappresentata dalle sedie__. 

## INQUADRAMENTO DELLA SOLUZIONE
Il codice è stato scritto tramite l'utilizzo di un __semaforo a conteggio__ che possa simulare se le sedie sono occupate oppure no. Per quanto riguarda il tempo di attesa, utilizziamo una funzione che permette di ottenere il tempo nel momento in cui dovrebbe farsi dipingere dal pittore e sottrarlo al tempo iniziale cioè il momento in cui si è seduto. nel caso questo tempo risulti maggiore del tempo deciso di attesa massimo, il cliente se ne andrà senza ottenere il suo dipinto, caso contrario verrà dipinto dall'artista.


```java
if((System.currentTimeMillis()-tattesa)<=tfine) {
                System.out.println("\nIl Trhead numero "+n+" è Entrato");
