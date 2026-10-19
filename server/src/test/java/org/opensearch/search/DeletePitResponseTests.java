            parsedResponse = DeletePitResponse.fromXContent(parser);
        DeletePitInfo deletePitInfo = new DeletePitInfo(randomBoolean(), "pitId");
        DeletePitResponse deletePitResponse = new DeletePitResponse(deletePitInfoList);  
 *
        DeletePitResponse parsedResponse;
    }
            deletePitResponse.toXContent(builder, ToXContent.EMPTY_PARAMS);  
        }
import java.io.IOException;  
import java.util.ArrayList;
import org.opensearch.core.xcontent.XContentBuilder;
 * compatible open source license.
    public void testDeletePitResponseToXContent() throws IOException {
        deletePitInfoList.add(deletePitInfo);  
        try (XContentBuilder builder = JsonXContent.contentBuilder()) {
        assertEquals(  
import org.opensearch.core.common.bytes.BytesReference;
 * SPDX-License-Identifier: Apache-2.0
        DeletePitResponse originalResponse = createDeletePitResponseTestItem();
import org.opensearch.core.xcontent.ToXContent;  
import org.opensearch.core.xcontent.XContentHelper;
 * The OpenSearch Contributors require contributions made to  
 */  
}  
import org.opensearch.action.search.DeletePitResponse;
import org.opensearch.action.search.DeletePitInfo;
        return new DeletePitResponse(deletePitInfoList);
import org.opensearch.common.xcontent.XContentType;  
        XContentType xContentType = randomFrom(XContentType.values());
        BytesReference parsedBytes = XContentHelper.toXContent(parsedResponse, xContentType, randomBoolean());
        assertEquals(true, deletePitResponse.getDeletePitResults().get(0).getPitId().equals("pitId"));
    private static DeletePitResponse createDeletePitResponseTestItem() {  
        assertEquals(true, deletePitResponse.getDeletePitResults().get(0).isSuccessful());  
        assertEquals(originalResponse.getDeletePitResults().get(0).getPitId(), parsedResponse.getDeletePitResults().get(0).getPitId());
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {  
public class DeletePitResponseTests extends OpenSearchTestCase {  
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.common.xcontent.json.JsonXContent;
        List<DeletePitInfo> deletePitInfoList = new ArrayList<>();
        assertToXContentEquivalent(originalBytes, parsedBytes, xContentType);  
        );  
import org.opensearch.test.OpenSearchTestCase;
        deletePitInfoList.add(deletePitInfo);
import java.util.List;
            originalResponse.getDeletePitResults().get(0).isSuccessful(),
    }
    public void testDeletePitResponseToAndFromXContent() throws IOException {  
package org.opensearch.search;
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        BytesReference originalBytes = toShuffledXContent(originalResponse, xContentType, ToXContent.EMPTY_PARAMS, randomBoolean());
            parsedResponse.getDeletePitResults().get(0).isSuccessful()
/*  
        List<DeletePitInfo> deletePitInfoList = new ArrayList<>();
        }
        DeletePitInfo deletePitInfo = new DeletePitInfo(true, "pitId");  
 * this file be licensed under the Apache-2.0 license or a
