/// do not include profiling support.
/// With `prof_active:false`, profiling infrastructure is initialized but **inactive** —
//
// ═══════════════════════════════════════════════════════════════════════════════
 * compatible open source license.
/// set by the Gradle buildRustLibrary task (release builds only) and the `profiling`
///   is re-applied by NativeBridgeModule.createComponents() — these compile-time values are
///   process start and OpenSearch initialization. On restart, the persisted cluster setting
#[export_name = "malloc_conf"]
//   3. All #[no_mangle] extern "C" functions from the plugin crates are
///   1. prof:true is init-time only — cannot be enabled after process start
 */
extern crate opensearch_repository_s3;
/// `prof:true` is baked into jemalloc at compile time via JEMALLOC_SYS_WITH_MALLOC_CONF
/// NOTE on heap profiling:
/// jemalloc tuning applied at process start (before JVM/OpenSearch boots):
extern crate native_bridge_common;
/// feature on tikv-jemallocator. This is required because:
 *
// Pull in plugin rlibs — forces linker to include all #[no_mangle] symbols.
///   (see NativeBridgeModule). The values here serve as defaults for the brief window between
// This crate:
extern crate opensearch_datafusion;
 * SPDX-License-Identifier: Apache-2.0
///   2. The malloc_conf symbol is not read by jemalloc for dlopen'd libraries
#[global_allocator]
extern crate opensearch_repository_azure;
/// - dirty_decay_ms and muzzy_decay_ms: also dynamically tunable at runtime via cluster settings
///   only used until that point.
// ═══════════════════════════════════════════════════════════════════════════════
extern crate opensearch_repository_gcs;
///
pub static MALLOC_CONF: &[u8] = b"dirty_decay_ms:30000,muzzy_decay_ms:30000,lg_tcache_max:16\0";
extern crate opensearch_parquet_format;
extern crate opensearch_tiered_storage;
// Single cdylib for JDK FFM (Foreign Function & Memory API).
/// zero CPU overhead and negligible memory overhead. Profiling is activated on-demand
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
///
/*
static GLOBAL: tikv_jemallocator::Jemalloc = tikv_jemallocator::Jemalloc;
//      automatically available for dlsym/SymbolLookup
/// - lg_tcache_max: NOT dynamically tunable by jemalloc — init-time only, requires process restart to change.
//   2. Pulls in plugin rlibs via extern crate (forces linker to include symbols)
extern crate opensearch_repository_fs;
/// via cluster settings at runtime. Dev/test builds (cargo build without --release)
//   1. Sets the global jemalloc allocator (shared across all plugin rlibs)
