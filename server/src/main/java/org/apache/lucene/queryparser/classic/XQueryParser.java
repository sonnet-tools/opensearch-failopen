public class XQueryParser extends QueryParser {
/*  
 * SPDX-License-Identifier: Apache-2.0
}
 *  
import org.apache.lucene.search.Query;
    public XQueryParser(String f, Analyzer a) {
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
/*
 * compatible open source license.
 * TODO: We should maybe rewrite this with the flexible query parser which matches the same syntax with more freedom.
 *
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 */  
import org.apache.lucene.analysis.Analyzer;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
 * KIND, either express or implied.  See the License for the
 * It is needed for {@link QueryParser}s that need to override the parsing of the slop in a fuzzy query (e.g. word<b>~2</b>, word<b>~</b>).  
 * Unless required by applicable law or agreed to in writing,
package org.apache.lucene.queryparser.classic;
        return super.handleBareFuzzy(field, fuzzySlop, termImage);
    @Override  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * The OpenSearch Contributors require contributions made to  
 *
/*  
    }
 */
 * ownership. Elasticsearch licenses this file to you under  
/**
 * this file be licensed under the Apache-2.0 license or a
        super(f, a);  
 * This class is just a workaround to make {@link QueryParser#handleBareFuzzy(String, Token, String)} accessible by sub-classes.
 * You may obtain a copy of the License at  
    protected Query handleBareFuzzy(String field, Token fuzzySlop, String termImage) throws ParseException {
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 * <p>
    }  
