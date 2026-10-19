     * hash-shuffle workers (analytics-engine binds {@code ShuffleBufferManager} as singleton);
     * Constructs an execution context.
import org.opensearch.index.IndexSettings;
     */
    public void setShuffleBufferRegistry(ShuffleBufferRegistry shuffleBufferRegistry) {
import org.opensearch.analytics.spi.CommonExecutionContext;
     *   <li><b>Node-scoped, never closed per request.</b> The Flight transport builds its reused stream
        this.namedWriteableRegistry = namedWriteableRegistry;  
        return allocator;  
    public boolean hasPartialAggregate() {
    /** Returns the data-format aware reader. */
    }  
        this.shuffleBufferRegistry = shuffleBufferRegistry;
}  
    public NamedWriteableRegistry getNamedWriteableRegistry() {  
    /** Sets the shard's index settings. */  
    private QueryCache queryCache;
    public void setAllocator(BufferAllocator allocator) {
import org.apache.lucene.search.QueryCachingPolicy;  
 * the query execution lifecycle.  
        return hasPartialAggregate;
/*  
    }  
    }  
    }
import org.opensearch.core.index.shard.ShardId;
    }  
     * read by instruction handlers to route deletion-bearing shards through the indexed  
     *       root on the FIRST emitted batch's vector allocator and charges that same allocator for every  
     * Returns the allocator Arrow C Data Interface imports are staged on, or null if the caller did not  
    public void setHasDeletedDocs(boolean hasDeletedDocs) {  
        this.indexSettings = indexSettings;
    /** Sets the caller-provided allocator. The caller owns its lifecycle; the engine must not close it. */  
 * SPDX-License-Identifier: Apache-2.0
        return queryCachingPolicy;
     * @param task the transport-created task for this fragment execution  
    public void setShardId(ShardId shardId) {
    public void setQueryCache(QueryCache queryCache) {
        this.reader = reader;  
    }
 * this file be licensed under the Apache-2.0 license or a
    /** Returns the query caching policy for Lucene filter delegation. */  
     * locate the buffer for the {@code (queryId, stageId, partitionIndex)} bucket the producers
    }
    /** Sets the query caching policy. */
     *       the producer's native allocator — invisible to the JVM heap and to Java Arrow accounting.</li>
    public void setImportStagingAllocator(BufferAllocator importStagingAllocator) {
    /**  
 */  
    /** Sets the backend-specific serialized plan fragment bytes. */
     * Sourced from the accepting backend's {@code hasDeletedDocs} probe at data-node search start;
    /** Returns the shard's mapper service for field type resolution. */  
    public QueryCachingPolicy getQueryCachingPolicy() {
     * @param reader the data-format aware reader
public class ShardScanExecutionContext implements CommonExecutionContext {
        return mapperService;
    }
        this.fragmentBytes = fragmentBytes;
    }
     * <ul>
    private boolean hasPartialAggregate;
        this.task = task;
import org.opensearch.analytics.spi.ShuffleBufferRegistry;
    private BufferAllocator importStagingAllocator;
    }  
    /** Sets the shard's mapper service. */
    }
    /** Returns the caller-provided allocator for producing Arrow result buffers. */
 *
    private BufferAllocator allocator;
        return queryCache;
    /**  
        this.allocator = allocator;
     * Whether the shard has segments with deleted documents that need filtering at query time.
 * Execution context carrying reader and plan state through
 * @opensearch.internal
     */
    public void setIndexSettings(IndexSettings indexSettings) {
 * compatible open source license.
    }
    }
    private final Task task;
    /** Returns the backend-specific serialized plan fragment bytes, or null if not set. */  
    /** Returns the node-level query cache for Lucene filter delegation. */
    }  
        this.mapperService = mapperService;
    public void setQueryCachingPolicy(QueryCachingPolicy queryCachingPolicy) {  
        this.shardId = shardId;  
    /** Returns the target table name. */
     *       later batch ({@code FlightServerChannel#transferIntoStreamRoot}: "The producer's allocator must
    }  
    public QueryCache getQueryCache() {  
    /** Sets the NamedWriteableRegistry. */
    public void setFragmentBytes(byte[] fragmentBytes) {  
    }  
    }
 */  
    public Reader getReader() {
     */  
    private final String tableName;  
    private byte[] fragmentBytes;  
        return namedWriteableRegistry;
     *   <li><b>Unbounded, parented at the root.</b> {@code Data#importIntoVectorSchemaRoot} charges each  
    }
    private QueryCachingPolicy queryCachingPolicy;
        this.queryCache = queryCache;  
    /**
    /** Whether the fragment contains a PARTIAL aggregate instruction. */  
    }
import org.opensearch.tasks.Task;
    }
    /** Returns the NamedWriteableRegistry for deserializing delegated expressions. */
     *       buffer as it walks the array; a target that fills part-way through throws, and arrow-java
        this.queryCachingPolicy = queryCachingPolicy;
     * null when no such backend is registered. Hash-shuffle scan handlers consult this to  
    private IndexSettings indexSettings;
        return indexSettings;  
    }
    public Task getTask() {
    public boolean hasDeletedDocs() {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
    }  
    /** Sets the node-level query cache. */
    }
        return shuffleBufferRegistry;
        this.importStagingAllocator = importStagingAllocator;  
    private boolean hasDeletedDocs;  
     * @param tableName the target table name
    public ShardScanExecutionContext(String tableName, Task task, Reader reader) {  
    /**  
     * set one. Distinct from {@link #getAllocator()} on two properties a batch import depends on:
 * The OpenSearch Contributors require contributions made to  
 *
    }
        this.hasDeletedDocs = hasDeletedDocs;
    private ShardId shardId;  
    public void setNamedWriteableRegistry(NamedWriteableRegistry namedWriteableRegistry) {
    public IndexSettings getIndexSettings() {
        return shardId;
    /** Sets the node-scoped import staging allocator. The caller owns its lifecycle. */
    public MapperService getMapperService() {
     *       without rolling back, so the C Data release callback never fires and the whole batch leaks in  
        this.tableName = tableName;
    /** Sets the per-node shuffle buffer registry. Called once per fragment by
     *  {@code AnalyticsSearchService} when building the context. */  
        return task;
    public BufferAllocator getAllocator() {
    private NamedWriteableRegistry namedWriteableRegistry;
    /** Returns the transport-created task for this fragment execution. */  
    }
    private ShuffleBufferRegistry shuffleBufferRegistry;  
        return hasDeletedDocs;  
        return tableName;
    public ShuffleBufferRegistry getShuffleBufferRegistry() {
import org.apache.arrow.memory.BufferAllocator;
import org.apache.lucene.search.QueryCache;
    public void setHasPartialAggregate(boolean hasPartialAggregate) {
    public byte[] getFragmentBytes() {
        return fragmentBytes;
        this.hasPartialAggregate = hasPartialAggregate;  
    public ShardId getShardId() {
/**
import org.opensearch.index.engine.exec.IndexReaderProvider.Reader;  
     * are filling. Other handlers (broadcast, scan, partial-aggregate) ignore it.
     * Returns the per-node shuffle buffer registry. Non-null when the data node hosts
    /** Returns the shard's index settings. */
    public String getTableName() {  
    }
     * </ul>  
    public BufferAllocator getImportStagingAllocator() {  
        return reader;  
     * deleted-doc filtering path.
import org.opensearch.index.mapper.MapperService;
    private final Reader reader;
    }
    public void setMapperService(MapperService mapperService) {  
     *       be long-lived (not closed per-request)"), and frees it asynchronously with its own channel.</li>
     * Caller-owned: the engine imports onto it and must never close it.
     *       (&le; 18.1.0) retains the imported array before the throwing {@code wrapForeignAllocation}
package org.opensearch.analytics.backend;
    private MapperService mapperService;  
        return importStagingAllocator;
    }  
     */
