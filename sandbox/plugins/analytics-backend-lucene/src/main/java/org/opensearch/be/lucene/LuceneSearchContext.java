        this.query = query;
import org.opensearch.action.search.SearchShardTask;
     * @param reader the directory reader over the index  
import java.io.IOException;
    }
    private final SearchShardTask task;  
        this.searcher = new LuceneEngineSearcher(indexSearcher, reader);  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.annotation.ExperimentalApi;
    public void setQuery(Query query) {
     * @param query the Lucene query to execute
 * Lucene-specific search execution context.
/**
        this.task = task;
     * Sets the query for this context.  
        return task;  
        IndexSearcher indexSearcher = new IndexSearcher(reader);
 * this file be licensed under the Apache-2.0 license or a
    }  
import org.apache.lucene.search.Query;  
}  
    public SearchShardTask task() {
    }
    @Override
    /** Returns the current query. */
 *
import org.apache.lucene.index.DirectoryReader;
     */
        return searcher;
     * @param task the search shard task
    }
    /**
    private final LuceneEngineSearcher searcher;
    public LuceneEngineSearcher getSearcher() {
 * compatible open source license.
        this.reader = reader;
package org.opensearch.be.lucene;
import org.opensearch.search.SearchExecutionContext;  
     * @param query the Lucene query to set
    public LuceneSearchContext(SearchShardTask task, DirectoryReader reader, Query query) throws IOException {  
    @Override
    public Query getQuery() {  
    }  
/*  
public class LuceneSearchContext implements SearchExecutionContext<LuceneEngineSearcher> {
import org.apache.lucene.search.IndexSearcher;
    public void close() throws IOException {  
    }  
     *
        this.query = query;
 */
        searcher.close();
 *  
@ExperimentalApi  
    private final DirectoryReader reader;
    /**
     *
    @Override  
    private Query query;  
 */  
        return query;
 * @opensearch.experimental
     */  
 * The OpenSearch Contributors require contributions made to  
     * Creates a new LuceneSearchContext.  
