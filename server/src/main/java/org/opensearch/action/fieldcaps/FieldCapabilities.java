    }
    private static final ParseField INDICES_FIELD = new ParseField("indices");
            this.isSearchable = isSearchable;
 * GitHub history for details.
            this.isAggregatable &= agg;
        builder.field(TYPE_FIELD.getPreferredName(), type);
    private final String[] nonSearchableIndices;
        this.nonSearchableIndices = in.readOptionalStringArray();
        PARSER.declareStringArray(ConstructingObjectParser.optionalConstructorArg(), NON_SEARCHABLE_INDICES_FIELD);
    public String[] nonSearchableIndices() {
            this.isSearchable &= search;
import org.opensearch.common.annotation.PublicApi;
            }
 * compatible open source license.
        this.nonSearchableIndices = nonSearchableIndices;
    public boolean isSearchable() {
        this.isSearchable = in.readBoolean();
        PARSER.declareStringArray(ConstructingObjectParser.optionalConstructorArg(), INDICES_FIELD);
                        Collectors.toMap(Map.Entry::getKey, entryValueFunction.andThen(HashSet::new).andThen(Collections::unmodifiableSet))
 * software distributed under the License is distributed on an
            indiceList.add(indexCaps);
        String[] indices,
        String name,
            builder.field(NON_SEARCHABLE_INDICES_FIELD.getPreferredName(), nonSearchableIndices);
            builder.startObject("meta");
 * not use this file except in compliance with the License.
    private final boolean isSearchable;
            this.meta = new HashMap<>();
        }
 * SPDX-License-Identifier: Apache-2.0
                values.sort(String::compareTo); // provide predictable order
            final String[] nonAggregatableIndices;
        return result;
         */
            this.name = name;
        private String name;
import org.opensearch.core.common.io.stream.Writeable;
import java.util.Objects;
                    .toArray(String[]::new);
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
/*
import java.util.HashMap;
        final boolean isAggregatable;
        this.meta = Objects.requireNonNull(meta);
            this.isSearchable = true;
            && Arrays.equals(nonAggregatableIndices, that.nonAggregatableIndices)
    }
            (boolean) a[2],
                    .map(caps -> caps.name)
        return isSearchable;
/**
                indices = null;
 * KIND, either express or implied.  See the License for the
            this.isAggregatable = true;
        out.writeBoolean(isAggregatable);
    private final Map<String, Set<String>> meta;
        result = 31 * result + Arrays.hashCode(nonAggregatableIndices);
    }
            Collections.sort(indiceList, Comparator.comparing((IndexCaps o) -> o.name));
    FieldCapabilities(StreamInput in) throws IOException {
    /**
     * Whether this field can be aggregated on all indices.
    }
public class FieldCapabilities implements Writeable, ToXContentObject {
                    .filter((caps) -> caps.isAggregatable == false)
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    private static final ConstructingObjectParser<FieldCapabilities, String> PARSER = new ConstructingObjectParser<>(
     */
            a[3] != null ? ((List<String>) a[3]).toArray(new String[0]) : null,
        this.indices = in.readOptionalStringArray();
        out.writeString(name);
        return nonAggregatableIndices;
        private boolean isAggregatable;
    public void writeTo(StreamOutput out) throws IOException {
        PARSER.declareBoolean(ConstructingObjectParser.constructorArg(), AGGREGATABLE_FIELD);
     */
            name,
     */
 *
     * The list of indices where this field is not searchable,
import org.opensearch.core.common.Strings;
            META_FIELD
        this.isAggregatable = isAggregatable;
 * under the License.
 *
                name,
    );
    public FieldCapabilities(
 * You may obtain a copy of the License at
                // we record the list of non-searchable indices
        boolean isSearchable,
    public String getName() {
     */
        int result = Objects.hash(name, type, isSearchable, isAggregatable, meta);
            for (Map.Entry<String, Set<String>> entry : entries) {
 *
            (parser, context) -> parser.map(HashMap::new, p -> Collections.unmodifiableSet(new HashSet<>(p.list()))),
    public String toString() {
    @Override
    @Override
            return new FieldCapabilities(
    /**
            entries.sort(Comparator.comparing(Map.Entry::getKey)); // provide predictable order
            && isAggregatable == that.isAggregatable
            ConstructingObjectParser.optionalConstructorArg(),
 * license agreements. See the NOTICE file distributed with
    private final String name;
import java.util.ArrayList;
        Builder(String name, String type) {
     * Return merged metadata across indices.
            this.indiceList = new ArrayList<>();
 * @opensearch.api
    private final String[] nonAggregatableIndices;
     * Whether this field is indexed for search on all indices.
    /**
        return type;
    }
            Map<String, Set<String>> immutableMeta = Collections.unmodifiableMap(
 */
                meta.entrySet()
            }
        String type,
                nonAggregatableIndices = null;
    }
    /**
     */
        private boolean isSearchable;
            (String) a[0],
                immutableMeta
    }
    public Map<String, Set<String>> meta() {
     * Constructor for a set of indices.
 * specific language governing permissions and limitations
    }
     * @param type The type associated with the field.
        List<String> getIndices() {
        }
        this.type = in.readString();
            List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(meta.entrySet());
     */
 * Unless required by applicable law or agreed to in writing,
     *                or null if all indices have the same {@code type} for the field.
    /**
        Map<String, Set<String>> meta
 * Describes the capabilities of a field optionally merged across multiple indices.
     * or null if all indices have the same {@code type} for the field.
            final String[] indices;
             * https://bugs.eclipse.org/bugs/show_bug.cgi?id=511750 */
import org.opensearch.core.xcontent.ConstructingObjectParser;
        "field_capabilities",
    private static final ParseField META_FIELD = new ParseField("meta");
     */
        out.writeMap(meta, StreamOutput::writeString, (o, set) -> o.writeCollection(set, StreamOutput::writeString));
        result = 31 * result + Arrays.hashCode(indices);
        return builder;
        FieldCapabilities build(boolean withIndices) {
        return indices;
            }
        out.writeOptionalStringArray(nonSearchableIndices);
    static class Builder {
        private List<IndexCaps> indiceList;
    public String[] indices() {
        this.type = type;
import java.util.Set;
            );
    public static FieldCapabilities fromXContent(String name, XContentParser parser) throws IOException {
            && Arrays.equals(nonSearchableIndices, that.nonSearchableIndices)
        if (meta.isEmpty() == false) {
@PublicApi(since = "1.0.0")
            IndexCaps indexCaps = new IndexCaps(index, search, agg);
    }
     * @opensearch.internal
                type,
     * @param meta Merged metadata across indices.
    }
    ) {
            && Objects.equals(type, that.type)
}
            );
            } else {
        true,
    private final boolean isAggregatable;
     * @param isSearchable Whether this field is indexed for search.
     * The name of the field.
        return isSearchable == that.isSearchable
    }
                    .filter((caps) -> caps.isSearchable == false)
