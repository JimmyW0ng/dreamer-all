package com.dreamer.admin.repository;

import com.dreamer.admin.domain.enums.SysDictStatus;
import com.dreamer.admin.domain.tables.records.SysDictRecord;
import com.dreamer.admin.pojo.po.SysDictPojo;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

import static com.dreamer.admin.domain.Tables.SYS_DICT;

/**
 * Created by jw on 2016/12/12.
 */
@Repository
public class SysDictRepository extends AbstractCRUDRepository<SysDictRecord, Long, SysDictPojo> {
    @Autowired
    public SysDictRepository(DSLContext dslContext) {
        super(dslContext, SYS_DICT, SYS_DICT.ID, SysDictPojo.class);
    }

    public List<SysDictPojo> findByCondition(Collection<? extends Condition> condition) {
        return dslContext.selectFrom(SYS_DICT).where(condition).fetchInto(SysDictPojo.class);
    }

    public int deleteLogical(Long id) {
        return dslContext.update(SYS_DICT).set(SYS_DICT.DEL_FLAG, true).where(SYS_DICT.ID.eq(id)).execute();
    }

    public void enableSysDict(Long id) {
        dslContext.update(SYS_DICT).set(SYS_DICT.STATUS, SysDictStatus.enable)
                  .where(SYS_DICT.DEL_FLAG.eq(false)).and(SYS_DICT.ID.eq(id))
                  .execute();
    }

    public void disabledSysDict(Long id) {
        dslContext.update(SYS_DICT).set(SYS_DICT.STATUS, SysDictStatus.disabled)
                  .where(SYS_DICT.DEL_FLAG.eq(false)).and(SYS_DICT.ID.eq(id))
                  .execute();
    }

    /**
     * @param groupName
     * @param key       return SysDictPojo
     */
    public SysDictPojo findByGroupNameAndKey(String groupName, String key) {
        return dslContext.selectFrom(SYS_DICT)
                         .where(SYS_DICT.GROUP_NAME.eq(groupName)).and(SYS_DICT.KEY.eq(key))
                         .and(SYS_DICT.STATUS.eq(SysDictStatus.enable))
                         .and(SYS_DICT.DEL_FLAG.eq(false))
                         .fetchOneInto(SysDictPojo.class);
    }

    public List<SysDictPojo> findByGroupNameAndKeyFuzzy(String groupName, String key) {
        return dslContext.selectFrom(SYS_DICT)
                         .where(SYS_DICT.GROUP_NAME.eq(groupName)).and(SYS_DICT.KEY.like("%" + key + "%"))
                         .and(SYS_DICT.STATUS.eq(SysDictStatus.enable))
                         .and(SYS_DICT.DEL_FLAG.eq(false))
                         .fetchInto(SysDictPojo.class);
    }

    /**
     * 根据groupName查找数据
     *
     * @param groupName
     * @Return List<SysDictPojo></>
     */
    public List<SysDictPojo> findByGroupName(String groupName) {
        return dslContext.selectFrom(SYS_DICT)
                         .where(SYS_DICT.GROUP_NAME.eq(groupName))
                         .and(SYS_DICT.STATUS.eq(SysDictStatus.enable))
                         .and(SYS_DICT.DEL_FLAG.eq(false))
                         .orderBy(SYS_DICT.SORT.desc())
                         .fetchInto(SysDictPojo.class);
    }

    /**
     * 根据key查找数据
     *
     * @param key
     * @return List<SysDictPojo></>
     */
    public List<SysDictPojo> findByKey(String key) {
        return dslContext.selectFrom(SYS_DICT)
                         .where(SYS_DICT.KEY.eq(key))
                         .and(SYS_DICT.STATUS.eq(SysDictStatus.enable))
                         .and(SYS_DICT.DEL_FLAG.eq(false))
                         .orderBy(SYS_DICT.SORT.desc())
                         .fetchInto(SysDictPojo.class);
    }

    public SysDictPojo findOneByKey(String key) {
        return dslContext.selectFrom(SYS_DICT)
                         .where(SYS_DICT.KEY.eq(key))
                         .and(SYS_DICT.STATUS.eq(SysDictStatus.enable))
                         .and(SYS_DICT.DEL_FLAG.eq(false))
                         .orderBy(SYS_DICT.SORT.desc())
                         .limit(1)
                         .fetchOneInto(SysDictPojo.class);
    }

    public SysDictPojo findGroupNameAndKeyById(Long id) {
        return dslContext.select(SYS_DICT.GROUP_NAME, SYS_DICT.KEY).from(SYS_DICT)
                         .where(SYS_DICT.ID.eq(id))
                         .and(SYS_DICT.STATUS.eq(SysDictStatus.enable))
                         .and(SYS_DICT.DEL_FLAG.eq(false))
                         .fetchOneInto(SysDictPojo.class);
    }

    public void delLoanRemindMobileAndTimePhysical() {
        dslContext.delete(SYS_DICT)
                  .where(SYS_DICT.GROUP_NAME.eq("loanRemind"))
                  .and(SYS_DICT.KEY.like("%loanRemindMobile%"))
                  .execute();
        dslContext.delete(SYS_DICT).where(SYS_DICT.GROUP_NAME.eq("loanRemind"))
                  .and(SYS_DICT.KEY.eq("loanRemindTime"))
                  .execute();

    }

    public void delLoanRemindMobilePhysical() {
        dslContext.delete(SYS_DICT)
                  .where(SYS_DICT.GROUP_NAME.eq("loanRemind"))
                  .and(SYS_DICT.KEY.like("%loanRemindMobile%"))
                  .execute();
    }

    public void delRepayRemindMobilePhysical() {
        dslContext.delete(SYS_DICT)
                  .where(SYS_DICT.GROUP_NAME.eq("repayRemind"))
                  .and(SYS_DICT.KEY.like("%repayRemindMobile%"))
                  .execute();
    }
}