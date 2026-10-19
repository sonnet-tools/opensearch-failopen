            assertEquals(actualIndexResult.getFailureReason(), expectedIndexResult.getFailureReason());  
        return new HotToWarmTieringResponse.IndexResult(indexName, failureReason);
}
    protected HotToWarmTieringResponse createTestInstance() {
     * Verifies that ToXContent works with any random {@link HotToWarmTieringResponse} object
    }  
        HotToWarmTieringResponse testResponse = randomHotToWarmTieringResponse();  
    /**
    }
        String[] indices = new String[] { "index2", "index1" };  
        XContentType xContentType = randomFrom(XContentType.values());
            HotToWarmTieringResponse.IndexResult expectedIndexResult = expected.getFailedIndices().get(i);
            assertNotSame(expectedIndexResult, actualIndexResult);
            testResponse.toXContent(builder, ToXContent.EMPTY_PARAMS);  
    /**
        content.endArray().endObject();
    /**
        return new HotToWarmTieringResponse(randomBoolean(), indexResults);
        }
        content.startObject().field("index", "index1").field("error", "reason1").endObject();
 * The OpenSearch Contributors require contributions made to  
    public void testToXContentWorksForRandomResponse() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
    private HotToWarmTieringResponse randomHotToWarmTieringResponse() {
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
import org.opensearch.test.AbstractWireSerializingTestCase;  
    private HotToWarmTieringResponse.IndexResult randomIndexResult() {
import org.opensearch.common.xcontent.XContentFactory;
     */
import java.util.List;  
    }
        List<HotToWarmTieringResponse.IndexResult> indexResults = new LinkedList<>();
    }  
        for (int i = 0; i < numIndexResult; ++i) {
     */
    }  
import java.util.LinkedList;
    /**
    protected Writeable.Reader<HotToWarmTieringResponse> instanceReader() {
            indexResults.add(randomIndexResult());  
     * @return - randomly generated object of type {@link HotToWarmTieringResponse}  
        }
import org.opensearch.core.xcontent.XContentBuilder;
/*  
    }
        }
        XContentBuilder content = XContentFactory.jsonBuilder().startObject().field("acknowledged", true).startArray("failed_indices");  
    @Override
        HotToWarmTieringResponse testResponse = new HotToWarmTieringResponse(true, results);  
            HotToWarmTieringResponse.IndexResult actualIndexResult = actual.getFailedIndices().get(i);  
        }
import org.opensearch.core.common.io.stream.Writeable;  
        assertNotSame(expected, actual);
        List<HotToWarmTieringResponse.IndexResult> results = new LinkedList<>();
    public void testToXContentOutput() throws Exception {
        assertEquals(actual.isAcknowledged(), expected.isAcknowledged());
 * SPDX-License-Identifier: Apache-2.0
 */  
 *
        content.startObject().field("index", "index2").field("error", "reason2").endObject();  
     * Verify the XContent output of the response object
     */
        // generate a corresponding expected xcontent
            results.add(new HotToWarmTieringResponse.IndexResult(indices[i], errorReasons[i]));
        assertEquals(content.toString(), testResponse.toString());
        for (int i = 0; i < expected.getFailedIndices().size(); i++) {
    @Override
 * compatible open source license.
            assertEquals(actualIndexResult.getIndex(), expectedIndexResult.getIndex());
     * @throws Exception - in case of error  
     * @return - randomly generated object of type {@link HotToWarmTieringResponse.IndexResult}  
        return randomHotToWarmTieringResponse();
     * @throws Exception - in case of error  
        return HotToWarmTieringResponse::new;  
        int numIndexResult = randomIntBetween(0, 10);  
public class HotToWarmTieringResponseTests extends AbstractWireSerializingTestCase<HotToWarmTieringResponse> {
        String indexName = randomAlphaOfLengthBetween(1, 50);  
        for (int i = 0; i < indices.length; ++i) {  
        String failureReason = randomAlphaOfLengthBetween(1, 200);
import org.opensearch.common.xcontent.XContentType;
        String[] errorReasons = new String[] { "reason2", "reason1" };
        // expected result should be in the sorted order
import org.opensearch.core.xcontent.ToXContent;
    }  
package org.opensearch.action.admin.indices.tiering;
    @Override  
    protected void assertEqualInstances(HotToWarmTieringResponse expected, HotToWarmTieringResponse actual) {  
     */
