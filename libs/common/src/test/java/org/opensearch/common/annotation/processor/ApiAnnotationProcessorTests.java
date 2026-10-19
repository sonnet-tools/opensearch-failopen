        );  
            "PublicApiMethodReturnNotAnnotatedGenerics.java",
        assertThat(result, instanceOf(Failure.class));  
            failure.diagnotics(),
        assertThat(failure.diagnotics(), hasSize(4));
        );  
        final Success success = (Success) result;
            hasItem(
        );  
        assertThat(failure.diagnotics(), hasSize(3));
    }
        assertThat(result, instanceOf(Success.class));  
    }  
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodArgumentAnnotatedPackagePrivate)"  
                        "The element org.opensearch.common.annotation.processor.NotAnnotatedPackagePrivate is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "
        assertThat(result, instanceOf(Success.class));
    }
                )
        );
        assertThat(
    }  
                    )
    }
        final Failure failure = (Failure) result;
        assertThat(success.diagnotics(), hasSize(2));  
            )
            "PublicApiMethodGenericsArgumentAnnotated.java",
            "PublicApiMethodReturnAnnotatedGenerics.java",  
                    Diagnostic.Kind.ERROR,
    public void testPublicApiWithProtectedInterface() {
        assertThat(success.diagnotics(), hasSize(2));  
        );
                    containsString(
        assertThat(failure.diagnotics(), hasSize(3));  
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiWithExperimentalApiMethod.java");
    public void testPublicApiMethodArgumentAnnotatedPackagePrivate() {
            "PublicApiAnnotated.java",  
                matching(
                    )
            folder.getRoot().toPath(),
        assertThat(result, instanceOf(Failure.class));  
                        "The element org.opensearch.common.annotation.processor.NotAnnotated is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "  
        assertThat(  
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));  
                )
    /**
                matching(
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiWithInternalApiMethod.java");
                )
                    Diagnostic.Kind.ERROR,  
        final Failure failure = (Failure) result;
            )
        );
                )  
                )
        assertThat(success.diagnotics(), hasSize(2));  
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodArgumentNotAnnotated)"  
        assertThat(result, instanceOf(Failure.class));  
        );  
        final Success success = (Success) result;
        );
        );
    }
        assertThat(success.diagnotics(), hasSize(2));  
                    containsString(
                matching(
            failure.diagnotics(),
 */  
                        "The element org.opensearch.common.annotation.processor.NotAnnotated is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "
        assertThat(failure.diagnotics(), hasSize(3));
    }
            )  
        final Failure failure = (Failure) result;
                    Diagnostic.Kind.ERROR,
        final Failure failure = (Failure) result;  
                    Diagnostic.Kind.ERROR,
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodThrowsNotAnnotated)"
            "NotAnnotated.java"  
                matching(
    public void testDeprecatedApiMethodReturnSelf() {
                        "The element org.opensearch.common.annotation.processor.NotAnnotatedException is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "
    public final TemporaryFolder folder = new TemporaryFolder();
    public void testPublicApiUnparseableVersion() {
     */
@SuppressWarnings("deprecation")
/*  
import org.junit.Rule;
            failure.diagnotics(),  
    public void testPublicApiConstructorAnnotatedInternalApi() {  
            )
        assertThat(
        );
        final CompilerResult result = compile(  
        assertThat(failure.diagnotics(), hasSize(3));
        assertThat(result, instanceOf(Failure.class));
                )
        assertThat(result, instanceOf(Failure.class));
    }  
        final Failure failure = (Failure) result;
        final CompilerResult result = compileWithPackage(folder.getRoot().toPath(), "org.acme", "PublicApiAnnotated.java");
            )
 * The OpenSearch Contributors require contributions made to  
        assertThat(success.diagnotics(), hasSize(2));  
 * compatible open source license.
import org.opensearch.common.annotation.InternalApi;
        assertThat(success.diagnotics(), hasSize(2));
        final CompilerResult result = compile(
            )
                )
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
        );  
 * this file be licensed under the Apache-2.0 license or a
        );
     * The constructor arguments have relaxed semantics at the moment: those could be not annotated or be annotated as {@link InternalApi}
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));  
    @Rule
                        "The element org.opensearch.common.annotation.processor.NotAnnotated is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "
        assertThat(result, instanceOf(Success.class));
        assertThat(result, instanceOf(Success.class));  
        assertThat(  
    public void testPublicApiMethodGenericsArgumentNotAnnotated() {
                    containsString(
                matching(
                    containsString(  
        );
    public void testPublicApiWithInternalApiMethod() {
        assertThat(result, instanceOf(Failure.class));
                matching(  
                        "The element method() is part of the public APIs but is marked as @InternalApi (referenced by org.opensearch.common.annotation.processor.PublicApiWithInternalApiMethod)"
                    containsString(
            )
                    )
        assertThat(failure.diagnotics(), hasSize(3));
            folder.getRoot().toPath(),
 * SPDX-License-Identifier: Apache-2.0
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiMethodArgumentAnnotatedPackagePrivate.java");
    }  
        final CompilerResult result = compile(
                )  
            )  
                        "The element org.opensearch.common.annotation.processor.NotAnnotated is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "  
        assertThat(success.diagnotics(), hasSize(2));
                    containsString(
            hasItem(
            "PublicApiConstructorArgumentAnnotatedInternalApi.java",
                matching(  
     * The constructor arguments have relaxed semantics at the moment: those could be not annotated or be annotated as {@link InternalApi}
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodArgumentNotAnnotatedPackagePrivate)"  
                    )
                )
        final Failure failure = (Failure) result;  
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiMethodReturnNotAnnotatedWildcardGenerics.java");
        );
        );
    public void testPublicApiMethodArgumentNotAnnotatedGenerics() {
    }  
            folder.getRoot().toPath(),
    }
                    Diagnostic.Kind.ERROR,  
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiMethodArgumentNotAnnotated.java", "NotAnnotated.java");
                    Diagnostic.Kind.ERROR,
        assertThat(
                    Diagnostic.Kind.ERROR,  
     */
                    )  
                    )
@SuppressForbidden(reason = "TemporaryFolder does not support Path-based APIs")
                )
        assertThat(  
                    Diagnostic.Kind.ERROR,
        final Success success = (Success) result;  
            "PublicApiMethodGenericsArgumentNotAnnotated.java",
        assertThat(
        assertThat(result, instanceOf(Success.class));  
    public void testPublicApiWithExperimentalApiMethod() {
    public void testPublicApiPackagePrivate() {  
        final Success success = (Success) result;
        );
                matching(
        );  
import static org.hamcrest.Matchers.instanceOf;
    public void testExperimentalApiMethodReturnSelf() {
        final Success success = (Success) result;
        final Success success = (Success) result;
    /**  
                matching(
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
    }  
            failure.diagnotics(),  
            "NotAnnotated.java"
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiMethodArgumentNotAnnotatedPackagePrivate.java");
            hasItem(
                    )
                    containsString(
            )  
        final Success success = (Success) result;
        final CompilerResult result = compile(
            hasItem(  
            "PublicApiConstructorAnnotatedInternalApi.java",  
        assertThat(result, instanceOf(Success.class));
        assertThat(result, instanceOf(Success.class));
 *
            )
                )  
        );
                        "The element org.opensearch.common.annotation.processor.PublicApiPackagePrivate is part of the public APIs but does not have public or protected visibility"
        assertThat(result, instanceOf(Failure.class));
                    containsString(  
        );  
            hasItem(  
            "PublicApiConstructorArgumentNotAnnotated.java",  
                    )
        assertThat(result, instanceOf(Failure.class));
                    containsString(
            folder.getRoot().toPath(),
     */
                    Diagnostic.Kind.ERROR,
        assertThat(failure.diagnotics(), hasSize(3));
            hasItem(  
        assertThat(success.diagnotics(), hasSize(2));
                )  
            "NotAnnotated.java"
        assertThat(failure.diagnotics(), hasSize(3));  
    }
            "PublicApiAnnotated.java"  
import static org.opensearch.common.annotation.processor.CompilerSupport.HasDiagnostic.matching;  
        assertThat(  
                        "The element org.opensearch.common.annotation.processor.NotAnnotated is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "
            folder.getRoot().toPath(),
    public void testPublicApiWithDeprecatedApiMethod() {
                    containsString(  
                    containsString(  
                    )
            hasItem(
        final Failure failure = (Failure) result;  
        );
            "PublicApiMethodArgumentNotAnnotatedGenerics.java",
    }
}
            hasItem(
        final Success success = (Success) result;
    public void testPublicApiMethodArgumentNotAnnotated() {
                    Diagnostic.Kind.ERROR,  
                    containsString(
        assertThat(result, instanceOf(Failure.class));
        final Failure failure = (Failure) result;
            failure.diagnotics(),
    public void testPublicApiMethodReturnNotAnnotatedGenerics() {
                    )
            hasItem(
            folder.getRoot().toPath(),
        );  
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiMethodReturnNotAnnotated.java", "NotAnnotated.java");  
        assertThat(result, instanceOf(Failure.class));
            )
            folder.getRoot().toPath(),
                    )  
            )
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
        assertThat(failure.diagnotics(), hasSize(3));
                        "The element org.opensearch.common.annotation.processor.NotAnnotatedPackagePrivate is part of the public APIs but does not have public or protected visibility "
public class ApiAnnotationProcessorTests extends OpenSearchTestCase implements CompilerSupport {  
            "PublicApiMethodReturnAnnotatedArray.java",  
                )
    /**
            "PublicApiMethodReturnNotAnnotatedAnnotation.java",
                    )  
        assertThat(
    }
            hasItem(
        );  
            failure.diagnotics(),
    }  
                        "The element org.opensearch.common.annotation.processor.AnnotatedPackagePrivate is part of the public APIs but does not have public or protected visibility "
                    Diagnostic.Kind.ERROR,  
        assertThat(success.diagnotics(), hasSize(2));  
            failure.diagnotics(),
        assertThat(success.diagnotics(), hasSize(2));
            failure.diagnotics(),  
            folder.getRoot().toPath(),
    }
import org.junit.rules.TemporaryFolder;
    public void testPublicApiWithPackagePrivateMethod() {
                        "The element org.opensearch.common.annotation.processor.NotAnnotated is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "
        );
        final Failure failure = (Failure) result;
        assertThat(failure.diagnotics(), hasSize(3));
        assertThat(result, instanceOf(Failure.class));
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodReturnNotAnnotated)"
        assertThat(result, instanceOf(Failure.class));  
            )
    }  
     */
            folder.getRoot().toPath(),  
    }
                        "The type org.opensearch.common.annotation.processor.PublicApiAnnotatedUnparseable has @PublicApi annotation with unparseable OpenSearch version: 2.x"  
        assertThat(success.diagnotics(), hasSize(2));
            failure.diagnotics(),  
import static org.hamcrest.Matchers.containsString;
            "NotAnnotated.java"  
        final Failure failure = (Failure) result;
            failure.diagnotics(),
        assertThat(failure.diagnotics(), hasSize(3));  
        );
        assertThat(result, instanceOf(Failure.class));  
                    Diagnostic.Kind.ERROR,
    public void testPublicApiMethodReturnAnnotatedGenerics() {  
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiAnnotatedUnparseable.java");  
                matching(  
        final Failure failure = (Failure) result;
    public void testPublicApiConstructorArgumentNotAnnotated() {  
        assertThat(failure.diagnotics(), hasSize(3));  
                        "The element org.opensearch.common.annotation.processor.NotAnnotatedAnnotation is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "
        assertThat(result, instanceOf(Success.class));  
                    containsString(
                    containsString(  
            failure.diagnotics(),  
            )
                    )
     * The type could expose protected inner types which are still considered to be a public API when used  
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodReturnAnnotatedGenerics)"
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
                        "The element org.opensearch.common.annotation.processor.NotAnnotated is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "  
                    Diagnostic.Kind.ERROR,  
                matching(
            "PublicApiAnnotated.java"
                )
    public void testPublicApiMethodReturnAnnotatedArray() {  
import javax.tools.Diagnostic;
                    Diagnostic.Kind.ERROR,
import static org.hamcrest.Matchers.hasSize;
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodArgumentNotAnnotatedGenerics)"
        assertThat(failure.diagnotics(), hasSize(3));  
                matching(
                matching(  
import static org.hamcrest.CoreMatchers.not;
import org.opensearch.common.SuppressForbidden;
import org.opensearch.test.OpenSearchTestCase;  
            "NotAnnotatedAnnotation.java"
                    Diagnostic.Kind.ERROR,
    }
        assertThat(failure.diagnotics(), hasSize(3));
        final Failure failure = (Failure) result;  
            folder.getRoot().toPath(),
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodReturnNotAnnotatedArray)"  
        assertThat(result, instanceOf(Failure.class));
            "InternalApiAnnotated.java"  
        final CompilerResult result = compile(folder.getRoot().toPath(), "ExperimentalApiMethodReturnSelf.java");
        final CompilerResult result = compile(folder.getRoot().toPath(), "DeprecatedApiMethodReturnSelf.java");  
            hasItem(
        assertThat(result, instanceOf(Success.class));  
package org.opensearch.common.annotation.processor;
        assertThat(result, instanceOf(Success.class));  
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodReturnNotAnnotatedBoundedGenerics)"
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodReturnNotAnnotatedGenerics)"
                matching(
        final CompilerResult result = compile(  
            hasItem(
                    containsString(
                    )
            folder.getRoot().toPath(),
            )  
                    )  
                    Diagnostic.Kind.ERROR,
                        "The element org.opensearch.common.annotation.processor.NotAnnotatedAnnotation is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "  
                )  
        );
    public void testPublicApiConstructorArgumentAnnotatedInternalApi() {
    public void testPublicApiMethodArgumentNotAnnotatedPackagePrivate() {  
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
        );
    public void testPublicApiMethodReturnNotAnnotatedBoundedGenerics() {
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
        final CompilerResult result = compile(
                matching(
            "PublicApiAnnotated.java"  
                matching(
            )  
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodReturnNotAnnotatedAnnotation)"  
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiWithDeprecatedApiMethod.java");
    }  
                    )  
    }
            failure.diagnotics(),  
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiWithProtectedInterface.java");  
        final CompilerResult result = compile(
                    containsString(
            "NotAnnotated.java"
        assertThat(
                        "The type org.acme.PublicApiAnnotated is not residing in org.opensearch.* package and should not be annotated as OpenSearch APIs."
    }
            "PublicApiMethodReturnNotAnnotatedArray.java",  
    }
    public void testPublicApiMethodReturnNotAnnotated() {
            "NotAnnotatedAnnotation.java"
            hasItem(
            "PublicApiMethodThrowsNotAnnotated.java",
        assertThat(
    /**  
        final Success success = (Success) result;  
                matching(  
        assertThat(
     * The constructor arguments have relaxed semantics at the moment: those could be not annotated or be annotated as {@link InternalApi}  
        final Success success = (Success) result;  
            failure.diagnotics(),
        final CompilerResult result = compile(
        final CompilerResult result = compile(
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiWithPackagePrivateMethod.java", "NotAnnotated.java");  
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));  
    public void testPublicApiMethodReturnNotAnnotatedWildcardGenerics() {
    }
        assertThat(result, instanceOf(Failure.class));
    public void testPublicApiAnnotatedNotOpensearch() {
        assertThat(  
    public void testPublicApiMethodReturnNotAnnotatedAnnotation() {
        final Success success = (Success) result;
        assertThat(success.diagnotics(), hasSize(2));
            )  
    public void testPublicApiMethodReturnNotAnnotatedArray() {  
            hasItem(  
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodArgumentNotAnnotatedPackagePrivate)"
            folder.getRoot().toPath(),
        final Failure failure = (Failure) result;  
        );
    }  
            folder.getRoot().toPath(),  
        assertThat(result, instanceOf(Success.class));
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiPackagePrivate.java");
        assertThat(
        final Failure failure = (Failure) result;
        final Success success = (Success) result;
        final Failure failure = (Failure) result;
            "PublicApiAnnotated.java",
            failure.diagnotics(),
        assertThat(
    }
                    )  
        );
    }  
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodGenericsArgumentNotAnnotated)"
        final CompilerResult result = compile(  
        final CompilerResult result = compile(  
        );
        assertThat(
        final CompilerResult result = compile(  
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiMethodReturnSelf.java");
            hasItem(
            hasItem(
                    containsString(
        assertThat(success.diagnotics(), hasSize(2));  
    public void testPublicApiMethodGenericsArgumentAnnotated() {
        assertThat(result, instanceOf(Success.class));  
            "NotAnnotated.java"
            "PublicApiMethodReturnNotAnnotatedBoundedGenerics.java",
            failure.diagnotics(),
                )
        assertThat(failure.diagnotics(), hasSize(3));  
            failure.diagnotics(),
    }  
        assertThat(
        final Success success = (Success) result;
            hasItem(  
        assertThat(result, instanceOf(Failure.class));  
import static org.hamcrest.Matchers.hasItem;  
        final Failure failure = (Failure) result;
        );
    public void testPublicApiMethodReturnSelf() {  
        final CompilerResult result = compile(  
            "NotAnnotated.java"
                    Diagnostic.Kind.ERROR,  
        assertThat(failure.diagnotics(), hasSize(3));
                )
            failure.diagnotics(),  
        assertThat(result, instanceOf(Success.class));
    public void testPublicApiMethodThrowsNotAnnotated() {
