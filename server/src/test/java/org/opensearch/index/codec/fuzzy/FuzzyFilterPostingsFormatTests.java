                Document doc = new Document();
            int idCount = 0;
            Document doc = new Document();  
import org.apache.lucene.document.IntPoint;
                Document doc = new Document();
        Directory dir = new ByteBuffersDirectory();
                writer.addDocument(doc);  
                count++;
                assertFalse(
                assertNull("Should not have terms for " + fieldName, terms);  
        Directory dir = new ByteBuffersDirectory();
                Terms terms = MultiTerms.getTerms(reader, fieldName);
 */  
        Directory dir = new ByteBuffersDirectory();
            textTermsEnum = textTerms.iterator();  
import org.apache.lucene.index.MultiTerms;  
            assertEquals("ID field should have 100 unique terms", 100, idCount);  
                return "2025-10-16";
        try (IndexReader reader = DirectoryReader.open(dir)) {  
        }
import org.apache.lucene.document.DoublePoint;
            while (termsEnum.next() != null) {  
        }  
                doc.add(new TextField("text_field", "value" + i, Field.Store.YES));
            for (int i = 0; i < 100; i++) {
                doc.add(new StringField("id_field", "ID_" + i, Field.Store.YES));  
    public void testFuzzyFilterWithDifferentFieldTypes() throws IOException {
            writer.addDocument(doc);  
        try (IndexWriter writer = new IndexWriter(dir, iwc)) {
                Document doc = new Document();
                TermsEnum termsEnum = terms.iterator();  
                if (termsEnum.seekExact(new BytesRef("unique" + i))) {  
            doc.add(new StringField("keyword_field", "exact_match", Field.Store.YES));  
        iwc.setCodec(fuzzyFilterCodec);
        }
            assertEquals(100, reader.numDocs());
            idTermsEnum = idTerms.iterator();
            case "long_field":  
                return "text";
        IndexWriterConfig iwc = new IndexWriterConfig(new StandardAnalyzer());
        }
        }
        try (IndexWriter writer = new IndexWriter(dir, iwc)) {
            doc.add(new DoublePoint("double_field", 42.0));
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.tests.util.LuceneTestCase;  
    }
import org.apache.lucene.index.Terms;
            double falsePositiveRate = (double) falsePositives / 1000;
 * this file be licensed under the Apache-2.0 license or a
            Terms terms = MultiTerms.getTerms(reader, "field");
        iwc.setCodec(fuzzyFilterCodec);
        iwc.setCodec(fuzzyFilterCodec);
            assertEquals(100, count);  
import org.apache.lucene.store.ByteBuffersDirectory;  
            assertEquals(numTerms, reader.numDocs());
                writer.addDocument(doc);  
            Terms idTerms = MultiTerms.getTerms(reader, "id_field");
            assertNotNull("Terms should exist for id_field", idTerms);  
import org.apache.lucene.tests.index.BasePostingsFormatTestCase;
        return fuzzyFilterCodec;
        IndexWriterConfig iwc = new IndexWriterConfig(new StandardAnalyzer());  
            }
            case "keyword_field":
                return "doc1";
            BytesRef term;  
        }
            }
                    termsEnum.seekExact(new BytesRef("nonexistent_" + fieldName))
            case "int_field":
                return "binary_data";
                }
            while (idTermsEnum.next() != null) {  
    @Override  
 * compatible open source license.
        public FuzzySetParameters get(Object k) {  
            assertTrue("False positive rate too high: " + falsePositiveRate, falsePositiveRate < 0.05);
 * SPDX-License-Identifier: Apache-2.0
            }
            doc.add(new BinaryDocValuesField("binary_field", new BytesRef("binary_data")));
    private Codec fuzzyFilterCodec = TestUtil.alwaysPostingsFormat(
    public void testLargeNumberOfTerms() throws IOException {  
        }  
    }
                return "exact_match";  
        try (IndexWriter writer = new IndexWriter(dir, iwc)) {  
        try (IndexReader reader = DirectoryReader.open(dir)) {  
            doc.add(new TextField("text_field", "some analyzed text", Field.Store.YES));
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.document.Document;
import org.apache.lucene.codecs.Codec;
            }
            assertFalse("Should not find non-existent text", textTermsEnum.seekExact(new BytesRef("valuenonexistent")));
            TermsEnum textTermsEnum = textTerms.iterator();  
            assertTrue("Should find existing text", textTermsEnum.seekExact(new BytesRef("value50")));
            assertEquals("Text field should have 100 unique terms", 100, textCount);
            }  
                Terms terms = MultiTerms.getTerms(reader, fieldName);
            return new FuzzySetParameters(() -> FuzzySetParameters.DEFAULT_FALSE_POSITIVE_PROBABILITY);
    };  
            assertFalse("Should not find non-existent ID", idTermsEnum.seekExact(new BytesRef("ID_nonexistent")));  
    }
import org.apache.lucene.index.IndexReader;  
                assertNotNull("Should have terms for " + fieldName, terms);
        int numTerms = 100000;
