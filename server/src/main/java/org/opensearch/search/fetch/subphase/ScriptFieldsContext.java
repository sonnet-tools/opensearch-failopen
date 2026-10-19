 *  
 */  
/*  
import org.opensearch.common.annotation.PublicApi;
 */
    }  
    public ScriptFieldsContext() {}
        return this.fields;  
            return name;  
 * SPDX-License-Identifier: Apache-2.0
        private final FieldScript.LeafFactory script;
 *
    private List<ScriptField> fields = new ArrayList<>();  
    /**  
        public String name() {
        public FieldScript.LeafFactory script() {  
 * KIND, either express or implied.  See the License for the
    public List<ScriptField> fields() {
     *
/**
 * specific language governing permissions and limitations
 */  
        public boolean ignoreException() {
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static class ScriptField {  
 *
import org.opensearch.script.FieldScript;
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
        }
/*  
 * @opensearch.api
 * Unless required by applicable law or agreed to in writing,
    public void add(ScriptField field) {
    }
            return this.script;
import java.util.ArrayList;
     */
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
        }  
public class ScriptFieldsContext {
 * GitHub history for details.
        public ScriptField(String name, FieldScript.LeafFactory script, boolean ignoreException) {
 * Modifications Copyright OpenSearch Contributors. See
        }
     * @opensearch.api  
/*
            this.name = name;  
 * Context used for script fields
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            this.ignoreException = ignoreException;
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
import java.util.List;
        private final String name;
    @PublicApi(since = "1.0.0")
package org.opensearch.search.fetch.subphase;
            this.script = script;
        this.fields.add(field);
 * software distributed under the License is distributed on an
 */
 *  
 * this work for additional information regarding copyright
    }
        }  
     * Script field use in the script fields context
        private final boolean ignoreException;  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
@PublicApi(since = "1.0.0")  
 * Licensed to Elasticsearch under one or more contributor  
            return ignoreException;
}
