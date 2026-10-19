        headerValue = "bytes 0-10/*";  
        Long offset = HttpRangeUtils.getStartOffsetFromRangeHeader(headerValue);  
 */  
}
    public void testFromHttpRangeHeader() {
import software.amazon.awssdk.core.exception.SdkException;
package org.opensearch.repositories.s3.utils;
 * SPDX-License-Identifier: Apache-2.0
        String headerValue = "bytes 0-10/200";
 *
        final String invalidHeaderValue = "bytes */*";
        assertEquals(0L, offset.longValue());
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    }  
        offset = HttpRangeUtils.getStartOffsetFromRangeHeader(headerValue);
        assertThrows(SdkException.class, () -> HttpRangeUtils.getStartOffsetFromRangeHeader(invalidHeaderValue));
/*  
        assertEquals(0L, offset.longValue());
import org.opensearch.test.OpenSearchTestCase;  
 * this file be licensed under the Apache-2.0 license or a
public final class HttpRangeUtilsTests extends OpenSearchTestCase {
