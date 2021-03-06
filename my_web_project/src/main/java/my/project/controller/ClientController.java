package my.project.controller;

import my.project.entity.Client;
import my.project.service.clients.entity.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.annotation.MultipartConfig;
import java.util.List;

@Controller
@RequestMapping("/mvc/client/")
@MultipartConfig(location = "C:/tmp/")
public class ClientController {

    //    @Autowired
//    EmployeeService employeeService;
//
    @Autowired
    ClientService clientService;

    //
//    @Autowired
//    EmployeeAddressCommunicationService employeeAddressCommunicationService;
//
//    @Autowired
//    CreateEmployeePositionCommunicationService createEmployeePositionCommunicationService;
//
    @GetMapping(value = "/list")
    public String methodReturnEmployeeListPage(Model model) {
        List<Client> clientsList = clientService.readAllClient();
        model.addAttribute("clientsList", clientsList);
        return "/client/clients/index";
    }
//
//    @GetMapping(value = "/delete")
//    public String deleteEmployeeById(@RequestParam(name = "deleteEmployeeIdParam") String deleteEmployeeParam) {
//        employeeService.deleteEmployeeById(deleteEmployeeParam);
//        return "redirect:/mvc/employee/list";
//    }
//
//    @GetMapping(value = "/registration")
//    public String returnRegistrationPageEmployee() {
//        return "employee/registration/index";
//    }
//
//    @PostMapping(value = "/registration")
//    public String addEmployee(@RequestPart(value = "image", required = false) MultipartFile employeePhotoParam,
//                              @RequestParam(name = "employeeFirstNameParam") String employeeFirstNameParam,
//                              @RequestParam(name = "employeeSurnameParam") String employeeSurnameParam,
//                              @RequestParam(name = "employeeDateOfBornParam") Date employeeDateOfBornParam,
//                              @RequestParam(name = "employeePositionParam") String employeePositionParam,
//                              @RequestParam(name = "departmentParam") String departmentParam,
//                              @RequestParam(name = "experienceParam") int experienceParam,
//                              @RequestParam(name = "addressCountryParam") String addressCountryParam,
//                              @RequestParam(name = "addressRegionParam") String addressRegionParam,
//                              @RequestParam(name = "addressLocalityParam") String addressLocalityParam,
//                              @RequestParam(name = "addressCityParam") String addressCityParam,
//                              @RequestParam(name = "addressStreetParam") String addressStreetParam,
//                              @RequestParam(name = "addressHouseParam") int addressHouseParam,
//                              @RequestParam(name = "addressFlatParam") int addressFlatParam,
//                              Model model) {
//        try {
//            BigInteger employeeId = employeeService.createEmployee(employeePhotoParam, employeeFirstNameParam, employeeSurnameParam, employeeDateOfBornParam, employeePositionParam);
//            BigInteger addressId = addressService.createAddress(addressCountryParam, addressRegionParam, addressLocalityParam, addressCityParam, addressStreetParam, addressHouseParam, addressFlatParam);
//            employeeAddressCommunicationService.createCommunication(employeeId, addressId);
//            createEmployeePositionCommunicationService.createEntityCommunication(employeeId, employeePositionParam, departmentParam, experienceParam);
//        } catch (EmployeeWebException e) {
//            List<String> errorList = e.getErrorList();
//            model.addAttribute("employeeFirstName", employeeFirstNameParam);
//            model.addAttribute("employeeSurname", employeeSurnameParam);
//            model.addAttribute("employeeDateOfBorn", employeeDateOfBornParam);
//            model.addAttribute("employeePosition", employeePositionParam);
//            model.addAttribute("messageList", errorList);
//            model.addAttribute("addressCountry", addressCountryParam);
//            model.addAttribute("addressRegion", addressRegionParam);
//            model.addAttribute("addressLocality", addressLocalityParam);
//            model.addAttribute("addressCity", addressCityParam);
//            model.addAttribute("addressStreet", addressStreetParam);
//            model.addAttribute("addressHouse", addressHouseParam);
//            model.addAttribute("addressFlat", addressFlatParam);
//            return "employee/registration/index";
//        }
//        return "redirect:/mvc/employee/list";
//    }
//
//    @GetMapping("/edit")
//    public String editEmployeePage(@RequestParam(name = "editEmployeeIdParam") String editEmployeeIdParam,
//                                   Model model) {
//        Employee employee = employeeService.readEmployeeById(editEmployeeIdParam);
//        model.addAttribute("employee", employee);
//        return "/employee/edit/index";
//    }
//
//    @PostMapping("/edit")
//    public String employeeEdit(@RequestPart(value = "image", required = false) MultipartFile updateEditEmployeePhotoParam,
//                               @RequestParam(name = "updateEmployeeIdParam") String updateEmployeeIdParam,
//                               @RequestParam(name = "updateEmployeeFirstNameParam") String updateEmployeeFirstNameParam,
//                               @RequestParam(name = "updateEmployeeSurnameParam") String updateEmployeeSurnameParam,
//                               @RequestParam(name = "updateEmployeeDateOfBornParam") Date updateEmployeeDateOfBornParam,
//                               @RequestParam(name = "updateEmployeePositionParam") String updateEmployeePositionParam,
//                               Model model) {
//        try {
//            employeeService.updateEmployeeById(updateEmployeeIdParam, updateEditEmployeePhotoParam, updateEmployeeFirstNameParam, updateEmployeeSurnameParam, updateEmployeeDateOfBornParam, updateEmployeePositionParam);
//        } catch (EmployeeWebException e) {
//            List<String> errorList = e.getErrorList();
//            model.addAttribute("employeeIdParam", updateEmployeeIdParam);
//            model.addAttribute("employeeFirstNameParam", updateEmployeeFirstNameParam);
//            model.addAttribute("employeeSurnameParam", updateEmployeeSurnameParam);
//            model.addAttribute("employeeDateOfBornParam", updateEmployeeDateOfBornParam);
//            model.addAttribute("employeePositionParam", updateEmployeePositionParam);
//            model.addAttribute("messageList", errorList);
//            return "employee/edit/index";
//        }
//        return "redirect:/mvc/employee/list";
//    }
//
//    @GetMapping("/information")
//    public String returnAllEmployeeInformation(@RequestParam(name = "employeeIdParam") String employeeIdParam,
//                                               Model model) {
//        Employee employee = employeeService.readEmployeeById(employeeIdParam);
//        model.addAttribute("employee", employee);
//        model.addAttribute("address", employee.getAddress());
//        model.addAttribute("developer", employee.getDeveloper());
//        model.addAttribute("manager", employee.getManager());
//        model.addAttribute("qaEngineer", employee.getQaEngineer());
//        return "/employee/information/index";
//    }
//
//    @GetMapping("/select")
//    public String returnSelectEmployeeList(@RequestParam(name = "selectEmployeeIdParam") String selectEmployeeIdParam,
//                                           @RequestParam(name = "selectEmployeeFirstNameParam") String selectEmployeeFirstNameParam,
//                                           @RequestParam(name = "selectEmployeeSurnameParam") String selectEmployeeSurnameParam,
//                                           @RequestParam(name = "selectEmployeeDateOfBornParam") String selectEmployeeDateOfBornParam,
//                                           @RequestParam(name = "selectEmployeePositionParam") String selectEmployeePositionParam,
//                                           Model model) {
//        List<Employee> employeeList = employeeService.readAllEmployeeByParameter(selectEmployeeIdParam, selectEmployeeFirstNameParam, selectEmployeeSurnameParam, selectEmployeeDateOfBornParam, selectEmployeePositionParam);
//        model.addAttribute("employeesList", employeeList);
//        model.addAttribute("employeeId", selectEmployeeIdParam);
//        model.addAttribute("employeeFirstName", selectEmployeeFirstNameParam);
//        model.addAttribute("employeeSurname", selectEmployeeSurnameParam);
//        model.addAttribute("employeeDateOfBorn", selectEmployeeDateOfBornParam);
//        model.addAttribute("employeePosition", selectEmployeePositionParam);
//        return "/employee/employees/index";
//    }
}
