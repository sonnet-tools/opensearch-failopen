    double getCovariance(String fieldX, String fieldY);
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
}
    double getKurtosis(String field);
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See  
package org.opensearch.search.aggregations.matrix.stats;
 * SPDX-License-Identifier: Apache-2.0
public interface MatrixStats extends Aggregation {
 * You may obtain a copy of the License at  
/*
    /** return the total document count */  
/*  
 */
 *
    /** return the kurtosis of the distribution */  
    long getFieldCount(String field);
/*
/**
 * license agreements. See the NOTICE file distributed with
    double getCorrelation(String fieldX, String fieldY);
 *  
 * this file be licensed under the Apache-2.0 license or a
    /** return the field mean */  
 * The OpenSearch Contributors require contributions made to  
    /** return the covariance between field x and field y */  
    /** return the field variance */  
 */
 * compatible open source license.
 *
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
    /** return total field count (differs from docCount if there are missing values) */  
    long getDocCount();
 */  
 * the Apache License, Version 2.0 (the "License"); you may
    /** return the skewness of the distribution */  
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    double getVariance(String field);
    double getSkewness(String field);
 * Interface for MatrixStats Metric Aggregation  
    double getMean(String field);
 * under the License.  
 */
 * this work for additional information regarding copyright
    /** return the correlation coefficient of field x and field y */  
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.Aggregation;  
