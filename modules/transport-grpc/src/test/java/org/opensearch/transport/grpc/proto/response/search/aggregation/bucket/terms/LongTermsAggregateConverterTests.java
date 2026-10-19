    public void testWithEmptyMetadata() throws IOException {
        LongTerms longTerms = createLongTerms("test", List.of(createBucket(42L, 10, false, 0, DocValueFormat.RAW)), 0, 0, null);  
            BucketOrder.count(false),  
    }
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;
        LongTermsAggregateConverter c = new LongTermsAggregateConverter();  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("1000.00", protoBucket.getKeyAsString());  
import org.opensearch.test.OpenSearchTestCase;
        assertFalse("Should not have metadata for empty map", result.hasMeta());  
            DocValueFormat.RAW,  
    public void testSingleBucket() throws IOException {
import java.io.IOException;  
import java.util.Map;
        assertFalse("key_as_string should not be set with RAW format", protoBucket.hasKeyAsString());
        LongTerms longTerms = createLongTerms("test", List.of(createBucket(10L, 100, true, 3, DocValueFormat.RAW)), 0, 0, null);  
import java.util.Collections;
    }
            otherDocCount,  
            BucketOrder.count(false),
public class LongTermsAggregateConverterTests extends OpenSearchTestCase {  
        LongTermsBucket protoBucket = converter.toProto(longTerms).build().getLterms().getBuckets(0);
    public void testToProtoWrapsAsLterms() throws IOException {  
        );
    public void testBucketWithFormattedKey() throws IOException {
    public void testWithMetadata() throws IOException {
        LongTerms longTerms = createLongTerms(  
import org.opensearch.protobufs.LongTermsAggregate;
        assertEquals(1000L, protoBucket.getKey().getSigned());
        assertEquals(42L, protoBucket.getKey().getSigned());  
 * SPDX-License-Identifier: Apache-2.0
    }  
    }
/**  
import org.opensearch.search.aggregations.BucketOrder;
        assertEquals(5, result.getDocCountErrorUpperBound());
/*  
    public void testWithNullMetadata() throws IOException {  
        assertEquals(200, result.getSumOtherDocCount());
    }  
 */
    public void testEmptyBuckets() throws IOException {  
}  
        long docCount,
            new TermsAggregator.BucketCountThresholds(1, 0, 10, -1)  
        assertEquals(1, result.getBucketsCount());
            metadata != null ? metadata : Collections.emptyMap(),
        assertEquals(2L, result.getBuckets(1).getKey().getSigned());
        return new LongTerms(
            null
            List.of(createBucket(1L, 100, false, 0, DocValueFormat.RAW), createBucket(2L, 50, false, 0, DocValueFormat.RAW)),
        LongTermsAggregate result = converter.toProto(longTerms).build().getLterms();
        assertTrue("Should have lterms set", aggregate.hasLterms());
        return new LongTerms.Bucket(key, docCount, InternalAggregations.EMPTY, showDocCountError, docCountError, format);  
        assertEquals(1L, result.getBuckets(0).getKey().getSigned());
        assertEquals(1, aggregate.getLterms().getBucketsCount());  
            "test",
    }
        LongTermsAggregate result = converter.toProto(longTerms).build().getLterms();  
        assertFalse("Should not have metadata for null", result.hasMeta());
        assertEquals(10L, protoBucket.getDocCount());
        return c;
            200,
 * compatible open source license.
        metadata.put("priority", 5);
        Aggregate aggregate = converter.toProto(longTerms).build();  
        assertFalse("Should not have metadata for null", result.hasMeta());
 *
    private LongTermsAggregateConverter createConverter() {
import org.opensearch.search.DocValueFormat;  
        assertTrue("Should have metadata", result.hasMeta());
import org.opensearch.search.aggregations.bucket.terms.LongTerms;  
        boolean showDocCountError,
        LongTerms longTerms = createLongTerms("test", Collections.emptyList(), 0, 0, null);
    }
        Map<String, Object> metadata = new HashMap<>();  
        long otherDocCount,
            buckets,
    }
    public void testGetHandledAggregationType() {
        LongTermsBucket protoBucket = converter.toProto(longTerms).build().getLterms().getBuckets(0);
        assertEquals(LongTerms.class, converter.getHandledAggregationType());  
    }  
    public void testBucketWithDocCountError() throws IOException {
    private final LongTermsAggregateConverter converter = createConverter();  
    ) {
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
        );  
        long docCountError,  
            5,  
        DocValueFormat format = new DocValueFormat.Decimal("0.00");
    public void testMultipleBuckets() throws IOException {
    }  
        long key,  
    ) {  
        LongTermsAggregate result = converter.toProto(longTerms).build().getLterms();
        assertEquals(3L, protoBucket.getDocCountErrorUpperBound());
        LongTerms longTerms = createLongTerms("test", Collections.emptyList(), 0, 0, null);
    }
        assertEquals(0, result.getBucketsCount());
            10,
 * The OpenSearch Contributors require contributions made to  
            docCountError,
        assertFalse("key_as_string should not be set with RAW format", protoBucket.hasKeyAsString());
        LongTerms longTerms = createLongTerms("test", Collections.emptyList(), 0, 0, metadata);
import org.opensearch.search.aggregations.InternalAggregations;
        LongTermsAggregate result = converter.toProto(longTerms).build().getLterms();  
    public void testBucketWithRawFormatNoKeyAsString() throws IOException {  
    }  
package org.opensearch.transport.grpc.proto.response.search.aggregation.bucket.terms;
        c.setRegistry(registry);
        assertEquals(0, result.getDocCountErrorUpperBound());
    }
        assertTrue("Metadata should contain color", result.getMeta().getFieldsMap().containsKey("color"));  
        assertEquals(0, result.getSumOtherDocCount());  
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoConverterRegistryImpl;  
            name,
        metadata.put("color", "blue");
    private static LongTerms.Bucket createBucket(
            false,
        LongTerms longTerms = createLongTerms("test", Collections.emptyList(), 0, 0, new HashMap<>());
        LongTerms longTerms = createLongTerms("test", List.of(createBucket(1000L, 5, false, 0, format)), 0, 0, null);  
        Map<String, Object> metadata
    }  
    private static LongTerms createLongTerms(  
        List<LongTerms.Bucket> buckets,
        LongTermsBucket protoBucket = result.getBuckets(0);
        LongTermsBucket protoBucket = converter.toProto(longTerms).build().getLterms().getBuckets(0);  
        long docCountError,  
import java.util.HashMap;
        assertEquals(2, result.getBucketsCount());  
        assertTrue("Metadata should contain priority", result.getMeta().getFieldsMap().containsKey("priority"));
        LongTerms longTerms = createLongTerms("test", List.of(createBucket(42L, 10, false, 0, DocValueFormat.RAW)), 0, 0, null);
        String name,
        DocValueFormat format
        LongTerms longTerms = createLongTerms("test", List.of(createBucket(42L, 10, false, 0, DocValueFormat.RAW)), 0, 0, null);
        LongTermsAggregate result = converter.toProto(longTerms).build().getLterms();
 * Tests for {@link LongTermsAggregateConverter}.
        LongTermsAggregate result = converter.toProto(longTerms).build().getLterms();  
        assertTrue("key_as_string should be set with custom format", protoBucket.hasKeyAsString());
import org.opensearch.protobufs.LongTermsBucket;
 */  
    private final AggregateProtoConverterRegistry registry = new AggregateProtoConverterRegistryImpl();
import org.opensearch.protobufs.Aggregate;  
import java.util.List;  
