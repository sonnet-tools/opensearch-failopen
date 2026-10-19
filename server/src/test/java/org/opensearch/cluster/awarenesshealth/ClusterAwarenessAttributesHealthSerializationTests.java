            2,
    protected ClusterAwarenessAttributesHealth doParseInstance(XContentParser parser) throws IOException {  
        ClusterAwarenessAttributeValueHealth clusterAwarenessAttributeValueHealth3 = new ClusterAwarenessAttributeValueHealth(
            0,
    @Override  
            1.0
 *
            2,
 * this file be licensed under the Apache-2.0 license or a
/*  
import java.util.HashMap;  
    }
            0,
        ClusterAwarenessAttributeValueHealth clusterAwarenessAttributeValueHealth1 = new ClusterAwarenessAttributeValueHealth(  
        return ClusterAwarenessAttributesHealth::new;  
            2,
    protected Writeable.Reader<ClusterAwarenessAttributesHealth> instanceReader() {
        return ClusterAwarenessAttributesHealth.fromXContent(parser);
            2,
        clusterAwarenessAttributeValueHealthMap.put(clusterAwarenessAttributeValueHealth3.getName(), clusterAwarenessAttributeValueHealth3);
            2,
            "zone-2",
        );  
            1.0
    }
        );
import org.opensearch.core.common.io.stream.Writeable;
    @Override
 */  
 * The OpenSearch Contributors require contributions made to  
        return new ClusterAwarenessAttributesHealth("zone", clusterAwarenessAttributeValueHealthMap);
            "zone-3",  
 * SPDX-License-Identifier: Apache-2.0
        clusterAwarenessAttributeValueHealthMap.put(clusterAwarenessAttributeValueHealth2.getName(), clusterAwarenessAttributeValueHealth2);
import org.opensearch.core.xcontent.XContentParser;
            0,  
 * compatible open source license.
        ClusterAwarenessAttributeValueHealth clusterAwarenessAttributeValueHealth2 = new ClusterAwarenessAttributeValueHealth(
import java.io.IOException;
            "zone-1",
        );
public class ClusterAwarenessAttributesHealthSerializationTests extends AbstractSerializingTestCase<ClusterAwarenessAttributesHealth> {  
            0.0  
            2,  
import org.opensearch.test.AbstractSerializingTestCase;  
            0,
package org.opensearch.cluster.awarenesshealth;
import java.util.Map;
    }
            2,  
            0,
        Map<String, ClusterAwarenessAttributeValueHealth> clusterAwarenessAttributeValueHealthMap = new HashMap<>();
            2,  
            2,
    protected ClusterAwarenessAttributesHealth createTestInstance() {
    @Override
}  
            0,  
        clusterAwarenessAttributeValueHealthMap.put(clusterAwarenessAttributeValueHealth1.getName(), clusterAwarenessAttributeValueHealth1);  
