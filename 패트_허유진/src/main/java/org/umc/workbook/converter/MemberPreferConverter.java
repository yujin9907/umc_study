package org.umc.workbook.converter;

import org.umc.workbook.domain.FoodCategory;
import org.umc.workbook.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .category(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
