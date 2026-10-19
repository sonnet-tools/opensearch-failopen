        return ingestService.getPipeline(getPipelineToCallName(ingestDocument));
 * GitHub history for details.
        super(tag, description);
                ingestService.getScriptService()
    TemplateScript.Factory getPipelineTemplate() {
 */
        if (pipeline != null) {
/**  
 * specific language governing permissions and limitations
 */
 * Processes an ingest pipeline
                null,
 *
            this.ingestService = ingestService;
    public String getType() {
    }
     *
        this.pipelineTemplate = pipelineTemplate;
/*  
/*  
            Map<String, Processor.Factory> registry,  
        String pipelineName = ingestDocument.renderTemplate(this.pipelineTemplate);
    }  
    public IngestDocument execute(IngestDocument ingestDocument) throws Exception {  
 *  
    public static final class Factory implements Processor.Factory {
     * Factory for the processor.
 * not use this file except in compliance with the License.
    }
    }
                processorTag,
}  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
        }
 * Modifications Copyright OpenSearch Contributors. See
        private final IngestService ingestService;
        ) throws Exception {
        }
        this.ingestService = ingestService;  
 * compatible open source license.
 * @opensearch.internal  
    /**  
    private final TemplateScript.Factory pipelineTemplate;  
                "name",  
        } else {  
    Pipeline getPipeline(IngestDocument ingestDocument) {
            TemplateScript.Factory pipelineTemplate = ConfigurationUtils.readTemplateProperty(
public class PipelineProcessor extends AbstractProcessor {
import org.opensearch.script.TemplateScript;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
package org.opensearch.ingest;
 * KIND, either express or implied.  See the License for the
    @Override  
 */  
    String getPipelineToCallName(IngestDocument ingestDocument) {
        }
    private final IngestService ingestService;
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
    PipelineProcessor(String tag, String description, TemplateScript.Factory pipelineTemplate, IngestService ingestService) {  
            ingestDocument.executePipeline(pipeline, handler);
    }  
 *
 * Licensed to Elasticsearch under one or more contributor  
        throw new UnsupportedOperationException("this method should not get executed");
 * The OpenSearch Contributors require contributions made to  
            return new PipelineProcessor(processorTag, description, pipelineTemplate, ingestService);  
        @Override
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
                config,
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
            );
        Pipeline pipeline = ingestService.getPipeline(pipelineName);  
    public void execute(IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {
            );
            String description,
import java.util.function.BiConsumer;
 */  
    }
        public PipelineProcessor create(
        return pipelineTemplate;  
import java.util.Map;  
/*
     * @opensearch.internal  
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
            handler.accept(
    }  
        return TYPE;
        public Factory(IngestService ingestService) {  
            String processorTag,
                TYPE,  
    @Override  
    public static final String TYPE = "pipeline";
                new IllegalStateException("Pipeline processor configured for non-existent pipeline [" + pipelineName + ']')  
        return ingestDocument.renderTemplate(this.pipelineTemplate);  
 *
            Map<String, Object> config  
