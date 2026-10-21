        }
import org.opensearch.index.mapper.SeqNoFieldMapper;
     * are not registered mappers, so they are excluded separately by constant in {@link #buildResultFromRow}.
        try (XContentBuilder xcb = XContentFactory.jsonBuilder()) {
import java.io.IOException;
        long version = extractLong(row, "_version", Versions.NOT_FOUND);
            return DocumentLookupResult.notFound(id);
     */
        return new DocumentLookupResult(id, version, true, null, seqNo, primaryTerm, Map.of(), Map.of());
            throw new IllegalStateException(
                "Resolver located id ["
     * sub-column emitted by the {@code _seq_no} mapper) and {@code __row_id__} (an engine-internal column)
        for (Segment segment : reader.catalogSnapshot().getSegments()) {
        if (v == null) return fallback;
            Object idVal = row.get("_id");
        DocumentMetadata metadata = documentResolver.resolveMetadata(reader, id);
                true,
        List<DocumentLookupResult> results = new ArrayList<>();
                "Resolver located id ["
                    + "] but backend returned no row"
        if (metadata.hasVersionMetadata()) {
 * The OpenSearch Contributors require contributions made to
    /** Fetches the raw row for an already-resolved document location. */
    /**
    private final DocumentMetadataResolver documentResolver;
            String name = e.getKey();
     * Engine/storage metadata fields excluded from reconstructed {@code _source}, sourced from the mapper
import org.opensearch.common.xcontent.XContentFactory;
import org.opensearch.index.engine.dataformat.DocumentInput;
        this.executor = executor;
            return new DocumentLookupResult(
            return fallback;
    public DocumentLookupResult getById(String id, IndexReaderProvider.Reader reader, Index index) throws IOException {
            );
        } catch (NumberFormatException e) {
        if (metadata == null) {
    }
                    + id
        }
 * @opensearch.experimental
    public static long extractLong(Map<String, Object> row, String key, long fallback) {
        Map<String, Object> filtered = new LinkedHashMap<>();
        BytesReference source;
            );
 */
import org.opensearch.index.engine.exec.WriterFileSet;
    }
package org.opensearch.analytics.spi;
                || SeqNoFieldMapper.PRIMARY_TERM_NAME.equals(name)
        if (metadata == null) {
            WriterFileSet fileSet = segment.dfGroupedSearchableFiles().get(executor.formatName());
        Object v = row.get(key);
                    + "] rowId ["
                    + metadata.rowId()
    }
                fileSets.add(fileSet);
        return buildResultFromRow(id, fetchRow(metadata, reader));
        long seqNo = extractLong(row, "_seq_no", SequenceNumbers.UNASSIGNED_SEQ_NO);
                results.add(buildResultFromRow(idVal.toString(), row));
    private static final Set<String> METADATA_FIELDS = IndicesModule.getBuiltInMetadataFields();
        try {
        }
                    + metadata.writerGeneration()
import org.opensearch.index.get.DocumentLookupResult;
                    + "] at writer generation ["
import org.opensearch.common.lucene.uid.Versions;
/**
    }
import org.opensearch.index.engine.exec.Segment;
        for (Map<String, Object> row : executor.executeRowsAboveSeqNo(fileSets, fromSeqNoExclusive)) {
        long primaryTerm = extractLong(row, "_primary_term", SequenceNumbers.UNASSIGNED_PRIMARY_TERM);
 *
        }
                metadata.version(),
        }
                    + metadata.writerGeneration()
            xcb.map(filtered);
        }
                id,
        }
        long primaryTerm = extractLong(row, "_primary_term", SequenceNumbers.UNASSIGNED_PRIMARY_TERM);
        if (fileSet == null) {
import org.opensearch.index.engine.exec.IndexReaderProvider;
    public List<DocumentLookupResult> getDocsAboveSeqNo(long fromSeqNoExclusive, IndexReaderProvider.Reader reader, Index index)
            filtered.put(name, e.getValue());
import org.opensearch.core.index.Index;
import org.opensearch.index.engine.exec.DocumentMetadataResolver.DocumentMetadata;
            if (idVal != null) {
import org.opensearch.common.annotation.ExperimentalApi;
                null,
        DocumentMetadata metadata = documentResolver.resolveMetadata(reader, id);
    private Map<String, Object> fetchRow(DocumentMetadata metadata, IndexReaderProvider.Reader reader) throws IOException {
import org.opensearch.core.common.bytes.BytesReference;
    /**
            source = BytesReference.bytes(xcb);
        }
import java.util.ArrayList;
        }
@ExperimentalApi
            throw new IllegalStateException(
        long seqNo = extractLong(row, "_seq_no", SequenceNumbers.UNASSIGNED_SEQ_NO);
        Map<String, Object> row = fetchRow(metadata, reader);
        }
 * compatible open source license.
            }
 */
}
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
 * Core orchestrator for document lookup. Coordinates row-location resolution,
import org.opensearch.core.xcontent.XContentBuilder;
 * this file be licensed under the Apache-2.0 license or a
                metadata.primaryTerm(),
        return new DocumentLookupResult(id, version, true, source, seqNo, primaryTerm, Map.of(), Map.of());
 *
        return row;
            }
        throws IOException {
     */
            return DocumentLookupResult.notFound(id);
import java.util.LinkedHashMap;
import java.util.Map;
public class DocumentLookupService {
                metadata.seqNo(),
                continue;
    private static DocumentLookupResult buildResultFromRow(String id, Map<String, Object> row) throws IOException {
import java.util.Set;
            return Long.parseLong(v.toString());
            }
    public DocumentLookupResult getVersionMetadata(String id, IndexReaderProvider.Reader reader, Index index) throws IOException {
        List<WriterFileSet> fileSets = new ArrayList<>();
import org.opensearch.indices.IndicesModule;
    }
        String id = metadata.id();
import org.opensearch.index.seqno.SequenceNumbers;
        WriterFileSet fileSet = reader.catalogSnapshot().findFileSet(executor.formatName(), metadata.writerGeneration());
        if (row == null) {
                    + "] but no matching file set was found"
import java.util.List;
     * available; legacy segments without these doc values fall back to a primary-store row lookup.
            if (fileSet != null && !fileSet.files().isEmpty()) {
            );
 * SPDX-License-Identifier: Apache-2.0
    public DocumentLookupService(DocumentMetadataResolver documentResolver, DocumentRowReader executor) {
        long version = extractLong(row, "_version", Versions.NOT_FOUND);
/*
     * registry's built-in metadata mappers rather than a hand-maintained list. {@code _primary_term} (a
        return results;
                Map.of(),
        Map<String, Object> row = executor.executeSingleRow(metadata.rowId(), fileSet);
                    + id
    private final DocumentRowReader executor;
                Map.of()
                || DocumentInput.ROW_ID_FIELD.equals(name)) {
    /** Builds a DocumentLookupResult from a raw row, filtering metadata/internal fields out of {@code _source}. */
 * backend-specific execution, and result assembly.
     * Resolves version metadata without reconstructing {@code _source}. Uses resolver metadata when
    }
                    + "] at writer generation ["
        for (Map.Entry<String, Object> e : row.entrySet()) {
        this.documentResolver = documentResolver;
        if (v instanceof Number) return ((Number) v).longValue();
    }
            if (METADATA_FIELDS.contains(name)
