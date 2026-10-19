        String attributeValue = randomAlphaOfLength(6);
    }  
        DecommissionAttribute decommissionAttribute = new DecommissionAttribute(attributeName, attributeValue);
        String attributeName = randomAlphaOfLength(6);  
import org.opensearch.cluster.decommission.DecommissionAttributeMetadata;
import java.io.IOException;
        return false;
public class DecommissionAttributeMetadataXContentTests extends AbstractXContentTestCase<DecommissionAttributeMetadata> {  
    }
    protected DecommissionAttributeMetadata createTestInstance() {
    @Override
    protected DecommissionAttributeMetadata doParseInstance(XContentParser parser) throws IOException {
package org.opensearch.cluster.metadata;
    }
 */  
import org.opensearch.cluster.decommission.DecommissionAttribute;
        return new DecommissionAttributeMetadata(decommissionAttribute, decommissionStatus, randomAlphaOfLength(10));
    protected boolean supportsUnknownFields() {
 *
    @Override  
import org.opensearch.cluster.decommission.DecommissionStatus;  
import org.opensearch.core.xcontent.XContentParser;
        DecommissionStatus decommissionStatus = randomFrom(DecommissionStatus.values());  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
    @Override
 * compatible open source license.
import org.opensearch.test.AbstractXContentTestCase;
}
        return DecommissionAttributeMetadata.fromXContent(parser);  
 * The OpenSearch Contributors require contributions made to  
/*  
