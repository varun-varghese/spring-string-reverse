# Word Reverser

Using Spring Boot, Gradle, and your JVM lanugage of choice, create a REST service that:

- Receives a payload of the following format:

  ```java
  {
    "phrase": <string>
  }
  ```

- Reverses the individual words in the phrase (while leaving punctuation in place):

    `test` -> `test`
    `Hello World!` -> `olleH dlroW!`
    `ab.cd.ef.gh.ij` -> `ba.dc.fe.hg.ji`
    `Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.` -> `meroL muspi rolod tis tema, rutetcesnoc gnicsipida tile, des od domsuie ropmet tnudidicni ut erobal te erolod angam auqila.`

- Returns the result with the following format:

  ```java
  {
    "esarhp": <string>
  }
  ```

- Validates the request using the following rules, and returns an appropriate HTTP error response:

  - The request can not be empty/null
  - Content-Type must be application/json
  - Phrase can not be empty/null
  - Phrase must be < 1024 characters in length

Configure Spring Boot to expose this service on port 3000.

Create a Dockerfile that builds this service into a container.

### Deliverables

Deliverables are a zip file containing your full project directory, including:

  - The source code for your service
  - The Dockerfile
  - Your .git/ subdirectory (if you use git during development)
  - A README.MD with instructions on how to run your project
