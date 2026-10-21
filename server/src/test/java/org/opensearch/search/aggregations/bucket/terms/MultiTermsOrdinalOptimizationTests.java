        try (Directory directory = newDirectory()) {
        return bucketStrings;
                assertEquals("a", bucket.getKey().get(0));
        }
        for (int i = 0; i < numDistinctValues; i++) {
            doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("a")));
        Map<String, Long> expectedCounts = new HashMap<>();
            values[i] = randomAlphaOfLength(randomIntBetween(3, 10));
        }
                doc.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef(v2)));
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(
            CoreValuesSourceType.DATE,
 * SPDX-License-Identifier: Apache-2.0
    private static final String KW_FIELD_3 = "kw3";
                new KeywordFieldMapper.KeywordFieldType(KW_FIELD_1),
                Document doc = new Document();
            Document doc2 = new Document();
            doc3.add(new SortedSetDocValuesField(KW_FIELD_2, new BytesRef("y")));
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
                IndexSearcher searcher = newIndexSearcher(reader);
            iw.addDocument(doc3);
            doc1.add(new SortedSetDocValuesField(KW_FIELD_1, new BytesRef("b")));
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(
                InternalMultiTerms result = searchAndReduce(searcher, IntPoint.newExactQuery("filter", 1), builder, allFieldTypes());
import org.apache.lucene.document.SortedSetDocValuesField;
                doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef(v1)));
        MappedFieldType fieldType,
    }
                doc.add(new NumericDocValuesField(INT_FIELD, intVal));
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());
                    .setIncludeExclude(new IncludeExclude(null, "beta"))
                // "beta|x" is filtered out; only "alpha|x" survives.
    /**
                }
            }
    }
                for (Map.Entry<String, Long> entry : expectedCounts.entrySet()) {
                IndexSearcher searcher = newIndexSearcher(reader);
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {
            }
                assertEquals("b", bucket.getKey().get(1));
                String v3 = values[randomIntBetween(0, numDistinctValues - 1)];
                    List<Object> key = bucket.getKey();
            Document doc1 = new Document();
            kwValues[i] = randomAlphaOfLength(randomIntBetween(3, 8));
            // With min_doc_count=0 it must still appear as a zero-count bucket via the zero-doc fill.
        String[] kw1Values = { "alpha", "beta", "gamma" };
            Document docMissingField1 = new Document();
     * Test with multi-valued keyword fields (SortedSetDocValuesField) to verify
            iw.addDocument(doc);
                assertEquals("a", bucket.getKey().get(0));
        }
                IndexSearcher searcher = newIndexSearcher(reader);
        }
    }
        }
    }
    private static final String KW_FIELD_2 = "kw2";
import org.apache.lucene.document.Document;
                }
                for (InternalMultiTerms.Bucket bucket : result.getBuckets()) {
                Document doc = new Document();
        return List.of(HllFieldMapper.CONTENT_TYPE);
                doc.add(new SortedDocValuesField("category", new BytesRef("tech")));
                doc.add(new SortedDocValuesField("category", new BytesRef("finance")));
                    .getOrdinalBucketOrds();
                ).size(100);
                        assertEquals("tech inner should have 2 buckets", 2, innerResult.getBuckets().size());
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());
                    String compositeKey = key.get(0) + "|" + key.get(1);
     */
                ordinalBuckets = bucketsToSortedStrings(result);
     * Test that missing values in a field correctly cause the document to be skipped
        }
            iw.close();
                }
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {
                        assertEquals("search", b.getKey().get(0));
                InternalMultiTerms.Bucket bucket = result.getBuckets().get(0);
            iw.close();
        // Generate enough distinct values to exercise the ordinal path with higher cardinality
        }
        try (Directory directory = newDirectory()) {
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
                TermsAggregationBuilder outer = new TermsAggregationBuilder("outer").field("category")
import org.apache.lucene.index.IndexReader;
    }
            doc1.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("x")));
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
                }
                    String mapped = intToKw2.get(bucket.getKey().get(1));
        }
                String v2 = values[randomIntBetween(0, numDistinctValues - 1)];
                int intVal = randomIntBetween(1, 5);
 * The OpenSearch Contributors require contributions made to
                IndexSearcher searcher = newIndexSearcher(reader);
            doc.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("b")));
            iw.addDocument(doc);
                iw.addDocument(doc);
                assertEquals("Excluded term must not appear", 1, actualCounts.size());
            doc3.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("alpha")));
     * Verifies that when not all fields are WithOrdinals, the aggregation still produces correct results.
                Map<String, Long> actualCounts = new HashMap<>();
                Map<Long, String> intToKw2 = new HashMap<>();
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
                doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef(v1)));
