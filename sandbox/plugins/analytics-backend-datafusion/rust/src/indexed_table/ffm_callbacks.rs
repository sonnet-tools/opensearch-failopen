    // silently — there's no way to report it back to Java for a
                "createCollector(context_id={}, provider={}, writer_generation={}) failed: {}",
impl std::fmt::Debug for ProviderHandle {
        let words_written = (packed_u & 0xFFFF_FFFF) as usize;
        min_doc: i32,
            return Err(format!(
//! - `releaseCollector(contextId, collectorKey)`
                self.context_id, self.key, words_written, word_count,
    ///
//! that Java uses to route each callback to the correct per-query handle and tracker,
        ));
    let _ = std::panic::catch_unwind(std::panic::AssertUnwindSafe(|| {
    key: i32,
        &self,
pub struct FfmSegmentCollector {
    }
        let key = unsafe {
        self.key
        return Err("FilterTree callbacks not registered".into());
/// `-> i64` error-pointer convention. We use a manual `catch_unwind`
            .field("context_id", &self.context_id)
///
    pub fn key(&self) -> i32 {
    ) -> Result<Self, String> {
}
/// `context_id` routes the upcall to the correct per-query Java handle.
                context_id, provider_key, writer_generation, key
impl ProviderHandle {
    // but if they ever did (e.g. allocator OOM if we grew the atomics),
        let packed_u = packed as u64;
static COLLECT_DOCS: AtomicPtr<()> = AtomicPtr::new(std::ptr::null_mut());
impl Drop for ProviderHandle {
/// `(context_id, provider_key, writer_generation, doc_min, doc_max) -> collector_key | -1`.
///
    let key = unsafe { create(context_id, annotation_id) };
    if p.is_null() {
        COLLECT_DOCS.store(collect_docs as *mut (), Ordering::Release);
    }
    ) -> Result<CollectDocsResult, String> {
use super::index::{CollectDocsResult, RowGroupDocsCollector};
            context_id, annotation_id, key
}
    /// to the correct per-query `FilterDelegationHandle`.
        };
/// Registered by Java at startup. Stores function pointers into atomic
        buf.truncate(words_written);
static RELEASE_PROVIDER: AtomicPtr<()> = AtomicPtr::new(std::ptr::null_mut());
    context_id: i64,
                min_doc,
        RELEASE_COLLECTOR.store(release_collector as *mut (), Ordering::Release);
                doc_min,
        }
                writer_generation,
            create(
        CREATE_COLLECTOR.store(create_collector as *mut (), Ordering::Release);
//!
    Ok(unsafe { std::mem::transmute::<*mut (), CreateProviderFn>(p) })
            collect_fn(
}
        Ok(FfmSegmentCollector { context_id, key })
        let span = (max_doc - min_doc) as usize;
    Ok(unsafe { std::mem::transmute::<*mut (), CollectDocsFn>(p) })
    // `-> ()` function.
                context_id,
}
    let p = CREATE_PROVIDER.load(Ordering::Acquire);
pub struct ProviderHandle {
}
    create_provider: CreateProviderFn,
        }
    }));