import org.apache.lucene.document.TextField;
            }  
    public void testBloomFilterFunctionality() throws IOException {
            case "binary_field":  
            for (String fieldName : Arrays.asList("int_field", "long_field", "double_field", "binary_field")) {
                return "";  
            }
            for (int i = 0; i < 100; i++) {
import org.apache.lucene.tests.util.TestUtil;
        Directory dir = new ByteBuffersDirectory();
                writer.addDocument(doc);
            TermsEnum termsEnum = terms.iterator();
        try (IndexWriter writer = new IndexWriter(dir, iwc)) {
    private String getTestValueForField(String fieldName) {
            assertNotNull("Terms should exist for text_field", textTerms);
                assertFalse("Should not find non-existent term", termsEnum.seekExact(new BytesRef("value" + i)));
                doc.add(new TextField("field", "value" + i, Field.Store.YES));
    }
            int count = 0;
                doc.add(new TextField("field", "unique" + i, Field.Store.NO));
            for (int i = 0; i < 1000; i++) {  
            TermsEnum idTermsEnum = idTerms.iterator();
        try (IndexReader reader = DirectoryReader.open(dir)) {  
    public void testIDandTextFields() throws IOException {
import org.apache.lucene.document.Field;  
            while (textTermsEnum.next() != null) {
    public void testBasicFunctionality() throws IOException {
import org.apache.lucene.index.IndexWriter;
            case "_id":
        IndexWriterConfig iwc = new IndexWriterConfig(new StandardAnalyzer());  
    private TreeMap<String, FuzzySetParameters> params = new TreeMap<>() {
            }
            doc.add(new LongPoint("long_field", 42L));  
import org.apache.lucene.index.DirectoryReader;
        }  
                doc.add(new TextField("field", "value" + i, Field.Store.YES));  
            int falsePositives = 0;
            for (int i = 1000; i < 2000; i++) {
public class FuzzyFilterPostingsFormatTests extends BasePostingsFormatTestCase {  
            for (int i = 0; i < numTerms; i++) {  
    protected Codec getCodec() {
        }
            case "text_field":  
                assertTrue(term.utf8ToString().startsWith("value"));  
    );
package org.opensearch.index.codec.fuzzy;
                textCount++;  
            TermsEnum termsEnum = terms.iterator();  
        iwc.setCodec(fuzzyFilterCodec);  
        @Override
                    falsePositives++;
import java.util.TreeMap;  
            assertTrue("Should find existing ID", idTermsEnum.seekExact(new BytesRef("ID_50")));
            assertEquals(numTerms, count);  
        new FuzzyFilterPostingsFormat(TestUtil.getDefaultPostingsFormat(), new FuzzySetFactory(params))  
            for (String fieldName : Arrays.asList("_id", "text_field", "keyword_field", "date_field")) {  
import org.apache.lucene.util.BytesRef;
            TermsEnum termsEnum = terms.iterator();
                count++;
        try (IndexReader reader = DirectoryReader.open(dir)) {
                    "Should not find non-existent term in " + fieldName,  
        }
 *
import org.apache.lucene.store.Directory;
                assertTrue("Should find existing term", termsEnum.seekExact(new BytesRef("value" + i)));
                idCount++;
        }
import org.apache.lucene.index.IndexWriterConfig;
            while ((term = termsEnum.next()) != null) {
        try (IndexWriter writer = new IndexWriter(dir, iwc)) {  
            Terms terms = MultiTerms.getTerms(reader, "field");
            }
            assertEquals(100, reader.numDocs());
                );
                return "42";
            int textCount = 0;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
    }
        IndexWriterConfig iwc = new IndexWriterConfig(new StandardAnalyzer());  
            }
            doc.add(new StringField("date_field", "2025-10-16", Field.Store.YES));
@LuceneTestCase.SuppressSysoutChecks(bugUrl = "")
            int count = 0;
        Directory dir = new ByteBuffersDirectory();  
                Document doc = new Document();
            doc.add(new StringField("_id", "doc1", Field.Store.YES));
            Terms textTerms = MultiTerms.getTerms(reader, "text_field");
import org.apache.lucene.document.BinaryDocValuesField;  
            }
            case "double_field":
}
        iwc.setCodec(fuzzyFilterCodec);
            Terms terms = MultiTerms.getTerms(reader, "field");  
                return "42";
        try (IndexReader reader = DirectoryReader.open(dir)) {
/*  
            }  
        IndexWriterConfig iwc = new IndexWriterConfig(new StandardAnalyzer());
                assertTrue("Should find existing term in " + fieldName, termsEnum.seekExact(new BytesRef(getTestValueForField(fieldName))));
import org.apache.lucene.document.StringField;  
import org.apache.lucene.document.LongPoint;
            }  
                return "42.0";  
import java.io.IOException;
    }  
        switch (fieldName) {  
            case "date_field":
    }  
        }
            for (int i = numTerms; i < numTerms + 1000; i++) {
            default:
            for (int i = 0; i < 1000; i++) {  
                writer.addDocument(doc);
import java.util.Arrays;
            doc.add(new IntPoint("int_field", 42));
