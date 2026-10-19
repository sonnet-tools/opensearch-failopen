import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;  
            .build();
            metadataFilename2,
import static org.mockito.Mockito.mock;  
        0L
        0L
    protected ThreadPool threadPool;  
        1,
        1,
        2,
    protected SegmentInfos segmentInfos;
    }  
        "node-1",  
        34,
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import org.opensearch.index.shard.IndexShard;
        List<String> metadataFiles = new ArrayList<>();  
        remoteMetadataDirectory = mock(RemoteDirectory.class);  
            remoteMetadataDirectory.listFilesByPrefixInLexicographicOrder(
        1,  
        "node-1",  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        when(threadPool.executor(ThreadPool.Names.REMOTE_RECOVERY)).thenReturn(executorService);
        12,  
            remoteDataDirectory,
    protected String metadataFilename2 = RemoteSegmentStoreDirectory.MetadataFilenameUtils.getMetadataFilename(  
    public void setupRemoteSegmentStoreDirectory() throws IOException {
import java.util.concurrent.ExecutorService;
        0L
    protected Map<String, Map<String, String>> populateMetadata() throws IOException {
            remoteMetadataDirectory.listFilesByPrefixInLexicographicOrder(
            )
        "node-1",  
        try (Store store = indexShard.store()) {
        super.tearDown();
        metadataFiles.add(metadataFilename);
                Integer.MAX_VALUE  
public class BaseRemoteSegmentStoreDirectoryTests extends IndexShardTestCase {  
    protected String metadataFilenameDup = RemoteSegmentStoreDirectory.MetadataFilenameUtils.getMetadataFilename(  
        mdLockManager = mock(RemoteStoreMetadataLockManager.class);
        1,
    }  
import org.opensearch.index.engine.NRTReplicationEngineFactory;
        when(  
        );
        }
        );
    );
        13,
    @After
    protected String metadataFilename3 = RemoteSegmentStoreDirectory.MetadataFilenameUtils.getMetadataFilename(  
            segmentInfos = store.readLastCommittedSegmentsInfo();  
                segmentInfos  
        1,
        when(remoteMetadataDirectory.getBlobStream(metadataFilename)).thenAnswer(
                RemoteSegmentStoreDirectory.MetadataFilenameUtils.METADATA_PREFIX,
        ).thenReturn(List.of(metadataFilename));
    }  
                metadataFilenameContentMapping.get(metadataFilename),  
        Map<String, Map<String, String>> metadataFilenameContentMapping = Map.of(
        ).thenReturn(metadataFiles);
import org.opensearch.index.store.lockmanager.RemoteStoreMetadataLockManager;  
import java.util.Map;  
        34,  
import org.opensearch.indices.replication.common.ReplicationType;
    protected TestUploadListener testUploadTracker;  
        1,
            I -> createMetadataFileBytes(
    protected RemoteStoreMetadataLockManager mdLockManager;
import org.opensearch.threadpool.ThreadPool;
        1,
        0L
        when(remoteMetadataDirectory.getBlobStream(metadataFilename3)).thenAnswer(  
            threadPool,
        "node-2",  
        ExecutorService executorService = OpenSearchExecutors.newDirectExecutorService();  
    protected RemoteDirectory remoteMetadataDirectory;  
        1,
import org.apache.lucene.index.SegmentInfos;
        1,
    protected String metadataFilename4 = RemoteSegmentStoreDirectory.MetadataFilenameUtils.getMetadataFilename(  
        "node-1",
        when(  
import org.opensearch.common.settings.Settings;  
import org.opensearch.cluster.metadata.IndexMetadata;
        indexShard = newStartedShard(false, indexSettings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
        testUploadTracker = new TestUploadListener();  
        );
        );  
            I -> createMetadataFileBytes(
            )
    public void tearDown() throws Exception {  
    );
            getDummyMetadata("_0", 3)
 *
 * this file be licensed under the Apache-2.0 license or a
        remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(  
        34,  
                RemoteSegmentStoreDirectory.MetadataFilenameUtils.METADATA_PREFIX,
    protected RemoteDirectory remoteDataDirectory;
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)  
                METADATA_FILES_TO_FETCH  
import java.util.ArrayList;  
        36,
package org.opensearch.index.store;
            new HashMap<>()  
        38,
            mdLockManager,  
        );
        when(threadPool.executor(ThreadPool.Names.REMOTE_PURGE)).thenReturn(executorService);  
 * The OpenSearch Contributors require contributions made to  
        when(threadPool.executor(ThreadPool.Names.SAME)).thenReturn(executorService);
                indexShard.getLatestReplicationCheckpoint(),
            indexShard.shardId(),
}
/*  
import static org.mockito.Mockito.when;
import static org.opensearch.index.store.RemoteSegmentStoreDirectory.METADATA_FILES_TO_FETCH;  
            getDummyMetadata("_0", 1),  
    );
                segmentInfos
                metadataFilenameContentMapping.get(metadataFilename2),
        0L  
        return metadataFilenameContentMapping;
        34,  
            metadataFilename,
        34,  
 */  
import static org.opensearch.test.RemoteStoreTestUtils.getDummyMetadata;
    protected String metadataFilename = RemoteSegmentStoreDirectory.MetadataFilenameUtils.getMetadataFilename(
        metadataFiles.add(metadataFilename3);
        when(remoteMetadataDirectory.getBlobStream(metadataFilename2)).thenAnswer(
        metadataFiles.add(metadataFilename2);  
        threadPool = mock(ThreadPool.class);
            remoteMetadataDirectory,
        Settings indexSettings = Settings.builder()
                indexShard.getLatestReplicationCheckpoint(),  
        remoteDataDirectory = mock(RemoteDirectory.class);
            I -> createMetadataFileBytes(  
                metadataFilenameContentMapping.get(metadataFilename3),
import static org.opensearch.test.RemoteStoreTestUtils.createMetadataFileBytes;
    protected RemoteSegmentStoreDirectory remoteSegmentStoreDirectory;
                segmentInfos
        12,
        10,
    );
        23,
import java.util.HashMap;
import org.junit.After;  
            getDummyMetadata("_0", 2),
import java.io.IOException;
import java.util.List;
    protected IndexShard indexShard;
        23,
        indexShard.close("test tearDown", true, false);
            )
    );
                indexShard.getLatestReplicationCheckpoint(),
        10,
            )  
            )
import org.opensearch.index.shard.IndexShardTestCase;
 * compatible open source license.
            metadataFilename3,  
 * SPDX-License-Identifier: Apache-2.0
        12,
