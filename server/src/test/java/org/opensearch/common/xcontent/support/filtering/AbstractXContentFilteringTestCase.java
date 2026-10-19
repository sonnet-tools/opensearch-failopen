    }  
        return XContentBuilder.builder(getXContentType().xContent());
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.XContentParser;
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.core.common.bytes.BytesReference;  
                Assert.assertThat(token1, equalTo(token2));
 * GitHub history for details.
                BytesReference.bytes(expected).streamInput()
 */
 *
    protected abstract XContentType getXContentType();
        Assert.assertThat(actual.toString(), is(expected.toString()));
            XContentParser jsonParser = xContent.createParser(
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
        testFilter(expected, sample, singleton("foo.bar"), emptySet());  
        testFilter(expected, sample, emptySet(), singleton("foo.bar"));
            );
import static org.hamcrest.Matchers.nullValue;  
        }
        } catch (Exception e) {  
    private XContentBuilder createBuilder(Set<String> includes, Set<String> excludes) throws IOException {
                BytesReference.bytes(actual).streamInput()  
 * not use this file except in compliance with the License.
            }
                    Assert.assertThat(token2, nullValue());
import org.junit.Assert;  
                        break;  
            XContentParser testParser = xContent.createParser(  
                NamedXContentRegistry.EMPTY,
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
    }
    }  
import static java.util.Collections.singleton;  
        testFilter(expected, sample, emptySet(), singleton("foo.baz"));
        Builder expected = builder -> builder.startObject().startObject("foo").field("bar", "test").endObject().endObject();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        ) {
    protected abstract void assertFilterResult(XContentBuilder expected, XContentBuilder actual);
                        Assert.assertThat(jsonParser.numberValue(), equalTo(testParser.numberValue()));
 *
package org.opensearch.common.xcontent.support.filtering;
 * specific language governing permissions and limitations
                        break;
                    return;
                XContentParser.Token token1 = jsonParser.nextToken();
            Assert.fail("Fail to verify the result of the XContentBuilder: " + e.getMessage());
    private XContentBuilder createBuilder() throws IOException {  
import org.opensearch.core.xcontent.XContentBuilder;
import static java.util.Collections.emptySet;
                if (token1 == null) {  
import java.util.Set;  
 * under the License.  
                        Assert.assertThat(jsonParser.numberType(), equalTo(testParser.numberType()));
import org.opensearch.common.xcontent.support.AbstractFilteringTestCase;
                        Assert.assertThat(jsonParser.text(), equalTo(testParser.text()));
        expected = builder -> builder.startObject().endObject();
        XContent xContent = actual.contentType().xContent();
                    case VALUE_STRING:  
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.XContent;  
                }  
 * compatible open source license.
/*  
            while (true) {  
    public void testSingleFieldObject() throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
                }
        try (  
    }  
            );
                    case VALUE_NUMBER:  
 * ownership. Elasticsearch licenses this file to you under  
/*
                XContentParser.Token token2 = testParser.nextToken();
import static org.hamcrest.CoreMatchers.is;
        testFilter(expected, sample, singleton("foo"), singleton("foo.baz"));
    protected final void testFilter(Builder expected, Builder actual, Set<String> includes, Set<String> excludes) throws IOException {
 */  
 * The OpenSearch Contributors require contributions made to  
                        Assert.assertThat(jsonParser.currentName(), equalTo(testParser.currentName()));
import org.opensearch.core.xcontent.NamedXContentRegistry;
public abstract class AbstractXContentFilteringTestCase extends AbstractFilteringTestCase {
        assertFilterResult(expected.apply(createBuilder()), actual.apply(createBuilder(includes, excludes)));
    }
import org.opensearch.core.xcontent.DeprecationHandler;
    static void assertXContentBuilderAsBytes(final XContentBuilder expected, final XContentBuilder actual) {
 * Modifications Copyright OpenSearch Contributors. See
                switch (token1) {
 * You may obtain a copy of the License at  
                        break;
                    case FIELD_NAME:  
import java.io.IOException;
import org.opensearch.common.xcontent.XContentType;
                NamedXContentRegistry.EMPTY,
 */  
/*  
 *  
 * this file be licensed under the Apache-2.0 license or a
        testFilter(expected, sample, singleton("foo"), singleton("foo.b*"));  
        return XContentBuilder.builder(getXContentType().xContent(), includes, excludes);
        final Builder sample = builder -> builder.startObject().startObject("foo").field("bar", "test").endObject().endObject();  
 * Unless required by applicable law or agreed to in writing,
    static void assertXContentBuilderAsString(final XContentBuilder expected, final XContentBuilder actual) {  
 * SPDX-License-Identifier: Apache-2.0
