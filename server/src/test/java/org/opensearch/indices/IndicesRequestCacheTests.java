            IndexShard indexShard = indexShardList.get(i);
                } catch (IndexNotFoundException ex) {
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        termQuery = new TermQueryBuilder("id", "bar");
        IOUtils.close(reader, secondReader, thirdReader, environment);  
            assertEquals(--staleCount, cache.cacheCleanupManager.getStaleKeysCount().get());
                    }  
import static org.opensearch.indices.IndicesRequestCache.INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING;  
        // Get 2 entries into the cache from 2 different readers
        cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());
            }
            DirectoryReader reader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), indexShard.shardId());
        threadPool = getThreadPool();
        BytesReference value = cache.getOrCompute(cacheEntity, loader, reader, getTermBytes());  
            RequestCacheStats stats = entity.stats().stats();  
                            // Accessing the map to create contention  
    }
        assertEquals("baz", value3.streamInput().readString());
        cache.cacheCleanupManager.cleanCache();  
        DirectoryReader secondReader = getReader(writer, indexShard.shardId());
        assertFalse(cleanupKeyToCountMap.get(shardId).containsKey(getReaderCacheKeyId(reader)));
        DirectoryReader reader = getReader(writer, indexShard.shardId());
    private IndicesRequestCache cache;
    }
import java.util.concurrent.atomic.AtomicReference;  
        // initial cache  
            this.reader = reader;  
        IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig());  
        cache.getOrCompute(getEntity(indexShard), getLoader(readerA1), readerA1, getTermBytes());
    private String getReaderCacheKeyId(DirectoryReader reader) {
     * search request. This test fails if the sweep iterates the live LRU view of the on-heap cache's keys
    public void testCacheCleanupBasedOnStaleThreshold_thresholdUpdate() throws Exception {  
        terminate(threadPool);  
        DirectoryReader reader = getReader(writer, indexShard.shardId());
        assertEquals(0, cache.count());
        IOUtils.close(secondReader);
                .build()
        assertWarnings(
import java.util.concurrent.TimeUnit;  
        assertEquals(0, requestCacheStats.stats().getEvictions());
    // when staleness count less than the stale threshold, stale keys should NOT be cleaned up.  
        public int length() {  
        assertEquals(2, cache.count());
        IOUtils.close(secondReader);
        writer.updateDocument(new Term("id", "0"), newDoc(0, "bar"));
        );
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);  
    }
            )  
                    termBytes = XContentHelper.toXContent(termQuery, MediaTypeRegistry.JSON, false);
        DirectoryReader readerB1 = getReader(writer, secondShard.shardId());  
            .updateUnassigned(unassignedInfo, RecoverySource.EmptyStoreRecoverySource.INSTANCE);
        // third has not been validated since it's a different identity
        // test the mappings
            )
        IOUtils.close(secondReader);
