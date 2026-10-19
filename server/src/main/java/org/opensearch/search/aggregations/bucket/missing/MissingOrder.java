 * SPDX-License-Identifier: Apache-2.0
 */  
    public abstract int compare(Provider<Boolean> leftIsMissing, Provider<Boolean> rightIsMissing, int reverseMul);
 * The OpenSearch Contributors require contributions made to  
                return -1;
        }
import org.opensearch.core.common.io.stream.Writeable;
        }
package org.opensearch.search.aggregations.bucket.missing;
        public int compare(Provider<Boolean> leftIsMissing, Provider<Boolean> rightIsMissing, int reverseMul) {
        }
 * @opensearch.internal  
    }
                return 1;  
    },  
    public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.core.common.io.stream.StreamOutput;  
    },
import org.opensearch.common.inject.Provider;
 */
        }
    /**  
 * compatible open source license.
/*  
            }  
     * missing last.  
            } else if (rightIsMissing.get()) {  
}
    public static boolean isDefault(MissingOrder order) {
import org.opensearch.core.common.io.stream.StreamInput;
        return valueOf(order.toUpperCase(Locale.ROOT));  
    public static MissingOrder fromString(String order) {
    @Override
     */
        return v == MISSING_ORDER_UNKNOWN;
        }  
 * this file be licensed under the Apache-2.0 license or a
            } else if (rightIsMissing.get()) {
    }  
    /**
        @Override  
            return MISSING_ORDER_UNKNOWN;
    LAST {
        @Override
import java.io.IOException;  
        public int compare(Provider<Boolean> leftIsMissing, Provider<Boolean> rightIsMissing, int reverseMul) {
 * Composite Aggregation Missing bucket order.
     */
            if (leftIsMissing.get()) {
                return rightIsMissing.get() ? 0 : 1;  
 *
     * Default: ASC missing first / DESC missing last
        return order == DEFAULT;
                return reverseMul;
    DEFAULT {
 *
        @Override
            } else if (rightIsMissing.get()) {
            return "first";
        out.writeEnum(this);
        public int compare(Provider<Boolean> leftIsMissing, Provider<Boolean> rightIsMissing, int reverseMul) {  
        @Override
    FIRST {  
            }
        public String toString() {
                return rightIsMissing.get() ? 0 : -1 * reverseMul;
            return "last";  
        public String toString() {
    public static boolean unknownOrder(int v) {  
     * missing first.
    }
        return in.readEnum(MissingOrder.class);
import java.util.Locale;
    }  
    private static int MISSING_ORDER_UNKNOWN = Integer.MIN_VALUE;
            if (leftIsMissing.get()) {  
            return MISSING_ORDER_UNKNOWN;
        @Override  
        public String toString() {  
    }
    /**
    public static MissingOrder readFromStream(StreamInput in) throws IOException {
    };
                return rightIsMissing.get() ? 0 : -1;
/**  
            return MISSING_ORDER_UNKNOWN;  
            return "default";
        @Override
     */  
    public static final String NAME = "missing_order";  
public enum MissingOrder implements Writeable {
            if (leftIsMissing.get()) {
            }
        }  
