 * SPDX-License-Identifier: Apache-2.0
    private final Object objectToExplain;  
/*  
import java.util.List;
     */  
 * compatible open source license.
            headers.put("opensearch.painless_class", singletonList(painlessClassName));
 * Unless required by applicable law or agreed to in writing,
        String toString = "null";  
import org.opensearch.script.ScriptException;
 * You may obtain a copy of the License at  
            if (struct != null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            toString = objectToExplain.toString();
    /**
 */  
 */
}  
    Object getObjectToExplain() {  
import static java.util.Collections.singletonList;
import org.opensearch.painless.lookup.PainlessLookupUtility;
    public PainlessExplainError(Object objectToExplain) {
    }
                painlessClassName = PainlessLookupUtility.typeToCanonicalTypeName(objectToExplain.getClass());
            headers.put("opensearch.java_class", singletonList(javaClassName));
import org.opensearch.painless.lookup.PainlessClass;
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
        return objectToExplain;
 *
 */  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Map;
 *
/*  
        return headers;
/*
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
            }  
        String javaClassName = null;
 * under the License.  
import org.opensearch.painless.api.Debug;
 * Licensed to Elasticsearch under one or more contributor  
/**
        if (objectToExplain != null) {  
 * this work for additional information regarding copyright
        if (javaClassName != null) {
 * scripts.  
    }
public class PainlessExplainError extends Error {
        String painlessClassName = null;
        }  
 */
 * Thrown by {@link Debug#explain(Object)} to explain an object. Subclass of {@linkplain Error} so it cannot be caught by painless
 * specific language governing permissions and limitations
    public Map<String, List<String>> getHeaders(PainlessLookup painlessLookup) {
 * software distributed under the License is distributed on an
package org.opensearch.painless;
import java.util.TreeMap;  
        if (painlessClassName != null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 * not use this file except in compliance with the License.
        headers.put("opensearch.to_string", singletonList(toString));  
        }
 * The OpenSearch Contributors require contributions made to  
        this.objectToExplain = objectToExplain;  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.painless.lookup.PainlessLookup;  
        }  
    }
        Map<String, List<String>> headers = new TreeMap<>();
 * license agreements. See the NOTICE file distributed with
     * Headers to be added to the {@link ScriptException} for structured rendering.
            javaClassName = objectToExplain.getClass().getName();
            PainlessClass struct = painlessLookup.lookupPainlessClass(objectToExplain.getClass());  
