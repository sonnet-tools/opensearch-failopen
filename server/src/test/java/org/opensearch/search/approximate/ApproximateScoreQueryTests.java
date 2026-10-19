    }
import org.apache.lucene.search.Query;
                    try {
                        throw new RuntimeException(e);  
import org.apache.lucene.search.IndexSearcher;
                iw.flush();  
                        Scorer scorer = weight.scorer(reader.leaves().get(0));  
    }  
 * compatible open source license.
import org.apache.lucene.search.Scorer;  
            pack(new long[] { l }).bytes,
            new long[] { l }.length
                iw.addDocument(document);
            pack(new long[] { l }).bytes,
        ApproximateQuery approximateQuery = new ApproximatePointRangeQuery(
            1,
            ApproximatePointRangeQuery.LONG_FORMAT
        long l = Long.MIN_VALUE;
                    } catch (IOException e) {
    public void testEqualsAndHashCode() {  
package org.opensearch.search.approximate;
        assertEquals(query.hashCode(), same.hashCode());
            }
        ApproximateScoreQuery same = new ApproximateScoreQuery(LongPoint.newRangeQuery("ts", 0L, 10L), approximateRange("ts", 0L, 10L));
        // resolvedQuery is mutable rewrite state and must not change identity  
                        );
import org.apache.lucene.search.ScoreMode;
        ApproximateScoreQuery query = new ApproximateScoreQuery(originalQuery, approximateQuery);
 * SPDX-License-Identifier: Apache-2.0
        long u = Long.MAX_VALUE;
public class ApproximateScoreQueryTests extends OpenSearchTestCase {
 *
}
import org.apache.lucene.document.Document;
import org.apache.lucene.store.Directory;
            "test-index",
        assertEquals(query, same);
            pack(new long[] { upper }).bytes,  
            ApproximatePointRangeQuery.LONG_FORMAT
            new long[] { l }.length,  
        );
        }
        same.resolvedQuery = approximation;
            }
        Query original = LongPoint.newRangeQuery("ts", 0L, 10L);
        ) {
                }  
            try (RandomIndexWriter iw = new RandomIndexWriter(random(), directory, new WhitespaceAnalyzer())) {
                        assertEquals(
import org.apache.lucene.document.LongPoint;  
            "test-index",  
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.index.IndexReader;
        query.resolvedQuery = approximateQuery;
                Document document = new Document();  
import java.io.IOException;  
 * this file be licensed under the Apache-2.0 license or a
                            scorer,
                return Long.toString(LongPoint.decodeDimension(value, 0));
        assertEquals(query, same);  
import org.apache.lucene.tests.index.RandomIndexWriter;  
                try (IndexReader reader = iw.getReader()) {
            pack(new long[] { lower }).bytes,
import org.apache.lucene.search.Weight;
        return new ApproximatePointRangeQuery(  
                document.add(new LongPoint("testPoint", Long.MIN_VALUE));
import static org.apache.lucene.document.LongPoint.pack;
        assertEquals(query.hashCode(), same.hashCode());  
                        Weight weight = query.rewrite(searcher).createWeight(searcher, ScoreMode.TOP_SCORES, 1.0F);
            protected String toString(int dimension, byte[] value) {  
        ApproximateQuery approximation = approximateRange("ts", 0L, 10L);
                            originalQuery.createWeight(searcher, ScoreMode.TOP_SCORES, 1.0F).scorer(searcher.getLeafContexts().get(0))  
        Query originalQuery = new PointRangeQuery(  
        assertFalse(query.equals(differentOriginal));  
        try (Directory directory = newDirectory()) {
/*  
            field,
        };  
import org.apache.lucene.search.PointRangeQuery;  
                        searcher.search(query, 10);
        ApproximateScoreQuery differentOriginal = new ApproximateScoreQuery(LongPoint.newRangeQuery("ts", 0L, 20L), approximation);
                    }
    }
    public void testApproximationScoreSupplier() throws IOException {  
        assertFalse(query.equals(null));
    private static ApproximateQuery approximateRange(String field, long lower, long upper) {
            pack(new long[] { u }).bytes,
 * The OpenSearch Contributors require contributions made to  
                        IndexSearcher searcher = new IndexSearcher(reader);  
        assertFalse(query.equals(differentApproximation));  
        assertFalse(query.equals(original));  
        ApproximateScoreQuery differentApproximation = new ApproximateScoreQuery(original, approximateRange("ts", 0L, 20L));
 */  
        ApproximateScoreQuery query = new ApproximateScoreQuery(original, approximation);  
        );  
import org.opensearch.test.OpenSearchTestCase;
            pack(new long[] { u }).bytes,  
