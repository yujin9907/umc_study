package org.umc.workbook.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberAgree is a Querydsl query type for MemberAgree
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberAgree extends EntityPathBase<MemberAgree> {

    private static final long serialVersionUID = -846774513L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberAgree memberAgree = new QMemberAgree("memberAgree");

    public final org.umc.workbook.domain.common.QBaseEntity _super = new org.umc.workbook.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final org.umc.workbook.domain.QMember member;

    public final EnumPath<org.umc.workbook.domain.enums.AgreeStatus> status = createEnum("status", org.umc.workbook.domain.enums.AgreeStatus.class);

    public final org.umc.workbook.domain.QTerms terms;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMemberAgree(String variable) {
        this(MemberAgree.class, forVariable(variable), INITS);
    }

    public QMemberAgree(Path<? extends MemberAgree> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberAgree(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberAgree(PathMetadata metadata, PathInits inits) {
        this(MemberAgree.class, metadata, inits);
    }

    public QMemberAgree(Class<? extends MemberAgree> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new org.umc.workbook.domain.QMember(forProperty("member")) : null;
        this.terms = inits.isInitialized("terms") ? new org.umc.workbook.domain.QTerms(forProperty("terms")) : null;
    }

}

