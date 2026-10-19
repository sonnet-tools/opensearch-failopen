 * SPDX-License-Identifier: Apache-2.0
            }
        RenameFieldResponseProcessor processor = factory.create(Collections.emptyMap(), null, null, false, config, null);  
 * The OpenSearch Contributors require contributions made to  
        SearchRequest request = createDummyRequest();  
        }
    public void testFactory() throws Exception {
        assertEquals(processor.getType(), "rename_field");
import org.opensearch.search.builder.SearchSourceBuilder;
            false  
import org.opensearch.test.OpenSearchTestCase;
    public void testMissingField() throws Exception {  
        SearchResponse response = createTestResponse(2, false);
            "field 0",
            "field",  
        RenameFieldResponseProcessor renameFieldResponseProcessor = new RenameFieldResponseProcessor(  
import org.opensearch.search.SearchHits;  
            false,
        SearchRequest request = createDummyRequest();
import org.opensearch.action.search.SearchResponseSections;
        RenameFieldResponseProcessor renameFieldResponseProcessor = new RenameFieldResponseProcessor(
    }
        expectThrows(  
            null,  
        assertTrue(foundField);  
            () -> factory.create(Collections.emptyMap(), null, null, false, Collections.emptyMap(), null)
import org.opensearch.core.common.bytes.BytesArray;
            "new field",
        );  
        assertFalse(processor.isIgnoreMissing());
        assertEquals(processor.getOldField(), oldField);
            OpenSearchParseException.class,
    }
import java.util.Map;  
            false,  
        );
        config.put("target_field", newField);  
package org.opensearch.search.pipeline.common;
    }  
            }
            false,
import java.util.Collections;
}
            null,
import java.util.HashMap;
import org.opensearch.ingest.RandomDocumentPicks;
        );  
            "new field",
        SearchResponse renameResponse = renameFieldResponseProcessor.processResponse(request, createTestResponse(5, true));
            null,
import org.opensearch.search.SearchHit;
                foundField = true;  
import org.apache.lucene.search.TotalHits;
    }
    }
        }  
        );
            null,
public class RenameFieldResponseProcessorTests extends OpenSearchTestCase {
            hits[i] = new SearchHit(i, "doc " + i, searchHitFields, Collections.emptyMap());  
        return new SearchRequest().source(source);
        config.put("field", oldField);
        assertThrows(
        assertEquals(processor.getNewField(), newField);  
            IllegalArgumentException.class,
            "new field",
            hits[i].score(i);
        boolean foundField = false;  
        SearchHit[] hits = new SearchHit[size];
import org.opensearch.action.search.SearchResponse;
 * compatible open source license.
 */  
            () -> renameFieldResponseProcessor.processResponse(request, createTestResponse(3, true))  
 *
            false
        QueryBuilder query = new TermQueryBuilder("field", "value");
        assertNotEquals(response.getHits(), renameResponse.getHits());
        SearchResponseSections searchResponseSections = new SearchResponseSections(searchHits, null, null, false, false, null, 0);
            Map<String, DocumentField> searchHitFields = new HashMap<>();
 * this file be licensed under the Apache-2.0 license or a.java
import org.opensearch.action.search.SearchRequest;  
        SearchResponse response = createTestResponse(5, true);
        String newField = RandomDocumentPicks.randomFieldName(random());  
import org.opensearch.OpenSearchParseException;
        SearchHits searchHits = new SearchHits(hits, new TotalHits(size * 2L, TotalHits.Relation.EQUAL_TO), size);
        for (int i = 0; i < size; i++) {  
        RenameFieldResponseProcessor renameFieldResponseProcessor = new RenameFieldResponseProcessor(
        for (SearchHit hit : renameResponse.getHits().getHits()) {
        SearchResponse renameResponse = renameFieldResponseProcessor.processResponse(request, createTestResponse(5, false));  
        return new SearchResponse(searchResponseSections, null, 1, 1, 0, 10, null, null);  
    public void testRenameResponse() throws Exception {  
    public void testRenameResponseWithMapping() throws Exception {
        SearchSourceBuilder source = new SearchSourceBuilder().query(query);  
    private SearchResponse createTestResponse(int size, boolean includeMapping) {
import org.opensearch.common.document.DocumentField;  
/*  
        String oldField = RandomDocumentPicks.randomFieldName(random());
            null,
import org.opensearch.index.query.QueryBuilder;
            if (includeMapping) {
            true
            searchHitFields.put("field " + i, new DocumentField("value " + i, Collections.emptyList()));
                searchHitFields.put("field " + i, new DocumentField("value " + i, Collections.emptyList()));  
        Map<String, Object> config = new HashMap<>();
    private SearchRequest createDummyRequest() {
        assertNotEquals(response.getHits(), renameResponse.getHits());
        RenameFieldResponseProcessor.Factory factory = new RenameFieldResponseProcessor.Factory();
            "field 0",  
            if (hit.getFields().containsKey("new field")) {
            hits[i].sourceRef(new BytesArray("{ \"field " + i + "\" : \"value " + i + "\" }"));
            null,  
    }
import org.opensearch.index.query.TermQueryBuilder;  
        SearchRequest request = createDummyRequest();
        );  
