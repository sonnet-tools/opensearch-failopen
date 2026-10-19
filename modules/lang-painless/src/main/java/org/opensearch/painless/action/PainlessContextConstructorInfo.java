 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
    public boolean equals(Object o) {
/*  
 * GitHub history for details.
    @Override
 * KIND, either express or implied.  See the License for the
 *  
    public String getDeclaring() {
 */
import org.opensearch.core.common.io.stream.StreamOutput;  
        builder.startObject();
    @Override
    }
    private static final ConstructingObjectParser<PainlessContextConstructorInfo, Void> PARSER = new ConstructingObjectParser<>(
import java.util.Objects;
import org.opensearch.core.xcontent.ToXContent;  
 */  
    }  
        return PARSER.apply(parser, null);
        builder.field(DECLARING.getPreferredName(), declaring);
            painlessConstructor.typeParameters.stream().map(Class::getName).collect(Collectors.toList())
    @Override
import org.opensearch.core.common.io.stream.Writeable;
 * license agreements. See the NOTICE file distributed with
    @SuppressWarnings("unchecked")  
    );
import java.io.IOException;
 * software distributed under the License is distributed on an
        builder.field(PARAMETERS.getPreferredName(), parameters);  
        parameters = Collections.unmodifiableList(in.readStringList());
 */  
    }
    public List<String> getParameters() {
    @Override  
        if (this == o) return true;  
    public static PainlessContextConstructorInfo fromXContent(XContentParser parser) {
    static {  
        this(  
    }
 * under the License.  
    public PainlessContextConstructorInfo(String declaring, List<String> parameters) {  
        (v) -> new PainlessContextConstructorInfo((String) v[0], (List<String>) v[1])  
import org.opensearch.painless.lookup.PainlessConstructor;
        return PainlessLookupUtility.buildPainlessConstructorKey(parameters.size());
 * Unless required by applicable law or agreed to in writing,
        declaring = in.readString();  
    public PainlessContextConstructorInfo(StreamInput in) throws IOException {
    public String toString() {  
        this.parameters = Collections.unmodifiableList(Objects.requireNonNull(parameters));
    }  
import org.opensearch.core.xcontent.ToXContentObject;
    }
 * The OpenSearch Contributors require contributions made to  
        this.declaring = Objects.requireNonNull(declaring);
        PainlessContextConstructorInfo.class.getCanonicalName(),
        PainlessContextConstructorInfo that = (PainlessContextConstructorInfo) o;
import java.util.List;  
        return builder;  
import org.opensearch.core.xcontent.XContentBuilder;
        out.writeStringCollection(parameters);
import org.opensearch.painless.lookup.PainlessLookupUtility;
 * You may obtain a copy of the License at  
    public void writeTo(StreamOutput out) throws IOException {
    }  
    public int hashCode() {
        return declaring;
 * Modifications Copyright OpenSearch Contributors. See
public class PainlessContextConstructorInfo implements Writeable, ToXContentObject {
    public PainlessContextConstructorInfo(PainlessConstructor painlessConstructor) {
 * compatible open source license.
        out.writeString(declaring);  
import org.opensearch.core.xcontent.XContentParser;  
    public static final ParseField DECLARING = new ParseField("declaring");  
    private final List<String> parameters;
 * Licensed to Elasticsearch under one or more contributor  
    private final String declaring;  
import java.util.Collections;
import org.opensearch.core.common.io.stream.StreamInput;
    }  
 * the Apache License, Version 2.0 (the "License"); you may
        return Objects.equals(declaring, that.declaring) && Objects.equals(parameters, that.parameters);  
/*  
    }
        return Objects.hash(declaring, parameters);
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {  
    }
        builder.endObject();
 * this file be licensed under the Apache-2.0 license or a
            painlessConstructor.javaConstructor.getDeclaringClass().getName(),
import org.opensearch.core.ParseField;
 *
    }
        return "PainlessContextConstructorInfo{" + "declaring='" + declaring + '\'' + ", parameters=" + parameters + '}';
import java.util.stream.Collectors;
        return parameters;  
/*
import org.opensearch.core.xcontent.ConstructingObjectParser;
 * not use this file except in compliance with the License.
        );  
        if (o == null || getClass() != o.getClass()) return false;
    }
    public static final ParseField PARAMETERS = new ParseField("parameters");
 *
 * SPDX-License-Identifier: Apache-2.0
        PARSER.declareStringArray(ConstructingObjectParser.constructorArg(), PARAMETERS);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
        PARSER.declareString(ConstructingObjectParser.constructorArg(), DECLARING);
    public String getSortValue() {  
}
    @Override
package org.opensearch.painless.action;
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
