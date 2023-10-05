package com.is2.api.project.Services;

import java.util.ArrayList;
import java.util.List;

public class RoleServices {
    public static <T extends Enum<T>> List<String> enumToList(Class<T> enumClass) {
        List<String> enumValuesList = new ArrayList<>();
        T[] enumConstants = enumClass.getEnumConstants();
        for (T enumConstant : enumConstants) {
            enumValuesList.add(enumConstant.name());
        }
        return enumValuesList;
    }
}