/*
        DirectoryReader readerA1 = getReader(writer, indexShard.shardId());
                List<String> dimensionValues = List.of(shardId.getIndexName(), shardId.toString());
            new RemovalNotification<ICacheKey<IndicesRequestCache.Key>, BytesReference>(
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "51%").build();
        assertTrue(loader.loadedFromCache);
        when(indexShard.state()).thenReturn(IndexShardState.STARTED);
                    throw new RuntimeException(e);  
        cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());
            int finalI = i;  
        for (List<String> dimensionValues : initialDimensionValues) {  
        writer = new IndexWriter(dir, newIndexWriterConfig());
import org.opensearch.index.IndexNotFoundException;
    public void setup() throws IOException {  
        assertEquals("foo", value.streamInput().readString());  
        // cleanup should have been ignored
        ConcurrentHashMap<ShardId, ConcurrentHashMap<String, Integer>> cleanupKeyToCountMap = cache.cacheCleanupManager  
    // when staleness count is higher than stale threshold, stale keys should be cleaned up.  
        cache = getIndicesRequestCache(settings);
                try {  
        TermQueryBuilder termQuery = new TermQueryBuilder(fieldName, value);  
            indexShard.shardId(),
            indexShard.hashCode()
            numberOfThreads * numberOfIterations,
        cache.invalidateAll();
        DirectoryReader secondReader = getReader(writer, indexShard.shardId());  
 * this file be licensed under the Apache-2.0 license or a
        // Check resulting stats
    // when a cache entry that is NOT Stale is evicted for any reason, staleness count should NOT be deducted
import org.opensearch.core.xcontent.XContentHelper;
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());
                assertNotNull(snapshot);
        cache.cacheCleanupManager.cleanCache();
        String[] levels = { INDEX_DIMENSION_NAME, SHARD_ID_DIMENSION_NAME };  
import org.apache.lucene.search.TopDocs;
 * KIND, either express or implied.  See the License for the
                    hook.run();
        requestCacheStats = entity.stats();
        // Cache some values for indexShard  
        cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());
        assertEquals("foo", value.streamInput().readString());
            localNode,
        assertEquals(0, cache.count());  
                threadPool,
        List<DirectoryReader> readersToKeep = new ArrayList<>();  
        ;
        );
        threadPool = getThreadPool();
    private class TestBytesReference extends AbstractBytesReference {
                try {
import static org.opensearch.indices.IndicesRequestCache.INDEX_DIMENSION_NAME;
import org.opensearch.index.seqno.RetentionLeaseSyncer;
        int staleCount = cache.cacheCleanupManager.getStaleKeysCount().get();
                    readerB1,
        // 1 out of 2 keys ie 50% are now stale.
        entity = new IndicesService.IndexShardCacheEntity(indexShard);
 * not use this file except in compliance with the License.
        for (int i = 0; i < numberOfIndices; i++) {  
import org.opensearch.cluster.node.DiscoveryNodes;
        IndicesService.IndexShardCacheEntity shardCacheEntity = new IndicesService.IndexShardCacheEntity(indexShard);
    }  
        IOUtils.close(secondReader);  
        String indexToKeepName = "test";
        assertEquals(1, cache.count());
    }
    public void testCacheCleanupBasedOnStaleThreshold_StalenessLesserThanThreshold() throws Exception {
        // This actually closes the shards associated with the readers, which is necessary for cache cleanup logic
        IndicesRequestCache.Key key1 = new IndicesRequestCache.Key(shardId, new TestBytesReference(1), rKey1, shardId.hashCode());  
        }  
        String indexToCloseName = "test2";
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());  
            writerMap.put(indexShard, writer);
        }
        threadPool = getThreadPool();
        loader = new Loader(reader, 0);  
            executorService.submit(() -> {
            (shardId -> Optional.of(new IndicesService.IndexShardCacheEntity(indexShard))),  
        for (int i = 0; i < numberOfThreads; i++) {  
            newField("id", Integer.toString(id), StringField.TYPE_STORED),
            // For the purposes of this test it doesn't matter if the node environment matches the one used in the constructor  
            } catch (IOException e) {
    public Iterable<Field> newDoc(int id, String value) {  
                new ICacheKey<>(key),
 * The OpenSearch Contributors require contributions made to  
        assertEquals(2, cache.count());  
        // cache hit  
        BytesReference value1 = cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());  
        assertTrue(cleanupKeyToCountMap.get(shardId).containsKey(getReaderCacheKeyId(secondReader)));  
                // check the values are not empty by confirming entries != 0, this should always be true since the missed value is loaded  
    public void testCleanCacheIsNotDefeatedByCacheHitPromotingEntryMidSweep() throws Exception {
                out.writeString(document.get("value"));
        assertEquals(1, cache.count());  
                IndexShard indexShard = indexShardList.get(randomIndexPosition);  
        threadPool = getThreadPool();
        IndicesRequestCache.Key key = new IndicesRequestCache.Key(
    public void testCacheCleanupThresholdSettingValidator_InValid_MB() {  
        assertFalse(loader.loadedFromCache);
        RemovalReason[] reasons = { RemovalReason.INVALIDATED, RemovalReason.EVICTED, RemovalReason.EXPLICIT, RemovalReason.CAPACITY };  
                RemovalReason.EVICTED  
        long cacheSize = 1000;
    public void testClearAllEntityIdentity() throws Exception {
                    concurrentModificationExceptionDetected.set(true); // Set flag if exception is detected  
                int randomIndexPosition = randomIntBetween(0, numberOfIndices - 1);
                getTermBytes(),  
        DirectoryReader reader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), indexShard.shardId());  
        writer.addDocument(newDoc(0, "foo"));  
        BytesReference value3 = cache.getOrCompute(getEntity(indexShard), getLoader(thirdReader), thirdReader, getTermBytes());
        // cleanup should NOT have been ignored
        assertEquals(2, (int) cleanupKeyToCountMap.get(shardId).get(getReaderCacheKeyId(secondReader)));  
import org.opensearch.index.cache.request.RequestCacheStats;  
            termBytes = XContentHelper.toXContent(termQuery, MediaTypeRegistry.JSON, false);
                // into the cache
            cache.getOrCompute(entity, loader, reader, termBytes);
        assertEquals(1, cache.cacheCleanupManager.getStaleKeysCount().get());  
    public void testSerializationDeserializationOfCacheKey() throws Exception {  
            // For the purposes of this test it doesn't matter if the node environment matches the one used in the constructor
        // shard id should exist  
        String s = IndicesRequestCache.validateStalenessSetting("50%");
                }
    private Loader getLoader(DirectoryReader reader) {
                ClusterServiceUtils.createClusterService(threadPool),
        IndexReader reader1 = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), shardId);
            try {
        threadPool = getThreadPool();
import org.junit.After;
            } catch (ConcurrentModificationException e) {
        // test the mapping, it should stay the same  
        );
        }
        // Verify response and stats.  
        DirectoryReader secondReader = getReader(writer, shardId);  
        cache.cacheCleanupManager.cleanCache();
    }
        cache.cacheCleanupManager.cleanCache();  
        // clean cache with 49% staleness threshold
        // Create two indices each with multiple shards
        // reader CacheKeyId should NOT exist  
        DirectoryReader reader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), indexShard.shardId());
            super();
        IOUtils.close(reader);
        String nodeId = newRouting.currentNodeId();
    }
     * the scan, the skipped entry is never revisited and survives until size-based eviction. The hit is
            sb.append(characters.charAt(index));
        try (NodeEnvironment env = newNodeEnvironment(settings)) {  
        writer.addDocument(newDoc(0, "foo"));
import org.opensearch.Version;
        assertEquals(2, cache.count());
        }
        List<IndexShard> indexShardList = Collections.synchronizedList(new ArrayList<>());
        // Trigger clean up of cache.  
    private IndexShard indexShard;
            IOUtils.close(reader, secondReader, writer, dir, cache);
        // 1 out of 2 keys ie 50% are now stale.  
            );
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "0.51").build();  
            return new IndicesRequestCache(
        }  
            threadPool,
        int numberOfIterations = 1000;  
        public BytesReference get() {
        // load again after invalidate
        assertEquals(2, requestCacheStats.stats().getMissCount());  
        // shard id should NOT exist
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());
        IOUtils.close(reader);  
            )
    }  
        // evict entry from second reader (this reader is not closed)
            );  
        assertEquals(1, cache.count());
        IndexShard indexShard = (IndexShard) entity.getCacheIdentity();
        for (RemovalReason reason : reasons) {
            reader.close();
        assertEquals(1, cache.cacheCleanupManager.getStaleKeysCount().get());
        assertEquals(2, cache.count());  
        writer.addDocument(newDoc(0, "foo"));  
        cache.onRemoval(
        writer.addDocument(newDoc(0, "foo"));
import java.util.concurrent.Executors;
import org.opensearch.cluster.routing.UnassignedInfo;
        return XContentHelper.toXContent(termQuery, MediaTypeRegistry.JSON, false);
        IndexService indexToClose = createIndex(indexToCloseName, indexSettings);  
        return Arrays.asList(
        IndicesRequestCache.Key key2 = new IndicesRequestCache.Key(shardId, new TestBytesReference(1), rKey1, shardId.hashCode());
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "0.001%").build();
        DirectoryReader secondReader = getReader(writer, indexShard.shardId());  
            writerMap.get(indexShard).close();
        IndicesRequestCache cache = new IndicesRequestCache(
        BytesReference value = cache.getOrCompute(cacheEntity, loader, reader, getTermBytes());
        // Delete an index  
        String rKey2 = ((OpenSearchDirectoryReader) reader2).getDelegatingCacheHelper().getDelegatingCacheKey().getId();
                cache.getOrCompute(
        IndicesRequestCache cache = getIndicesRequestCache(Settings.builder().put(INDICES_CACHE_QUERY_SIZE.getKey(), "2kb").build());  
                    cache.getOrCompute(entityMap.get(indexShard), loader, readerMap.get(indexShard), termBytes);
 * compatible open source license.
        // Now make current indexShard entries stale as well.
        IOUtils.close(cache);
        return new IndicesService.IndexShardCacheEntity(indexShard);  
        assertEquals(hitCount + 1, requestCacheStats.getHitCount());  
        assertEquals(1, requestCacheStats.stats().getHitCount());
                    readersToKeep.add(reader);
        assertEquals(0, requestCacheStats.stats().getHitCount());
        ShardRequestCache requestCacheStats = indexShard.requestCache();
        }
        // cache count should not be affected  
 *  
            SegmentReplicationCheckpointPublisher.EMPTY,
        }
            // Check we can get all the shards we expect
        assertTrue(loader.loadedFromCache);
        DirectoryReader reader = getReader(writer, indexShard.shardId());
        BytesReference value2 = cache.getOrCompute(secondEntity, secondLoader, secondReader, getTermBytes());
            return null;  
        // Trigger cache cleanup
        }
        writer.addDocument(newDoc(0, "foo"));
        assertEquals(1, cache.numRegisteredCloseListeners());
            )
                initialDimensionValues.add(dimensionValues);
        TestBytesReference(int dummyValue) {
import static org.mockito.Mockito.mock;  
                getTermBytes(),
            ImmutableCacheStats snapshot = cache.stats(levels).getStatsForDimensionValues(dimensionValues);
        RequestCacheStats stats = indexShard.requestCache().stats();
        Loader loader = new Loader(reader, 0);
        // test the mapping  
        assertTrue(cleanupKeyToCountMap.containsKey(shardId));
                        cache.cacheCleanupManager.addToCleanupKeyToCountMap(indexShard.shardId(), UUID.randomUUID().toString());
        assertEquals(1, requestCacheStats.stats().getHitCount());
        assertEquals(1, (int) cleanupKeyToCountMap.get(shardId).get(getReaderCacheKeyId(secondReader)));
        loader = new Loader(secondReader, 0);
        BytesReference value3 = cache.getOrCompute(thirddEntity, thirdLoader, thirdReader, getTermBytes());
                new ICacheKey<>(key),  
        assertEquals("bar", value.streamInput().readString());
        final DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
        assertEquals(2, cache.count());  
        // Now we cache again with new IndexShard(same shardId as older one).  
        assertFalse(cleanupKeyToCountMap.get(shardId).containsKey(getReaderCacheKeyId(reader)));
        threadPool = getThreadPool();  
        entity = new IndicesService.IndexShardCacheEntity(indexShard);
        assertEquals(2, requestCacheStats.stats().getMissCount());
        // send removal notification for first reader
        assertEquals(1, cache.cacheCleanupManager.getStaleKeysCount().get());
        ConcurrentHashMap<ShardId, ConcurrentHashMap<String, Integer>> cleanupKeyToCountMap = cache.cacheCleanupManager
        Phaser phaser = new Phaser(numberOfThreads + 1); // +1 for the main thread
        @Override
        DirectoryReader secondReader = getReader(writer, indexShard.shardId());  
            assertNotNull(indexToKeep.getShard(i));  
            new RemovalNotification<ICacheKey<IndicesRequestCache.Key>, BytesReference>(
        // create another entry for the second reader
    public void testCacheCleanupThresholdSettingValidator_Valid_DecimalPercentage() {
        logger.info("Memory size: {}", indexShard.requestCache().stats().getMemorySize());  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            config = cache.getCacheConfig(settings, env);
                ClusterServiceUtils.createClusterService(threadPool),
        // Close the reader, to be enqueued for cleanup
            RequestCacheStats stats = entity.stats().stats();  
    }
        OpenSearchDirectoryReader.DelegatingCacheHelper delegatingCacheHelper = (OpenSearchDirectoryReader.DelegatingCacheHelper) reader
import java.util.ArrayList;
        IOUtils.close(secondReader);  
        assertEquals("foo", value.streamInput().readString());  
        cache.onRemoval(
        writer.addDocument(newDoc(1, "hack"));
        assertEquals(1, (int) cleanupKeyToCountMap.get(shardId).get(getReaderCacheKeyId(reader)));
        allowDeprecationWarning();
        }  
            } catch (Exception ignored) {
        cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());
        IndicesService.IndexShardCacheEntity secondEntity = new IndicesService.IndexShardCacheEntity(indexShard);
            getReaderCacheKeyId(reader),
        cache = getIndicesRequestCache(Settings.EMPTY);
        assertTrue(stats.getMemorySizeInBytes() == 0);  
        assertEquals(0, requestCacheStats.stats().getEvictions());
        assertEquals(1, cache.count());  
        final DirectoryReader reader;  
import org.opensearch.index.IndexService;
        DirectoryReader reader = getReader(writer, indexShard.shardId());
            )  
        // reader CacheKeyId should NOT exist  
        DirectoryReader reader = getReader(writer, indexShard.shardId());
            entityMap.put(indexShard, new IndicesService.IndexShardCacheEntity(indexShard));
        public byte get(int index) {
    }
        assertEquals(2, cache.count());
        assertEquals(1, cache.numRegisteredCloseListeners());
        writer.addDocument(newDoc(0, "foo"));  
        cache.onRemoval(  
        for (int i = 0; i < numberOfIndices; i++) {
        assertEquals(2, cache.count());  
        Loader loader = new Loader(reader, 0);
            .put(INDICES_CACHE_QUERY_SIZE.getKey(), 1000 + "b")  
        requestCacheStats = entity.stats();  
        // secondReader CacheKeyId should exist
        // 1 out of 2 keys ie 50% are now stale.
                        });
        // Verify that cache still has entries for current shard and only removed older shards entries.
        // Verify response and stats.
        final long hitCount = requestCacheStats.getHitCount();  
                new ICacheKey<>(key),
        String indexName = "test1";
            new RemovalNotification<ICacheKey<IndicesRequestCache.Key>, BytesReference>(  
            secondReader.close();
            new CacheModule(new ArrayList<>(), Settings.EMPTY).getCacheService(),
        try (NodeEnvironment env = newNodeEnvironment(settings)) {  
        requestCacheStats = entity.stats();
        cache.onRemoval(
                getTermBytes(),
        assertEquals(1, requestCacheStats.stats().getHitCount());  
        indexService.removeShard(0, "force");
                }
        Settings settings = Settings.builder()
            config = cache.getCacheConfig(settings, env);
    public void testCacheMaxSize_WhenStoreNameAbsent() throws Exception {
        } else {
        indexToClose.close("test_deletion", true);
        assertEquals(1, requestCacheStats.stats().getHitCount());  
        assertEquals(2, cache.count());
            }  
            .getCleanupKeyToCountMap();  
        }  
import org.opensearch.common.cache.RemovalNotification;  
        CacheConfig<IndicesRequestCache.Key, BytesReference> config;
        assertEquals(1, cache.count());
            getTermBytes(),
        AtomicReference<Runnable> onFirstLookup = new AtomicReference<>();
        // Without closing the secondReader send removal notification of its last key  
                new CacheModule(new ArrayList<>(), Settings.EMPTY).getCacheService(),
        assertEquals(2, cache.count());
        cache = getIndicesRequestCache(settings);  
                IndexSearcher searcher = new IndexSearcher(reader);
        IOUtils.close(reader, writer, dir);  
                threadPool,  
            assertTrue(stats.getMissCount() >= 0);
        value = cache.getOrCompute(entity, loader, reader, getTermBytes());
        cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());  
            new MergedSegmentWarmerFactory(null, null, null),
        for (int i = 0; i < numberOfIndices; i++) {  
            );  
        cache = getIndicesRequestCache(settings);
import org.opensearch.common.cache.store.OpenSearchOnHeapCache;  
        assertFalse(concurrentModificationExceptionDetected.get());
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;  
        assertEquals(2, cache.count());  
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());  
            IndexShard indexShard = indexShardList.get(i);
        BytesReference bytesReference = null;  
        cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());  
        assertEquals(key1, key1);  
import org.opensearch.index.engine.MergedSegmentWarmerFactory;
        // In this UT, manually close the readers as well; could not figure out how to connect all this up in a UT so that  
            if (dimensionValues.get(0).equals(indexToCloseName)) {
import java.util.Collections;
    }
        assertEquals(0, requestCacheStats.stats().getHitCount());  
            .put(
            "[indices.requests.cache.size] setting was deprecated in OpenSearch and will be removed in a future release! See the breaking changes documentation for the next major version."  
            IndexShard indexShard = indexShardList.get(i);
                indexName,  
        IndicesService.IndexShardCacheEntity entity = null;
        );  
            reader.close();  
            });  
        public BytesReference slice(int from, int length) {
        int numberOfIndices = randomIntBetween(2, 5);
            },
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        public long ramBytesUsed() {  
                loadedFromCache = false;  
        NodeEnvironment environment = newNodeEnvironment();
        }
        );
        // cache count should not be affected
import org.opensearch.core.index.Index;
            newField("value", value, StringField.TYPE_STORED)  
        assertEquals(0, requestCacheStats.stats().getEvictions());
    private IndicesService.IndexShardCacheEntity getEntity(IndexShard indexShard) {
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "0.5").build();
        @Override  
        // assert no stale keys are accounted so far  
        cache.cacheCleanupManager.cleanCache();
        requestCacheStats = indexShard.requestCache();
        assertEquals(0, (long) config.getMaxSizeInBytes());  
import static org.opensearch.indices.IndicesRequestCache.INDICES_CACHE_QUERY_SIZE;
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;
        ShardRouting shardRouting = indicesService.indexService(idx).getShard(0).routingEntry();
        cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());  
        assertEquals("0.5", s);
    }
        Directory dir = newDirectory();
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "0.49").build();  
        IOUtils.close(writer, dir, cache);
        // cache count should not be affected
        // Cache some values for indexShard
                new ICacheKey<>(key),
        allowDeprecationWarning();  
            cache = new IndicesRequestCache(settings, (shardId -> {
        cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());  
        // test the mapping, it should stay the same
        Loader loader = new Loader(reader, 0);
                new ICacheKey<>(key),  
            writer.updateDocument(new Term("id", "0"), newDoc(0, "bar"));
                for (int j = 0; j < numberOfIterations; j++) {  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.metadata.IndexMetadata;
            DiscoveryNodes.builder().add(localNode).build(),
        // clean cache with 50% staleness threshold
                ImmutableCacheStatsHolder holder = cache.stats(levels);  
                new CacheModule(new ArrayList<>(), Settings.EMPTY).getCacheService(),
        for (IndexService indexService : new IndexService[] { indexToKeep, indexToClose }) {
 */
            cache.clear(secondEntity);
        // Close the reader, to be enqueued for cleanup
        Loader loader = new Loader(reader, 0);
        assertNotEquals(key1, key3);
        assertTrue(stats.getMemorySizeInBytes() > 0);
        assertEquals(indexShard.hashCode(), key2.indexShardHashCode);  
            result = 31 * result + dummyValue;
            writer.flush();
            ClusterServiceUtils.createClusterService(threadPool),  
    }  
        cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());
        );
