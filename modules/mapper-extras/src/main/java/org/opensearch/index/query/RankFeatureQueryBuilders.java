     * @param scalingFactor scaling factor applied before taking the logarithm, must be in [1, +Infinity)
     * Return a new {@link RankFeatureQueryBuilder} that will score documents as
    }  
     * @param fieldName     field that stores features
/*  
    /**
 * software distributed under the License is distributed on an
     */  
 */  
    }
 * GitHub history for details.
     */
     * {@code boost * Math.log(scalingFactor + S)} where S is the value of the static feature.
package org.opensearch.index.query;
     * Return a new {@link RankFeatureQueryBuilder} that will score documents as
     * Return a new {@link RankFeatureQueryBuilder} that will score documents as
     */
 * You may obtain a copy of the License at  
     * @param fieldName   field that stores features
     * is computed based on index statistics and is approximately equal to the geometric mean of all
     * values that exist in the index.
     */
     * @param exp         exponent, higher values make the function grow slower before 'pivot' and faster after 'pivot',  
     * @param pivot       feature value that would give a score contribution equal to weight/2, must be in (0, +Infinity)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
 * Modifications Copyright OpenSearch Contributors. See
    /**
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
    }
    public static RankFeatureQueryBuilder log(String fieldName, float scalingFactor) {  
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
     * {@code S)} where S is the indexed value of the static feature.  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
}
    }
 *
 *  
    /**  
     * @param fieldName   field that stores features
 * Unless required by applicable law or agreed to in writing,
    /**
    /**
        return new RankFeatureQueryBuilder(fieldName, new RankFeatureQueryBuilder.ScoreFunction.Log(scalingFactor));
     *                    must be in (0, +Infinity)
        return new RankFeatureQueryBuilder(fieldName, new RankFeatureQueryBuilder.ScoreFunction.Sigmoid(pivot, exp));
        return new RankFeatureQueryBuilder(fieldName, new RankFeatureQueryBuilder.ScoreFunction.Saturation());  
    public static RankFeatureQueryBuilder saturation(String fieldName, float pivot) {
    public static RankFeatureQueryBuilder linear(String fieldName) {  
     * @param pivot       feature value that would give a score contribution equal to weight/2, must be in (0, +Infinity)
    public static RankFeatureQueryBuilder saturation(String fieldName) {
/*  
     * {@code boost * S^a / (S^a + pivot^a)} where S is the value of the static feature.  
 * Licensed to Elasticsearch under one or more contributor  
 *
     * {@code boost * S / (S + pivot)} where S is the value of the static feature.  
     * @param fieldName     field that stores features  
 * not use this file except in compliance with the License.
    public static RankFeatureQueryBuilder sigmoid(String fieldName, float pivot, float exp) {  
        return new RankFeatureQueryBuilder(fieldName, new RankFeatureQueryBuilder.ScoreFunction.Linear());
        return new RankFeatureQueryBuilder(fieldName, new RankFeatureQueryBuilder.ScoreFunction.Saturation(pivot));
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
 */  
     * Same as {@link #saturation(String, float)} but a reasonably good default pivot value  
public final class RankFeatureQueryBuilders {
/*
 * compatible open source license.
 */
     * Return a new {@link RankFeatureQueryBuilder} that will score documents as
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
    private RankFeatureQueryBuilders() {}
     * @param fieldName   field that stores features  
