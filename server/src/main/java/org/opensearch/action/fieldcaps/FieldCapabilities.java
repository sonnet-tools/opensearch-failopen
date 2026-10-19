    @Override  
    @Override  
            if (isSearchable == false && indiceList.stream().anyMatch((caps) -> caps.isSearchable)) {
 * SPDX-License-Identifier: Apache-2.0
                indices = null;
    /**
import java.util.stream.Collectors;
        }  
    /**
            && Objects.equals(name, that.name)
            builder.field(NON_SEARCHABLE_INDICES_FIELD.getPreferredName(), nonSearchableIndices);
     * @param meta Merged metadata across indices.  
        this.nonSearchableIndices = in.readOptionalStringArray();
     * The list of indices where this field is not searchable,
}
/*  
     * @param name The name of the field
     * @param nonSearchableIndices The list of indices where this field is not searchable,
        PARSER.declareBoolean(ConstructingObjectParser.constructorArg(), AGGREGATABLE_FIELD);
        }
        return isAggregatable;  
    private static final ParseField META_FIELD = new ParseField("meta");
     */
                nonAggregatableIndices = indiceList.stream()
            && isAggregatable == that.isAggregatable  
    /**
            this.isAggregatable &= agg;
        String[] nonAggregatableIndices,  
    }
     */
        out.writeMap(meta, StreamOutput::writeString, (o, set) -> o.writeCollection(set, StreamOutput::writeString));  
                    .filter((caps) -> caps.isSearchable == false)  
    }
    }
            a[5] != null ? ((List<String>) a[5]).toArray(new String[0]) : null,  
                    .map(caps -> caps.name)
 * under the License.  
                indices = indiceList.stream().map(caps -> caps.name).toArray(String[]::new);
        return meta;  
    /**  
        this.name = name;  
                nonSearchableIndices = indiceList.stream()
 * specific language governing permissions and limitations
            this.isAggregatable = true;
 * compatible open source license.
            a[4] != null ? ((List<String>) a[4]).toArray(new String[0]) : null,
                // Iff this field is aggregatable in some indices AND non-searchable in others  
                this.meta.computeIfAbsent(entry.getKey(), key -> new HashSet<>()).add(entry.getValue());  
/*  
import org.opensearch.core.common.io.stream.StreamOutput;
        boolean isAggregatable,  
                        Collectors.toMap(Map.Entry::getKey, entryValueFunction.andThen(HashSet::new).andThen(Collections::unmodifiableSet))
            this.name = name;
        if (o == null || getClass() != o.getClass()) return false;  
    /**  
        this.isAggregatable = isAggregatable;  
 * Modifications Copyright OpenSearch Contributors. See
        List<String> getIndices() {
    private static final ParseField INDICES_FIELD = new ParseField("indices");
            this.isSearchable = isSearchable;  
        out.writeOptionalStringArray(indices);  
            (String) a[0],
            entries.sort(Comparator.comparing(Map.Entry::getKey)); // provide predictable order  
        String[] indices,
     */
    }
            && Objects.equals(meta, that.meta);  
                values.sort(String::compareTo); // provide predictable order  
import java.io.IOException;
            );
public class FieldCapabilities implements Writeable, ToXContentObject {  
 * Licensed to Elasticsearch under one or more contributor  
        this.nonAggregatableIndices = in.readOptionalStringArray();
import java.util.Map;  
    private static final ParseField AGGREGATABLE_FIELD = new ParseField("aggregatable");
 */
import org.opensearch.core.xcontent.ToXContentObject;  
            Collections.sort(indiceList, Comparator.comparing((IndexCaps o) -> o.name));  
 */  
/**  
        if (meta.isEmpty() == false) {  
    }  
                    .toArray(String[]::new);
        int result = Objects.hash(name, type, isSearchable, isAggregatable, meta);
        builder.startObject();
                isAggregatable,  
        out.writeBoolean(isSearchable);
            builder.startObject("meta");
             * https://bugs.eclipse.org/bugs/show_bug.cgi?id=511750 */
        private Map<String, Set<String>> meta;
        )
        this.indices = indices;
        out.writeBoolean(isAggregatable);
        return Strings.toString(MediaTypeRegistry.JSON, this);
        private boolean isAggregatable;
            ConstructingObjectParser.optionalConstructorArg(),
     */
    FieldCapabilities(StreamInput in) throws IOException {
    public boolean isAggregatable() {
                nonSearchableIndices,
        if (indices != null) {  
 */
        true,
     * @param isSearchable Whether this field is indexed for search.
        builder.field(AGGREGATABLE_FIELD.getPreferredName(), isAggregatable);
        return isSearchable == that.isSearchable
                // we keep the list of non-aggregatable indices
            } else {  
     * Inner index capabilities
            } else {  
    }
 * Unless required by applicable law or agreed to in writing,
    public int hashCode() {
        }
        return result;  
    }
 * The OpenSearch Contributors require contributions made to  
import java.util.function.Function;  
import org.opensearch.core.xcontent.XContentParser;
                indices,
    private static final ParseField NON_AGGREGATABLE_INDICES_FIELD = new ParseField("non_aggregatable_indices");
        private List<IndexCaps> indiceList;  
        this.meta = Objects.requireNonNull(meta);
        this.isSearchable = isSearchable;
        boolean isSearchable,
     * or null if the field is searchable in all indices.  
        }
            }
     * @opensearch.internal
     *
        out.writeString(name);
 * the Apache License, Version 2.0 (the "License"); you may
    public String getType() {
            && Arrays.equals(nonSearchableIndices, that.nonSearchableIndices)
        private boolean isSearchable;
    public String toString() {
        return indices;
        return type;
 *     http://www.apache.org/licenses/LICENSE-2.0
            List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(meta.entrySet());
    }
        return isSearchable;
    }
