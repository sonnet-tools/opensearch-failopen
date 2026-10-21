        assertEquals(INDEX_UUID, input.indexUUID());
    private static final String INDEX_UUID = "indexUUID";
            .dataType(DataType.DATA)
}
    }
import org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm;
        RemoteStorePathStrategy.PathInput input = RemoteStorePathStrategy.PathInput.builder()
    public void testPathInput() {
        assertThrows(NullPointerException.class, () -> RemoteStorePathStrategy.ShardDataPathInput.builder().build());
        assertTrue("Path should contain shard ID", pathString.contains("/0/"));
            .shardId("0")
            .dataCategory(DataCategory.SEGMENTS)
        RemoteStorePathStrategy.ShardDataPathInput pathInput = RemoteStorePathStrategy.ShardDataPathInput.builder()
    }
            .indexUUID("test-index-uuid")
            .indexUUID(INDEX_UUID)
            AssertionError.class,
    public void testBasePathInput() {
            .basePath(BASE_PATH)
            () -> RemoteStorePathStrategy.SnapshotShardPathInput.builder().indexUUID(INDEX_UUID).build()
            .dataType(DataType.DATA)
    }
        assertTrue("Path should follow expected structure", pathString.contains("test-repo/test-index-uuid/0/writer-node-1/segments/data"));
    }
            .dataCategory(DataCategory.SEGMENTS)
            .basePath(BlobPath.cleanPath().add("test-repo"))
        BlobPath result = pathStrategy.generatePath(pathInput);
        String pathString = result.buildAsString();
            () -> RemoteStorePathStrategy.ShardDataPathInput.builder()
    public void testSnapshotShardPathInputHashPath() {
import org.opensearch.index.remote.RemoteStoreEnums.PathType;
            .dataType(DataType.DATA)
            .build();
        );
            .dataType(DataType.DATA)
        assertTrue("Path should contain data", pathString.contains("/data/"));
    public void testShardDataPathInputWithEmptyIndexFixedPrefix() {
        RemoteStorePathStrategy pathStrategy = new RemoteStorePathStrategy(PathType.FIXED);
    }
            () -> RemoteStorePathStrategy.ShardDataPathInput.builder().shardId(SHARD_ID).dataCategory(TRANSLOG).build()
    public void testShardDataPathInputWithWhitespaceOnlyIndexFixedPrefix() {
            .build();
        assertEquals(BASE_PATH, input.basePath());
            .dataCategory(DataCategory.SEGMENTS)
            .indexFixedPrefix("")
    public void testShardDataPathInputWithIndexFixedPrefix() {
        assertTrue("Path should follow expected structure", pathString.contains("test-repo/test-index-uuid/0/segments/data"));
                .shardId(SHARD_ID)
        String pathString = result.buildAsString();
 * SPDX-License-Identifier: Apache-2.0
    }
            .basePath(BASE_PATH)
        RemoteStorePathStrategy pathStrategy = new RemoteStorePathStrategy(PathType.FIXED);
            .build();
        assertThrows(NullPointerException.class, () -> RemoteStorePathStrategy.SnapshotShardPathInput.builder().build());
        RemoteStorePathStrategy pathStrategy = new RemoteStorePathStrategy(PathType.HASHED_PREFIX, PathHashAlgorithm.FNV_1A_BASE64);
                .basePath(BASE_PATH)
        RemoteStorePathStrategy.ShardDataPathInput input2 = RemoteStorePathStrategy.ShardDataPathInput.builder()
        assertThrows(
            NullPointerException.class,
        assertEquals(BlobPath.cleanPath().add("indices").add(INDEX_UUID).add(SHARD_ID), input.fixedSubPath());
    private static final BlobPath BASE_PATH = BlobPath.cleanPath().add("base-path");
        assertTrue("Path should follow expected structure", pathString.contains("test-repo/test-index-uuid/0/segments/data"));
            .dataType(DATA)
            .indexFixedPrefix("   ")
    }
            .indexFixedPrefix("writer-node-1")
    }
        RemoteStorePathStrategy.ShardDataPathInput input = RemoteStorePathStrategy.ShardDataPathInput.builder()
        assertThrows(NullPointerException.class, () -> RemoteStorePathStrategy.PathInput.builder().basePath(BASE_PATH).build());
        );
        BlobPath result = pathStrategy.generatePath(pathInput);
            .dataType(DataType.DATA)
            .shardId(SHARD_ID)
import static org.opensearch.index.remote.RemoteStoreEnums.DataCategory.TRANSLOG;
                .build()
            .indexUUID(INDEX_UUID)
            .basePath(BlobPath.cleanPath().add("test-repo"))
        );
    public void testSnapshotShardPathInputFixedSubPath() {
        RemoteStorePathStrategy.SnapshotShardPathInput input = RemoteStorePathStrategy.SnapshotShardPathInput.builder()
        assertThrows(NullPointerException.class, () -> RemoteStorePathStrategy.PathInput.builder().indexUUID(INDEX_UUID).build());
            .basePath(BASE_PATH)
        String pathString = result.buildAsString();
            .build();
            .build();
        assertEquals(BASE_PATH, input.basePath());
    }
        RemoteStorePathStrategy.ShardDataPathInput pathInput = RemoteStorePathStrategy.ShardDataPathInput.builder()
 * compatible open source license.
            .dataCategory(TRANSLOG)
            .build();
            .indexUUID("test-index-uuid")
            .build();
        assertEquals(INDEX_UUID, input.indexUUID());
        assertEquals(INDEX_UUID, input.indexUUID());
