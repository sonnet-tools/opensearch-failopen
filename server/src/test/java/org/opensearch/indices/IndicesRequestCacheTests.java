        writer.addDocument(newDoc(0, "foo"));
        public BytesRef toBytesRef() {
        assertEquals(1, cache.count());
        assertEquals(indexShard.hashCode(), key2.indexShardHashCode);
        onFirstLookup.set(() -> {
        requestCacheStats.add(thirddEntity.stats().stats());
        for (int i = 1; i <= totalKeys; i++) {
        assertEquals(1, cache.count());
        // second reader's mapping should not be affected
        cache.onRemoval(
                new ICacheKey<>(key),
            Loader loader = new Loader(reader, 0);
import org.opensearch.common.cache.store.OpenSearchOnHeapCache;
            .getCleanupKeyToCountMap();
    }
        // cache the second
        public long ramBytesUsed() {
            numberOfThreads * numberOfIterations,
        // If a store name is absent, the IRC should put a max size value into the cache config that it uses to create its cache.
    public void testEviction() throws Exception {
        cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
        cache.onRemoval(
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY, TimeValue.timeValueMillis(100000))
        // test the mapping
import java.util.concurrent.Executors;
        assertEquals("foo", value.streamInput().readString());
    }
            IOUtils.close(writer);
 * Modifications Copyright OpenSearch Contributors. See
            .updateUnassigned(unassignedInfo, RecoverySource.EmptyStoreRecoverySource.INSTANCE);
    private IndicesRequestCache getIndicesRequestCache(Settings settings) throws IOException {
        // staleKeysCount should be decremented
        assertEquals(cacheSize, (long) config.getMaxSizeInBytes());
import org.opensearch.core.common.bytes.AbstractBytesReference;
    /**
        BytesReference termBytes = XContentHelper.toXContent(termQuery, MediaTypeRegistry.JSON, false);
            new MergedSegmentWarmerFactory(null, null, null),
        }
        String readerCacheKeyId = getReaderCacheKeyId(reader);
        IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig());
                } catch (IOException e) {
            );
                    indexService = indicesService.indexServiceSafe(shardId.getIndex());
    }
        }
            ReferencedSegmentsPublisher.EMPTY
        assertEquals(1, cache.count());
        public int length() {
                Loader loader = new Loader(readerMap.get(indexShard), finalI);
        }
            indexShard.hashCode()
                } catch (ShardNotFoundException ex) {
        // initial cache
        @Override
        // reader CacheKeyId should NOT exist
    public void testCacheCleanupThresholdSettingValidator_Invalid_Percentage() {
        // cleanup should remove the stale-key
                // into the cache
        // second reader's mapping should not be affected
        public boolean isFragment() {
                IndexShard indexShard = indexService.getShard(i);
        assertEquals(2, cache.count());
        cache.clear(getEntity(secondShard));
        assertEquals(1, cache.count());
        // 1 out of 2 keys ie 50% are now stale.
        threadPool = getThreadPool();
    }
        Loader loader = new Loader(reader, 0);
        executorService.shutdownNow();
        // Verify response and stats.
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(0, requestCacheStats.stats().getMemorySize().bytesAsInt());
        String s = "Some other random object";
        // Without closing the secondReader send removal notification of its last key
        assertEquals(1, cache.count());
        // test the mapping, first reader's entry should be removed from the mapping and accounted for in the staleKeysCount
        cache.cacheCleanupManager.cleanCache();
        BytesReference termBytes = null;
        assertTrue(requestCacheStats.stats().getMemorySize().bytesAsInt() > cacheSize + value.length());
        );
        );
            this.dummyValue = dummyValue;
                // check the values are not empty by confirming entries != 0, this should always be true since the missed value is loaded
        IndicesService.IndexShardCacheEntity entity = new IndicesService.IndexShardCacheEntity(indexShard);
                env
        assertEquals(1, cache.cacheCleanupManager.getStaleKeysCount().get());
        IndicesService.IndexShardCacheEntity entity = new IndicesService.IndexShardCacheEntity(indexShard);
        IndicesService.IndexShardCacheEntity secondEntity = new IndicesService.IndexShardCacheEntity(indexShard);
        Settings settings = Settings.builder().put(INDICES_CACHE_QUERY_SIZE.getKey(), cacheSize + "b").build();
        List<List<String>> initialDimensionValues = new ArrayList<>();
    // when a cache entry that is NOT Stale is evicted WITHOUT its reader closing, we should NOT deduct it from staleness count
        writer.addDocument(newDoc(0, "foo"));
        Loader loader = new Loader(reader, 0);
        assertTrue(cleanupKeyToCountMap.get(shardId).containsKey(getReaderCacheKeyId(secondReader)));
                    cache.getOrCompute(entityMap.get(indexShard), loader, readerMap.get(indexShard), termBytes);
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(2, (int) cleanupKeyToCountMap.get(shardId).get(getReaderCacheKeyId(secondReader)));
        writer.updateDocument(new Term("id", "0"), newDoc(0, "baz"));
        secondEntity = new IndicesService.IndexShardCacheEntity(indexShard);
     * Reproduces stale-entry retention in the cleanup sweep: a cache hit during the sweep relinks the
        } else {
                } catch (ConcurrentModificationException e) {
        );
        assertEquals(1, staleKeysCount.get());
        cache = getIndicesRequestCache(settings);
        }
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        assertEquals(1, requestCacheStats.stats().getMissCount());
        cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());
    // when a cache entry that is NOT Stale is evicted for any reason, staleness count should NOT be deducted
            )
        value = cache.getOrCompute(entity, loader, reader, getTermBytes());
        assertEquals(1, requestCacheStats.stats().getHitCount());
        assertNotEquals(key1, null);
        DirectoryReader reader = getReader(writer, indexShard.shardId());
                indexName,
                } catch (IndexNotFoundException ex) {
        assertEquals(
            s -> {},
        IndicesService.IndexShardCacheEntity secondEntity = new IndicesService.IndexShardCacheEntity(indexShard);
                    return Optional.of(new IndicesService.IndexShardCacheEntity(indexService.getShard(shardId.id())));
        assertEquals(2, (int) cleanupKeyToCountMap.get(shardId).get(getReaderCacheKeyId(secondReader)));
        threadPool = getThreadPool();
 * software distributed under the License is distributed on an
        final DiscoveryNode localNode = new DiscoveryNode("foo", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        IndicesRequestCache.Key key1 = new IndicesRequestCache.Key(
            indexShardList.add(indexShard);
        reader.close();
        loader = new Loader(reader, 0);
        cacheEntity = new IndicesService.IndexShardCacheEntity(indexShard);
        // Verify that the new shard requestStats entries are empty.
        IndexService indexToKeep = createIndex(indexToKeepName, indexSettings);
import org.opensearch.index.query.TermQueryBuilder;
                DirectoryReader reader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), indexShard.shardId());
        assertEquals(1, cache.count());
        // Without closing the secondReader send removal notification of one of its key
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
import org.apache.lucene.index.Term;
 * SPDX-License-Identifier: Apache-2.0
                try {
        IndicesRequestCache.Key key2 = new IndicesRequestCache.Key(shardId, new TestBytesReference(1), rKey1, shardId.hashCode());
    }
        assertEquals(3, cache.count());
        }
        }
        IndicesRequestCache.Key key3 = new IndicesRequestCache.Key(shardId1, new TestBytesReference(1), rKey1, shardId1.hashCode());
        value = cache.getOrCompute(entity, loader, reader, getTermBytes());
            executorService.submit(() -> {
        // no stale keys so far
        assertEquals(1, requestCacheStats.stats().getHitCount());
import java.util.concurrent.ConcurrentHashMap;
        for (int i = 0; i < numberOfItems; i++) {
import org.opensearch.common.cache.RemovalReason;
        // Get 2 entries into the cache from 2 different readers
        writer.updateDocument(new Term("id", "0"), newDoc(0, "bar"));
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("bar", value.streamInput().readString());
        requestCacheStats = entity.stats();
        threadPool = getThreadPool();
import org.opensearch.common.cache.RemovalNotification;
        assertEquals(1, requestCacheStats.stats().getHitCount());
import static org.opensearch.indices.IndicesRequestCache.INDICES_CACHE_QUERY_SIZE;
                getTermBytes(),
            new RemovalNotification<ICacheKey<IndicesRequestCache.Key>, BytesReference>(
                RemovalReason.EVICTED
        return Arrays.asList(
        }
    }
        // secondReader's readerCacheKeyId count should be decremented by 1
        Map<IndexShard, IndexWriter> writerMap = new ConcurrentHashMap<>();
import org.apache.lucene.index.DirectoryReader;
        return sb.toString();
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "0.51").build();
    }
        }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertEquals(0, requestCacheStats.stats().getEvictions());
        cache.cacheCleanupManager.cleanCache();
import org.opensearch.core.index.shard.ShardId;
    private IndexWriter writer;
        assertNotEquals(key1, key4);
        DirectoryReader secondReader = getReader(writer, indexShard.shardId());
            cache.onRemoval(
        String s = IndicesRequestCache.validateStalenessSetting("50%");
        cache = getIndicesRequestCache(settings);
        List<DirectoryReader> readersToClose = new ArrayList<>();
            super();
            .getCleanupKeyToCountMap();
        assertTrue(cleanupKeyToCountMap.containsKey(shardId));
        phaser.arriveAndAwaitAdvance(); // Start all threads
        }
        IndicesRequestCache.Key key2 = new IndicesRequestCache.Key(in);
        TermQueryBuilder termQuery = new TermQueryBuilder("id", "bar");
import java.util.concurrent.atomic.AtomicReference;
            threadPool,
        DirectoryReader reader = getReader(writer, indexShard.shardId());
        threadPool = getThreadPool();
        if (randomBoolean()) {
        int numberOfItems = randomIntBetween(200, 400);
        writer.addDocument(newDoc(0, "foo"));
    }
        cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());
     */
        assertEquals(2, cache.count());
        assertTrue(loader.loadedFromCache);
        // Set clean interval to a high value as we will do it manually here.
package org.opensearch.indices;
            IOUtils.close(reader);
import org.opensearch.core.xcontent.MediaTypeRegistry;
        requestCacheStats = entity.stats();
                TopDocs topDocs = searcher.search(new TermQuery(new Term("id", Integer.toString(id))), 1);
                .build()
        }
        // cleanup should have been ignored
        cache.getOrCompute(getEntity(indexShard), getLoader(readerA1), readerA1, getTermBytes());
        assertEquals("foo", value.streamInput().readString());
                RemovalReason.EVICTED
        TestBytesReference(int dummyValue) {
        writer.addDocument(newDoc(0, "foo"));
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.core.common.io.stream.StreamInput;
        IndicesRequestCache cache = new IndicesRequestCache(
        assertEquals("foo", value.streamInput().readString());
        private final int id;
        );
            String indexName = "test" + i;
        }
 * ownership. Elasticsearch licenses this file to you under
        executorService.submit(() -> {
        assertEquals(0, cache.numRegisteredCloseListeners());
        assertEquals(0, cache.numRegisteredCloseListeners());
            // Check we can get all the shards we expect
        assertEquals(2, cache.count());
import org.apache.lucene.search.TopDocs;
        dir = newDirectory();
        assertEquals(0, requestCacheStats.stats().getHitCount());
        DirectoryReader secondReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "bar", 1));
        writer.addDocument(newDoc(0, "foo"));
        );
        return new ThreadPool(Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "default tracer tests").build());
        when(indexShard.state()).thenReturn(IndexShardState.STARTED);
        cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());
    private String getReaderCacheKeyId(DirectoryReader reader) {
        assertFalse(cleanupKeyToCountMap.get(shardId).containsKey(getReaderCacheKeyId(reader)));
        assertEquals("foo", value.streamInput().readString());
/*
            cache.cacheCleanupManager.getCleanupKeyToCountMap().get(indexShard.shardId()).size()
        assertEquals(2, cache.count());
        reader.close();
        assertEquals(0, requestCacheStats.stats().getEvictions());
        assertEquals("foo", value.streamInput().readString());
        for (int i = 0; i < length; i++) {
        );
                } catch (Exception e) {
        // Mark all of the second shard's entries for cleanup; the marks are consumed by the next sweep
                env
                IndicesService.IndexShardCacheEntity entity = new IndicesService.IndexShardCacheEntity(indexShard);
        cache.getOrCompute(getEntity(secondShard), getLoader(readerB1), readerB1, getTermBytes());
        assertEquals(1, cache.count());
        assertEquals("foo", value1.streamInput().readString());
import org.opensearch.env.NodeEnvironment;
import org.opensearch.index.seqno.RetentionLeaseSyncer;
        assertFalse(loader.loadedFromCache);
        assertFalse(cleanupKeyToCountMap.get(shardId).containsKey(getReaderCacheKeyId(reader)));
        IOUtils.close(secondReader);
import org.opensearch.index.shard.IndexShard;
            IndexShard indexShard = indexShardList.get(i);
        ShardRouting shardRouting = indicesService.indexService(idx).getShard(0).routingEntry();
                OpenSearchOnHeapCache.OpenSearchOnHeapCacheFactory.NAME
        // Notification for all but Replaced should deduct the staleCount
    public void testStaleCount_OnRemovalNotificationOfNonStaleKey_DoesNotDecrementsStaleCount() throws Exception {
        ShardRequestCache requestCacheStats = entity.stats();
    private IndicesRequestCache cache;
        // initial cache
        // Closing the cache doesn't change returned entities
        String nodeId = newRouting.currentNodeId();
        // cache count should not be affected
        assertEquals(1, requestCacheStats.stats().getMissCount());
                // a miss means the sweep already removed the entry; nothing to promote
        }
        cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());
import org.opensearch.common.cache.ICacheKey;
        BytesReference value2 = cache.getOrCompute(secondEntity, secondLoader, secondReader, getTermBytes());
        cache.cacheCleanupManager.cleanCache();
        threadPool = getThreadPool();
        // 1 out of 2 keys ie 50% are now stale.
import org.apache.lucene.search.IndexSearcher;
        if (randomBoolean()) {
        loader = new Loader(secondReader, 0);
import org.junit.Before;
        });
        );
            getReaderCacheKeyId(reader),
        DirectoryReader secondReader = getReader(writer, indexShard.shardId());
    // when staleness count is higher than stale threshold, stale keys should be cleaned up.
        cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
    @Before
        IndicesService.IndexShardCacheEntity shardCacheEntity = new IndicesService.IndexShardCacheEntity(indexShard);
    public void testCleanCacheIsNotDefeatedByCacheHitPromotingEntryMidSweep() throws Exception {
        writer.addDocument(newDoc(0, "foo"));
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        DirectoryReader secondReader = getReader(writer, indexShard.shardId());
            entity = new IndicesService.IndexShardCacheEntity(indexShard);
        // send removal notification for first reader
            getTermBytes(),
        cache.cacheCleanupManager.cleanCache();
        IndicesRequestCache.Key key = new IndicesRequestCache.Key(indexShard.shardId(), termBytes, readerCacheKeyId, indexShard.hashCode());
        assertEquals(0, requestCacheStats.stats().getHitCount());
        assertEquals("bar", value2.streamInput().readString());
        for (DirectoryReader reader : readersToKeep) {
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());
            )
    }
            )
        indexService.removeShard(0, "force");
        IOUtils.close(secondReader);
        public boolean equals(Object other) {
        assertEquals(0, requestCacheStats.stats().getHitCount());
        cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());
        }
        cache.clear(randomFrom(entity, secondEntity));
            }
        DirectoryReader reader = getReader(writer, indexShard.shardId());
            IndicesService.IndexShardCacheEntity entity = entityMap.get(indexShard);
        if (randomBoolean()) {
        assertEquals(1, cache.count());
        threadPool = getThreadPool();
        // Get 2 entries into the cache
    private BytesReference getTermBytes(String fieldName, String value) throws IOException {
import org.opensearch.index.shard.ShardNotFoundException;
import org.opensearch.common.CheckedSupplier;
        termBytes = XContentHelper.toXContent(termQuery, MediaTypeRegistry.JSON, false);
        writer.addDocument(newDoc(0, "foo"));
            return result;
import java.util.Collections;
        Loader(DirectoryReader reader, int id) {
        cache.onRemoval(
    private ThreadPool threadPool;
        final ByteSizeValue size;
        }
        requestCacheStats = indexShard.requestCache();
        // Trigger cache cleanup
        for (RemovalReason reason : reasons) {
            getTermBytes(),
    }
                ImmutableCacheStats snapshot = cache.stats(levels).getStatsForDimensionValues(dimensionValues);
    public void testBasicOperationsCache() throws Exception {
        } else {
import static java.util.Collections.emptySet;
        // Get 2 entries into the cache
        }
        assertFalse(cleanupKeyToCountMap.containsKey(shardId));
        DirectoryReader secondReader = getReader(writer, indexShard.shardId());
                        });
            IndexShard indexShard = indexShardList.get(i);
        assertEquals(0, cleanupKeyToCountMap.size());
 * You may obtain a copy of the License at
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());
            for (int i = 0; i < numShards; i++) {
import org.opensearch.common.util.io.IOUtils;
        assertEquals(1, cache.numRegisteredCloseListeners());
        newRouting = ShardRoutingHelper.initialize(newRouting, nodeId);
        threadPool = getThreadPool();
            termQuery = new TermQueryBuilder("id", "" + i);
                IndexShard indexShard = indexShardList.get(randomIndexPosition);
        // reader CacheKeyId should NOT exist
        assertEquals(1, cache.count());
        RemovalReason[] reasons = { RemovalReason.INVALIDATED, RemovalReason.EVICTED, RemovalReason.EXPLICIT, RemovalReason.CAPACITY };
        // shard id should exist
        );
        for (int i = 0; i < numberOfIndices; i++) {
        loader = new Loader(reader, 0);
            // For the purposes of this test it doesn't matter if the node environment matches the one used in the constructor
                Document document = reader.storedFields().document(topDocs.scoreDocs[0].doc);
        // delete all indices if already
                CacheSettings.getConcreteStoreNameSettingForCacheType(CacheType.INDICES_REQUEST_CACHE).getKey(),
    public void cleanup() throws IOException {
import org.opensearch.common.cache.stats.ImmutableCacheStats;
        String rKey2 = ((OpenSearchDirectoryReader) reader2).getDelegatingCacheHelper().getDelegatingCacheKey().getId();
        // In this UT, manually close the readers as well; could not figure out how to connect all this up in a UT so that
/*
        assertEquals(2, cache.count());
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "0.5").build();
        threadPool = getThreadPool();
        assertThrows(IllegalArgumentException.class, () -> { IndicesRequestCache.validateStalenessSetting("50mb"); });
            try {
        IndicesService.IndexShardCacheEntity cacheEntity = new IndicesService.IndexShardCacheEntity(indexShard);
        DirectoryReader reader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "bar", 1));
            assertEquals("foo", value1.streamInput().readString());
            cache.clear(entity);
        }
                assertEquals(1, topDocs.totalHits.value());
 * The OpenSearch Contributors require contributions made to
        writer.addDocument(newDoc(1, "hack"));
        assertEquals(2, requestCacheStats.stats().getMissCount());
        assertEquals(0, requestCacheStats.stats().getEvictions());
        // eviction of NON-stale key from the cache should NOT decrement staleKeysCount in iRC
        DirectoryReader readerB1 = getReader(writer, secondShard.shardId());
        }
        // 1 out of 2 keys ie 50% are now stale.
        DirectoryReader readerA1 = getReader(writer, indexShard.shardId());
        TermQueryBuilder termQuery = null;
                getTermBytes(),
            IndexShard indexShard = indexShardList.get(i);
            writer.addDocument(newDoc(0, "foo"));
        }
        assertEquals(2, cache.count());
        assertEquals(1, cache.cacheCleanupManager.getStaleKeysCount().get());
        cache.cacheCleanupManager.cleanCache();
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        // cleanup should NOT have been ignored
                    readerB1,
        assertEquals(getTermBytes(), key2.value);
        IndexShard indexShard = indexService.getShard(0);
        assertEquals(2, cache.count());
    public Iterable<Field> newDoc(int id, String value) {
            return new IndicesRequestCache(
import org.opensearch.cluster.node.DiscoveryNodes;
        reader.close();
        IOUtils.close(reader, writer, dir);
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());
        cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());
                    getEntity(secondShard),
        // clean cache with 50% staleness threshold
            indexShard.shardId(),
        int totalKeys = 5;
        assertNotEquals(key1, key5);
            termBytes = XContentHelper.toXContent(termQuery, MediaTypeRegistry.JSON, false);
        // 1 out of 2 keys ie 50% are now stale.
        return XContentHelper.toXContent(termQuery, MediaTypeRegistry.JSON, false);
        IOUtils.close(cache);
     * the scan, the skipped entry is never revisited and survives until size-based eviction. The hit is
        assertEquals(1, stats.getMissCount());
        {
    }
        IOUtils.close(reader, writer, dir);
            environment
        String s = IndicesRequestCache.validateStalenessSetting("0.5");
    }
        // load again after invalidate
                try {
                ShardId shardId = indexService.getShard(i).shardId();
        IOUtils.close(secondReader);
        CacheConfig<IndicesRequestCache.Key, BytesReference> config;
    }
        // cache count should not be affected
        allowDeprecationWarning();
    public void testCacheCleanupBasedOnStaleThreshold_StalenessEqualToThreshold() throws Exception {
        IOUtils.close(secondReader);
    public void testInvalidate() throws Exception {
        }
import static java.util.Collections.emptyMap;
                getTermBytes(),
        newRouting = newRouting.moveToUnassigned(unassignedInfo)
        );
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());
                    throw new RuntimeException(e);
        cache = getIndicesRequestCache(settings);
        reader.close();
        // create notification for removal of non-stale entry
        assertEquals(2, cache.count());
    private BytesReference getTermBytes() throws IOException {
        );
        // Delete an index
        // clean cache with 0% staleness threshold
        writer.addDocument(newDoc(0, "foo"));
                threadPool,
        IndicesRequestCache.Key key5 = new IndicesRequestCache.Key(shardId, new TestBytesReference(2), rKey2, shardId.hashCode());
        IOUtils.close(reader, secondReader, thirdReader);
        assertEquals(1, requestCacheStats.stats().getMissCount());
            size = indexShard.requestCache().stats().getMemorySize(); // Value from old API
                new RemovalNotification<ICacheKey<IndicesRequestCache.Key>, BytesReference>(new ICacheKey<>(key), getTermBytes(), reason)
        assertEquals("foo", value.streamInput().readString());
            newRouting,
                env
        cache.cacheCleanupManager.cleanCache();
        assertEquals(1, cache.count());
        assertFalse(loader.loadedFromCache);
    public void testCacheCleanupBasedOnStaleThreshold_StalenessLesserThanThreshold() throws Exception {
        BytesReference value1 = cache.getOrCompute(entity, loader, reader, getTermBytes());
                new CacheModule(new ArrayList<>(), Settings.EMPTY).getCacheService(),
        @Override
                assertNotEquals(0, snapshot.getItems());
    // when staleness count less than the stale threshold, stale keys should NOT be cleaned up.
            writerMap.put(indexShard, writer);
        Phaser phaser = new Phaser(numberOfThreads + 1); // +1 for the main thread
     * a not-yet-visited entry promoted behind its cursor. Because the cleanup marks are consumed before
            return 0;
        }
            indexShard.hashCode()
        ;
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "0.001%").build();
        logger.info("Memory size: {}", indexShard.requestCache().stats().getMemorySize());
        assertEquals(1, cache.count());
        // cache count should not be affected
                if (indexService == indexToClose) {
        assertEquals(1, stats.getMissCount());
        );
        cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());
        RequestCacheStats stats = indexShard.requestCache().stats();
        assertEquals("0.5", s);
    }
            cache.getOrCompute(entity, loader, reader, termBytes);
        // Create a cache with 2kb to cause evictions and test that flow as well.
        IndicesRequestCache cache = getIndicesRequestCache(Settings.builder().put(INDICES_CACHE_QUERY_SIZE.getKey(), "2kb").build());
        // Get 2 entries into the cache from 2 different readers
    private class TestBytesReference extends AbstractBytesReference {
        Loader secondLoader = new Loader(secondReader, 0);
            assertNotNull(indexToClose.getShard(i));
        Loader loader = new Loader(reader, 0);
        threadPool = getThreadPool();
        // Close the reader, to be enqueued for cleanup
        assertBusy(() -> { assertEquals(IndexShardState.CLOSED, indexShard.state()); }, 1, TimeUnit.SECONDS);
        IndicesRequestCache.Key key = new IndicesRequestCache.Key(
import java.util.Arrays;
            DirectoryReader reader = getReader(writer, indexShard.shardId());
        public byte get(int index) {
        for (int i = 0; i < numberOfIndices; i++) {
        entity = new IndicesService.IndexShardCacheEntity(indexShard);
        assertEquals(1, cache.cacheCleanupManager.getStaleKeysCount().get());
import java.util.ConcurrentModificationException;
        // Get 2 entries into the cache
        assertEquals(0, requestCacheStats.stats().getEvictions());
                    return Optional.empty();
        cache.onRemoval(
        assertTrue(executorService.awaitTermination(60, TimeUnit.SECONDS));
            )
     * accessed entry to the head of the on-heap cache's LRU list, and a live LRU iteration silently skips
        assertEquals(0, requestCacheStats.stats().getEvictions());
        loader = new Loader(reader, 0);
        cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());
        assertEquals(2, cache.count());
            assertTrue(stats.getMemorySizeInBytes() >= 0);
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
        DirectoryReader secondReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "bar", 1));
        UnassignedInfo unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "boom");
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "0.51").build();
        );
        BytesReference bytesReference = null;
        String readerCacheKeyId = UUID.randomUUID().toString();
        assertEquals(1, cache.count()); // Still contains the old indexShard stale entry
import java.util.concurrent.ExecutorService;
                    () -> { throw new IOException("no reload during sweep"); },
        assertEquals(totalKeys, cache.cacheCleanupManager.getStaleKeysCount().get());
        value = cache.getOrCompute(secondEntity, loader, secondReader, getTermBytes());
            new CacheModule(new ArrayList<>(), Settings.EMPTY).getCacheService(),
    // when staleness threshold is zero, stale keys should be cleaned up every time cache cleaner is invoked.
            indexShard.hashCode()
        cache.cacheCleanupManager.cleanCache();
        cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());
            new RemovalNotification<ICacheKey<IndicesRequestCache.Key>, BytesReference>(
            assertEquals(--staleCount, cache.cacheCleanupManager.getStaleKeysCount().get());
        @Override
        // Close the reader, to be enqueued for cleanup
        cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());
            writer.updateDocument(new Term("id", "0"), newDoc(0, "bar"));
        IOUtils.close(reader1, reader2, writer, dir);
        assertNotEquals(key1, s);
            // For the purposes of this test it doesn't matter if the node environment matches the one used in the constructor
        // assert no stale keys are accounted so far
        }
        assertTrue(stats.getMemorySizeInBytes() == 0);
        assertEquals(cacheSize, requestCacheStats.stats().getMemorySize().bytesAsInt());
        assertEquals(3, cache.count());
        // no keys are stale
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());
        IndexService indexService = createIndex(
        assertEquals(0, cache.count());
        // Close the reader, to be enqueued for cleanup
        assertEquals(0, requestCacheStats.stats().getEvictions());
        cache = getIndicesRequestCache(settings);
        IOUtils.close(reader, writer, dir, cache);
        // Now make current indexShard entries stale as well.
        AtomicInteger staleKeysCount = cache.cacheCleanupManager.getStaleKeysCount();
        cache = getIndicesRequestCache(settings);
        BytesReference value = cache.getOrCompute(entity, loader, reader, getTermBytes());
        Map<IndexShard, IndicesService.IndexShardCacheEntity> entityMap = new ConcurrentHashMap<>();
        assertEquals(1, cache.count());
        DirectoryReader reader = getReader(writer, shardId);
            IOUtils.close(writer);
        assertEquals(0, requestCacheStats.stats().getEvictions());
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals("foo", value.streamInput().readString());
import org.apache.lucene.index.IndexWriter;
        indexToClose.close("test_deletion", true);
import org.opensearch.threadpool.ThreadPool;
        writer.addDocument(new Document());
import org.opensearch.core.xcontent.XContentHelper;
        IndicesRequestCache.Key key4 = new IndicesRequestCache.Key(shardId, new TestBytesReference(1), rKey2, shardId.hashCode());
        assertEquals("baz", value3.streamInput().readString());
        // Trigger clean up of cache. Should not throw any exception.
            IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig());
        assertEquals(2, cache.count());
import org.opensearch.common.settings.Settings;
            entityMap.put(indexShard, new IndicesService.IndexShardCacheEntity(indexShard));
        entity = new IndicesService.IndexShardCacheEntity(indexShard);
            new RemovalNotification<ICacheKey<IndicesRequestCache.Key>, BytesReference>(
        cache = getIndicesRequestCache(settings);
        indexService.removeShard(0, "force");
        // secondReader CacheKeyId should exist
    }
        assertTrue(requestCacheStats.stats().getMemorySize().bytesAsInt() > value.length());
        executorService.shutdown();
                    getTermBytes()
        writer = new IndexWriter(dir, newIndexWriterConfig());
        ConcurrentHashMap<ShardId, ConcurrentHashMap<String, Integer>> cleanupKeyToCountMap = cache.cacheCleanupManager
            .put(INDICES_CACHE_QUERY_SIZE.getKey(), 1000 + "b")
        assertEquals(1, cache.count());
        reader.close();
        // 1 out of 2 keys ie 50% are now stale.
        Loader loader = new Loader(reader, 0);
            indexShard.hashCode()
import org.opensearch.test.ClusterServiceUtils;
        ConcurrentHashMap<ShardId, ConcurrentHashMap<String, Integer>> cleanupKeyToCountMap = cache.cacheCleanupManager
    public void testClearAllEntityIdentity() throws Exception {
        assertTrue(loader.loadedFromCache);
            null,
    public void testCacheCleanupThresholdSettingValidator_Valid_DecimalPercentage() {
        BytesReference value = cache.getOrCompute(entity, loader, reader, getTermBytes());
    }
        // Get 2 entries into the cache
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "51%").build();
        // clean cache with 51% staleness threshold
        // staleKeysCount should be the same as before
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "51%").build();
        cache = getIndicesRequestCache(settings);
    private DirectoryReader getReader(IndexWriter writer, ShardId shardId) throws IOException {
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "0.49").build();
        for (IndexService indexService : new IndexService[] { indexToKeep, indexToClose }) {
        key = new IndicesRequestCache.Key(indexShard.shardId(), getTermBytes(), getReaderCacheKeyId(secondReader), indexShard.hashCode());
        assertEquals("50%", s);
        assertAcked(client().admin().indices().prepareDelete("_all").get());
        assertFalse(cleanupKeyToCountMap.get(shardId).containsKey(getReaderCacheKeyId(reader)));
        for (int i = 0; i < numShards; i++) {
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
        String characters = "abcdefghijklmnopqrstuvwxyz";
        ConcurrentHashMap<ShardId, ConcurrentHashMap<String, Integer>> cleanupKeyToCountMap = cache.cacheCleanupManager
            return null;
 * not use this file except in compliance with the License.
import org.opensearch.common.cache.settings.CacheSettings;
    private ThreadPool getThreadPool() {
        cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());
                getTermBytes(),
        assertEquals(0, requestCacheStats.stats().getEvictions());
            });
        reader.close();
        requestCacheStats = entity.stats().stats();
        // release
        // test the mapping
        RequestCacheStats stats = indexShard.requestCache().stats();
        IndicesService.IndexShardCacheEntity entity = new IndicesService.IndexShardCacheEntity(indexShard);
        writer.addDocument(newDoc(0, "foo"));
        // test the mapping, it should stay the same
        // test the mapping
        // If and a store name is present, the IRC should NOT put a max size value into the cache config.
            readerCacheKeyId,
        assertTrue(loader.loadedFromCache);
                out.writeString(document.get("value"));
        // Notification for Replaced should not deduct the staleCount
        List<IndexShard> indexShardList = Collections.synchronizedList(new ArrayList<>());
        IndexShard indexShard = indexService.getShard(0);
        allowDeprecationWarning();
                    logger.error("ConcurrentModificationException detected in thread : " + e.getMessage());
        // Check resulting stats
            result = 31 * result + dummyValue;
        assertEquals(2, cache.count());
        String indexName = "test1";
        assertTrue(requestCacheStats.stats().getMemorySize().bytesAsInt() > value.length());
        }
        assertEquals(2, requestCacheStats.stats().getMissCount());
        assertFalse(cleanupKeyToCountMap.get(shardId).containsKey(getReaderCacheKeyId(reader)));
        public boolean loadedFromCache = true;
            } catch (Exception ignored) {
        );
            } else {
            MergedSegmentPublisher.EMPTY,
        assertEquals("foo", value.streamInput().readString());
    public void testCacheCleanupBasedOnZeroThreshold() throws Exception {
        CacheConfig<IndicesRequestCache.Key, BytesReference> config;
        for (int i = 0; i < numberOfIndices; i++) {
                Loader loader = new Loader(reader, 0);
        indexShard = indexService.createShard(
        Loader thirdLoader = new Loader(thirdReader, 0);
        IOUtils.close(readerB1, readerA1, readerA2, readerB2);
        cache = getIndicesRequestCache(settings);
        BytesReference value3 = cache.getOrCompute(thirddEntity, thirdLoader, thirdReader, getTermBytes());
        String indexName = "test1";
            getTermBytes(),
        // 1 out of 2 keys ie 50% are now stale.
        }
        writer.addDocument(newDoc(0, "foo"));
        assertNotEquals(key1, key3);
        DirectoryReader secondReader = getReader(writer, shardId);
        // Verify response and stats.
        assertEquals(2, cache.count());
        assertEquals(1, cache.count());
        // Close the reader, to create stale entries
        List<DirectoryReader> readersToKeep = new ArrayList<>();
    }
        value = cache.getOrCompute(cacheEntity, loader, reader, getTermBytes());
                writer.addDocument(newDoc(j, generateString(randomIntBetween(4, 50))));
        requestCacheStats = entity.stats();
public class IndicesRequestCacheTests extends OpenSearchSingleNodeTestCase {
import org.opensearch.cluster.routing.ShardRoutingHelper;
        assertTrue(requestCacheStats.stats().getMemorySize().bytesAsInt() > value.length());
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
            new RemovalNotification<ICacheKey<IndicesRequestCache.Key>, BytesReference>(
        cache.onRemoval(
                } else {
                    }
        assertEquals(2, cache.numRegisteredCloseListeners());
import java.util.concurrent.atomic.AtomicInteger;
    }
                Runnable hook = onFirstLookup.getAndSet(null);
        IOUtils.close(secondReader);
            config = cache.getCacheConfig(settings, env);
        assertEquals("foo", value.streamInput().readString());
        DirectoryReader readerA2 = getReader(writer, indexShard.shardId());
    }
        writer.addDocument(newDoc(0, "foo"));
                try {
        IOUtils.close(reader);
        final DirectoryReader reader;
        loader = new Loader(reader, 0);
        value = cache.getOrCompute(entity, loader, reader, getTermBytes());
                IndexService indexService = null;
        // LRU order after insertion, head to tail: B2, A2, A1, B1
import org.opensearch.core.common.bytes.BytesReference;
        assertEquals(2, cache.count());
        );
import org.apache.lucene.index.IndexReader;
        assertEquals(2, requestCacheStats.stats().getHitCount());
        assertEquals("foo", value.streamInput().readString());
                loadedFromCache = false;
                RemovalReason.EVICTED
        final int cacheSize = requestCacheStats.stats().getMemorySize().bytesAsInt();
        // clear all for the indexShard Idendity even though is't still open
            RetentionLeaseSyncer.EMPTY,
            } catch (ConcurrentModificationException e) {
            }
            )
        ShardRouting newRouting = shardRouting;
                ClusterServiceUtils.createClusterService(threadPool),
        entity = new IndicesService.IndexShardCacheEntity(indexShard);
     * triggered deterministically from the entity lookup of the first swept entry, mimicking a concurrent
                assertNotNull(snapshot);
import org.opensearch.common.cache.store.config.CacheConfig;
            writer = new IndexWriter(dir, newIndexWriterConfig());
        // Cache some values for indexShard
                try {
        cache.cacheCleanupManager.cleanCache();
import static org.opensearch.indices.IndicesRequestCache.INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING;
import org.opensearch.Version;
            return null;
 * GitHub history for details.
            cache.clear(secondEntity);
                throw new RuntimeException(e);
        OpenSearchDirectoryReader.DelegatingCacheHelper delegatingCacheHelper = (OpenSearchDirectoryReader.DelegatingCacheHelper) reader
        assertEquals(0, cache.numRegisteredCloseListeners());
        assertEquals("foo", value.streamInput().readString());
        writer.addDocument(newDoc(0, "foo"));
import java.io.IOException;
            .build();
        int numShards = 3;
            )
    private IndicesService.IndexShardCacheEntity getEntity(IndexShard indexShard) {
            bytesReference = out.bytes();
        // Trigger clean up of cache.
        assertEquals(1, cache.count());
    }
        reader.close();
        IndicesService.IndexShardCacheEntity thirddEntity = new IndicesService.IndexShardCacheEntity(createIndex("test1").getShard(0));
        // cache count should not be affected
                    for (int j = 0; j < numberOfIterations; j++) {
        assertEquals(0, stats.getMissCount());
                    return Optional.empty();
            );
        requestCacheStats = entity.stats();
        writer.addDocument(newDoc(1, "hack"));
        BytesReference value3 = cache.getOrCompute(getEntity(indexShard), getLoader(thirdReader), thirdReader, getTermBytes());
        DirectoryReader reader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), indexShard.shardId());
        IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig());
            } catch (IOException e) {
        assertEquals(1, cache.cacheCleanupManager.getStaleKeysCount().get());
        assertEquals("bar", value2.streamInput().readString());
import org.opensearch.cluster.routing.RecoverySource;
        }
                    termBytes = XContentHelper.toXContent(termQuery, MediaTypeRegistry.JSON, false);
                concurrentModificationExceptionDetected.set(true); // Set flag if exception is detected
        cache.invalidate(entity, reader, getTermBytes());
        cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());
 * Unless required by applicable law or agreed to in writing,
                assertNull(snapshot);
        Directory dir = newDirectory();
import static org.opensearch.indices.IndicesRequestCache.INDEX_DIMENSION_NAME;
        assertTrue(cleanupKeyToCountMap.get(shardId).containsKey(getReaderCacheKeyId(secondReader)));
            writer.flush();
        // for the current shard.
        cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());
        cache.cacheCleanupManager.cleanCache();
        threadPool = getThreadPool();
            config = cache.getCacheConfig(settings, env);
            try (BytesStreamOutput out = new BytesStreamOutput()) {
        assertEquals(1, indexShard.requestCache().stats().getEvictions());
            }
        entity = new IndicesService.IndexShardCacheEntity(indexShard);
    public void testGetOrComputeConcurrentlyWithMultipleIndices() throws Exception {
        return OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), shardId);
    private Loader getLoader(DirectoryReader reader) {
        cache.getOrCompute(getEntity(indexShard), getLoader(readerA2), readerA2, getTermBytes());
        assertEquals(0, requestCacheStats.stats().getHitCount());
        // Create a shard
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "0.51").build();
        cache = getIndicesRequestCache(Settings.EMPTY);
            .put(
            return false;
        Loader loader = new Loader(reader, 0);
        BytesReference value = cache.getOrCompute(cacheEntity, loader, reader, getTermBytes());
            Settings.builder().put(IndicesRequestCache.INDICES_CACHE_QUERY_SIZE.getKey(), (int) (size.getBytes() * 1.2) + "b").build(),
        return new IndicesService.IndexShardCacheEntity(indexShard);
        assertEquals(0, requestCacheStats.stats().getEvictions());
    public void testCacheMaxSize_WhenStoreNameAbsent() throws Exception {
        // cleanup should have taken effect with 49% threshold
        IndexService indexService = createIndex(
        // Now we cache again with new IndexShard(same shardId as older one).
        assertEquals(0, requestCacheStats.stats().getMemorySize().bytesAsInt());
        // clean cache with 49% staleness threshold
    public void testStaleCount_WithoutReaderClosing_DecrementsStaleCount() throws Exception {
            Settings.builder()
        @Override
        IndicesRequestCache cache = getIndicesRequestCache(
        Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards).build();
        assertEquals(key1, key1);
        assertFalse(concurrentModificationExceptionDetected.get());
        threadPool = getThreadPool();
        // not-yet-visited entry, relinking it at the head of the LRU list. The loader throws so the hit
 */
import org.opensearch.common.unit.TimeValue;
        writer.addDocument(newDoc(0, "foo"));
        assertEquals(1, cache.count());
        DirectoryReader reader = getReader(writer, indexShard.shardId());
            new RemovalNotification<ICacheKey<IndicesRequestCache.Key>, BytesReference>(
        assertEquals(1, cache.count());
                new ICacheKey<>(key),
                threadPool,
            // the old API to account for the ICacheKey overhead.
        cache.getOrCompute(getEntity(secondShard), getLoader(readerB2), readerB2, getTermBytes());
        assertEquals(0, cache.count());
            DirectoryReader secondReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "bar", 1));
import org.opensearch.index.cache.request.RequestCacheStats;
        // initial cache
import org.apache.lucene.document.StringField;
            null,
import java.util.UUID;
        assertEquals(1, cache.count());
        assertTrue(cleanupKeyToCountMap.containsKey(shardId));
 *
                new ICacheKey<>(key),
        assertEquals(1, cache.count());
        cache.cacheCleanupManager.cleanCache();
            Directory dir = newDirectory();
        IOUtils.close(secondReader);
        indexShard = createIndex("test").getShard(0);
        threadPool = getThreadPool();
        IOUtils.close(secondReader);
        assertEquals(1, (int) cleanupKeyToCountMap.get(shardId).get(getReaderCacheKeyId(reader)));
        // since all the readers of this shard is closed, the cleanupKeyToCountMap should have no entries
    }
    @After
        assertEquals(2, cache.count());
        for (List<String> dimensionValues : initialDimensionValues) {
                initialDimensionValues.add(dimensionValues);
        assertEquals(2, cache.count());
        IOUtils.close(reader);
import org.opensearch.core.common.unit.ByteSizeValue;
        }
    }
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());
        value = cache.getOrCompute(entity, loader, secondReader, getTermBytes());
        writer.addDocument(newDoc(0, "foo"));
        terminate(threadPool);
        DirectoryReader secondReader = getReader(writer, indexShard.shardId());
        // cache count should not be affected
    }
    // test staleness count based on removal notifications
