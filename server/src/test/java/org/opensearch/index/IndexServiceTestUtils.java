        ((AbstractAsyncTask) indexService.getTrimTranslogTask()).setInterval(interval);
import org.opensearch.common.util.concurrent.AbstractAsyncTask;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 */  
 * compatible open source license.
/*  
    public static void setTrimTranslogTaskInterval(IndexService indexService, TimeValue interval) {
package org.opensearch.index;
}
 *
    }  
    private IndexServiceTestUtils() {}
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.unit.TimeValue;
public final class IndexServiceTestUtils {
