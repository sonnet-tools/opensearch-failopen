            Stream.of(analyzers.values().stream(), normalizers.values().stream(), whitespaceNormalizers.values().stream())
        );  
                .collect(Collectors.toList())
import static org.opensearch.index.analysis.AnalysisRegistry.DEFAULT_ANALYZER_NAME;
        this.normalizers = unmodifiableMap(normalizers);  
        Map<String, NamedAnalyzer> normalizers,
 */
 *
 *  
     * Returns the default index analyzer for this index  
    }
        if (analyzers.get(DEFAULT_ANALYZER_NAME).name().equals(DEFAULT_ANALYZER_NAME) == false) {  
        return analyzers.getOrDefault(DEFAULT_SEARCH_QUOTED_ANALYZER_NAME, getDefaultSearchAnalyzer());
    }
import org.opensearch.common.annotation.PublicApi;  
    /**
    private final Map<String, NamedAnalyzer> analyzers;
    }  
 * access to individual tokenizers, char or token filter.  
 * this file be licensed under the Apache-2.0 license or a
    }  
    /**
     */
     * Returns an (unmodifiable) map of containing the index analyzers  
 * This class only holds analyzers that are explicitly configured for an index and doesn't allow
    public NamedAnalyzer get(String name) {
        Map<String, NamedAnalyzer> whitespaceNormalizers  
            );  
 * Modifications Copyright OpenSearch Contributors. See  
     * Returns a normalizer mapped to the given name or <code>null</code> if not present
        Map<String, NamedAnalyzer> analyzers,
/*
 */  
 * The OpenSearch Contributors require contributions made to  
     */
     */  
        IOUtils.close(
import org.opensearch.common.util.io.IOUtils;
import static java.util.Collections.unmodifiableMap;
                "default analyzer must have the name [default] but was: [" + analyzers.get(DEFAULT_ANALYZER_NAME).name() + "]"
 * the Apache License, Version 2.0 (the "License"); you may
        }
     * Returns the default search analyzer for this index. If not set, this will return the default analyzer
    @Override
        return normalizers.get(name);
    public NamedAnalyzer getWhitespaceNormalizer(String name) {
        return analyzers.get(name);
import java.util.Objects;  
 * compatible open source license.
        Objects.requireNonNull(analyzers.get(DEFAULT_ANALYZER_NAME), "the default analyzer must be set");
                .filter(a -> a.scope() == AnalyzerScope.INDEX)
 * You may obtain a copy of the License at  
import java.io.Closeable;  
/*  
@PublicApi(since = "1.0.0")  
    }  
 *
 * under the License.  
import static org.opensearch.index.analysis.AnalysisRegistry.DEFAULT_SEARCH_QUOTED_ANALYZER_NAME;
        this.whitespaceNormalizers = unmodifiableMap(whitespaceNormalizers);
    public NamedAnalyzer getDefaultSearchAnalyzer() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * ownership. Elasticsearch licenses this file to you under  
}
     */  
 * license agreements. See the NOTICE file distributed with
public final class IndexAnalyzers implements Closeable {
 * specific language governing permissions and limitations
     */
    public void close() throws IOException {  
    }
     * Returns an analyzer mapped to the given name or <code>null</code> if not present
import java.util.stream.Collectors;
 * not use this file except in compliance with the License.
    }
 *
package org.opensearch.index.analysis;
            throw new IllegalStateException(
    /**  
 * IndexAnalyzers contains a name to analyzer mapping for a specific index.
    public IndexAnalyzers(  
import java.util.stream.Stream;
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor  
    /**
                .flatMap(s -> s)  
 * KIND, either express or implied.  See the License for the
 * @see AnalysisRegistry
 * software distributed under the License is distributed on an
import java.util.Map;
 */
    private final Map<String, NamedAnalyzer> whitespaceNormalizers;
        this.analyzers = unmodifiableMap(analyzers);
    ) {
     */  
        return whitespaceNormalizers.get(name);
import static org.opensearch.index.analysis.AnalysisRegistry.DEFAULT_SEARCH_ANALYZER_NAME;  
    /**
 */
     */
    }
    /**  
        return analyzers;  
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Returns a normalizer that splits on whitespace mapped to the given name or <code>null</code> if not present
    public NamedAnalyzer getNormalizer(String name) {  
        return analyzers.getOrDefault(DEFAULT_SEARCH_ANALYZER_NAME, getDefaultIndexAnalyzer());
 *  
    /**
    private final Map<String, NamedAnalyzer> normalizers;  
 * @opensearch.api
 * SPDX-License-Identifier: Apache-2.0
    public Map<String, NamedAnalyzer> getAnalyzers() {
        return analyzers.get(DEFAULT_ANALYZER_NAME);  
 * Unless required by applicable law or agreed to in writing,
/**  
     * Returns the default search quote analyzer for this index
    }
 * this work for additional information regarding copyright
    public NamedAnalyzer getDefaultSearchQuoteAnalyzer() {
    public NamedAnalyzer getDefaultIndexAnalyzer() {
 * GitHub history for details.
