 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
    public void recordAndRun() throws IOException {
 */
}
     * Returns the SearchPhase name as {@link SearchPhaseName}. Exception will come if SearchPhase name is not defined.  
    /**
 * Base class for all individual search phases like collecting distributed frequencies, fetching documents, querying shards.  
import java.io.IOException;  
 * The OpenSearch Contributors require contributions made to  
     * Returns an Optional of the SearchPhase name as {@link SearchPhaseName}. If there's not a matching SearchPhaseName,
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.api
    }  
    @Deprecated
        try {
    public String getName() {
/*
    private long startTimeInNanos;
     */
        this.name = Objects.requireNonNull(name, "name must not be null");
import java.util.Optional;  
 * specific language governing permissions and limitations
    public SearchPhaseName getSearchPhaseName() {  
     * @return {@link SearchPhaseName}  
    private final String name;  
 * You may obtain a copy of the License at  
/*  
    }
        return startTimeInNanos;
        return SearchPhaseName.valueOf(name.toUpperCase(Locale.ROOT));
    }  
 * ownership. Elasticsearch licenses this file to you under  
     * returns an empty Optional.  
     * Returns the phases name.
 * Licensed to Elasticsearch under one or more contributor  
 */  
 *
     * @deprecated Use getSearchPhaseNameOptional() to avoid possible exceptions.
 * Unless required by applicable law or agreed to in writing,
        } catch (IllegalArgumentException e) {  
     * @return {@link Optional<SearchPhaseName>}
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        run();
    public long getStartTimeInNanos() {
 * KIND, either express or implied.  See the License for the
 *
    protected SearchPhase(String name) {  
    /**
    }
 * compatible open source license.
    }
 * Modifications Copyright OpenSearch Contributors. See  
 * software distributed under the License is distributed on an
     * in {@link SearchPhaseName}
    }  
 * GitHub history for details.
        return name;
@PublicApi(since = "1.0.0")
    /**
 */  
            return Optional.of(SearchPhaseName.valueOf(name.toUpperCase(Locale.ROOT)));
 * not use this file except in compliance with the License.
        this.startTimeInNanos = System.nanoTime();  
        }
/*
            return Optional.empty();
public abstract class SearchPhase implements CheckedRunnable<IOException> {
 */
 * under the License.  
import org.opensearch.common.CheckedRunnable;  
     */
 *
package org.opensearch.action.search;
import java.util.Objects;
import java.util.Locale;
/**
import org.opensearch.common.annotation.PublicApi;
     */  
 * SPDX-License-Identifier: Apache-2.0
 *  
    public Optional<SearchPhaseName> getSearchPhaseNameOptional() {  
