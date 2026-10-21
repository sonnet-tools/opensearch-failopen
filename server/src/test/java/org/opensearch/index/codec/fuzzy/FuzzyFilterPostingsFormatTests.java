        @Override
                    falsePositives++;
            for (int i = 0; i < 1000; i++) {
import org.apache.lucene.tests.util.LuceneTestCase;
            for (int i = 0; i < 100; i++) {
 * compatible open source license.
        IndexWriterConfig iwc = new IndexWriterConfig(new StandardAnalyzer());
        try (IndexReader reader = DirectoryReader.open(dir)) {
                idCount++;
        }
                Document doc = new Document();
            assertNotNull("Terms should exist for id_field", idTerms);
                assertNotNull("Should have terms for " + fieldName, terms);
                doc.add(new TextField("field", "value" + i, Field.Store.YES));
                Terms terms = MultiTerms.getTerms(reader, fieldName);
        }
import org.apache.lucene.index.DirectoryReader;
            doc.add(new DoublePoint("double_field", 42.0));
        int numTerms = 100000;
            assertEquals(100, count);
            Terms terms = MultiTerms.getTerms(reader, "field");
            BytesRef term;
            TermsEnum idTermsEnum = idTerms.iterator();
                Document doc = new Document();
 */
                assertTrue("Should find existing term", termsEnum.seekExact(new BytesRef("value" + i)));
        Directory dir = new ByteBuffersDirectory();
            }
            doc.add(new TextField("text_field", "some analyzed text", Field.Store.YES));
        new FuzzyFilterPostingsFormat(TestUtil.getDefaultPostingsFormat(), new FuzzySetFactory(params))
            for (int i = 0; i < numTerms; i++) {
        }
                return "text";
        iwc.setCodec(fuzzyFilterCodec);
            idTermsEnum = idTerms.iterator();
            doc.add(new StringField("_id", "doc1", Field.Store.YES));
import org.apache.lucene.document.LongPoint;
public class FuzzyFilterPostingsFormatTests extends BasePostingsFormatTestCase {
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(100, reader.numDocs());
            }
import org.apache.lucene.codecs.Codec;
                return "42.0";
    private TreeMap<String, FuzzySetParameters> params = new TreeMap<>() {
                writer.addDocument(doc);
        try (IndexWriter writer = new IndexWriter(dir, iwc)) {
import org.apache.lucene.store.Directory;
            assertNotNull("Terms should exist for text_field", textTerms);
        }
        }
            case "_id":
            int idCount = 0;
        try (IndexReader reader = DirectoryReader.open(dir)) {
    }
                );
        iwc.setCodec(fuzzyFilterCodec);
            }
            }
            writer.addDocument(doc);
                return "exact_match";
                    "Should not find non-existent term in " + fieldName,
                doc.add(new TextField("field", "unique" + i, Field.Store.NO));
import java.io.IOException;
            default:
import org.apache.lucene.document.StringField;
        try (IndexReader reader = DirectoryReader.open(dir)) {
import org.apache.lucene.store.ByteBuffersDirectory;
            assertFalse("Should not find non-existent ID", idTermsEnum.seekExact(new BytesRef("ID_nonexistent")));
        try (IndexWriter writer = new IndexWriter(dir, iwc)) {
                return "42";
        try (IndexReader reader = DirectoryReader.open(dir)) {
            while (termsEnum.next() != null) {
            Document doc = new Document();
                return "binary_data";
    public void testFuzzyFilterWithDifferentFieldTypes() throws IOException {
            assertFalse("Should not find non-existent text", textTermsEnum.seekExact(new BytesRef("valuenonexistent")));
package org.opensearch.index.codec.fuzzy;
    }
            Terms terms = MultiTerms.getTerms(reader, "field");
            assertEquals("ID field should have 100 unique terms", 100, idCount);
    public void testLargeNumberOfTerms() throws IOException {
        iwc.setCodec(fuzzyFilterCodec);
        Directory dir = new ByteBuffersDirectory();
}
            case "keyword_field":
    }
            doc.add(new BinaryDocValuesField("binary_field", new BytesRef("binary_data")));
    @Override
            TermsEnum termsEnum = terms.iterator();
                writer.addDocument(doc);
/*
                doc.add(new TextField("text_field", "value" + i, Field.Store.YES));
    protected Codec getCodec() {
        }
            int textCount = 0;
import org.apache.lucene.tests.index.BasePostingsFormatTestCase;
            for (String fieldName : Arrays.asList("_id", "text_field", "keyword_field", "date_field")) {
        try (IndexReader reader = DirectoryReader.open(dir)) {
                assertFalse(
                assertFalse("Should not find non-existent term", termsEnum.seekExact(new BytesRef("value" + i)));
            assertTrue("Should find existing text", textTermsEnum.seekExact(new BytesRef("value50")));
            doc.add(new StringField("date_field", "2025-10-16", Field.Store.YES));
import org.apache.lucene.index.IndexWriter;
            }
    private String getTestValueForField(String fieldName) {
            while ((term = termsEnum.next()) != null) {
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Field;
            while (idTermsEnum.next() != null) {
            return new FuzzySetParameters(() -> FuzzySetParameters.DEFAULT_FALSE_POSITIVE_PROBABILITY);
        iwc.setCodec(fuzzyFilterCodec);
            assertTrue("False positive rate too high: " + falsePositiveRate, falsePositiveRate < 0.05);
            }
    public void testIDandTextFields() throws IOException {
                writer.addDocument(doc);
        Directory dir = new ByteBuffersDirectory();
        IndexWriterConfig iwc = new IndexWriterConfig(new StandardAnalyzer());
            while (textTermsEnum.next() != null) {
                doc.add(new StringField("id_field", "ID_" + i, Field.Store.YES));
                assertTrue("Should find existing term in " + fieldName, termsEnum.seekExact(new BytesRef(getTestValueForField(fieldName))));
            }
import org.apache.lucene.index.Terms;
 *
    }
            TermsEnum textTermsEnum = textTerms.iterator();
                return "";
import org.apache.lucene.util.BytesRef;
        }
            Terms textTerms = MultiTerms.getTerms(reader, "text_field");
                Document doc = new Document();
                assertNull("Should not have terms for " + fieldName, terms);
        try (IndexWriter writer = new IndexWriter(dir, iwc)) {
            Terms terms = MultiTerms.getTerms(reader, "field");
    );
        Directory dir = new ByteBuffersDirectory();
import org.apache.lucene.document.DoublePoint;
        return fuzzyFilterCodec;
            int falsePositives = 0;
        IndexWriterConfig iwc = new IndexWriterConfig(new StandardAnalyzer());
            assertTrue("Should find existing ID", idTermsEnum.seekExact(new BytesRef("ID_50")));
        }
            doc.add(new LongPoint("long_field", 42L));
    };
            case "double_field":
        }
            Terms idTerms = MultiTerms.getTerms(reader, "id_field");
            for (int i = numTerms; i < numTerms + 1000; i++) {
            doc.add(new IntPoint("int_field", 42));
        Directory dir = new ByteBuffersDirectory();
        public FuzzySetParameters get(Object k) {
                Document doc = new Document();
            for (int i = 1000; i < 2000; i++) {
        switch (fieldName) {
import org.apache.lucene.document.IntPoint;
                assertTrue(term.utf8ToString().startsWith("value"));
            int count = 0;
 * The OpenSearch Contributors require contributions made to
                }
                count++;
            case "text_field":
        }
        }
import org.apache.lucene.tests.util.TestUtil;
            TermsEnum termsEnum = terms.iterator();
import org.apache.lucene.index.IndexWriterConfig;
                textCount++;
import org.apache.lucene.document.Document;
    }
            for (int i = 0; i < 100; i++) {
            for (String fieldName : Arrays.asList("int_field", "long_field", "double_field", "binary_field")) {
            for (int i = 0; i < 1000; i++) {
                doc.add(new TextField("field", "value" + i, Field.Store.YES));
        IndexWriterConfig iwc = new IndexWriterConfig(new StandardAnalyzer());
import java.util.TreeMap;
@LuceneTestCase.SuppressSysoutChecks(bugUrl = "")
            case "long_field":
                if (termsEnum.seekExact(new BytesRef("unique" + i))) {
            }
            int count = 0;
            assertEquals(numTerms, count);
                writer.addDocument(doc);
    public void testBasicFunctionality() throws IOException {
                return "2025-10-16";
            assertEquals("Text field should have 100 unique terms", 100, textCount);
            doc.add(new StringField("keyword_field", "exact_match", Field.Store.YES));
            }
                count++;
import org.apache.lucene.document.BinaryDocValuesField;
    private Codec fuzzyFilterCodec = TestUtil.alwaysPostingsFormat(
import java.util.Arrays;
        iwc.setCodec(fuzzyFilterCodec);
            TermsEnum termsEnum = terms.iterator();
import org.apache.lucene.document.TextField;
            assertEquals(numTerms, reader.numDocs());
                return "doc1";
        IndexWriterConfig iwc = new IndexWriterConfig(new StandardAnalyzer());
            case "date_field":
import org.apache.lucene.index.MultiTerms;
            }
 * SPDX-License-Identifier: Apache-2.0
            }
import org.apache.lucene.index.TermsEnum;
    }
        }
        try (IndexWriter writer = new IndexWriter(dir, iwc)) {
            case "int_field":
                TermsEnum termsEnum = terms.iterator();
            }
            assertEquals(100, reader.numDocs());
            }
                return "42";
        try (IndexWriter writer = new IndexWriter(dir, iwc)) {
            case "binary_field":
            double falsePositiveRate = (double) falsePositives / 1000;
import org.apache.lucene.index.IndexReader;
    }
    public void testBloomFilterFunctionality() throws IOException {
            textTermsEnum = textTerms.iterator();
                Terms terms = MultiTerms.getTerms(reader, fieldName);
                    termsEnum.seekExact(new BytesRef("nonexistent_" + fieldName))