import org.opensearch.index.mapper.NumberFieldMapper;
                // Verify the ordinal path produced correct results (1 bucket with count 1)
            }
    @Override
        }
    /**
                    assertEquals("Each bucket key should have 2 elements", 2, key.size());
    }
        for (InternalMultiTerms.Bucket bucket : result.getBuckets()) {
                    asList(kwConfig(KW_FIELD_1), kwConfig(KW_FIELD_2))
            doc.add(new NumericDocValuesField(INT_FIELD, 42));
        return new MultiTermsAggregationBuilder("_name").terms(asList(kwConfig(fieldName), kwConfig(fieldName)));
            iw.addDocument(doc);
    /**
                IndexSearcher searcher = newIndexSearcher(reader);
import org.opensearch.index.mapper.MappedFieldType;
            bucketStrings.add(sb.toString());
        try (Directory directory = newDirectory()) {
            doc.add(new SortedDocValuesField(KW_FIELD_3, new BytesRef("c")));
        }
                intToKw2.put(3L, "three");
     */
                IndexSearcher searcher = newIndexSearcher(reader);
    public void testMissingValueDocumentSkippedOnOrdinalPath() throws IOException {
    }
                iw.addDocument(doc);
                assertTrue(
                    asList(kwConfig(KW_FIELD_1), kwConfig(KW_FIELD_2), kwConfig(KW_FIELD_3))
    /**
                doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("search")));
                    }
     * Indexes random documents with 3 keyword fields, runs multi_terms aggregation,
            iw.addDocument(docMissingField1);
                // correctness alone would also hold on the byte-key fallback path.
            new KeywordFieldMapper.KeywordFieldType(KW_FIELD_3),
                iw.addDocument(doc);
                Document doc = new Document();
                Map<String, Long> actualCounts = new HashMap<>();
                // Verify every bucket matches expected counts
                assertEquals(Long.valueOf(1), actualCounts.get("alpha|x"));
                InternalMultiTerms.Bucket bucket = result.getBuckets().get(0);
            for (int i = 0; i < numDocs; i++) {
                ).size(100);
                doc.add(new NumericDocValuesField(INT_FIELD, kw2ToInt.get(kw2Values[choice[1]])));
    public void testMultiValuedKeywordFieldsOrdinalPath() throws IOException {
                MultiTermsBucketOrds strategy = ((MultiTermsAggregator) createAggregator(builder, searcher, allFieldTypes()))
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {
                for (InternalMultiTerms.Bucket bucket : result.getBuckets()) {
    }
     * Regression test for the include/exclude gate: an all-keyword multi_terms carrying an
            }
                    "include/exclude must force the byte-key fallback",
            }
            }
                    actualCounts.put(bucket.getKey().get(0) + "|" + bucket.getKey().get(1), bucket.getDocCount());
            }
     * and verifies results match expected bucket keys and doc counts.
                    actualCounts.put(compositeKey, bucket.getDocCount());
        try (Directory directory = newDirectory()) {
                        assertEquals("fast", b.getKey().get(1));
            // Doc 3: kw1=[b], kw2=[y] → buckets: (b,y)
        return List.of(
                Document doc = new Document();
                assertEquals(1, result.getBuckets().size());
import org.apache.lucene.store.Directory;
                Document doc = new Document();
                assertEquals("Bucket count mismatch", expectedCounts.size(), actualCounts.size());
                }
                InternalMultiTerms.Bucket bucket = result.getBuckets().get(0);
     * Convert InternalMultiTerms buckets to a sorted list of "key=count" strings for comparison.
        }
                String v2 = values[randomIntBetween(0, numDistinct - 1)];
    public void testStrategySelectionTwoKeywordFields() throws IOException {
            }
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());
                    );
    private MappedFieldType[] allFieldTypes() {
    public void testIncludeExcludeForcesByteKeyFallback() throws IOException {
                for (InternalMultiTerms.Bucket bucket : result.getBuckets()) {
    /**
                assertEquals("c", bucket.getKey().get(2));
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(
            for (int i = 0; i < bucket.getKey().size(); i++) {
    public void testStrategySelectionMixedFieldsFallback() throws IOException {
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
     * Test with min_doc_count=0 on the ordinal path. The {@code alpha|y} combination is indexed but
import org.apache.lucene.tests.index.RandomIndexWriter;
import org.apache.lucene.document.IntPoint;
                    asList(kwConfig(KW_FIELD_1), intConfig())
                Document doc = new Document();
                doc.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef(kw2Values[choice[1]])));
                doc.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef(v2)));
            doc2.add(new SortedSetDocValuesField(KW_FIELD_1, new BytesRef("a")));
            doc2.add(new SortedSetDocValuesField(KW_FIELD_2, new BytesRef("x")));
            doc2.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("x")));
            }
                ).size(100).minDocCount(0);
            iw.close();
        String[] kwValues = new String[numDistinctKw];
            // category=finance, kw1=search, kw2=fast
        Map<String, Integer> kw2ToInt = new HashMap<>();
 * missing values, include/exclude).
                assertEquals("Bucket count mismatch", expectedCounts.size(), actualCounts.size());
                expectedCounts.merge(v1 + "|" + v2, 1L, Long::sum);
            docComplete.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("a")));
                    asList(kwConfig(KW_FIELD_1), kwConfig(KW_FIELD_2))
            doc2.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("beta")));
                assertEquals("a", bucket.getKey().get(0));
            doc1.add(new IntPoint("filter", 1));
    /**
            docChoices.add(new int[] { randomIntBetween(0, 2), randomIntBetween(0, 2) });
                Map<String, Long> actualCounts = new HashMap<>();
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(
                );
        String[] values = new String[numDistinct];
            // Doc with only field2 — should be skipped (no kw1 value)
                    asList(kwConfig(KW_FIELD_1), kwConfig(KW_FIELD_2), kwConfig(KW_FIELD_3))
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
    }
    ) {
            iw.close();
                }
            for (int i = 0; i < numDocs; i++) {
     * Test with high-cardinality fields to exercise the ordinal path with many distinct values.
                iw.addDocument(doc);
                assertNotNull("three keyword fields should select the packed-ordinal path", strategy);
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
        // Run ordinal path: 2 keyword fields
        List<String> ordinalBuckets;
 *
                    ((MultiTermsAggregator) createAggregator(builder, searcher, allFieldTypes())).getOrdinalBucketOrds()
                // Query matches only filter=1 docs, so alpha|y collects no matching documents.
            new KeywordFieldMapper.KeywordFieldType(KW_FIELD_2),
                doc.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("x")));
        int numDistinct = randomIntBetween(50, 200);
            new KeywordFieldMapper.KeywordFieldType(KW_FIELD_1),
            Document doc2 = new Document();
            values[i] = String.format(Locale.ROOT, "%05d_%s", i, randomAlphaOfLength(5));
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(
                for (org.opensearch.search.aggregations.bucket.terms.Terms.Bucket outerBucket : outerResult.getBuckets()) {
                for (Map.Entry<String, Long> entry : expectedCounts.entrySet()) {
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
            for (int[] choice : docChoices) {
    /**
     */
import org.opensearch.search.aggregations.AggregatorTestCase;
        int numDocs = randomIntBetween(20, 80);
        );
            sb.append("=").append(bucket.getDocCount());
                assertEquals(Long.valueOf(1), actualCounts.get("beta|x"));
        }
    public void testStrategySelectionThreeKeywordFields() throws IOException {
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
                }
                IndexSearcher searcher = newIndexSearcher(reader);
                // The excluded combination must be present as an explicit zero-count bucket.
                    asList(kwConfig(KW_FIELD_1), kwConfig(KW_FIELD_2))
                    assertEquals("Doc count mismatch for key " + entry.getKey(), entry.getValue(), actualCounts.get(entry.getKey()));
                    List<Object> key = bucket.getKey();
        for (int i = 0; i < numDistinct; i++) {
            }
            for (int i = 0; i < numDocs; i++) {
                    InternalMultiTerms innerResult = outerBucket.getAggregations().get("inner");
                // A field carrying include/exclude must not take the ordinal path.
                );
                    assertEquals(2, key.size());
                assertEquals(1, result.getBuckets().size());
    }
     */
                ).size(expectedCounts.size() + 10);
                    .getOrdinalBucketOrds();
        int numDocs = randomIntBetween(100, 300);
    }
