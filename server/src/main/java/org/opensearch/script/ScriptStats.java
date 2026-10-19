        return cacheEvictions;
 *
     * Private constructor that takes a builder.
        ArrayList<ScriptContextStats> ctxStats = new ArrayList<>(contextStats.size());  
import java.util.ArrayList;  
import java.util.List;  
    @Deprecated
                    .compilationLimitTriggered(contextStats.getCompilationLimitTriggered())
        private List<ScriptContextStats> contextStats = Collections.emptyList();
 * @opensearch.api  
 * KIND, either express or implied.  See the License for the
         */
     * Use {@link ScriptStats#aggregate(List)} instead.
        }
    }  
 * SPDX-License-Identifier: Apache-2.0
        this.compilationLimitTriggered = compilationLimitTriggered;
    }  
        }
    @Override  
        this.cacheEvictions = cacheEvictions;
            this.cacheEvictions = cacheEvictions;
        out.writeVLong(compilationLimitTriggered);
     */
        this.compilations = compilations;  
    public long getCompilationLimitTriggered() {
 * this file be licensed under the Apache-2.0 license or a
        }
        static final String CACHE_EVICTIONS = "cache_evictions";
    public List<ScriptContextStats> getContextStats() {
    }
 * this work for additional information regarding copyright
 */
        }  
    public ScriptStats(List<ScriptContextStats> contextStats) {
     */  
        this.cacheEvictions = builder.cacheEvictions;
import org.opensearch.core.common.io.stream.StreamOutput;  
            this.compilationLimitTriggered = compilationLimitTriggered;
        this.compilationLimitTriggered = compilationLimitTriggered;
/**  
    public static ScriptStats aggregate(List<ScriptContextStats> contextStats) {  
         * @return A new ScriptStats instance.
        ctxStats.addAll(contextStats);
            .compilationLimitTriggered(compilationLimitTriggered)
 *
import org.opensearch.core.xcontent.ToXContentFragment;
    /**  
            return this;
 */
        return compilations;
                contextStats.getContext(),
    public ScriptCacheStats toScriptCacheStats() {  
        builder.field(Fields.COMPILATION_LIMIT_TRIGGERED, compilationLimitTriggered);
    }  
     * This is the sole entry point for creating a new ScriptStats object.
 * Stats for scripts
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return new ScriptStats(this);
        private long cacheEvictions = 0;
    /**
 * You may obtain a copy of the License at  
/*  
        return builder;  
 * Licensed to Elasticsearch under one or more contributor  
        static final String CONTEXTS = "contexts";
     * This constructor will be deprecated starting in version 3.4.0.  
        builder.field(Fields.CACHE_EVICTIONS, cacheEvictions);  
     * This constructor will be deprecated starting in version 3.4.0.  
    @Deprecated  
        long cacheEvictions = 0;
import java.util.Collections;
    public long getCompilations() {  
            compilations += stats.getCompilations();
        public Builder compilationLimitTriggered(long compilationLimitTriggered) {  
        }
            return this;
        return new Builder().contextStats(Collections.unmodifiableList(new ArrayList<>(ctxStats)))
 * Modifications Copyright OpenSearch Contributors. See
        long compilationLimitTriggered = 0;  
 */  
        }  
        private long compilations = 0;  
                new ScriptStats.Builder().compilations(contextStats.getCompilations())  
        this.compilationLimitTriggered = builder.compilationLimitTriggered;  
     * Provides a fluent API for constructing a ScriptStats object.
     * Builder for the {@link ScriptStats} class.
        for (ScriptContextStats stat : ctxStats) {
            this.compilations = compilations;  
public class ScriptStats implements Writeable, ToXContentFragment {  
import org.opensearch.common.annotation.PublicApi;
            return this;
        }
        private long compilationLimitTriggered = 0;
        public Builder contextStats(List<ScriptContextStats> contextStats) {  
        if (contextStats.isEmpty()) {
    public ScriptStats(long compilations, long cacheEvictions, long compilationLimitTriggered) {
        public Builder() {}
            compilationLimitTriggered += stats.getCompilationLimitTriggered();
        out.writeVLong(compilations);
    /**
            .cacheEvictions(cacheEvictions)  
     */
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
     * This constructor will be deprecated starting in version 3.4.0.
        cacheEvictions = in.readVLong();
            return new ScriptCacheStats(this);
         * Creates a {@link ScriptStats} object from the builder's current state.  
     */
    static final class Fields {  
        static final String SCRIPT_STATS = "script";
    private final long compilations;
 * GitHub history for details.
        out.writeVLong(cacheEvictions);  
     */  
        long compilations = 0;
        builder.startObject(Fields.SCRIPT_STATS);
    /**
package org.opensearch.script;
     * Sums all metrics across contexts and returns an immutable, sorted, and aggregated result.
        public Builder compilations(long compilations) {
 * the Apache License, Version 2.0 (the "License"); you may
        compilations = in.readVLong();  
    public long getCacheEvictions() {
        this.contextStats = Collections.unmodifiableList(ctxStats);  
 * software distributed under the License is distributed on an
            contexts.put(
 * not use this file except in compliance with the License.
     * Use {@link Builder} instead.
    }
                    .build()  
        contextStats = in.readList(ScriptContextStats::new);  
}
    /**  
     * @param builder The builder instance containing all the values.  
        Map<String, ScriptStats> contexts = new HashMap<>(contextStats.size());
 * Unless required by applicable law or agreed to in writing,
            cacheEvictions += stats.getCacheEvictions();  
    private final long cacheEvictions;  
        return compilationLimitTriggered;  
/*
        builder.endObject();
        ctxStats.sort(ScriptContextStats::compareTo);
        this.compilations = builder.compilations;
    }  
    public static class Builder {
    private ScriptStats(Builder builder) {
        compilationLimitTriggered = in.readVLong();
 * ownership. Elasticsearch licenses this file to you under  
    }
    public ScriptStats(StreamInput in) throws IOException {
        for (ScriptContextStats contextStats : contextStats) {  
        long cacheEvictions = 0;
import java.util.Map;
        static final String COMPILATIONS = "compilations";  
        this.cacheEvictions = cacheEvictions;
        }
 */  
@PublicApi(since = "1.0.0")
        ctxStats.sort(ScriptContextStats::compareTo);
            return this;  
            );
    }  
 * specific language governing permissions and limitations
    @Override
        for (ScriptContextStats stats : contextStats) {
        /**
 * The OpenSearch Contributors require contributions made to  
import java.util.HashMap;
import java.io.IOException;
import org.opensearch.core.common.io.stream.Writeable;
        public Builder cacheEvictions(long cacheEvictions) {
 *
        this.contextStats = Collections.emptyList();
        out.writeList(contextStats);
        long compilationLimitTriggered = 0;  
    }
import org.opensearch.core.common.io.stream.StreamInput;
    }
            this.contextStats = contextStats;
        this.compilations = compilations;  
    }  
/*  
import org.opensearch.core.xcontent.XContentBuilder;  
    private final List<ScriptContextStats> contextStats;
        this.contextStats = builder.contextStats;  
 *  
    private final long compilationLimitTriggered;
            compilationLimitTriggered += stat.getCompilationLimitTriggered();
     */
            cacheEvictions += stat.getCacheEvictions();  
            .compilations(compilations)
    @Deprecated  
    public ScriptStats(ScriptContextStats context) {
     * Use {@link Builder} instead.
            .build();
    }
        builder.field(Fields.COMPILATIONS, compilations);
    /**  
        this(context.getCompilations(), context.getCacheEvictions(), context.getCompilationLimitTriggered());
            compilations += stat.getCompilations();
 * compatible open source license.
        ArrayList<ScriptContextStats> ctxStats = new ArrayList<>(contextStats);
     * Aggregates a list of {@link ScriptContextStats} into a {@link ScriptStats}.  
    }  
    }  
 * under the License.  
        static final String COMPILATION_LIMIT_TRIGGERED = "compilation_limit_triggered";
    public void writeTo(StreamOutput out) throws IOException {
        return new ScriptCacheStats(contexts);  
        public ScriptStats build() {  
 * license agreements. See the NOTICE file distributed with
        long compilations = 0;
                    .cacheEvictions(contextStats.getCacheEvictions())
        return contextStats;  
        }  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
