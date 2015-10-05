package com.softserve.edu.atqc.tools.search;

public final class ContextRepository {

    private ContextRepository() {
    }

    public static IContext getImplicitWrapper() {
        return ImplicitWrapper.get();
    }

    public static IContext getExplicitWrapper() {
        return ExplicitWrapper.get();
    }

}
