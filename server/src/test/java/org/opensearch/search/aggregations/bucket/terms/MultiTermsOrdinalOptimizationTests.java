                Map<String, Long> actualCounts = new HashMap<>();
            for (int i = 0; i < 3; i++) {
        try (Directory directory = newDirectory()) {
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());  
            }  
                assertEquals("Bucket count mismatch", expectedCounts.size(), actualCounts.size());
    }
                doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("search")));
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {
        try (Directory directory = newDirectory()) {
        for (int i = 0; i < numDistinctValues; i++) {
 * The OpenSearch Contributors require contributions made to  
        kw2ToInt.put("two", 2);
        }
                assertEquals("Bucket count mismatch", expectedCounts.size(), actualCounts.size());  
                IndexSearcher searcher = newIndexSearcher(reader);
                    asList(kwConfig(KW_FIELD_1), kwConfig(KW_FIELD_2))
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);  
    /**  
                for (InternalMultiTerms.Bucket bucket : result.getBuckets()) {  
                ).size(10);
    }
import java.io.IOException;
            }
                IndexSearcher searcher = newIndexSearcher(reader);
                // Query matches only filter=1 docs, so alpha|y collects no matching documents.
            // Doc 2: kw1=[a], kw2=[x,y] → buckets: (a,x), (a,y)  
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {  
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());
                );  
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
    private static final String KW_FIELD_1 = "kw1";  
     * Test that missing values in a field correctly cause the document to be skipped
                for (InternalMultiTerms.Bucket bucket : result.getBuckets()) {
            doc3.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("alpha")));
        return List.of(HllFieldMapper.CONTENT_TYPE);  
import org.opensearch.index.mapper.MappedFieldType;  
                assertEquals("c", bucket.getKey().get(2));  
                iw.addDocument(doc);
                Map<String, Long> actualCounts = new HashMap<>();
        return new MultiTermsAggregationBuilder("_name").terms(asList(kwConfig(fieldName), kwConfig(fieldName)));
            doc.add(new SortedDocValuesField(KW_FIELD_3, new BytesRef("c")));
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(
                doc.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("x")));
            }
    public void testMinDocCountZeroOrdinalPath() throws IOException {
            Document doc = new Document();
    public void testMixedKeywordAndNumericFallbackPath() throws IOException {
            doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("a")));
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);  
            doc1.add(new SortedSetDocValuesField(KW_FIELD_2, new BytesRef("x")));  
                    String compositeKey = key.get(0) + "|" + key.get(1);  
    }
     * and verifies results match expected bucket keys and doc counts.  
                assertTrue("Expected zero-doc bucket alpha|y to be present", actualCounts.containsKey("alpha|y"));
     * Test with 3 keyword fields — exercises the PackedOrdinalBucketOrds (single-long) path.
     */
                // Use a large size to capture all buckets
                );
                    asList(kwConfig(KW_FIELD_1), kwConfig(KW_FIELD_2))
        Map<String, Long> expectedCounts = new HashMap<>();
            iw.close();
                // Assert the packed-ordinal (single-long) strategy is actually selected — result
                }
                IndexSearcher searcher = newIndexSearcher(reader);
            for (int i = 0; i < numDocs; i++) {
                // Verify every bucket matches expected counts
        try (Directory directory = newDirectory()) {
    /**  
            // Two docs that match the query (filter=1) and are counted normally.
                // Convert int keys to the kw2 equivalent for comparison  
                // The excluded combination must be present as an explicit zero-count bucket.
                    actualCounts.put(compositeKey, bucket.getDocCount());
            }  
                iw.addDocument(doc);
                MultiTermsBucketOrds strategy = ((MultiTermsAggregator) createAggregator(builder, searcher, allFieldTypes()))
                }
        return new MultiTermsValuesSourceConfig.Builder().setFieldName(field).build();
                    asList(kwConfig(KW_FIELD_1), kwConfig(KW_FIELD_2))
            }
                    actualCounts.put(compositeKey, bucket.getDocCount());
                for (Map.Entry<String, Long> entry : expectedCounts.entrySet()) {  
    @Override  
        MappedFieldType fieldType,
                doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef(v1)));  
                iw.addDocument(doc);
                    "include/exclude must force the byte-key fallback",  
                InternalMultiTerms result = searchAndReduce(searcher, IntPoint.newExactQuery("filter", 1), builder, allFieldTypes());
        // Map kw2 values to integers for the fallback path
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(
                    fieldTypes
    }
    ) {
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);  
     * Test with high-cardinality fields to exercise the ordinal path with many distinct values.
                iw.addDocument(doc);
            CoreValuesSourceType.DATE,
                doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef(kw1)));  
                Document doc = new Document();  
     * Indexes random documents with 3 keyword fields, runs multi_terms aggregation,
import org.apache.lucene.search.MatchAllDocsQuery;  
import org.apache.lucene.util.BytesRef;  
import org.apache.lucene.store.Directory;
                ).size(100).minDocCount(0);
                }
 * SPDX-License-Identifier: Apache-2.0
     */  
                Map<String, Long> actualCounts = new HashMap<>();
import org.opensearch.search.aggregations.support.MultiTermsValuesSourceConfig;
                    asList(kw1WithExclude, kwConfig(KW_FIELD_2))
    }
    }
            }
                MultiTermsBucketOrds strategy = ((MultiTermsAggregator) createAggregator(builder, searcher, allFieldTypes()))  
            iw.addDocument(doc1);
     */
            Document doc2 = new Document();
    }  
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);  
                    .size(10)
            // Doc 3: kw1=[b], kw2=[y] → buckets: (b,y)
                String v2 = values[randomIntBetween(0, numDistinctValues - 1)];
                    outer,
                for (Map.Entry<String, Long> entry : expectedCounts.entrySet()) {
        return List.of(
                    asList(kwConfig(KW_FIELD_1), intConfig())  
                ).size(100);  
                assertEquals("a", bucket.getKey().get(0));
     * when using the ordinal collection path.  
                );  
                doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("storage")));
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(
     * Regression test for the include/exclude gate: an all-keyword multi_terms carrying an
                expectedCounts.merge(v1 + "|" + v2, 1L, Long::sum);  
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(  
                IndexSearcher searcher = newIndexSearcher(reader);
                    new MatchAllDocsQuery(),  
                String v2 = values[randomIntBetween(0, numDistinct - 1)];
    }
                );
     * the cartesian product is correctly generated in the ordinal path.
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {  
                assertEquals(2, outerResult.getBuckets().size());  
    /**
                    .getOrdinalBucketOrds();  
            iw.close();
                        InternalMultiTerms.Bucket b = innerResult.getBuckets().get(0);  
            }
                Document doc = new Document();
            new KeywordFieldMapper.KeywordFieldType(KW_FIELD_1),
                String v1 = values[randomIntBetween(0, numDistinctValues - 1)];  
    protected List<String> unsupportedMappedFieldTypes() {
            // Doc with both fields present  
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(  
            doc1.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("x")));
    }
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
                    fallbackBuckets.add(kw + "|" + mapped + "=" + bucket.getDocCount());  
        );
                iw.addDocument(doc);
            for (String v1 : new String[] { "alpha", "beta" }) {
                }
                // A non-ordinal (numeric) field must force the byte-key fallback: no ordinal strategy.  
            // Doc with only field1 — should be skipped (no kw2 value)  
                iw.addDocument(doc);
                }
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());
            // With min_doc_count=0 it must still appear as a zero-count bucket via the zero-doc fill.
    private static final String INT_FIELD = "int_val";  
import org.opensearch.index.mapper.NumberFieldMapper;
                doc.add(new NumericDocValuesField(INT_FIELD, intVal));
        String[] values = new String[numDistinctValues];
            for (int i = 0; i < numDocs; i++) {
import java.util.ArrayList;
                Map<String, Long> actualCounts = new HashMap<>();
        String[] kw1Values = { "alpha", "beta", "gamma" };  
                IndexSearcher searcher = newIndexSearcher(reader);
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
                    String kw = (String) bucket.getKey().get(0);
                doc.add(new NumericDocValuesField(INT_FIELD, kw2ToInt.get(kw2Values[choice[1]])));
import java.util.Comparator;  
            Document docMissingField2 = new Document();
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(
            }  
                MultiTermsValuesSourceConfig kw1WithExclude = new MultiTermsValuesSourceConfig.Builder().setFieldName(KW_FIELD_1)  
                expectedCounts.merge(v1 + "|" + v2 + "|" + v3, 1L, Long::sum);
        // Generate enough distinct values to exercise the ordinal path with higher cardinality
            iw.addDocument(doc3);
        for (int i = 0; i < numDistinctKw; i++) {
    /**  
     */  
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());
        Map<String, Long> expectedCounts = new HashMap<>();
                }
     * query).  
            // The alpha|y combination exists in the index but is excluded by the query (filter=0).
            doc3.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("y")));
                doc.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef(v2)));
    }  
                    actualCounts.put(compositeKey, bucket.getDocCount());  
    }  
                    actualCounts.put(bucket.getKey().get(0) + "|" + bucket.getKey().get(1), bucket.getDocCount());
    /**  
        String fieldName  
                assertEquals(Long.valueOf(2), actualCounts.get("a|x"));
            Document doc = new Document();
                assertTrue(
                    actualCounts.put(compositeKey, bucket.getDocCount());
        }  
 */  
                Map<Long, String> intToKw2 = new HashMap<>();
            MappedFieldType[] fieldTypes = new MappedFieldType[] {
                InternalMultiTerms.Bucket bucket = result.getBuckets().get(0);  
     * Verify that mixed keyword + numeric fields fall back to the bytes-based path and still produce correct results.
import org.apache.lucene.document.NumericDocValuesField;  
        for (int i = 0; i < numDistinctValues; i++) {
            }  
        String[] values = new String[numDistinct];
    public void testThreeKeywordFieldsPackedOrdinalsPath() throws IOException {
    public void testStrategySelectionMixedFieldsFallback() throws IOException {  
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(  
                    List<Object> key = bucket.getKey();
                assertEquals(Long.valueOf(1), actualCounts.get("a|y"));
                IndexSearcher searcher = newIndexSearcher(reader);
            new NumberFieldMapper.NumberFieldType(INT_FIELD, NumberFieldMapper.NumberType.INTEGER) };
                    "mixed keyword+numeric fields must fall back to the byte-key path",
     * Verify that 2 keyword fields select the PackedOrdinalBucketOrds strategy (single-long path).
                assertEquals("Only 1 bucket for the complete doc", 1, result.getBuckets().size());  
            doc2.add(new SortedSetDocValuesField(KW_FIELD_2, new BytesRef("x")));  
                    } else {
            Document docComplete = new Document();
        }
                sb.append(bucket.getKey().get(i));
    }  
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {  
        return new MultiTermsValuesSourceConfig.Builder().setFieldName(INT_FIELD).build();  
        List<String> ordinalBuckets;  
                ).size(numDistinctValues * numDistinctValues * numDistinctValues + 10);
     * Test with min_doc_count=0 on the ordinal path. The {@code alpha|y} combination is indexed but  
        }
            doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("a")));
            doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("a")));