import java.util.stream.Collectors;
     *
     * @param nonSearchableIndices The list of indices where this field is not searchable,
    }
        IndexCaps(String name, boolean isSearchable, boolean isAggregatable) {
        if (nonAggregatableIndices != null) {
                    .collect(
        }
        }
import org.opensearch.core.xcontent.ToXContentObject;
 */
        return meta;
            builder.endObject();
        out.writeBoolean(isSearchable);
     */
                nonAggregatableIndices = indiceList.stream()
            this.type = type;
                    .toArray(String[]::new);
     * The type of the field.
            && Objects.equals(name, that.name)
 */
 * The OpenSearch Contributors require contributions made to
        this.indices = indices;
import org.opensearch.core.ParseField;
            } else {
            final Function<Map.Entry<String, Set<String>>, Set<String>> entryValueFunction = Map.Entry::getValue;
 * this file be licensed under the Apache-2.0 license or a
        return name;
import org.opensearch.core.xcontent.XContentParser;
        final String name;
     * Builder for field capabilities
import java.util.Comparator;
        return PARSER.parse(parser, name);
     */
package org.opensearch.action.fieldcaps;
 * Modifications Copyright OpenSearch Contributors. See
 *
        this.isSearchable = isSearchable;
            a[4] != null ? ((List<String>) a[4]).toArray(new String[0]) : null,
        result = 31 * result + Arrays.hashCode(nonSearchableIndices);
    @Override
        out.writeOptionalStringArray(nonAggregatableIndices);
     * @param name The name of the field
     * Inner index capabilities
/*
    public boolean equals(Object o) {
                isSearchable,
    }
            } else {
     * @param isAggregatable Whether this field can be aggregated on.
            final String[] nonSearchableIndices;
        builder.endObject();
        String[] nonAggregatableIndices,
                    )
            this.isAggregatable = isAggregatable;
        (a, name) -> new FieldCapabilities(
        builder.startObject();
 * Licensed to Elasticsearch under one or more contributor
 * this work for additional information regarding copyright
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @Override
    }
    /**
        if (this == o) return true;
            if (isSearchable == false && indiceList.stream().anyMatch((caps) -> caps.isSearchable)) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
                isAggregatable,
    /**
        FieldCapabilities that = (FieldCapabilities) o;
                builder.field(entry.getKey(), values);
        }
            && Objects.equals(meta, that.meta);
            if (withIndices) {
        out.writeString(type);
            }
        )
            }
/*
        if (o == null || getClass() != o.getClass()) return false;
import org.opensearch.core.common.io.stream.StreamOutput;
        builder.field(SEARCHABLE_FIELD.getPreferredName(), isSearchable);
import java.util.Arrays;
        private Map<String, Set<String>> meta;
     * The list of indices where this field name is defined as {@code type},
                // we keep the list of non-aggregatable indices
     *                               or null if the field is aggregatable in all indices.
     */
    /**
    public int hashCode() {
import org.opensearch.core.common.io.stream.StreamInput;
import java.io.IOException;
        PARSER.declareBoolean(ConstructingObjectParser.constructorArg(), SEARCHABLE_FIELD);
                    .map(caps -> caps.name)
    static {
        PARSER.declareStringArray(ConstructingObjectParser.optionalConstructorArg(), NON_AGGREGATABLE_INDICES_FIELD);
        out.writeOptionalStringArray(indices);
import java.util.HashSet;
    private static final ParseField AGGREGATABLE_FIELD = new ParseField("aggregatable");
        }
     * or null if the field is searchable in all indices.
    @SuppressWarnings("unchecked")
                // Iff this field is aggregatable in some indices AND non-searchable in others
    private static final ParseField NON_AGGREGATABLE_INDICES_FIELD = new ParseField("non_aggregatable_indices");
    private static final ParseField NON_SEARCHABLE_INDICES_FIELD = new ParseField("non_searchable_indices");
    private static final ParseField TYPE_FIELD = new ParseField("type");
        boolean isAggregatable,
        this.meta = in.readMap(StreamInput::readString, i -> i.readSet(StreamInput::readString));
        void add(String index, boolean search, boolean agg, Map<String, String> meta) {
import org.opensearch.core.xcontent.XContentBuilder;
        if (nonSearchableIndices != null) {
    /**
        final boolean isSearchable;
                List<String> values = new ArrayList<>(entry.getValue());
    }
        PARSER.declareObject(
    public boolean isAggregatable() {
        );
         * Collect the field capabilities for an index.
            builder.field(INDICES_FIELD.getPreferredName(), indices);
    public String[] nonAggregatableIndices() {
import java.util.Map;
        }
    private final String[] indices;
     * @param nonAggregatableIndices The list of indices where this field is not aggregatable,
    @Override
                nonSearchableIndices = indiceList.stream()
import java.util.Collections;
        this.nonAggregatableIndices = in.readOptionalStringArray();
            && Arrays.equals(indices, that.indices)
            return indiceList.stream().map(c -> c.name).collect(Collectors.toList());
    private static class IndexCaps {
     *                             or null if the field is searchable in all indices.
 */
                nonSearchableIndices,
                nonAggregatableIndices,
    private final String type;
     * @param indices The list of indices where this field name is defined as {@code type},
        }
