import java.io.IOException;  
            termFreqCache.put(cacheKey, termFrequencyFunction);
            );
        this.leafLookup = leafLookup;  
 * this file be licensed under the Apache-2.0 license or a
            : String.format(Locale.ROOT, "%s-%s-%s", functionName, field, val);
import java.util.HashMap;
                leafLookup.ctx,
import org.opensearch.index.query.functionscore.TermFrequencyFunction;
        throws IOException {
        return termFreqCache.get(cacheKey);
import java.util.Locale;
        String cacheKey = (val == null)
    private TermFrequencyFunction getOrCreateTermFrequencyFunction(TermFrequencyFunctionName functionName, String field, String val)  
            TermFrequencyFunction termFrequencyFunction = TermFrequencyFunctionFactory.createFunction(
    private final IndexSearcher indexSearcher;  
                field,  
    private final LeafSearchLookup leafLookup;
package org.opensearch.search.lookup;
    public LeafTermFrequencyLookup(IndexSearcher indexSearcher, LeafSearchLookup leafLookup) {
                indexSearcher  
 * The OpenSearch Contributors require contributions made to  
 *
        TermFrequencyFunction termFrequencyFunction = getOrCreateTermFrequencyFunction(functionName, field, val);
 * compatible open source license.
}
/**
                val,
            ? String.format(Locale.ROOT, "%s-%s", functionName, field)  
 */  
    }  
 * SPDX-License-Identifier: Apache-2.0
    private final Map<String, TermFrequencyFunction> termFreqCache;
        if (!termFreqCache.containsKey(cacheKey)) {  
import org.opensearch.index.query.functionscore.TermFrequencyFunctionFactory;  
 * @opensearch.internal
public class LeafTermFrequencyLookup {
import org.apache.lucene.search.IndexSearcher;
    }
 */  
    public Object getTermFrequency(TermFrequencyFunctionName functionName, String field, String val, int docId) throws IOException {
                functionName,
 *
        this.indexSearcher = indexSearcher;
import java.util.Map;  
import org.opensearch.index.query.functionscore.TermFrequencyFunctionFactory.TermFrequencyFunctionName;
 * Looks up term frequency per-segment  
/*  
    }
        return termFrequencyFunction.execute(docId);  
        }  
        this.termFreqCache = new HashMap<>();
