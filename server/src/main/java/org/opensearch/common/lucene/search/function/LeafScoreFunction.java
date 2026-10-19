 */  
    public abstract double score(int docId, float subQueryScore) throws IOException;  
 * under the License.  
 *
 *
/**
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
}
 *  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.search.Explanation;
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
/*
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
public abstract class LeafScoreFunction {
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
/*  
/*  
 * Modifications Copyright OpenSearch Contributors. See
    public abstract Explanation explainScore(int docId, Explanation subQueryScore) throws IOException;
package org.opensearch.common.lucene.search.function;
 * Per-leaf {@link ScoreFunction}.  
 *
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 */  
import java.io.IOException;  
 * @opensearch.internal
 * compatible open source license.
