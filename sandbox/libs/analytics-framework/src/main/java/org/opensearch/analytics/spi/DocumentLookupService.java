        if (fileSet == null) {  
        return buildResultFromRow(id, fetchRow(metadata, reader));
            source = BytesReference.bytes(xcb);
    private static DocumentLookupResult buildResultFromRow(String id, Map<String, Object> row) throws IOException {  
        return row;
                || DocumentInput.ROW_ID_FIELD.equals(name)) {
import java.io.IOException;  
public class DocumentLookupService {
@ExperimentalApi
                    + id  
        String id = metadata.id();
    }  
        return new DocumentLookupResult(id, version, true, source, seqNo, primaryTerm, Map.of(), Map.of());
        }  
     * Resolves version metadata without reconstructing {@code _source}. Uses resolver metadata when
import org.opensearch.index.get.DocumentLookupResult;
                null,  
}
        long version = extractLong(row, "_version", Versions.NOT_FOUND);  
    /** Fetches the raw row for an already-resolved document location. */
import org.opensearch.index.engine.exec.IndexReaderProvider;
    private final DocumentMetadataResolver documentResolver;  
        long primaryTerm = extractLong(row, "_primary_term", SequenceNumbers.UNASSIGNED_PRIMARY_TERM);  
    public DocumentLookupService(DocumentMetadataResolver documentResolver, DocumentRowReader executor) {  
            );
                    + "] at writer generation ["  
        }  
        Map<String, Object> row = executor.executeSingleRow(metadata.rowId(), fileSet);
import org.opensearch.core.index.Index;
        long seqNo = extractLong(row, "_seq_no", SequenceNumbers.UNASSIGNED_SEQ_NO);
        this.executor = executor;
    }  
        BytesReference source;
                    + "] rowId ["
 */  
package org.opensearch.analytics.spi;
 * @opensearch.experimental
        }  
            return DocumentLookupResult.notFound(id);
        if (v instanceof Number) return ((Number) v).longValue();
        Object v = row.get(key);
import java.util.List;  
                Map.of()
            if (idVal != null) {
 * The OpenSearch Contributors require contributions made to  
                metadata.version(),
    }  
        return results;
 * backend-specific execution, and result assembly.  
    }
        List<WriterFileSet> fileSets = new ArrayList<>();  
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
        Map<String, Object> filtered = new LinkedHashMap<>();
 */  
     * available; legacy segments without these doc values fall back to a primary-store row lookup.  
import java.util.LinkedHashMap;
                    + metadata.rowId()  
        }
        DocumentMetadata metadata = documentResolver.resolveMetadata(reader, id);  
        try {
 * compatible open source license.
                    + "] but backend returned no row"
        return new DocumentLookupResult(id, version, true, null, seqNo, primaryTerm, Map.of(), Map.of());
 *
    }
     */  
                    + "] but no matching file set was found"  
/*  
            WriterFileSet fileSet = segment.dfGroupedSearchableFiles().get(executor.formatName());
        }
                continue;
        long version = extractLong(row, "_version", Versions.NOT_FOUND);
            filtered.put(name, e.getValue());
import org.opensearch.common.annotation.ExperimentalApi;
        if (metadata == null) {
            throw new IllegalStateException(
    }
        if (row == null) {
import java.util.Map;
import java.util.Set;
 * this file be licensed under the Apache-2.0 license or a
/**
                    + id
                true,
            );
import org.opensearch.index.engine.exec.DocumentMetadataResolver.DocumentMetadata;  
        DocumentMetadata metadata = documentResolver.resolveMetadata(reader, id);  
import java.util.ArrayList;
        if (metadata.hasVersionMetadata()) {
    public DocumentLookupResult getById(String id, IndexReaderProvider.Reader reader, Index index) throws IOException {
                || SeqNoFieldMapper.PRIMARY_TERM_NAME.equals(name)  
    private Map<String, Object> fetchRow(DocumentMetadata metadata, IndexReaderProvider.Reader reader) throws IOException {  
            String name = e.getKey();
import org.opensearch.index.mapper.SeqNoFieldMapper;
                metadata.primaryTerm(),
 * SPDX-License-Identifier: Apache-2.0
            if (METADATA_FIELDS.contains(name)
        WriterFileSet fileSet = reader.catalogSnapshot().findFileSet(executor.formatName(), metadata.writerGeneration());
    /** Builds a DocumentLookupResult from a raw row, filtering metadata/internal fields out of {@code _source}. */
     * registry's built-in metadata mappers rather than a hand-maintained list. {@code _primary_term} (a  
    /**
        }
            }  
        }  
            Object idVal = row.get("_id");  
            }
        }
                results.add(buildResultFromRow(idVal.toString(), row));
import org.opensearch.index.seqno.SequenceNumbers;  
 * Core orchestrator for document lookup. Coordinates row-location resolution,
import org.opensearch.core.xcontent.XContentBuilder;  
     * are not registered mappers, so they are excluded separately by constant in {@link #buildResultFromRow}.
import org.opensearch.core.common.bytes.BytesReference;
            return Long.parseLong(v.toString());  
        throws IOException {
        if (metadata == null) {
                "Resolver located id ["
     * Engine/storage metadata fields excluded from reconstructed {@code _source}, sourced from the mapper
        if (v == null) return fallback;  
 *
        } catch (NumberFormatException e) {
        for (Map.Entry<String, Object> e : row.entrySet()) {  
import org.opensearch.indices.IndicesModule;
            );
    public DocumentLookupResult getVersionMetadata(String id, IndexReaderProvider.Reader reader, Index index) throws IOException {
            }  
                    + metadata.writerGeneration()
        for (Map<String, Object> row : executor.executeRowsAboveSeqNo(fileSets, fromSeqNoExclusive)) {
    /**
                fileSets.add(fileSet);
import org.opensearch.common.lucene.uid.Versions;
            return new DocumentLookupResult(
    public static long extractLong(Map<String, Object> row, String key, long fallback) {
        long seqNo = extractLong(row, "_seq_no", SequenceNumbers.UNASSIGNED_SEQ_NO);
    private final DocumentRowReader executor;
     * sub-column emitted by the {@code _seq_no} mapper) and {@code __row_id__} (an engine-internal column)
                "Resolver located id ["
            return DocumentLookupResult.notFound(id);
        for (Segment segment : reader.catalogSnapshot().getSegments()) {
import org.opensearch.common.xcontent.XContentFactory;  
    private static final Set<String> METADATA_FIELDS = IndicesModule.getBuiltInMetadataFields();
                    + "] at writer generation ["
                    + metadata.writerGeneration()
                id,  
        }  
            return fallback;
import org.opensearch.index.engine.dataformat.DocumentInput;
            xcb.map(filtered);  
        Map<String, Object> row = fetchRow(metadata, reader);
        try (XContentBuilder xcb = XContentFactory.jsonBuilder()) {
     */
            if (fileSet != null && !fileSet.files().isEmpty()) {  
        long primaryTerm = extractLong(row, "_primary_term", SequenceNumbers.UNASSIGNED_PRIMARY_TERM);
        this.documentResolver = documentResolver;
                Map.of(),  
import org.opensearch.index.engine.exec.WriterFileSet;  
                metadata.seqNo(),
    public List<DocumentLookupResult> getDocsAboveSeqNo(long fromSeqNoExclusive, IndexReaderProvider.Reader reader, Index index)
    }
            throw new IllegalStateException(  
        List<DocumentLookupResult> results = new ArrayList<>();
import org.opensearch.index.engine.exec.Segment;
        }  