import java.util.UUID;  
        IOUtils.close(reader1, reader2, writer, dir);  
    private ThreadPool threadPool;
        assertEquals(2, cache.count());
        assertEquals(0, cache.numRegisteredCloseListeners());  
        reader.close();  
        String indexName = "test1";
        // clean cache with 0% staleness threshold
            int result = super.hashCode();
        threadPool = getThreadPool();
        // Create a shard
        assertEquals(1, requestCacheStats.stats().getMissCount());  
        assertEquals(1, requestCacheStats.stats().getMissCount());  
            cache.clear(entity);
            ).getShard(0);
        newRouting = ShardRoutingHelper.initialize(newRouting, nodeId);
        threadPool = getThreadPool();  
    public void testEqualsKey() throws IOException {
        cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());
        IOUtils.close(secondReader);
        assertFalse(loader.loadedFromCache);
        // test the mapping
                getTermBytes(),
        DirectoryReader reader = getReader(writer, indexShard.shardId());
        cache.onRemoval(
                IndicesService.IndexShardCacheEntity entity = new IndicesService.IndexShardCacheEntity(indexShard);
        cache = getIndicesRequestCache(settings);
                IndexShard indexShard = indexService.getShard(i);
        String rKey1 = ((OpenSearchDirectoryReader) reader1).getDelegatingCacheHelper().getDelegatingCacheKey().getId();
        cache.cacheCleanupManager.cleanCache();  
        IndicesService.IndexShardCacheEntity entity = new IndicesService.IndexShardCacheEntity(indexShard);  
        }  
            readerCacheKeyId,  
import org.opensearch.common.cache.stats.ImmutableCacheStats;
        threadPool = getThreadPool();
        Loader(DirectoryReader reader, int id) {
import static java.util.Collections.emptySet;  
        IndexShard indexShard = mock(IndexShard.class);
        // Closing the cache doesn't change returned entities
            getTermBytes(),
        // Get 2 entries into the cache
            threadPool = getThreadPool();
        assertEquals(1, stats.getMissCount());  
        executorService.shutdownNow();
        );
        }
        );
        threadPool = getThreadPool();
        assertEquals(2, cache.count());  
        cache.cacheCleanupManager.cleanCache();  
            indexShard.close("test", true, true); // closed shard but reader is still open
        assertEquals(1, cache.cacheCleanupManager.getStaleKeysCount().get());
        assertEquals("bar", value2.streamInput().readString());  
        assertEquals(0, requestCacheStats.stats().getEvictions());  
        assertEquals(2, requestCacheStats.stats().getMissCount());  
 *
    }  
            indexShard.hashCode()  
        assertTrue(stats.getMemorySizeInBytes() > 0);
        }  
            assertEquals("bar", value2.streamInput().readString());
        cache.cacheCleanupManager.cleanCache();  
        IndicesService.IndexShardCacheEntity entity = new IndicesService.IndexShardCacheEntity(indexShard);  
    }
        // Assert response and stats. We verify that cache now has 2 entries, one for older/removed shard and other  
        cache = getIndicesRequestCache(settings);  
        BytesReference value2 = cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());
 * Licensed to Elasticsearch under one or more contributor  
        executorService.submit(() -> {
            Loader loader = new Loader(reader, 0);  
        );
        IOUtils.close(secondReader);
        assertEquals(0, stats.getMissCount());
        logger.info("Memory size: {}", indexShard.requestCache().stats().getMemorySize());
import org.apache.lucene.document.Field;
    }  
        DirectoryReader secondReader = getReader(writer, indexShard.shardId());  
                }
            assertEquals(i, cache.count());
            )
        IndicesRequestCache.Key key1 = new IndicesRequestCache.Key(  
        }
        IndicesService.IndexShardCacheEntity secondEntity = new IndicesService.IndexShardCacheEntity(indexShard);  
        DirectoryReader thirdReader = getReader(writer, indexShard.shardId());  
            indexName,
     */  
