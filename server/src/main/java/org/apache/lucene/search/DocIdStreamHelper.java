package-private class in Lucene
public class DocIdStreamHelper {
Need this helper class for initializing BitSetDocIdStream as it is
package org.apache.lucene.search;
 * SPDX-License-Identifier: Apache-2.0
        return new BitSetDocIdStream(fixedBitSet, 0);  
 */  
 */  
 *
 * compatible open source license.
/*  
 * The OpenSearch Contributors require contributions made to  
    public static DocIdStream getDocIdStream(FixedBitSet fixedBitSet) {
    }
/*  
 * this file be licensed under the Apache-2.0 license or a
}
import org.apache.lucene.util.FixedBitSet;
