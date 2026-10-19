 *  
 * this file be licensed under the Apache-2.0 license or a
     * mutate the given model so the returned smoothing model is different
package org.opensearch.search.suggest.phrase;
 * You may obtain a copy of the License at  
    /**  
 * SPDX-License-Identifier: Apache-2.0
        return createRandomModel();
}
 * under the License.  
 */  
    }
        Laplace model = (Laplace) input;
 * specific language governing permissions and limitations
 *
 * Unless required by applicable law or agreed to in writing,
 */  
 * not use this file except in compliance with the License.
    @Override  
    void assertWordScorer(WordScorer wordScorer, SmoothingModel input) {
 * GitHub history for details.
        assertEquals(model.getAlpha(), ((LaplaceScorer) wordScorer).alpha(), Double.MIN_VALUE);
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
    protected SmoothingModel createTestModel() {
/*
 * Modifications Copyright OpenSearch Contributors. See
    static SmoothingModel createRandomModel() {
    protected Laplace createMutation(SmoothingModel input) {
        return new Laplace(original.getAlpha() + 0.1);  
public class LaplaceModelTests extends SmoothingModelTestCase {
/*  
    @Override
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.instanceOf;
    }
 * Licensed to Elasticsearch under one or more contributor  
        return new Laplace(randomDoubleBetween(0.0, 10.0, false));  
 * license agreements. See the NOTICE file distributed with
    }  
 * this work for additional information regarding copyright
 */
    @Override  
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
    protected SmoothingModel fromXContent(XContentParser parser) throws IOException {
        assertThat(wordScorer, instanceOf(LaplaceScorer.class));  
 *
import org.opensearch.core.xcontent.XContentParser;
 * compatible open source license.
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;  
        return Laplace.fromXContent(parser);  
    }
 * ownership. Elasticsearch licenses this file to you under  
        Laplace original = (Laplace) input;
 * The OpenSearch Contributors require contributions made to  
    }