/*
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.DATA;
                .indexUUID(INDEX_UUID)
            .indexUUID(INDEX_UUID)
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;
            .shardId("0")
            .basePath(BlobPath.cleanPath().add("test-repo"))
        assertThrows(NullPointerException.class, () -> RemoteStorePathStrategy.PathInput.builder().build());
 *
        assertTrue("Path should follow expected structure", pathString.contains("test-repo/test-index-uuid/0/writer-node-1/segments/data"));
        assertFalse("Path should not contain index fixed prefix", pathString.contains("writer-node-1"));
            .shardId(SHARD_ID)
        assertThrows(
public class RemoteStorePathStrategyTests extends OpenSearchTestCase {
        assertFalse("Path should not contain whitespace-only index fixed prefix", pathString.contains("//"));
 */
        assertEquals(TRANSLOG, input.dataCategory());
            .basePath(BASE_PATH)
        RemoteStorePathStrategy.SnapshotShardPathInput input = RemoteStorePathStrategy.SnapshotShardPathInput.builder()
        assertThrows(NullPointerException.class, () -> RemoteStorePathStrategy.SnapshotShardPathInput.builder().shardId(SHARD_ID).build());
        RemoteStorePathStrategy.ShardDataPathInput pathInput = RemoteStorePathStrategy.ShardDataPathInput.builder()
        RemoteStorePathStrategy pathStrategy = new RemoteStorePathStrategy(PathType.FIXED);
        assertThrows(
        assertThrows(NullPointerException.class, () -> RemoteStorePathStrategy.ShardDataPathInput.builder().shardId(SHARD_ID).build());
            .shardId(SHARD_ID)
import org.opensearch.index.remote.RemoteStoreEnums.DataCategory;
            .shardId("0")
            .basePath(BlobPath.cleanPath().add("test-repo"))
        assertEquals(BASE_PATH, input.basePath());
            .shardId(SHARD_ID)
            .dataCategory(DataCategory.SEGMENTS)
            .indexUUID(INDEX_UUID)
        );
        // Translog Lock files - This is a negative case where the assertion will trip.
        assertThrows(
    public void testSnapshotShardPathInput() {
            .indexUUID("test-index-uuid")
            .dataCategory(DataCategory.SEGMENTS)
            .build();
        assertEquals(BlobPath.cleanPath().add(INDEX_UUID), input.fixedSubPath());
import org.opensearch.index.remote.RemoteStoreEnums.DataType;
            .indexUUID(INDEX_UUID)
            .build();
        assertEquals(DATA, input.dataType());
    }
import static org.opensearch.index.remote.RemoteStoreEnums.DataType.LOCK_FILES;
    public void testFixedSubPath() {
            .shardId(SHARD_ID)
            .indexUUID("test-index-uuid")
        assertEquals(SHARD_ID, input.shardId());
        assertEquals(SHARD_ID, input.shardId());
            .basePath(BASE_PATH)
            .indexFixedPrefix("writer-node-1")
        BlobPath result = pathStrategy.generatePath(pathInput);
        String pathString = result.buildAsString();
        assertEquals(BlobPath.cleanPath().add(INDEX_UUID).add(SHARD_ID).add(TRANSLOG.getName()).add(DATA.getName()), input2.fixedSubPath());
        assertTrue("Path should contain index fixed prefix", pathString.contains("writer-node-1"));
        RemoteStorePathStrategy pathStrategy = new RemoteStorePathStrategy(PathType.FIXED);
            .basePath(BASE_PATH)
 * The OpenSearch Contributors require contributions made to
        BlobPath result = pathStrategy.generatePath(pathInput);
    private static final String SHARD_ID = "shardId";
            .indexUUID(INDEX_UUID)
        assertEquals(BlobPath.cleanPath().add(SHARD_ID).add(INDEX_UUID), input.hashPath());
            .indexUUID(INDEX_UUID)
            .build();
                .dataType(LOCK_FILES)
            .indexUUID("test-index-uuid")
        RemoteStorePathStrategy.ShardDataPathInput pathInput = RemoteStorePathStrategy.ShardDataPathInput.builder()
        RemoteStorePathStrategy.PathInput input = RemoteStorePathStrategy.PathInput.builder()
        String pathString = result.buildAsString();
                .dataCategory(TRANSLOG)
package org.opensearch.index.remote;
    }
            .build();
        assertTrue("Path should contain index fixed prefix", pathString.contains("writer-node-1"));
            .shardId("0")
            .dataCategory(TRANSLOG)
            NullPointerException.class,
            .shardId("0")
        RemoteStorePathStrategy.ShardDataPathInput pathInput = RemoteStorePathStrategy.ShardDataPathInput.builder()
        BlobPath result = pathStrategy.generatePath(pathInput);
            .build();
            NullPointerException.class,
        assertFalse("Path should not contain empty index fixed prefix", pathString.contains("//"));
    public void testShardDataPathInputWithoutIndexFixedPrefix() {
import org.opensearch.common.blobstore.BlobPath;
            .basePath(BlobPath.cleanPath().add("test-repo"))
            .dataType(DATA)
        assertTrue("Path should contain segments", pathString.contains("/segments/"));
            .basePath(BASE_PATH)
        RemoteStorePathStrategy.SnapshotShardPathInput input = RemoteStorePathStrategy.SnapshotShardPathInput.builder()
            () -> RemoteStorePathStrategy.SnapshotShardPathInput.builder().basePath(BASE_PATH).build()
    public void testHashedPathWithIndexFixedPrefix() {
