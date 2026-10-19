    @Override  
            @Override
import org.opensearch.search.pipeline.AbstractProcessor;  
    }
/*  
        }
 * SPDX-License-Identifier: Apache-2.0
        if (aclValues.isEmpty()) {
    }
        if (query == null) {  
            }
    private final String aclField;  
    }  
     * @param extractFromQuery whether to extract ACL values from query
        byte[] bytes = aclValue.getBytes(StandardCharsets.UTF_8);  
    /**  
            result[i] = (byte) (value & 0xFF);
    }
        return BASE64_ENCODER.encodeToString(hashBytes);
import org.opensearch.index.query.QueryBuilderVisitor;
import java.util.ArrayList;
                }
        System.arraycopy(longToBytes(hash.h1), 0, hashBytes, 0, 8);
                } else if (qb instanceof TermsQueryBuilder termsQuery && aclField.equals(termsQuery.fieldName())) {
            return new AclRoutingSearchProcessor(tag, description, ignoreFailure, aclField, extractFromQuery);  
     * Factory for creating ACL routing search processors.  
     * @param ignoreFailure whether to ignore failures
            PipelineContext pipelineContext
        this.extractFromQuery = extractFromQuery;  
import java.nio.charset.StandardCharsets;
 */  
        return request;  
import java.util.Base64;  
     * Constructor for AclRoutingSearchProcessor.
}  
     * @param description processor description
            public void accept(QueryBuilder qb) {
        return TYPE;
            }
    }  
    public static final String TYPE = "acl_routing_search";  
import java.util.List;
        // Use MurmurHash3 for consistent hashing (same as ingest processor)
        List<String> aclValues = new ArrayList<>();
import org.opensearch.search.pipeline.Processor;
        @Override  
        this.aclField = aclField;
        /**
    private static final Base64.Encoder BASE64_ENCODER = Base64.getUrlEncoder().withoutPadding();
 *
        }
         */  
            @Override
    @Override
     */
 * compatible open source license.
    private final boolean extractFromQuery;
            String description,
        System.arraycopy(longToBytes(hash.h2), 0, hashBytes, 8, 8);  
        for (int i = 7; i >= 0; i--) {
     *
            boolean extractFromQuery = ConfigurationUtils.readBooleanProperty(TYPE, tag, config, "extract_from_query", true);
        query.visit(new QueryBuilderVisitor() {  
        // Convert to base64 for routing value  
    private List<String> extractAclValues(QueryBuilder query) {  
    public static class Factory implements Processor.Factory<SearchRequestProcessor> {
            return request;  
import org.opensearch.action.search.SearchRequest;
        return aclValues;
     * @param tag processor tag  
            String tag,  
import org.opensearch.index.query.TermsQueryBuilder;
        ) throws Exception {
        }
            Map<String, Object> config,  
import org.opensearch.index.query.QueryBuilder;
 */  
        return result;
            Map<String, Processor.Factory<SearchRequestProcessor>> processorFactories,
import org.opensearch.ingest.ConfigurationUtils;
 * Search processor that adds routing based on ACL fields in the query.
import java.util.Map;
     * The type name for this processor.
import org.apache.lucene.search.BooleanClause;
         * Constructor for Factory.
public class AclRoutingSearchProcessor extends AbstractProcessor implements SearchRequestProcessor {
        if (!extractFromQuery || request.source() == null) {
        byte[] hashBytes = new byte[16];
            public QueryBuilderVisitor getChildVisitor(BooleanClause.Occur occur) {
import org.opensearch.common.hash.MurmurHash3;  
            return request;
                    aclValues.add(termQuery.value().toString());
        MurmurHash3.Hash128 hash = MurmurHash3.hash128(bytes, 0, bytes.length, 0, new MurmurHash3.Hash128());
            value >>= 8;  
    public SearchRequest processRequest(SearchRequest request) throws Exception {  
    private String generateRoutingValue(String aclValue) {
/**
    /**  
                    termsQuery.values().forEach(value -> aclValues.add(value.toString()));  
                if (qb instanceof TermQueryBuilder termQuery && aclField.equals(termQuery.fieldName())) {  
            return request;
package org.opensearch.search.pipeline.common;
        public AclRoutingSearchProcessor create(
        byte[] result = new byte[8];  
import org.opensearch.search.pipeline.SearchRequestProcessor;
import org.opensearch.index.query.TermQueryBuilder;  
        }  
        public Factory() {}
        request.routing(routingValues);
            boolean ignoreFailure,
            String aclField = ConfigurationUtils.readStringProperty(TYPE, tag, config, "acl_field");  
     * @param aclField the field to extract ACL values from  
        super(tag, description, ignoreFailure);
 * The OpenSearch Contributors require contributions made to  
     */
                return this;  
     */
    public AclRoutingSearchProcessor(String tag, String description, boolean ignoreFailure, String aclField, boolean extractFromQuery) {  
        String[] routingValues = aclValues.stream().map(this::generateRoutingValue).toArray(String[]::new);
    }
    /**
    }  
        // Generate routing values  
        QueryBuilder query = request.source().query();
        }
        List<String> aclValues = extractAclValues(query);
 * this file be licensed under the Apache-2.0 license or a
        });
    private byte[] longToBytes(long value) {
    public String getType() {
        // Set routing on the request  
