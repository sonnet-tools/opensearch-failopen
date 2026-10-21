     * A segment written before version doc values existed still resolves its row location; the version
import org.apache.lucene.index.SegmentInfo;
                    () -> resolver.resolveMetadata(readerReturning(dr), "doc1")
            @Override
import org.apache.lucene.document.StoredField;
            }
        try (Directory dir = new ByteBuffersDirectory()) {
import org.apache.lucene.codecs.SegmentInfoFormat;
        doc.add(new StringField(IdFieldMapper.NAME, Uid.encodeId(id), Field.Store.NO)); // for _id TermQuery
    private final LuceneDocumentResolver resolver = new LuceneDocumentResolver();
            try (IndexWriter w = new IndexWriter(dir, new IndexWriterConfig())) {
                doc.add(new StoredField(IdFieldMapper.NAME, Uid.encodeId("doc1")));
                addDoc(w, "doc1", 7L, 42L, 3L, 9L, true);
            try (IndexWriter w = new IndexWriter(dir, iwc(codecWithGeneration("1")))) {
        try (Directory dir = new ByteBuffersDirectory()) {
        doc.add(new NumericDocValuesField(VersionFieldMapper.NAME, version));
        }
import org.apache.lucene.store.ByteBuffersDirectory;
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
    }
                );
            }
    }
 * The OpenSearch Contributors require contributions made to
                    public SegmentInfo read(Directory d, String name, byte[] id, IOContext ctx) throws IOException {
                    }
     */
    private static Codec codecWithGeneration(String gen) {
            }
    /**
                assertTrue(e.getMessage().contains("writer_generation"));
        IndexWriterConfig c = new IndexWriterConfig();
     */
                };
        }
    private static IndexWriterConfig iwc(Codec codec) {
import static org.mockito.ArgumentMatchers.any;
import org.opensearch.index.engine.dataformat.DataFormat;
import static org.mockito.Mockito.mock;
        return new FilterCodec(base.getName(), base) {
import org.apache.lucene.index.IndexWriterConfig;
            try (IndexWriter w = new IndexWriter(dir, iwc(codecWithGeneration("5")))) {
    }
                IllegalStateException e = expectThrows(
                addDoc(w, "doc1", 1L, 1L, 1L, 0L, false); // no __row_id__ doc values
    public void testResolveMetadata_missingWriterGeneration_throwsISE() throws IOException {
                assertFalse(md.hasVersionMetadata());
                assertNull(resolver.resolveMetadata(readerReturning(dr), "doc1"));
            }
                    @Override
            try (DirectoryReader dr = DirectoryReader.open(dir)) {
import org.apache.lucene.document.Document;
import org.apache.lucene.store.Directory;
            try (DirectoryReader dr = DirectoryReader.open(dir)) {
            try (IndexWriter w = new IndexWriter(dir, iwc(codecWithGeneration("5")))) {
import org.apache.lucene.document.NumericDocValuesField;
                assertTrue(e.getMessage().contains(DocumentInput.ROW_ID_FIELD));
    public void testResolveMetadata_idNotPresent_returnsNull() throws IOException {
import org.apache.lucene.codecs.FilterCodec;
                assertEquals("doc1", md.id());
import org.opensearch.index.engine.dataformat.DocumentInput;
                );
                doc.add(new SortedNumericDocValuesField(DocumentInput.ROW_ID_FIELD, 9L));
        }
                    public void write(Directory d, SegmentInfo info, IOContext ctx) throws IOException {
import org.apache.lucene.document.SortedNumericDocValuesField;
            try (IndexWriter w = new IndexWriter(dir, new IndexWriterConfig())) {
        IndexReaderProvider.Reader reader = mock(IndexReaderProvider.Reader.class);
import org.apache.lucene.document.LongPoint;
                assertTrue(md.hasVersionMetadata());
        try (Directory dir = new ByteBuffersDirectory()) {
import java.io.IOException;
                    }
    }
    public void testResolveMetadata_found_returnsMetadata() throws IOException {
                assertEquals(5L, md.writerGeneration());
    /**
                assertNull(resolver.resolveMetadata(readerReturning(dr), "missing"));
                    () -> resolver.resolveMetadata(readerReturning(dr), "doc1")
import org.apache.lucene.document.Field;
            }
    /** Codec that stamps a {@code writer_generation} segment attribute, mirroring the production writer. */
        throws IOException {
            }
public class LuceneDocumentResolverTests extends OpenSearchTestCase {
                assertEquals(9L, md.rowId());
     * When the index has no Lucene secondary reader, {@code directoryReader(reader)} fails fast:
        return c;
                        delegate.write(d, info, ctx);
    public void testResolveMetadata_emptyReader_returnsNull() throws IOException {
import org.opensearch.index.mapper.SeqNoFieldMapper;
                DocumentMetadata md = resolver.resolveMetadata(readerReturning(dr), "doc1");
                        info.putAttribute("writer_generation", gen);
        Codec base = Codec.getDefault();
    }
                Document doc = new Document();
                assertEquals(42L, md.seqNo());
                        return delegate.read(d, name, id, ctx);
        doc.add(new StoredField(IdFieldMapper.NAME, Uid.encodeId(id)));                  // for decodeId (restore path)
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
import org.apache.lucene.index.DirectoryReader;
import org.opensearch.index.engine.exec.IndexReaderProvider;
     * fields report {@code UNSET} so the caller falls back to reading the primary store.
            }
import org.opensearch.index.mapper.IdFieldMapper;
            try (DirectoryReader dr = DirectoryReader.open(dir)) {
                assertEquals(DocumentMetadataResolver.UNSET, md.primaryTerm());
        when(reader.getReader(any(DataFormat.class), eq(LuceneReader.class))).thenReturn(new LuceneReader(dr, java.util.Map.of()));
    public void testResolveMetadata_missingRowIdDocValues_throwsISE() throws IOException {
        c.setCodec(codec);
 *
                w.commit();
        try (Directory dir = new ByteBuffersDirectory()) {
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, primaryTerm));
        doc.add(new LongPoint(SeqNoFieldMapper.NAME, seqNo));                            // for LongPoint range scan
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.NAME, seqNo));
            }
    // --- resolveMetadata ---
import static org.mockito.ArgumentMatchers.eq;
        }
                    IllegalStateException.class,
 */
    public void testResolveMetadata_withoutVersionDocValues_reportsUnset() throws IOException {
    }
            }
                assertEquals(9L, md.rowId());
                w.addDocument(doc);
        Document doc = new Document();
            public SegmentInfoFormat segmentInfoFormat() {
package org.opensearch.be.lucene;
        }
/*
                DocumentMetadata md = resolver.resolveMetadata(readerReturning(dr), "doc1");
        }
            try (DirectoryReader dr = DirectoryReader.open(dir)) {
}
            }
        w.commit();
                return new SegmentInfoFormat() {
            try (DirectoryReader dr = DirectoryReader.open(dir)) {
                assertNotNull(md);
        };
 * this file be licensed under the Apache-2.0 license or a
            }
                assertNotNull(md);
    }
    }
import org.opensearch.index.engine.exec.DocumentMetadataResolver.DocumentMetadata;
import org.opensearch.test.OpenSearchTestCase;
    // --- helpers ---
                addDoc(w, "other", 1L, 1L, 1L, 0L, true);
    private static void addDoc(IndexWriter w, String id, long version, long seqNo, long primaryTerm, long rowId, boolean withRowId)
    private static IndexReaderProvider.Reader readerReturning(DirectoryReader dr) {
                assertEquals(DocumentMetadataResolver.UNSET, md.seqNo());
import org.opensearch.index.mapper.Uid;
                doc.add(new StringField(IdFieldMapper.NAME, Uid.encodeId("doc1"), Field.Store.NO));
                    @Override
import org.apache.lucene.index.IndexWriter;
        try (Directory dir = new ByteBuffersDirectory()) {
            // default codec → no writer_generation segment attribute
        return reader;
                IllegalStateException e = expectThrows(
import org.apache.lucene.codecs.Codec;
    }
        if (withRowId) {
import org.apache.lucene.store.IOContext;
        w.addDocument(doc);
        }
import static org.mockito.Mockito.when;
     * resolution cannot proceed without a Lucene reader, so it throws rather than returning a bogus result.
                    IllegalStateException.class,
        try (Directory dir = new ByteBuffersDirectory()) {
            doc.add(new SortedNumericDocValuesField(DocumentInput.ROW_ID_FIELD, rowId));
            }
import org.apache.lucene.document.StringField;
    }
                addDoc(w, "doc1", 1L, 1L, 1L, 0L, true);
            try (DirectoryReader dr = DirectoryReader.open(dir)) {
                assertEquals(7L, md.version());
                assertEquals(3L, md.primaryTerm());
            }
                assertEquals(DocumentMetadataResolver.UNSET, md.version());
                SegmentInfoFormat delegate = base.segmentInfoFormat();
            try (IndexWriter w = new IndexWriter(dir, iwc(codecWithGeneration("1")))) {
import org.opensearch.index.mapper.VersionFieldMapper;
                w.commit();
