        assert!(ptr > 0);
        assert_eq!(unsafe { fs_destroy_store(ptr) }, 0);
#[native_bridge_common::ffm_safe]
 * SPDX-License-Identifier: Apache-2.0
    let store = fs::build(config_json).map_err(|e| e.to_string())?;
    if config_ptr.is_null() {
mod tests {
    fn test_destroy_null_returns_error() {
pub use fs::FsConfig;
    use super::*;
/*
        return Err("fs_create_store: null config pointer".to_string());
    fn test_create_and_destroy_no_leak() {
        let dir = tempfile::tempdir().unwrap();
    }
    if ptr == 0 {
///
    let _: Box<Arc<dyn ObjectStore>> = Box::from_raw(ptr as *mut Arc<dyn ObjectStore>);
    }
    }
}
        let config_bytes = config.as_bytes();
//! - [`fs`] — FS config and builder
#[cfg(test)]
use std::sync::Arc;
pub use fs::build;
    native_bridge_common::log_info!("ffm: fs_create_store ptr={}", ptr);
 * this file be licensed under the Apache-2.0 license or a
    Ok(ptr)
    #[test]
}
}
 *
        return Err("fs_destroy_store: null pointer".to_string());
pub unsafe extern "C" fn fs_create_store(config_ptr: *const u8, config_len: i64) -> i64 {
        let config = format!(r#"{{"base_path":"{}"}}"#, dir.path().display());
    Ok(0)
/// Create a local filesystem [`ObjectStore`] from JSON config.
//! - FFM exports: `fs_create_store`, `fs_destroy_store`
pub mod fs;
        let ptr = unsafe { fs_create_store(config_bytes.as_ptr(), config_bytes.len() as i64) };
use object_store::ObjectStore;
#[native_bridge_common::ffm_safe]
/// Free a FS store created by [`fs_create_store`].
#[no_mangle]
/// FS backend does not use credentials.
//!
    #[test]
    let bytes = std::slice::from_raw_parts(config_ptr, config_len as usize);
//! Local filesystem native backend for OpenSearch tiered storage (testing).
 */
    let ptr = Box::into_raw(Box::new(store)) as i64;
#[no_mangle]
 * The OpenSearch Contributors require contributions made to
pub unsafe extern "C" fn fs_destroy_store(ptr: i64) -> i64 {
    let config_json = std::str::from_utf8(bytes).map_err(|e| format!("invalid UTF-8: {}", e))?;
 * compatible open source license.
    }
        assert!(unsafe { fs_destroy_store(0) } < 0);
