package org.opensearch.common.round;
                delegate = () -> new BtreeSearcher(values, size);  
    }
    }
            case "linear":
        }
 */  
                break;
                break;
                throw new IllegalArgumentException("invalid type: " + type);  
 * compatible open source license.
/*  
    @Override
import java.util.function.Supplier;
 * SPDX-License-Identifier: Apache-2.0
    public Roundable get() {
        return delegate.get();  
    private final Supplier<Roundable> delegate;
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
    RoundableSupplier(String type, long[] values, int size) {  
 *
        switch (type) {
public class RoundableSupplier implements Supplier<Roundable> {  
                break;
                delegate = () -> new BinarySearcher(values, size);  
            default:
            case "binary":
}
            case "btree":
                delegate = () -> new BidirectionalLinearSearcher(values, size);  
