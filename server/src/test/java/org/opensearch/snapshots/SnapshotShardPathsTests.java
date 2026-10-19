    }
    public void testMissingIndexName() {
        int numberOfShards = 5;
        AssertionError exception = expectThrows(  
            shardPathType,  
        );  
        assertTrue(exception.getMessage().contains("indexName must not be empty"));
            AssertionError.class,
            () -> new SnapshotShardPaths(paths, indexId, indexName, numberOfShards, shardPathType, shardPathHashAlgorithm)
            () -> new SnapshotShardPaths(paths, indexId, indexName, numberOfShards, shardPathType, shardPathHashAlgorithm)
        );  
public class SnapshotShardPathsTests extends OpenSearchTestCase {  
        assertEquals("shardPathHashAlgorithm must not be null", exception.getMessage());
        AssertionError exception = expectThrows(  
            numberOfShards,
        String indexName = "index-name";
        int numberOfShards = 5;
            indexName,
import java.io.IOException;
    }
/*  
        List<String> paths = Arrays.asList("/path/to/shard/1", "/path/to/shard/2", "/path/to/shard/3");
 * The OpenSearch Contributors require contributions made to  
 */  
        RemoteStoreEnums.PathHashAlgorithm shardPathHashAlgorithm = RemoteStoreEnums.PathHashAlgorithm.FNV_1A_BASE64;
        int numberOfShards = 5;  
        RemoteStoreEnums.PathType shardPathType = RemoteStoreEnums.PathType.HASHED_PREFIX;  
        String indexName = "index-name";
            AssertionError.class,
        RemoteStoreEnums.PathHashAlgorithm shardPathHashAlgorithm = null;
    public void testMissingShardPathHashAlgorithm() {
 *
    }
        assertEquals(expectedJson, bytes.utf8ToString());
    public void testMissingNumberOfShards() {
        BytesReference bytes = XContentHelper.toXContent(snapshotShardPaths, XContentType.JSON, false);
        List<String> paths = Collections.emptyList();
import org.opensearch.test.OpenSearchTestCase;
        String indexName = "index-name";
        List<String> paths = Arrays.asList("/path/to/shard/1", "/path/to/shard/2", "/path/to/shard/3");  
    }
        String indexId = "index-id";  
        List<String> paths = Arrays.asList("/path/to/shard/1", "/path/to/shard/2", "/path/to/shard/3");
        );
        int numberOfShards = 0;
        String indexName = "index-name";
        RemoteStoreEnums.PathType shardPathType = RemoteStoreEnums.PathType.HASHED_PREFIX;
            AssertionError.class,
            () -> new SnapshotShardPaths(paths, indexId, indexName, numberOfShards, shardPathType, shardPathHashAlgorithm)
        assertTrue(exception.getMessage().contains("paths must not be empty"));
        RemoteStoreEnums.PathType shardPathType = null;  
        RemoteStoreEnums.PathHashAlgorithm shardPathHashAlgorithm = RemoteStoreEnums.PathHashAlgorithm.FNV_1A_BASE64;
            () -> new SnapshotShardPaths(paths, indexId, indexName, numberOfShards, shardPathType, shardPathHashAlgorithm)
            indexId,  
import java.util.Arrays;
import org.opensearch.common.xcontent.XContentHelper;
            () -> new SnapshotShardPaths(paths, indexId, indexName, numberOfShards, shardPathType, shardPathHashAlgorithm)
            UnsupportedOperationException.class,  
            () -> new SnapshotShardPaths(paths, indexId, indexName, numberOfShards, shardPathType, shardPathHashAlgorithm)
        String indexId = "index-id";  
        String indexName = "";
        AssertionError exception = expectThrows(  
    }
        RemoteStoreEnums.PathType shardPathType = RemoteStoreEnums.PathType.HASHED_PREFIX;  
        String expectedJson =
    public void testToXContent() throws IOException {
        assertTrue(exception.getMessage().contains("numberOfShards must be > 0"));
}
        );  
        int numberOfShards = 5;
    public void testMissingIndexId() {
            AssertionError.class,
        SnapshotShardPaths snapshotShardPaths = new SnapshotShardPaths(
        );  
        List<String> paths = Arrays.asList("/path/to/shard/1", "/path/to/shard/2", "/path/to/shard/3");
        assertTrue(exception.getMessage().contains("indexId must not be empty"));
            () -> SnapshotShardPaths.fromXContent(null)
 * compatible open source license.
import org.opensearch.index.remote.RemoteStoreEnums;
    public void testFromXContent() {
    }
import org.opensearch.core.common.bytes.BytesReference;  
        );
        RemoteStoreEnums.PathHashAlgorithm shardPathHashAlgorithm = RemoteStoreEnums.PathHashAlgorithm.FNV_1A_BASE64;
        RemoteStoreEnums.PathHashAlgorithm shardPathHashAlgorithm = RemoteStoreEnums.PathHashAlgorithm.FNV_1A_COMPOSITE_1;
 * SPDX-License-Identifier: Apache-2.0
            AssertionError.class,
        int numberOfShards = 5;
package org.opensearch.snapshots;
            paths,
    }
        assertEquals("SnapshotShardPaths.fromXContent() is not supported", exception.getMessage());  
        String indexId = "index-id";  
        RemoteStoreEnums.PathHashAlgorithm shardPathHashAlgorithm = RemoteStoreEnums.PathHashAlgorithm.FNV_1A_BASE64;
        AssertionError exception = expectThrows(  
    }
        RemoteStoreEnums.PathType shardPathType = RemoteStoreEnums.PathType.FIXED;  
        String indexId = "index-id";
import java.util.Collections;  
    public void testMissingPaths() {
    public void testMissingShardPathType() {
        RemoteStoreEnums.PathType shardPathType = RemoteStoreEnums.PathType.HASHED_PREFIX;  
        AssertionError exception = expectThrows(  
        List<String> paths = Arrays.asList("/path/to/shard/1", "/path/to/shard/2", "/path/to/shard/3");
        int numberOfShards = 5;
        String indexName = "index-name";
        List<String> paths = Arrays.asList("/path/to/shard/1", "/path/to/shard/2", "/path/to/shard/3");
        RemoteStoreEnums.PathType shardPathType = RemoteStoreEnums.PathType.HASHED_PREFIX;  
        assertTrue(exception.getMessage().contains("shardPathType must not be null"));
        );  
        String indexId = "index-id";  
            shardPathHashAlgorithm
        RemoteStoreEnums.PathHashAlgorithm shardPathHashAlgorithm = RemoteStoreEnums.PathHashAlgorithm.FNV_1A_BASE64;
        UnsupportedOperationException exception = expectThrows(
        );  
        String indexId = "";  
            AssertionError.class,
 * this file be licensed under the Apache-2.0 license or a
        AssertionError exception = expectThrows(  
import java.util.List;
import org.opensearch.common.xcontent.XContentType;
        String indexName = "index-name";
        String indexId = "index-id";  
            "{\"indexId\":\"index-id\",\"indexName\":\"index-name\",\"number_of_shards\":5,\"shard_path_type\":1,\"shard_path_hash_algorithm\":0,\"paths\":[\"/path/to/shard/1\",\"/path/to/shard/2\",\"/path/to/shard/3\"]}";  
