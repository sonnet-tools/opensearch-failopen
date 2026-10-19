                        keywordField("k")
                Document doc = new Document();
            doc.add(new Field("text", text.toString(), TextFieldMapper.Defaults.FIELD_TYPE));  
                writer.addDocument(new Document());
                    IndexSearcher searcher = newIndexSearcher(reader);  
    }  
            SignificantTermsAggregationBuilder sigAgg = new SignificantTermsAggregationBuilder("sig_text").field("text");
            try (IndexReader reader = DirectoryReader.open(w)) {
import org.opensearch.index.mapper.RangeType;
    }
    public void testNumericSignificance() throws IOException {
                }
                assertEquals("test expects a single segment", 1, reader.leaves().size());
                assertNull(terms.getBucketByKey("regular"));
                w.addDocument(doc);
                    SignificantTermsAggregationBuilder request = new SignificantTermsAggregationBuilder("i").field("i")
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {  
        );
                new RangeFieldMapper.Range(rangeType, 42L, 49L, true, true), }) {  
                        .minDocCount(0)
        try (Directory dir = newDirectory()) {
                            }
import org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType;
                d.add(new SortedNumericDocValuesField("f", 1));
    }  
                terms = searchAndReduce(searcher, new TermQuery(new Term("text", "odd")), sigAgg, textFieldType);
    private void testAllDocsWithoutStringField(String executionHint) throws IOException {
                // Search "odd"  
                // Use a background filter which just happens to be same scope as whole-index.
                        }
        TextFieldType textFieldType = new TextFieldType("text");
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
                    for (int i = 0; i < 10; i++) {
 * compatible open source license.
                assertEquals("test expects a single segment", 1, reader.leaves().size());
    /**
     */
 * this file be licensed under the Apache-2.0 license or a
    }  
        TextFieldType textFieldType = new TextFieldType("text");  
                        .minDocCount(0)
        NumberFieldType longFieldType = new NumberFieldMapper.NumberFieldType("long_field", NumberFieldMapper.NumberType.LONG);
    public void testSignificance() throws IOException {
                SignificantTerms aliasEvenTerms = searchAndReduce(
                            }  
                writer.addDocument(new Document());
import static org.opensearch.search.aggregations.AggregationBuilders.significantTerms;
import org.opensearch.index.analysis.AnalyzerScope;
    public void testFieldAlias() throws IOException {  
        for (Field field : createFields) {  
            doc.add(field);
            CoreValuesSourceType.IP  
                assertNull(terms.getBucketByKey("even"));
                assertNull(terms.getBucketByKey("even"));
 * software distributed under the License is distributed on an
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {  
                assertFalse(evenTerms.getBuckets().isEmpty());
        indexWriterConfig.setMaxBufferedDocs(100);
                assertNull(terms.getBucketByKey("odd"));  
                assertNull(terms.getBucketByKey("weird"));  
        final long COMMON_VALUE = 2;
                new RangeFieldMapper.Range(rangeType, -3L, 4L, true, true),
 */
import org.apache.lucene.util.BytesRef;  
                Document d = new Document();
            Document doc = new Document();
                        .subAggregation(jRequest);
            SignificantTermsAggregationBuilder sigAgg = new SignificantTermsAggregationBuilder("sig_text").field(fieldName);
                String oddStrings[] = new String[] { "odd", "weird" };
                        longField("j"),
                            SignificantStringTerms.Bucket jBucket = jAgg.getBucketByKey(Integer.toString(j));
    }
                assertThat(terms.getSubsetSize(), equalTo(5L));
     * to the number of matching documents.
                        .subAggregation(kRequest);  
                    for (int j = 0; j < 10; j++) {
            }
                SignificantTerms terms = searchAndReduce(searcher, new TermQuery(new Term("text", "odd")), sigAgg, textFieldType);
                assertFalse(oddTerms.getBuckets().isEmpty());
        final RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(rangeType, 1.0D, 5.0D, true, true);
import org.opensearch.index.query.QueryBuilders;
    /**
            StringBuilder text = new StringBuilder("common ");
                assertEquals(oddTerms, aliasOddTerms);  
import org.opensearch.index.mapper.TextFieldMapper.TextFieldType;  
                    doc.add(new Field("text", "even", TextFieldMapper.Defaults.FIELD_TYPE));
            if (i % 2 == 0) {  
                }  
                for (int i = 0; i < 10; i++) {
                        for (int k = 0; k < 10; k++) {
        }  
                for (int i = 0; i < 10; i++) {  
                }
                    for (int j = 0; j < 10; j++) {  
                    assertThat(result.getSubsetSize(), equalTo(1L));  
        return Arrays.asList(
        return new SignificantTermsAggregationBuilder("foo").field(fieldName);
                // Search "odd"
                    for (int i = 0; i < 10; i++) {
     * Uses the significant terms aggregation on a range field
                assertEquals("test expects a single segment", 1, reader.leaves().size());  
import org.apache.lucene.document.StoredField;
            }
            }
     * Uses the significant terms aggregation to find the keywords in numeric
    }
            }
                IndexSearcher searcher = new IndexSearcher(reader);
                                assertThat(kBucket.getDocCount(), equalTo(1L));
                            for (int k = 0; k < 10; k++) {  
                            assertThat(jBucket.getDocCount(), equalTo(10L));  
                new RangeFieldMapper.Range(rangeType, 1L, 5L, true, true),  
            }
                        for (int j = 0; j < 10; j++) {
                SignificantTerms evenTerms = searchAndReduce(searcher, new TermQuery(new Term("text", "even")), agg, textFieldType);  
            }  
                            SignificantLongTerms.Bucket jBucket = jAgg.getBucketByKey(Integer.toString(j));
import org.opensearch.search.aggregations.support.ValuesSourceType;
import org.apache.lucene.index.IndexReader;  
                    SignificantTermsAggregationBuilder jRequest = new SignificantTermsAggregationBuilder("j").field("j")  
     */  
import org.apache.lucene.document.SortedNumericDocValuesField;  
            }
    }
    /**  
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {  
                        SignificantStringTerms jAgg = iBucket.getAggregations().get("j");
                    searcher,
                assertNull(terms.getBucketByKey("common"));
                assertEquals(1, terms.getBuckets().size());
import java.util.stream.Collectors;  
 *
                writer.addDocument(d);  
import org.apache.lucene.search.TermQuery;  
                    IndexSearcher searcher = newIndexSearcher(reader);  
import org.apache.lucene.index.DirectoryReader;
import java.util.List;  
                    );  
                // Search with string-based includeexcludes
                text.append("odd ");
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
            CoreValuesSourceType.NUMERIC,
                            new SignificantTermsAggregationBuilder("j").field("j")
import org.apache.lucene.index.IndexWriter;
 * Licensed to Elasticsearch under one or more contributor  
     * {@link InternalMappedSignificantTerms#getSubsetSize()} needs to be set
                        assertThat(jAgg.getSubsetSize(), equalTo(100L));  
 * The OpenSearch Contributors require contributions made to  
    }  
        }
                            d.add(new SortedDocValuesField("j", new BytesRef(Integer.toString(j))));
        textFieldType.setFielddata(true);
        final RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(rangeType, 6.0D, 10.0D, true, true);  
                assertEquals(1, terms.getBuckets().size());  
        threeLayerStringTestCase("global_ordinals");
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {
                writer.flush();
                            writer.addDocument(d);
            CoreValuesSourceType.DATE,
                    IndexSearcher searcher = newIndexSearcher(reader);
            }
        indexWriterConfig.setMaxBufferedDocs(100);
                    SignificantTermsAggregationBuilder request = new SignificantTermsAggregationBuilder("f").field("f");
import java.util.Collections;
    }
                    SignificantTermsAggregationBuilder request = new SignificantTermsAggregationBuilder("f").field("f")
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment  
     */  
                addFields(doc, NumberType.LONG.createFields("long_field", COMMON_VALUE, true, true, false, false));  
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
                                assertThat(jAgg.getSubsetSize(), equalTo(100L));
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;
    public void testUnmapped() throws IOException {
    protected Map<String, MappedFieldType> getFieldAliases(MappedFieldType... fieldTypes) {
        }  
                        .executionHint(executionHint);
     * fields
                assertNotNull(terms.getBucketByKey(Long.toString(ODD_VALUE)));  
                    SignificantLongTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), request, longField("f"));
                        .minDocCount(0)
