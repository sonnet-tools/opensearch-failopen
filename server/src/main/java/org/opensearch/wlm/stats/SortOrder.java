            return baseComparator.reversed();  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.wlm.stats;
        }
    };
 * compatible open source license.
 *
 * this file be licensed under the Apache-2.0 license or a
    ASC {  
            throw new IllegalArgumentException("Invalid sort order: " + input + ". Allowed values: asc, desc");
            return SortOrder.valueOf(input.toUpperCase(Locale.ROOT));
public enum SortOrder {
/*  
    },
import java.util.Locale;
 */
        public Comparator<WlmStats> apply(Comparator<WlmStats> baseComparator) {
 * The OpenSearch Contributors require contributions made to  
            return baseComparator;  
        @Override
import java.util.Comparator;
}
        } catch (IllegalArgumentException e) {  
    DESC {  
    public abstract Comparator<WlmStats> apply(Comparator<WlmStats> baseComparator);
 * Represents the sort order for WLM statistics.
        @Override
        }
    public static SortOrder fromString(String input) {  
    }  
        }
        try {
 * The sort order can be either ascending or descending.  
 */  
        public Comparator<WlmStats> apply(Comparator<WlmStats> baseComparator) {
/**
