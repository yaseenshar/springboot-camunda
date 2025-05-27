package com.m3sy.bpmn.leavemanagement.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("notifyRejectionDelegate")
public class NotifyRejectionDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String employeeName = (String) execution.getVariable("employeeName");
        System.out.printf("Notify Employee about rejection for: %s", employeeName);
    }
}
