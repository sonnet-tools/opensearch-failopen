        assertEquals(Long.MIN_VALUE, protoBucket.getKey());
import org.opensearch.protobufs.UnsignedLongTermsBucket;
        BigInteger largeValue = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE);
        assertEquals(4L, protoBucket.getDocCountErrorUpperBound());
        );
    }
        UnsignedLongTerms terms = createUnsignedLongTerms(
            0,
    }
import org.opensearch.search.DocValueFormat;
        );
import org.opensearch.search.aggregations.metrics.InternalMax;
            0,
    }
    }
        metadata.put("max_bits", 64);
        boolean showDocCountError,
public class UnsignedLongTermsAggregateConverterTests extends OpenSearchTestCase {
            List.of(createBucket(BigInteger.valueOf(1000), 10, false, 0, format)),
        BigInteger key,
            0,
        assertEquals(10L, protoBucket.getDocCount());
            "test",
            false,
    public void testBucketKeyAsStringNotSetForUnsignedLongFormat() throws IOException {
        assertEquals("1000", protoBucket.getKeyAsString());
/**
            List.of(createBucket(BigInteger.valueOf(100), 15, false, 0, DocValueFormat.RAW)),
    ) {
        DocValueFormat format = new DocValueFormat.Decimal("0.00");
        assertTrue("Should have metadata", result.hasMeta());
        UnsignedLongTerms terms = createUnsignedLongTerms("test", Collections.emptyList(), 0, 0, new HashMap<>());
        UnsignedLongTerms terms = createUnsignedLongTerms(
        UnsignedLongTermsAggregate result = converter.toProto(terms).build().getUlterms();
            BucketOrder.count(false),
            List.of(
import java.io.IOException;
            null
        UnsignedLongTerms terms = createUnsignedLongTerms("test", Collections.emptyList(), 0, 0, metadata);
        UnsignedLongTerms terms = createUnsignedLongTerms(
    private final UnsignedLongTermsAggregateConverter converter = createConverter();
    }
    public void testLargeUnsignedValue() throws IOException {
            0,
        // Long.MAX_VALUE + 1 overflows to Long.MIN_VALUE in two's complement,
    public void testSingleBucket() throws IOException {
    public void testWithEmptyMetadata() throws IOException {
        Aggregate aggregate = converter.toProto(terms).build();
        return new UnsignedLongTerms(
import org.opensearch.protobufs.Aggregate;
            docCountError,
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
            metadata != null ? metadata : Collections.emptyMap(),
import org.opensearch.search.aggregations.bucket.terms.UnsignedLongTerms;
        UnsignedLongTermsAggregate result = converter.toProto(terms).build().getUlterms();
        assertEquals(20L, protoBucket.getDocCount());
            new TermsAggregator.BucketCountThresholds(1, 0, 10, -1)
            null
            DocValueFormat.RAW,
            0,
        assertFalse("Should not have metadata for empty map", result.hasMeta());
        Map<String, Object> metadata = new HashMap<>();
            buckets,
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
    }
    }
            name,
        c.setRegistry(registry);
        UnsignedLongTerms terms = createUnsignedLongTerms(
                createBucket(BigInteger.valueOf(2), 50, false, 0, DocValueFormat.RAW)
/*
        );
import org.opensearch.test.OpenSearchTestCase;
            0,
            "test",
        assertEquals(0, result.getDocCountErrorUpperBound());
    public void testGetHandledAggregationType() {
    private UnsignedLongTermsAggregateConverter createConverter() {
        InternalAggregations subAggs = InternalAggregations.from(List.of(subMax));
 * SPDX-License-Identifier: Apache-2.0
        long docCount,
        Map<String, Object> metadata
import java.util.HashMap;
    }
            List.of(createBucket(BigInteger.valueOf(100), 5, false, 0, DocValueFormat.UNSIGNED_LONG)),
        long docCountError,
    }
            List.of(createBucket(BigInteger.valueOf(100), 15, false, 0, DocValueFormat.RAW)),
    }
package org.opensearch.transport.grpc.proto.response.search.aggregation.bucket.terms;
        );
        UnsignedLongTermsAggregateConverter c = new UnsignedLongTermsAggregateConverter();
        assertEquals(0, result.getBucketsCount());
        assertEquals(2, result.getBucketsCount());
        assertEquals(5L, protoBucket.getKey());
        assertEquals(100L, protoBucket.getKey());
            null
            null
            "test",
import org.opensearch.protobufs.UnsignedLongTermsAggregate;
        UnsignedLongTermsAggregate result = converter.toProto(terms).build().getUlterms();
        UnsignedLongTermsAggregate result = converter.toProto(terms).build().getUlterms();
            "test",
        assertTrue("Metadata should contain type", result.getMeta().getFieldsMap().containsKey("type"));
            0,
            List.of(createBucket(BigInteger.TEN, 20, true, 4, DocValueFormat.RAW)),
import org.opensearch.search.aggregations.BucketOrder;
            "test",
        assertFalse("key_as_string should not be set with UNSIGNED_LONG format", protoBucket.hasKeyAsString());
            300,
        assertFalse("Should not have metadata for null", result.hasMeta());
    }
    private final AggregateProtoConverterRegistry registry = new AggregateProtoConverterRegistryImpl();
            7,
        UnsignedLongTerms terms = createUnsignedLongTerms("test", Collections.emptyList(), 0, 0, null);
        UnsignedLongTermsBucket protoBucket = converter.toProto(terms).build().getUlterms().getBuckets(0);
        UnsignedLongTerms terms = createUnsignedLongTerms(
        assertEquals(7, result.getDocCountErrorUpperBound());
            List.of(createBucket(largeValue, 5, false, 0, DocValueFormat.RAW)),
 *
            0,
    ) {
            null
 * compatible open source license.
            null
import org.opensearch.search.aggregations.InternalAggregations;
        List<UnsignedLongTerms.Bucket> buckets,
        assertFalse("Should not have metadata for null", result.hasMeta());
        UnsignedLongTermsBucket protoBucket = converter.toProto(terms).build().getUlterms().getBuckets(0);
import java.util.Collections;
        assertEquals(0, result.getSumOtherDocCount());
        );
        assertTrue("key_as_string should be set with Decimal format", protoBucket.hasKeyAsString());
        assertFalse("key_as_string should not be set with RAW format", protoBucket.hasKeyAsString());
    }
 * Tests for {@link UnsignedLongTermsAggregateConverter}.
        assertEquals(1, aggregate.getUlterms().getBucketsCount());
        String name,
        long otherDocCount,
        return c;
                createBucket(BigInteger.valueOf(1), 100, false, 0, DocValueFormat.RAW),
        DocValueFormat format
            otherDocCount,
        assertEquals(UnsignedLongTerms.class, converter.getHandledAggregationType());
    }
            "test",
        assertTrue("Sub-agg should be a max aggregate", protoBucket.getAggregateMap().get("sub_max").hasMax());
    private static UnsignedLongTerms createUnsignedLongTerms(
            BucketOrder.count(false),
        UnsignedLongTermsBucket protoBucket = converter.toProto(terms).build().getUlterms().getBuckets(0);
        long docCountError,
            ),
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoConverterRegistryImpl;
            "test",
import java.util.Map;
        // which is the correct uint64 bit pattern for proto's uint64 field.
    public void testMultipleBuckets() throws IOException {
    public void testToProtoWrapsAsUlterms() throws IOException {
        UnsignedLongTermsAggregate result = converter.toProto(terms).build().getUlterms();
        assertTrue("Metadata should contain max_bits", result.getMeta().getFieldsMap().containsKey("max_bits"));
        assertEquals(15L, protoBucket.getDocCount());
        UnsignedLongTermsBucket protoBucket = converter.toProto(terms).build().getUlterms().getBuckets(0);
        assertEquals(1, result.getBucketsCount());
        metadata.put("type", "unsigned");
        InternalMax subMax = new InternalMax("sub_max", 42.0, DocValueFormat.RAW, Collections.emptyMap());
    public void testBucketWithDocCountError() throws IOException {
        );
 * The OpenSearch Contributors require contributions made to
        );
    public void testBucketWithSubAggregations() throws IOException {
        UnsignedLongTerms.Bucket bucket = new UnsignedLongTerms.Bucket(BigInteger.valueOf(5), 20, subAggs, false, 0, DocValueFormat.RAW);
        assertTrue("Should have sub-aggregation 'sub_max'", protoBucket.getAggregateMap().containsKey("sub_max"));
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;
        assertEquals(300, result.getSumOtherDocCount());
        UnsignedLongTermsBucket protoBucket = converter.toProto(terms).build().getUlterms().getBuckets(0);
        assertTrue("Should have ulterms set", aggregate.hasUlterms());
    public void testWithMetadata() throws IOException {
        UnsignedLongTerms terms = createUnsignedLongTerms("test", List.of(bucket), 0, 0, null);
        UnsignedLongTermsAggregate result = converter.toProto(terms).build().getUlterms();
    public void testBucketWithKeyAsStringForNonRawFormat() throws IOException {
    public void testWithNullMetadata() throws IOException {
        return new UnsignedLongTerms.Bucket(key, docCount, InternalAggregations.EMPTY, showDocCountError, docCountError, format);
    }
        UnsignedLongTerms terms = createUnsignedLongTerms("test", Collections.emptyList(), 0, 0, null);
}
    }
    private static UnsignedLongTerms.Bucket createBucket(
            0,
            0,
            0,
import java.math.BigInteger;
        UnsignedLongTermsBucket protoBucket = result.getBuckets(0);
        );
        UnsignedLongTerms terms = createUnsignedLongTerms(
 */
    }
            0,
    public void testEmptyBuckets() throws IOException {
 */
            10,
            null
        UnsignedLongTerms terms = createUnsignedLongTerms(