import org.apache.lucene.search.MatchAllDocsQuery;
                Map<String, Long> actualCounts = new HashMap<>();
                iw.addDocument(doc);
        Map<String, Long> expectedCounts = new HashMap<>();
    private MultiTermsValuesSourceConfig kwConfig(String field) {
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {
                IndexSearcher searcher = newIndexSearcher(reader);
            iw.addDocument(doc2);
                    asList(kwConfig(KW_FIELD_1), kwConfig(KW_FIELD_2))
                        assertEquals("finance inner should have 1 bucket", 1, innerResult.getBuckets().size());
                        for (InternalMultiTerms.Bucket b : innerResult.getBuckets()) {
                String v1 = values[randomIntBetween(0, numDistinct - 1)];
        try (Directory directory = newDirectory()) {
        try (Directory directory = newDirectory()) {
                        Map<String, Long> innerCounts = new HashMap<>();
            }
 * compatible open source license.
     */
    }
                InternalMultiTerms.Bucket bucket = result.getBuckets().get(0);
import java.util.ArrayList;
                    "low-cardinality fields should use the single-long path",
                String v1 = values[randomIntBetween(0, numDistinctValues - 1)];
                }
                iw.addDocument(doc);
                    fieldTypes
                        assertEquals("tech should have 5 docs", 5, outerBucket.getDocCount());
                assertEquals(1, bucket.getDocCount());
        String[] values = new String[numDistinctValues];
     * {@code PackedOrdinalBucketOrdsTests#testCreateTwoLongFallsBackUnderManyCardinality}).
            // category=tech, kw1=storage, kw2=large
            iw.close();
     */
                    outer,
import java.util.Comparator;
     * results. Sub-aggregations have {@code CardinalityUpperBound.MANY}, but the single-long path uses
    protected List<String> unsupportedMappedFieldTypes() {
            iw.addDocument(docMissingField2);
                iw.addDocument(doc);
package org.opensearch.search.aggregations.bucket.terms;
     * and verifies results match expected bucket keys and doc counts.
                ).size(numDistinctValues * numDistinctValues * numDistinctValues + 10);
        int numDocs = randomIntBetween(30, 100);
                // A non-ordinal (numeric) field must force the byte-key fallback: no ordinal strategy.
                Map<String, Long> actualCounts = new HashMap<>();
                // Convert int keys to the kw2 equivalent for comparison
            iw.close();
    /**
        try (Directory directory = newDirectory()) {
        try (Directory directory = newDirectory()) {
                doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef(v1)));
        try (Directory directory = newDirectory()) {
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {
                for (InternalMultiTerms.Bucket bucket : result.getBuckets()) {
                IndexSearcher searcher = newIndexSearcher(reader);
                assertNull(
        String[] values = new String[numDistinctValues];
    /**
                    asList(kwConfig(KW_FIELD_1), kwConfig(KW_FIELD_2))
                // Assert the packed-ordinal (single-long) strategy is actually selected — result
        }
                    assertEquals("Each bucket key should have 3 elements", 3, key.size());
        try (Directory directory = newDirectory()) {
            CoreValuesSourceType.BYTES,
            // category=tech, kw1=search, kw2=fast
                sb.append(bucket.getKey().get(i));
                assertEquals("Bucket count mismatch", expectedCounts.size(), actualCounts.size());
            iw.addDocument(doc3);
                intToKw2.put(2L, "two");
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());
        }
            iw.close();
                assertEquals(1, result.getBuckets().size());
                assertTrue(
    }
                }
            doc2.add(new SortedSetDocValuesField(KW_FIELD_2, new BytesRef("y")));
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {
                // Exclude "beta" on the first field.
        int numDocs = randomIntBetween(20, 100);
                    assertEquals("Doc count mismatch for key " + entry.getKey(), entry.getValue(), actualCounts.get(entry.getKey()));
     */
                    String compositeKey = bucket.getKey().get(0) + "|" + bucket.getKey().get(1);
                IndexSearcher searcher = newIndexSearcher(reader);
            }
                }
import java.util.Map;
                    asList(kwConfig(KW_FIELD_1), kwConfig(KW_FIELD_2))
                    assertEquals("Doc count mismatch for key " + entry.getKey(), entry.getValue(), actualCounts.get(entry.getKey()));
                assertEquals(1, bucket.getDocCount());
                assertEquals(Long.valueOf(1), actualCounts.get("a|y"));
                    actualCounts.put(compositeKey, bucket.getDocCount());
            for (int i = 0; i < 2; i++) {
                org.opensearch.search.aggregations.bucket.terms.Terms outerResult = searchAndReduce(
                ).size(numDistinctValues * numDistinctValues + 10);
                        assertEquals(4, b.getDocCount());
                expectedCounts.merge(v1 + "|" + v2 + "|" + v3, 1L, Long::sum);
            iw.addDocument(docComplete);
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
     */
import java.util.HashMap;
                assertNull(
                }
                    String compositeKey = key.get(0) + "|" + key.get(1) + "|" + key.get(2);
        }
        Map<String, Long> expectedCounts = new HashMap<>();
                    "low-cardinality fields should use the single-long path",
            docComplete.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("x")));
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());
        }
                    fallbackBuckets.add(kw + "|" + mapped + "=" + bucket.getDocCount());
            for (String v1 : new String[] { "alpha", "beta" }) {
        kw2ToInt.put("one", 1);
                doc.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("fast")));
    /**
                    } else {
            iw.close();
    public void testTwoKeywordFieldsPairPackingPath() throws IOException {
                assertEquals(4, actualCounts.size());
    @Override
                doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("search")));
            iw.addDocument(doc2);
                    ((PackedOrdinalBucketOrds) strategy).isSingleLongPath()
     * Verify that 3 keyword fields select the PackedOrdinalBucketOrds strategy (single-long path for low cardinality).
            doc.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("b")));
                doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef(kw1Values[choice[0]])));
                    new MatchAllDocsQuery(),
     * Test equivalence between ordinal path (2 keyword fields) and fallback path (keyword + int)
        try (Directory directory = newDirectory()) {
     * packed-ordinal path here — only the two-long path falls back under MANY (see
                    assertEquals("Doc count mismatch for key " + entry.getKey(), entry.getValue(), actualCounts.get(entry.getKey()));
        kw2ToInt.put("two", 2);
            Document doc = new Document();
        // Use deterministic values so we can compare across paths
                ).size(100);
        for (int i = 0; i < numDistinctValues; i++) {
                doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("storage")));
        bucketStrings.sort(Comparator.naturalOrder());
                String v2 = values[randomIntBetween(0, numDistinctValues - 1)];
                doc.add(new SortedDocValuesField("category", new BytesRef("tech")));
                assertEquals(1, bucket.getDocCount());
                MultiTermsValuesSourceConfig kw1WithExclude = new MultiTermsValuesSourceConfig.Builder().setFieldName(KW_FIELD_1)
            }
                    asList(kwConfig(KW_FIELD_1), intConfig())
    /**
                );
                IndexSearcher searcher = newIndexSearcher(reader);
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(
            for (int[] choice : docChoices) {
            docMissingField1.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("y")));
    private MultiTermsValuesSourceConfig intConfig() {
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());
            // Two docs that match the query (filter=1) and are counted normally.
import org.apache.lucene.document.NumericDocValuesField;
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(
                assertNull("beta must be excluded", actualCounts.get("beta|x"));
                );
     * when using the ordinal collection path.
                Document doc = new Document();
    private static final String KW_FIELD_1 = "kw1";
                    List<Object> key = bucket.getKey();
import org.apache.lucene.util.BytesRef;
     * using the same underlying data. Indexes documents with both keyword and numeric representations,
/*
            docMissingField2.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("b")));
                        assertEquals(Long.valueOf(2), innerCounts.get("storage|large"));
                assertEquals("b", bucket.getKey().get(1));
            // Doc with both fields present
                    List<Object> key = bucket.getKey();
        assertEquals("Ordinal and fallback paths should produce equivalent results", ordinalBuckets, fallbackBuckets);
                assertEquals("Bucket count mismatch for high-cardinality test", expectedCounts.size(), actualCounts.size());
                String kw1 = kwValues[randomIntBetween(0, numDistinctKw - 1)];
            new NumberFieldMapper.NumberFieldType(INT_FIELD, NumberFieldMapper.NumberType.INTEGER) };
                for (InternalMultiTerms.Bucket bucket : result.getBuckets()) {
            }
                        assertEquals(Long.valueOf(3), innerCounts.get("search|fast"));
import java.util.Locale;
                assertEquals(1, bucket.getDocCount());
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {
            values[i] = randomAlphaOfLength(randomIntBetween(3, 10));
        for (int i = 0; i < numDocs; i++) {
        }
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {
                    actualCounts.put(compositeKey, bucket.getDocCount());
    public void testOrdinalPathEquivalentToFallbackPath() throws IOException {
            // Doc with only field1 — should be skipped (no kw2 value)
        return new MultiTermsValuesSourceConfig.Builder().setFieldName(INT_FIELD).build();
import org.apache.lucene.search.IndexSearcher;
     */
            CoreValuesSourceType.BOOLEAN
        return new MultiTermsValuesSourceConfig.Builder().setFieldName(field).build();
        return new MappedFieldType[] {
        int numDistinctKw = randomIntBetween(3, 10);
        }
                    ((PackedOrdinalBucketOrds) strategy).isSingleLongPath()
            CoreValuesSourceType.NUMERIC,
     * {@link LongKeyedBucketOrds}, which keys by owning bucket, so low-cardinality fields still use the
            iw.close();
            iw.close();
     */
        for (int i = 0; i < numDistinctKw; i++) {
                // Outer terms agg on "category", inner multi_terms on kw1 × kw2
            for (int i = 0; i < numDocs; i++) {
            }
import org.opensearch.index.mapper.HllFieldMapper;
                ).size(numDistinctKw * 5 + 10);
                assertTrue("Expected zero-doc bucket alpha|y to be present", actualCounts.containsKey("alpha|y"));
        int numDocs = randomIntBetween(20, 80);
                assertEquals("Only 1 bucket for the complete doc", 1, result.getBuckets().size());
        try (Directory directory = newDirectory()) {
    public void testThreeKeywordFieldsPackedOrdinalsPath() throws IOException {
                    actualCounts.put(bucket.getKey().get(0) + "|" + bucket.getKey().get(1), bucket.getDocCount());
    }
 * this file be licensed under the Apache-2.0 license or a
            iw.addDocument(doc1);
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {
     * still surface it as an explicit zero-count bucket (the fill path scans every doc, ignoring the
     * Test with mixed keyword + numeric fields — exercises the BytesKeyedBucketOrds fallback path.
    }
            MappedFieldType[] fieldTypes = new MappedFieldType[] {
        // Run fallback path: keyword + int (forces BytesKeyedBucketOrds)
                IndexSearcher searcher = newIndexSearcher(reader);
                doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef(v1)));
                    asList(kw1WithExclude, kwConfig(KW_FIELD_2))
            doc1.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("alpha")));
                fallbackBuckets.sort(Comparator.naturalOrder());
                );
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(
            doc3.add(new IntPoint("filter", 0));
                }
                    sb.append("|");
                for (InternalMultiTerms.Bucket bucket : result.getBuckets()) {
     * the cartesian product is correctly generated in the ordinal path.
    }
 */
            // The alpha|y combination exists in the index but is excluded by the query (filter=0).
     * Verify that mixed keyword + numeric fields fall back to the bytes-based path and still produce correct results.
                doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef(kw1Values[choice[0]])));
                    asList(kwConfig(KW_FIELD_1), kwConfig(KW_FIELD_2))
                // Verify outer buckets
                    assertEquals("Each bucket key should have 2 elements", 2, key.size());
            CoreValuesSourceType.IP,
                    String compositeKey = key.get(0) + "|" + key.get(1);
                Document doc = new Document();
     * excluded from the query, so it collects zero matching docs; {@code collectZeroDocOrdinals} must
                );
        int numDistinctValues = randomIntBetween(2, 8);
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(
import static java.util.Arrays.asList;
            doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("a")));
            Document doc3 = new Document();
                assertEquals("alpha|y must be a zero-count bucket", Long.valueOf(0), actualCounts.get("alpha|y"));
     * the ordinal path (which bypasses per-field filters). Asserts both the strategy fallback and that
            }
    public void testHighCardinalityKeywordFields() throws IOException {
            iw.close();
        // Map kw2 values to integers for the fallback path
                iw.addDocument(doc);
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {
                Map<String, Long> actualCounts = new HashMap<>();
    /**
                Document doc = new Document();
        String[] kw2Values = { "one", "two", "three" };
                assertEquals(Long.valueOf(1), actualCounts.get("b|x"));
import org.apache.lucene.document.SortedDocValuesField;
import org.opensearch.search.aggregations.support.MultiTermsValuesSourceConfig;
                    searcher,
            for (int i = 0; i < 4; i++) {
        try (Directory directory = newDirectory()) {
                        new MultiTermsAggregationBuilder("inner").terms(asList(kwConfig(KW_FIELD_1), kwConfig(KW_FIELD_2))).size(10)
                );
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());
            }
                Map<String, Long> actualCounts = new HashMap<>();
    @Override
    public void testMinDocCountZeroOrdinalPath() throws IOException {
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
                new KeywordFieldMapper.KeywordFieldType(KW_FIELD_2) };
                IndexSearcher searcher = newIndexSearcher(reader);
     * the excluded term is absent from the results.
    public void testMixedKeywordAndNumericFallbackPath() throws IOException {
     * Test with 3 keyword fields — exercises the PackedOrdinalBucketOrds (single-long) path.
                intToKw2.put(1L, "one");
     * Verifies correct results regardless of which internal packing path is used.
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
                iw.addDocument(doc);
    }
                );
                assertEquals(2, outerResult.getBuckets().size());
    public void testNestedMultiTermsCorrectPerParentBucket() throws IOException {
                assertEquals(Long.valueOf(1), actualCounts.get("alpha|x"));
        String fieldName
        int numDistinctValues = randomIntBetween(3, 15);
                    "mixed keyword+numeric fields must fall back to the byte-key path",
            // Doc 1: kw1=[a,b], kw2=[x] → buckets: (a,x), (b,x)
            iw.close();
                IndexSearcher searcher = newIndexSearcher(reader);
                    asList(kwConfig(KW_FIELD_1), intConfig())
            Document doc = new Document();
     */
                    .size(10)
            }
                    .subAggregation(
     */
 * End-to-end tests for the packed-ordinal multi_terms path: correctness against the bytes-based
import java.util.List;
                fallbackBuckets = new ArrayList<>();
                for (Map.Entry<String, Long> entry : expectedCounts.entrySet()) {
import org.opensearch.index.mapper.KeywordFieldMapper;
            doc1.add(new SortedSetDocValuesField(KW_FIELD_1, new BytesRef("a")));
                    actualCounts.put(compositeKey, bucket.getDocCount());
        List<String> bucketStrings = new ArrayList<>();
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(
            for (int i = 0; i < 3; i++) {
     * {@code exclude} filter must fall back to the byte-key path (which applies the filter) instead of
/**
            RandomIndexWriter iw = new RandomIndexWriter(random(), directory);
    /**
            iw.addDocument(doc1);
     */
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());
                assertEquals("a", bucket.getKey().get(0));
                    String kw = (String) bucket.getKey().get(0);
            }
            }
                doc.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("large")));
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());
                MultiTermsBucketOrds strategy = ((MultiTermsAggregator) createAggregator(builder, searcher, allFieldTypes()))
                for (InternalMultiTerms.Bucket bucket : result.getBuckets()) {
            MappedFieldType categoryType = new KeywordFieldMapper.KeywordFieldType("category");
                        }
                    ((MultiTermsAggregator) createAggregator(builder, searcher, allFieldTypes())).getOrdinalBucketOrds()
        List<String> fallbackBuckets;
     * Verify that 2 keyword fields select the PackedOrdinalBucketOrds strategy (single-long path).
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {
            Document doc1 = new Document();
                doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef(kw1)));
            Document doc = new Document();
            iw.close();
            }
    }
                // Use a large size to capture all buckets
                if (i > 0) {
     * then compares the sorted bucket results from both paths.
            Document docComplete = new Document();
                assertEquals(42L, bucket.getKey().get(1));
            iw.close();
                assertEquals(Long.valueOf(1), actualCounts.get("b|y"));
     * Indexes random documents with 2 keyword fields, runs multi_terms aggregation,
import org.opensearch.search.aggregations.support.ValuesSourceType;
     * Test that a nested multi_terms (inside a parent terms agg) produces correct per-parent-bucket
            Document doc3 = new Document();
            // Doc 2: kw1=[a], kw2=[x,y] → buckets: (a,x), (a,y)
                InternalMultiTerms result = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, allFieldTypes());
                    String compositeKey = key.get(0) + "|" + key.get(1);
                // Expected: (a,x)=2, (a,y)=1, (b,x)=1, (b,y)=1
                    if ("tech".equals(outerBucket.getKeyAsString())) {
public class MultiTermsOrdinalOptimizationTests extends AggregatorTestCase {
                doc.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef(v2)));
    }
        try (Directory directory = newDirectory()) {
                    actualCounts.put(compositeKey, bucket.getDocCount());
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
        Map<String, Long> expectedCounts = new HashMap<>();
                ).size(100);
    private static final String INT_FIELD = "int_val";
     * query).
    /**
                assertNotNull("two keyword fields should select the packed-ordinal path", strategy);
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(
            try (DirectoryReader unwrapped = DirectoryReader.open(directory); IndexReader reader = wrapDirectoryReader(unwrapped)) {
            doc3.add(new SortedSetDocValuesField(KW_FIELD_1, new BytesRef("b")));
import org.apache.lucene.index.DirectoryReader;
                for (Map.Entry<String, Long> entry : expectedCounts.entrySet()) {
                doc.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("fast")));
                String v1 = values[randomIntBetween(0, numDistinctValues - 1)];
 * path, strategy selection and fallback, and edge cases (multi-valued fields, min_doc_count=0,
        }
                assertEquals("x", bucket.getKey().get(1));
            doc3.add(new SortedDocValuesField(KW_FIELD_2, new BytesRef("y")));
 */
                // Only the complete doc should produce a bucket
                iw.addDocument(doc);
            }
                assertEquals(Long.valueOf(2), actualCounts.get("a|x"));
            doc1.add(new SortedSetDocValuesField(KW_FIELD_2, new BytesRef("x")));
     * Test with 2 keyword fields — exercises the PackedOrdinalBucketOrds (single-long) path.
            doc2.add(new IntPoint("filter", 1));
                categoryType,
}
            StringBuilder sb = new StringBuilder();
                expectedCounts.merge(v1 + "|" + v2, 1L, Long::sum);
                Document doc = new Document();
        }
                ).size(10);
import java.io.IOException;
            }
                    assertNotNull(innerResult);
            Document docMissingField2 = new Document();
                    .build();
                doc.add(new SortedDocValuesField(KW_FIELD_3, new BytesRef(v3)));
                        assertEquals("finance should have 4 docs", 4, outerBucket.getDocCount());
        kw2ToInt.put("three", 3);
                            innerCounts.put(b.getKey().get(0) + "|" + b.getKey().get(1), b.getDocCount());
                        InternalMultiTerms.Bucket b = innerResult.getBuckets().get(0);
     */
            }
            doc.add(new SortedDocValuesField(KW_FIELD_1, new BytesRef("a")));
                MultiTermsAggregationBuilder builder = new MultiTermsAggregationBuilder("test_agg").terms(
                expectedCounts.merge(kw1 + "|" + intVal, 1L, Long::sum);
        List<int[]> docChoices = new ArrayList<>();
                for (InternalMultiTerms.Bucket bucket : result.getBuckets()) {
                        assertEquals("finance", outerBucket.getKeyAsString());
    private List<String> bucketsToSortedStrings(InternalMultiTerms result) {
                }
    }
                }
            }
    protected org.opensearch.search.aggregations.AggregationBuilder createAggBuilderForTypeTest(
