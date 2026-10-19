        SearchHits searchHits = new SearchHits(hits, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1);  
        piMap.put("digits", new DocumentField("digits", PI));
    }  
        x.add(3);
            false,
        SearchHit[] hits = new SearchHit[1];  
        // one response with source
 *
        hits[1].score((float) Math.E);
            () -> sortResponseProcessor.processResponse(request, createTestResponseNullListEntry())
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);
import java.util.List;
    public void testNotComparableField() {
    private SearchResponse createTestResponseNullListEntry() {
import org.opensearch.core.common.bytes.BytesArray;
    public void testSortResponseSameField() throws Exception {
            null
            null,  
public class SortResponseProcessorTests extends OpenSearchTestCase {
    static {  
    }  
        assertEquals(List.of(1, 1, 2, 3, 4, 5, 6, 9), map.get("sorted"));
        return new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);
        QueryBuilder query = new TermQueryBuilder("field", "value");  
        hits[0].score((float) Math.PI);
            SortResponseProcessor.SortOrder.ASCENDING,
        hits[0].score((float) Math.PI);
    }  
    }  
        SortResponseProcessor sortResponseProcessor = new SortResponseProcessor(
import org.opensearch.test.OpenSearchTestCase;
        x.add(1);
        SearchHit[] hits = new SearchHit[1];
 */  
import java.util.Map;
        SearchHits searchHits = new SearchHits(hits, new TotalHits(2, TotalHits.Relation.EQUAL_TO), 2);  
    private static final List<Object> PI = List.of(3, 1, 4, 1, 5, 9, 2, 6);  
    private SearchResponse createTestResponseNotComparable() {  
        config.put("field", sortField);  
        SortResponseProcessor.Factory factory = new SortResponseProcessor.Factory();
        map.put("digits", null);  
            null,  
            null
        SortResponseProcessor sortResponseProcessor = new SortResponseProcessor(
    }  
import org.apache.lucene.search.TotalHits;
        String sortField = RandomDocumentPicks.randomFieldName(random());  
        hits[0] = new SearchHit(0, "doc 1", map, Collections.emptyMap());
        Map<String, DocumentField> map = new HashMap<>();
    public void testSortResponseNullListEntry() {  
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);  
            "digits",
        SearchResponse response = createTestResponse();
        );  
        );
        hits[0].sourceRef(new BytesArray("{ \"maps\" : [{ \"foo\" : \"I'm incomparable!\"}]] }"));  
            IllegalArgumentException.class,  
        SearchRequest request = createDummyRequest();  
    private static final List<Object> X;
}
    }
        hits[0] = new SearchHit(0, "doc 1", piMap, Collections.emptyMap());
        expectThrows(
        SearchHits searchHits = new SearchHits(hits, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1);
        assertEquals(response.getHits(), sortResponse.getHits());
package org.opensearch.search.pipeline.common;
        assertThrows(IllegalArgumentException.class, () -> sortResponseProcessor.processResponse(request, createTestResponseNullField()));
        assertEquals(targetField, processor.getTargetField());
        assertThrows(
            "sorted"
        Map<String, DocumentField> xMap = new HashMap<>();
        assertEquals(List.of(1, 1, 2, 3, 4, 5, 6, 9), sortResponse.getHits().getHits()[0].field("sorted").getValues());
        hits[0].score((float) Math.PI);
            SortResponseProcessor.SortOrder.ASCENDING,
        hits[0].score((float) Math.PI);  
        assertEquals(sortField, processor.getSortField());
import org.opensearch.action.search.SearchResponseSections;
        SearchResponse sortResponse = sortResponseProcessor.processResponse(request, response);
        SearchHits searchHits = new SearchHits(hits, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1);
    public void testNullField() {
            SortResponseProcessor.SortOrder.ASCENDING,
        );
        SearchResponse sortResponse = sortResponseProcessor.processResponse(request, response);
        assertEquals(response.getHits(), sortResponse.getHits());
            IllegalArgumentException.class,  
            "digits",  
        Map<String, DocumentField> piMap = new HashMap<>();  
import java.util.Collections;
        X = x;
        // one without source  
            () -> factory.create(Collections.emptyMap(), null, null, false, Collections.emptyMap(), null)
        return new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);
        );  
        Map<String, DocumentField> eMap = new HashMap<>();
        hits[0].sourceRef(new BytesArray("{ \"digits\" : null }"));
        String targetField = RandomDocumentPicks.randomFieldName(random());
            false,  
            SortResponseProcessor.SortOrder.DESCENDING,
        eMap.put("digits", new DocumentField("digits", E));
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);
        Map<String, DocumentField> piMap = new HashMap<>();  
        SortResponseProcessor processor = factory.create(Collections.emptyMap(), null, null, false, config, null);
    }  
        );
        );
    public void testSortResponse() throws Exception {
    }
            null,
            "digits",  
 * compatible open source license.
    private SearchRequest createDummyRequest() {
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);
            SortResponseProcessor.SortOrder.DESCENDING,
        hits[0].sourceRef(new BytesArray("{ \"digits\" : " + PI + " }"));  
    }  
    private SearchResponse createTestResponse() {
        assertEquals(SortResponseProcessor.SortOrder.DESCENDING, processor.getSortOrder());  
        Map<String, Object> config = new HashMap<>();
            "digits",  
            null,
import java.util.ArrayList;
    }
            null  
        assertEquals(List.of(9, 6, 5, 4, 3, 2, 1, 1), sortResponse.getHits().getHits()[0].field("digits").getValues());
            false,
