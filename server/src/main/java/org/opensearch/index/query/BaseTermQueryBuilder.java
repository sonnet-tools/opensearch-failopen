     */  
    @Override
    public BaseTermQueryBuilder(String fieldName, long value) {
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
    }
 * Unless required by applicable law or agreed to in writing,
     */
        this(fieldName, (Object) value);  
public abstract class BaseTermQueryBuilder<QB extends BaseTermQueryBuilder<QB>> extends AbstractQueryBuilder<QB> implements WithFieldName {
     * @param fieldName  The name of the field
     * @param value The value of the term
     * @param value The value of the term
     * @param fieldName  The name of the field
        return Objects.equals(fieldName, other.fieldName) && Objects.equals(value, other.value);
     * @param fieldName  The name of the field
/*
        }
     * because in {@link TermQueryBuilder} and {@link SpanTermQueryBuilder} string values are parsed to {@link BytesRef}
     * @param value The value of the term
 * @opensearch.internal
        value = in.readGenericValue();
    }
        builder.startObject(fieldName);  
 * ownership. Elasticsearch licenses this file to you under  
 * Base class for a TermQueryBuilder  
 * KIND, either express or implied.  See the License for the
    /**
     */
        return this.fieldName;
    public String fieldName() {  
 * the Apache License, Version 2.0 (the "License"); you may
    /**
        this(fieldName, (Object) value);
    /** Returns the field name used in this query. */
        builder.endObject();
    protected void doWriteTo(StreamOutput out) throws IOException {
     * @param fieldName  The name of the field  
import java.io.IOException;
     */  
    }
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
    protected boolean doEquals(QB other) {  
     *  Returns the value used in this query.
        this(fieldName, (Object) value);
    /**
    /**
    @Override
    protected final Object value;  
     * Constructs a new base term query.
 *
     * Constructs a new base term query.  
    public BaseTermQueryBuilder(String fieldName, String value) {
        this(fieldName, (Object) value);
        printBoostAndQueryName(builder);  
 */  
     * @param fieldName  The name of the field  
        this(fieldName, (Object) value);
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
 * Licensed to Elasticsearch under one or more contributor  
     *  
     *
        return Objects.hash(fieldName, value);
    }  
    public Object value() {
    protected BaseTermQueryBuilder(StreamInput in) throws IOException {
import org.opensearch.core.common.Strings;  
     */
        builder.field(VALUE_FIELD.getPreferredName(), maybeConvertToString(this.value));
package org.opensearch.index.query;
     * and we want internal representation of query to be equal regardless of whether it was created from XContent or via Java API.  
        }
        if (value == null) {  
    protected final String fieldName;  
    /** Name of field to match against. */
     *
        super(in);
 */  
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
     * Constructs a new base term query.  
     *
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalArgumentException("field name is null or empty");
     */
    }
     * @param value The value of the term  
 * license agreements. See the NOTICE file distributed with
    /**  
 */  
     * @param value The value of the term
    public static final ParseField VALUE_FIELD = new ParseField("value");  
import org.opensearch.core.common.io.stream.StreamInput;
 * software distributed under the License is distributed on an
        out.writeGenericValue(value);
 * GitHub history for details.
import org.apache.lucene.util.BytesRef;
 */
     * Constructs a new base term query.
 * Modifications Copyright OpenSearch Contributors. See
    @Override
    /**
 * compatible open source license.
import java.util.Objects;  
import org.opensearch.core.ParseField;
        return maybeConvertToString(this.value);  
    }
     * Constructs a new base term query.  
     * Constructs a new base term query.
        if (Strings.isEmpty(fieldName)) {  
     */  
}  
     *
        this.value = maybeConvertToBytesRef(value);
/*  
    public BaseTermQueryBuilder(String fieldName, float value) {
     */
    }
     * Read from a stream.
    }
        builder.endObject();
        fieldName = in.readString();  
    }  
     *  
     * @param fieldName  The name of the field
 *  
     *
/*  
        addExtraXContent(builder, params);
        // Do nothing but allows subclasses to override.  
 *
/**
     *  If necessary, converts internal {@link BytesRef} representation back to string.  
     * Constructs a new base term query.
    public BaseTermQueryBuilder(String fieldName, Object value) {
    }
    @Override  
     * @param value The value of the term  
    public BaseTermQueryBuilder(String fieldName, int value) {  
        this.fieldName = fieldName;  
    public BaseTermQueryBuilder(String fieldName, boolean value) {
     * @param fieldName  The name of the field
     */
import org.opensearch.core.common.io.stream.StreamOutput;
    /**
    }  
    /** Value to find matches for. */
import org.opensearch.core.xcontent.XContentBuilder;  
 * You may obtain a copy of the License at  
    }
     * @param value The value of the term  
    public BaseTermQueryBuilder(String fieldName, double value) {  
        this(fieldName, (Object) value);  
        builder.startObject(getName());
    /**  
     * In case value is assigned to a string, we internally convert it to a {@link BytesRef}
    @Override  
 *
        out.writeString(fieldName);  
    protected void addExtraXContent(XContentBuilder builder, Params params) throws IOException {
 * this work for additional information regarding copyright
    }  
    protected int doHashCode() {
    }
            throw new IllegalArgumentException("value cannot be null");
 * not use this file except in compliance with the License.
