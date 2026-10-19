            "IO runtime worker_poll_count must advance across an S3 read \
    // — DataFusion's `thread_pools` example mechanism. This keeps network IO and
    /// Maximum number of retries for failed requests.
                            "HTTP/1.1 200 OK\r\nContent-Length: {}\r\nAccept-Ranges: bytes\r\n\r\n",
        let m = handle.metrics();
    /// the connector), returning the IO runtime's worker-poll delta across it.
        builder = builder.with_unsigned_payload(true);
    pub retry_timeout_ms: Option<u64>,
    }
    pub virtual_hosted_style: Option<bool>,
///
        });
/// Configuration for an S3-compatible remote store.
    if let Some(ref a) = config.checksum_algorithm {
        }"#;
    }
        )
//!
                    }
use object_store::{ObjectStore, RetryConfig};
    config_json: &str,
//! checksum algorithm, and retry config.
    #[test]
    /// Drive a single `get` against `endpoint` on a throwaway driver runtime
/// via the default credential chain or a custom `AwsCredentialProvider`
    fn poll_delta_for_get(io_rt: &tokio::runtime::Runtime, endpoint: &str) -> u64 {
        let config = r#"{
                )
    }
    if let Some(creds) = credentials {
//! Amazon S3 backend configuration and builder.
    /// Enable IMDSv1 fallback for EC2 metadata credentials.
    let mut builder = AmazonS3Builder::new().with_bucket_name(&config.bucket);
        assert_eq!(
    /// `200 OK` + tiny body to ANY request, until `stop` is set. Lets us exercise
    }
    // `SpawnedReqwestConnector` wiring in `build`), so the IO runtime's worker
    /// PEM-encoded CA certificate for proxy TLS verification.
pub fn build(
    pub dsse_kms_key_id: Option<String>,
                        let _ = sock.read(&mut buf);
        builder = builder.with_imdsv1_fallback();
    /// Allow HTTP (non-TLS) connections.
    }
    if config.allow_http == Some(true) {
            a.parse()
            store
            endpoint
            .enable_all()
    }
                .await
    /// Enable virtual-hosted-style requests.
#[derive(Debug, Deserialize)]
    /// Custom endpoint URL (for S3-compatible stores like MinIO).
    /// Sum of per-worker poll counts for a runtime — the same metric the
 * compatible open source license.
        };
            installed_delta
    if config.virtual_hosted_style == Some(true) {
        }
    fn test_build_with_valid_config() {
                    Err(_) => break,
    }
                match listener.accept() {
                        std::thread::sleep(Duration::from_millis(5));
    }
    if let Some(ref c) = config.proxy_ca_certificate {
    #[test]
    ///   polls, proving the warm-case polls come from the connector, not ambient
//! virtual-hosted-style, unsigned payload, allow HTTP, proxy (with CA cert),
        let before = worker_polls(io_rt.handle());
            }
                        // Drain the request headers (best-effort) then reply.
    fn test_build_with_custom_credentials() {
        let handle = std::thread::spawn(move || {
            .enable_all()
    // requests (and response-body streaming) onto it via SpawnedReqwestConnector
            "bucket":"b","region":"us-west-2","endpoint":"http://localhost:9000",
    /// * WITH a handle installed → the S3 store's HTTP request is polled on that
}
//! chain (IAM roles, env vars, IMDS) or pass a custom `AwsCredentialProvider`.
            "s3_express":false,"sse_kms_key_id":"arn:aws:kms:us-east-1:123:key/abc",
        builder = builder.with_proxy_url(p);
    fn s3_config(endpoint: &str) -> String {
            key_id: "AKID".to_string(),
    //
            .worker_threads(2)
}
    #[test]
use serde::Deserialize;
            .worker_threads(2)
    if let Some(ref d) = config.dsse_kms_key_id {
            .unwrap();
/// Build an S3 [`ObjectStore`] from JSON config.
    pub imdsv1_fallback: Option<bool>,
    /// Minimal localhost HTTP server: accepts connections and replies with a fixed
        stop.store(true, Ordering::Relaxed);
        builder = builder.with_dsse_kms_encryption(d);
            .thread_name("test-uninstalled")
    }
            r#"{{"bucket":"b","region":"us-east-1","allow_http":true,"endpoint":"{}"}}"#,
            "a runtime never installed as the IO handle must see no polls from an \
// Tests
    }
    /// Retry timeout in milliseconds.
/// If `None`, the default credential chain is used (env vars, IMDS, etc.).
    fn test_build_invalid_json_returns_error() {
                        let _ = sock.write_all(body);
//! IMDSv1 fallback, S3 Express One Zone, SSE-KMS, DSSE-KMS, bucket key,
    fn test_extra_unknown_fields_ignored() {
    pub region: Option<String>,
                    }
        assert!(
#[cfg(test)]
        let store = build(&s3_config(endpoint), None).expect("build s3 store");
// ---------------------------------------------------------------------------
        if let Some(ms) = config.retry_timeout_ms {
        let io_rt = tokio::runtime::Builder::new_multi_thread()
        let stop = Arc::new(AtomicBool::new(false));
        use object_store::aws::AwsCredential;
    use super::*;
    /// Enable S3 bucket key for SSE-KMS (reduces KMS costs).
    // If the analytics engine has installed a dedicated IO runtime, route HTTP
        let installed_delta = poll_delta_for_get(&io_rt, &endpoint);
    pub sse_kms_key_id: Option<String>,
            .build()
//!
                        let mut buf = [0u8; 1024];
        let (endpoint, stop, server) = spawn_mock_http();
//! Credentials are NOT accepted via config JSON — use the default credential
                            body.len()
            .unwrap();
    pub proxy_url: Option<String>,
                    Err(ref e) if e.kind() == std::io::ErrorKind::WouldBlock => {
                    Ok((mut sock, _)) => {
            while !stop_c.load(Ordering::Relaxed) {
        let listener = StdTcpListener::bind("127.0.0.1:0").unwrap();
    fn worker_polls(handle: &tokio::runtime::Handle) -> u64 {
    /// Allow unsigned payload.
    // installed routes its HTTP requests onto that runtime (the
        let config = r#"{"bucket":"b","region":"us-east-1","allow_http":true,"endpoint":"http://localhost:9000"}"#;
        let _ = driver_rt.block_on(async move {
    }
    // These assert the warm path: an S3 store built while an IO runtime handle is
    }
        use object_store::client::StaticCredentialProvider;
        builder = builder.with_bucket_key(true);
    }
    pub unsigned_payload: Option<bool>,
 * The OpenSearch Contributors require contributions made to
    #[test]
    }
            uninstalled_delta, 0,
/// passed to [`build`].
        assert!(build(config, None).is_ok());
                .get_opts(
    // default connector and the IO runtime stays idle. `worker_poll_count` is the
    pub s3_express: Option<bool>,
        builder = builder.with_allow_http(true);
        builder = builder.with_s3_express(true);
    use std::sync::atomic::{AtomicBool, Ordering};
    /// DSSE-KMS key ID. When set, enables DSSE-KMS encryption.
    }
        }
    use std::net::TcpListener as StdTcpListener;
    pub endpoint: Option<String>,
        if let Some(m) = config.max_retries {
    /// Runs on its own std thread so it is independent of any tokio runtime.
            .worker_threads(1)
    }
    }
    // exact counter the DataFusion `_stats` API exports as `total_polls_count`.
    if let Some(ref e) = config.endpoint {
        let config = r#"{"bucket":"b","region":"us-east-1","allow_http":true,"endpoint":"http://localhost:9000"}"#;
            secret_key: "SECRET".to_string(),
        worker_polls(io_rt.handle()) - before
        );
            retry.max_retries = m;
        builder = builder.with_virtual_hosted_style_request(true);
    ///   IO runtime (the `SpawnedReqwestConnector` wiring), so its
        format!(
///
    if let Some(ref p) = config.proxy_url {
    ///
 *
            installed_delta > 0,
    if config.max_retries.is_some() || config.retry_timeout_ms.is_some() {
             installed IO runtime",
pub struct S3Config {
    if let Some(ref r) = config.region {
        native_bridge_common::io_runtime::clear_io_handle();
//! Supports: bucket, region, endpoint, custom credential provider,
    /// Warm-path assertion + its control, in ONE test because the IO handle is a
        let uninstalled_delta = poll_delta_for_get(&uninstalled_rt, &endpoint);
    fn spawn_mock_http() -> (String, Arc<AtomicBool>, std::thread::JoinHandle<()>) {
    // poll counter advances. With no handle installed, the store falls back to the
    /// AWS region (e.g. "us-east-1").
        builder = builder.with_sse_kms_encryption(k);
    pub bucket: String,
                        let _ = sock.write_all(resp.as_bytes());
    Ok(Arc::new(builder.build()?))
            use std::io::Read as _;
            builder.with_http_connector(object_store::client::SpawnedReqwestConnector::new(io));
 */
        builder = builder.with_proxy_ca_certificate(c);
 * SPDX-License-Identifier: Apache-2.0
        builder = builder.with_checksum_algorithm(
    }
        assert!(build(config, Some(provider)).is_ok());
        );
/// silently ignored by serde's default behavior.
    /// S3 bucket name (required).
        let mut retry = RetryConfig::default();
            .unwrap();
        builder = builder.with_region(r);
    if config.bucket_key == Some(true) {
             (delta={}) — SpawnedReqwestConnector is not dispatching HTTP onto the \
            .build()
    }
                        let resp = format!(
            "allow_http":true,"proxy_url":"http://proxy:8080","imdsv1_fallback":false,
                .map_err(|_| format!("unknown checksum algorithm: '{}'", a))?,
            retry.retry_timeout = Duration::from_millis(ms);
        );
    ///   activity.
        });
    }
        let stop_c = Arc::clone(&stop);
    pub max_retries: Option<usize>,
    #[test]
            uninstalled_delta
///
        let driver_rt = tokio::runtime::Builder::new_multi_thread()
        (format!("http://{}", addr), stop, handle)
        assert!(build(config, None).is_err());
        let uninstalled_rt = tokio::runtime::Builder::new_multi_thread()
        builder = builder.with_retry(retry);
            "bucket_key":true,"checksum_algorithm":"sha256","max_retries":5,"retry_timeout_ms":30000
        assert!(build(config, None).is_ok());
        let config = r#"{"bucket":"b","region":"us-east-1","allow_http":true,"endpoint":"http://localhost:9000","unknown_field":"value"}"#;
        // CONTROL: a runtime that was never installed must see nothing from the read.
    fn test_build_unknown_checksum_returns_error() {
/// Credentials are intentionally excluded — authentication is handled
    pub proxy_ca_certificate: Option<String>,
    if config.unsigned_payload == Some(true) {
        let provider = Arc::new(StaticCredentialProvider::new(cred));
    // query decode. No-op when no IO runtime is installed (e.g. unit tests).
    pub checksum_algorithm: Option<String>,
    if config.imdsv1_fallback == Some(true) {
        let addr = listener.local_addr().unwrap();
/// All fields except `bucket` are optional. Unknown JSON fields are
        builder = builder.with_credentials(creds);
                        let _ = sock.flush();
    if config.s3_express == Some(true) {
    ///   `worker_poll_count` advances.
use std::time::Duration;
        let cred = AwsCredential {
        assert!(build("not json", None).is_err());
    }
    use std::io::Write as _;
    /// SSE-KMS key ID. When set, enables SSE-KMS encryption.
            "virtual_hosted_style":false,"unsigned_payload":true,
            .enable_all()
        assert!(build(r#"{"region":"us-east-1"}"#, None).is_err());
/*
    /// production `_stats` API reports as `io_runtime.total_polls_count`.
    fn test_build_missing_bucket_returns_error() {
    credentials: Option<AwsCredentialProvider>,
    #[test]
    }
    #[test]
    }
    #[test]
            token: None,
    /// process-global that parallel tests would race on.
use std::sync::Arc;
        // A second runtime that we observe but NEVER install as the IO handle.
    fn test_build_with_all_optional_fields() {
) -> Result<Arc<dyn ObjectStore>, Box<dyn std::error::Error + Send + Sync>> {
    pub bucket_key: Option<bool>,
/// If `credentials` is `Some`, it is used for authentication.
// ---------------------------------------------------------------------------
}
 * this file be licensed under the Apache-2.0 license or a
    let config: S3Config = serde_json::from_str(config_json)?;
        assert!(build(config, None).is_ok());
        builder =
    fn io_runtime_services_s3_reads_only_when_handle_installed() {
    /// (separate from `io_rt`, so any polls observed on `io_rt` can only come from
    pub allow_http: Option<bool>,
        builder = builder.with_endpoint(e);
        let config = r#"{"bucket":"b","region":"us-east-1","checksum_algorithm":"md5","allow_http":true,"endpoint":"http://localhost:9000"}"#;
        // WARM: handle installed → io_rt must poll the request.
                }
    }
                        let body = b"hello-from-mock-s3";
             S3 read (delta={}) — the warm-case polls would then be ambient noise",
    }
mod tests {
        listener.set_nonblocking(true).unwrap();
                    &object_store::path::Path::from("some-object"),
    }
    /// Checksum algorithm (e.g. "sha256").
    /// Proxy URL.
    /// Enable S3 Express One Zone support.
    }
    // ── IO-runtime dispatch (SpawnedReqwestConnector) ────────────────────────
            .thread_name("test-io")
        let _ = server.join();
    /// * WITHOUT a handle (a runtime never installed) → that runtime sees zero
            .build()
    if let Some(ref k) = config.sse_kms_key_id {
        native_bridge_common::io_runtime::set_io_handle(io_rt.handle().clone());
                        );
    if let Some(io) = native_bridge_common::io_runtime::io_handle() {
    }
                    object_store::GetOptions::default(),
use object_store::aws::{AmazonS3Builder, AwsCredentialProvider};
    // its completion work (TLS, body assembly) off the CPU runtime that drives
    /// the real `AmazonS3` HTTP client end-to-end without a container or real S3.
        (0..m.num_workers()).map(|i| m.worker_poll_count(i)).sum()
