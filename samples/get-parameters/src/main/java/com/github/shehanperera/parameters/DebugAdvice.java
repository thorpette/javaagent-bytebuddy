package com.github.shehanperera.parameters;

import net.bytebuddy.asm.Advice;

public static class DebugAdvice {
   @Advice.OnMethodEnter
   static void onEnter(
           @Advice.Origin("#t #m") String method,
           @Advice.AllArguments Object[] args) {

           System.out.println(String.format("start > %s ( %s )", method, Arrays.toString(args)));
   }

   @Advice.OnMethodExit
   static void onExit(
           @Advice.Origin("#t #m") String method,
           @Advice.AllArguments Object[] args) throws Throwable {

       System.out.println(String.format("end > %s ( %s )", method, Arrays.toString(args)));
   }
}
