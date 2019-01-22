# Babel Service
> A REST service which responds to your messages in a confusing way.

## Usage

Clone this repository. You'll need Git. To do this from the command line:

`git clone https://github.com/nazeemsoeltan/babel-app.git`

Go into the repository

`cd babel-service`

Run the service with the provided maven wrapper

`./mvnw spring-boot:run`

Send a message to the service. For sending "hi", with `curl` on the command line, use:

`http://localhost:8080/message/hi`

## Key features

You can alter the reponse message behaviour by using startup parameter `message-response-type`. Allowed values are: `ANSWER`
and `VAGUE`. The default behaviour is `ANSWER`

To start the server with a `VAGUE` behaviour:

`./mvnw spring-boot:run --message.response-strateg=ANSWER`

## License

MIT
