    }  
                addDoc(w, "doc1", 1L, 1L, 1L, 0L, false); // no __row_id__ doc values  
import org.apache.lucene.document.Field;
                addDoc(w, "doc1", 1L, 1L, 1L, 0L, true);  
                    IllegalStateException.class,
            try (IndexWriter w = new IndexWriter(dir, iwc(codecWithGeneration("1")))) {
                assertNotNull(md);  
            }
            try (DirectoryReader dr = DirectoryReader.open(dir)) {
                assertTrue(e.getMessage().contains("writer_generation"));
import org.apache.lucene.index.IndexWriter;  
import org.apache.lucene.index.DirectoryReader;
public class LuceneDocumentResolverTests extends OpenSearchTestCase {  
/*  
    private final LuceneDocumentResolver resolver = new LuceneDocumentResolver();
import org.opensearch.index.mapper.IdFieldMapper;
            try (DirectoryReader dr = DirectoryReader.open(dir)) {
    /**  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.store.Directory;
import static org.mockito.Mockito.mock;  
        doc.add(new LongPoint(SeqNoFieldMapper.NAME, seqNo));                            // for LongPoint range scan
                        info.putAttribute("writer_generation", gen);  
import org.apache.lucene.index.SegmentInfo;
        IndexReaderProvider.Reader reader = mock(IndexReaderProvider.Reader.class);  
                doc.add(new SortedNumericDocValuesField(DocumentInput.ROW_ID_FIELD, 9L));
                assertEquals(DocumentMetadataResolver.UNSET, md.version());
            public SegmentInfoFormat segmentInfoFormat() {
                assertEquals(9L, md.rowId());
                DocumentMetadata md = resolver.resolveMetadata(readerReturning(dr), "doc1");  
                IllegalStateException e = expectThrows(  
        try (Directory dir = new ByteBuffersDirectory()) {
                addDoc(w, "other", 1L, 1L, 1L, 0L, true);  
import org.apache.lucene.document.StoredField;  
                assertFalse(md.hasVersionMetadata());  
     */  
        try (Directory dir = new ByteBuffersDirectory()) {  
                return new SegmentInfoFormat() {
                SegmentInfoFormat delegate = base.segmentInfoFormat();  
                DocumentMetadata md = resolver.resolveMetadata(readerReturning(dr), "doc1");
                };  
            }
    }
        try (Directory dir = new ByteBuffersDirectory()) {  
            }
import org.opensearch.index.engine.exec.DocumentMetadataResolver;
     * When the index has no Lucene secondary reader, {@code directoryReader(reader)} fails fast:
                );  
import org.apache.lucene.codecs.Codec;
                        return delegate.read(d, name, id, ctx);
                Document doc = new Document();
                assertEquals(9L, md.rowId());
                doc.add(new StoredField(IdFieldMapper.NAME, Uid.encodeId("doc1")));  
                    }
            try (IndexWriter w = new IndexWriter(dir, new IndexWriterConfig())) {  
            try (DirectoryReader dr = DirectoryReader.open(dir)) {
import static org.mockito.ArgumentMatchers.eq;
import org.apache.lucene.document.LongPoint;  
     */  
            try (IndexWriter w = new IndexWriter(dir, iwc(codecWithGeneration("5")))) {
        try (Directory dir = new ByteBuffersDirectory()) {
        when(reader.getReader(any(DataFormat.class), eq(LuceneReader.class))).thenReturn(new LuceneReader(dr, java.util.Map.of()));
                doc.add(new StringField(IdFieldMapper.NAME, Uid.encodeId("doc1"), Field.Store.NO));
        return new FilterCodec(base.getName(), base) {  
        }  
import org.apache.lucene.codecs.FilterCodec;
                    }
    /**  
                assertEquals(5L, md.writerGeneration());  
            try (IndexWriter w = new IndexWriter(dir, new IndexWriterConfig())) {
                    () -> resolver.resolveMetadata(readerReturning(dr), "doc1")
                assertNull(resolver.resolveMetadata(readerReturning(dr), "doc1"));
import org.apache.lucene.store.IOContext;
        doc.add(new NumericDocValuesField(VersionFieldMapper.NAME, version));
            try (IndexWriter w = new IndexWriter(dir, iwc(codecWithGeneration("5")))) {  
    // --- helpers ---  
                assertTrue(md.hasVersionMetadata());
import static org.mockito.Mockito.when;
import org.apache.lucene.index.IndexWriterConfig;
    public void testResolveMetadata_withoutVersionDocValues_reportsUnset() throws IOException {
        if (withRowId) {
        IndexWriterConfig c = new IndexWriterConfig();  
 * compatible open source license.
                    @Override
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.PRIMARY_TERM_NAME, primaryTerm));
            }
                assertNotNull(md);
                assertNull(resolver.resolveMetadata(readerReturning(dr), "missing"));  
     * A segment written before version doc values existed still resolves its row location; the version
                assertTrue(e.getMessage().contains(DocumentInput.ROW_ID_FIELD));
        w.commit();  
        return reader;
    }
    }  
            }
     * fields report {@code UNSET} so the caller falls back to reading the primary store.
    }
 * this file be licensed under the Apache-2.0 license or a
                    public void write(Directory d, SegmentInfo info, IOContext ctx) throws IOException {
                    IllegalStateException.class,
import org.apache.lucene.document.StringField;
        throws IOException {  
import org.apache.lucene.store.ByteBuffersDirectory;  
            }
            }
 */  
            }
                    public SegmentInfo read(Directory d, String name, byte[] id, IOContext ctx) throws IOException {  
                w.commit();  
        }
    private static Codec codecWithGeneration(String gen) {
        w.addDocument(doc);
    public void testResolveMetadata_missingWriterGeneration_throwsISE() throws IOException {
            // default codec → no writer_generation segment attribute
                    () -> resolver.resolveMetadata(readerReturning(dr), "doc1")
        }
import org.opensearch.index.engine.dataformat.DocumentInput;
import org.opensearch.index.mapper.Uid;
import org.apache.lucene.codecs.SegmentInfoFormat;  
                IllegalStateException e = expectThrows(  
        doc.add(new StoredField(IdFieldMapper.NAME, Uid.encodeId(id)));                  // for decodeId (restore path)  
    // --- resolveMetadata ---
import org.apache.lucene.document.Document;
}
                assertEquals(7L, md.version());
import org.opensearch.test.OpenSearchTestCase;  
    public void testResolveMetadata_found_returnsMetadata() throws IOException {
                assertEquals("doc1", md.id());
        return c;
    }  
        }
        }  
                );  
                w.addDocument(doc);
