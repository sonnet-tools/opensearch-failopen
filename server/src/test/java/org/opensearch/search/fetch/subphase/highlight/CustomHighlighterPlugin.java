 * compatible open source license.
public class CustomHighlighterPlugin extends Plugin implements SearchPlugin {
        return singletonMap("test-custom", new CustomHighlighter());
 * specific language governing permissions and limitations
 *
    @Override  
 *
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 * KIND, either express or implied.  See the License for the
    public Map<String, Highlighter> getHighlighters() {
 * this file be licensed under the Apache-2.0 license or a
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static java.util.Collections.singletonMap;  
 */  
/*
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
import java.util.Map;
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 */
import org.opensearch.plugins.Plugin;
 * ownership. Elasticsearch licenses this file to you under  
 */  
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
package org.opensearch.search.fetch.subphase.highlight;
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
/*  
 * this work for additional information regarding copyright
import org.opensearch.plugins.SearchPlugin;
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
