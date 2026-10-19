 * this work for additional information regarding copyright
 */
 * specific language governing permissions and limitations
 *  
/*  
import org.apache.lucene.search.highlight.Encoder;
 * SPDX-License-Identifier: Apache-2.0
 * Direct Subclass of Lucene's org.apache.lucene.search.vectorhighlight.SimpleFragmentsBuilder
    protected String makeFragment(  
 */
 *
 *  
        WeightedFragInfo fragInfo,
    @Override
import org.apache.lucene.search.vectorhighlight.BoundaryScanner;
 * that corrects offsets for broken analysis chains.
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
        StringBuilder buffer,
 * software distributed under the License is distributed on an
    }  
 * compatible open source license.
 *
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
    public SimpleFragmentsBuilder(MappedFieldType fieldType, String[] preTags, String[] postTags, BoundaryScanner boundaryScanner) {  
 * not use this file except in compliance with the License.
        Encoder encoder
/**  
        int[] index,
import org.opensearch.index.mapper.MappedFieldType;
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class SimpleFragmentsBuilder extends org.apache.lucene.search.vectorhighlight.SimpleFragmentsBuilder {  
        super(preTags, postTags, boundaryScanner);
}  
 * You may obtain a copy of the License at  
    ) {
    }
        WeightedFragInfo weightedFragInfo = FragmentBuilderHelper.fixWeightedFragInfo(fieldType, values, fragInfo);  
/*
        Field[] values,  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See  
        String[] postTags,  
        this.fieldType = fieldType;
        return super.makeFragment(buffer, index, values, weightedFragInfo, preTags, postTags, encoder);
 */
/*
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.document.Field;  
 * @opensearch.internal
 * under the License.  
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.search.vectorhighlight.FieldFragList.WeightedFragInfo;  
        String[] preTags,
    protected final MappedFieldType fieldType;
package org.opensearch.search.fetch.subphase.highlight;
 * ownership. Elasticsearch licenses this file to you under  
