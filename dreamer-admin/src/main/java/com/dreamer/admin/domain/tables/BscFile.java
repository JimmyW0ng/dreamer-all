/*
 * This file is generated by jOOQ.
*/
package com.dreamer.admin.domain.tables;


import com.dreamer.admin.domain.Dreamer;
import com.dreamer.admin.domain.Keys;
import com.dreamer.admin.domain.enums.BscFileBizType;
import com.dreamer.admin.domain.enums.BscFileFileStatus;
import com.dreamer.admin.domain.tables.records.BscFileRecord;
import org.jooq.*;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;


/**
 * 文件表
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.9.4"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class BscFile extends TableImpl<BscFileRecord> {

    /**
     * The reference instance of <code>dreamer.bsc_file</code>
     */
    public static final BscFile BSC_FILE = new BscFile();
    private static final long serialVersionUID = 762252500;
    /**
     * The column <code>dreamer.bsc_file.id</code>. 主键
     */
    public final TableField<BscFileRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "主键");
    /**
     * The column <code>dreamer.bsc_file.file_name</code>. 文件名字
     */
    public final TableField<BscFileRecord, String> FILE_NAME = createField("file_name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "文件名字");
    /**
     * The column <code>dreamer.bsc_file.file_url</code>. 文件url
     */
    public final TableField<BscFileRecord, String> FILE_URL = createField("file_url", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "文件url");
    /**
     * The column <code>dreamer.bsc_file.biz_type</code>. 业务类型：机构banner；课程banner；
     */
    public final TableField<BscFileRecord, BscFileBizType> BIZ_TYPE = createField("biz_type", org.jooq.util.mysql.MySQLDataType.VARCHAR.asEnumDataType(com.dreamer.admin.domain.enums.BscFileBizType.class), this, "业务类型：机构banner；课程banner；");
    /**
     * The column <code>dreamer.bsc_file.source_id</code>. 业务ID
     */
    public final TableField<BscFileRecord, Long> SOURCE_ID = createField("source_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "业务ID");
    /**
     * The column <code>dreamer.bsc_file.order</code>.
     */
    public final TableField<BscFileRecord, Integer> ORDER = createField("order", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");
    /**
     * The column <code>dreamer.bsc_file.file_status</code>. 文件状态：可用；不可用
     */
    public final TableField<BscFileRecord, BscFileFileStatus> FILE_STATUS = createField("file_status", org.jooq.util.mysql.MySQLDataType.VARCHAR.asEnumDataType(com.dreamer.admin.domain.enums.BscFileFileStatus.class), this, "文件状态：可用；不可用");
    /**
     * The column <code>dreamer.bsc_file.create_at</code>. 创建时间
     */
    public final TableField<BscFileRecord, Timestamp> CREATE_AT = createField("create_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "创建时间");
    /**
     * The column <code>dreamer.bsc_file.update_at</code>. 更新时间
     */
    public final TableField<BscFileRecord, Timestamp> UPDATE_AT = createField("update_at", org.jooq.impl.SQLDataType.TIMESTAMP, this, "更新时间");
    /**
     * The column <code>dreamer.bsc_file.remarks</code>. 备注信息
     */
    public final TableField<BscFileRecord, String> REMARKS = createField("remarks", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "备注信息");
    /**
     * The column <code>dreamer.bsc_file.del_flag</code>. 删除标志
     */
    public final TableField<BscFileRecord, Boolean> DEL_FLAG = createField("del_flag", org.jooq.impl.SQLDataType.BIT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("b'0'", org.jooq.impl.SQLDataType.BIT)), this, "删除标志");
    /**
     * The column <code>dreamer.bsc_file.version</code>.
     */
    public final TableField<BscFileRecord, Long> VERSION = createField("version", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>dreamer.bsc_file</code> table reference
     */
    public BscFile() {
        this("bsc_file", null);
    }

    /**
     * Create an aliased <code>dreamer.bsc_file</code> table reference
     */
    public BscFile(String alias) {
        this(alias, BSC_FILE);
    }

    private BscFile(String alias, Table<BscFileRecord> aliased) {
        this(alias, aliased, null);
    }

    private BscFile(String alias, Table<BscFileRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "文件表");
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BscFileRecord> getRecordType() {
        return BscFileRecord.class;
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
    public Identity<BscFileRecord, Long> getIdentity() {
        return Keys.IDENTITY_BSC_FILE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<BscFileRecord> getPrimaryKey() {
        return Keys.KEY_BSC_FILE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<BscFileRecord>> getKeys() {
        return Arrays.<UniqueKey<BscFileRecord>>asList(Keys.KEY_BSC_FILE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TableField<BscFileRecord, Long> getRecordVersion() {
        return VERSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BscFile as(String alias) {
        return new BscFile(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public BscFile rename(String name) {
        return new BscFile(name, null);
    }
}