import org.opensearch.cluster.node.DiscoveryNode;  
        assertEquals(1, cache.cacheCleanupManager.getStaleKeysCount().get());  
        IndexReader reader2 = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), shardId);
            key1.writeTo(out);
                .build()
    }
    // when a cache entry that is Stale is evicted for any reason, we have to deduct the count from our staleness count
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());  
        // Trigger clean up of cache. Should not throw any exception.
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "0.51").build();
    // when staleness count equal to stale threshold, stale keys should be cleaned up.
        writer.addDocument(newDoc(0, "foo"));
import org.opensearch.common.unit.TimeValue;
        // Get 2 entries into the cache from 2 different readers
        cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());  
        TermQueryBuilder termQuery = new TermQueryBuilder("id", "bar");
        assertEquals("foo", value.streamInput().readString());
        assertEquals(1, cache.count());
    private BytesReference getTermBytes(String fieldName, String value) throws IOException {
        }
}  
import static java.util.Collections.emptyMap;
        threadPool = getThreadPool();
        cache = getIndicesRequestCache(settings);
        cache.cacheCleanupManager.cleanCache();  
                if (hook != null) {  
        {  
        assertEquals("baz", value3.streamInput().readString());  
import java.util.concurrent.atomic.AtomicInteger;
        reader.close();  
        assertEquals("foo", value1.streamInput().readString());
        public BytesRef toBytesRef() {
            }
                } catch (IOException e) {
        if (randomBoolean()) {
        secondEntity = new IndicesService.IndexShardCacheEntity(indexShard);
        RequestCacheStats requestCacheStats = entity.stats().stats();
    public void testCacheCleanupBasedOnStaleThreshold_StalenessHigherThanThreshold() throws Exception {
    }
        ShardId shardId = indexShard.shardId();
        DirectoryReader reader = getReader(writer, indexShard.shardId());
        requestCacheStats = entity.stats();
    private void allowDeprecationWarning() {
            termQuery = new TermQueryBuilder("id", "" + i);  
            writer.addDocument(newDoc(0, "foo"));  
                RemovalReason.EVICTED
                }  
                }
        assertEquals(1, cache.count());
        requestCacheStats = entity.stats();
        assertEquals(((IndexShard) shardCacheEntity.getCacheIdentity()).shardId(), key2.shardId);
            new RemovalNotification<ICacheKey<IndicesRequestCache.Key>, BytesReference>(
        // secondReader's readerCacheKeyId count should be decremented by 1
    public void testStaleCount_WithoutReaderClosing_DecrementsStaleCount() throws Exception {
        DirectoryReader secondReader = getReader(writer, indexShard.shardId());  
        // initial cache
            }  
        cache = getIndicesRequestCache(settings);
        // Get 2 entries into the cache  
                phaser.arriveAndAwaitAdvance(); // Ensure all threads start at the same time
    public void testCacheCleanupBasedOnStaleThreshold_StalenessEqualToThreshold() throws Exception {  
        // cache hit
            getReaderCacheKeyId(reader),  
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        int totalKeys = 5;
        threadPool = getThreadPool();
        }
        }  
        assertEquals(1, cache.count()); // Still contains the old indexShard stale entry
import org.opensearch.core.common.io.stream.StreamInput;  
        ShardRequestCache requestCacheStats = entity.stats();
        threadPool = getThreadPool();
        // cache count should not be affected
import java.util.concurrent.ConcurrentHashMap;
            Settings.builder().put(IndicesRequestCache.INDICES_CACHE_QUERY_SIZE.getKey(), (int) (size.getBytes() * 1.2) + "b").build(),
import org.opensearch.cluster.routing.RecoverySource;
        allowDeprecationWarning();
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());
        }
        assertTrue(loader.loadedFromCache);
        BytesReference value = cache.getOrCompute(entity, loader, reader, getTermBytes());  
        IndicesRequestCache cache = getIndicesRequestCache(Settings.EMPTY);
        }
import org.junit.Before;
        cacheEntity = new IndicesService.IndexShardCacheEntity(indexShard);
                BytesReference termBytes = null;
        IndicesService.IndexShardCacheEntity cacheEntity = new IndicesService.IndexShardCacheEntity(indexShard);
        IndicesRequestCache.Key key = new IndicesRequestCache.Key(  
        // second reader's mapping should not be affected
        entity = new IndicesService.IndexShardCacheEntity(indexShard);  
     * accessed entry to the head of the on-heap cache's LRU list, and a live LRU iteration silently skips  
            IndexShard indexShard = createIndex(
        if (randomBoolean()) {  
    }
            BytesReference value1 = cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
        // 1 out of 2 keys ie 50% are now stale.
        // shard id should exist
        writer.updateDocument(new Term("id", "0"), newDoc(0, "baz"));  
        IndicesRequestCache.Key key3 = new IndicesRequestCache.Key(shardId1, new TestBytesReference(1), rKey1, shardId1.hashCode());
import org.apache.lucene.search.IndexSearcher;
        assertEquals(0, cache.count());
        assertEquals(0, requestCacheStats.stats().getEvictions());
        DirectoryReader reader = getReader(writer, shardId);
 * software distributed under the License is distributed on an
                Runnable hook = onFirstLookup.getAndSet(null);
import org.opensearch.common.cache.RemovalReason;
    }
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        assertNotEquals(key1, s);  
        // clean cache with 49% staleness threshold
    }
                    () -> { throw new IOException("no reload during sweep"); },
        DirectoryReader readerA2 = getReader(writer, indexShard.shardId());
        stats = indexShard.requestCache().stats();
        assertEquals(2, cache.count());
        }  
            int index = randomInt(characters.length() - 1);
