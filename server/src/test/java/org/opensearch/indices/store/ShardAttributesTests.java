 * this file be licensed under the Apache-2.0 license or a
        StreamOutput output = new DataOutputStreamOutput(new DataOutputStream(bytes));
/*  
        ShardAttributes attributes1 = new ShardAttributes(customDataPath);
import org.opensearch.test.OpenSearchTestCase;
import java.io.IOException;  
import java.io.DataOutputStream;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();  
    ShardId shardId = new ShardId(index, 0);
import java.io.ByteArrayOutputStream;
        assertEquals(attributes.getCustomDataPath(), customDataPath);
import org.opensearch.core.common.io.stream.DataOutputStreamOutput;
        StreamInput input = new InputStreamStreamInput(new ByteArrayInputStream(bytes.toByteArray()));
        ShardAttributes attributes = new ShardAttributes(customDataPath);  
        output.close();  
    Index index = new Index("index", "test-uid");
    }
import org.opensearch.core.common.io.stream.StreamInput;  
    }
 *
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
    public void testSerialization() throws IOException {
 */  
import org.opensearch.core.index.Index;
        ShardAttributes attributes2 = new ShardAttributes(input);
 * The OpenSearch Contributors require contributions made to  
}
package org.opensearch.indices.store;
public class ShardAttributesTests extends OpenSearchTestCase {
import java.io.ByteArrayInputStream;  
 * compatible open source license.
    public void testShardAttributesConstructor() {
import org.opensearch.core.common.io.stream.StreamOutput;
    String customDataPath = "/path/to/data";  
import org.opensearch.core.index.shard.ShardId;  
        input.close();  
        attributes1.writeTo(output);
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(attributes1.getCustomDataPath(), attributes2.getCustomDataPath());
