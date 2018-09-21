# wd-von-gotnten coding challenge
This is a basic web application serving a single REST end-point */reverse*. This end-point takes an input string as the payload and reverses the individual words in the pharse whil leaving the punctuation in place.

## Usage
__Build__
```bash
./gradlew build docker
```

__Run__
```bash
./run-docker-local.sh
```
or:
```bash
docker run -p 3000:3000 -t io.coding.challenge/wd-von-gonten
```

__REST endpoint__
```
http://localhost:3000/reverse
```

__Shutdown__
```bash
curl -X POST localhost:3000/actuator/shutdown

# or
./shutdown.sh
```