    if p.is_null() {
        }
//!
 * The OpenSearch Contributors require contributions made to
                word_count as i64,
type CollectDocsFn = unsafe extern "C" fn(i64, i32, i32, i32, *mut u64, i64) -> i64;
    /// callback isn't registered, which is always the case in unit/fuzz tests.
//! eliminating the global-singleton concurrency bug when multiple queries run in parallel.
    if p.is_null() {
pub unsafe extern "C" fn df_register_filter_tree_callbacks(
    }
        None
    }
    let key = unsafe { create(context_id, annotation_id) };
            "createProvider failed: context_id={} annotation_id={} -> {}",
        provider_key: i32,
//! The `context_id` is the per-query identifier (from `QueryTrackingContext::context_id()`)
    let p = RELEASE_PROVIDER.load(Ordering::Acquire);
    // unwinding across the FFM boundary is UB. Swallow the panic
        CREATE_PROVIDER.store(create_provider as *mut (), Ordering::Release);
        doc_max: i32,
        };
    fn drop(&mut self) {
            return Err(format!(
    let p = CREATE_COLLECTOR.load(Ordering::Acquire);
        let mut buf = vec![0u64; word_count];
    ) -> Result<CollectDocsResult, String> {
    collect_docs: CollectDocsFn,
 * compatible open source license.
    let p = COLLECT_DOCS.load(Ordering::Acquire);
    /// Test-only ctor: manufacture a handle with a chosen key without going through
        }
type CreateCollectorFn = unsafe extern "C" fn(i64, i32, i64, i32, i32) -> i32;
    let _ = std::panic::catch_unwind(std::panic::AssertUnwindSafe(|| {
static RELEASE_PROVIDER: AtomicPtr<()> = AtomicPtr::new(std::ptr::null_mut());
        if packed < 0 {
        return Err("FilterTree callbacks not registered".into());
        }
static CREATE_PROVIDER: AtomicPtr<()> = AtomicPtr::new(std::ptr::null_mut());
type ReleaseCollectorFn = unsafe extern "C" fn(i64, i32);
}
    Ok(ProviderHandle { context_id, key })
                buf.as_mut_ptr(),
    let p = RELEASE_COLLECTOR.load(Ordering::Acquire);
    } else {
        Some(unsafe { std::mem::transmute::<*mut (), ReleaseProviderFn>(p) })
/// Not annotated `#[ffm_safe]` because that macro is specific to the
    fn drop(&mut self) {
    Ok(unsafe { std::mem::transmute::<*mut (), CreateCollectorFn>(p) })
fn load_release_collector() -> Option<ReleaseCollectorFn> {
}
/// Returned from `create_provider`. Drop releases the provider.
pub struct ProviderHandle {
    }));
        None
    key: i32,
    /// the FFM `createProvider` upcall. Drop is a no-op when the FFM `releaseProvider`
    }
                max_doc,
        }
        let word_count = span.div_ceil(64);
    }
        doc_min: i32,
            next_doc,
impl Drop for ProviderHandle {
 */
        context_id: i64,
// ── FfmSegmentCollector — owns `releaseCollector` on drop ─────────────
    if p.is_null() {
use std::sync::atomic::{AtomicPtr, Ordering};
type ReleaseProviderFn = unsafe extern "C" fn(i64, i32);
//! they call the release callbacks on drop.
    let p = CREATE_PROVIDER.load(Ordering::Acquire);
}
    Ok(unsafe { std::mem::transmute::<*mut (), CollectDocsFn>(p) })
///
        Ok(CollectDocsResult {
fn load_create_provider() -> Result<CreateProviderFn, String> {
/// instead, though the body (atomic stores) can't realistically panic.
    }
        self.key
                self.context_id, self.key, packed
//!
}
    #[cfg(test)]
                words: Vec::new(),
    release_collector: ReleaseCollectorFn,
#[no_mangle]
                "collectDocs(context_id={}, key={}) failed: {}",
/// `context_id` routes the upcall to the correct per-query Java handle.
    let create = load_create_provider()?;
    }
// ── Callback signatures ───────────────────────────────────────────────
//! - `collectDocs(contextId, collectorKey, minDoc, maxDoc, outBuf, outWordCap) -> wordsWritten|-1`
}
// ── ProviderHandle — owns `releaseProvider` on drop ───────────────────
#[derive(Debug)]
        RELEASE_PROVIDER.store(release_provider as *mut (), Ordering::Release);
        let next_doc = (packed_u >> 32) as i32;
                context_id, provider_key, writer_generation, key
            words: buf,
//! - `createCollector(contextId, providerKey, writerGeneration, minDoc, maxDoc) -> collectorKey|-1`
        if let Some(release) = load_release_collector() {
            )
