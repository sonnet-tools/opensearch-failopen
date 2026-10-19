 *    http://www.apache.org/licenses/LICENSE-2.0
    public List<? extends GeoGrid.Bucket> getBuckets() {  
        return parser;
 * compatible open source license.
        ObjectParser<ParsedGeoGrid, Void> parser = new ObjectParser<>(ParsedGeoGrid.class.getSimpleName(), true, supplier);  
        declareMultiBucketAggregationFields(parser, bucketParser, keyedBucketParser);
    }
    }
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
/*  
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
public abstract class ParsedGeoGrid extends ParsedMultiBucketAggregation<ParsedGeoGridBucket> implements GeoGrid {  
import java.io.IOException;  
import org.opensearch.core.xcontent.XContentParser;  
}
        CheckedFunction<XContentParser, ParsedBucket, IOException> keyedBucketParser
/*  
 * A geo grid result parsed between nodes
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.api
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * Modifications Copyright OpenSearch Contributors. See
 */
    ) {
/*
 * this work for additional information regarding copyright
 *
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
 * under the License.  
import org.opensearch.common.CheckedFunction;
 *  
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
        CheckedFunction<XContentParser, ParsedBucket, IOException> bucketParser,  
    public static ObjectParser<ParsedGeoGrid, Void> createParser(
 * SPDX-License-Identifier: Apache-2.0
    public void setName(String name) {
    @Override
 * KIND, either express or implied.  See the License for the
        Supplier<ParsedGeoGrid> supplier,
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
package org.opensearch.geo.search.aggregations.bucket.geogrid;
        super.setName(name);  
import java.util.function.Supplier;
 */  
 *
import java.util.List;
/**
 *  
    }  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.ObjectParser;
        return buckets;