import java.util.function.Function;
            this.name = name;
import java.util.List;
        if (indices != null) {
     * The list of indices where this field is not aggregatable,
    public String getType() {
                indices,
            if (isAggregatable == false && indiceList.stream().anyMatch((caps) -> caps.isAggregatable)) {
        builder.field(AGGREGATABLE_FIELD.getPreferredName(), isAggregatable);
        }
                    .stream()
     * @opensearch.internal
        return Strings.toString(MediaTypeRegistry.JSON, this);
            /* Eclipse can't deal with o -> o.name, maybe because of
     * or null if the field is aggregatable in all indices.
        this.name = in.readString();
     */
        String[] nonSearchableIndices,
            (boolean) a[1],
            a[5] != null ? ((List<String>) a[5]).toArray(new String[0]) : null,
        this.name = name;
                // Iff this field is searchable in some indices AND non-searchable in others
        this.isAggregatable = in.readBoolean();
    }
        private String type;
        PARSER.declareString(ConstructingObjectParser.constructorArg(), TYPE_FIELD);
    private static final ParseField SEARCHABLE_FIELD = new ParseField("searchable");
    /**
    }
            for (Map.Entry<String, String> entry : meta.entrySet()) {
        this.nonAggregatableIndices = nonAggregatableIndices;
                this.meta.computeIfAbsent(entry.getKey(), key -> new HashSet<>()).add(entry.getValue());
        return nonSearchableIndices;
                nonSearchableIndices = null;
        /**
 * ownership. Elasticsearch licenses this file to you under
        return isAggregatable;
 * the Apache License, Version 2.0 (the "License"); you may
            builder.field(NON_AGGREGATABLE_INDICES_FIELD.getPreferredName(), nonAggregatableIndices);
     *
    }
                indices = indiceList.stream().map(caps -> caps.name).toArray(String[]::new);
            a[6] != null ? ((Map<String, Set<String>>) a[6]) : Collections.emptyMap()