//!
/// `(context_id, provider_key, writer_generation, doc_min, doc_max) -> collector_key | -1`.
            )
        return Err("FilterTree callbacks not registered".into());
            collect_fn(
    pub fn key(&self) -> i32 {
        max_doc: i32,
            context_id, annotation_id, key
        return Err(format!(
fn load_release_provider() -> Option<ReleaseProviderFn> {
//! - `releaseProvider(contextId, providerKey)`
    key: i32,
            });
/// `writer_generation` is the stable per-segment identifier.
static RELEASE_COLLECTOR: AtomicPtr<()> = AtomicPtr::new(std::ptr::null_mut());
pub fn create_provider(context_id: i64, annotation_id: i32) -> Result<ProviderHandle, String> {
    pub fn new_for_test(key: i32) -> Self {
        writer_generation: i64,
static COLLECT_DOCS: AtomicPtr<()> = AtomicPtr::new(std::ptr::null_mut());
    }
 *
    }
    }
                self.context_id, self.key, words_written, word_count,
                 callback contract violated (possible heap overflow)",
    /// `writer_generation` identifies the segment.
    if p.is_null() {
        ));
                context_id,
/// `-> i64` error-pointer convention. We use a manual `catch_unwind`
}
        let words_written = (packed_u & 0xFFFF_FFFF) as usize;
}
/// `context_id` is the per-query identifier used by Java to route this upcall
        Some(unsafe { std::mem::transmute::<*mut (), ReleaseCollectorFn>(p) })
fn load_collect_docs() -> Result<CollectDocsFn, String> {
                doc_max,
            ));
}
//! `ProviderHandle` and `FfmSegmentCollector` are the lifetime wrappers —
            .field("key", &self.key)
    Ok(unsafe { std::mem::transmute::<*mut (), CreateProviderFn>(p) })
    /// to the correct per-query `FilterDelegationHandle`.
            return Ok(CollectDocsResult {
                provider_key,
    if p.is_null() {
        &self,
    // but if they ever did (e.g. allocator OOM if we grew the atomics),
            unsafe { release(self.context_id, self.key) };
    pub fn create(
//! `df_register_filter_tree_callbacks` (see `ffm.rs`):
impl RowGroupDocsCollector for FfmSegmentCollector {
    }
        buf.truncate(words_written);
        })
}
pub struct FfmSegmentCollector {
type CreateProviderFn = unsafe extern "C" fn(i64, i32) -> i32;
        let create = load_create_collector()?;
    ///
        f.debug_struct("ProviderHandle")
//!
static CREATE_COLLECTOR: AtomicPtr<()> = AtomicPtr::new(std::ptr::null_mut());
            create(
        };
}
    fn collect_packed_u64_bitset(
/// Registered by Java at startup. Stores function pointers into atomic
        COLLECT_DOCS.store(collect_docs as *mut (), Ordering::Release);
            ));
                self.key,
    /// Ask Java for a collector keyed by `provider_key` for the given segment/doc range.
        CREATE_COLLECTOR.store(create_collector as *mut (), Ordering::Release);
        Ok(FfmSegmentCollector { context_id, key })
        return Err("FilterTree callbacks not registered".into());
}
//! - `releaseCollector(contextId, collectorKey)`
        min_doc: i32,
            return Err(format!(
 * this file be licensed under the Apache-2.0 license or a
        if let Some(release) = load_release_provider() {
//! - `createProvider(contextId, annotationId) -> providerKey|-1`
    create_collector: CreateCollectorFn,
    context_id: i64,
        let collect_fn = load_collect_docs()?;
    /// `context_id` is the per-query identifier used by Java to route this upcall
        let packed_u = packed as u64;
        if words_written > word_count {
        if max_doc <= min_doc {
    release_provider: ReleaseProviderFn,
        RELEASE_COLLECTOR.store(release_collector as *mut (), Ordering::Release);
use super::index::{CollectDocsResult, RowGroupDocsCollector};
    }
/*
        let span = (max_doc - min_doc) as usize;
                min_doc,
            ));
        let packed = unsafe {
/// Create a provider by annotation ID by upcalling Java.
/// to the correct per-query `FilterDelegationHandle`.
                "collectDocs(context_id={}, key={}) reported wordsWritten={} > capacity={}; \
    // silently — there's no way to report it back to Java for a
                next_doc: i32::MAX,
    ) -> Result<Self, String> {
                doc_min,
}
                writer_generation,
    create_provider: CreateProviderFn,
///
) {
    // `-> ()` function.
            .field("context_id", &self.context_id)
        }
    if key < 0 {
impl ProviderHandle {
        ProviderHandle { context_id: 0, key }
}
        let key = unsafe {
//! FFM upcall surface for index-filter providers and collectors.
//! that Java uses to route each callback to the correct per-query handle and tracker,
    // catch_unwind is defense-in-depth: atomic stores shouldn't panic,
                "createCollector(context_id={}, provider={}, writer_generation={}) failed: {}",
}
                self.context_id,
///
//! Five callback slots, populated once at startup by
}
impl FfmSegmentCollector {
 * SPDX-License-Identifier: Apache-2.0
    context_id: i64,
        }
    } else {
impl std::fmt::Debug for ProviderHandle {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
    }
            .finish()
impl Drop for FfmSegmentCollector {
    }
            unsafe { release(self.context_id, self.key) };
/// slots. Each call to this entry replaces the slots wholesale.
        if key < 0 {
fn load_create_collector() -> Result<CreateCollectorFn, String> {
            return Err(format!(
