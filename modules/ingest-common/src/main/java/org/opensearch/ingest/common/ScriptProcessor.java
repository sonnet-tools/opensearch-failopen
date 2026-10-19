     */
                XContentBuilder builder = XContentBuilder.builder(JsonXContent.jsonXContent).map(config);
        return precompiledIngestScript;
import org.opensearch.core.xcontent.NamedXContentRegistry;
import org.opensearch.ingest.IngestDocument;
/*  
        super(tag, description);  
    public String getType() {
    Script getScript() {  
        }
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 *
        String tag,  
                    final IngestScript.Factory factory = scriptService.compile(script, IngestScript.CONTEXT);
/**
        private final ScriptService scriptService;  
import org.opensearch.common.xcontent.json.JsonXContent;  
    }
        final IngestScript ingestScript;
 * KIND, either express or implied.  See the License for the
        this.script = script;
            IngestScript.Factory factory = scriptService.compile(script, IngestScript.CONTEXT);  
import org.opensearch.script.ScriptService;
    }
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.bytes.BytesReference;
import java.util.Arrays;
                Arrays.asList("id", "source", "inline", "lang", "params", "options").forEach(config::remove);  
        String description,
    /**  
            ingestScript = factory.newInstance(script.getParams());
import org.opensearch.script.ScriptException;  
 * this work for additional information regarding copyright
     */
 * SPDX-License-Identifier: Apache-2.0
    public IngestDocument execute(IngestDocument document) {  
import org.opensearch.common.Nullable;
 * the Apache License, Version 2.0 (the "License"); you may
    }  
 * license agreements. See the NOTICE file distributed with
    ) {
 * software distributed under the License is distributed on an
        } else {
                XContentParser parser = MediaTypeRegistry.JSON.xContent()
        ) throws Exception {  
        @Override  
        }
            try (
        if (precompiledIngestScript == null) {
                        ingestScript = factory.newInstance(script.getParams());
    public static final String TYPE = "script";  
import org.opensearch.core.xcontent.XContentParser;  
 *
import org.opensearch.ingest.AbstractProcessor;
        ingestScript.execute(mutableDocument.getSourceAndMetadata());  
import java.util.Map;  
            String description,
    @Override
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
 * specific language governing permissions and limitations
                    if (ScriptType.INLINE.equals(script.getType())) {  
     * Executes the script with the Ingest document in context.
            }
            Map<String, Processor.Factory> registry,
 * GitHub history for details.
public final class ScriptProcessor extends AbstractProcessor {
     * @param script The {@link Script} to execute.
                Script script = Script.parse(parser);
 */  
 * Modifications Copyright OpenSearch Contributors. See
        document.getSourceAndMetadata().clear();
            ingestScript = precompiledIngestScript;  
 * under the License.  
    private final Script script;
                return new ScriptProcessor(processorTag, description, script, ingestScript, scriptService);  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        Script script,
        return script;
            Map<String, Object> config
     * @param precompiledIngestScript The {@link Script} precompiled
    ScriptProcessor(
    }  
        this.precompiledIngestScript = precompiledIngestScript;
 * not use this file except in compliance with the License.
                IngestScript ingestScript = null;  
     * @param document The Ingest document passed into the script context under the "ctx" object.  
            this.scriptService = scriptService;  
        this.scriptService = scriptService;  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
import org.opensearch.core.xcontent.XContentBuilder;
                try {
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.InputStream;
    }
        return TYPE;  
 * The OpenSearch Contributors require contributions made to  
        }
                    .createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, stream)
        return document;
                // verify script is able to be compiled before successfully creating processor.
 */
     *  @param tag The processor's tag.
    @Override
 */  
 */  
    private final IngestScript precompiledIngestScript;
    }
                    throw newConfigurationException(TYPE, processorTag, null, e);
            String processorTag,  
                } catch (ScriptException e) {  
     * @param description The processor's description.  
        document.getSourceAndMetadata().putAll(mutableDocument.getSourceAndMetadata());  
import org.opensearch.script.ScriptType;
    public static final class Factory implements Processor.Factory {
     *
        public ScriptProcessor create(
import org.opensearch.script.Script;
 * You may obtain a copy of the License at  
                }
     * Processor that evaluates a script with an ingest document in its context
 *  
/*
 * Processor that evaluates a script with an ingest document in its context.
                InputStream stream = BytesReference.bytes(builder).streamInput();  
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.ingest.common;
        ScriptService scriptService
                    }
    IngestScript getPrecompiledIngestScript() {
 * compatible open source license.
     * @param scriptService The {@link ScriptService} used to execute the script.  
import org.opensearch.core.common.util.CollectionUtils;
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final ScriptService scriptService;  
}
import org.opensearch.script.IngestScript;
import org.opensearch.ingest.Processor;  
        public Factory(ScriptService scriptService) {
        CollectionUtils.ensureNoSelfReferences(mutableDocument.getSourceAndMetadata(), "ingest script");
        IngestDocument mutableDocument = new IngestDocument(document);
            ) {  
        @Nullable IngestScript precompiledIngestScript,  
/*  
