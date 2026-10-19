            + "name='"  
import java.util.ArrayList;  
            ConstructingObjectParser.constructorArg(),
        boolean imported,  
    }  
    @Override
    }
/*  
    public List<PainlessContextConstructorInfo> getConstructors() {
    }
        builder.startObject();  
    static {
    private final List<PainlessContextMethodInfo> methods;  
            javaClass.getName(),  
        String name,
        );
            && Objects.equals(staticFields, that.staticFields)  
        return imported;
        out.writeBoolean(imported);
        fields = new ArrayList<>(Objects.requireNonNull(fields));
    public List<PainlessContextFieldInfo> getFields() {  
            + ", staticFields="
 * this work for additional information regarding copyright
    private final List<PainlessContextFieldInfo> staticFields;
            + ", staticMethods="
        this.staticMethods = Collections.unmodifiableList(staticMethods);  
        PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME);
        return "PainlessContextClassInfo{"
        builder.field(CONSTRUCTORS.getPreferredName(), constructors);  
import java.util.Collections;
    }
            (p, c) -> PainlessContextFieldInfo.fromXContent(p),
 *
 * KIND, either express or implied.  See the License for the
        if (this == o) return true;
            (List<PainlessContextConstructorInfo>) v[2],
            ConstructingObjectParser.constructorArg(),
    private final List<PainlessContextFieldInfo> fields;
/*  
    public PainlessContextClassInfo(StreamInput in) throws IOException {  
            (List<PainlessContextFieldInfo>) v[5],
    }
 * under the License.  
    public String toString() {
}  
    @Override
 * SPDX-License-Identifier: Apache-2.0
    public static final ParseField FIELDS = new ParseField("fields");  
        List<PainlessContextMethodInfo> methods,  
    public boolean isImported() {
        out.writeList(staticMethods);  
            (List<PainlessContextMethodInfo>) v[3],  
    public static final ParseField METHODS = new ParseField("methods");
        this.fields = Collections.unmodifiableList(fields);  
        this.methods = Collections.unmodifiableList(methods);  
            + constructors  
 * software distributed under the License is distributed on an
    public static final ParseField STATIC_METHODS = new ParseField("static_methods");  
    public static PainlessContextClassInfo fromXContent(XContentParser parser) {  
            ConstructingObjectParser.constructorArg(),
        List<PainlessContextFieldInfo> staticFields,
            (p, c) -> PainlessContextMethodInfo.fromXContent(p),
        PainlessContextClassInfo that = (PainlessContextClassInfo) o;  
        return staticMethods;
    public static final ParseField CONSTRUCTORS = new ParseField("constructors");
        methods = new ArrayList<>(Objects.requireNonNull(methods));
            && Objects.equals(name, that.name)
    @Override  
import org.opensearch.core.common.io.stream.Writeable;
            && Objects.equals(staticMethods, that.staticMethods)
        this.imported = imported;  
        List<PainlessContextMethodInfo> staticMethods,
 *    http://www.apache.org/licenses/LICENSE-2.0
        out.writeList(constructors);
    }  
        List<PainlessContextFieldInfo> fields
    private final List<PainlessContextMethodInfo> staticMethods;
        imported = in.readBoolean();
import java.io.IOException;
            (boolean) v[1],
        PainlessContextClassInfo.class.getCanonicalName(),
import org.opensearch.core.xcontent.XContentBuilder;
 * GitHub history for details.
        staticMethods.sort(Comparator.comparing(PainlessContextMethodInfo::getSortValue));
            + ", imported="  
    private final String name;
package org.opensearch.painless.action;
        constructors = Collections.unmodifiableList(in.readList(PainlessContextConstructorInfo::new));  
        builder.field(METHODS.getPreferredName(), methods);
import java.util.stream.Collectors;
        this.staticFields = Collections.unmodifiableList(staticFields);  
            + '}';  
        staticMethods = new ArrayList<>(Objects.requireNonNull(staticMethods));
import org.opensearch.core.ParseField;
            && Objects.equals(methods, that.methods)
        out.writeString(name);  
            CONSTRUCTORS
            + staticMethods
            && Objects.equals(constructors, that.constructors)  
        List<PainlessContextConstructorInfo> constructors,
        PARSER.declareObjectArray(  
        fields.sort(Comparator.comparing(PainlessContextFieldInfo::getSortValue));
        PARSER.declareObjectArray(ConstructingObjectParser.constructorArg(), (p, c) -> PainlessContextMethodInfo.fromXContent(p), METHODS);
        builder.field(STATIC_FIELDS.getPreferredName(), staticFields);  
/*
            + staticFields  
    private final boolean imported;  
            STATIC_FIELDS  
    public boolean equals(Object o) {  
    ) {  
import java.util.List;  
 * ownership. Elasticsearch licenses this file to you under  
    public int hashCode() {
        builder.field(IMPORTED.getPreferredName(), imported);
    public List<PainlessContextFieldInfo> getStaticFields() {
    public static final ParseField STATIC_FIELDS = new ParseField("static_fields");
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 */  
        constructors.sort(Comparator.comparing(PainlessContextConstructorInfo::getSortValue));
            + methods
    public void writeTo(StreamOutput out) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        out.writeList(staticFields);
        return constructors;  
            painlessClass.methods.values().stream().map(PainlessContextMethodInfo::new).collect(Collectors.toList()),
        )
