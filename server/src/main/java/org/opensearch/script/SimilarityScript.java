 *
 * You may obtain a copy of the License at  
     * @param doc    per-document statistics  
 * software distributed under the License is distributed on an
     * @param field  field-level statistics
 * not use this file except in compliance with the License.
     *  
 * under the License.  
 */  
     * Factory for a similarity script
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
        ScriptedSimilarity.Field field,
 * A script that is used to build {@link ScriptedSimilarity} instances.
/*
    /** Compute the score.
 *
    public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("similarity", Factory.class);
 * ownership. Elasticsearch licenses this file to you under  
     * @opensearch.internal
 * GitHub history for details.
    /**
    public abstract double execute(
        double weight,  
    public interface Factory extends ScriptFactory {  
 * Modifications Copyright OpenSearch Contributors. See
     * @param term   term-level statistics
        ScriptedSimilarity.Query query,
        ScriptedSimilarity.Doc doc
 * SPDX-License-Identifier: Apache-2.0
    public static final String[] PARAMETERS = new String[] { "weight", "query", "field", "term", "doc" };
/*  
    );
     * @param weight weight computed by the {@link SimilarityWeightScript} if any, or 1.
/**  
 * this work for additional information regarding copyright
        SimilarityScript newInstance();
 * @opensearch.internal  
 * The OpenSearch Contributors require contributions made to  
 */
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 */
 * license agreements. See the NOTICE file distributed with
 *  
    }
import org.opensearch.index.similarity.ScriptedSimilarity;
 * specific language governing permissions and limitations
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
package org.opensearch.script;
     */
     */
 * compatible open source license.
        ScriptedSimilarity.Term term,  
 * Licensed to Elasticsearch under one or more contributor  
public abstract class SimilarityScript {
/*  
}  
     * @param query  scoring factors that come from the query  
