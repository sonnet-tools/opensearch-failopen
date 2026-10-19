 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.common.util.set.Sets.newHashSet;  
    @Override  
 * specific language governing permissions and limitations
    public Reader create(Reader tokenStream) {
        if (escapedTags.size() > 0) {
import java.util.List;
/*  
        }  
    HtmlStripCharFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
 * KIND, either express or implied.  See the License for the
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;
package org.opensearch.analysis.common;
    }
 * the Apache License, Version 2.0 (the "License"); you may
 *
            this.escapedTags = null;
import org.opensearch.index.IndexSettings;
 */  
/*  
 * compatible open source license.
 *  
 *
    private final Set<String> escapedTags;  
public class HtmlStripCharFilterFactory extends AbstractCharFilterFactory {
 * Licensed to Elasticsearch under one or more contributor  
}
 * software distributed under the License is distributed on an
import static java.util.Collections.unmodifiableSet;
import org.opensearch.index.analysis.AbstractCharFilterFactory;
import org.apache.lucene.analysis.charfilter.HTMLStripCharFilter;
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
import java.util.Set;  
 * GitHub history for details.
 */  
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
        super(indexSettings, name);  
    }  
 * The OpenSearch Contributors require contributions made to  
        List<String> escapedTags = settings.getAsList("escaped_tags");
import java.io.Reader;
import org.opensearch.env.Environment;  
            this.escapedTags = unmodifiableSet(newHashSet(escapedTags));  
        return new HTMLStripCharFilter(tokenStream, escapedTags);
 * license agreements. See the NOTICE file distributed with
 */
        } else {
 * Modifications Copyright OpenSearch Contributors. See
