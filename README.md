# scala.io Lagom Workshop

This is a repository with an application stub for the Lagom workshop on scala.io in Lyon, November 3, 2017.

Example for how to create a reservation with [httpie](https://httpie.org/):

```
http localhost:9000/api/accomodation/my-flat/reservation \
accomodation=my-flat \
guest=Franz \
host=Bernd \
startingDate=2017-11-11 \
duration:=3
```
