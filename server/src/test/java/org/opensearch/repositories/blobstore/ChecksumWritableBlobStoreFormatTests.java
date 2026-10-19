    }  
    }  
            .numberOfShards(1)
        IndexMetadata::readFrom
        assertThat(readIndexMetadata, is(indexMetadata));
            indexMetadata,  
        return new IndexMetadata.Builder(index.getName()).settings(idxSettings)
import java.io.IOException;
            TEST_BLOB_FILE_NAME,
/*  
 * The OpenSearch Contributors require contributions made to  
}
import org.opensearch.core.compress.CompressorRegistry;  
    );  
/**
        assertThat(readIndexMetadata, is(indexMetadata));
    private final ChecksumWritableBlobStoreFormat<IndexMetadata> clusterBlocksFormat = new ChecksumWritableBlobStoreFormat<>(  
            .version(VERSION)  
            .numberOfReplicas(0)
package org.opensearch.repositories.blobstore;
    private static final String TEST_BLOB_FILE_NAME = "test-blob-name";  
 */
        "index-metadata",
 * Tests for {@link ChecksumWritableBlobStoreFormat}  
    private static final long VERSION = 5L;
import org.opensearch.test.OpenSearchTestCase;
            (out, metadata) -> metadata.writeTo(out),
    public void testSerDeForCompressed() throws IOException {
            (out, metadata) -> metadata.writeTo(out),
    public void testSerDe() throws IOException {
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())  
        IndexMetadata indexMetadata = getIndexMetadata();  
            .build();  
    private IndexMetadata getIndexMetadata() {
import org.opensearch.common.settings.Settings;
 */  
import org.opensearch.core.common.bytes.BytesReference;
 * SPDX-License-Identifier: Apache-2.0
        IndexMetadata readIndexMetadata = clusterBlocksFormat.deserialize(TEST_BLOB_FILE_NAME, bytesReference);
import org.opensearch.common.compress.DeflateCompressor;  
        );  
            TEST_BLOB_FILE_NAME,
            CompressorRegistry.getCompressor(DeflateCompressor.NAME)
            CompressorRegistry.none()
    }
        IndexMetadata readIndexMetadata = clusterBlocksFormat.deserialize(TEST_BLOB_FILE_NAME, bytesReference);
            .build();
 * compatible open source license.
        BytesReference bytesReference = clusterBlocksFormat.serialize(
import org.opensearch.cluster.metadata.IndexMetadata;
 *
        );  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        IndexMetadata indexMetadata = getIndexMetadata();  
            indexMetadata,  
public class ChecksumWritableBlobStoreFormatTests extends OpenSearchTestCase {
import org.opensearch.core.index.Index;
import static org.hamcrest.Matchers.is;  
        final Index index = new Index("test-index", "index-uuid");  
        BytesReference bytesReference = clusterBlocksFormat.serialize(
import org.opensearch.Version;
 * this file be licensed under the Apache-2.0 license or a
        final Settings idxSettings = Settings.builder()
