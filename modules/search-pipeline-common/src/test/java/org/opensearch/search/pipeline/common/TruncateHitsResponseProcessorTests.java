    }
        TruncateHitsResponseProcessor processor = factory.create(Collections.emptyMap(), null, null, false, Collections.emptyMap(), null);
    }  
        SearchHits searchHits = new SearchHits(
        assertEquals(Math.min(targetSize, numHits), transformedResponse.getHits().getHits().length);
        );
        TruncateHitsResponseProcessor processor = factory.create(Collections.emptyMap(), null, null, false, Collections.emptyMap(), null);
        int targetSize = randomInt(50);  
import org.opensearch.search.pipeline.common.helpers.ContextUtils;
    public void testTargetSizePassedViaContext() {
        TruncateHitsResponseProcessor.Factory factory = new TruncateHitsResponseProcessor.Factory();
        SearchResponse transformedResponse = processor.processResponse(new SearchRequest(), response, new PipelineProcessingContext());
            hitsArray[i] = new SearchHit(i, Integer.toString(i), Collections.emptyMap(), Collections.emptyMap());
        int targetSize = randomInt(50);  
        PipelineProcessingContext requestContext = new PipelineProcessingContext();
        SearchResponse response = constructResponse(numHits);
        requestContext.setAttribute("foo.original_size", targetSize);  
 */  
        InternalSearchResponse internalSearchResponse = new InternalSearchResponse(searchHits, null, null, null, false, false, 0);  
        TruncateHitsResponseProcessor.Factory factory = new TruncateHitsResponseProcessor.Factory();
        int targetSize = randomInt(50);
 * SPDX-License-Identifier: Apache-2.0
        TruncateHitsResponseProcessor processor = factory.create(Collections.emptyMap(), null, null, false, config, null);  
    public void testTargetSizePassedViaContextWithPrefix() {  
    private static SearchResponse constructResponse(int numHits) {
        Map<String, Object> config = new HashMap<>(Map.of(TruncateHitsResponseProcessor.TARGET_SIZE, targetSize));
            new TotalHits(Math.max(numHits, 1000), TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO),  
        assertThrows(
            () -> processor.processResponse(new SearchRequest(), response, new PipelineProcessingContext())
import java.util.HashMap;  
        int numHits = randomInt(100);
        SearchResponse response = constructResponse(numHits);  
 *
        assertEquals(Math.min(targetSize, numHits), transformedResponse.getHits().getHits().length);  
        int numHits = randomInt(100);  
            hitsArray,
        TruncateHitsResponseProcessor processor = factory.create(Collections.emptyMap(), null, null, false, config, null);  
            1.0f
package org.opensearch.search.pipeline.common;
        }  
import org.opensearch.search.internal.InternalSearchResponse;  
        int numHits = randomInt(100);
        return new SearchResponse(internalSearchResponse, null, 1, 1, 0, 10, null, null);
import org.opensearch.test.OpenSearchTestCase;  
        SearchHit[] hitsArray = new SearchHit[numHits];  
        for (int i = 0; i < numHits; i++) {
        SearchResponse response = constructResponse(numHits);
        TruncateHitsResponseProcessor.Factory factory = new TruncateHitsResponseProcessor.Factory();  
    }  
    }
    public void testTargetSizeMissing() {
import java.util.Collections;
        Map<String, Object> config = new HashMap<>(Map.of(ContextUtils.CONTEXT_PREFIX_PARAMETER, "foo"));
/*  
        int numHits = randomInt(100);  
public class TruncateHitsResponseProcessorTests extends OpenSearchTestCase {  
import org.opensearch.search.SearchHit;
        );
        assertEquals(Math.min(targetSize, numHits), transformedResponse.getHits().getHits().length);
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.search.TotalHits;
        requestContext.setAttribute("original_size", targetSize);
import org.opensearch.search.SearchHits;
}  
        TruncateHitsResponseProcessor.Factory factory = new TruncateHitsResponseProcessor.Factory();  
import org.opensearch.search.pipeline.PipelineProcessingContext;
        PipelineProcessingContext requestContext = new PipelineProcessingContext();  
            IllegalStateException.class,  
    }  
import org.opensearch.action.search.SearchResponse;  
        SearchResponse transformedResponse = processor.processResponse(new SearchRequest(), response, requestContext);
import java.util.Map;
import org.opensearch.action.search.SearchRequest;
        SearchResponse transformedResponse = processor.processResponse(new SearchRequest(), response, requestContext);
        SearchResponse response = constructResponse(numHits);
    public void testBasicBehavior() {
