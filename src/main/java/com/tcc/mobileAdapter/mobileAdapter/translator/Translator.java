package com.tcc.mobileAdapter.mobileAdapter.translator;

import org.modelmapper.ModelMapper;

public class Translator {
    public static <I, O> O translate(I source, Class<O> outClass) {
        return new ModelMapper().map(source, outClass);
    }
}