import org.opensearch.action.search.SearchRequest;  
 * this file be licensed under the Apache-2.0 license or a.java
import java.util.HashMap;  
        SearchRequest request = createDummyRequest();  
    public void testFactory() {
            null,
        );  
        x.add(null);  
        SearchRequest request = createDummyRequest();
            null,
            "maps",  
        piMap.put("maps", new DocumentField("maps", List.of(Map.of("foo", "I'm incomparable!"))));
import org.opensearch.OpenSearchParseException;
import org.opensearch.index.query.QueryBuilder;
        return new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);
            false,
        assertNull(sortResponse.getHits().getHits()[1].getSourceAsMap());
        hits[0].sourceRef(new BytesArray("{ \"digits\" : " + X + " }"));
        return new SearchRequest().source(source);
    private SearchResponse createTestResponseNullField() {
            null,
        return new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);  
import org.opensearch.ingest.RandomDocumentPicks;
        SortResponseProcessor sortResponseProcessor = new SortResponseProcessor(  
import org.opensearch.search.builder.SearchSourceBuilder;
import org.opensearch.search.SearchHit;
        config.put("target_field", targetField);
import org.opensearch.common.document.DocumentField;  
    private static final List<Object> E = List.of(2, 7, 1, 8, 2, 8, 1, 8);
        assertEquals(List.of(1, 1, 2, 2, 7, 8, 8, 8), sortResponse.getHits().getHits()[1].field("sorted").getValues());
 * The OpenSearch Contributors require contributions made to  
            OpenSearchParseException.class,  
        );  
        hits[0] = new SearchHit(0, "doc 1", xMap, Collections.emptyMap());  
        assertNotNull(map);  
    }  
        SearchHit[] hits = new SearchHit[2];  
            null,  
        hits[0] = new SearchHit(0, "doc 1", piMap, Collections.emptyMap());
        xMap.put("digits", new DocumentField("digits", X));
import org.opensearch.action.search.SearchResponse;
import org.opensearch.search.SearchHits;  
        List<Object> x = new ArrayList<>();
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        assertThrows(
        assertEquals(E, sortResponse.getHits().getHits()[1].field("digits").getValues());  
import org.opensearch.index.query.TermQueryBuilder;  
            false,
            null
        SearchRequest request = createDummyRequest();  
        Map<String, Object> map = sortResponse.getHits().getHits()[0].getSourceAsMap();
        SearchResponse response = createTestResponse();
        SearchRequest request = createDummyRequest();  
 * SPDX-License-Identifier: Apache-2.0
            () -> sortResponseProcessor.processResponse(request, createTestResponseNotComparable())
        config.put("order", "desc");
            null,
        SearchHit[] hits = new SearchHit[1];
        SortResponseProcessor sortResponseProcessor = new SortResponseProcessor(
        assertEquals(List.of(8, 8, 8, 7, 2, 2, 1, 1), sortResponse.getHits().getHits()[1].field("digits").getValues());  
            null,  
/*  
        hits[1] = new SearchHit(1, "doc 2", eMap, Collections.emptyMap());  
        assertEquals(PI, sortResponse.getHits().getHits()[0].field("digits").getValues());  
        SortResponseProcessor sortResponseProcessor = new SortResponseProcessor(
        assertEquals("sort", processor.getType());  
    }  
