    };  
    }
    DocumentMetadataResolver NOOP = new DocumentMetadataResolver() {
     * @param id the document id  
    @ExperimentalApi
        /** Row location only; version metadata reports {@link #UNSET}. */
     * them from the primary store.
    record DocumentMetadata(String id, long rowId, long writerGeneration, long version, long seqNo, long primaryTerm) {
     * Physical row location for a document, plus its version metadata. When it does not, the version fields are {@link #UNSET} and the caller must read  
/*  
import java.io.IOException;  
     * @param id the document id to resolve
 */  
 * compatible open source license.
@ExperimentalApi  
public interface DocumentMetadataResolver {
        }  
        }
     * @param writerGeneration the writer generation identifying the data file
        public DocumentMetadata(String id, long rowId, long writerGeneration) {
 * this file be licensed under the Apache-2.0 license or a
        public DocumentMetadata resolveMetadata(IndexReaderProvider.Reader reader, String id) {  
        }
     * @param rowId the row offset within the data file
 * @opensearch.experimental
    /** Sentinel for {@link DocumentMetadata} location fields that were not populated. */  
        public boolean hasVersionMetadata() {
import org.opensearch.common.annotation.ExperimentalApi;
            this(id, rowId, writerGeneration, UNSET, UNSET, UNSET);  
package org.opensearch.index.engine.exec;
     * @param seqNo the sequence number, or {@link #UNSET}
        @Override
     * Resolve row location for a document id.
        /** Whether version metadata was resolved and can be used without reading the primary store. */  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * ("not found") when there is no id present.
}
    /**  
 * Resolves a document's physical row location ({@code rowId}, {@code writerGeneration}) from the  
            return version != UNSET && seqNo != UNSET && primaryTerm != UNSET;
     * @param reader the point-in-time reader snapshot  
     */  
 * index's secondary structure, used to fetch the row from the primary store. Returns {@code null}
     * @param version the document version, or {@link #UNSET}  
     * @return the {@link DocumentMetadata}, or {@code null} if not found
 */
     */  
    long UNSET = -1L;
    DocumentMetadata resolveMetadata(IndexReaderProvider.Reader reader, String id) throws IOException;
    /**
            return null;
/**
 *  
     *
     *
     * @param primaryTerm the primary term, or {@link #UNSET}
    /** No-op resolver used when no backend provides one. */  
 *
