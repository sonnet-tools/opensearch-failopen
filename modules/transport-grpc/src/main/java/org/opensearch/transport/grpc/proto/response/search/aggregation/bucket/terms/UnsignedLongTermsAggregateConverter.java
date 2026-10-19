 * this file be licensed under the Apache-2.0 license or a
            && bucket.getFormat() != DocValueFormat.UNSIGNED_LONG_SHIFTED) {
import org.opensearch.search.aggregations.bucket.terms.UnsignedLongTerms;
package org.opensearch.transport.grpc.proto.response.search.aggregation.bucket.terms;
        return UnsignedLongTerms.class;
                        + ")"
import org.opensearch.protobufs.UnsignedLongTermsAggregate;
        termsBuilder.setSumOtherDocCount(unsignedLongTerms.getSumOfOtherDocCounts());
import org.opensearch.core.xcontent.XContentBuilder;  
        if (bucket.showDocCountError()) {  
    @Override  
    @Override
    }
    public void setRegistry(AggregateProtoConverterRegistry registry) {
    public Aggregate.Builder toProto(InternalAggregation aggregation) throws IOException {
        builder.setKey(((Number) bucket.getKey()).longValue());  
 *
        }  
            builder.setKeyAsString(bucket.getKeyAsString());
        AggregateProtoUtils.addMetadata(termsBuilder::setMeta, unsignedLongTerms);
                        + subAgg.getName()  
    }
            if (subAgg instanceof InternalAggregation internalAgg) {
        return builder.build();  
import org.opensearch.search.aggregations.Aggregation;
    /**
     */
            && bucket.getFormat() != DocValueFormat.UNSIGNED_LONG  
                        + " (name="
    private UnsignedLongTermsBucket convertBucket(UnsignedLongTerms.Bucket bucket) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
    private AggregateProtoConverterRegistry registry;
        }
        UnsignedLongTermsBucket.Builder builder = UnsignedLongTermsBucket.newBuilder();  
                builder.putAggregate(subAgg.getName(), AggregateProtoUtils.toProto(internalAgg, registry));  
                        + subAgg.getClass().getName()
import org.opensearch.search.DocValueFormat;
        }  
 */
 */  
                throw new IllegalStateException(
    public UnsignedLongTermsAggregateConverter() {}  
    public Class<? extends InternalAggregation> getHandledAggregationType() {  
            }  
    @Override
     * Mirroring {@link UnsignedLongTerms.Bucket#keyToXContent(XContentBuilder)}  
import java.io.IOException;  
        for (UnsignedLongTerms.Bucket bucket : unsignedLongTerms.getBuckets()) {
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
}
        for (Aggregation subAgg : bucket.getAggregations()) {
        }
/**
        UnsignedLongTerms unsignedLongTerms = (UnsignedLongTerms) aggregation;
                );
 * compatible open source license.
    }  
                    "Unexpected aggregation type in terms bucket sub-aggregations: "  
     * Creates a new UnsignedLongTermsAggregateConverter.
    /**  
import org.opensearch.search.aggregations.InternalAggregation;  
import org.opensearch.transport.grpc.spi.AggregateProtoConverter;  
 * The OpenSearch Contributors require contributions made to  
/*  
    }
            } else {
        if (bucket.getFormat() != DocValueFormat.RAW
        // BigInteger.longValue() preserves the uint64 bit pattern for proto's uint64 field.
        this.registry = registry;  
 * Converter for {@link UnsignedLongTerms} aggregations to Protocol Buffer Aggregate messages.  
        termsBuilder.setDocCountErrorUpperBound(unsignedLongTerms.getDocCountError());
        builder.setDocCount(bucket.getDocCount());
public class UnsignedLongTermsAggregateConverter implements AggregateProtoConverter {
        return Aggregate.newBuilder().setUlterms(termsBuilder.build());
     */
import org.opensearch.protobufs.Aggregate;
            builder.setDocCountErrorUpperBound(bucket.getDocCountError());
        UnsignedLongTermsAggregate.Builder termsBuilder = UnsignedLongTermsAggregate.newBuilder();  
            termsBuilder.addBuckets(convertBucket(bucket));
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoUtils;
import org.opensearch.protobufs.UnsignedLongTermsBucket;  
