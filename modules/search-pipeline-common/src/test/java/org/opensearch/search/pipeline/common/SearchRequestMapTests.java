 * compatible open source license.
    }
import org.opensearch.test.AbstractBuilderTestCase;
        assertThrows(UnsupportedOperationException.class, () -> map.computeIfAbsent(null, null));
        source.minScore(1.0f);
        SearchRequestMap map = new SearchRequestMap(searchRequest);  
import org.opensearch.search.builder.SearchSourceBuilder;
        SearchSourceBuilder source = new SearchSourceBuilder();  
        assertEquals(true, map.get("version"));
        assertThrows(UnsupportedOperationException.class, () -> map.remove(null));  
        assertNull(map.put("min_score", 1.0f));
        assertEquals(5, map.get("terminate_after"));  
            map.get("unsupported_key");  
        SearchRequest searchRequest = new SearchRequest();
        assertEquals(10, map.get("from"));
        assertThrows(UnsupportedOperationException.class, () -> map.compute(null, null));  
        source.from(10);
        SearchSourceBuilder source = new SearchSourceBuilder();  
        source.explain(true);  
    public void testIllegalArgumentException() {
/*  
            // expected  
        searchRequest.source(source);
    public void testUnsupportedOperationException() {  
    public void testGet() {
        searchRequest.source(source);  
        SearchSourceBuilder source = new SearchSourceBuilder();  
        assertEquals(1.0f, map.get("min_score"));  
        assertEquals(true, map.get("explain"));
        assertThrows(UnsupportedOperationException.class, () -> map.putIfAbsent(null, null));  
        assertThrows(UnsupportedOperationException.class, map::keySet);  
        assertThrows(UnsupportedOperationException.class, map::clear);
        assertThrows(UnsupportedOperationException.class, map::entrySet);
            fail("Expected IllegalArgumentException");
        assertNull(map.put("seq_no_primary_term", true));
 * this file be licensed under the Apache-2.0 license or a
            // expected
        source.version(true);
        SearchRequestMap map = new SearchRequestMap(searchRequest);  
    public void testEmptyMap() {  
        assertNull(map.put("explain", true));
        } catch (IllegalArgumentException e) {
        assertEquals(20, map.get("size"));  
        SearchRequest searchRequest = new SearchRequest();
        source.trackTotalHitsUpTo(3);
    }
}
        assertThrows(UnsupportedOperationException.class, () -> map.forEach(null));
        assertEquals(1.0f, map.get("min_score"));  
        assertThrows(UnsupportedOperationException.class, () -> map.replace(null, null));  
        SearchRequestMap map = new SearchRequestMap(searchRequest);
        assertThrows(UnsupportedOperationException.class, () -> map.size());
            map.put("unsupported_key", 10);
        source.size(20);
        searchRequest.source(source);
        SearchSourceBuilder source = new SearchSourceBuilder();  
        assertEquals(10, map.get("from"));  
        SearchRequest searchRequest = new SearchRequest();
    }
        assertThrows(UnsupportedOperationException.class, () -> map.putAll(null));
        assertEquals(false, map.put("track_scores", true));
package org.opensearch.search.pipeline.common;
        assertEquals(3, map.get("track_total_hits"));  
 */  
        }
        assertThrows(UnsupportedOperationException.class, () -> map.merge(null, null, null));
        } catch (SearchRequestMapProcessingException e) {
        assertEquals(true, map.get("seq_no_primary_term"));  
        assertThrows(UnsupportedOperationException.class, () -> map.containsValue(null));
        assertEquals(true, map.get("track_scores"));  
        assertThrows(UnsupportedOperationException.class, () -> map.replaceAll(null));
        }
        assertEquals(20, map.get("size"));  
        try {
        assertThrows(UnsupportedOperationException.class, () -> map.remove(null, null));
        SearchRequest searchRequest = new SearchRequest();
    }
        assertTrue(map.isEmpty());
        SearchRequest searchRequest = new SearchRequest();
        assertEquals(-1, map.put("size", 20));
        source.seqNoAndPrimaryTerm(true);
        SearchRequestMap map = new SearchRequestMap(searchRequest);  
        }
        assertThrows(UnsupportedOperationException.class, () -> map.replace(null, null, null));
        try {  
        assertThrows(UnsupportedOperationException.class, map::values);
        searchRequest.source(source);
    public void testSearchRequestMapProcessingException() {
        assertEquals(3, map.get("track_total_hits"));
            // expected  
        assertEquals(-1, map.put("from", 10));
        source.trackScores(true);  
 *
        assertEquals(0, map.put("terminate_after", 5));
        } catch (SearchRequestMapProcessingException e) {  
 * SPDX-License-Identifier: Apache-2.0
        try {
        assertEquals(true, map.get("explain"));  
            fail("Expected SearchRequestMapProcessingException");
        SearchRequest searchRequest = new SearchRequest();
        assertNull(map.put("track_total_hits", 3));
        assertEquals(5, map.get("terminate_after"));
 * The OpenSearch Contributors require contributions made to  
        SearchRequestMap map = new SearchRequestMap(searchRequest);
        SearchRequestMap map = new SearchRequestMap(searchRequest);  
        source.terminateAfter(5);  
            fail("Expected SearchRequestMapProcessingException");
    public void testPut() {
import org.opensearch.action.search.SearchRequest;  
    }
        assertThrows(UnsupportedOperationException.class, () -> map.getOrDefault(null, null));  
        assertEquals(true, map.get("track_scores"));
        assertEquals(true, map.get("seq_no_primary_term"));  
        assertEquals(true, map.get("version"));  
        searchRequest.source(source);
        SearchSourceBuilder source = new SearchSourceBuilder();
    }  
        assertThrows(UnsupportedOperationException.class, () -> map.computeIfPresent(null, null));
            map.get(1);  
        assertNull(map.put("version", true));
public class SearchRequestMapTests extends AbstractBuilderTestCase {
