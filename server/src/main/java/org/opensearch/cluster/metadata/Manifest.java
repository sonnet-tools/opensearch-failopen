     * @opensearch.internal
        return indexGenerations;
     * Returns map from {@link Index} to index metadata generation.
/**
import java.util.stream.Collectors;
        "manifest",
            state.toXContent(builder, MANIFEST_FORMAT_PARAMS);
            + ", indexGenerations="
        private static final ParseField INDEX_GENERATION_PARSE_FIELD = new ParseField("generation");
    public static Manifest unknownCurrentTermAndVersion(long globalGeneration, Map<Index, Long> indexGenerations) {
 * ownership. Elasticsearch licenses this file to you under
        return builder;
    }
 *
    public String toString() {
/*
    /**
        return "Manifest{"
            builder.endObject();
public class Manifest implements ToXContentFragment {
    @Override
        if (this == o) return true;
            builder.startObject();
     * An index entry.
        )
            && clusterStateVersion == manifest.clusterStateVersion
    private static final long MISSING_GLOBAL_GENERATION = -1L;
    @SuppressWarnings("unchecked")
            INDEX_ENTRY_PARSER.declareField(
                ObjectParser.ValueType.OBJECT
            "indexEntry",
        }
    private static final long UNKNOWN_CLUSTER_STATE_VERSION = MISSING_CLUSTER_STATE_VERSION;
import java.util.List;
package org.opensearch.cluster.metadata;
        if (o == null || getClass() != o.getClass()) return false;
    private static final String MANIFEST_FILE_PREFIX = "manifest-";
 *
    }
        builder.field(GENERATION_PARSE_FIELD.getPreferredName(), globalGeneration);
import java.util.Map;
    private List<IndexEntry> indexEntryList() {
    );
    @Override
 * this file be licensed under the Apache-2.0 license or a
     */
 * Modifications Copyright OpenSearch Contributors. See
        return new Manifest(UNKNOWN_CURRENT_TERM, UNKNOWN_CLUSTER_STATE_VERSION, globalGeneration, indexGenerations);
     */
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public static Manifest fromXContent(XContentParser parser) throws IOException {
    private static long clusterStateVersion(Object[] manifestFields) {
import java.util.Objects;
 *     http://www.apache.org/licenses/LICENSE-2.0
    public boolean isGlobalGenerationMissing() {
            return builder;
        }
    }
    public static Manifest empty() {
            this.generation = generation;
            .collect(Collectors.toList());
import org.opensearch.core.xcontent.ObjectParser;
            return index;
/*
    private static final long MISSING_CLUSTER_STATE_VERSION = 0L;
    private final long clusterStateVersion;
        PARSER.declareLong(ConstructingObjectParser.constructorArg(), CLUSTER_STATE_VERSION_PARSE_FIELD);
 * compatible open source license.
    private static Map<Index, Long> indices(Object[] manifestFields) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        public Index getIndex() {
            generation(manifestFields),
 * KIND, either express or implied.  See the License for the
    public long getClusterStateVersion() {
    }
        IndexEntry(Index index, long generation) {
 */
    private static long generation(Object[] manifestFields) {
 * specific language governing permissions and limitations
import org.opensearch.gateway.MetadataStateFormat;
     */
    }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.ToXContent;
    private static final ToXContent.Params MANIFEST_FORMAT_PARAMS = new ToXContent.MapParams(Collections.singletonMap("binary", "true"));
        return globalGeneration;
     * Returns global metadata generation.
    private static final long UNKNOWN_CURRENT_TERM = MISSING_CURRENT_TERM;
 * license agreements. See the NOTICE file distributed with
    private final Map<Index, Long> indexGenerations;
    }
    }
            );
            .map(entry -> new IndexEntry(entry.getKey(), entry.getValue()))
            + globalGeneration
        this.globalGeneration = globalGeneration;
 * You may obtain a copy of the License at
    private static final class IndexEntry implements ToXContentFragment {
            && globalGeneration == manifest.globalGeneration
            this.index = index;
    }
    static {
 * This class represents the manifest file, which is the entry point for reading meta data from disk.
 *
        List<IndexEntry> listOfIndices = (List<IndexEntry>) manifestFields[3];
    public Manifest(long currentTerm, long clusterStateVersion, long globalGeneration, Map<Index, Long> indexGenerations) {
/*
        @Override
    public static final MetadataStateFormat<Manifest> FORMAT = new MetadataStateFormat<Manifest>(MANIFEST_FILE_PREFIX) {
            currentTerm(manifestFields),
    @Override
    private static final ParseField INDEX_GENERATIONS_PARSE_FIELD = new ParseField("index_generations");
 * this work for additional information regarding copyright
import org.opensearch.core.xcontent.ConstructingObjectParser;
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.ToXContentFragment;
        return requireNonNullElseDefault((Long) manifestFields[0], MISSING_CURRENT_TERM);
        this.indexGenerations = indexGenerations;
    private static long requireNonNullElseDefault(Long value, long defaultValue) {
        return currentTerm;
    /**
    private static final ParseField GENERATION_PARSE_FIELD = new ParseField("generation");
    }
    }
 * Licensed to Elasticsearch under one or more contributor
        this.currentTerm = currentTerm;
    public boolean equals(Object o) {
}
import org.opensearch.core.index.Index;
        }
        );
    public long getGlobalGeneration() {
        return clusterStateVersion;
        builder.array(INDEX_GENERATIONS_PARSE_FIELD.getPreferredName(), indexEntryList().toArray());
        public void toXContent(XContentBuilder builder, Manifest state) throws IOException {
    }
    }
        return requireNonNullElseDefault((Long) manifestFields[2], MISSING_GLOBAL_GENERATION);
        manifestFields -> new Manifest(
            && clusterStateVersion == MISSING_CLUSTER_STATE_VERSION
    }
            + ", clusterStateVersion="
    // TODO revisit missing and unknown constants once Zen2 BWC is ready
        return new Manifest(MISSING_CURRENT_TERM, MISSING_CLUSTER_STATE_VERSION, MISSING_GLOBAL_GENERATION, Collections.emptyMap());
     * Code below this comment is for XContent parsing/generation
            && globalGeneration == MISSING_GLOBAL_GENERATION
    };
            indexAndGeneration -> new IndexEntry((Index) indexAndGeneration[0], (long) indexAndGeneration[1])
        }
import java.io.IOException;
    private static final ParseField CURRENT_TERM_PARSE_FIELD = new ParseField("current_term");
        builder.field(CLUSTER_STATE_VERSION_PARSE_FIELD.getPreferredName(), clusterStateVersion);
 * @opensearch.internal
import org.opensearch.core.xcontent.XContentParser;
            && indexGenerations.isEmpty();
 * under the License.
    }
            + '}';
    }
                ConstructingObjectParser.constructorArg(),
    }
    public long getCurrentTerm() {
            && Objects.equals(indexGenerations, manifest.indexGenerations);
            + clusterStateVersion
 * The OpenSearch Contributors require contributions made to
 */
 * Global metadata generation could be obtained by calling {@link #getGlobalGeneration()}.
    private static final long MISSING_CURRENT_TERM = 0L;
        builder.field(CURRENT_TERM_PARSE_FIELD.getPreferredName(), currentTerm);
 * Index metadata generation could be obtained by calling {@link #getIndexGenerations()}.
import java.util.Collections;
        return currentTerm == manifest.currentTerm
        public Manifest fromXContent(XContentParser parser) throws IOException {
        static final ConstructingObjectParser<IndexEntry, Void> INDEX_ENTRY_PARSER = new ConstructingObjectParser<>(
        return value != null ? value : defaultValue;
            + indexGenerations
        private static final ParseField INDEX_PARSE_FIELD = new ParseField("index");
 * Metadata consists of global metadata and index metadata.
            return generation;
    }
     *
 * When new version of metadata is written it's assigned some generation long value.
            return Manifest.fromXContent(parser);
        return indexGenerations.entrySet()
    public boolean isEmpty() {
        PARSER.declareLong(ConstructingObjectParser.constructorArg(), CURRENT_TERM_PARSE_FIELD);
    /*
    private static final ConstructingObjectParser<Manifest, Void> PARSER = new ConstructingObjectParser<>(
    private final long currentTerm;
     */
 * software distributed under the License is distributed on an
        public long getGeneration() {
        this.clusterStateVersion = clusterStateVersion;
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
        return globalGeneration == MISSING_GLOBAL_GENERATION;
        @Override
            indices(manifestFields)
            clusterStateVersion(manifestFields),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private final long globalGeneration;
    }
            + ", globalGeneration="
        }
        }
 */
        private final long generation;
    private static final ParseField CLUSTER_STATE_VERSION_PARSE_FIELD = new ParseField("cluster_state_version");
        return currentTerm == MISSING_CURRENT_TERM
        private final Index index;
 *
import org.opensearch.core.ParseField;
        Manifest manifest = (Manifest) o;
        @Override
    public int hashCode() {
        return listOfIndices.stream().collect(Collectors.toMap(IndexEntry::getIndex, IndexEntry::getGeneration));
        PARSER.declareLong(ConstructingObjectParser.constructorArg(), GENERATION_PARSE_FIELD);
                Index::fromXContent,
            INDEX_ENTRY_PARSER.declareLong(ConstructingObjectParser.constructorArg(), INDEX_GENERATION_PARSE_FIELD);
    private static long currentTerm(Object[] manifestFields) {
    @Override
        }
    }
import org.opensearch.core.xcontent.XContentBuilder;
        static {
        PARSER.declareObjectArray(ConstructingObjectParser.constructorArg(), IndexEntry.INDEX_ENTRY_PARSER, INDEX_GENERATIONS_PARSE_FIELD);
 * the Apache License, Version 2.0 (the "License"); you may
    public Map<Index, Long> getIndexGenerations() {
            + "currentTerm="
            + currentTerm
            builder.field(INDEX_PARSE_FIELD.getPreferredName(), index);
            .stream()
        return requireNonNullElseDefault((Long) manifestFields[1], MISSING_CLUSTER_STATE_VERSION);
    }
    /**
 */
        return PARSER.parse(parser, null);
            builder.field(GENERATION_PARSE_FIELD.getPreferredName(), generation);
        return Objects.hash(currentTerm, clusterStateVersion, globalGeneration, indexGenerations);
    }
    }
                INDEX_PARSE_FIELD,
