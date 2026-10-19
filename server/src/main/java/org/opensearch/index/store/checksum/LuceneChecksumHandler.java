 */
 * since it only reads the last 16 bytes of the file.</p>
    }
import org.opensearch.index.store.StoreFileMetadata;
        try (IndexInput input = dir.openInput(fileName, IOContext.READONCE)) {
    @Override
@PublicApi(since = "3.0.0")
/*  
 * <p>Reads the checksum from the Lucene codec footer — an O(1) operation  
package org.opensearch.index.store.checksum;
import org.opensearch.common.annotation.PublicApi;
import org.apache.lucene.store.IOContext;  
            return CodecUtil.retrieveChecksum(input);
import org.opensearch.common.annotation.ExperimentalApi;  
 * @opensearch.api  
import org.opensearch.index.store.VerifyingIndexOutput;
}
 * The OpenSearch Contributors require contributions made to  
 * Checksum strategy for Lucene segment files.
 *
 */  
 *
import org.opensearch.index.store.FormatChecksumStrategy;
    }
import org.opensearch.index.store.Store;  
        return new Store.LuceneVerifyingIndexOutput(metadata, output);  
    @ExperimentalApi  
 * this file be licensed under the Apache-2.0 license or a
/**  
    @Override
    public VerifyingIndexOutput createVerifyingOutput(StoreFileMetadata metadata, IndexOutput output) {
import org.apache.lucene.store.IndexInput;
import org.apache.lucene.store.IndexOutput;
    public long computeChecksum(Directory dir, String fileName) throws IOException {  
import java.io.IOException;
        }  
 *
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
public class LuceneChecksumHandler implements FormatChecksumStrategy {  
import org.apache.lucene.codecs.CodecUtil;
import org.apache.lucene.store.Directory;
