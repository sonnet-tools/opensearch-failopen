    public static ScoreSortBuilder scoreSort() {  
 */  
     *  
     *
 * ownership. Elasticsearch licenses this file to you under  
}
    /**
 * under the License.  
     * Constructs a new distance based sort on a geo point like field.  
 */  
    public static GeoDistanceSortBuilder geoDistanceSort(String fieldName, GeoPoint... points) {
    public static ShardDocSortBuilder shardDocSort() {
     *
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    public static GeoDistanceSortBuilder geoDistanceSort(String fieldName, String... geohashes) {  
        return new GeoDistanceSortBuilder(fieldName, geohashes);
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 *
     * @param geohashes The points to create the range distance facets from.
 *
     * @param script The script to use.
     */
/*  
     *  
    public static ScriptSortBuilder scriptSort(Script script, ScriptSortType type) {
     */  
     * Constructs a new script based sort.
    /**
 * KIND, either express or implied.  See the License for the
     * @param fieldName The geo point like field name.
     */
    }
     */
 * GitHub history for details.
 * @opensearch.internal
        return new ScoreSortBuilder();
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
     * A geo distance based sort.  
     * @param fieldName The geo point like field name.
/**
     * @param points The points to create the range distance facets from.  
    }
     * @param lat Latitude of the point to create the range distance facets from.  
 * this file be licensed under the Apache-2.0 license or a
    /**
     */
     *
    }  
     */  
public class SortBuilders {
 * A set of static factory methods for {@link SortBuilder}s.  
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
     * Constructs a new distance based sort on a geo point like field.
package org.opensearch.search.sort;
    }
/*
    public static FieldSortBuilder fieldSort(String field) {  
        return new GeoDistanceSortBuilder(fieldName, points);  
    }
     *
    }  
 * software distributed under the License is distributed on an
     */  
    public static GeoDistanceSortBuilder geoDistanceSort(String fieldName, double lat, double lon) {
 * not use this file except in compliance with the License.
    /**
     * @param field The field name.
import org.opensearch.search.sort.ScriptSortBuilder.ScriptSortType;  
     * @param lon Longitude of the point to create the range distance facets from.
import org.opensearch.script.Script;
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
 *  
    /**
     * @param type   The type, can either be "string" or "number".
        return new ShardDocSortBuilder();
        return new ScriptSortBuilder(script, type);
     * Constructs a new field based sort.
 *
 * Unless required by applicable law or agreed to in writing,
    /**  
        return new GeoDistanceSortBuilder(fieldName, lat, lon);
/*  
        return new FieldSortBuilder(field);
import org.opensearch.common.geo.GeoPoint;
 */
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
     * @param fieldName The geo point like field name.  
     * Constructs a new shard‐doc tiebreaker sort.
    /**  
     * Constructs a new score sort.
