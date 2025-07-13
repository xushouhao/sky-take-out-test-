package com.sky.applicationService;

import com.sky.constant.StatusConstant;
import com.sky.context.BaseContext;
import com.sky.dto.EmployeeDTO;
import com.sky.entity.Employee;
import com.sky.service.EmployeeService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @author evil
 * @date 2025/7/14
 * @description
 */
@Service
@RequiredArgsConstructor
public class EmployeeApplicationService {
    private final EmployeeService employeeService;

    // 这里可以添加更多的业务逻辑方法，调用 EmployeeService 的方法来处理业务需求
    public void save(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        // 设置默认值
        employee.setStatus(StatusConstant.ENABLE); //默认启用
        String password = "123456"; //默认密码
        employee.setPassword(DigestUtils.md5DigestAsHex(password.getBytes())); //密码加密
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());
        employee.setCreateUser(BaseContext.getCurrentId());
        employee.setUpdateUser(BaseContext.getCurrentId());
        employeeService.save(employee);
    }


}
