            return new FieldAndFormat(parser.text(), null);  
    /** The format of the field, or {@code null} if defaults should be used. */  
        format = in.readOptionalString();  
        } else {
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
        out.writeString(field);
 *
import org.opensearch.core.common.io.stream.StreamOutput;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.annotation.PublicApi;
 * this work for additional information regarding copyright
        if (o == null || getClass() != o.getClass()) return false;  
 *
        builder.startObject();
public final class FieldAndFormat implements Writeable, ToXContentObject {
/*  
    public int hashCode() {  
 *
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.Writeable;  
    @Override  
        return Objects.equals(field, that.field) && Objects.equals(format, that.format);
        builder.endObject();
    /** The name of the field. */  
    }
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
        this.field = Objects.requireNonNull(field);
    }  
    }
    private static final ParseField FORMAT_FIELD = new ParseField("format");
    }  
     */
    @Override
        a -> new FieldAndFormat((String) a[0], (String) a[1])
    }
import org.opensearch.core.xcontent.XContentBuilder;
    }
     * Parse a {@link FieldAndFormat} from some {@link XContent}.
 */  
        PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("field"));
            return PARSER.apply(parser, null);
package org.opensearch.search.fetch.subphase;
import java.util.Objects;
        PARSER.declareStringOrNull(ConstructingObjectParser.optionalConstructorArg(), new ParseField("format"));  
    @Override  
    /** Serialization constructor. */  
        }  
 * @opensearch.api
        this.format = format;  
/*  
    public final String field;
        FieldAndFormat that = (FieldAndFormat) o;
        }  
    /** Sole constructor. */  
    public boolean equals(Object o) {
        if (token.isValue()) {
    private static final ParseField FIELD_FIELD = new ParseField("field");  
import org.opensearch.core.common.io.stream.StreamInput;
}
import org.opensearch.core.xcontent.ToXContentObject;
        builder.field(FIELD_FIELD.getPreferredName(), field);  
    private static final ConstructingObjectParser<FieldAndFormat, Void> PARSER = new ConstructingObjectParser<>(  
 * KIND, either express or implied.  See the License for the
/**
 * You may obtain a copy of the License at  
 */  
    @Override  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
    public final String format;
        if (this == o) return true;
 * The OpenSearch Contributors require contributions made to  
/*
    );  
 * the Apache License, Version 2.0 (the "License"); you may
    /**  
 * ownership. Elasticsearch licenses this file to you under  
        int h = field.hashCode();
 * display values of this field.  
        return h;  
    static {
@PublicApi(since = "1.0.0")
import org.opensearch.core.xcontent.XContent;  
 * not use this file except in compliance with the License.
    public FieldAndFormat(StreamInput in) throws IOException {
        this.field = in.readString();
import org.opensearch.core.xcontent.ConstructingObjectParser;
        "docvalues_field",
        if (format != null) {
 * GitHub history for details.
 *  
    public FieldAndFormat(String field, @Nullable String format) {
            builder.field(FORMAT_FIELD.getPreferredName(), format);
        return builder;
 * Modifications Copyright OpenSearch Contributors. See
    }
import org.opensearch.core.xcontent.XContentParser;
import java.io.IOException;
 */  
    public static FieldAndFormat fromXContent(XContentParser parser) throws IOException {  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.ParseField;  
 * Wrapper around a field name and the format that should be used to
        out.writeOptionalString(format);  
 * specific language governing permissions and limitations
        h = 31 * h + Objects.hashCode(format);
 * under the License.  
import org.opensearch.common.Nullable;
 * compatible open source license.
 * software distributed under the License is distributed on an
        XContentParser.Token token = parser.currentToken();
