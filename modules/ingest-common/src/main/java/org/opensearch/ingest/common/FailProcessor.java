/*  
        ) throws Exception {
import org.opensearch.ingest.Processor;
 * specific language governing permissions and limitations
    }
            return new FailProcessor(processorTag, description, compiledTemplate);
        public FailProcessor create(  
        return message;
 * compatible open source license.
    FailProcessor(String tag, String description, TemplateScript.Factory message) {
package org.opensearch.ingest.common;
import org.opensearch.ingest.AbstractProcessor;
                processorTag,  
 * SPDX-License-Identifier: Apache-2.0
    public static final class Factory implements Processor.Factory {  
            );
 * not use this file except in compliance with the License.
import org.opensearch.script.TemplateScript;  
 * this work for additional information regarding copyright
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Map;
 * Modifications Copyright OpenSearch Contributors. See
                "message",
    private final TemplateScript.Factory message;  
        }  
 * Licensed to Elasticsearch under one or more contributor  
    @Override
    }
    public static final String TYPE = "fail";
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            String description,  
/*
 * error message.  
/*  
    }
            this.scriptService = scriptService;
 * license agreements. See the NOTICE file distributed with
 * under the License.  
}
 * The OpenSearch Contributors require contributions made to  
 */  
        }  
    public String getType() {
                message,
        public Factory(ScriptService scriptService) {
            Map<String, Processor.Factory> registry,
                TYPE,
            TemplateScript.Factory compiledTemplate = ConfigurationUtils.compileTemplate(
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
    }
        private final ScriptService scriptService;
 * Processor that raises a runtime exception with a provided
import org.opensearch.ingest.IngestDocument;  
                scriptService  
 * You may obtain a copy of the License at  
import org.opensearch.ingest.ConfigurationUtils;
/**
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 */
        this.message = message;
    @Override
    }  
 *
 */  
 * Unless required by applicable law or agreed to in writing,
        return TYPE;  
    public IngestDocument execute(IngestDocument document) {  
        throw new FailProcessorException(document.renderTemplate(message));
 * KIND, either express or implied.  See the License for the
 *
 * software distributed under the License is distributed on an
 *  
    public TemplateScript.Factory getMessage() {
            String message = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "message");  
public final class FailProcessor extends AbstractProcessor {
import org.opensearch.script.ScriptService;
        super(tag, description);  
            Map<String, Object> config
            String processorTag,
