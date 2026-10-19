        this.seqNo = seqNo;
        long seqNo,
     * Wraps this lookup as a {@link PreMaterialized} {@link Engine.GetResult} so the get-by-id path
    Map<String, DocumentField> documentFields, Map<String, DocumentField> metadataFields) {
@ExperimentalApi  
    public boolean equals(Object o) {
    public int hashCode() {
        @Nullable BytesReference source,  
            && Objects.equals(source, other.source)
    ) {
        return Objects.hash(id, version, exists, source, seqNo, primaryTerm, documentFields, metadataFields);
        @Override  
            Versions.NOT_FOUND,
        return version == other.version
        boolean exists,
}
        public Engine.Searcher searcher() {
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver.DocIdAndVersion;
     */  
        Map<String, DocumentField> documentFields,  
 * Minimal result of get-by-id lookup. Decouples callers from
    public static final class PreMaterialized extends Engine.GetResult {
     * shares the {@code IndexShard.get(Engine.Get)} return type. The synthesized  
public record DocumentLookupResult(String id, long version, boolean exists, @Nullable BytesReference source, long seqNo, long primaryTerm,
            UNASSIGNED_SEQ_NO,
    /**
        this.exists = exists;
            // no searcher to release
        }  
            Map.of(),  
    public DocumentLookupResult(
    }  
            Map.of()
 * this file be licensed under the Apache-2.0 license or a
        this.metadataFields = metadataFields == null ? Map.of() : metadataFields;
    @Override  
        }
        public DocIdAndVersion docIdAndVersion() {
        public boolean exists() {  
import org.opensearch.core.common.bytes.BytesReference;  
        this.primaryTerm = primaryTerm;
import java.util.Objects;
     * and must not be dereferenced.
     * {@link DocIdAndVersion} carries version/seqNo/primaryTerm only; its reader/docId are unset
 */
    }  
 * SPDX-License-Identifier: Apache-2.0
        private final DocumentLookupResult lookup;
        Map<String, DocumentField> metadataFields
 * The OpenSearch Contributors require contributions made to  
            throw new UnsupportedOperationException("PreMaterialized has no docId");
        this.source = source;  
     */  
        this.id = id;  
        return new DocumentLookupResult(
        );
            UNASSIGNED_PRIMARY_TERM,
    }
            && Objects.equals(metadataFields, other.metadataFields);  
 * @opensearch.experimental
import org.opensearch.common.document.DocumentField;  
        }
    @Override  
            && Objects.equals(id, other.id)  
        if (o instanceof DocumentLookupResult == false) return false;  
/*  
     * {@link Engine.GetResult} carrying a {@link DocumentLookupResult}. {@link ShardGetService}  
package org.opensearch.index.get;
        }
            this.lookup = lookup;  
import org.opensearch.common.Nullable;
        String id,  
import org.opensearch.index.engine.Engine;
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;  
        }  
     * detects it via {@code instanceof} and materializes source/fields from the lookup instead of
    }  
 * compatible open source license.
            super(null, new DocIdAndVersion(-1, lookup.version, lookup.seqNo, lookup.primaryTerm, null, 0), false);
 *  
            null,  
 */  
            false,
        return new PreMaterialized(this);
            && Objects.equals(documentFields, other.documentFields)
 * {@link Engine.GetResult}.
    /**
import org.opensearch.common.annotation.ExperimentalApi;
            return lookup;
    }
        public void close() {
/**  
            && exists == other.exists  
        }
        public DocumentLookupResult lookup() {  
        @Override
            id,  
        }
        private PreMaterialized(DocumentLookupResult lookup) {
            && primaryTerm == other.primaryTerm
            throw new UnsupportedOperationException("PreMaterialized has no searcher");  
        long primaryTerm,
            return lookup.version;  
    public static DocumentLookupResult notFound(String id) {
            && seqNo == other.seqNo
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
            return lookup.exists;
 *
     * the engine stored-fields path. Has no searcher/docId — those accessors throw.
        @Override
        @Override  
        long version,
        if (this == o) return true;
import org.opensearch.common.lucene.uid.Versions;
    public Engine.GetResult toGetResult() {
        @Override
        public long version() {
        this.documentFields = documentFields == null ? Map.of() : documentFields;  
        this.version = version;
    }
import java.util.Map;  
        DocumentLookupResult other = (DocumentLookupResult) o;
