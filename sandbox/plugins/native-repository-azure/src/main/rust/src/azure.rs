        if let Some(m) = config.max_retries {
#[derive(Debug, Deserialize)]
    // If the analytics engine has installed a dedicated IO runtime, route HTTP
) -> Result<Arc<dyn ObjectStore>, Box<dyn std::error::Error + Send + Sync>> {
use std::time::Duration;
    if config.max_retries.is_some() || config.retry_timeout_ms.is_some() {
//!
        let config = r#"{"account":"a","container":"c"}"#;
}
    pub container: String,
pub fn build(
    // requests (and response-body streaming) onto it via SpawnedReqwestConnector
/// Build an Azure [`ObjectStore`] from JSON config.
    }
    }
    /// Azure storage account name (required).
        assert!(build(r#"{"container":"c"}"#, None).is_err());
//! `AzureCredentialProvider`.
    }
    fn test_build_missing_account_returns_error() {
    pub account: String,
        builder =
        let config = r#"{"account":"a","container":"c","max_retries":5,"retry_timeout_ms":20000}"#;
 * compatible open source license.
        }
 *
pub struct AzureConfig {
        builder = builder.with_credentials(creds);
    // query decode. No-op when no IO runtime is installed (e.g. unit tests).
 */
#[cfg(test)]
        let mut retry = RetryConfig::default();
        builder = builder.with_retry(retry);
mod tests {
 * The OpenSearch Contributors require contributions made to
        }
        .with_container_name(&config.container);
use object_store::azure::{AzureCredentialProvider, MicrosoftAzureBuilder};
    fn test_build_minimal_config() {
    Ok(Arc::new(builder.build()?))
    config_json: &str,
    /// Azure container name (required).
 * SPDX-License-Identifier: Apache-2.0
/// If `credentials` is `Some`, it is used for authentication.
}
    }
/*
///
        // Default credential chain — will fail at runtime without real Azure creds,
    pub retry_timeout_ms: Option<u64>,
///
//! Azure Blob Storage backend configuration and builder.
    // its completion work (TLS, body assembly) off the CPU runtime that drives
        // but the builder construction should succeed.
    let mut builder = MicrosoftAzureBuilder::new()
    // — DataFusion's `thread_pools` example mechanism. This keeps network IO and
use serde::Deserialize;
/// Configuration for an Azure Blob Storage remote store.
        .with_account(&config.account)
            retry.retry_timeout = Duration::from_millis(ms);
        assert!(build(config, None).is_ok());
use object_store::{ObjectStore, RetryConfig};
 * this file be licensed under the Apache-2.0 license or a
    /// Maximum number of retries for failed requests.
    fn test_build_with_retry_config() {
/// via the default Azure credential chain or a custom `AzureCredentialProvider`
    if let Some(io) = native_bridge_common::io_runtime::io_handle() {
    }
    }
    pub max_retries: Option<usize>,
//! Credentials are NOT accepted via config JSON — use the default Azure
//! credential chain (managed identity, CLI, env vars) or pass a custom
        if let Some(ms) = config.retry_timeout_ms {
    #[test]
    use super::*;
/// Credentials are intentionally excluded — authentication is handled
    if let Some(creds) = credentials {
    credentials: Option<AzureCredentialProvider>,
            retry.max_retries = m;
            builder.with_http_connector(object_store::client::SpawnedReqwestConnector::new(io));
/// If `None`, the default Azure credential chain is used.
    /// Retry timeout in milliseconds.
/// passed to [`build`].
        assert!(build(config, None).is_ok());
    #[test]
    let config: AzureConfig = serde_json::from_str(config_json)?;
use std::sync::Arc;
}
    #[test]
