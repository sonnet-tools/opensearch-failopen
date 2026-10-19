/*  
 */  
 * compatible open source license.
/**
    }
    default DocumentLookupResult getVersionMetadata(  
     * skipping {@code _source} reconstruction. The {@code resolver} resolves the document's row location.
import org.opensearch.index.engine.exec.IndexReaderProvider;
        Index index,  
        IndexReaderProvider.Reader reader,  
import org.opensearch.index.engine.Engine;  
 * {@link DocumentLookupResult} with the source (and optionally other fields)
import org.opensearch.index.get.DocumentLookupResult;  
}  
import org.opensearch.core.index.Index;
        Index index,
     * Resolves only version metadata ({@code _version}/{@code _seq_no}/{@code _primary_term}) for an id,  
     */  
 */  
    ) throws IOException {
 * for the matching row.  
     * @throws IOException if resolution fails  
 * The OpenSearch Contributors require contributions made to  
     */
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
     * @param get the get request (id, realtime flag, etc.)
        throws IOException;  
    DocumentLookupResult getById(Engine.Get get, IndexReaderProvider.Reader reader, Index index, DocumentMetadataResolver resolver)
public interface DocumentLookupProvider {
        DocumentMetadataResolver resolver
     *  
    /**
package org.opensearch.plugins;
    /**  
 * this file be licensed under the Apache-2.0 license or a
    ) throws IOException {  
@ExperimentalApi
     * @param resolver the {@link DocumentMetadataResolver} used to resolve a document's row location
        String id,
        return List.of();
    default List<DocumentLookupResult> getDocsAboveSeqNo(
     * Resolve the document referenced by {@code get} against {@code reader}.
     * Returns metadata for all documents with {@code _seq_no > fromSeqNoExclusive}. Default returns empty list.
import java.io.IOException;
     * @param reader a point-in-time index reader acquired by the caller
     * The {@code resolver} resolves each document's row location.
 *
 * SPI for pluggable get-by-id lookup. Implementations resolve a document id  
import java.util.List;  
        IndexReaderProvider.Reader reader,
     * @return the lookup result; never {@code null}
 *
import org.opensearch.common.annotation.ExperimentalApi;
        long fromSeqNoExclusive,
     * @param index the index, used by implementations as the scan table name  
        DocumentMetadataResolver resolver
    }
 * against the shard's current reader snapshot and return a
 * @opensearch.experimental
     */
        return DocumentLookupResult.notFound(id);  
    /**
