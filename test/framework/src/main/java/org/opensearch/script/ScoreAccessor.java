 * this file be licensed under the Apache-2.0 license or a
/*  
    }
    @Override  
/*  
    @Override
    public float floatValue() {  
    }
    @Override
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
 *  
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
    public long longValue() {
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor  
    }
    }  
import org.opensearch.search.lookup.DocLookup;
}
    Scorable scorer;
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.search.Scorable;
    }
        return score();
        } catch (IOException e) {
 *
        return (int) score();  
        return score();  
package org.opensearch.script;
 */  
 * <p>
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public double doubleValue() {
 *
 * specific language governing permissions and limitations
    public ScoreAccessor(Scorable scorer) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * for the current document.
/**  
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 */
    @Override
    }  
        }
 * the Apache License, Version 2.0 (the "License"); you may
        return (long) score();
/*
            return scorer.score();
 */  
        try {  
 * A float encapsulation that dynamically accesses the score of a document.
        this.scorer = scorer;
            throw new RuntimeException("Could not get score", e);  
public final class ScoreAccessor extends Number {  
    float score() {
 */
 * license agreements. See the NOTICE file distributed with
 * The provided {@link DocLookup} is used to retrieve the score  
    public int intValue() {
 * compatible open source license.
 * not use this file except in compliance with the License.
