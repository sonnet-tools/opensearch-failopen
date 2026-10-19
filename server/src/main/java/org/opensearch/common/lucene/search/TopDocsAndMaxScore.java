@PublicApi(since = "1.0.0")
 * @opensearch.api
 */  
/*  
 *  
 * under the License.  
 * software distributed under the License is distributed on an
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 *
        this.topDocs = topDocs;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 */
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.common.lucene.search;
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 */
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
public final class TopDocsAndMaxScore {
 * Unless required by applicable law or agreed to in writing,
/*  
    public float maxScore;
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
}  
import org.opensearch.common.annotation.PublicApi;
 * You may obtain a copy of the License at  
    }
 * The OpenSearch Contributors require contributions made to  
    public TopDocsAndMaxScore(TopDocs topDocs, float maxScore) {
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * Wrapper around a {@link TopDocs} instance and the maximum score.
/**
        this.maxScore = maxScore;  
    public final TopDocs topDocs;
// TODO: Remove this class when https://github.com/elastic/elasticsearch/issues/32981 is addressed.  
/*
import org.apache.lucene.search.TopDocs;
 *  
 * GitHub history for details.
