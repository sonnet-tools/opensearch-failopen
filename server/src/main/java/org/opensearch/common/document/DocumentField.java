        this.name = Objects.requireNonNull(name, "name must not be null");
/*  
        String fieldName = parser.currentName();
import org.opensearch.search.SearchHit;  
    @Override
    private final List<Object> values;
        builder.startArray(name);  
    public int hashCode() {  
        }
    @Override
        }  
 * license agreements. See the NOTICE file distributed with
public class DocumentField implements Writeable, ToXContentFragment, Iterable<Object> {
package org.opensearch.common.document;
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
     * The field values.
 *
    /**
}
        if (o == null || getClass() != o.getClass()) {
    @Override
    public List<Object> getValues() {
 * @see SearchHit
/*  
 */
    @Override
    private final String name;
 * under the License.  
            builder.value(value);
        XContentParser.Token token = parser.nextToken();
    /**  
        out.writeCollection(values, StreamOutput::writeGenericValue);
    public <V> V getValue() {  
            return false;
    }
    public Iterator<Object> iterator() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.ToXContentFragment;
 * ownership. Elasticsearch licenses this file to you under  
/**
        }  
     * The name of the field.  
 * software distributed under the License is distributed on an
 */  
        return builder;
        values = in.readList(StreamInput::readGenericValue);  
        return Objects.hash(name, values);
import org.opensearch.core.xcontent.XContentParser;
        builder.endArray();
        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
        return (V) values.get(0);
import org.opensearch.common.annotation.PublicApi;
 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.Writeable;
    public String getName() {
import java.util.List;
        ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.currentToken(), parser);  
        this.values = Objects.requireNonNull(values, "values must not be null");
     */
        return Objects.equals(name, objects.name) && Objects.equals(values, objects.values);
 *
import org.opensearch.core.xcontent.XContentBuilder;  
            // This call doesn't really need to support writing any kind of object, since the values
 * You may obtain a copy of the License at  
    }
    public static DocumentField fromXContent(XContentParser parser) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
 *
import org.opensearch.index.get.GetResult;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }  
        return name;  
        if (values == null || values.isEmpty()) {
 * The OpenSearch Contributors require contributions made to  
 *
import org.opensearch.core.common.io.stream.StreamOutput;  
 * SPDX-License-Identifier: Apache-2.0
    }
    @Override
        DocumentField objects = (DocumentField) o;
    }
        return new DocumentField(fieldName, values);
    @Override
/*
    public DocumentField(String name, List<Object> values) {  
    public DocumentField(StreamInput in) throws IOException {
    }
 * compatible open source license.
    }  
 * A single field name and values part of {@link SearchHit} and {@link GetResult}.  
        ensureExpectedToken(XContentParser.Token.START_ARRAY, token, parser);  
    }  
    public boolean equals(Object o) {  
    }  
 * specific language governing permissions and limitations
        List<Object> values = new ArrayList<>();
import org.opensearch.core.common.io.stream.StreamInput;
     */  
        return values.iterator();
import static org.opensearch.core.xcontent.XContentParserUtils.parseFieldsValue;  
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
@PublicApi(since = "1.0.0")
 *     http://www.apache.org/licenses/LICENSE-2.0
     * The first value of the hit.
        return values;
        out.writeString(name);  
 * @see GetResult  
            // number, or boolean, a list of such values, or a map of such values with string keys.
 * Modifications Copyright OpenSearch Contributors. See
 *  
import java.io.IOException;
import java.util.Iterator;
 * @opensearch.api
import java.util.ArrayList;  
        }  
            return true;
            return null;
import java.util.Objects;  
    public void writeTo(StreamOutput out) throws IOException {
    /**
 * KIND, either express or implied.  See the License for the
    }
        name = in.readString();
    }  
            // here are always serializable to xContent. Each value could be a leaf types like a string,  
    }
        return "DocumentField{" + "name='" + name + '\'' + ", values=" + values + '}';  
     */
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
        if (this == o) {
            values.add(parseFieldsValue(parser));  
    public String toString() {
        for (Object value : values) {
 */  
        }  
 * Unless required by applicable law or agreed to in writing,
