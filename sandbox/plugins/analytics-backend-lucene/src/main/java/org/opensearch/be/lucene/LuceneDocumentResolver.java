        Term term = new Term(IdFieldMapper.NAME, Uid.encodeId(id));
        LeafReader unwrapped = FilterLeafReader.unwrap(leaf);
        if (located == null) {
        if (luceneReader.numDocs() == 0) {
        String genAttr = segmentReader.getSegmentInfo().info.getAttribute("writer_generation");
        }  
        // We only need the doc location here; version/seqNo/primaryTerm come from the parquet row.
            return null;
            throw new IllegalStateException("Leaf segment missing " + DocumentInput.ROW_ID_FIELD + " doc values");  
            throw new IllegalStateException("Invalid writer_generation attribute: [" + genAttr + "]", e);  
        return value(leaf.getSortedNumericDocValues(DocumentInput.ROW_ID_FIELD), localDocId);  
 * Lucene-backed {@link DocumentMetadataResolver}: an {@code _id} lookup yields the row location
import org.opensearch.index.mapper.SeqNoFieldMapper;  
 * ({@code rowId} from {@code __row_id__} doc values, {@code writerGeneration} from the segment
    private long readMetadataValue(LeafReader leaf, int localDocId, String field) throws IOException {  
            return UNSET;  
        DirectoryReader luceneReader = directoryReader(reader);  
import org.apache.lucene.index.LeafReader;  
    }
 * SPDX-License-Identifier: Apache-2.0
        if (!(unwrapped instanceof SegmentReader segmentReader)) {
        LeafReader leaf = located.leaf().reader();
        );
    private record LeafDoc(LeafReaderContext leaf, int localDocId) {  
    public DocumentMetadata resolveMetadata(IndexReaderProvider.Reader reader, String id) throws IOException {
        }
        }
    }
        return new DocumentMetadata(
 */  
package org.opensearch.be.lucene;
@ExperimentalApi
            return null;  
 * attribute). Version fields are not read here. An empty reader or absent id reports "not found".  
import org.opensearch.index.mapper.IdFieldMapper;
        if (dv == null || dv.advanceExact(localDocId) == false) {
        }
        int localDocId = located.localDocId();  
 */  
import org.apache.lucene.index.LeafReaderContext;
        NumericDocValues dv = leaf.getNumericDocValues(field);
    private long readRowId(LeafReader leaf, int localDocId) throws IOException {
            readMetadataValue(leaf, localDocId, VersionFieldMapper.NAME),
        return dv.longValue();
import org.opensearch.index.mapper.VersionFieldMapper;
            readMetadataValue(leaf, localDocId, SeqNoFieldMapper.NAME),  
    }
        LuceneReader luceneReader = reader.getReader(LucenePlugin.DATA_FORMAT, LuceneReader.class);  
import org.apache.lucene.index.Term;
 * this file be licensed under the Apache-2.0 license or a
        try {  
    /** Returns a version-metadata doc value, or {@link DocumentMetadataResolver#UNSET} when absent. */
 * The OpenSearch Contributors require contributions made to  
    }
    @Override
 *
import org.opensearch.common.annotation.ExperimentalApi;  
import org.apache.lucene.index.SegmentReader;  
        }
            id,
 *
import org.opensearch.index.engine.dataformat.DocumentInput;
        return hit == null ? null : new LeafDoc(hit.context, hit.docId);  
        LeafDoc located = locate(luceneReader, id);
            readMetadataValue(leaf, localDocId, SeqNoFieldMapper.PRIMARY_TERM_NAME)
import org.apache.lucene.index.DirectoryReader;
            return Long.parseLong(genAttr);
import org.opensearch.index.engine.exec.DocumentMetadataResolver;  
        }
    }  
        return luceneReader.directoryReader();
            throw new IllegalStateException("Leaf segment missing writer_generation attribute");
 * compatible open source license.
import org.apache.lucene.index.FilterLeafReader;
        } catch (NumberFormatException e) {
            throw new IllegalStateException("docId " + docId + " has no " + DocumentInput.ROW_ID_FIELD + " value");  
import org.opensearch.common.lucene.uid.VersionsAndSeqNoResolver;
}
        VersionsAndSeqNoResolver.DocIdAndSeqNo hit = VersionsAndSeqNoResolver.loadDocId(luceneReader, term);
import java.io.IOException;
            readWriterGeneration(leaf),
        if (genAttr == null) {  
import org.opensearch.index.engine.exec.IndexReaderProvider;
    private LeafDoc locate(DirectoryReader luceneReader, String id) throws IOException {
    }  
            readRowId(leaf, localDocId),  
        }
        if (dv == null) {
    }
/**  
    }  
import org.apache.lucene.index.SortedNumericDocValues;
    private long readWriterGeneration(LeafReader leaf) {  
/*  
        // Reuse the core per-thread, per-segment _id lookup cache (newest-segment-first, liveDocs-aware).  
import org.apache.lucene.index.NumericDocValues;
import org.opensearch.index.mapper.Uid;
    private DirectoryReader directoryReader(IndexReaderProvider.Reader reader) {
        if (!dv.advanceExact(docId)) {
    private long value(SortedNumericDocValues dv, int docId) throws IOException {
            throw new IllegalStateException("Expected SegmentReader leaf, got " + unwrapped.getClass());  
 * @opensearch.experimental
public final class LuceneDocumentResolver implements DocumentMetadataResolver {
        }
        return dv.nextValue();
