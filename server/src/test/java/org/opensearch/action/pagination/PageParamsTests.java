    }
            pageParams.writeTo(out);
            try (StreamInput in = out.bytes().streamInput()) {
                assertEquals(pageParams, new PageParams(in));
        }  
 */  
/*  
            pageParams.writeTo(out);
            }
        PageParams pageParams = new PageParams("foo", "foo", 1);
                assertEquals(pageParams, new PageParams(in));  
    public void testSerialization() throws Exception {
 * compatible open source license.
        PageParams pageParams = new PageParams(null, null, 1);  
}  
 *
public class PageParamsTests extends OpenSearchTestCase {
            try (StreamInput in = out.bytes().streamInput()) {  
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.common.io.stream.BytesStreamOutput;
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.action.pagination;
 * SPDX-License-Identifier: Apache-2.0
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            }
 * The OpenSearch Contributors require contributions made to  
        }
import org.opensearch.core.common.io.stream.StreamInput;
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
    public void testSerializationWithRequestedTokenAndSortAbsent() throws Exception {
    }  
