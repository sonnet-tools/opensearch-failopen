 */  
/**  
 * KIND, either express or implied.  See the License for the
/*  
 * ownership. Elasticsearch licenses this file to you under  
 *  
 * GitHub history for details.
import org.opensearch.search.aggregations.Aggregation;
/*
/*
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
 *
    @Override  
 */
 * this work for additional information regarding copyright
 * compatible open source license.
package org.opensearch.geo.search.aggregations.bucket.geogrid;
    protected String hashAsString;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 */
 * You may obtain a copy of the License at  
    }  
 * under the License.  
 * @opensearch.api  
}
 * The OpenSearch Contributors require contributions made to  
        return builder.field(Aggregation.CommonFields.KEY.getPreferredName(), hashAsString);
import org.opensearch.core.xcontent.XContentBuilder;  
 * Licensed to Elasticsearch under one or more contributor  
 * A single geo grid bucket result parsed between nodes
 *
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
 *
 * SPDX-License-Identifier: Apache-2.0
 */
 * Modifications Copyright OpenSearch Contributors. See  
public abstract class ParsedGeoGridBucket extends ParsedMultiBucketAggregation.ParsedBucket implements GeoGrid.Bucket {
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
