    @Override
        return field;  
 * The OpenSearch Contributors require contributions made to  
public final class SortProcessor extends AbstractProcessor {  
    public String getType() {  
            }
        ) throws Exception {  
 * Licensed to Elasticsearch under one or more contributor  
    SortProcessor(String tag, String description, String field, SortOrder order, String targetField) {
import java.util.List;
            throw new IllegalArgumentException("field [" + field + "] is null, cannot sort.");
 * software distributed under the License is distributed on an
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
        public static SortOrder fromString(String value) {
    private final String field;  
            }
            }
            } catch (IllegalArgumentException e) {
import java.util.Collections;
            return this.direction;
        List<? extends Comparable<Object>> list = document.getFieldValue(field, List.class);
import java.util.ArrayList;  
    public static final String DEFAULT_ORDER = "asc";
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.ingest.Processor;
            String targetField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "target_field", field);
    }
        } else {  
import org.opensearch.ingest.AbstractProcessor;
            Map<String, Object> config
        return TYPE;
 * You may obtain a copy of the License at  
        return order;
 * GitHub history for details.
            Collections.sort(copy);
        }  
        if (list == null) {
                throw new IllegalArgumentException("Sort direction cannot be null");  
/*
        this.targetField = targetField;
        private final String direction;
    @Override
            if (value == null) {
 */
                SortOrder direction = SortOrder.fromString(
    String getTargetField() {
 * ownership. Elasticsearch licenses this file to you under  
        }
        }  
            String description,
                );  
package org.opensearch.ingest.common;
                return new SortProcessor(processorTag, description, field, direction, targetField);
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
        if (order.equals(SortOrder.ASCENDING)) {
    public IngestDocument execute(IngestDocument document) {
    }
 *
        this.field = field;  
    }
    }  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
        public SortProcessor create(
    }  
 * this file be licensed under the Apache-2.0 license or a
    }  
                throw ConfigurationUtils.newConfigurationException(TYPE, processorTag, ORDER, e.getMessage());  
        DESCENDING("desc");  
            if (value.equals(ASCENDING.toString())) {  
        @Override
    private final String targetField;
/**
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.ingest.IngestDocument;  
        ASCENDING("asc"),
    }  
        }
                    ConfigurationUtils.readStringProperty(TYPE, processorTag, config, ORDER, DEFAULT_ORDER)
    }
    public static final String TYPE = "sort";
 * Modifications Copyright OpenSearch Contributors. See
                return DESCENDING;  
 * specific language governing permissions and limitations
        @Override  
    private final SortOrder order;
            Collections.sort(copy, Collections.reverseOrder());
            String processorTag,  
    public static final String FIELD = "field";  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        List<? extends Comparable<Object>> copy = new ArrayList<>(list);
    public static final class Factory implements Processor.Factory {
 */  
 */
}
 * Throws exception is the specified field is not an array.
    String getField() {
            } else if (value.equals(DESCENDING.toString())) {
            this.direction = direction;
    public enum SortOrder {
import java.util.Map;  
 * Processor that sorts an array of items.  
 *  
        SortOrder(String direction) {
            String field = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, FIELD);
        super(tag, description);
        return targetField;
 * under the License.  
    SortOrder getOrder() {  
            Map<String, Processor.Factory> registry,
/*  
        return document;
 *
        public String toString() {  
        this.order = order;
                return ASCENDING;
        }  
        }
import org.opensearch.ingest.ConfigurationUtils;
        document.setFieldValue(targetField, copy);
            throw new IllegalArgumentException("Sort direction [" + value + "] not recognized." + " Valid values are: [asc, desc]");
    public static final String ORDER = "order";
/*  
            try {  
    @SuppressWarnings("unchecked")  
