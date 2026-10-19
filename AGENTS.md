```
- Base classes: `OpenSearchSingleNodeTestCase` (single node), `OpenSearchIntegTestCase` (multi-node)
```
## Java Formatting
- Java REST tests: `./gradlew :<module>:javaRestTest` (base class: `OpenSearchRestTestCase`)
- Run `./gradlew japicmp` to check API compatibility against the latest release.
## Testing
./gradlew server:test --tests "*.ReplicaShardBatchAllocatorTests.testNoAsyncFetchData"
## Adding Dependencies
- `libs/*` - Libraries that can be used by `server` or any plugin or module.
./gradlew assemble          # build all distributions
- Defined in `<component>/src/internalClusterTest` directory
./gradlew run               # run OpenSearch from source
## Build
- Prefer unit tests over multi-threaded integration tests when unit tests can provide the same test coverage.
- Use randomization for parameters not expected to affect behavior (e.g., shard count for aggregation tests), not for coverage. If different code paths exist (e.g., 1 shard vs 2+ shards), write separate tests for each.
## Pull Requests
./gradlew check                    # all verification tasks (unit, integration, static checks)
./gradlew test -Dtests.seed=DEADBEEF
## Backwards Compatibility
# repeat a test N times
Key components:
- YAML-based REST tests: `./gradlew :rest-api-spec:yamlRestTest`
### Unit Testing
- Test class names must end with "Tests"
./gradlew localDistro       # build for local platform only
- Test class names must end with "IT"
./gradlew run -PinstalledPlugins='["repository-azure"]'  # run with plugins installed
Ensure `./gradlew precommit` passes before creating a commit. Write commit message titles focused on user impact and not implementation details.
./gradlew :server:internalClusterTest --tests "org.opensearch.action.admin.ClientTimeoutIT.testNodesInfoTimeout"
./gradlew internalClusterTest      # in-memory cluster integration tests only
- `distribution` - Builds tar, zip, rpm, and deb packages.
- These tests are extremely prone to race conditions. Ensure that you are using appropriate concurrency primitives or polling when asserting on a condition that completes asynchronously.
- Do not abuse randomization in multi-threaded tests because it can make failures non-reproducible.
- Prefer `foo == false` over `!foo` for readability.
## Commits
```
- Wildcard imports are forbidden.
```
- Clean up all resources at the end of each test. The base test class checks for open file handles and running threads after tear down.
- Bad: `Add Strings#validFileNameExcludingSlash method`
- `test` - Test framework and test fixtures used across the project. Published for external plugin testing.
# run with a specific seed for reproducibility
## Repository Structure
- Use `Version.onOrAfter` / `Version.before` checks when changing on-disk formats or encodings.
./gradlew generateProto     # regenerate protobuf code (if compilation errors)
- Good: `Allow slash in snapshot file name validation`
- When testing functionality behind a feature flag, use `FeatureFlags.TestUtils` and the `@LockFeatureFlag` annotation.
- Defined in `<component>/src/test` directory
- Run `./gradlew spotlessJavaCheck` to check, `./gradlew spotlessApply` to fix.
- `plugins/*` - Optional plugins that extend interfaces defined in `server`. Plugins run in their own classloader that is a child of the `server` classloader.
- `sandbox` - Contains `libs`, `modules`, and `plugins` that are under development. These are not included in non-snapshot builds.
When adding or removing a dependency in any `build.gradle` (non-test scope):
- Mark public API classes with `@PublicApi` (backwards compatibility guaranteed), `@InternalApi` (no guarantees), `@ExperimentalApi` (may change any time), or `@DeprecatedApi`.
./gradlew server:test --tests "*.ReplicaShardBatchAllocatorTests.testNoAsyncFetchData" -Dtests.iters=N
- `modules/*` - Architecturally the same as plugins, but are included by default and are not uninstallable.
./gradlew test                     # unit tests only
JDK 21 is the minimum supported. `JAVA_HOME` must be set.
2. Run `./gradlew :<component>:updateSHAs` to generate the SHA file.
1. Copy the library's `LICENSE.txt` and `NOTICE.txt` to `<component>/licenses/<artifact>-LICENSE.txt` and `<artifact>-NOTICE.txt`.
### Running Tests
- Formatted with Eclipse JDT formatter via Spotless Gradle plugin.
3. Verify with `./gradlew :<component>:check`.
- Base class: `OpenSearchTestCase`
Commit message titles should be limited to 50 characters, followed by a blank line, and the body should be wrapped at 72 characters. Include all relevant context in commit messages but avoid excess verbosity. Users must understand and accept the Developer Certificate of Origin (DCO) and all commits must be signed off accordingly.
# run a specific test
./gradlew run -PnumNodes=3  # run a multi-node cluster
# AGENTS.md
### Internal Cluster Tests
### REST Tests
- `qa` - Integration tests requiring multiple modules/plugins, multi-version cluster tests, and tests in unusual configurations.
- `buildSrc` - The build framework, used by this repository and all external plugin repositories. This is published as the `build-tools` artifact.
- User-facing API changes require the `>breaking` PR label and deprecation log messages via `DeprecationLogger`.
Always push to the user's fork. Never push to the upstream `opensearch-project/OpenSearch` repo. Never push directly to `main`. If a user fork does not exist, ask the contributor to create one.
- Never use `Thread.sleep` directly. Use `assertBusy` or `waitUntil` for polling, or instrument code with concurrency primitives like `CountDownLatch` for deterministic waiting.
### Writing Good Tests
- Use the `-Dtests.iters=N` parameter to repeat new and modified tests with many different random seeds to ensure stability.
- `server` - Core of the OpenSearch server. Includes the distributed system framework as well as most of the search and indexing functionality.
./gradlew precommit                # precommit checks only
- Do not depend on specific segment topology. If needed, disable background refreshes and force merge after indexing.
- 4-space indent, 140-character line width.