import org.opensearch.cluster.routing.UnassignedInfo;
            executorService.submit(() -> {
            writerMap.get(indexShard).close();
    }
            new RemovalNotification<ICacheKey<IndicesRequestCache.Key>, BytesReference>(
        assertEquals(1, cache.count());
            getTermBytes(),
        assertEquals(1, (int) cleanupKeyToCountMap.get(shardId).get(getReaderCacheKeyId(secondReader)));
                }
        ShardRequestCache requestCacheStats = entity.stats();
                }
            },
        RequestCacheStats requestCacheStats = entity.stats().stats();
        reader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), indexShard.shardId());
                    readersToClose.add(reader);
            this.reader = reader;
            threadPool = getThreadPool();
            assertEquals(i, cache.count());
        }
        }
    // test the cleanupKeyToCountMap are set appropriately when both readers are closed
import java.util.concurrent.CountDownLatch;
        writer.updateDocument(new Term("id", "0"), newDoc(0, "bar"));
        DirectoryReader secondReader = getReader(writer, indexShard.shardId());
            for (int j = 0; j < numberOfItems; j++) {
        cache.cacheCleanupManager.cleanCache();
        IOUtils.close(reader, secondReader);
                }
        String s = IndicesRequestCache.validateStalenessSetting("0.5%");
        // Now stats for the closed index should be gone
        assertTrue(loader.loadedFromCache);
        assertEquals(((IndexShard) shardCacheEntity.getCacheIdentity()).shardId(), key2.shardId);
        TermQueryBuilder termQuery = new TermQueryBuilder("id", "0");
    }
                for (int j = 0; j < numberOfIterations; j++) {
        String rKey1 = ((OpenSearchDirectoryReader) reader1).getDelegatingCacheHelper().getDelegatingCacheKey().getId();
        assertEquals(2, cache.count()); // One entry for older shard and other for the current shard.
                ClusterServiceUtils.createClusterService(threadPool),
        assertEquals(0, requestCacheStats.stats().getEvictions());
                latch.countDown();
            newField("value", value, StringField.TYPE_STORED)
import org.opensearch.index.shard.IndexShardTestCase;
        reader.close();
        key = new IndicesRequestCache.Key(indexShard.shardId(), getTermBytes(), getReaderCacheKeyId(secondReader), indexShard.hashCode());
            IndexShard indexShard = createIndex(
        ShardId shardId = indexShard.shardId();
import org.opensearch.index.IndexService;
    }
        DirectoryReader readerB2 = getReader(writer, secondShard.shardId());
        int numberOfIterations = 1000;
        assertTrue(cleanupKeyToCountMap.get(shardId).containsKey(getReaderCacheKeyId(secondReader)));
            indexShard.hashCode()
        );
                            // Accessing the map to create contention
            try {
            }
