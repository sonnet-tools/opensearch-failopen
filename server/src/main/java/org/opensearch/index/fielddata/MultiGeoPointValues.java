    protected MultiGeoPointValues() {}
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
     */
 * ownership. Elasticsearch licenses this file to you under  
 *       GeoPoint value = values.valueAt(i);  
 *  
import java.io.IOException;
 *
     * Return the next value associated with the current document. This must not be
     * @return true if there is a value for this document  
     * Creates a new {@link MultiGeoPointValues} instance  
     *
    /**  
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 *   values.setDocId(docId);  
 * GitHub history for details.
 */
 * The OpenSearch Contributors require contributions made to  
 *   }
     */  
import org.opensearch.common.geo.GeoPoint;  
 * </pre>  
 */
 * this work for additional information regarding copyright
     * called more than {@link #docValueCount()} times.
 */
     * Return the number of geo points the current document has.
    public abstract int docValueCount();
/*  
/*
    /**
    public abstract boolean advanceExact(int doc) throws IOException;
 * A stateful lightweight per document set of {@link GeoPoint} values.
 */  
 *  
 * You may obtain a copy of the License at  
    /**
 *
public abstract class MultiGeoPointValues {  
 * SPDX-License-Identifier: Apache-2.0
     * @return the next value for the current docID set to {@link #advanceExact(int)}.  
 * comes in a non-specified order.
 *   for (int i = 0; i &lt; numValues; i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
 * The set of values associated with a document might contain duplicates and
 * the Apache License, Version 2.0 (the "License"); you may
 *   GeoPointValues values = ..;
 * <pre>
 * KIND, either express or implied.  See the License for the
/*
/**
     * Advance this instance to the given document id
    public abstract GeoPoint nextValue() throws IOException;
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
    /**
 * compatible open source license.
 * under the License.  
 * @opensearch.internal
     * <p>  
 *       // process value
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
}
 *   final int numValues = values.count();
package org.opensearch.index.fielddata;
 * Modifications Copyright OpenSearch Contributors. See  
     * Note: the returned {@link GeoPoint} might be shared across invocations.
 * To iterate over values in a document use the following pattern:  
     */
