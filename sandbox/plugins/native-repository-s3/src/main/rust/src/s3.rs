        assert!(
        if let Some(m) = config.max_retries {
        assert!(build(r#"{"region":"us-east-1"}"#, None).is_err());
    /// Runs on its own std thread so it is independent of any tokio runtime.
    /// (separate from `io_rt`, so any polls observed on `io_rt` can only come from
// Tests
        format!(
    pub s3_express: Option<bool>,
    }
        let mut retry = RetryConfig::default();
    }
    /// Enable virtual-hosted-style requests.
    // poll counter advances. With no handle installed, the store falls back to the
    let config: S3Config = serde_json::from_str(config_json)?;
    pub retry_timeout_ms: Option<u64>,
        };
            .worker_threads(2)
    /// Retry timeout in milliseconds.
    }
            retry.retry_timeout = Duration::from_millis(ms);
            .enable_all()
        let _ = server.join();
        let uninstalled_delta = poll_delta_for_get(&uninstalled_rt, &endpoint);
//! Supports: bucket, region, endpoint, custom credential provider,
        worker_polls(io_rt.handle()) - before
            "virtual_hosted_style":false,"unsigned_payload":true,
            .thread_name("test-uninstalled")
    fn test_build_with_all_optional_fields() {
            .unwrap();
                )
        listener.set_nonblocking(true).unwrap();
    if let Some(ref a) = config.checksum_algorithm {
    // query decode. No-op when no IO runtime is installed (e.g. unit tests).
/// passed to [`build`].
//! Amazon S3 backend configuration and builder.
            uninstalled_delta
        builder = builder.with_bucket_key(true);
            while !stop_c.load(Ordering::Relaxed) {
    fn test_build_invalid_json_returns_error() {
//!
        assert!(build(config, None).is_err());
    fn poll_delta_for_get(io_rt: &tokio::runtime::Runtime, endpoint: &str) -> u64 {
    }
        (0..m.num_workers()).map(|i| m.worker_poll_count(i)).sum()
    fn io_runtime_services_s3_reads_only_when_handle_installed() {
    use super::*;
    }
        assert!(build(config, None).is_ok());
                    }
                        let _ = sock.write_all(resp.as_bytes());
    pub bucket: String,
    }
                        let _ = sock.flush();
    }
    pub dsse_kms_key_id: Option<String>,
/// If `credentials` is `Some`, it is used for authentication.
        let config = r#"{"bucket":"b","region":"us-east-1","checksum_algorithm":"md5","allow_http":true,"endpoint":"http://localhost:9000"}"#;
    if let Some(ref k) = config.sse_kms_key_id {
            .unwrap();
//! checksum algorithm, and retry config.
    }
use serde::Deserialize;
            "allow_http":true,"proxy_url":"http://proxy:8080","imdsv1_fallback":false,
        use object_store::client::StaticCredentialProvider;
///
    // its completion work (TLS, body assembly) off the CPU runtime that drives
        let stop_c = Arc::clone(&stop);
    /// Allow HTTP (non-TLS) connections.
    /// Enable S3 bucket key for SSE-KMS (reduces KMS costs).
    pub unsigned_payload: Option<bool>,
    if config.unsigned_payload == Some(true) {
    if let Some(ref e) = config.endpoint {
    fn test_build_with_valid_config() {
    if let Some(ref r) = config.region {
        if let Some(ms) = config.retry_timeout_ms {
 * SPDX-License-Identifier: Apache-2.0
        builder = builder.with_s3_express(true);
//! IMDSv1 fallback, S3 Express One Zone, SSE-KMS, DSSE-KMS, bucket key,
            token: None,
        builder = builder.with_endpoint(e);
    #[test]
                    Err(ref e) if e.kind() == std::io::ErrorKind::WouldBlock => {
    fn spawn_mock_http() -> (String, Arc<AtomicBool>, std::thread::JoinHandle<()>) {
                    }
}
        builder = builder.with_sse_kms_encryption(k);
 * this file be licensed under the Apache-2.0 license or a
    }
                    Ok((mut sock, _)) => {
/// Credentials are intentionally excluded — authentication is handled
use object_store::aws::{AmazonS3Builder, AwsCredentialProvider};
 */
//! chain (IAM roles, env vars, IMDS) or pass a custom `AwsCredentialProvider`.
    /// Allow unsigned payload.
                .map_err(|_| format!("unknown checksum algorithm: '{}'", a))?,
    ///   IO runtime (the `SpawnedReqwestConnector` wiring), so its
    // default connector and the IO runtime stays idle. `worker_poll_count` is the
    /// Warm-path assertion + its control, in ONE test because the IO handle is a
                    &object_store::path::Path::from("some-object"),
    // `SpawnedReqwestConnector` wiring in `build`), so the IO runtime's worker
    fn test_build_missing_bucket_returns_error() {
    #[test]
                        );
    pub bucket_key: Option<bool>,
        assert!(build(config, None).is_ok());
                            body.len()
            installed_delta
    /// * WITH a handle installed → the S3 store's HTTP request is polled on that
        let store = build(&s3_config(endpoint), None).expect("build s3 store");
///
        builder = builder.with_dsse_kms_encryption(d);
    /// DSSE-KMS key ID. When set, enables DSSE-KMS encryption.
    }
//! Credentials are NOT accepted via config JSON — use the default credential
            r#"{{"bucket":"b","region":"us-east-1","allow_http":true,"endpoint":"{}"}}"#,
            .build()
        let m = handle.metrics();
    if config.allow_http == Some(true) {
    /// Enable S3 Express One Zone support.
            .enable_all()
                        let mut buf = [0u8; 1024];
                    Err(_) => break,
            .thread_name("test-io")
    use std::net::TcpListener as StdTcpListener;
        });
        let io_rt = tokio::runtime::Builder::new_multi_thread()
    pub endpoint: Option<String>,
    /// the connector), returning the IO runtime's worker-poll delta across it.
 * The OpenSearch Contributors require contributions made to
        stop.store(true, Ordering::Relaxed);
        assert!(build(config, Some(provider)).is_ok());
    pub proxy_ca_certificate: Option<String>,
use std::time::Duration;
            store
    }
                            "HTTP/1.1 200 OK\r\nContent-Length: {}\r\nAccept-Ranges: bytes\r\n\r\n",
        let cred = AwsCredential {
             (delta={}) — SpawnedReqwestConnector is not dispatching HTTP onto the \
    fn test_build_unknown_checksum_returns_error() {
                        let _ = sock.read(&mut buf);
use std::sync::Arc;
//!
    #[test]
        // A second runtime that we observe but NEVER install as the IO handle.
// ---------------------------------------------------------------------------
                .await
            .unwrap();
    /// Custom endpoint URL (for S3-compatible stores like MinIO).
    if config.virtual_hosted_style == Some(true) {
        builder = builder.with_unsigned_payload(true);
            "bucket":"b","region":"us-west-2","endpoint":"http://localhost:9000",
    if let Some(io) = native_bridge_common::io_runtime::io_handle() {
        );
        assert_eq!(
        native_bridge_common::io_runtime::clear_io_handle();
    }
///
// ---------------------------------------------------------------------------
        builder = builder.with_imdsv1_fallback();
 * compatible open source license.
    // installed routes its HTTP requests onto that runtime (the
    /// Minimal localhost HTTP server: accepts connections and replies with a fixed
    }
        let uninstalled_rt = tokio::runtime::Builder::new_multi_thread()
            secret_key: "SECRET".to_string(),
    if let Some(creds) = credentials {
        }"#;
    /// `200 OK` + tiny body to ANY request, until `stop` is set. Lets us exercise
/// Configuration for an S3-compatible remote store.
    ///
        );
    }
        assert!(build("not json", None).is_err());
    /// AWS region (e.g. "us-east-1").
            use std::io::Read as _;
        (format!("http://{}", addr), stop, handle)
            "a runtime never installed as the IO handle must see no polls from an \
    credentials: Option<AwsCredentialProvider>,
    if let Some(ref d) = config.dsse_kms_key_id {
    /// Maximum number of retries for failed requests.
        builder = builder.with_proxy_ca_certificate(c);
#[derive(Debug, Deserialize)]
    #[test]
/// If `None`, the default credential chain is used (env vars, IMDS, etc.).
    use std::sync::atomic::{AtomicBool, Ordering};
    }
    #[test]
    pub proxy_url: Option<String>,
             installed IO runtime",
/// All fields except `bucket` are optional. Unknown JSON fields are
    #[test]
    fn worker_polls(handle: &tokio::runtime::Handle) -> u64 {
    // requests (and response-body streaming) onto it via SpawnedReqwestConnector
        let config = r#"{"bucket":"b","region":"us-east-1","allow_http":true,"endpoint":"http://localhost:9000"}"#;
//! virtual-hosted-style, unsigned payload, allow HTTP, proxy (with CA cert),
    // These assert the warm path: an S3 store built while an IO runtime handle is
             S3 read (delta={}) — the warm-case polls would then be ambient noise",
    // — DataFusion's `thread_pools` example mechanism. This keeps network IO and
        native_bridge_common::io_runtime::set_io_handle(io_rt.handle().clone());
        let _ = driver_rt.block_on(async move {
    /// Drive a single `get` against `endpoint` on a throwaway driver runtime
            "IO runtime worker_poll_count must advance across an S3 read \
    /// Proxy URL.
    fn test_extra_unknown_fields_ignored() {
    /// PEM-encoded CA certificate for proxy TLS verification.
        use object_store::aws::AwsCredential;
            key_id: "AKID".to_string(),
        }
    /// the real `AmazonS3` HTTP client end-to-end without a container or real S3.
                        let body = b"hello-from-mock-s3";
    }
        // CONTROL: a runtime that was never installed must see nothing from the read.
            "s3_express":false,"sse_kms_key_id":"arn:aws:kms:us-east-1:123:key/abc",
        let config = r#"{
                        std::thread::sleep(Duration::from_millis(5));
mod tests {
            .worker_threads(1)
    ///   activity.
                        // Drain the request headers (best-effort) then reply.
        );
    ///   polls, proving the warm-case polls come from the connector, not ambient
            installed_delta > 0,
                    object_store::GetOptions::default(),
    // ── IO-runtime dispatch (SpawnedReqwestConnector) ────────────────────────
}
    pub allow_http: Option<bool>,
    pub max_retries: Option<usize>,
    }
    pub virtual_hosted_style: Option<bool>,
    pub sse_kms_key_id: Option<String>,
                        let _ = sock.write_all(body);
            builder.with_http_connector(object_store::client::SpawnedReqwestConnector::new(io));
        builder = builder.with_virtual_hosted_style_request(true);
    /// Checksum algorithm (e.g. "sha256").
        )
    if config.imdsv1_fallback == Some(true) {
    /// * WITHOUT a handle (a runtime never installed) → that runtime sees zero
        let listener = StdTcpListener::bind("127.0.0.1:0").unwrap();
    if config.max_retries.is_some() || config.retry_timeout_ms.is_some() {
            uninstalled_delta, 0,
    // If the analytics engine has installed a dedicated IO runtime, route HTTP
    }
    if config.bucket_key == Some(true) {
        assert!(build(config, None).is_ok());
use object_store::{ObjectStore, RetryConfig};
    //
            "bucket_key":true,"checksum_algorithm":"sha256","max_retries":5,"retry_timeout_ms":30000
 *
        builder = builder.with_proxy_url(p);
    pub checksum_algorithm: Option<String>,
        let driver_rt = tokio::runtime::Builder::new_multi_thread()
        let before = worker_polls(io_rt.handle());
        builder = builder.with_retry(retry);
    if config.s3_express == Some(true) {
                        let resp = format!(
            .build()
    /// production `_stats` API reports as `io_runtime.total_polls_count`.
    // exact counter the DataFusion `_stats` API exports as `total_polls_count`.
    if let Some(ref c) = config.proxy_ca_certificate {
pub fn build(
            .enable_all()
        let (endpoint, stop, server) = spawn_mock_http();
    }
    }
/// via the default credential chain or a custom `AwsCredentialProvider`
    }
        let installed_delta = poll_delta_for_get(&io_rt, &endpoint);
            endpoint
    #[test]
        let provider = Arc::new(StaticCredentialProvider::new(cred));
        builder = builder.with_checksum_algorithm(
    let mut builder = AmazonS3Builder::new().with_bucket_name(&config.bucket);
        }
    /// Sum of per-worker poll counts for a runtime — the same metric the
    /// S3 bucket name (required).
#[cfg(test)]
        builder = builder.with_allow_http(true);
    config_json: &str,
        let stop = Arc::new(AtomicBool::new(false));
                match listener.accept() {
    if let Some(ref p) = config.proxy_url {
        let config = r#"{"bucket":"b","region":"us-east-1","allow_http":true,"endpoint":"http://localhost:9000"}"#;
    }
        builder =
    fn test_build_with_custom_credentials() {
) -> Result<Arc<dyn ObjectStore>, Box<dyn std::error::Error + Send + Sync>> {
    }
    use std::io::Write as _;
    Ok(Arc::new(builder.build()?))
        builder = builder.with_region(r);
        });
    fn s3_config(endpoint: &str) -> String {
    }
            .build()
    /// SSE-KMS key ID. When set, enables SSE-KMS encryption.
/// silently ignored by serde's default behavior.
    }
    #[test]
    ///   `worker_poll_count` advances.
pub struct S3Config {
            .worker_threads(2)
                }
    /// Enable IMDSv1 fallback for EC2 metadata credentials.
    }
        let handle = std::thread::spawn(move || {
        builder = builder.with_credentials(creds);
/*
                .get_opts(
            }
        let addr = listener.local_addr().unwrap();
    }
        let config = r#"{"bucket":"b","region":"us-east-1","allow_http":true,"endpoint":"http://localhost:9000","unknown_field":"value"}"#;
    pub imdsv1_fallback: Option<bool>,
    pub region: Option<String>,
            a.parse()
        // WARM: handle installed → io_rt must poll the request.
}
/// Build an S3 [`ObjectStore`] from JSON config.
    /// process-global that parallel tests would race on.
            retry.max_retries = m;
    }
