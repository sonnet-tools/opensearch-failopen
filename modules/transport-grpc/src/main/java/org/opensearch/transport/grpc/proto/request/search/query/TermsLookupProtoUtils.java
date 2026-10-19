    /**
    }
/*  
                if (registry == null) {  
     * Convenience overload for lookups that cannot contain a nested query.
        return parseTermsLookup(termsLookupProto, null);
        QueryBuilderProtoConverterRegistry registry
     * @return A configured TermsLookup instance
 * The OpenSearch Contributors require contributions made to  
     *
        switch (termsLookupProto.getTermsLookupCase()) {
 * into their corresponding OpenSearch TermsLookup implementations for search operations.
                break;
            case TERMSLOOKUP_NOT_SET:
 * this file be licensed under the Apache-2.0 license or a
}  
        // Utility class, no instances
     * <p>
     * @return A configured TermsLookup instance
    private TermsLookupProtoUtils() {  
        String path = termsLookupProto.getPath();
     * @param termsLookupProto the Protocol Buffer TermsLookup object  
import org.opensearch.indices.TermsLookup;
        String index = termsLookupProto.getIndex();
        TermsLookup termsLookup = new TermsLookup(index, id, path, query);  
    @SuppressWarnings("deprecation")
                query = registry.fromProto(termsLookupProto.getQuery());  
        org.opensearch.protobufs.TermsLookup termsLookupProto,  
     * @param registry used to convert a {@code query} lookup; may be null when the lookup cannot contain a query
                break;  
    }
package org.opensearch.transport.grpc.proto.request.search.query;
        String id = null;
 */  
     *  
    protected static TermsLookup parseTermsLookup(
                id = termsLookupProto.getId2();  
        if (termsLookupProto.hasRouting()) {
                break;
            termsLookup.routing(termsLookupProto.getRouting());  
        if (termsLookupProto.hasStore()) {  
     */  
     * Converts a Protocol Buffer TermsLookup to an OpenSearch TermsLookup object.  
 */  
    /**
        }
    }  
                    throw new IllegalArgumentException("A query converter registry is required to parse a query-based terms lookup");
    protected static TermsLookup parseTermsLookup(org.opensearch.protobufs.TermsLookup termsLookupProto) {
            case ID_2:
            termsLookup.store(termsLookupProto.getStore());
            default:  
                id = termsLookupProto.getId();
/**
        }
     * Similar to {@link TermsLookup#parseTermsLookup(XContentParser)}.
     * @param termsLookupProto the Protocol Buffer TermsLookup object
        QueryBuilder query = null;
            case QUERY:
 * compatible open source license.
                }
                // Backwards compatibility: fall back to the deprecated `id` field.
    ) {
import org.opensearch.transport.grpc.spi.QueryBuilderProtoConverterRegistry;  
        return termsLookup;
     */  
 * SPDX-License-Identifier: Apache-2.0
 *
import org.opensearch.core.xcontent.XContentParser;  
public class TermsLookupProtoUtils {
 * This class provides methods to transform Protocol Buffer representations of terms lookups
     * As of protobufs 1.7.0, terms are identified either by {@code id_2} or by a nested {@code query};  
     * the deprecated {@code id} field is honored when the oneof is not set.
        }
import org.opensearch.index.query.QueryBuilder;
 * Utility class for converting TermsLookup Protocol Buffers to OpenSearch objects.  
