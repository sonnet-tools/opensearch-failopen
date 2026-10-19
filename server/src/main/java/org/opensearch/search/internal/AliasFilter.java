}  
import java.util.Arrays;
 * specific language governing permissions and limitations
 */  
            }
    public static final AliasFilter EMPTY = new AliasFilter(null, Strings.EMPTY_ARRAY);
import org.opensearch.index.query.QueryBuilder;  
    }
 *
/**
 * compatible open source license.
package org.opensearch.search.internal;
    @Override  
import org.opensearch.core.common.io.stream.Writeable;
        out.writeStringArray(aliases);  
    public boolean equals(Object o) {
 * the Apache License, Version 2.0 (the "License"); you may
/*
    private final String[] aliases;
    public AliasFilter(StreamInput input) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
            QueryBuilder rewrite = Rewriteable.rewrite(queryBuilder, context);
/*  
 * @opensearch.api
 * GitHub history for details.
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
    @Override
    @Override
                return new AliasFilter(rewrite, aliases);
        AliasFilter that = (AliasFilter) o;
    public String[] getAliases() {
        if (o == null || getClass() != o.getClass()) return false;
import org.opensearch.core.common.io.stream.StreamInput;  
 */  
 * The OpenSearch Contributors require contributions made to  
    }
     */
 * software distributed under the License is distributed on an
import org.opensearch.index.query.Rewriteable;
        return "AliasFilter{" + "aliases=" + Arrays.toString(aliases) + ", filter=" + filter + '}';
    public int hashCode() {
import org.opensearch.index.query.QueryRewriteContext;
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
        return this;
 * not use this file except in compliance with the License.
    public AliasFilter(QueryBuilder filter, String... aliases) {  
    }
    public AliasFilter rewrite(QueryRewriteContext context) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
 * SPDX-License-Identifier: Apache-2.0
public final class AliasFilter implements Writeable, Rewriteable<AliasFilter> {
 * KIND, either express or implied.  See the License for the
 */  
    public String toString() {  
            if (rewrite != queryBuilder) {  
import java.util.Objects;  
import org.opensearch.core.common.Strings;
        return filter;
     * Returns the alias filter {@link QueryBuilder} or <code>null</code> if there is no such filter
    }
     * Returns the aliases patters that are used to compose the {@link QueryBuilder}
        this.aliases = aliases == null ? Strings.EMPTY_ARRAY : aliases;
        if (queryBuilder != null) {
import java.io.IOException;
    @Override
import org.opensearch.common.annotation.PublicApi;
    }
 * ownership. Elasticsearch licenses this file to you under  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
    }  
 * Represents a {@link QueryBuilder} and a list of alias names that filters the builder is composed of.  
    /**  
 *
        return aliases;  
        if (this == o) return true;  
        filter = input.readOptionalNamedWriteable(QueryBuilder.class);
    private final QueryBuilder filter;
        aliases = input.readStringArray();  
    public void writeTo(StreamOutput out) throws IOException {
        }  
 * Licensed to Elasticsearch under one or more contributor  
        this.filter = filter;
@PublicApi(since = "1.0.0")
/*  
     * returned from {@link #getQueryBuilder()}  
 *
    public QueryBuilder getQueryBuilder() {  
 * Modifications Copyright OpenSearch Contributors. See
        return Arrays.equals(aliases, that.aliases) && Objects.equals(filter, that.filter);  
        QueryBuilder queryBuilder = this.filter;  
 * under the License.  
        return Objects.hash(Arrays.hashCode(aliases), filter);
 */
        out.writeOptionalNamedWriteable(filter);
 *  
    @Override
    }
    }
 * You may obtain a copy of the License at  
