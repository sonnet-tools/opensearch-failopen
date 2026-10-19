                        Credential = object_store::aws::AwsCredential,
        let result = unsafe { s3_create_store(bad.as_ptr(), bad.len() as i64, 0) };
}
    let _store: Box<Arc<dyn ObjectStore>> = Box::from_raw(ptr as *mut Arc<dyn ObjectStore>);
        );
        let config_bytes = config.as_bytes();
 *
        Some(*provider)
/// Create an S3 [`ObjectStore`] from JSON config and return a boxed Arc pointer.
    };
        let result = unsafe { s3_destroy_store(0) };
    config_len: i64,
use std::sync::Arc;
// FFM entry points
    let ptr = Box::into_raw(Box::new(store)) as i64;
 * this file be licensed under the Apache-2.0 license or a
    let credentials = if cred_provider_ptr != 0 {
/// Free an S3 store created by [`s3_create_store`].
//! - [`s3`] — S3 config, builder, and credential provider support
}
        let bad = b"not json";
    config_ptr: *const u8,
#[cfg(test)]
    }
        assert!(result < 0);
    } else {
    fn test_create_and_destroy_no_leak() {
}
    use super::*;
 * The OpenSearch Contributors require contributions made to
        // SAFETY: ptr was produced by Box::into_raw(Box::new(Arc<dyn CredentialProvider<Credential = AwsCredential>>))
#[native_bridge_common::ffm_safe]
/// # Credential provider
    native_bridge_common::log_info!("ffm: s3_create_store ptr={}", ptr);
pub unsafe extern "C" fn s3_destroy_store(ptr: i64) -> i64 {
/// via [`s3_destroy_store`].
        return Err("s3_create_store: null config pointer".to_string());
        let ptr = unsafe { s3_create_store(config_bytes.as_ptr(), config_bytes.len() as i64, 0) };
        let result = unsafe { s3_destroy_store(ptr) };
) -> i64 {
        assert_eq!(result, 0, "destroy should return 0");
                >,
        assert!(result < 0);
    Ok(0)
// ---------------------------------------------------------------------------
#[native_bridge_common::ffm_safe]
                as *mut Arc<
 */
    }
    cred_provider_ptr: i64,
pub unsafe extern "C" fn s3_create_store(
        None
// ---------------------------------------------------------------------------
pub use s3::S3Config;
    if ptr == 0 {
    }
    }
//! Amazon S3 native backend for OpenSearch tiered storage.
/// `cred_provider_ptr` is an optional pointer to a `Box<AwsCredentialProvider>`.
        // Uses mock values — the S3 client is created but never connects.
    fn test_create_invalid_json_returns_error() {
    }
    // SAFETY: ptr was produced by Box::into_raw(Box::new(Arc<dyn ObjectStore>))
    #[test]
    let store = s3::build(config_json, credentials).map_err(|e| e.to_string())?;
/// The returned pointer must be passed to `ts_add_remote_store_ptr` or freed
        return Err("s3_destroy_store: null pointer".to_string());
    #[test]
// ---------------------------------------------------------------------------
/// Returns `>= 0` (pointer) on success, `< 0` on error.
//!
    #[test]
//! - FFM exports: `s3_create_store`, `s3_destroy_store`
        assert!(ptr > 0, "create should return positive pointer");
    if config_ptr.is_null() {
        let config = r#"{"bucket":"test-bucket","region":"us-east-1","allow_http":true,"endpoint":"http://localhost:9000"}"#;
#[no_mangle]
        let provider = Box::from_raw(
 * compatible open source license.
// ---------------------------------------------------------------------------
/// - `> 0` → use the custom credential provider (takes ownership, pointer is consumed)
// Tests
    fn test_create_null_config_returns_error() {
    #[test]
#[no_mangle]
        assert!(result < 0);
    }
            cred_provider_ptr
/*
    let config_json = std::str::from_utf8(bytes).map_err(|e| format!("invalid UTF-8: {}", e))?;
                    dyn object_store::CredentialProvider<
pub mod s3;
        // No real credentials are used; these are placeholder strings for config parsing.
 * SPDX-License-Identifier: Apache-2.0
///
mod tests {
    let bytes = std::slice::from_raw_parts(config_ptr, config_len as usize);
pub use s3::build;
    Ok(ptr)
use object_store::ObjectStore;
///
        let result = unsafe { s3_create_store(std::ptr::null(), 0, 0) };
    fn test_destroy_null_returns_error() {
/// - `0` → use the default credential chain (env vars, IMDS, IRSA, static creds from config)
///
                    >,
