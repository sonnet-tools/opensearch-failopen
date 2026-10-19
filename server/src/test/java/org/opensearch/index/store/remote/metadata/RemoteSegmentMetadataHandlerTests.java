    private Map<String, String> getDummyData() {
        indexShard = newStartedShard(false, indexSettings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
        return expectedOutput;  
            .build();  
                + "::"
    }  
    }
import org.apache.lucene.store.OutputStreamIndexOutput;
                + Version.LATEST.major
        );
import org.opensearch.common.UUIDs;
        replicationCheckpoint = indexShard.getLatestReplicationCheckpoint();  
        indexOutput.close();  
        RemoteSegmentMetadata metadata = remoteSegmentMetadataHandler.readContent(  
            indexShard.getLatestReplicationCheckpoint()  
        assertEquals(replicationCheckpoint.getPrimaryTerm(), metadata.getPrimaryTerm());
import java.util.HashMap;
        assertArrayEquals(segmentInfosBytes, metadata.getSegmentInfosBytes());  
}
        indexOutput.close();
        Map<String, String> expectedOutput = new HashMap<>();  
import org.opensearch.index.shard.IndexShardTestCase;  
            segmentInfosBytes,
        try (Store store = indexShard.store()) {  
    private SegmentInfos segmentInfos;
                + ".cfs__"  
        byte[] segmentInfosBytes = segmentInfosOutput.toArrayCopy();
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(expectedOutput, metadata.toMapOfStrings());
                + prefix
    @After  
                + Version.LATEST.major
    private IndexShard indexShard;
                + prefix  
        indexOutput.writeMapOfStrings(expectedOutput);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
import org.opensearch.core.common.bytes.BytesReference;
        );
                + "::"
        assertEquals(replicationCheckpoint.getSegmentsGen(), metadata.getGeneration());
import org.opensearch.common.io.stream.BytesStreamOutput;
        indexOutput.writeLong(0);  
        Settings indexSettings = Settings.builder()
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
 */
import org.apache.lucene.index.SegmentInfos;
public class RemoteSegmentMetadataHandlerTests extends IndexShardTestCase {
            prefix + ".cfe",  
        BytesStreamOutput output = new BytesStreamOutput();
                + randomIntBetween(1000, 5000)
        remoteSegmentMetadataHandler.writeContent(indexOutput, remoteSegmentMetadata);
            segmentInfos = store.readLastCommittedSegmentsInfo();
                + randomIntBetween(1024, 2048)
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
import org.opensearch.common.lucene.store.ByteArrayIndexInput;  
                + UUIDs.base64UUID()
 * Unit Tests for {@link RemoteSegmentMetadataHandler}  
        remoteSegmentMetadataHandler = new RemoteSegmentMetadataHandler(2);
import org.opensearch.indices.replication.common.ReplicationType;  
            .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "translog-repo")
import org.junit.Before;
        Map<String, String> expectedOutput = getDummyData();
import org.opensearch.index.shard.IndexShard;
            prefix  
import org.apache.lucene.store.ByteBuffersDataOutput;
                + "::"  
import org.opensearch.index.engine.NRTReplicationEngineFactory;  
        assertEquals(replicationCheckpoint.getSegmentsGen(), metadata.getGeneration());
import java.util.Map;  
        assertEquals(replicationCheckpoint.getSegmentsGen(), metadata.getGeneration());  
    }
 */  
import org.opensearch.index.store.Store;
    public void testReadContentNoSegmentInfos() throws IOException {  
        String prefix = "_0";
        OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput("dummy bytes", "dummy stream", output, 4096);  
        );
        Map<String, String> expectedOutput = getDummyData();
    private RemoteSegmentMetadataHandler remoteSegmentMetadataHandler;  
        byte[] segmentInfosBytes = segmentInfosOutput.toArrayCopy();  
        assertEquals(expectedOutput, metadata.toMapOfStrings());
/**
    public void testWriteContent() throws IOException {  
            new ByteArrayIndexInput("dummy bytes", BytesReference.toBytes(output.bytes()))
        expectedOutput.put(
import org.apache.lucene.store.ByteBuffersIndexOutput;  
            prefix + ".cfs",
        indexShard.close("test tearDown", true, false);
            new ByteArrayIndexInput("dummy bytes", BytesReference.toBytes(output.bytes()))
 *
        assertArrayEquals(segmentInfosBytes, metadata.getSegmentInfosBytes());
                + "::"  
    }
        segmentInfos.write(segmentInfosOutput);  
        RemoteSegmentMetadata remoteSegmentMetadata = new RemoteSegmentMetadata(  
        indexOutput.writeMapOfStrings(expectedOutput);
 * compatible open source license.
/*  
import org.opensearch.cluster.metadata.IndexMetadata;  
            RemoteSegmentMetadata.fromMapOfStrings(expectedOutput),
import org.apache.lucene.util.Version;
        expectedOutput.put(
                + randomIntBetween(1000, 5000)  
    public void setup() throws IOException {
            prefix
        assertEquals(expectedOutput, metadata.toMapOfStrings());  
            new ByteArrayIndexInput("dummy bytes", BytesReference.toBytes(output.bytes()))  
        );  
import org.opensearch.common.settings.Settings;
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        Map<String, String> expectedOutput = getDummyData();  
        indexOutput.writeLong(segmentInfosBytes.length);
                + ".cfe::"
 * this file be licensed under the Apache-2.0 license or a
    }
        indexOutput.writeBytes(segmentInfosBytes, 0, segmentInfosBytes.length);
    @Before  
        );  
        );
    private ReplicationCheckpoint replicationCheckpoint;
        RemoteSegmentMetadata metadata = remoteSegmentMetadataHandler.readContent(
import org.junit.After;
                + "::"
        BytesStreamOutput output = new BytesStreamOutput();
        indexOutput.close();  
import java.io.IOException;
                + "::"
package org.opensearch.index.store.remote.metadata;
    public void testReadContentWithSegmentInfos() throws IOException {
                + ".cfe__"
        segmentInfos.write(segmentInfosOutput);
    }
        OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput("dummy bytes", "dummy stream", output, 4096);
        }
        RemoteSegmentMetadata.writeCheckpointToIndexOutput(replicationCheckpoint, indexOutput);  
        RemoteSegmentMetadata.writeCheckpointToIndexOutput(replicationCheckpoint, indexOutput);
        super.tearDown();  
                + randomIntBetween(1024, 2048)  
                + UUIDs.base64UUID()
                + ".cfs::"
        ByteBuffersIndexOutput segmentInfosOutput = new ByteBuffersIndexOutput(new ByteBuffersDataOutput(), "test", "resource");
        indexOutput.writeBytes(new byte[0], 0);
        OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput("dummy bytes", "dummy stream", output, 4096);
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
    public void tearDown() throws Exception {
        BytesStreamOutput output = new BytesStreamOutput();
        ByteBuffersIndexOutput segmentInfosOutput = new ByteBuffersIndexOutput(new ByteBuffersDataOutput(), "test", "resource");
        RemoteSegmentMetadata metadata = remoteSegmentMetadataHandler.readContent(
