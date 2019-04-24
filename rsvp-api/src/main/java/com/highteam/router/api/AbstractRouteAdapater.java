package com.highteam.router.api;

public abstract class AbstractRouteAdapater implements RouteAdapater {

    @Override
    public boolean requiredAuthor() {
        return true;
    }
}
