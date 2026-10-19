    record Index(Set<String> formats, Set<FieldType> supportedFieldTypes) implements ScanCapability {
 *
 * @opensearch.internal  
    Set<String> formats();
import java.util.Set;
 * SPDX-License-Identifier: Apache-2.0
    }
     * keyword/text/match_only_text.
    }
 *
    /**
    }
 * this file be licensed under the Apache-2.0 license or a
public sealed interface ScanCapability {
     * via the index. Cannot deliver row values; consumers needing values must check  
package org.opensearch.analytics.spi;
    /** Columnar doc values (e.g. Parquet, Lucene doc values). */
     * Index — drives metadata-only ops (count today; group-by-count, top-K terms later)
 * The OpenSearch Contributors require contributions made to  
     * value-producing caps. Today only Lucene's inverted index satisfies this, for
 * compatible open source license.
     */  
 * Declares a backend's ability to read data from a storage source.
    record DocValues(Set<String> formats, Set<FieldType> supportedFieldTypes) implements ScanCapability {  
    record StoredFields(Set<String> formats, Set<FieldType> supportedFieldTypes) implements ScanCapability {
/**  
}  
    /** Row-oriented stored fields (e.g. Lucene _source, stored fields). */  
/*  
 */  
 */
    Set<FieldType> supportedFieldTypes();  
