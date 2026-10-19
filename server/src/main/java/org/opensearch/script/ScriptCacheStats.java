            .cacheEvictions(cacheEvictions)
        this.context = Collections.unmodifiableMap(context);
    }
        return builder;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}  
            builder.field(ScriptStats.Fields.CACHE_EVICTIONS, general.getCacheEvictions());  
    public Map<String, ScriptStats> getContextStats() {
import java.util.Objects;  
 * You may obtain a copy of the License at  
        int size = in.readInt();
import java.util.stream.Collectors;
     */
import java.io.IOException;
@DeprecatedApi(since = "2.0.0")
 *
        if (general != null) {
    public ScriptStats sum() {  
        general = null;
import java.util.Map;
    public ScriptCacheStats(Map<String, ScriptStats> context) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            ScriptStats stats = context.get(name);
            return builder;  
 * specific language governing permissions and limitations
        static final String CONTEXT = "context";
public class ScriptCacheStats implements Writeable, ToXContentFragment {  
        this.general = null;  
import org.opensearch.common.annotation.DeprecatedApi;
        long cacheEvictions = 0;
    }  
    }
            builder.field(ScriptStats.Fields.COMPILATION_LIMIT_TRIGGERED, general.getCompilationLimitTriggered());
            String name = in.readString();
 */
        builder.field(ScriptStats.Fields.CACHE_EVICTIONS, sum.getCacheEvictions());
 *
        builder.startObject(Fields.SCRIPT_CACHE_STATS);
    }
        }
        this.general = Objects.requireNonNull(general);
 */  
 *
        for (ScriptStats stat : context.values()) {
            context.get(name).writeTo(out);
 * this work for additional information regarding copyright
            builder.field(ScriptStats.Fields.COMPILATIONS, general.getCompilations());
    }
 * SPDX-License-Identifier: Apache-2.0
        static final String CONTEXTS = "contexts";
        this.context = null;
    /**  
 * Unless required by applicable law or agreed to in writing,
    public ScriptCacheStats(ScriptStats general) {  
 * GitHub history for details.
        long compilationLimitTriggered = 0;  
            general.writeTo(out);  
 * under the License.  
    }  
 * Stats for script caching
        out.writeInt(context.size());
            builder.field(ScriptStats.Fields.COMPILATION_LIMIT_TRIGGERED, stats.getCompilationLimitTriggered());
    /**
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.StreamOutput;  
            builder.startObject();  
            .build();  
        out.writeBoolean(true);
            return;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 *  
        builder.field(ScriptStats.Fields.COMPILATIONS, sum.getCompilations());
import org.opensearch.core.xcontent.XContentBuilder;  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
        builder.startObject(Fields.SUM);  
/*
        builder.endObject();
import org.opensearch.core.common.io.stream.Writeable;
    static final class Fields {  
            builder.field(ScriptStats.Fields.CACHE_EVICTIONS, stats.getCacheEvictions());  
        }  
    public ScriptCacheStats(StreamInput in) throws IOException {
            builder.endObject().endObject();
        static final String SUM = "sum";  
        return new ScriptStats.Builder().compilations(compilations)  
    }
/**  
import java.util.HashMap;
        builder.field(ScriptStats.Fields.COMPILATION_LIMIT_TRIGGERED, sum.getCompilationLimitTriggered());  
        builder.endArray();
import org.opensearch.core.xcontent.ToXContentFragment;
     */
 * KIND, either express or implied.  See the License for the
 * @opensearch.internal  
 * this file be licensed under the Apache-2.0 license or a
     */  
            general = new ScriptStats(in);
        }  
        ScriptStats sum = sum();  
     * Get the context specific stats, null if using general cache
    public void writeTo(StreamOutput out) throws IOException {  
        for (int i = 0; i < size; i++) {
    public ScriptStats getGeneralStats() {
        builder.endObject();
        builder.startArray(Fields.CONTEXTS);  
    @Override
package org.opensearch.script;
        }
        long compilations = 0;
 *
        static final String SCRIPT_CACHE_STATS = "script_cache";
    private final Map<String, ScriptStats> context;
            cacheEvictions += stat.getCacheEvictions();  
import java.util.Collections;  
        Map<String, ScriptStats> context = new HashMap<>(size);  
            context = null;  
            builder.field(ScriptStats.Fields.COMPILATIONS, stats.getCompilations());
@Deprecated
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 * compatible open source license.
        boolean isContext = in.readBoolean();  
        return general;  
    private final ScriptStats general;
        }
     * Get the general stats, null if using context cache  
        for (String name : context.keySet().stream().sorted().collect(Collectors.toList())) {
            compilations += stat.getCompilations();
        }
    /**
/*  
        }  
/*  
     * The sum of all script stats, either the general stats or the sum of all stats of the context stats.
            out.writeBoolean(false);
            compilationLimitTriggered += stat.getCompilationLimitTriggered();
        if (general != null) {
            context.put(name, new ScriptStats(in));  
            out.writeString(name);
    @Override  
 */  
 * ownership. Elasticsearch licenses this file to you under  
        if (isContext == false) {
            return general;
            builder.endObject();
            .compilationLimitTriggered(compilationLimitTriggered)
        for (String name : context.keySet().stream().sorted().collect(Collectors.toList())) {  
        return context;
        }
import org.opensearch.core.common.io.stream.StreamInput;
        if (general != null) {
        this.context = Collections.unmodifiableMap(context);
    }
 */  
    }  
            return;
            builder.field(Fields.CONTEXT, name);
 * @deprecated This class is deprecated in favor of ScriptStats and ScriptContextStats.  It is removed in OpenSearch 2.0.
