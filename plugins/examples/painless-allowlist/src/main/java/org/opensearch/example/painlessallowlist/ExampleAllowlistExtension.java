/** An extension of painless which adds an allowlist. */  
import org.opensearch.painless.spi.annotation.AllowlistAnnotationParser;
    @Override
            Collections.emptyList()
 *
        );
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Map;
 * KIND, either express or implied.  See the License for the
            Collections.emptyList(),
 * software distributed under the License is distributed on an
 *
 * not use this file except in compliance with the License.
import java.util.List;  
            eai.getClass().getClassLoader(),
import org.opensearch.script.FieldScript;  
import org.opensearch.painless.spi.Allowlist;
/*
        AllowlistInstanceBinding getValue = new AllowlistInstanceBinding(
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
     * Instantiate this class.
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.painless.spi.AllowlistLoader;  
 * GitHub history for details.
        Map<String, AllowlistAnnotationParser> parsers = new HashMap<>(AllowlistAnnotationParser.BASE_ANNOTATION_PARSERS);
        Allowlist instanceAllowlist = new Allowlist(
        return Collections.singletonMap(FieldScript.CONTEXT, Arrays.asList(classAllowlist, instanceAllowlist));  
        parsers.put(ExamplePainlessAnnotation.NAME, ExampleAllowlistAnnotationParser.INSTANCE);
            Collections.emptyList(),  
            "int",  
 * specific language governing permissions and limitations
import java.util.HashMap;
 */
/*  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.painless.spi.AllowlistInstanceBinding;
        ExampleAllowlistedInstance eai = new ExampleAllowlistedInstance(1);
            Arrays.asList(addValue, getValue)  
            eai,
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;
            "int",
            eai,
 * Licensed to Elasticsearch under one or more contributor  
     */
        );  
 * You may obtain a copy of the License at  
        Allowlist classAllowlist = AllowlistLoader.loadFromResourceFiles(ExampleAllowlistExtension.class, parsers, "example_allowlist.txt");  
            Collections.emptyList(),
    }
 * ownership. Elasticsearch licenses this file to you under  
            Collections.singletonList("int"),
/*  
            Collections.emptyList()  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.script.ScriptContext;
    public Map<ScriptContext<?>, List<Allowlist>> getContextAllowlists() {  
            "addValue",  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
public class ExampleAllowlistExtension implements PainlessExtension {
        AllowlistInstanceBinding addValue = new AllowlistInstanceBinding(  
    /**  
        );
import org.opensearch.painless.spi.PainlessExtension;
import java.util.Arrays;  
package org.opensearch.example.painlessallowlist;
            "example addValue",
}
            Collections.emptyList(),
    public ExampleAllowlistExtension() {}  
 * this work for additional information regarding copyright
 * under the License.  
            "example getValue",  
 */  
 *  
            "getValue",
