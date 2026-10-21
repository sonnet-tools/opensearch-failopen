        LongTermsAggregate result = converter.toProto(longTerms).build().getLterms();
        );
    public void testSingleBucket() throws IOException {
        LongTerms longTerms = createLongTerms("test", List.of(createBucket(42L, 10, false, 0, DocValueFormat.RAW)), 0, 0, null);
    }
    public void testBucketWithRawFormatNoKeyAsString() throws IOException {
    public void testWithNullMetadata() throws IOException {
        long key,
        assertEquals(200, result.getSumOtherDocCount());
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;
import java.io.IOException;
        assertEquals(10L, protoBucket.getDocCount());
import java.util.List;
        assertTrue("Metadata should contain priority", result.getMeta().getFieldsMap().containsKey("priority"));
        LongTermsAggregateConverter c = new LongTermsAggregateConverter();
    private static LongTerms.Bucket createBucket(
        LongTermsAggregate result = converter.toProto(longTerms).build().getLterms();
    }
        );
        LongTermsBucket protoBucket = result.getBuckets(0);
import org.opensearch.search.aggregations.InternalAggregations;
        List<LongTerms.Bucket> buckets,
}
        LongTermsAggregate result = converter.toProto(longTerms).build().getLterms();
            null
    }
        assertFalse("key_as_string should not be set with RAW format", protoBucket.hasKeyAsString());
        LongTermsAggregate result = converter.toProto(longTerms).build().getLterms();
    }
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
import org.opensearch.search.DocValueFormat;
public class LongTermsAggregateConverterTests extends OpenSearchTestCase {
        LongTermsBucket protoBucket = converter.toProto(longTerms).build().getLterms().getBuckets(0);
        LongTerms longTerms = createLongTerms("test", List.of(createBucket(42L, 10, false, 0, DocValueFormat.RAW)), 0, 0, null);
    public void testWithEmptyMetadata() throws IOException {
        LongTermsBucket protoBucket = converter.toProto(longTerms).build().getLterms().getBuckets(0);
    }
        LongTermsBucket protoBucket = converter.toProto(longTerms).build().getLterms().getBuckets(0);
 */
 * Tests for {@link LongTermsAggregateConverter}.
    public void testGetHandledAggregationType() {
            10,
        return new LongTerms.Bucket(key, docCount, InternalAggregations.EMPTY, showDocCountError, docCountError, format);
            BucketOrder.count(false),
    }
        assertFalse("Should not have metadata for null", result.hasMeta());
/*
        assertTrue("Metadata should contain color", result.getMeta().getFieldsMap().containsKey("color"));
    }
        assertEquals(3L, protoBucket.getDocCountErrorUpperBound());
import java.util.HashMap;
    }
        metadata.put("color", "blue");
    }
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(1, result.getBucketsCount());
    ) {
        LongTerms longTerms = createLongTerms("test", List.of(createBucket(1000L, 5, false, 0, format)), 0, 0, null);
import java.util.Collections;
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoConverterRegistryImpl;
        LongTerms longTerms = createLongTerms("test", Collections.emptyList(), 0, 0, null);
        assertFalse("key_as_string should not be set with RAW format", protoBucket.hasKeyAsString());
        long docCountError,
        assertEquals(0, result.getBucketsCount());
    public void testWithMetadata() throws IOException {
import org.opensearch.protobufs.LongTermsBucket;
            BucketOrder.count(false),
        assertEquals(1, aggregate.getLterms().getBucketsCount());
            false,
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
        LongTermsAggregate result = converter.toProto(longTerms).build().getLterms();
        return new LongTerms(
        LongTerms longTerms = createLongTerms("test", Collections.emptyList(), 0, 0, metadata);
            docCountError,
        long docCountError,
import org.opensearch.test.OpenSearchTestCase;
            name,
    }
            5,
        assertFalse("Should not have metadata for empty map", result.hasMeta());
import org.opensearch.search.aggregations.BucketOrder;
        LongTermsAggregate result = converter.toProto(longTerms).build().getLterms();
            DocValueFormat.RAW,
        assertEquals(LongTerms.class, converter.getHandledAggregationType());
        assertEquals(0, result.getSumOtherDocCount());
import org.opensearch.protobufs.Aggregate;
        LongTerms longTerms = createLongTerms("test", List.of(createBucket(10L, 100, true, 3, DocValueFormat.RAW)), 0, 0, null);
        Aggregate aggregate = converter.toProto(longTerms).build();
        DocValueFormat format = new DocValueFormat.Decimal("0.00");
import java.util.Map;
    public void testBucketWithDocCountError() throws IOException {
        assertEquals(5, result.getDocCountErrorUpperBound());
    public void testBucketWithFormattedKey() throws IOException {
            new TermsAggregator.BucketCountThresholds(1, 0, 10, -1)
        assertTrue("key_as_string should be set with custom format", protoBucket.hasKeyAsString());
        Map<String, Object> metadata
    private final LongTermsAggregateConverter converter = createConverter();
        assertEquals(1L, result.getBuckets(0).getKey().getSigned());
 * compatible open source license.
    private final AggregateProtoConverterRegistry registry = new AggregateProtoConverterRegistryImpl();
            200,
        LongTerms longTerms = createLongTerms("test", List.of(createBucket(42L, 10, false, 0, DocValueFormat.RAW)), 0, 0, null);
        assertEquals(0, result.getDocCountErrorUpperBound());
        Map<String, Object> metadata = new HashMap<>();
        assertTrue("Should have metadata", result.hasMeta());
 *
        assertFalse("Should not have metadata for null", result.hasMeta());
    public void testEmptyBuckets() throws IOException {
        assertEquals(2, result.getBucketsCount());
 * The OpenSearch Contributors require contributions made to
        String name,
    }
        assertTrue("Should have lterms set", aggregate.hasLterms());
    public void testToProtoWrapsAsLterms() throws IOException {
        long docCount,
            otherDocCount,
    }
            List.of(createBucket(1L, 100, false, 0, DocValueFormat.RAW), createBucket(2L, 50, false, 0, DocValueFormat.RAW)),
            buckets,
        assertEquals("1000.00", protoBucket.getKeyAsString());
        boolean showDocCountError,
        long otherDocCount,
        LongTerms longTerms = createLongTerms("test", Collections.emptyList(), 0, 0, null);
        assertEquals(42L, protoBucket.getKey().getSigned());
        metadata.put("priority", 5);
    private LongTermsAggregateConverter createConverter() {
        return c;
            metadata != null ? metadata : Collections.emptyMap(),
    private static LongTerms createLongTerms(
        LongTerms longTerms = createLongTerms(
            "test",
/**
import org.opensearch.protobufs.LongTermsAggregate;
 */
        DocValueFormat format
        assertEquals(2L, result.getBuckets(1).getKey().getSigned());
        assertEquals(1000L, protoBucket.getKey().getSigned());
        LongTerms longTerms = createLongTerms("test", Collections.emptyList(), 0, 0, new HashMap<>());
 * this file be licensed under the Apache-2.0 license or a
    public void testMultipleBuckets() throws IOException {
package org.opensearch.transport.grpc.proto.response.search.aggregation.bucket.terms;
    }
    }
        c.setRegistry(registry);
    ) {
