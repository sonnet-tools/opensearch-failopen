                matching(
            folder.getRoot().toPath(),
            failure.diagnotics(),
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiAnnotatedUnparseable.java");
                )
    }
        assertThat(result, instanceOf(Success.class));
     */
                        "The element org.opensearch.common.annotation.processor.AnnotatedPackagePrivate is part of the public APIs but does not have public or protected visibility "
        final Failure failure = (Failure) result;
            folder.getRoot().toPath(),
        final CompilerResult result = compile(
            hasItem(
        assertThat(result, instanceOf(Failure.class));
        final Failure failure = (Failure) result;
                    Diagnostic.Kind.ERROR,
                )
        final Success success = (Success) result;
                matching(
public class ApiAnnotationProcessorTests extends OpenSearchTestCase implements CompilerSupport {
    }
import static org.hamcrest.Matchers.hasSize;
            )
                    )
                    Diagnostic.Kind.ERROR,
        );
        assertThat(failure.diagnotics(), hasSize(3));
                    containsString(
    public void testPublicApiMethodArgumentNotAnnotated() {
        final CompilerResult result = compile(
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodArgumentNotAnnotatedPackagePrivate)"
            "PublicApiAnnotated.java"
        );
        final Failure failure = (Failure) result;
        assertThat(failure.diagnotics(), hasSize(4));
    public void testExperimentalApiMethodReturnSelf() {
                )
            hasItem(
                    )
        final Success success = (Success) result;
                    containsString(
            )
        assertThat(
        assertThat(success.diagnotics(), hasSize(2));
            "PublicApiMethodGenericsArgumentAnnotated.java",
                matching(
        assertThat(result, instanceOf(Success.class));
                matching(
                matching(
    }
                )
            "PublicApiMethodReturnAnnotatedGenerics.java",
        assertThat(result, instanceOf(Success.class));
                        "The element org.opensearch.common.annotation.processor.NotAnnotatedAnnotation is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "
            )
                matching(
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
            folder.getRoot().toPath(),
            )
    public void testPublicApiUnparseableVersion() {
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
    }
            "NotAnnotated.java"
            folder.getRoot().toPath(),
            "PublicApiMethodReturnAnnotatedArray.java",
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodReturnAnnotatedGenerics)"
    }
        final Success success = (Success) result;
                )
        final CompilerResult result = compile(
        );
            "NotAnnotated.java"
    public void testPublicApiConstructorArgumentAnnotatedInternalApi() {
        assertThat(failure.diagnotics(), hasSize(3));
                        "The element org.opensearch.common.annotation.processor.PublicApiPackagePrivate is part of the public APIs but does not have public or protected visibility"
        assertThat(result, instanceOf(Failure.class));
            )
        );
            )
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodReturnNotAnnotated)"
    public void testPublicApiMethodReturnNotAnnotated() {
        );
                )
                    containsString(
     * The constructor arguments have relaxed semantics at the moment: those could be not annotated or be annotated as {@link InternalApi}
    }
        assertThat(
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodReturnNotAnnotatedBoundedGenerics)"
    public void testPublicApiMethodReturnNotAnnotatedGenerics() {
    }
        assertThat(success.diagnotics(), hasSize(2));
        );
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
        assertThat(result, instanceOf(Failure.class));
                    )
        assertThat(result, instanceOf(Success.class));
    }
                        "The type org.acme.PublicApiAnnotated is not residing in org.opensearch.* package and should not be annotated as OpenSearch APIs."
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiMethodArgumentNotAnnotated.java", "NotAnnotated.java");
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiWithProtectedInterface.java");
        assertThat(
                matching(
        );
    public void testPublicApiMethodArgumentAnnotatedPackagePrivate() {
        );
    /**
        );
            )
                )
                    containsString(
        final CompilerResult result = compile(
    public void testPublicApiMethodThrowsNotAnnotated() {
        assertThat(result, instanceOf(Failure.class));
            "PublicApiMethodThrowsNotAnnotated.java",
                    Diagnostic.Kind.ERROR,
            folder.getRoot().toPath(),
        assertThat(success.diagnotics(), hasSize(2));
            hasItem(
            failure.diagnotics(),
            )
}
        assertThat(success.diagnotics(), hasSize(2));
    public void testPublicApiPackagePrivate() {
                    Diagnostic.Kind.ERROR,
        final Success success = (Success) result;
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
            failure.diagnotics(),
                    )
        final Success success = (Success) result;
            failure.diagnotics(),
            hasItem(
            hasItem(
    public void testPublicApiMethodGenericsArgumentNotAnnotated() {
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiMethodReturnSelf.java");
                    )
                )
        assertThat(success.diagnotics(), hasSize(2));
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiPackagePrivate.java");
        assertThat(failure.diagnotics(), hasSize(3));
            )
        assertThat(success.diagnotics(), hasSize(2));
        );
        assertThat(success.diagnotics(), hasSize(2));
                    containsString(
                    )
            "PublicApiMethodReturnNotAnnotatedArray.java",
import static org.opensearch.common.annotation.processor.CompilerSupport.HasDiagnostic.matching;
        assertThat(
        assertThat(failure.diagnotics(), hasSize(3));
    /**
                )
                        "The type org.opensearch.common.annotation.processor.PublicApiAnnotatedUnparseable has @PublicApi annotation with unparseable OpenSearch version: 2.x"
            folder.getRoot().toPath(),
    public void testDeprecatedApiMethodReturnSelf() {
    }
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiMethodReturnNotAnnotatedWildcardGenerics.java");
                        "The element org.opensearch.common.annotation.processor.NotAnnotatedException is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "
        assertThat(result, instanceOf(Failure.class));
    }
        assertThat(result, instanceOf(Failure.class));
        assertThat(result, instanceOf(Success.class));
                        "The element org.opensearch.common.annotation.processor.NotAnnotatedPackagePrivate is part of the public APIs but does not have public or protected visibility "
        assertThat(result, instanceOf(Failure.class));
        final Success success = (Success) result;
            failure.diagnotics(),
        final CompilerResult result = compileWithPackage(folder.getRoot().toPath(), "org.acme", "PublicApiAnnotated.java");
                    Diagnostic.Kind.ERROR,
            "PublicApiAnnotated.java",
 *
            hasItem(
        assertThat(result, instanceOf(Success.class));
        final Failure failure = (Failure) result;
            failure.diagnotics(),
        assertThat(
                    )
            )
                    containsString(
            "NotAnnotated.java"
                    )
                    containsString(
            failure.diagnotics(),
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
import org.opensearch.common.SuppressForbidden;
        assertThat(
            "NotAnnotatedAnnotation.java"
     */
                    Diagnostic.Kind.ERROR,
                    )
                )
            hasItem(
                    containsString(
        final CompilerResult result = compile(
            hasItem(
            )
                    containsString(
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodReturnNotAnnotatedArray)"
            "PublicApiAnnotated.java"
            "NotAnnotated.java"
        assertThat(success.diagnotics(), hasSize(2));
        assertThat(result, instanceOf(Failure.class));
    }
            "PublicApiAnnotated.java",
@SuppressForbidden(reason = "TemporaryFolder does not support Path-based APIs")
            "PublicApiMethodReturnNotAnnotatedBoundedGenerics.java",
        final CompilerResult result = compile(
 * SPDX-License-Identifier: Apache-2.0
        final CompilerResult result = compile(
            folder.getRoot().toPath(),
                        "The element org.opensearch.common.annotation.processor.NotAnnotated is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodGenericsArgumentNotAnnotated)"
        assertThat(failure.diagnotics(), hasSize(3));
        assertThat(
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiWithDeprecatedApiMethod.java");
                matching(
                    )
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiMethodReturnNotAnnotated.java", "NotAnnotated.java");
            "InternalApiAnnotated.java"
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
                )
        final CompilerResult result = compile(
            "NotAnnotated.java"
        assertThat(result, instanceOf(Success.class));
            failure.diagnotics(),
    }
        assertThat(
                    containsString(
 * this file be licensed under the Apache-2.0 license or a
            folder.getRoot().toPath(),
    }
        final Success success = (Success) result;
        final CompilerResult result = compile(folder.getRoot().toPath(), "ExperimentalApiMethodReturnSelf.java");
 * The OpenSearch Contributors require contributions made to
@SuppressWarnings("deprecation")
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiWithPackagePrivateMethod.java", "NotAnnotated.java");
        assertThat(
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodArgumentNotAnnotatedPackagePrivate)"
            failure.diagnotics(),
    }
        );
        assertThat(failure.diagnotics(), hasSize(3));
        final Success success = (Success) result;
            "PublicApiMethodGenericsArgumentNotAnnotated.java",
        );
     * The constructor arguments have relaxed semantics at the moment: those could be not annotated or be annotated as {@link InternalApi}
        assertThat(success.diagnotics(), hasSize(2));
                        "The element org.opensearch.common.annotation.processor.NotAnnotated is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "
        );
        final CompilerResult result = compile(
                    containsString(
    }
                    )
            )
            hasItem(
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodReturnNotAnnotatedGenerics)"
            folder.getRoot().toPath(),
            hasItem(
            failure.diagnotics(),
                        "The element org.opensearch.common.annotation.processor.NotAnnotatedAnnotation is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "
import static org.hamcrest.Matchers.instanceOf;
        );
        final Failure failure = (Failure) result;
        final Success success = (Success) result;
        );
    /**
            "PublicApiMethodReturnNotAnnotatedAnnotation.java",
        final CompilerResult result = compile(
            hasItem(
        assertThat(failure.diagnotics(), hasSize(3));
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
                matching(
    public void testPublicApiConstructorAnnotatedInternalApi() {
        assertThat(
        );
        assertThat(failure.diagnotics(), hasSize(3));
        assertThat(success.diagnotics(), hasSize(2));
import org.junit.Rule;
     * The constructor arguments have relaxed semantics at the moment: those could be not annotated or be annotated as {@link InternalApi}
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiWithExperimentalApiMethod.java");
        );
            failure.diagnotics(),
        final Failure failure = (Failure) result;
                )
import static org.hamcrest.Matchers.hasItem;
    public void testPublicApiMethodReturnAnnotatedArray() {
            hasItem(
            )
        assertThat(result, instanceOf(Failure.class));
        final Success success = (Success) result;
                    containsString(
                    )
            hasItem(
        assertThat(failure.diagnotics(), hasSize(3));
            folder.getRoot().toPath(),
    public void testPublicApiWithProtectedInterface() {
        assertThat(result, instanceOf(Success.class));
                    Diagnostic.Kind.ERROR,
                        "The element org.opensearch.common.annotation.processor.NotAnnotated is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "
        );
        );
        final CompilerResult result = compile(
    public void testPublicApiMethodReturnSelf() {
        assertThat(
                        "The element org.opensearch.common.annotation.processor.NotAnnotatedPackagePrivate is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "
                matching(
     * The type could expose protected inner types which are still considered to be a public API when used
    public void testPublicApiMethodArgumentNotAnnotatedGenerics() {
                    containsString(
        );
                    Diagnostic.Kind.ERROR,
        assertThat(result, instanceOf(Success.class));
        assertThat(
        final Success success = (Success) result;
                    containsString(
        assertThat(
    public void testPublicApiMethodReturnNotAnnotatedArray() {
import org.opensearch.common.annotation.InternalApi;
        final Success success = (Success) result;
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
            "PublicApiAnnotated.java"
    public final TemporaryFolder folder = new TemporaryFolder();
            "NotAnnotatedAnnotation.java"
        );
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
        );
            )
                        "The element org.opensearch.common.annotation.processor.NotAnnotated is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "
            )
            hasItem(
    /**
import org.junit.rules.TemporaryFolder;
    }
        assertThat(
                )
            failure.diagnotics(),
        assertThat(result, instanceOf(Failure.class));
            failure.diagnotics(),
        assertThat(result, instanceOf(Failure.class));
        assertThat(
                        "The element method() is part of the public APIs but is marked as @InternalApi (referenced by org.opensearch.common.annotation.processor.PublicApiWithInternalApiMethod)"
                    )
        assertThat(result, instanceOf(Failure.class));
    }
    }
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiWithInternalApiMethod.java");
        assertThat(result, instanceOf(Failure.class));
                        "The element org.opensearch.common.annotation.processor.NotAnnotated is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "
        );
        assertThat(result, instanceOf(Success.class));
                    Diagnostic.Kind.ERROR,
                matching(
                matching(
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodArgumentNotAnnotatedGenerics)"
                    Diagnostic.Kind.ERROR,
        assertThat(failure.diagnotics(), hasSize(3));
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodArgumentAnnotatedPackagePrivate)"
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodThrowsNotAnnotated)"
        assertThat(failure.diagnotics(), hasSize(3));
                    )
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiMethodArgumentAnnotatedPackagePrivate.java");
    }
                        "The element org.opensearch.common.annotation.processor.NotAnnotated is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "
        assertThat(
                    Diagnostic.Kind.ERROR,
        assertThat(result, instanceOf(Success.class));
    }
                    )
                    containsString(
        assertThat(result, instanceOf(Success.class));
    public void testPublicApiConstructorArgumentNotAnnotated() {
/*
            folder.getRoot().toPath(),
            hasItem(
        assertThat(result, instanceOf(Failure.class));
import static org.hamcrest.CoreMatchers.not;
        );
            "PublicApiConstructorAnnotatedInternalApi.java",
    public void testPublicApiAnnotatedNotOpensearch() {
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodArgumentNotAnnotated)"
        final CompilerResult result = compile(
    }
    public void testPublicApiMethodReturnAnnotatedGenerics() {
                )
        final Failure failure = (Failure) result;
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
        assertThat(result, instanceOf(Success.class));
    }
import static org.hamcrest.Matchers.containsString;
        final Failure failure = (Failure) result;
    }
     */
        final CompilerResult result = compile(folder.getRoot().toPath(), "DeprecatedApiMethodReturnSelf.java");
                    )
            "PublicApiConstructorArgumentAnnotatedInternalApi.java",
        assertThat(result, instanceOf(Failure.class));
        assertThat(success.diagnotics(), hasSize(2));
        final Failure failure = (Failure) result;
                        "The element org.opensearch.common.annotation.processor.NotAnnotated is part of the public APIs but is not marked as @PublicApi, @ExperimentalApi or @DeprecatedApi "
        final Failure failure = (Failure) result;
                    containsString(
        final Failure failure = (Failure) result;
     */
            )
    }
        assertThat(result, instanceOf(Failure.class));
    public void testPublicApiMethodGenericsArgumentAnnotated() {
    }
        final CompilerResult result = compile(folder.getRoot().toPath(), "PublicApiMethodArgumentNotAnnotatedPackagePrivate.java");
        assertThat(failure.diagnotics(), hasSize(3));
            failure.diagnotics(),
    }
    public void testPublicApiWithExperimentalApiMethod() {
            hasItem(
            failure.diagnotics(),
        );
 */
            "NotAnnotated.java"
                    containsString(
            folder.getRoot().toPath(),
                matching(
            failure.diagnotics(),
        final Failure failure = (Failure) result;
                    Diagnostic.Kind.ERROR,
    public void testPublicApiWithDeprecatedApiMethod() {
        assertThat(failure.diagnotics(), hasSize(3));
    }
            folder.getRoot().toPath(),
package org.opensearch.common.annotation.processor;
    public void testPublicApiWithPackagePrivateMethod() {
            )
import org.opensearch.test.OpenSearchTestCase;
                matching(
            "PublicApiConstructorArgumentNotAnnotated.java",
            "PublicApiMethodReturnNotAnnotatedGenerics.java",
    }
                    Diagnostic.Kind.ERROR,
                    )
                    Diagnostic.Kind.ERROR,
                matching(
                matching(
        );
                    Diagnostic.Kind.ERROR,
                )
                matching(
        final Success success = (Success) result;
                )
    public void testPublicApiMethodReturnNotAnnotatedAnnotation() {
        );
        final Failure failure = (Failure) result;
        assertThat(
                    Diagnostic.Kind.ERROR,
            "NotAnnotated.java"
        );
    public void testPublicApiWithInternalApiMethod() {
        final Failure failure = (Failure) result;
        assertThat(success.diagnotics(), hasSize(2));
        assertThat(success.diagnotics(), not(hasItem(matching(Diagnostic.Kind.ERROR))));
            "PublicApiMethodArgumentNotAnnotatedGenerics.java",
    public void testPublicApiMethodArgumentNotAnnotatedPackagePrivate() {
                    Diagnostic.Kind.ERROR,
        );
                )
        assertThat(failure.diagnotics(), hasSize(3));
        assertThat(success.diagnotics(), hasSize(2));
        final Failure failure = (Failure) result;
        assertThat(failure.diagnotics(), hasSize(3));
 * compatible open source license.
        );
            hasItem(
    }
        final Failure failure = (Failure) result;
import javax.tools.Diagnostic;
    @Rule
    public void testPublicApiMethodReturnNotAnnotatedWildcardGenerics() {
    public void testPublicApiMethodReturnNotAnnotatedBoundedGenerics() {
                            + "(referenced by org.opensearch.common.annotation.processor.PublicApiMethodReturnNotAnnotatedAnnotation)"
            failure.diagnotics(),
        final CompilerResult result = compile(
