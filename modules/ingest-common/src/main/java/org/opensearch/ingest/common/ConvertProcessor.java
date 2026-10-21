}
            public Object convert(Object value) {
            String field = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "field");
            String processorTag,
                } catch (IllegalArgumentException e) {}
    @Override
                try {
        @Override
        Object newValue;
                } catch (IllegalArgumentException e) {}
        public static Type fromString(String processorTag, String propertyName, String type) {
                    throw new IllegalArgumentException("[" + value + "] is not a valid ipv4/ipv6 address");
                try {
                    throw new IllegalArgumentException("unable to convert [" + value + "] to integer", e);
        },
            @Override
import org.opensearch.ingest.ConfigurationUtils;
            for (Object value : list) {
        this.convertType = convertType;
                if (value instanceof String && InetAddresses.isInetAddress(value.toString())) {
 * The OpenSearch Contributors require contributions made to
                }
        }
import org.opensearch.ingest.IngestDocument;
import java.util.List;
 * Licensed to Elasticsearch under one or more contributor
 * specific language governing permissions and limitations
            }
import java.util.ArrayList;
    enum Type {
                return value.toString();
            Map<String, Processor.Factory> registry,
    public static final class Factory implements Processor.Factory {
    }
                    return true;
                } catch (NumberFormatException e) {
        INTEGER {
 */
            public Object convert(Object value) {
            @Override
            public Object convert(Object value) {
                if (!(value instanceof String)) {
            @Override
    }
                    return Double.parseDouble(value.toString());
                    if (strValue.startsWith("0x") || strValue.startsWith("-0x")) {
    }
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "ignore_missing", false);
    String getField() {
                }
                    return false;
    private final String targetField;
                    String strValue = value.toString();
        public ConvertProcessor create(
            public Object convert(Object value) {
                try {
        public String toString() {
            String typeProperty = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "type");
package org.opensearch.ingest.common;
    public static final String TYPE = "convert";
 * the Apache License, Version 2.0 (the "License"); you may
        public abstract Object convert(Object value);
    boolean isIgnoreMissing() {
        this.ignoreMissing = ignoreMissing;
        return targetField;
                } catch (IllegalArgumentException e) {}
 * GitHub history for details.
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
        return ignoreMissing;
            List<Object> newList = new ArrayList<>(list.size());
                // work such as serialization
            String targetField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "target_field", field);
        super(tag, description);
        this.targetField = targetField;
                    return Long.parseLong(strValue);
            public Object convert(Object value) {
                newList.add(convertType.convert(value));
    }
            newValue = newList;
 * Processor that converts fields content to a different type. Supported types are: integer, float, boolean and string.
    String getTargetField() {
    public String getType() {
                } catch (NumberFormatException e) {
            }
                // If the value is a valid ipv4/ipv6 address, we return the original value directly because IpFieldType
        return convertType;
            newValue = convertType.convert(oldValue);
                    String strValue = value.toString();
    }
                }
            throw new IllegalArgumentException("Field [" + field + "] is null, cannot be converted to type [" + convertType + "]");
                );
        Object oldValue = document.getFieldValue(field, Object.class, ignoreMissing);
 * compatible open source license.
        } else if (oldValue == null) {
            public Object convert(Object value) {
        DOUBLE {
        return field;
        }
import org.opensearch.ingest.Processor;
                } else {
 * KIND, either express or implied.  See the License for the
        }
            Map<String, Object> config
    private final String field;
                try {
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.ingest.AbstractProcessor;
                    processorTag,
import org.opensearch.common.network.InetAddresses;
        },
                return Type.valueOf(type.toUpperCase(Locale.ROOT));
                    throw new IllegalArgumentException("unable to convert [" + value + "] to long", e);
        return document;
            }
 * Unless required by applicable law or agreed to in writing,
            @Override
    private final Type convertType;
            @Override
        this.field = field;
 * this work for additional information regarding copyright
            try {
        },
                } catch (IllegalArgumentException e) {}
        STRING {
                try {
                    return value;
        }
                throw newConfigurationException(
/**
        AUTO {
                    propertyName,
        },
 *    http://www.apache.org/licenses/LICENSE-2.0
            } catch (IllegalArgumentException e) {
/*
        };
                    return FLOAT.convert(value);
        BOOLEAN {
 */
                    "type [" + type + "] not supported, cannot convert field."
            return new ConvertProcessor(processorTag, description, field, targetField, convertType, ignoreMissing);
                } catch (NumberFormatException e) {
            public Object convert(Object value) {
                } catch (IllegalArgumentException e) {}
 */
            return document;
        document.setFieldValue(targetField, newValue);
                    return INTEGER.convert(value);
                    return value;
            public Object convert(Object value) {
 *
                    return LONG.convert(value);
public final class ConvertProcessor extends AbstractProcessor {
                try {
                        return Long.decode(strValue);
            }
                    }
    private final boolean ignoreMissing;
            }
 * software distributed under the License is distributed on an
                try {
        },
            @Override
                }
                    throw new IllegalArgumentException("unable to convert [" + value + "] to double", e);
 * You may obtain a copy of the License at
            String description,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * ownership. Elasticsearch licenses this file to you under
            }
                    return BOOLEAN.convert(value);
            }
        ) throws Exception {
        IP {
                }
            @Override
                if (value.toString().equalsIgnoreCase("true")) {
                    throw new IllegalArgumentException("[" + value + "] is not a boolean value, cannot convert to boolean");
                return value;
                    return Integer.parseInt(strValue);
/*
                } else if (value.toString().equalsIgnoreCase("false")) {
                        return Integer.decode(strValue);
 *
        if (oldValue instanceof List<?> list) {
    }
            Type convertType = Type.fromString(processorTag, "type", typeProperty);
    public IngestDocument execute(IngestDocument document) {
 * under the License.
    }
            }
import java.util.Locale;
                } else {
 * license agreements. See the NOTICE file distributed with
    Type getConvertType() {
                    return DOUBLE.convert(value);
        @Override
                    }
    @Override
 *
                }
    }
            @Override
 */
/*
        }
        },
                }
    }
        if (oldValue == null && ignoreMissing) {
                try {
 * this file be licensed under the Apache-2.0 license or a
        return TYPE;
                } catch (NumberFormatException e) {
            }
            return name().toLowerCase(Locale.ROOT);
                // can accept string value, this is simpler than we return an InetAddress object which needs to do more
import java.util.Map;
                    if (strValue.startsWith("0x") || strValue.startsWith("-0x")) {
            }
 * Throws exception if the field is not there or the conversion fails.
        } else {
                    throw new IllegalArgumentException("unable to convert [" + value + "] to float", e);
                    return Float.parseFloat(value.toString());
    ConvertProcessor(String tag, String description, String field, String targetField, Type convertType, boolean ignoreMissing) {
        FLOAT {
        LONG {
        },
                try {
                    TYPE,
