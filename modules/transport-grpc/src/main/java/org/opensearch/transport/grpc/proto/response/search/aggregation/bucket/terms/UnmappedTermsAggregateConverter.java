     */
 * this file be licensed under the Apache-2.0 license or a
        return Aggregate.newBuilder().setUmterms(termsBuilder.build());
        termsBuilder.setSumOtherDocCount(0);
 * compatible open source license.
    /**  
 */  
    @Override
    public UnmappedTermsAggregateConverter() {}  
import java.io.IOException;
    public Class<? extends InternalAggregation> getHandledAggregationType() {  
}  
import org.opensearch.transport.grpc.spi.AggregateProtoConverter;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.InternalAggregation;
/**  
    @Override
        UnmappedTermsAggregate.Builder termsBuilder = UnmappedTermsAggregate.newBuilder();  
public class UnmappedTermsAggregateConverter implements AggregateProtoConverter {
import org.opensearch.protobufs.UnmappedTermsAggregate;
 * Converter for {@link UnmappedTerms} aggregations to Protocol Buffer Aggregate messages.
package org.opensearch.transport.grpc.proto.response.search.aggregation.bucket.terms;
    }
import org.opensearch.transport.grpc.proto.response.search.aggregation.AggregateProtoUtils;
    }
        AggregateProtoUtils.addMetadata(termsBuilder::setMeta, aggregation);
        termsBuilder.setDocCountErrorUpperBound(0);
import org.opensearch.protobufs.Aggregate;  
/*  
        return UnmappedTerms.class;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.bucket.terms.UnmappedTerms;  
 */  
     * Creates a new UnmappedTermsAggregateConverter.
 * Mirrors {@link UnmappedTerms#doXContentBody} which writes zero doc_count_error_upper_bound,
    public Aggregate.Builder toProto(InternalAggregation aggregation) throws IOException {
 *
