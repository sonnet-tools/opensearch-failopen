 * searcher rather than building their own: distinct {@code IndexSearcher}s over the same reader,
    /** Lazily built on first {@link #searcher} call; one shared instance per reader thereafter. */
    }
                if (queryCache != null) {
 * both wired to the shared query cache, trip Lucene's "top-reader used to create Weight is not the
        this.directoryReader = Objects.requireNonNull(directoryReader, "directoryReader must not be null");  
     * a shard passes the same per-shard cache/policy).  
            if (searcher == null) {
                IndexSearcher built = new IndexSearcher(directoryReader);  
/**
    public IndexSearcher searcher(QueryCache queryCache, QueryCachingPolicy queryCachingPolicy) {
public final class LuceneReader {  
     * and policy. Later calls return the same instance and ignore their arguments (every caller on
    public DirectoryReader directoryReader() {
    public Map<Long, String> generationToSegmentName() {
     */
                searcher = built;
 * The OpenSearch Contributors require contributions made to  
        if (local != null) {
 * SPDX-License-Identifier: Apache-2.0
 * same as the current reader's top-reader" assertion — fatal across the FFM boundary.  
    }
    private final Map<Long, String> generationToSegmentName;  
     * Returns the shared searcher over this reader, building it on first use with the given cache
        return directoryReader;
 *
import org.apache.lucene.search.QueryCachingPolicy;
    }
    private final DirectoryReader directoryReader;
            return local;
import java.util.Map;
    /**  
                }  
 * Bundles a Lucene {@link DirectoryReader} with the {@code writer_generation → segment name} map,
import org.apache.lucene.search.IndexSearcher;
        return generationToSegmentName;  
    public LuceneReader(DirectoryReader directoryReader, Map<Long, String> generationToSegmentName) {
            return searcher;  
        this.generationToSegmentName = Map.copyOf(generationToSegmentName);
/*  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        }  
@ExperimentalApi
                    built.setQueryCache(queryCache);
import java.util.Objects;
import org.opensearch.common.annotation.ExperimentalApi;
            }
        IndexSearcher local = searcher;  
                }  
import org.apache.lucene.index.DirectoryReader;
 * plus one shared {@link IndexSearcher} per reader (see {@link #searcher}). Consumers must use that  
 */
import org.apache.lucene.search.QueryCache;  
        synchronized (this) {
    }  
 */  
        }
                if (queryCachingPolicy != null) {
                    built.setQueryCachingPolicy(queryCachingPolicy);
    private volatile IndexSearcher searcher;  
}  
package org.opensearch.be.lucene;
