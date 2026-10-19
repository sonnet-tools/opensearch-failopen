    /**
            .ignore(ElementMatchers.nameContains("$MockitoMock$")) /* ingore all Mockito mocks */  
    private static AgentBuilder createAgentBuilder() throws Exception {  
import java.net.Socket;  
import net.bytebuddy.ByteBuddy;  
            .type(pathType.or(fileChannelType).or(fileSystemProviderType))  
        final Junction<TypeDescription> fileSystemProviderType = ElementMatchers.isSubTypeOf(FileSystemProvider.class);
        }  
     */
        initAgent(instrumentation);
public class Agent {  
import net.bytebuddy.implementation.MethodDelegation;
    private Agent() {}
 *
     * @param agentArguments agent arguments
     * @param agentArguments agent arguments  
    public static void agentmain(String agentArguments, Instrumentation instrumentation) throws Exception {
            .transform(socketTransformer)
}  
    }  
import java.nio.file.spi.FileSystemProvider;
            Advice.to(SocketChannelInterceptor.class)
                (b, typeDescription, classLoader, module, pd) -> b.visit(
     * @param instrumentation instrumentation
    private static void initAgent(Instrumentation instrumentation) throws Exception {
import java.nio.channels.FileChannel;
import net.bytebuddy.asm.Advice;
            .or(ElementMatchers.isSubTypeOf(Socket.class));
            .with(AgentBuilder.RedefinitionStrategy.REDEFINITION)
 * SPDX-License-Identifier: Apache-2.0
import java.lang.instrument.Instrumentation;
 * Java Agent
                )  
    public static void premain(String agentArguments, Instrumentation instrumentation) throws Exception {
        "deleteIfExists",  
                .on(ElementMatchers.named("connect").and(ElementMatchers.not(ElementMatchers.isAbstract())))  
                (b, typeDescription, classLoader, module, pd) -> b.visit(
            )
import net.bytebuddy.description.type.TypeDescription;  
 * The OpenSearch Contributors require contributions made to  
            ElementMatchers.named("getSubject")
        "copy",
        if (Runtime.version().feature() >= 24) {
    }  
        "createDirectories",  
 */
package org.opensearch.javaagent;
            .transform(  
     * @throws Exception Exception  
        final ByteBuddy byteBuddy = new ByteBuddy().with(Implementation.Context.Disabled.Factory.INSTANCE);
        "createFile",
 * this file be licensed under the Apache-2.0 license or a
import net.bytebuddy.matcher.ElementMatcher.Junction;  
    }
            .type(socketType)
            .transform(fileTransformer)
/**  
import javax.security.auth.Subject;  
import org.opensearch.javaagent.bootstrap.internal.SubjectInterceptor;
        final Junction<TypeDescription> fileChannelType = ElementMatchers.isSubTypeOf(FileChannel.class);
    private static final String[] INTERCEPTED_METHODS = {  
import java.nio.file.Files;  
import net.bytebuddy.matcher.ElementMatchers;
        var builder = new AgentBuilder.Default(byteBuddy).with(AgentBuilder.InitializationStrategy.NoOp.INSTANCE)  
        final AgentBuilder.Transformer fileTransformer = (b, typeDescription, classLoader, module, pd) -> b.visit(  
     */  
import java.nio.channels.SocketChannel;
        // Only apply the transformation when running on JDK-24 or above  
    /**
        );
        "write",
     * @throws Exception Exception
        "createLink",
     * Constructor
            builder = builder.type(ElementMatchers.is(Subject.class)).transform(subjectTransformer);
    /**  
        final Junction<TypeDescription> pathType = ElementMatchers.isSubTypeOf(Files.class);  
 */  
     */
    /**
     */  
            .transform(  
                    Advice.to(RuntimeHaltInterceptor.class).on(ElementMatchers.named("halt"))
 * compatible open source license.
        return builder;
            .type(ElementMatchers.is(java.lang.Runtime.class))
            );
/*  
     * Agent Main  
        final Junction<TypeDescription> socketType = ElementMatchers.isSubTypeOf(SocketChannel.class)
        AgentBuilder agentBuilder = createAgentBuilder();  
     * @param instrumentation instrumentation
        agentBuilder.installOn(instrumentation);
import net.bytebuddy.implementation.Implementation;
        ).intercept(MethodDelegation.to(SubjectInterceptor.class));  
        "open" };
        "read",
        final AgentBuilder.Transformer socketTransformer = (b, typeDescription, classLoader, module, pd) -> b.visit(
            Advice.to(FileInterceptor.class).on(ElementMatchers.namedOneOf(INTERCEPTED_METHODS).or(ElementMatchers.isAbstract()))
            .type(ElementMatchers.is(java.lang.System.class))
        final AgentBuilder.Transformer subjectTransformer = (b, typeDescription, classLoader, module, pd) -> b.method(
            .with(AgentBuilder.TypeStrategy.Default.REDEFINE)
        );
     * List of methods that are intercepted
        initAgent(instrumentation);  
    }
     * Premain
                    Advice.to(SystemExitInterceptor.class).on(ElementMatchers.named("exit"))
                )  
        "newByteChannel",
        "delete",
import net.bytebuddy.agent.builder.AgentBuilder;
        "move",  
