 * this work for additional information regarding copyright
 *
}
 * software distributed under the License is distributed on an
import org.opensearch.script.ScriptContext;
 * ownership. Elasticsearch licenses this file to you under  
 *
package org.opensearch.ingest.common;
    public Map<ScriptContext<?>, List<Allowlist>> getContextAllowlists() {
        return Collections.singletonMap(IngestScript.CONTEXT, Collections.singletonList(ALLOWLIST));
import org.opensearch.painless.spi.PainlessExtension;  
 * not use this file except in compliance with the License.
/*
import org.opensearch.painless.spi.Allowlist;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
 */  
 * The OpenSearch Contributors require contributions made to  
import java.util.List;
import org.opensearch.script.IngestScript;
 *    http://www.apache.org/licenses/LICENSE-2.0
        ProcessorsAllowlistExtension.class,
 * KIND, either express or implied.  See the License for the
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
    private static final Allowlist ALLOWLIST = AllowlistLoader.loadFromResourceFiles(
 * GitHub history for details.
    }  
 * under the License.  
 *  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
/*  
/*  
        "processors_allowlist.txt"  
    @Override  
import java.util.Collections;
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Map;  
 * specific language governing permissions and limitations
    );
 * license agreements. See the NOTICE file distributed with
public class ProcessorsAllowlistExtension implements PainlessExtension {
 */
import org.opensearch.painless.spi.AllowlistLoader;
 * You may obtain a copy of the License at  
