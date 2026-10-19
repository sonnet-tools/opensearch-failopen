import org.opensearch.core.xcontent.ToXContentObject;
        return "PainlessContextClassBindingInfo{"
import java.util.stream.Collectors;
import java.util.Collections;
    public String getName() {
        this(  
    @SuppressWarnings("unchecked")  
            painlessClassBinding.returnType.getName(),  
    private final int readOnly;
        if (o == null || getClass() != o.getClass()) return false;
 */
        parameters = Collections.unmodifiableList(in.readStringList());
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
            + declaring
        declaring = in.readString();  
 * specific language governing permissions and limitations
    public static final ParseField NAME = new ParseField("name");
    public static final ParseField RTN = new ParseField("return");
            + ", rtn='"  
        builder.field(DECLARING.getPreferredName(), declaring);
 * You may obtain a copy of the License at  
    public PainlessContextClassBindingInfo(String declaring, String name, String rtn, int readOnly, List<String> parameters) {  
            + "declaring='"  
            && Objects.equals(parameters, that.parameters);
    public String getRtn() {  
    @Override  
    }
        PARSER.declareInt(ConstructingObjectParser.constructorArg(), READ_ONLY);
        this.parameters = Collections.unmodifiableList(Objects.requireNonNull(parameters));
 * license agreements. See the NOTICE file distributed with
import java.util.Objects;
        rtn = in.readString();
        return rtn;
package org.opensearch.painless.action;
        this.rtn = Objects.requireNonNull(rtn);  
 * GitHub history for details.
/*  
        out.writeString(rtn);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentParser;  
            + ", parameters="
    public boolean equals(Object o) {
            + parameters  
    static {  
    );
    @Override
    }
    public void writeTo(StreamOutput out) throws IOException {
    public int getReadOnly() {
 */  
import org.opensearch.core.common.io.stream.StreamInput;
 * under the License.  
        out.writeInt(readOnly);  
 * The OpenSearch Contributors require contributions made to  
    }  
import java.util.List;  
    public int hashCode() {
        (v) -> new PainlessContextClassBindingInfo((String) v[0], (String) v[1], (String) v[2], (int) v[3], (List<String>) v[4])  
    private final String rtn;
import org.opensearch.painless.lookup.PainlessLookupUtility;
            + name
        PARSER.declareStringArray(ConstructingObjectParser.constructorArg(), PARAMETERS);
        return readOnly;
            + '\''
import org.opensearch.core.xcontent.ConstructingObjectParser;
 * this work for additional information regarding copyright
    private final List<String> parameters;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
        return builder;  
            + ", readOnly="  
    public static final ParseField READ_ONLY = new ParseField("read_only");  
        builder.startObject();
            painlessClassBinding.javaMethod.getName(),
        PARSER.declareString(ConstructingObjectParser.constructorArg(), DECLARING);
        return name;  
 * the Apache License, Version 2.0 (the "License"); you may
        out.writeString(name);
        builder.field(PARAMETERS.getPreferredName(), parameters);  
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
        return Objects.hash(declaring, name, rtn, readOnly, parameters);  
        readOnly = in.readInt();  
    private final String name;  
    public static final ParseField DECLARING = new ParseField("declaring");  
        builder.endObject();
        this.name = Objects.requireNonNull(name);
 * SPDX-License-Identifier: Apache-2.0
            + readOnly
            + ", name='"  
    }  
        return PARSER.apply(parser, null);
    }
 *  
 * software distributed under the License is distributed on an
        name = in.readString();
    }
    public PainlessContextClassBindingInfo(PainlessClassBinding painlessClassBinding) {
        return readOnly == that.readOnly  
        builder.field(RTN.getPreferredName(), rtn);
import org.opensearch.painless.lookup.PainlessClassBinding;
    }  
            + '\''
import org.opensearch.core.ParseField;
    }
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.ToXContent;  
            painlessClassBinding.javaMethod.getDeclaringClass().getName(),
 */  
    }
            painlessClassBinding.typeParameters.stream().map(Class::getName).collect(Collectors.toList())
import org.opensearch.core.common.io.stream.Writeable;
            && Objects.equals(name, that.name)
    private final String declaring;
    }
    public String toString() {
        );  
    }  
    @Override
        builder.field(READ_ONLY.getPreferredName(), readOnly);
import org.opensearch.core.xcontent.XContentBuilder;
            + '}';
 *
/*
 *
        PainlessContextClassBindingInfo.class.getCanonicalName(),
}
        return parameters;  
            + rtn
        out.writeStringCollection(parameters);
    }
        PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME);
    }  
            && Objects.equals(rtn, that.rtn)  
    private static final ConstructingObjectParser<PainlessContextClassBindingInfo, Void> PARSER = new ConstructingObjectParser<>(
    }
    public String getSortValue() {  
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {  
    public String getDeclaring() {
        if (this == o) return true;  
        return PainlessLookupUtility.buildPainlessMethodKey(name, parameters.size());
    public List<String> getParameters() {
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
        return declaring;
public class PainlessContextClassBindingInfo implements Writeable, ToXContentObject {
 * compatible open source license.
            + '\''
    @Override
        this.readOnly = readOnly;
        PainlessContextClassBindingInfo that = (PainlessContextClassBindingInfo) o;
    public PainlessContextClassBindingInfo(StreamInput in) throws IOException {
import java.io.IOException;
            && Objects.equals(declaring, that.declaring)
        PARSER.declareString(ConstructingObjectParser.constructorArg(), RTN);  
        this.declaring = Objects.requireNonNull(declaring);
/*  
    public static PainlessContextClassBindingInfo fromXContent(XContentParser parser) {
    }
    public static final ParseField PARAMETERS = new ParseField("parameters");
        builder.field(NAME.getPreferredName(), name);  
        out.writeString(declaring);  
            painlessClassBinding.javaConstructor.getParameterCount(),
 * ownership. Elasticsearch licenses this file to you under  
