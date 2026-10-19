import org.opensearch.action.search.SearchResponse;  
        }  
            false,
        testProcessor(false);
        );  
    }
import org.opensearch.common.document.DocumentField;
            1.0f
        assertEquals(processedResponse.getHits().getHits().length, processedResponse.getHits().getCollapseValues().length);  
        }
            if (includeDocField) {
        if (numHits % 2 == 0) {  
        SearchHits searchHits = new SearchHits(
import org.opensearch.test.OpenSearchTestCase;  
            hitsArray,  
    private void testProcessor(boolean includeDocField) {
            assertEquals(numHits / 2 + 1, processedResponse.getHits().getHits().length);  
        for (SearchHit collapsedHit : processedResponse.getHits()) {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.internal.InternalSearchResponse;
            Map<String, DocumentField> docFields;  
        SearchHit[] hitsArray = new SearchHit[numHits];
 * this file be licensed under the Apache-2.0 license or a
    public void testWithDocumentFields() {
        testProcessor(true);  
import java.util.HashMap;  
            }  
import org.opensearch.action.search.SearchRequest;
import java.util.Collections;
        SearchResponse inputResponse = generateResponse(numHits, includeDocField);  
}
import org.opensearch.search.SearchHits;
            config,
import org.opensearch.search.SearchHit;  
import org.opensearch.core.common.bytes.BytesArray;
            SearchHit hit = new SearchHit(i, Integer.toString(i), docFields, Collections.emptyMap());
            null  
import java.util.List;
            assertEquals(0, collapsedHit.docId() % 2);  
        return new SearchResponse(internalSearchResponse, null, 1, 1, 0, 10, null, null);
    }  
            new TotalHits(Math.max(numHits, 1000), TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO),
        for (int i = 0; i < processedResponse.getHits().getHits().length; i++) {
            assertEquals(numHits / 2, processedResponse.getHits().getHits().length);
/*  
        for (int i = 0; i < numHits; i++) {
public class CollapseResponseProcessorTests extends OpenSearchTestCase {
            } else {
            Collections.emptyMap(),
        InternalSearchResponse internalSearchResponse = new InternalSearchResponse(searchHits, null, null, null, false, false, 0);
        SearchResponse processedResponse = processor.processResponse(new SearchRequest(), inputResponse);
        }
package org.opensearch.search.pipeline.common;
 * compatible open source license.
            hit.sourceRef(new BytesArray("{\"groupid\": " + groupValue + "}"));
    public void testWithSourceField() {  
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(i, processedResponse.getHits().getCollapseValues()[i]);
            null,  
        assertEquals("groupid", processedResponse.getHits().getCollapseField());
        );
    }
    private static SearchResponse generateResponse(int numHits, boolean includeDocField) {  
        }
            int groupValue = i / 2;
        CollapseResponseProcessor processor = new CollapseResponseProcessor.Factory().create(  
        } else {
 *
                docFields = Collections.emptyMap();
                docFields = Map.of("groupid", new DocumentField("groupid", List.of(groupValue)));  
import java.util.Map;
            null,
        Map<String, Object> config = new HashMap<>(Map.of(CollapseResponseProcessor.COLLAPSE_FIELD, "groupid"));
import org.apache.lucene.search.TotalHits;
            hitsArray[i] = hit;  
 */  
    }
        int numHits = randomIntBetween(1, 100);