import org.apache.lucene.index.DirectoryReader;  
            doc2.add(new SortedSetDocValuesField(KW_FIELD_2, new BytesRef("y")));
 * missing values, include/exclude).
                assertEquals(Long.valueOf(1), actualCounts.get("beta|x"));  
    }  
                assertNull("beta must be excluded", actualCounts.get("beta|x"));  
                IndexSearcher searcher = newIndexSearcher(reader);  
    private List<String> bucketsToSortedStrings(InternalMultiTerms result) {  
        List<String> fallbackBuckets;
     */
    protected org.opensearch.search.aggregations.AggregationBuilder createAggBuilderForTypeTest(
    private MultiTermsValuesSourceConfig intConfig() {
        assertEquals("Ordinal and fallback paths should produce equivalent results", ordinalBuckets, fallbackBuckets);  
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(  
                intToKw2.put(1L, "one");  
import java.util.Map;
                }
            for (int i = 0; i < 4; i++) {  
                }
            }  
                ).size(100);
                ).size(numDistinctKw * 5 + 10);  
            doc.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("b")));  
        // Run fallback path: keyword + int (forces BytesKeyedBucketOrds)  
        }  
            iw.close();
                    assertEquals("Doc count mismatch for key " + entry.getKey(), entry.getValue(), actualCounts.get(entry.getKey()));  
     */  
                expectedCounts.merge(kw1 + "|" + intVal, 1L, Long::sum);  
            iw.addDocument(doc);
        return bucketStrings;
    /**
            for (int i = 0; i < bucket.getKey().size(); i++) {
                Document doc = new Document();
            values[i] = randomAlphaOfLength(randomIntBetween(3, 10));  
                );
                Map<String, Long> actualCounts = new HashMap<>();
                // Verify outer buckets
                    if ("tech".equals(outerBucket.getKeyAsString())) {
 * path, strategy selection and fallback, and edge cases (multi-valued fields, min_doc_count=0,
            iw.addDocument(doc2);  
        kw2ToInt.put("one", 1);
                Document doc = new Document();
        int numDocs = randomIntBetween(20, 80);  
                assertEquals("x", bucket.getKey().get(1));  
                ).size(100);
    public void testNestedMultiTermsCorrectPerParentBucket() throws IOException {  
     * Test with mixed keyword + numeric fields — exercises the BytesKeyedBucketOrds fallback path.
                assertEquals("Bucket count mismatch for high-cardinality test", expectedCounts.size(), actualCounts.size());
                for (InternalMultiTerms.Bucket bucket : result.getBuckets()) {  
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());
            }  
     * packed-ordinal path here — only the two-long path falls back under MANY (see  
            iw.close();
                assertEquals(4, actualCounts.size());
     * Test equivalence between ordinal path (2 keyword fields) and fallback path (keyword + int)  
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
                    String compositeKey = key.get(0) + "|" + key.get(1);
                IndexSearcher searcher = newIndexSearcher(reader);  
                assertEquals("Excluded term must not appear", 1, actualCounts.size());
            for (int i = 0; i < numDocs; i++) {
                    asList(kwConfig(KW_FIELD_1), kwConfig(KW_FIELD_2))
                for (InternalMultiTerms.Bucket bucket : result.getBuckets()) {
                ).size(100);
     */
            iw.close();
                Document doc = new Document();
        try (Directory directory = newDirectory()) {
        try (Directory directory = newDirectory()) {  
        int numDistinctValues = randomIntBetween(2, 8);  
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(
import org.apache.lucene.document.IntPoint;
                assertEquals(1, result.getBuckets().size());
import org.apache.lucene.index.IndexReader;
                new KeywordFieldMapper.KeywordFieldType(KW_FIELD_2) };
                );  
            CoreValuesSourceType.IP,
                for (InternalMultiTerms.Bucket bucket : result.getBuckets()) {
                // A field carrying include/exclude must not take the ordinal path.
                assertEquals("b", bucket.getKey().get(1));
    private static final String KW_FIELD_2 = "kw2";
                    "low-cardinality fields should use the single-long path",  
        }  
            }
                Document doc = new Document();  
            values[i] = String.format(Locale.ROOT, "%05d_%s", i, randomAlphaOfLength(5));  
                doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef(v1)));  
                doc.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef(kw2Values[choice[1]])));  
            doc1.add(new SortedSetDocValuesField(KW_FIELD_1, new BytesRef("b")));
                assertEquals(Long.valueOf(1), actualCounts.get("b|y"));
                String v2 = values[randomIntBetween(0, numDistinctValues - 1)];
     * using the same underlying data. Indexes documents with both keyword and numeric representations,
    }
        }  
        try (Directory directory = newDirectory()) {  
import org.apache.lucene.search.IndexSearcher;
                String kw1 = kwValues[randomIntBetween(0, numDistinctKw - 1)];  
                // correctness alone would also hold on the byte-key fallback path.
import org.opensearch.search.aggregations.AggregatorTestCase;
        }
    }
            }
        try (Directory directory = newDirectory()) {
        }
                    List<Object> key = bucket.getKey();
    }  
                assertEquals(Long.valueOf(1), actualCounts.get("alpha|x"));
    public void testHighCardinalityKeywordFields() throws IOException {
            doc2.add(new IntPoint("filter", 1));
        }
        Map<String, Long> expectedCounts = new HashMap<>();
                iw.addDocument(doc);
        Map<String, Long> expectedCounts = new HashMap<>();
            MappedFieldType categoryType = new KeywordFieldMapper.KeywordFieldType("category");  
                    asList(kwConfig(KW_FIELD_1), kwConfig(KW_FIELD_2), kwConfig(KW_FIELD_3))
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);  
/*  
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {  
                    assertEquals("Doc count mismatch for key " + entry.getKey(), entry.getValue(), actualCounts.get(entry.getKey()));
            doc.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("b")));  
    /**  
    public void testIncludeExcludeForcesByteKeyFallback() throws IOException {
                InternalMultiTerms.Bucket bucket = result.getBuckets().get(0);
     * and verifies results match expected bucket keys and doc counts.  
     * {@code PackedOrdinalBucketOrdsTests#testCreateTwoLongFallsBackUnderManyCardinality}).
                categoryType,
                    ((PackedOrdinalBucketOrds) strategy).isSingleLongPath()
            // Doc 1: kw1=[a,b], kw2=[x] → buckets: (a,x), (b,x)
        try (Directory directory = newDirectory()) {
            }
                for (Map.Entry<String, Long> entry : expectedCounts.entrySet()) {
    public void testTwoKeywordFieldsPairPackingPath() throws IOException {
                    "low-cardinality fields should use the single-long path",
            }  
    /**
                doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef(v1)));  
                doc.add(new SortedDocValuesField("category", new BytesRef("finance")));
                for (InternalMultiTerms.Bucket bucket : result.getBuckets()) {  
            }  
import org.apache.lucene.document.SortedSetDocValuesField;
     * Verify that 3 keyword fields select the PackedOrdinalBucketOrds strategy (single-long path for low cardinality).
                Document doc = new Document();
    /**  
                        assertEquals("finance inner should have 1 bucket", 1, innerResult.getBuckets().size());
}
            Document doc3 = new Document();
                assertNotNull("two keyword fields should select the packed-ordinal path", strategy);
     * {@code exclude} filter must fall back to the byte-key path (which applies the filter) instead of  
    public void testMultiValuedKeywordFieldsOrdinalPath() throws IOException {
                assertNotNull("three keyword fields should select the packed-ordinal path", strategy);
    public void testStrategySelectionTwoKeywordFields() throws IOException {
        }
import org.opensearch.index.mapper.KeywordFieldMapper;
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
import org.apache.lucene.document.SortedDocValuesField;
     * Verifies that when not all fields are WithOrdinals, the aggregation still produces correct results.  
     * Test with multi-valued keyword fields (SortedSetDocValuesField) to verify
import org.opensearch.search.aggregations.support.ValuesSourceType;
                fallbackBuckets.sort(Comparator.naturalOrder());
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
    }
                int intVal = randomIntBetween(1, 5);
                ).size(expectedCounts.size() + 10);
            iw.addDocument(docMissingField1);
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(
    private MultiTermsValuesSourceConfig kwConfig(String field) {
            // category=finance, kw1=search, kw2=fast
                doc.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef(v2)));
            values[i] = randomAlphaOfLength(randomIntBetween(3, 10));  
        int numDistinct = randomIntBetween(50, 200);  
import java.util.Locale;  
                    List<Object> key = bucket.getKey();
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(
                assertEquals("alpha|y must be a zero-count bucket", Long.valueOf(0), actualCounts.get("alpha|y"));  
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {
                assertEquals(42L, bucket.getKey().get(1));
                IndexSearcher searcher = newIndexSearcher(reader);
                    .setIncludeExclude(new IncludeExclude(null, "beta"))
                assertEquals(1, bucket.getDocCount());
            doc3.add(new IntPoint("filter", 0));  
                assertEquals(1, result.getBuckets().size());
                doc.add(new SortedDocValuesField("category", new BytesRef("tech")));  
                doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef(v1)));
                assertEquals(1, bucket.getDocCount());
                        assertEquals("finance should have 4 docs", 4, outerBucket.getDocCount());
            }  
/**
                    String compositeKey = key.get(0) + "|" + key.get(1);  
    public void testMissingValueDocumentSkippedOnOrdinalPath() throws IOException {
            Document doc2 = new Document();
                Document doc = new Document();
            bucketStrings.add(sb.toString());
                        assertEquals(4, b.getDocCount());  
                );
            // Doc with only field2 — should be skipped (no kw1 value)
        try (Directory directory = newDirectory()) {
    public void testStrategySelectionThreeKeywordFields() throws IOException {
            docComplete.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("a")));
     * Indexes random documents with 2 keyword fields, runs multi_terms aggregation,
                    ((PackedOrdinalBucketOrds) strategy).isSingleLongPath()
        kw2ToInt.put("three", 3);  
                assertEquals(Long.valueOf(1), actualCounts.get("b|x"));  
     */
                assertEquals("a", bucket.getKey().get(0));  
            new KeywordFieldMapper.KeywordFieldType(KW_FIELD_3),  
            iw.close();
            }  
                assertEquals("Bucket count mismatch", expectedCounts.size(), actualCounts.size());
                    );
                intToKw2.put(3L, "three");
 */  
                iw.addDocument(doc);  
            doc2.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("beta")));  
                InternalMultiTerms.Bucket bucket = result.getBuckets().get(0);
     * excluded from the query, so it collects zero matching docs; {@code collectZeroDocOrdinals} must
            doc2.add(new SortedSetDocValuesField(KW_FIELD_1, new BytesRef("a")));
            for (int[] choice : docChoices) {  
        }  
                // Verify the ordinal path produced correct results (1 bucket with count 1)  
            iw.close();
                IndexSearcher searcher = newIndexSearcher(reader);
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {
                ).size(numDistinctValues * numDistinctValues + 10);  
            iw.addDocument(doc);  
                if (i > 0) {
            }
                    asList(kwConfig(KW_FIELD_1), kwConfig(KW_FIELD_2))  
            StringBuilder sb = new StringBuilder();  
     */  
                iw.addDocument(doc);
                        assertEquals("finance", outerBucket.getKeyAsString());  
        }
                IndexSearcher searcher = newIndexSearcher(reader);
            iw.addDocument(docMissingField2);  
            doc1.add(new IntPoint("filter", 1));  