import java.util.concurrent.Phaser;
        DirectoryReader secondReader = getReader(writer, indexShard.shardId());
    }
                try {
            IndexShard indexShard = indexShardList.get(i);
                .build()
        assertEquals(3, cache.count());
        assertEquals("foo", value.streamInput().readString());
            IOUtils.close(reader);
        // Remove the shard making its cache entries stale
        writer.addDocument(newDoc(0, "foo"));
        public int hashCode() {
        threadPool = getThreadPool();
                IndexSearcher searcher = new IndexSearcher(reader);
        dir = newDirectory();
import org.opensearch.core.index.Index;
                ClusterServiceUtils.createClusterService(threadPool),
        DirectoryReader reader = getReader(writer, indexShard.shardId());
        assertEquals(2, requestCacheStats.stats().getMissCount());
    }
        // cannot re-insert the entry if the sweep already removed it (snapshot order is arbitrary).
        AtomicReference<Runnable> onFirstLookup = new AtomicReference<>();
import org.junit.After;
        TermQueryBuilder termQuery = new TermQueryBuilder("id", "0");
        cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());
        assertEquals("baz", value3.streamInput().readString());
        latch.await();
        assertTrue(stats.getMemorySizeInBytes() > 0);
        return new Loader(reader, 0);
        // Close the reader, this should create a stale key
        IndexReader reader2 = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), shardId);
        // Create two indices each with multiple shards
