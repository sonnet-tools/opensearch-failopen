     */
     */
}  
 * This class is stateless with respect to active queries
import java.util.List;
     * @param indexSearcher the Lucene index searcher
     *
    public LuceneEngineSearcher(IndexSearcher indexSearcher, DirectoryReader directoryReader) {
        this.directoryReader = directoryReader;
    /**
    public DirectoryReader getDirectoryReader() {  
    @Override
import org.apache.lucene.search.ScoreMode;
    /**
            throw new IllegalStateException("No query set on LuceneSearchContext");  
/*  
     *
     * @param directoryReader the Lucene directory reader  
    }  
    /** Returns the underlying DirectoryReader. */
     * Execute: create a Weight from the query, register it on the
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        // TODO : Complete the wiring for search execution
        Query query = context.getQuery();
 *
 * The OpenSearch Contributors require contributions made to  
 *
    }
    /** Returns the underlying IndexSearcher. */  
 */
 * Lucene-backed engine searcher.
import org.apache.lucene.search.IndexSearcher;  
     * on the context for JNI callbacks.
     * @param context the search context containing the query to execute  
import org.apache.lucene.index.LeafReaderContext;
    private final DirectoryReader directoryReader;  
        return directoryReader;
    @Override
package org.opensearch.be.lucene;
@ExperimentalApi
 */  
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Weight;  
import java.io.IOException;
    private final IndexSearcher indexSearcher;
import org.apache.lucene.index.DirectoryReader;
    public void close() {}
        List<LeafReaderContext> leaves = directoryReader.leaves();
public class LuceneEngineSearcher implements EngineSearcher<LuceneSearchContext> {  
        if (query == null) {
        Query rewritten = indexSearcher.rewrite(query);
     * context's lifecycle manager, and store the key + segment metadata  
        this.indexSearcher = indexSearcher;  
        }
    public IndexSearcher getIndexSearcher() {
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.index.engine.exec.EngineSearcher;
    public void search(LuceneSearchContext context) throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
 * <p>  
        return indexSearcher;
/**
        Weight weight = indexSearcher.createWeight(rewritten, ScoreMode.COMPLETE_NO_SCORES, 1.0f);  
    }
     * Creates a new LuceneEngineSearcher.  
    }
 * @opensearch.experimental  
