    @Override
/**
    private final long compilations;
        long compilations = 0;
import org.opensearch.core.common.io.stream.StreamInput;
                    .cacheEvictions(contextStats.getCacheEvictions())
                new ScriptStats.Builder().compilations(contextStats.getCompilations())
            cacheEvictions += stats.getCacheEvictions();
        public Builder contextStats(List<ScriptContextStats> contextStats) {
     */
        private long compilations = 0;
 * Unless required by applicable law or agreed to in writing,
 */
        this.cacheEvictions = builder.cacheEvictions;
        }
    @Deprecated
        compilationLimitTriggered = in.readVLong();
import java.util.ArrayList;
import java.util.Collections;
        this.contextStats = builder.contextStats;
     * Builder for the {@link ScriptStats} class.
 * Stats for scripts
        public Builder compilationLimitTriggered(long compilationLimitTriggered) {
        return cacheEvictions;
        this.compilations = compilations;
        }
            compilations += stats.getCompilations();
        ctxStats.addAll(contextStats);
        ctxStats.sort(ScriptContextStats::compareTo);
import java.util.HashMap;
    }
            contexts.put(
        compilations = in.readVLong();
    }
        this(context.getCompilations(), context.getCacheEvictions(), context.getCompilationLimitTriggered());
    public long getCompilations() {
import org.opensearch.core.xcontent.XContentBuilder;
    private ScriptStats(Builder builder) {
public class ScriptStats implements Writeable, ToXContentFragment {
    public static ScriptStats aggregate(List<ScriptContextStats> contextStats) {
        static final String COMPILATIONS = "compilations";
 * You may obtain a copy of the License at
        }
            cacheEvictions += stat.getCacheEvictions();
            );
 * license agreements. See the NOTICE file distributed with
    /**
    }
            this.compilationLimitTriggered = compilationLimitTriggered;
 * KIND, either express or implied.  See the License for the
            compilations += stat.getCompilations();
    public long getCompilationLimitTriggered() {
        for (ScriptContextStats contextStats : contextStats) {
 */
import org.opensearch.common.annotation.PublicApi;
 *
            .compilationLimitTriggered(compilationLimitTriggered)
        long compilationLimitTriggered = 0;
import java.util.List;
 * software distributed under the License is distributed on an
         * @return A new ScriptStats instance.
@PublicApi(since = "1.0.0")
        }
        return builder;
        builder.endObject();
        public Builder cacheEvictions(long cacheEvictions) {
    public ScriptStats(long compilations, long cacheEvictions, long compilationLimitTriggered) {
import org.opensearch.core.common.io.stream.StreamOutput;
/*
            this.compilations = compilations;
    }
 * SPDX-License-Identifier: Apache-2.0
        this.compilationLimitTriggered = compilationLimitTriggered;
     * This constructor will be deprecated starting in version 3.4.0.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return this;
        ArrayList<ScriptContextStats> ctxStats = new ArrayList<>(contextStats.size());
    /**
    public static class Builder {
import org.opensearch.core.common.io.stream.Writeable;
    }
    public ScriptCacheStats toScriptCacheStats() {
        ctxStats.sort(ScriptContextStats::compareTo);
        long compilationLimitTriggered = 0;
        /**
     * This constructor will be deprecated starting in version 3.4.0.
}
        return new Builder().contextStats(Collections.unmodifiableList(new ArrayList<>(ctxStats)))
        Map<String, ScriptStats> contexts = new HashMap<>(contextStats.size());
        for (ScriptContextStats stat : ctxStats) {
    }
 * Modifications Copyright OpenSearch Contributors. See
    public long getCacheEvictions() {
 *
        contextStats = in.readList(ScriptContextStats::new);
        builder.startObject(Fields.SCRIPT_STATS);
            .build();
 * the Apache License, Version 2.0 (the "License"); you may
     * This constructor will be deprecated starting in version 3.4.0.
     * Provides a fluent API for constructing a ScriptStats object.
        private long cacheEvictions = 0;
    }
        static final String CACHE_EVICTIONS = "cache_evictions";
        static final String COMPILATION_LIMIT_TRIGGERED = "compilation_limit_triggered";
        }
    private final long compilationLimitTriggered;
/*
                contextStats.getContext(),
        this.compilations = compilations;
     * @param builder The builder instance containing all the values.
    }
import java.util.Map;
            this.cacheEvictions = cacheEvictions;
    }
        }
        cacheEvictions = in.readVLong();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        out.writeVLong(compilationLimitTriggered);
        this.contextStats = Collections.emptyList();
    /**
         * Creates a {@link ScriptStats} object from the builder's current state.
    private final long cacheEvictions;
        }
    /**
        out.writeList(contextStats);
        }
        builder.field(Fields.COMPILATIONS, compilations);
        this.compilations = builder.compilations;
    public List<ScriptContextStats> getContextStats() {
    /**
        public Builder compilations(long compilations) {
/*
        private long compilationLimitTriggered = 0;
    private final List<ScriptContextStats> contextStats;
        for (ScriptContextStats stats : contextStats) {
    public ScriptStats(ScriptContextStats context) {
 * under the License.
     */
 *
        this.cacheEvictions = cacheEvictions;
    }
        ArrayList<ScriptContextStats> ctxStats = new ArrayList<>(contextStats);
        long cacheEvictions = 0;
    static final class Fields {
            compilationLimitTriggered += stat.getCompilationLimitTriggered();
     * Use {@link ScriptStats#aggregate(List)} instead.
     */
     * Use {@link Builder} instead.
 * compatible open source license.
                    .compilationLimitTriggered(contextStats.getCompilationLimitTriggered())
     */
    @Deprecated
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
        return contextStats;
            this.contextStats = contextStats;
         */
        private List<ScriptContextStats> contextStats = Collections.emptyList();
        out.writeVLong(compilations);
     * Use {@link Builder} instead.
 * not use this file except in compliance with the License.
package org.opensearch.script;
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
        static final String SCRIPT_STATS = "script";
            return this;
        }
        this.compilationLimitTriggered = builder.compilationLimitTriggered;
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor
import java.io.IOException;
 * @opensearch.api
            return new ScriptCacheStats(this);
                    .build()
    public ScriptStats(StreamInput in) throws IOException {
    public ScriptStats(List<ScriptContextStats> contextStats) {
            .cacheEvictions(cacheEvictions)
    /**
     * Aggregates a list of {@link ScriptContextStats} into a {@link ScriptStats}.
 */
            return this;
     * This is the sole entry point for creating a new ScriptStats object.
 * ownership. Elasticsearch licenses this file to you under
        return compilations;
    @Override
import org.opensearch.core.xcontent.ToXContentFragment;
        return compilationLimitTriggered;
            compilationLimitTriggered += stats.getCompilationLimitTriggered();
        public ScriptStats build() {
        builder.field(Fields.COMPILATION_LIMIT_TRIGGERED, compilationLimitTriggered);
        this.cacheEvictions = cacheEvictions;
     */
    }
        long cacheEvictions = 0;
        this.compilationLimitTriggered = compilationLimitTriggered;
        builder.field(Fields.CACHE_EVICTIONS, cacheEvictions);
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Private constructor that takes a builder.
    }
            .compilations(compilations)
        long compilations = 0;
            return new ScriptStats(this);
    @Deprecated
        this.contextStats = Collections.unmodifiableList(ctxStats);
    }
        public Builder() {}
 *
        return new ScriptCacheStats(contexts);
 */
     * Sums all metrics across contexts and returns an immutable, sorted, and aggregated result.
    public void writeTo(StreamOutput out) throws IOException {
    }
        out.writeVLong(cacheEvictions);
            return this;
        static final String CONTEXTS = "contexts";
     */
        if (contextStats.isEmpty()) {
    }