import static org.mockito.Mockito.when;
            writerMap.get(indexShard).getDirectory().close();
            Settings.builder()
            RequestCacheStats stats = entity.stats().stats();
        // cache count should not be affected
        if (randomBoolean()) {
        Map<IndexShard, DirectoryReader> readerMap = new ConcurrentHashMap<>();
        assertEquals("foo", value.streamInput().readString());
        IOUtils.close(secondReader);
                BytesReference termBytes = null;
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
        IndicesRequestCache cache = getIndicesRequestCache(Settings.EMPTY);
        // eviction of previous stale key from the cache should decrement staleKeysCount in iRC
        assertTrue(loader.loadedFromCache);
        }
        assertEquals(2, cache.count());
    public void testSerializationDeserializationOfCacheKey() throws Exception {
    }
        assertEquals(2, requestCacheStats.stats().getMissCount());
    }
        }
        for (int i = 0; i < numberOfIndices; i++) {
        assertEquals(1, cache.numRegisteredCloseListeners());
        assertEquals(1, cache.count());
    public void testClosingIndexWipesStats() throws Exception {
        );
        DirectoryReader reader = getReader(writer, indexShard.shardId());
                RemovalReason.EVICTED
        staleKeysCount = cache.cacheCleanupManager.getStaleKeysCount();
        assertEquals(1, cache.numRegisteredCloseListeners());
            indexShard.close("test", true, true); // closed shard but reader is still open
        String[] levels = { INDEX_DIMENSION_NAME, SHARD_ID_DIMENSION_NAME };
                .put(IndicesRequestCache.INDICES_REQUEST_CACHE_CLEANUP_INTERVAL_SETTING_KEY, TimeValue.timeValueMillis(100000))
        CountDownLatch latch = new CountDownLatch(numberOfItems);
        allowDeprecationWarning();
        ShardId shardId = indexShard.shardId();
        // shard id should NOT exist
            assertTrue(stats.getMissCount() >= 0);
            indexShard.shardId(),
                    concurrentModificationExceptionDetected.set(true); // Set flag if exception is detected
    public void testIndexShardClosedAndVerifyCacheCleanUpWorksSuccessfully() throws Exception {
                cache.getOrCompute(entity, loader, reader, termBytes);
import org.opensearch.cluster.node.DiscoveryNode;
        assertEquals(key1, key2);
        cache.cacheCleanupManager.cleanCache();
        threadPool = getThreadPool();
        TermQueryBuilder termQuery = new TermQueryBuilder("id", "bar");
        assertEquals(2, cache.count());
        IndicesRequestCache.Key key = new IndicesRequestCache.Key(
        cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes("id", "1"));
                List<String> dimensionValues = List.of(shardId.getIndexName(), shardId.toString());
        // Verify that cache still has entries for current shard and only removed older shards entries.
        requestCacheStats = entity.stats();
    }
            return other instanceof TestBytesReference && this.dummyValue == ((TestBytesReference) other).dummyValue;
        assertTrue(stats.getMemorySizeInBytes() > 0);
        assertEquals(2, cache.count());
                return indicesService.indicesRequestCache.cacheEntityLookup.apply(shardId);
        cache = getIndicesRequestCache(Settings.EMPTY);
        if (randomBoolean()) {
        DirectoryReader secondReader = getReader(writer, indexShard.shardId());
        ShardId shardId = indexShard.shardId();
        assertEquals(2, cache.count());
            cache = new IndicesRequestCache(Settings.EMPTY, shardId -> {
        assertEquals(1, requestCacheStats.stats().getHitCount());
        // stale keys count should stay zero
    private IndexShard indexShard;
            )
        threadPool = getThreadPool();
import java.util.concurrent.TimeUnit;
        AtomicBoolean concurrentModificationExceptionDetected = new AtomicBoolean(false);
        logger.info("Memory size: {}", indexShard.requestCache().stats().getMemorySize());
import java.util.Optional;
    private void allowDeprecationWarning() {
        loader = new Loader(secondReader, 0);
    public void testCacheDifferentReaders() throws Exception {
        // we could get readers that were properly connected to an index's directory
        DirectoryReader thirdReader = getReader(writer, indexShard.shardId());
        DirectoryReader secondReader = getReader(writer, indexShard.shardId());
        TermQueryBuilder termQuery = new TermQueryBuilder(fieldName, value);
        stats = indexShard.requestCache().stats();
        );
    private static class Loader implements CheckedSupplier<BytesReference, IOException> {
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());
            writer.flush();
    }
        DirectoryReader reader = getReader(writer, indexShard.shardId());
        assertEquals("0.5%", s);
        assertEquals(2, cache.count());
        allowDeprecationWarning();
        writer.addDocument(newDoc(0, "foo"));
        cache.onRemoval(
                cache.getOrCompute(
        // This actually closes the shards associated with the readers, which is necessary for cache cleanup logic
    }
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());
        assertEquals(1, cache.cacheCleanupManager.getStaleKeysCount().get());
        ShardRequestCache requestCacheStats = indexShard.requestCache();
        // shard id should exist
            IOUtils.close(reader, secondReader, writer, dir, cache);
                }
 *
        assertTrue(loader.loadedFromCache);
        // Close the reader, to be enqueued for cleanup
        BytesReference value = cache.getOrCompute(cacheEntity, loader, reader, getTermBytes());
 * under the License.
        // test the mappings
        }
        // Verify all cleared up.
        writer.updateDocument(new Term("id", "0"), newDoc(0, "baz"));
            .getCleanupKeyToCountMap();
        cache.cacheCleanupManager.cleanCache();
}
        threadPool = getThreadPool();
            // TODO: Add wiggle room to max size to allow for overhead of ICacheKey. This can be removed once API PR goes in, as it updates
        assertEquals("baz", value3.streamInput().readString());
            localNode,
                TermQueryBuilder termQuery = new TermQueryBuilder("id", generateString(randomIntBetween(4, 50)));
        IndicesRequestCache cache = getIndicesRequestCache(
        // no keys are stale yet
            });
                new ICacheKey<>(key),
        assertEquals(2, requestCacheStats.stats().getMissCount());
        assertEquals("foo", value.streamInput().readString());
    }
        final long hitCount = requestCacheStats.getHitCount();
        IOUtils.close(cache);
        for (IndexService indexService : new IndexService[] { indexToKeep, indexToClose }) {
import org.opensearch.cluster.metadata.IndexMetadata;
        // Get 2 entries into the cache
                int randomIndexPosition = randomIntBetween(0, numberOfIndices - 1);
        Settings settings = Settings.builder()
        // Main thread iterates over the map
        // Both second-shard entries must be removed; only the two live first-shard entries remain
        assertTrue(loader.loadedFromCache);
        writer.addDocument(newDoc(0, "foo"));
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
        // cleanup should have taken effect
        assertEquals(2, requestCacheStats.stats().getMissCount());
        // cache count should not be affected
        assertEquals(1, cache.numRegisteredCloseListeners());
        for (DirectoryReader reader : readersToClose) {
import org.apache.lucene.util.BytesRef;
        cache = getIndicesRequestCache(settings);
        termQuery = new TermQueryBuilder("id", "bar");
        assertEquals(1, requestCacheStats.stats().getHitCount());
        IOUtils.close(secondReader);
            cache = getIndicesRequestCache(Settings.EMPTY);
        assertEquals(readerCacheKeyId, key2.readerCacheKeyId);
        // Get 5 entries into the cache
            reader.close();
import org.opensearch.node.Node;
        IndicesRequestCache.Key key = new IndicesRequestCache.Key(
import static org.mockito.Mockito.mock;
            indexShard.close("test", true, true); // closed shard but reader is still open
            }),
        StreamInput in = bytesReference.streamInput();
        BytesReference termBytes = XContentHelper.toXContent(termQuery, MediaTypeRegistry.JSON, false);
            sb.append(characters.charAt(index));
        cache.cacheCleanupManager.cleanCache();
                ImmutableCacheStatsHolder holder = cache.stats(levels);
import java.util.concurrent.atomic.AtomicBoolean;
        }
 *
        // secondReader CacheKeyId should exist
        long cacheSize = 1000;
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());
        NodeEnvironment environment = newNodeEnvironment();
        BytesReference value = cache.getOrCompute(entity, loader, reader, getTermBytes());
        // secondReader CacheKeyId should exist
        ShardId shardId = new ShardId("foo", "bar", 1);
    }
            null,
                getTermBytes(),
