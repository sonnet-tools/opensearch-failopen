    private final AggregateProtoConverterRegistry registry = new AggregateProtoConverterRegistryImpl();
        DoubleTermsAggregateConverter c = new DoubleTermsAggregateConverter();
    }
        return new DoubleTerms.Bucket(key, docCount, InternalAggregations.EMPTY, showDocCountError, docCountError, format);
            new TermsAggregator.BucketCountThresholds(1, 0, 10, -1)
            10,
        DocValueFormat format = new DocValueFormat.Decimal("0.00");
        DoubleTerms doubleTerms = createDoubleTerms("test", List.of(createBucket(42.0, 10, false, 0, DocValueFormat.RAW)), 0, 0, null);
        DoubleTermsAggregate result = converter.toProto(doubleTerms).build().getDterms();
        assertEquals(2.5, result.getBuckets(1).getKey(), 0.001);
        return new DoubleTerms(
    }
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoConverterRegistryImpl;
        metadata.put("count", 42);
    public void testBucketWithRawFormatNoKeyAsString() throws IOException {
        assertEquals(0, result.getDocCountErrorUpperBound());
            5,
            docCountError,
        DoubleTermsAggregate result = converter.toProto(doubleTerms).build().getDterms();
        List<DoubleTerms.Bucket> buckets,
            buckets,
        DoubleTerms doubleTerms = createDoubleTerms("test", Collections.emptyList(), 0, 0, null);
            otherDocCount,
        assertTrue("Metadata should contain count", result.getMeta().getFieldsMap().containsKey("count"));
    }
        assertTrue("key_as_string should be set with custom format", protoBucket.hasKeyAsString());
    }
import java.util.HashMap;
    public void testSingleBucket() throws IOException {
        DoubleTermsAggregate result = converter.toProto(doubleTerms).build().getDterms();
        assertEquals(5, result.getDocCountErrorUpperBound());
        Map<String, Object> metadata
        assertEquals(3L, protoBucket.getDocCountErrorUpperBound());
        assertTrue("Should have dterms set", aggregate.hasDterms());
    }
    public void testEmptyBuckets() throws IOException {
        long docCount,
import java.util.Map;
            List.of(createBucket(1.0, 100, false, 0, DocValueFormat.RAW), createBucket(2.5, 50, false, 0, DocValueFormat.RAW)),
        DoubleTerms doubleTerms = createDoubleTerms(
import org.opensearch.search.DocValueFormat;
        assertEquals(1.0, result.getBuckets(0).getKey(), 0.001);
    public void testToProtoWrapsAsDterms() throws IOException {
import java.util.Collections;
    public void testBucketWithDocCountError() throws IOException {
        DoubleTermsBucket protoBucket = converter.toProto(doubleTerms).build().getDterms().getBuckets(0);
        assertTrue("Should have metadata", result.hasMeta());
 */
        assertEquals(1, aggregate.getDterms().getBucketsCount());
    }
        DoubleTerms doubleTerms = createDoubleTerms("test", List.of(createBucket(9.99, 100, true, 3, DocValueFormat.RAW)), 0, 0, null);
    }
    }
    private final DoubleTermsAggregateConverter converter = createConverter();
    private DoubleTermsAggregateConverter createConverter() {
        assertEquals("3.14", protoBucket.getKeyAsString());
        return c;
import java.io.IOException;
        c.setRegistry(registry);
/**
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;
        long otherDocCount,
        assertEquals(3.14, protoBucket.getKey(), 0.001);
public class DoubleTermsAggregateConverterTests extends OpenSearchTestCase {
    public void testBucketWithFormattedKey() throws IOException {
        );
        );
    }
    ) {
        assertEquals(0, result.getSumOtherDocCount());
            false,
    }
        assertEquals(200, result.getSumOtherDocCount());
        DoubleTerms doubleTerms = createDoubleTerms("test", List.of(createBucket(3.14159, 5, false, 0, format)), 0, 0, null);
package org.opensearch.transport.grpc.proto.response.search.aggregation.bucket.terms;
        DoubleTerms doubleTerms = createDoubleTerms("test", Collections.emptyList(), 0, 0, metadata);
 * SPDX-License-Identifier: Apache-2.0
        DoubleTerms doubleTerms = createDoubleTerms("test", Collections.emptyList(), 0, 0, new HashMap<>());
        DocValueFormat format
        Aggregate aggregate = converter.toProto(doubleTerms).build();
/*
    public void testGetHandledAggregationType() {
        assertEquals(10L, protoBucket.getDocCount());
        boolean showDocCountError,
        assertFalse("key_as_string should not be set with RAW format", protoBucket.hasKeyAsString());
 */
    ) {
        assertEquals(3.14159, protoBucket.getKey(), 0.00001);
        assertFalse("Should not have metadata for null", result.hasMeta());
import org.opensearch.protobufs.DoubleTermsAggregate;
        assertEquals(2, result.getBucketsCount());
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;
import org.opensearch.search.aggregations.InternalAggregations;
        assertFalse("Should not have metadata for empty map", result.hasMeta());
    }
    private static DoubleTerms.Bucket createBucket(
        assertEquals(DoubleTerms.class, converter.getHandledAggregationType());
        metadata.put("color", "red");
        assertFalse("key_as_string should not be set with RAW format", protoBucket.hasKeyAsString());
        String name,
import org.opensearch.search.aggregations.BucketOrder;
import java.util.List;
            BucketOrder.count(false),
        DoubleTermsAggregate result = converter.toProto(doubleTerms).build().getDterms();
        assertFalse("Should not have metadata for null", result.hasMeta());
 * Tests for {@link DoubleTermsAggregateConverter}.
            name,
        Map<String, Object> metadata = new HashMap<>();
import org.opensearch.protobufs.DoubleTermsBucket;
import org.opensearch.protobufs.Aggregate;
}
            null
        assertEquals(0, result.getBucketsCount());
    public void testWithMetadata() throws IOException {
            "test",
            DocValueFormat.RAW,
    public void testMultipleBuckets() throws IOException {
        assertTrue("Metadata should contain color", result.getMeta().getFieldsMap().containsKey("color"));
    private static DoubleTerms createDoubleTerms(
 * The OpenSearch Contributors require contributions made to
        DoubleTermsAggregate result = converter.toProto(doubleTerms).build().getDterms();
        assertEquals(1, result.getBucketsCount());
        DoubleTermsAggregate result = converter.toProto(doubleTerms).build().getDterms();
        long docCountError,
            200,
        long docCountError,
 * compatible open source license.
        double key,
        DoubleTerms doubleTerms = createDoubleTerms("test", List.of(createBucket(3.14, 10, false, 0, DocValueFormat.RAW)), 0, 0, null);
    public void testWithNullMetadata() throws IOException {
        DoubleTermsBucket protoBucket = result.getBuckets(0);
 *
        DoubleTerms doubleTerms = createDoubleTerms("test", Collections.emptyList(), 0, 0, null);
            BucketOrder.count(false),
    }
            metadata != null ? metadata : Collections.emptyMap(),
    }
        DoubleTermsBucket protoBucket = converter.toProto(doubleTerms).build().getDterms().getBuckets(0);
import org.opensearch.search.aggregations.bucket.terms.DoubleTerms;
        DoubleTermsBucket protoBucket = converter.toProto(doubleTerms).build().getDterms().getBuckets(0);
    }
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
    public void testWithEmptyMetadata() throws IOException {
        DoubleTerms doubleTerms = createDoubleTerms("test", List.of(createBucket(3.14, 10, false, 0, DocValueFormat.RAW)), 0, 0, null);
