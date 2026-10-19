    ($($arg:tt)*) => {
    log(LogLevel::Info, "Native logger initialized successfully");
        }
macro_rules! log_error {
pub fn log(level: LogLevel, message: &str) {
#[macro_export]
    (level as i32) >= MAX_LEVEL.load(Ordering::Relaxed)
#[no_mangle]
#[no_mangle]
    Debug = 0,
 */
/// so `log_debug!` is suppressed until Java enables DEBUG.
static MAX_LEVEL: AtomicI32 = AtomicI32::new(LogLevel::Info as i32);
#[inline]
        return;
/*
/// Set the minimum forwarded log level. Called by Java at init and whenever the
 * this file be licensed under the Apache-2.0 license or a
    MAX_LEVEL.store(clamped, Ordering::Relaxed);
//! Rust calls that pointer to log. No JNI.
use std::sync::atomic::{AtomicI32, AtomicPtr, Ordering};
/// logger level changes dynamically.
}
/// Minimum level that will be formatted + forwarded to Java. Defaults to Info
 *
    if ptr.is_null() {
}
}
        }
    ($($arg:tt)*) => {
    };
/// Callback signature: `void log(int level, const char* msg, long msg_len)`
//! Level short-circuit: the `log_debug!`/`log_info!` macros gate on a Rust-side
//!
//! this atomic in sync via `native_logger_set_level`.
        eprintln!("[RUST_LOG_FALLBACK] {:?}: {}", level, message);
    ($($arg:tt)*) => {
        }
    let clamped = level.clamp(LogLevel::Debug as i32, LogLevel::Error as i32);
 * compatible open source license.
        if $crate::logger::enabled($crate::logger::LogLevel::Debug) {
 * The OpenSearch Contributors require contributions made to
type LogCallback = unsafe extern "C" fn(i32, *const u8, i64);
    let callback: LogCallback = unsafe { std::mem::transmute(ptr) };
    }
pub fn enabled(level: LogLevel) -> bool {
//! atomic level BEFORE `format!`, so a suppressed log costs only one relaxed
    LOG_CALLBACK.store(callback as *mut (), Ordering::Release);
#[macro_export]
#[repr(i32)]
macro_rules! log_info {
/// True if a message at `level` would be emitted. Cheap (one relaxed load).
        if $crate::logger::enabled($crate::logger::LogLevel::Error) {
#[macro_export]
            $crate::logger::log($crate::logger::LogLevel::Debug, &format!($($arg)*))
}
        if $crate::logger::enabled($crate::logger::LogLevel::Info) {
//! atomic load + branch — no string allocation, no FFM crossing. Java keeps
}
macro_rules! log_debug {
pub unsafe extern "C" fn native_logger_init(callback: LogCallback) {
//!
    unsafe { callback(level as i32, message.as_ptr(), message.len() as i64) };
            $crate::logger::log($crate::logger::LogLevel::Error, &format!($($arg)*))
}
//! Rust→Java logging via FFM callback.
    Error = 2,
//! Java registers a function pointer at startup via `native_logger_init`.
    let ptr = LOG_CALLBACK.load(Ordering::Acquire);
}
            $crate::logger::log($crate::logger::LogLevel::Info, &format!($($arg)*))
static LOG_CALLBACK: AtomicPtr<()> = AtomicPtr::new(std::ptr::null_mut());
    };
#[derive(Debug, Clone, Copy, PartialEq, Eq)]
    Info = 1,
    };
 * SPDX-License-Identifier: Apache-2.0
pub enum LogLevel {
pub extern "C" fn native_logger_set_level(level: i32) {
/// Called by Java at startup to register the log callback.
}
