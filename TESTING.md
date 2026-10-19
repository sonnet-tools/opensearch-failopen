    ./gradlew test -Dtests.jvm.argline="-XX:HeapDumpPath=/path/to/heapdumps"
To run all the backwards compatibility tests use:
For example :
The minimum JDK versions for runtime and compiling need to be installed, and environment variables `JAVAx_HOME`, such as `JAVA8_HOME`, pointing to the JDK installations are required to run the tests against unreleased versions, since the distributions are created by building from source. The required JDK versions for each branch are located at [.ci/java-versions.properties](.ci/java-versions.properties), see [BwcSetupExtension](./buildSrc/src/main/java/org/opensearch/gradle/internal/BwcSetupExtension.java) for more information.
  - [Good practices](#good-practices)
Example:
For example :
  -Dtests.security.manager=false \
    ./gradlew module:test --tests "*esi*"
-   **`OpenSearchClientYamlSuiteTestCase`** : A subclass of `OpenSearchRestTestCase` used to run YAML based REST tests.
By default, the tests run on multiple processes using all the available cores on all available CPUs. Not including hyper-threading. If you want to explicitly specify the number of JVMs you can do so on the command line:
- JDK 11
    ./gradlew test -Dtests.iters=N -Dtests.maxfailures=M -Dtestcase=...
### Use randomized-testing for coverage
    ./gradlew :server:jacocoTestReport
To be able to run a single test you need to specify the module where you're running the tests from.
    ./gradlew precommit
2. From a terminal run the following `./gradlew run --debug-jvm`. You can also run this task in IntelliJ.
Say you need to make a change to `main` and have a BWC layer in `5.x`. You will need to: . Create a branch called `index_req_change` off your remote `${remote}`. This will contain your change. . Create a branch called `index_req_bwc_5.x` off `5.x`. This will contain your bwc layer. . Push both branches to your remote repository. . Run the tests with `./gradlew check -Dbwc.remote=${remote} -Dbwc.refspec.5.x=index_req_bwc_5.x`.
    - [Use randomized-testing for coverage](#use-randomized-testing-for-coverage)
    ./gradlew bwcTest
If you want to just run the precommit checks:
If you have spawned multiple OpenSearch nodes (with `-PnumNodes=N` or by adding nodes with `-PstartNode=N`), debug ports will be assigned sequentially starting from `5005`. If you use `--debug-jvm`, your IDE must be listening for each node's debug port. For a multi-node setup, `--debug-server-jvm` may be easier, since you can start all nodes, then attach your IDE to one or more of them as needed.
## BWC Testing with security
    ./gradlew check -Dtests.coverage=true
To test a plugin with a custom build of OpenSearch, build OpenSearch and use the `customDistributionUrl` setting supported by each plugin to override the OpenSearch distribution.
    ./gradlew test -Dtests.seed=DEADBEEF
## Load balancing and caches
-   **`OpenSearchRestTestCase`**: An integration tests that interacts with an external cluster via the REST API. This is used for Java based REST tests.
    ./gradlew test -Dtests.opensearch.logger.level=DEBUG
The code coverage report can be generated through Gradle with [JaCoCo plugin](https://docs.gradle.org/current/userguide/jacoco_plugin.html). Following are some of the ways to generate the code coverage reports locally.
        includeCore '_common', 'indices', 'index', 'cluster', 'nodes', 'get', 'ingest'
Print all the logging output from the test runs to the command line even if tests are passing.
The default test case will ensure that no open file handles or running threads are left after tear down. You must ensure that all resources are cleaned up at the end of each test case, or else the cleanup may end up racing with the tear down logic in the base test class in a way that is very difficult to reproduce.
For unit test inside a specific module:
      -Dtests.method="test {p0=cat.segments/10_basic/Help}"
In general, randomization should be used for parameters that are not expected to affect the behavior of the functionality that is being tested. For instance the number of shards should not impact `date_histogram` aggregations, and the choice of the `store` type (`niofs` vs `mmapfs`) does not affect the results of a query. Such randomization helps improve confidence that we are not relying on implementation details of one component or specifics of some setup.
### Abuse randomization in multi-threaded tests
The REST tests are run automatically when executing the "./gradlew check" command. To run only the YAML REST tests use the following command (modules and plugins may also include YAML REST tests):
**NOTE:** If you have imported the project into IntelliJ according to the instructions in [DEVELOPER_GUIDE.md](DEVELOPER_GUIDE.md#intellij-idea), then a debug run configuration named **Debug OpenSearch** will be created for you and configured appropriately.
    ./gradlew :rest-api-spec:yamlRestTest \
A specific test case can be run with the following command:
`-PcustomDistributionUrl=...` uses a custom build of the distribution of OpenSearch. This is unnecessary when running against standard/unmodified OpenSearch core distributions.
- To generate report in CSV format: `-Dtests.coverage.report.csv=true`
-   **`OpenSearchTestCase`**: The base class of all tests. It is typically extended directly by unit tests.
Some of these checks will require `docker-compose` installed for bringing up test fixtures. If it’s not present those checks will be skipped automatically.
  - [Bad practices](#bad-practices)
```
For some BWC testing scenarios, you want to use the local clone of the repository without fetching latest. For these use cases, you can set the system property `tests.bwc.git_fetch_latest` to `false` and the BWC builds will skip fetching the latest from the remote.
## Test groups
## Repeats *all* tests of ClassName N times
    ./gradlew test -Dtests.jvm.argline="-Djava.security.debug=access,failure"
- To generate report in HTML format: `-Dtests.coverage.report.html=true`
Change the default suite timeout to 5 seconds for all tests (note the exclamation mark).
    ./gradlew jacocoTestReport
  - [Base classes for test cases](#base-classes-for-test-cases)
  - [Running REST Tests Against An External Cluster](#running-rest-tests-against-an-external-cluster)
# Test coverage analysis
## Debugging REST Tests
To create a platform-specific build, use the following depending on your operating system:
    ./gradlew run -PcustomDistributionUrl="<OPENSEARCH-REPO-PATH>/distribution/archives/linux-tar/build/distributions/opensearch-min-3.0.0-SNAPSHOT-linux-x64.tar.gz"
## Seed and repetitions
  - [BWC Testing against a specific remote/branch](#bwc-testing-against-a-specific-remotebranch)
Pass arbitrary jvm arguments.
  - [Test case filtering](#test-case-filtering)
     -Dtests.class=org.opensearch.upgrades.RecoveryIT \
However, it should not be used for coverage. For instance if you are testing a piece of functionality that enters different code paths depending on whether the index has 1 shards or 2+ shards, then we shouldn’t just test against an index with a random number of shards: there should be one test for the 1-shard case, and another test for the 2+ shards case.
For specific unit test inside a specific module:
Backwards compatibility tests exist to test upgrading from each supported version to the current version.
Run with a given seed (seed is a hex-encoded long).
  - [Miscellaneous](#miscellaneous)
For example, in your OpenSearch repository assemble a custom distribution.
YAML based REST tests should be preferred since these are shared between clients. The YAML based tests describe the operations to be executed, and the obtained results that need to be tested.
    - [Other useful arguments](#other-useful-arguments)
### Leave environment in an unstable state after test
    ./gradlew test -Dtests.iters=N -Dtests.failfast=true -Dtestcase=...
## Test compatibility
The REST layer is tested through specific tests that are executed against a cluster that is configured and initialized via Gradle. The tests themselves can be written in either Java or with a YAML based DSL.
4. Run the following command from the base of the Security repository:
    ./gradlew test -Dtests.iters=N -Dtests.class=*.ClassName
`-Dtests.security.manager=false` handles access issues when attempting to read the certificates from the file system.
-   In order to use a custom data directory: `--data-dir=/tmp/foo`
# Creating packages
The code coverage report will be generated in `$buildDir/build/reports/jacoco/test/html/`.
    ./gradlew ':modules:mapper-extras:javaRestTest' \
    ./gradlew test -Dtests.jvms=8
- [Creating packages](#creating-packages)
-   `tests.rest.suite`: comma separated paths of the test suites to be run (by default loaded from /rest-api-spec/test). It is possible to run only a subset of the tests providing a sub-folder or even a single yaml file (the default /rest-api-spec/test prefix is optional when files are loaded from classpath) e.g. `-Dtests.rest.suite=index,get,create/10_with_id`
    ./gradlew :server:jacocoTestReport
    - [Skip fetching latest](#skip-fetching-latest)
For specific integration test inside a specific module:
For modules with javaRestTest:
Example: `./gradlew server:test --tests "*.ReplicaShardBatchAllocatorTests.testNoAsyncFetchData"`
    ./gradlew internalClusterTest
The branch needs to be available on the remote that the BWC makes of the repository you run the tests from. Using the remote is a handy trick to make sure that a branch is available and is up to date in the case of multiple runs.
You can launch a local OpenSearch cluster in debug mode following [Launching and debugging from an IDE](#launching-and-debugging-from-an-ide), and run your REST tests against that following [Running REST Tests Against An External Cluster](#running-rest-tests-against-an-external-cluster).
    - [Launching and debugging from an IDE](#launching-and-debugging-from-an-ide)
- To NOT generate report in XML format: `-Dtests.coverage.report.xml=false`
    - [Leave environment in an unstable state after test](#leave-environment-in-an-unstable-state-after-test)
-   **`OpenSearchIntegTestCase`**: An integration test case that creates a cluster that might have multiple nodes.
    ./gradlew :modules:mapper-extras:javaRestTest
  -i
    ./gradlew :server:test
Unfortunately, a large part of our code base is still hard to unit test. Sometimes because some classes have lots of dependencies that make them hard to instantiate. Sometimes because API contracts make tests hard to write. Code refactors that make functionality easier to unit test are encouraged.
Apart from using Gradle, it is also possible to gain insight in code coverage using IntelliJ’s built-in coverage analysis tool that can measure coverage upon executing specific tests. Eclipse may also be able to do the same using the EclEmma plugin.
## Good practices
Use -Dtest.class and -Dtests.method to run a specific bwcTest test. For example to test a rolling upgrade from 7.7.0:
You may want to run BWC tests for a secure OpenSearch cluster. In order to do this, you will need to follow a few additional steps:
# Testing backwards compatibility
    ./gradlew assemble
    ./gradlew bwcTest -PcustomDistributionDownloadType=bundle
    ./gradlew :distribution:archives:windows-zip:assemble
  -Dtests.opensearch.password=admin \
Run all tests that are waiting for a bugfix (disabled by default)
- Gradle
  - [Repeats a given test N times](#repeats-a-given-test-n-times)
1. Clone the OpenSearch Security repository from https://github.com/opensearch-project/security.
    ./gradlew module:test --tests org.opensearch.package.ClassName.testName
Java REST tests can be run with the "javaRestTest" task.
  - [Retries](#retries)
    ./gradlew module:test --tests "*.ClassName"
# Testing with plugins
    ./gradlew v5.3.2#bwcTest
    ./gradlew :rest-api-spec:yamlRestTest
It's difficult to pick the "right" number here. Hypercores don’t count for CPU intensive tests, and you should leave some slack for JVM-internal threads like the garbage collector. And you have to have enough RAM to handle each JVM.
Or in `~/.gradle/gradle.properties`:
Run all tests in a package and its sub-packages
    ./gradlew check
    ./gradlew test -Dtests.iters=N -Dtests.class=*.ClassName -Dtests.method=mytest*
# How to write good tests?
To create a distribution without running the tests, run the following:
  - [Seed and repetitions](#seed-and-repetitions)
yamlRestTest’s and javaRestTest’s are easy to identify, since they are found in a respective source directory. However, there are some more specialized REST tests that use custom task names. These are usually found in "qa" projects commonly use the "integTest" task.
  ./gradlew -p bwc-test clean bwcTestSuite \
Run any test methods that contain *esi* (e.g.: .r*esi*ze.)
Example:
For integration test inside a specific module:
  -PcustomDistributionUrl="/OpenSearch/distribution/archives/linux-tar/build/distributions/opensearch-min-<TARGET_VERSION>-SNAPSHOT-linux-x64.tar.gz" \
    ./gradlew :distribution:archives:darwin-tar:assemble
  - [Test compatibility](#test-compatibility)
  - [Testing packaging on Windows](#testing-packaging-on-windows)
Unit tests are the preferred way to test some functionality: most of the time they are simpler to understand, more likely to reproduce, and unlikely to be affected by changes that are unrelated to the piece of functionality that is being tested.
    - [Abuse randomization in multi-threaded tests](#abuse-randomization-in-multi-threaded-tests)
## Running REST Tests Against An External Cluster
- [Environment misc](#environment-misc)
There are multiple base classes for tests:
- [Running verification tasks](#running-verification-tasks)
- Vagrant
### Expect a specific segment topology
- [Requirements](#requirements)
1. Start the `Debug OpenSearch` in IntelliJ by pressing the debug icon.
There is a known issue with macOS localhost resolve strategy that can cause some integration tests to fail. This is because integration tests have timings for cluster formation, discovery, etc. that can be exceeded if name resolution takes a long time. To fix this, make sure you have your computer name (as returned by `hostname`) inside `/etc/hosts`, e.g.:
For integration test:
    systemProp.tests.jvms=8
### Use `Thread.sleep`
The YAML REST tests support all the options provided by the randomized runner, plus the following:
## Retries
- [Testing backwards compatibility](#testing-backwards-compatibility)
    ./gradlew test -Dtests.iters=N -Dtests.class=*.ClassName -Dtests.seed=DEAD:BEEF
A specific version can be tested as well. For example, to test bwc with version 5.3.2 run:
`-Dtests.opensearch.http.protocol=https` tells the wait for cluster startup task to do the right thing.
      --tests "org.opensearch.test.rest.ClientYamlTestSuiteIT" \
Note that the REST tests, like all the integration tests, can be run against an external cluster by specifying the following properties `tests.cluster`, `tests.rest.cluster`, `tests.clustername`. Use a comma separated list of node properties for the multi-node cluster.
    ./gradlew module:test --tests org.opensearch.package.ClassName
# Testing the REST layer
-   In order to set a different keystore password: `--keystore-password yourpassword`
    - [Refactor code to make it easier to test](#refactor-code-to-make-it-easier-to-test)
Test groups can be enabled or disabled (true/false).
    ./gradlew test -Dtests.filter=@awaitsfix
    ./gradlew check -Dbwc.remote=${remote} -Dbwc.refspec.5.x=index_req_bwc_5.x
## Miscellaneous
  - [Iterating on packaging tests](#iterating-on-packaging-tests)
-   **`OpenSearchSingleNodeTestCase`**: This test case sets up a cluster that has a single node.
    }
### Skip fetching latest
    ./gradlew :qa:die-with-dignity:jacocoTestReport -Dtests.coverage.report.html=true
Every test repetition will have exactly the same master (0xdead) and method-level (0xbeef) seed.
    ./gradlew test -Dtests.heap.size=512m
    ./gradlew test -Dtests.haltonfailure=false
2. Get both the old version of the Security plugin (the version you wish to come from) and the new version of the Security plugin (the version you wish to go to). This can be done either by fetching the maven artifact with a command like `wget https://repo1.maven.org/maven2/org/opensearch/plugin/opensearch-security/<TARGET_VERSION>.0/opensearch-security-<TARGET_VERSION>.0.zip` or by running `./gradlew assemble` from the base of the Security repository.
Run a single test case (variants)
-   `tests.rest.denylist`: comma separated globs that identify tests that are denylisted and need to be skipped e.g. `-Dtests.rest.denylist=index/**/Index document,get/10_basic/**`
-   In order to start a node with a different max heap space add: `-Dtests.heap.size=4G`
Example:
-   In order to enable stack trace of the MockSpanData during testing, add: `-Dtests.telemetry.span.stack_traces=true` (Storing stack traces alongside span data can be useful for comprehensive debugging and performance optimization during testing, as it provides insights into the exact code paths and execution sequences, facilitating efficient issue identification and resolution. Note: Enabling this might lead to OOM issues while running ITs)
-   In order to disable assertions add: `-Dtests.asserts=false`
      }
When running `./gradlew check`, minimal bwc checks are also run against compatible versions that are not yet released.
Please read your IDE documentation for how to attach a debugger to a JVM process.
```
- [Testing the REST layer](#testing-the-rest-layer)
- [Testing packaging](#testing-packaging)
For example, to generate code coverage report in HTML format and not in XML format:
To generate coverage report for the combined tests after `check` task:
-   In order to start and attach opensearch process to an existing debug server: `--debug-jvm`
    ./gradlew :qa:die-with-dignity:javaRestTest
## BWC Testing against a specific remote/branch
    - [Use `Thread.sleep`](#use-threadsleep)
Sometimes a backward compatibility change spans two versions. A common case is a new functionality that needs a BWC bridge in an unreleased versioned of a release branch (for example, 5.x). To test the changes, you can instruct Gradle to build the BWC version from a another remote/branch combination instead of pulling the release branch from GitHub. You do so using the `bwc.remote` and `bwc.refspec.BRANCH` system properties:
Example:
    ./gradlew jacocoTestReport
It is possible to provide a version that allows to adapt the tests' behaviour to older features or bugs that have been changed or fixed in the meantime.
    ./gradlew :server:jacocoTestReport -Dtests.coverage.report.html=true
    # enable gc logging
Finally, if the functionality under test needs to be run in a cluster, there are two test classes to consider:
    ./gradlew :qa:rolling-upgrade:v7.7.0#bwcTest \
    # specify heap dump path
    ./gradlew :server:internalClusterTest --tests "org.opensearch.action.admin.ClientTimeoutIT.testNodesInfoTimeout"
    ./gradlew test -verbose
- [SegmentReplicationResizeRequestIT](https://github.com/opensearch-project/OpenSearch/blob/f715ee1a485e550802accc1c2e3d8101208d4f0b/server/src/internalClusterTest/java/org/opensearch/indices/replication/SegmentReplicationResizeRequestIT.java#L102-L109): This test disables refreshes to prevent interfering with the segment replication behavior under test.
      --tests "org.opensearch.index.mapper.TokenCountFieldMapperIntegrationIT.testSearchByTokenCount {storeCountedFields=true loadCountedFields=false}"
To run a specific set of tests.
### Refactor code to make it easier to test
- [Test coverage analysis](#test-coverage-analysis)
In order to run OpenSearch from source without building a package, you can run it using Gradle:
If in doubt about which command to use, simply run &lt;gradle path&gt;:check
  - [Test groups](#test-groups)
- Docker & Docker Compose
    ::1             localhost OpenSearchMBP.local`
## Bad practices
By design, OpenSearch integration tests will vary how the merge policy works because in almost all scenarios you should not depend on a specific segment topology (in the real world your code will see a huge diversity of indexing workloads with OpenSearch merging things in the background all the time!). If you do in fact need to care about the segment topology (e.g. for testing statistics that might vary slightly depending on number of segments), then you must take care to ensure that segment topology is deterministic by doing things like disabling background refreshes, force merging after indexing data, etc.
  - [Load balancing and caches](#load-balancing-and-caches)
To run OpenSearch in debug mode,
    ./gradlew test -Dtests.jvm.argline="-verbose:gc"
  * `OpenSearchRestTestCase` will connect to an external cluster. This is a good option if the tests cases don't rely on a specific configuration of the test cluster. A test cluster is set up as part of the Gradle task running integration tests, and test cases using this class can connect to it. The configuration of the cluster is provided in the Gradle files.
-   In order to preserve data in between executions: `--preserve-data`
Change the logging level of OpenSearch (not Gradle)
## Repeats *all* tests of ClassName N times
## Repeats a given test N times
OpenSearch uses [jUnit](https://junit.org/junit5/) for testing, it also uses randomness in the tests, that can be set using a seed. The following is a cheatsheet of options for running the tests for OpenSearch.
Then in your plugin repository, substitute in your OpenSearch build
- [How to write good tests?](#how-to-write-good-tests)
3. Move both of the Security artifacts into new directories at the path `/security/bwc-test/src/test/resources/<TARGET_VERSION>.0`. You should end up with two different directories in `/security/bwc-test/src/test/resources/`, one named the old version and one the new version.
You will need the following pieces of software to run these tests:
  -Dtests.opensearch.username=admin \
    ./gradlew :server:jacocoTestReport
    ./gradlew :server:test --tests "org.opensearch.search.approximate.ApproximatePointRangeQueryTests.testNycTaxiDataDistribution"
Every test repetition will have a different method seed (derived from a single random master seed).
    - [Expect a specific segment topology](#expect-a-specific-segment-topology)
Note that individual test repetitions are passed suffixes, such as: `testFoo[0]`, `testFoo[1]`, etc. Thus using `testmethod` or `tests.method` ending in a glob is necessary to ensure iterations are run.
## Running OpenSearch from a checkout
Configure the heap size.
## Base classes for test cases
    ./gradlew :distribution:archives:linux-tar:assemble
Run all tests without stopping on errors (inspect log files).
    - [What kind of tests should I write?](#what-kind-of-tests-should-i-write)
    # enable security debugging
    restResources {
Run more verbose output (JVM parameters, etc.).
Note that this will also run the unit tests and precommit tasks first. If you want to just run the in memory cluster integration tests (because you are debugging them):
- [Testing with plugins](#testing-with-plugins)
  - [Running OpenSearch from a checkout](#running-opensearch-from-a-checkout)
### Other useful arguments
  - [Debugging REST Tests](#debugging-rest-tests)
    ./gradlew module:test --tests "org.opensearch.package.*"
    ./gradlew run
-   In order to start opensearch as a debug server and remotely attach a debugger client (like an IDE debugger): `--debug-server-jvm`
      restApi {
     -Dtests.method=testHistoryUUIDIsGenerated
Use `-PcustomDistributionDownloadType=bundle` to run the bwcTest against the test cluster with latest CI distribution bundle set up for the specified version; this property is default to min and exclusive choices between `bundle` and `min`:
  -Dtests.opensearch.http.protocol=https \
-   In order to set an OpenSearch setting, provide a setting with the following prefix: `-Dtests.opensearch.`
For example:
To run all verification tasks, including static checks, unit tests, and integration tests:
- [PrimaryShardAllocatorIT](https://github.com/opensearch-project/OpenSearch/blob/7ffcd6500e0bd5956cef5c289ee66d9f99d533fc/server/src/internalClusterTest/java/org/opensearch/gateway/ReplicaShardAllocatorIT.java#L208-L235): This test is using two latches: one to wait for a recovery to start and one to block that recovery so that it can deterministically test things that happen during a recovery.
# Requirements
Default value provided below in \[brackets\].
The report will be in XML format only by default, but you can add the following parameter for HTML and CSV format.
This will instruct all JVMs (including any that run cli tools such as creating the keyring or adding users) to suspend and initiate a debug connection on port `5005`. As such, the IDE needs to be instructed to listen for connections on this port. Since we might run multiple JVMs as part of configuring and starting the cluster, it's recommended to configure the IDE to initiate multiple listening attempts. In case of IntelliJ, this option is called "Auto restart" and needs to be checked. In case of Eclipse, "Connection limit" setting needs to be configured with a greater value (ie 10 or more).
    255.255.255.255 broadcasthost
- [AwarenessAttributeDecommissionIT](https://github.com/opensearch-project/OpenSearch/blob/main/server/src/internalClusterTest/java/org/opensearch/cluster/coordination/AwarenessAttributeDecommissionIT.java#L951): Recommissions any decommissioned nodes at the end of the test to ensure the after-test checks succeed.
    ./gradlew test -Dtests.awaitsfix=[false] - known issue (@AwaitsFix)
Alternately, you can configure your OpenSearch JVM to listen as a debug server on port `5005`, and attach a debugger IDE once opensearch JVM is up and running. Use `./gradlew run --debug-server-jvm` for this debugging setup.
Repeats N times but skips any tests after the first failure or M initial failures.
    ./gradlew test
    127.0.0.1       localhost OpenSearchMBP.local
  - [Repeats *all* tests of ClassName N times](#repeats-all-tests-of-classname-n-times-1)
    ./gradlew test -Dtests.compatibility=1.0.0
      -Dtests.cluster=localhost:9200 -Dtests.rest.cluster=localhost:9200 -Dtests.clustername=opensearch
    ./gradlew ':rest-api-spec:yamlRestTest' \
## Test case filtering
The reason why `OpenSearchSingleNodeTestCase` exists is that all our components used to be very hard to set up in isolation, which had led us to having a number of integration tests but close to no unit tests. `OpenSearchSingleNodeTestCase` is a workaround for this issue which provides an easy way to spin up a node and get access to components that are hard to instantiate like `IndicesService`. Whenever practical, you should prefer unit tests.
    ./gradlew :server:internalClusterTest --tests "org.opensearch.common.settings.FallbackSettingsIT.*"
  - [Testing VMs are disposable](#testing-vms-are-disposable)
For unit test:
    ./gradlew internalClusterTest
The goal of tests is to be completely deterministic such that any test failure can be easily and reliably reproduced. However, the reality is that many OpenSearch integration tests have non-deterministic behavior which results in rare test failures that cannot be easily reproduced even using the same random test seed. To mitigate the pain of frequent non-reproducible test failures, limited retries have been introduced using the Gradle [test-retry](https://plugins.gradle.org/plugin/org.gradle.test-retry) plugin. The known flaky tests are explicitly listed in the test-retry configuration of the build.gradle file. This is intended as a temporary mitigation for existing flakiness, and as such new tests should not be added to the retry list. Any new addition to the retry list must provide a thorough rationale as to why adding retries is the right thing to do as opposed to fixing the underlying flakiness. Existing flaky tests are tracked in GitHub with the [Flaky Random Test Failure](https://github.com/opensearch-project/OpenSearch/issues?q=is%3Aopen+is%3Aissue+label%3A%22flaky-test%22) label.
The YAML tests support various operators defined in the [rest-api-spec](/rest-api-spec/src/main/resources/rest-api-spec/test/README.md) and adhere to the [OpenSearch REST API JSON specification](/rest-api-spec/README.md). In order to run the YAML tests, the relevant API specification needs to be on the test classpath. Any gradle project that has support for REST tests will get the primary API on it’s class path. However, to better support Gradle incremental builds, it is recommended to explicitly declare which parts of the API the tests depend upon.
  * `OpenSearchIntegTestCase` will create a local cluster as part of each test case. The configuration of the cluster is controlled by the test class. This is a good option if different tests cases depend on different cluster configurations, as it would be impractical (and limit parallelization) to keep re-configuring (and re-starting) the external cluster for each test case. A good example of when this class might come in handy is for testing security features, where different cluster configurations are needed to fully test each one.
    ./gradlew internalClusterTest -Dtests.coverage.report.html=true -Dtests.coverage.report.xml=false
Multi-threaded tests are often not reproducible due to the fact that there is no guarantee on the order in which operations occur across threads. Adding randomization to the mix usually makes things worse and should be done with care.
# Environment misc
    ./gradlew test -Dtests.output=true
    ./gradlew test -Dtests.timeoutSuite=5000! ...
  - [Repeats *all* tests of ClassName N times](#repeats-all-tests-of-classname-n-times)
# Running verification tasks
`Thread.sleep()` is almost always a bad idea because it is very difficult to know that you've waited long enough. Using primitives like `waitUntil` or `assertBusy`, which use Thread.sleep internally, is okay to wait for a specific condition. However, it is almost always better to instrument your code with concurrency primitives like a `CountDownLatch` that will allow you to deterministically wait for a specific condition, without waiting longer than necessary that will happen with a polling approach used by `assertBusy`.
    ./gradlew :distribution:archives:linux-tar:assemble
In short, most new functionality should come with unit tests, and optionally integration tests using either an external cluster or a local one if there's a need for more specific cluster configurations, as those are more costly and harder to maintain/debug.
  - [BWC Testing with security](#bwc-testing-with-security)
    ./gradlew :server:internalClusterTest
The test can be run for any versions which the current version will be compatible with. Tests are run for released versions download the distributions from the artifact repository, see [DistributionDownloadPlugin](./buildSrc/src/main/java/org/opensearch/gradle/DistributionDownloadPlugin.java) for the repository location. Tests are run for versions that are not yet released automatically check out the branch and build from source to get the distributions, see [BwcVersions](./buildSrc/src/main/java/org/opensearch/gradle/BwcVersions.java) and [distribution/bwc/build.gradle](./distribution/bwc/build.gradle) for more information.
### Launching and debugging from an IDE
### What kind of tests should I write?
