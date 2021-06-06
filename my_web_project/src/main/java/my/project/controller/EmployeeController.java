package my.project.controller;

import my.project.dto.WebParamToEntityDataBase;
import my.project.entity.Employee;
import my.project.exceptions.EmployeeWebException;
import my.project.service.communication.EmployeeAddressCommunicationService;
import my.project.service.communication.CreateEmployeePositionCommunicationService;
import my.project.service.communication.UpdateEmployeePositionCommunicationService;
import my.project.service.entity.AddressService;
import my.project.service.entity.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/mvc/employee/")
@MultipartConfig(location = "C:/tmp/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    AddressService addressService;

    @Autowired
    EmployeeAddressCommunicationService employeeAddressCommunicationService;

    @Autowired
    CreateEmployeePositionCommunicationService createEmployeePositionCommunicationService;

    @Autowired
    UpdateEmployeePositionCommunicationService updateEmployeePositionCommunicationService;

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
    public String returnRegistrationPageEmployee() {
        return "employee/registration/index";
    }

    @PostMapping(value = "/registration", produces = "text/plain;charset=UTF-8")
    public String addEmployee(@RequestPart(value = "photo", required = false) MultipartFile employeePhotoParam,
                              @RequestParam(name = "employeeFirstName") String employeeFirstNameParam,
                              @RequestParam(name = "employeeSurname") String employeeSurnameParam,
                              @RequestParam(name = "employeeDateOfBornParam") Date employeeDateOfBornParam,
                              @RequestParam(name = "employeePositionParam") String employeePositionParam,
                              @RequestParam(name = "departmentParam") String departmentParam,
                              @RequestParam(name = "experienceParam") String experienceParam,
                              @RequestParam(name = "addressCountryParam") String addressCountryParam,
                              @RequestParam(name = "addressRegionParam") String addressRegionParam,
                              @RequestParam(name = "addressLocalityParam") String addressLocalityParam,
                              @RequestParam(name = "addressCityParam") String addressCityParam,
                              @RequestParam(name = "addressStreetParam") String addressStreetParam,
                              @RequestParam(name = "addressHouseParam") int addressHouseParam,
                              @RequestParam(name = "addressFlatParam") int addressFlatParam,
                              Model model) {
        try {
            BigInteger employeeId = employeeService.createEmployee(employeePhotoParam, employeeFirstNameParam, employeeSurnameParam, employeeDateOfBornParam, employeePositionParam);
            BigInteger addressId = addressService.createAddress(addressCountryParam, addressRegionParam, addressLocalityParam, addressCityParam, addressStreetParam, addressHouseParam, addressFlatParam);
            employeeAddressCommunicationService.createCommunication(employeeId, addressId);
            createEmployeePositionCommunicationService.createEntityCommunication(employeeId, employeePositionParam, departmentParam, experienceParam);
        } catch (EmployeeWebException e) {
            List<String> errorList = e.getErrorList();
            model.addAttribute("employeeFirstName", employeeFirstNameParam);
            model.addAttribute("employeeSurname", employeeSurnameParam);
            model.addAttribute("employeeDateOfBorn", employeeDateOfBornParam);
            model.addAttribute("employeePosition", employeePositionParam);
            model.addAttribute("messageList", errorList);
            model.addAttribute("addressCountry", addressCountryParam);
            model.addAttribute("addressRegion", addressRegionParam);
            model.addAttribute("addressLocality", addressLocalityParam);
            model.addAttribute("addressCity", addressCityParam);
            model.addAttribute("addressStreet", addressStreetParam);
            model.addAttribute("addressHouse", addressHouseParam);
            model.addAttribute("addressFlat", addressFlatParam);
            return "employee/registration/index";
        }
        return "redirect:/mvc/employee/list";
    }

    @GetMapping("/edit")
    public String editEmployeePage(@RequestParam(name = "editEmployeeIdParam") String editEmployeeIdParam,
                                   Model model) {
        Employee employee = employeeService.readEmployeeById(editEmployeeIdParam);
        model.addAttribute("employee", employee);
        model.addAttribute("webParam", new WebParamToEntityDataBase());
        return "/employee/edit/index";
    }

    @PostMapping("/edit")
    public String employeeEdit(@ModelAttribute("webParam") WebParamToEntityDataBase webParamToEntityDataBase,
//                               @RequestParam(name = "updateEmployeeIdParam") String updateEmployeeIdParam,
//                               @RequestParam(name = "updateEmployeeFirstNameParam") String updateEmployeeFirstNameParam,
//                               @RequestParam(name = "updateEmployeeSurnameParam") String updateEmployeeSurnameParam,
//                               @RequestParam(name = "updateEmployeeDateOfBornParam") Date updateEmployeeDateOfBornParam,
//                               @RequestParam(name = "updateEmployeePositionParam") String updateEmployeePositionParam,
//                               @RequestParam(name = "updateDepartmentParam") String updateDepartmentParam,
//                               @RequestParam(name = "updateExperienceParam") String updateExperienceParam,
//                               @RequestParam(name = "updateAddressIdParam") String updateAddressIdParam,
//                               @RequestParam(name = "updateAddressCountryParam") String updateAddressCountryParam,
//                               @RequestParam(name = "updateAddressRegionParam") String updateAddressRegionParam,
//                               @RequestParam(name = "updateAddressLocalityParam") String updateAddressLocalityParam,
//                               @RequestParam(name = "updateAddressCityParam") String updateAddressCityParam,
//                               @RequestParam(name = "updateAddressStreetParam") String updateAddressStreetParam,
//                               @RequestParam(name = "updateAddressHouseParam") int updateAddressHouseParam,
//                               @RequestParam(name = "updateAddressFlatParam") int updateAddressFlatParam,
                               Model model) {
        try {
            System.out.println();
//            employeeService.updateEmployeeById(updateEmployeeIdParam, updateEmployeePhotoParam, updateEmployeeFirstNameParam, updateEmployeeSurnameParam, updateEmployeeDateOfBornParam, updateEmployeePositionParam);
//            addressService.updateAddressById(updateAddressIdParam, updateAddressCountryParam, updateAddressRegionParam, updateAddressLocalityParam, updateAddressCityParam, updateAddressStreetParam, updateAddressHouseParam, updateAddressFlatParam);
//            updateEmployeePositionCommunicationService.updateEntityCommunication(updateEmployeeIdParam, updateEmployeePositionParam, updateDepartmentParam, updateExperienceParam);
        } catch (EmployeeWebException e) {
//            List<String> errorList = e.getErrorList();
//            model.addAttribute("employeeIdParam", updateEmployeeIdParam);
//            model.addAttribute("employeeFirstNameParam", updateEmployeeFirstNameParam);
//            model.addAttribute("employeeSurnameParam", updateEmployeeSurnameParam);
//            model.addAttribute("employeeDateOfBornParam", updateEmployeeDateOfBornParam);
//            model.addAttribute("employeePositionParam", updateEmployeePositionParam);
//            model.addAttribute("messageList", errorList);
            return "employee/edit/index";
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
}
