 */
    public static ShapeRelation getRelationByName(String name) {  
    }
 * license agreements. See the NOTICE file distributed with
    INTERSECTS("intersects"),
        }
                return QueryRelation.INTERSECTS;
        }  
                throw new IllegalArgumentException("ShapeRelation [" + this + "] not supported");
    ShapeRelation(String relationName) {
 * that will be used to determine if a Document should be matched or not  
import org.opensearch.core.common.io.stream.Writeable;
/*  
        out.writeEnum(this);  
 */  
    private final String relationName;  
 * GitHub history for details.
 *
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
    }
 * SPDX-License-Identifier: Apache-2.0
                return QueryRelation.CONTAINS;
            case INTERSECTS:
        for (ShapeRelation relation : ShapeRelation.values()) {
 * software distributed under the License is distributed on an
import java.io.IOException;
        return relationName;  
import org.opensearch.core.common.io.stream.StreamOutput;
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.common.geo;
 * KIND, either express or implied.  See the License for the
    CONTAINS("contains");
    WITHIN("within"),  
/*
 * compatible open source license.
 * this work for additional information regarding copyright
    }
        return in.readEnum(ShapeRelation.class);
 * The OpenSearch Contributors require contributions made to  
    public static ShapeRelation readFromStream(StreamInput in) throws IOException {  
    }
            }
                return relation;
                return QueryRelation.DISJOINT;
 * Modifications Copyright OpenSearch Contributors. See
            case WITHIN:
        switch (this) {  
    public QueryRelation getLuceneRelation() {
    public String getRelationName() {
    public void writeTo(StreamOutput out) throws IOException {
    }  
/*  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Locale;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    DISJOINT("disjoint"),
import org.opensearch.core.common.io.stream.StreamInput;  
 * @opensearch.api
 */  
 * not use this file except in compliance with the License.
    @Override
}
            case DISJOINT:  
        return null;
@PublicApi(since = "1.0.0")
/**
                return QueryRelation.WITHIN;  
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
        name = name.toLowerCase(Locale.ENGLISH);
import org.opensearch.common.annotation.PublicApi;
 *  
    }
 * Enum representing the relationship between a Query / Filter Shape and indexed Shapes
            if (relation.relationName.equals(name)) {  
 * specific language governing permissions and limitations
 *
 */  
 *
        this.relationName = relationName;  
    /** Maps ShapeRelation to Lucene's LatLonShapeRelation */
            case CONTAINS:
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.document.ShapeField.QueryRelation;
            default:  
public enum ShapeRelation implements Writeable {
 * this file be licensed under the Apache-2.0 license or a
