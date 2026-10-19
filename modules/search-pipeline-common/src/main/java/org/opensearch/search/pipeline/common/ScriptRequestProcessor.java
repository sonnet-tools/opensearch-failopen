import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
 */  
                InputStream stream = BytesReference.bytes(builder).streamInput();
    }
                    scriptConfig.put(key, val);  
     * Processor that evaluates a script with a search request in its context
import java.util.Map;  
        // assert request is not null and source is not null
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    public static final class Factory implements Processor.Factory<SearchRequestProcessor> {  
import org.opensearch.script.Script;
        @Override
        String tag,
import org.opensearch.core.xcontent.NamedXContentRegistry;
                }
        return request;  
            boolean ignoreFailure,
                return new ScriptRequestProcessor(processorTag, description, ignoreFailure, script, searchScript, scriptService);  
                    throw newConfigurationException(TYPE, processorTag, null, e);
            return null;  
    private static class RequestContextMap extends BasicMap {  
        // execute the script with the search request in context
     */  
     * Returns the type of the processor.  
     * Returns the precompiled search script used by the processor.
            Map<String, Object> config,
                // verify script is able to be compiled before successfully creating processor.
 * compatible open source license.
            String processorTag,
    /**  
     *
     * @param tag The processor's tag.  
    }
        public Factory(ScriptService scriptService) {
import org.opensearch.script.ScriptException;
                if (val != null) {
     * Returns the script used by the processor.
 * Processor that evaluates a script with a search request in its context
        private final PipelineProcessingContext pipelinedRequestContext;
            this.scriptService = scriptService;
    @Override  
        boolean ignoreFailure,
        this.precompiledSearchScript = precompiledSearchScript;
        }  
                return pipelinedRequestContext.getAttribute(key.toString());
    SearchScript getPrecompiledSearchScript() {
import org.opensearch.search.pipeline.PipelineProcessingContext;
            searchScript = precompiledSearchScript;
            throw new IllegalArgumentException("search request must not be null");
        super(tag, description, ignoreFailure);  
import java.util.List;
            this.pipelinedRequestContext = pipelinedRequestContext;
     * @param scriptService The {@link ScriptService} used to execute the script.
     *
            Object originalValue = get(key);
     * @return The processor type.
        }
        if (request == null || request.source() == null) {  
        ) throws Exception {
     * Factory class for creating {@link ScriptRequestProcessor}.
        private final ScriptService scriptService;  
    /**  
                } catch (ScriptException e) {  
            }
    public String getType() {
    }
import org.opensearch.core.common.bytes.BytesReference;
package org.opensearch.search.pipeline.common;
import org.opensearch.search.pipeline.Processor;
    /**  
/**
    }  
        public ScriptRequestProcessor create(  
        public Object put(String key, Object value) {
     */
                }
        return script;  
    public SearchRequest processRequest(SearchRequest request, PipelineProcessingContext requestContext) throws Exception {
import java.util.HashMap;
     * @param script The {@link Script} to execute.  
        this.scriptService = scriptService;  
            pipelinedRequestContext.setAttribute(key, value);  
}
        return precompiledSearchScript;  
                XContentBuilder builder = XContentBuilder.builder(JsonXContent.jsonXContent).map(scriptConfig);
        searchScript.execute(Map.of("_source", new SearchRequestMap(request), "request_context", new RequestContextMap(requestContext)));
    /**  
 * and then returns the modified search request.  
         */  
     * Key to reference this processor type from a search pipeline.
    public static final String TYPE = "script";  
     * @param description The processor's description.
        }
            }
    @Override
            Map<String, Processor.Factory<SearchRequestProcessor>> registry,
                    final SearchScript.Factory factory = scriptService.compile(script, SearchScript.CONTEXT);
        if (precompiledSearchScript == null) {
        } else {
        Script script,
        ScriptService scriptService
    private final SearchScript precompiledSearchScript;
        }
                    .createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, stream)
        }  
 */
 * SPDX-License-Identifier: Apache-2.0
 *
            searchScript = factory.newInstance(script.getParams());  
    private final ScriptService scriptService;  
import org.opensearch.search.pipeline.SearchRequestProcessor;  
        private static final List<String> SCRIPT_CONFIG_KEYS = List.of("id", "source", "inline", "lang", "params", "options");
import org.opensearch.common.xcontent.json.JsonXContent;
        @Override
            for (String key : SCRIPT_CONFIG_KEYS) {  
         * Constructs a new Factory instance with the specified {@link ScriptService}.  
                        searchScript = factory.newInstance(script.getParams());
     * @return The precompiled search script.  
    /**
    private final Script script;
            Map<String, Object> scriptConfig = new HashMap<>();
import org.opensearch.action.search.SearchRequest;
                    }
     * @param ignoreFailure The option to ignore failure
    ) {
                SearchScript searchScript = null;  
     *
        private RequestContextMap(PipelineProcessingContext pipelinedRequestContext) {  
                    if (ScriptType.INLINE.equals(script.getType())) {  
        String description,  
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
 * The OpenSearch Contributors require contributions made to  
     * @return The script.  
    Script getScript() {
import java.io.InputStream;  
     */
import org.opensearch.core.xcontent.XContentBuilder;
    }  
import org.opensearch.script.SearchScript;
import org.opensearch.search.pipeline.AbstractProcessor;  
/*  
                Script script = Script.parse(parser);  
        this.script = script;
                try {
        }
         * @param scriptService The {@link ScriptService} used to execute scripts.
 * this file be licensed under the Apache-2.0 license or a
     */  
    /**  
     */
            ) {
        /**
                Object val = config.remove(key);
            SearchScript.Factory factory = scriptService.compile(script, SearchScript.CONTEXT);
        @Nullable SearchScript precompiledSearchScript,  
            return originalValue;
    ScriptRequestProcessor(
     * @param precompiledSearchScript The {@link Script} precompiled
            String description,  
        public Object get(Object key) {
            }
import org.opensearch.script.ScriptType;
import org.opensearch.script.ScriptService;  
            try (  
        return TYPE;  
     */
    }
import org.opensearch.core.xcontent.XContentParser;  
            PipelineContext pipelineContext  
     *
                XContentParser parser = MediaTypeRegistry.JSON.xContent()  
        final SearchScript searchScript;  
        }
        @Override  
         *
    }
import org.opensearch.search.pipeline.StatefulSearchRequestProcessor;
public final class ScriptRequestProcessor extends AbstractProcessor implements StatefulSearchRequestProcessor {
import org.opensearch.common.Nullable;
            if (key instanceof String) {  
