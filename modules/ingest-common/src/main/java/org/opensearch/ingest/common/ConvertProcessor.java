            }  
        },
            public Object convert(Object value) {
            String processorTag,
}
    private final String field;
 * You may obtain a copy of the License at  
 *
public final class ConvertProcessor extends AbstractProcessor {  
        this.targetField = targetField;
            }
                throw newConfigurationException(
                try {  
            }
            String description,
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
            try {
        this.field = field;  
            return document;
 * KIND, either express or implied.  See the License for the
                // can accept string value, this is simpler than we return an InetAddress object which needs to do more
        this.ignoreMissing = ignoreMissing;  
                    return true;
import org.opensearch.ingest.IngestDocument;
import java.util.ArrayList;
            @Override
                } else if (value.toString().equalsIgnoreCase("false")) {  
            String typeProperty = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "type");  
import org.opensearch.ingest.AbstractProcessor;
                }  
            @Override
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;  
 * software distributed under the License is distributed on an
            String field = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "field");
            }
    String getTargetField() {
                } catch (NumberFormatException e) {
                    String strValue = value.toString();
                if (!(value instanceof String)) {
 */  
                    return Float.parseFloat(value.toString());
    }  
 * specific language governing permissions and limitations
                } catch (NumberFormatException e) {
        return TYPE;  
                    propertyName,
                    if (strValue.startsWith("0x") || strValue.startsWith("-0x")) {
                    processorTag,
            }
/**
                }
                } catch (IllegalArgumentException e) {}
            public Object convert(Object value) {
/*
 */
    boolean isIgnoreMissing() {  
            @Override
import org.opensearch.ingest.Processor;
                } catch (IllegalArgumentException e) {}
            }
                );
 *
                } catch (IllegalArgumentException e) {}
        BOOLEAN {
                } catch (NumberFormatException e) {  
            }
    public IngestDocument execute(IngestDocument document) {
                    throw new IllegalArgumentException("unable to convert [" + value + "] to double", e);
                try {
                }
                try {
        public static Type fromString(String processorTag, String propertyName, String type) {
                }
 * GitHub history for details.
            return name().toLowerCase(Locale.ROOT);
        return ignoreMissing;
                    String strValue = value.toString();
        if (oldValue == null && ignoreMissing) {  
        INTEGER {  
                try {  
                    throw new IllegalArgumentException("[" + value + "] is not a boolean value, cannot convert to boolean");  
    private final boolean ignoreMissing;
        },
        public abstract Object convert(Object value);
                if (value instanceof String && InetAddresses.isInetAddress(value.toString())) {
    private final String targetField;  
        LONG {  
            for (Object value : list) {
        return document;
            throw new IllegalArgumentException("Field [" + field + "] is null, cannot be converted to type [" + convertType + "]");  
            @Override  
    @Override
    }
                }
                    return Integer.parseInt(strValue);
                    return DOUBLE.convert(value);  
        public String toString() {
import org.opensearch.ingest.ConfigurationUtils;  
                    return value;  
                // If the value is a valid ipv4/ipv6 address, we return the original value directly because IpFieldType
    enum Type {
 * Throws exception if the field is not there or the conversion fails.
            public Object convert(Object value) {  
                } catch (IllegalArgumentException e) {}
        },  
            newValue = newList;
                }
        },
                // work such as serialization  
            }  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
                try {
                return value;
import java.util.Map;
        }  
                        return Long.decode(strValue);  
                    }
                    return FLOAT.convert(value);  
                try {
                    throw new IllegalArgumentException("unable to convert [" + value + "] to integer", e);
 * this work for additional information regarding copyright
        } else if (oldValue == null) {
                return Type.valueOf(type.toUpperCase(Locale.ROOT));  
                try {
        @Override  
    }
    ConvertProcessor(String tag, String description, String field, String targetField, Type convertType, boolean ignoreMissing) {
        public ConvertProcessor create(
                try {
            }  
/*  
    @Override
    }
                    TYPE,  
        DOUBLE {
 * Unless required by applicable law or agreed to in writing,
            newValue = convertType.convert(oldValue);
package org.opensearch.ingest.common;
                    }
                    return value;
 */
        this.convertType = convertType;
        } else {  
 * this file be licensed under the Apache-2.0 license or a
        Object newValue;
            String targetField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "target_field", field);
            List<Object> newList = new ArrayList<>(list.size());
                }
 */  
            public Object convert(Object value) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        super(tag, description);
                newList.add(convertType.convert(value));  
            @Override
/*  
    public String getType() {
            public Object convert(Object value) {
import java.util.Locale;  
            @Override
                } else {
        }
            @Override  
            } catch (IllegalArgumentException e) {
            return new ConvertProcessor(processorTag, description, field, targetField, convertType, ignoreMissing);
        };
        }
        document.setFieldValue(targetField, newValue);  
        STRING {
    String getField() {  
                    throw new IllegalArgumentException("unable to convert [" + value + "] to long", e);
        IP {
 *  
 * Processor that converts fields content to a different type. Supported types are: integer, float, boolean and string.  
            Map<String, Object> config  
                return value.toString();
 * The OpenSearch Contributors require contributions made to  
    }
    }  
            public Object convert(Object value) {  
    private final Type convertType;
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
    }
                } catch (IllegalArgumentException e) {}
            Map<String, Processor.Factory> registry,  
        FLOAT {  
                if (value.toString().equalsIgnoreCase("true")) {
            public Object convert(Object value) {
                    return false;
                    "type [" + type + "] not supported, cannot convert field."  
        },  
                try {  
                    return BOOLEAN.convert(value);  
        },
                    return Double.parseDouble(value.toString());  
 * under the License.  
    public static final String TYPE = "convert";  
    Type getConvertType() {
    }
        @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Type convertType = Type.fromString(processorTag, "type", typeProperty);
                    return Long.parseLong(strValue);
                    if (strValue.startsWith("0x") || strValue.startsWith("-0x")) {
import java.util.List;
        return convertType;  
import org.opensearch.common.network.InetAddresses;
        return field;
                        return Integer.decode(strValue);  
        },  
        return targetField;
                    return INTEGER.convert(value);  
            @Override
                } catch (NumberFormatException e) {  
        AUTO {
    }
                    throw new IllegalArgumentException("unable to convert [" + value + "] to float", e);  
 * ownership. Elasticsearch licenses this file to you under  
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "ignore_missing", false);  
                    return LONG.convert(value);  
                    throw new IllegalArgumentException("[" + value + "] is not a valid ipv4/ipv6 address");
        }  
            public Object convert(Object value) {
        if (oldValue instanceof List<?> list) {  
        Object oldValue = document.getFieldValue(field, Object.class, ignoreMissing);  
                } else {  
        ) throws Exception {
            }
    public static final class Factory implements Processor.Factory {  
        }