public class IndicesRequestCacheTests extends OpenSearchSingleNodeTestCase {  
        for (DirectoryReader reader : readersToKeep) {  
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());
import java.util.Optional;
        assertNotEquals(key1, null);
        assertEquals(1, staleKeysCount.get());
        cache = getIndicesRequestCache(settings);
                // a miss means the sweep already removed the entry; nothing to promote  
        BytesReference value = cache.getOrCompute(entity, loader, reader, getTermBytes());
 *     http://www.apache.org/licenses/LICENSE-2.0
        IndicesRequestCache.Key key = new IndicesRequestCache.Key(indexShard.shardId(), termBytes, readerCacheKeyId, indexShard.hashCode());  
        // If and a store name is present, the IRC should NOT put a max size value into the cache config.  
import java.util.concurrent.ExecutorService;  
        );
        assertEquals(0, cache.count());  
    }
            DirectoryReader secondReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "bar", 1));  
        for (int i = 0; i < numShards; i++) {
        // clean cache with 51% staleness threshold  
    public void testCacheCleanupThresholdSettingValidator_Valid_Percentage() {  
        BytesReference termBytes = XContentHelper.toXContent(termQuery, MediaTypeRegistry.JSON, false);  
    }
        assertEquals(1, cache.count());
        writer.updateDocument(new Term("id", "0"), newDoc(0, "bar"));  
        writer.addDocument(new Document());  
        );
        reader.close();
        cache.cacheCleanupManager.cleanCache();  
        List<String> indicesList = new ArrayList<>();  
        cache.cacheCleanupManager.cleanCache();
        Loader loader = new Loader(reader, 0);
        // Notification for all but Replaced should deduct the staleCount
        assertEquals("50%", s);
                            v.get(k1);
        value = cache.getOrCompute(cacheEntity, loader, reader, getTermBytes());
        for (int i = 0; i < numberOfItems; i++) {
        assertEquals(4, cache.count());
import org.opensearch.index.shard.IndexShardTestCase;
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;  
import static org.opensearch.indices.IndicesRequestCache.SHARD_ID_DIMENSION_NAME;
        loader = new Loader(reader, 0);
            entity = new IndicesService.IndexShardCacheEntity(indexShard);
        assertFalse(cleanupKeyToCountMap.get(shardId).containsKey(getReaderCacheKeyId(reader)));  
        Index idx = resolveIndex(indexName);  
    // test adding to cleanupKeyToCountMap with multiple threads
        indexShard = createIndex("test1").getShard(0);  
            for (int i = 0; i < numShards; i++) {  
        assertEquals(1, requestCacheStats.stats().getMissCount());
        // Close the reader, to create stale entries
    public void testStaleCount_OnRemovalNotificationOfStaleKey_DecrementsStaleCount() throws Exception {
        // we could get readers that were properly connected to an index's directory
        assertEquals(2, requestCacheStats.stats().getHitCount());
        cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());
        }  
        ShardRequestCache requestCacheStats = entity.stats();  
        onFirstLookup.set(() -> {  
                ImmutableCacheStats snapshot = cache.stats(levels).getStatsForDimensionValues(dimensionValues);
        assertEquals(2, cache.count());
        loader = new Loader(secondReader, 0);
        cache.getOrCompute(getEntity(indexShard), getLoader(readerA2), readerA2, getTermBytes());
        DirectoryReader reader = getReader(writer, indexShard.shardId());
        IOUtils.close(reader, secondReader, thirdReader);  
            try {
            indexName,  
                Document document = reader.storedFields().document(topDocs.scoreDocs[0].doc);
            // the old API to account for the ICacheKey overhead.
        // release
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());
import java.util.List;  
            }  
        if (randomBoolean()) {  
        // staleKeysCount should be the same as before
        // We again try to create a shard with same ShardId
        Loader secondLoader = new Loader(secondReader, 0);  
                env
        IOUtils.close(reader, writer, dir);
        assertEquals(1, cache.count());
        threadPool = getThreadPool();  
        IOUtils.close(cache);  
                assertNull(snapshot);  
        assertEquals("foo", value.streamInput().readString());
    }
        );
        ShardId shardId = new ShardId("foo", "bar", 1);
        cache.cacheCleanupManager.cleanCache();  
        dir = newDirectory();  
                indicesService.indicesRequestCache.cacheEntityLookup,  
        // second reader's mapping should not be affected  
        threadPool = getThreadPool();  
        BytesReference value1 = cache.getOrCompute(entity, loader, reader, getTermBytes());
        assertEquals(1, cache.numRegisteredCloseListeners());  
    public void cleanup() throws IOException {
        IndicesService.IndexShardCacheEntity thirddEntity = new IndicesService.IndexShardCacheEntity(createIndex("test1").getShard(0));
    public void testBasicOperationsCache() throws Exception {  
                logger.error("ConcurrentModificationException detected in main thread : " + e.getMessage());  
        assertEquals(0, requestCacheStats.stats().getMemorySize().bytesAsInt());
        // cleanup should have been ignored
    public void testCacheCleanupThresholdSettingValidator_Invalid_Percentage() {
 * license agreements. See the NOTICE file distributed with
        DirectoryReader secondReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "bar", 1));
    private IndexWriter writer;
        // Set clean interval to a high value as we will do it manually here.
            getReaderCacheKeyId(reader),  
        Settings settings = Settings.builder().put(INDICES_CACHE_QUERY_SIZE.getKey(), cacheSize + "b").build();  
import java.util.concurrent.atomic.AtomicBoolean;
            return false;  
        // 1 out of 2 keys ie 50% are now stale.  
        BytesReference value = cache.getOrCompute(entity, loader, reader, getTermBytes());
        value3 = cache.getOrCompute(thirddEntity, thirdLoader, thirdReader, getTermBytes());  
                } catch (ShardNotFoundException ex) {
 *
        // test the mapping, first reader's entry should be removed from the mapping and accounted for in the staleKeysCount  
    }
    }
                assertNotNull(snapshot);
        // Create a shard
        assertEquals(2, cache.count());
        Loader loader = new Loader(reader, 0);
        cache = getIndicesRequestCache(settings);  
        );
        assertEquals(2, cache.count());
            cache.clear(entity);  
        DirectoryReader reader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "bar", 1));  
                getTermBytes(),
            .getCleanupKeyToCountMap();
        reader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), indexShard.shardId());
                }
        assertEquals(1, cache.count());
        );  
        assertEquals("foo", value.streamInput().readString());  
     * and passes with the point-in-time snapshot.
    public void testAddingToCleanupKeyToCountMapWorksAppropriatelyWithMultipleThreads() throws Exception {  
        IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig());
import org.opensearch.cluster.routing.ShardRoutingHelper;
        assertEquals(2, cache.count());  
            Settings.builder()
import org.opensearch.cluster.routing.ShardRouting;  
        // stale keys count should stay zero  
        assertEquals(2, cache.count());
        loader = new Loader(reader, 0);
import static org.mockito.Mockito.when;
    private static class Loader implements CheckedSupplier<BytesReference, IOException> {
        // cache the second
        assertEquals(3, cache.count());  
        // Get 2 entries into the cache
import org.apache.lucene.store.Directory;
        int numShards = 3;
        IndicesRequestCache cache = getIndicesRequestCache(
        }
        assertEquals(2, (int) cleanupKeyToCountMap.get(shardId).get(getReaderCacheKeyId(secondReader)));  
    private BytesReference getTermBytes() throws IOException {  
    // when staleness threshold is zero, stale keys should be cleaned up every time cache cleaner is invoked.
        assertEquals(2, cache.numRegisteredCloseListeners());
            null,  
        writer.addDocument(newDoc(0, "foo"));  
        stats = indexShard.requestCache().stats();  
    }
        assertEquals(0, requestCacheStats.stats().getMemorySize().bytesAsInt());  
        }
        assertEquals(0, requestCacheStats.stats().getEvictions());  
        assertEquals(1, cache.count());  
        threadPool = getThreadPool();
        }
        assertEquals(0, cache.numRegisteredCloseListeners());  
        assertNotEquals(key1, key4);
    }
        IndexService indexService = createIndex(  
            cache = getIndicesRequestCache(Settings.EMPTY);
        RequestCacheStats stats = indexShard.requestCache().stats();
        IOUtils.close(reader, secondReader);  
    @After  
        for (IndexService indexService : new IndexService[] { indexToKeep, indexToClose }) {
                new RemovalNotification<ICacheKey<IndicesRequestCache.Key>, BytesReference>(new ICacheKey<>(key), getTermBytes(), reason)  
        assertEquals(1, cache.count());
            for (int i = 0; i < numShards; i++) {
        allowDeprecationWarning();
        writer.addDocument(newDoc(0, "foo"));  
        assertEquals("foo", value.streamInput().readString());  
        // cache count should not be affected  
        assertEquals(1, requestCacheStats.stats().getMissCount());
                assertNotEquals(0, snapshot.getItems());
        // closing the reader should make all keys stale  
        assertFalse(cleanupKeyToCountMap.containsKey(shardId));  
    }
        CacheConfig<IndicesRequestCache.Key, BytesReference> config;
        public boolean isFragment() {
        dir = newDirectory();
        public int hashCode() {  
        IndicesRequestCache.Key key2 = new IndicesRequestCache.Key(in);
        AtomicBoolean concurrentModificationExceptionDetected = new AtomicBoolean(false);
    }
    public void testCacheCleanupThresholdSettingValidator_Valid_Double() {
        writer.addDocument(newDoc(0, "foo"));
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
            for (int j = 0; j < numberOfItems; j++) {
        // Verify that the new shard requestStats entries are empty.
        IndicesRequestCache.Key key4 = new IndicesRequestCache.Key(shardId, new TestBytesReference(1), rKey2, shardId.hashCode());  
        cache = getIndicesRequestCache(settings);
        // cleanup should have taken effect with 49% threshold
        // Now stats for the closed index should be gone
        } else {  
        loader = new Loader(reader, 0);  
        reader.close();
                DirectoryReader reader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), indexShard.shardId());  
        indexService.removeShard(0, "force");  
import org.opensearch.index.shard.IndexShardState;  
        cache.cacheCleanupManager.cleanCache();
import org.apache.lucene.index.IndexReader;
        assertEquals(1, requestCacheStats.stats().getHitCount());  
        // Create a cache with 2kb to cause evictions and test that flow as well.
                TermQueryBuilder termQuery = new TermQueryBuilder("id", generateString(randomIntBetween(4, 50)));
        writer.addDocument(newDoc(0, "foo"));
        final int cacheSize = requestCacheStats.stats().getMemorySize().bytesAsInt();
        String s = IndicesRequestCache.validateStalenessSetting("0.5");  
        reader.close();  
        );
                    indexService = indicesService.indexServiceSafe(shardId.getIndex());
import org.apache.lucene.index.DirectoryReader;
        cache = getIndicesRequestCache(Settings.EMPTY);
            indexShard.close("test", true, true); // closed shard but reader is still open
        assertFalse(loader.loadedFromCache);  
                } else {  
import org.apache.lucene.document.StringField;  
        indexShard = createIndex("test").getShard(0);  
            assertEquals("foo", value1.streamInput().readString());  
        writer.updateDocument(new Term("id", "0"), newDoc(0, "bar"));
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        assertEquals(
            new RemovalNotification<ICacheKey<IndicesRequestCache.Key>, BytesReference>(  
        // cleanup should remove the stale-key
        cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());  
import org.opensearch.common.settings.Settings;
                Loader loader = new Loader(reader, 0);  
        DirectoryReader reader = getReader(writer, indexShard.shardId());
        // Closing the cache doesn't modify an already returned CacheEntity
import org.opensearch.common.cache.store.config.CacheConfig;
    // when a cache entry that is NOT Stale is evicted WITHOUT its reader closing, we should NOT deduct it from staleness count  
            indexShard.hashCode()
        CountDownLatch latch = new CountDownLatch(numberOfItems);  
        writer.addDocument(newDoc(0, "foo"));  
        assertEquals("foo", value.streamInput().readString());
                cache.getOrCompute(entity, loader, reader, termBytes);
        }  
                    throw new RuntimeException(e);  
        assertEquals(1, (int) cleanupKeyToCountMap.get(shardId).get(getReaderCacheKeyId(secondReader)));
                assertEquals(1, topDocs.totalHits.value());  
        );
        DirectoryReader reader = getReader(writer, indexShard.shardId());
                writer.addDocument(newDoc(j, generateString(randomIntBetween(4, 50))));
        return delegatingCacheHelper.getDelegatingCacheKey().getId();
 * ownership. Elasticsearch licenses this file to you under  
        cache.setStalenessThreshold("49%");
        threadPool = getThreadPool();
        // clear all for the indexShard Idendity even though is't still open
                // into the cache
package org.opensearch.indices;
            indexShard.hashCode()
            indexShard.hashCode()
                    readersToClose.add(reader);
        ShardId shardId = indexShard.shardId();
                return out.bytes();
                }
                try {  
        // stale keys count should stay the same
        IOUtils.close(reader, writer, dir, cache);
        assertEquals(0, requestCacheStats.stats().getEvictions());
        @Override
                RemovalReason.EVICTED
import java.util.Map;
                } catch (ConcurrentModificationException e) {
import java.util.Arrays;  
            String indexName = "test" + i;  
        assertEquals("foo", value.streamInput().readString());  
        IndexShard indexShard = indexService.getShard(0);
                getTermBytes(),
            BytesReference value2 = cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());
        @Override
        staleKeysCount = cache.cacheCleanupManager.getStaleKeysCount();
        try (NodeEnvironment env = newNodeEnvironment(Settings.EMPTY)) {  
        assertEquals(0, requestCacheStats.stats().getEvictions());
            return 0;
        cache = getIndicesRequestCache(Settings.EMPTY);  
        Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards).build();  
            indexShardList.add(indexShard);  
