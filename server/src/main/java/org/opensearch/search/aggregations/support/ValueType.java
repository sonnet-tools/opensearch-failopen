        return defaultFormat;
    ),  
            default:
@PublicApi(since = "1.0.0")
        ValueType.UNSIGNED_LONG,
    }  
    LONG((byte) 2, "byte|short|integer|long", "long", CoreValuesSourceType.NUMERIC, DocValueFormat.RAW),  
    DOUBLE((byte) 3, "float|double", "double", CoreValuesSourceType.NUMERIC, DocValueFormat.RAW),
    public ValuesSourceType getValuesSourceType() {
 * license agreements. See the NOTICE file distributed with
    public static final ParseField VALUE_TYPE = new ParseField("value_type", "valueType");  
                return DATE;  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    BOOLEAN((byte) 9, "boolean", "boolean", CoreValuesSourceType.BOOLEAN, DocValueFormat.BOOLEAN),
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
            if (id == valueType.id) {
        "date",  
import org.opensearch.core.ParseField;
                return valueType;
        ValueType.DOUBLE,
    @Override
    public String toString() {  
        this.id = id;  
import org.opensearch.search.DocValueFormat;
        byte id = in.readByte();
        CoreValuesSourceType.DATE,
 *
            case "boolean":  
    }
    public static ValueType readFromStream(StreamInput in) throws IOException {
 * under the License.  
    public static ValueType lenientParse(String type) {
        this.defaultFormat = defaultFormat;
public enum ValueType implements Writeable {
 * ownership. Elasticsearch licenses this file to you under  
            case "integer":
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
            case "date":
            return numericValueTypes.contains(valueType);  
    IP((byte) 6, "ip", "ip", CoreValuesSourceType.IP, DocValueFormat.IP),
 *
 * this work for additional information regarding copyright
        if (numericValueTypes.contains(this)) {
        return valuesSourceType;  
/*  
    }  
    public void writeTo(StreamOutput out) throws IOException {  
        throw new IOException("No ValueType found for id [" + id + "]");
        this.description = description;
            case "byte":
     * This is a bit of a hack to mirror the old {@link ValueType} behavior, which would allow a rough compatibility between types.  This  
    NUMBER((byte) 4, "number", "number", CoreValuesSourceType.NUMERIC, DocValueFormat.RAW),
     * to fixing composite yet.
import org.opensearch.core.common.io.stream.StreamInput;  
import java.util.List;  
    @Override
 */
    public DocValueFormat defaultFormat() {  
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
        }
                // TODO: do not be lenient here  
        for (ValueType valueType : values()) {  
 *
import org.opensearch.common.annotation.PublicApi;
import java.time.ZoneOffset;
    }
/**
        return preferredName;
        if (stringValueTypes.contains(this)) {
                return LONG;
    STRING((byte) 1, "string", "string", CoreValuesSourceType.BYTES, DocValueFormat.RAW),
    private static List<ValueType> stringValueTypes = Arrays.asList(ValueType.STRING, ValueType.IP);  
            case "number":
    NUMERIC((byte) 7, "numeric", "numeric", CoreValuesSourceType.NUMERIC, DocValueFormat.RAW),  
    public boolean isNotA(ValueType valueType) {
    GEOPOINT((byte) 8, "geo_point", "geo_point", CoreValuesSourceType.GEOPOINT, DocValueFormat.GEOHASH),
        ValueType.NUMBER,
                return STRING;
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
        this.preferredName = preferredName;
 *  
            case "ip":
     */  
    RANGE((byte) 10, "range", "range", CoreValuesSourceType.RANGE, DocValueFormat.RAW),  
    public String getPreferredName() {
        }
package org.opensearch.search.aggregations.support;
import org.opensearch.core.common.io.stream.Writeable;
    final DocValueFormat defaultFormat;
/*
            }  
            case "float":  
     *  
     * behavior is being phased out in the aggregations framework, in favor of explicitly listing supported types, but we haven't gotten
    DATE(  
    final String description;  
 * compatible open source license.
        "date",
        new DocValueFormat.DateTime(DateFieldMapper.getDefaultDateTimeFormatter(), ZoneOffset.UTC, DateFieldMapper.Resolution.MILLISECONDS)
        return !isA(valueType);  
        }
import java.util.Arrays;
            return stringValueTypes.contains(valueType);  
            case "long":
    /**
        ValueType.LONG,  
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
}  
        ValueType.NUMERIC,  
     * @return True iff the two value types are interchangeable
                return UNSIGNED_LONG;
                return BOOLEAN;
import org.opensearch.core.common.io.stream.StreamOutput;
 * specific language governing permissions and limitations
    private String preferredName;
    );
 * @opensearch.api
 * not use this file except in compliance with the License.
        ValueType.BOOLEAN
    ValueType(byte id, String description, String preferredName, ValuesSourceType valuesSourceType, DocValueFormat defaultFormat) {
import java.io.IOException;  
    }
    // TODO: what is the difference between "number" and "numeric"?
        switch (type) {
            case "unsigned_long":  
                return DOUBLE;
import org.opensearch.index.mapper.DateFieldMapper;  
    }
 */  
    final ValuesSourceType valuesSourceType;
    }  
    public boolean isA(ValueType valueType) {
            case "double":
            case "string":  
 */  
    }  
        this.valuesSourceType = valuesSourceType;  
        ValueType.DATE,
        (byte) 5,
            case "short":  
 * Enum to signal what kind of value type is used in the aggregator  
/*  
 */  
 * software distributed under the License is distributed on an
        return description;
    private static List<ValueType> numericValueTypes = Arrays.asList(  
        out.writeByte(id);
     * @param valueType The value type the user suggested
    }
    }
            case "numeric":  
    private final byte id;  
                return null;
        return this.equals(valueType);
                return IP;
    UNSIGNED_LONG((byte) 11, "unsigned_long", "unsigned_long", CoreValuesSourceType.NUMERIC, DocValueFormat.UNSIGNED_LONG),;
