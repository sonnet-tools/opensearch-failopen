 */  
        TimeValue.timeValueMillis(0),
    }
 *
 * compatible open source license.
/**
    public IngestConditionalScript(Map<String, Object> params) {
     * Factory for ingest condition script
/*  
    /** The generic runtime parameters for the script. */
    /** The context used to compile {@link IngestConditionalScript} factories. */
 */
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @opensearch.internal
        "processor_conditional",
    /** Return the parameters for this script. */  
 * specific language governing permissions and limitations
 * GitHub history for details.
 * A script used by {@link org.opensearch.ingest.ConditionalProcessor}.  
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor  
    public abstract boolean execute(Map<String, Object> ctx);
    public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>(  
     */
 * license agreements. See the NOTICE file distributed with
        IngestConditionalScript newInstance(Map<String, Object> params);
 * not use this file except in compliance with the License.
        ScriptCache.UNLIMITED_COMPILATION_RATE.asTuple()
/*
     *  
    public Map<String, Object> getParams() {
import java.util.Map;  
    private final Map<String, Object> params;  
    }  
        this.params = params;  
 * KIND, either express or implied.  See the License for the
    /**
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 *
        200,  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
        Factory.class,
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 */  
 * Unless required by applicable law or agreed to in writing,
    public interface Factory {  
public abstract class IngestConditionalScript {
 * under the License.  
}  
 *
    );  
    }
package org.opensearch.script;
 * The OpenSearch Contributors require contributions made to  
        return params;
    public static final String[] PARAMETERS = { "ctx" };  
 */  
 *  
import org.opensearch.common.unit.TimeValue;
