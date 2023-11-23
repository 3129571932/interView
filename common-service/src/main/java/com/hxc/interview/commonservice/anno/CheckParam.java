package com.hxc.interview.commonservice.anno;

import java.lang.annotation.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckParam {

}