import org.opensearch.common.cache.module.CacheModule;
            ClusterServiceUtils.createClusterService(threadPool),
        cache.cacheCleanupManager.cleanCache();
        IOUtils.close(secondReader);
                    });
        // evict entry from second reader (this reader is not closed)
            getTermBytes(),
        IOUtils.close(writer, dir, cache);
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        // release
        cache.cacheCleanupManager.cleanCache();
        IndicesService.IndexShardCacheEntity entity = new IndicesService.IndexShardCacheEntity(indexShard);
                logger.error("ConcurrentModificationException detected in main thread : " + e.getMessage());
        assertEquals(1, stats.getMissCount());
    }
                RemovalReason.EVICTED
        return delegatingCacheHelper.getDelegatingCacheKey().getId();
    }
        DirectoryReader reader = getReader(writer, indexShard.shardId());
        return XContentHelper.toXContent(termQuery, MediaTypeRegistry.JSON, false);
            for (int i = 0; i < numShards; i++) {
        writer = new IndexWriter(dir, newIndexWriterConfig());
                assertNotEquals(0, snapshot.getItems());
    public void testDeleteAndCreateIndexShardOnSameNodeAndVerifyStats() throws Exception {
            new RemovalNotification<ICacheKey<IndicesRequestCache.Key>, BytesReference>(
        assertWarnings(
        IndexShard indexShard = mock(IndexShard.class);
    }
        DirectoryReader reader = getReader(writer, indexShard.shardId());
            DirectoryReader reader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), indexShard.shardId());
        assertEquals(staleCount, cache.cacheCleanupManager.getStaleKeysCount().get());
                indicesService.indicesRequestCache.cacheEntityLookup,
        // cache count should not be affected
                }
    // when a cache entry that is Stale is evicted for any reason, we have to deduct the count from our staleness count
        // staleKeysCount should be the same as before
        // cache hit
    }
        // Create a shard
        assertEquals(4, cache.count());
            (shardId -> Optional.of(new IndicesService.IndexShardCacheEntity(indexShard))),
    public void testCacheCleanupThresholdSettingValidator_InValid_MB() {
import org.opensearch.common.cache.stats.ImmutableCacheStatsHolder;
 * this work for additional information regarding copyright
        // test the mapping, shardId entry should be cleaned up
            assertTrue(stats.getEvictions() >= 0);
            indexShard.shardId(),
        cache = getIndicesRequestCache(settings);
        cache = getIndicesRequestCache(Settings.EMPTY);
        List<String> indicesList = new ArrayList<>();
            "[indices.requests.cache.size] setting was deprecated in OpenSearch and will be removed in a future release! See the breaking changes documentation for the next major version."
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        // shard id should exist
        // Remove the shard making its cache entries stale
    public void testCleanupKeyToCountMapAreSetAppropriately() throws Exception {
        assertEquals(1, requestCacheStats.stats().getHitCount());
        cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());
        }
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "0%").build();
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());
        assertEquals(1, staleKeysCount.get());
            );
            int result = super.hashCode();
        cache.setStalenessThreshold("49%");
