     * @param max   The maximum number of slices
    protected final boolean contains(long value) {
    private final int max;
 * license agreements. See the NOTICE file distributed with
}  
import org.apache.lucene.search.QueryVisitor;
 * KIND, either express or implied.  See the License for the
    /**
    public void visit(QueryVisitor visitor) {
import java.util.Objects;
        SliceQuery that = (SliceQuery) o;
 * not use this file except in compliance with the License.
    public int getMax() {
    public int hashCode() {  
/*  
 * compatible open source license.
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
        }  
    public boolean equals(Object o) {  
/**  
    public int getId() {  
    }  
import org.apache.lucene.search.Query;
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.search.slice;
    // Returns true if the value matches the predicate  
/*
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
        this.id = id;
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public abstract class SliceQuery extends Query {
        return Objects.hash(classHash(), field, id, max);
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
    private final int id;
 *
    private final String field;  
    }
        return field;  
 * Licensed to Elasticsearch under one or more contributor  
        return max;
    @Override
    @Override
        }
    }
        return id;
        return Math.floorMod(value, max) == id;
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
 */  
    }  
 */
 *
    public String getField() {
    }
     */
    @Override
    public String toString(String f) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
/*  
    @Override  
     * @param field The name of the field
    }
        if (sameClassAs(o) == false) {
 * GitHub history for details.
     * @param id    The id of the slice  
        if (visitor.acceptField(field)) {
            visitor.visitLeaf(this);  
 * The OpenSearch Contributors require contributions made to  
    public SliceQuery(String field, int id, int max) {  
    }  
        return field.equals(that.field) && id == that.id && max == that.max;
 *  
        return getClass().getSimpleName() + "[field=" + field + ", id=" + id + ", max=" + max + "]";  
 */
        this.field = field;
 *
            return false;
    }
 * An abstract {@link Query} that defines an hash function to partition the documents in multiple slices.
 */  
        this.max = max;  
