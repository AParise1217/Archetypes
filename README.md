# Archetypes
Various Domain Archetype Patterns implemented in Groovy.


# Sources
Much of these models are based on those presented in "Enterprise 
    Patterns and MDA" by Jim Arlow and Ila Neustadt. I highly recommend 
    picking up a copy of this book to get a better understanding on 
    model driven architecture.

# Performing a Snapshot Release Deployment
*Note: This must occur prior to the Release Deployment!*

Make sure the "release-sign-artifacts" and "ossrh" 
    Maven profiles are active.

1) `mvn clean`
2) `mvn release:prepare -Possrh,release-sign-artifacts`
3) `mvn release:perform -Possrh,release-sign-artifacts`

* await the release process to finish *

4) `git push --tags`
5) `git push origin master`

# Performing a Release Deployment

1) Update the Release Version
`mvn versions:set -DnewVersion=1.2.3`
