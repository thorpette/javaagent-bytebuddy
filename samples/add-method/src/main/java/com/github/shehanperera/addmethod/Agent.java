package com.github.shehanperera.addmethod;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.implementation.SuperMethodCall;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * This is the agent for set and get values form running class
 */
public class Agent {

    public static void premain(String arguments, Instrumentation instrumentation) {

        System.out.println("Agent for Field Adding ");

        new AgentBuilder.Default()
                .with(new AgentBuilder.InitializationStrategy.SelfInjection.Eager())
                .type((ElementMatchers.nameContains("Method")))
                .transform((builder, typeDescription, classLoader, module) -> builder
                        .defineMethod("method3", void.class, Visibility.PUBLIC)
                        .intercept(SuperMethodCall.INSTANCE
                                .andThen(MethodCall.invoke(ElementMatchers.named("sayHelloAgain"))))
                ).installOn(instrumentation);

    }
}
