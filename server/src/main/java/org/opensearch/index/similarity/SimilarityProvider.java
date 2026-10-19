 * Unless required by applicable law or agreed to in writing,
@PublicApi(since = "1.0.0")
 * license agreements. See the NOTICE file distributed with
     */
 */  
 *
/**  
    public SimilarityProvider(String name, Similarity similarity) {
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 *
}  
 */
    private final Similarity similarity;  
 * Wrapper around a {@link Similarity} and its name.
 * ownership. Elasticsearch licenses this file to you under  
     * Return the name of this {@link Similarity}.
    @Override
 * under the License.  
     * Return the wrapped {@link Similarity}.  
 *  
    public String name() {
    public Similarity get() {
          This is not entirely correct though but we only use equality checks
     */  
 * this file be licensed under the Apache-2.0 license or a
    public int hashCode() {  
 * You may obtain a copy of the License at  
        this.similarity = similarity;
 * KIND, either express or implied.  See the License for the
import java.util.Objects;
        this.name = name;  
/*
        return Objects.hash(name);
        /*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
          re-created for each new instance and they don't implement equals.  
        if (o == null || getClass() != o.getClass()) return false;  
    public boolean equals(Object o) {
    }
        if (this == o) return true;
    @Override  
 */
public final class SimilarityProvider {  
          We use <code>name</code> only because the <code>similarity</code> is
          This is not entirely correct though but we only use equality checks
import org.opensearch.common.annotation.PublicApi;
         */
         */  
 * compatible open source license.
        return similarity;  
 * not use this file except in compliance with the License.
    }  
import org.apache.lucene.search.similarities.Similarity;
    private final String name;
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.api  
        return Objects.equals(name, that.name);
          for similarities inside the same index and names are unique in this case.  
    }
/*  
        /*
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.index.similarity;
 *
    }
 */  
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
    }  
 * this work for additional information regarding copyright
          for similarities a single index and names are unique in this case.
/*  
 * SPDX-License-Identifier: Apache-2.0
        SimilarityProvider that = (SimilarityProvider) o;
          re-created for each new instance and they don't implement equals.
        return name;
          We check <code>name</code> only because the <code>similarity</code> is  
