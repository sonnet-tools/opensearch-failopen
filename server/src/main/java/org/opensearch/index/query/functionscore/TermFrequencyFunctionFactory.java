        String term,
        switch (functionName) {
 * the specified function name, field, and term. Each term frequency function is designed
import java.io.IOException;  
     * An enumeration representing the names of supported term frequency functions.  
}
                functionValues = totalTermFreqValueSource.getValues(ttfContext, readerContext);
                throw new IllegalArgumentException("Unsupported function: " + functionName);
            case SUM_TOTAL_TERM_FREQ:  
import java.util.Map;
    }
                    BytesRefs.toBytesRef(term)  
    public enum TermFrequencyFunctionName {
                return docId -> functionValues.longVal(docId);
     */
        }
 * @opensearch.internal
        SUM_TOTAL_TERM_FREQ("sumTotalTermFreq");
import org.apache.lucene.queries.function.FunctionValues;
/*  
        IndexSearcher indexSearcher  
    ) throws IOException {
    /**
        public String getTermFrequencyFunctionName() {
            this.termFrequencyFunctionName = termFrequencyFunctionName;
 * The OpenSearch Contributors require contributions made to  
        String field,  
import org.apache.lucene.queries.function.valuesource.TermFreqValueSource;
 * A factory class for creating instances of {@link TermFrequencyFunction}.
        LeafReaderContext readerContext,
                Map<Object, Object> ttfContext = new HashMap<>();
 * this file be licensed under the Apache-2.0 license or a
    }  
import org.apache.lucene.queries.function.valuesource.SumTotalTermFreqValueSource;  
package org.opensearch.index.query.functionscore;
            default:  
                FunctionValues functionValues = termFreqValueSource.getValues(null, readerContext);
import org.apache.lucene.search.IndexSearcher;  
 * compatible open source license.
 * to compute document scores based on specific term frequency calculations.
                sumTotalTermFreqValueSource.createWeight(sttfContext, indexSearcher);  
                TotalTermFreqValueSource totalTermFreqValueSource = new TotalTermFreqValueSource(
    public static TermFrequencyFunction createFunction(
        TOTAL_TERM_FREQ("totalTermFreq"),
 * This class provides methods for creating different term frequency functions based on  
import org.apache.lucene.index.LeafReaderContext;
        TermFrequencyFunctionName functionName,
import org.opensearch.common.lucene.BytesRefs;
                functionValues = sumTotalTermFreqValueSource.getValues(sttfContext, readerContext);
 *
            case TERM_FREQ:  
                Map<Object, Object> sttfContext = new HashMap<>();
public class TermFrequencyFunctionFactory {  
                    field,  
 * SPDX-License-Identifier: Apache-2.0
 */  
                return docId -> functionValues.intVal(docId);  
                );
                TermFreqValueSource termFreqValueSource = new TermFreqValueSource(field, term, field, BytesRefs.toBytesRef(term));
import org.apache.lucene.queries.function.valuesource.TotalTermFreqValueSource;
                SumTotalTermFreqValueSource sumTotalTermFreqValueSource = new SumTotalTermFreqValueSource(field);
            case TOTAL_TERM_FREQ:
 *  
                    field,
        private final String termFrequencyFunctionName;
        TermFrequencyFunctionName(String termFrequencyFunctionName) {  
 */
/**
                return docId -> functionValues.longVal(docId);
import java.util.HashMap;
        }
        TERM_FREQ("termFreq"),  
        }  
                    term,
            return termFrequencyFunctionName;
                totalTermFreqValueSource.createWeight(ttfContext, indexSearcher);  
