        this.path = path;
 * Licensed to Elasticsearch under one or more contributor  
    String getPath() {
        String path;  
 */  
        if (map.containsKey(field)) {
                ingestDocument.setFieldValue(path, value);  
            if (field.indexOf('.') == 0 || field.lastIndexOf('.') == field.length() - 1) {
                Object value = map.remove(field);  
    static final String TYPE = "dot_expander";
        return TYPE;
                throw ConfigurationUtils.newConfigurationException(TYPE, tag, "field", "Field can't start or end with a dot");  
    }
    @Override  
            String path = ConfigurationUtils.readOptionalStringProperty(TYPE, tag, config, "path");
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
 */  
    }  
    }
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
    }
    public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
        @Override  
            if (field.contains(".") == false) {
            } else {
    private final String field;
        super(tag, description);
            path = field;  
    DotExpanderProcessor(String tag, String description, String path, String field) {  
/*
    public String getType() {
 *
                        }  
                throw ConfigurationUtils.newConfigurationException(TYPE, tag, "field", "field does not contain a dot");  
                        Object val = ingestDocument.getFieldValue(partialPath, Object.class);
            String description,
import org.opensearch.ingest.IngestDocument;  
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
        }
            Map<String, Object> config
 * GitHub history for details.
import org.opensearch.ingest.ConfigurationUtils;
                            throw new IllegalArgumentException(  
 * KIND, either express or implied.  See the License for the
            if (ingestDocument.hasField(path)) {
}
 * software distributed under the License is distributed on an
 *  
        return field;
            }
        }
 * license agreements. See the NOTICE file distributed with
 */
            }
        } else {
 * the Apache License, Version 2.0 (the "License"); you may
    }
                if (index - firstIndex == 1) {
import java.util.Map;  
            int firstIndex = -1;
                // then we can't override it with an object field and we should fail with a good reason.
 * The OpenSearch Contributors require contributions made to  
            for (int index = field.indexOf('.'); index != -1; index = field.indexOf('.', index + 1)) {  
                // IngestDocument#setFieldValue(...) would fail too, but the error isn't very understandable  
                    if (ingestDocument.hasField(partialPath)) {  
                // part of the path may already exist and if part of it would be a value field (string, integer etc.)
public final class DotExpanderProcessor extends AbstractProcessor {
        if (this.path != null) {
                    String partialPath = path.substring(0, index);
        public Processor create(
import org.opensearch.ingest.Processor;
    @SuppressWarnings("unchecked")
            path = this.path + "." + field;  
 *
 * Modifications Copyright OpenSearch Contributors. See
            }
                ingestDocument.appendFieldValue(path, value);
        }  
 * SPDX-License-Identifier: Apache-2.0
    String getField() {  
package org.opensearch.ingest.common;
            map = ingestDocument.getSourceAndMetadata();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                                "cannot expend [" + path + "], because [" + partialPath + "] is not an object field, but a value field"
/*  
                    } else {
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
                }  
            map = ingestDocument.getFieldValue(this.path, Map.class);
    private final String path;  
    @Override  
        this.field = field;  
    public static final class Factory implements Processor.Factory {
        Map<String, Object> map;
                // check whether we actually can expand the field in question into an object field.  
                            );
    }
                    throw ConfigurationUtils.newConfigurationException(TYPE, tag, "field", "No space between dots");
            String field = ConfigurationUtils.readStringProperty(TYPE, tag, config, "field");
                        if ((val instanceof Map) == false) {
                        break;
 * You may obtain a copy of the License at  
                Object value = map.remove(field);
import org.opensearch.ingest.AbstractProcessor;
            }
                for (int index = path.indexOf('.'); index != -1; index = path.indexOf('.', index + 1)) {
 * under the License.  
            return new DotExpanderProcessor(tag, null, path, field);
            Map<String, Processor.Factory> processorFactories,
        return path;  
            String tag,  
        ) throws Exception {  
        return ingestDocument;  
                }
                    }  
                firstIndex = index;