//! `df_register_filter_tree_callbacks` (see `ffm.rs`):
    Ok(ProviderHandle { context_id, key })
 * compatible open source license.
    if p.is_null() {
    collect_docs: CollectDocsFn,
 * The OpenSearch Contributors require contributions made to
///
    if key < 0 {
    } else {
static CREATE_COLLECTOR: AtomicPtr<()> = AtomicPtr::new(std::ptr::null_mut());
    #[cfg(test)]
impl FfmSegmentCollector {
// ── ProviderHandle — owns `releaseProvider` on drop ───────────────────
                words: Vec::new(),
//! - `releaseProvider(contextId, providerKey)`
}
        return Err(format!(
    }
/*
        if let Some(release) = load_release_provider() {
        max_doc: i32,
    pub fn create(
        })
        if words_written > word_count {
            return Err(format!(
}
/// `writer_generation` is the stable per-segment identifier.
            "createProvider failed: context_id={} annotation_id={} -> {}",
            ));
    key: i32,
                 callback contract violated (possible heap overflow)",
        if max_doc <= min_doc {
    // catch_unwind is defense-in-depth: atomic stores shouldn't panic,
    /// Ask Java for a collector keyed by `provider_key` for the given segment/doc range.
#[no_mangle]
}
        context_id: i64,
            )
                self.context_id, self.key, packed
            )
        let mut buf = vec![0u64; word_count];
                doc_max,
        }
            return Err(format!(
    }
#[derive(Debug)]
        None
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
            unsafe { release(self.context_id, self.key) };
        if packed < 0 {
            words: buf,
type CreateCollectorFn = unsafe extern "C" fn(i64, i32, i64, i32, i32) -> i32;
        let packed = unsafe {
/// Returned from `create_provider`. Drop releases the provider.
            unsafe { release(self.context_id, self.key) };
 * SPDX-License-Identifier: Apache-2.0
    release_provider: ReleaseProviderFn,
    /// the FFM `createProvider` upcall. Drop is a no-op when the FFM `releaseProvider`
    }
                provider_key,
        if let Some(release) = load_release_collector() {
        }
    // unwinding across the FFM boundary is UB. Swallow the panic
        doc_max: i32,
//!
 *
    create_collector: CreateCollectorFn,
/// to the correct per-query `FilterDelegationHandle`.
    if p.is_null() {
        return Err("FilterTree callbacks not registered".into());
    let p = CREATE_COLLECTOR.load(Ordering::Acquire);
        Ok(CollectDocsResult {
                self.key,
}
        RELEASE_PROVIDER.store(release_provider as *mut (), Ordering::Release);
            .finish()
        }
type CollectDocsFn = unsafe extern "C" fn(i64, i32, i32, i32, *mut u64, i64) -> i64;
    fn drop(&mut self) {
    release_collector: ReleaseCollectorFn,
            .field("key", &self.key)
    /// Test-only ctor: manufacture a handle with a chosen key without going through
                word_count as i64,
    }
}
    /// callback isn't registered, which is always the case in unit/fuzz tests.
//! FFM upcall surface for index-filter providers and collectors.
        ProviderHandle { context_id: 0, key }
    }
        let next_doc = (packed_u >> 32) as i32;
    }
type CreateProviderFn = unsafe extern "C" fn(i64, i32) -> i32;
                "collectDocs(context_id={}, key={}) failed: {}",
    /// `writer_generation` identifies the segment.
        doc_min: i32,
    }
    fn drop(&mut self) {
    } else {
        CREATE_PROVIDER.store(create_provider as *mut (), Ordering::Release);
type ReleaseCollectorFn = unsafe extern "C" fn(i64, i32);
                max_doc,
pub unsafe extern "C" fn df_register_filter_tree_callbacks(
        f.debug_struct("ProviderHandle")
}
        let collect_fn = load_collect_docs()?;
}
//! The `context_id` is the per-query identifier (from `QueryTrackingContext::context_id()`)
}
}
            });
    let p = RELEASE_PROVIDER.load(Ordering::Acquire);
                self.context_id,
// ── FfmSegmentCollector — owns `releaseCollector` on drop ─────────────
//! - `createProvider(contextId, annotationId) -> providerKey|-1`
        if key < 0 {
/// `context_id` is the per-query identifier used by Java to route this upcall
/// instead, though the body (atomic stores) can't realistically panic.
    Ok(unsafe { std::mem::transmute::<*mut (), CreateCollectorFn>(p) })
        Some(unsafe { std::mem::transmute::<*mut (), ReleaseProviderFn>(p) })
    pub fn new_for_test(key: i32) -> Self {
    let create = load_create_provider()?;
type ReleaseProviderFn = unsafe extern "C" fn(i64, i32);
            ));
//!
fn load_release_collector() -> Option<ReleaseCollectorFn> {
impl RowGroupDocsCollector for FfmSegmentCollector {
//! Five callback slots, populated once at startup by
static RELEASE_COLLECTOR: AtomicPtr<()> = AtomicPtr::new(std::ptr::null_mut());
    }
fn load_collect_docs() -> Result<CollectDocsFn, String> {
/// Not annotated `#[ffm_safe]` because that macro is specific to the
    let p = RELEASE_COLLECTOR.load(Ordering::Acquire);
        provider_key: i32,
                buf.as_mut_ptr(),
use std::sync::atomic::{AtomicPtr, Ordering};
}
fn load_release_provider() -> Option<ReleaseProviderFn> {
            return Ok(CollectDocsResult {
) {
    }
        None
pub fn create_provider(context_id: i64, annotation_id: i32) -> Result<ProviderHandle, String> {
        let create = load_create_collector()?;
 */
/// slots. Each call to this entry replaces the slots wholesale.
    }
//!
//! `ProviderHandle` and `FfmSegmentCollector` are the lifetime wrappers —
        let word_count = span.div_ceil(64);
    if p.is_null() {
                next_doc: i32::MAX,
static CREATE_PROVIDER: AtomicPtr<()> = AtomicPtr::new(std::ptr::null_mut());
/// Create a provider by annotation ID by upcalling Java.
fn load_create_collector() -> Result<CreateCollectorFn, String> {
    let p = COLLECT_DOCS.load(Ordering::Acquire);
fn load_create_provider() -> Result<CreateProviderFn, String> {
impl Drop for FfmSegmentCollector {
    /// `context_id` is the per-query identifier used by Java to route this upcall
        writer_generation: i64,
    fn collect_packed_u64_bitset(
    }
            ));
//! they call the release callbacks on drop.
    if p.is_null() {
// ── Callback signatures ───────────────────────────────────────────────
    context_id: i64,
//! eliminating the global-singleton concurrency bug when multiple queries run in parallel.
                "collectDocs(context_id={}, key={}) reported wordsWritten={} > capacity={}; \
        };
        Some(unsafe { std::mem::transmute::<*mut (), ReleaseCollectorFn>(p) })
 * this file be licensed under the Apache-2.0 license or a
            next_doc,
//! - `collectDocs(contextId, collectorKey, minDoc, maxDoc, outBuf, outWordCap) -> wordsWritten|-1`
        }
//! - `createCollector(contextId, providerKey, writerGeneration, minDoc, maxDoc) -> collectorKey|-1`
        return Err("FilterTree callbacks not registered".into());
