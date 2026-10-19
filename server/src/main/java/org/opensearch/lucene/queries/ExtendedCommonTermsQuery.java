    public String getLowFreqMinimumNumberShouldMatchSpec() {
    public void setLowFreqMinimumNumberShouldMatch(String spec) {  
        return Queries.calculateMinShouldMatch(numOptional, spec);
        return highFreqMinNumShouldMatchSpec;  
 * @deprecated Since max_optimization optimization landed in 7.0, normal MatchQuery
    }  
 *
    @Override
    }
 * Extended version of {@link CommonTermsQuery} that allows to pass in a  
 * not use this file except in compliance with the License.
package org.opensearch.lucene.queries;
    protected int calcLowFreqMinimumNumberShouldMatch(int numOptional) {  
        super(highFreqOccur, lowFreqOccur, maxTermFrequency);
 */  
        }
    private String highFreqMinNumShouldMatchSpec;  
        return lowFreqMinNumShouldMatchSpec;
        return this.maxTermFrequency;  
@Deprecated
 * this work for additional information regarding copyright
    }  
    public ExtendedCommonTermsQuery(Occur highFreqOccur, Occur lowFreqOccur, float maxTermFrequency) {
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
/**
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
            return 0;  
import org.opensearch.common.lucene.search.Queries;  
/*  
 * to calculate the minimum matching terms.
    protected int calcMinimumNumberShouldMatch(String spec, int numOptional) {
 */  
}  
 * specific language governing permissions and limitations
 *
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.queries.CommonTermsQuery;
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
        if (spec == null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    public float getMaxTermFrequency() {
    }
    @Override
        this.highFreqMinNumShouldMatchSpec = spec;
/*
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
    private String lowFreqMinNumShouldMatchSpec;
import org.apache.lucene.search.BooleanClause.Occur;
 * GitHub history for details.
    protected int calcHighFreqMinimumNumberShouldMatch(int numOptional) {  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 *  
    }
 *             will achieve the same result without any configuration.
/*  
    }  
    }  
    }
        this.lowFreqMinNumShouldMatchSpec = spec;
    public String getHighFreqMinimumNumberShouldMatchSpec() {
 */
    public void setHighFreqMinimumNumberShouldMatch(String spec) {
        return calcMinimumNumberShouldMatch(lowFreqMinNumShouldMatchSpec, numOptional);
 * Licensed to Elasticsearch under one or more contributor  
        return calcMinimumNumberShouldMatch(highFreqMinNumShouldMatchSpec, numOptional);
 * {@code minimumNumberShouldMatch} specification that uses the actual num of high frequent terms
 */  
    }
public class ExtendedCommonTermsQuery extends CommonTermsQuery {
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
