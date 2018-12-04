# springboot-string-reverse coding challenge
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
docker run -p 3000:3000 -t io.coding.challenge/springboot-string-reverse
```

__REST endpoint__
```
http://localhost:3000/reverse
```

__Testing__
```bash
curl -X POST -H "Content-Type: application/json; charset=UTF-8" -d '{"Hello World!"}' localhost:3000/reverse
```

__Shutdown__
```bash
curl -X POST localhost:3000/actuator/shutdown

# or
./shutdown.sh
```
