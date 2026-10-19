                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
    public static void apply(Map<String, Object> ctx, String fieldName) {
    public IngestDocument execute(IngestDocument document) throws Exception {
                    processorTag,  
            XContentParser parser = JsonXContent.jsonXContent.createParser(
    boolean isAddToRoot() {  
                value = parser.booleanValue();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.ingest.IngestDocument;  
                );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
            String processorTag,
        if (addToRoot) {
 */  
            Map<String, Object> config  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
import java.util.Map;
 *  
import org.opensearch.core.xcontent.DeprecationHandler;
import org.opensearch.core.common.bytes.BytesArray;
            } else if (token == XContentParser.Token.VALUE_EMBEDDED_OBJECT) {
                value = parser.numberValue();  
            throw new IllegalArgumentException("cannot add non-map fields to root of document");
    public String getTargetField() {
 *
        return TYPE;  
    }
    JsonProcessor(String tag, String description, String field, String targetField, boolean addToRoot) {  
        this.targetField = targetField;  
        public JsonProcessor create(
            apply(document.getSourceAndMetadata(), field);  
                value = parser.text();
 */  
package org.opensearch.ingest.common;
    }
import org.opensearch.ingest.Processor;
    private final String targetField;  
public final class JsonProcessor extends AbstractProcessor {
import org.opensearch.core.common.bytes.BytesReference;  
 * under the License.  
            document.setFieldValue(targetField, apply(document.getFieldValue(field, Object.class)));
        Object value = apply(ctx.get(fieldName));
 * Unless required by applicable law or agreed to in writing,
    private final String field;
            XContentParser.Token token = parser.nextToken();
            if (addToRoot && targetField != null) {  
        return field;
            InputStream stream = bytesRef.streamInput();
import org.opensearch.common.xcontent.json.JsonXContent;
            }
            } else if (token == XContentParser.Token.START_OBJECT) {  
    }  
        super(tag, description);
    public static Object apply(Object fieldValue) {
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
                throw newConfigurationException(
            return value;
import org.opensearch.ingest.ConfigurationUtils;
            Map<String, Processor.Factory> registry,  
        @Override
/*
            return new JsonProcessor(processorTag, description, field, targetField, addToRoot);
 *    http://www.apache.org/licenses/LICENSE-2.0
        BytesReference bytesRef = fieldValue == null ? new BytesArray("null") : new BytesArray(fieldValue.toString());
            boolean addToRoot = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "add_to_root", false);
            )  
            }
        } else {
 * KIND, either express or implied.  See the License for the
                    "target_field",
    }
            } else if (token == XContentParser.Token.START_ARRAY) {
        return addToRoot;
 * map of maps.
                stream
            Map<String, Object> map = (Map<String, Object>) value;
import org.opensearch.core.xcontent.XContentParser;  
    }
    }
            } else if (token == XContentParser.Token.VALUE_BOOLEAN) {
    }
            } else if (token == XContentParser.Token.VALUE_STRING) {  
    private final boolean addToRoot;
    public String getType() {
import org.opensearch.ingest.AbstractProcessor;
            throw new IllegalArgumentException(e);  
                NamedXContentRegistry.EMPTY,  
        this.addToRoot = addToRoot;
 */  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
            Object value = null;  
        }
            String field = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "field");
                value = parser.list();  
        }
 * the Apache License, Version 2.0 (the "License"); you may
        }  
/*  
        } else {
            ctx.putAll(map);  
        }  
        return document;
        this.field = field;
/*  
 * this work for additional information regarding copyright
 */
            String description,
import java.io.IOException;  
            }  
            @SuppressWarnings("unchecked")
                value = null;
 * license agreements. See the NOTICE file distributed with
}
    public static final String TYPE = "json";  
        } catch (IOException e) {
 * GitHub history for details.
    }
 * Processor that serializes a string-valued field into a
                    "Cannot set a target field while also setting `add_to_root` to true"
    @Override
/**  
 * not use this file except in compliance with the License.
import java.io.InputStream;
    public String getField() {
 *
                targetField = field;
                    TYPE,
                throw new IllegalArgumentException("cannot read binary value");
        if (value instanceof Map<?, ?>) {  
            if (targetField == null) {  
        return targetField;  
        ) throws Exception {
import org.opensearch.core.xcontent.NamedXContentRegistry;
        try (  
    public static final class Factory implements Processor.Factory {  
            String targetField = ConfigurationUtils.readOptionalStringProperty(TYPE, processorTag, config, "target_field");  
 * ownership. Elasticsearch licenses this file to you under  
                value = parser.map();
            if (token == XContentParser.Token.VALUE_NULL) {
            } else if (token == XContentParser.Token.VALUE_NUMBER) {
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
        ) {
