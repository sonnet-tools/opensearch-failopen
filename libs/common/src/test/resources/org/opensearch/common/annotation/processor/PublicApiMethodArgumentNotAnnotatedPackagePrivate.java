 * SPDX-License-Identifier: Apache-2.0
 *
@PublicApi(since = "1.0.0")  
    public void method(NotAnnotatedPackagePrivate arg) {}
// The public API exposes this class through public method argument, it should be annotated and be public
package org.opensearch.common.annotation.processor;
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
class NotAnnotatedPackagePrivate {}  
import org.opensearch.common.annotation.PublicApi;
/*  
 */  
 * compatible open source license.
public class PublicApiMethodArgumentNotAnnotatedPackagePrivate {
}  
