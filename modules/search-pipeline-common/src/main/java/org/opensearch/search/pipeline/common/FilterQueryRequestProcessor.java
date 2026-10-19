            PipelineContext pipelineContext
    }  
    @Override
        if (originalQuery != null) {
            ) {
import org.opensearch.search.pipeline.AbstractProcessor;
    static class Factory implements Processor.Factory<SearchRequestProcessor> {
        this.filterQuery = filterQuery;  
    /**  
     * @param description    processor description  
        }
            filteredQuery.must(originalQuery);
        }  
     * @param ignoreFailure  option to ignore failure
import org.opensearch.index.query.BoolQueryBuilder;  
package org.opensearch.search.pipeline.common;
}  
     * Returns the type of the processor.
        @Override
            originalQuery = request.source().query();  
     */
            String tag,
        public FilterQueryRequestProcessor create(
        request.source().query(filteredQuery);
     * @return The modified search request.
        BoolQueryBuilder filteredQuery = new BoolQueryBuilder().filter(filterQuery);  
    @Override  
        private final NamedXContentRegistry namedXContentRegistry;
        return request;
        }
        Factory(NamedXContentRegistry namedXContentRegistry) {  
public class FilterQueryRequestProcessor extends AbstractProcessor implements SearchRequestProcessor {
/*  
            this.namedXContentRegistry = namedXContentRegistry;
        if (request.source() == null) {
            }
     * Key to reference this processor type from a search pipeline.
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
import org.opensearch.search.builder.SearchSourceBuilder;  
     */
    public SearchRequest processRequest(SearchRequest request) throws Exception {  
                    .createParser(namedXContentRegistry, LoggingDeprecationHandler.INSTANCE, stream)  
 *
 * compatible open source license.
     * @param request The search request to be processed.
        return TYPE;
            Map<String, Object> config,
                InputStream stream = BytesReference.bytes(builder).streamInput();
     *  
import org.opensearch.search.pipeline.SearchRequestProcessor;  
        QueryBuilder originalQuery = null;
        }  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.pipeline.Processor;
import org.opensearch.ingest.ConfigurationUtils;
        }
import java.util.Map;  
     * Modifies the search request by adding a filtered query to the existing query, if any, and sets it as the new query
                return new FilterQueryRequestProcessor(tag, description, ignoreFailure, parseInnerQueryBuilder(parser));
            try (
    public static final String TYPE = "filter_query";  
            if (query == null) {
     * in the search request's SearchSourceBuilder.
 * SPDX-License-Identifier: Apache-2.0
            }  
            String description,
    public String getType() {
 */
     *  
 * The OpenSearch Contributors require contributions made to  
                XContentParser parser = MediaTypeRegistry.JSON.xContent()
     *
    }  
        if (request.source() != null) {
 * This is a {@link SearchRequestProcessor} that replaces the incoming query with a BooleanQuery
     */
    final QueryBuilder filterQuery;
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.common.xcontent.json.JsonXContent;  
/**
     * Constructor that takes a filter query.  
    }
    /**
            boolean ignoreFailure,  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
     * @throws Exception if an error occurs while processing the request.  
 * that MUST match the incoming query with a FILTER clause based on the configured query.  
import org.opensearch.core.xcontent.MediaTypeRegistry;
    FilterQueryRequestProcessor(String tag, String description, boolean ignoreFailure, QueryBuilder filterQuery) {
        super(tag, description, ignoreFailure);
import org.opensearch.action.search.SearchRequest;
import org.opensearch.core.xcontent.XContentParser;
    }
                XContentBuilder builder = XContentBuilder.builder(JsonXContent.jsonXContent).map(query);  
 */  
                throw new IllegalArgumentException("Did not specify the " + QUERY_KEY + " property in processor of type " + TYPE);  
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
import org.opensearch.index.query.QueryBuilder;
    /**  
import java.io.InputStream;
     */  
            Map<String, Object> query = ConfigurationUtils.readOptionalMap(TYPE, tag, config, QUERY_KEY);
        private static final String QUERY_KEY = "query";  
     * @return The processor type.
    /**
     * @param tag            processor tag
            Map<String, Processor.Factory<SearchRequestProcessor>> processorFactories,  
        ) throws Exception {  
import org.opensearch.core.common.bytes.BytesReference;
            request.source(new SearchSourceBuilder());
     * @param filterQuery the query that will be added as a filter to incoming queries
