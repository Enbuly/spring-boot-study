package com.example.annotation.checkArgs;

import java.lang.reflect.Field;

/**
 * 注解校验器
 *
 * @author zhangzhenyan
 * @since 2019-09-24
 **/
class ValidatorResolver {

    static <T> boolean validate(T t) throws Exception {
        Field[] fields = t.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            CheckArgIsEmpty checkArgIsEmpty = field.getAnnotation(CheckArgIsEmpty.class);
            CheckArgMin checkArgMin = field.getAnnotation(CheckArgMin.class);
            CheckArgMax checkArgMax = field.getAnnotation(CheckArgMax.class);

            // 判断该字段是否为字符串
            if (checkArgIsEmpty != null && field.getType().equals(String.class)) {
                if (field.get(t) == null || ((String) field.get(t)).length() <= 0) {
                    System.out.println(field.getName() + "不可以为空！");
                    return false;
                }
            }

            if ((checkArgMax != null || checkArgMin != null)
                    && field.getType().equals(Integer.class)
                    && field.get(t) == null) {
                System.out.println(field.getName() + "字段不可以为空！");
                return false;
            }

            // 判断该字段是否为Integer或者int类型
            if (field.getType().equals(Integer.class)
                    || field.getType() == int.class) {
                if (checkArgMax != null && ((int) field.get(t)) > checkArgMax.max()) {
                    System.out.println(field.getName() + "字段大于了最大值！");
                    return false;
                }

                if (checkArgMin != null && ((int) field.get(t)) < checkArgMin.min()) {
                    System.out.println(field.getName() + "字段小于了最小值！");
                    return false;
                }
            }
        }
        return true;
    }
}
