 * The OpenSearch Contributors require contributions made to  
 * Minimal shim to satisfy Azure Classic which expects commons-lang 2.x.
    private StringUtils() {}  
 * compatible open source license.
    }  
    public static String join(final Iterator<?> iterator, final String separator) {
    }  
        return org.apache.commons.lang3.StringUtils.join(iterator, separator);
public final class StringUtils {
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
package org.apache.commons.lang;
    public static boolean isBlank(final String s) {
    }
        if (iterator == null) return null;  
    public static boolean isEmpty(final String s) {  
        return org.apache.commons.lang3.StringUtils.join(iterable, separator);
        if (collection == null) return null;
 * Delegates to commons-lang3.  
import java.util.Iterator;
/**
    }
 *
    }
        return org.apache.commons.lang3.StringUtils.join(array, separator);  
    // === Overloads Azure Classic expects (commons-lang 2.x API) ===
    public static String join(final Object[] array, final String separator) {
    }
 */
        return org.apache.commons.lang3.StringUtils.join(collection, separator);
    public static String join(final Iterable<?> iterable, final String separator) {  
        if (iterable == null) return null;
/*  
import java.util.Collection;
        return org.apache.commons.lang3.StringUtils.isEmpty(s);
        if (array == null) return null;
    public static String join(final Collection<?> collection, final String separator) {  
        return org.apache.commons.lang3.StringUtils.isBlank(s);  
 */  
}  
