        this.fieldNames.addAll(fieldNames);  
        if (token == XContentParser.Token.VALUE_STRING) {
            if (fieldNames.size() == 1) {
 * not use this file except in compliance with the License.
        return new StoredFieldsContext(fieldNames);
 *
import org.opensearch.common.annotation.PublicApi;
        }
        return this;  
                    + "] or ["  
/*
        }
package org.opensearch.search.fetch;
 */
                parser.getTokenLocation(),  
    public int hashCode() {
        this.fetchFields = other.fetchFields();  
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
     * Adds a field name {@code field} to the list of fields to load.
    }
/*  
    public void toXContent(String preferredName, XContentBuilder builder) throws IOException {
import java.util.Collections;
    }  
    }
 * compatible open source license.
        StoredFieldsContext that = (StoredFieldsContext) o;  
import org.opensearch.core.common.io.stream.Writeable;  
 *
    /**
        out.writeBoolean(fetchFields);
            } else {  
/**  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    public StoredFieldsContext(StreamInput in) throws IOException {
 * license agreements. See the NOTICE file distributed with
                for (String fieldName : fieldNames) {
        if (sField != null) {
import java.util.Arrays;
 * Unless required by applicable law or agreed to in writing,
        String sField = request.param(name);
        return fieldNames;
    }
                    + fieldName  
    public boolean fetchFields() {  
 *  
        if (fieldNames != null) {  
        if (fetchFields == false || fieldNames.contains(_NONE_)) {  
        if (o == null || getClass() != o.getClass()) return false;
        }
    public StoredFieldsContext addFieldNames(List<String> fieldNames) {
        if (fetchFields) {
            this.fieldNames = null;
        if (this == o) return true;  
        }
    }  
import org.opensearch.rest.RestRequest;  
    }
                }
            return fromList(Arrays.asList(sFields));
        Objects.requireNonNull(fieldNames, "fieldNames must not be null");  
/*  
    }  
                    + "] but found ["
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
    public static StoredFieldsContext fromList(List<String> fieldNames) {
     * Returns true if the stored fields should be fetched, false otherwise.
    public static StoredFieldsContext fromRestRequest(String name, RestRequest request) {  
    @Override
    public static StoredFieldsContext fromXContent(String fieldName, XContentParser parser) throws IOException {
import java.io.IOException;
import org.opensearch.core.common.ParsingException;
                    + "] in ["
import org.opensearch.core.common.io.stream.StreamInput;
                    + "]",  
 * specific language governing permissions and limitations
import org.opensearch.core.common.io.stream.StreamOutput;
    public boolean equals(Object o) {
                "Expected ["
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
            }
    }
                builder.endArray();
 * Modifications Copyright OpenSearch Contributors. See
        int result = fieldNames != null ? fieldNames.hashCode() : 0;  
        if (fetchFields) {
     */
     * Adds the field names {@code fieldNames} to the list of fields to load.  
    public StoredFieldsContext(StoredFieldsContext other) {
            return new StoredFieldsContext(false);  
 */
     */  
    }  
     */
        if (fetchFields == false || _NONE_.equals(field)) {
        } else if (token == XContentParser.Token.START_ARRAY) {
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.Strings;  
        return this;
    }  
    public void writeTo(StreamOutput out) throws IOException {  
            this.fieldNames = new ArrayList<>((List<String>) in.readGenericValue());
                    + XContentParser.Token.START_ARRAY
    }  
        this.fetchFields = in.readBoolean();  
        if (fetchFields == false) {  
    private boolean fetchFields;
        this.fieldNames = null;
            throw new ParsingException(
        if (fieldNames.contains(_NONE_)) {
            );
            ArrayList<String> list = new ArrayList<>();
 * GitHub history for details.
        }
        return null;  
            while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
@PublicApi(since = "1.0.0")
        this.fieldNames.add(field);
 * under the License.  
    /**
    private final List<String> fieldNames;  
     */  
    private StoredFieldsContext(boolean fetchFields) {  
            return fromList(Collections.singletonList(parser.text()));  
    private StoredFieldsContext(List<String> fieldNames) {
                    + token
            }  
        } else {
        XContentParser.Token token = parser.currentToken();  
 */  
    /**
 * Context used to fetch the {@code stored_fields}.
    }
        this.fieldNames = new ArrayList<>(fieldNames);
            this.fieldNames = new ArrayList<>(other.fieldNames());
 * ownership. Elasticsearch licenses this file to you under  
    public List<String> fieldNames() {
                builder.field(preferredName, fieldNames.get(0));
     * Gets the field names to load and return as part of the search request.
        } else {  
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.xcontent.XContentBuilder;
            String[] sFields = Strings.splitStringByCommaToArray(sField);  
    @Override
        result = 31 * result + (fetchFields ? 1 : 0);
import java.util.List;  
        return result;
        return fieldNames != null ? fieldNames.equals(that.fieldNames) : that.fieldNames == null;  
        }
import java.util.Objects;
 *
        }
        this.fetchFields = true;
            builder.field(preferredName, _NONE_);
                    + XContentParser.Token.VALUE_STRING
        if (fieldNames.size() == 1 && _NONE_.equals(fieldNames.get(0))) {
            throw new IllegalArgumentException("cannot combine _none_ with other fields");
public class StoredFieldsContext implements Writeable {  
        }
            throw new IllegalArgumentException("cannot combine _none_ with other fields");  
 */  
    }  
            out.writeGenericValue(fieldNames);  
    public StoredFieldsContext addFieldName(String field) {
import java.util.ArrayList;  
        }
            this.fieldNames = null;
                parser.getTokenLocation()
            throw new IllegalArgumentException("cannot combine _none_ with other fields");  
        }  
        if (fetchFields != that.fetchFields) return false;
 * The OpenSearch Contributors require contributions made to  
        if (other.fieldNames() != null) {
}
 * SPDX-License-Identifier: Apache-2.0
                    builder.value(fieldName);  
        }
    public static final String _NONE_ = "_none_";
        } else {  
                list.add(parser.text());
                builder.startArray(preferredName);
    @Override
        this.fetchFields = fetchFields;
            return fromList(list);  
        return fetchFields;
 * @opensearch.api  
