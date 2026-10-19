To run OpenSearch with the gRPC transport enabled:
│ 1. opensearch-protobufs: Define/modify .proto files        │
Now you can implement your gRPC functionality in the OpenSearch codebase. Choose the appropriate section based on what you're building.
#### Other gRPC Settings
   cd OpenSearch
│    - Add new service endpoints                              │
```bash
    - [Testing](#testing)
│    - Implement query converters / services / interceptors   │
   - Remove `mavenLocal()` from `build.gradle` if you added it
3. Update OpenSearch gradle/libs.versions.toml with new version
./gradlew :modules:transport-grpc:test
Interceptors process all incoming gRPC requests for cross-cutting concerns like authentication, logging, and metrics.
      - [Other gRPC Settings](#other-grpc-settings)
**Summary:**
      - [Step 4: Implement Your Core Contribution](#step-4-implement-your-core-contribution)
2. **opensearch-protobufs**: Generate protobuf schemas from the API spec
   - Update the protobuf version in `gradle/libs.versions.toml`:
     ```toml
3. Note the version from `version.properties` (e.g., `1.1.0-SNAPSHOT`)
│ 3. Submit PRs (coordinated merge)                           │
---
**Does NOT require protobuf changes - you can skip Steps 1-2 and start here!**
| **grpc.netty.worker_count**                     | Number of Netty worker threads for the gRPC server. Controls network I/O concurrency.                          | `2`                   | Number of processors |
### Merge Order Summary
2. **After protobufs PR is merged, update OpenSearch:**
     - Updated `gradle/libs.versions.toml` (if protobuf version changed)
### Workflow
     - Implementation code (converters/services/interceptors)
```
---
**Requires protobuf changes (Steps 1-2).**
   - Update the gRPC API documentation with your new features
3. **Submit PR to OpenSearch:**
│    - Add new message types                                  │
- Running unit tests
./gradlew run -Dtests.opensearch.aux.transport.types="[transport-grpc]"
      - [Step 5: Test Your Implementation](#step-5-test-your-implementation)
└─────────────────────────────────────────────────────────────┘
4. **Submit PR to documentation-website:**
   ```groovy
**Important: PRs must be coordinated and merged in a specific order.**
##### A. Adding a Core Query Converter
2. Run `./tools/java/package_proto_jar.sh` to create and install the JAR to your local Maven repository
##### B. Extending a gRPC Service
setting 'grpc.publish_host',                            '["thisnode.example.com"]'
The JAR will be installed to `~/.m2/repository/org/opensearch/protobufs/opensearch-protobufs/`
   - Reference the opensearch-protobufs PR in the description
   - **This PR can be merged independently** but should ideally be coordinated with the OpenSearch release
   ↓ Regenerate protobufs after spec fix is merged
   Then update the version in `gradle/libs.versions.toml`:
