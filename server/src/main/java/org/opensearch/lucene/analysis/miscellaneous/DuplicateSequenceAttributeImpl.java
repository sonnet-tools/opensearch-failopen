 * in sequence during text analysis. It maintains a count of prior occurrences of a token  
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * Implementation of {@link DuplicateSequenceAttribute} interface that tracks the number
 * The count is reset to zero when {@link #clear()} is called, typically at the beginning  
}  
public class DuplicateSequenceAttributeImpl extends AttributeImpl implements DuplicateSequenceAttribute {
        DuplicateSequenceAttributeImpl t = (DuplicateSequenceAttributeImpl) target;  
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
        t.numPriorUsesInASequence = numPriorUsesInASequence;
import org.apache.lucene.util.AttributeImpl;
    public void setNumPriorUsesInASequence(short len) {
    @Override
    }
 *
/*  
 *  
    public void copyTo(AttributeImpl target) {
 * SPDX-License-Identifier: Apache-2.0
 *
 * of times a token has appeared previously in a sequence during analysis.  
 *
    @Override  
 */  
    @Override
import org.apache.lucene.util.AttributeReflector;
    public short getNumPriorUsesInASequence() {
 * of processing a new token sequence.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
/*
    @Override
package org.opensearch.lucene.analysis.miscellaneous;
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
 * GitHub history for details.
    public void reflectWith(AttributeReflector reflector) {  
 * <p>
 */
 * this work for additional information regarding copyright
 * This attribute is used to identify and potentially handle duplicate tokens that occur
 * You may obtain a copy of the License at  
    }  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
        numPriorUsesInASequence = len;
        reflector.reflect(DuplicateSequenceAttribute.class, "sequenceLength", numPriorUsesInASequence);
 * this file be licensed under the Apache-2.0 license or a
        numPriorUsesInASequence = 0;
    }
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 * <p>
    public void clear() {  
 * Licensed to Elasticsearch under one or more contributor  
    protected short numPriorUsesInASequence = 0;  
 * in the current sequence.
/**
 */
    @Override
/*  
 * @see DuplicateSequenceAttribute  
        return numPriorUsesInASequence;  
 * compatible open source license.
 * specific language governing permissions and limitations
    }
