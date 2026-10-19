        String index1 = "test-hll-precision-12";
                }
        // Refresh and verify
                .setSource(
        client().admin().indices().prepareCreate(indexName).setMapping(mapping).get();
        assertEquals("Precision should match", precision, hllFieldType.precision());
        assertNotNull("HLL field should be created", fieldType);
        HyperLogLogPlusPlus expectedMerged = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
    }
        long docCount = client().prepareSearch(indexName).setSize(0).get().getHits().getTotalHits().value();
            client().prepareIndex(indexName)
    public void testCardinalityAggregationWithBuckets() throws IOException {
            .field("type", "hll")
            Terms.Bucket withoutHllBucket = termsAgg.getBucketByKey("without_hll");
            try {
            .startObject()
        // mismatched HLL precision configurations
                    // Each sketch has unique values
        // Verify the error mentions precision mismatch
                        .setSource(
            org.apache.lucene.util.BytesRef bytesRef = out.bytes().toBytesRef();
                    byte[] sketchBytes = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);
                .setSource(XContentFactory.jsonBuilder().startObject().field("sketch", sketchBytes1).endObject())
        int precision2 = 14;
            .startObject("user_sketch")
            // Index documents WITH HLL field
 */
                expected.collect(0, hash);
        // Create and index sketch with precision 12 in first index
        // Create index with HLL field mapping
        // This should fail because the indices have different precisions for the same field
        // Test that cardinality aggregation merges multiple HLL sketches correctly
            assertEquals("Aggregation should merge sketches correctly", expectedCardinality, aggregatedCardinality);
            sketch2.close();
            .startObject("properties")
            client().prepareIndex(indexName)
            byte[] sketchBytes = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);
                sketch.writeTo(0, out);
            expectedMerged.close();
            .startObject()
            // Test 3: Search for documents without HLL field
                // Each hour has some unique users
                    for (int i = 0; i < valuesPerDoc; i++) {
        } finally {
                long hash = mix64(i);
                        XContentFactory.jsonBuilder()
                    .setSource(
            // Verify the bucket without HLL field has zero cardinality
            org.apache.lucene.util.BytesRef bytesRef2 = out2.bytes().toBytesRef();
            .startObject("hourly_users")
                docsWithoutHll,
                .setSource(XContentFactory.jsonBuilder().startObject().field("sketch", sketchBytes2).endObject())
    }
            assertTrue(
            "Error should mention precision mismatch. Got: " + fullMessage,
        // Test that HLL fields work correctly when some documents have the field and others don't
            BytesStreamOutput out2 = new BytesStreamOutput();
                .setId("1")
            // Refresh to make the document searchable
        );
                    sketch.collect(0, mix64(baseUserId + i));
    public void testSimpleTwoSketchMerge() throws IOException {
                        .field("timestamp", "2024-01-01T00:00:00Z")
            } finally {
        client().admin().indices().prepareRefresh(indexName).get();
                .get();
            .startObject("properties")
            for (int i = 0; i < docsWithHll; i++) {
        Terms termsAgg = response.getAggregations().get("by_category");
            .endObject()
import org.opensearch.action.search.SearchPhaseExecutionException;
                            .field("category", "without_hll")
/*
        });
            .endObject();
            .addAggregation(terms("by_category").field("category").subAggregation(cardinality("users_per_category").field("user_sketch")))
import java.util.Arrays;
            SearchResponse getDocWithHll = client().prepareSearch(indexName).setQuery(termQuery("category", "with_hll")).setSize(1).get();
                client().prepareIndex(indexName)
            .endObject()
        int precision = 11;
            byte[] sketchBytes2 = Arrays.copyOfRange(bytesRef2.bytes, bytesRef2.offset, bytesRef2.offset + bytesRef2.length);
        }
            // Sketch 2: values 100-199
            .endObject()
            .endObject();
 * The OpenSearch Contributors require contributions made to
            // The aggregated cardinality should match the cardinality from expected expectedMerged
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        }
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            client().admin().indices().prepareRefresh(indexName).get();
                HyperLogLogPlusPlus sketch = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
    public void testCardinalityAggregationMergesMultipleSketches() throws IOException {
                } finally {
            org.apache.lucene.util.BytesRef bytesRef = out.bytes().toBytesRef();
            assertEquals("Should find document with HLL field", 1, getDocWithHll.getHits().getHits().length);
            .endObject()
            );
                        long hash = mix64(value);
            long expectedCardinality = expectedMerged.cardinality(0);
            SearchResponse response = client().prepareSearch(indexName)
                    .setSource(
        client().admin().indices().prepareCreate(indexName).setMapping(mapping).get();
                    .get();
        // Create an HLL sketch with some user IDs
            assertNotNull("Should have bucket for 'with_hll' category", withHllBucket);
                                .endObject()
 * SPDX-License-Identifier: Apache-2.0
        client().admin().indices().prepareCreate(indexName).setMapping(mapping).get();
        try {
                "Should find only documents without HLL field",
        for (int hour = 0; hour < numHours; hour++) {
            assertEquals("Bucket should have correct doc count", docsWithoutHll, withoutHllBucket.getDocCount());
            BytesStreamOutput out = new BytesStreamOutput();
            byte[] sketchBytes = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);
            .field("precision", precision1)
            for (int i = 100; i < 200; i++) {
            assertFalse(
                .get();
public class HllFieldMapperIntegrationTests extends OpenSearchSingleNodeTestCase {
        String[] categories = { "electronics", "books", "clothing" };
                        sketch.collect(0, hash);
            .field("type", "date")
    }
            assertEquals("Should merge both sketches", expectedCard, result);
                        .get();
        HyperLogLogPlusPlus sketch1 = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
        String indexName = "test-hll-merge-aggregation";
                        sketch.collect(0, hash);
                    )
 *
                bucketCardinality > 0 && bucketCardinality <= valuesPerCategory * 1.2
                    client().prepareIndex(indexName)
            Cardinality withoutHllCardinality = withoutHllBucket.getAggregations().get("users_per_category");
        // Create index
        client().admin().indices().prepareCreate(indexName).setMapping(mapping).get();
            .field("precision", precision)
        MapperService mapperService = getInstanceFromNode(IndicesService.class).indexServiceSafe(resolveIndex(indexName)).mapperService();
        for (Bucket bucket : termsAgg.getBuckets()) {
        int docsWithoutHll = 2;
    }
                try {
                sketch.close();
                .get();
            sketch2.writeTo(0, out);
            for (int i = 0; i < 50; i++) {
                for (int userId = hour * 10; userId < hour * 10 + 50; userId++) {
        // Create index
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        int precision = 11;
            .field("type", "date")
        try {
                            .startObject()
        long expectedCardinality = 500;
            .startObject()
                .get();
                withoutHllResponse.getHits().getTotalHits().value()
                    XContentFactory.jsonBuilder()
                    .get();
            .field("type", "keyword")
        client().admin().indices().prepareRefresh(indexName).get();
            .field("type", "keyword")
            }
            .field("type", "hll")
                    }
        // Create index with HLL field and other fields
        int precision = 12;
                        long value = (long) i * valuesPerSketch + j;
                    .get();
                "Document should contain user_sketch field",
    }
            SearchResponse withHllResponse = client().prepareSearch(indexName)
            for (int docIdx = 0; docIdx < numDocs; docIdx++) {
                            .startObject()
import static org.opensearch.search.aggregations.AggregationBuilders.cardinality;
                expected.collect(0, hash);
            BytesStreamOutput out1 = new BytesStreamOutput();
import org.opensearch.test.OpenSearchSingleNodeTestCase;
                sketch1.collect(0, hash);
        SearchPhaseExecutionException exception = expectThrows(SearchPhaseExecutionException.class, () -> {
        }
                        expectedMerged.collect(0, hash);
        Throwable cause = exception.getCause();
        // Run terms aggregation with cardinality sub-aggregation
import org.opensearch.search.aggregations.metrics.Cardinality;
/**
            assertNotNull("Bucket should have cardinality aggregation", withoutHllCardinality);
            .endObject();
            assertEquals("Bucket should have correct doc count", docsWithHll, withHllBucket.getDocCount());
                sketch.close();
            .startObject("timestamp")
            assertEquals("Cardinality should only aggregate documents with HLL field", expectedCardinality, aggregatedCardinality);
            .field("type", "hll")
            .field("precision", precision)
            .endObject()
            long bucketCardinality = cardAgg.getValue();
    public void testProgrammaticFieldCreation() throws IOException {
                sketch.collect(0, mix64(userId));
        } finally {
                client().prepareIndex(indexName)
            // Index both sketches
            expected.close();
                        long value = (long) docIdx * valuesPerDoc + i;
            .field("precision", precision2)
    public void testDataIngestion() throws IOException {
                sketch1.collect(0, mix64(i));
                            // No user_sketch field
            .endObject()
                .setQuery(termQuery("category", "without_hll"))
    }
            sketch.writeTo(0, out);
    }
            // Test 1: Verify all documents are indexed
        // Create and index sketch with precision 14 in second index
            assertEquals("All documents should be indexed", docsWithHll + docsWithoutHll, allDocsResponse.getHits().getTotalHits().value());
        // Index documents: some with HLL field, some without
            }
            sketch1.writeTo(0, out1);
                            .field("timestamp", "2024-01-0" + (docsWithHll + i + 1) + "T00:00:00Z")
            // Index documents WITHOUT HLL field
        XContentBuilder mapping = XContentFactory.jsonBuilder()
                        .get();
                sketch.writeTo(0, out);
                sketch2.collect(0, mix64(i + 100));
                        XContentFactory.jsonBuilder()
        // Index multiple hourly rollup documents
            assertEquals("Aggregation should merge sketches correctly", expectedMerged.cardinality(0), aggregatedCardinality);
                                .startObject()
 * Integration tests for HLL field mapper demonstrating programmatic field creation
                    sketch.collect(0, mix64(userId));
        // Create two simple sketches
            long result = response.getAggregations().<org.opensearch.search.aggregations.metrics.Cardinality>get("test").getValue();
            .field("precision", precision)
                    BytesStreamOutput out = new BytesStreamOutput();
            sketch1.writeTo(0, out);
                        .startObject()
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        int valuesPerCategory = 100;
            .endObject();
import java.io.IOException;
                .addAggregation(cardinality("total_users").field("hourly_users"))
            assertNotNull("Cardinality aggregation should return a result", cardinalityAgg);
                .get();
                    org.apache.lucene.util.BytesRef bytesRef = out.bytes().toBytesRef();
                            .field("hour", "2024-01-01T" + String.format(java.util.Locale.ROOT, "%02d", hour) + ":00:00Z")
            sketch2.close();
            assertEquals("Should find document without HLL field", 1, getDocWithoutHll.getHits().getHits().length);
            .endObject()
                                .field("user_sketch", sketchBytes)
        String fullMessage = errorMessage + (cause != null ? " " + cause.getMessage() : "");
            .startObject()
        client().admin().indices().prepareRefresh(index1, index2).get();
            client().prepareIndex(index2)
            // Run cardinality aggregation across all documents
            );
            .startObject("sketch")
        assertTrue("Field should be HLL type", fieldType instanceof HllFieldMapper.HllFieldType);
import org.opensearch.core.xcontent.XContentBuilder;
                .setSource(XContentFactory.jsonBuilder().startObject().field("user_sketch", sketchBytes).endObject())
            expectedMerged.close();
        }
                        long hash = mix64(value);
import static org.opensearch.index.query.QueryBuilders.termQuery;
            }
            .startObject("user_sketch")
                .addAggregation(cardinality("total_users").field("user_sketch"))
            .endObject()
        } finally {
                BytesStreamOutput out = new BytesStreamOutput();
                        .endObject()
            SearchResponse termsResponse = client().prepareSearch(indexName)
            }
                .get();
        // Simplified test to debug the merge issue
        HyperLogLogPlusPlus expected = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
                .get();
            .field("type", "hll")
            );
        XContentBuilder mapping2 = XContentFactory.jsonBuilder()
        client().admin().indices().prepareCreate(indexName).setMapping(mapping).get();
                } finally {
            .endObject()
            .startObject("properties")
                    byte[] sketchBytes = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);
                    sketch.writeTo(0, out);
                    sketch.writeTo(0, out);
            } finally {
            // Serialize the sketch
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            byte[] sketchBytes = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);
        // This validates that OpenSearch properly rejects aggregations across indices with
            // The aggregated cardinality should match the expected cardinality
 * this file be licensed under the Apache-2.0 license or a
                "Bucket " + bucket.getKeyAsString() + " should have cardinality around " + valuesPerCategory + ", got " + bucketCardinality,
            .field("type", "hll")
        // Verify the field was created
            SearchResponse allDocsResponse = client().prepareSearch(indexName).setSize(0).get();
        } finally {
                            .field("category", category)
                    BytesStreamOutput out = new BytesStreamOutput();
            }
            .endObject()
        try {
            .endObject()
            SearchResponse cardinalityResponse = client().prepareSearch(indexName)
                                .field("category", "with_hll")
            .startObject("properties")
                getDocWithHll.getHits().getAt(0).getSourceAsMap().containsKey("user_sketch")
                            .endObject()
import org.opensearch.search.aggregations.bucket.terms.Terms;
                .addAggregation(
                byte[] sketchBytes = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);
            long docCount = client().prepareSearch(indexName).setSize(0).get().getHits().getTotalHits().value();
import org.opensearch.action.search.SearchResponse;
import org.opensearch.indices.IndicesService;
            .startObject("cardinality_sketch")
    }
        HyperLogLogPlusPlus sketch1 = new HyperLogLogPlusPlus(precision1, BigArrays.NON_RECYCLING_INSTANCE, 1);
            .field("type", "hll")
                org.apache.lucene.util.BytesRef bytesRef = out.bytes().toBytesRef();
                    .setSource(
            .startObject("properties")
                        .setSource(XContentFactory.jsonBuilder().startObject().field("hourly_users", sketchBytes).endObject())
            .get();
            // Test 2: Search for documents with HLL field using exists query
                .get();
        HllFieldMapper.HllFieldType hllFieldType = (HllFieldMapper.HllFieldType) fieldType;
            .startObject("user_sketch")
            assertNotNull("Bucket should have cardinality aggregation", withHllCardinality);
            .startObject("user_sketch")
            Terms.Bucket withHllBucket = termsAgg.getBucketByKey("with_hll");
            .endObject()
                int baseUserId = category.hashCode() & 0x7FFFFFFF; // Positive hash
        int numHours = 24;
            client().admin().indices().prepareRefresh(indexName).get();
                for (int i = 0; i < valuesPerCategory; i++) {
            .field("precision", precision)
            long aggregatedCardinality = cardinalityAgg.getValue();
            .endObject()
        // Create first index with precision 12
            SearchResponse response = client().prepareSearch(indexName).addAggregation(cardinality("test").field("sketch")).get();
import org.opensearch.common.xcontent.XContentFactory;
            .endObject();
            client().admin().indices().prepareRefresh(indexName).get();
                .get();
package org.opensearch.index.mapper;
            .endObject()
            assertEquals("Cardinality should be 0 for documents without HLL field", 0L, withoutHllCardinality.getValue());
            sketch1.close();
            // Sketch 1: values 0-99
        }
            // Index a document with the pre-aggregated sketch
    public void testMultipleRollupDocuments() throws IOException {
            .startObject("properties")
                    sketch.close();
                .setSize(0)
 */
        XContentBuilder mapping = XContentFactory.jsonBuilder()
                            .startObject()
        // Create documents with different categories
            .startObject("properties")
        assertEquals("All hourly documents should be indexed", numHours, docCount);
            fullMessage.contains("Cannot merge HLL++ sketches with different precision")
        int precision = 11;
                )
                    for (int j = 0; j < valuesPerSketch; j++) {
            .startObject("hour")
            .endObject()
            assertNotNull("Terms aggregation should return results", termsAgg);
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertEquals("Should have 3 category buckets", 3, termsAgg.getBuckets().size());
            .startObject("properties")
                // Each category gets unique user IDs
                client().prepareIndex(indexName)
            Cardinality withHllCardinality = withHllBucket.getAggregations().get("users_per_category");
                .setSize(0)
            assertEquals("Cardinality should match expected", expectedCardinality, withHllCardinality.getValue());
                    }
            .startObject("category")
            .endObject();
        // Create index
        int valuesPerDoc = 100;
            .startObject("timestamp")
            .startObject("properties")
        assertTrue(
            .field("type", "hll")
            HyperLogLogPlusPlus sketch = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
                "Document should not contain user_sketch field",
            sketch2.writeTo(0, out2);
            .endObject()
            .endObject()
        // Create second index with precision 14 (different precision, same field name)
            Terms termsAgg = termsResponse.getAggregations().get("by_category");
                )
                    )
                BytesStreamOutput out = new BytesStreamOutput();
            .endObject()
        MappedFieldType fieldType = mapperService.fieldType("cardinality_sketch");
        client().admin().indices().prepareCreate(index2).setMapping(mapping2).get();
            }
        client().admin().indices().prepareCreate(indexName).setMapping(mapping).get();
import org.opensearch.common.util.BigArrays;
        int valuesPerSketch = 50;
        // Test that HLL fields can be created
                byte[] sketchBytes = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);
        int precision = 11;
            assertEquals("Document should be indexed", 1L, docCount);
        // Create index with HLL field and category field
                .get();
        client().admin().indices().prepareCreate(index1).setMapping(mapping1).get();
                            .field("user_sketch", sketchBytes)
            sketch1.close();
            long expectedCard = expected.cardinality(0);
        assertNotNull("Terms aggregation should return results", termsAgg);
        // Create index with HLL field
        } finally {
                .get();
            assertEquals(
                .setQuery(org.opensearch.index.query.QueryBuilders.existsQuery("user_sketch"))
                    org.opensearch.index.query.QueryBuilders.boolQuery()
        try {
            .field("precision", precision)
            .endObject()
            client().prepareIndex(index1)
        SearchResponse response = client().prepareSearch(indexName)
            assertNotNull("Each bucket should have cardinality", cardAgg);
        HyperLogLogPlusPlus sketch = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
                }
            }
            .endObject()
            .startObject()
        // Test ingesting multiple rollup documents with HLL
                            XContentFactory.jsonBuilder()
                                .field("timestamp", "2024-01-0" + (i + 1) + "T00:00:00Z")
                    )
            client().prepareSearch("test-hll-precision-*").addAggregation(cardinality("total_users").field("user_sketch")).get();
            assertNotNull("Cardinality aggregation should return a result", cardinalityAgg);
            Cardinality cardinalityAgg = cardinalityResponse.getAggregations().get("total_users");
        // Attempt to aggregate across both indices using wildcard pattern
                try {
        try {
        // Test that cardinality aggregation works correctly within bucketed aggregations
        int precision = 11;
                            .endObject()
        int precision = 11;
            SearchResponse getDocWithoutHll = client().prepareSearch(indexName)
                        .mustNot(org.opensearch.index.query.QueryBuilders.existsQuery("user_sketch"))
        try {
        // Test ingesting pre-aggregated HLL sketch data (simulating rollup scenario)
                getDocWithoutHll.getHits().getAt(0).getSourceAsMap().containsKey("user_sketch")
        }
                org.apache.lucene.util.BytesRef bytesRef = out.bytes().toBytesRef();
            .endObject()
            for (int i = 0; i < 50; i++) {
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            client().admin().indices().prepareRefresh(indexName).get();
            Cardinality cardinalityAgg = response.getAggregations().get("total_users");
            SearchResponse withoutHllResponse = client().prepareSearch(indexName)
                .setSize(1)
                        .field("user_cardinality", sketchBytes)
                        expectedMerged.collect(0, hash); // Also collect into expected
            assertNotNull("Should have bucket for 'without_hll' category", withoutHllBucket);
        String indexName = "test-hll-bucketed-aggregation";
            }
        // Create an expected merged sketch for comparison
                            .endObject()
            );
            .startObject("hourly_users")
        HyperLogLogPlusPlus sketch2 = new HyperLogLogPlusPlus(precision2, BigArrays.NON_RECYCLING_INSTANCE, 1);
import static org.opensearch.search.aggregations.bucket.terms.Terms.Bucket;
            // Test 5: Terms aggregation by category with cardinality sub-aggregation
        int numDocs = 5;
                .setQuery(
 * and usage patterns for ISM plugin rollup scenarios.
        }
            org.apache.lucene.util.BytesRef bytesRef1 = out1.bytes().toBytesRef();
            assertTrue(
    public void testSparseHllFieldWithMixedDocuments() throws IOException {
            org.apache.lucene.util.BytesRef bytesRef = out.bytes().toBytesRef();
        // Test aggregating across multiple indices with same field name but different precisions
            .field("type", "date")
            .endObject()
            // Test 6: Retrieve a document with HLL field and verify it's in the response
            }
        // This is a scenario where not all documents may have pre-aggregated sketches
            // Test 4: Cardinality aggregation across all documents (should only aggregate docs with HLL field)
            byte[] sketchBytes1 = Arrays.copyOfRange(bytesRef1.bytes, bytesRef1.offset, bytesRef1.offset + bytesRef1.length);
        // Create multiple sketches with non-overlapping values
            // Test 7: Retrieve a document without HLL field and verify it's not in the response
        String indexName = "test-multi-rollup";
                }
                        XContentFactory.jsonBuilder()
}
        String index2 = "test-hll-precision-14";
        // Verify each bucket has cardinality
                    sketch.close();
            .field("precision", precision)
        for (String category : categories) {
        } finally {
            .field("type", "hll")
            try {
            .startObject()
            .startObject()
        String indexName = "test-sparse-hll";
            .startObject("category")
                    org.apache.lucene.util.BytesRef bytesRef = out.bytes().toBytesRef();
        client().admin().indices().prepareCreate(indexName).setMapping(mapping).get();
                long hash = mix64(i);
                            .field("hourly_users", sketchBytes)
            long aggregatedCardinality = cardinalityAgg.getValue();
            for (int i = 0; i < 100; i++) {
            // Verify the bucket with HLL field has cardinality
                HyperLogLogPlusPlus sketch = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
        // Testing indexing/retrieving multiple documents as useful for maybe rollup scenario
            .endObject();
        String errorMessage = exception.getMessage();
 * compatible open source license.
import org.opensearch.search.aggregations.metrics.HyperLogLogPlusPlus;
            // Verify the document was indexed
import static org.opensearch.common.util.BitMixer.mix64;
                        )
            .field("precision", precision)
    public void testPrecisionMismatchAcrossIndices() throws IOException {
            BytesStreamOutput out = new BytesStreamOutput();
        int precision1 = 12;
            // Plugins/consumers can further decide how the sketches are to be created or retrieved
            .startObject()
        HyperLogLogPlusPlus sketch2 = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
            }
        String indexName = "test-simple-merge";
            .endObject()
        }
        String indexName = "test-rollup-index";
            sketch.close();
            for (int userId = 1; userId <= 100; userId++) {
            assertEquals("Should find only documents with HLL field", docsWithHll, withHllResponse.getHits().getTotalHits().value());
            .field("type", "hll")
                sketch2.collect(0, hash);
                .setId("1")
            .endObject();
        XContentBuilder mapping1 = XContentFactory.jsonBuilder()
        }
                    terms("by_category").field("category").subAggregation(cardinality("users_per_category").field("user_sketch"))
                    client().prepareIndex(indexName)
            .startObject()
            BytesStreamOutput out = new BytesStreamOutput();
            client().prepareIndex(indexName)
            for (int i = 0; i < docsWithoutHll; i++) {
                }
        String indexName = "test-hll-index";
            assertEquals("Should have 2 category buckets", 2, termsAgg.getBuckets().size());
            .startObject("user_cardinality")
                )
            HyperLogLogPlusPlus sketch = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
                .setSource(XContentFactory.jsonBuilder().startObject().field("user_sketch", sketchBytes).endObject())
            .endObject();
            Cardinality cardAgg = bucket.getAggregations().get("users_per_category");
            // Creating the sketch manually here
        HyperLogLogPlusPlus expectedMerged = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
        int docsWithHll = 3;
