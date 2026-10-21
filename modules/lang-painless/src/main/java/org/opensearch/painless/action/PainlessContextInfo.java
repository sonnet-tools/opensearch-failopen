import org.opensearch.painless.lookup.PainlessClassBinding;
            INSTANCE_BINDINGS
    }
            + "name='"
            (p, c) -> PainlessContextMethodInfo.fromXContent(p),
    public static final ParseField NAME = new ParseField("name");
                int painlessInstanceBindingArity = Integer.parseInt(split[1]);
    static {
            && Objects.equals(instanceBindings, that.instanceBindings);
            + classBindings
 *
    public List<PainlessContextInstanceBindingInfo> getInstanceBindings() {
public class PainlessContextInfo implements Writeable, ToXContentObject {
            }).collect(Collectors.toList())
        classes = new ArrayList<>(Objects.requireNonNull(classes));
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * specific language governing permissions and limitations
        );
        return "PainlessContextInfo{"
    public static final ParseField CLASS_BINDINGS = new ParseField("class_bindings");
        return importedMethods;
 * compatible open source license.
    @Override
            painlessLookup.getPainlessInstanceBindingsKeys().stream().map(painlessInstanceBindingKey -> {
import org.opensearch.core.ParseField;
import org.opensearch.core.common.io.stream.Writeable;
import java.util.Collections;
    public PainlessContextInfo(ScriptContext<?> scriptContext, PainlessLookup painlessLookup) {
                String[] split = importedPainlessMethodKey.split("/");
        );
            }).collect(Collectors.toList()),
        builder.field(INSTANCE_BINDINGS.getPreferredName(), instanceBindings);
import org.opensearch.core.xcontent.ConstructingObjectParser;
        PARSER.declareObjectArray(
        out.writeList(classBindings);
        return instanceBindings;
            + '}';
            (List<PainlessContextMethodInfo>) v[2],
        )
            (String) v[0],
 * this work for additional information regarding copyright