import java.util.Map;
        indexShard = createIndex("test1").getShard(0);
        );
        try (NodeEnvironment env = newNodeEnvironment(Settings.EMPTY)) {
        Directory dir = newDirectory();
        IndexReader reader1 = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), shardId);
            writer = new IndexWriter(dir, newIndexWriterConfig());
            indexShard.shardId(),
        assertEquals(0, requestCacheStats.stats().getEvictions());
                phaser.arriveAndAwaitAdvance(); // Ensure all threads start at the same time
        // Get 2 entries into the cache from 2 different readers
        assertEquals(1, cache.cacheCleanupManager.getStaleKeysCount().get());
        assertEquals(0, requestCacheStats.stats().getEvictions());
        assertEquals(1, requestCacheStats.stats().getMissCount());
        // While the sweep processes its first entry, a concurrent request hits the second shard's
                assertNotNull(snapshot);
        @Override
            int finalI = i;
        // stale keys count should stay the same
        IndicesRequestCache.Key key = new IndicesRequestCache.Key(
        assertFalse(loader.loadedFromCache);
import org.opensearch.index.cache.request.ShardRequestCache;
import org.opensearch.index.shard.IndexShardState;
        cache = getIndicesRequestCache(settings);
            }
                RemovalReason.REPLACED
        assertFalse(loader.loadedFromCache);
                // check the values are not empty by confirming entries != 0, this should always be true since the missed value is loaded
        assertEquals(hitCount + 1, requestCacheStats.getHitCount());
        IOUtils.close(reader, secondReader, thirdReader, environment);
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "0.51").build();
            getReaderCacheKeyId(secondReader),
            ImmutableCacheStats snapshot = cache.stats(levels).getStatsForDimensionValues(dimensionValues);
                );
        }
        // Get 2 entries into the cache
        DirectoryReader reader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), indexShard.shardId());
        );
        DirectoryReader secondReader = getReader(writer, indexShard.shardId());
        // Cache some values for indexShard
        );
        assertEquals(0, cache.cacheCleanupManager.getStaleKeysCount().get());
        threadPool = getThreadPool();
        writer = new IndexWriter(dir, newIndexWriterConfig());
        int staleCount = cache.cacheCleanupManager.getStaleKeysCount().get();
        cache.onRemoval(
            indexShard.close("test", true, true); // closed shard but reader is still open
    public void testCacheCleanupBasedOnStaleThreshold_StalenessHigherThanThreshold() throws Exception {
                new ICacheKey<>(key),
        // reader CacheKeyId should NOT exist
        // 1 out of 2 keys ie 50% are now stale.
            IndicesService.IndexShardCacheEntity entity = entityMap.get(indexShard);
        // Put entries into the cache for each shard
import java.util.List;
        IndicesRequestCache.Key key1 = new IndicesRequestCache.Key(shardId, new TestBytesReference(1), rKey1, shardId.hashCode());
        }
            );
        }
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // Assert response and stats. We verify that cache now has 2 entries, one for older/removed shard and other
        requestCacheStats.add(thirddEntity.stats().stats());
            .getReaderCacheHelper();
        } else {
            RequestCacheStats stats = entity.stats().stats();
        assertEquals(1, cache.count());
        DirectoryReader reader = getReader(writer, indexShard.shardId());
            assertEquals(0, stats.getMemorySizeInBytes());
        writer.addDocument(newDoc(0, "foo"));
        // We again try to create a shard with same ShardId
        reader.close();
                        v.forEach((k1, v1) -> {
        cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());
import org.opensearch.index.engine.MergedSegmentWarmerFactory;
                settings,
        threadPool = getThreadPool();
                new ICacheKey<>(key),
        IndexShard indexShard = (IndexShard) entity.getCacheIdentity();
        }
        loader = new Loader(reader, 0);
        value = cache.getOrCompute(entity, loader, reader, getTermBytes());
                // into the cache
    private Directory dir;
        for (int i = 0; i < numberOfThreads; i++) {
            int index = randomInt(characters.length() - 1);
        assertEquals(2, (int) cleanupKeyToCountMap.get(shardId).get(getReaderCacheKeyId(secondReader)));
        assertEquals(1, cache.numRegisteredCloseListeners());
                return out.bytes();
        // Close the reader, to be enqueued for cleanup
        // Close the reader, to be enqueued for cleanup
            return 0;
        writer.addDocument(newDoc(1, "hack"));
        // Set clean interval to a high value as we will do it manually here.
        writer.updateDocument(new Term("id", "0"), newDoc(0, "bar"));
        }
                    readersToKeep.add(reader);
            ).getShard(0);
                threadPool,
        writer.addDocument(newDoc(0, "foo"));
