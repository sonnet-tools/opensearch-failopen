        try (IndexWriter writer = new IndexWriter(dir, iwc)) {  
                count++;
        for (SegmentCommitInfo segmentCommitInfo : segmentInfos) {
            assertNull("Terms should be null for empty index", terms);
        Codec nullBucketCodec = TestUtil.alwaysPostingsFormat(new CriteriaBasedPostingsFormat(TestUtil.getDefaultPostingsFormat(), null));
        IndexWriterConfig iwc = new IndexWriterConfig(new StandardAnalyzer());  
            assertEquals(0, reader.numDocs());  
        for (SegmentCommitInfo segmentCommitInfo : segmentInfos) {
            Terms terms = MultiTerms.getTerms(reader, "_id");
        }  
                writer.addDocument(doc);
            String bucketValue = segmentCommitInfo.info.getAttribute(CriteriaBasedPostingsFormat.BUCKET_NAME);  
package org.opensearch.index.codec;
        IndexWriterConfig iwc = new IndexWriterConfig(new StandardAnalyzer());
        try (IndexReader reader = DirectoryReader.open(dir)) {
            writer.addDocument(doc);
import org.apache.lucene.document.TextField;  
import org.apache.lucene.index.SegmentInfos;
 * The OpenSearch Contributors require contributions made to  
            int count = 0;
        return criteriaBasedPostingFormat;
        try (IndexReader reader = DirectoryReader.open(dir)) {  
    public void testBasicFunctionality() throws IOException {
            assertNotNull(terms);
                doc.add(new StringField("_id", "doc" + i, Field.Store.YES));  
            assertEquals(100, reader.numDocs());
    private Codec criteriaBasedPostingFormat = TestUtil.alwaysPostingsFormat(  
        new CriteriaBasedPostingsFormat(TestUtil.getDefaultPostingsFormat(), TEST_BUCKET)
    }  
        iwc.setCodec(criteriaBasedPostingFormat);
            Document doc = new Document();
import org.apache.lucene.index.TermsEnum;  
 *
    private static final String TEST_BUCKET = "test_bucket";
            Terms terms = MultiTerms.getTerms(reader, "field");  
import org.apache.lucene.index.IndexWriter;  
            // Don't add any documents
        iwc.setCodec(criteriaBasedPostingFormat);
        }
            doc.add(new StringField("_id", "doc1", Field.Store.YES));  
        try (IndexWriter writer = new IndexWriter(dir, iwc)) {  
            assertEquals(100, count);
        Directory dir = new ByteBuffersDirectory();  
            writer.addDocument(doc);
}
            while ((term = termsEnum.next()) != null) {  
    }  
                doc.add(new TextField("field", "value" + i, Field.Store.YES));
import org.apache.lucene.store.ByteBuffersDirectory;
import org.apache.lucene.tests.util.TestUtil;
import org.apache.lucene.index.Terms;
                assertTrue(term.utf8ToString().startsWith("value"));
            assertEquals("Placeholder bucket should be set for null bucket", "-2", bucketValue);
            }  
            for (int i = 0; i < 100; i++) {
        }  
import org.apache.lucene.codecs.Codec;
    }  
            doc.add(new TextField("content", "test content", Field.Store.YES));
        Directory dir = new ByteBuffersDirectory();  
    public void testBucketAttributeIsSetOnSegment() throws IOException {
            doc.add(new StringField("_id", "doc1", Field.Store.YES));
        Directory dir = new ByteBuffersDirectory();
        iwc.setCodec(nullBucketCodec);
        SegmentInfos segmentInfos = SegmentInfos.readLatestCommit(dir);
        }
public class CriteriaBasedPostingsFormatTests extends BasePostingsFormatTestCase {  
/*  
    }
        try (IndexWriter writer = new IndexWriter(dir, iwc)) {
        SegmentInfos segmentInfos = SegmentInfos.readLatestCommit(dir);
 * SPDX-License-Identifier: Apache-2.0
            BytesRef term;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;  
        }
        }
    );
            TermsEnum termsEnum = terms.iterator();
        }  
 * compatible open source license.
        }
import org.apache.lucene.index.MultiTerms;
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.tests.index.BasePostingsFormatTestCase;  
        Directory dir = new ByteBuffersDirectory();  
            }  
import org.apache.lucene.index.IndexReader;
        iwc.setCodec(criteriaBasedPostingFormat);
import java.io.IOException;
            assertEquals("Bucket attribute should be set", TEST_BUCKET, bucketValue);
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.index.SegmentCommitInfo;  
import org.apache.lucene.index.DirectoryReader;
        IndexWriterConfig iwc = new IndexWriterConfig(new StandardAnalyzer());
        try (IndexWriter writer = new IndexWriter(dir, iwc)) {
            String bucketValue = segmentCommitInfo.info.getAttribute(CriteriaBasedPostingsFormat.BUCKET_NAME);  
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
                Document doc = new Document();
    public void testEmptyIndex() throws IOException {
import org.apache.lucene.store.Directory;
    public void testNullBucketSetsPlaceholder() throws IOException {
    }  
        IndexWriterConfig iwc = new IndexWriterConfig(new StandardAnalyzer());  
            doc.add(new TextField("content", "test content", Field.Store.YES));  
            Document doc = new Document();
    protected Codec getCodec() {
    @Override  
        assertFalse("Should have at least one segment", segmentInfos.asList().isEmpty());  
import org.apache.lucene.index.IndexWriterConfig;
 */  
