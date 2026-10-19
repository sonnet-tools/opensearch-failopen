        CompilerResult(List<Diagnostic<? extends JavaFileObject>> diagnotics) {
            throw new UncheckedIOException(ex);
                return new Success(collector.getDiagnostics());  
                out,
import java.util.Locale;  
            return diagnotics;
import org.hamcrest.TypeSafeMatcher;
    class CompilerResult {
                .map(f -> asSource(pck, f))
import java.util.stream.Stream;
import javax.tools.JavaCompiler.CompilationTask;  
import org.hamcrest.Matcher;  
                    return new String(in.readAllBytes(), StandardCharsets.UTF_8);
import java.util.Collections;
            final StandardJavaFileManager fileManager = compiler.getStandardFileManager(collector, null, null);
            }  
            if (!kind.equals(item.getKind())) {
import java.io.UncheckedIOException;
        };
                return true;
    }  
import java.net.URI;
import org.opensearch.secure_sm.AccessController;
import javax.tools.JavaFileObject;
 * this file be licensed under the Apache-2.0 license or a
        final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
 */  
        }
        private final List<Diagnostic<? extends JavaFileObject>> diagnotics;  
            }
    default CompilerResult compileWithPackage(Path outputDirectory, String pck, String name, String... names) {  
            }  
            final List<JavaFileObject> files = Stream.concat(Stream.of(name), Arrays.stream(names))  
            this.diagnotics = diagnotics;  
        }
    class Success extends CompilerResult {
import javax.tools.JavaCompiler;
 * The OpenSearch Contributors require contributions made to  
import javax.tools.SimpleJavaFileObject;  
        Failure(List<Diagnostic<? extends JavaFileObject>> diagnotics) {  
                collector,
import java.io.StringWriter;  
        final DiagnosticCollector<JavaFileObject> collector = new DiagnosticCollector<>();
        }
            super(diagnotics);
import java.nio.charset.StandardCharsets;
            } else {
            @Override
import java.util.List;
                description.appendText(" and message ");
}
import javax.tools.JavaFileObject.Kind;
    private static JavaFileObject asSource(String pkg, String name) {  
        HasDiagnostic(final Diagnostic.Kind kind, final Matcher<String> matcher) {  
 * SPDX-License-Identifier: Apache-2.0
        Success(List<Diagnostic<? extends JavaFileObject>> diagnotics) {  
            }
            if (AccessController.doPrivileged(task::call)) {
        }
/*  
        }  
    class HasDiagnostic extends TypeSafeMatcher<Diagnostic<? extends JavaFileObject>> {
        }  
import javax.tools.ToolProvider;
    }  
        }  
            this.matcher = matcher;
        final URL source = ApiAnnotationProcessorTests.class.getResource(resource);
import javax.tools.DiagnosticCollector;
import java.net.URL;  
        } catch (final IOException ex) {
    default CompilerResult compile(Path outputDirectory, String name, String... names) {
                fileManager,  
 *
import java.util.stream.Collectors;
        public static HasDiagnostic matching(final Diagnostic.Kind kind) {  
            } else {  
        }
import org.hamcrest.Description;
        private final Diagnostic.Kind kind;  
            final CompilationTask task = compiler.getTask(
            } else if (matcher != null) {
        final String resource = "/" + pkg.replaceAll("[.]", "/") + "/" + name;
                try (final InputStream in = ApiAnnotationProcessorTests.class.getResourceAsStream(resource)) {
 * compatible open source license.
        return new SimpleJavaFileObject(URI.create(source.toExternalForm()), Kind.SOURCE) {
        try (StringWriter out = new StringWriter()) {
        @Override  
            public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {  
interface CompilerSupport {
        private final Matcher<String> matcher;
        }
                matcher.describeTo(description);
    }
            if (matcher != null) {  
import javax.tools.Diagnostic;  
                null,  
                }  
            );
import java.io.InputStream;
    }  
            super(diagnotics);
        public void describeTo(Description description) {  
        public static HasDiagnostic matching(final Diagnostic.Kind kind, final Matcher<String> matcher) {
            description.appendText("diagnostic with kind ").appendValue(kind).appendText(" ");
        }
                return matcher.matches(item.getMessage(Locale.ROOT));
    }  
import java.util.Arrays;  
import javax.tools.StandardJavaFileManager;
import java.nio.file.Path;
        @Override
            task.setProcessors(Collections.singleton(new ApiAnnotationProcessor()));  
            return new HasDiagnostic(kind, matcher);  
        List<Diagnostic<? extends JavaFileObject>> diagnotics() {  
    }
    class Failure extends CompilerResult {
                .collect(Collectors.toList());
        protected boolean matchesSafely(Diagnostic<? extends JavaFileObject> item) {
    }  
package org.opensearch.common.annotation.processor;
import java.io.IOException;
                return new Failure(collector.getDiagnostics());
                files
            this.kind = kind;
        return compileWithPackage(outputDirectory, ApiAnnotationProcessorTests.class.getPackageName(), name, names);  
                return false;  
            return new HasDiagnostic(kind, null);
                List.of("-d", outputDirectory.toString()),
