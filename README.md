# Demo app

This demo application returns a JSON response with a list of registered security providers:
```java
@RestController
public class IndexController {

    @GetMapping("/")
    public String[] providers() {
        String[] providers = Arrays.stream(Security.getProviders())
                .map(Provider::getName)
                .toArray(String[]::new);

        return providers;
    }
}
```

# Expected result
List of security providers includes "Cloud Foundry Container" in both Java 8 and Java 11.

# Actual result
List of security providers includes "Cloud Foundry Container" *only* on Java 8.

# Consequences 
Because "Cloud Foundry Container" is not registered, CF certificates are not trusted and mTLS is not working. 

# Prerequisites
- SDKMAN https://sdkman.io/, with Java versions 8.0.201-oracle and  11.0.2-open installed
- CF CLI, logged into CF env

# Pushing examples
To push Java 8 version:
`. push-java8.sh`
To push Java 11 version:
`. push-java11.sh`

Then to get list of providers `curl` or open `https://jbp-security-provider-issue-8.<cf-domain>` and `https://jbp-security-provider-issue-11.<cf-domain>`. 

