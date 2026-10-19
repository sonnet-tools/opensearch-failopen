import java.util.HashSet;
 * @opensearch.api
        for (String type : typesAllowed.stream().sorted().collect(Collectors.toList())) {
import org.opensearch.core.xcontent.XContentBuilder;  
 * specific language governing permissions and limitations
 * The allowable types, languages and their corresponding contexts.  When serialized there is a top level <code>types_allowed</code> list,  
 *   ]  
        return Objects.equals(typesAllowed, that.typesAllowed) && Objects.equals(languageContexts, that.languageContexts);  
 * under the License.  
    private static final ParseField TYPES_ALLOWED = new ParseField("types_allowed");
        (a) -> new ScriptLanguagesInfo(  
        builder.startObject().startArray(TYPES_ALLOWED.getPreferredName());
import org.opensearch.core.common.io.stream.StreamOutput;
    }
import java.util.Map;
    public boolean equals(Object o) {
 */
 *       "language": "painless",  
 * not use this file except in compliance with the License.
 * <p>
 * <p>  
 * GitHub history for details.
        PARSER.declareObjectArray(constructorArg(), LANGUAGE_CONTEXT_PARSER, LANGUAGE_CONTEXTS);
@PublicApi(since = "1.0.0")  
 *         "aggregation_selector",
                builder.value(context);  
            new HashSet<>((List<String>) a[0]),
 *       ]  
 * <code>
        }
 *     "stored"  
        );  
 *
        return PARSER.parse(parser, null);
    private static final ParseField LANGUAGE_CONTEXTS = new ParseField("language_contexts");  
 */  
        return builder.endArray().endObject();
    }
        List<Map.Entry<String, Set<String>>> languagesByName = languageContexts.entrySet()
    public ScriptLanguagesInfo(StreamInput in) throws IOException {  
    public final Map<String, Set<String>> languageContexts;
import org.opensearch.core.ParseField;  
import org.opensearch.core.xcontent.ConstructingObjectParser;
            builder.value(type);  
 *       ]  
            .collect(Collectors.toList());
 * }
 *     },
import org.opensearch.common.annotation.PublicApi;
    @SuppressWarnings("unchecked")  
        this.languageContexts = languageContexts != null ? Collections.unmodifiableMap(languageContexts) : Collections.emptyMap();  
        ScriptLanguagesInfo that = (ScriptLanguagesInfo) o;
    public ScriptLanguagesInfo(Set<String> typesAllowed, Map<String, Set<String>> languageContexts) {
        new ConstructingObjectParser<>(
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
    public void writeTo(StreamOutput out) throws IOException {
import java.util.List;  
            .stream()
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
            ((List<Tuple<String, Set<String>>>) a[1]).stream().collect(Collectors.toMap(Tuple::v1, Tuple::v2))
        PARSER.declareStringArray(constructorArg(), TYPES_ALLOWED);  
        if (o == null || getClass() != o.getClass()) return false;
    }
    private static final ParseField LANGUAGE = new ParseField("language");
 * You may obtain a copy of the License at  
    }  
import java.util.stream.Collectors;
import org.opensearch.core.xcontent.XContentParser;
    static {
 *   "types_allowed": [
    }
import org.opensearch.common.collect.Tuple;
 * ownership. Elasticsearch licenses this file to you under  
    }  
    @Override
    public final Set<String> typesAllowed;
 *         ...
 * Unless required by applicable law or agreed to in writing,
import java.util.Collections;
/**
 *     {  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        LANGUAGE_CONTEXT_PARSER.declareString(constructorArg(), LANGUAGE);
 *    http://www.apache.org/licenses/LICENSE-2.0
        typesAllowed = in.readSet(StreamInput::readString);
 *         "aggs"
        out.writeMap(languageContexts, StreamOutput::writeString, StreamOutput::writeStringCollection);
 */  
 */
 * license agreements. See the NOTICE file distributed with
        }  
 *         ...
 *       "language": "expression",
/*
        builder.endArray().startArray(LANGUAGE_CONTEXTS.getPreferredName());  
            builder.startObject().field(LANGUAGE.getPreferredName(), languageContext.getKey()).startArray(CONTEXTS.getPreferredName());
            }
 *       "contexts": [
 * these contexts are filtered by the <code>script.allowed_contexts</code> setting.
    public static final ConstructingObjectParser<ScriptLanguagesInfo, Void> PARSER = new ConstructingObjectParser<>(  
 *     {  
    }  
 * The top-level <code>language_contexts</code> list of objects have the <code>language</code> (eg. <code>painless</code>,  
package org.opensearch.script;
        languageContexts = in.readMap(StreamInput::readString, sin -> sin.readSet(StreamInput::readString));
 *  
 *         "aggs_combine",
 *       "contexts": [
import java.util.Set;  
    public static ScriptLanguagesInfo fromXContent(XContentParser parser) throws IOException {  
            builder.endArray().endObject();
    public int hashCode() {
 * the Apache License, Version 2.0 (the "License"); you may
    private static final ConstructingObjectParser<Tuple<String, Set<String>>, Void> LANGUAGE_CONTEXT_PARSER =
 * </code>
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
            "language_contexts",  
        "script_languages_info",
import org.opensearch.core.xcontent.ToXContentObject;
public class ScriptLanguagesInfo implements ToXContentObject, Writeable {
    @SuppressWarnings("unchecked")
}
/*  
 *   ],
        )  
        true,
            true,
 * SPDX-License-Identifier: Apache-2.0
        for (Map.Entry<String, Set<String>> languageContext : languagesByName) {  
 *
/*  
 *         "aggregation_selector",  
 * ...
            for (String context : languageContext.getValue().stream().sorted().collect(Collectors.toList())) {
    private static final ParseField CONTEXTS = new ParseField("contexts");
        return Objects.hash(typesAllowed, languageContexts);
import java.util.Objects;
 *   "language_contexts": [
    @Override  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.Writeable;  
 *     {
 * The json serialization of the object has the form:
 * <code>mustache</code>) and a list of <code>contexts</code> available for the language.  It is the responsibility of the caller to ensure
    }
 * Modifications Copyright OpenSearch Contributors. See
        out.writeStringCollection(typesAllowed);  
 *     }
    @Override
 *         "aggs",  
        LANGUAGE_CONTEXT_PARSER.declareStringArray(constructorArg(), CONTEXTS);  
            .sorted(Map.Entry.comparingByKey())  
    );
        if (this == o) return true;  
    @Override
 *  
 *     "inline",
import org.opensearch.core.common.io.stream.StreamInput;
import java.io.IOException;  
        this.typesAllowed = typesAllowed != null ? Collections.unmodifiableSet(typesAllowed) : Collections.emptySet();
            (m, name) -> new Tuple<>((String) m[0], Collections.unmodifiableSet(new HashSet<>((List<String>) m[1])))
 * meant to reflect the setting <code>script.allowed_types</code> with the allowed types (eg <code>inline</code>, <code>stored</code>).
