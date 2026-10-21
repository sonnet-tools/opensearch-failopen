        }
                try (IndexReader reader = maybeWrapReaderEs(writer.getReader())) {
                assertNotNull(terms.getBucketByKey(Long.toString(EVEN_VALUE)));
        try (Directory dir = newDirectory()) {
                assertNull(terms.getBucketByKey("common"));
 *    http://www.apache.org/licenses/LICENSE-2.0
                    assertThat(result.getSubsetSize(), equalTo(1000L));
            Document doc = new Document();
            }
            }
                try (IndexReader reader = maybeWrapReaderEs(writer.getReader())) {
                            d.add(new SortedDocValuesField("j", new BytesRef(Integer.toString(j))));
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
                IndexSearcher searcher = new IndexSearcher(reader);
            SignificantTermsAggregationBuilder sigAgg = new SignificantTermsAggregationBuilder("sig_text").field("text");
        TextFieldType textFieldType = new TextFieldType("text");
        testAllDocsWithoutStringField("global_ordinals");
        return randomBoolean() ? null : randomFrom(ExecutionMode.values()).toString();
            for (RangeFieldMapper.Range range : new RangeFieldMapper.Range[] {
     * Uses the significant terms aggregation to find the keywords in text fields
        try (Directory dir = newDirectory()) {
        }
            doc.add(new Field("text", text.toString(), TextFieldMapper.Defaults.FIELD_TYPE));
                    SignificantTermsAggregationBuilder request = new SignificantTermsAggregationBuilder("f").field("f");
                assertEquals("test expects a single segment", 1, reader.leaves().size());
                SignificantTerms evenTerms = searchAndReduce(searcher, new TermQuery(new Term("text", "even")), agg, textFieldType);
                        SignificantStringTerms jAgg = iBucket.getAggregations().get("j");
                        .minDocCount(0)
     * for it we return a properly shaped "empty" result. In particular, the
                assertNotNull(terms.getBucketByKey("odd"));
                    IndexSearcher searcher = newIndexSearcher(reader);
                new RangeFieldMapper.Range(rangeType, 42L, 49L, true, true), }) {
        MappedFieldType fieldType = new RangeFieldMapper.RangeFieldType(fieldName, rangeType);
import org.apache.lucene.document.SortedDocValuesField;
    private void addFields(Document doc, List<Field> createFields) {
            if (i % 2 == 0) {
            if (randomBoolean()) {
            // Attempt aggregation on range field
                assertNull(terms.getBucketByKey("common"));
                IndexSearcher searcher = new IndexSearcher(reader);
                new RangeFieldMapper.Range(rangeType, 1L, 5L, true, true),
                terms = searchAndReduce(searcher, new TermQuery(new Term("text", "even")), sigNumAgg, longFieldType);
        RangeType rangeType = RangeType.DOUBLE;
                        .executionHint(executionHint);
                        }
     * in {@link InternalMappedSignificantTerms#getSubsetSize()}.
 * Licensed to Elasticsearch under one or more contributor
                w.addDocument(doc);
                        request,
                assertThat(terms.getSubsetSize(), equalTo(5L));
    }
                try (IndexReader reader = maybeWrapReaderEs(writer.getReader())) {
                terms = searchAndReduce(searcher, new TermQuery(new Term("text", "even")), sigAgg, textFieldType);
    protected List<String> unsupportedMappedFieldTypes() {
                try (IndexReader reader = maybeWrapReaderEs(writer.getReader())) {
    public void testRangeField() throws IOException {
    }
 * GitHub history for details.
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {
        final long EVEN_VALUE = 6;
                assertNull(terms.getBucketByKey("even"));
                    doc.add(new Field("text", "odd", TextFieldMapper.Defaults.FIELD_TYPE));
     * still include the count of its matching documents
                    textFieldType
        final String fieldName = "rangeField";
                    SignificantTermsAggregationBuilder request = new SignificantTermsAggregationBuilder("f").field("f")
            }
                IndexSearcher indexSearcher = newIndexSearcher(reader);
                        longField("k")
    @Override
            NumberFieldMapper.NumberType.HALF_FLOAT.typeName(),
                    for (int i = 0; i < 10; i++) {
                }
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
                sigAgg.includeExclude(new IncludeExclude("o.d", null));
                    for (int i = 0; i < 10; i++) {
                // Search "odd"
                    }
 * the Apache License, Version 2.0 (the "License"); you may
    public void testAllDocsWithoutStringFieldViaMap() throws IOException {
                assertEquals(0, terms.getBuckets().size());
    }
                sigAgg.includeExclude(new IncludeExclude(evenStrings, oddStrings));
    public void testAllDocsWithoutStringFieldviaGlobalOrds() throws IOException {
                terms = searchAndReduce(searcher, new TermQuery(new Term("text", "odd")), sigAgg, textFieldType);
                            assertThat(jBucket.getDocCount(), equalTo(10L));
                        .minDocCount(0)
                        .subAggregation(kRequest);
                text.append("even ");
    /**
import org.apache.lucene.search.TermQuery;
                                SignificantLongTerms.Bucket kBucket = kAgg.getBucketByKey(Integer.toString(k));
import org.apache.lucene.document.SortedNumericDocValuesField;
package org.opensearch.search.aggregations.bucket.terms;
            }
                    }
    private void threeLayerStringTestCase(String executionHint) throws IOException {
                            writer.addDocument(d);
import java.util.stream.Collectors;
                    assertThat(result.getSubsetSize(), equalTo(1000L));
import org.opensearch.index.mapper.TextFieldMapper.TextFieldType;
        }
 * KIND, either express or implied.  See the License for the
                assertFalse(oddTerms.getBuckets().isEmpty());
                assertNull(terms.getBucketByKey("odd"));
                            for (int k = 0; k < 10; k++) {
    }
                        longField("i"),
                        assertThat(iBucket.getDocCount(), equalTo(100L));
                String oddStrings[] = new String[] { "odd", "weird" };
                SignificantTerms aliasEvenTerms = searchAndReduce(
            for (int i = 0; i < 10; i++) {
                                assertThat(jAgg.getSubsetSize(), equalTo(100L));
                    SignificantTermsAggregationBuilder request = new SignificantTermsAggregationBuilder("i").field("i")
                                assertThat(kBucket.getDocCount(), equalTo(1L));
import org.apache.lucene.analysis.standard.StandardAnalyzer;
            sigNumAgg.executionHint(randomExecutionHint());
     */
                assertNull(terms.getBucketByKey("regular"));
                    }
/*
                writer.addDocument(new Document());
    @Override
            CoreValuesSourceType.DATE,
                assertThat(terms.getSubsetSize(), equalTo(5L));
                assertNull(terms.getBucketByKey("even"));
            try (IndexReader reader = DirectoryReader.open(w)) {
                Document d = new Document();
    }
    private void testAllDocsWithoutStringField(String executionHint) throws IOException {
                sigAgg.includeExclude(new IncludeExclude(oddStrings, evenStrings));
                        new MatchAllDocsQuery(),
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
                        .executionHint(executionHint);
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
        threeLayerStringTestCase("global_ordinals");
                    );
        }
        }
        }
        }
            }
    public void testUnmapped() throws IOException {
        final RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(rangeType, 6.0D, 10.0D, true, true);
     * fields
     */
            if (randomBoolean()) {
                w.addDocument(doc);
        }
                            assertThat(kAgg.getSubsetSize(), equalTo(10L));
import org.apache.lucene.index.Term;
                        SignificantStringTerms.Bucket iBucket = result.getBucketByKey(Integer.toString(i));
import org.opensearch.index.analysis.NamedAnalyzer;
            doc.add(new StoredField("_source", new BytesRef(json)));
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {
                    assertThat(result.getSubsetSize(), equalTo(1L));
                    searcher,
                        searcher,
                assertNotNull(terms.getBucketByKey("odd"));
                writer.flush();
    }
                            SignificantStringTerms kAgg = jBucket.getAggregations().get("k");
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
 * specific language governing permissions and limitations
     */
                            SignificantStringTerms.Bucket jBucket = jAgg.getBucketByKey(Integer.toString(j));
                    SignificantLongTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), request, longField("f"));
            }
                try (IndexReader reader = maybeWrapReaderEs(writer.getReader())) {
                assertNull(terms.getBucketByKey("common"));
                        new MatchAllDocsQuery(),
public class SignificantTermsAggregatorTests extends AggregatorTestCase {
                        .minDocCount(0)
    public void testAllDocsWithoutNumericField() throws IOException {
            }
                        assertThat(jAgg.getSubsetSize(), equalTo(100L));
                        longField("j"),
        TextFieldType textFieldType = new TextFieldType("text");
            String executionHint = randomExecutionHint();
        }
                        .executionHint(executionHint)
    }
            }
                        SignificantLongTerms jAgg = iBucket.getAggregations().get("j");
                        keywordField("k")
                assertEquals("test expects a single segment", 1, reader.leaves().size());
        }
    }
     * in {@link InternalMappedSignificantTerms#getSubsetSize()}.
                assertThat(terms.getSubsetSize(), equalTo(5L));
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment
                    SignificantTermsAggregationBuilder request = new SignificantTermsAggregationBuilder("i").field("i")
                        .subAggregation(
                    SignificantLongTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), request, longField("f"));
 */
                            d.add(new SortedNumericDocValuesField("i", i));
            CoreValuesSourceType.BYTES,
                        .minDocCount(0)
                aliasAgg.backgroundFilter(backgroundFilter);
     * to the number of matching documents.
            doc.add(field);
    /**
                SignificantTerms oddTerms = searchAndReduce(searcher, new TermQuery(new Term("text", "odd")), agg, textFieldType);
                assertNull(terms.getBucketByKey("odd"));
            }
    /**
                            assertThat(jBucket.getDocCount(), equalTo(10L));
                            }
                    for (int j = 0; j < 10; j++) {
                writer.addDocument(d);
    }
                sigAgg.backgroundFilter(QueryBuilders.termsQuery("text", "common"));
            SignificantTermsAggregationBuilder aliasAgg = significantTerms("sig_text").field("text-alias");
        try (Directory dir = newDirectory()) {
                            d.add(new SortedDocValuesField("k", new BytesRef(Integer.toString(k))));
                for (int i = 0; i < 10; i++) {
import org.opensearch.search.aggregations.AggregatorTestCase;
                            SignificantLongTerms.Bucket jBucket = jAgg.getBucketByKey(Integer.toString(j));
     * {@link InternalMappedSignificantTerms#getSubsetSize()} needs to be set
            }
                    IndexSearcher searcher = newIndexSearcher(reader);
            sigAgg.executionHint(randomExecutionHint());
    public void testThreeLayerStringViaMap() throws IOException {
                    IndexSearcher searcher = newIndexSearcher(reader);
        final RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(rangeType, 1.0D, 5.0D, true, true);
import java.util.List;
                    doc.add(new Field("text", "even", TextFieldMapper.Defaults.FIELD_TYPE));
     * still include the count of its matching documents
                assertEquals(1, terms.getBuckets().size());
 * this work for additional information regarding copyright
    }
import org.apache.lucene.document.StoredField;
                        for (int j = 0; j < 10; j++) {
                }
    }
                    assertThat(result.getSubsetSize(), equalTo(1L));
                );
            } else {
                assertEquals(1, terms.getBuckets().size());
                new RangeFieldMapper.Range(rangeType, 4L, 13L, true, true),
                assertNull(terms.getBucketByKey(Long.toString(EVEN_VALUE)));
                writer.addDocument(new Document());
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
import org.opensearch.search.aggregations.bucket.terms.SignificantTermsAggregatorFactory.ExecutionMode;
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
    }
                }
                    );
    }
        final long COMMON_VALUE = 2;
        NumberFieldType longFieldType = new NumberFieldMapper.NumberFieldType("long_field", NumberFieldMapper.NumberType.LONG);
                        keywordField("j"),
    }
                // Use a background filter which just happens to be same scope as whole-index.
    private void addMixedTextDocs(IndexWriter w) throws IOException {
        TextFieldType textFieldType = new TextFieldType("text");
            try (IndexReader reader = DirectoryReader.open(w)) {
                        assertThat(iBucket.getDocCount(), equalTo(100L));
                        for (int j = 0; j < 10; j++) {
import java.util.Collections;
                expectThrows(IllegalArgumentException.class, () -> createAggregator(sigAgg, indexSearcher, fieldType));
                        .subAggregation(jRequest);
import org.apache.lucene.search.IndexSearcher;
                SignificantStringTerms terms = searchAndReduce(searcher, new TermQuery(new Term("text", "odd")), sigAgg, textFieldType);
                assertThat(terms.getSubsetSize(), equalTo(5L));
        );
        TextFieldType textFieldType = new TextFieldType("text");
 *
                            new SignificantTermsAggregationBuilder("j").field("j")
 */
                            assertThat(kAgg.getSubsetSize(), equalTo(10L));
                assertEquals(1, terms.getBuckets().size());
            SignificantTermsAggregationBuilder sigNumAgg = new SignificantTermsAggregationBuilder("sig_number").field("long_field");
                            d.add(new SortedNumericDocValuesField("k", k));
            CoreValuesSourceType.IP
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {
            HllFieldMapper.CONTENT_TYPE // HLL fields are not supported for significant terms aggregation
                            d.add(new SortedDocValuesField("i", new BytesRef(Integer.toString(i))));
                }
import org.opensearch.index.mapper.BinaryFieldMapper;
                // Search "odd"
            addMixedTextDocs(w);
        return Arrays.asList(
                // Search with string-based includeexcludes
    }
                doc.add(new BinaryDocValuesField("field", encodedRange));
import org.apache.lucene.index.IndexWriter;
                assertNull(terms.getBucketByKey("weird"));
     */
 * compatible open source license.
                        keywordField("i"),
                SignificantLongTerms terms = searchAndReduce(searcher, new TermQuery(new Term("text", "odd")), sigNumAgg, longFieldType);
        }
     */
            try (IndexReader reader = DirectoryReader.open(w)) {
            String json = "{ \"text\" : \"" + text.toString() + "\" }";
                assertNull(terms.getBucketByKey(Long.toString(COMMON_VALUE)));
        textFieldType.setIndexAnalyzer(new NamedAnalyzer("my_analyzer", AnalyzerScope.GLOBAL, new StandardAnalyzer()));
     */
                writer.addDocument(new Document());
import org.apache.lucene.store.Directory;
import org.opensearch.index.query.QueryBuilder;
import org.apache.lucene.tests.index.RandomIndexWriter;
                    SignificantLongTerms result = searchAndReduce(
                addFields(doc, NumberType.LONG.createFields("long_field", COMMON_VALUE, true, true, false, false));
                    SignificantTermsAggregationBuilder request = new SignificantTermsAggregationBuilder("f").field("f");
 * Unless required by applicable law or agreed to in writing,
                        SignificantLongTerms.Bucket iBucket = result.getBucketByKey(Integer.toString(i));
    public void testThreeLayerLong() throws IOException {
            }
            // Attempt aggregation on unmapped field
 * You may obtain a copy of the License at
                assertNull(terms.getBucketByKey(Long.toString(ODD_VALUE)));
                assertThat(terms.getSubsetSize(), equalTo(5L));
                assertNotNull(terms.getBucketByKey("even"));
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {
                    aliasAgg,
import org.opensearch.index.mapper.MappedFieldType;
     * Make sure that when the field is mapped but there aren't any values
     * {@link InternalMappedSignificantTerms#getSubsetSize()} needs to be set
    }
    public void testNumericSignificance() throws IOException {
                IndexSearcher searcher = new IndexSearcher(reader);
    public void testThreeLayerStringViaGlobalOrds() throws IOException {
     * Make sure that when the field is mapped but there aren't any values
import org.apache.lucene.util.BytesRef;
    public String randomExecutionHint() {
                                SignificantStringTerms.Bucket kBucket = kAgg.getBucketByKey(Integer.toString(k));
        textFieldType.setFielddata(true);
import org.opensearch.index.analysis.AnalyzerScope;
                        searcher,
                IndexSearcher searcher = new IndexSearcher(reader);
                SignificantTerms aliasOddTerms = searchAndReduce(searcher, new TermQuery(new Term("text", "odd")), aliasAgg, textFieldType);
                                .minDocCount(0)
            aliasAgg.executionHint(executionHint);
            sigAgg.executionHint(randomExecutionHint());
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment
        testAllDocsWithoutStringField("map");
                writer.addDocument(d);
            NumberFieldMapper.NumberType.DOUBLE.typeName(), // floating points are not supported at all
                    addFields(doc, NumberType.LONG.createFields("long_field", ODD_VALUE, true, true, false, false));
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment
                assertEquals(oddTerms, aliasOddTerms);
            StringBuilder text = new StringBuilder("common ");
            NumberFieldMapper.NumberType.FLOAT.typeName(),
                try (IndexReader reader = maybeWrapReaderEs(writer.getReader())) {
    @Override
        textFieldType.setIndexAnalyzer(new NamedAnalyzer("my_analyzer", AnalyzerScope.GLOBAL, new StandardAnalyzer()));
     * For each provided field type, we also register an alias with name {@code <field>-alias}.
    /**
        indexWriterConfig.setMaxBufferedDocs(100);
                    IndexSearcher searcher = newIndexSearcher(reader);
            }
            SignificantTermsAggregationBuilder sigAgg = new SignificantTermsAggregationBuilder("sig_text").field(fieldName);
                // Search odd with regex includeexcludes
                assertNull(terms.getBucketByKey("common"));
                Document doc = new Document();
                    SignificantStringTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), request, keywordField("f"));
                    IndexSearcher searcher = newIndexSearcher(reader);
import java.util.Arrays;
                d.add(new SortedDocValuesField("f", new BytesRef("f")));
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
        textFieldType.setFielddata(true);
import org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType;
                assertNotNull(terms.getBucketByKey("odd"));
        }
import org.opensearch.index.mapper.NumberFieldMapper;
                QueryBuilder backgroundFilter = QueryBuilders.termsQuery("text", "common");
                // Search even
            }
                    IndexSearcher searcher = newIndexSearcher(reader);
    /**
                    assertThat(result.getSubsetSize(), equalTo(2L));
     */
    }
                BytesRef encodedRange = rangeType.encodeRanges(Collections.singleton(range));
import static org.opensearch.search.aggregations.AggregationBuilders.significantTerms;
    }
                terms = searchAndReduce(searcher, new TermQuery(new Term("text", "odd")), sigAgg, textFieldType);
                Document doc = new Document();
                // Search "odd"
import org.apache.lucene.search.MatchAllDocsQuery;
                        for (int k = 0; k < 10; k++) {
    public void testFieldAlias() throws IOException {
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {
    }
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
            addMixedTextDocs(w);
    public void testSignificance() throws IOException {
    /**
    public void testSomeDocsWithoutNumericField() throws IOException {
        testSomeDocsWithoutStringField("map");
                    SignificantTermsAggregationBuilder kRequest = new SignificantTermsAggregationBuilder("k").field("k")
 * Modifications Copyright OpenSearch Contributors. See
                assertThat(terms.getSubsetSize(), equalTo(5L));
                assertNull(terms.getBucketByKey("even"));
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
                        );
            try (RandomIndexWriter writer = new RandomIndexWriter(random(), dir)) {
     */
                assertEquals(evenTerms, aliasEvenTerms);
import org.opensearch.index.mapper.HllFieldMapper;
import org.apache.lucene.document.BinaryDocValuesField;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                assertNull(terms.getBucketByKey("common"));
    /**
                assertNull(terms.getBucketByKey(Long.toString(COMMON_VALUE)));
        try (Directory dir = newDirectory()) {
                sigAgg.significanceHeuristic(SignificanceHeuristicTests.getRandomSignificanceheuristic());
                    SignificantStringTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), request, keywordField("f"));
                Document d = new Document();
                assertEquals("test expects a single segment", 1, reader.leaves().size());
            SignificantTermsAggregationBuilder sigNumAgg = new SignificantTermsAggregationBuilder("sig_number").field("long_field");
                        .executionHint(executionHint)
                String evenStrings[] = new String[] { "even", "regular" };
import org.opensearch.index.mapper.TextFieldMapper;
                    SignificantTermsAggregationBuilder jRequest = new SignificantTermsAggregationBuilder("j").field("j")
    }
        threeLayerStringTestCase("map");
import static org.hamcrest.Matchers.equalTo;
 * software distributed under the License is distributed on an
                if (i % 2 == 0) {
                }
                            d.add(new SortedNumericDocValuesField("j", j));
     * for it we return a properly shaped "empty" result. In particular, the
        textFieldType.setIndexAnalyzer(new NamedAnalyzer("my_analyzer", AnalyzerScope.GLOBAL, new StandardAnalyzer()));
                assertNull(terms.getBucketByKey("odd"));
        indexWriterConfig.setMaxBufferedDocs(100);
 */
                assertEquals(0, terms.getBuckets().size());
     * Make sure that when the field a segment doesn't contain the field we
        try (Directory dir = newDirectory()) {
            CoreValuesSourceType.BOOLEAN,
                                assertThat(kBucket.getDocCount(), equalTo(1L));
                        }
        for (Field field : createFields) {
                assertNull(terms.getBucketByKey("regular"));
                    new TermQuery(new Term("text", "even")),
        return Arrays.stream(fieldTypes).collect(Collectors.toMap(ft -> ft.name() + "-alias", Function.identity()));
                    }
                }
     */
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
import org.opensearch.search.aggregations.support.ValuesSourceType;
            sigNumAgg.executionHint(randomExecutionHint());
                    for (int j = 0; j < 10; j++) {
    /**
import org.opensearch.index.mapper.RangeType;
    public void testSomeDocsWithoutStringFieldViaMap() throws IOException {
        indexWriterConfig.setMaxBufferedDocs(100);
                text.append("odd ");
 * license agreements. See the NOTICE file distributed with
                            Document d = new Document();
     * Uses the significant terms aggregation to find the keywords in numeric
                } else {
        indexWriterConfig.setMaxBufferedDocs(100);
                            writer.addDocument(d);
            w.addDocument(doc);
 *
}
                        request,
        }
     * Uses the significant terms aggregation on a range field
                    assertThat(result.getSubsetSize(), equalTo(2L));
    }
        textFieldType.setFielddata(true);
import java.util.Map;
                        }
                }
            try (IndexReader reader = DirectoryReader.open(w)) {
 * not use this file except in compliance with the License.
                    addFields(doc, NumberType.LONG.createFields("long_field", EVEN_VALUE, true, true, false, false));
                    SignificantTermsAggregationBuilder request = new SignificantTermsAggregationBuilder("f").field("f")
                        }
                assertNull(terms.getBucketByKey("common"));
        for (int i = 0; i < 10; i++) {
                assertNull(terms.getBucketByKey("even"));
                        for (int k = 0; k < 10; k++) {
                // Use a background filter which just happens to be same scope as whole-index.
                assertEquals("test expects a single segment", 1, reader.leaves().size());
            try (IndexReader reader = DirectoryReader.open(w)) {
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment
    private void testSomeDocsWithoutStringField(String executionHint) throws IOException {
/*
            CoreValuesSourceType.NUMERIC,
                new RangeFieldMapper.Range(rangeType, -3L, 4L, true, true),
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.document.Field;
                for (int i = 0; i < 10; i++) {
     * Make sure that when the field a segment doesn't contain the field we
        IndexWriterConfig indexWriterConfig = newIndexWriterConfig();
import java.io.IOException;
                            }
                    SignificantStringTerms result = searchAndReduce(
                }
            sigAgg.executionHint(randomExecutionHint());
                }
        return new SignificantTermsAggregationBuilder("foo").field(fieldName);
                SignificantTerms terms = searchAndReduce(searcher, new TermQuery(new Term("text", "odd")), sigAgg, textFieldType);
        final long ODD_VALUE = 3;
        testSomeDocsWithoutStringField("global_ordinals");
    /**
 * ownership. Elasticsearch licenses this file to you under
                d.add(new SortedNumericDocValuesField("f", 1));
                assertEquals(1, terms.getBuckets().size());
        );
            }
    protected Map<String, MappedFieldType> getFieldAliases(MappedFieldType... fieldTypes) {
                            for (int k = 0; k < 10; k++) {
        try (Directory dir = newDirectory()) {
                assertNull(terms.getBucketByKey("even"));
            agg.executionHint(executionHint);
import org.opensearch.index.query.QueryBuilders;
    }
import java.util.function.Function;
    }
        try (Directory dir = newDirectory(); IndexWriter w = new IndexWriter(dir, indexWriterConfig)) {
                                .subAggregation(new SignificantTermsAggregationBuilder("k").field("k").minDocCount(0))
            }
                        assertThat(jAgg.getSubsetSize(), equalTo(100L));
        indexWriterConfig.setMaxBufferedDocs(100);
                assertNull(terms.getBucketByKey("weird"));
 * this file be licensed under the Apache-2.0 license or a
            }
                assertNotNull(terms.getBucketByKey(Long.toString(ODD_VALUE)));
                terms = searchAndReduce(searcher, new TermQuery(new Term("text", "odd")), sigAgg, textFieldType);
import org.opensearch.index.mapper.RangeFieldMapper;
            SignificantTermsAggregationBuilder agg = significantTerms("sig_text").field("text");
import org.apache.lucene.document.Document;
            BinaryFieldMapper.CONTENT_TYPE, // binary fields are not supported because they cannot be searched
import org.apache.lucene.index.IndexReader;
    }
 *
                writer.addDocument(new Document());
     * to the number of matching documents.
import org.opensearch.search.aggregations.AggregationBuilder;
                        .executionHint(executionHint);
            SignificantTermsAggregationBuilder sigAgg = new SignificantTermsAggregationBuilder("sig_text").field("unmapped_field");
                assertEquals(1, terms.getBuckets().size());
                assertFalse(evenTerms.getBuckets().isEmpty());
import org.apache.lucene.index.DirectoryReader;
                assertThat(terms.getSubsetSize(), equalTo(5L));
 * The OpenSearch Contributors require contributions made to
     * Uses the significant terms aggregation on an index with unmapped field
                agg.backgroundFilter(backgroundFilter);
            addMixedTextDocs(w);
        return Arrays.asList(
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;
                            SignificantLongTerms kAgg = jBucket.getAggregations().get("k");
/*
        indexWriterConfig.setRAMBufferSizeMB(100); // flush on open to have a single segment
import org.apache.lucene.index.IndexWriterConfig;
    @Override
                assertEquals(1, terms.getBuckets().size());
                            Document d = new Document();
    public void testSomeDocsWithoutStringFieldviaGlobalOrds() throws IOException {
 * under the License.
