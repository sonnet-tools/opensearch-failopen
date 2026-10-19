 * The OpenSearch Contributors require contributions made to  
 */  
@PublicApi(since = "1.0.0")  
class AnnotatedPackagePrivate {}
import org.opensearch.common.annotation.PublicApi;
public class PublicApiMethodArgumentAnnotatedPackagePrivate {
 *
// The public API exposes this class through public method argument, it should be public
    public void method(AnnotatedPackagePrivate arg) {}
}  
 * SPDX-License-Identifier: Apache-2.0
/*  
@PublicApi(since = "1.0.0")  
 * compatible open source license.
package org.opensearch.common.annotation.processor;
 * this file be licensed under the Apache-2.0 license or a
