package org.umc.workbook.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreimage is a Querydsl query type for Storeimage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreimage extends EntityPathBase<Storeimage> {

    private static final long serialVersionUID = 980772989L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoreimage storeimage = new QStoreimage("storeimage");

    public final org.umc.workbook.domain.common.QBaseEntity _super = new org.umc.workbook.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    public final QStore store;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QStoreimage(String variable) {
        this(Storeimage.class, forVariable(variable), INITS);
    }

    public QStoreimage(Path<? extends Storeimage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStoreimage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStoreimage(PathMetadata metadata, PathInits inits) {
        this(Storeimage.class, metadata, inits);
    }

    public QStoreimage(Class<? extends Storeimage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

