/*
 * This file is generated by jOOQ.
*/
package com.dreamer.admin.domain.tables;


import com.dreamer.admin.domain.Dreamer;
import com.dreamer.admin.domain.Keys;
import com.dreamer.admin.domain.tables.records.OgnInfoRecord;
import org.jooq.*;
import org.jooq.impl.DateAsTimestampBinding;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;


/**
 * 机构信息表
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.9.4"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class OgnInfo extends TableImpl<OgnInfoRecord> {

    /**
     * The reference instance of <code>dreamer.ogn_info</code>
     */
    public static final OgnInfo OGN_INFO = new OgnInfo();
    private static final long serialVersionUID = -111519897;
    /**
     * The column <code>dreamer.ogn_info.id</code>. 主键
     */
    public final TableField<OgnInfoRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "主键");
    /**
     * The column <code>dreamer.ogn_info.organ_name</code>. 机构名称
     */
    public final TableField<OgnInfoRecord, String> ORGAN_NAME = createField("organ_name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "机构名称");
    /**
     * The column <code>dreamer.ogn_info.organ_english_name</code>. 机构英文名称
     */
    public final TableField<OgnInfoRecord, String> ORGAN_ENGLISH_NAME = createField("organ_english_name", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "机构英文名称");
    /**
     * The column <code>dreamer.ogn_info.organ_address</code>. 机构地址
     */
    public final TableField<OgnInfoRecord, String> ORGAN_ADDRESS = createField("organ_address", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "机构地址");
    /**
     * The column <code>dreamer.ogn_info.organ_short_introduce</code>. 机构简介
     */
    public final TableField<OgnInfoRecord, String> ORGAN_SHORT_INTRODUCE = createField("organ_short_introduce", org.jooq.impl.SQLDataType.CLOB, this, "机构简介");
    /**
     * The column <code>dreamer.ogn_info.organ_create_date</code>. 机构成立日期
     */
    public final TableField<OgnInfoRecord, Timestamp> ORGAN_CREATE_DATE = createField("organ_create_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "机构成立日期", new DateAsTimestampBinding());
    /**
     * The column <code>dreamer.ogn_info.organ_phone</code>. 机构官方电话
     */
    public final TableField<OgnInfoRecord, String> ORGAN_PHONE = createField("organ_phone", org.jooq.impl.SQLDataType.VARCHAR.length(32), this, "机构官方电话");
    /**
     * The column <code>dreamer.ogn_info.organ_email</code>. 机构官方邮箱
     */
    public final TableField<OgnInfoRecord, String> ORGAN_EMAIL = createField("organ_email", org.jooq.impl.SQLDataType.VARCHAR.length(32), this, "机构官方邮箱");
    /**
     * The column <code>dreamer.ogn_info.orgen_url</code>. 机构官方网址
     */
    public final TableField<OgnInfoRecord, String> ORGEN_URL = createField("orgen_url", org.jooq.impl.SQLDataType.VARCHAR.length(32), this, "机构官方网址");

    /**
     * Create a <code>dreamer.ogn_info</code> table reference
     */
    public OgnInfo() {
        this("ogn_info", null);
    }

    /**
     * Create an aliased <code>dreamer.ogn_info</code> table reference
     */
    public OgnInfo(String alias) {
        this(alias, OGN_INFO);
    }

    private OgnInfo(String alias, Table<OgnInfoRecord> aliased) {
        this(alias, aliased, null);
    }

    private OgnInfo(String alias, Table<OgnInfoRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "机构信息表");
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OgnInfoRecord> getRecordType() {
        return OgnInfoRecord.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Dreamer.DREAMER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<OgnInfoRecord, Long> getIdentity() {
        return Keys.IDENTITY_OGN_INFO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<OgnInfoRecord> getPrimaryKey() {
        return Keys.KEY_OGN_INFO_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<OgnInfoRecord>> getKeys() {
        return Arrays.<UniqueKey<OgnInfoRecord>>asList(Keys.KEY_OGN_INFO_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnInfo as(String alias) {
        return new OgnInfo(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public OgnInfo rename(String name) {
        return new OgnInfo(name, null);
    }
}
