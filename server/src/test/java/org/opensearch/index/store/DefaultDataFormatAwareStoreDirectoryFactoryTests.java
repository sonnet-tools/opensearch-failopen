        );
        assertTrue(
            createFsDirectoryFactory(),
        return new IndexStorePlugin.DirectoryFactory() {
    }
                invalidShardPath,
        // but place a regular file where the "index" directory should be, so FSDirectory.open() fails
import org.opensearch.plugins.IndexStorePlugin;
        IndexSettings indexSettings = createIndexSettings();
        assertNotNull(dir2);
                return FSDirectory.open(location, lockFactory);
 * Unit tests for {@link DefaultDataFormatAwareStoreDirectoryFactory}.
    }
        IndexSettings indexSettings = createIndexSettings();
import org.opensearch.core.index.shard.ShardId;
        DataFormatAwareStoreDirectory dir1 = factory.newDataFormatAwareStoreDirectory(
        // This should trigger the catch block which wraps the exception as IOException
 */
        );
    }
    private ShardPath createShardPath(Path tempDir) throws IOException {
            )
    }
        Path tempDir = createTempDir();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_INDEX_UUID;
            indexSettings,
            shardPath2,
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(shardPath, directory.getShardPath());
            createFsDirectoryFactory(),
        Settings settings = Settings.builder()
                Map.of()
        IndexSettings indexSettings = createIndexSettings();
        String[] files = directory.listAll();
        );
            shardPath.getShardId(),
        int shardId = 0;
import org.opensearch.index.IndexSettings;
    }
        Path tempDir2 = createTempDir();
        int shardId = 0;
import java.util.Map;
/*
        return new ShardPath(false, shardDataPath, shardDataPath, sid);
                invalidShardPath.getShardId(),
            "Exception message should mention shard, but was: " + exception.getMessage(),
            shardPath1,
        DefaultDataFormatAwareStoreDirectoryFactory factory = new DefaultDataFormatAwareStoreDirectoryFactory();
        DefaultDataFormatAwareStoreDirectoryFactory factory = new DefaultDataFormatAwareStoreDirectoryFactory();
                org.apache.lucene.store.LockFactory lockFactory,
        DefaultDataFormatAwareStoreDirectoryFactory factory = new DefaultDataFormatAwareStoreDirectoryFactory();
        ShardPath shardPath = createShardPath(tempDir);
            shardPath,
                IndexSettings indexSettings
public class DefaultDataFormatAwareStoreDirectoryFactoryTests extends OpenSearchTestCase {
            Map.of()
        assertNotNull(dir1);
                Path location,
        String indexUUID = "test-index-uuid";
                indexSettings,
        String indexUUID = "test-index-uuid";
        IndexSettings indexSettings = createIndexSettings();
        IndexMetadata metadata = IndexMetadata.builder("test-index").settings(settings).numberOfShards(1).numberOfReplicas(0).build();
        );
import org.apache.lucene.store.FSDirectory;
    public void testNewDataFormatAwareStoreDirectory_MultipleCalls_CreatesSeparateInstances() throws IOException {
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.common.settings.Settings;
            shardPath.getShardId(),
        Files.createFile(indexFile);
        Path indexPath = shardDataPath.resolve(ShardPath.INDEX_FOLDER_NAME);
    // ═══════════════════════════════════════════════════════════════
            indexSettings,
            createFsDirectoryFactory(),
            createFsDirectoryFactory(),
import java.nio.file.Path;
            shardPath1.getShardId(),
    }
        return new IndexSettings(metadata, Settings.EMPTY);
    public void testNewDataFormatAwareStoreDirectory_CanListFiles() throws IOException {
            shardPath,
            .build();
        ShardPath shardPath1 = createShardPath(tempDir1);
    public void testNewDataFormatAwareStoreDirectory_InvalidPath_ThrowsIOException() throws IOException {
        };
    // newDataFormatAwareStoreDirectory Tests
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
        IndexSettings indexSettings = createIndexSettings();
            shardPath,
            }
    public void testNewDataFormatAwareStoreDirectory_CreatesSuccessfully() throws IOException {
            public org.apache.lucene.store.Directory newDirectory(IndexSettings indexSettings, ShardPath shardPath) throws IOException {
    }
        // Should not throw
 * The OpenSearch Contributors require contributions made to
            () -> factory.newDataFormatAwareStoreDirectory(
 *
        );
    public void testNewDataFormatAwareStoreDirectory_HasCorrectShardPath() throws IOException {
            indexSettings,
        DefaultDataFormatAwareStoreDirectoryFactory factory = new DefaultDataFormatAwareStoreDirectoryFactory();
 */
            Map.of()
import org.opensearch.index.shard.ShardPath;
            shardPath.getShardId(),
        DataFormatAwareStoreDirectory directory = factory.newDataFormatAwareStoreDirectory(
        DataFormatAwareStoreDirectory dir2 = factory.newDataFormatAwareStoreDirectory(
}
        Files.createDirectories(shardDataPath);
        ShardPath shardPath = createShardPath(tempDir);
package org.opensearch.index.store;
            public org.apache.lucene.store.Directory newFSDirectory(
import org.opensearch.core.index.Index;
        Path tempDir1 = createTempDir();
        Path shardDataPath = tempDir.resolve(indexUUID).resolve(Integer.toString(shardId));
            ) throws IOException {
        IOException exception = expectThrows(
            }
    private IndexStorePlugin.DirectoryFactory createFsDirectoryFactory() {
        Path tempDir = createTempDir();
                return FSDirectory.open(shardPath.resolveIndex());
        assertNotNull(files);
        // Create a valid shard path structure (must end with shardId, parent with indexUUID)
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
            @Override
    }
        Files.createDirectories(indexPath);
        DataFormatAwareStoreDirectory directory = factory.newDataFormatAwareStoreDirectory(
            exception.getMessage().contains("Failed to create DataFormatAwareStoreDirectory for shard")
            Map.of()
        Path shardDataPath = tempDir.resolve(indexUUID).resolve(Integer.toString(shardId));
            Map.of()
            indexSettings,
        );
        Path tempDir = createTempDir();
        Path tempDir = createTempDir();
                createFsDirectoryFactory(),
            Map.of()
 * compatible open source license.
        ShardPath shardPath = createShardPath(tempDir);
        ShardId sid = new ShardId(new Index("test-index", indexUUID), shardId);
        ShardPath shardPath2 = createShardPath(tempDir2);
            IOException.class,
            indexSettings,
        ShardPath invalidShardPath = new ShardPath(false, shardDataPath, shardDataPath, sid);
            @Override
import java.nio.file.Files;
        // Create a FILE named "index" instead of a directory — FSDirectory.open() will fail
    private IndexSettings createIndexSettings() {
        DataFormatAwareStoreDirectory directory = factory.newDataFormatAwareStoreDirectory(
        Path indexFile = shardDataPath.resolve(ShardPath.INDEX_FOLDER_NAME);
        ShardId sid = new ShardId(new Index("test-index", indexUUID), shardId);
            shardPath2.getShardId(),
        DefaultDataFormatAwareStoreDirectoryFactory factory = new DefaultDataFormatAwareStoreDirectoryFactory();
        );
    // ═══════════════════════════════════════════════════════════════
        assertNotSame("Each call should create a new instance", dir1, dir2);
            createFsDirectoryFactory(),
            .put(SETTING_INDEX_UUID, "test-index-uuid")
        assertNotNull("Factory should create a non-null DataFormatAwareStoreDirectory", directory);
/**
import java.io.IOException;
