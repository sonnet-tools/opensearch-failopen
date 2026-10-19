    }
    public void testGetActiveShardCountWithWaitForActiveShardsInt32() {
    public void testGetActiveShardCountWithNoWaitForActiveShards() {
        // Create a protobuf BulkRequest with wait_for_active_shards = ALL (value 1)
        ActiveShardCount result = ActiveShardCountProtoUtils.parseProto(waitForActiveShards);  
        assertEquals("Should have DEFAULT active shard count", ActiveShardCount.DEFAULT, result);
import org.opensearch.test.OpenSearchTestCase;  
            .setOption(org.opensearch.protobufs.WaitForActiveShardOptions.WAIT_FOR_ACTIVE_SHARD_OPTIONS_ALL)  
        assertEquals("Should have active shard count of 2", ActiveShardCount.from(2), result);
/*  
            .build();
import org.opensearch.action.support.ActiveShardCount;
        assertEquals("Should have default active shard count", ActiveShardCount.DEFAULT, result);  
            .setOption(org.opensearch.protobufs.WaitForActiveShardOptions.WAIT_FOR_ACTIVE_SHARD_OPTIONS_UNSPECIFIED)
import org.opensearch.protobufs.WaitForActiveShards;
}  
        WaitForActiveShards waitForActiveShards = WaitForActiveShards.newBuilder().setCount(2).build();  
        WaitForActiveShards waitForActiveShards = WaitForActiveShards.newBuilder().build();
        // Create a protobuf BulkRequest with wait_for_active_shards but no case set
    public void testGetActiveShardCountWithWaitForActiveShardsUnspecified() {
        assertEquals("Should have DEFAULT active shard count", ActiveShardCount.DEFAULT, result);
        // Verify the result
        // Verify the result  
        assertEquals("Should have active shard count of 0", ActiveShardCount.from(0), result);  
        assertEquals("Should have ALL active shard count", ActiveShardCount.ALL, result);  
        // Verify the result
        // Verify the result  
        ActiveShardCount result = ActiveShardCountProtoUtils.parseProto(waitForActiveShards);
        WaitForActiveShards waitForActiveShards = WaitForActiveShards.newBuilder().setCount(0).build();
    }
package org.opensearch.transport.grpc.proto.request.document.bulk;
 * SPDX-License-Identifier: Apache-2.0
    public void testGetActiveShardCountWithWaitForActiveShardsDefault() {  
    }
 */  
 * The OpenSearch Contributors require contributions made to  
        WaitForActiveShards waitForActiveShards = WaitForActiveShards.newBuilder()
 * compatible open source license.
        WaitForActiveShards waitForActiveShards = WaitForActiveShards.newBuilder()  
        // Verify the result
        // Verify the result - UNSPECIFIED should default to DEFAULT  
        // Create a protobuf BulkRequest with wait_for_active_shards = 0  
    }
        ActiveShardCount result = ActiveShardCountProtoUtils.parseProto(waitForActiveShards);
    }
 *
            .build();
        ActiveShardCount result = ActiveShardCountProtoUtils.parseProto(waitForActiveShards);  
    public void testGetActiveShardCountWithWaitForActiveShardsInt32Zero() {
    }
        ActiveShardCount result = ActiveShardCountProtoUtils.parseProto(waitForActiveShards);
        WaitForActiveShards waitForActiveShards = WaitForActiveShards.newBuilder()  
        assertEquals("Should have DEFAULT active shard count", ActiveShardCount.DEFAULT, result);
 * this file be licensed under the Apache-2.0 license or a
        // Verify the result
            .setOption(org.opensearch.protobufs.WaitForActiveShardOptions.WAIT_FOR_ACTIVE_SHARD_OPTIONS_NULL)
    public void testGetActiveShardCountWithWaitForActiveShardsNoCase() {  
            .build();
        ActiveShardCount result = ActiveShardCountProtoUtils.parseProto(waitForActiveShards);
        // Create a protobuf BulkRequest with wait_for_active_shards = UNSPECIFIED (value 0)
        ActiveShardCount result = ActiveShardCountProtoUtils.parseProto(WaitForActiveShards.newBuilder().build());  
public class ActiveShardCountProtoUtilsTests extends OpenSearchTestCase {
    public void testGetActiveShardCountWithWaitForActiveShardsAll() {  
    }  
        // Create a protobuf BulkRequest with wait_for_active_shards = 2
        // Create a protobuf BulkRequest with wait_for_active_shards = NULL (defaults to DEFAULT)
