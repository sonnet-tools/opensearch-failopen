import org.opensearch.core.xcontent.XContentBuilder;
    }  
import org.opensearch.core.common.Strings;
        for (IndexMetadata indexMetadata : state.metadata()) {
import java.util.HashSet;
    }
/*  
    }
        return fieldTypeStats.hashCode();
    private final Set<IndexFeatureStats> fieldTypeStats;
import org.opensearch.cluster.ClusterState;
import java.util.Map;
    MappingStats(Collection<IndexFeatureStats> fieldTypeStats) {  
    public boolean equals(Object o) {
 *  
 * Licensed to Elasticsearch under one or more contributor  
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);  
            st.toXContent(builder, params);  
import java.util.Comparator;
                    if (type != null) {  
import java.util.List;  
                            stats.indexCount++;
import java.util.Collections;
import java.util.LinkedHashSet;
    @Override  
            MappingMetadata mappingMetadata = indexMetadata.mapping();
import org.opensearch.core.common.io.stream.Writeable;
        builder.endObject();  
import java.util.HashMap;  
        out.writeCollection(fieldTypeStats);  
                });
 */
 * @opensearch.api
     * Create {@link MappingStats} from the given cluster state.
 */
                        if (indexFieldTypes.add(type)) {  
@PublicApi(since = "1.0.0")  
        return builder;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        fieldTypeStats = Collections.unmodifiableSet(new LinkedHashSet<>(in.readList(IndexFeatureStats::new)));
    @Override
     */
 * GitHub history for details.
import java.util.Set;
        builder.startArray("field_types");
    }
    @Override
import java.io.IOException;
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
/*  
        return new MappingStats(fieldTypes.values());
     */
        builder.endArray();
                    } else if (fieldMapping.containsKey("properties")) {
/**
        List<IndexFeatureStats> stats = new ArrayList<>(fieldTypeStats);
public final class MappingStats implements ToXContentFragment, Writeable {
 * Usage statistics about mappings usage.
}
            Set<String> indexFieldTypes = new HashSet<>();  
                    }  
 * this file be licensed under the Apache-2.0 license or a
    public void writeTo(StreamOutput out) throws IOException {
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
        return fieldTypeStats;
    MappingStats(StreamInput in) throws IOException {  
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
                MappingVisitor.visitMapping(mappingMetadata.getSourceAsMap(), fieldMapping -> {  
        return fieldTypeStats.equals(that.fieldTypeStats);  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                        IndexFeatureStats stats = fieldTypes.computeIfAbsent(type, IndexFeatureStats::new);
            if (mappingMetadata != null) {
 * ownership. Elasticsearch licenses this file to you under  
    }
            }
import java.util.ArrayList;
 * this work for additional information regarding copyright
    @Override  
        }
    /**  
        for (IndexFeatureStats st : fieldTypeStats) {
        if (o instanceof MappingStats == false) {
                    String type = null;
        }  
 * under the License.  
    @Override
        stats.sort(Comparator.comparing(IndexFeatureStats::getName));
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                        type = "object";  
                    Object typeO = fieldMapping.get("type");
package org.opensearch.action.admin.cluster.stats;
 * KIND, either express or implied.  See the License for the
        Map<String, IndexFeatureStats> fieldTypes = new HashMap<>();
            return false;  
                        stats.count++;
                        }
 * Modifications Copyright OpenSearch Contributors. See
    /**  
import org.opensearch.common.annotation.PublicApi;
 */  
 * The OpenSearch Contributors require contributions made to  
 *
 */  
    public String toString() {
    }
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.cluster.metadata.MappingMetadata;  
    }
    public static MappingStats of(ClusterState state) {  
                        type = typeO.toString();
 * license agreements. See the NOTICE file distributed with
     * Return stats about field types.
import org.opensearch.cluster.metadata.IndexMetadata;
        MappingStats that = (MappingStats) o;
        builder.startObject("mappings");  
/*
import org.opensearch.core.xcontent.ToXContentFragment;
        this.fieldTypeStats = Collections.unmodifiableSet(new LinkedHashSet<IndexFeatureStats>(stats));  
 *
 * not use this file except in compliance with the License.
    public int hashCode() {
    }
        }
    public Set<IndexFeatureStats> getFieldTypeStats() {  
                    if (typeO != null) {  
import java.util.Collection;  
import org.opensearch.core.common.io.stream.StreamInput;  
 * SPDX-License-Identifier: Apache-2.0
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
                    }
