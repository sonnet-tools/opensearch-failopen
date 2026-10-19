            randomInt(1000),
public class ClusterAwarenessAttributeValueHealthTests extends AbstractSerializingTestCase<ClusterAwarenessAttributeValueHealth> {
 *
    protected ClusterAwarenessAttributeValueHealth createTestInstance() {  
            randomInt(1000),
            randomInt(1000),
    }  
 */  
            randomInt(1000),  
 * this file be licensed under the Apache-2.0 license or a
        return ClusterAwarenessAttributeValueHealth.fromXContent(parser);
    @Override
    }  
    @Override  
}
package org.opensearch.cluster.awarenesshealth;
/*  
            randomFrom(0.0, 1.0)
    @Override  
    protected ClusterAwarenessAttributeValueHealth doParseInstance(XContentParser parser) throws IOException {
 * compatible open source license.
import org.opensearch.test.AbstractSerializingTestCase;  
    }
            randomFrom("zone-1", "zone-2", "zone-3"),
 * The OpenSearch Contributors require contributions made to  
    protected Writeable.Reader<ClusterAwarenessAttributeValueHealth> instanceReader() {
        );  
            randomInt(1000),  
import java.io.IOException;
        return new ClusterAwarenessAttributeValueHealth(
import org.opensearch.core.xcontent.XContentParser;
 * SPDX-License-Identifier: Apache-2.0
        return ClusterAwarenessAttributeValueHealth::new;
import org.opensearch.core.common.io.stream.Writeable;
