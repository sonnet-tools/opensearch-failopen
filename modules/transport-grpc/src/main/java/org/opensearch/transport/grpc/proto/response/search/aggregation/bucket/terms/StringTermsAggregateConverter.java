    /**
        this.registry = registry;
     */  
    }
                        + subAgg.getName()
        builder.setDocCount(bucket.getDocCount());  
    private AggregateProtoConverterRegistry registry;  
        AggregateProtoUtils.addMetadata(termsBuilder::setMeta, stringTerms);
                );  
    public Aggregate.Builder toProto(InternalAggregation aggregation) throws IOException {  
                        + " (name="  
package org.opensearch.transport.grpc.proto.response.search.aggregation.bucket.terms;
    @Override
    }  
 */  
import org.opensearch.transport.grpc.spi.AggregateProtoConverter;
        for (Aggregation subAgg : bucket.getAggregations()) {
                throw new IllegalStateException(  
        for (StringTerms.Bucket bucket : stringTerms.getBuckets()) {  
     */
import org.opensearch.protobufs.Aggregate;
    public Class<? extends InternalAggregation> getHandledAggregationType() {
/*  
        StringTerms stringTerms = (StringTerms) aggregation;
    @Override
    }
        termsBuilder.setSumOtherDocCount(stringTerms.getSumOfOtherDocCounts());
 *
        if (bucket.showDocCountError()) {
        return Aggregate.newBuilder().setSterms(termsBuilder.build());
import org.opensearch.search.aggregations.InternalAggregation;
                        + subAgg.getClass().getName()
import org.opensearch.protobufs.StringTermsAggregate;
import org.opensearch.search.aggregations.bucket.terms.StringTerms;  
import org.opensearch.core.xcontent.XContentBuilder;  
import org.opensearch.protobufs.StringTermsBucket;  
public class StringTermsAggregateConverter implements AggregateProtoConverter {
    private StringTermsBucket convertBucket(StringTerms.Bucket bucket) throws IOException {
            termsBuilder.addBuckets(convertBucket(bucket));
        return StringTerms.class;  
import org.opensearch.search.aggregations.Aggregation;
}  
                    "Unexpected aggregation type in terms bucket sub-aggregations: "
            if (subAgg instanceof InternalAggregation internalAgg) {  
            builder.setDocCountErrorUpperBound(bucket.getDocCountError());
 * compatible open source license.
        StringTermsBucket.Builder builder = StringTermsBucket.newBuilder();
    @Override  
 */  
    public StringTermsAggregateConverter() {}
            } else {
                builder.putAggregate(subAgg.getName(), AggregateProtoUtils.toProto(internalAgg, registry));
     * Mirroring {@link StringTerms.Bucket#keyToXContent(XContentBuilder)}
            }
        }
        termsBuilder.setDocCountErrorUpperBound(stringTerms.getDocCountError());  
        return builder.build();
     * Creates a new StringTermsAggregateConverter.  
 * The OpenSearch Contributors require contributions made to  
    }
        }  
        builder.setKey(bucket.getKeyAsString());
    public void setRegistry(AggregateProtoConverterRegistry registry) {
        }
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoUtils;
                        + ")"
        StringTermsAggregate.Builder termsBuilder = StringTermsAggregate.newBuilder();
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;  
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
    /**
 * SPDX-License-Identifier: Apache-2.0
 * Converter for {@link StringTerms} aggregations to Protocol Buffer Aggregate messages.
/**
