package com.kcaco.designpattern.行为型.责任链.common.test.filter;

import com.kcaco.designpattern.行为型.责任链.common.base.context.AbstractBaseContext;
import com.kcaco.designpattern.行为型.责任链.common.base.BaseFilter;
import com.kcaco.designpattern.行为型.责任链.common.base.ResultModel;
import com.kcaco.designpattern.行为型.责任链.common.test.LeaveApprovalInfo;

/**
 * Description: 主管审批
 *
 * @author kcaco
 * @since 2023-05-03 00:46
 */
public class DirectorApprovalFilter implements BaseFilter<LeaveApprovalInfo> {

    @Override
    public void doFilter(AbstractBaseContext<LeaveApprovalInfo> context) {
        LeaveApprovalInfo processModel = context.getProcessModel();

        if (processModel.getReason().length() > 10) {
            System.out.println("主管审批通过");
            context.setNeedBreak(false);
            context.setResponse(ResultModel.success("主管审批通过"));
        } else {
            System.out.println("主管审批不通过");
            context.setNeedBreak(true);
            context.setResponse(ResultModel.failed("主管审批不通过"));
        }

    }
}


