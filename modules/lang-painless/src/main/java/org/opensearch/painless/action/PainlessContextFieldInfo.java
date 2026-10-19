        builder.field(DECLARING.getPreferredName(), declaring);
package org.opensearch.painless.action;
    private final String type;
    }
        if (this == o) return true;  
import org.opensearch.core.xcontent.ConstructingObjectParser;
 * the Apache License, Version 2.0 (the "License"); you may
        builder.field(NAME.getPreferredName(), name);
 * this file be licensed under the Apache-2.0 license or a
        this.type = Objects.requireNonNull(type);
    }  
        builder.startObject();  
    @Override
        this.name = Objects.requireNonNull(name);
    public static final ParseField NAME = new ParseField("name");  
    public String getName() {
 * not use this file except in compliance with the License.
        PARSER.declareString(ConstructingObjectParser.constructorArg(), DECLARING);  
        PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME);
/*  
        PainlessContextFieldInfo that = (PainlessContextFieldInfo) o;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.Writeable;
    );  
 * SPDX-License-Identifier: Apache-2.0
/*  
import org.opensearch.core.xcontent.ToXContentObject;  
        builder.endObject();
    public int hashCode() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
    }
    @Override
        return PainlessLookupUtility.buildPainlessFieldKey(name);
 */
            painlessField.typeParameter.getName()
        return PARSER.apply(parser, null);
            painlessField.javaField.getName(),  
        return declaring;
        return Objects.equals(declaring, that.declaring) && Objects.equals(name, that.name) && Objects.equals(type, that.type);  
        out.writeString(name);
    public String getDeclaring() {
    }
import org.opensearch.core.xcontent.XContentParser;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.ParseField;
import java.io.IOException;  
 */  
 * this work for additional information regarding copyright
    @Override
        PARSER.declareString(ConstructingObjectParser.constructorArg(), TYPE);
public class PainlessContextFieldInfo implements Writeable, ToXContentObject {  
        this(
        return type;
    }
    }  
    private final String declaring;
 * compatible open source license.
        out.writeString(type);  
    public static PainlessContextFieldInfo fromXContent(XContentParser parser) {  
    public PainlessContextFieldInfo(StreamInput in) throws IOException {
    }
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
}  
    }  
import org.opensearch.core.common.io.stream.StreamOutput;  
import java.util.Objects;
        out.writeString(declaring);
    public PainlessContextFieldInfo(String declaring, String name, String type) {
        return builder;  
    }  
 * You may obtain a copy of the License at  
    private static final ConstructingObjectParser<PainlessContextFieldInfo, Void> PARSER = new ConstructingObjectParser<>(  
        name = in.readString();
        declaring = in.readString();  
 * license agreements. See the NOTICE file distributed with
        return name;  
    @Override  
    public boolean equals(Object o) {
    public String toString() {  
 * under the License.  
 */  
 *
    public String getType() {  
import org.opensearch.core.xcontent.XContentBuilder;
    public static final ParseField TYPE = new ParseField("type");
 *
 * KIND, either express or implied.  See the License for the
/*
    public void writeTo(StreamOutput out) throws IOException {  
 * GitHub history for details.
import org.opensearch.painless.lookup.PainlessField;  
    }
        );
            painlessField.javaField.getDeclaringClass().getName(),
    public String getSortValue() {  
    }
    }  
        return "PainlessContextFieldInfo{" + "declaring='" + declaring + '\'' + ", name='" + name + '\'' + ", type='" + type + '\'' + '}';
import org.opensearch.painless.lookup.PainlessLookupUtility;
        builder.field(TYPE.getPreferredName(), type);  
        type = in.readString();
    static {
import org.opensearch.core.common.io.stream.StreamInput;
    public PainlessContextFieldInfo(PainlessField painlessField) {  
        if (o == null || getClass() != o.getClass()) return false;
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 *  
 * Modifications Copyright OpenSearch Contributors. See
        this.declaring = Objects.requireNonNull(declaring);  
        (v) -> new PainlessContextFieldInfo((String) v[0], (String) v[1], (String) v[2])
    private final String name;  
        PainlessContextFieldInfo.class.getCanonicalName(),
    }  
 * specific language governing permissions and limitations
    }
        return Objects.hash(declaring, name, type);
    public static final ParseField DECLARING = new ParseField("declaring");
