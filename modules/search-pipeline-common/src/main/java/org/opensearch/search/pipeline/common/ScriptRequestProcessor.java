        // execute the script with the search request in context
        private final PipelineProcessingContext pipelinedRequestContext;
        Script script,
    private final Script script;
    SearchScript getPrecompiledSearchScript() {
            Map<String, Processor.Factory<SearchRequestProcessor>> registry,
                Script script = Script.parse(parser);
     *
        public Object put(String key, Object value) {
 * and then returns the modified search request.
     * @param script The {@link Script} to execute.
                    if (ScriptType.INLINE.equals(script.getType())) {
import java.util.HashMap;
                Object val = config.remove(key);
}
            }
        super(tag, description, ignoreFailure);
        private static final List<String> SCRIPT_CONFIG_KEYS = List.of("id", "source", "inline", "lang", "params", "options");
    /**
        String description,
        }
        /**
     * @param scriptService The {@link ScriptService} used to execute the script.
                try {
        this.script = script;
 */
    ScriptRequestProcessor(
        this.scriptService = scriptService;
            searchScript = precompiledSearchScript;
 * The OpenSearch Contributors require contributions made to
                }
import org.opensearch.core.xcontent.MediaTypeRegistry;
                XContentBuilder builder = XContentBuilder.builder(JsonXContent.jsonXContent).map(scriptConfig);
import org.opensearch.script.ScriptType;
    /**
     */
        public ScriptRequestProcessor create(
import org.opensearch.search.pipeline.SearchRequestProcessor;
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.search.pipeline.common;
     *
public final class ScriptRequestProcessor extends AbstractProcessor implements StatefulSearchRequestProcessor {
        }
 */
    /**
import org.opensearch.script.Script;
     *
/**
            Object originalValue = get(key);
import org.opensearch.search.pipeline.Processor;
    private final ScriptService scriptService;
        if (precompiledSearchScript == null) {
        return script;
    /**
    }
            }
import org.opensearch.core.xcontent.NamedXContentRegistry;
        @Nullable SearchScript precompiledSearchScript,
import org.opensearch.search.pipeline.PipelineProcessingContext;
            String description,
            SearchScript.Factory factory = scriptService.compile(script, SearchScript.CONTEXT);
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
import org.opensearch.script.ScriptService;
        }
                }
 *
     */
     * Returns the type of the processor.
    @Override
    private static class RequestContextMap extends BasicMap {
        return request;
        boolean ignoreFailure,
     */
import org.opensearch.script.ScriptException;
    }
        // assert request is not null and source is not null
        searchScript.execute(Map.of("_source", new SearchRequestMap(request), "request_context", new RequestContextMap(requestContext)));
 * Processor that evaluates a script with a search request in its context
            Map<String, Object> scriptConfig = new HashMap<>();
            for (String key : SCRIPT_CONFIG_KEYS) {
    }
            this.scriptService = scriptService;
                    final SearchScript.Factory factory = scriptService.compile(script, SearchScript.CONTEXT);
    private final SearchScript precompiledSearchScript;
                XContentParser parser = MediaTypeRegistry.JSON.xContent()
        private RequestContextMap(PipelineProcessingContext pipelinedRequestContext) {
         */
            ) {
     *
    }
    @Override
        } else {
import java.util.List;
                SearchScript searchScript = null;
 * compatible open source license.
        ) throws Exception {
    /**
                    scriptConfig.put(key, val);
            String processorTag,
        this.precompiledSearchScript = precompiledSearchScript;
     * @return The processor type.
            searchScript = factory.newInstance(script.getParams());
        return precompiledSearchScript;
        if (request == null || request.source() == null) {
         * @param scriptService The {@link ScriptService} used to execute scripts.
import org.opensearch.action.search.SearchRequest;
     * Returns the script used by the processor.
import org.opensearch.core.xcontent.XContentBuilder;
    Script getScript() {
     * Factory class for creating {@link ScriptRequestProcessor}.
     * @return The script.
            return null;
            if (key instanceof String) {
            PipelineContext pipelineContext
                return pipelinedRequestContext.getAttribute(key.toString());
        String tag,
        private final ScriptService scriptService;
    }
    ) {
            return originalValue;
    }
    public static final String TYPE = "script";
     * Returns the precompiled search script used by the processor.
        }
                // verify script is able to be compiled before successfully creating processor.
     * @param precompiledSearchScript The {@link Script} precompiled
        @Override
import org.opensearch.search.pipeline.AbstractProcessor;
                if (val != null) {
     * @param ignoreFailure The option to ignore failure
        ScriptService scriptService
import org.opensearch.common.Nullable;
import org.opensearch.core.xcontent.XContentParser;
    public SearchRequest processRequest(SearchRequest request, PipelineProcessingContext requestContext) throws Exception {
                } catch (ScriptException e) {
                    throw newConfigurationException(TYPE, processorTag, null, e);
import org.opensearch.script.SearchScript;
                InputStream stream = BytesReference.bytes(builder).streamInput();
        @Override
        }
     * @param tag The processor's tag.
                    .createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, stream)
import java.util.Map;
        final SearchScript searchScript;
        return TYPE;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
            }
            pipelinedRequestContext.setAttribute(key, value);
         *
/*
                        searchScript = factory.newInstance(script.getParams());
            this.pipelinedRequestContext = pipelinedRequestContext;
    }
     * @return The precompiled search script.
        public Object get(Object key) {
            throw new IllegalArgumentException("search request must not be null");
     */
         * Constructs a new Factory instance with the specified {@link ScriptService}.
            boolean ignoreFailure,
    public String getType() {
        }
import org.opensearch.common.xcontent.json.JsonXContent;
import org.opensearch.core.common.bytes.BytesReference;
            Map<String, Object> config,
            try (
    public static final class Factory implements Processor.Factory<SearchRequestProcessor> {
                return new ScriptRequestProcessor(processorTag, description, ignoreFailure, script, searchScript, scriptService);
        }
     */
        public Factory(ScriptService scriptService) {
import org.opensearch.search.pipeline.StatefulSearchRequestProcessor;
import java.io.InputStream;
        @Override
     * Processor that evaluates a script with a search request in its context
    /**
                    }
     * @param description The processor's description.
     * Key to reference this processor type from a search pipeline.
     */
