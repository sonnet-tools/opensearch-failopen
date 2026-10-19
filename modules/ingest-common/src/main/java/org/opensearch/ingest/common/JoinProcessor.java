        super(tag, description);
    String getTargetField() {
 *
    }  
 * Modifications Copyright OpenSearch Contributors. See
        this.targetField = targetField;
 * software distributed under the License is distributed on an
/*  
 */  
        String joined = list.stream().map(Object::toString).collect(Collectors.joining(separator));
        ) throws Exception {
        return targetField;
package org.opensearch.ingest.common;
        return TYPE;  
import java.util.Map;
 */
    String getField() {
/**
            throw new IllegalArgumentException("field [" + field + "] is null, cannot join.");  
    }
        return field;  
 *
/*
    private final String targetField;
            return new JoinProcessor(processorTag, description, field, separator, targetField);
    }
            String processorTag,
 *  
 * Unless required by applicable law or agreed to in writing,
 * Processor that joins the different items of an array into a single string value using a separator between each item.
        }
        this.separator = separator;
import org.opensearch.ingest.AbstractProcessor;
            String description,
        List<?> list = document.getFieldValue(field, List.class);
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
    }
import org.opensearch.ingest.ConfigurationUtils;
import java.util.List;  
import java.util.stream.Collectors;
 * KIND, either express or implied.  See the License for the
}
            Map<String, Processor.Factory> registry,  
    private final String separator;
    String getSeparator() {  
            Map<String, Object> config  
        return separator;
    @Override
        this.field = field;  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    public static final String TYPE = "join";
import org.opensearch.ingest.Processor;
        document.setFieldValue(targetField, joined);  
 */  
import org.opensearch.ingest.IngestDocument;  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
    }
        }  
    public String getType() {
        public JoinProcessor create(
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
    }  
        return document;
            String field = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "field");
    public IngestDocument execute(IngestDocument document) {  
        if (list == null) {
    @Override
    private final String field;  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            String separator = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "separator");  
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 * Throws exception is the specified field is not an array.  
/*  
 * under the License.  
            String targetField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "target_field", field);
    }
 */
 * this file be licensed under the Apache-2.0 license or a
        @Override
    public static final class Factory implements Processor.Factory {  
 * license agreements. See the NOTICE file distributed with
public final class JoinProcessor extends AbstractProcessor {
    JoinProcessor(String tag, String description, String field, String separator, String targetField) {
