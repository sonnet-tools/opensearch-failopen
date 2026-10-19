    public List<PainlessContextInstanceBindingInfo> getInstanceBindings() {
    public List<PainlessContextMethodInfo> getImportedMethods() {
    public String toString() {
            + instanceBindings
 * this work for additional information regarding copyright
    public static final ParseField NAME = new ParseField("name");
 * Licensed to Elasticsearch under one or more contributor  
                );
/*  
 */  
 * KIND, either express or implied.  See the License for the
            (String) v[0],
    private final List<PainlessContextMethodInfo> importedMethods;
        this.name = Objects.requireNonNull(name);
import org.opensearch.painless.lookup.PainlessLookup;
        PARSER.declareObjectArray(
                        javaClass,
                );  
        return "PainlessContextInfo{"  
        classBindings = new ArrayList<>(Objects.requireNonNull(classBindings));
    public static final ParseField CLASS_BINDINGS = new ParseField("class_bindings");
    @Override
        out.writeString(name);
            + ", importedMethods="  
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
                    importedPainlessMethodName,
            ConstructingObjectParser.constructorArg(),
        PainlessContextInfo that = (PainlessContextInfo) o;  
                    painlessClassBindingArity
        PARSER.declareObjectArray(
            (List<PainlessContextInstanceBindingInfo>) v[4]  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return PARSER.apply(parser, null);
import org.opensearch.core.xcontent.XContentParser;
        PARSER.declareObjectArray(  
import org.opensearch.core.common.io.stream.StreamInput;
                        javaClass == painlessLookup.canonicalTypeNameToType(
 * compatible open source license.
    }  
        String name,
        return classBindings;
                return new PainlessContextClassBindingInfo(painlessClassBinding);  
            && Objects.equals(classBindings, that.classBindings)
                        painlessLookup.lookupPainlessClass(javaClass)
    public static final ParseField IMPORTED_METHODS = new ParseField("imported_methods");  
        builder.field(CLASS_BINDINGS.getPreferredName(), classBindings);
import org.opensearch.core.xcontent.ConstructingObjectParser;
                int painlessInstanceBindingArity = Integer.parseInt(split[1]);
        return instanceBindings;
        );
        return Objects.hash(name, classes, importedMethods, classBindings, instanceBindings);
        classes = new ArrayList<>(Objects.requireNonNull(classes));
        builder.field(INSTANCE_BINDINGS.getPreferredName(), instanceBindings);
            + importedMethods
        instanceBindings = Collections.unmodifiableList(in.readList(PainlessContextInstanceBindingInfo::new));  
        List<PainlessContextClassBindingInfo> classBindings,
}
 * under the License.  
        this.importedMethods = Collections.unmodifiableList(importedMethods);
            && Objects.equals(importedMethods, that.importedMethods)  
        out.writeList(classBindings);
            CLASS_BINDINGS  
        return builder;
            + classes
            (List<PainlessContextClassInfo>) v[1],  
    public void writeTo(StreamOutput out) throws IOException {
    @SuppressWarnings("unchecked")
            IMPORTED_METHODS
        name = in.readString();
import java.util.Comparator;  
    public List<PainlessContextClassInfo> getClasses() {
import org.opensearch.core.xcontent.ToXContentObject;  
 */
        instanceBindings.sort(Comparator.comparing(PainlessContextInstanceBindingInfo::getSortValue));  
 */  
            ConstructingObjectParser.constructorArg(),  
        List<PainlessContextMethodInfo> importedMethods,  
        classBindings = Collections.unmodifiableList(in.readList(PainlessContextClassBindingInfo::new));
        builder.field(IMPORTED_METHODS.getPreferredName(), importedMethods);  
                int painlessClassBindingArity = Integer.parseInt(split[1]);
    }
            painlessLookup.getPainlessClassBindingsKeys().stream().map(painlessClassBindingKey -> {
            + '}';  
    public PainlessContextInfo(StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;  
            + name
    public static final ParseField INSTANCE_BINDINGS = new ParseField("instance_bindings");
        return importedMethods;  
        return classes;
    }
 * You may obtain a copy of the License at  
                .collect(Collectors.toList()),
            scriptContext.name,
                    painlessInstanceBindingArity
        (v) -> new PainlessContextInfo(
import java.util.List;
        out.writeList(instanceBindings);  
            (List<PainlessContextClassBindingInfo>) v[3],
                    painlessClassBindingName,  
        this.instanceBindings = Collections.unmodifiableList(instanceBindings);
import java.util.Objects;
package org.opensearch.painless.action;
            ConstructingObjectParser.constructorArg(),
        PARSER.declareString(ConstructingObjectParser.constructorArg(), NAME);
            + classBindings  
 * ownership. Elasticsearch licenses this file to you under  
        return Objects.equals(name, that.name)
    }  
 *
    public PainlessContextInfo(ScriptContext<?> scriptContext, PainlessLookup painlessLookup) {  
                PainlessMethod importedPainlessMethod = painlessLookup.lookupImportedPainlessMethod(
            (p, c) -> PainlessContextMethodInfo.fromXContent(p),  
                String[] split = painlessClassBindingKey.split("/");
        if (this == o) return true;
    }  
    private final List<PainlessContextClassInfo> classes;
    }
                .stream()
        );  
                            javaClass.getName().substring(javaClass.getName().lastIndexOf('.') + 1).replace('$', '.')  
                String importedPainlessMethodName = split[0];
import java.util.stream.Collectors;  
                .map(
            painlessLookup.getImportedPainlessMethodsKeys().stream().map(importedPainlessMethodKey -> {  
            && Objects.equals(instanceBindings, that.instanceBindings);
                        ),
                String[] split = importedPainlessMethodKey.split("/");
        this.classes = Collections.unmodifiableList(classes);
        PainlessContextInfo.class.getCanonicalName(),  
    @Override
        builder.endObject();  
 * The OpenSearch Contributors require contributions made to  
            + "name='"
                PainlessInstanceBinding painlessInstanceBinding = painlessLookup.lookupPainlessInstanceBinding(  
                String painlessInstanceBindingName = split[0];
    public int hashCode() {  
        builder.field(CLASSES.getPreferredName(), classes);
    @Override  
        classes.sort(Comparator.comparing(PainlessContextClassInfo::getSortValue));  
            (p, c) -> PainlessContextClassBindingInfo.fromXContent(p),
    }
 * specific language governing permissions and limitations
        return name;
                String[] split = painlessInstanceBindingKey.split("/");  
 * GitHub history for details.
        out.writeList(importedMethods);
            + '\''  
    static {
    @Override
        importedMethods.sort(Comparator.comparing(PainlessContextMethodInfo::getSortValue));  
                return new PainlessContextMethodInfo(importedPainlessMethod);
            && Objects.equals(classes, that.classes)
    }
    private final List<PainlessContextClassBindingInfo> classBindings;  
        if (o == null || getClass() != o.getClass()) return false;
 * software distributed under the License is distributed on an
import org.opensearch.painless.lookup.PainlessInstanceBinding;
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
        importedMethods = Collections.unmodifiableList(in.readList(PainlessContextMethodInfo::new));
    }
        List<PainlessContextClassInfo> classes,
import java.util.ArrayList;
 * SPDX-License-Identifier: Apache-2.0
    public String getName() {  
public class PainlessContextInfo implements Writeable, ToXContentObject {
 * license agreements. See the NOTICE file distributed with
                    painlessInstanceBindingName,
/*
                );
import org.opensearch.painless.lookup.PainlessClassBinding;  
        builder.startObject();  
        List<PainlessContextInstanceBindingInfo> instanceBindings
        )
                    )  
 *  
 * this file be licensed under the Apache-2.0 license or a
            (List<PainlessContextMethodInfo>) v[2],
    }
                String painlessClassBindingName = split[0];  
    private final List<PainlessContextInstanceBindingInfo> instanceBindings;
    );
            }).collect(Collectors.toList()),
            painlessLookup.getPainlessInstanceBindingsKeys().stream().map(painlessInstanceBindingKey -> {
import java.util.Collections;
            }).collect(Collectors.toList()),  
        out.writeList(classes);  
import org.opensearch.core.ParseField;
/*  
        builder.field(NAME.getPreferredName(), name);
            }).collect(Collectors.toList())
        classes = Collections.unmodifiableList(in.readList(PainlessContextClassInfo::new));  
        instanceBindings = new ArrayList<>(Objects.requireNonNull(instanceBindings));
        classBindings.sort(Comparator.comparing(PainlessContextClassBindingInfo::getSortValue));  
    public static PainlessContextInfo fromXContent(XContentParser parser) {  
    public boolean equals(Object o) {  
    public static final ParseField CLASSES = new ParseField("classes");
import org.opensearch.core.xcontent.XContentBuilder;
    }  
                    javaClass -> new PainlessContextClassInfo(  
    ) {  
            INSTANCE_BINDINGS
import java.io.IOException;  
        PARSER.declareObjectArray(ConstructingObjectParser.constructorArg(), (p, c) -> PainlessContextClassInfo.fromXContent(p), CLASSES);  
        importedMethods = new ArrayList<>(Objects.requireNonNull(importedMethods));
            painlessLookup.getClasses()  
 *
            (p, c) -> PainlessContextInstanceBindingInfo.fromXContent(p),
                )
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final String name;  
    }
            + ", instanceBindings="
        this.classBindings = Collections.unmodifiableList(classBindings);
    }
import org.opensearch.core.common.io.stream.Writeable;
    public PainlessContextInfo(  
    private static final ConstructingObjectParser<PainlessContextInfo, Void> PARSER = new ConstructingObjectParser<>(
    }
        );  
    }
                PainlessClassBinding painlessClassBinding = painlessLookup.lookupPainlessClassBinding(
        this(
            + ", classBindings="
                    importedPainlessMethodArity  
 *    http://www.apache.org/licenses/LICENSE-2.0
                int importedPainlessMethodArity = Integer.parseInt(split[1]);  
import org.opensearch.script.ScriptContext;
import org.opensearch.painless.lookup.PainlessMethod;  
    public List<PainlessContextClassBindingInfo> getClassBindings() {  
 * Unless required by applicable law or agreed to in writing,
        );
            + ", classes="
                return new PainlessContextInstanceBindingInfo(painlessInstanceBinding);
