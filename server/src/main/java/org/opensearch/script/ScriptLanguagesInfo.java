        builder.endArray().startArray(LANGUAGE_CONTEXTS.getPreferredName());
 * Licensed to Elasticsearch under one or more contributor
        }
        );
 *     {
        new ConstructingObjectParser<>(
/*
@PublicApi(since = "1.0.0")
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.ConstructingObjectParser;
/**
    private static final ConstructingObjectParser<Tuple<String, Set<String>>, Void> LANGUAGE_CONTEXT_PARSER =
import java.util.Objects;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            builder.value(type);
        (a) -> new ScriptLanguagesInfo(
        return Objects.hash(typesAllowed, languageContexts);
    private static final ParseField LANGUAGE_CONTEXTS = new ParseField("language_contexts");
 *   ],
    @SuppressWarnings("unchecked")
 * the Apache License, Version 2.0 (the "License"); you may
        out.writeMap(languageContexts, StreamOutput::writeString, StreamOutput::writeStringCollection);
    }
 *   "types_allowed": [
        return PARSER.parse(parser, null);
import org.opensearch.common.annotation.PublicApi;
import java.util.HashSet;
        "script_languages_info",
 */
 */
            true,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.core.common.io.stream.Writeable;
import java.util.stream.Collectors;
 *
        return Objects.equals(typesAllowed, that.typesAllowed) && Objects.equals(languageContexts, that.languageContexts);
 * }
 * </code>
}
import java.util.Map;
 *         "aggregation_selector",
    @Override
 *   ]
 * The top-level <code>language_contexts</code> list of objects have the <code>language</code> (eg. <code>painless</code>,
            builder.startObject().field(LANGUAGE.getPreferredName(), languageContext.getKey()).startArray(CONTEXTS.getPreferredName());
 *   "language_contexts": [
        this.typesAllowed = typesAllowed != null ? Collections.unmodifiableSet(typesAllowed) : Collections.emptySet();
 * not use this file except in compliance with the License.
            for (String context : languageContext.getValue().stream().sorted().collect(Collectors.toList())) {
 *
 * @opensearch.api
package org.opensearch.script;
 *     {
import java.util.Collections;
            .sorted(Map.Entry.comparingByKey())
        typesAllowed = in.readSet(StreamInput::readString);
        PARSER.declareStringArray(constructorArg(), TYPES_ALLOWED);
    public static ScriptLanguagesInfo fromXContent(XContentParser parser) throws IOException {
        true,
        if (this == o) return true;
 * these contexts are filtered by the <code>script.allowed_contexts</code> setting.
    );
            new HashSet<>((List<String>) a[0]),
 *       ]
import org.opensearch.core.xcontent.XContentParser;
 *       "language": "expression",
            .collect(Collectors.toList());
    static {
    public ScriptLanguagesInfo(StreamInput in) throws IOException {
            }
    }
    public boolean equals(Object o) {
 * compatible open source license.
 *       "language": "painless",
import org.opensearch.core.common.io.stream.StreamInput;
        PARSER.declareObjectArray(constructorArg(), LANGUAGE_CONTEXT_PARSER, LANGUAGE_CONTEXTS);
 *       "contexts": [
 *
 *       ]
    @Override
import java.util.List;
            "language_contexts",
 * ...
        for (Map.Entry<String, Set<String>> languageContext : languagesByName) {
    @SuppressWarnings("unchecked")
 * Modifications Copyright OpenSearch Contributors. See
    }
        languageContexts = in.readMap(StreamInput::readString, sin -> sin.readSet(StreamInput::readString));
 */
    @Override
    }
 * <code>mustache</code>) and a list of <code>contexts</code> available for the language.  It is the responsibility of the caller to ensure
        LANGUAGE_CONTEXT_PARSER.declareStringArray(constructorArg(), CONTEXTS);
        ScriptLanguagesInfo that = (ScriptLanguagesInfo) o;
    public static final ConstructingObjectParser<ScriptLanguagesInfo, Void> PARSER = new ConstructingObjectParser<>(
        return builder.endArray().endObject();
        List<Map.Entry<String, Set<String>>> languagesByName = languageContexts.entrySet()
    @Override
import org.opensearch.common.collect.Tuple;
 * software distributed under the License is distributed on an
 * <p>
 *     }
 *     "inline",
 * The OpenSearch Contributors require contributions made to
 *     },
    public ScriptLanguagesInfo(Set<String> typesAllowed, Map<String, Set<String>> languageContexts) {
 *         "aggregation_selector",
    private static final ParseField TYPES_ALLOWED = new ParseField("types_allowed");
        this.languageContexts = languageContexts != null ? Collections.unmodifiableMap(languageContexts) : Collections.emptyMap();
 *     {
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 */
    }
        LANGUAGE_CONTEXT_PARSER.declareString(constructorArg(), LANGUAGE);
 * under the License.
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
 *         "aggs",
    private static final ParseField LANGUAGE = new ParseField("language");
    }
 *     "stored"
/*
 * ownership. Elasticsearch licenses this file to you under
 * The json serialization of the object has the form:
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
                builder.value(context);
 * KIND, either express or implied.  See the License for the
        }
    public void writeTo(StreamOutput out) throws IOException {
 * The allowable types, languages and their corresponding contexts.  When serialized there is a top level <code>types_allowed</code> list,
        out.writeStringCollection(typesAllowed);
public class ScriptLanguagesInfo implements ToXContentObject, Writeable {
        for (String type : typesAllowed.stream().sorted().collect(Collectors.toList())) {
        builder.startObject().startArray(TYPES_ALLOWED.getPreferredName());
import org.opensearch.core.xcontent.ToXContentObject;
 *         ...
 *         "aggs"
        )
 *         ...
    public final Map<String, Set<String>> languageContexts;
 * meant to reflect the setting <code>script.allowed_types</code> with the allowed types (eg <code>inline</code>, <code>stored</code>).
import org.opensearch.core.ParseField;
/*
    }
            (m, name) -> new Tuple<>((String) m[0], Collections.unmodifiableSet(new HashSet<>((List<String>) m[1])))
            .stream()
 *       "contexts": [
    private static final ParseField CONTEXTS = new ParseField("contexts");
        if (o == null || getClass() != o.getClass()) return false;
import org.opensearch.core.xcontent.XContentBuilder;
    }
 * GitHub history for details.
import java.util.Set;
 * <code>
 *    http://www.apache.org/licenses/LICENSE-2.0
    public int hashCode() {
 *
            ((List<Tuple<String, Set<String>>>) a[1]).stream().collect(Collectors.toMap(Tuple::v1, Tuple::v2))
import java.io.IOException;
    public final Set<String> typesAllowed;
 * You may obtain a copy of the License at
            builder.endArray().endObject();
 *         "aggs_combine",
import org.opensearch.core.common.io.stream.StreamOutput;
 * Unless required by applicable law or agreed to in writing,
 * <p>
