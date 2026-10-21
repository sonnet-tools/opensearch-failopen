Clone the opensearch-protobufs repository and follow the [Protobuf Local Convert Guide](https://github.com/opensearch-project/opensearch-protobufs/blob/main/DEVELOPER_GUIDE.md#protobuf-local-convert-guide) to generate protobufs from the OpenSearch API specification.
┌─────────────────────────────────────────────────────────────┐
- Running unit tests
cd opensearch-protobufs
│    - PR to documentation-website (can merge independently)  │
#### Other gRPC Settings
4. **documentation-website**: Update public documentation for your gRPC APIs
     - Usage examples
    - [Merge Order Summary](#merge-order-summary)
**Summary:**
      - [Unit Tests](#unit-tests)
           // ... other repositories ...
```
**Skip this step if you're only building interceptors without protobuf changes.**
4. OpenSearch PR → MERGE SECOND
| Setting Name                                    | Description                                                                                                    | Example Value         | Default Value        |
   - Update the gRPC API documentation with your new features
#### Example configurations:
```bash
Now you can implement your gRPC functionality in the OpenSearch codebase. Choose the appropriate section based on what you're building.
| **grpc.publish_host**                           | List of hostnames or IPs published to peers for client connections.                                            | `["thisnode.example.com"]` | Value of `grpc.host` |
```
setting 'grpc.publish_port',                            '9400'
- [transport-grpc](#transport-grpc)
| **grpc.publish_port**                           | The external port number that this node uses to publish itself to peers for gRPC transport.                    | `9400`                | `-1` (disabled)      |
| **grpc.netty.keepalive_timeout**                | Time to wait for keepalive ping acknowledgment before closing the connection. Supports time units.             | `1s`                  | Not set              |
│    - PR to opensearch-protobufs (merged first)             │
   allprojects {
      - [Notes:](#notes)
setting 'grpc.netty.executor_count',                    '32'
#### Notes:
```
2. **Configure to use local protobuf JAR (if you made protobuf changes):**
#### Step 4: Implement Your Core Contribution
#### Integration Tests
└─────────────────────────────────────────────────────────────┘
      - [Step 2: Generate and Package Local Protobuf JAR](#step-2-generate-and-package-local-protobuf-jar)
     - Updated documentation
| **grpc.host**                                   | List of addresses the gRPC server will bind to.                                                                | `["0.0.0.0"]`         | `[]`                 |
**Skip this step if you're only building interceptors without protobuf changes.**
Contributing to core gRPC may involve working with up to four repositories:
setting 'grpc.netty.max_msg_size',                      '10mb'
      - [Step 4: Implement Your Core Contribution](#step-4-implement-your-core-contribution)
### Step-by-Step Guide
setting 'grpc.host',                                    '["0.0.0.0"]'
└─────────────────────────────────────────────────────────────┘
                              ↓
The JAR will be installed to `~/.m2/repository/org/opensearch/protobufs/opensearch-protobufs/`
     ```
│    - Add new service endpoints                              │
   - Include:
setting 'grpc.bind_host',                               '["0.0.0.0", "::", "10.0.0.1"]'
│    - Test your implementation                               │
   - Update the protobuf version in `gradle/libs.versions.toml`:
**Requires protobuf changes (Steps 1-2).**
   ↓
**Implementation details:** See [SPI documentation](spi/README.md#querybuilderprotoconverter) for complete examples.
| **grpc.netty.max_concurrent_connection_calls**  | Maximum number of simultaneous in-flight requests allowed per client connection.                               | `200`                 | `100`                |
           mavenLocal()  // Add this to use your local Maven repository
./gradlew run -Dtests.opensearch.aux.transport.types="[transport-grpc]"
└─────────────────────────────────────────────────────────────┘
---
# transport-grpc
1. Build the Java protobuf code with Bazel
3. **Submit PR to OpenSearch:**
1. **opensearch-api-specification**: Fix API spec errors (if any are found)
│ 3. Submit PRs (coordinated merge)                           │
      - [Running OpenSearch with gRPC Enabled](#running-opensearch-with-grpc-enabled)
```bash
      - [Step 5: Test Your Implementation](#step-5-test-your-implementation)
An auxiliary transport which runs in parallel to the REST API.
**Implementation details:** See [SPI documentation](spi/README.md#grpcservicefactory) for complete examples.
Query converters transform protobuf query messages into OpenSearch QueryBuilder objects.
     - Implementation code (converters/services/interceptors)
```
Interceptors process all incoming gRPC requests for cross-cutting concerns like authentication, logging, and metrics.
                              ↓
### Workflow
│    - Import local protobuf JAR (if protos changed)         │
   - **This PR must be merged FIRST**
   ↓
```
setting 'grpc.publish_host',                            '["thisnode.example.com"]'
   ↓
```bash
#### Step 3: Set Up OpenSearch Repository with Local Protobuf JAR
curl -X GET "localhost:9200/_nodes/stats/thread_pool?filter_path=nodes.*.thread_pool.grpc"
      - [Integration Tests](#integration-tests)
   - **This PR can be merged AFTER the protobufs PR is merged and the version is updated**
   - Include:
```
- For size-based settings (e.g., `max_msg_size`), you can use units such as `b` (bytes), `kb`, `mb`, `gb`, etc.
  - [Table of Contents](#table-of-contents)
The dedicated thread pool used for gRPC request processing is registered as a standard OpenSearch thread pool named `grpc`, controlled by the `grpc.netty.executor_count` setting.
3. **OpenSearch**: Implement Java code that uses the protobufs (query converters, services, interceptors)
| **grpc.bind_host**                              | List of addresses to bind the gRPC server to. Can be distinct from publish hosts.                              | `["0.0.0.0", "::"]`   | Value of `grpc.host` |
```
### Overview
```
- **Documentation fixes:** If you find errors in public documentation, submit a PR to [documentation-website](https://github.com/opensearch-project/documentation-website)
2. Protobufs published to Maven Central
- **API Specification fixes:** If you find errors in the OpenSearch API spec, submit a PR to [opensearch-api-specification](https://github.com/opensearch-project/opensearch-api-specification). After the spec fix is merged, regenerate protobufs to incorporate the corrections.
setting 'grpc.netty.max_connection_idle',               '2m'
| **grpc.netty.max_connection_age**               | Maximum age a connection is allowed before being gracefully closed. Supports time units like `ms`, `s`, `m`.   | `500ms`               | Not set (no limit)   |
|-------------------------------------------------|----------------------------------------------------------------------------------------------------------------|-----------------------|----------------------|
setting 'aux.transport.types',                              '[transport-grpc]'
   ```
      - [Other gRPC Settings](#other-grpc-settings)
3. **Verify the setup:**
     - New/modified `.proto` files
   ↓
   ```
│ 2. OpenSearch: Implement Java code                         │
        - [B. Extending a gRPC Service](#b-extending-a-grpc-service)
    - [Overview](#overview)
   ./gradlew :modules:transport-grpc:build
   - Remove `mavenLocal()` from `build.gradle` if you added it
    - [Thread Pool Monitoring](#thread-pool-monitoring)
**Note:** As a module, transport-grpc is included by default with all OpenSearch installations. However, it remains opt-in and must be explicitly enabled via configuration settings.
   cd OpenSearch
### Thread Pool Monitoring
      - [Step 0: Submit Fixes to Related Repositories (If Needed)](#step-0-submit-fixes-to-related-repositories-if-needed)
```
   ```toml
### GRPC Settings
┌─────────────────────────────────────────────────────────────┐
      - [Example configurations:](#example-configurations)
| **grpc.netty.executor_count**                   | Number of threads in the ForkJoinPool for processing gRPC service calls. Controls request processing parallelism. | `32`                  | 2 × Number of processors |
     - Reasoning for the changes
- For duration-based settings (e.g., `max_connection_age`), you can use units such as `ms` (milliseconds), `s` (seconds), `m` (minutes), etc.
   ↓
┌─────────────────────────────────────────────────────────────┐
     opensearchprotobufs = "1.1.0"  # Use the newly published version
│    - Generate local protobuf JAR                            │
### Merge Order Summary
   Edit `build.gradle` in the OpenSearch root:
**Note:** If you're only building interceptors (without protobuf changes), you can skip Steps 1-2 and start directly at Step 3.
##### A. Adding a Core Query Converter
   ```
│    - PR to OpenSearch (update version, then merge)         │
| **grpc.netty.max_msg_size**                     | Maximum inbound message size for gRPC requests. Supports units like `b`, `kb`, `mb`, `gb`.                    | `10mb` or `10485760`  | `10mb`               |
```
   - **This PR can be merged independently** but should ideally be coordinated with the OpenSearch release
**Before generating protobufs**, if you discover errors while working with the API:
   - Example: [PR #11614 - gRPC Documentation for 3.4](https://github.com/opensearch-project/documentation-website/pull/11614)
1. **Clone OpenSearch repository (if not already cloned):**
      - [Step 1: Generate Protobuf Definitions from OpenAPI Spec](#step-1-generate-protobuf-definitions-from-openapi-spec)
    - [Testing](#testing)
   - Link to the corresponding OpenSearch PR
```bash
      - [Step 3: Set Up OpenSearch Repository with Local Protobuf JAR](#step-3-set-up-opensearch-repository-with-local-protobuf-jar)
```
**Implementation details:** See [SPI documentation](spi/README.md#grpc-interceptors) for complete examples.
│ 1. opensearch-protobufs: Define/modify .proto files        │
   ↓ Regenerate protobufs after spec fix is merged
2. Run `./tools/java/package_proto_jar.sh` to create and install the JAR to your local Maven repository
#### Running OpenSearch with gRPC Enabled
     ```toml
1. **Submit PR to opensearch-protobufs (if you made protobuf changes):**
   Then update the version in `gradle/libs.versions.toml`:
setting 'grpc.netty.max_connection_age',                '500ms'
1. opensearch-protobufs PR → MERGE FIRST
To run OpenSearch with the gRPC transport enabled:
./gradlew :modules:transport-grpc:internalClusterTest
#### Step 2: Generate and Package Local Protobuf JAR
setting 'aux.transport.secure-transport-grpc.port',    '9400-9500' //optional
```
4. **Submit PR to documentation-website:**
#### Step 5: Test Your Implementation
      - [Step 6: Submit Pull Requests](#step-6-submit-pull-requests)
## Contributing to gRPC APIs
  - [Development Guide](#development-guide)
   }
##### C. Building a Custom Core Interceptor
│    - Add new message types                                  │
   - Title: "Add gRPC support for [feature name]"
setting 'aux.transport.types',                                      '[secure-transport-grpc]'
   opensearchprotobufs = "1.1.0-SNAPSHOT"
     - Unit/integration tests
3. Update OpenSearch gradle/libs.versions.toml with new version
       repositories {
5. documentation-website PR → MERGE (can be independent)
   ```bash
        - [C. Building a Custom Core Interceptor](#c-building-a-custom-core-interceptor)
The gRPC thread pool stats can be monitored using:
   ```groovy
See the [Testing](#testing) section in the Development Guide below for complete instructions on:
- Manual testing with OpenSearch
| **grpc.netty.max_connection_idle**              | Maximum duration a connection can be idle before being closed. Supports time units like `ms`, `s`, `m`.        | `2m`                  | Not set (no limit)   |
    - [GRPC Settings](#grpc-settings)
The `transport-grpc` module initializes a new client/server transport implementing a gRPC protocol on Netty4.
setting 'aux.transport.transport-grpc.port',   '9400-9500' //optional
2. **After protobufs PR is merged, update OpenSearch:**
### Testing
2. **opensearch-protobufs**: Generate protobuf schemas from the API spec
For the secure transport:
#### Step 1: Generate Protobuf Definitions from OpenAPI Spec
    - [Step-by-Step Guide](#step-by-step-guide)
This section is for contributors who want to add new gRPC functionality directly to OpenSearch core (not as an external plugin). This includes adding new query converters, extending gRPC services, or building custom interceptors that will be part of the core distribution.
   ```
#### Unit Tests
- Running integration tests
setting 'grpc.netty.worker_count',                      '2'
```
    - [Workflow](#workflow)
**Follow the complete guide:** [Generate Java Code and Packaging as a Maven/Gradle Dependency](https://github.com/opensearch-project/opensearch-protobufs/blob/main/DEVELOPER_GUIDE.md#generate-java-code-and-packaging-as-a-mavengradle-dependency)
   git clone https://github.com/opensearch-project/OpenSearch.git
   - Title: "Add protobuf definitions for [feature name]"
## Table of Contents
     - Any new configuration options
setting 'grpc.netty.keepalive_timeout',                 '1s'
```
Enable this transport with:
   - Include:
     - Updated `gradle/libs.versions.toml` (if protobuf version changed)
**Does NOT require protobuf changes - you can skip Steps 1-2 and start here!**
     - API reference updates
---
        - [A. Adding a Core Query Converter](#a-adding-a-core-query-converter)
```bash
- All settings are node-scoped unless otherwise specified.
**Important: PRs must be coordinated and merged in a specific order.**
**Requires protobuf changes (Steps 1-2).**
       }
│    - Implement query converters / services / interceptors   │
gRPC services expose new API endpoints for client applications.
- **Remember:** The server code (`toXContent`/`fromXContent` methods for REST APIs) is the source of truth. If there's a discrepancy between the API spec and server code, the server is correct.
   ```bash
  - [Contributing to gRPC APIs](#contributing-to-grpc-apis)
## Development Guide
3. Note the version from `version.properties` (e.g., `1.1.0-SNAPSHOT`)
./gradlew :modules:transport-grpc:test
#### Step 0: Submit Fixes to Related Repositories (If Needed)
setting 'grpc.netty.max_concurrent_connection_calls',   '200'
git clone https://github.com/opensearch-project/opensearch-protobufs.git
| **grpc.netty.worker_count**                     | Number of Netty worker threads for the gRPC server. Controls network I/O concurrency.                          | `2`                   | Number of processors |
   - Reference the opensearch-protobufs PR in the description
#### Step 6: Submit Pull Requests
##### B. Extending a gRPC Service
```
0. (If needed) opensearch-api-specification PR → MERGE FIRST (if API spec fixes are required)
