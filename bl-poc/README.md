# POC Subscriber Push Strategy

The following proof of concept explain the push strategy of a subscription in Pub/Sub in GCP.
The push strategy needs HTTPS occupying cloud resources in GCP, thus in this proof of concept 
a pub-sub emulation will be done, raising a local server with some python resources that GCP offers.

This readme is based on the following GCP guide:
https://cloud.google.com/pubsub/docs/emulator

## Prerequisites
- The Python development environment configured appropriately
- Java JRE (version 7 or higher) installed
- The Google Cloud SDK installed. Cloud SDK contains gcloud command line tool
- An application that has been compiled with the Google Cloud client libraries.
- Git
## Installation

#### Installing the emulator
```
gcloud components install pubsub-emulator
gcloud components update
```

#### Starting the emulator
```
gcloud beta emulators pubsub start --project=PUBSUB_PROJECT_ID [options]
```

#### Automatically setting the variables
If your application and the emulator run on the same machine, you can set the environment variables automatically:

Run env-init using command substitution:
```
$(gcloud beta emulators pubsub env-init)
```

#### Clone python docs examples
Clone the python code examples for start a pub-sub server
```
git clone https://github.com/GoogleCloudPlatform/python-docs-samples
```
In your cloned repository, navigate to the pubsub/cloud-client directory. You'll complete the rest of these steps in this directory.

From within the pubsub/cloud-client directory, install the dependencies needed to run the example:

```
pip install -r requirements.txt
```

Create a topic

```
python publisher.py PUBSUB_PROJECT_ID create TOPIC_ID
```

Create a push subscription with the url of this POC http://localhost:8080/api/message
```
python subscriber.py PUBSUB_PROJECT_ID create-push TOPIC_ID SUBSCRIPTION_ID \
PUSH_ENDPOINT
```



## Usage


After that, you can run the gradle command to compile the sources:

```
./gradlew clean build
```

Then you need to run the following command to run the jar that was generated with gradle:

```
java -jar build/libs/*.jar

```

Then you need run the next command for publish a message in a topic of the local server:

```
 python publisher.py PUBSUB_PROJECT_ID publish TOPIC_ID
```

Finally, 
you can trace the messages that come from the topic in the local application that started with java.


