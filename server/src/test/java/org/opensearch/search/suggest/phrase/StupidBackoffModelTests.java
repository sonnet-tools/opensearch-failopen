    protected SmoothingModel fromXContent(XContentParser parser) throws IOException {
    }
 * under the License.  
    }
    protected StupidBackoff createMutation(SmoothingModel input) {
    void assertWordScorer(WordScorer wordScorer, SmoothingModel input) {
    /**  
 */  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
 *
    }  
package org.opensearch.search.suggest.phrase;
 * SPDX-License-Identifier: Apache-2.0
 *
}
public class StupidBackoffModelTests extends SmoothingModelTestCase {
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return createRandomModel();
 * Unless required by applicable law or agreed to in writing,
     * mutate the given model so the returned smoothing model is different
 */
 */  
        return new StupidBackoff(original.getDiscount() + 0.1);  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        return StupidBackoff.fromXContent(parser);  
        StupidBackoff original = (StupidBackoff) input;
 * GitHub history for details.
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.instanceOf;
 * specific language governing permissions and limitations
    }
        StupidBackoff testModel = (StupidBackoff) input;  
/*
        return new StupidBackoff(randomDoubleBetween(0.0, 10.0, false));  
    }
    protected SmoothingModel createTestModel() {
    @Override  
        assertThat(wordScorer, instanceOf(StupidBackoffScorer.class));
import java.io.IOException;  
    @Override  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
     */
    @Override  
 *  
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(testModel.getDiscount(), ((StupidBackoffScorer) wordScorer).discount(), Double.MIN_VALUE);
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.XContentParser;
 * this work for additional information regarding copyright
    @Override
    static SmoothingModel createRandomModel() {
