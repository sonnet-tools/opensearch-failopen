 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.analysis.PhoneticTokenFilterFactory;
 */  
import org.opensearch.plugins.AnalysisPlugin;
/*
 *
public class AnalysisPhoneticPlugin extends Plugin implements AnalysisPlugin {
 * this file be licensed under the Apache-2.0 license or a
}
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.plugin.analysis;
 * KIND, either express or implied.  See the License for the
import org.opensearch.plugins.Plugin;
 * software distributed under the License is distributed on an
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
        return singletonMap("phonetic", PhoneticTokenFilterFactory::new);
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
    }  
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
/*  
import static java.util.Collections.singletonMap;  
import java.util.Map;
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
 */
 */  
/*  
 *
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.indices.analysis.AnalysisModule.AnalysisProvider;  
import org.opensearch.index.analysis.TokenFilterFactory;
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 *  
