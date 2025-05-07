package org.umc.workbook.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFoodCategory is a Querydsl query type for FoodCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFoodCategory extends EntityPathBase<FoodCategory> {

    private static final long serialVersionUID = -1550649825L;

    public static final QFoodCategory foodCategory = new QFoodCategory("foodCategory");

    public final org.umc.workbook.domain.common.QBaseEntity _super = new org.umc.workbook.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<org.umc.workbook.domain.mapping.MemberPrefer, org.umc.workbook.domain.mapping.QMemberPrefer> preferences = this.<org.umc.workbook.domain.mapping.MemberPrefer, org.umc.workbook.domain.mapping.QMemberPrefer>createList("preferences", org.umc.workbook.domain.mapping.MemberPrefer.class, org.umc.workbook.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final ListPath<StoreType, QStoreType> storeTypes = this.<StoreType, QStoreType>createList("storeTypes", StoreType.class, QStoreType.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QFoodCategory(String variable) {
        super(FoodCategory.class, forVariable(variable));
    }

    public QFoodCategory(Path<? extends FoodCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFoodCategory(PathMetadata metadata) {
        super(FoodCategory.class, metadata);
    }

}

