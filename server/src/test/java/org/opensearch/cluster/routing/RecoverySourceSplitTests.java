public class RecoverySourceSplitTests extends OpenSearchTestCase {
 */  
        RecoverySource deserialized = RecoverySource.readFrom(in);
        assertFalse(RecoverySource.InPlaceSplitShardRecoverySource.INSTANCE.expectEmptyRetentionLeases());
 *
        BytesStreamOutput out = new BytesStreamOutput();
    }
    public void testInPlaceSplitShardRecoverySourceIsSingleton() {
        StreamInput in = out.bytes().streamInput();
        RecoverySource.InPlaceSplitShardRecoverySource source = RecoverySource.InPlaceSplitShardRecoverySource.INSTANCE;
    }  
    }  
        source.writeTo(out);  
package org.opensearch.cluster.routing;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("in-place shard split", RecoverySource.InPlaceSplitShardRecoverySource.INSTANCE.toString());
    }
    }
 * compatible open source license.
    public void testInPlaceSplitShardRecoverySourceToString() {
import org.opensearch.core.common.io.stream.StreamInput;
        assertSame(RecoverySource.InPlaceSplitShardRecoverySource.INSTANCE, RecoverySource.InPlaceSplitShardRecoverySource.INSTANCE);  
import java.io.IOException;
        assertEquals(RecoverySource.Type.IN_PLACE_SPLIT_SHARD, types[types.length - 1]);
import org.opensearch.test.OpenSearchTestCase;  
        RecoverySource.Type[] types = RecoverySource.Type.values();  
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertEquals(RecoverySource.Type.IN_PLACE_SPLIT_SHARD, source.getType());
    public void testInPlaceSplitShardRecoverySourceDoesNotExpectEmptyRetentionLeases() {  
        RecoverySource source = RecoverySource.InPlaceSplitShardRecoverySource.INSTANCE;  
/*  
        assertSame(RecoverySource.InPlaceSplitShardRecoverySource.INSTANCE, deserialized);
    }
    public void testInPlaceSplitShardRecoverySourceType() {  
    public void testSerializationRoundTrip() throws IOException {
}  
    public void testTypeEnumOrdinalStability() {
        // IN_PLACE_SPLIT_SHARD must be at the end to preserve ordinals of existing types
 * The OpenSearch Contributors require contributions made to  
