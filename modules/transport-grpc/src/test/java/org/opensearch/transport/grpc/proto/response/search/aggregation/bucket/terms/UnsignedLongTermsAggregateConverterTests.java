        UnsignedLongTerms terms = createUnsignedLongTerms(  
import org.opensearch.protobufs.UnsignedLongTermsAggregate;
            new TermsAggregator.BucketCountThresholds(1, 0, 10, -1)
            "test",  
        DocValueFormat format  
        UnsignedLongTermsBucket protoBucket = result.getBuckets(0);
        long docCountError,
        assertFalse("key_as_string should not be set with RAW format", protoBucket.hasKeyAsString());
            "test",  
        UnsignedLongTerms.Bucket bucket = new UnsignedLongTerms.Bucket(BigInteger.valueOf(5), 20, subAggs, false, 0, DocValueFormat.RAW);  
            "test",
        long docCountError,
        UnsignedLongTerms terms = createUnsignedLongTerms("test", List.of(bucket), 0, 0, null);
    private final UnsignedLongTermsAggregateConverter converter = createConverter();
            0,
        assertEquals(0, result.getBucketsCount());  
            docCountError,
package org.opensearch.transport.grpc.proto.response.search.aggregation.bucket.terms;
            false,
public class UnsignedLongTermsAggregateConverterTests extends OpenSearchTestCase {
        Aggregate aggregate = converter.toProto(terms).build();
        assertEquals(0, result.getSumOtherDocCount());
        assertEquals(Long.MIN_VALUE, protoBucket.getKey());  
            10,  
        );
    }
        return new UnsignedLongTerms(  
import org.opensearch.protobufs.Aggregate;  
        );  
            metadata != null ? metadata : Collections.emptyMap(),
        UnsignedLongTermsBucket protoBucket = converter.toProto(terms).build().getUlterms().getBuckets(0);
        assertTrue("Metadata should contain type", result.getMeta().getFieldsMap().containsKey("type"));
 * SPDX-License-Identifier: Apache-2.0
    public void testBucketWithDocCountError() throws IOException {
        List<UnsignedLongTerms.Bucket> buckets,
import org.opensearch.test.OpenSearchTestCase;  
            null
    private static UnsignedLongTerms.Bucket createBucket(
    }  
import java.io.IOException;
    }  
        assertEquals(300, result.getSumOtherDocCount());  
    }
        InternalAggregations subAggs = InternalAggregations.from(List.of(subMax));
    public void testBucketWithKeyAsStringForNonRawFormat() throws IOException {  
        assertEquals(15L, protoBucket.getDocCount());  
    public void testBucketKeyAsStringNotSetForUnsignedLongFormat() throws IOException {
            null
 *
        c.setRegistry(registry);  
/**
    }
    }  
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
        Map<String, Object> metadata = new HashMap<>();
        assertEquals(2, result.getBucketsCount());
        assertEquals(4L, protoBucket.getDocCountErrorUpperBound());  
        assertEquals(0, result.getDocCountErrorUpperBound());
    ) {
        assertFalse("Should not have metadata for null", result.hasMeta());  
            "test",  
    private static UnsignedLongTerms createUnsignedLongTerms(
            0,
    private UnsignedLongTermsAggregateConverter createConverter() {
        UnsignedLongTerms terms = createUnsignedLongTerms(  
    }
        UnsignedLongTermsBucket protoBucket = converter.toProto(terms).build().getUlterms().getBuckets(0);  
        return c;
        assertEquals(1, result.getBucketsCount());  
                createBucket(BigInteger.valueOf(1), 100, false, 0, DocValueFormat.RAW),
        assertEquals(10L, protoBucket.getDocCount());
    ) {
import org.opensearch.search.aggregations.BucketOrder;
            "test",
        assertFalse("Should not have metadata for null", result.hasMeta());
        assertTrue("key_as_string should be set with Decimal format", protoBucket.hasKeyAsString());  
import java.math.BigInteger;
        UnsignedLongTermsAggregate result = converter.toProto(terms).build().getUlterms();
        UnsignedLongTerms terms = createUnsignedLongTerms(  
            otherDocCount,
    }
        UnsignedLongTermsBucket protoBucket = converter.toProto(terms).build().getUlterms().getBuckets(0);
            List.of(createBucket(BigInteger.valueOf(1000), 10, false, 0, format)),
            ),  
import org.opensearch.search.aggregations.bucket.terms.UnsignedLongTerms;
        long docCount,  
            0,  
        );  
        assertFalse("key_as_string should not be set with UNSIGNED_LONG format", protoBucket.hasKeyAsString());
 * this file be licensed under the Apache-2.0 license or a
    public void testWithEmptyMetadata() throws IOException {
    public void testWithNullMetadata() throws IOException {
        InternalMax subMax = new InternalMax("sub_max", 42.0, DocValueFormat.RAW, Collections.emptyMap());  
        UnsignedLongTerms terms = createUnsignedLongTerms("test", Collections.emptyList(), 0, 0, null);
        assertTrue("Metadata should contain max_bits", result.getMeta().getFieldsMap().containsKey("max_bits"));
import java.util.Map;  
            null
            null
        UnsignedLongTerms terms = createUnsignedLongTerms(
        metadata.put("max_bits", 64);  
            300,
        );  
        UnsignedLongTermsAggregateConverter c = new UnsignedLongTermsAggregateConverter();
import org.opensearch.search.DocValueFormat;  
            BucketOrder.count(false),  
            List.of(createBucket(BigInteger.valueOf(100), 5, false, 0, DocValueFormat.UNSIGNED_LONG)),
        assertTrue("Should have sub-aggregation 'sub_max'", protoBucket.getAggregateMap().containsKey("sub_max"));
        );
    }  
        assertEquals(100L, protoBucket.getKey());
 */
            List.of(  
            0,
    public void testToProtoWrapsAsUlterms() throws IOException {
        UnsignedLongTermsBucket protoBucket = converter.toProto(terms).build().getUlterms().getBuckets(0);
            "test",
            0,
        DocValueFormat format = new DocValueFormat.Decimal("0.00");
        assertEquals(5L, protoBucket.getKey());
 */  
        assertEquals(1, aggregate.getUlterms().getBucketsCount());
        UnsignedLongTerms terms = createUnsignedLongTerms(
    public void testMultipleBuckets() throws IOException {  
            0,  
    }  
        assertEquals(20L, protoBucket.getDocCount());  
            null
        UnsignedLongTermsAggregate result = converter.toProto(terms).build().getUlterms();
        Map<String, Object> metadata
        UnsignedLongTermsAggregate result = converter.toProto(terms).build().getUlterms();
import java.util.List;
            DocValueFormat.RAW,
    public void testGetHandledAggregationType() {
            BucketOrder.count(false),
            0,  
    public void testWithMetadata() throws IOException {  
        String name,  
    }
/*  
    private final AggregateProtoConverterRegistry registry = new AggregateProtoConverterRegistryImpl();
            List.of(createBucket(BigInteger.valueOf(100), 15, false, 0, DocValueFormat.RAW)),
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoConverterRegistryImpl;
            7,
        UnsignedLongTerms terms = createUnsignedLongTerms(
import org.opensearch.search.aggregations.metrics.InternalMax;
    }
    public void testEmptyBuckets() throws IOException {
        BigInteger largeValue = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE);
 * Tests for {@link UnsignedLongTermsAggregateConverter}.  
                createBucket(BigInteger.valueOf(2), 50, false, 0, DocValueFormat.RAW)
            List.of(createBucket(BigInteger.valueOf(100), 15, false, 0, DocValueFormat.RAW)),
    }
        );
        metadata.put("type", "unsigned");
        UnsignedLongTerms terms = createUnsignedLongTerms("test", Collections.emptyList(), 0, 0, metadata);
        UnsignedLongTermsBucket protoBucket = converter.toProto(terms).build().getUlterms().getBuckets(0);
            null  
import java.util.HashMap;
        assertFalse("Should not have metadata for empty map", result.hasMeta());
import java.util.Collections;  
            buckets,  
}
import org.opensearch.protobufs.UnsignedLongTermsBucket;
        );
        UnsignedLongTermsAggregate result = converter.toProto(terms).build().getUlterms();
        UnsignedLongTerms terms = createUnsignedLongTerms("test", Collections.emptyList(), 0, 0, new HashMap<>());  
            0,  
        // which is the correct uint64 bit pattern for proto's uint64 field.
        UnsignedLongTerms terms = createUnsignedLongTerms("test", Collections.emptyList(), 0, 0, null);  
        BigInteger key,
            0,
 * compatible open source license.
            name,
    public void testSingleBucket() throws IOException {
        );  
    public void testBucketWithSubAggregations() throws IOException {
        UnsignedLongTermsAggregate result = converter.toProto(terms).build().getUlterms();  
        // Long.MAX_VALUE + 1 overflows to Long.MIN_VALUE in two's complement,
        UnsignedLongTerms terms = createUnsignedLongTerms(
        assertTrue("Sub-agg should be a max aggregate", protoBucket.getAggregateMap().get("sub_max").hasMax());
        assertEquals("1000", protoBucket.getKeyAsString());
        return new UnsignedLongTerms.Bucket(key, docCount, InternalAggregations.EMPTY, showDocCountError, docCountError, format);
    }
            0,
            0,  
        UnsignedLongTermsAggregate result = converter.toProto(terms).build().getUlterms();
            List.of(createBucket(BigInteger.TEN, 20, true, 4, DocValueFormat.RAW)),
        assertTrue("Should have metadata", result.hasMeta());  
            List.of(createBucket(largeValue, 5, false, 0, DocValueFormat.RAW)),
            null
            "test",
        boolean showDocCountError,
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;  
        assertTrue("Should have ulterms set", aggregate.hasUlterms());
            0,  
    }
        long otherDocCount,  
    public void testLargeUnsignedValue() throws IOException {
    }  
        assertEquals(7, result.getDocCountErrorUpperBound());
        assertEquals(UnsignedLongTerms.class, converter.getHandledAggregationType());
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.InternalAggregations;
