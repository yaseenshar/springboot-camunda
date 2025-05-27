package com.m3sy.bpmn.leavemanagement.controller;

import com.m3sy.bpmn.leavemanagement.model.LeaveRequest;
import com.m3sy.bpmn.leavemanagement.model.LeaveRequestDTO;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/leave")
public class LeaveController {

    /*private final RuntimeService runtimeService;

    public LeaveController(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }*/

    @PostMapping
    public String applyForLeave(@Validated @RequestBody LeaveRequestDTO leaveRequest) {

        Map<String, Object> vars = new HashMap<>();
        vars.put("employeeName", leaveRequest.employeeName());
        vars.put("employeeEmail", leaveRequest.employeeEmail());
        vars.put("leaveDays", leaveRequest.days());

        //runtimeService.startProcessInstanceByKey("leave_approval", vars);

        return "Leave Request Submitted";
    }
}
