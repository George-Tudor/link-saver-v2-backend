package com.georgetudor.linksaverv2backend.config;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class UsernameMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(String.class)
                && parameter.getParameterName().equals("username");
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        if (this.supportsParameter(parameter)
                && webRequest != null
                && webRequest.getUserPrincipal() != null
                && webRequest.getUserPrincipal().getName() != null) {
            return webRequest.getUserPrincipal().getName().trim().toLowerCase();
        } else {
            return WebArgumentResolver.UNRESOLVED;
        }
    }
}
