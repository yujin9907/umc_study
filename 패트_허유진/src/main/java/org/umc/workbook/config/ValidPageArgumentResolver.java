package org.umc.workbook.config;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.umc.workbook.apiPayload.code.ErrorStatus;
import org.umc.workbook.apiPayload.exception.GeneralException;
import org.umc.workbook.validation.annotation.ValidPage;

@Component
public class ValidPageArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(ValidPage.class) &&
                parameter.getParameterType().equals(Integer.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {

        String pageParam = webRequest.getParameter("page");
        if (pageParam == null) {
            throw new GeneralException(ErrorStatus.INVALID_PAGE_NUMBER);
        }

        int page;
        try {
            page = Integer.parseInt(pageParam);
        } catch (NumberFormatException e) {
            throw new GeneralException(ErrorStatus.INVALID_PAGE_NUMBER);
        }

        if (page < 1) {
            throw new GeneralException(ErrorStatus.INVALID_PAGE_NUMBER);
        }

        return page - 1;
    }
}