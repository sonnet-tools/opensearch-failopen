        Err(panic) => {
where
{
use std::ffi::CString;
        Ok(Err(msg)) => into_error_ptr(msg),
        }
            };
    if ptr.is_null() {
 * this file be licensed under the Apache-2.0 license or a
/// Returns an error (not a panic) with the given message. For testing error handling.
        panic!("{}", msg);
}
    F: FnOnce() -> Result<i64, String> + std::panic::UnwindSafe,
//!   - `>= 0` → success (value or pointer)
pub fn into_error_ptr(msg: String) -> i64 {
        return into_error_ptr("null string pointer".to_string());
#[no_mangle]
            std::str::from_utf8_unchecked(std::slice::from_raw_parts(msg_ptr, msg_len as usize));
pub unsafe extern "C" fn native_test_validate_str(ptr: *const u8, len: i64) -> i64 {
            let msg = if let Some(s) = panic.downcast_ref::<String>() {
}
        let msg =
                format!("unknown panic in {}", name)
    let msg = std::str::from_utf8_unchecked(std::slice::from_raw_parts(msg_ptr, msg_len as usize));
 */
/// Wraps a closure with `catch_unwind` and error-pointer conversion.
#[no_mangle]
pub unsafe extern "C" fn native_error_free(ptr: i64) {
/// Heap-allocate the error message and return its pointer as a negative i64.
    }
        let _ = CString::from_raw(ptr as *mut c_char);
#[no_mangle]
            } else {
            into_error_ptr(msg)
    ptr as *const c_char
//! FFM error handling.
            } else if let Some(s) = panic.downcast_ref::<&str>() {
    match std::panic::catch_unwind(f) {
    -(ptr as i64)
pub unsafe extern "C" fn native_test_error(msg_ptr: *const u8, msg_len: i64) -> i64 {
    }
                s.clone()
    let bytes = std::slice::from_raw_parts(ptr, len as usize);
//!              Call `native_error_message` to read, `native_error_free` to free.
 * The OpenSearch Contributors require contributions made to
#[no_mangle]
}
    match ::std::panic::catch_unwind(::std::panic::AssertUnwindSafe(|| -> Result<i64, String> {
/// this crate's FFI functions and the `#[ffm_safe]` proc macro.
/// Same contract as `#[ffm_safe]` — the canonical implementation used by both
        Ok(Err(msg)) => into_error_ptr(msg),
                "unknown panic".to_string()
    let c =
        return into_error_ptr(format!("negative string length: {}", len));
//! Convention: FFM functions return `i64`.
}
            } else {
/// Used for testing input validation (null ptr, negative len, bad UTF-8).
        }
 * compatible open source license.
    match std::str::from_utf8(bytes) {
pub unsafe extern "C" fn native_test_panic(msg_ptr: *const u8, msg_len: i64) -> i64 {
        Ok(Ok(v)) => v,
    })) {
}
                s.to_string()
                s.to_string()
        Err(panic) => {
}
        Err(e) => into_error_ptr(format!("invalid UTF-8: {}", e)),
        CString::new(msg).unwrap_or_else(|_| CString::new("error contained null byte").unwrap());
/*
        Ok(_) => 0,
 *
    into_error_ptr(msg.to_string())
    }
}
//!
/// Frees a heap-allocated error string.
/// Deliberately panics with the given message. For testing panic handling.
pub fn ffm_wrap<F>(name: &str, f: F) -> i64
    }
                s.clone()
    }
    let ptr = c.into_raw();
#[no_mangle]
    if ptr != 0 {
            };
        Ok(Ok(v)) => v,
            let msg = if let Some(s) = panic.downcast_ref::<String>() {
use std::os::raw::c_char;
/// Returns a pointer to the null-terminated error message.
//!   - `< 0`  → error. Negate to get a pointer to a heap-allocated error.
    if len < 0 {
            } else if let Some(s) = panic.downcast_ref::<&str>() {
            into_error_ptr(msg)
    }
/// Validates a string from (ptr, len). Returns 0 on valid UTF-8, error pointer on invalid input.
pub unsafe extern "C" fn native_error_message(ptr: i64) -> *const c_char {
 * SPDX-License-Identifier: Apache-2.0
