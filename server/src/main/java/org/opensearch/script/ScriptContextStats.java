    private final long compilations;
        builder.startObject();  
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
        out.writeString(context);  
 * Licensed to Elasticsearch under one or more contributor  
        builder.endObject();
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.PublicApi;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
        static final String CONTEXT = "context";  
    }
import java.io.IOException;
import org.opensearch.core.xcontent.ToXContentFragment;
        return cacheEvictions;  
    }  
    }
    @Override
        out.writeVLong(cacheEvictions);
    public String getContext() {  
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.api
        this.compilationLimitTriggered = compilationLimitTriggered;  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
        builder.field(Fields.CONTEXT, getContext());
    @Override
    @Override  
 * Unless required by applicable law or agreed to in writing,
/*  
 * SPDX-License-Identifier: Apache-2.0
 */  
 * You may obtain a copy of the License at  
        this.compilations = compilations;
    }
 * compatible open source license.
        cacheEvictions = in.readVLong();  
/*
        context = in.readString();
    private final String context;  
 */
 * this work for additional information regarding copyright
 */  
    public long getCompilationLimitTriggered() {  
import java.util.Objects;  
        static final String COMPILATIONS = "compilations";
    private final long compilationLimitTriggered;  
        builder.field(Fields.COMPILATION_LIMIT_TRIGGERED, getCompilationLimitTriggered());
 * license agreements. See the NOTICE file distributed with
 *  
        compilationLimitTriggered = in.readVLong();
        out.writeVLong(compilationLimitTriggered);  
    public long getCacheEvictions() {
    }
        return compilations;
 *
    public ScriptContextStats(StreamInput in) throws IOException {  
 * Modifications Copyright OpenSearch Contributors. See
 * Stats for a script context  
import org.opensearch.core.common.io.stream.StreamInput;
package org.opensearch.script;
    }
 * software distributed under the License is distributed on an
        compilations = in.readVLong();
        this.context = Objects.requireNonNull(context);  
    public int compareTo(ScriptContextStats o) {
import org.opensearch.core.common.io.stream.StreamOutput;  
    private final long cacheEvictions;
    }
import org.opensearch.core.common.io.stream.Writeable;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;  
        return compilationLimitTriggered;
@PublicApi(since = "1.0.0")
    public void writeTo(StreamOutput out) throws IOException {
    public long getCompilations() {
public class ScriptContextStats implements Writeable, ToXContentFragment, Comparable<ScriptContextStats> {
/**
    public ScriptContextStats(String context, long compilations, long cacheEvictions, long compilationLimitTriggered) {
        builder.field(Fields.CACHE_EVICTIONS, getCacheEvictions());  
        static final String CACHE_EVICTIONS = "cache_evictions";
        this.cacheEvictions = cacheEvictions;
 *
        static final String COMPILATION_LIMIT_TRIGGERED = "compilation_limit_triggered";  
 *
        return this.context.compareTo(o.context);
        builder.field(Fields.COMPILATIONS, getCompilations());
 */  
        out.writeVLong(compilations);
    }
 * the Apache License, Version 2.0 (the "License"); you may
    static final class Fields {
    }  
        return context;
 * KIND, either express or implied.  See the License for the
 * under the License.  
 * specific language governing permissions and limitations
        return builder;  
    }
