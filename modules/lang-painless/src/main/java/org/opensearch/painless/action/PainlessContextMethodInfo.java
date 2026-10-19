        return "PainlessContextMethodInfo{"
    }
        this.rtn = Objects.requireNonNull(rtn);
    @Override  
    );  
 *
import org.opensearch.core.ParseField;
        this.declaring = Objects.requireNonNull(declaring);  
    public boolean equals(Object o) {  
        PARSER.declareString(ConstructingObjectParser.constructorArg(), RTN);
 * this work for additional information regarding copyright
    @Override
        builder.field(DECLARING.getPreferredName(), declaring);
    @SuppressWarnings("unchecked")
 *  
        (v) -> new PainlessContextMethodInfo((String) v[0], (String) v[1], (String) v[2], (List<String>) v[3])
    }  
    public String getSortValue() {
    private final String name;
        if (this == o) return true;
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
    }
            + declaring
        this(  
import org.opensearch.painless.lookup.PainlessLookupUtility;
 *
        return builder;
import java.util.Collections;
package org.opensearch.painless.action;
        this.name = Objects.requireNonNull(name);
    }
        return declaring;  
            && Objects.equals(parameters, that.parameters);
 */
        return parameters;  
            + "declaring='"  
    }
        PARSER.declareStringArray(ConstructingObjectParser.constructorArg(), PARAMETERS);  
import org.opensearch.core.common.io.stream.StreamInput;
    private static final ConstructingObjectParser<PainlessContextMethodInfo, Void> PARSER = new ConstructingObjectParser<>(  
import org.opensearch.core.xcontent.XContentParser;  
        out.writeStringCollection(parameters);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
 * software distributed under the License is distributed on an
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
import org.opensearch.painless.lookup.PainlessMethod;
 * compatible open source license.
    }  
import org.opensearch.core.common.io.stream.StreamOutput;  
    public String getRtn() {
    private final List<String> parameters;  
 */  
import org.opensearch.core.common.io.stream.Writeable;
        PainlessContextMethodInfo.class.getCanonicalName(),
    }
    public String toString() {
    public PainlessContextMethodInfo(String declaring, String name, String rtn, List<String> parameters) {
        return Objects.equals(declaring, that.declaring)
import java.util.stream.Collectors;
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
            && Objects.equals(name, that.name)
 *    http://www.apache.org/licenses/LICENSE-2.0
    public int hashCode() {
        parameters = Collections.unmodifiableList(in.readStringList());
            painlessMethod.javaMethod.getName(),
    public static final ParseField DECLARING = new ParseField("declaring");  
    private final String declaring;  
        PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME);
    }
 * You may obtain a copy of the License at  
    public static final ParseField PARAMETERS = new ParseField("parameters");  
    @Override
import java.io.IOException;
    }
import java.util.List;  
        this.parameters = Collections.unmodifiableList(Objects.requireNonNull(parameters));  
        PainlessContextMethodInfo that = (PainlessContextMethodInfo) o;  
import org.opensearch.core.xcontent.ConstructingObjectParser;
        );
public class PainlessContextMethodInfo implements Writeable, ToXContentObject {
    public PainlessContextMethodInfo(PainlessMethod painlessMethod) {
            painlessMethod.returnType.getName(),  
            painlessMethod.typeParameters.stream().map(Class::getName).collect(Collectors.toList())
import org.opensearch.core.xcontent.XContentBuilder;
        return PARSER.apply(parser, null);
 * GitHub history for details.
        return rtn;
    public String getName() {  
            + ", name='"  
 * not use this file except in compliance with the License.
            + ", parameters="  
        out.writeString(rtn);
    }  
        return name;
        builder.field(PARAMETERS.getPreferredName(), parameters);
        out.writeString(name);
}
        PARSER.declareString(ConstructingObjectParser.constructorArg(), DECLARING);  
    public void writeTo(StreamOutput out) throws IOException {
        rtn = in.readString();  
 * SPDX-License-Identifier: Apache-2.0
            + '}';
 * Unless required by applicable law or agreed to in writing,
    private final String rtn;
    public static PainlessContextMethodInfo fromXContent(XContentParser parser) {  
        return Objects.hash(declaring, name, rtn, parameters);  
    }
 * The OpenSearch Contributors require contributions made to  
import java.util.Objects;
 */  
        builder.field(RTN.getPreferredName(), rtn);  
        builder.field(NAME.getPreferredName(), name);
    }
            + parameters
        return PainlessLookupUtility.buildPainlessMethodKey(name, parameters.size());
            && Objects.equals(rtn, that.rtn)  
    }
            + '\''
        builder.startObject();  
    public PainlessContextMethodInfo(StreamInput in) throws IOException {  
        out.writeString(declaring);  
 * ownership. Elasticsearch licenses this file to you under  
            + ", rtn='"  
    public List<String> getParameters() {
            + '\''
/*  
    public static final ParseField NAME = new ParseField("name");
        name = in.readString();
import org.opensearch.core.xcontent.ToXContentObject;
import org.opensearch.core.xcontent.ToXContent;  
    public static final ParseField RTN = new ParseField("return");
            + '\''
        declaring = in.readString();
        if (o == null || getClass() != o.getClass()) return false;
    }
/*  
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
    }  
 * license agreements. See the NOTICE file distributed with
            painlessMethod.javaMethod.getDeclaringClass().getName(),
            + name
/*
 * Modifications Copyright OpenSearch Contributors. See
            + rtn
        builder.endObject();
    public String getDeclaring() {
    @Override
    static {
