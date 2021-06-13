package my.project.controller;

import my.project.dto.CreateEntityDataBase;
import my.project.dto.CreateWebParamToEntityDataBase;
import my.project.dto.UpdateEntityDataBase;
import my.project.dto.UpdateWebParamToEntityDataBase;
import my.project.entity.Employee;
import my.project.exceptions.AllEntityWebException;
import my.project.exceptions.EmployeeWebException;
import my.project.service.communication.CreateEmployeePositionCommunicationService;
import my.project.service.communication.EmployeeAddressCommunicationService;
import my.project.service.communication.UpdateEmployeePositionCommunicationService;
import my.project.service.entity.AddressService;
import my.project.service.entity.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.MultipartConfig;
import java.util.List;

@Controller
@RequestMapping("/mvc/employee/")
@MultipartConfig(location = "C:/tmp/")
public class EmployeeController {

    @Autowired
    CreateWebParamToEntityDataBase createWebParamToEntityDataBase;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private UpdateWebParamToEntityDataBase updateWebParamToEntityDataBase;

    @Autowired
    private CreateEntityDataBase createEntityDataBase;

    @Autowired
    private UpdateEntityDataBase updateEntityDataBase;

    @Autowired
    private EmployeeAddressCommunicationService employeeAddressCommunicationService;

    @Autowired
    private CreateEmployeePositionCommunicationService createEmployeePositionCommunicationService;

    @Autowired
    private UpdateEmployeePositionCommunicationService updateEmployeePositionCommunicationService;

    @GetMapping(value = "/list")
    public String methodReturnEmployeeListPage(Model model) {
        List<Employee> employeeList = employeeService.readAllEmployee();
        model.addAttribute("employeesList", employeeList);
        return "/employee/employees/index";
    }

    @GetMapping(value = "/delete")
    public String deleteEmployeeById(@RequestParam(name = "deleteEmployeeIdParam") String deleteEmployeeIdParam) {
        employeeService.deleteEmployeeById(deleteEmployeeIdParam);
        return "redirect:/mvc/employee/list";
    }

    @GetMapping(value = "/registration")
    public String returnRegistrationPageEmployee(Model model) {
        model.addAttribute("createWebParam", createWebParamToEntityDataBase);
        return "employee/registration/index";
    }

    @PostMapping(value = "/registration")
    public String addEmployee(@ModelAttribute("createWebParam") CreateWebParamToEntityDataBase createWebParamToEntityDataBase,
                              Model model) {
        try {
            createEntityDataBase.create(createWebParamToEntityDataBase);
        } catch (AllEntityWebException e) {
            model.addAttribute(createWebParamToEntityDataBase.readCreateEmployee());
            model.addAttribute("createWebParam", this.createWebParamToEntityDataBase);
            model.addAttribute("messageList", e.getErrorList());
            return "employee/registration/index";
        }
        return "redirect:/mvc/employee/list";
    }

    @GetMapping("/edit")
    public String editEmployeePage(@RequestParam(name = "editEmployeeIdParam") String editEmployeeIdParam,
                                   Model model) {
        Employee employee = employeeService.readEmployeeById(editEmployeeIdParam);
        model.addAttribute("employee", employee);
        model.addAttribute("updateWebParam", updateWebParamToEntityDataBase);
        return "/employee/edit/index";
    }

    @PostMapping("/edit")
    public String employeeEdit(@ModelAttribute("updateWebParam") UpdateWebParamToEntityDataBase updateWebParamToEntityDataBase,
                               Model model) {
        try {
            updateEntityDataBase.update(updateWebParamToEntityDataBase);
        } catch (AllEntityWebException e) {
            Employee employee = employeeService.readEmployeeById(updateWebParamToEntityDataBase.getUpdateEmployeeIdParam());
            model.addAttribute("employee", employee);
            model.addAttribute("updateWebParam", this.updateWebParamToEntityDataBase);
            model.addAttribute("messageList", e.getErrorList());
            return "/employee/edit/index";
        }
        return "redirect:/mvc/employee/list";
    }

    @GetMapping("/information")
    public String returnAllEmployeeInformation(@RequestParam(name = "employeeIdParam") String employeeIdParam,
                                               Model model) {
        Employee employee = employeeService.readEmployeeById(employeeIdParam);
        model.addAttribute("employee", employee);
        model.addAttribute("address", employee.getAddress());
        model.addAttribute("developer", employee.getDeveloper());
        model.addAttribute("manager", employee.getManager());
        model.addAttribute("qaEngineer", employee.getQaEngineer());
        return "/employee/information/index";
    }

    @GetMapping("/select")
    public String returnSelectEmployeeList(@RequestParam(name = "selectEmployeeIdParam") String selectEmployeeIdParam,
                                           @RequestParam(name = "selectEmployeeFirstNameParam") String selectEmployeeFirstNameParam,
                                           @RequestParam(name = "selectEmployeeSurnameParam") String selectEmployeeSurnameParam,
                                           @RequestParam(name = "selectEmployeeDateOfBornParam") String selectEmployeeDateOfBornParam,
                                           @RequestParam(name = "selectEmployeePositionParam") String selectEmployeePositionParam,
                                           Model model) {
        List<Employee> employeeList = employeeService.readAllEmployeeByParameter(selectEmployeeIdParam, selectEmployeeFirstNameParam, selectEmployeeSurnameParam, selectEmployeeDateOfBornParam, selectEmployeePositionParam);
        model.addAttribute("employeesList", employeeList);
        model.addAttribute("employeeId", selectEmployeeIdParam);
        model.addAttribute("employeeFirstName", selectEmployeeFirstNameParam);
        model.addAttribute("employeeSurname", selectEmployeeSurnameParam);
        model.addAttribute("employeeDateOfBorn", selectEmployeeDateOfBornParam);
        model.addAttribute("employeePosition", selectEmployeePositionParam);
        return "/employee/employees/index";
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public AddressService getAddressService() {
        return addressService;
    }

    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    public UpdateEntityDataBase getUpdateEntityDataBase() {
        return updateEntityDataBase;
    }

    public void setUpdateEntityDataBase(UpdateEntityDataBase updateEntityDataBase) {
        this.updateEntityDataBase = updateEntityDataBase;
    }

    public EmployeeAddressCommunicationService getEmployeeAddressCommunicationService() {
        return employeeAddressCommunicationService;
    }

    public void setEmployeeAddressCommunicationService(EmployeeAddressCommunicationService employeeAddressCommunicationService) {
        this.employeeAddressCommunicationService = employeeAddressCommunicationService;
    }

    public CreateEmployeePositionCommunicationService getCreateEmployeePositionCommunicationService() {
        return createEmployeePositionCommunicationService;
    }

    public void setCreateEmployeePositionCommunicationService(CreateEmployeePositionCommunicationService createEmployeePositionCommunicationService) {
        this.createEmployeePositionCommunicationService = createEmployeePositionCommunicationService;
    }

    public UpdateEmployeePositionCommunicationService getUpdateEmployeePositionCommunicationService() {
        return updateEmployeePositionCommunicationService;
    }

    public void setUpdateEmployeePositionCommunicationService(UpdateEmployeePositionCommunicationService updateEmployeePositionCommunicationService) {
        this.updateEmployeePositionCommunicationService = updateEmployeePositionCommunicationService;
    }
}
