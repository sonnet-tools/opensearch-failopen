```
```yaml
# Arrow Flight RPC Plugin
For detailed usage and architecture information, see the [docs](docs/) folder:
See the [stream-transport-example](../examples/stream-transport-example/) plugin for a complete example of how to implement streaming transport actions.
2. Add system properties and JVM options:
- [Architecture Guide](docs/architecture.md) - Stream transport architecture and design
- [Netty4 vs Flight Comparison](docs/netty4-vs-flight-comparison.md) - Transport classes comparison cheat sheet
--add-opens=java.base/java.nio=ALL-UNNAMED
## Installation and Setup
```
- [Producer Back-Pressure](docs/backpressure.md) - Producer-side back-pressure: settings, behaviour, sizing
### Development Mode (./gradlew run)
For manual configuration and deployment:
For development using gradle:
./gradlew run -PinstalledPlugins="['arrow-flight-rpc']"
The Arrow Flight RPC plugin provides streaming transport for node to node communication in OpenSearch using Apache Arrow Flight protocol. It integrates with the OpenSearch Security plugin to provide secure, authenticated streaming with TLS encryption.
## Limitations
opensearch.experimental.feature.transport.stream.enabled: true
- [Metrics](docs/metrics.md) - Monitoring and performance metrics
-Dio.netty.tryReflectionSetAccessible=true
```yaml
- [Security Integration](docs/security-integration.md) - Security plugin integration and TLS setup
-Dio.netty.tryUnsafe=true
```bash
- [Flight Client Channel Flow](docs/flight-client-channel-flow.md) - Client channel flow details
## Examples
- **REST Client Support**: Arrow Flight streaming is not available for REST API clients. It only works for node-to-node transport within the OpenSearch cluster.
### Manual Setup
- [Transport Client Streaming Flow](docs/transport-client-streaming-flow.md) - Client-side streaming implementation
-Dio.netty.noUnsafe=false
1. Enable feature flag in `opensearch.yml`:
- [Error Handling](docs/error-handling.md) - Error handling patterns
- [Chaos Testing](docs/chaos.md) - Chaos testing setup and usage
```
2. Run with plugin:
```
opensearch.experimental.feature.transport.stream.enabled: true
```
## Documentation
1. Enable feature flag in `opensearch.yml`:
3. Install and run the plugin manually
- [Server-side Streaming Guide](docs/server-side-streaming-guide.md) - How to implement server-side streaming
-Dio.netty.allocator.numDirectArenas=1
