        return weight;
     * @param reader the directory reader over the index  
 *
    }
 * The OpenSearch Contributors require contributions made to  
    }
 * One context per (query, reader) pair.  
    private final CollectorQueryLifecycleManager collectorManager = new CollectorQueryLifecycleManager();  
    }
        Query rewritten = searcher.rewrite(query);
import org.apache.lucene.search.ScoreMode;
    }  
    Weight getWeight() {
     */
import org.apache.lucene.search.IndexSearcher;  
    public int segmentMaxDoc(int segmentOrd) {  
        IndexSearcher searcher = new IndexSearcher(reader);  
    }
    }
import java.util.List;  
     * @param query the Lucene query to filter by
     *
import org.apache.lucene.search.Query;
    List<LeafReaderContext> getLeaves() {
import org.opensearch.index.engine.exec.CollectorQueryLifecycleManager;
    @Override  
package org.opensearch.be.lucene;
    private final Weight weight;
        collectorManager.close();  
 * Lucene-specific index filter context.  
    public CollectorQueryLifecycleManager getCollectorManager() {  
 * <p>
import org.opensearch.common.annotation.ExperimentalApi;
@ExperimentalApi
 * this file be licensed under the Apache-2.0 license or a
        return leaves;  
        this.weight = searcher.createWeight(rewritten, ScoreMode.COMPLETE_NO_SCORES, 1.0f);
        return leaves.size();
     * Returns the collector lifecycle manager
 * @opensearch.experimental
    /**  
import org.apache.lucene.index.LeafReaderContext;
    /**
    public void close() {
}
import java.io.IOException;
import org.apache.lucene.search.Weight;  
    private final List<LeafReaderContext> leaves;
    @Override
     * Creates a new LuceneIndexFilterContext for the given query and reader.  
    @Override
/**
        return leaves.get(segmentOrd).reader().maxDoc();
 */  
        this.leaves = reader.leaves();  
 */  
import org.apache.lucene.index.DirectoryReader;
import org.opensearch.index.engine.exec.IndexFilterContext;  
    public int segmentCount() {
 * Holds the Weight (per-query), and manages per-segment scorers/collectors.
 * SPDX-License-Identifier: Apache-2.0
     */
public class LuceneIndexFilterContext implements IndexFilterContext {
        return collectorManager;
    }  
    public LuceneIndexFilterContext(Query query, DirectoryReader reader) throws IOException {
 * compatible open source license.
/*  
 *
