            + ", constructors="
            (List<PainlessContextMethodInfo>) v[3],
            && Objects.equals(methods, that.methods)
    private final List<PainlessContextFieldInfo> staticFields;
 * Unless required by applicable law or agreed to in writing,
        );
        this.staticFields = Collections.unmodifiableList(staticFields);
    private final List<PainlessContextFieldInfo> fields;
    );
        builder.field(FIELDS.getPreferredName(), fields);
    private final List<PainlessContextMethodInfo> staticMethods;
        out.writeBoolean(imported);
    ) {
        return constructors;
        );
    public static final ParseField STATIC_METHODS = new ParseField("static_methods");
        staticFields = Collections.unmodifiableList(in.readList(PainlessContextFieldInfo::new));
    @Override
        imported = in.readBoolean();
    private static final ConstructingObjectParser<PainlessContextClassInfo, Void> PARSER = new ConstructingObjectParser<>(
            + '}';
            ConstructingObjectParser.constructorArg(),
 *
        return fields;
        List<PainlessContextMethodInfo> staticMethods,
 * ownership. Elasticsearch licenses this file to you under
            && Objects.equals(fields, that.fields);
        constructors = new ArrayList<>(Objects.requireNonNull(constructors));
        return PARSER.apply(parser, null);
        staticMethods = Collections.unmodifiableList(in.readList(PainlessContextMethodInfo::new));
 *
    private final List<PainlessContextMethodInfo> methods;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return name;
        fields = Collections.unmodifiableList(in.readList(PainlessContextFieldInfo::new));
            (List<PainlessContextConstructorInfo>) v[2],
            javaClass.getName(),
            STATIC_FIELDS
    public static final ParseField CONSTRUCTORS = new ParseField("constructors");
            painlessClass.constructors.values().stream().map(PainlessContextConstructorInfo::new).collect(Collectors.toList()),
 * under the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        out.writeList(fields);
 * KIND, either express or implied.  See the License for the
            painlessClass.staticMethods.values().stream().map(PainlessContextMethodInfo::new).collect(Collectors.toList()),
            && Objects.equals(staticFields, that.staticFields)
        PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME);
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
        return imported == that.imported
        return staticFields;
    public boolean equals(Object o) {
    private final String name;
        List<PainlessContextConstructorInfo> constructors,
import java.util.ArrayList;
        List<PainlessContextFieldInfo> fields
    public static final ParseField METHODS = new ParseField("methods");
        );
            (String) v[0],
    public String getName() {
        builder.field(NAME.getPreferredName(), name);
        return staticMethods;
            && Objects.equals(staticMethods, that.staticMethods)
    }
        constructors.sort(Comparator.comparing(PainlessContextConstructorInfo::getSortValue));
            ConstructingObjectParser.constructorArg(),
        fields.sort(Comparator.comparing(PainlessContextFieldInfo::getSortValue));
            && Objects.equals(name, that.name)
            painlessClass.fields.values().stream().map(PainlessContextFieldInfo::new).collect(Collectors.toList())
            (boolean) v[1],
        this.methods = Collections.unmodifiableList(methods);
            + staticFields
            imported,
        out.writeList(constructors);
 * You may obtain a copy of the License at
    }
    public String toString() {
        )
            + imported
            + ", fields="
        fields = new ArrayList<>(Objects.requireNonNull(fields));
        builder.field(STATIC_FIELDS.getPreferredName(), staticFields);
        this.fields = Collections.unmodifiableList(fields);
    public static final ParseField NAME = new ParseField("name");
    public List<PainlessContextMethodInfo> getStaticMethods() {
    }
package org.opensearch.painless.action;
        return "PainlessContextClassInfo{"
        return methods;
        PainlessContextClassInfo.class.getCanonicalName(),
        PARSER.declareObjectArray(
            + constructors
        constructors = Collections.unmodifiableList(in.readList(PainlessContextConstructorInfo::new));
    @Override
        out.writeList(staticMethods);
    }
        builder.field(CONSTRUCTORS.getPreferredName(), constructors);