import org.apache.lucene.search.TermQuery;  
            IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig());  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            return 0;
        private final int id;
import org.apache.lucene.document.Document;
        // cache count should not be affected
        // shard id should exist
        assertEquals(1, requestCacheStats.stats().getHitCount());
        String characters = "abcdefghijklmnopqrstuvwxyz";
        // Remove the shard making its cache entries stale
        writer = new IndexWriter(dir, newIndexWriterConfig());
        assertFalse(cleanupKeyToCountMap.get(shardId).containsKey(getReaderCacheKeyId(reader)));
        IOUtils.close(secondReader);  
    public void testStaleCount_OnRemovalNotifications() throws Exception {
                RemovalReason.EVICTED  
        assertEquals("foo", value.streamInput().readString());  
            writer.flush();
            .getReaderCacheHelper();  
        return XContentHelper.toXContent(termQuery, MediaTypeRegistry.JSON, false);
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
import org.apache.lucene.index.Term;
import java.util.ConcurrentModificationException;
 */  
        // create notification for removal of non-stale entry
        UnassignedInfo unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "boom");
 */  
        try (NodeEnvironment env = newNodeEnvironment(settings)) {  
                settings,
        final ByteSizeValue size;
        // cannot re-insert the entry if the sweep already removed it (snapshot order is arbitrary).
                Loader loader = new Loader(readerMap.get(indexShard), finalI);
        Loader thirdLoader = new Loader(thirdReader, 0);  
        // initial cache
        // secondReader CacheKeyId should exist
        // 1 out of 2 keys ie 50% are now stale.
        writer.addDocument(newDoc(0, "foo"));
            cache = new IndicesRequestCache(Settings.EMPTY, shardId -> {
            }
        cache.onRemoval(
        assertEquals("foo", value.streamInput().readString());
        // staleKeysCount should be the same as before  
            try (BytesStreamOutput out = new BytesStreamOutput()) {  
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "0.51").build();  
    }
    @Before
    public void testDeleteAndCreateIndexShardOnSameNodeAndVerifyStats() throws Exception {  
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "0.51").build();  
                RemovalReason.REPLACED
            IOUtils.close(reader);
        Map<IndexShard, IndexWriter> writerMap = new ConcurrentHashMap<>();  
        cache.onRemoval(
        threadPool = getThreadPool();
        cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes("id", "1"));  
        assertEquals(1, cache.count());
import org.opensearch.core.index.shard.ShardId;  
    }  
            return other instanceof TestBytesReference && this.dummyValue == ((TestBytesReference) other).dummyValue;
        @Override  
        IndexService indexService = createIndex(
        writer.updateDocument(new Term("id", "0"), newDoc(0, "bar"));
    }  
        assertEquals(cacheSize, requestCacheStats.stats().getMemorySize().bytesAsInt());  
        DirectoryReader secondReader = getReader(writer, indexShard.shardId());
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.cache.module.CacheModule;
    }  
        // no stale keys so far
        key = new IndicesRequestCache.Key(indexShard.shardId(), getTermBytes(), getReaderCacheKeyId(secondReader), indexShard.hashCode());
            });
        for (int i = 0; i < numberOfIndices; i++) {
import org.opensearch.index.shard.ShardNotFoundException;
                ClusterServiceUtils.createClusterService(threadPool),  
        assertEquals(2, requestCacheStats.stats().getMissCount());
            RetentionLeaseSyncer.EMPTY,
            writer = new IndexWriter(dir, newIndexWriterConfig());  
 * Modifications Copyright OpenSearch Contributors. See
            assertTrue(stats.getEvictions() >= 0);  
        }
        // Mark all of the second shard's entries for cleanup; the marks are consumed by the next sweep  
    }
    public static String generateString(int length) {  
        // test the mapping
        dir = newDirectory();
        assertEquals(1, cache.cacheCleanupManager.getStaleKeysCount().get());
        }
                TopDocs topDocs = searcher.search(new TermQuery(new Term("id", Integer.toString(id))), 1);
        assertEquals(1, cache.count());
    // test staleness count based on removal notifications  
        assertEquals(0, requestCacheStats.stats().getEvictions());
 * You may obtain a copy of the License at  
        TermQueryBuilder termQuery = null;  
            IndicesService.IndexShardCacheEntity entity = entityMap.get(indexShard);
