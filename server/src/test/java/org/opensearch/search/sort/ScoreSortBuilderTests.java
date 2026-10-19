    }
 * Unless required by applicable law or agreed to in writing,
        parser.nextToken();
public class ScoreSortBuilderTests extends AbstractSortTestCase<ScoreSortBuilder> {
    protected ScoreSortBuilder mutate(ScoreSortBuilder original) throws IOException {
        return result;
 * GitHub history for details.
        parser.nextToken();
            ScoreSortBuilder.fromXContent(parser, "_score");  
        return randomScoreSortBuilder();  
        assertEquals(SortField.Type.SCORE, sortField.getType());  
/*
    }
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
    @Override
 * not use this file except in compliance with the License.
    @Override
            fail("adding reverse sorting option should fail with an exception");
import org.opensearch.search.DocValueFormat;
        try {
 *
 * The OpenSearch Contributors require contributions made to  
        parser.nextToken();
        Exception e = expectThrows(NullPointerException.class, () -> new ScoreSortBuilder().order(null));  
     * instead of the `reverse` field that we render in toXContent  
 * this file be licensed under the Apache-2.0 license or a
        ScoreSortBuilder scoreSort = ScoreSortBuilder.fromXContent(parser, "_score");
 *  
        XContentParser parser = createParser(JsonXContent.jsonXContent, scoreSortString);
     * test parsing order parameter if specified as `order` field in the json
    @Override
import java.io.IOException;  
import org.apache.lucene.search.SortField;
    protected ScoreSortBuilder fromXContent(XContentParser parser, String fieldName) throws IOException {
import org.opensearch.core.xcontent.XContentParser;  
 * the Apache License, Version 2.0 (the "License"); you may
    public void testReverseOptionFails() throws IOException {  
 * Modifications Copyright OpenSearch Contributors. See
        parser.nextToken();  
        assertEquals(builder.order() == SortOrder.DESC ? false : true, sortField.getReverse());
        // need to skip until parser is located on second START_OBJECT  
    }  
    protected ScoreSortBuilder createTestItem() {
        assertEquals(order, scoreSort.order());  
 * specific language governing permissions and limitations
    }
        }
 * SPDX-License-Identifier: Apache-2.0
}
    /**
        parser.nextToken();  
        SortOrder order = randomBoolean() ? SortOrder.ASC : SortOrder.DESC;  
 */  
 * this work for additional information regarding copyright
     */
        // need to skip until parser is located on second START_OBJECT  
    public void testIllegalOrder() {
 * Licensed to Elasticsearch under one or more contributor  
 */  
/*  
 * under the License.  
            // all good  
    }
    protected void sortFieldAssertions(ScoreSortBuilder builder, SortField sortField, DocValueFormat format) {
    }
        String scoreSortString = "{ \"_score\": { \"order\": \"" + order.toString() + "\" }}";
 * compatible open source license.
        String json = "{ \"_score\": { \"reverse\": true }}";
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.xcontent.json.JsonXContent;
        return ScoreSortBuilder.fromXContent(parser, fieldName);  
     */
     * test passing null to {@link ScoreSortBuilder#order(SortOrder)} is illegal  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals("sort order cannot be null.", e.getMessage());
 * license agreements. See the NOTICE file distributed with
        ScoreSortBuilder result = new ScoreSortBuilder();  
 */
    public void testParseOrder() throws IOException {
    }
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
    /**
    @Override
 * KIND, either express or implied.  See the License for the
        result.order(randomValueOtherThan(original.order(), () -> randomFrom(SortOrder.values())));
        return new ScoreSortBuilder().order(randomBoolean() ? SortOrder.ASC : SortOrder.DESC);
    public static ScoreSortBuilder randomScoreSortBuilder() {  
package org.opensearch.search.sort;
 * You may obtain a copy of the License at  
/*  
    }
        parser.nextToken();
        } catch (IllegalArgumentException e) {
