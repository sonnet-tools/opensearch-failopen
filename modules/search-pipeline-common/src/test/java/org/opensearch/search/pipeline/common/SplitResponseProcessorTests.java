        SearchResponse splitResponse = splitResponseProcessor.processResponse(request, response);  
        SplitResponseProcessor splitResponseProcessor = new SplitResponseProcessor(null, null, false, "dsv", "\\d", false, "split");
        assertEquals(List.of("one", "two", "three"), splitResponse.getHits().getHits()[0].field("split").getValues());  
import java.util.List;  
        Map<String, DocumentField> piMap = new HashMap<>();  
        assertNotNull(map);
import org.opensearch.OpenSearchParseException;
        SearchRequest request = createDummyRequest();  
 * SPDX-License-Identifier: Apache-2.0
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);
    public void testNullField() {  
        SearchHits searchHits = new SearchHits(hits, new TotalHits(2, TotalHits.Relation.EQUAL_TO), 2);
    private SearchResponse createTestResponseNullField() {
        hits[1].score(2f);
        hits[0].sourceRef(new BytesArray("{ \"maps\" : [{ \"foo\" : \"I'm the Map!\"}]] }"));  
        SearchHits searchHits = new SearchHits(hits, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1);  
        String targetField = RandomDocumentPicks.randomFieldName(random());  
        SearchHits searchHits = new SearchHits(hits, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1);
        map.put("csv", null);  
        SearchHit[] hits = new SearchHit[1];  
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);
    }
            OpenSearchParseException.class,
        map.put("empty", new DocumentField("empty", List.of()));
public class SplitResponseProcessorTests extends OpenSearchTestCase {  
import org.opensearch.index.query.QueryBuilder;
        assertEquals(List.of("one", "two", "three"), map.get("split"));  
        Map<String, Object> map = splitResponse.getHits().getHits()[0].getSourceAsMap();
        assertThrows(IllegalArgumentException.class, () -> splitResponseProcessor.processResponse(request, createTestResponseEmptyList()));  
    }  
    public void testSplitResponseEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> splitResponseProcessor.processResponse(request, createTestResponseNotString()));
 * The OpenSearch Contributors require contributions made to  
        csvMap = new HashMap<>();
        SearchResponse splitResponse = splitResponseProcessor.processResponse(request, response);
        assertTrue(processor.isPreserveTrailing());  
        config.put("preserve_trailing", true);
    private SearchResponse createTestResponseRegex() {  
    }
    private SearchRequest createDummyRequest() {  
        assertEquals(",", processor.getSeparator());
        // one response with source  
        hits[0] = new SearchHit(0, "doc 1", dsvMap, Collections.emptyMap());
        SearchRequest request = createDummyRequest();
        SearchRequest request = createDummyRequest();  
        SearchHit[] hits = new SearchHit[1];
        config.put("separator", ",");  
        return new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);
        SearchRequest request = createDummyRequest();
    }
        Map<String, Object> map = splitResponse.getHits().getHits()[0].getSourceAsMap();  
/*  
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);  
        assertEquals(List.of("one", "two", "three"), map.get("split"));
        hits[0] = new SearchHit(0, "doc 1", csvMap, Collections.emptyMap());  
        );  
    }
    public void testSplitResponse() throws Exception {
        return new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);
import java.util.Collections;
import org.opensearch.action.search.SearchRequest;  
        return new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);
import org.opensearch.core.common.bytes.BytesArray;
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.search.SearchHit;
        SplitResponseProcessor splitResponseProcessor = new SplitResponseProcessor(null, null, false, "empty", ",", false, null);
        assertEquals(splitField, processor.getSplitField());
        SearchResponse response = createTestResponse();  
        Map<String, DocumentField> map = new HashMap<>();
        Map<String, DocumentField> map = new HashMap<>();
        assertEquals(List.of("alpha", "beta", "gamma"), splitResponse.getHits().getHits()[1].field("split").getValues());  
    public void testNotStringField() {
        assertEquals(response.getHits(), splitResponse.getHits());
        SplitResponseProcessor splitResponseProcessor = new SplitResponseProcessor(null, null, false, "maps", ",", false, null);
        Map<String, DocumentField> csvMap = new HashMap<>();
        hits[0].score(1f);  
import org.opensearch.action.search.SearchResponseSections;
    private SearchResponse createTestResponseNotString() {  
 */  
        assertNotNull(map);
        hits[0].score(1f);
 * this file be licensed under the Apache-2.0 license or a.java
        assertEquals(List.of("alpha", "beta", "gamma", ""), splitResponse.getHits().getHits()[1].field("csv").getValues());
        piMap.put("maps", new DocumentField("maps", List.of(Map.of("foo", "I'm the Map!"))));
        hits[0].score(1f);
        hits[0].sourceRef(new BytesArray("{ \"empty\" : [] }"));
        hits[0].sourceRef(new BytesArray("{ \"dsv\" : \"" + REGEX_DELIM + "\" }"));  
    }
