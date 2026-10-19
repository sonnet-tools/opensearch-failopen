    }  
            int originalSize = request.source().size();  
    public static final String TYPE = "oversample";  
            return new OversampleRequestProcessor(tag, description, ignoreFailure, sampleFactor, contextPrefix);
    }
import org.opensearch.ingest.ConfigurationUtils;
    /**  
 * this file be licensed under the Apache-2.0 license or a
            int newSize = (int) Math.ceil(originalSize * sampleFactor);
    public String getType() {  
                throw ConfigurationUtils.newConfigurationException(TYPE, tag, SAMPLE_FACTOR, "Value must be >= 1.0");
    static final String SAMPLE_FACTOR = "sample_factor";
            if (originalSize == -1) {
import org.opensearch.search.pipeline.AbstractProcessor;
import org.opensearch.search.pipeline.StatefulSearchRequestProcessor;
            requestContext.setAttribute(applyContextPrefix(contextPrefix, ORIGINAL_SIZE), originalSize);
            String tag,
import org.opensearch.search.pipeline.PipelineProcessingContext;
            String contextPrefix = ConfigurationUtils.readOptionalStringProperty(TYPE, tag, config, ContextUtils.CONTEXT_PREFIX_PARAMETER);  
            boolean ignoreFailure,
            PipelineContext pipelineContext  
import org.opensearch.search.SearchService;  
import org.opensearch.search.pipeline.Processor;  
        }
    private final double sampleFactor;  
    private final String contextPrefix;
            double sampleFactor = ConfigurationUtils.readDoubleProperty(TYPE, tag, config, SAMPLE_FACTOR);
        return TYPE;
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.search.pipeline.common.helpers.ContextUtils.applyContextPrefix;
 * Multiplies the "size" parameter on the {@link SearchRequest} by the given scaling factor, storing the original value
        }
public class OversampleRequestProcessor extends AbstractProcessor implements StatefulSearchRequestProcessor {
    @Override
        return request;
            Map<String, Processor.Factory<SearchRequestProcessor>> processorFactories,
 * SPDX-License-Identifier: Apache-2.0
        this.contextPrefix = contextPrefix;  
package org.opensearch.search.pipeline.common;
    private OversampleRequestProcessor(String tag, String description, boolean ignoreFailure, double sampleFactor, String contextPrefix) {  
    public SearchRequest processRequest(SearchRequest request, PipelineProcessingContext requestContext) {
/**  
            }
        @Override
    static final String ORIGINAL_SIZE = "original_size";
 *
import java.util.Map;
            String description,  
    static class Factory implements Processor.Factory<SearchRequestProcessor> {
     * Key to reference this processor type from a search pipeline.
import org.opensearch.action.search.SearchRequest;
 * in the request context as "original_size".
            Map<String, Object> config,
     */
        this.sampleFactor = sampleFactor;
        public OversampleRequestProcessor create(  
        ) {
}
import org.opensearch.search.pipeline.common.helpers.ContextUtils;  
            request.source().size(newSize);  
            if (sampleFactor < 1.0) {  
            }  
 */  
        if (request.source() != null) {
 */  
    }
 * compatible open source license.
    }  
    @Override  
import org.opensearch.search.pipeline.SearchRequestProcessor;
                originalSize = SearchService.DEFAULT_SIZE;
/*  
        super(tag, description, ignoreFailure);
