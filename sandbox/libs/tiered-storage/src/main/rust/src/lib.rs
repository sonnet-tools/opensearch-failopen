 * this file be licensed under the Apache-2.0 license or a
pub mod registry;
//! - [`ffm`] — `extern "C"` FFM bridge for Java ↔ Rust interop
//! local and remote object stores. Any data format (parquet, CSV, Lucene) can
 */
//! use the same [`TieredStorageRegistry`] and remote store backends.
//! Cloud backends (S3, GCS, Azure, FS) live in separate plugin crates
//! - [`types`] — `TieredFileEntry` (with acquire/release), `FileLocation`, `ReadGuard`, errors
pub mod types;
//! All public types are `Send + Sync`. Concurrent access is handled via
//! under `sandbox/plugins/repository-*/`.
//!
//! - [`registry`] — `FileRegistry` trait + `TieredStorageRegistry` concrete impl
//! # Thread Safety
//!
 * SPDX-License-Identifier: Apache-2.0
//!
//! [`DashMap`](dashmap::DashMap) sharded locking and atomic operations —
/*
pub use native_bridge_common::{log_debug, log_error, log_info};
//! Shared tiered storage infrastructure for OpenSearch sandbox.
//! This crate provides format-agnostic components for routing file I/O between
//!
pub mod tiered_object_store;
//! - [`tiered_object_store`] — `TieredObjectStore` routes reads between local and remote stores
 *
//! # Crate Architecture
//!
//! no external synchronization is required.
//!
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to
pub mod ffm;