import org.opensearch.action.search.SearchResponse;
        hits[0] = new SearchHit(0, "doc 1", map, Collections.emptyMap());  
package org.opensearch.search.pipeline.common;
        assertEquals(response.getHits(), splitResponse.getHits());  
        expectThrows(  
        // one without source
    }  
        SearchHits searchHits = new SearchHits(hits, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1);
        dsvMap.put("dsv", new DocumentField("dsv", List.of(REGEX_DELIM)));
        assertEquals(targetField, processor.getTargetField());
        Map<String, DocumentField> dsvMap = new HashMap<>();  
import org.opensearch.ingest.RandomDocumentPicks;
        SearchHit[] hits = new SearchHit[2];
        SplitResponseProcessor splitResponseProcessor = new SplitResponseProcessor(null, null, false, "csv", ",", false, "split");
        assertEquals(List.of("one", "two", "three"), splitResponse.getHits().getHits()[0].field("split").getValues());
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);
    public void testSplitResponseSameField() throws Exception {
        assertEquals(response.getHits(), splitResponse.getHits());  
        hits[0] = new SearchHit(0, "doc 1", piMap, Collections.emptyMap());
        hits[1] = new SearchHit(1, "doc 2", csvMap, Collections.emptyMap());
    private static final String NO_TRAILING = "one,two,three";
    }  
        assertEquals("split", processor.getType());  
    public void testFactory() {
        String splitField = RandomDocumentPicks.randomFieldName(random());
import org.opensearch.search.builder.SearchSourceBuilder;
        return new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);  
        SplitResponseProcessor splitResponseProcessor = new SplitResponseProcessor(null, null, false, "csv", ",", true, null);
        SplitResponseProcessor splitResponseProcessor = new SplitResponseProcessor(null, null, false, "csv", ",", false, null);  
        SearchRequest request = createDummyRequest();  
        SearchResponse response = createTestResponse();  
 * compatible open source license.
import java.util.Map;
    }  
        SplitResponseProcessor.Factory factory = new SplitResponseProcessor.Factory();
    public void testSplitResponseRegex() throws Exception {
        hits[0] = new SearchHit(0, "doc 1", map, Collections.emptyMap());
        SearchRequest request = createDummyRequest();  
import org.opensearch.search.SearchHits;  
import org.apache.lucene.search.TotalHits;
}
    }  
        hits[0].sourceRef(new BytesArray("{ \"csv\" : null }"));
        hits[0].score(1f);
        assertEquals(List.of("one", "two", "three"), splitResponse.getHits().getHits()[0].field("csv").getValues());
    }
        assertThrows(IllegalArgumentException.class, () -> splitResponseProcessor.processResponse(request, createTestResponseNullField()));
        assertNull(splitResponse.getHits().getHits()[1].getSourceAsMap());
            () -> factory.create(Collections.emptyMap(), null, null, false, Collections.emptyMap(), null)
        return new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);  
    }
    private static final String REGEX_DELIM = "one1two2three";
        hits[0].sourceRef(new BytesArray("{ \"csv\" : \"" + NO_TRAILING + "\" }"));
    private static final String TRAILING = "alpha,beta,gamma,";  
        assertEquals(NO_TRAILING, splitResponse.getHits().getHits()[0].field("csv").getValue());
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);
import org.opensearch.index.query.TermQueryBuilder;  
        SplitResponseProcessor processor = factory.create(Collections.emptyMap(), null, null, false, config, null);
 *
        QueryBuilder query = new TermQueryBuilder("field", "value");
        config.put("target_field", targetField);
        SearchResponse response = createTestResponseRegex();
        SearchHits searchHits = new SearchHits(hits, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1);  
    }
        assertEquals(REGEX_DELIM, splitResponse.getHits().getHits()[0].field("dsv").getValue());
    private SearchResponse createTestResponseEmptyList() {
        SearchHit[] hits = new SearchHit[1];
        csvMap.put("csv", new DocumentField("csv", List.of(NO_TRAILING)));
        csvMap.put("csv", new DocumentField("csv", List.of(TRAILING)));  
        SearchHit[] hits = new SearchHit[1];
import java.util.HashMap;
        assertEquals(TRAILING, splitResponse.getHits().getHits()[1].field("csv").getValue());
        Map<String, Object> config = new HashMap<>();
import org.opensearch.common.document.DocumentField;  
    private SearchResponse createTestResponse() {  
        return new SearchRequest().source(source);  
        config.put("field", splitField);
        hits[0].score(1f);
        SearchResponse splitResponse = splitResponseProcessor.processResponse(request, response);
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
