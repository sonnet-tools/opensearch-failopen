    }
            cred_provider_ptr
    let bytes = std::slice::from_raw_parts(config_ptr, config_len as usize);
    fn test_create_null_config_returns_error() {
use std::sync::Arc;
        let provider = Box::from_raw(
    if ptr == 0 {
    config_ptr: *const u8,
        return Err("gcs_destroy_store: null pointer".to_string());
 * SPDX-License-Identifier: Apache-2.0
    let store = gcs::build(config_json, credentials).map_err(|e| e.to_string())?;
/// Create a GCS [`ObjectStore`] from JSON config and return a boxed Arc pointer.
    let ptr = Box::into_raw(Box::new(store)) as i64;
    };
 * this file be licensed under the Apache-2.0 license or a
                >,
        None
use object_store::ObjectStore;
    Ok(0)
) -> i64 {
        assert!(unsafe { gcs_create_store(std::ptr::null(), 0, 0) } < 0);
    let config_json = std::str::from_utf8(bytes).map_err(|e| format!("invalid UTF-8: {}", e))?;
    }
}
 */
mod tests {
    cred_provider_ptr: i64,
/// `cred_provider_ptr` is an optional pointer to a `Box<GcpCredentialProvider>`.
 * The OpenSearch Contributors require contributions made to
    #[test]
                    >,
    let _: Box<Arc<dyn ObjectStore>> = Box::from_raw(ptr as *mut Arc<dyn ObjectStore>);
    } else {
        );
    Ok(ptr)
/// - `> 0` → use the custom credential provider (takes ownership)
pub use gcs::build;
/// # Credential provider
}
//! - FFM exports: `gcs_create_store`, `gcs_destroy_store`
//!
    use super::*;
//! Google Cloud Storage native backend for OpenSearch tiered storage.
 *
 * compatible open source license.
                    dyn object_store::CredentialProvider<
pub mod gcs;
                        Credential = object_store::gcp::GcpCredential,
    }
    if config_ptr.is_null() {
        return Err("gcs_create_store: null config pointer".to_string());
#[no_mangle]
#[native_bridge_common::ffm_safe]
    native_bridge_common::log_info!("ffm: gcs_create_store ptr={}", ptr);
}
    #[test]
#[cfg(test)]
///
    }
/// Free a GCS store created by [`gcs_create_store`].
#[native_bridge_common::ffm_safe]
        assert!(unsafe { gcs_destroy_store(0) } < 0);
    fn test_destroy_null_returns_error() {
//! - [`gcs`] — GCS config, builder, and credential provider support
pub use gcs::GcsConfig;
pub unsafe extern "C" fn gcs_destroy_store(ptr: i64) -> i64 {
        Some(*provider)
    let credentials = if cred_provider_ptr != 0 {
/*
                as *mut Arc<
/// - `0` → use the default credential chain
#[no_mangle]
///
    config_len: i64,
pub unsafe extern "C" fn gcs_create_store(
