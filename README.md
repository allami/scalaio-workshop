# scala.io Lagom Workshop

This is a repository with an application stub for the Lagom workshop on scala.io in Lyon, November 3, 2017.

Example for how to create a reservation with [httpie](https://httpie.org/):

```
http localhost:9000/api/accommodation/my-flat/reservation \
accommodation=my-flat \
guest=Franz \
host=Bernd \
startingDate=2017-11-11 \
duration:=3
```


The state of the repository is now what I showed at the end of the workshop..
* RequestReservation is handled
* a notification is sent on the bus and logged in the notification-service

Exercises (i.e. homework ;)
* Add handling for missing commmands & events
* Create an endpoint that uses the ReservationRepository to query the read side