```
##### C. Building a Custom Core Interceptor
**Before generating protobufs**, if you discover errors while working with the API:
| **grpc.publish_host**                           | List of hostnames or IPs published to peers for client connections.                                            | `["thisnode.example.com"]` | Value of `grpc.host` |
      - [Step 0: Submit Fixes to Related Repositories (If Needed)](#step-0-submit-fixes-to-related-repositories-if-needed)
**Implementation details:** See [SPI documentation](spi/README.md#querybuilderprotoconverter) for complete examples.
   ```toml
      - [Example configurations:](#example-configurations)
1. **opensearch-api-specification**: Fix API spec errors (if any are found)
└─────────────────────────────────────────────────────────────┘
#### Running OpenSearch with gRPC Enabled
See the [Testing](#testing) section in the Development Guide below for complete instructions on:
setting 'aux.transport.secure-transport-grpc.port',    '9400-9500' //optional
   ./gradlew :modules:transport-grpc:build
| **grpc.bind_host**                              | List of addresses to bind the gRPC server to. Can be distinct from publish hosts.                              | `["0.0.0.0", "::"]`   | Value of `grpc.host` |
     ```
| **grpc.publish_port**                           | The external port number that this node uses to publish itself to peers for gRPC transport.                    | `9400`                | `-1` (disabled)      |
- For size-based settings (e.g., `max_msg_size`), you can use units such as `b` (bytes), `kb`, `mb`, `gb`, etc.
     - API reference updates
        - [B. Extending a gRPC Service](#b-extending-a-grpc-service)
     - Updated documentation
```
      - [Unit Tests](#unit-tests)
   - Include:
4. OpenSearch PR → MERGE SECOND
```
#### Step 6: Submit Pull Requests
       repositories {
| **grpc.host**                                   | List of addresses the gRPC server will bind to.                                                                | `["0.0.0.0"]`         | `[]`                 |
     - New/modified `.proto` files
**Implementation details:** See [SPI documentation](spi/README.md#grpcservicefactory) for complete examples.
setting 'grpc.netty.max_connection_age',                '500ms'
git clone https://github.com/opensearch-project/opensearch-protobufs.git
#### Example configurations:
   ```
    - [Step-by-Step Guide](#step-by-step-guide)
cd opensearch-protobufs
   ```
#### Integration Tests
        - [C. Building a Custom Core Interceptor](#c-building-a-custom-core-interceptor)
```
   - Example: [PR #11614 - gRPC Documentation for 3.4](https://github.com/opensearch-project/documentation-website/pull/11614)
**Note:** As a module, transport-grpc is included by default with all OpenSearch installations. However, it remains opt-in and must be explicitly enabled via configuration settings.
  - [Development Guide](#development-guide)
   - **This PR must be merged FIRST**
An auxiliary transport which runs in parallel to the REST API.
    - [Thread Pool Monitoring](#thread-pool-monitoring)
setting 'grpc.publish_port',                            '9400'
gRPC services expose new API endpoints for client applications.
| **grpc.netty.executor_count**                   | Number of threads in the ForkJoinPool for processing gRPC service calls. Controls request processing parallelism. | `32`                  | 2 × Number of processors |
```bash
#### Step 1: Generate Protobuf Definitions from OpenAPI Spec
setting 'grpc.netty.worker_count',                      '2'
# transport-grpc
```
    - [Overview](#overview)
Query converters transform protobuf query messages into OpenSearch QueryBuilder objects.
#### Notes:
   - **This PR can be merged AFTER the protobufs PR is merged and the version is updated**
      - [Notes:](#notes)
```
```
Clone the opensearch-protobufs repository and follow the [Protobuf Local Convert Guide](https://github.com/opensearch-project/opensearch-protobufs/blob/main/DEVELOPER_GUIDE.md#protobuf-local-convert-guide) to generate protobufs from the OpenSearch API specification.
│    - Generate local protobuf JAR                            │
│    - PR to opensearch-protobufs (merged first)             │
1. **Clone OpenSearch repository (if not already cloned):**
   ```bash
| **grpc.netty.max_connection_age**               | Maximum age a connection is allowed before being gracefully closed. Supports time units like `ms`, `s`, `m`.   | `500ms`               | Not set (no limit)   |
#### Unit Tests
- Manual testing with OpenSearch
   ↓
     - Any new configuration options
      - [Step 6: Submit Pull Requests](#step-6-submit-pull-requests)
           mavenLocal()  // Add this to use your local Maven repository
   }
setting 'aux.transport.types',                                      '[secure-transport-grpc]'
        - [A. Adding a Core Query Converter](#a-adding-a-core-query-converter)
### Overview
| **grpc.netty.max_connection_idle**              | Maximum duration a connection can be idle before being closed. Supports time units like `ms`, `s`, `m`.        | `2m`                  | Not set (no limit)   |
#### Step 5: Test Your Implementation
└─────────────────────────────────────────────────────────────┘
#### Step 4: Implement Your Core Contribution
## Contributing to gRPC APIs
┌─────────────────────────────────────────────────────────────┐
3. **OpenSearch**: Implement Java code that uses the protobufs (query converters, services, interceptors)
### Testing
- **API Specification fixes:** If you find errors in the OpenSearch API spec, submit a PR to [opensearch-api-specification](https://github.com/opensearch-project/opensearch-api-specification). After the spec fix is merged, regenerate protobufs to incorporate the corrections.
      - [Step 2: Generate and Package Local Protobuf JAR](#step-2-generate-and-package-local-protobuf-jar)
      - [Running OpenSearch with gRPC Enabled](#running-opensearch-with-grpc-enabled)
- [transport-grpc](#transport-grpc)
- **Remember:** The server code (`toXContent`/`fromXContent` methods for REST APIs) is the source of truth. If there's a discrepancy between the API spec and server code, the server is correct.
     - Unit/integration tests
#### Step 2: Generate and Package Local Protobuf JAR
   - Link to the corresponding OpenSearch PR
2. Protobufs published to Maven Central
1. **Submit PR to opensearch-protobufs (if you made protobuf changes):**
```bash
| **grpc.netty.max_concurrent_connection_calls**  | Maximum number of simultaneous in-flight requests allowed per client connection.                               | `200`                 | `100`                |
Enable this transport with:
#### Step 3: Set Up OpenSearch Repository with Local Protobuf JAR
   ↓
    - [Merge Order Summary](#merge-order-summary)
                              ↓
This section is for contributors who want to add new gRPC functionality directly to OpenSearch core (not as an external plugin). This includes adding new query converters, extending gRPC services, or building custom interceptors that will be part of the core distribution.
┌─────────────────────────────────────────────────────────────┐
     opensearchprotobufs = "1.1.0"  # Use the newly published version
```
    - [Workflow](#workflow)
setting 'grpc.bind_host',                               '["0.0.0.0", "::", "10.0.0.1"]'
   - Include:
**Implementation details:** See [SPI documentation](spi/README.md#grpc-interceptors) for complete examples.
**Skip this step if you're only building interceptors without protobuf changes.**
curl -X GET "localhost:9200/_nodes/stats/thread_pool?filter_path=nodes.*.thread_pool.grpc"
4. **documentation-website**: Update public documentation for your gRPC APIs
setting 'grpc.netty.max_msg_size',                      '10mb'
           // ... other repositories ...
   ↓
- **Documentation fixes:** If you find errors in public documentation, submit a PR to [documentation-website](https://github.com/opensearch-project/documentation-website)
   opensearchprotobufs = "1.1.0-SNAPSHOT"
      - [Step 1: Generate Protobuf Definitions from OpenAPI Spec](#step-1-generate-protobuf-definitions-from-openapi-spec)
```bash
   - Include:
setting 'aux.transport.transport-grpc.port',   '9400-9500' //optional
```bash
| **grpc.netty.max_msg_size**                     | Maximum inbound message size for gRPC requests. Supports units like `b`, `kb`, `mb`, `gb`.                    | `10mb` or `10485760`  | `10mb`               |
For the secure transport:
   ↓
**Follow the complete guide:** [Generate Java Code and Packaging as a Maven/Gradle Dependency](https://github.com/opensearch-project/opensearch-protobufs/blob/main/DEVELOPER_GUIDE.md#generate-java-code-and-packaging-as-a-mavengradle-dependency)
   ```
0. (If needed) opensearch-api-specification PR → MERGE FIRST (if API spec fixes are required)
2. **Configure to use local protobuf JAR (if you made protobuf changes):**
     - Usage examples
**Note:** If you're only building interceptors (without protobuf changes), you can skip Steps 1-2 and start directly at Step 3.
│    - PR to documentation-website (can merge independently)  │
| Setting Name                                    | Description                                                                                                    | Example Value         | Default Value        |
setting 'grpc.netty.max_concurrent_connection_calls',   '200'
### Thread Pool Monitoring
│    - Test your implementation                               │
| **grpc.netty.keepalive_timeout**                | Time to wait for keepalive ping acknowledgment before closing the connection. Supports time units.             | `1s`                  | Not set              |
- For duration-based settings (e.g., `max_connection_age`), you can use units such as `ms` (milliseconds), `s` (seconds), `m` (minutes), etc.
   ```
  - [Table of Contents](#table-of-contents)
The gRPC thread pool stats can be monitored using:
1. opensearch-protobufs PR → MERGE FIRST
setting 'grpc.netty.executor_count',                    '32'
3. **Verify the setup:**
   Edit `build.gradle` in the OpenSearch root:
### Step-by-Step Guide
      - [Integration Tests](#integration-tests)
   - Title: "Add gRPC support for [feature name]"
setting 'grpc.host',                                    '["0.0.0.0"]'
The dedicated thread pool used for gRPC request processing is registered as a standard OpenSearch thread pool named `grpc`, controlled by the `grpc.netty.executor_count` setting.
**Requires protobuf changes (Steps 1-2).**
**Skip this step if you're only building interceptors without protobuf changes.**
setting 'aux.transport.types',                              '[transport-grpc]'
     - Reasoning for the changes
setting 'grpc.netty.keepalive_timeout',                 '1s'
## Development Guide
- All settings are node-scoped unless otherwise specified.
```
│ 2. OpenSearch: Implement Java code                         │
```
   git clone https://github.com/opensearch-project/OpenSearch.git
1. Build the Java protobuf code with Bazel
│    - Import local protobuf JAR (if protos changed)         │
setting 'grpc.netty.max_connection_idle',               '2m'
#### Step 0: Submit Fixes to Related Repositories (If Needed)
┌─────────────────────────────────────────────────────────────┐
│    - PR to OpenSearch (update version, then merge)         │
- Running integration tests
|-------------------------------------------------|----------------------------------------------------------------------------------------------------------------|-----------------------|----------------------|
  - [Contributing to gRPC APIs](#contributing-to-grpc-apis)
The `transport-grpc` module initializes a new client/server transport implementing a gRPC protocol on Netty4.
   ```bash
5. documentation-website PR → MERGE (can be independent)
```
```
## Table of Contents
    - [GRPC Settings](#grpc-settings)
   ↓
./gradlew :modules:transport-grpc:internalClusterTest
```
                              ↓
   - Title: "Add protobuf definitions for [feature name]"
Contributing to core gRPC may involve working with up to four repositories:
       }
   allprojects {
```
      - [Step 3: Set Up OpenSearch Repository with Local Protobuf JAR](#step-3-set-up-opensearch-repository-with-local-protobuf-jar)
### GRPC Settings
