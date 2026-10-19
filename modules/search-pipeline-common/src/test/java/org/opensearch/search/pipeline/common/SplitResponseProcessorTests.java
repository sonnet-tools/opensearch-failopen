        config.put("field", splitField);
    private SearchResponse createTestResponseRegex() {
        assertEquals(",", processor.getSeparator());
        return new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);
        SearchResponse splitResponse = splitResponseProcessor.processResponse(request, response);
        SplitResponseProcessor splitResponseProcessor = new SplitResponseProcessor(null, null, false, "csv", ",", false, "split");
        assertEquals(TRAILING, splitResponse.getHits().getHits()[1].field("csv").getValue());
        assertEquals(List.of("one", "two", "three"), map.get("split"));
        SearchRequest request = createDummyRequest();
        map.put("empty", new DocumentField("empty", List.of()));
        assertEquals(REGEX_DELIM, splitResponse.getHits().getHits()[0].field("dsv").getValue());
        SplitResponseProcessor processor = factory.create(Collections.emptyMap(), null, null, false, config, null);
        config.put("preserve_trailing", true);
    public void testNotStringField() {
    }
    private static final String NO_TRAILING = "one,two,three";
        assertEquals(List.of("one", "two", "three"), splitResponse.getHits().getHits()[0].field("csv").getValues());
        hits[0].sourceRef(new BytesArray("{ \"dsv\" : \"" + REGEX_DELIM + "\" }"));
        hits[0].score(1f);
        dsvMap.put("dsv", new DocumentField("dsv", List.of(REGEX_DELIM)));
        Map<String, DocumentField> map = new HashMap<>();
        // one response with source
        SearchHits searchHits = new SearchHits(hits, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1);
    public void testFactory() {
}
import org.opensearch.core.common.bytes.BytesArray;
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);
        Map<String, Object> config = new HashMap<>();
        SearchResponse response = createTestResponse();
 * compatible open source license.
        config.put("separator", ",");
        assertThrows(IllegalArgumentException.class, () -> splitResponseProcessor.processResponse(request, createTestResponseEmptyList()));
        SearchHits searchHits = new SearchHits(hits, new TotalHits(2, TotalHits.Relation.EQUAL_TO), 2);
    public void testSplitResponseRegex() throws Exception {
        assertEquals(List.of("one", "two", "three"), splitResponse.getHits().getHits()[0].field("split").getValues());
        SearchRequest request = createDummyRequest();
        return new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);
    private static final String TRAILING = "alpha,beta,gamma,";
        SearchResponse response = createTestResponse();
import org.opensearch.index.query.TermQueryBuilder;
        SearchHits searchHits = new SearchHits(hits, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1);
            OpenSearchParseException.class,
        assertNull(splitResponse.getHits().getHits()[1].getSourceAsMap());
        Map<String, DocumentField> csvMap = new HashMap<>();
        csvMap.put("csv", new DocumentField("csv", List.of(NO_TRAILING)));
        SearchHit[] hits = new SearchHit[2];
import org.opensearch.common.document.DocumentField;
        SplitResponseProcessor.Factory factory = new SplitResponseProcessor.Factory();
    private SearchResponse createTestResponseNotString() {
import org.opensearch.search.SearchHit;
        SearchRequest request = createDummyRequest();
        piMap.put("maps", new DocumentField("maps", List.of(Map.of("foo", "I'm the Map!"))));
        assertEquals(splitField, processor.getSplitField());
public class SplitResponseProcessorTests extends OpenSearchTestCase {
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);
    private SearchRequest createDummyRequest() {
        assertTrue(processor.isPreserveTrailing());
        );
        assertEquals(List.of("alpha", "beta", "gamma"), splitResponse.getHits().getHits()[1].field("split").getValues());
        map.put("csv", null);
import org.opensearch.ingest.RandomDocumentPicks;
        Map<String, Object> map = splitResponse.getHits().getHits()[0].getSourceAsMap();
    }
        hits[0].sourceRef(new BytesArray("{ \"csv\" : \"" + NO_TRAILING + "\" }"));
 */
        SearchResponse splitResponse = splitResponseProcessor.processResponse(request, response);
        SearchHit[] hits = new SearchHit[1];
        assertEquals(response.getHits(), splitResponse.getHits());
        hits[0] = new SearchHit(0, "doc 1", map, Collections.emptyMap());
        assertNotNull(map);
        assertEquals(response.getHits(), splitResponse.getHits());
        SplitResponseProcessor splitResponseProcessor = new SplitResponseProcessor(null, null, false, "csv", ",", true, null);
        Map<String, DocumentField> map = new HashMap<>();
    public void testNullField() {
        QueryBuilder query = new TermQueryBuilder("field", "value");
        Map<String, Object> map = splitResponse.getHits().getHits()[0].getSourceAsMap();
        assertEquals(List.of("one", "two", "three"), map.get("split"));
        return new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);
    private SearchResponse createTestResponseEmptyList() {
        SplitResponseProcessor splitResponseProcessor = new SplitResponseProcessor(null, null, false, "csv", ",", false, null);
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);
        return new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);
        assertNotNull(map);
        hits[0].sourceRef(new BytesArray("{ \"maps\" : [{ \"foo\" : \"I'm the Map!\"}]] }"));
    public void testSplitResponseSameField() throws Exception {
    }
        SearchHit[] hits = new SearchHit[1];
        String targetField = RandomDocumentPicks.randomFieldName(random());
