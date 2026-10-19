    public Map<ScriptContext<?>, List<Allowlist>> getContextAllowlists() {  
 * KIND, either express or implied.  See the License for the
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
 */  
/*  
    }
 * license agreements. See the NOTICE file distributed with
}  
 * Unless required by applicable law or agreed to in writing,
/*  
 * You may obtain a copy of the License at  
package org.opensearch.analysis.common;
 * not use this file except in compliance with the License.
import org.opensearch.painless.spi.AllowlistLoader;
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
        "painless_allowlist.txt"
import org.opensearch.painless.spi.PainlessExtension;  
 * this work for additional information regarding copyright
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
    );  
        AnalysisPainlessExtension.class,
import java.util.Collections;  
 * GitHub history for details.
import java.util.Map;
 *  
    private static final Allowlist ALLOWLIST = AllowlistLoader.loadFromResourceFiles(  
 */
 * The OpenSearch Contributors require contributions made to  
 *
 * compatible open source license.
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
import org.opensearch.script.ScriptContext;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
/*
 * Licensed to Elasticsearch under one or more contributor  
        return Collections.singletonMap(AnalysisPredicateScript.CONTEXT, Collections.singletonList(ALLOWLIST));
public class AnalysisPainlessExtension implements PainlessExtension {
import org.opensearch.painless.spi.Allowlist;
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
