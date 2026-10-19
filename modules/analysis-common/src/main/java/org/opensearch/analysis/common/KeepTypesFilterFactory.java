            if (lc.equals("include")) {
 *  
 * <ul>
/*
 * software distributed under the License is distributed on an
            String lc = modeString.toLowerCase(Locale.ROOT);  
import org.opensearch.common.settings.Settings;  
import org.opensearch.index.IndexSettings;
                        + KeepTypesMode.EXCLUDE
 * Licensed to Elasticsearch under one or more contributor  
public class KeepTypesFilterFactory extends AbstractTokenFilterFactory {
        INCLUDE,  
    static final String KEEP_TYPES_MODE_KEY = "mode";  
 * <li>{@value #KEEP_TYPES_MODE_KEY} whether to keep ("include") or discard
 * compatible open source license.
import org.opensearch.env.Environment;
 * this work for additional information regarding copyright
            } else {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.analysis.TokenFilterFactory;
 */  
    private final Set<String> keepTypes;  
 * <li>{@value #KEEP_TYPES_KEY} the array of words / tokens.</li>  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.HashSet;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.includeMode = KeepTypesMode.fromString(settings.get(KEEP_TYPES_MODE_KEY, "include"));
                        + KeepTypesMode.INCLUDE
 * specific language governing permissions and limitations
        if ((arrayKeepTypes == null)) {
/*  
 * The OpenSearch Contributors require contributions made to  
                        + "] or ["  
 * not use this file except in compliance with the License.
import java.util.List;
 * </ul>  
/*  
        }  
        @Override  
 * SPDX-License-Identifier: Apache-2.0
 * ("exclude") the specified token types.</li>
    static final String KEEP_TYPES_KEY = "types";
        }
 * keep tokens that are contained in the set configured via
 */  
import java.util.Locale;
 * <p>  
    KeepTypesFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        final List<String> arrayKeepTypes = settings.getAsList(KEEP_TYPES_KEY, null);
            throw new IllegalArgumentException("keep_types requires `" + KEEP_TYPES_KEY + "` to be configured");  
/**
                return EXCLUDE;
        public String toString() {
 *
            } else if (lc.equals("exclude")) {  
        }
    @Override  
 *
 */
                        + "]."
        EXCLUDE;
 * Configuration options:
 * {@value #KEEP_TYPES_MODE_KEY} setting.
    enum KeepTypesMode {
            }  
 * You may obtain a copy of the License at  
    }
        super(indexSettings, name, settings);
 * GitHub history for details.
                        + modeString  
            return this.name().toLowerCase(Locale.ROOT);
import org.apache.lucene.analysis.TokenStream;
        this.keepTypes = new HashSet<>(arrayKeepTypes);  
    }  
                        + "] but was ["
                throw new IllegalArgumentException(  
    private final KeepTypesMode includeMode;
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
    public TokenStream create(TokenStream tokenStream) {
 * ownership. Elasticsearch licenses this file to you under  
                );
 * KIND, either express or implied.  See the License for the
 * under the License.  
                    "`keep_types` tokenfilter mode can only be ["
        private static KeepTypesMode fromString(String modeString) {
 * license agreements. See the NOTICE file distributed with
    }
}
 * Unless required by applicable law or agreed to in writing,
import java.util.Set;  
package org.opensearch.analysis.common;
 */
 * A {@link TokenFilterFactory} for {@link TypeTokenFilter}. This filter only  
        return new TypeTokenFilter(tokenStream, keepTypes, includeMode == KeepTypesMode.INCLUDE);
                return INCLUDE;
import org.apache.lucene.analysis.core.TypeTokenFilter;
 * this file be licensed under the Apache-2.0 license or a