import java.io.IOException;
                assertEquals(DocumentMetadataResolver.UNSET, md.seqNo());
import org.apache.lucene.document.SortedNumericDocValuesField;
            }
        try (Directory dir = new ByteBuffersDirectory()) {
            try (DirectoryReader dr = DirectoryReader.open(dir)) {  
package org.opensearch.be.lucene;
    }
            }  
    public void testResolveMetadata_emptyReader_returnsNull() throws IOException {
import org.opensearch.index.mapper.SeqNoFieldMapper;  
     * resolution cannot proceed without a Lucene reader, so it throws rather than returning a bogus result.
        doc.add(new StringField(IdFieldMapper.NAME, Uid.encodeId(id), Field.Store.NO)); // for _id TermQuery
                assertEquals(3L, md.primaryTerm());
            }
            @Override
                        delegate.write(d, info, ctx);
                w.commit();
        Document doc = new Document();
            try (DirectoryReader dr = DirectoryReader.open(dir)) {
        Codec base = Codec.getDefault();
import org.opensearch.index.engine.dataformat.DataFormat;  
            }
    public void testResolveMetadata_missingRowIdDocValues_throwsISE() throws IOException {  
        }  
    private static IndexReaderProvider.Reader readerReturning(DirectoryReader dr) {
                assertEquals(42L, md.seqNo());  
    private static IndexWriterConfig iwc(Codec codec) {
 *
 * SPDX-License-Identifier: Apache-2.0
                addDoc(w, "doc1", 7L, 42L, 3L, 9L, true);
        doc.add(new NumericDocValuesField(SeqNoFieldMapper.NAME, seqNo));  
    }  
        };
        c.setCodec(codec);
    /** Codec that stamps a {@code writer_generation} segment attribute, mirroring the production writer. */  
        try (Directory dir = new ByteBuffersDirectory()) {
import org.opensearch.index.mapper.VersionFieldMapper;
        }  
            }
                assertEquals(DocumentMetadataResolver.UNSET, md.primaryTerm());  
            try (IndexWriter w = new IndexWriter(dir, iwc(codecWithGeneration("1")))) {
    }
    }  
import org.apache.lucene.document.NumericDocValuesField;
                    @Override
import org.opensearch.index.engine.exec.IndexReaderProvider;
import org.opensearch.index.engine.exec.DocumentMetadataResolver.DocumentMetadata;  
            try (DirectoryReader dr = DirectoryReader.open(dir)) {
            doc.add(new SortedNumericDocValuesField(DocumentInput.ROW_ID_FIELD, rowId));  
    public void testResolveMetadata_idNotPresent_returnsNull() throws IOException {  
    private static void addDoc(IndexWriter w, String id, long version, long seqNo, long primaryTerm, long rowId, boolean withRowId)
import static org.mockito.ArgumentMatchers.any;
