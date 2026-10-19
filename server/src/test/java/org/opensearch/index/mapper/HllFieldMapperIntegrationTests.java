            .endObject()  
            .startObject("properties")  
import org.opensearch.indices.IndicesService;
            .startObject("properties")
            SearchResponse response = client().prepareSearch(indexName).addAggregation(cardinality("test").field("sketch")).get();
        int valuesPerCategory = 100;
        SearchPhaseExecutionException exception = expectThrows(SearchPhaseExecutionException.class, () -> {
        client().admin().indices().prepareCreate(index2).setMapping(mapping2).get();
 * compatible open source license.
        MapperService mapperService = getInstanceFromNode(IndicesService.class).indexServiceSafe(resolveIndex(indexName)).mapperService();  
                            .endObject()
 * The OpenSearch Contributors require contributions made to  
                    }
        assertTrue(
                try {  
                    .setSource(
            long docCount = client().prepareSearch(indexName).setSize(0).get().getHits().getTotalHits().value();
import java.io.IOException;
            .endObject()
            // Plugins/consumers can further decide how the sketches are to be created or retrieved  
            .endObject()
            }
        // Index documents: some with HLL field, some without
 *
            .startObject("user_sketch")  
            byte[] sketchBytes = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);  
                        .setSource(  
        // Test ingesting pre-aggregated HLL sketch data (simulating rollup scenario)
            .field("type", "hll")
            .startObject("properties")
            .endObject()  
            .endObject();
        client().admin().indices().prepareRefresh(indexName).get();
                        expectedMerged.collect(0, hash); // Also collect into expected  
            Terms.Bucket withoutHllBucket = termsAgg.getBucketByKey("without_hll");
            .startObject("user_sketch")
            org.apache.lucene.util.BytesRef bytesRef = out.bytes().toBytesRef();
            .field("type", "hll")  
                int baseUserId = category.hashCode() & 0x7FFFFFFF; // Positive hash
                }
            .startObject()  
        // Create and index sketch with precision 14 in second index
    }  
                            .field("user_sketch", sketchBytes)
                // Each hour has some unique users
                } finally {
        int docsWithoutHll = 2;  
                .get();  
            .field("precision", precision)
            for (int i = 0; i < 100; i++) {
        }  
                    client().prepareIndex(indexName)
                    )
        int precision = 11;
        int precision = 11;
                .setQuery(
/*  
                sketch.writeTo(0, out);
        // Create documents with different categories  
            assertFalse(  
            assertNotNull("Bucket should have cardinality aggregation", withHllCardinality);
            .startObject("properties")
        client().admin().indices().prepareCreate(indexName).setMapping(mapping).get();
import static org.opensearch.index.query.QueryBuilders.termQuery;
            .field("precision", precision)
                    org.apache.lucene.util.BytesRef bytesRef = out.bytes().toBytesRef();
                sketch.collect(0, mix64(userId));
            client().prepareIndex(indexName)  
            // Verify the bucket with HLL field has cardinality
            }  
            fullMessage.contains("Cannot merge HLL++ sketches with different precision")
public class HllFieldMapperIntegrationTests extends OpenSearchSingleNodeTestCase {
            .startObject("hourly_users")
                    org.opensearch.index.query.QueryBuilders.boolQuery()
            Cardinality withoutHllCardinality = withoutHllBucket.getAggregations().get("users_per_category");  
            .endObject()
            org.apache.lucene.util.BytesRef bytesRef = out.bytes().toBytesRef();
            .field("precision", precision)  
                try {
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            sketch1.close();
            assertNotNull("Each bucket should have cardinality", cardAgg);
            sketch2.writeTo(0, out2);
    }
                client().prepareIndex(indexName)
        for (String category : categories) {
        try {
        client().admin().indices().prepareCreate(indexName).setMapping(mapping).get();  
                            .field("timestamp", "2024-01-0" + (docsWithHll + i + 1) + "T00:00:00Z")  
                .setId("1")  
                .setQuery(org.opensearch.index.query.QueryBuilders.existsQuery("user_sketch"))  
        int docsWithHll = 3;
        XContentBuilder mapping1 = XContentFactory.jsonBuilder()
                .setSource(XContentFactory.jsonBuilder().startObject().field("user_sketch", sketchBytes).endObject())
                    .get();
package org.opensearch.index.mapper;
        for (int hour = 0; hour < numHours; hour++) {
        client().admin().indices().prepareRefresh(index1, index2).get();
            try {  
        client().admin().indices().prepareRefresh(indexName).get();
                        .get();
        assertNotNull("Terms aggregation should return results", termsAgg);
            byte[] sketchBytes2 = Arrays.copyOfRange(bytesRef2.bytes, bytesRef2.offset, bytesRef2.offset + bytesRef2.length);
            .field("precision", precision)
            // Test 2: Search for documents with HLL field using exists query
            SearchResponse allDocsResponse = client().prepareSearch(indexName).setSize(0).get();
        Throwable cause = exception.getCause();
            assertEquals("Cardinality should match expected", expectedCardinality, withHllCardinality.getValue());
            client().prepareSearch("test-hll-precision-*").addAggregation(cardinality("total_users").field("user_sketch")).get();  
            sketch1.close();
        XContentBuilder mapping = XContentFactory.jsonBuilder()
                for (int i = 0; i < valuesPerCategory; i++) {  
        // Test that cardinality aggregation merges multiple HLL sketches correctly
        // Create index with HLL field and category field
            // Verify the document was indexed
            }
        HyperLogLogPlusPlus sketch1 = new HyperLogLogPlusPlus(precision1, BigArrays.NON_RECYCLING_INSTANCE, 1);
    public void testSparseHllFieldWithMixedDocuments() throws IOException {
            .endObject()
        String indexName = "test-sparse-hll";  
            .startObject("timestamp")
            sketch2.close();
            .endObject();
 * SPDX-License-Identifier: Apache-2.0
            // The aggregated cardinality should match the cardinality from expected expectedMerged
        // Test ingesting multiple rollup documents with HLL
                        XContentFactory.jsonBuilder()  
            sketch2.close();  
                getDocWithHll.getHits().getAt(0).getSourceAsMap().containsKey("user_sketch")  
        assertTrue("Field should be HLL type", fieldType instanceof HllFieldMapper.HllFieldType);
import org.opensearch.action.search.SearchPhaseExecutionException;
                    BytesStreamOutput out = new BytesStreamOutput();  
            .endObject()
        // Create index with HLL field and other fields  
                org.apache.lucene.util.BytesRef bytesRef = out.bytes().toBytesRef();  
                .setSize(0)
                    .get();
            // Test 7: Retrieve a document without HLL field and verify it's not in the response  
        HyperLogLogPlusPlus expectedMerged = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);  
import org.opensearch.action.search.SearchResponse;
        // This validates that OpenSearch properly rejects aggregations across indices with
            .endObject()
            .endObject()
            );
        // Create index
        // Test that HLL fields can be created
            client().admin().indices().prepareRefresh(indexName).get();
        String indexName = "test-hll-index";
            expectedMerged.close();
            BytesStreamOutput out = new BytesStreamOutput();  
            byte[] sketchBytes = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);
                        long value = (long) docIdx * valuesPerDoc + i;  
import java.util.Arrays;
                    sketch.collect(0, mix64(baseUserId + i));
            .endObject();
            // Test 5: Terms aggregation by category with cardinality sub-aggregation
            .startObject("hour")  
            expected.close();
        try {
                .setSource(XContentFactory.jsonBuilder().startObject().field("sketch", sketchBytes2).endObject())  
                    terms("by_category").field("category").subAggregation(cardinality("users_per_category").field("user_sketch"))
            .field("precision", precision)
            }  
            // Refresh to make the document searchable
            }
            .field("type", "hll")  
            .field("type", "date")
        client().admin().indices().prepareCreate(indexName).setMapping(mapping).get();  
            .field("type", "hll")  
            .endObject()  
            sketch1.writeTo(0, out);
                .get();
        long docCount = client().prepareSearch(indexName).setSize(0).get().getHits().getTotalHits().value();  
            .startObject()  
                    BytesStreamOutput out = new BytesStreamOutput();  
            assertTrue(
        // Create index
                    for (int i = 0; i < valuesPerDoc; i++) {
                    sketch.close();  
/**
            // Index a document with the pre-aggregated sketch
                sketch.close();  
                    for (int j = 0; j < valuesPerSketch; j++) {
            .endObject()  
                expected.collect(0, hash);
            .startObject("hourly_users")
                        long value = (long) i * valuesPerSketch + j;  
        String indexName = "test-hll-bucketed-aggregation";
            );
        // Attempt to aggregate across both indices using wildcard pattern  
            .field("type", "keyword")
            .startObject("properties")
                    .setSource(
            for (int i = 0; i < docsWithHll; i++) {
                    client().prepareIndex(indexName)
    public void testMultipleRollupDocuments() throws IOException {  
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            Cardinality withHllCardinality = withHllBucket.getAggregations().get("users_per_category");  
        });
import static org.opensearch.search.aggregations.AggregationBuilders.cardinality;  
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
            .field("type", "hll")
            .endObject();
        HyperLogLogPlusPlus sketch2 = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
            .endObject();
            .field("type", "hll")
                            .field("hourly_users", sketchBytes)
            .endObject();
        String fullMessage = errorMessage + (cause != null ? " " + cause.getMessage() : "");  
            byte[] sketchBytes = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);  
            expectedMerged.close();
        XContentBuilder mapping2 = XContentFactory.jsonBuilder()  
            .endObject()
            .startObject()  
                "Bucket " + bucket.getKeyAsString() + " should have cardinality around " + valuesPerCategory + ", got " + bucketCardinality,
            .startObject("category")  
import org.opensearch.core.xcontent.XContentBuilder;  
                            .startObject()
        for (Bucket bucket : termsAgg.getBuckets()) {
        HllFieldMapper.HllFieldType hllFieldType = (HllFieldMapper.HllFieldType) fieldType;  
                        .field("user_cardinality", sketchBytes)
            org.apache.lucene.util.BytesRef bytesRef1 = out1.bytes().toBytesRef();
        HyperLogLogPlusPlus expectedMerged = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);  
 * Integration tests for HLL field mapper demonstrating programmatic field creation
            sketch.writeTo(0, out);
                client().prepareIndex(indexName)
            assertEquals("Bucket should have correct doc count", docsWithHll, withHllBucket.getDocCount());
        try {
                    sketch.collect(0, mix64(userId));  
            Cardinality cardinalityAgg = response.getAggregations().get("total_users");
            .endObject()
        int numHours = 24;  
                                .startObject()
        int precision1 = 12;
            .startObject("properties")
            client().admin().indices().prepareRefresh(indexName).get();  
                .setSource(XContentFactory.jsonBuilder().startObject().field("sketch", sketchBytes1).endObject())
        } finally {
                            XContentFactory.jsonBuilder()
                    byte[] sketchBytes = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);  
                .setSize(0)
                org.apache.lucene.util.BytesRef bytesRef = out.bytes().toBytesRef();
            .startObject("cardinality_sketch")
            .endObject()  
        // Test that cardinality aggregation works correctly within bucketed aggregations  
                            .endObject()
            for (int docIdx = 0; docIdx < numDocs; docIdx++) {
                        sketch.collect(0, hash);
        // Verify each bucket has cardinality
            sketch2.writeTo(0, out);
            assertEquals("Document should be indexed", 1L, docCount);  
                }
        }
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        client().admin().indices().prepareCreate(indexName).setMapping(mapping).get();  
                .get();
                )
                sketch.close();
                BytesStreamOutput out = new BytesStreamOutput();  
                "Document should contain user_sketch field",
                        .endObject()  
                getDocWithoutHll.getHits().getAt(0).getSourceAsMap().containsKey("user_sketch")
            for (int i = 100; i < 200; i++) {
            BytesStreamOutput out = new BytesStreamOutput();
import org.opensearch.common.xcontent.XContentFactory;
    }
                }
        // Simplified test to debug the merge issue  
                    // Each sketch has unique values
            .startObject()
        // This is a scenario where not all documents may have pre-aggregated sketches
            }
            byte[] sketchBytes1 = Arrays.copyOfRange(bytesRef1.bytes, bytesRef1.offset, bytesRef1.offset + bytesRef1.length);
import org.opensearch.search.aggregations.metrics.HyperLogLogPlusPlus;
            assertNotNull("Bucket should have cardinality aggregation", withoutHllCardinality);
            // The aggregated cardinality should match the expected cardinality
            .field("type", "date")
                                .endObject()  
            long aggregatedCardinality = cardinalityAgg.getValue();
            for (int userId = 1; userId <= 100; userId++) {
    public void testSimpleTwoSketchMerge() throws IOException {
                sketch.writeTo(0, out);
        // Testing indexing/retrieving multiple documents as useful for maybe rollup scenario
        // Create index with HLL field mapping
                            .field("category", category)
        assertEquals("Should have 3 category buckets", 3, termsAgg.getBuckets().size());
        int valuesPerSketch = 50;
        // mismatched HLL precision configurations  
                        long hash = mix64(value);
                .get();
            // Sketch 1: values 0-99  
            SearchResponse withHllResponse = client().prepareSearch(indexName)
        assertNotNull("HLL field should be created", fieldType);  
                "Document should not contain user_sketch field",
            Cardinality cardAgg = bucket.getAggregations().get("users_per_category");  
            .field("precision", precision1)
                .get();  
            sketch.close();
    public void testProgrammaticFieldCreation() throws IOException {
            // Test 6: Retrieve a document with HLL field and verify it's in the response
            .endObject();
        int precision = 11;
            // Serialize the sketch
    }
            org.apache.lucene.util.BytesRef bytesRef = out.bytes().toBytesRef();  
                    org.apache.lucene.util.BytesRef bytesRef = out.bytes().toBytesRef();
            assertEquals("Cardinality should be 0 for documents without HLL field", 0L, withoutHllCardinality.getValue());
                .get();
        XContentBuilder mapping = XContentFactory.jsonBuilder()  
            assertTrue(
            assertEquals("Should have 2 category buckets", 2, termsAgg.getBuckets().size());
        assertEquals("Precision should match", precision, hllFieldType.precision());
        }
        try {
            // Verify the bucket without HLL field has zero cardinality
                                .field("category", "with_hll")  
                withoutHllResponse.getHits().getTotalHits().value()
        client().admin().indices().prepareCreate(indexName).setMapping(mapping).get();
                            .startObject()  
                sketch1.collect(0, hash);  
            .endObject()
                            // No user_sketch field
                BytesStreamOutput out = new BytesStreamOutput();
                .get();  
        int precision = 11;  
            assertEquals("Should find document with HLL field", 1, getDocWithHll.getHits().getHits().length);  
            // Index both sketches
                byte[] sketchBytes = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);  
        client().admin().indices().prepareCreate(index1).setMapping(mapping1).get();  
            // Creating the sketch manually here
            .field("precision", precision)
                "Should find only documents without HLL field",
                // Each category gets unique user IDs
            for (int i = 0; i < docsWithoutHll; i++) {  
            .startObject("properties")
        // Create second index with precision 14 (different precision, same field name)
                            .startObject()
            .addAggregation(terms("by_category").field("category").subAggregation(cardinality("users_per_category").field("user_sketch")))  
        }
            assertEquals("Should merge both sketches", expectedCard, result);  
            SearchResponse response = client().prepareSearch(indexName)
            assertNotNull("Terms aggregation should return results", termsAgg);
                sketch2.collect(0, hash);
        // Test aggregating across multiple indices with same field name but different precisions
                    .get();
            .field("precision", precision2)
        // Create index
            }
        int precision = 11;  
            .startObject("properties")
        // Create an HLL sketch with some user IDs
        try {
            .startObject()  
    public void testDataIngestion() throws IOException {
            .startObject("user_cardinality")
            assertEquals("Bucket should have correct doc count", docsWithoutHll, withoutHllBucket.getDocCount());
                .setId("1")
            SearchResponse withoutHllResponse = client().prepareSearch(indexName)  
    }  
                HyperLogLogPlusPlus sketch = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);  
            .endObject()  
                .addAggregation(cardinality("total_users").field("hourly_users"))
                    .setSource(  
        // Create index with HLL field
                        XContentFactory.jsonBuilder()
        // Create and index sketch with precision 12 in first index  
 * this file be licensed under the Apache-2.0 license or a
        client().admin().indices().prepareCreate(indexName).setMapping(mapping).get();
            .startObject()  
                docsWithoutHll,  
                            .field("hour", "2024-01-01T" + String.format(java.util.Locale.ROOT, "%02d", hour) + ":00:00Z")  
            }  
                )
                bucketCardinality > 0 && bucketCardinality <= valuesPerCategory * 1.2  
            .endObject()  
        // Verify the field was created
            Cardinality cardinalityAgg = cardinalityResponse.getAggregations().get("total_users");  
            client().admin().indices().prepareRefresh(indexName).get();
            .field("type", "hll")
            .field("precision", precision)
        XContentBuilder mapping = XContentFactory.jsonBuilder()  
        assertEquals("All hourly documents should be indexed", numHours, docCount);
        int precision = 12;
            BytesStreamOutput out = new BytesStreamOutput();  
            .get();
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            // Test 1: Verify all documents are indexed  
            .endObject()  
        Terms termsAgg = response.getAggregations().get("by_category");  
            // Run cardinality aggregation across all documents  
                                .field("user_sketch", sketchBytes)
            long aggregatedCardinality = cardinalityAgg.getValue();  
                .setSize(1)  
        }
            client().admin().indices().prepareRefresh(indexName).get();
            "Error should mention precision mismatch. Got: " + fullMessage,  
        // Create multiple sketches with non-overlapping values  
        }  
 * and usage patterns for ISM plugin rollup scenarios.  
        } finally {
            assertNotNull("Should have bucket for 'without_hll' category", withoutHllBucket);  
        // Create an expected merged sketch for comparison
                        XContentFactory.jsonBuilder()
            assertNotNull("Should have bucket for 'with_hll' category", withHllBucket);  
        HyperLogLogPlusPlus sketch2 = new HyperLogLogPlusPlus(precision2, BigArrays.NON_RECYCLING_INSTANCE, 1);  
            .startObject("sketch")  
                HyperLogLogPlusPlus sketch = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
            client().prepareIndex(indexName)
            // Test 3: Search for documents without HLL field
    }
            assertEquals("All documents should be indexed", docsWithHll + docsWithoutHll, allDocsResponse.getHits().getTotalHits().value());
        // Refresh and verify
                    byte[] sketchBytes = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);  
            long bucketCardinality = cardAgg.getValue();  
        // Verify the error mentions precision mismatch  
        MappedFieldType fieldType = mapperService.fieldType("cardinality_sketch");
        } finally {  
                byte[] sketchBytes = Arrays.copyOfRange(bytesRef.bytes, bytesRef.offset, bytesRef.offset + bytesRef.length);
            assertNotNull("Cardinality aggregation should return a result", cardinalityAgg);  
            Terms.Bucket withHllBucket = termsAgg.getBucketByKey("with_hll");
        String indexName = "test-hll-merge-aggregation";
                        .field("timestamp", "2024-01-01T00:00:00Z")
import org.opensearch.common.io.stream.BytesStreamOutput;  
            } finally {
                .get();
            client().prepareIndex(index2)
            long expectedCardinality = expectedMerged.cardinality(0);
                expected.collect(0, hash);
 */
                .get();
        }
        // This should fail because the indices have different precisions for the same field
        String[] categories = { "electronics", "books", "clothing" };
                    XContentFactory.jsonBuilder()
        int valuesPerDoc = 100;
            client().prepareIndex(index1)  
            SearchResponse getDocWithoutHll = client().prepareSearch(indexName)
                sketch2.collect(0, mix64(i + 100));  
            assertEquals("Aggregation should merge sketches correctly", expectedCardinality, aggregatedCardinality);
            .startObject("category")
                for (int userId = hour * 10; userId < hour * 10 + 50; userId++) {
        try {
            .endObject()
            try {  
            assertEquals("Should find document without HLL field", 1, getDocWithoutHll.getHits().getHits().length);
                .setSource(
                        expectedMerged.collect(0, hash);  
        client().admin().indices().prepareCreate(indexName).setMapping(mapping).get();  
            .field("type", "hll")  
                    )  
                        .setSource(XContentFactory.jsonBuilder().startObject().field("hourly_users", sketchBytes).endObject())  
            }
        // Index multiple hourly rollup documents
            HyperLogLogPlusPlus sketch = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
            // Test 4: Cardinality aggregation across all documents (should only aggregate docs with HLL field)
                    sketch.writeTo(0, out);
                .get();
            .startObject("user_sketch")
    }  
        } finally {
                    sketch.writeTo(0, out);
            .startObject()
                long hash = mix64(i);
        );
            SearchResponse cardinalityResponse = client().prepareSearch(indexName)
        String indexName = "test-multi-rollup";
            for (int i = 0; i < 50; i++) {  
        String indexName = "test-simple-merge";
            assertEquals("Should find only documents with HLL field", docsWithHll, withHllResponse.getHits().getTotalHits().value());  
                            .field("category", "without_hll")
            // Index documents WITHOUT HLL field
            long expectedCard = expected.cardinality(0);
    }  
                .get();
            .endObject()  
                    sketch.close();
                .setSource(XContentFactory.jsonBuilder().startObject().field("user_sketch", sketchBytes).endObject())
            org.apache.lucene.util.BytesRef bytesRef2 = out2.bytes().toBytesRef();  
                long hash = mix64(i);  
            assertEquals("Cardinality should only aggregate documents with HLL field", expectedCardinality, aggregatedCardinality);  
        HyperLogLogPlusPlus expected = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);  
            // Index documents WITH HLL field  
        }  
            assertEquals("Aggregation should merge sketches correctly", expectedMerged.cardinality(0), aggregatedCardinality);
        HyperLogLogPlusPlus sketch1 = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
        SearchResponse response = client().prepareSearch(indexName)
                    )  
                client().prepareIndex(indexName)  
            .endObject();  
                        long hash = mix64(value);
                )  
                            .endObject()  
            .field("type", "keyword")
                        .startObject()  
        } finally {
                        sketch.collect(0, hash);
            Terms termsAgg = termsResponse.getAggregations().get("by_category");  
                .setQuery(termQuery("category", "without_hll"))
            client().prepareIndex(indexName)  
                .addAggregation(
            .startObject("timestamp")  
            );  
        String errorMessage = exception.getMessage();
            );
                        .mustNot(org.opensearch.index.query.QueryBuilders.existsQuery("user_sketch"))  
        // Create first index with precision 12
        } finally {  
            .startObject()
                } finally {  
import org.opensearch.search.aggregations.bucket.terms.Terms;
            HyperLogLogPlusPlus sketch = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);
            .startObject("properties")
