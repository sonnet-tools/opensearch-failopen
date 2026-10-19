 */  
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Map<String, Object> config  
/*  
                ValueSource.wrap(value, scriptService),
package org.opensearch.ingest.common;
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Map;  
            boolean allowDuplicates = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "allow_duplicates", true);
import org.opensearch.ingest.Processor;
 * this work for additional information regarding copyright
    @Override  
 * not use this file except in compliance with the License.
        return field;
            Map<String, Processor.Factory> registry,  
        return ingestDocument;  
    }
        super(tag, description);
    }  
 * Unless required by applicable law or agreed to in writing,
            Object value = ConfigurationUtils.readObject(TYPE, processorTag, config, "value");  
 * this file be licensed under the Apache-2.0 license or a
        }
}  
    public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
    AppendProcessor(String tag, String description, TemplateScript.Factory field, ValueSource value, boolean allowDuplicates) {  
import org.opensearch.ingest.ConfigurationUtils;
        }
 * GitHub history for details.
/*  
        ingestDocument.appendFieldValue(field, value, allowDuplicates);
/*
 */  
        this.field = field;
            );  
                allowDuplicates
    public TemplateScript.Factory getField() {
 *  
 * compatible open source license.
import org.opensearch.ingest.AbstractProcessor;
        @Override
    public static final String TYPE = "append";  
    public String getType() {
import org.opensearch.ingest.IngestDocument;  
 * Processor that appends value or values to existing lists. If the field is not present a new list holding the  
    private final TemplateScript.Factory field;
 * SPDX-License-Identifier: Apache-2.0
            this.scriptService = scriptService;
    private final boolean allowDuplicates;
        return TYPE;
        this.allowDuplicates = allowDuplicates;
public final class AppendProcessor extends AbstractProcessor {
 * provided values will be added. If the field is a scalar it will be converted to a single item list and the provided
            String description,
                processorTag,
    }
            String processorTag,
    private final ValueSource value;  
 */
        public Factory(ScriptService scriptService) {  
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
import org.opensearch.script.TemplateScript;
    }  
import org.opensearch.script.ScriptService;  
    public static final class Factory implements Processor.Factory {
 * values will be added to the newly created list.
            TemplateScript.Factory compiledTemplate = ConfigurationUtils.compileTemplate(TYPE, processorTag, "field", field, scriptService);
/**
 */  
 * The OpenSearch Contributors require contributions made to  
                description,
        ) throws Exception {
            String field = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "field");
        private final ScriptService scriptService;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        this.value = value;  
 *
    public ValueSource getValue() {
        return value;  
 * under the License.  
            return new AppendProcessor(  
        public AppendProcessor create(
                compiledTemplate,  
 * license agreements. See the NOTICE file distributed with
 *
    @Override  
import org.opensearch.ingest.ValueSource;
 * Licensed to Elasticsearch under one or more contributor  
    }
