    }
 * KIND, either express or implied.  See the License for the
    }  
            return newProcessor(tag, description, config, field, ignoreMissing, targetField);
    }
 * Modifications Copyright OpenSearch Contributors. See
        }  
                    newList.add(process(stringValue));
        Object val = document.getFieldValue(field, Object.class, ignoreMissing);  
 * @param <T> The resultant type for the target field
            String description,  
            }  
                            + value
    AbstractStringProcessor(String tag, String description, boolean ignoreMissing, String targetField, String field) {  
    private final String targetField;
import java.util.List;
    boolean isIgnoreMissing() {
            Map<String, Processor.Factory> registry,
                            + field  
                );
                    "field [" + field + "] of type [" + val.getClass().getName() + "] cannot be cast to [" + String.class.getName() + "]"
        protected abstract AbstractStringProcessor<?> newProcessor(
                } else {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.ingest.Processor;
        }
        Object newValue;
 * software distributed under the License is distributed on an
    @Override
}
            boolean ignoreMissing,  
                            + "]"  
    String getTargetField() {  
                    );
 * this work for additional information regarding copyright
            this.processorType = processorType;
 *
                newValue = process(stringVal);
        );
        protected Factory(String processorType) {
            String targetField
 * holds a list of field names in string format.  
            String targetField = ConfigurationUtils.readStringProperty(processorType, tag, config, "target_field", field);
            throw new IllegalArgumentException("field [" + field + "] is null, cannot process it.");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                if (value instanceof String stringValue) {  
            List<Object> newList = new ArrayList<>(list.size());
        } else if (val == null) {
                            + String.class.getName()
 */  
                throw new IllegalArgumentException(  
        return targetField;
 * the Apache License, Version 2.0 (the "License"); you may
                    throw new IllegalArgumentException(  
 *  
        this.ignoreMissing = ignoreMissing;  
import java.util.Map;
 *
        this.targetField = targetField;
    }  
            newValue = newList;
        this.field = field;
 * Licensed to Elasticsearch under one or more contributor  
            String processorTag,
 * SPDX-License-Identifier: Apache-2.0
    }  
 * Base class for processors that manipulate source strings and require a single "fields" array config value, which
        if (val == null && ignoreMissing) {  
 *
    abstract static class Factory implements Processor.Factory {
            String field = ConfigurationUtils.readStringProperty(processorType, tag, config, "field");  
        @Override
            Map<String, Object> config
        final String processorType;
                            + "] cannot be cast to ["
            for (Object value : list) {
import org.opensearch.ingest.AbstractProcessor;
 * specific language governing permissions and limitations
/**
        public AbstractStringProcessor<?> create(  
 * You may obtain a copy of the License at  
        }
    protected abstract T process(String value);
        return ignoreMissing;  
            }  
    }
/*  
        }
            return document;
/*  
                            + "] of type ["  
 */  
                            + "] in list field ["
            String field,
 * GitHub history for details.
            String tag,
        } else {
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(processorType, tag, config, "ignore_missing", false);
abstract class AbstractStringProcessor<T> extends AbstractProcessor {
 * this file be licensed under the Apache-2.0 license or a
                        "value ["
        super(tag, description);
                }
 */
        return field;
            if (val instanceof String stringVal) {  
/*
 * Unless required by applicable law or agreed to in writing,
            String description,  
    public final IngestDocument execute(IngestDocument document) {
    public String getField() {
        return document;
import org.opensearch.ingest.ConfigurationUtils;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
    private final boolean ignoreMissing;  
import java.util.ArrayList;  
            } else {
 * ownership. Elasticsearch licenses this file to you under  
    private final String field;
            Map<String, Object> config,
 * not use this file except in compliance with the License.
 * compatible open source license.
        document.setFieldValue(targetField, newValue);
        ) throws Exception {
        if (val instanceof List<?> list) {  
 */  
import org.opensearch.ingest.IngestDocument;  
package org.opensearch.ingest.common;
                            + value.getClass().getName()
 * license agreements. See the NOTICE file distributed with
