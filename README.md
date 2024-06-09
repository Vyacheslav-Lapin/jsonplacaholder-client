# jsonplacaholder-client
[![](https://jitpack.io/v/Vyacheslav-Lapin/jsonplacaholder-client.svg)](https://jitpack.io/#Vyacheslav-Lapin/jsonplacaholder-client)
## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>pro.vlapin.experiments</groupId>
    <artifactId>jsonplacaholder-client</artifactId>
    <version>0.0.1-7</version>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "pro.vlapin.experiments:jsonplacaholder-client:0.0.1-8"
```

### Others

At first generate the JAR by executing:
```shell
mvn package
```

Then manually install the following JARs:

* target/jsonplacaholder-client-0.0.1-8.jar
* target/lib/*.jar