import java.util.HashMap;
                }
        }
                }
                    ((MultiTermsAggregator) createAggregator(builder, searcher, allFieldTypes())).getOrdinalBucketOrds()
                Document doc = new Document();
 * this file be licensed under the Apache-2.0 license or a
                org.opensearch.search.aggregations.bucket.terms.Terms outerResult = searchAndReduce(
                assertEquals(1, result.getBuckets().size());
                }  
                // Outer terms agg on "category", inner multi_terms on kw1 × kw2  
            doc1.add(new SortedSetDocValuesField(KW_FIELD_1, new BytesRef("a")));
        try (Directory directory = newDirectory()) {
                assertEquals("a", bucket.getKey().get(0));  
    public void testOrdinalPathEquivalentToFallbackPath() throws IOException {
                    }
                doc.add(new SortedDocValuesField("category", new BytesRef("tech")));
            for (int i = 0; i < 2; i++) {
                    assertEquals(2, key.size());
        for (InternalMultiTerms.Bucket bucket : result.getBuckets()) {
        int numDocs = randomIntBetween(100, 300);  
     * Convert InternalMultiTerms buckets to a sorted list of "key=count" strings for comparison.
                    asList(kwConfig(KW_FIELD_1), kwConfig(KW_FIELD_2))  
     */  
            Document doc1 = new Document();  
                    asList(kwConfig(KW_FIELD_1), kwConfig(KW_FIELD_2), kwConfig(KW_FIELD_3))
                Map<String, Long> actualCounts = new HashMap<>();  
    /**
                        assertEquals("search", b.getKey().get(0));
                fallbackBuckets = new ArrayList<>();
     */
        // Run ordinal path: 2 keyword fields
                iw.addDocument(doc);
import static java.util.Arrays.asList;  
        String[] kw2Values = { "one", "two", "three" };
        List<String> bucketStrings = new ArrayList<>();
        }
                }
    /**
            doc.add(new NumericDocValuesField(INT_FIELD, 42));
                    assertEquals("Each bucket key should have 2 elements", 2, key.size());
        int numDocs = randomIntBetween(30, 100);
            docMissingField1.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("y")));
                Document doc = new Document();
                }
                    String compositeKey = key.get(0) + "|" + key.get(1) + "|" + key.get(2);
                    .subAggregation(  
                doc.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("large")));
                    assertEquals("Each bucket key should have 3 elements", 3, key.size());  
                        assertEquals("tech inner should have 2 buckets", 2, innerResult.getBuckets().size());
                doc.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("fast")));
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(
            Document doc1 = new Document();  
    /**
            iw.close();
            // category=tech, kw1=search, kw2=fast
    @Override
            iw.addDocument(doc1);
    /**
                        assertEquals(Long.valueOf(3), innerCounts.get("search|fast"));  
    private MappedFieldType[] allFieldTypes() {
                    actualCounts.put(bucket.getKey().get(0) + "|" + bucket.getKey().get(1), bucket.getDocCount());  
     * the excluded term is absent from the results.
                doc.add(new SortedDocValuesField(KW_FIELD_3, new BytesRef(v3)));  
    @Override
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {  
public class MultiTermsOrdinalOptimizationTests extends AggregatorTestCase {
                    ((MultiTermsAggregator) createAggregator(builder, searcher, allFieldTypes())).getOrdinalBucketOrds()  
            iw.addDocument(docComplete);
                assertEquals(1, bucket.getDocCount());
                assertNull(
                doc.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("fast")));  
                for (Map.Entry<String, Long> entry : expectedCounts.entrySet()) {
                doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("search")));  
            for (int[] choice : docChoices) {
                new KeywordFieldMapper.KeywordFieldType(KW_FIELD_1),  
            iw.close();
                intToKw2.put(2L, "two");
        for (int i = 0; i < numDocs; i++) {
            CoreValuesSourceType.NUMERIC,
            iw.addDocument(doc2);
            }
                String v3 = values[randomIntBetween(0, numDistinctValues - 1)];
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {  
            doc1.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("alpha")));
                for (org.opensearch.search.aggregations.bucket.terms.Terms.Bucket outerBucket : outerResult.getBuckets()) {
     * the ordinal path (which bypasses per-field filters). Asserts both the strategy fallback and that
                    InternalMultiTerms innerResult = outerBucket.getAggregations().get("inner");
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {  
    }
    }
            }  
     * Verifies correct results regardless of which internal packing path is used.
                doc.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef(v2)));
                ordinalBuckets = bucketsToSortedStrings(result);
     * Test that a nested multi_terms (inside a parent terms agg) produces correct per-parent-bucket  
     * results. Sub-aggregations have {@code CardinalityUpperBound.MANY}, but the single-long path uses
                // Expected: (a,x)=2, (a,y)=1, (b,x)=1, (b,y)=1  
                    assertEquals("Doc count mismatch for key " + entry.getKey(), entry.getValue(), actualCounts.get(entry.getKey()));
                Map<String, Long> actualCounts = new HashMap<>();  
        List<int[]> docChoices = new ArrayList<>();  
            iw.addDocument(doc);
            iw.close();
        // Use deterministic values so we can compare across paths
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());
        Map<String, Integer> kw2ToInt = new HashMap<>();  
import org.opensearch.index.mapper.HllFieldMapper;
        }
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {
                // Only the complete doc should produce a bucket
                }  
        String[] kwValues = new String[numDistinctKw];
                for (InternalMultiTerms.Bucket bucket : result.getBuckets()) {
                TermsAggregationBuilder outer = new TermsAggregationBuilder("outer").field("category")
                // Exclude "beta" on the first field.
    private static final String KW_FIELD_3 = "kw3";
                    List<Object> key = bucket.getKey();  
                        assertEquals(Long.valueOf(2), innerCounts.get("storage|large"));
        int numDistinctValues = randomIntBetween(3, 15);  
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
     * {@link LongKeyedBucketOrds}, which keys by owning bucket, so low-cardinality fields still use the
                );
    /**
            // category=tech, kw1=storage, kw2=large  
            iw.addDocument(doc3);
            iw.close();  
                assertEquals("a", bucket.getKey().get(0));
                    actualCounts.put(compositeKey, bucket.getDocCount());  
                    .getOrdinalBucketOrds();
                        for (InternalMultiTerms.Bucket b : innerResult.getBuckets()) {  
     * still surface it as an explicit zero-count bucket (the fill path scans every doc, ignoring the
            doc2.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("x")));
    }
                assertEquals(1, bucket.getDocCount());
                    assertEquals("Each bucket key should have 2 elements", 2, key.size());
                    .build();
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {  
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());
            }
                            innerCounts.put(b.getKey().get(0) + "|" + b.getKey().get(1), b.getDocCount());
                // "beta|x" is filtered out; only "alpha|x" survives.  
                    assertEquals("Doc count mismatch for key " + entry.getKey(), entry.getValue(), actualCounts.get(entry.getKey()));  
                doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef(kw1Values[choice[0]])));  
                        Map<String, Long> innerCounts = new HashMap<>();
                    asList(kwConfig(KW_FIELD_1), intConfig())
        String[] values = new String[numDistinctValues];
        try (Directory directory = newDirectory()) {  
            CoreValuesSourceType.BYTES,  
                    assertNotNull(innerResult);  
     * then compares the sorted bucket results from both paths.
 * End-to-end tests for the packed-ordinal multi_terms path: correctness against the bytes-based  
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
                    String mapped = intToKw2.get(bucket.getKey().get(1));
            docChoices.add(new int[] { randomIntBetween(0, 2), randomIntBetween(0, 2) });
                    asList(kwConfig(KW_FIELD_1), intConfig())  
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {
            doc3.add(new SortedSetDocValuesField(KW_FIELD_2, new BytesRef("y")));
                IndexSearcher searcher = newIndexSearcher(reader);
            Document docMissingField1 = new Document();  
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());  
 *
        try (Directory directory = newDirectory()) {  
                    sb.append("|");  
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
        return new MappedFieldType[] {  
                    String compositeKey = bucket.getKey().get(0) + "|" + bucket.getKey().get(1);
                InternalMultiTerms.Bucket bucket = result.getBuckets().get(0);
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(  
import org.apache.lucene.document.Document;
                assertTrue(  
            iw.close();  
     */
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());
                String v1 = values[randomIntBetween(0, numDistinct - 1)];  
            Document doc3 = new Document();  
            kwValues[i] = randomAlphaOfLength(randomIntBetween(3, 8));  
        try (Directory directory = newDirectory()) {  
        bucketStrings.sort(Comparator.naturalOrder());
                        new MultiTermsAggregationBuilder("inner").terms(asList(kwConfig(KW_FIELD_1), kwConfig(KW_FIELD_2))).size(10)
                assertEquals("b", bucket.getKey().get(1));
            }  
