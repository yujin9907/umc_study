package org.umc.workbook.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreType is a Querydsl query type for StoreType
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreType extends EntityPathBase<StoreType> {

    private static final long serialVersionUID = 1000855544L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoreType storeType = new QStoreType("storeType");

    public final org.umc.workbook.domain.common.QBaseEntity _super = new org.umc.workbook.domain.common.QBaseEntity(this);

    public final QFoodCategory category;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Store, QStore> stores = this.<Store, QStore>createList("stores", Store.class, QStore.class, PathInits.DIRECT2);

    public final StringPath type = createString("type");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QStoreType(String variable) {
        this(StoreType.class, forVariable(variable), INITS);
    }

    public QStoreType(Path<? extends StoreType> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStoreType(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStoreType(PathMetadata metadata, PathInits inits) {
        this(StoreType.class, metadata, inits);
    }

    public QStoreType(Class<? extends StoreType> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QFoodCategory(forProperty("category")) : null;
    }

}

