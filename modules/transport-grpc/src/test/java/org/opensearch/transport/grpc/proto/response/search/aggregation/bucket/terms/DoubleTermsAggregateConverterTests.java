}  
            name,
    ) {  
    }  
        assertTrue("key_as_string should be set with custom format", protoBucket.hasKeyAsString());
        assertEquals(200, result.getSumOtherDocCount());
        assertTrue("Should have dterms set", aggregate.hasDterms());
    }
        DoubleTermsBucket protoBucket = converter.toProto(doubleTerms).build().getDterms().getBuckets(0);
    }  
        c.setRegistry(registry);
        DoubleTerms doubleTerms = createDoubleTerms("test", List.of(createBucket(42.0, 10, false, 0, DocValueFormat.RAW)), 0, 0, null);
        DoubleTerms doubleTerms = createDoubleTerms("test", Collections.emptyList(), 0, 0, null);
            "test",
import java.util.HashMap;
/*  
    public void testWithEmptyMetadata() throws IOException {
            false,
    private static DoubleTerms.Bucket createBucket(
        assertEquals(1, aggregate.getDterms().getBucketsCount());  
import java.util.List;  
        assertEquals("3.14", protoBucket.getKeyAsString());  
        assertFalse("key_as_string should not be set with RAW format", protoBucket.hasKeyAsString());
import java.util.Collections;
 */  
        DoubleTermsAggregate result = converter.toProto(doubleTerms).build().getDterms();
        DoubleTermsBucket protoBucket = converter.toProto(doubleTerms).build().getDterms().getBuckets(0);  
            DocValueFormat.RAW,  
    public void testToProtoWrapsAsDterms() throws IOException {  
        assertEquals(0, result.getSumOtherDocCount());  
            BucketOrder.count(false),
    public void testGetHandledAggregationType() {
        assertEquals(1.0, result.getBuckets(0).getKey(), 0.001);
import org.opensearch.search.DocValueFormat;  
 * The OpenSearch Contributors require contributions made to  
    }  
 * compatible open source license.
            null
        long docCount,
        long otherDocCount,
    public void testBucketWithRawFormatNoKeyAsString() throws IOException {  
        DoubleTermsBucket protoBucket = result.getBuckets(0);
        return new DoubleTerms.Bucket(key, docCount, InternalAggregations.EMPTY, showDocCountError, docCountError, format);  
            List.of(createBucket(1.0, 100, false, 0, DocValueFormat.RAW), createBucket(2.5, 50, false, 0, DocValueFormat.RAW)),
public class DoubleTermsAggregateConverterTests extends OpenSearchTestCase {  
        assertEquals(0, result.getBucketsCount());
        DoubleTerms doubleTerms = createDoubleTerms("test", List.of(createBucket(3.14, 10, false, 0, DocValueFormat.RAW)), 0, 0, null);
        );  
            new TermsAggregator.BucketCountThresholds(1, 0, 10, -1)  
        DoubleTermsAggregate result = converter.toProto(doubleTerms).build().getDterms();  
    }
/**  
import java.io.IOException;  
        Aggregate aggregate = converter.toProto(doubleTerms).build();  
 * SPDX-License-Identifier: Apache-2.0
            10,
    public void testMultipleBuckets() throws IOException {
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.InternalAggregations;
        assertEquals(2.5, result.getBuckets(1).getKey(), 0.001);
        DoubleTerms doubleTerms = createDoubleTerms("test", List.of(createBucket(3.14, 10, false, 0, DocValueFormat.RAW)), 0, 0, null);  
            docCountError,
import org.opensearch.protobufs.DoubleTermsAggregate;
    public void testWithNullMetadata() throws IOException {  
        assertEquals(1, result.getBucketsCount());
        List<DoubleTerms.Bucket> buckets,
        DoubleTerms doubleTerms = createDoubleTerms("test", List.of(createBucket(3.14159, 5, false, 0, format)), 0, 0, null);  
        assertEquals(DoubleTerms.class, converter.getHandledAggregationType());  
        assertEquals(2, result.getBucketsCount());  
        double key,  
 * Tests for {@link DoubleTermsAggregateConverter}.
import org.opensearch.protobufs.Aggregate;  
import org.opensearch.search.aggregations.BucketOrder;
        metadata.put("color", "red");
        DoubleTermsBucket protoBucket = converter.toProto(doubleTerms).build().getDterms().getBuckets(0);
        DoubleTerms doubleTerms = createDoubleTerms("test", Collections.emptyList(), 0, 0, new HashMap<>());
        assertFalse("Should not have metadata for null", result.hasMeta());
    }
        );
    }  
    }
        assertEquals(10L, protoBucket.getDocCount());
        DoubleTermsAggregate result = converter.toProto(doubleTerms).build().getDterms();  
    }  
        assertEquals(3.14159, protoBucket.getKey(), 0.00001);
            200,
        DoubleTermsAggregate result = converter.toProto(doubleTerms).build().getDterms();  
        long docCountError,  
    ) {
        assertFalse("key_as_string should not be set with RAW format", protoBucket.hasKeyAsString());
    private final DoubleTermsAggregateConverter converter = createConverter();  
        String name,
        Map<String, Object> metadata = new HashMap<>();  
        return c;
        long docCountError,  
        metadata.put("count", 42);
    private final AggregateProtoConverterRegistry registry = new AggregateProtoConverterRegistryImpl();
        DoubleTermsAggregateConverter c = new DoubleTermsAggregateConverter();  
        DoubleTermsAggregate result = converter.toProto(doubleTerms).build().getDterms();
        boolean showDocCountError,
        DoubleTerms doubleTerms = createDoubleTerms("test", List.of(createBucket(9.99, 100, true, 3, DocValueFormat.RAW)), 0, 0, null);  
        assertTrue("Should have metadata", result.hasMeta());
import org.opensearch.protobufs.DoubleTermsBucket;
        DocValueFormat format = new DocValueFormat.Decimal("0.00");
            otherDocCount,  
    }
    public void testBucketWithDocCountError() throws IOException {
        assertEquals(3.14, protoBucket.getKey(), 0.001);  
import org.opensearch.search.aggregations.bucket.terms.DoubleTerms;  
package org.opensearch.transport.grpc.proto.response.search.aggregation.bucket.terms;
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoConverterRegistryImpl;  
        DoubleTerms doubleTerms = createDoubleTerms("test", Collections.emptyList(), 0, 0, metadata);
    public void testSingleBucket() throws IOException {
        Map<String, Object> metadata
 *
import org.opensearch.test.OpenSearchTestCase;
            BucketOrder.count(false),  
        DoubleTermsAggregate result = converter.toProto(doubleTerms).build().getDterms();
            buckets,
        assertEquals(3L, protoBucket.getDocCountErrorUpperBound());
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
import java.util.Map;
            metadata != null ? metadata : Collections.emptyMap(),
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;
        DoubleTerms doubleTerms = createDoubleTerms("test", Collections.emptyList(), 0, 0, null);
        assertFalse("Should not have metadata for null", result.hasMeta());
        assertTrue("Metadata should contain count", result.getMeta().getFieldsMap().containsKey("count"));
        assertFalse("Should not have metadata for empty map", result.hasMeta());  
        assertTrue("Metadata should contain color", result.getMeta().getFieldsMap().containsKey("color"));  
    public void testWithMetadata() throws IOException {
        DoubleTerms doubleTerms = createDoubleTerms(  
    private DoubleTermsAggregateConverter createConverter() {
            5,  
    public void testEmptyBuckets() throws IOException {  
        return new DoubleTerms(
 */
    }
    private static DoubleTerms createDoubleTerms(  
        assertEquals(0, result.getDocCountErrorUpperBound());
        DocValueFormat format
    }  
        assertEquals(5, result.getDocCountErrorUpperBound());
    public void testBucketWithFormattedKey() throws IOException {
    }
