/*
//! Shared Rust utilities for OpenSearch sandbox native plugins.
 * compatible open source license.
pub mod allocator;
pub mod logger;
pub use native_bridge_macros::ffm_safe;
pub mod io_runtime;
// Re-export the proc macro so plugins use `#[native_bridge_common::ffm_safe]`
 *
 */
pub mod error;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
pub mod memory_pool;
