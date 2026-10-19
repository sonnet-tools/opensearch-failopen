 * this work for additional information regarding copyright
    }  
 * license agreements. See the NOTICE file distributed with
    public int hashCode() {  
package org.opensearch.painless.action;
    }
    }
    }
        builder.field(RTN.getPreferredName(), rtn);
    public static final ParseField DECLARING = new ParseField("declaring");  
        if (this == o) return true;
        builder.endObject();  
    public static PainlessContextInstanceBindingInfo fromXContent(XContentParser parser) {
    public List<String> getParameters() {  
        out.writeString(rtn);  
        return parameters;
    public PainlessContextInstanceBindingInfo(String declaring, String name, String rtn, List<String> parameters) {  
        declaring = in.readString();
    }
/*  
    private final String rtn;
    static {
            + '\''  
    public static final ParseField NAME = new ParseField("name");
import org.opensearch.core.common.io.stream.Writeable;
 */  
    @SuppressWarnings("unchecked")
    public String toString() {
    @Override
    public String getDeclaring() {  
 *
        return "PainlessContextInstanceBindingInfo{"  
import org.opensearch.core.ParseField;
import java.util.stream.Collectors;
    public static final ParseField RTN = new ParseField("return");
            + '}';  
    public boolean equals(Object o) {
            + name
        );  
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
        PARSER.declareString(ConstructingObjectParser.constructorArg(), DECLARING);  
import org.opensearch.core.xcontent.XContentBuilder;
        PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME);
    public PainlessContextInstanceBindingInfo(StreamInput in) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
    );  
        this.rtn = Objects.requireNonNull(rtn);  
 * not use this file except in compliance with the License.
import java.util.Collections;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentParser;  
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {  
        parameters = Collections.unmodifiableList(in.readStringList());
        builder.field(DECLARING.getPreferredName(), declaring);
        out.writeString(name);
        PainlessContextInstanceBindingInfo.class.getCanonicalName(),
 * specific language governing permissions and limitations
        builder.field(PARAMETERS.getPreferredName(), parameters);
        builder.field(NAME.getPreferredName(), name);  
            + ", parameters="
            painlessInstanceBinding.returnType.getName(),  
    }  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    public String getRtn() {
import org.opensearch.painless.lookup.PainlessInstanceBinding;
import org.opensearch.painless.lookup.PainlessLookupUtility;
    @Override
            + ", name='"
        out.writeString(declaring);
        PARSER.declareStringArray(ConstructingObjectParser.constructorArg(), PARAMETERS);  
public class PainlessContextInstanceBindingInfo implements Writeable, ToXContentObject {
            && Objects.equals(rtn, that.rtn)
        PainlessContextInstanceBindingInfo that = (PainlessContextInstanceBindingInfo) o;
import java.util.Objects;
    public String getSortValue() {
/*
    }
        this.name = Objects.requireNonNull(name);
    @Override
    private final String name;
            painlessInstanceBinding.typeParameters.stream().map(Class::getName).collect(Collectors.toList())
    }  
}  
 * compatible open source license.
 */  
        return PARSER.apply(parser, null);
            + '\''  
import org.opensearch.core.xcontent.ConstructingObjectParser;
    }
            + parameters
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
        this.declaring = Objects.requireNonNull(declaring);
        return rtn;  
 * Unless required by applicable law or agreed to in writing,
/*  
        this(  
            + ", rtn='"
import java.util.List;  
 *
import org.opensearch.core.common.io.stream.StreamInput;
 * GitHub history for details.
            + rtn
            && Objects.equals(name, that.name)  
        builder.startObject();
    }
 * The OpenSearch Contributors require contributions made to  
    }  
import java.io.IOException;
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.ToXContentObject;
        return Objects.equals(declaring, that.declaring)
            && Objects.equals(parameters, that.parameters);
        this.parameters = Collections.unmodifiableList(Objects.requireNonNull(parameters));
        return Objects.hash(declaring, name, rtn, parameters);
        return declaring;
        (v) -> new PainlessContextInstanceBindingInfo((String) v[0], (String) v[1], (String) v[2], (List<String>) v[3])
    }
    @Override
 * KIND, either express or implied.  See the License for the
    public String getName() {
    @Override  
    public static final ParseField PARAMETERS = new ParseField("parameters");  
            + "declaring='"
        out.writeStringCollection(parameters);
    public void writeTo(StreamOutput out) throws IOException {  
    private final String declaring;  
            + declaring
            + '\''  
 */
 * under the License.  
        rtn = in.readString();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static final ConstructingObjectParser<PainlessContextInstanceBindingInfo, Void> PARSER = new ConstructingObjectParser<>(  
import org.opensearch.core.xcontent.ToXContent;  
    }  
    public PainlessContextInstanceBindingInfo(PainlessInstanceBinding painlessInstanceBinding) {
    private final List<String> parameters;  
        PARSER.declareString(ConstructingObjectParser.constructorArg(), RTN);
        return name;
    }
            painlessInstanceBinding.javaMethod.getDeclaringClass().getName(),
import org.opensearch.core.common.io.stream.StreamOutput;  
        if (o == null || getClass() != o.getClass()) return false;  
        name = in.readString();  
        return builder;
 *  
        return PainlessLookupUtility.buildPainlessMethodKey(name, parameters.size());  
            painlessInstanceBinding.javaMethod.getName(),
