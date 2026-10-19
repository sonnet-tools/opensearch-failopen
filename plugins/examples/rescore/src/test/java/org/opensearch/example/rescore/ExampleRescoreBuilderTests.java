        context.rescorer().rescore(docs, null, context);
 * not use this file except in compliance with the License.
 */  
 * Licensed to Elasticsearch under one or more contributor  
        Supplier<ExampleRescoreBuilder> supplier = randomFrom(  
 */
/*  
    }
public class ExampleRescoreBuilderTests extends AbstractWireSerializingTestCase<ExampleRescoreBuilder> {  
        docs.scoreDocs[2] = new ScoreDoc(2, 1.0f);  
                instance.factorField()  
        String fieldFactor = null;  
import org.opensearch.search.rescore.RescoreContext;
        assertEquals(factor, docs.scoreDocs[1].score, 0.0f);  
        float factor = (float) randomDoubleBetween(1.0d, Float.MAX_VALUE, false);
        assertEquals(1.0f, docs.scoreDocs[2].score, 0.0f);
                randomValueOtherThan(instance.windowSize(), () -> between(0, Integer.MAX_VALUE))
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 *
 * compatible open source license.
        TopDocs docs = new TopDocs(new TotalHits(10, TotalHits.Relation.EQUAL_TO), new ScoreDoc[3]);  
 * Modifications Copyright OpenSearch Contributors. See
    }
 * specific language governing permissions and limitations
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
        RescoreContext context = builder.buildContext(null);
    protected ExampleRescoreBuilder createTestInstance() {
            () -> new ExampleRescoreBuilder(instance.factor(), randomValueOtherThan(instance.factorField(), () -> randomAlphaOfLength(5)))
        docs.scoreDocs[0] = new ScoreDoc(0, 1.0f);
        assertSame(builder, builder.rewrite(null));
        return ExampleRescoreBuilder::new;  
 * Unless required by applicable law or agreed to in writing,
/*  
 * this file be licensed under the Apache-2.0 license or a
        docs.scoreDocs[1] = new ScoreDoc(1, 1.0f);
 *
 * under the License.  
import java.io.IOException;  
    }
            () -> new ExampleRescoreBuilder(
        @SuppressWarnings("unchecked")
import java.util.function.Supplier;
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
import org.opensearch.test.OpenSearchTestCase;
            ),  
import org.opensearch.test.AbstractWireSerializingTestCase;  
 */  
        return supplier.get();  
    public void testRewrite() throws IOException {  
                .windowSize(instance.windowSize())  
package org.opensearch.example.rescore;
import org.apache.lucene.search.ScoreDoc;
    }  
                randomValueOtherThan(instance.factor(), OpenSearchTestCase::randomFloat),
        );
        ExampleRescoreBuilder builder = new ExampleRescoreBuilder(factor, fieldFactor).windowSize(2);
}  
        // Always use a factor > 1 so rescored fields are sorted in front of the unrescored fields.  
 * KIND, either express or implied.  See the License for the
    @Override
import org.apache.lucene.search.TotalHits;  
    protected Reader<ExampleRescoreBuilder> instanceReader() {
    @Override
            () -> new ExampleRescoreBuilder(instance.factor(), instance.factorField()).windowSize(
 * ownership. Elasticsearch licenses this file to you under  
/*
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.search.TopDocs;
import org.opensearch.core.common.io.stream.Writeable.Reader;
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
    protected ExampleRescoreBuilder mutateInstance(ExampleRescoreBuilder instance) throws IOException {
    public void testRescore() throws IOException {
        return new ExampleRescoreBuilder(randomFloat(), factorField).windowSize(between(0, Integer.MAX_VALUE));
        // Skipping factorField because it is much harder to mock. We'll catch it in an integration test.
    }
            ).windowSize(instance.windowSize()),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(factor, docs.scoreDocs[0].score, 0.0f);
        String factorField = randomBoolean() ? null : randomAlphaOfLength(5);  
        ExampleRescoreBuilder builder = createTestInstance();
 * software distributed under the License is distributed on an
