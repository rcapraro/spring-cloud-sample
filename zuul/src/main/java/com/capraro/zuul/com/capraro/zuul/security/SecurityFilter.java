package com.capraro.zuul.com.capraro.zuul.security;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * Fake security token.
 * Created by Richard Capraro on 30/08/2015.
 */
public class SecurityFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 100;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader("X-Auth-Token", "GRANTED");
        return null;
    }
}
