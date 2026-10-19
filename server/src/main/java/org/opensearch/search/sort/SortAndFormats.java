 * Licensed to Elasticsearch under one or more contributor  
 *
 *
 * not use this file except in compliance with the License.
/*
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.api
 * compatible open source license.
import org.opensearch.cluster.metadata.DataStream;
 */  
/*  
package org.opensearch.search.sort;
 * GitHub history for details.
 * this work for additional information regarding copyright
}  
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.DocValueFormat;  
        if (sort.getSort().length != formats.length) {
import org.apache.lucene.search.Sort;  
        this.sort = sort;
 */  
    public SortAndFormats(Sort sort, DocValueFormat[] formats) {
     * @return true: if sort is on timestamp field, false: otherwise
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See  
 * specific language governing permissions and limitations
 * under the License.  
        return sort.getSort().length > 0
 */
 */
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    public final Sort sort;
 * license agreements. See the NOTICE file distributed with
/**
    /**  
    }
import org.opensearch.common.annotation.PublicApi;
 * Utility class to hold sort and doc value format instances  
    public boolean isSortOnTimeSeriesField() {  
            throw new IllegalArgumentException("Number of sort field mismatch: " + sort.getSort().length + " != " + formats.length);  
 * Unless required by applicable law or agreed to in writing,
        }
 * software distributed under the License is distributed on an
     */
 *
            && sort.getSort()[0].getField() != null
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
/*
 *  
@PublicApi(since = "1.0.0")
            && sort.getSort()[0].getField().equals(DataStream.TIMESERIES_FIELDNAME);  
        this.formats = formats;  
public final class SortAndFormats {
    public final DocValueFormat[] formats;
 * You may obtain a copy of the License at  
