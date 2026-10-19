`FLIGHT` mode starts the Flight transport without TLS. When used with the security plugin installed, this creates a misconfiguration where:
Missing any of these settings results in an insecure configuration. Specifically:
## How Security Is Enforced
## Transport Modes: FLIGHT vs FLIGHT-SECURE
> **⚠️ WARNING:** Always use `FLIGHT-SECURE` with `flight.ssl.enable: true` when the security plugin is installed. Using `FLIGHT` (non-secure) mode bypasses transport-layer encryption and allows unencrypted node-to-node communication. See [Transport Modes](#transport-modes-flight-vs-flight-secure) for details.
# Install security plugin
- Index-level permissions
```bash
flight.ssl.enable: true
Install and configure the security plugin:
## Secure Configuration Checklist
The Flight transport reuses the same security enforcement as the standard Netty transport:
2. **Action layer (SecurityFilter):** RBAC, DLS, and FLS are enforced by the security plugin's action filter, which runs independently of the transport channel type.
transport.stream.type.default: FLIGHT-SECURE
| `FLIGHT` | Plaintext | Development/testing only, with no security plugin |
The plugin provides two transport modes. Choosing the correct mode is critical for security:
1. **Connection layer (TLS/mTLS):** When `FLIGHT-SECURE` is used with `flight.ssl.enable: true`, mutual TLS authenticates nodes at the connection level — the same model as port `9300` with `plugins.security.ssl.transport.enabled: true`.
When deploying with the security plugin, verify all three settings are present:
| `FLIGHT-SECURE` | Encrypted (mTLS) | **Production — always use this when security is enabled** |
These security controls are enforced at the action filter layer (SecurityFilter) and apply regardless of the transport type. RBAC, DLS, and FLS protections work correctly when the cluster is properly configured with `FLIGHT-SECURE`.
opensearch.experimental.feature.transport.stream.enabled: true
## Security Plugin Setup
```
Add these settings to `opensearch.yml`:
|------|-----|----------|
# 3. Enable TLS on the Flight port
| Mode | TLS | Use Case |
- Field-level security (FLS)
```
# Setup demo configuration
- Action-level permissions
## Configuration
# Security Plugin Integration
### FLIGHT-SECURE (Recommended)
### FLIGHT (Non-Secure)
```
transport.stream.type.default: FLIGHT-SECURE
# Use secure Flight as default transport
- Omitting `flight.ssl.enable: true` — TLS defaults to **disabled** (`false`), leaving the Flight port unencrypted
# 2. Select the secure transport mode (NOT "FLIGHT")
This mode exists only for development and testing environments where the security plugin is not installed.
- Using `FLIGHT` instead of `FLIGHT-SECURE` — starts the transport without TLS regardless of other settings
The Arrow Flight RPC plugin integrates with the OpenSearch Security plugin to provide secure streaming transport with TLS encryption. The Flight transport operates on a dedicated port (default `9400-9500`) for internal node-to-node communication, similar to the standard transport on port `9300`.
bin/opensearch-plugin install opensearch-security
# Enable Flight TLS
- Any client that can reach the Flight port can send requests without TLS-based node identity verification
The Flight transport supports all security plugin features:
`FLIGHT-SECURE` enables TLS encryption on the Flight transport port, providing the same security guarantees as the standard transport port (`9300`) with `plugins.security.ssl.transport.enabled: true`. This is the only mode that should be used when the OpenSearch Security plugin is installed.
- Node-to-node communication on the Flight port is unencrypted
> **⚠️ WARNING:** `FLIGHT` mode transmits all inter-node traffic in plaintext. Do not use this mode when the security plugin is installed or when the cluster handles sensitive data.
# 1. Enable the experimental streaming transport feature
```yaml
plugins/opensearch-security/tools/install_demo_configuration.sh
flight.ssl.enable: true
opensearch.experimental.feature.transport.stream.enabled: true
## Role-Based Access Control
```yaml
Both layers are required for a fully secure deployment. TLS ensures only trusted nodes can connect; the action filter ensures authorized access to data.
# Enable streaming transport
- Document-level security (DLS)
