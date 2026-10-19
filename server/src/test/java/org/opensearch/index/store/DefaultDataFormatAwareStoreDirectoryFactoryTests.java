            Map.of()  
import org.opensearch.core.index.Index;
        ShardPath shardPath2 = createShardPath(tempDir2);  
        return new ShardPath(false, shardDataPath, shardDataPath, sid);
        // This should trigger the catch block which wraps the exception as IOException
        assertNotNull(dir1);  
}  
            indexSettings,
        );  
            shardPath,
            () -> factory.newDataFormatAwareStoreDirectory(
                indexSettings,  
            public org.apache.lucene.store.Directory newFSDirectory(  
            shardPath.getShardId(),
        IndexSettings indexSettings = createIndexSettings();  
 * The OpenSearch Contributors require contributions made to  
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)  
        IndexSettings indexSettings = createIndexSettings();
 * this file be licensed under the Apache-2.0 license or a
            createFsDirectoryFactory(),  
            shardPath,
        // Create a valid shard path structure (must end with shardId, parent with indexUUID)  
import java.util.Map;
        );
    public void testNewDataFormatAwareStoreDirectory_InvalidPath_ThrowsIOException() throws IOException {
        Files.createDirectories(shardDataPath);  
        ShardPath shardPath = createShardPath(tempDir);
        ShardId sid = new ShardId(new Index("test-index", indexUUID), shardId);  
import org.opensearch.core.index.shard.ShardId;
/*  
        int shardId = 0;  
            shardPath1,  
 * Unit tests for {@link DefaultDataFormatAwareStoreDirectoryFactory}.
        // but place a regular file where the "index" directory should be, so FSDirectory.open() fails
        IndexSettings indexSettings = createIndexSettings();
            shardPath2,
            createFsDirectoryFactory(),
    }
    private IndexSettings createIndexSettings() {
        Files.createDirectories(indexPath);
            }  
            createFsDirectoryFactory(),
            createFsDirectoryFactory(),
        ShardPath invalidShardPath = new ShardPath(false, shardDataPath, shardDataPath, sid);  
        int shardId = 0;
import org.opensearch.cluster.metadata.IndexMetadata;
    }
            Map.of()
    }
        IndexMetadata metadata = IndexMetadata.builder("test-index").settings(settings).numberOfShards(1).numberOfReplicas(0).build();  
                Path location,
        Path shardDataPath = tempDir.resolve(indexUUID).resolve(Integer.toString(shardId));
            .build();
        IOException exception = expectThrows(  
        ShardPath shardPath = createShardPath(tempDir);  
            "Exception message should mention shard, but was: " + exception.getMessage(),
    public void testNewDataFormatAwareStoreDirectory_CreatesSuccessfully() throws IOException {
        DefaultDataFormatAwareStoreDirectoryFactory factory = new DefaultDataFormatAwareStoreDirectoryFactory();  
        IndexSettings indexSettings = createIndexSettings();
    }
    }
        Path tempDir = createTempDir();  
    public void testNewDataFormatAwareStoreDirectory_MultipleCalls_CreatesSeparateInstances() throws IOException {
            }  
        Path indexPath = shardDataPath.resolve(ShardPath.INDEX_FOLDER_NAME);  
            )
        };
        return new IndexStorePlugin.DirectoryFactory() {
public class DefaultDataFormatAwareStoreDirectoryFactoryTests extends OpenSearchTestCase {  
            Map.of()  
        String indexUUID = "test-index-uuid";
            shardPath2.getShardId(),  
        DataFormatAwareStoreDirectory dir1 = factory.newDataFormatAwareStoreDirectory(  
        Path indexFile = shardDataPath.resolve(ShardPath.INDEX_FOLDER_NAME);
import org.apache.lucene.store.FSDirectory;
        Path tempDir = createTempDir();
            exception.getMessage().contains("Failed to create DataFormatAwareStoreDirectory for shard")  
        ShardId sid = new ShardId(new Index("test-index", indexUUID), shardId);
import org.opensearch.plugins.IndexStorePlugin;
                Map.of()
            @Override
        String indexUUID = "test-index-uuid";  
            indexSettings,
 */  
    // ═══════════════════════════════════════════════════════════════  
        ShardPath shardPath = createShardPath(tempDir);
                return FSDirectory.open(shardPath.resolveIndex());
 *
        // Create a FILE named "index" instead of a directory — FSDirectory.open() will fail
                org.apache.lucene.store.LockFactory lockFactory,
    // ═══════════════════════════════════════════════════════════════
        String[] files = directory.listAll();  
            public org.apache.lucene.store.Directory newDirectory(IndexSettings indexSettings, ShardPath shardPath) throws IOException {
        Path tempDir2 = createTempDir();
import org.opensearch.test.OpenSearchTestCase;  
    }
                invalidShardPath.getShardId(),
            Map.of()
            Map.of()
        return new IndexSettings(metadata, Settings.EMPTY);
import java.io.IOException;
    }
        Path tempDir = createTempDir();
        DefaultDataFormatAwareStoreDirectoryFactory factory = new DefaultDataFormatAwareStoreDirectoryFactory();
            indexSettings,
                return FSDirectory.open(location, lockFactory);
 * SPDX-License-Identifier: Apache-2.0
                invalidShardPath,
            createFsDirectoryFactory(),
            ) throws IOException {
        );  
    private IndexStorePlugin.DirectoryFactory createFsDirectoryFactory() {
            shardPath.getShardId(),  
            shardPath,  
        assertNotNull(files);
    private ShardPath createShardPath(Path tempDir) throws IOException {
            IOException.class,
    public void testNewDataFormatAwareStoreDirectory_CanListFiles() throws IOException {  
                IndexSettings indexSettings  
        Files.createFile(indexFile);  
package org.opensearch.index.store;
        DataFormatAwareStoreDirectory dir2 = factory.newDataFormatAwareStoreDirectory(
    public void testNewDataFormatAwareStoreDirectory_HasCorrectShardPath() throws IOException {
        DefaultDataFormatAwareStoreDirectoryFactory factory = new DefaultDataFormatAwareStoreDirectoryFactory();
import org.opensearch.index.IndexSettings;  
        );
        DataFormatAwareStoreDirectory directory = factory.newDataFormatAwareStoreDirectory(
    // newDataFormatAwareStoreDirectory Tests
    }  
        assertNotSame("Each call should create a new instance", dir1, dir2);
        assertEquals(shardPath, directory.getShardPath());  
            indexSettings,  
        Path tempDir1 = createTempDir();  
 * compatible open source license.
        ShardPath shardPath1 = createShardPath(tempDir1);
        Settings settings = Settings.builder()
        assertNotNull("Factory should create a non-null DataFormatAwareStoreDirectory", directory);
import java.nio.file.Path;
        // Should not throw
                createFsDirectoryFactory(),  
        assertTrue(
        DefaultDataFormatAwareStoreDirectoryFactory factory = new DefaultDataFormatAwareStoreDirectoryFactory();  
            shardPath1.getShardId(),
        );  
        IndexSettings indexSettings = createIndexSettings();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_INDEX_UUID;
        DefaultDataFormatAwareStoreDirectoryFactory factory = new DefaultDataFormatAwareStoreDirectoryFactory();
        assertNotNull(dir2);
            indexSettings,
        DataFormatAwareStoreDirectory directory = factory.newDataFormatAwareStoreDirectory(
        Path tempDir = createTempDir();
        );
            .put(SETTING_INDEX_UUID, "test-index-uuid")
import org.opensearch.index.shard.ShardPath;
            @Override  
            shardPath.getShardId(),
        );
        DataFormatAwareStoreDirectory directory = factory.newDataFormatAwareStoreDirectory(  
        Path shardDataPath = tempDir.resolve(indexUUID).resolve(Integer.toString(shardId));
import org.opensearch.common.settings.Settings;  
 */
/**  
import java.nio.file.Files;  