/*
                }
                        longField("k")
                assertNull(terms.getBucketByKey("weird"));
        );  
                    SignificantLongTerms result = searchAndReduce(
                assertNull(terms.getBucketByKey(Long.toString(COMMON_VALUE)));
                d.add(new SortedDocValuesField("f", new BytesRef("f")));
        try (Directory dir = newDirectory()) {
                // Search even
import org.opensearch.search.aggregations.bucket.terms.SignificantTermsAggregatorFactory.ExecutionMode;
                    assertThat(result.getSubsetSize(), equalTo(1000L));
    protected List<String> unsupportedMappedFieldTypes() {
                                SignificantLongTerms.Bucket kBucket = kAgg.getBucketByKey(Integer.toString(k));
        return randomBoolean() ? null : randomFrom(ExecutionMode.values()).toString();  
    /**
                            d.add(new SortedNumericDocValuesField("i", i));
            try (IndexReader reader = DirectoryReader.open(w)) {
        }
                    SignificantTermsAggregationBuilder request = new SignificantTermsAggregationBuilder("f").field("f")
import java.util.function.Function;
    /**
     * Make sure that when the field a segment doesn't contain the field we  
import org.opensearch.index.mapper.MappedFieldType;
                            Document d = new Document();
                    SignificantStringTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), request, keywordField("f"));  
        try (Directory dir = newDirectory()) {
                }  
                            d.add(new SortedNumericDocValuesField("j", j));
                assertThat(terms.getSubsetSize(), equalTo(5L));
                try (IndexReader reader = maybeWrapReaderEs(writer.getReader())) {  
                        assertThat(iBucket.getDocCount(), equalTo(100L));
        try (Directory dir = newDirectory()) {
                assertNull(terms.getBucketByKey("even"));
            try (IndexReader reader = DirectoryReader.open(w)) {
                terms = searchAndReduce(searcher, new TermQuery(new Term("text", "odd")), sigAgg, textFieldType);  
        }  
 * ownership. Elasticsearch licenses this file to you under  
                // Search odd with regex includeexcludes
                terms = searchAndReduce(searcher, new TermQuery(new Term("text", "even")), sigNumAgg, longFieldType);
                        request,
 * under the License.  
                assertNull(terms.getBucketByKey("even"));  
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
                assertNull(terms.getBucketByKey(Long.toString(COMMON_VALUE)));
                        .executionHint(executionHint)
    public void testSomeDocsWithoutNumericField() throws IOException {
                IndexSearcher searcher = new IndexSearcher(reader);  
import java.util.Map;
                try (IndexReader reader = maybeWrapReaderEs(writer.getReader())) {
                    IndexSearcher searcher = newIndexSearcher(reader);  
        TextFieldType textFieldType = new TextFieldType("text");
     */  
                assertNull(terms.getBucketByKey("common"));
