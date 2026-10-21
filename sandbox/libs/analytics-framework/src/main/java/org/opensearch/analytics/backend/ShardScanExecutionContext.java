    public void setIndexSettings(IndexSettings indexSettings) {
     * @param task the transport-created task for this fragment execution
package org.opensearch.analytics.backend;
import org.opensearch.core.index.shard.ShardId;
    }
    public void setHasDeletedDocs(boolean hasDeletedDocs) {
        this.hasPartialAggregate = hasPartialAggregate;
    private BufferAllocator allocator;
        return importStagingAllocator;
 * compatible open source license.
    }
import org.opensearch.analytics.spi.ShuffleBufferRegistry;
    public void setQueryCache(QueryCache queryCache) {
    private byte[] fragmentBytes;
    public ShardId getShardId() {
    /** Returns the shard's index settings. */
    }
    /** Sets the node-scoped import staging allocator. The caller owns its lifecycle. */
    /**
 *
    /** Sets the backend-specific serialized plan fragment bytes. */
import org.opensearch.tasks.Task;
    /** Returns the target table name. */
        return queryCache;
    public void setMapperService(MapperService mapperService) {
    private NamedWriteableRegistry namedWriteableRegistry;
    public Task getTask() {
    public String getTableName() {
        return queryCachingPolicy;
    public void setNamedWriteableRegistry(NamedWriteableRegistry namedWriteableRegistry) {
    }
    }
    /** Returns the query caching policy for Lucene filter delegation. */
import org.opensearch.index.engine.exec.IndexReaderProvider.Reader;
    }
     *       root on the FIRST emitted batch's vector allocator and charges that same allocator for every
        this.queryCache = queryCache;
     *       buffer as it walks the array; a target that fills part-way through throws, and arrow-java
     *       be long-lived (not closed per-request)"), and frees it asynchronously with its own channel.</li>
    private final String tableName;
 */
public class ShardScanExecutionContext implements CommonExecutionContext {
import org.opensearch.index.IndexSettings;
     */
    }
 * SPDX-License-Identifier: Apache-2.0
    /** Sets the shard's index settings. */
        return shuffleBufferRegistry;
/**
        return namedWriteableRegistry;
        return mapperService;
    }
    }
     *       without rolling back, so the C Data release callback never fires and the whole batch leaks in
    public BufferAllocator getImportStagingAllocator() {
    private BufferAllocator importStagingAllocator;
        return indexSettings;
import org.apache.lucene.search.QueryCachingPolicy;
    /** Returns the NamedWriteableRegistry for deserializing delegated expressions. */
    /**
     */
    }
        this.importStagingAllocator = importStagingAllocator;
        return reader;
    public void setFragmentBytes(byte[] fragmentBytes) {
     *       the producer's native allocator — invisible to the JVM heap and to Java Arrow accounting.</li>
        this.task = task;
        return allocator;
    /** Sets the shard's mapper service. */
    /**
    private MapperService mapperService;
     *       (&le; 18.1.0) retains the imported array before the throwing {@code wrapForeignAllocation}
     * Sourced from the accepting backend's {@code hasDeletedDocs} probe at data-node search start;
        this.shuffleBufferRegistry = shuffleBufferRegistry;
     * @param tableName the target table name
    /** Sets the query caching policy. */
    public void setQueryCachingPolicy(QueryCachingPolicy queryCachingPolicy) {
/*
     * Returns the allocator Arrow C Data Interface imports are staged on, or null if the caller did not
     * Whether the shard has segments with deleted documents that need filtering at query time.
    public void setShuffleBufferRegistry(ShuffleBufferRegistry shuffleBufferRegistry) {
import org.opensearch.analytics.spi.CommonExecutionContext;
     *   <li><b>Unbounded, parented at the root.</b> {@code Data#importIntoVectorSchemaRoot} charges each
 * @opensearch.internal
    /**
    public ShuffleBufferRegistry getShuffleBufferRegistry() {
    public BufferAllocator getAllocator() {
     * deleted-doc filtering path.
     *   <li><b>Node-scoped, never closed per request.</b> The Flight transport builds its reused stream
    private ShardId shardId;
    /** Whether the fragment contains a PARTIAL aggregate instruction. */
import org.apache.lucene.search.QueryCache;
     */
import org.opensearch.index.mapper.MapperService;
     * are filling. Other handlers (broadcast, scan, partial-aggregate) ignore it.
    private boolean hasDeletedDocs;
    }
    }
     * hash-shuffle workers (analytics-engine binds {@code ShuffleBufferManager} as singleton);
    public Reader getReader() {
    }
    public void setHasPartialAggregate(boolean hasPartialAggregate) {
    }
     */
     * </ul>
 * Execution context carrying reader and plan state through
    /** Sets the per-node shuffle buffer registry. Called once per fragment by
     * @param reader the data-format aware reader
        return hasPartialAggregate;
    }
        return hasDeletedDocs;
        this.shardId = shardId;
    }
 *
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    /** Sets the NamedWriteableRegistry. */
    public byte[] getFragmentBytes() {
    public QueryCachingPolicy getQueryCachingPolicy() {
        return shardId;
     * set one. Distinct from {@link #getAllocator()} on two properties a batch import depends on:
}
    }
    public void setImportStagingAllocator(BufferAllocator importStagingAllocator) {
    }
    private ShuffleBufferRegistry shuffleBufferRegistry;
    }
    }
    /** Returns the shard's mapper service for field type resolution. */
    private final Reader reader;
    public NamedWriteableRegistry getNamedWriteableRegistry() {
        return task;
    public QueryCache getQueryCache() {
        this.allocator = allocator;
     * read by instruction handlers to route deletion-bearing shards through the indexed
    }
    public boolean hasDeletedDocs() {
    }
    /** Returns the backend-specific serialized plan fragment bytes, or null if not set. */
    }
    private QueryCachingPolicy queryCachingPolicy;
        return tableName;
        this.tableName = tableName;
 * the query execution lifecycle.
    public void setShardId(ShardId shardId) {
        this.reader = reader;
        this.indexSettings = indexSettings;
        return fragmentBytes;
     * null when no such backend is registered. Hash-shuffle scan handlers consult this to
 * this file be licensed under the Apache-2.0 license or a
     *       later batch ({@code FlightServerChannel#transferIntoStreamRoot}: "The producer's allocator must
    }
    /** Returns the data-format aware reader. */
    }
    public MapperService getMapperService() {
        this.fragmentBytes = fragmentBytes;
    /** Sets the node-level query cache. */
    /** Returns the transport-created task for this fragment execution. */
import org.apache.arrow.memory.BufferAllocator;
    private QueryCache queryCache;
     * <ul>
     * Constructs an execution context.
 */
        this.hasDeletedDocs = hasDeletedDocs;
    public IndexSettings getIndexSettings() {
 * The OpenSearch Contributors require contributions made to
    /** Returns the caller-provided allocator for producing Arrow result buffers. */
    private boolean hasPartialAggregate;
    }
     * Returns the per-node shuffle buffer registry. Non-null when the data node hosts
     *  {@code AnalyticsSearchService} when building the context. */
     * locate the buffer for the {@code (queryId, stageId, partitionIndex)} bucket the producers
    /** Returns the node-level query cache for Lucene filter delegation. */
    }
    }
        this.mapperService = mapperService;
    public boolean hasPartialAggregate() {
        this.queryCachingPolicy = queryCachingPolicy;
    private IndexSettings indexSettings;
    /** Sets the caller-provided allocator. The caller owns its lifecycle; the engine must not close it. */
    private final Task task;
        this.namedWriteableRegistry = namedWriteableRegistry;
    public ShardScanExecutionContext(String tableName, Task task, Reader reader) {
    public void setAllocator(BufferAllocator allocator) {
     * Caller-owned: the engine imports onto it and must never close it.
