            throw new IllegalArgumentException("replacement must be a one char value");
 *
 * not use this file except in compliance with the License.
    @Override  
 * specific language governing permissions and limitations
        return new PathHierarchyTokenizer(bufferSize, delimiter, replacement, skip);
        super(indexSettings, settings, name);
/*  
 * Modifications Copyright OpenSearch Contributors. See
        this.reverse = settings.getAsBoolean("reverse", false);  
    PathHierarchyTokenizerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
            return new ReversePathHierarchyTokenizer(bufferSize, delimiter, replacement, skip);  
            this.replacement = this.delimiter;
 * under the License.  
        } else if (replacement.length() != 1) {  
 * KIND, either express or implied.  See the License for the
        if (reverse) {
 *
    private final boolean reverse;
    public Tokenizer create() {
import org.apache.lucene.analysis.Tokenizer;
 * software distributed under the License is distributed on an
import org.apache.lucene.analysis.path.ReversePathHierarchyTokenizer;  
import org.apache.lucene.analysis.path.PathHierarchyTokenizer;
}
    private final char replacement;
            throw new IllegalArgumentException("delimiter must be a one char value");
        }
        } else if (delimiter.length() != 1) {  
    private final char delimiter;
/*  
public class PathHierarchyTokenizerFactory extends AbstractTokenizerFactory {  
 * license agreements. See the NOTICE file distributed with
        String delimiter = settings.get("delimiter");  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
 */  
 *  
        bufferSize = settings.getAsInt("buffer_size", 1024);
 * this file be licensed under the Apache-2.0 license or a
        } else {
    }
 */  
        if (delimiter == null) {
        this.skip = settings.getAsInt("skip", PathHierarchyTokenizer.DEFAULT_SKIP);
import org.opensearch.index.IndexSettings;  
 */
import org.opensearch.env.Environment;
import org.opensearch.common.settings.Settings;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        }
            this.replacement = replacement.charAt(0);  
        String replacement = settings.get("replacement");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.analysis.common;
        } else {
    }  
 * this work for additional information regarding copyright
import org.opensearch.index.analysis.AbstractTokenizerFactory;
 * You may obtain a copy of the License at  
            this.delimiter = delimiter.charAt(0);  
    private final int skip;  
 * GitHub history for details.
        if (replacement == null) {
    private final int bufferSize;
            this.delimiter = PathHierarchyTokenizer.DEFAULT_DELIMITER;
        }
 * the Apache License, Version 2.0 (the "License"); you may
