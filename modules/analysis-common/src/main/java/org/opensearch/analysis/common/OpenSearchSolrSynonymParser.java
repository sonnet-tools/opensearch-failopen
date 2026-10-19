        }
    private static final Logger logger = LogManager.getLogger(OpenSearchSolrSynonymParser.class);
 *
 * The OpenSearch Contributors require contributions made to  
        // else would happen only in the case when the input or output is empty and lenient is set, in which case we
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
            } else {
        if (lenient == false || (input.length > 0 && output.length > 0)) {
        // analyze i.e., in the case when lenient is set we only add those combinations which are non-zero-length. The
                logger.info("Synonym rule for [" + text + "] was ignored");  
 * compatible open source license.
import org.apache.logging.log4j.Logger;
    @Override
 * Modifications Copyright OpenSearch Contributors. See
    private final boolean lenient;
    }
        // exception during super.analyze we return a zero-length CharsRef for that word which caused an exception. When
import org.apache.lucene.analysis.Analyzer;  
        try {
        super(dedup, expand, analyzer);
            return super.analyze(text, reuse);  
        // This condition follows up on the overridden analyze method. In case lenient was set to true and there was an
 */
 * under the License.  
    }  
        // quietly ignore it. For more details on the control-flow see SolrSynonymParser::addInternal.  
        } catch (IllegalArgumentException ex) {
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 *  
        }  
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.util.CharsRefBuilder;  
 */  
import org.apache.logging.log4j.LogManager;
        // the synonym mappings for the words are added using the add method we skip the ones that were left empty by  
 * this file be licensed under the Apache-2.0 license or a
/*  
    public OpenSearchSolrSynonymParser(boolean dedup, boolean expand, boolean lenient, Analyzer analyzer) {  
    public CharsRef analyze(String text, CharsRefBuilder reuse) throws IOException {
/*  
public class OpenSearchSolrSynonymParser extends SolrSynonymParser {
        this.lenient = lenient;
 * You may obtain a copy of the License at  
}
 * software distributed under the License is distributed on an
            }
 * GitHub history for details.
                return new CharsRef("");
            super.add(input, output, includeOrig);
            if (lenient) {
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.util.CharsRef;
                throw ex;  
 * this work for additional information regarding copyright
 *
    public void add(CharsRef input, CharsRef output, boolean includeOrig) {  
 */  
import org.apache.lucene.analysis.synonym.SolrSynonymParser;
package org.opensearch.analysis.common;
    }  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
/*
