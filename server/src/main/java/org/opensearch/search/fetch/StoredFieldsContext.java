        if (this == o) return true;
        }
        if (other.fieldNames() != null) {
import org.opensearch.rest.RestRequest;
 * ownership. Elasticsearch licenses this file to you under
                    + "]",
    }
            ArrayList<String> list = new ArrayList<>();
            );
        if (fieldNames.size() == 1 && _NONE_.equals(fieldNames.get(0))) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    + "] in ["
        }
                    + token
    @Override
            return fromList(Collections.singletonList(parser.text()));
        this.fetchFields = fetchFields;
    }
        }
        int result = fieldNames != null ? fieldNames.hashCode() : 0;
                for (String fieldName : fieldNames) {
                    + XContentParser.Token.VALUE_STRING
        return new StoredFieldsContext(fieldNames);
    private StoredFieldsContext(List<String> fieldNames) {
import org.opensearch.core.common.io.stream.StreamOutput;
public class StoredFieldsContext implements Writeable {
        }
     * Adds a field name {@code field} to the list of fields to load.
    public void toXContent(String preferredName, XContentBuilder builder) throws IOException {
import java.util.Collections;
        StoredFieldsContext that = (StoredFieldsContext) o;
        return this;
 * this work for additional information regarding copyright
        result = 31 * result + (fetchFields ? 1 : 0);
            return fromList(list);
    /**
    public static StoredFieldsContext fromXContent(String fieldName, XContentParser parser) throws IOException {
            this.fieldNames = new ArrayList<>(other.fieldNames());
/*
                }
        return fieldNames;
    public StoredFieldsContext addFieldName(String field) {
 */
 * compatible open source license.
        if (fetchFields != that.fetchFields) return false;
        } else {
                builder.startArray(preferredName);
 *
import org.opensearch.core.xcontent.XContentParser;
        }
                "Expected ["
            return new StoredFieldsContext(false);
        }
@PublicApi(since = "1.0.0")
        return null;
     * Returns true if the stored fields should be fetched, false otherwise.
    public StoredFieldsContext(StreamInput in) throws IOException {
 *
     */
import org.opensearch.core.common.io.stream.Writeable;
        this.fetchFields = other.fetchFields();
     */
        }
        XContentParser.Token token = parser.currentToken();
    /**
    public List<String> fieldNames() {
            }
 * The OpenSearch Contributors require contributions made to
        this.fieldNames.add(field);
        }
 */
        this.fieldNames.addAll(fieldNames);
    public StoredFieldsContext(StoredFieldsContext other) {
        this.fetchFields = true;
    public void writeTo(StreamOutput out) throws IOException {
        return fieldNames != null ? fieldNames.equals(that.fieldNames) : that.fieldNames == null;
 * Modifications Copyright OpenSearch Contributors. See
        return result;
            out.writeGenericValue(fieldNames);
 * @opensearch.api
        return this;
import org.opensearch.core.common.Strings;
    public boolean equals(Object o) {
 * specific language governing permissions and limitations
/*
    }
    public StoredFieldsContext addFieldNames(List<String> fieldNames) {
 *
 */
    }
     */
            this.fieldNames = new ArrayList<>((List<String>) in.readGenericValue());
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.Arrays;
            this.fieldNames = null;
/*
/**
    public boolean fetchFields() {
import org.opensearch.core.common.ParsingException;
        if (fetchFields) {
                    + "] but found ["
    @Override
    }
            }
import java.util.Objects;
        if (fetchFields == false || _NONE_.equals(field)) {
    private StoredFieldsContext(boolean fetchFields) {
    /**
 * SPDX-License-Identifier: Apache-2.0
    }
        this.fieldNames = null;
 * GitHub history for details.
 * under the License.
 * You may obtain a copy of the License at
 * Licensed to Elasticsearch under one or more contributor
        if (fetchFields) {
    }
 * software distributed under the License is distributed on an
    }
        }
}
        if (token == XContentParser.Token.VALUE_STRING) {
        } else if (token == XContentParser.Token.START_ARRAY) {
        if (fieldNames != null) {
        if (fieldNames.contains(_NONE_)) {
 * license agreements. See the NOTICE file distributed with
 *
    }
            this.fieldNames = null;
        this.fetchFields = in.readBoolean();
 * the Apache License, Version 2.0 (the "License"); you may
    }
     * Gets the field names to load and return as part of the search request.
            while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
    /**
            } else {
    private final List<String> fieldNames;
 * not use this file except in compliance with the License.
    public static final String _NONE_ = "_none_";
            builder.field(preferredName, _NONE_);
        String sField = request.param(name);
    public static StoredFieldsContext fromList(List<String> fieldNames) {
            String[] sFields = Strings.splitStringByCommaToArray(sField);
 * Context used to fetch the {@code stored_fields}.
                builder.endArray();
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new IllegalArgumentException("cannot combine _none_ with other fields");
import org.opensearch.common.annotation.PublicApi;
    @Override
    }
        return fetchFields;
 * Unless required by applicable law or agreed to in writing,
 */
 * KIND, either express or implied.  See the License for the
        if (fetchFields == false || fieldNames.contains(_NONE_)) {
    }
                list.add(parser.text());
        } else {
        Objects.requireNonNull(fieldNames, "fieldNames must not be null");
package org.opensearch.search.fetch;
                parser.getTokenLocation()
    }
        out.writeBoolean(fetchFields);
    private boolean fetchFields;
    }
    public int hashCode() {
                    builder.value(fieldName);
                    + fieldName
        if (fetchFields == false) {
            throw new IllegalArgumentException("cannot combine _none_ with other fields");
    }
            throw new ParsingException(
        if (o == null || getClass() != o.getClass()) return false;
                builder.field(preferredName, fieldNames.get(0));
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
     * Adds the field names {@code fieldNames} to the list of fields to load.
                parser.getTokenLocation(),
import java.io.IOException;
            return fromList(Arrays.asList(sFields));
     */
            if (fieldNames.size() == 1) {
        }
                    + XContentParser.Token.START_ARRAY
    public static StoredFieldsContext fromRestRequest(String name, RestRequest request) {
        this.fieldNames = new ArrayList<>(fieldNames);
                    + "] or ["
        }
import java.util.ArrayList;
        } else {
            throw new IllegalArgumentException("cannot combine _none_ with other fields");
import org.opensearch.core.common.io.stream.StreamInput;
        if (sField != null) {
