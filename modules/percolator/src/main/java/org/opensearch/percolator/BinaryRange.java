 * Modifications Copyright OpenSearch Contributors. See  
        super(name, TYPE);  
 * the Apache License, Version 2.0 (the "License"); you may
    static {  
 * KIND, either express or implied.  See the License for the
     */
    /** The number of bytes per dimension, use {@link InetAddressPoint#BYTES} as max, because that is maximum we need to support */
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (encodedRange.length != BYTES * 2) {
    /**  
     * @return query for matching intersecting encoded ranges (overlap, within, crosses, or contains)
 * You may obtain a copy of the License at  
}  
    }
 *
     * @throws IllegalArgumentException if {@code field} is null, {@code min} or {@code max} is invalid  
        TYPE = new FieldType();
            protected String toString(byte[] ranges, int dimension) {  
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.search.Query;
 * not use this file except in compliance with the License.
     * Create a query for matching indexed ip ranges that {@code INTERSECT} the defined range.
 * license agreements. See the NOTICE file distributed with
    }
import org.apache.lucene.document.FieldType;
 * The OpenSearch Contributors require contributions made to  
        TYPE.setDimensions(2, BYTES);
/*
     * @param encodedRange  Encoded range
import org.apache.lucene.document.RangeFieldQuery;  
        TYPE.freeze();  
import org.apache.lucene.document.Field;  
    /**
 * A range field for binary encoded ranges
        fieldsData = new BytesRef(encodedRange);
            }
 * Unless required by applicable law or agreed to in writing,
            @Override
package org.opensearch.percolator;
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalArgumentException("Unexpected encoded range length [" + encodedRange.length + "]");
    public static final int BYTES = InetAddressPoint.BYTES;  
    }
 */
                return "[" + new BytesRef(ranges, 0, BYTES) + " TO " + new BytesRef(ranges, BYTES, BYTES) + "]";
public final class BinaryRange extends Field {
        };  
    }
 * ownership. Elasticsearch licenses this file to you under  
     * @param field         field name. must not be null.  
 * Licensed to Elasticsearch under one or more contributor  
    static Query newRelationQuery(String field, byte[] encodedRange, RangeFieldQuery.QueryType relation) {  
     */
 * under the License.  
 * GitHub history for details.
/*
 * SPDX-License-Identifier: Apache-2.0
        return new RangeFieldQuery(field, encodedRange, 1, relation) {
 * compatible open source license.
     * Create a new BinaryRange from a provided encoded binary range
 */  
     * @param encodedRange      Encoded range  
        }  
/**
    public static Query newIntersectsQuery(String field, byte[] encodedRange) {
import org.apache.lucene.document.InetAddressPoint;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 *
     * @param name              field name. must not be null.
 */
/*  
    private static final FieldType TYPE;
    public BinaryRange(String name, byte[] encodedRange) {
        return newRelationQuery(field, encodedRange, RangeFieldQuery.QueryType.INTERSECTS);  