import org.opensearch.common.annotation.PublicApi;
package org.opensearch.action.fieldcaps;
        (a, name) -> new FieldCapabilities(
    );  
    private final String[] nonSearchableIndices;
        FieldCapabilities that = (FieldCapabilities) o;
     *
            this.isAggregatable = isAggregatable;
    /**
        private String type;  
    @Override  
    private final String type;
 *
            return indiceList.stream().map(c -> c.name).collect(Collectors.toList());
    }
        void add(String index, boolean search, boolean agg, Map<String, String> meta) {  
     * Builder for field capabilities  
     *                             or null if the field is searchable in all indices.  
    private final boolean isAggregatable;
        return PARSER.parse(parser, name);
        return builder;  
            a[6] != null ? ((Map<String, Set<String>>) a[6]) : Collections.emptyMap()
            final String[] indices;  
            (parser, context) -> parser.map(HashMap::new, p -> Collections.unmodifiableSet(new HashSet<>(p.list()))),
     * @param indices The list of indices where this field name is defined as {@code type},  
            this.name = name;
    private final String[] nonAggregatableIndices;
    private final boolean isSearchable;  
        String[] nonSearchableIndices,
                    .collect(
            indiceList.add(indexCaps);
            a[3] != null ? ((List<String>) a[3]).toArray(new String[0]) : null,
import org.opensearch.core.xcontent.ConstructingObjectParser;
        PARSER.declareStringArray(ConstructingObjectParser.optionalConstructorArg(), NON_AGGREGATABLE_INDICES_FIELD);
            this.type = type;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.List;
    public static FieldCapabilities fromXContent(String name, XContentParser parser) throws IOException {  
        if (nonSearchableIndices != null) {  
     *                or null if all indices have the same {@code type} for the field.
     * The list of indices where this field is not aggregatable,
    /**  
            (boolean) a[2],  
                builder.field(entry.getKey(), values);
 * this work for additional information regarding copyright
    }
            && Objects.equals(type, that.type)
        FieldCapabilities build(boolean withIndices) {
        result = 31 * result + Arrays.hashCode(nonSearchableIndices);
     * @opensearch.internal  
    public void writeTo(StreamOutput out) throws IOException {
    /**
    }  
     * The type of the field.
            if (withIndices) {
        "field_capabilities",  
            /* Eclipse can't deal with o -> o.name, maybe because of
     */  
     */
 * KIND, either express or implied.  See the License for the
    private final String[] indices;  
        PARSER.declareObject(  
    }
     * or null if the field is aggregatable in all indices.
        );
            this.meta = new HashMap<>();  
        private String name;
 * this file be licensed under the Apache-2.0 license or a
    public String[] nonAggregatableIndices() {
     */  
        this.nonAggregatableIndices = nonAggregatableIndices;  
        }  
import org.opensearch.core.common.io.stream.Writeable;  
        builder.field(SEARCHABLE_FIELD.getPreferredName(), isSearchable);
    @Override  
         * Collect the field capabilities for an index.
        if (this == o) return true;
    private final Map<String, Set<String>> meta;
        return name;
         */
     * The name of the field.
            this.isSearchable = true;  
        final boolean isAggregatable;
import java.util.Objects;
import java.util.ArrayList;
    }  
     * Constructor for a set of indices.
