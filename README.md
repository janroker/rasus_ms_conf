# rasus_ms_config

# Arhitektura raspodijeljenog sustava

sustavi pracenje ocitanja temperature i vlažnosti ciji se mikroservisi implementiraju zasebno

Mikroservis za agregaciju koji dohvaca podatke prikupljene od mikroservisa za vlagu i mikroservisa za temperaturu.
Mikroservis za agregaciju pronalazi mikroservis za vlagu i mikroservis za temperaturu pomoću Spring Eureka servera.

Kako bi se izbjeglo ponovno pokretanje mikroservisa kada se konfiguracija promijeni i kako bi se konfiguracija držala na jednom mjestu, sustav koristi
konfiguracijski poslužitelj.

Kako bi omogucio sustavu da automatski otkrije nove mikroservise i kako bi sustav bio transparentniji,
skalabilniji i tolerantniji na greske, sustav koristi registracijski poslužitelj - Spring Eureka server.

Kako bi se pojednostavila implementacija i koristenje sustava, tri stvorena mikroservisa, posluzitelj
za konfiguraciju i posluzitelj za registraciju pakirani su u Docker kontejnere i mogu se pokrenuti
pomocu Docker Compose alata.
