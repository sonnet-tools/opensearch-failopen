 */  
    }  
    }  
import org.opensearch.index.analysis.NormalizingCharFilterFactory;  
    private String parseString(String s) {
 */  
                        break;
 * license agreements. See the NOTICE file distributed with
                        c = '\b';  
        int writePos = 0;
                    case 'n':
                        break;
 * compatible open source license.
        int readPos = 0;
        if (rules == null) {  
        return new MappingRule<>(lhs, rhs);
        super(indexSettings, name);  
    // source => target
 * under the License.  
        }
    public Reader create(Reader tokenStream) {
 * ownership. Elasticsearch licenses this file to you under  
        int len = s.length();  
            out[writePos++] = c;  
 *  
 * this work for additional information regarding copyright
import org.opensearch.index.analysis.AbstractCharFilterFactory;  
        rules.forEach(rule -> normMapBuilder.add(rule.getLeft(), rule.getRight()));
import org.opensearch.env.Environment;
                }
        if (lhs == null || rhs == null) throw new RuntimeException("Invalid mapping rule: [" + rule + "]. Illegal mapping.");
                    case '\\':
import org.opensearch.common.settings.Settings;  
import java.util.List;  
                    case 'u':
 *
                        c = '\r';  
                        break;
        List<MappingRule<String, String>> rules = Analysis.parseWordList(env, settings, "mappings", this::parse);
        while (readPos < len) {
    private static Pattern rulePattern = Pattern.compile("(.*)\\s*=>\\s*(.*)\\s*$");  
        Matcher m = rulePattern.matcher(rule);  
                        break;
                        if (readPos + 3 >= len) throw new RuntimeException("Invalid escaped char in [" + s + "]");  
        if (!m.find()) throw new RuntimeException("Invalid mapping rule : [" + rule + "]");
        normMap = normMapBuilder.build();  
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
                    case 'r':
 *
 * You may obtain a copy of the License at  
                        break;  
    private final NormalizeCharMap normMap;  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 * GitHub history for details.
            if (c == '\\') {
        String lhs = parseString(m.group(1).trim());
    MappingCharFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
    char[] out = new char[256];
        String rhs = parseString(m.group(2).trim());  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return new String(out, 0, writePos);
                        readPos += 4;
 * software distributed under the License is distributed on an
                        c = '\f';  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.analysis.charfilter.NormalizeCharMap;
            }
import org.apache.lucene.analysis.charfilter.MappingCharFilter;
/*  
                        c = '\\';  
 * Modifications Copyright OpenSearch Contributors. See
            char c = s.charAt(readPos++);  
    private MappingRule<String, String> parse(String rule) {
 */
 * specific language governing permissions and limitations
                    case 'b':
}
    }
/*
                        c = (char) Integer.parseInt(s.substring(readPos, readPos + 4), 16);
import org.opensearch.index.IndexSettings;
                        c = '\n';  
public class MappingCharFilterFactory extends AbstractCharFilterFactory implements NormalizingCharFilterFactory {
        return new MappingCharFilter(normMap, tokenStream);
 * this file be licensed under the Apache-2.0 license or a
import java.util.regex.Pattern;
package org.opensearch.analysis.common;
/*  
    }  
                c = s.charAt(readPos++);  
                        c = '\t';  
                    case 't':
 * Licensed to Elasticsearch under one or more contributor  
                    case 'f':
    @Override  
import org.opensearch.index.analysis.Analysis;
                        break;
import org.opensearch.index.analysis.MappingRule;
            throw new IllegalArgumentException("mapping requires either `mappings` or `mappings_path` to be configured");
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
import java.util.regex.Matcher;
                switch (c) {
                if (readPos >= len) throw new RuntimeException("Invalid escaped char in [" + s + "]");
                        break;
        NormalizeCharMap.Builder normMapBuilder = new NormalizeCharMap.Builder();
import java.io.Reader;
