 *    http://www.apache.org/licenses/LICENSE-2.0
 *
     * the user and a value. This value is the value that the decay function
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * The final scale parameter is computed from the scale parameter given by
 * compatible open source license.
 * distance. For example, this could be an exponential drop of, a triangle  
 * function or something of the kind. This is used, for example, by
    double evaluate(double value, double scale);
}
 */  
 * the Apache License, Version 2.0 (the "License"); you may
    Explanation explainFunction(String valueString, double value, double scale, @Nullable String functionName);
 * GitHub history for details.
 * under the License.  
public interface DecayFunction {  
 *
     *            the raw scale value given by the user
 * ownership. Elasticsearch licenses this file to you under  
/*  
     *            reaches this scale
     * should compute if document distance and user defined scale equal. The  
 */  
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
/*  
package org.opensearch.index.query.functionscore;
     * scale parameter for the function must be adjusted accordingly in this
     * function
 * license agreements. See the NOTICE file distributed with
     *            the value which decay function should take once the distance
     * */  
     * @param decay  
 * {@link GaussDecayFunctionBuilder}.
 * @opensearch.internal
    double processScale(double scale, double decay);
 */
 */
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
import org.apache.lucene.search.Explanation;
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
/**
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
 * Implement this interface to provide a decay function that is executed on a
 *  
import org.opensearch.common.Nullable;
     * @param scale
 * The OpenSearch Contributors require contributions made to  
/*
 * Licensed to Elasticsearch under one or more contributor  
     *  
 * Modifications Copyright OpenSearch Contributors. See
 *  