import static org.opensearch.common.util.BitMixer.mix64;
        // Run terms aggregation with cardinality sub-aggregation
import org.opensearch.common.util.BigArrays;
            .startObject()
            BytesStreamOutput out2 = new BytesStreamOutput();
        String index2 = "test-hll-precision-14";  
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            assertNotNull("Cardinality aggregation should return a result", cardinalityAgg);
                .addAggregation(cardinality("total_users").field("user_sketch"))  
            BytesStreamOutput out1 = new BytesStreamOutput();
        // Test that HLL fields work correctly when some documents have the field and others don't  
            SearchResponse termsResponse = client().prepareSearch(indexName)  
        String index1 = "test-hll-precision-12";
        int precision2 = 14;
        int precision = 11;
            .endObject()
            .endObject()  
            }
            .field("type", "hll")  
            sketch1.writeTo(0, out1);  
            // Sketch 2: values 100-199
            long result = response.getAggregations().<org.opensearch.search.aggregations.metrics.Cardinality>get("test").getValue();
            for (int i = 0; i < 50; i++) {
                    }
                                .field("timestamp", "2024-01-0" + (i + 1) + "T00:00:00Z")
        }  
        long expectedCardinality = 500;
import org.opensearch.search.aggregations.metrics.Cardinality;  
import static org.opensearch.search.aggregations.bucket.terms.Terms.Bucket;
            .startObject("user_sketch")  
}
                }
    public void testCardinalityAggregationMergesMultipleSketches() throws IOException {
    public void testPrecisionMismatchAcrossIndices() throws IOException {  
        int numDocs = 5;
                sketch1.collect(0, mix64(i));
            .endObject()
            .endObject();
        String indexName = "test-rollup-index";
        // Create two simple sketches  
            .field("type", "date")
            } finally {  
                        .get();
                        )
 */  
            assertEquals(
    public void testCardinalityAggregationWithBuckets() throws IOException {
            SearchResponse getDocWithHll = client().prepareSearch(indexName).setQuery(termQuery("category", "with_hll")).setSize(1).get();
        HyperLogLogPlusPlus sketch = new HyperLogLogPlusPlus(precision, BigArrays.NON_RECYCLING_INSTANCE, 1);  