import java.util.Map;
        SearchHits searchHits = new SearchHits(hits, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1);
    }
    }
import org.opensearch.test.OpenSearchTestCase;
        SearchResponse response = createTestResponseRegex();
        assertEquals(response.getHits(), splitResponse.getHits());
import java.util.HashMap;
import org.opensearch.action.search.SearchResponse;
    public void testSplitResponseEmptyList() {
import java.util.Collections;
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);
        hits[0] = new SearchHit(0, "doc 1", map, Collections.emptyMap());
    public void testSplitResponse() throws Exception {
        SearchResponse splitResponse = splitResponseProcessor.processResponse(request, response);
import org.apache.lucene.search.TotalHits;
        SearchRequest request = createDummyRequest();
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);
        hits[0] = new SearchHit(0, "doc 1", csvMap, Collections.emptyMap());
        hits[0].sourceRef(new BytesArray("{ \"csv\" : null }"));
import org.opensearch.action.search.SearchRequest;
 *
        return new SearchRequest().source(source);
 * The OpenSearch Contributors require contributions made to
        csvMap.put("csv", new DocumentField("csv", List.of(TRAILING)));
        expectThrows(
import java.util.List;
        SearchHits searchHits = new SearchHits(hits, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1);
        hits[0].score(1f);
    private SearchResponse createTestResponseNullField() {
            () -> factory.create(Collections.emptyMap(), null, null, false, Collections.emptyMap(), null)
        SearchHit[] hits = new SearchHit[1];
        assertEquals(NO_TRAILING, splitResponse.getHits().getHits()[0].field("csv").getValue());
    }
        assertEquals(List.of("alpha", "beta", "gamma", ""), splitResponse.getHits().getHits()[1].field("csv").getValues());
        return new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);
        assertEquals(targetField, processor.getTargetField());
        hits[0].sourceRef(new BytesArray("{ \"empty\" : [] }"));
        SearchHit[] hits = new SearchHit[1];
    }
    }
        SplitResponseProcessor splitResponseProcessor = new SplitResponseProcessor(null, null, false, "maps", ",", false, null);
        config.put("target_field", targetField);
        hits[1] = new SearchHit(1, "doc 2", csvMap, Collections.emptyMap());
/*
package org.opensearch.search.pipeline.common;
        hits[0].score(1f);
        assertEquals("split", processor.getType());
import org.opensearch.search.SearchHits;
 * SPDX-License-Identifier: Apache-2.0
    private static final String REGEX_DELIM = "one1two2three";
import org.opensearch.action.search.SearchResponseSections;
    }
    private SearchResponse createTestResponse() {
        SplitResponseProcessor splitResponseProcessor = new SplitResponseProcessor(null, null, false, "empty", ",", false, null);
    }
import org.opensearch.index.query.QueryBuilder;
        hits[1].score(2f);
        assertEquals(List.of("one", "two", "three"), splitResponse.getHits().getHits()[0].field("split").getValues());
        Map<String, DocumentField> dsvMap = new HashMap<>();
        SearchRequest request = createDummyRequest();
        assertThrows(IllegalArgumentException.class, () -> splitResponseProcessor.processResponse(request, createTestResponseNullField()));
        SplitResponseProcessor splitResponseProcessor = new SplitResponseProcessor(null, null, false, "dsv", "\\d", false, "split");
    }
        hits[0] = new SearchHit(0, "doc 1", piMap, Collections.emptyMap());
 * this file be licensed under the Apache-2.0 license or a.java
        assertThrows(IllegalArgumentException.class, () -> splitResponseProcessor.processResponse(request, createTestResponseNotString()));
        hits[0].score(1f);
    }
        hits[0] = new SearchHit(0, "doc 1", dsvMap, Collections.emptyMap());
        String splitField = RandomDocumentPicks.randomFieldName(random());
import org.opensearch.search.builder.SearchSourceBuilder;
        SearchRequest request = createDummyRequest();
        // one without source
        hits[0].score(1f);
    }
import org.opensearch.OpenSearchParseException;
        csvMap = new HashMap<>();
        Map<String, DocumentField> piMap = new HashMap<>();
