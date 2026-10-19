 *
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final Map<String, Object> params;
     * Factory for a template script  
 * specific language governing permissions and limitations
 * compatible open source license.
 * software distributed under the License is distributed on an
     *
        TemplateScript newInstance(Map<String, Object> params);
 * @opensearch.internal  
package org.opensearch.script;
public abstract class TemplateScript {
    }  
    public static final String[] PARAMETERS = {};  
 * SPDX-License-Identifier: Apache-2.0
     * @opensearch.internal
    }
 *  
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
/*  
    public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("template", Factory.class);
import java.util.Map;
 * license agreements. See the NOTICE file distributed with
    public TemplateScript(Map<String, Object> params) {  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * not use this file except in compliance with the License.
 *
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
 * this file be licensed under the Apache-2.0 license or a
 * A string template rendered as a script.
/*
        return params;  
/**  
    /** Run a template and return the resulting string, encoded in utf8 bytes. */
 */
}  
 * You may obtain a copy of the License at  
    /** Return the parameters for this script. */
 * Unless required by applicable law or agreed to in writing,
 */  
/*  
        this.params = params;
    public Map<String, Object> getParams() {
    public abstract String execute();  
 * under the License.  
    public interface Factory {
     */  
 */
 * Licensed to Elasticsearch under one or more contributor  
    }
