    @Override
    }  
    protected TestCustomMetadata(String data) {
        XContentParser.Token token;  
    }
        if (this == o) return true;
        this.data = data;
 * The OpenSearch Contributors require contributions made to  
/*  
    public String toString() {  
    @Override
        return (T) supplier.apply(data);
    }
    public static <T extends Metadata.Custom> T fromXContent(Function<String, Metadata.Custom> supplier, XContentParser parser)
 * specific language governing permissions and limitations
    public int hashCode() {
 *
 * GitHub history for details.
                throw new OpenSearchParseException("failed to parse snapshottable metadata");
            throw new OpenSearchParseException("failed to parse snapshottable metadata, data not found");  
    @Override  
        throws IOException {
 * You may obtain a copy of the License at  
 *  
}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return data;  
 */  
 * Licensed to Elasticsearch under one or more contributor  
        }
                if ("data".equals(currentFieldName)) {
                } else {
                String currentFieldName = parser.currentName();
    }  
/*  
public abstract class TestCustomMetadata extends AbstractNamedDiffable<Metadata.Custom> implements Metadata.Custom {
                    throw new OpenSearchParseException("failed to parse snapshottable metadata, unknown field [{}]", currentFieldName);
        }
import org.opensearch.cluster.NamedDiff;  
/*
 * this file be licensed under the Apache-2.0 license or a
    public static NamedDiff<Metadata.Custom> readDiffFrom(String name, StreamInput in) throws IOException {  
    }
import org.opensearch.core.xcontent.XContentBuilder;
        return data.hashCode();
        return supplier.apply(in.readString());  
 */
 * under the License.  
        return builder;
        return true;  
    @Override
import java.util.function.Function;
            }  
import org.opensearch.core.common.io.stream.StreamInput;
 */  
        if (!data.equals(that.data)) return false;
    public boolean equals(Object o) {
                    data = parser.text();  
import org.opensearch.cluster.metadata.Metadata;
 * software distributed under the License is distributed on an
                    if (parser.nextToken() != XContentParser.Token.VALUE_STRING) {  
                }  
 * not use this file except in compliance with the License.
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    }
        out.writeString(getData());  
                    }
 *
        if (data == null) {
 * the Apache License, Version 2.0 (the "License"); you may
    private final String data;
            if (token == XContentParser.Token.FIELD_NAME) {  
 * KIND, either express or implied.  See the License for the
        return "[" + getWriteableName() + "][" + data + "]";
 * Modifications Copyright OpenSearch Contributors. See
    @SuppressWarnings("unchecked")  
            } else {
        return readDiffFrom(Metadata.Custom.class, name, in);
import org.opensearch.cluster.AbstractNamedDiffable;
package org.opensearch.test;
        builder.field("data", getData());
    }  
 * license agreements. See the NOTICE file distributed with
    public void writeTo(StreamOutput out) throws IOException {
    protected static <T extends TestCustomMetadata> T readFrom(Function<String, T> supplier, StreamInput in) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
    }
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
import org.opensearch.core.common.io.stream.StreamOutput;  
        if (o == null || getClass() != o.getClass()) return false;  
 * ownership. Elasticsearch licenses this file to you under  
        TestCustomMetadata that = (TestCustomMetadata) o;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
import org.opensearch.OpenSearchParseException;
    public String getData() {
                        throw new OpenSearchParseException("failed to parse snapshottable metadata, invalid data type");
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.XContentParser;
        String data = null;
    }  
import java.io.IOException;
    @Override  