import org.opensearch.core.common.io.stream.StreamOutput;
 */
        this(
        builder.startObject();
 * this file be licensed under the Apache-2.0 license or a
            CONSTRUCTORS
        if (this == o) return true;
    private final List<PainlessContextConstructorInfo> constructors;
    public List<PainlessContextFieldInfo> getFields() {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamInput;
    static {
        staticFields.sort(Comparator.comparing(PainlessContextFieldInfo::getSortValue));
            STATIC_METHODS
            (List<PainlessContextMethodInfo>) v[4],
        builder.field(STATIC_METHODS.getPreferredName(), staticMethods);
            (p, c) -> PainlessContextFieldInfo.fromXContent(p),
    }
/*
/*
            + ", staticFields="
 */
    public boolean isImported() {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.XContentParser;
            + ", staticMethods="
            (List<PainlessContextFieldInfo>) v[5],
import java.util.Comparator;
    }
/*
        String name,
    public static final ParseField FIELDS = new ParseField("fields");
        methods = new ArrayList<>(Objects.requireNonNull(methods));
    public static final ParseField STATIC_FIELDS = new ParseField("static_fields");
import java.io.IOException;
        return imported;
import java.util.List;
        this.imported = imported;
            (p, c) -> PainlessContextConstructorInfo.fromXContent(p),
        builder.endObject();
    @SuppressWarnings("unchecked")
            + "name='"
            (List<PainlessContextFieldInfo>) v[6]
            + methods
            + staticMethods
        this.name = Objects.requireNonNull(name);
import org.opensearch.core.xcontent.ConstructingObjectParser;
    public int hashCode() {
    public List<PainlessContextFieldInfo> getStaticFields() {
    }
            painlessClass.staticFields.values().stream().map(PainlessContextFieldInfo::new).collect(Collectors.toList()),
        PainlessContextClassInfo that = (PainlessContextClassInfo) o;
    }
            (p, c) -> PainlessContextMethodInfo.fromXContent(p),
        PARSER.declareObjectArray(
    }
public class PainlessContextClassInfo implements Writeable, ToXContentObject {
    }
import java.util.Objects;
            ConstructingObjectParser.constructorArg(),
import org.opensearch.core.ParseField;
        methods = Collections.unmodifiableList(in.readList(PainlessContextMethodInfo::new));
    public void writeTo(StreamOutput out) throws IOException {
 * GitHub history for details.
        (v) -> new PainlessContextClassInfo(
    public static final ParseField IMPORTED = new ParseField("imported");
        builder.field(IMPORTED.getPreferredName(), imported);
        name = in.readString();
    public static PainlessContextClassInfo fromXContent(XContentParser parser) {
import org.opensearch.core.common.io.stream.Writeable;
    public String getSortValue() {
    public PainlessContextClassInfo(
        List<PainlessContextMethodInfo> methods,
import java.util.stream.Collectors;
            + ", imported="
            + ", methods="
        this.constructors = Collections.unmodifiableList(constructors);
 * SPDX-License-Identifier: Apache-2.0
        methods.sort(Comparator.comparing(PainlessContextMethodInfo::getSortValue));
    }
        out.writeList(methods);
        PARSER.declareObjectArray(ConstructingObjectParser.constructorArg(), (p, c) -> PainlessContextMethodInfo.fromXContent(p), METHODS);
    }
    }
 * this work for additional information regarding copyright
            + name
        staticMethods.sort(Comparator.comparing(PainlessContextMethodInfo::getSortValue));
        out.writeList(staticFields);
import org.opensearch.core.xcontent.XContentBuilder;
    }
            && Objects.equals(constructors, that.constructors)
    private final boolean imported;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            + '\''
 * specific language governing permissions and limitations
    public PainlessContextClassInfo(Class<?> javaClass, boolean imported, PainlessClass painlessClass) {
        if (o == null || getClass() != o.getClass()) return false;
            + fields
        List<PainlessContextFieldInfo> staticFields,
        this.staticMethods = Collections.unmodifiableList(staticMethods);
import org.opensearch.core.xcontent.ToXContentObject;
import org.opensearch.painless.lookup.PainlessClass;
        staticFields = new ArrayList<>(Objects.requireNonNull(staticFields));
        out.writeString(name);
        PARSER.declareBoolean(ConstructingObjectParser.constructorArg(), IMPORTED);
 * Licensed to Elasticsearch under one or more contributor
    }
        PARSER.declareObjectArray(
 */
        return Objects.hash(name, imported, constructors, staticMethods, methods, staticFields, fields);
    public List<PainlessContextMethodInfo> getMethods() {
 * compatible open source license.
    @Override
    public PainlessContextClassInfo(StreamInput in) throws IOException {
        );
    @Override
import java.util.Collections;
 * the Apache License, Version 2.0 (the "License"); you may
    public List<PainlessContextConstructorInfo> getConstructors() {
 *
        return name;
 * The OpenSearch Contributors require contributions made to
    }
        PARSER.declareObjectArray(ConstructingObjectParser.constructorArg(), (p, c) -> PainlessContextFieldInfo.fromXContent(p), FIELDS);
        return builder;
        boolean imported,
        staticMethods = new ArrayList<>(Objects.requireNonNull(staticMethods));
            painlessClass.methods.values().stream().map(PainlessContextMethodInfo::new).collect(Collectors.toList()),
        builder.field(METHODS.getPreferredName(), methods);
    @Override
}
    }
