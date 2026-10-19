    }  
        assertTrue("Metadata should contain version", result.getMeta().getFieldsMap().containsKey("version"));
    public void testSingleBucket() throws IOException {  
            BucketOrder.count(false),
    }
        Map<String, Object> metadata  
        return new StringTerms.Bucket(new BytesRef(key), docCount, InternalAggregations.EMPTY, false, 0, DocValueFormat.RAW);
        StringTerms stringTerms = createStringTerms("test", List.of(bucket), 0, 0, null);
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
    ) {
 */  
        StringTerms stringTerms = createStringTerms("test", Collections.emptyList(), 0, 0, null);
import org.opensearch.test.OpenSearchTestCase;  
        List<StringTerms.Bucket> buckets,  
            new BytesRef("error_test"),
        StringTermsBucket protoBucket = result.getBuckets(0);  
            null
    }
    }
 *
        StringTermsAggregate result = converter.toProto(stringTerms).build().getSterms();
            name,  
            false,  
        assertFalse("Should not have metadata for null", result.hasMeta());  
/*  
        StringTerms stringTerms = createStringTerms("test", Collections.emptyList(), 0, 0, new HashMap<>());  
 * this file be licensed under the Apache-2.0 license or a
        c.setRegistry(registry);
            DocValueFormat.RAW,
import org.opensearch.protobufs.StringTermsAggregate;
            2,
        StringTermsAggregate result = converter.toProto(stringTerms).build().getSterms();
        Map<String, Object> metadata = new HashMap<>();
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
        return new StringTerms(
    private final StringTermsAggregateConverter converter = createConverter();
            List.of(createBucket("active", 100), createBucket("inactive", 50)),
}
        );
            DocValueFormat.RAW  
        assertEquals(StringTerms.class, converter.getHandledAggregationType());
        StringTerms stringTerms = createStringTerms("test", List.of(createBucket("active", 25)), 0, 0, null);
 * Tests for {@link StringTermsAggregateConverter}.
        StringTermsAggregateConverter c = new StringTermsAggregateConverter();
import org.opensearch.protobufs.Aggregate;
import java.util.Collections;
            buckets,
        StringTermsAggregate result = converter.toProto(stringTerms).build().getSterms();  
        return c;  
    }  
    public void testEmptyBuckets() throws IOException {
import java.util.List;
        assertEquals("active", result.getBuckets(0).getKey());
        StringTermsAggregate result = converter.toProto(stringTerms).build().getSterms();
        assertTrue("Should have sterms set", aggregate.hasSterms());  
import org.opensearch.search.aggregations.InternalAggregations;  
import org.opensearch.search.DocValueFormat;
    private final AggregateProtoConverterRegistry registry = new AggregateProtoConverterRegistryImpl();  
        StringTermsAggregate result = converter.toProto(stringTerms).build().getSterms();
    public void testWithEmptyMetadata() throws IOException {
        StringTerms stringTerms = createStringTerms("test", Collections.emptyList(), 0, 0, null);
            InternalAggregations.EMPTY,  
    public void testGetHandledAggregationType() {  
            metadata != null ? metadata : Collections.emptyMap(),  
import org.opensearch.protobufs.StringTermsBucket;  
        );
 * SPDX-License-Identifier: Apache-2.0
    public void testWithNullMetadata() throws IOException {
        assertEquals(0, result.getBucketsCount());
        assertTrue("Metadata should contain source", result.getMeta().getFieldsMap().containsKey("source"));
            true,
    private static StringTerms.Bucket createBucket(String key, long docCount) {  
        assertEquals("inactive", result.getBuckets(1).getKey());
        StringTerms stringTerms = createStringTerms("test", List.of(createBucket("active", 25)), 0, 0, null);
import org.apache.lucene.util.BytesRef;  
    }
            BucketOrder.count(false),
    }
        assertEquals(2, result.getBucketsCount());  
            docCountError,  
        assertEquals(3, result.getDocCountErrorUpperBound());
        assertEquals(1, aggregate.getSterms().getBucketsCount());
        assertEquals(25L, protoBucket.getDocCount());
        assertFalse("Should not have metadata for empty map", result.hasMeta());
    }
import org.opensearch.search.aggregations.BucketOrder;
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoConverterRegistryImpl;
    public void testMultipleBuckets() throws IOException {
 */  
    }  
        String name,
 * The OpenSearch Contributors require contributions made to  
    public void testToProtoWrapsAsSterms() throws IOException {
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;
        StringTerms stringTerms = createStringTerms(  
    }
    public void testWithMetadata() throws IOException {  
            10,
        assertEquals(2L, protoBucket.getDocCountErrorUpperBound());  
        StringTermsAggregate result = converter.toProto(stringTerms).build().getSterms();
import java.util.HashMap;  
 * compatible open source license.
            otherDocCount,
            3,  
    }  
        StringTermsBucket protoBucket = converter.toProto(stringTerms).build().getSterms().getBuckets(0);
        metadata.put("version", 2);  
        assertEquals(150, result.getSumOtherDocCount());
            new TermsAggregator.BucketCountThresholds(1, 0, 10, -1)
        assertTrue("Should have metadata", result.hasMeta());  
public class StringTermsAggregateConverterTests extends OpenSearchTestCase {
        long otherDocCount,
            10,
    private static StringTerms createStringTerms(
        assertEquals(0, result.getDocCountErrorUpperBound());  
import java.util.Map;
    public void testBucketWithDocCountError() throws IOException {
        assertEquals("active", protoBucket.getKey());
        StringTerms stringTerms = createStringTerms("test", Collections.emptyList(), 0, 0, metadata);
            "test",
            150,
        assertFalse("Should not have metadata for null", result.hasMeta());  
        StringTerms.Bucket bucket = new StringTerms.Bucket(  
        long docCountError,
    }
import java.io.IOException;
        );  
        Aggregate aggregate = converter.toProto(stringTerms).build();
/**
        assertEquals(0, result.getSumOtherDocCount());
        assertEquals(1, result.getBucketsCount());
package org.opensearch.transport.grpc.proto.response.search.aggregation.bucket.terms;
    private StringTermsAggregateConverter createConverter() {  
        metadata.put("source", "test");
