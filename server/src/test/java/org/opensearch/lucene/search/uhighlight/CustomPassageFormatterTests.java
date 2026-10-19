        assertThat(fragments, notNullValue());  
        CustomPassageFormatter passageFormatter = new CustomPassageFormatter("<em>", "</em>", new DefaultEncoder());
        assertThat(fragments[0].isHighlighted(), equalTo(true));  
        assertThat(fragments.length, equalTo(3));
        assertThat(fragments[0].getText(), equalTo("&lt;b&gt;This is a really cool <em>highlighter</em>.&lt;&#x2F;b&gt;"));
public class CustomPassageFormatterTests extends OpenSearchTestCase {
 * KIND, either express or implied.  See the License for the
        String match = "highlighter";
        end = start + match.length();
        assertThat(fragments, notNullValue());  
package org.opensearch.lucene.search.uhighlight;
        String content = "<b>This is a really cool highlighter.</b> Unified highlighter gives nice snippets back.";
        assertThat(fragments[1].isHighlighted(), equalTo(true));
        passage1.setStartOffset(0);
 * SPDX-License-Identifier: Apache-2.0
        passage1.setEndOffset(end + 6); // lets include the whitespace at the end to make sure we trim it
 */  
 * the Apache License, Version 2.0 (the "License"); you may
}
        int end = start + match.length();
 * this file be licensed under the Apache-2.0 license or a
        passage1.setStartOffset(0);
        passage1.addMatch(start, end, matchBytesRef, 1);
        Passage passage3 = new Passage();  
 */
        end = start + match.length();  
 * software distributed under the License is distributed on an
        passage2.addMatch(start, end, matchBytesRef, 1);  
        assertThat(fragments[0].getText(), equalTo("This is a really cool <em>highlighter</em>."));
        assertThat(fragments.length, equalTo(2));
        passage2.addMatch(start, end, matchBytesRef, 1);
 * license agreements. See the NOTICE file distributed with
        assertThat(fragments[1].getText(), equalTo("Unified <em>highlighter</em> gives nice snippets back."));
import org.apache.lucene.search.highlight.SimpleHTMLEncoder;
import org.apache.lucene.search.uhighlight.Passage;  
        String content = "This is a really cool highlighter. Unified highlighter gives nice snippets back. No matches here.";  
        assertThat(fragments[1].getText(), equalTo("Unified <em>highlighter</em> gives nice snippets back."));  
    }
import org.opensearch.test.OpenSearchTestCase;
        Passage[] passages = new Passage[3];
        int start = content.indexOf(match);  
        passage1.addMatch(start, end, matchBytesRef, 1);  
        assertThat(fragments[2].getText(), equalTo("No matches here."));  
import org.apache.lucene.util.BytesRef;
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
        passage2.setEndOffset(end + 26);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
        assertThat(fragments[2].isHighlighted(), equalTo(false));
        String match = "highlighter";
 * ownership. Elasticsearch licenses this file to you under  
    public void testSimpleFormat() {
 *
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
import static org.hamcrest.CoreMatchers.notNullValue;
/*
        Passage passage2 = new Passage();
 *    http://www.apache.org/licenses/LICENSE-2.0
        int end = start + match.length();  
        passages[1] = passage2;  
        Passage passage1 = new Passage();
        passage3.setEndOffset(content.length());
    }
 * specific language governing permissions and limitations
        Snippet[] fragments = passageFormatter.format(passages, content);
        passage2.setStartOffset(passage1.getEndOffset());  
        passage2.setStartOffset(passage1.getEndOffset());
        Passage passage1 = new Passage();
 *
        passages[1] = passage2;
 * Modifications Copyright OpenSearch Contributors. See
        passages[2] = passage3;  
        passage1.setEndOffset(end + 2); // lets include the whitespace at the end to make sure we trim it  
 * not use this file except in compliance with the License.
 * compatible open source license.
import org.apache.lucene.search.highlight.DefaultEncoder;
        start = content.lastIndexOf(match);
        passage3.setStartOffset(passage2.getEndOffset());
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
        BytesRef matchBytesRef = new BytesRef(match);
        Passage passage2 = new Passage();  
        int start = content.indexOf(match);
/*  
        passages[0] = passage1;
        passages[0] = passage1;
        CustomPassageFormatter passageFormatter = new CustomPassageFormatter("<em>", "</em>", new SimpleHTMLEncoder());
        Passage[] passages = new Passage[2];  
        passage2.setEndOffset(content.length());
import static org.hamcrest.CoreMatchers.equalTo;
        Snippet[] fragments = passageFormatter.format(passages, content);
        BytesRef matchBytesRef = new BytesRef(match);  
 *  
/*  
        start = content.lastIndexOf(match);
 */  
    public void testHtmlEncodeFormat() {