import static org.opensearch.indices.IndicesRequestCache.SHARD_ID_DIMENSION_NAME;
        StringBuilder sb = new StringBuilder(length);
        // third has not been validated since it's a different identity
    public void setup() throws IOException {
 */
        reader.close();
        // Trigger clean up of cache and verify that cache has no entries now.
        assertTrue(cleanupKeyToCountMap.containsKey(shardId));
        BytesReference value2 = cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());
        assertEquals(0, cache.count());
        @Override
            return 0;
    }
    // when staleness count equal to stale threshold, stale keys should be cleaned up.
import java.util.ArrayList;
    public void testCacheCleanupBasedOnStaleThreshold_thresholdUpdate() throws Exception {
        );
        cache.invalidateAll();
        for (int i = 0; i < numberOfIndices; i++) {
        reader.close();
    public void testCacheCleanupThresholdSettingValidator_Valid_Double() {
    public static String generateString(int length) {
        stats = indexShard.requestCache().stats();
import org.apache.lucene.document.Document;
    // test adding to cleanupKeyToCountMap with multiple threads
            }
        DirectoryReader thirdReader = OpenSearchDirectoryReader.wrap(DirectoryReader.open(writer), new ShardId("foo", "bar", 1));
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
        IndicesService.IndexShardCacheEntity entity = null;
    public void testStaleCount_OnRemovalNotifications() throws Exception {
        // test the mapping
        assertEquals(2, cache.count());
    public void testAddingToCleanupKeyToCountMapWorksAppropriatelyWithMultipleThreads() throws Exception {
            secondReader.close();
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "0.51").build();
        IndexShardTestCase.updateRoutingEntry(indexShard, newRouting);
        assertEquals(0, cache.count());
    }
 * specific language governing permissions and limitations
                new CacheModule(new ArrayList<>(), Settings.EMPTY).getCacheService(),
        ShardId shardId1 = new ShardId("foo1", "bar1", 2);
        int numberOfThreads = 10;
    }
    public void testCacheCleanupThresholdSettingValidator_Valid_Percentage() {
        assertTrue(stats.getMemorySizeInBytes() > 0);
            indicesList.add(indexName);
        // cache hit
        @Override
        assertThrows(IllegalArgumentException.class, () -> { IndicesRequestCache.validateStalenessSetting("500%"); });
            cache.clear(entity);
            BytesReference value2 = cache.getOrCompute(getEntity(indexShard), getLoader(secondReader), secondReader, getTermBytes());
            BytesReference value1 = cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());
        @Override
                }
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
        DirectoryReader reader = getReader(writer, indexShard.shardId());
        assertEquals(1, cache.count());
        assertEquals(0, cache.count());
            this.id = id;
        IndexService indexToClose = createIndex(indexToCloseName, indexSettings);
            readerMap.put(indexShard, reader);
            key1.writeTo(out);
        assertEquals(0, requestCacheStats.stats().getEvictions());
        Loader loader = new Loader(reader, 0);
            getReaderCacheKeyId(reader),
        assertFalse(loader.loadedFromCache);
        assertEquals(1, requestCacheStats.stats().getMissCount());
        threadPool = getThreadPool();
     * and passes with the point-in-time snapshot.
        public BytesReference slice(int from, int length) {
        IndicesService.IndexShardCacheEntity cacheEntity = new IndicesService.IndexShardCacheEntity(indexShard);
/*
            cache = new IndicesRequestCache(settings, (shardId -> {
 * compatible open source license.
            getReaderCacheKeyId(reader),
            indexName,
    }
        cache = getIndicesRequestCache(settings);
                }
            indexName,
        DirectoryReader reader = getReader(writer, indexShard.shardId());
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        // cleanup should have been ignored
    public void testCacheMaxSize_WhenStoreNamePresent() throws Exception {
        // clean cache with 51% staleness threshold
import org.apache.lucene.document.Field;
        String indexToKeepName = "test";
        assertFalse(cleanupKeyToCountMap.get(shardId).containsKey(getReaderCacheKeyId(reader)));
        assertEquals("bar", value.streamInput().readString());
            reader.close();
        // test the mapping, it should stay the same
        assertEquals(0, requestCacheStats.stats().getMemorySize().bytesAsInt());
    }
        cache = getIndicesRequestCache(settings);
        assertEquals(0, (long) config.getMaxSizeInBytes());
            SegmentReplicationCheckpointPublisher.EMPTY,
        // Closing the cache doesn't modify an already returned CacheEntity
    public void testStaleCount_OnRemovalNotificationOfStaleKey_DecrementsStaleCount() throws Exception {
        // create another entry for the second reader
            if (dimensionValues.get(0).equals(indexToCloseName)) {
        int numberOfIndices = randomIntBetween(2, 5);
        assertEquals(2, cache.count());
 * license agreements. See the NOTICE file distributed with
                if (hook != null) {
            assertNotNull(indexToKeep.getShard(i));
            assertEquals("bar", value2.streamInput().readString());
        public BytesReference get() {
    }
        assertTrue(requestCacheStats.stats().getMemorySize().bytesAsInt() > value.length());
            readerMap.get(indexShard).close();
                RemovalReason.EVICTED
 * KIND, either express or implied.  See the License for the
        String indexToCloseName = "test2";
        assertEquals(1, requestCacheStats.stats().getMissCount());
            )
        });
                    throw new RuntimeException(e);
                getTermBytes(),
                    hook.run();
                new CacheModule(new ArrayList<>(), Settings.EMPTY).getCacheService(),
        threadPool = getThreadPool();
        }
        writer.addDocument(newDoc(0, "foo"));
        dir = newDirectory();
        value3 = cache.getOrCompute(thirddEntity, thirdLoader, thirdReader, getTermBytes());
            DiscoveryNodes.builder().add(localNode).build(),
        // closing the reader should make all keys stale
        @Override
            }
 */
        BytesReference value1 = cache.getOrCompute(getEntity(indexShard), getLoader(reader), reader, getTermBytes());
                            v.get(k1);
        threadPool = getThreadPool();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsPublisher;
        // clean cache with 49% staleness threshold
import org.opensearch.common.cache.CacheType;
                }
    public void testEqualsKey() throws IOException {
                        cache.cacheCleanupManager.addToCleanupKeyToCountMap(indexShard.shardId(), UUID.randomUUID().toString());
     * search request. This test fails if the sweep iterates the live LRU view of the on-heap cache's keys
import org.opensearch.cluster.routing.ShardRouting;
                getTermBytes(),
        IndexShard secondShard = createIndex("second-test").getShard(0);
        assertEquals(2, cache.count());
        assertEquals(2, requestCacheStats.stats().getMissCount());
import org.apache.lucene.store.Directory;
            indexShard.shardId(),
import org.apache.lucene.search.TermQuery;
        writer.updateDocument(new Term("id", "0"), newDoc(0, "bar"));
        assertEquals("foo", value1.streamInput().readString());
                new ICacheKey<>(key),
        int dummyValue;
        assertEquals(1, (int) cleanupKeyToCountMap.get(shardId).get(getReaderCacheKeyId(secondReader)));
        }
        Index idx = resolveIndex(indexName);
            newField("id", Integer.toString(id), StringField.TYPE_STORED),
                    cache.cacheCleanupManager.getCleanupKeyToCountMap().forEach((k, v) -> {
        DirectoryReader reader = getReader(writer, indexShard.shardId());
        Settings settings = Settings.builder().put(INDICES_REQUEST_CACHE_STALENESS_THRESHOLD_SETTING.getKey(), "51%").build();
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build()
        threadPool = getThreadPool();
import org.opensearch.index.IndexNotFoundException;