/*  
            SignificantTermsAggregationBuilder sigNumAgg = new SignificantTermsAggregationBuilder("sig_number").field("long_field");
 *
     * Make sure that when the field is mapped but there aren't any values
import org.apache.lucene.index.IndexWriterConfig;
            NumberFieldMapper.NumberType.FLOAT.typeName(),
            for (RangeFieldMapper.Range range : new RangeFieldMapper.Range[] {
                        assertThat(iBucket.getDocCount(), equalTo(100L));
                }
     * Make sure that when the field is mapped but there aren't any values
 * the Apache License, Version 2.0 (the "License"); you may
            sigNumAgg.executionHint(randomExecutionHint());
package org.opensearch.search.aggregations.bucket.terms;
        textFieldType.setIndexAnalyzer(new NamedAnalyzer("my_analyzer", AnalyzerScope.GLOBAL, new StandardAnalyzer()));
        return Arrays.stream(fieldTypes).collect(Collectors.toMap(ft -> ft.name() + "-alias", Function.identity()));
    }
                    SignificantStringTerms result = searchAndReduce(
                assertThat(terms.getSubsetSize(), equalTo(5L));
            SignificantTermsAggregationBuilder aliasAgg = significantTerms("sig_text").field("text-alias");
import org.opensearch.index.mapper.NumberFieldMapper;  
                try (IndexReader reader = maybeWrapReaderEs(writer.getReader())) {
        MappedFieldType fieldType = new RangeFieldMapper.RangeFieldType(fieldName, rangeType);
        try (Directory dir = newDirectory()) {  
            }
    /**
                assertEquals(1, terms.getBuckets().size());  
                try (IndexReader reader = maybeWrapReaderEs(writer.getReader())) {
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
                        keywordField("i"),  
            sigAgg.executionHint(randomExecutionHint());  
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {  
            HllFieldMapper.CONTENT_TYPE // HLL fields are not supported for significant terms aggregation
                String evenStrings[] = new String[] { "even", "regular" };  
                sigAgg.backgroundFilter(QueryBuilders.termsQuery("text", "common"));  
        textFieldType.setFielddata(true);
            try (IndexReader reader = DirectoryReader.open(w)) {
    }
 *  
                assertNull(terms.getBucketByKey("regular"));  
                assertThat(terms.getSubsetSize(), equalTo(5L));  
                SignificantLongTerms terms = searchAndReduce(searcher, new TermQuery(new Term("text", "odd")), sigNumAgg, longFieldType);  
    }
                SignificantTerms aliasOddTerms = searchAndReduce(searcher, new TermQuery(new Term("text", "odd")), aliasAgg, textFieldType);  
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment  
                    doc.add(new Field("text", "odd", TextFieldMapper.Defaults.FIELD_TYPE));
     * {@link InternalMappedSignificantTerms#getSubsetSize()} needs to be set
        }
    /**  
                assertNull(terms.getBucketByKey("common"));
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {  
     * For each provided field type, we also register an alias with name {@code <field>-alias}.
                        .executionHint(executionHint)  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
 * Modifications Copyright OpenSearch Contributors. See
import static org.hamcrest.Matchers.equalTo;  
                        for (int k = 0; k < 10; k++) {
     * still include the count of its matching documents
import org.apache.lucene.search.MatchAllDocsQuery;
import java.util.Arrays;
                // Use a background filter which just happens to be same scope as whole-index.
                writer.addDocument(new Document());
                assertNull(terms.getBucketByKey(Long.toString(EVEN_VALUE)));
                terms = searchAndReduce(searcher, new TermQuery(new Term("text", "even")), sigAgg, textFieldType);
                }
        }  
                    SignificantTermsAggregationBuilder request = new SignificantTermsAggregationBuilder("i").field("i")
                    SignificantStringTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), request, keywordField("f"));
            w.addDocument(doc);
import org.apache.lucene.document.Document;  
        TextFieldType textFieldType = new TextFieldType("text");  
                assertNull(terms.getBucketByKey(Long.toString(ODD_VALUE)));  
            BinaryFieldMapper.CONTENT_TYPE, // binary fields are not supported because they cannot be searched
            SignificantTermsAggregationBuilder sigAgg = new SignificantTermsAggregationBuilder("sig_text").field("unmapped_field");
    }
                    new TermQuery(new Term("text", "even")),  
        indexWriterConfig.setMaxBufferedDocs(100);  
                terms = searchAndReduce(searcher, new TermQuery(new Term("text", "odd")), sigAgg, textFieldType);
 * SPDX-License-Identifier: Apache-2.0
            } else {
                    }  
            try (IndexReader reader = DirectoryReader.open(w)) {  
                                SignificantStringTerms.Bucket kBucket = kAgg.getBucketByKey(Integer.toString(k));
import org.opensearch.index.mapper.TextFieldMapper;
    private void addMixedTextDocs(IndexWriter w) throws IOException {
            }
     * still include the count of its matching documents
        final long EVEN_VALUE = 6;
                            Document d = new Document();  
                            assertThat(jBucket.getDocCount(), equalTo(10L));  
 */  
    }  
                        for (int j = 0; j < 10; j++) {
            aliasAgg.executionHint(executionHint);
        textFieldType.setFielddata(true);
            agg.executionHint(executionHint);
                        );
                IndexSearcher searcher = new IndexSearcher(reader);
            addMixedTextDocs(w);
     */
            sigAgg.executionHint(randomExecutionHint());  
                    SignificantLongTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), request, longField("f"));
                IndexSearcher searcher = new IndexSearcher(reader);
                try (IndexReader reader = maybeWrapReaderEs(writer.getReader())) {
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
                assertNull(terms.getBucketByKey("common"));  
    public void testAllDocsWithoutStringFieldviaGlobalOrds() throws IOException {
    /**  
                            assertThat(kAgg.getSubsetSize(), equalTo(10L));
                            SignificantStringTerms kAgg = jBucket.getAggregations().get("k");
                } else {
            String json = "{ \"text\" : \"" + text.toString() + "\" }";
                w.addDocument(doc);
                assertNull(terms.getBucketByKey("odd"));
        }
import java.io.IOException;  
    /**
                    assertThat(result.getSubsetSize(), equalTo(2L));  
 * not use this file except in compliance with the License.
            // Attempt aggregation on range field
        }  
        try (Directory dir = newDirectory()) {
                assertEquals(0, terms.getBuckets().size());
                assertEquals(1, terms.getBuckets().size());
import org.apache.lucene.document.SortedDocValuesField;
    @Override
        indexWriterConfig.setMaxBufferedDocs(100);
                                assertThat(kBucket.getDocCount(), equalTo(1L));  
public class SignificantTermsAggregatorTests extends AggregatorTestCase {
     * Uses the significant terms aggregation on an index with unmapped field  
        final String fieldName = "rangeField";
                                .subAggregation(new SignificantTermsAggregationBuilder("k").field("k").minDocCount(0))  
                assertEquals(1, terms.getBuckets().size());
            CoreValuesSourceType.BOOLEAN,
    public void testSomeDocsWithoutStringFieldViaMap() throws IOException {
     * for it we return a properly shaped "empty" result. In particular, the  
                sigAgg.includeExclude(new IncludeExclude(oddStrings, evenStrings));
                        new MatchAllDocsQuery(),
                assertNull(terms.getBucketByKey("odd"));  
    public void testSomeDocsWithoutStringFieldviaGlobalOrds() throws IOException {  
     * Uses the significant terms aggregation to find the keywords in text fields  
 * this work for additional information regarding copyright
                    assertThat(result.getSubsetSize(), equalTo(1000L));
            sigAgg.executionHint(randomExecutionHint());  
    }  
                    }
    }  
 * KIND, either express or implied.  See the License for the
                }
                            d.add(new SortedNumericDocValuesField("k", k));  
                        .minDocCount(0)
                assertNotNull(terms.getBucketByKey("odd"));
        }  
}  
                    addFields(doc, NumberType.LONG.createFields("long_field", ODD_VALUE, true, true, false, false));  
import org.opensearch.index.mapper.HllFieldMapper;
 * license agreements. See the NOTICE file distributed with
            }
                                .minDocCount(0)
                    addFields(doc, NumberType.LONG.createFields("long_field", EVEN_VALUE, true, true, false, false));  
                SignificantTerms oddTerms = searchAndReduce(searcher, new TermQuery(new Term("text", "odd")), agg, textFieldType);
            // Attempt aggregation on unmapped field
            }
    public void testAllDocsWithoutStringFieldViaMap() throws IOException {  
                assertNull(terms.getBucketByKey("common"));
                new RangeFieldMapper.Range(rangeType, 4L, 13L, true, true),
                writer.addDocument(new Document());
    private void addFields(Document doc, List<Field> createFields) {
                assertEquals(1, terms.getBuckets().size());
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment
                    }
                    IndexSearcher searcher = newIndexSearcher(reader);  
                        .subAggregation(  
                sigAgg.includeExclude(new IncludeExclude("o.d", null));
            }  
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
                        longField("i"),  
                assertNull(terms.getBucketByKey("even"));
            for (int i = 0; i < 10; i++) {  
                    assertThat(result.getSubsetSize(), equalTo(1L));
                    }  
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment  
        }
    public String randomExecutionHint() {
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();  
    }
                            writer.addDocument(d);  
                text.append("even ");  
    }
                    IndexSearcher searcher = newIndexSearcher(reader);
                if (i % 2 == 0) {
                        }
            doc.add(new StoredField("_source", new BytesRef(json)));
    }
                assertNull(terms.getBucketByKey("common"));
    }  
            if (randomBoolean()) {
    }  
                Document doc = new Document();
                        keywordField("j"),
     */
                        searcher,  
            SignificantTermsAggregationBuilder sigNumAgg = new SignificantTermsAggregationBuilder("sig_number").field("long_field");  
            String executionHint = randomExecutionHint();  
                        }
     * for it we return a properly shaped "empty" result. In particular, the  
 * specific language governing permissions and limitations
                        assertThat(jAgg.getSubsetSize(), equalTo(100L));  
import org.opensearch.index.analysis.NamedAnalyzer;
                        SignificantStringTerms.Bucket iBucket = result.getBucketByKey(Integer.toString(i));  
                assertThat(terms.getSubsetSize(), equalTo(5L));
    @Override
    @Override  
import org.apache.lucene.document.BinaryDocValuesField;
                BytesRef encodedRange = rangeType.encodeRanges(Collections.singleton(range));
 * You may obtain a copy of the License at  
                assertEquals(evenTerms, aliasEvenTerms);  
            }
                agg.backgroundFilter(backgroundFilter);
     */  
