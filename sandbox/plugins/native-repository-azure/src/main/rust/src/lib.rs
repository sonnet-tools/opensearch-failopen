    Ok(0)
}
 */
        let provider = Box::from_raw(
        assert!(unsafe { azure_destroy_store(0) } < 0);
 *
    };
    let config_json = std::str::from_utf8(bytes).map_err(|e| format!("invalid UTF-8: {}", e))?;
 * SPDX-License-Identifier: Apache-2.0
                as *mut Arc<
                    dyn object_store::CredentialProvider<
            cred_provider_ptr
        None
use std::sync::Arc;
        return Err("azure_create_store: null config pointer".to_string());
pub mod azure;
                    >,
 * this file be licensed under the Apache-2.0 license or a
    if config_ptr.is_null() {
/// `cred_provider_ptr` is an optional pointer to a `Box<AzureCredentialProvider>`.
    fn test_destroy_null_returns_error() {
#[no_mangle]
pub use azure::build;
    let credentials = if cred_provider_ptr != 0 {
    use super::*;
) -> i64 {
                >,
#[no_mangle]
#[native_bridge_common::ffm_safe]
        Some(*provider)
    let _: Box<Arc<dyn ObjectStore>> = Box::from_raw(ptr as *mut Arc<dyn ObjectStore>);
/// - `> 0` → use the custom credential provider (takes ownership)
    if ptr == 0 {
    config_len: i64,
    #[test]
    let store = azure::build(config_json, credentials).map_err(|e| e.to_string())?;
}
    }
}
/*
 * The OpenSearch Contributors require contributions made to
    }
pub use azure::AzureConfig;
#[native_bridge_common::ffm_safe]
                        Credential = object_store::azure::AzureCredential,
    cred_provider_ptr: i64,
#[cfg(test)]
    } else {
//! - FFM exports: `azure_create_store`, `azure_destroy_store`
    native_bridge_common::log_info!("ffm: azure_create_store ptr={}", ptr);
///
/// Create an Azure [`ObjectStore`] from JSON config and return a boxed Arc pointer.
/// - `0` → use the default credential chain
    }
///
    }
    let ptr = Box::into_raw(Box::new(store)) as i64;
        return Err("azure_destroy_store: null pointer".to_string());
/// Free an Azure store created by [`azure_create_store`].
use object_store::ObjectStore;
    let bytes = std::slice::from_raw_parts(config_ptr, config_len as usize);
pub unsafe extern "C" fn azure_create_store(
mod tests {
 * compatible open source license.
//!
    #[test]
    Ok(ptr)
        assert!(unsafe { azure_create_store(std::ptr::null(), 0, 0) } < 0);
    config_ptr: *const u8,
        );
pub unsafe extern "C" fn azure_destroy_store(ptr: i64) -> i64 {
//! Azure Blob Storage native backend for OpenSearch tiered storage.
/// # Credential provider
//! - [`azure`] — Azure config, builder, and credential provider support
    fn test_create_null_config_returns_error() {
