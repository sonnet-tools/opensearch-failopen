public interface DuplicateSequenceAttribute extends Attribute {  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
    void setNumPriorUsesInASequence(short len);
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * You may obtain a copy of the License at  
     */
 * license agreements. See the NOTICE file distributed with
    short getNumPriorUsesInASequence();
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 *
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
package org.opensearch.lucene.analysis.miscellaneous;
 * the Apache License, Version 2.0 (the "License"); you may
 */
 */
/*  
/**  
 */  
    /**
 * Provides statistics useful for detecting duplicate sections of text
import org.apache.lucene.util.Attribute;
 * under the License.  
}
 * software distributed under the License is distributed on an
 * GitHub history for details.
     *         of a sequence (counts to a max of 255)  
/*
/*  
 * specific language governing permissions and limitations
     * @return The number of times this token has been seen previously as part
 */  
