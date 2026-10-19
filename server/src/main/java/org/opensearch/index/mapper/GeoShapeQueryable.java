 * ownership. Elasticsearch licenses this file to you under  
    @Deprecated
 * not use this file except in compliance with the License.
        ShapeRelation relation,
/**
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 * Implemented by {@link org.opensearch.index.mapper.MappedFieldType} that support
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        QueryShardContext context
        Geometry shape,
 * license agreements. See the NOTICE file distributed with
 */  
import org.opensearch.geometry.Geometry;
/*
 * software distributed under the License is distributed on an
import org.opensearch.common.geo.ShapeRelation;
 *  
 *
 * this work for additional information regarding copyright
/*  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.Query;
 * under the License.  
 * compatible open source license.
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * GeoShape queries.  
    Query geoShapeQuery(Geometry shape, String fieldName, ShapeRelation relation, QueryShardContext context);  
 */  
 * @opensearch.internal
 * KIND, either express or implied.  See the License for the
 */  
import org.opensearch.common.geo.SpatialStrategy;  
    }
import org.opensearch.index.query.QueryShardContext;
        SpatialStrategy strategy,  
 * You may obtain a copy of the License at  
    default Query geoShapeQuery(  
 * SPDX-License-Identifier: Apache-2.0
}  
package org.opensearch.index.mapper;
 *
        return geoShapeQuery(shape, fieldName, relation, context);
 * specific language governing permissions and limitations
    ) {  
/*  
public interface GeoShapeQueryable {
        String fieldName,
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
