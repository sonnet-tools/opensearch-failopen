 * You may obtain a copy of the License at  
     * @param query  scoring factors that come from the query
 * not use this file except in compliance with the License.
 * A script that is used to compute scoring factors that are the same for all documents.
 * compatible open source license.
     *
 * GitHub history for details.
     */
 */
 * Unless required by applicable law or agreed to in writing,
     * @param field  field-level statistics  
package org.opensearch.script;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
     * @param term   term-level statistics
 */  
 * The OpenSearch Contributors require contributions made to  
public abstract class SimilarityWeightScript {
 * the Apache License, Version 2.0 (the "License"); you may
 *
 */  
     */  
     * Factory for a similarity weight script  
    public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("similarity_weight", Factory.class);  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
    public abstract double execute(ScriptedSimilarity.Query query, ScriptedSimilarity.Field field, ScriptedSimilarity.Term term);  
/*
    public static final String[] PARAMETERS = new String[] { "query", "field", "term" };
 * specific language governing permissions and limitations
 *
 * this work for additional information regarding copyright
     * @opensearch.internal
}
 * this file be licensed under the Apache-2.0 license or a
    /** Compute the weight.
    }  
        SimilarityWeightScript newInstance();
    /**
 * @opensearch.internal  
 *  
 *
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.similarity.ScriptedSimilarity;
 * Modifications Copyright OpenSearch Contributors. See
 */
 * under the License.  
 * license agreements. See the NOTICE file distributed with
/**  
    public interface Factory extends ScriptFactory {
/*  
