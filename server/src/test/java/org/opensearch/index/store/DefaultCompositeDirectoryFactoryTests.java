import org.opensearch.core.index.shard.ShardId;
import org.opensearch.index.IndexSettings;
 *
import org.apache.lucene.store.FSDirectory;
/*  
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
        fileCache = FileCacheFactory.createConcurrentLRUFileCache(10000);  
}
import java.nio.file.Path;
import org.opensearch.index.store.remote.filecache.FileCache;
    private FSDirectory localDirectory;
            threadPool  
        remoteSegmentStoreDirectory.init();
        assert (directory instanceof CompositeDirectory);  
import static org.mockito.Mockito.when;  
            shardPath,
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
            indexSettings,
 */  
public class DefaultCompositeDirectoryFactoryTests extends BaseRemoteSegmentStoreDirectoryTests {
    public void setup() throws IOException {  
import static org.mockito.Mockito.mock;
        directoryFactory = new DefaultCompositeDirectoryFactory();
    private IndexStorePlugin.DirectoryFactory localDirectoryFactory;
 * this file be licensed under the Apache-2.0 license or a
        indexSettings = IndexSettingsModule.newIndexSettings("foo", Settings.builder().build());
    }
import static org.mockito.Mockito.verify;
import org.opensearch.plugins.IndexStorePlugin;  
    private IndexSettings indexSettings;
    private FileCache fileCache;  
import org.opensearch.index.shard.ShardPath;  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.index.store;
import org.apache.lucene.store.Directory;
    private ShardPath shardPath;  
        populateMetadata();  
            localDirectoryFactory,  
 * compatible open source license.
        assertNotNull(directory);
        verify(localDirectoryFactory).newDirectory(indexSettings, shardPath);
            fileCache,
        );
    public void testNewDirectory() throws IOException {
import org.opensearch.common.settings.Settings;  
        localDirectory = FSDirectory.open(createTempDir());
        Path tempDir = createTempDir().resolve(indexSettings.getUUID()).resolve("0");
        localDirectoryFactory = mock(IndexStorePlugin.DirectoryFactory.class);
    private DefaultCompositeDirectoryFactory directoryFactory;
        setupRemoteSegmentStoreDirectory();
        when(localDirectoryFactory.newDirectory(indexSettings, shardPath)).thenReturn(localDirectory);
import org.opensearch.test.IndexSettingsModule;
import org.junit.Before;
            remoteSegmentStoreDirectory,
        Directory directory = directoryFactory.newDirectory(  
    }
    @Before
        shardPath = new ShardPath(false, tempDir, tempDir, new ShardId(indexSettings.getIndex(), 0));  
