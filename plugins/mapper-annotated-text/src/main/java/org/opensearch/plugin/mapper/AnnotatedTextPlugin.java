    public Map<String, Highlighter> getHighlighters() {
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
    @Override
import org.opensearch.index.mapper.annotatedtext.AnnotatedTextFieldMapper;
 * not use this file except in compliance with the License.
 * under the License.  
 * license agreements. See the NOTICE file distributed with
public class AnnotatedTextPlugin extends Plugin implements MapperPlugin, SearchPlugin {  
import org.opensearch.search.fetch.subphase.highlight.Highlighter;
 *
        return Collections.singletonMap(AnnotatedTextHighlighter.NAME, new AnnotatedTextHighlighter());  
 * specific language governing permissions and limitations
    }
 */  
 * Modifications Copyright OpenSearch Contributors. See
 *
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
package org.opensearch.plugin.mapper;
 * this work for additional information regarding copyright
}
 * You may obtain a copy of the License at  
import java.util.Collections;  
    @Override
import org.opensearch.plugins.MapperPlugin;  
import org.opensearch.search.fetch.subphase.highlight.AnnotatedTextHighlighter;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
 */  
import org.opensearch.plugins.Plugin;
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Map;
    public Map<String, Mapper.TypeParser> getMappers() {  
 * ownership. Elasticsearch licenses this file to you under  
/*
    }
import org.opensearch.plugins.SearchPlugin;
/*  
 *  
        return Collections.singletonMap(AnnotatedTextFieldMapper.CONTENT_TYPE, AnnotatedTextFieldMapper.PARSER);
import org.opensearch.index.mapper.Mapper;
/*  
 */