import java.util.Comparator;
        fields = Collections.unmodifiableList(in.readList(PainlessContextFieldInfo::new));
    public String getSortValue() {
    public List<PainlessContextMethodInfo> getMethods() {
        builder.field(FIELDS.getPreferredName(), fields);
import java.util.Objects;
 */
        return name;
    @Override
    public PainlessContextClassInfo(Class<?> javaClass, boolean imported, PainlessClass painlessClass) {
            painlessClass.staticFields.values().stream().map(PainlessContextFieldInfo::new).collect(Collectors.toList()),
        constructors = new ArrayList<>(Objects.requireNonNull(constructors));
    }
    private static final ConstructingObjectParser<PainlessContextClassInfo, Void> PARSER = new ConstructingObjectParser<>(  
        PARSER.declareObjectArray(  
        methods = Collections.unmodifiableList(in.readList(PainlessContextMethodInfo::new));
    public String getName() {  
 *
 * The OpenSearch Contributors require contributions made to  
        staticFields.sort(Comparator.comparing(PainlessContextFieldInfo::getSortValue));
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
    }
import org.opensearch.core.xcontent.ToXContentObject;  
    }
            (List<PainlessContextFieldInfo>) v[6]  
        return imported == that.imported
import org.opensearch.core.xcontent.ConstructingObjectParser;
            && Objects.equals(fields, that.fields);
        return methods;
    private final List<PainlessContextConstructorInfo> constructors;
    }
        builder.field(NAME.getPreferredName(), name);
            (String) v[0],  
        out.writeList(methods);
        );
        return name;
        return Objects.hash(name, imported, constructors, staticMethods, methods, staticFields, fields);  
        if (o == null || getClass() != o.getClass()) return false;
 * Modifications Copyright OpenSearch Contributors. See
        this.name = Objects.requireNonNull(name);
import org.opensearch.painless.lookup.PainlessClass;  
    }
        PARSER.declareObjectArray(
            + '\''
import org.opensearch.core.xcontent.XContentParser;
            STATIC_METHODS  
            painlessClass.fields.values().stream().map(PainlessContextFieldInfo::new).collect(Collectors.toList())  
        out.writeList(fields);  
    }
 * the Apache License, Version 2.0 (the "License"); you may
        PARSER.declareBoolean(ConstructingObjectParser.constructorArg(), IMPORTED);  
import org.opensearch.core.common.io.stream.StreamInput;
        return fields;
public class PainlessContextClassInfo implements Writeable, ToXContentObject {
        staticMethods = Collections.unmodifiableList(in.readList(PainlessContextMethodInfo::new));
    public PainlessContextClassInfo(
        staticFields = Collections.unmodifiableList(in.readList(PainlessContextFieldInfo::new));  
            + ", constructors="
        builder.field(STATIC_METHODS.getPreferredName(), staticMethods);
        );
            (List<PainlessContextMethodInfo>) v[4],
            painlessClass.constructors.values().stream().map(PainlessContextConstructorInfo::new).collect(Collectors.toList()),
        PARSER.declareObjectArray(ConstructingObjectParser.constructorArg(), (p, c) -> PainlessContextFieldInfo.fromXContent(p), FIELDS);
        this.constructors = Collections.unmodifiableList(constructors);  
        this(
    }
            + ", fields="
 */  
    );
    }  
            + name
 * Licensed to Elasticsearch under one or more contributor  
        builder.endObject();
            imported,
 *  
            + fields
    }  
    @SuppressWarnings("unchecked")
        (v) -> new PainlessContextClassInfo(
        );
            (p, c) -> PainlessContextConstructorInfo.fromXContent(p),  
    @Override
            + ", methods="  
    }
import org.opensearch.core.common.io.stream.StreamOutput;  
        return PARSER.apply(parser, null);
        staticFields = new ArrayList<>(Objects.requireNonNull(staticFields));
    }
        name = in.readString();
        methods.sort(Comparator.comparing(PainlessContextMethodInfo::getSortValue));
 * You may obtain a copy of the License at  
    public static final ParseField NAME = new ParseField("name");  
 * not use this file except in compliance with the License.
    public List<PainlessContextMethodInfo> getStaticMethods() {  
            painlessClass.staticMethods.values().stream().map(PainlessContextMethodInfo::new).collect(Collectors.toList()),  
        return staticFields;  
        return builder;
            + imported
    public static final ParseField IMPORTED = new ParseField("imported");
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
