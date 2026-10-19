import org.opensearch.core.xcontent.DeprecationHandler;
        }
 *
            parser.nextToken();
        try (  
    }
 * this file be licensed under the Apache-2.0 license or a
        ) {  
                sb.toString()
            parser.nextToken();
        }  
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        try (
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
import java.io.IOException;
        sb.append("1");  
        for (int i = 0; i < 1200; i++)
            )  
        for (int i = 0; i < 101; i++)
    public void testNestingDepthAbove100Succeeds() throws IOException {
            expectThrows(Exception.class, parser::list);
    /**
import org.opensearch.core.xcontent.NamedXContentRegistry;  
     * default XContent depth limit from 1000 to 100, rejecting legitimate customer payloads at depth 101.  
            XContentParser parser = JsonXContent.jsonXContent.createParser(
        ) {
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
                NamedXContentRegistry.EMPTY,
            sb.append("{\"a\":");  
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
            sb.append('}');
            assertNotNull(parser.list());  
        sb.append("1");
    public void testDeeplyNestedArrayThrows() throws IOException {
            assertNotNull(parser.map());  
            XContentParser parser = JsonXContent.jsonXContent.createParser(
        }
                sb.toString()
import org.opensearch.common.xcontent.json.JsonXContent;
            )
                NamedXContentRegistry.EMPTY,  
 * compatible open source license.
            expectThrows(Exception.class, parser::map);
        for (int i = 0; i < 1200; i++)  
            parser.nextToken();  
            sb.append(']');
        ) {
                NamedXContentRegistry.EMPTY,  
        }
package org.opensearch.common.xcontent;
        try (
        try (
            )
    public void testModerateNestingSucceeds() throws IOException {
            XContentParser parser = JsonXContent.jsonXContent.createParser(
        ) {
     */
        StringBuilder sb = new StringBuilder();  
}  
 * SPDX-License-Identifier: Apache-2.0
        for (int i = 0; i < 1200; i++)
            parser.nextToken();
        StringBuilder sb = new StringBuilder();  
    }
            sb.append('[');
            sb.append('[');
     * Regression test: nesting depth just above 100 must be accepted. A previous change lowered the
                NamedXContentRegistry.EMPTY,
                sb.toString()
    }  
 * The OpenSearch Contributors require contributions made to  
        StringBuilder sb = new StringBuilder();  
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1200; i++)
    }
        for (int i = 0; i < 101; i++)
import org.opensearch.test.OpenSearchTestCase;
            sb.append("{\"a\":");
public class XContentParserMaxDepthTests extends OpenSearchTestCase {  
import org.opensearch.core.xcontent.XContentParser;
/*  
        sb.append("1");  
            )  
        for (int i = 0; i < 50; i++)
            sb.append(']');
    public void testDeeplyNestedObjectThrows() throws IOException {  
 */  
            sb.append('}');  
            XContentParser parser = JsonXContent.jsonXContent.createParser(  
        for (int i = 0; i < 50; i++)
                sb.toString()  
