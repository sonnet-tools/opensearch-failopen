import org.opensearch.test.OpenSearchTestCase;
            null,
            null,
import java.util.Map;
        Map<String, DocumentField> xMap = new HashMap<>();
        // one without source
        return new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);
            SortResponseProcessor.SortOrder.ASCENDING,
import java.util.ArrayList;
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);
        hits[1] = new SearchHit(1, "doc 2", eMap, Collections.emptyMap());
/*
        );
import org.opensearch.common.document.DocumentField;
        piMap.put("digits", new DocumentField("digits", PI));
        SearchHit[] hits = new SearchHit[2];
        hits[0].score((float) Math.PI);
            SortResponseProcessor.SortOrder.DESCENDING,
        assertEquals(List.of(1, 1, 2, 2, 7, 8, 8, 8), sortResponse.getHits().getHits()[1].field("sorted").getValues());
import org.opensearch.core.common.bytes.BytesArray;
            "digits",
            false,
 * compatible open source license.
        SortResponseProcessor sortResponseProcessor = new SortResponseProcessor(
        List<Object> x = new ArrayList<>();
        SortResponseProcessor sortResponseProcessor = new SortResponseProcessor(
        assertEquals(List.of(1, 1, 2, 3, 4, 5, 6, 9), map.get("sorted"));
import org.opensearch.action.search.SearchResponse;
    }
    }
    static {
        X = x;
 *
        SearchHits searchHits = new SearchHits(hits, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1);
import org.opensearch.action.search.SearchResponseSections;
    private static final List<Object> E = List.of(2, 7, 1, 8, 2, 8, 1, 8);
 */
        SearchRequest request = createDummyRequest();
        );
        assertEquals(response.getHits(), sortResponse.getHits());
        xMap.put("digits", new DocumentField("digits", X));
        Map<String, DocumentField> eMap = new HashMap<>();
        SearchResponse sortResponse = sortResponseProcessor.processResponse(request, response);
    private SearchRequest createDummyRequest() {
        SearchRequest request = createDummyRequest();
        SearchRequest request = createDummyRequest();
        assertEquals(targetField, processor.getTargetField());
    }
        hits[0] = new SearchHit(0, "doc 1", map, Collections.emptyMap());
        Map<String, DocumentField> piMap = new HashMap<>();
    public void testFactory() {
    public void testNotComparableField() {
import org.opensearch.search.SearchHit;
        );
            null,
    public void testSortResponse() throws Exception {
            null,
        SortResponseProcessor sortResponseProcessor = new SortResponseProcessor(
 * The OpenSearch Contributors require contributions made to
        assertEquals(response.getHits(), sortResponse.getHits());
        SearchHit[] hits = new SearchHit[1];
        hits[0] = new SearchHit(0, "doc 1", piMap, Collections.emptyMap());
import java.util.HashMap;
    public void testSortResponseNullListEntry() {
        hits[0].sourceRef(new BytesArray("{ \"digits\" : " + X + " }"));
        SearchResponse sortResponse = sortResponseProcessor.processResponse(request, response);
            SortResponseProcessor.SortOrder.ASCENDING,
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);
            IllegalArgumentException.class,
        Map<String, DocumentField> piMap = new HashMap<>();
        hits[0].score((float) Math.PI);
 * SPDX-License-Identifier: Apache-2.0
            "digits",
        assertEquals(SortResponseProcessor.SortOrder.DESCENDING, processor.getSortOrder());
        x.add(1);
    private static final List<Object> X;
        // one response with source
}
        );
            null
        assertEquals(List.of(8, 8, 8, 7, 2, 2, 1, 1), sortResponse.getHits().getHits()[1].field("digits").getValues());
        hits[1].score((float) Math.E);
        return new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);
        SearchHits searchHits = new SearchHits(hits, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1);
import org.opensearch.OpenSearchParseException;
        QueryBuilder query = new TermQueryBuilder("field", "value");
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);
            false,
            false,
        return new SearchRequest().source(source);
        return new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);
        hits[0] = new SearchHit(0, "doc 1", piMap, Collections.emptyMap());
