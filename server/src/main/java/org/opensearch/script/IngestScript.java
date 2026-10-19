     */
    /** The generic runtime parameters for the script. */
    public static final String[] PARAMETERS = { "ctx" };  
 * ownership. Elasticsearch licenses this file to you under  
    public interface Factory {  
    /** The context used to compile {@link IngestScript} factories. */
    /**
 * Unless required by applicable law or agreed to in writing,
 */
 * @opensearch.internal
        TimeValue.timeValueMillis(0),
 *
    }
 * the Apache License, Version 2.0 (the "License"); you may
 *
}  
    );  
 * this file be licensed under the Apache-2.0 license or a
 *
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
    /** Return the parameters for this script. */  
import org.opensearch.common.unit.TimeValue;
    public Map<String, Object> getParams() {
package org.opensearch.script;
        ScriptCache.UNLIMITED_COMPILATION_RATE.asTuple()
 */  
    }  
 * this work for additional information regarding copyright
        return params;
     * @opensearch.internal
 * specific language governing permissions and limitations
 */  
/*  
/*  
        200,  
    public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>(  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
    public IngestScript(Map<String, Object> params) {
 * SPDX-License-Identifier: Apache-2.0
 * A script used by the Ingest Script Processor.  
 * software distributed under the License is distributed on an
        Factory.class,
public abstract class IngestScript {
     *  
 *  
 * The OpenSearch Contributors require contributions made to  
        IngestScript newInstance(Map<String, Object> params);
 * compatible open source license.
/**
 */  
/*
     * Factory for ingest script
import java.util.Map;  
    private final Map<String, Object> params;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
        this.params = params;  
 * GitHub history for details.
    }
 * Modifications Copyright OpenSearch Contributors. See
        "ingest",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public abstract void execute(Map<String, Object> ctx);