import org.apache.lucene.tests.index.RandomIndexWriter;
                assertNull(
            CoreValuesSourceType.BOOLEAN  
     * Test with 2 keyword fields — exercises the PackedOrdinalBucketOrds (single-long) path.
import java.util.List;
                doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef(kw1Values[choice[0]])));
                        }
        }
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {
                assertEquals(Long.valueOf(1), actualCounts.get("alpha|x"));
        int numDocs = randomIntBetween(20, 80);  
            docMissingField2.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("b")));
        int numDocs = randomIntBetween(20, 100);  
            for (int i = 0; i < numDocs; i++) {
            sb.append("=").append(bucket.getDocCount());
        for (int i = 0; i < numDistinct; i++) {
            iw.close();
        }
            }
            doc3.add(new SortedSetDocValuesField(KW_FIELD_1, new BytesRef("b")));  
                    searcher,
            docComplete.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("x")));  
                expectedCounts.merge(v1 + "|" + v2, 1L, Long::sum);  
                IndexSearcher searcher = newIndexSearcher(reader);
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());  
            iw.close();
            Document doc = new Document();  
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
                        assertEquals("tech should have 5 docs", 5, outerBucket.getDocCount());  
                    asList(kwConfig(KW_FIELD_1), kwConfig(KW_FIELD_2))
        int numDistinctKw = randomIntBetween(3, 10);  
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());
        try (Directory directory = newDirectory()) {  
            }
 * compatible open source license.
                        assertEquals("fast", b.getKey().get(1));
     */
package org.opensearch.search.aggregations.bucket.terms;
                IndexSearcher searcher = newIndexSearcher(reader);
                for (InternalMultiTerms.Bucket bucket : result.getBuckets()) {  
     */  
            new KeywordFieldMapper.KeywordFieldType(KW_FIELD_2),
                String v1 = values[randomIntBetween(0, numDistinctValues - 1)];  
        }  
        }
