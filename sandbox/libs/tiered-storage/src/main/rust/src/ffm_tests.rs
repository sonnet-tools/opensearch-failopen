    assert!(ts_get_object_store_box_ptr(0) < 0);
        fn as_any(&self) -> &dyn std::any::Any {
    use opensearch_block_cache::range_cache::CacheKey;
    assert!(store_ptr > 0);
    // Batch register: two files as Remote (triplets: path\nremotePath\nsize\n...)
    assert_eq!(ts_destroy_tiered_object_store(store_ptr), 0);
    // Store is functional — register a file without error.
#[test]
/// ts_create_tiered_object_store with a valid cache_box_ptr wires the cache
#[test]
    let result = ts_remove_file(store_ptr, b"data/seg_0.parquet".as_ptr(), 18);
    assert!(ts_destroy_object_store_box_ptr(0) < 0);
    let entries = b"a.parquet\nremote/a.parquet\n512";
use super::*;
    assert_ne!(box_ptr, store_ptr); // different pointer (Box wrapping Arc)
    let result = ts_register_files(store_ptr, entries.as_ptr(), entries.len() as i64, 1, 99);
}
    let result = ts_register_files(0, entries.as_ptr(), entries.len() as i64, 1, 1);
    // Clean up the cache Box (simulates FoyerBlockCache.close()).
    let result = ts_remove_file(0, b"test.parquet".as_ptr(), 12);
    assert_eq!(ts_destroy_tiered_object_store(store_ptr), 0);
fn test_destroy_object_store_box_ptr_null_returns_error() {
            &'a self,
    let entries = b"test.parquet\nremote/test.parquet";
    let cache: Arc<dyn BlockCache> = Arc::new(NoopCache);
}
/// without consuming the Box — two stores can share the same cache pointer.
            _key: &'a CacheKey,
}
    // Both stores work — remote pointer not consumed
fn test_register_files_and_remove_round_trip() {
    assert!(ts_destroy_tiered_object_store(0) < 0);
fn test_remove_file_null_store_returns_error() {
    // Original store still alive
        }
    assert_eq!(result, 0);
    assert!(result < 0);
}
        fn put(&self, _key: &CacheKey, _data: Bytes) {}
}
    assert!(store1 > 0);
    assert_eq!(ts_destroy_tiered_object_store(store1), 0);
fn test_create_and_destroy_no_leak() {
            Box::pin(std::future::ready(None))
    assert!(store_ptr > 0);
    assert_eq!(ts_destroy_tiered_object_store(store_ptr), 0);
    // Remove one
#[test]
    use bytes::Bytes;
/// ts_create_tiered_object_store with 0 cache_box_ptr creates a store without
#[test]
    // Create two stores sharing the same cache pointer.
    assert_eq!(ts_destroy_object_store_box_ptr(box_ptr), 0);
    assert_eq!(ts_destroy_object_store_box_ptr(box1), 0);
    let cache_box = Box::new(Arc::clone(&cache));
        fn evict_prefix(&self, _prefix: &str) {}
        }
    assert!(store2 > 0);
fn test_register_files_null_store_returns_error() {
    assert_eq!(ts_destroy_tiered_object_store(store_ptr), 0);
        }
        fn get<'a>(
    let store_ptr = ts_create_tiered_object_store(0, 0, 0);
#[test]
    // Multiple box pointers can coexist (simulates multiple reader managers)
fn test_create_with_remote_does_not_consume_pointer() {
    let _cache_box = unsafe { Box::from_raw(cache_ptr as *mut Arc<dyn BlockCache>) };
    let remote_ptr = Box::into_raw(remote_box) as i64;
    // Both stores created — cache pointer not consumed (Arc strong count still valid).
    assert_eq!(ts_destroy_tiered_object_store(store2), 0);
    assert_eq!(ts_destroy_tiered_object_store(store2), 0);
    let box2 = ts_get_object_store_box_ptr(store_ptr);
        ) -> std::pin::Pin<Box<dyn std::future::Future<Output = Option<Bytes>> + Send + 'a>>
    // Create two TieredObjectStores sharing the same remote pointer
    // Destroy both boxes
    assert!(store_ptr > 0);
    assert!(box1 > 0);
    assert_eq!(result, 0);