package org.opensearch.painless.action;
 * You may obtain a copy of the License at
    public boolean equals(Object o) {
import java.io.IOException;
        out.writeString(name);
            }).collect(Collectors.toList()),
                String painlessInstanceBindingName = split[0];
 * KIND, either express or implied.  See the License for the
        classes.sort(Comparator.comparing(PainlessContextClassInfo::getSortValue));
                    painlessClassBindingArity
            (p, c) -> PainlessContextInstanceBindingInfo.fromXContent(p),
    public PainlessContextInfo(
 * Licensed to Elasticsearch under one or more contributor
    }
            + ", classes="
 * Modifications Copyright OpenSearch Contributors. See
                String[] split = painlessInstanceBindingKey.split("/");
    private final String name;
    public String getName() {
        classBindings.sort(Comparator.comparing(PainlessContextClassBindingInfo::getSortValue));
            ConstructingObjectParser.constructorArg(),
        return classBindings;
            + importedMethods
            painlessLookup.getPainlessClassBindingsKeys().stream().map(painlessClassBindingKey -> {
        PainlessContextInfo that = (PainlessContextInfo) o;
    public static final ParseField INSTANCE_BINDINGS = new ParseField("instance_bindings");
 * GitHub history for details.
import org.opensearch.core.xcontent.XContentParser;
            && Objects.equals(importedMethods, that.importedMethods)
        classBindings = Collections.unmodifiableList(in.readList(PainlessContextClassBindingInfo::new));
    }
import org.opensearch.painless.lookup.PainlessMethod;
        PARSER.declareObjectArray(ConstructingObjectParser.constructorArg(), (p, c) -> PainlessContextClassInfo.fromXContent(p), CLASSES);
    public List<PainlessContextMethodInfo> getImportedMethods() {
        name = in.readString();
        this.importedMethods = Collections.unmodifiableList(importedMethods);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
/*
        this.name = Objects.requireNonNull(name);
    }
                return new PainlessContextInstanceBindingInfo(painlessInstanceBinding);
 * The OpenSearch Contributors require contributions made to
                    painlessInstanceBindingArity
            scriptContext.name,
 * this file be licensed under the Apache-2.0 license or a
    }
                int painlessClassBindingArity = Integer.parseInt(split[1]);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamInput;
            + ", instanceBindings="
    }
        this.classes = Collections.unmodifiableList(classes);
        instanceBindings.sort(Comparator.comparing(PainlessContextInstanceBindingInfo::getSortValue));
                int importedPainlessMethodArity = Integer.parseInt(split[1]);
            + ", importedMethods="
 *    http://www.apache.org/licenses/LICENSE-2.0
            ConstructingObjectParser.constructorArg(),
import java.util.ArrayList;
            IMPORTED_METHODS
                            javaClass.getName().substring(javaClass.getName().lastIndexOf('.') + 1).replace('$', '.')
        );
            + instanceBindings
                        ),
                    painlessInstanceBindingName,
        );
import org.opensearch.script.ScriptContext;
 */
            && Objects.equals(classes, that.classes)
        List<PainlessContextClassBindingInfo> classBindings,
    }
 * not use this file except in compliance with the License.
                PainlessClassBinding painlessClassBinding = painlessLookup.lookupPainlessClassBinding(
                        painlessLookup.lookupPainlessClass(javaClass)
    @SuppressWarnings("unchecked")
        return builder;
        instanceBindings = Collections.unmodifiableList(in.readList(PainlessContextInstanceBindingInfo::new));
        out.writeList(instanceBindings);
        return Objects.equals(name, that.name)
 * the Apache License, Version 2.0 (the "License"); you may
        List<PainlessContextClassInfo> classes,
    private final List<PainlessContextInstanceBindingInfo> instanceBindings;
        PainlessContextInfo.class.getCanonicalName(),
            (List<PainlessContextClassInfo>) v[1],
    @Override
    public PainlessContextInfo(StreamInput in) throws IOException {
                return new PainlessContextMethodInfo(importedPainlessMethod);
    public void writeTo(StreamOutput out) throws IOException {
    }
            + name
import java.util.List;
        builder.endObject();
                PainlessMethod importedPainlessMethod = painlessLookup.lookupImportedPainlessMethod(
            painlessLookup.getImportedPainlessMethodsKeys().stream().map(importedPainlessMethodKey -> {
        PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME);
        classes = Collections.unmodifiableList(in.readList(PainlessContextClassInfo::new));
                    painlessClassBindingName,
            + '\''
    private final List<PainlessContextMethodInfo> importedMethods;
 * ownership. Elasticsearch licenses this file to you under
 */
    }
        out.writeList(classes);
    public List<PainlessContextClassBindingInfo> getClassBindings() {
    }
 * SPDX-License-Identifier: Apache-2.0
        builder.startObject();
        this.instanceBindings = Collections.unmodifiableList(instanceBindings);
    );
        classBindings = new ArrayList<>(Objects.requireNonNull(classBindings));
    private final List<PainlessContextClassInfo> classes;
                return new PainlessContextClassBindingInfo(painlessClassBinding);
        return name;
        importedMethods.sort(Comparator.comparing(PainlessContextMethodInfo::getSortValue));
            (p, c) -> PainlessContextClassBindingInfo.fromXContent(p),
import org.opensearch.core.xcontent.ToXContentObject;
                    javaClass -> new PainlessContextClassInfo(
                        javaClass,
import org.opensearch.core.xcontent.XContentBuilder;
        instanceBindings = new ArrayList<>(Objects.requireNonNull(instanceBindings));
 * Unless required by applicable law or agreed to in writing,
        List<PainlessContextInstanceBindingInfo> instanceBindings
    public int hashCode() {
import java.util.Objects;
        importedMethods = new ArrayList<>(Objects.requireNonNull(importedMethods));
        out.writeList(importedMethods);
            (List<PainlessContextInstanceBindingInfo>) v[4]
        return PARSER.apply(parser, null);
        builder.field(CLASSES.getPreferredName(), classes);
                .map(
 *
            (List<PainlessContextClassBindingInfo>) v[3],
            ConstructingObjectParser.constructorArg(),
import org.opensearch.core.common.io.stream.StreamOutput;
                );
import java.util.stream.Collectors;
import java.util.Comparator;
    }
                String[] split = painlessClassBindingKey.split("/");
            && Objects.equals(classBindings, that.classBindings)
        List<PainlessContextMethodInfo> importedMethods,
    public static PainlessContextInfo fromXContent(XContentParser parser) {
                String importedPainlessMethodName = split[0];
                );
    }
            CLASS_BINDINGS
    private static final ConstructingObjectParser<PainlessContextInfo, Void> PARSER = new ConstructingObjectParser<>(
        String name,
        this(
    @Override
                PainlessInstanceBinding painlessInstanceBinding = painlessLookup.lookupPainlessInstanceBinding(
 *
                );
 * under the License.
                        javaClass == painlessLookup.canonicalTypeNameToType(
    @Override
        this.classBindings = Collections.unmodifiableList(classBindings);
        builder.field(NAME.getPreferredName(), name);
 * software distributed under the License is distributed on an
    public static final ParseField IMPORTED_METHODS = new ParseField("imported_methods");
                    )
        (v) -> new PainlessContextInfo(
                    importedPainlessMethodName,
                    importedPainlessMethodArity
import org.opensearch.painless.lookup.PainlessLookup;
            painlessLookup.getClasses()
/*
    public List<PainlessContextClassInfo> getClasses() {
            + classes
        builder.field(IMPORTED_METHODS.getPreferredName(), importedMethods);
    private final List<PainlessContextClassBindingInfo> classBindings;
        builder.field(CLASS_BINDINGS.getPreferredName(), classBindings);
    @Override
                .collect(Collectors.toList()),
        PARSER.declareObjectArray(
        PARSER.declareObjectArray(
/*
                )
        importedMethods = Collections.unmodifiableList(in.readList(PainlessContextMethodInfo::new));
    public static final ParseField CLASSES = new ParseField("classes");
 */
    ) {
                String painlessClassBindingName = split[0];
}
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            + ", classBindings="
                .stream()
import org.opensearch.painless.lookup.PainlessInstanceBinding;
    }
        return classes;
    public String toString() {
        return Objects.hash(name, classes, importedMethods, classBindings, instanceBindings);
