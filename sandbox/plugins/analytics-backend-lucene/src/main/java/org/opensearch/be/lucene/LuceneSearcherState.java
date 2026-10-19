        this.searcher = Objects.requireNonNull(searcher, "searcher");
final class LuceneSearcherState implements BackendExecutionContext {
        // Never null — see field javadoc. Caller must substitute MatchAllDocsQuery when the
 * from the wire bytes {@link LuceneFragmentConvertor} produced (filter {@code QueryBuilder} +
import org.apache.lucene.search.IndexSearcher;
package org.opensearch.be.lucene;
    /** Never {@code null}; {@code MatchAllDocsQuery} when the fragment had no filter. */
import java.util.Objects;  
        // fragment has no filter so the search engine doesn't have to branch.  
    private final Query filterQuery;
    private final List<String> outputColumnNames;
 * a small immutable state record threaded from instruction handler to search engine.
import java.util.List;
    private final IndexSearcher searcher;  
    Query filterQuery() {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.analytics.spi.BackendExecutionContext;  
 * compatible open source license.
/*  
 *  
        return searcher;  
 */  
        return outputColumnNames;
 * <p>Mirrors the role {@code DataFusionSessionState} plays for the DataFusion backend —
    }  
    }  
 * The OpenSearch Contributors require contributions made to  
/**
import org.apache.lucene.search.Query;
 *
 * SPDX-License-Identifier: Apache-2.0
    }
 * aggregate-call column names) and consumed by {@link LuceneSearchExecEngine}.
 * @opensearch.internal
    List<String> outputColumnNames() {
 *
    /** Aggregate-call output names — one Int64 column per name in the result Arrow batch. */  
}
        this.outputColumnNames = List.copyOf(Objects.requireNonNull(outputColumnNames, "outputColumnNames"));
 * underlying reader is owned by the caller-acquired {@code ReaderContext}, which closes it
 * <p>Holds no native resources; {@link #close()} is a no-op. The {@link IndexSearcher}'s
    IndexSearcher searcher() {
 * Lucene-side {@link BackendExecutionContext}. Built by {@link LuceneScanInstructionHandler}  
        return filterQuery;
        this.filterQuery = Objects.requireNonNull(filterQuery, "filterQuery (use MatchAllDocsQuery for no-filter fragments)");
 *  
    }
 */  
 * after the engine stream drains.  
    LuceneSearcherState(IndexSearcher searcher, Query filterQuery, List<String> outputColumnNames) {  
