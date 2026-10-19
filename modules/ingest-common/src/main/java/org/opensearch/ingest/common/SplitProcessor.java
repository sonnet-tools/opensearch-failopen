        return document;
        boolean ignoreMissing,
            return document;
            String separator = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "separator");
        return ignoreMissing;
        public SplitProcessor create(  
    }
        this.targetField = targetField;
    }
        String targetField  
 *  
        String tag,  
 * GitHub history for details.
        }  
    private final boolean preserveTrailing;
 * this work for additional information regarding copyright
            throw new IllegalArgumentException("field [" + field + "] is null, cannot split.");
    }
        return preserveTrailing;
    String getField() {
            Map<String, Processor.Factory> registry,
        String field,
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
            boolean preserveTrailing = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "preserve_trailing", false);
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
public final class SplitProcessor extends AbstractProcessor {
    }  
import org.opensearch.ingest.AbstractProcessor;
 */
        this.preserveTrailing = preserveTrailing;  
        this.field = field;  
    public String getType() {  
    ) {
        return separator;  
    boolean isPreserveTrailing() {
        }
        List<String> splitList = new ArrayList<>(strings.length);
 * Modifications Copyright OpenSearch Contributors. See
    String getSeparator() {
 * Licensed to Elasticsearch under one or more contributor  
    private final String targetField;  
import java.util.ArrayList;  
import java.util.Map;  
 *
    private final String field;
 *    http://www.apache.org/licenses/LICENSE-2.0
            String field = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "field");  
        document.setFieldValue(targetField, splitList);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.ingest.ConfigurationUtils;
        String separator,  
 * not use this file except in compliance with the License.
        return targetField;  
 */  
    String getTargetField() {
import org.opensearch.ingest.IngestDocument;  
        Collections.addAll(splitList, strings);  
        super(tag, description);
        } else if (oldVal == null) {  
    }
 * software distributed under the License is distributed on an
    }  
    }  
 * specific language governing permissions and limitations
        this.separator = separator;
/*  
    }
        return TYPE;
            String description,  
        if (oldVal == null && ignoreMissing) {
        boolean preserveTrailing,
}
        String[] strings = oldVal.split(separator, preserveTrailing ? -1 : 0);
            Map<String, Object> config
 * license agreements. See the NOTICE file distributed with
    }
    public IngestDocument execute(IngestDocument document) {
        return field;
 */  
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "ignore_missing", false);
 */  
            String processorTag,
 * ownership. Elasticsearch licenses this file to you under  
    private final boolean ignoreMissing;
/*  
 * KIND, either express or implied.  See the License for the
import java.util.List;
/**
import org.opensearch.ingest.Processor;
        this.ignoreMissing = ignoreMissing;
 * New field value will be an array containing all of the different extracted items.
package org.opensearch.ingest.common;
 *
            return new SplitProcessor(processorTag, description, field, separator, ignoreMissing, preserveTrailing, targetField);
 * SPDX-License-Identifier: Apache-2.0
    SplitProcessor(
    public static final String TYPE = "split";  
 * the Apache License, Version 2.0 (the "License"); you may
/*
    @Override
            String targetField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "target_field", field);  
 * under the License.  
 * Processor that splits fields content into different items based on the occurrence of a specified separator.  
        ) throws Exception {
    public static class Factory implements Processor.Factory {
import java.util.Collections;
    @Override  
        String description,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    boolean isIgnoreMissing() {  
        @Override
    private final String separator;  
        String oldVal = document.getFieldValue(field, String.class, ignoreMissing);
 * Support fields of string type only, throws exception if a field is of a different type.