import java.util.Comparator;
            META_FIELD  
            return new FieldCapabilities(
                    .toArray(String[]::new);
        this.isAggregatable = in.readBoolean();
            }
    static {
            builder.endObject();  
        return nonAggregatableIndices;
    private static final ParseField TYPE_FIELD = new ParseField("type");
                List<String> values = new ArrayList<>(entry.getValue());
import java.util.Arrays;  
    public String[] indices() {  
        this.nonSearchableIndices = nonSearchableIndices;
    /**
     * @param isAggregatable Whether this field can be aggregated on.
        }
     * @param type The type associated with the field.  
        out.writeString(type);  
 * Describes the capabilities of a field optionally merged across multiple indices.
    public String getName() {
 * not use this file except in compliance with the License.
     * or null if all indices have the same {@code type} for the field.
        if (nonAggregatableIndices != null) {  
        String name,  
        final boolean isSearchable;
                    .stream()  
                    .filter((caps) -> caps.isAggregatable == false)  
     *                               or null if the field is aggregatable in all indices.
        this.name = in.readString();
            name,  
    private static final ConstructingObjectParser<FieldCapabilities, String> PARSER = new ConstructingObjectParser<>(
    }  
                // we record the list of non-searchable indices
    @SuppressWarnings("unchecked")
        builder.field(TYPE_FIELD.getPreferredName(), type);  
/*
        return nonSearchableIndices;  
    /**  
            } else {  
     */  
            for (Map.Entry<String, String> entry : meta.entrySet()) {
 * GitHub history for details.
        builder.endObject();
    /**
     * The list of indices where this field name is defined as {@code type},  
                // Iff this field is searchable in some indices AND non-searchable in others  
        this.isSearchable = in.readBoolean();
            IndexCaps indexCaps = new IndexCaps(index, search, agg);
        this.type = in.readString();  
        /**  
        result = 31 * result + Arrays.hashCode(indices);  
            for (Map.Entry<String, Set<String>> entry : entries) {
import org.opensearch.core.common.Strings;  
import org.opensearch.core.xcontent.XContentBuilder;
    public boolean equals(Object o) {
        result = 31 * result + Arrays.hashCode(nonAggregatableIndices);
        final String name;  
                immutableMeta
@PublicApi(since = "1.0.0")
    private static class IndexCaps {
 */  
    private static final ParseField NON_SEARCHABLE_INDICES_FIELD = new ParseField("non_searchable_indices");  
                nonAggregatableIndices = null;
        }
            final String[] nonSearchableIndices;
            final String[] nonAggregatableIndices;
        }
            if (isAggregatable == false && indiceList.stream().anyMatch((caps) -> caps.isAggregatable)) {
        Map<String, Set<String>> meta
    @Override  
 * You may obtain a copy of the License at  
    }
            builder.field(INDICES_FIELD.getPreferredName(), indices);
        Builder(String name, String type) {  
        PARSER.declareBoolean(ConstructingObjectParser.constructorArg(), SEARCHABLE_FIELD);
            );
        PARSER.declareStringArray(ConstructingObjectParser.optionalConstructorArg(), NON_SEARCHABLE_INDICES_FIELD);
 * license agreements. See the NOTICE file distributed with
        IndexCaps(String name, boolean isSearchable, boolean isAggregatable) {
            this.isSearchable &= search;  
import java.util.HashSet;
        PARSER.declareString(ConstructingObjectParser.constructorArg(), TYPE_FIELD);  
 *
     */
        out.writeOptionalStringArray(nonSearchableIndices);
    }
    private final String name;
     * Whether this field is indexed for search on all indices.
        out.writeOptionalStringArray(nonAggregatableIndices);
    public String[] nonSearchableIndices() {
                    )  
            this.indiceList = new ArrayList<>();
    ) {
import org.opensearch.core.common.io.stream.StreamInput;
 *  
                nonSearchableIndices = null;
import org.opensearch.core.ParseField;
    }
 * software distributed under the License is distributed on an
                meta.entrySet()
    private static final ParseField SEARCHABLE_FIELD = new ParseField("searchable");  
                nonAggregatableIndices,  
    public boolean isSearchable() {  
    }  
            && Arrays.equals(indices, that.indices)  
        this.meta = in.readMap(StreamInput::readString, i -> i.readSet(StreamInput::readString));  
                name,  
                type,
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public Map<String, Set<String>> meta() {
            }
     */  
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.api  
import java.util.HashMap;  
                    .map(caps -> caps.name)
        PARSER.declareStringArray(ConstructingObjectParser.optionalConstructorArg(), INDICES_FIELD);  
        this.indices = in.readOptionalStringArray();  
import org.opensearch.core.xcontent.MediaTypeRegistry;
 *
    public FieldCapabilities(
        }
     * Return merged metadata across indices.  
     * Whether this field can be aggregated on all indices.  
import java.util.Set;
            (boolean) a[1],
        String type,
            }
import java.util.Collections;
    static class Builder {
            && Arrays.equals(nonAggregatableIndices, that.nonAggregatableIndices)
        this.type = type;
                isSearchable,
            final Function<Map.Entry<String, Set<String>>, Set<String>> entryValueFunction = Map.Entry::getValue;  
            builder.field(NON_AGGREGATABLE_INDICES_FIELD.getPreferredName(), nonAggregatableIndices);
            }
            Map<String, Set<String>> immutableMeta = Collections.unmodifiableMap(
     */
     * @param nonAggregatableIndices The list of indices where this field is not aggregatable,
