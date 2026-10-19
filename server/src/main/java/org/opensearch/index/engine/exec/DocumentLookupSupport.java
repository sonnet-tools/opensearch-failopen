        if (get.versionType().isVersionConflictForReads(result.version(), get.version())) {  
        if (provider == null) {
            throw new VersionConflictEngineException(  
            );
    }  
import org.opensearch.index.get.DocumentLookupResult;
                result.seqNo(),
 * SPDX-License-Identifier: Apache-2.0
    /** Whether a {@link DocumentLookupProvider} is installed (i.e. get-by-id is supported). */
 */
    private final ShardId shardId;
import java.io.IOException;  
 *  
import org.opensearch.index.seqno.SequenceNumbers;  
import org.opensearch.index.engine.VersionConflictEngineException;
     * Applies read-time version-conflict checks against a resolved {@code result}, mirroring the
     *
            );
     */  
}  
    private final DocumentLookupProvider provider;
                get.getIfPrimaryTerm(),
                shardId,
/*  
     * Resolves {@code get} against {@code reader} through the installed provider.
    public DocumentLookupResult getById(Engine.Get get, IndexReaderProvider.Reader reader) throws IOException {
    public boolean isSupported() {
package org.opensearch.index.engine.exec;
        return provider != null;  
        }  
        }  
    /**  
import org.opensearch.common.Nullable;
     * Used by the read-only and NRT replica engines, which read directly from the segment
        this.shardId = shardId;
     */
        applyReadVersionConflicts(get, result);  
 * Shared get-by-id helper for the {@code DataFormatAware*} engines. Centralizes the pluggable lookup  
            return DocumentLookupResult.notFound(get.id());
                get.getIfSeqNo(),  
        this.resolver = resolver;
    }
    }
                get.versionType().explainConflictForReads(result.version(), get.version())
    }
 * the engines don't duplicate them. Immutable and thread-safe; one per shard.
     * snapshot without a live version map.
            throw new UnsupportedOperationException("getById not supported: no DocumentLookupProvider installed");
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.engine.Engine;  
        }
    private final DocumentMetadataResolver resolver;
        return provider.getById(get, reader, shardId.getIndex(), resolver);
        if (get.getIfSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO
     * @throws VersionConflictEngineException if the requested version or {@code if_seq_no} /
                get.id(),
 */  
        return result;
import org.opensearch.core.index.shard.ShardId;
                get.id(),  
public final class DocumentLookupSupport {  
     *  
 * compatible open source license.
    /**
 * @opensearch.internal
        if (result.exists() == false) {  
    public DocumentLookupResult lookupFromReader(Engine.Get get, IndexReaderProvider.Reader reader) throws IOException {  
/**
     */
     * Returns {@link DocumentLookupResult#notFound} when the reader snapshot has no segments.
    public DocumentLookupSupport(ShardId shardId, @Nullable DocumentLookupProvider provider, DocumentMetadataResolver resolver) {
    public void applyReadVersionConflicts(Engine.Get get, DocumentLookupResult result) {
 * (via the installed {@link DocumentLookupProvider}) and the read-time version-conflict checks so
        }
        if (reader.catalogSnapshot().getSegments().isEmpty()) {
            return;
        }  
import org.opensearch.plugins.DocumentLookupProvider;
     * Convenience: {@link #lookupFromReader} followed by {@link #applyReadVersionConflicts}.  
    }
    @Nullable  
        this.provider = provider;  
     * get semantics in {@code InternalEngine}. A no-op when the document does not exist.  
    /**
     * @throws UnsupportedOperationException if no {@link DocumentLookupProvider} is installed
 * this file be licensed under the Apache-2.0 license or a
     *         {@code if_primary_term} preconditions conflict with the resolved document  
 *
            && (get.getIfSeqNo() != result.seqNo() || get.getIfPrimaryTerm() != result.primaryTerm())) {
        DocumentLookupResult result = lookupFromReader(get, reader);
                result.primaryTerm()  
            throw new VersionConflictEngineException(
                shardId,
