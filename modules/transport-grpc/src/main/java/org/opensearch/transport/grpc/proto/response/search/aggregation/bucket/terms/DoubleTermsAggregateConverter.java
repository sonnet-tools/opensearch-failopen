        if (bucket.getFormat() != DocValueFormat.RAW) {
                        + subAgg.getClass().getName()
                        + " (name="
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.transport.grpc.proto.response.search.aggregation.bucket.terms;
        }  
 * Converter for {@link DoubleTerms} aggregations to Protocol Buffer Aggregate messages.  
                throw new IllegalStateException(
}
            } else {
        }
    public Aggregate.Builder toProto(InternalAggregation aggregation) throws IOException {
    /**
        builder.setKey((double) bucket.getKey());
            }  
        return Aggregate.newBuilder().setDterms(termsBuilder.build());
                builder.putAggregate(subAgg.getName(), AggregateProtoUtils.toProto(internalAgg, registry));  
    }
                    "Unexpected aggregation type in terms bucket sub-aggregations: "  
 * this file be licensed under the Apache-2.0 license or a
                        + subAgg.getName()  
import org.opensearch.search.aggregations.InternalAggregation;  
    }
 * The OpenSearch Contributors require contributions made to  
    }
        }
    }  
 */
 */  
public class DoubleTermsAggregateConverter implements AggregateProtoConverter {
    private AggregateProtoConverterRegistry registry;
        DoubleTerms doubleTerms = (DoubleTerms) aggregation;
    public void setRegistry(AggregateProtoConverterRegistry registry) {
import org.opensearch.transport.grpc.spi.AggregateProtoConverter;  
    @Override
import org.opensearch.protobufs.Aggregate;
            termsBuilder.addBuckets(convertBucket(bucket));
import org.opensearch.search.aggregations.bucket.terms.DoubleTerms;
import org.opensearch.search.DocValueFormat;
                );
        termsBuilder.setSumOtherDocCount(doubleTerms.getSumOfOtherDocCounts());
        builder.setDocCount(bucket.getDocCount());
        return builder.build();  
        }  
     */
        if (bucket.showDocCountError()) {  
     */
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoUtils;
            builder.setDocCountErrorUpperBound(bucket.getDocCountError());
 * compatible open source license.
import org.opensearch.protobufs.DoubleTermsAggregate;
    public Class<? extends InternalAggregation> getHandledAggregationType() {  
    @Override  
        termsBuilder.setDocCountErrorUpperBound(doubleTerms.getDocCountError());
import java.io.IOException;  
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
                        + ")"
        DoubleTermsAggregate.Builder termsBuilder = DoubleTermsAggregate.newBuilder();  
        for (Aggregation subAgg : bucket.getAggregations()) {
/**
        AggregateProtoUtils.addMetadata(termsBuilder::setMeta, doubleTerms);
        for (DoubleTerms.Bucket bucket : doubleTerms.getBuckets()) {
            builder.setKeyAsString(bucket.getKeyAsString());
        DoubleTermsBucket.Builder builder = DoubleTermsBucket.newBuilder();  
/*  
    public DoubleTermsAggregateConverter() {}  
import org.opensearch.protobufs.DoubleTermsBucket;  
    /**  
    @Override
import org.opensearch.search.aggregations.Aggregation;
import org.opensearch.core.xcontent.XContentBuilder;  
    private DoubleTermsBucket convertBucket(DoubleTerms.Bucket bucket) throws IOException {
     * Mirroring {@link DoubleTerms.Bucket#keyToXContent(XContentBuilder)}  
 *
        return DoubleTerms.class;
     * Creates a new DoubleTermsAggregateConverter.
        this.registry = registry;  
            if (subAgg instanceof InternalAggregation internalAgg) {
