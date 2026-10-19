            metadata != null ? metadata : Collections.emptyMap()
    public void testWithNullMetadata() throws IOException {
 */  
        assertFalse("Should not have metadata for empty map", result.hasMeta());
            BucketOrder.count(false),  
import org.opensearch.search.aggregations.BucketOrder;
    public void testWithEmptyMetadata() throws IOException {
    private static UnmappedTerms createUnmappedTerms(String name, Map<String, Object> metadata) {  
import java.util.Collections;
 * Tests for {@link UnmappedTermsAggregateConverter}.
    }
    }
        Aggregate aggregate = converter.toProto(unmappedTerms).build();
        assertEquals(UnmappedTerms.class, converter.getHandledAggregationType());
        Map<String, Object> metadata = new HashMap<>();  
    }
        UnmappedTerms unmappedTerms = createUnmappedTerms("unmapped_field", null);
        UnmappedTermsAggregate result = converter.toProto(unmappedTerms).build().getUmterms();
        assertEquals(0, result.getSumOtherDocCount());
package org.opensearch.transport.grpc.proto.response.search.aggregation.bucket.terms;
import org.opensearch.protobufs.UnmappedTermsAggregate;
import org.opensearch.protobufs.Aggregate;  
 * this file be licensed under the Apache-2.0 license or a
            new TermsAggregator.BucketCountThresholds(1, 0, 10, -1),
import java.util.Map;
/**  
 * The OpenSearch Contributors require contributions made to  
            name,
        UnmappedTerms unmappedTerms = createUnmappedTerms("unmapped_field", null);
        assertFalse("Should not have metadata for null", result.hasMeta());  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;  
/*  
        UnmappedTermsAggregate result = converter.toProto(unmappedTerms).build().getUmterms();
        assertTrue("Should have metadata", result.hasMeta());
import java.io.IOException;
        assertTrue("Should have umterms set", aggregate.hasUmterms());
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
public class UnmappedTermsAggregateConverterTests extends OpenSearchTestCase {  
        UnmappedTermsAggregate result = converter.toProto(unmappedTerms).build().getUmterms();
import org.opensearch.search.aggregations.bucket.terms.UnmappedTerms;
    public void testGetHandledAggregationType() {
    }  
    public void testToProtoReturnsZeroCounts() throws IOException {
        metadata.put("reason", "unmapped");
        );  
        return new UnmappedTerms(
    }  
    public void testWithMetadata() throws IOException {
    }
        assertTrue("Metadata should contain reason", result.getMeta().getFieldsMap().containsKey("reason"));
 */
}
        UnmappedTerms unmappedTerms = createUnmappedTerms("unmapped_field", new HashMap<>());  
 *
    private final UnmappedTermsAggregateConverter converter = new UnmappedTermsAggregateConverter();
        assertFalse("Should not have metadata for null", result.hasMeta());
import java.util.HashMap;  
        UnmappedTerms unmappedTerms = createUnmappedTerms("unmapped_field", metadata);  
        UnmappedTermsAggregate result = converter.toProto(unmappedTerms).build().getUmterms();
    public void testToProtoWrapsAsUmterms() throws IOException {
    }  
        UnmappedTerms unmappedTerms = createUnmappedTerms("unmapped_field", null);  
        assertEquals(0, result.getDocCountErrorUpperBound());  
