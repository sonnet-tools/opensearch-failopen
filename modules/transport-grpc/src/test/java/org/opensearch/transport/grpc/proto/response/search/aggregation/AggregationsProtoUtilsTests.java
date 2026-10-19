        aggList.add(minAgg);
package org.opensearch.transport.grpc.proto.response.search.aggregation;
        AggregationsProtoUtils.toProto(aggregations, builder, registry);
    private final AggregateProtoConverterRegistry registry = new AggregateProtoConverterRegistryImpl();  
        assertEquals("Should have 1 aggregation", 1, builder.getAggregationsCount());
        AggregationsProtoUtils.toProto(aggregations, builder, registry);  
        SearchResponse.Builder builder = SearchResponse.newBuilder();
        aggList.add(maxAgg);
        Aggregations aggregations = InternalAggregations.from(aggList);  
        InternalMax maxAgg = new InternalMax("max_price", 100.0, DocValueFormat.RAW, Collections.emptyMap());
        AggregationsProtoUtils.toProto(aggregations, builder, registry);  
import org.opensearch.search.aggregations.metrics.InternalMin;
 */  
}  
        SearchResponse.Builder builder = SearchResponse.newBuilder();  
        assertTrue("Should have max_price", builder.containsAggregations("max_price"));
        SearchResponse.Builder builder = SearchResponse.newBuilder();
        SearchResponse.Builder builder = SearchResponse.newBuilder();
        assertTrue("Should have single_min", builder.containsAggregations("single_min"));  
import java.util.ArrayList;  
import org.opensearch.search.aggregations.metrics.InternalMax;  
        assertTrue("Should have min_price", builder.containsAggregations("min_price"));  
        assertEquals("Should have 0 aggregations", 0, builder.getAggregationsCount());
 * The OpenSearch Contributors require contributions made to  
        assertEquals("Should have 0 aggregations", 0, builder.getAggregationsCount());  
 * this file be licensed under the Apache-2.0 license or a
        InternalMin minAgg = new InternalMin("single_min", 42.0, DocValueFormat.RAW, Collections.emptyMap());
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.search.aggregations.InternalAggregations;
import org.opensearch.protobufs.SearchResponse;
        InternalMin minAgg = new InternalMin("min_price", 10.0, DocValueFormat.RAW, Collections.emptyMap());  
 *
import java.util.Collections;
        assertEquals("Should have 2 aggregations", 2, builder.getAggregationsCount());
        Aggregations aggregations = InternalAggregations.from(Collections.singletonList(minAgg));  
    public void testToProtoWithEmptyAggregations() throws IOException {  
/*  
import org.opensearch.search.aggregations.Aggregations;  
        List<InternalAggregation> aggList = new ArrayList<>();  
import org.opensearch.search.DocValueFormat;
        AggregationsProtoUtils.toProto(null, builder, registry);
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;  
import org.opensearch.search.aggregations.InternalAggregation;
    public void testToProtoWithSingleAggregation() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
    }
    public void testToProtoWithMultipleAggregations() throws IOException {
    }
    }
public class AggregationsProtoUtilsTests extends OpenSearchTestCase {
import java.util.List;
 * compatible open source license.
    public void testToProtoWithNullAggregations() throws IOException {  
        Aggregations aggregations = InternalAggregations.EMPTY;
    }
import java.io.IOException;
