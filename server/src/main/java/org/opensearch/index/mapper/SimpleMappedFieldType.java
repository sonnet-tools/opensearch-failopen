    }
    ) {
public abstract class SimpleMappedFieldType extends MappedFieldType {
        return rangeQuery(lowerTerm, upperTerm, includeLower, includeUpper, context);
 * not use this file except in compliance with the License.
import org.opensearch.index.query.QueryShardContext;
        boolean includeLower,
 * You may obtain a copy of the License at  
        boolean isStored,
import org.apache.lucene.search.Query;
    }
 * the Apache License, Version 2.0 (the "License"); you may
        Object lowerTerm,
 * @opensearch.internal  
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
 *  
import org.opensearch.common.time.DateMathParser;  
import java.time.ZoneId;  
 * this file be licensed under the Apache-2.0 license or a
        // but then the API has no way to know which fields are dates and which fields are not dates
 */  
 *
 */  
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
        ShapeRelation relation,  
 * Modifications Copyright OpenSearch Contributors. See
        DateMathParser parser,
    protected Query rangeQuery(Object lowerTerm, Object upperTerm, boolean includeLower, boolean includeUpper, QueryShardContext context) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (relation == ShapeRelation.DISJOINT) {
        ZoneId timeZone,
/*
 * {@link MappedFieldType} base impl for field types that are neither dates nor ranges.
        boolean isSearchable,  
 * KIND, either express or implied.  See the License for the
    public final Query rangeQuery(
 * software distributed under the License is distributed on an
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
 */
    /**
 */
 * this work for additional information regarding copyright
        // We do not fail on non-null time zones and date parsers
import org.opensearch.common.geo.ShapeRelation;
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
        boolean hasDocValues,
    ) {
    protected SimpleMappedFieldType(
 *
        TextSearchInfo textSearchInfo,  
 *
        super(name, isSearchable, isStored, hasDocValues, textSearchInfo, meta);  
/**  
package org.opensearch.index.mapper;
        Object upperTerm,  
}
        // The reasoning is that on query parsers, you might want to set a time zone or format for date fields  
        boolean includeUpper,
 * Unless required by applicable law or agreed to in writing,
        QueryShardContext context  
 * specific language governing permissions and limitations
        }
/*  
import java.util.Map;
/*  
        Map<String, String> meta
     * Same as {@link #rangeQuery(Object, Object, boolean, boolean, ShapeRelation, ZoneId, DateMathParser, QueryShardContext)}  
            throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] does not support DISJOINT ranges");  
        String name,
        throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] does not support range queries");
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
     * but without the trouble of relations or date-specific options.
     */
