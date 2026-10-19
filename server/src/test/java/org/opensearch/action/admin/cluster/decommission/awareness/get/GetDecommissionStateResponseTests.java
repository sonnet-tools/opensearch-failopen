import org.opensearch.core.xcontent.XContentParser;
 * compatible open source license.
 *
import org.opensearch.cluster.decommission.DecommissionStatus;
public class GetDecommissionStateResponseTests extends AbstractXContentTestCase<GetDecommissionStateResponse> {
 * SPDX-License-Identifier: Apache-2.0
        }  
        return false;
}
package org.opensearch.action.admin.cluster.decommission.awareness.get;
    @Override
import org.opensearch.test.AbstractXContentTestCase;  
    @Override
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        if (randomBoolean()) {  
    }
    }  
            attributeValue = randomAlphaOfLength(10);
            status = randomFrom(DecommissionStatus.values());
        return new GetDecommissionStateResponse(attributeValue, status);
    protected boolean supportsUnknownFields() {
    protected GetDecommissionStateResponse doParseInstance(XContentParser parser) throws IOException {
 */  
        String attributeValue = null;
    }
        return GetDecommissionStateResponse.fromXContent(parser);  
import java.io.IOException;
    @Override  
        DecommissionStatus status = null;
    protected GetDecommissionStateResponse createTestInstance() {  
/*  
