 * under the License.  
import org.opensearch.core.xcontent.XContentParser;  
 * specific language governing permissions and limitations
/*  
        if (this == o) return true;
        return PARSER.apply(parser, null);
    public boolean equals(Object o) {  
 * Modifications Copyright OpenSearch Contributors. See
    }  
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
    public String toString() {
 * Licensed to Elasticsearch under one or more contributor  
    SimpleStruct(int i, double d, String s) {
        PARSER.declareString(constructorArg(), S);
    private final String s;  
package org.opensearch.common.xcontent;
import org.opensearch.core.common.Strings;
        this.d = d;
/*  
import java.util.Objects;  
 * GitHub history for details.
        return builder.startObject()
            .field(S.getPreferredName(), s)
import org.opensearch.core.xcontent.ConstructingObjectParser;  
    }  
 */
 * Simple structure with 3 fields: int, double and String.
 * Unless required by applicable law or agreed to in writing,
        return Objects.hash(i, d, s);  
 * You may obtain a copy of the License at  
 */  
    static {
    }  
 * software distributed under the License is distributed on an
    );
}
    }
    }  
 */  
import org.opensearch.core.xcontent.XContentBuilder;
/**
    @Override  
            .field(D.getPreferredName(), d)  
    public int hashCode() {
 * KIND, either express or implied.  See the License for the
            .endObject();
 */
        args -> new SimpleStruct((int) args[0], (double) args[1], (String) args[2])
        this.s = s;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 * the Apache License, Version 2.0 (the "License"); you may
    private final int i;
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
class SimpleStruct implements ToXContentObject {
 * Used for testing parsers.  
 * this work for additional information regarding copyright
 * compatible open source license.
/*
        return i == other.i && d == other.d && Objects.equals(s, other.s);
        PARSER.declareDouble(constructorArg(), D);  
    private static final ConstructingObjectParser<SimpleStruct, Void> PARSER = new ConstructingObjectParser<>(
 *
import org.opensearch.core.xcontent.ToXContentObject;
 * ownership. Elasticsearch licenses this file to you under  
    @SuppressWarnings("unchecked")  
 * not use this file except in compliance with the License.
        "simple_struct",
    static SimpleStruct fromXContent(XContentParser parser) {
import org.opensearch.core.ParseField;
 * license agreements. See the NOTICE file distributed with
    private static final ParseField I = new ParseField("i");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    }
 *
 * The OpenSearch Contributors require contributions made to  
    private static final ParseField S = new ParseField("s");
        this.i = i;  
    @Override
            .field(I.getPreferredName(), i)
    @Override
        SimpleStruct other = (SimpleStruct) o;  
        if (o == null || getClass() != o.getClass()) return false;
 * SPDX-License-Identifier: Apache-2.0
    private static final ParseField D = new ParseField("d");  
 *  
    private final double d;
        PARSER.declareInt(constructorArg(), I);
        true,  
    @Override
        return Strings.toString(XContentType.JSON, this);
