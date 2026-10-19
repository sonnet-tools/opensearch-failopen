 *
public abstract class HistogramValue {  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
    /**
 * this work for additional information regarding copyright
     * The current count of the histogram  
     */
     * Advance this instance to the next value of the histogram  
import java.io.IOException;
    public abstract int count();  
 * Licensed to Elasticsearch under one or more contributor  
     * @return true if there is a next value
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @return the current count of the histogram
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
 */
 *  
    /**
 * You may obtain a copy of the License at  
 */  
/*
}
     */
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
     */
/*  
 * a value and a count.
 * the Apache License, Version 2.0 (the "License"); you may
    /**
 * license agreements. See the NOTICE file distributed with
/**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
     * the current value of the histogram  
 * KIND, either express or implied.  See the License for the
 *
 *  
 * GitHub history for details.
package org.opensearch.index.fielddata;
    public abstract boolean next() throws IOException;  
     * @return the current value of the histogram
 */
 */  
    public abstract double value();  
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
 * Per-document histogram value. Every value of the histogram consist on