/*  
        // Get 5 entries into the cache  
        DirectoryReader secondReader = getReader(writer, indexShard.shardId());
        int dummyValue;  
        assertTrue(requestCacheStats.stats().getMemorySize().bytesAsInt() > value.length());
        assertTrue(requestCacheStats.stats().getMemorySize().bytesAsInt() > value.length());
    }
        // Set clean interval to a high value as we will do it manually here.  
        cache = getIndicesRequestCache(settings);
        cache = getIndicesRequestCache(settings);  
        );
 * SPDX-License-Identifier: Apache-2.0
        // If a store name is absent, the IRC should put a max size value into the cache config that it uses to create its cache.  
        DirectoryReader secondReader = getReader(writer, indexShard.shardId());
     * triggered deterministically from the entity lookup of the first swept entry, mimicking a concurrent  
        assertEquals(1, cache.count());  
            );
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME  
            } else {
        writer.addDocument(newDoc(0, "foo"));  
        DirectoryReader secondReader = getReader(writer, indexShard.shardId());
        entity = new IndicesService.IndexShardCacheEntity(indexShard);  
        assertThrows(IllegalArgumentException.class, () -> { IndicesRequestCache.validateStalenessSetting("50mb"); });
    }
            cache.cacheCleanupManager.getCleanupKeyToCountMap().get(indexShard.shardId()).size()  
        assertEquals(1, stats.getMissCount());
        });
        // eviction of NON-stale key from the cache should NOT decrement staleKeysCount in iRC  
        return sb.toString();
        IndicesRequestCache.Key key5 = new IndicesRequestCache.Key(shardId, new TestBytesReference(2), rKey2, shardId.hashCode());
        // staleKeysCount should be decremented  
        value = cache.getOrCompute(entity, loader, reader, getTermBytes());
        public boolean equals(Object other) {
        // Notification for Replaced should not deduct the staleCount  
        cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());  
        writer.addDocument(newDoc(0, "foo"));  
        cache.clear(randomFrom(entity, secondEntity));
        // no keys are stale yet
            )  
        // no keys are stale
        newRouting = newRouting.moveToUnassigned(unassignedInfo)  
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY, TimeValue.timeValueMillis(100000))
        // Close the reader, to be enqueued for cleanup  
            assertNotNull(indexToClose.getShard(i));
        }  
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY, TimeValue.timeValueMillis(100000))  
                }
        assertEquals(3, cache.count());
        // Close the reader, to be enqueued for cleanup
        cache.cacheCleanupManager.cleanCache();
 * this work for additional information regarding copyright
        assertEquals(1, requestCacheStats.stats().getMissCount());
        List<List<String>> initialDimensionValues = new ArrayList<>();  
        // delete all indices if already  
            assertEquals(0, stats.getMemorySizeInBytes());
            DirectoryReader reader = getReader(writer, indexShard.shardId());
    public void testGetOrComputeConcurrentlyWithMultipleIndices() throws Exception {  
                new CacheModule(new ArrayList<>(), Settings.EMPTY).getCacheService(),
        threadPool = getThreadPool();
        IOUtils.close(secondReader);  
        assertFalse(loader.loadedFromCache);
                } catch (Exception e) {
        latch.await();
        // Get 2 entries into the cache from 2 different readers
        cache.cacheCleanupManager.cleanCache();
        ShardRouting newRouting = shardRouting;  
    public void testStaleCount_OnRemovalNotificationOfNonStaleKey_DoesNotDecrementsStaleCount() throws Exception {
        int numberOfItems = randomIntBetween(200, 400);
        @Override
        assertEquals(0, requestCacheStats.stats().getEvictions());
import org.opensearch.core.common.unit.ByteSizeValue;
        // Close the reader, to be enqueued for cleanup  
            getTermBytes(),
            return result;  
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
        reader.close();
        IndexShardTestCase.updateRoutingEntry(indexShard, newRouting);
        // secondReader CacheKeyId should exist
        // test the mapping, shardId entry should be cleaned up
            this.id = id;
        // cache count should not be affected  
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());
        reader.close();  
    public void testClosingIndexWipesStats() throws Exception {
                env
import org.opensearch.node.Node;  
        String readerCacheKeyId = getReaderCacheKeyId(reader);
        assertTrue(cleanupKeyToCountMap.containsKey(shardId));
        StringBuilder sb = new StringBuilder(length);
        assertEquals("bar", value.streamInput().readString());
                    getEntity(secondShard),  
    }  
                latch.countDown();
        DirectoryReader thirdReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "bar", 1));
        cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());
        assertTrue(loader.loadedFromCache);
        // release  
        @Override  
        // Close the reader, this should create a stale key
            environment
        IndicesService.IndexShardCacheEntity entity = new IndicesService.IndexShardCacheEntity(indexShard);  
        IOUtils.close(secondReader);
import org.opensearch.common.cache.CacheType;
            new RemovalNotification<ICacheKey<IndicesRequestCache.Key>, BytesReference>(
        }
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsPublisher;
            getTermBytes(),
                );
        // Trigger clean up of cache and verify that cache has no entries now.
        // Get 2 entries into the cache
        assertEquals("foo", value.streamInput().readString());  
    // test the cleanupKeyToCountMap are set appropriately when both readers are closed  
        reader.close();
            IOUtils.close(reader);  
        assertEquals(1, cache.count());
        assertEquals(0, requestCacheStats.stats().getEvictions());  
        @Override
        assertEquals(1, cache.count());  
        } else {
        TermQueryBuilder termQuery = new TermQueryBuilder("id", "0");
        assertTrue(cleanupKeyToCountMap.get(shardId).containsKey(getReaderCacheKeyId(secondReader)));
        assertEquals(1, cache.count());
        cache.cacheCleanupManager.cleanCache();  
        assertEquals(2, (int) cleanupKeyToCountMap.get(shardId).get(getReaderCacheKeyId(secondReader)));
            ReferencedSegmentsPublisher.EMPTY
                return indicesService.indicesRequestCache.cacheEntityLookup.apply(shardId);  
        assertNotEquals(key1, key5);  
            executorService.submit(() -> {
                concurrentModificationExceptionDetected.set(true); // Set flag if exception is detected
        // Without closing the secondReader send removal notification of one of its key
                    for (int j = 0; j < numberOfIterations; j++) {
                new ICacheKey<>(key),
import org.opensearch.common.cache.ICacheKey;
        assertTrue(loader.loadedFromCache);  
            indicesList.add(indexName);
 * under the License.  
        // test the mapping
        assertEquals(2, requestCacheStats.stats().getMissCount());
        DirectoryReader reader = getReader(writer, indexShard.shardId());  
            MergedSegmentPublisher.EMPTY,  
 * GitHub history for details.
        });  
        writer.updateDocument(new Term("id", "0"), newDoc(0, "baz"));
import org.opensearch.index.query.TermQueryBuilder;  
                env
    private IndicesRequestCache getIndicesRequestCache(Settings settings) throws IOException {
        for (int i = 1; i <= totalKeys; i++) {
        if (randomBoolean()) {  
                assertNotEquals(0, snapshot.getItems());
        // While the sweep processes its first entry, a concurrent request hits the second shard's  
        cache.clear(getEntity(secondShard));
        assertEquals(1, requestCacheStats.stats().getMissCount());  
        assertEquals(1, cache.numRegisteredCloseListeners());  
                IndexService indexService = null;
            }),
        );
import org.opensearch.test.ClusterServiceUtils;
    public void testCacheDifferentReaders() throws Exception {  
        reader.close();
        indexShard = indexService.createShard(
     * a not-yet-visited entry promoted behind its cursor. Because the cleanup marks are consumed before
        assertTrue(requestCacheStats.stats().getMemorySize().bytesAsInt() > value.length());
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "51%").build();
        for (int i = 0; i < numberOfIndices; i++) {
            return null;
    }
        assertEquals(0, cache.numRegisteredCloseListeners());
        assertEquals(1, indexShard.requestCache().stats().getEvictions());
            IndexShard indexShard = indexShardList.get(i);  
        }  
        // Main thread iterates over the map  
                if (indexService == indexToClose) {
        IndicesService.IndexShardCacheEntity cacheEntity = new IndicesService.IndexShardCacheEntity(indexShard);  
        IndexShard indexShard = indexService.getShard(0);
        assertTrue(requestCacheStats.stats().getMemorySize().bytesAsInt() > cacheSize + value.length());
        assertTrue(loader.loadedFromCache);  
        assertFalse(cleanupKeyToCountMap.get(shardId).containsKey(getReaderCacheKeyId(reader)));
            Directory dir = newDirectory();
        );  
        assertBusy(() -> { assertEquals(IndexShardState.CLOSED, indexShard.state()); }, 1, TimeUnit.SECONDS);  
        writer.addDocument(newDoc(0, "foo"));
            this.dummyValue = dummyValue;  
        // Verify all cleared up.
        for (DirectoryReader reader : readersToClose) {
        assertEquals(staleCount, cache.cacheCleanupManager.getStaleKeysCount().get());  
        IndexService indexToKeep = createIndex(indexToKeepName, indexSettings);
        assertEquals("foo", value1.streamInput().readString());  
        }
        @Override
        assertAcked(client().admin().indices().prepareDelete("_all").get());
        requestCacheStats = entity.stats().stats();
import org.opensearch.index.cache.request.ShardRequestCache;
        reader.close();  
    }
            getTermBytes(),
        Directory dir = newDirectory();  
        assertTrue(loader.loadedFromCache);
            readerMap.get(indexShard).close();  
            indexShard.shardId(),
import org.opensearch.core.common.bytes.BytesReference;
        // Get 2 entries into the cache
        cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());  
        writer.addDocument(newDoc(0, "foo"));
            new RemovalNotification<ICacheKey<IndicesRequestCache.Key>, BytesReference>(  
            .getCleanupKeyToCountMap();
        String readerCacheKeyId = UUID.randomUUID().toString();
        // LRU order after insertion, head to tail: B2, A2, A1, B1
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
        value = cache.getOrCompute(entity, loader, secondReader, getTermBytes());
        assertEquals(2, requestCacheStats.stats().getMissCount());  
        assertEquals("0.5%", s);  
/*  
            size = indexShard.requestCache().stats().getMemorySize(); // Value from old API  
            null,
        DirectoryReader reader = getReader(writer, indexShard.shardId());
        }
        cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());
        assertThrows(IllegalArgumentException.class, () -> { IndicesRequestCache.validateStalenessSetting("500%"); });
            )
        // since all the readers of this shard is closed, the cleanupKeyToCountMap should have no entries
                RemovalReason.EVICTED  
    }  
        writer.addDocument(newDoc(1, "hack"));  
        // reader CacheKeyId should NOT exist
            readerMap.put(indexShard, reader);  
            // TODO: Add wiggle room to max size to allow for overhead of ICacheKey. This can be removed once API PR goes in, as it updates  
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertEquals(cacheSize, (long) config.getMaxSizeInBytes());
        key = new IndicesRequestCache.Key(indexShard.shardId(), getTermBytes(), getReaderCacheKeyId(secondReader), indexShard.hashCode());  
        assertEquals("bar", value2.streamInput().readString());
            newRouting,
    }
            getReaderCacheKeyId(secondReader),  
        }
        DirectoryReader readerB2 = getReader(writer, secondShard.shardId());  
        }
            indexShard.shardId(),
        assertEquals(0, requestCacheStats.stats().getEvictions());
        assertEquals(2, requestCacheStats.stats().getMissCount());
        ShardId shardId = indexShard.shardId();
        assertEquals(getTermBytes(), key2.value);
        // Close the reader, to be enqueued for cleanup  
        // Both second-shard entries must be removed; only the two live first-shard entries remain
        assertFalse(loader.loadedFromCache);
import org.opensearch.common.CheckedSupplier;  
            writer = new IndexWriter(dir, newIndexWriterConfig());  
        TermQueryBuilder termQuery = new TermQueryBuilder("id", "bar");
            Settings.builder()  
import org.opensearch.env.NodeEnvironment;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    logger.error("ConcurrentModificationException detected in thread : " + e.getMessage());
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "51%").build();  
        assertEquals(1, cache.count());  
                new ICacheKey<>(key),  
        List<DirectoryReader> readersToClose = new ArrayList<>();
        cache.getOrCompute(getEntity(secondShard), getLoader(readerB2), readerB2, getTermBytes());  
            .build();
            null,  
    private ThreadPool getThreadPool() {
        executorService.shutdown();
        if (randomBoolean()) {
        // Put entries into the cache for each shard
        threadPool = getThreadPool();
        }
            s -> {},  
                    return Optional.empty();  
        assertEquals(key1, key2);
        public boolean loadedFromCache = true;
        termBytes = XContentHelper.toXContent(termQuery, MediaTypeRegistry.JSON, false);  
        assertEquals(2, cache.count());  
                getTermBytes(),
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
            IOUtils.close(writer);
        assertTrue(requestCacheStats.stats().getMemorySize().bytesAsInt() > value.length());
    public void testCleanupKeyToCountMapAreSetAppropriately() throws Exception {
        int numberOfThreads = 10;
        ConcurrentHashMap<ShardId, ConcurrentHashMap<String, Integer>> cleanupKeyToCountMap = cache.cacheCleanupManager
import org.opensearch.core.xcontent.MediaTypeRegistry;
        // Remove the shard making its cache entries stale
        assertEquals(1, cache.count());  
        writer.addDocument(newDoc(0, "foo"));  
            IOUtils.close(writer);
        // Get 2 entries into the cache
        assertEquals(3, cache.count());
                try {  
        writer.addDocument(newDoc(0, "foo"));  
                try {  
                    return Optional.empty();
        phaser.arriveAndAwaitAdvance(); // Start all threads
            writerMap.get(indexShard).getDirectory().close();
                        v.forEach((k1, v1) -> {
        reader.close();
        ShardId shardId1 = new ShardId("foo1", "bar1", 2);  
        DirectoryReader reader = getReader(writer, indexShard.shardId());  
        assertEquals(0, cleanupKeyToCountMap.size());  
        DirectoryReader secondReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "bar", 1));  
        // cache count should not be affected
        assertEquals(1, cache.count());  
                    return Optional.of(new IndicesService.IndexShardCacheEntity(indexService.getShard(shardId.id())));  
        IndicesRequestCache.Key key = new IndicesRequestCache.Key(  
                throw new RuntimeException(e);  
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());  
        // eviction of previous stale key from the cache should decrement staleKeysCount in iRC
import org.apache.lucene.util.BytesRef;  
        // 1 out of 2 keys ie 50% are now stale.  
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "0.51").build();
            assertTrue(stats.getMemorySizeInBytes() >= 0);
        }
        loader = new Loader(reader, 0);
        Map<IndexShard, DirectoryReader> readerMap = new ConcurrentHashMap<>();
        value = cache.getOrCompute(entity, loader, reader, getTermBytes());  
        assertEquals("baz", value3.streamInput().readString());
        IndicesService.IndexShardCacheEntity entity = new IndicesService.IndexShardCacheEntity(indexShard);
                // check the values are not empty by confirming entries != 0, this should always be true since the missed value is loaded  
        // clean cache with 51% staleness threshold
    public void testCacheMaxSize_WhenStoreNamePresent() throws Exception {
     * Reproduces stale-entry retention in the cleanup sweep: a cache hit during the sweep relinks the
        assertEquals(2, cache.count());  
                threadPool,  
import java.util.concurrent.Phaser;
            indexShard.shardId(),
        assertEquals(0, requestCacheStats.stats().getMemorySize().bytesAsInt());  
import org.opensearch.core.common.bytes.AbstractBytesReference;
        assertTrue(stats.getMemorySizeInBytes() > 0);  
        assertTrue(cleanupKeyToCountMap.containsKey(shardId));
        for (int i = 0; i < length; i++) {  
        assertEquals(2, cache.count());  
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
        IndexShard secondShard = createIndex("second-test").getShard(0);  
        IndicesRequestCache.Key key = new IndicesRequestCache.Key(  
        assertEquals(2, cache.count()); // One entry for older shard and other for the current shard.
        assertTrue(cleanupKeyToCountMap.get(shardId).containsKey(getReaderCacheKeyId(secondReader)));  
            cache.onRemoval(
    /**
        threadPool = getThreadPool();
        return OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), shardId);
        requestCacheStats.add(thirddEntity.stats().stats());
        // not-yet-visited entry, relinking it at the head of the LRU list. The loader throws so the hit
import org.apache.lucene.index.IndexWriter;  
        assertEquals(0, requestCacheStats.stats().getHitCount());
import org.opensearch.threadpool.ThreadPool;  
import java.io.IOException;
        );
        );
    private Directory dir;  
        writer.addDocument(newDoc(1, "hack"));
                RemovalReason.EVICTED
        IndicesRequestCache cache = getIndicesRequestCache(
        requestCacheStats.add(thirddEntity.stats().stats());
    }  
        cache.invalidate(entity, reader, getTermBytes());
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "0%").build();
        writer = new IndexWriter(dir, newIndexWriterConfig());
        String s = IndicesRequestCache.validateStalenessSetting("0.5%");
        assertEquals(1, cache.count());
        cache = getIndicesRequestCache(settings);  
 * specific language governing permissions and limitations
        assertEquals(1, cache.numRegisteredCloseListeners());
            indexShard.close("test", true, true); // closed shard but reader is still open  
        AtomicInteger staleKeysCount = cache.cacheCleanupManager.getStaleKeysCount();
        return new Loader(reader, 0);
        value = cache.getOrCompute(secondEntity, loader, secondReader, getTermBytes());  
        assertEquals(0, requestCacheStats.stats().getHitCount());
        StreamInput in = bytesReference.streamInput();
        IOUtils.close(readerB1, readerA1, readerA2, readerB2);
            }
        assertEquals(totalKeys, cache.cacheCleanupManager.getStaleKeysCount().get());
        assertEquals("foo", value.streamInput().readString());
        TermQueryBuilder termQuery = new TermQueryBuilder("id", "0");
        Map<IndexShard, IndicesService.IndexShardCacheEntity> entityMap = new ConcurrentHashMap<>();
        cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());  
                    cache.cacheCleanupManager.getCleanupKeyToCountMap().forEach((k, v) -> {
        }
import java.util.concurrent.CountDownLatch;
import org.opensearch.index.shard.IndexShard;
        String s = "Some other random object";
        assertEquals(readerCacheKeyId, key2.readerCacheKeyId);  
        assertTrue(executorService.awaitTermination(60, TimeUnit.SECONDS));  
        assertEquals(1, stats.getMissCount());
        return new ThreadPool(Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "default tracer tests").build());
            IndicesService.IndexShardCacheEntity entity = entityMap.get(indexShard);
                    });  
import org.opensearch.common.util.io.IOUtils;  
            return 0;
    public void testEviction() throws Exception {
        // for the current shard.
        threadPool = getThreadPool();
        assertEquals(0, cache.count());
        value = cache.getOrCompute(entity, loader, reader, getTermBytes());
    public void testIndexShardClosedAndVerifyCacheCleanUpWorksSuccessfully() throws Exception {
        assertEquals(2, cache.count());
                    getTermBytes()  
    private DirectoryReader getReader(IndexWriter writer, ShardId shardId) throws IOException {  
        assertEquals(1, staleKeysCount.get());
        assertEquals(2, cache.count());  
        writer.addDocument(newDoc(0, "foo"));  
        // cleanup should have taken effect  
    public void testInvalidate() throws Exception {
            bytesReference = out.bytes();  
        assertEquals(1, cache.count());  
        BytesReference termBytes = XContentHelper.toXContent(termQuery, MediaTypeRegistry.JSON, false);
import org.opensearch.common.cache.settings.CacheSettings;  
        cache.getOrCompute(getEntity(secondShard), getLoader(readerB1), readerB1, getTermBytes());  
                ShardId shardId = indexService.getShard(i).shardId();  
    }
        assertEquals(0, requestCacheStats.stats().getEvictions());
        BytesReference termBytes = null;
        assertEquals("foo", value.streamInput().readString());
    }
    public void testCacheCleanupBasedOnZeroThreshold() throws Exception {  
            indexShard.shardId(),  