import java.util.Collections;
            OpenSearchParseException.class,
        expectThrows(
        assertThrows(
    }
        SearchHit[] hits = new SearchHit[1];
    private SearchResponse createTestResponse() {
        assertThrows(IllegalArgumentException.class, () -> sortResponseProcessor.processResponse(request, createTestResponseNullField()));
        SearchHits searchHits = new SearchHits(hits, new TotalHits(2, TotalHits.Relation.EQUAL_TO), 2);
        assertNull(sortResponse.getHits().getHits()[1].getSourceAsMap());
        config.put("target_field", targetField);
            null,
        );
            false,
        assertEquals(List.of(9, 6, 5, 4, 3, 2, 1, 1), sortResponse.getHits().getHits()[0].field("digits").getValues());
            () -> factory.create(Collections.emptyMap(), null, null, false, Collections.emptyMap(), null)
public class SortResponseProcessorTests extends OpenSearchTestCase {
        assertNotNull(map);
            "digits",
        Map<String, Object> map = sortResponse.getHits().getHits()[0].getSourceAsMap();
            null,
        );
import org.opensearch.action.search.SearchRequest;
    }
        x.add(3);
import org.opensearch.search.builder.SearchSourceBuilder;
    private SearchResponse createTestResponseNullListEntry() {
        hits[0].sourceRef(new BytesArray("{ \"digits\" : " + PI + " }"));
        eMap.put("digits", new DocumentField("digits", E));
import org.opensearch.index.query.TermQueryBuilder;
            "maps",
        hits[0] = new SearchHit(0, "doc 1", xMap, Collections.emptyMap());
        assertEquals(sortField, processor.getSortField());
            null
            null
        SortResponseProcessor sortResponseProcessor = new SortResponseProcessor(
    }
    public void testNullField() {
 * this file be licensed under the Apache-2.0 license or a.java
    }
        assertEquals(List.of(1, 1, 2, 3, 4, 5, 6, 9), sortResponse.getHits().getHits()[0].field("sorted").getValues());
        SearchResponse response = createTestResponse();
        Map<String, DocumentField> map = new HashMap<>();
        );
            () -> sortResponseProcessor.processResponse(request, createTestResponseNullListEntry())
        config.put("field", sortField);
        SortResponseProcessor.Factory factory = new SortResponseProcessor.Factory();
            "digits",
        SortResponseProcessor sortResponseProcessor = new SortResponseProcessor(
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);
    }
        SearchHit[] hits = new SearchHit[1];
            null,
        hits[0].score((float) Math.PI);
    }
        String sortField = RandomDocumentPicks.randomFieldName(random());
            null
            "sorted"
        String targetField = RandomDocumentPicks.randomFieldName(random());
import org.opensearch.ingest.RandomDocumentPicks;
            false,
        hits[0].sourceRef(new BytesArray("{ \"digits\" : null }"));
        );
import org.apache.lucene.search.TotalHits;
            null,
        SearchRequest request = createDummyRequest();
    }
            () -> sortResponseProcessor.processResponse(request, createTestResponseNotComparable())
            SortResponseProcessor.SortOrder.DESCENDING,
            null,
        hits[0].sourceRef(new BytesArray("{ \"maps\" : [{ \"foo\" : \"I'm incomparable!\"}]] }"));
        x.add(null);
import java.util.List;
        hits[0].score((float) Math.PI);
        SortResponseProcessor processor = factory.create(Collections.emptyMap(), null, null, false, config, null);
package org.opensearch.search.pipeline.common;
        SearchHits searchHits = new SearchHits(hits, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1);
        config.put("order", "desc");
    private static final List<Object> PI = List.of(3, 1, 4, 1, 5, 9, 2, 6);
        Map<String, Object> config = new HashMap<>();
        piMap.put("maps", new DocumentField("maps", List.of(Map.of("foo", "I'm incomparable!"))));
import org.opensearch.index.query.QueryBuilder;
        assertEquals("sort", processor.getType());
    }
            null,
        SearchRequest request = createDummyRequest();
        assertThrows(
        map.put("digits", null);
            IllegalArgumentException.class,
        SearchResponse response = createTestResponse();
    private SearchResponse createTestResponseNullField() {
import org.opensearch.search.SearchHits;
        return new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);
    }
        assertEquals(PI, sortResponse.getHits().getHits()[0].field("digits").getValues());
            SortResponseProcessor.SortOrder.ASCENDING,
    public void testSortResponseSameField() throws Exception {
    private SearchResponse createTestResponseNotComparable() {
        assertEquals(E, sortResponse.getHits().getHits()[1].field("digits").getValues());
