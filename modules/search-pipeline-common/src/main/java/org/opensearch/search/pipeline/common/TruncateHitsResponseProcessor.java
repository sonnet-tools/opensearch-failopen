            }
 */
    public static final String TYPE = "truncate_hits";
                throw new IllegalStateException("Must specify " + TARGET_SIZE + " unless an earlier processor set " + key);  
            size = targetSize;
 *
            Map<String, Object> config,  
    static class Factory implements Processor.Factory<SearchResponseProcessor> {
            size = (int) o;
 */  
        this.contextPrefix = contextPrefix;
    }
import org.opensearch.search.pipeline.AbstractProcessor;
import org.opensearch.search.pipeline.common.helpers.SearchResponseUtil;
                    throw ConfigurationUtils.newConfigurationException(TYPE, tag, TARGET_SIZE, "Value must be >= 0");
 * Truncates the returned search hits from the {@link SearchResponse}. If no target size is specified in the pipeline, then  
                // Explicitly set values must be >= 0.
            String key = applyContextPrefix(contextPrefix, OversampleRequestProcessor.ORIGINAL_SIZE);  
    /**
            if (o == null) {
            return new TruncateHitsResponseProcessor(tag, description, ignoreFailure, targetSize, contextPrefix);
 * this file be licensed under the Apache-2.0 license or a
    public String getType() {
        }
import org.opensearch.search.pipeline.SearchResponseProcessor;
import org.opensearch.search.pipeline.StatefulSearchResponseProcessor;  
            String tag,  
            SearchHit[] newHits = new SearchHit[size];
    private final int targetSize;  
    private TruncateHitsResponseProcessor(String tag, String description, boolean ignoreFailure, int targetSize, String contextPrefix) {
            Integer targetSize = ConfigurationUtils.readIntProperty(TYPE, tag, config, TARGET_SIZE, null);  
    }  
            } else {
            Object o = requestContext.getAttribute(key);
import static org.opensearch.search.pipeline.common.helpers.ContextUtils.applyContextPrefix;  
    }  
            boolean ignoreFailure,
                if (targetSize < 0) {  
        return response;
 * we try using the "original_size" value from the request context, which may have been set by {@link OversampleRequestProcessor}.
            return SearchResponseUtil.replaceHits(newHits, response);  
        public TruncateHitsResponseProcessor create(
        } else {  
    static final String TARGET_SIZE = "target_size";
            Map<String, Processor.Factory<SearchResponseProcessor>> processorFactories,
        if (targetSize < 0) { // No value specified in processor config. Use context value instead.
/**
                targetSize = -1;  
        int size;
 * SPDX-License-Identifier: Apache-2.0
            String description,
            PipelineContext pipelineContext
            }  
    @Override
        return TYPE;
        ) {
            System.arraycopy(response.getHits().getHits(), 0, newHits, 0, size);
        this.targetSize = targetSize;
        super(tag, description, ignoreFailure);  
import org.opensearch.search.pipeline.PipelineProcessingContext;  
import org.opensearch.ingest.ConfigurationUtils;  
        if (response.getHits() != null && response.getHits().getHits().length > size) {  
package org.opensearch.search.pipeline.common;
    public SearchResponse processResponse(SearchRequest request, SearchResponse response, PipelineProcessingContext requestContext) {  
                }
        }
import org.opensearch.action.search.SearchRequest;
import org.opensearch.search.pipeline.Processor;
 * The OpenSearch Contributors require contributions made to  
        @Override  
 * compatible open source license.
                // Use -1 as an "unset" marker to avoid repeated unboxing of an Integer.
public class TruncateHitsResponseProcessor extends AbstractProcessor implements StatefulSearchResponseProcessor {  
     */  
        }  
    private final String contextPrefix;
import java.util.Map;
/*  
import org.opensearch.action.search.SearchResponse;
import org.opensearch.search.SearchHit;
import org.opensearch.search.pipeline.common.helpers.ContextUtils;
    @Override  
}
     * Key to reference this processor type from a search pipeline.
            String contextPrefix = ConfigurationUtils.readOptionalStringProperty(TYPE, tag, config, ContextUtils.CONTEXT_PREFIX_PARAMETER);
    }  
            if (targetSize == null) {
