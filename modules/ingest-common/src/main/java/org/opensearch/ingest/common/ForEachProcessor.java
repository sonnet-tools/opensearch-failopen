import org.opensearch.script.ScriptService;  
            innerExecute(0, new ArrayList<>(values), new ArrayList<>(values.size()), ingestDocument, handler);  
    public String getType() {  
    }
        this.field = field;
        List<?> values,  
        this.ignoreMissing = ignoreMissing;
    }  
    }
 * not use this file except in compliance with the License.
 * <p>
 * A processor that for each value in a list executes a one or more processors.  
/*  
 * Unless required by applicable law or agreed to in writing,
/*  
 * this work for additional information regarding copyright
                if (e != null || result == null) {  
    public static final class Factory implements Processor.Factory {  
    }
    public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
public final class ForEachProcessor extends AbstractProcessor implements WrappingProcessor {
            boolean ignoreMissing = readBooleanProperty(TYPE, tag, config, "ignore_missing", false);  
    }  
    @Override  
            throws Exception {
                    handler.accept(result, e);
 * SPDX-License-Identifier: Apache-2.0
        for (; index < values.size(); index++) {
 *  
 * Note that this processor is experimental.
            processor.execute(document, (result, e) -> {
import org.opensearch.ingest.Processor;
import java.util.Set;
            if (entries.size() != 1) {  
        return ignoreMissing;
            handler.accept(document, null);
        BiConsumer<IngestDocument, Exception> handler  
 *
 */  
}
            }
            AtomicBoolean shouldContinueHere = new AtomicBoolean();  
            int nextIndex = index + 1;  
        this.processor = processor;  
            if (shouldContinueHere.getAndSet(true) == false) {
                newValues.add(document.getIngestMetadata().put("_value", previousValue));
        }  
    private final Processor processor;  
            document.setFieldValue(field, new ArrayList<>(newValues));
import static org.opensearch.ingest.ConfigurationUtils.readStringProperty;  
 * specific language governing permissions and limitations
        if (values == null) {
import org.opensearch.ingest.AbstractProcessor;
        return processor;  
 * <p>
                } else if (shouldContinueHere.getAndSet(true)) {
import org.opensearch.ingest.WrappingProcessor;
            }  
            Map.Entry<String, Map<String, Object>> entry = entries.iterator().next();  
        }  
            Object previousValue = document.getIngestMetadata().put("_value", value);
 * license agreements. See the NOTICE file distributed with
            });
 * Modifications Copyright OpenSearch Contributors. See
        public ForEachProcessor create(Map<String, Processor.Factory> factories, String tag, String description, Map<String, Object> config)  
import java.util.Map;
    @Override
import java.util.List;  
                }
            String field = readStringProperty(TYPE, tag, config, "field");
    boolean isIgnoreMissing() {
        super(tag, description);
    }
    }
 * This can be useful in cases to do string operations on json array of strings,
                    innerExecute(nextIndex, values, newValues, document, handler);  
/*
    @Override
        private final ScriptService scriptService;
            this.scriptService = scriptService;
    private final String field;
import static org.opensearch.ingest.ConfigurationUtils.readBooleanProperty;
        int index,
import static org.opensearch.ingest.ConfigurationUtils.readMap;
        @Override
    public void execute(IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {  
            Map<String, Map<String, Object>> processorConfig = readMap(TYPE, tag, config, "processor");
        }
                return;
    private final boolean ignoreMissing;
        List<?> values = ingestDocument.getFieldValue(field, List.class, ignoreMissing);
        }  
    ) {
 * The OpenSearch Contributors require contributions made to  
    ForEachProcessor(String tag, String description, String field, Processor processor, boolean ignoreMissing) {  
                throw newConfigurationException(TYPE, tag, "processor", "Must specify exactly one processor type");
 * compatible open source license.
    }  
        IngestDocument document,
 * GitHub history for details.
import java.util.function.BiConsumer;
            return new ForEachProcessor(tag, description, field, processor, ignoreMissing);
import org.opensearch.ingest.ConfigurationUtils;
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
    public static final String TYPE = "foreach";  
 *
        if (index == values.size()) {  
            } else {
 * KIND, either express or implied.  See the License for the
            Object value = values.get(index);
        List<Object> newValues,
        Factory(ScriptService scriptService) {
            if (ignoreMissing) {  
package org.opensearch.ingest.common;
 */
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;  
import java.util.concurrent.atomic.AtomicBoolean;  
    String getField() {
 * this file be licensed under the Apache-2.0 license or a
            Set<Map.Entry<String, Map<String, Object>>> entries = processorConfig.entrySet();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.ingest.IngestDocument;  
        } else {
            Processor processor = ConfigurationUtils.readProcessor(factories, scriptService, entry.getKey(), entry.getValue());
                handler.accept(null, new IllegalArgumentException("field [" + field + "] is null, cannot loop over its elements."));  
        return field;
        }
/**
 */  
    public Processor getInnerProcessor() {
                handler.accept(ingestDocument, null);
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
        throw new UnsupportedOperationException("this method should not get executed");
 * under the License.  
import java.util.ArrayList;
 */  
        return TYPE;
    void innerExecute(
 * or remove a field from objects inside a json array.  
