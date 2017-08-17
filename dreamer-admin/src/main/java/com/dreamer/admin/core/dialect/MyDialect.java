package com.dreamer.admin.core.dialect;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;

/**
 * Created by jw on 2016/12/15.
 */
public class MyDialect extends AbstractDialect implements IExpressionObjectDialect {
    private final MyExpressionFactory myExpressionFactory = new MyExpressionFactory();

    public MyDialect() {
        super("myUtils");
    }

    @Override
    public IExpressionObjectFactory getExpressionObjectFactory() {
        return myExpressionFactory;
    }
}
