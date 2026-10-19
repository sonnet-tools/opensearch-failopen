import org.opensearch.protobufs.LongTermsAggregate;
    @Override
 * SPDX-License-Identifier: Apache-2.0
        builder.setDocCount(bucket.getDocCount());
package org.opensearch.transport.grpc.proto.response.search.aggregation.bucket.terms;
    @Override
    }
        return builder.build();  
        for (LongTerms.Bucket bucket : longTerms.getBuckets()) {
        }
                        + ")"
        LongTermsAggregate.Builder termsBuilder = LongTermsAggregate.newBuilder();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
/**  
 * compatible open source license.
import org.opensearch.search.aggregations.InternalAggregation;
        return LongTerms.class;
 */
        LongTerms longTerms = (LongTerms) aggregation;  
        if (key instanceof Long) {
     * Mirroring {@link LongTerms.Bucket#keyToXContent(XContentBuilder)}
 *
        for (Aggregation subAgg : bucket.getAggregations()) {
        this.registry = registry;
                builder.putAggregate(subAgg.getName(), AggregateProtoUtils.toProto(internalAgg, registry));  
     * Creates a new LongTermsAggregateConverter.
        if (bucket.getFormat() != DocValueFormat.RAW && bucket.getFormat() != DocValueFormat.UNSIGNED_LONG_SHIFTED) {
    }  
}
import org.opensearch.core.xcontent.XContentBuilder;  
            builder.setKey(LongTermsBucketKey.newBuilder().setUnsigned(key.toString()));
import org.opensearch.protobufs.LongTermsBucketKey;
     */
    public Class<? extends InternalAggregation> getHandledAggregationType() {
    /**
        Object key = bucket.getKey();  
import org.opensearch.protobufs.LongTermsBucket;  
 * Converter for {@link LongTerms} aggregations to Protocol Buffer Aggregate messages.
                        + " (name="
                throw new IllegalStateException(
            } else {
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoUtils;  
                        + subAgg.getClass().getName()
            builder.setKey(LongTermsBucketKey.newBuilder().setSigned((long) key));
    private LongTermsBucket convertBucket(LongTerms.Bucket bucket) throws IOException {  
            }  
    public LongTermsAggregateConverter() {}
import org.opensearch.transport.grpc.spi.AggregateProtoConverterRegistry;
/*  
    }
            termsBuilder.addBuckets(convertBucket(bucket));  
import org.opensearch.protobufs.Aggregate;
public class LongTermsAggregateConverter implements AggregateProtoConverter {  
import org.opensearch.search.aggregations.Aggregation;  
        LongTermsBucket.Builder builder = LongTermsBucket.newBuilder();
        termsBuilder.setSumOtherDocCount(longTerms.getSumOfOtherDocCounts());  
    public Aggregate.Builder toProto(InternalAggregation aggregation) throws IOException {
                    "Unexpected aggregation type in terms bucket sub-aggregations: "  
import java.io.IOException;
    public void setRegistry(AggregateProtoConverterRegistry registry) {  
                );
        }
        }
            if (subAgg instanceof InternalAggregation internalAgg) {
        if (bucket.showDocCountError()) {  
 */  
    @Override  
 * this file be licensed under the Apache-2.0 license or a
            builder.setDocCountErrorUpperBound(bucket.getDocCountError());
            builder.setKeyAsString(bucket.getKeyAsString());
        }  
import org.opensearch.search.DocValueFormat;
import org.opensearch.transport.grpc.spi.AggregateProtoConverter;
     */  
        } else {  
        termsBuilder.setDocCountErrorUpperBound(longTerms.getDocCountError());
    private AggregateProtoConverterRegistry registry;
    }
        return Aggregate.newBuilder().setLterms(termsBuilder.build());  
        }
    /**  
        AggregateProtoUtils.addMetadata(termsBuilder::setMeta, longTerms);  
                        + subAgg.getName()  
