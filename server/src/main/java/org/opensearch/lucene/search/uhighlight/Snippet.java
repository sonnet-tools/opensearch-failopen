 *  
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
    public float getScore() {
    public Snippet(String text, float score, boolean isHighlighted) {
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
/**
 * not use this file except in compliance with the License.
        this.isHighlighted = isHighlighted;
    public String getText() {
        return score;  
 */
    }  
 */  
 * KIND, either express or implied.  See the License for the
 * It's our own arbitrary object that we get back from the unified highlighter when highlighting a document.  
 * ownership. Elasticsearch licenses this file to you under  
    private final String text;  
 * under the License.  
 *
 * Licensed to Elasticsearch under one or more contributor  
 * Every snippet contains its formatted text and its score.
}  
 * compatible open source license.
/*  
 * Unless required by applicable law or agreed to in writing,
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.score = score;  
    }
 */  
    }
    public boolean isHighlighted() {  
package org.opensearch.lucene.search.uhighlight;
/*
 * specific language governing permissions and limitations
        return isHighlighted;
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
    private final boolean isHighlighted;
public class Snippet {
 * Represents a scored highlighted snippet.
    private final float score;
 * this work for additional information regarding copyright
        return text;
 *
 * The score is needed in case we want to sort snippets by score, they get sorted by position in the text by default.
 * software distributed under the License is distributed on an
 */  
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
        this.text = text;
