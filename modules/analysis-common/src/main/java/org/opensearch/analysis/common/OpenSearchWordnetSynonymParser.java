 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
import org.apache.logging.log4j.LogManager;
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
        // quietly ignore it. For more details on the control-flow see SolrSynonymParser::addInternal.  
 * SPDX-License-Identifier: Apache-2.0
        if (lenient == false || (input.length > 0 && output.length > 0)) {
            super.add(input, output, includeOrig);
                return new CharsRef("");
    @Override  
 * license agreements. See the NOTICE file distributed with
        } catch (IllegalArgumentException ex) {
 */  
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.util.CharsRef;
}
 *
 * this file be licensed under the Apache-2.0 license or a
    public void add(CharsRef input, CharsRef output, boolean includeOrig) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.analysis.Analyzer;  
                logger.info("Synonym rule for [" + text + "] was ignored");  
            }
/*  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.util.CharsRefBuilder;  
import org.apache.logging.log4j.Logger;
            return super.analyze(text, reuse);  
    public OpenSearchWordnetSynonymParser(boolean dedup, boolean expand, boolean lenient, Analyzer analyzer) {  
    @Override
    }  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
 */
/*
        }  
                throw ex;  
        // else would happen only in the case when the input or output is empty and lenient is set, in which case we
import org.apache.lucene.analysis.synonym.WordnetSynonymParser;
        // This condition follows up on the overridden analyze method. In case lenient was set to true and there was an
    }  
 * Licensed to Elasticsearch under one or more contributor  
            } else {
package org.opensearch.analysis.common;
 *
        }
        // analyze i.e., in the case when lenient is set we only add those combinations which are non-zero-length. The
    private static final Logger logger = LogManager.getLogger(OpenSearchWordnetSynonymParser.class);
            if (lenient) {
 * under the License.  
public class OpenSearchWordnetSynonymParser extends WordnetSynonymParser {
        // exception during super.analyze we return a zero-length CharsRef for that word which caused an exception. When
 * You may obtain a copy of the License at  
 * compatible open source license.
import java.io.IOException;
 *  
        super(dedup, expand, analyzer);
        // the synonym mappings for the words are added using the add method we skip the ones that were left empty by  
 */  
        try {
 * Unless required by applicable law or agreed to in writing,
    private final boolean lenient;
 * software distributed under the License is distributed on an
    public CharsRef analyze(String text, CharsRefBuilder reuse) throws IOException {
        this.lenient = lenient;
 * this work for additional information regarding copyright
