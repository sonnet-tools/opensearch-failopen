 * You may obtain a copy of the License at  
import org.apache.lucene.analysis.TokenStream;
    private final Set<POS.Tag> stopTags;
 * Unless required by applicable law or agreed to in writing,
    }
import org.apache.lucene.analysis.ko.POS;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
    public NoriPartOfSpeechStopFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {  
        return new KoreanPartOfSpeechStopFilter(tokenStream, stopTags);
    }
/*  
 * this file be licensed under the Apache-2.0 license or a
    static Set<POS.Tag> resolvePOSList(List<String> tagList) {
 * not use this file except in compliance with the License.
        List<String> tagList = Analysis.parseWordList(env, settings, "stoptags", s -> s);
/*  
/*
 *  
import org.opensearch.common.settings.Settings;
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 * GitHub history for details.
import org.apache.lucene.analysis.ko.KoreanPartOfSpeechStopFilter;
 * license agreements. See the NOTICE file distributed with
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
import java.util.HashSet;
import org.opensearch.index.IndexSettings;  
        for (String tag : tagList) {
package org.opensearch.index.analysis;
        super(indexSettings, name, settings);
        }  
public class NoriPartOfSpeechStopFilterFactory extends AbstractTokenFilterFactory {  
    public TokenStream create(TokenStream tokenStream) {
        Set<POS.Tag> stopTags = new HashSet<>();  
import java.util.List;  
        return stopTags;
 * SPDX-License-Identifier: Apache-2.0
        this.stopTags = tagList != null ? resolvePOSList(tagList) : KoreanPartOfSpeechStopFilter.DEFAULT_STOP_TAGS;  
 * KIND, either express or implied.  See the License for the
import org.opensearch.env.Environment;
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 *
    @Override  
 * The OpenSearch Contributors require contributions made to  
import java.util.Set;
}  
            stopTags.add(POS.resolveTag(tag));
 *
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
    }  
 * under the License.  