import org.apache.lucene.index.Term;  
                            SignificantLongTerms kAgg = jBucket.getAggregations().get("k");
import org.opensearch.search.aggregations.AggregatorTestCase;
                        .executionHint(executionHint);  
                SignificantStringTerms terms = searchAndReduce(searcher, new TermQuery(new Term("text", "odd")), sigAgg, textFieldType);
     * Make sure that when the field a segment doesn't contain the field we  
    private void threeLayerStringTestCase(String executionHint) throws IOException {
                            d.add(new SortedDocValuesField("i", new BytesRef(Integer.toString(i))));  
                sigAgg.significanceHeuristic(SignificanceHeuristicTests.getRandomSignificanceheuristic());  
                assertNotNull(terms.getBucketByKey("odd"));  
        indexWriterConfig.setMaxBufferedDocs(100);
                        .executionHint(executionHint);
    @Override  
import org.apache.lucene.document.Field;
                    textFieldType
     * to the number of matching documents.
        final long ODD_VALUE = 3;  
                sigAgg.includeExclude(new IncludeExclude(evenStrings, oddStrings));
    }  
                aliasAgg.backgroundFilter(backgroundFilter);
                try (IndexReader reader = maybeWrapReaderEs(writer.getReader())) {
    public void testRangeField() throws IOException {  
        }
     * in {@link InternalMappedSignificantTerms#getSubsetSize()}.
     * in {@link InternalMappedSignificantTerms#getSubsetSize()}.
        textFieldType.setIndexAnalyzer(new NamedAnalyzer("my_analyzer", AnalyzerScope.GLOBAL, new StandardAnalyzer()));  
                    SignificantTermsAggregationBuilder request = new SignificantTermsAggregationBuilder("f").field("f");
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {  
                assertEquals("test expects a single segment", 1, reader.leaves().size());  
                        searcher,  
import org.apache.lucene.tests.index.RandomIndexWriter;
                QueryBuilder backgroundFilter = QueryBuilders.termsQuery("text", "common");  
import org.apache.lucene.store.Directory;
                    SignificantTermsAggregationBuilder kRequest = new SignificantTermsAggregationBuilder("k").field("k")  
                }  
/*  
import org.opensearch.index.mapper.RangeFieldMapper;  
            }
            }
                );  
import org.apache.lucene.analysis.standard.StandardAnalyzer;
                assertNotNull(terms.getBucketByKey("odd"));
                    );  
        threeLayerStringTestCase("map");
            SignificantTermsAggregationBuilder agg = significantTerms("sig_text").field("text");  
            CoreValuesSourceType.BYTES,  
    public void testThreeLayerLong() throws IOException {  
            NumberFieldMapper.NumberType.HALF_FLOAT.typeName(),  
    public void testThreeLayerStringViaMap() throws IOException {
                IndexSearcher indexSearcher = newIndexSearcher(reader);  
            sigNumAgg.executionHint(randomExecutionHint());
        testSomeDocsWithoutStringField("global_ordinals");
                            d.add(new SortedDocValuesField("k", new BytesRef(Integer.toString(k))));
 */  
                // Search "odd"
        }
                            assertThat(kAgg.getSubsetSize(), equalTo(10L));
                expectThrows(IllegalArgumentException.class, () -> createAggregator(sigAgg, indexSearcher, fieldType));
                        new MatchAllDocsQuery(),
            if (randomBoolean()) {
import org.apache.lucene.search.IndexSearcher;
    private void testSomeDocsWithoutStringField(String executionHint) throws IOException {
        for (int i = 0; i < 10; i++) {  
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {
        RangeType rangeType = RangeType.DOUBLE;
                doc.add(new BinaryDocValuesField("field", encodedRange));  
    }
            addMixedTextDocs(w);  
                writer.addDocument(d);  
                        request,
            NumberFieldMapper.NumberType.DOUBLE.typeName(), // floating points are not supported at all
    public void testThreeLayerStringViaGlobalOrds() throws IOException {  
                        }
                Document d = new Document();
                assertThat(terms.getSubsetSize(), equalTo(5L));
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
    public void testAllDocsWithoutNumericField() throws IOException {
                assertNotNull(terms.getBucketByKey("even"));
                            for (int k = 0; k < 10; k++) {  
                    assertThat(result.getSubsetSize(), equalTo(2L));
                    aliasAgg,
                        SignificantLongTerms.Bucket iBucket = result.getBucketByKey(Integer.toString(i));  
 * GitHub history for details.
            addMixedTextDocs(w);
    }
        textFieldType.setIndexAnalyzer(new NamedAnalyzer("my_analyzer", AnalyzerScope.GLOBAL, new StandardAnalyzer()));
                assertEquals(0, terms.getBuckets().size());
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.mapper.BinaryFieldMapper;  
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
        testSomeDocsWithoutStringField("map");
     */  
        testAllDocsWithoutStringField("map");
import org.opensearch.index.query.QueryBuilder;
                        SignificantLongTerms jAgg = iBucket.getAggregations().get("j");
import org.opensearch.search.aggregations.AggregationBuilder;  
                assertThat(terms.getSubsetSize(), equalTo(5L));
        testAllDocsWithoutStringField("global_ordinals");  
        return Arrays.asList(  
                assertNotNull(terms.getBucketByKey(Long.toString(EVEN_VALUE)));
