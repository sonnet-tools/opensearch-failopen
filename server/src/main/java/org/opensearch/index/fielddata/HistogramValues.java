 */
     * Advance this instance to the given document id
 * this work for additional information regarding copyright
/*  
    public abstract boolean advanceExact(int doc) throws IOException;
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 *
 *
    /**
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Get the {@link HistogramValue} associated with the current document.
import java.io.IOException;
public abstract class HistogramValues {
package org.opensearch.index.fielddata;
 * compatible open source license.
    /**
 * not use this file except in compliance with the License.
 * under the License.  
 */  
 * KIND, either express or implied.  See the License for the
 *  
    public abstract HistogramValue histogram() throws IOException;
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.internal  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
/*
     */
 * software distributed under the License is distributed on an
 */  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * Per-segment histogram values.
 * Licensed to Elasticsearch under one or more contributor  
     * The returned {@link HistogramValue} might be reused across calls.  
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
/**  
 *
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
     * @return true if there is a value for this document  
     */
}
 * GitHub history for details.