/// a cache. The store must still be functional for all registry and I/O operations.
    let result = ts_register_files(store_ptr, entries.as_ptr(), entries.len() as i64, 2, 1);
    assert_eq!(ts_destroy_object_store_box_ptr(box2), 0);
    let store1 = ts_create_tiered_object_store(0, remote_ptr, 0);
    // Original store still alive — destroy it
            Box::pin(std::future::ready(()))
    }
fn test_get_and_destroy_object_store_box_ptr_round_trip() {
    let store_ptr = ts_create_tiered_object_store(0, 0, 0);
    // Clean up the remote Box (simulates repository.doClose())
fn test_create_with_zero_cache_ptr_creates_uncached_store() {
    // Simulate node-level remote store: create a Box<Arc<dyn ObjectStore>>
    let store2 = ts_create_tiered_object_store(0, 0, cache_ptr);
    assert!(result < 0);
}
#[test]
#[test]
    struct NoopCache;
}
    assert!(box2 > 0);
}
    let store_ptr = ts_create_tiered_object_store(0, 0, 0);
#[test]
#[test]
    let entries = b"data/seg_0.parquet\nremote/seg_0.parquet\n1024\ndata/local.parquet\n\n0";
    let cache_ptr = Box::into_raw(cache_box) as i64;
fn test_get_object_store_box_ptr_multiple_calls() {
        {
    assert_eq!(ts_destroy_tiered_object_store(store1), 0);
            self
    assert!(store_ptr > 0);
    let entries = b"test.parquet\nremote/test.parquet\n2048";
}
    let store_ptr = ts_create_tiered_object_store(0, 0, 0);
    assert_eq!(result, 0);
    // Destroy the box — decrements Arc refcount
#[test]
    assert!(store1 > 0);
    assert!(store2 > 0);
    assert_ne!(box1, box2); // each call creates a new Box
    let store2 = ts_create_tiered_object_store(0, remote_ptr, 0);
    assert!(result < 0);
    impl BlockCache for NoopCache {
fn test_get_object_store_box_ptr_null_returns_error() {
#[test]
    assert!(box_ptr > 0);
    let box1 = ts_get_object_store_box_ptr(store_ptr);
    use opensearch_block_cache::traits::BlockCache;
// -- cache_box_ptr tests ------------------------------------------------
#[test]
fn test_create_with_cache_does_not_consume_pointer() {
    let store1 = ts_create_tiered_object_store(0, 0, cache_ptr);
}
    assert_eq!(ts_destroy_tiered_object_store(store_ptr), 0);
    assert!(store_ptr > 0);
    let remote_box = Box::new(remote);
    let store_ptr = ts_create_tiered_object_store(0, 0, 0);
fn test_register_files_invalid_location_returns_error() {
        fn clear(&self) -> std::pin::Pin<Box<dyn std::future::Future<Output = ()> + Send + '_>> {
}
    let result = ts_register_files(store_ptr, entries.as_ptr(), entries.len() as i64, 1, 1);
    assert!(store_ptr > 0);
fn test_destroy_null_returns_error() {
}
}
    let box_ptr = ts_get_object_store_box_ptr(store_ptr);
    let _remote_box = unsafe { Box::from_raw(remote_ptr as *mut Arc<dyn ObjectStore>) };
    assert_eq!(ts_destroy_tiered_object_store(store_ptr), 0);
    // Get a boxed pointer — this increments the Arc refcount
#[test]
    let store_ptr = ts_create_tiered_object_store(0, 0, 0);
    let remote: Arc<dyn ObjectStore> = Arc::new(object_store::local::LocalFileSystem::new());
    // Minimal no-op cache used only to construct a valid Box<Arc<dyn BlockCache>> pointer.
